package top.ttt.test;

import top.ttt.bean.Cart;
import top.ttt.service.ICartService;
import top.ttt.service.impl.CartServiceImpl;

public class Test03 {

	public static void main(String[] args) {
		ICartService cartService = new CartServiceImpl();
		System.out.println(cartService.getCartByUserId(1));
//		Cart cart = new Cart();
//		System.out.println(cartService.insCart(cart));
		System.out.println(cartService.delCartByUserAndGoodsId(0, 0));
	}

}
