package com.monteiro.broker.model;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

/**
 *
 * @author vicente.monteiro
 */
@Entity
public class Property implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @Column(nullable = false)
    private BigDecimal amountCompany;

    @ManyToOne
    private Account account;

    @ManyToOne
    private Company company;

    public Property() {
    }

    public Property(final Long id) {
        this.id = id;
    }

    public Property(BigDecimal amountCompany, Account account, Company company) {
        this.amountCompany = amountCompany;
        this.account = account;
        this.company = company;
    }

    public BigDecimal getAmountCompany() {
        return amountCompany;
    }

    public void setAmountCompany(final BigDecimal amountCompany) {
        this.amountCompany = amountCompany;
    }

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(final Object object) {
        if (!(object instanceof Property)) {
            return false;
        }
        Property other = (Property) object;
        return !((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)));
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }

}
