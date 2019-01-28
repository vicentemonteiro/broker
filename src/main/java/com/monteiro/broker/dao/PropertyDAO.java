package com.monteiro.broker.dao;

import com.monteiro.broker.model.Account;
import com.monteiro.broker.model.Company;
import com.monteiro.broker.model.Property;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author vicente.monteiro
 */
public interface PropertyDAO extends CrudRepository<Property, Long> {

    Property findByAccountAndCompany(Account account, Company company);
}
