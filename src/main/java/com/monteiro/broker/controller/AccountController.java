package com.monteiro.broker.controller;

import com.monteiro.broker.dao.AccountDAO;
import com.monteiro.broker.model.Account;
import java.util.Collection;
import org.apache.commons.collections4.IteratorUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author vicente.monteiro
 */
@RestController
public class AccountController {

    @Autowired
    AccountDAO accountD;

    @RequestMapping("/account/save")
    public Account save(@RequestBody final Account account) {
        return this.accountD.save(account);
    }

    @RequestMapping("/account/view")
    public Account view(@RequestParam final String id) {
        return this.accountD.findById(Long.parseLong(id)).get();
    }

    @RequestMapping("/account/viewall")
    public Collection<Account> viewAll() {
        return IteratorUtils.toList(this.accountD.findAll().iterator());
    }

}
