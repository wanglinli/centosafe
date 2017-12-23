package com.wy.centosafe.service;

import com.wy.centosafe.domain.Result;
import com.wy.centosafe.enums.ResultEnum;
import com.wy.centosafe.exceptions.LogException;
import com.wy.centosafe.utils.ResultUtil;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.util.ArrayList;


/**
 * author wy
 * date 17-12-20
 * time 下午9:14
 */
@Service
public class LogService {

    private ArrayList<String> arrayList;

    //执行shell命令
    private static Object exec(String shell){
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

    //更新centos用户登陆日志并将结果定向到login文件
    public Result updateLoggedLog(){
        String s = "last | more > login";
        Object object = exec(s);
        if(object == null){
            return ResultUtil.error(1,"exec failed!");
        }
        return ResultUtil.success();
    }

    //更新centos用户ssh连接系统日志并将结果定向到sshconnect文件
    public Result updateSshConnecLog(){
        String s = "tac /var/log/secure >sshconnect";
        Object object = exec(s);
        if(object == null){
            return ResultUtil.error(1,"exec failed!");
        }
        return ResultUtil.success();
    }

    //得到logged文件并返回其内容给前端请求
    public Result getLoggedLogInfo() throws Exception{
        if(arrayList == null){
           arrayList = new ArrayList<>();
        }
        arrayList.clear();
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("login")));
            String message = null;
            while((message = br.readLine())!=null) {
               arrayList.add(message);
            }
            return ResultUtil.success(arrayList);
        }catch (Exception e){
            throw new LogException(ResultEnum.FILENOTEXIST_ERROR);
        }
    }

    //get sshlogin.txt
    public Result getSshConnecLogInfo() throws Exception{
        if(arrayList == null){
            arrayList = new ArrayList<>();
        }
        arrayList.clear();
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("sshconnect")));
            String message = null;
            while((message = br.readLine())!=null)
            {
                arrayList.add(message);
            }
            return ResultUtil.success(arrayList);
        }catch (Exception e){
            throw new LogException(ResultEnum.FILENOTEXIST_ERROR);
        }
    }

}
