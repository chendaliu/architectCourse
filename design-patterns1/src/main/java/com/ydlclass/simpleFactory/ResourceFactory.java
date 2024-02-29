package com.ydlclass.simpleFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 
 * @createTime 2023-05-09
 */
public class ResourceFactory {

    public static Resource create(String type,String url){
        if("http".equals(type)){
            // ..发起请求下载资源... 可能很复杂
            return new Resource(url);
        } else if ("file".equals(type)) {
            // ..建立流，做异常处理等等
            return new Resource(url);
        } else if ("classpath".equals(type)) {
            // ...
            return new Resource(url);
        } else {
            return new Resource("default");
        }

    }

}
