package com.wy.centosafe.controller;

import com.wy.centosafe.domain.Result;
import com.wy.centosafe.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * author wy
 * date 17-12-23
 * time 上午10:55
 */

@RestController
public class MemberController {
    @Autowired
    private MemberService memberService;

    /**
     * 全部用户信息
     * @return
     */
    @GetMapping(value = "/getMemberInfo")
    public Result getMemberInfo(){
        return memberService.memberInfo();
    }


}
