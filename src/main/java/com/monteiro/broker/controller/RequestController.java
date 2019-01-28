package com.monteiro.broker.controller;

import com.monteiro.broker.dao.RequestDAO;
import com.monteiro.broker.model.Request;
import com.monteiro.broker.simulator.MockData;
import static java.lang.Long.parseLong;
import static java.lang.Long.parseLong;
import java.util.List;
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
public class RequestController {

    @Autowired
    RequestDAO requestD;

    @Autowired
    MockData mockD;

    @RequestMapping("/request/save")
    public Request save(@RequestBody final Request request) {
        return this.requestD.save(request);
    }

    @RequestMapping("/request/view")
    public Request view(@RequestParam final String id) {
        return this.requestD.findById(parseLong(id)).get();
    }

    @RequestMapping("/request/delete")
    public void delete(@RequestParam final String id) {
        this.requestD.deleteById(parseLong(id));
    }

    @RequestMapping("/request/viewall")
    public List<Request> viewAll() {
        return toList(this.requestD.findAll().iterator());
    }

    @RequestMapping("/request/mock")
    public void mock() {
        this.mockD.mock();
    }
    private static final Logger LOG = Logger.getLogger(RequestController.class.getName());
}
