package com.ydlclass.observer.subscriber;

import java.util.Map;

/**
 * @author 
 * @createTime 2023-05-30
 */
public interface Subscriber {


    void onEvent(Map<String,Object> eventContext);

}
