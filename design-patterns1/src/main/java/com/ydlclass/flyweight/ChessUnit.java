package com.ydlclass.flyweight;

import lombok.ToString;

/**
 * 享元类就完成了
 * @author 
 * @createTime 2023-05-29
 */
@ToString
public class ChessUnit {

    private Long id;

    private String text;

    private Color Color;

    public ChessUnit(Long id, String text, ChessUnit.Color color) {
        this.id = id;
        this.text = text;
        Color = color;
    }

    public enum Color{
        RED,BLACK
    }
}
