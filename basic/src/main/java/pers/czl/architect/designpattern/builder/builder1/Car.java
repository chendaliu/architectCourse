package pers.czl.architect.designpattern.builder.builder1;

/**
 * 产品：汽车
 */
public class Car {
    //框架
    private String frame;

    //座位
    private String seat;

    //轮胎
    private String tire;

    public String getFrame() {
        return frame;
    }

    public void setFrame(String frame) {
        this.frame = frame;
    }

    public String getSeat() {
        return seat;
    }

    public void setSeat(String seat) {
        this.seat = seat;
    }

    public String getTire() {
        return tire;
    }

    public void setTire(String tire) {
        this.tire = tire;
    }

    @Override
    public String toString() {
        return "Car{" +
                "frame='" + frame + '\'' +
                ", seat='" + seat + '\'' +
                ", tire='" + tire + '\'' +
                '}';
    }
}
