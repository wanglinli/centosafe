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

    @RequestMapping("/updateLog")
    public Result updateLog(){
        return logService.updateLog();
    }

    @RequestMapping("/updateSshLog")
    public Result updateSshLog(){
        return logService.updateSshLog();
    }

    @RequestMapping("/getLogInfo")
    public Result getLogInfo(){
        return logService.getLogInfo();
    }

    @RequestMapping("/getSshLogInfo")
    public Result getSshLogInfo(){
        return logService.getSshLogInfo();
    }
}
