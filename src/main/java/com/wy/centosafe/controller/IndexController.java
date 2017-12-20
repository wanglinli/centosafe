package com.wy.centosafe.controller;

import com.wy.centosafe.domain.Result;
import com.wy.centosafe.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * author wy
 * date 17-12-20
 * time 下午9:05
 */

@RestController
public class IndexController {

    @Autowired
    private IndexService indexService;

    @RequestMapping("/updateLogin")
    public Result updateLogin(){
        return indexService.updateLogin();
    }

    @RequestMapping("/updateSshLogin")
    public Result updateSshLogin(){
        return indexService.updateSshLogin();
    }

    @RequestMapping("/getLoginInfo")
    public Result getLoginInfo(){
        return indexService.getLoginInfo();
    }

    @RequestMapping("/getSshLoginInfo")
    public Result getSshLoginInfo(){
        return indexService.getSshLoginInfo();
    }
}
