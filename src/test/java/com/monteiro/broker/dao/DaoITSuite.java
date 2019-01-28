package com.monteiro.broker.dao;

import java.util.logging.Logger;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author vicente.monteiro
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
    com.monteiro.broker.dao.AccountDAOIT.class,
    com.monteiro.broker.dao.CompanyDAOIT.class
})
public class DaoITSuite {

    private static final Logger LOG = Logger.getLogger(DaoITSuite.class.getName());
}
