package com.monteiro.broker.simulator;

import com.monteiro.broker.dao.AccountDAO;
import com.monteiro.broker.dao.CompanyDAO;
import com.monteiro.broker.dao.RequestDAO;
import com.monteiro.broker.model.Account;
import com.monteiro.broker.model.Company;
import com.monteiro.broker.model.Request;
import java.math.BigDecimal;
import java.util.Random;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author vicente.monteiro
 */
@Component
public class MockData {

    private static final Integer BASE_LOAD = 10_000;
    private static final String BASE_EMAIL = "vicente.baliu@gmail.com";

    private final Random rand = new Random();

    @Autowired
    PriceService priceStore;

    @Autowired
    CompanyDAO companyD;

    @Autowired
    AccountDAO accountD;

    @Autowired
    RequestDAO requestD;

    @PostConstruct
    private void init() {
        this.companyD.save(new Company("CCRO3")).getId();
        this.companyD.save(new Company("PETR4")).getId();
        this.companyD.save(new Company("CIEL3")).getId();
        this.companyD.save(new Company("KROT3")).getId();
    }

    public void mock() {
        this.accountD.save(new Account(new BigDecimal(this.rand.nextInt(BASE_LOAD) + 1), BASE_EMAIL));
        this.requestD.save(new Request(new Company(1L), new BigDecimal("12.00"), new BigDecimal("11.00"), new Account(1L)));
        this.requestD.save(new Request(new Company(2L), new BigDecimal("13.00"), new BigDecimal("12.00"), new Account(1L)));
        this.requestD.save(new Request(new Company(3L), new BigDecimal("14.00"), new BigDecimal("13.00"), new Account(1L)));
        this.requestD.save(new Request(new Company(4L), new BigDecimal("15.00"), new BigDecimal("14.00"), new Account(1L)));
    }
}
