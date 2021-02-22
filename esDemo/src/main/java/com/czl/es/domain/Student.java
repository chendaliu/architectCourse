package com.czl.es.domain;

import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

/**
 * @Title:
 * @Description:
 * @Author: wb-ccl670938
 * @CreateTime: 2020-12-21 16:38
 * @Version:1.0
 **/
@Data
@Accessors(chain = true)
@Document(indexName = "student", type = "school")
public class Student {

    @Id
    private String id;

    private String name;

    private String gender;

    private Integer age;
}