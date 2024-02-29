package com.ydlclass.composite;

/**
 * @author
 * @createTime 2023-05-27
 */
public class Main {

    public static void main(String[] args) {
        // 创建文件
        FileSystem dx = new File("稻香.mp3",1024L);
        FileSystem sjg = new File("双杰伦.mp3",1024L);
        FileSystem lldq = new File("流浪地球2.mp4",1024L);
        FileSystem ys = new File("我不是药神.class",2048L);
        FileSystem fl = new File("复仇者联盟3.class",2048L);

        // 创建文件夹
        Folder root = new Folder("root");
        Folder music = new Folder("音乐");
        Folder movie = new Folder("电影");
        Folder chinaMovie = new Folder("中国电影");
        Folder foreignMovie = new Folder("外国电影");

        // 组合
        root.addFileSystem(movie);
        root.addFileSystem(music);

        music.addFileSystem(dx);
        music.addFileSystem(sjg);

        movie.addFileSystem(chinaMovie);
        movie.addFileSystem(foreignMovie);
        chinaMovie.addFileSystem(ys);
        chinaMovie.addFileSystem(lldq);
        foreignMovie.addFileSystem(fl);

        root.display();
    }

}
