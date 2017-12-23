package com.wy.centosafe.controller;

import com.wy.centosafe.domain.Result;
import com.wy.centosafe.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * author wy
 * date 17-12-20
 * time 下午9:05
 */

@RestController
public class LogController {

    @Autowired
    private LogService logService;

    //更新centos系统用户登陆日志
    @RequestMapping("/updateLoggedLog")
    public Result updateLoggedLog(){
        return logService.updateLoggedLog();
    }

    //更新centos系统ssh连接日志
    @RequestMapping("/updateSshConnecLog")
    public Result updateSshConnecLog(){
        return logService.updateSshConnecLog();
    }

    //得到centos系统用户登陆日志内容
    @RequestMapping("/getLoggedLogInfo")
    public Result getLoggedLogInfo() throws Exception{
        return logService.getLoggedLogInfo();
    }

    //得到centos系统ssh连接日志内容
    @RequestMapping("/getSshConnecLogInfo")
    public Result getSshConnecLogInfo() throws Exception{
        return logService.getSshConnecLogInfo();
    }
}
