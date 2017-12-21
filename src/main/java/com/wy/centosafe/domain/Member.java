package com.wy.centosafe.domain;


/**
 * author wy
 * date 17-12-21
 * time 上午11:16
 */

public class Member {
    private String name;
    private String password;


    public Member() {
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

}
