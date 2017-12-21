package com.wy.centosafe.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * author wy
 * date 17-12-21
 * time 上午8:30
 */
@Controller
public class PageController {


    @RequestMapping("/admin")
    public String admin(){
        return "admin";
    }

    @RequestMapping("/ssh")
    public String ssh(){
        return "ssh";
    }



}
