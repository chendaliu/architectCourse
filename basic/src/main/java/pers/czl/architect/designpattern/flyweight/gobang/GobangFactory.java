package pers.czl.architect.designpattern.flyweight.gobang;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

/**
 * @Title:
 * @Description:
 * @Author: wb-ccl670938
 * @CreateTime: 2020-09-18 11:29
 * @Version:1.0
 **/
public enum GobangFactory {

    INSTANCE;

    private static Map<String, AbstractGobang> gobangHashMap = new HashMap<>();

    static {
        gobangHashMap.put(GolangColorEnum.COLOR_WHITE.getColor(), new WhiteGobang());
        gobangHashMap.put(GolangColorEnum.COLOR_BLACK.getColor(), new BlackGobang());
    }

    public AbstractGobang getGobang(GolangColorEnum golangColorEnum) {
        return gobangHashMap.get(golangColorEnum.getColor());
    }

}