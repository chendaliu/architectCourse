package com.ydlclass.composite;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author
 * @createTime 2023-05-27
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class File implements FileSystem{

    private String fileName;

    private Long size;

    @Override
    public void display() {
        System.out.println(fileName+":" + size + "MB");
    }
}
