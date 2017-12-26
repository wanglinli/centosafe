package com.wy.centosafe.controller;

import com.wy.centosafe.domain.Result;
import com.wy.centosafe.service.SysService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * author wy
 * date 17-12-20
 * time 下午9:05
 */

@RestController
public class SysController {

    @Autowired
    private SysService sysService;


    /**
     * 得到Linux系统用户登陆日志内容
     */

    @GetMapping(value = "/getLoggedInfo")
    public Result getLoggedInfo(){
        return sysService.getLoggedInfo();
    }

    /**
     * 得到ssh连接日志内容
     */

    @GetMapping(value = "/getSshConnectInfo")
    public Result getSshConnectInfo(){
        return sysService.getSshConnectInfo();
    }

    /**
     * 得到top文件内容
     * @return
     */
    @GetMapping(value = "/getTopInfo")
    public Result getTopInfo(){
        return sysService.getTopInfo();
    }

    /**
     * 得到发行版本
     * @return
     */
    @GetMapping(value = "/getVersionInfo")
    public Result getVersionInfo(){
        return sysService.getVersionInfo();
    }

    /**
     * 得到磁盘状态
     * @return
     */
    @GetMapping(value = "/getDfInfo")
    public Result getDfInfo(){
        return sysService.getDfInfo();
    }

    /**
     * 得到进程文件os信息
     * @return
     */
    @GetMapping(value = "/getPsInfo")
    public Result getPsInfo(){
        return sysService.getPsInfo();
    }

}
