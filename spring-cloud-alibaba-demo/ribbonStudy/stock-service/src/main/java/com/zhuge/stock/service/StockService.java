package com.zhuge.stock.service;

import org.springframework.stereotype.Service;

@Service
public class StockService {

	public String deductStock(Long productId, Integer stockCount) {
		String str = "商品productId=" + productId + "：扣减库存" + stockCount;
		System.out.println(str);
		return str;
	}

}