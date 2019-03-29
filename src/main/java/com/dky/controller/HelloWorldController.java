package com.dky.controller;

/**
 * describe:
 *
 * @author bowen
 * @date 2019/03/28
 */


import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;



@RestController
public class HelloWorldController {
    @RequestMapping("/info")

    public String info() {

        return "Hello world!";

    }
}
