package com.wy.centosafe.controller;

import com.wy.centosafe.domain.Member;
import com.wy.centosafe.domain.Result;
import com.wy.centosafe.service.CommonService;
import com.wy.centosafe.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * author wy
 * date 17-12-22
 * time 下午5:24
 * 公共rest风格的控制器
 */

@RestController
public class CommonController {

    @Autowired
    private MemberService memberService;

    @Autowired
    private CommonService commonService;

    //登陆
    @RequestMapping("/dologin")
    public Result dologin(Member member) throws Exception{
        return memberService.dologin(member.getName(),member.getPassword());
    }

    //注销
    @RequestMapping("/logout")
    public Result logout(){
        return memberService.logout();
    }

    //博客链接
    @GetMapping("/blog")
    public Result blog(){
        return commonService.getInfo();
    }

    //Github链接
    @GetMapping("/github")
    public Result github(){
        return commonService.getGithub();
    }

}
