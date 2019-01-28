package com.monteiro.broker.simulator;

import com.monteiro.broker.dao.CompanyDAO;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 *
 * @author vicente.monteiro
 */
@Service
public class PriceServiceImpl implements PriceService {

    private final Logger logger = LoggerFactory.getLogger(PriceServiceImpl.class);

    @Autowired
    CompanyDAO companyD;

    private static final Integer BASE_PRICE = 10;

    private final Random rand = new Random();
    private final Map<Long, BigDecimal> priceMap = new HashMap<Long, BigDecimal>();

    private Boolean init = Boolean.FALSE;

    @Override
    public BigDecimal getPrice(final Long companyId) {
        return priceMap.get(companyId);
    }

    private void updateCompany() {
        if (!init) {
            this.companyD.findAll().forEach((company) -> {
                PriceServiceImpl.this.priceMap.put(company.getId(), BigDecimal.ZERO);
            });
            init = Boolean.TRUE;
        }
    }

    @Scheduled(fixedDelay = 5000)
    private void updatePrices() {
        this.updateCompany();
        this.priceMap.keySet().forEach((key) -> {
            this.priceMap.replace(key, new BigDecimal(BASE_PRICE + rand.nextInt(BASE_PRICE)));
        });
        this.logger.info("Price Update");
    }

}
