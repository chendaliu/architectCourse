package com.ydlclass.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * @author
 * @createTime 2023-05-27
 */
public class Folder implements FileSystem{

    private String fileName;
    private List<FileSystem> fileSystems;

    public Folder(String fileName) {
        this.fileName = fileName;
        this.fileSystems = new ArrayList<>();
    }

    @Override
    public void display() {
        System.out.println("folder["+fileName+"]:");
        for (FileSystem fileSystem : fileSystems) {
            fileSystem.display();
        }
    }

    public void addFileSystem(FileSystem fileSystem){
        this.fileSystems.add(fileSystem);
    }
}
