package com.monteiro.broker.model;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

/**
 *
 * @author vicente.monteiro
 */
@Entity
public class Account implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @Column(nullable = false)
    private BigDecimal avaiableMoney;

    public Account() {
    }

    public Account(final Long id) {
        this.id = id;
    }

    public Account(final BigDecimal avaiableMoney, final String email) {
        this.avaiableMoney = avaiableMoney;
        this.email = email;
    }

    public BigDecimal getAvaiableMoney() {
        return avaiableMoney;
    }

    public void setAvaiableMoney(BigDecimal avaiableMoney) {
        this.avaiableMoney = avaiableMoney;
    }

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(final String email) {
        this.email = email;
    }

    private String email;

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Account)) {
            return false;
        }
        Account other = (Account) object;
        return !((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)));
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }

}
