package pers.czl.architect.designpattern.visitor;

/**
 * @author: daliu
 * @since: 2023-04-23 17:38
 **/
public class SnowflakeIdGenerator {
    /*
    机房 机器 序列号占的位数
     */
    private final static long DATACENTER_BIT = 5;
    private final static long MACHINE_BIT = 5;
    private final static long SEQUENCE_BIT = 12;

    // 起始时间戳, 固定值, 不能为new Date(),否则生成Id会重复
    private final static long START_TIMESTAMP = 154231231412L;
    // 机器标志相对序列号的偏移量 12位
    private final static long MACHINE_LEFT = SEQUENCE_BIT;
    // 机房标志相对机器的偏移量 17 = 12 + 5位
    private final static long DATACENTER_LEFT = MACHINE_LEFT + MACHINE_BIT;
    // 时间戳标志相对机器的偏移量 22 = 17 + 5位
    private final static long TIMESTAMP_LEFT = DATACENTER_LEFT + DATACENTER_BIT;

    // 用位运算计算出最大支持的数据中心数量 31
    private final static long MAX_DATACENTER_NUM = -1L ^ (-1L << DATACENTER_BIT);
    // 用位运算计算出最大支持的机器数量 31
    private final static long MAX_MACHINE_NUM = -1L ^ (-1L << MACHINE_BIT);
    // 用位运算计算出12位能存储的最大整数
    /*
    -1L异或运算复习
    0 ^ 0 和 1 ^ 1 = 0
    0 ^ 1 和 1 ^ 0 = 1

    -1L = 1111 1111  (0000 0001的取反+1)
    -1L << 12 = 1111 1111 0000 0000 0000

    1111 1111 0000 0000 0000
    ^
    1111 1111 1111 1111 1111
    ===============================
    0000 0000 1111 1111 1111 换算成十进制为: 4095
     */
    private final static long MAX_SEQUENCE = -1L ^ (-1L << SEQUENCE_BIT);
    /*
    机房 机器 序列号 上一次请求保存的时间戳
     */
    private static long datacenterId;
    private static long machineId;
    private static long sequence = 0L;// 自增序列号(相当于计数器)
    private static long lastStamp = -1L;

    /**
     * 此处无参构造private,是为了避免以下两点问题
     * (1)私有化避免了通过new方式进行调用, 解决了在for循环中通过new方式产生的id不一定唯一的问题
     * 因为用于记录上一次时间戳lastStamp永远无法得到对比
     * (2)没有给出有参构造在第一点的基础上考虑了分布式系统产生的唯一序列号应该总是"基于相同的参数"
     */
    public SnowflakeIdGenerator() {
    }
    /**
     * 产出下一个Id
     * @return
     */
    public static synchronized long nextId() {
        // 获取当前的时间戳
        long curStamp = getCurrentStamp();
        // 若当前时间戳 < 上次时间戳则抛出异常
        if (curStamp < lastStamp) {
            throw new RuntimeException("Clock moved backwords. Refusing to generate id");
        }
        // 1.同一毫秒内
        if (curStamp == lastStamp) {
            /*
            复习&运算:  除了1 & 1 = 1, 其余情况都是0
            例如sequence = 4095 MAX_SEQUENCE = 4095
            4095:       0000 1111 1111 1111
            ^
            4095 + 1:   0001 0000 0000 0000
            ===============================
            0(重置0)     0000 0000 0000 0000

             */
            // 1.1 相同毫秒内 id自增
            sequence = (sequence + 1) & MAX_SEQUENCE;
            // 1.2 同一毫秒内 序列数已经达到最大4095,等待下一个毫秒到来在生成
            if (sequence == 0L) {
                // 获取下一秒的时间戳并赋值给当前时间戳
                curStamp = getNextMill();
            }
            // 2.不同毫秒,序列号重置为0
        } else {
            sequence = 0L;
        }
        // 3.当前时间戳存档, 用于下次生成id对比是否为同一毫秒内
        lastStamp = curStamp;
        // 4.或运算拼接返回id
        return (curStamp - START_TIMESTAMP) << TIMESTAMP_LEFT // 时间戳部分
                | datacenterId << DATACENTER_LEFT // 机房部分
                | machineId << MACHINE_LEFT // 机器部分
                | sequence; // 序列号部分
    }

    private static long getNextMill() {
        long mill = getCurrentStamp();
        // 循环获取当前时间戳, 直到拿到下一秒的时间戳
        while (mill <= lastStamp) {
            mill = getCurrentStamp();
        }
        return mill;
    }

    private static long getCurrentStamp() {
        return System.currentTimeMillis();
    }
}

