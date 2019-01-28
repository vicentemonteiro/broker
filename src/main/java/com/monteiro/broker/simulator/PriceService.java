package com.monteiro.broker.simulator;

import java.math.BigDecimal;

/**
 *
 * @author vicente.monteiro
 */
public interface PriceService {

    BigDecimal getPrice(final Long companyId);

}
