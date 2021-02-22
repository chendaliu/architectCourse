package pers.czl.elasticjob.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Title:
 * @Description:
 * @Author: wb-ccl670938
 * @CreateTime: 2020-12-24 14:09
 * @Version:1.0
 **/
@RestController
public class TestController {

    @GetMapping(value="/console/{name}")
    public String startup(@PathVariable("name") String name) {
        return name;
    }
}