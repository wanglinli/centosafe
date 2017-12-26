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

import static com.wy.centosafe.service.CommonService.exec;


/**
 * author wy
 * date 17-12-20
 * time 下午9:14
 */
@Service
public class SysService {

    private ArrayList<String> arrayList;


    /**
     * 命令产生的文件
     * @param s 执行的命令
     */
    private void create(String s){
        exec(s);
    }


    /**
     * linux用户登录日志文件
     */
    private void createLogged(){
        String s = "last | more > record/login";
        create(s);
    }

    /**
     * 用户远程ssh连接系统日志产生的文件
     */
    private void createSshConnect(){
        String s = "tac /var/log/secure > record/sshconnect";
        create(s);
    }


    /**
     * centos top命令产生的文件
     */
    private void createTop(){
        String s = "top -b -n 1 | head -n 5 > record/top";
        create(s);
    }

    /**
     * 系统发行版本文件version
     */
    private void createVersion(){
        String s = "lsb_release -a > record/version";
        create(s);
    }

    /**
     * 磁盘状态文件df
     */
    private void createDf(){
        String s = "df > record/df";
        create(s);
    }

    /**
     * 系统进程文件ps
     */
    private void createPs(){
        String s = "ps -eFH | grep wy > record/ps";
        create(s);
    }
    /**
     *
     * @param file 要得到的文件的路径
     * @return
     */
    private Result getFile(String file){
        if(arrayList == null){
            arrayList = new ArrayList<>();
        }
        arrayList.clear();
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
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


    /**
     * 得到login文件内容
     */
    public Result getLoggedInfo(){
        createLogged();
        String file = "record/login";
        return getFile(file);
    }


    /**
     * 得到sshconnect内容
     * @return
     */
    public Result getSshConnectInfo(){
        createSshConnect();
        String file = "record/sshconnect";
        return getFile(file);
    }

    /**
     * 得到top文件的内容
     * @return
     */
    public Result getTopInfo(){
        createTop();
        String file = "record/top";
        return getFile(file);
    }

    /**
     * 得到系统版本
     * @return
     */
    public Result getVersionInfo(){
        createVersion();
        String file = "record/version";
        return getFile(file);
    }

    /**
     * 得到磁盘状态
     * @return
     */
    public Result getDfInfo(){
        createDf();
        String file = "record/df";
        return getFile(file);
    }

    /**
     * 得到进程文件ps信息
     * @return
     */
    public Result getPsInfo(){
        createPs();
        String file = "record/ps";
        return getFile(file);
    }
}
