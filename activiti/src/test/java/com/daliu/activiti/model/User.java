package com.daliu.activiti.model;

import java.io.Serializable;

/**
 * @Title:
 * @Description:
 * @Author: daliu
 * @CreateTime: 2021-07-15 14:35
 * @Version:1.0
 **/
public class User implements Serializable {

    private static final long serialVersionUID = -2427728494336034278L;

    private Integer id;

    private String name;

    public User(Integer id, String name) {
        this.id = id;
        this.name = name;
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
}