package com.monteiro.broker.business;

import com.monteiro.broker.dao.AccountDAO;
import com.monteiro.broker.dao.EntryDAO;
import com.monteiro.broker.dao.RequestDAO;
import com.monteiro.broker.model.Account;
import com.monteiro.broker.model.Entry;
import com.monteiro.broker.model.Property;
import com.monteiro.broker.model.Request;
import com.monteiro.broker.simulator.PriceService;
import com.monteiro.broker.util.TextWriter;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Date;
import javax.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class AutoBrokerService {

    private final Logger logger = LoggerFactory.getLogger(AutoBrokerService.class);

    @Autowired
    MailSender mailSender;

    @Autowired
    EntryDAO entryD;

    @Autowired
    PropertyService propService;

    @Autowired
    PriceService priceService;

    @Autowired
    AccountDAO accountD;

    @Autowired
    RequestDAO requestD;

    @Autowired
    TextWriter textW;

    @Autowired
    private ConfigurableApplicationContext appContext;

    private Integer it = 0;

    private void iterationCount() {
        //shutdown spring app
        if (it++ > 99) {

            this.textW.generateReport(this.getEntryReport());
            this.logger.info("Shutdown");

            try {
                this.appContext.close();
            }
            catch (final Exception e) {
                this.logger.error(e.getMessage());
            }
        }
    }

    //prepare and join the all entry
    private String getEntryReport() {
        final StringBuffer str = new StringBuffer();
        final String linesep = System.getProperty("line.separator");
        this.entryD.findAll().forEach((entry) -> {
            str.append(entry + linesep);
        });
        this.accountD.findAll().forEach((account) -> {
            str.append(account + linesep);
        });
        return str.toString();
    }

    @Scheduled(fixedDelay = 5000, initialDelay = 5000)
    private void proceedRequests() {
        proceedRequest();
    }

    private void proceedRequest() {
        this.requestD.findAll().forEach((request) -> {
            final BigDecimal currentPrice = this.priceService.getPrice(request.getCompany().getId());

            if (currentPrice.compareTo(request.getBuyPrice()) != 1) {
                buy(request, currentPrice);
            } else if (currentPrice.compareTo(request.getSellPrice()) != -1) {
                sell(request, currentPrice);
            }
        });
    }

    @Transactional
    private void buy(final Request request, final BigDecimal price) {
        final BigDecimal money = request.getAccount().getAvaiableMoney();
        final BigDecimal amountCompany = money.divide(price, RoundingMode.HALF_UP);

        if (amountCompany.compareTo(BigDecimal.ZERO) > 0) {

            //update the account money
            final Account account = request.getAccount();
            account.setAvaiableMoney(BigDecimal.ZERO);
            this.accountD.save(account);

            //registry aquisition
            final Entry entry = new Entry(new Date(), request, money, amountCompany, price, Boolean.TRUE);
            this.entryD.save(entry);

            //update the property
            this.propService.buy(request, amountCompany);

            this.done("Buy " + request.getCompany().getName(), entry);
        }

    }

    @Transactional
    private void sell(final Request request, final BigDecimal price) {
        final Property prop = this.propService.get(request);

        if (prop != null) {
            final BigDecimal value = prop.getAmountCompany().multiply(price);

            //update the account money
            final Account account = request.getAccount();
            account.setAvaiableMoney(account.getAvaiableMoney().add(value));
            this.accountD.save(account);

            //registry sell
            final Entry entry = new Entry(new Date(), request, value, prop.getAmountCompany(), price, Boolean.FALSE);
            this.entryD.save(entry);

            //update the property
            this.propService.sell(prop);

            this.done("Sell " + request.getCompany().getName(), entry);
        }
    }

    private void done(final String msg, final Entry entry) {
        this.logger.info(msg);
        this.iterationCount();
        this.sendMail(entry.getOrder().getAccount().getEmail(), msg, entry.toString());
    }

    private void sendMail(final String email, final String subject, final String body) {
        final SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(email);
        message.setSubject(subject);
        message.setText(body);
        this.mailSender.send(message);
    }

}
