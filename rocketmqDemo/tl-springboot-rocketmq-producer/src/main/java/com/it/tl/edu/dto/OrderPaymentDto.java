package com.it.tl.edu.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @author ：
 * @date：2019/11/4
 * @version: V1.0
 * @slogan:
 * @description : 如果报错，需要安装lombok插件
 */
@AllArgsConstructor
@Data
public class OrderPaymentDto {
    private long orderid;

    private BigDecimal paymoney;
}
