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
    private String link;

    MemberEnum(String name, String password){
        this.name = name;
        this.password = password;
        this.link = "http://127.0.0.1:8080/centosafe";
    }


    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getLink() {
        return link;
    }
}
