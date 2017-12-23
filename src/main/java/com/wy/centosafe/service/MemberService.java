package com.wy.centosafe.service;

import com.wy.centosafe.domain.Result;
import com.wy.centosafe.domain.repository.InfoRepository;
import com.wy.centosafe.domain.repository.MemberRepository;
import com.wy.centosafe.enums.ResultEnum;
import com.wy.centosafe.exceptions.MemberException;
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
    private HttpServletRequest httpServletRequest;

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private InfoRepository infoRepository;

    //登陆
    public Result dologin(String name, String password){
        try {
            if (password.equals(memberRepository.findByName(name).getPassword())) {
                HttpSession session = httpServletRequest.getSession();
                session.setAttribute("id", memberRepository.findByName(name).getId());
                session.setAttribute("name", memberRepository.findByName(name).getName());
                return ResultUtil.success(infoRepository.getByTitle("ip").getLink() + "/home");
            } else {
                throw new MemberException(ResultEnum.USERPASSWORD_ERROR);
            }
        }catch (Exception e){
            throw new MemberException(ResultEnum.USERNOTEXIST_ERROR);
        }


    }

    //注销
    public Result logout(){
        HttpSession session = httpServletRequest.getSession();
        session.removeAttribute("name");
        session.removeAttribute("id");
        return ResultUtil.success();
    }

    //用户信息
    public Result memberInfo(){
        return ResultUtil.success(memberRepository.findAll(new Sort(Sort.Direction.ASC, "id")));
    }
}
