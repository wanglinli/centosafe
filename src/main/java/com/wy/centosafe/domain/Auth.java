package com.wy.centosafe.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * author wy
 * date 17-12-22
 * time 下午3:29
 * 权限表
 */
@Entity
public class Auth {
    @Id
    @GeneratedValue
    private Integer id;

    //权限标题
    private String title;

    //权限操作
    private String operation;

    public Auth(){}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }
}
