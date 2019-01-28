package com.monteiro.broker.dao;

import com.monteiro.broker.model.Company;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author vicente.monteiro
 */
public interface CompanyDAO extends CrudRepository<Company, Long> {
}
