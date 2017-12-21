package com.wy.centosafe.controller;

import com.wy.centosafe.domain.Member;
import com.wy.centosafe.domain.Result;
import com.wy.centosafe.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * author wy
 * date 17-12-21
 * time 上午10:38
 */
@RestController
public class LoginController {

    @Autowired
    private LoginService loginService;

    @RequestMapping("/dologin")
    public Result dologin(Member member){
        return loginService.dologin(member.getName(),member.getPassword());
    }

    @RequestMapping("/logout")
    public Result logout(){
        return loginService.logout();
    }
}
