package com.tuling.entity;

import java.io.Serializable;

/**
 * @Title:
 * @Description:
 * @Author: wb-ccl670938
 * @CreateTime: 2020-10-26 17:29
 * @Version:1.0
 **/
public class Address {
    private Long id ;
    private String name ;

    public Address() {}

    public Address(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}