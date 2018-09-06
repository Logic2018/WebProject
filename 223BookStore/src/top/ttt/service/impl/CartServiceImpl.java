package top.ttt.service.impl;

import java.util.List;
import java.util.Map;

import top.ttt.bean.Cart;
import top.ttt.dao.ICartDao;
import top.ttt.dao.impl.CartDaoImpl;
import top.ttt.service.ICartService;

public class CartServiceImpl implements ICartService{

	ICartDao cartDao = new CartDaoImpl();
	@Override
	public List<Map<String, Object>> getCartByUserId(int userId) {
		// TODO Auto-generated method stub
		return cartDao.getCartByUserId(userId);
	}

	@Override
	public int delCartByUserAndGoodsId(int userId, int goodsId) {
		// TODO Auto-generated method stub
		return cartDao.delCartByUserAndGoodsId(userId, goodsId);
	}

	@Override
	public int insCart(Cart cart) {
		// TODO Auto-generated method stub
		return cartDao.insCart(cart);
	}

}
