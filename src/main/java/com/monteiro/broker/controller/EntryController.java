package com.monteiro.broker.controller;

import com.monteiro.broker.dao.EntryDAO;
import com.monteiro.broker.model.Entry;
import java.util.Collection;
import java.util.logging.Logger;
import org.apache.commons.collections4.IteratorUtils;
import static org.apache.commons.collections4.IteratorUtils.toList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author vicente.monteiro
 */
@RestController
public class EntryController {

    @Autowired
    private EntryDAO entryD;

    @RequestMapping("/entry/viewall")
    public Collection<Entry> viewAll() {
        return toList(this.entryD.findAll().iterator());
    }
    private static final Logger LOG = Logger.getLogger(EntryController.class.getName());
}
