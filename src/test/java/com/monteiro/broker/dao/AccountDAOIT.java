package com.monteiro.broker.dao;

import com.monteiro.broker.model.Account;
import static java.math.BigDecimal.ONE;
import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 *
 * @author vicente.monteiro
 */
@RunWith(SpringJUnit4ClassRunner.class)
@DataJpaTest
public class AccountDAOIT {

    @Autowired
    private AccountDAO accountD;

    @Test
    @Before
    public void testInsert() {
        assertNotNull(accountD.save(new Account(ONE, randomAlphabetic(5))));
    }

}
