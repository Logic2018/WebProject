package top.ttt.test;

import top.ttt.service.IGoodsService;
import top.ttt.service.impl.GoodsServiceImpl;

public class Test02 {

	public static void main(String[] args) {
		IGoodsService goodsService = new GoodsServiceImpl();
		System.out.println(goodsService.getAllGoods());
		System.out.println(goodsService.getGoodsByType("novel"));
		int[] ids = {1,2,3,4};
		System.out.println(goodsService.getGoodsByIds(ids));

	}

}
