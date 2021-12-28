package pers.czl.architect.designpattern.prototype.deepClone;

import com.sun.xml.internal.ws.api.message.Attachment;

/**
 * @author: daliu
 * @date: 2021-12-28 14:46
 **/
public class Client {
    public static void main(String[] args) {
        WeeklyLog log_previous = new WeeklyLog(); //创建原型对象
        Attachment attachment = new AttachmentImpl(); //创建附件对象
        log_previous.setAttachment(attachment);  //将附件添加到周报中

        WeeklyLog log_new = null;
        try {
            log_new = log_previous.deepClone(); //调用深克隆方法创建克隆对象
        } catch (Exception e) {
            System.out.println(e);
            System.err.println("克隆失败！");
        }
        //比较周报
        System.out.println("周报是否相同？ " + (log_previous == log_new));
        //比较附件
        System.out.println("附件是否相同？ " + (log_previous.getAttachment() == log_new.getAttachment()));
    }

}