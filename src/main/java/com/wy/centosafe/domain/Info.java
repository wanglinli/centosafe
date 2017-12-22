package com.wy.centosafe.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * author wy
 * date 17-12-22
 * time 下午2:43
 */
@Entity
public class Info {
    @Id
    @GeneratedValue
    private Integer id;

    //标题
    private String title;

    //网站链接
    private String link;

    public Info(){}

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

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
