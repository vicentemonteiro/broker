package com.monteiro.broker.dao;

import com.monteiro.broker.model.Entry;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author vicente.monteiro
 */
public interface EntryDAO extends CrudRepository<Entry, Long> {
}
