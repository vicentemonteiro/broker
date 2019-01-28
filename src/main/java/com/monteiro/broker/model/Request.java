package com.monteiro.broker.model;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

/**
 *
 * @author vicente.monteiro
 */
@Entity
public class Request implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    private Account account;

    @ManyToOne(optional = false)
    private Company company;

    @Column(nullable = false)
    private BigDecimal sellPrice;

    @Column(nullable = false)
    private BigDecimal buyPrice;

    public Request(Long id) {
        this.id = id;
    }

    public Request() {
    }

    public Request(final Long id, final Company company, final BigDecimal sellPrice, final BigDecimal buyPrice) {
        this.id = id;
        this.company = company;
        this.sellPrice = sellPrice;
        this.buyPrice = buyPrice;
    }

    public Request(final Company company, final BigDecimal sellPrice, final BigDecimal buyPrice, final Account account) {
        this.account = account;
        this.company = company;
        this.sellPrice = sellPrice;
        this.buyPrice = buyPrice;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(final Account account) {
        this.account = account;
    }

    public BigDecimal getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(final BigDecimal sellPrice) {
        this.sellPrice = sellPrice;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(final Company company) {
        this.company = company;
    }

    public BigDecimal getBuyPrice() {
        return buyPrice;
    }

    public void setBuyPrice(final BigDecimal buyPrice) {
        this.buyPrice = buyPrice;
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
        if (!(object instanceof Request)) {
            return false;
        }
        final Request other = (Request) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }

}
