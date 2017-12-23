package com.wy.centosafe.service;

import com.wy.centosafe.domain.Member;
import com.wy.centosafe.domain.Result;
import com.wy.centosafe.domain.repository.InfoRepository;
import com.wy.centosafe.enums.ResultEnum;
import com.wy.centosafe.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


/**
 * author wy
 * date 17-12-21
 * time 上午10:36
 */
@Service
public class CommonService {
    @Autowired
    private InfoRepository infoRepository;

    //首页博客链接
    public Result getInfo(){
        return ResultUtil.success(infoRepository.getByTitle("blog").getLink());
    }

    //首页Github链接
    public Result getGithub(){
        return ResultUtil.success(infoRepository.getByTitle("github").getLink());
    }



}
