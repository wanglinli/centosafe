package com.wy.centosafe.domain;
import javax.persistence.*;
import java.util.List;
import java.util.Set;

/**
 * author wy
 * date 17-12-21
 * time 上午11:16
 * 用户成员表
 */

@Entity
public class Member {

    @Id
    @GeneratedValue
    private Integer id;

    //用户名
    private String name;

    //登陆密码
    private String password;


    //映射关系产生中间表role_member
    @ManyToMany(cascade = CascadeType.PERSIST, fetch=FetchType.LAZY)
    @JoinTable(name="member_role",joinColumns={@JoinColumn(name="member_id")},inverseJoinColumns={@JoinColumn(name="role_id")})
    private Set<Role> roleSet;

    public Member() {
    }



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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Role> getRoleSet() {
        return roleSet;
    }
}
