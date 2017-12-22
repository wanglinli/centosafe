package com.wy.centosafe.domain;

import javax.persistence.*;
import java.util.Set;

/**
 * author wy
 * date 17-12-22
 * time 下午2:46
 */

@Entity
public class Role {

    @Id
    @GeneratedValue
    private Integer id;

    //权限名
    private String name;

    //权限描述
    private String content;

    @ManyToMany(cascade = CascadeType.PERSIST, fetch=FetchType.LAZY)
    @JoinTable(name="role_auth",joinColumns={@JoinColumn(name="role_id")},inverseJoinColumns={@JoinColumn(name="auth_id")})
    private Set<Auth> authSet;


    public Role(){}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setAuthSet(Set<Auth> authSet) {
        this.authSet = authSet;
    }
}
