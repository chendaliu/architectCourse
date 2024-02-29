package com.ydlclass.flyweight;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @author
 * @createTime 2023-05-29
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Position {
    private int positionX;
    private int positionY;
}
