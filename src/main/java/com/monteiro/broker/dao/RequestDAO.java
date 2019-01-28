package com.monteiro.broker.dao;

import com.monteiro.broker.model.Request;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author vicente.monteiro
 */
public interface RequestDAO extends CrudRepository<Request, Long> {
}
