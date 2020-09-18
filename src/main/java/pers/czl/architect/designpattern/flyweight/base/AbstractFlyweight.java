package pers.czl.architect.designpattern.flyweight.base;

/**
 * @Title:
 * @Description:
 * @Author: wb-ccl670938
 * @CreateTime: 2020-09-17 16:29
 * @Version:1.0
 **/
public abstract class AbstractFlyweight {
    //内部状态
    public String intrinsic;
    //外部状态
    protected final String extrinsic;

    protected AbstractFlyweight(String extrinsic) {
        this.extrinsic = extrinsic;
    }

    public abstract void operate(int extrinsic);


    public String getIntrinsic() {
        return intrinsic;
    }

    public void setIntrinsic(String intrinsic) {
        this.intrinsic = intrinsic;
    }
}