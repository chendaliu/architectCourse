package pers.czl.architect.designpattern.prototype.deepClone;

import com.sun.xml.internal.ws.api.message.Attachment;

import java.io.*;

/**
 * 工作周报类
 *
 * @author: daliu
 * @date: 2021-12-28 14:39
 **/
public class WeeklyLog implements Serializable {
    private Attachment attachment;

    private String name;

    private String date;

    private String content;

    public void setAttachment(Attachment attachment) {
        this.attachment = attachment;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Attachment getAttachment() {
        return (this.attachment);
    }

    public String getName() {
        return (this.name);
    }

    public String getDate() {
        return (this.date);
    }

    public String getContent() {
        return (this.content);
    }

    /*
     * 使用序列化技术实现深克隆
     * @param:
     * @return:
     * @author: daliu
     * @date: 2021/12/28 14:45
     **/
    public WeeklyLog deepClone() throws IOException, ClassNotFoundException, OptionalDataException {
        //将对象写入流中
        ByteArrayOutputStream bao = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bao);
        oos.writeObject(this);
        //将对象从流中取出
        ByteArrayInputStream bis = new ByteArrayInputStream(bao.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(bis);
        return (WeeklyLog) ois.readObject();
    }

    /**
     * 浅克隆方法clone()，此处使用Java语言提供的克隆机制
     * @param: []
     * @return: pers.czl.architect.designpattern.prototype.deepClone.WeeklyLog
     * @author: daliu
     * @date: 2021/12/28 14:45
     **/

    public WeeklyLog lightClone() {
        Object obj = null;
        try {
            obj = super.clone();
            return (WeeklyLog) obj;
        } catch (CloneNotSupportedException e) {
            System.out.println("不支持复制！");
            return null;
        }
    }

}