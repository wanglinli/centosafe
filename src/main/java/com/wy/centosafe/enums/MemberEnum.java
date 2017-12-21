package com.wy.centosafe.enums;

/**
 * author wy
 * date 17-12-21
 * time 上午10:39
 */
public enum MemberEnum {

    MEMBER_ADMIN("admin","cptbtptp"),
    MEMBER_USER("user","user");

    private String name;
    private String password;

    MemberEnum(String name, String password){
        this.name = name;
        this.password = password;

    }


    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }
}
