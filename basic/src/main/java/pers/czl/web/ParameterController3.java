package pers.czl.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * PathVariable的封装分析
 * @author 白起
 *
 */
@Controller
public class ParameterController3 {

    /**
     * 请求参数封装的分析
     */
    @RequestMapping("testParam3/{username}/{age}")
    public void testParam(@PathVariable("username") String username, @PathVariable Integer age){
        System.out.println(username+","+age);
    }

}
