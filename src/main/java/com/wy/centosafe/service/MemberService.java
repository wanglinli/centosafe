package com.wy.centosafe.service;

import com.wy.centosafe.domain.Result;
import com.wy.centosafe.domain.repository.InfoRepository;
import com.wy.centosafe.domain.repository.MemberRepository;
import com.wy.centosafe.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * author wy
 * date 17-12-22
 * time 下午6:11
 */
@Service
public class MemberService {

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private InfoRepository infoRepository;

    @Autowired
    private HttpServletRequest httpServletRequest;


    //用户列表
    public Result memberInfo(){
        return ResultUtil.success(memberRepository.findAll(new Sort(Sort.Direction.ASC, "id")));
    }
}
