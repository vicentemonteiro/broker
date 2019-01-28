package com.monteiro.broker.business;

import com.monteiro.broker.dao.PropertyDAO;
import com.monteiro.broker.model.Property;
import com.monteiro.broker.model.Request;
import java.math.BigDecimal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author vicente.monteiro
 */
@Service
public class PropertyService {

    @Autowired
    PropertyDAO propD;

    public Property buy(final Request request, final BigDecimal amountCompany) {
        Property prop = this.get(request);
        if (prop != null) {
            prop.setAmountCompany(prop.getAmountCompany().add(amountCompany));
        } else {
            prop = new Property(amountCompany, request.getAccount(), request.getCompany());
        }
        return this.propD.save(prop);
    }

    public Property get(final Request request) {
        return this.propD.findByAccountAndCompany(request.getAccount(), request.getCompany());
    }

    public void sell(final Property prop) {
        this.propD.delete(prop);
    }

}
