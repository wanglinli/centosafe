package com.wy.centosafe.service;

import com.wy.centosafe.domain.Member;
import com.wy.centosafe.domain.Result;
import com.wy.centosafe.enums.MemberEnum;
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
public class LoginService {
    @Autowired
    private HttpServletRequest httpServletRequest;

    public Result dologin(String name,String password){
        Member memberA = new Member();
        memberA.setName(MemberEnum.MEMBER_ADMIN.getName());
        memberA.setPassword(MemberEnum.MEMBER_ADMIN.getPassword());

        Member memberU = new Member();
        memberU.setName(MemberEnum.MEMBER_USER.getName());
        memberU.setPassword(MemberEnum.MEMBER_USER.getPassword());
        HttpSession session = httpServletRequest.getSession();
        if(name.equals(memberA.getName())){
            if(password.equals(memberA.getPassword())){
               session.setAttribute("name",memberA.getName());
                return ResultUtil.success(memberA.getName());
            }else {
                return ResultUtil.error(1,"密码错误!");
            }
        }else if(name.equals(memberU.getName())){
            if(password.equals(memberU.getPassword())){
                session.setAttribute("name",memberU.getName());
                return ResultUtil.success(memberU.getName());
            }else {
                return ResultUtil.error(1,"密码错误!");
            }
        }else {
            return ResultUtil.error(1,"用户不存在!");
        }

    }

    public Result logout(){
        HttpSession session = httpServletRequest.getSession();
        session.removeAttribute("name");
        return ResultUtil.success();
    }

}
