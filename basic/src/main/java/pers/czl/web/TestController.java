package pers.czl.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @RequestMapping("/test")
    public String test(String name) {
        return "hello" + name;
    }

    @RequestMapping("/test1")
    public String test1(String name) {
        return "hello1" + name;
    }
}
