package com.wy.centosafe.service;

import com.wy.centosafe.domain.Member;
import com.wy.centosafe.domain.Result;
import com.wy.centosafe.domain.repository.InfoRepository;
import com.wy.centosafe.domain.repository.MemberRepository;
import com.wy.centosafe.enums.ResultEnum;
import com.wy.centosafe.exceptions.MemberException;
import com.wy.centosafe.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.InputStreamReader;
import java.io.LineNumberReader;


/**
 * author wy
 * date 17-12-21
 * time 上午10:36
 */
@Service
public class CommonService {
    @Autowired
    private InfoRepository infoRepository;

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private HttpServletRequest httpServletRequest;
    //执行shell命令
    public static Object exec(String shell){
        try {
            String[] s = { "/bin/sh", "-c", shell };
            Process process = Runtime.getRuntime().exec(s);
            LineNumberReader br = new LineNumberReader(new InputStreamReader(
                    process.getInputStream()));
            StringBuffer sb = new StringBuffer();
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
                sb.append(line).append("\n");
            }
            return sb.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    //首页博客链接
    public Result getInfo(){
        return ResultUtil.success(infoRepository.getByTitle("blog").getLink());
    }

    //首页Github链接
    public Result getGithub(){
        return ResultUtil.success(infoRepository.getByTitle("github").getLink());
    }

    //登陆
    public Result dologin(String name, String password) throws MemberException {
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
        return ResultUtil.success(infoRepository.getByTitle("ip").getLink()+"/login");
    }



}
