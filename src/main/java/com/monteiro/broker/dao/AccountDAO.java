package com.monteiro.broker.dao;

import com.monteiro.broker.model.Account;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author vicente.monteiro
 */
public interface AccountDAO extends CrudRepository<Account, Long> {
}
