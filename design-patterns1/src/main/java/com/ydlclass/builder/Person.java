package com.ydlclass.builder;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

/**
 * @author 
 * @createTime 2023-05-12
 */
@Getter
@ToString
@Builder
public class Person {
    private String name;
    private int age;
    private String address;

    public static void main(String[] args) {
        Person.PersonBuilder builder = new Person.PersonBuilder();
        Person person = builder.age(12).name("lily").address("xxx").build();
    }
}
