package com.wy.centosafe.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * author wy
 * date 17-12-21
 * time 下午1:52
 */
@Controller
public class IndexController {

    @RequestMapping("/forbidden")
    public String forbidden(){
        return "forbidden";
    }

    @RequestMapping({"/login","/"})
    public String login(){
        return "login";
    }

}
