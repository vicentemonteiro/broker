package com.monteiro.broker.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

/**
 *
 * @author vicente.monteiro
 */
@Entity
public class Entry implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date insertDate;

    @ManyToOne(optional = false)
    private Request request;

    @Column(nullable = false)
    private BigDecimal amountMoney;

    @Column(nullable = false)
    private BigDecimal amountCompany;

    @Column(nullable = false)
    private BigDecimal price;

    @Column(nullable = false)
    private Boolean buy;

    public Entry() {
    }

    public Entry(final Date insertDate, final Request request, final BigDecimal amountMoney, final BigDecimal amountCompany, final BigDecimal price, final Boolean buy) {
        this.insertDate = insertDate;
        this.request = request;
        this.amountMoney = amountMoney;
        this.amountCompany = amountCompany;
        this.price = price;
        this.buy = buy;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Request getOrder() {
        return request;
    }

    public void setOrder(final Request request) {
        this.request = request;
    }

    public Date getInsertDate() {
        return insertDate;
    }

    public void setInsertDate(final Date insertDate) {
        this.insertDate = insertDate;
    }

    public BigDecimal getAmountCompany() {
        return amountCompany;
    }

    public void setAmountCompany(final BigDecimal amountCompany) {
        this.amountCompany = amountCompany;
    }

    public BigDecimal getAmountMoney() {
        return amountMoney;
    }

    public void setAmountMoney(final BigDecimal amountMoney) {
        this.amountMoney = amountMoney;
    }

    public Boolean getBuy() {
        return buy;
    }

    public void setBuy(final Boolean buy) {
        this.buy = buy;
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
        if (!(object instanceof Entry)) {
            return false;
        }
        final Entry other = (Entry) object;
        return !((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)));
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }

}
