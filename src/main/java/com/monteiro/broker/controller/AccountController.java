package com.monteiro.broker.controller;

import com.monteiro.broker.dao.AccountDAO;
import com.monteiro.broker.model.Account;
import static java.lang.Long.parseLong;
import java.util.Collection;
import java.util.logging.Logger;
import org.apache.commons.collections4.IteratorUtils;
import static org.apache.commons.collections4.IteratorUtils.toList;
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
        return this.accountD.findById(parseLong(id)).get();
    }

    @RequestMapping("/account/viewall")
    public Collection<Account> viewAll() {
        return toList(this.accountD.findAll().iterator());
    }
    private static final Logger LOG = Logger.getLogger(AccountController.class.getName());

}
