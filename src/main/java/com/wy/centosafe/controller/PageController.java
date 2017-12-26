package com.wy.centosafe.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * author wy
 * date 17-12-21
 * time 上午8:30
 */
@Controller
public class PageController {

    @GetMapping("/home")
    public String home(){
        return "home";
    }


}
