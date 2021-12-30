package pers.czl.architect.designpattern.adapter;

import ch.qos.logback.core.joran.spi.XMLUtil;
import pers.czl.architect.designpattern.adapter.adapter.OperationAdapter;
import pers.czl.architect.designpattern.adapter.target.ScoreOperation;

/**
 * 适配器模式
 * 角色：1.Adapter（适配器类），2.Adaptee（适配者类），3.Target（目标抽象类）
 * @author: daliu
 * @date: 2021-12-30 14:32
 **/
public class Client {

    public static void main(String[] args) {
        ScoreOperation operation = new OperationAdapter();
        int scores[] = {84,76,50,69,90,91,88,96}; //定义成绩数组
        int result[];
        int score;

        System.out.println("成绩排序结果：");
        result = operation.sort(scores);

        //遍历输出成绩
        for(int i : scores) {
            System.out.print(i + ",");
        }
        System.out.println();

        System.out.println("查找成绩90：");
        score = operation.search(result,90);
        if (score != -1) {
            System.out.println("找到成绩90。");
        }
        else {
            System.out.println("没有找到成绩90。");
        }

        System.out.println("查找成绩92：");
        score = operation.search(result,92);
        if (score != -1) {
            System.out.println("找到成绩92。");
        }
        else {
            System.out.println("没有找到成绩92。");
        }

    }
}