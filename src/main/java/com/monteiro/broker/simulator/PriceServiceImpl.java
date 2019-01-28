package com.monteiro.broker.simulator;

import com.monteiro.broker.dao.CompanyDAO;
import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import java.math.BigDecimal;
import static java.math.BigDecimal.ZERO;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import org.slf4j.Logger;
import static org.slf4j.LoggerFactory.getLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 *
 * @author vicente.monteiro
 */
@Service
public class PriceServiceImpl implements PriceService {

    private final Logger logger = getLogger(PriceServiceImpl.class);

    @Autowired
    CompanyDAO companyD;

    private static final Integer BASE_PRICE = 10;

    private final Random rand = new Random();
    private final Map<Long, BigDecimal> priceMap = new HashMap<Long, BigDecimal>();

    private Boolean init = FALSE;

    @Override
    public BigDecimal getPrice(final Long companyId) {
        return priceMap.get(companyId);
    }

    private void updateCompany() {
        if (!init) {
            this.companyD.findAll().forEach((company) -> {
                PriceServiceImpl.this.priceMap.put(company.getId(), ZERO);
            });
            init = TRUE;
        }
    }

    @Scheduled(fixedDelay = 5_000)
    private void updatePrices() {
        this.updateCompany();
        this.priceMap.keySet().forEach((key) -> {
            this.priceMap.replace(key, new BigDecimal(BASE_PRICE + rand.nextInt(BASE_PRICE)));
        });
        this.logger.info("Price Update");
    }

}
