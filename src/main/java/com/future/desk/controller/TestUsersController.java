package com.future.desk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author: stone
 * @create: 2019-07-03 18:15
 **/
@Controller
public class TestUsersController {

    @RequestMapping("/testReg")
    public String testReg(){
        return "testRegister";
    }

    @RequestMapping("/testLog")
    public String testLog(){
        return "testLogin";
    }

}

    
