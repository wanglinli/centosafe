package com.wy.centosafe.controller;

import com.wy.centosafe.service.CommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * author wy
 * date 17-12-21
 * time 上午10:38
 */
@RestController
public class LoginController {

    @Autowired
    private CommonService loginService;


}
