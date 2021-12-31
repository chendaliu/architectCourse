package pers.czl.architect.designpattern.composite;

import pers.czl.architect.designpattern.composite.component.AbstractFile;
import pers.czl.architect.designpattern.composite.composite.Folder;
import pers.czl.architect.designpattern.composite.leaf.ImageFile;
import pers.czl.architect.designpattern.composite.leaf.TextFile;
import pers.czl.architect.designpattern.composite.leaf.VideoFile;

/**
 * 组合模式
 * 适用于树形结构
 * <p>
 * 角色：
 * 1.Component（抽象构件）：可以是接口或抽象类，是叶子构件和容器构建的父类
 * 2.Leaf（叶子构件）
 * 3.Composite（容器构件）
 *
 * 组合模式的关键是定义了一个抽象构件类，它既可以代表叶子，又可以代表容器，而客户端针对该抽象构件类进行编程，无须知道它到底表示的是叶子还是容器，可以对其进行统一处理
 *
 * @author: daliu
 * @date: 2021-12-31 13:38
 **/
public class Client {

    public static void main(String[] args) {
        //针对抽象构件编程
        AbstractFile file1, file2, file3, file4, file5, folder1, folder2, folder3, folder4;

        folder1 = new Folder("Sunny的资料");
        folder2 = new Folder("图像文件");
        folder3 = new Folder("文本文件");
        folder4 = new Folder("视频文件");

        file1 = new ImageFile("小龙女.jpg");
        file2 = new ImageFile("张无忌.gif");
        file3 = new TextFile("九阴真经.txt");
        file4 = new TextFile("葵花宝典.doc");
        file5 = new VideoFile("笑傲江湖.rmvb");

        folder2.add(file1);
        folder2.add(file2);
        folder3.add(file3);
        folder3.add(file4);
        folder4.add(file5);
        folder1.add(folder2);
        folder1.add(folder3);
        folder1.add(folder4);

        //从“Sunny的资料”节点开始进行杀毒操作
        folder1.killVirus();
    }
}