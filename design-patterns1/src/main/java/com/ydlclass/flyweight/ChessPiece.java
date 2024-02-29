package com.ydlclass.flyweight;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author 
 * @createTime 2023-05-29
 */
@Data
@AllArgsConstructor
public class ChessPiece {

    private ChessUnit chessUnit;
    private Position position;

}
