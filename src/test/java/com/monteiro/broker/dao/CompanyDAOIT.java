/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.monteiro.broker.dao;

import com.monteiro.broker.model.Company;
import static java.util.Optional.empty;
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
public class CompanyDAOIT {

    @Autowired
    private CompanyDAO companyD;

    @Test
    @Before
    public void testInsert() {
        assertNotNull(companyD.save(new Company(randomAlphabetic(5))));
    }

    @Test
    public void testDelete() {
        this.companyD.deleteById(1L);
        assertTrue(empty().equals(this.companyD.findById(1L)));
    }

}
