package com.wy.centosafe.service;

import com.wy.centosafe.domain.Result;
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

    //exec shell
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

    //update login.txt
    public Result updateLog(){
        String s = "last | more > login.txt";
        Object object = exec(s);
        if(object == null){
            return ResultUtil.error(1,"exec failed!");
        }
        return ResultUtil.success();
    }

    //update sshlogin.txt
    public Result updateSshLog(){
        String s = "tac /var/log/secure >sshlogin.txt";
        Object object = exec(s);
        if(object == null){
            return ResultUtil.error(1,"exec failed!");
        }
        return ResultUtil.success();
    }

    //get login.txt
    public Result getLogInfo(){
        if(arrayList == null){
           arrayList = new ArrayList<>();
        }
        arrayList.clear();

        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("login.txt")));
            String message = null;
            while((message = br.readLine())!=null)
            {
               arrayList.add(message);
            }
            return ResultUtil.success(arrayList);
        }catch (Exception e){
            e.printStackTrace();
        }
        return ResultUtil.error(2,"get failed!");
    }

    //get sshlogin.txt
    public Result getSshLogInfo(){
        if(arrayList == null){
            arrayList = new ArrayList<>();
        }
        arrayList.clear();
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("sshlogin.txt")));
            String message = null;
            while((message = br.readLine())!=null)
            {
                arrayList.add(message);
            }
            return ResultUtil.success(arrayList);
        }catch (Exception e){
            e.printStackTrace();
        }
        return ResultUtil.error(2,"get failed!");
    }

}
