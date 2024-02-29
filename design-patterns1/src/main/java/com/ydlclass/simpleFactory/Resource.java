package com.ydlclass.simpleFactory;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 事实上一个资源类会很复杂
 * 我们一定样清除，课堂中的例子简单，但是不代表真实情况他就简单
 * 学习设计模式有一个中重要的作用就是写出可扩展、易阅读、可测试、高性能的代码
 * @author
 * @createTime 2023-05-09
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Resource {

    private String url;

}
