package com.dky.modules.sys.controller;

/**
 * describe:
 *
 * @author bowen
 * @date 2019/03/28
 */


import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;


@Api(description = "用户接口")
@RestController
public class HelloWorldController {
    @RequestMapping("/info")

    public String info() {

        return "Hello world!";

    }
}
