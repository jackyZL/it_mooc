package com.czy.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by jacky on 2017/7/17.
 */

@RestController
public class HelloController {

    @RequestMapping(value = "/hello", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public String hello() {

        return "{'hello':'hello'}";

    }
}
