package top.ttt.dao;

import java.util.List;
import java.util.Map;

import top.ttt.bean.Cart;

public interface ICartDao {

	/**
	 * 根据用户id查询购物车信息
	 * @param userId
	 * @return
	 */
	List<Map<String, Object>> getCartByUserId(int userId);
	
	/**
	 * 根据用户id和商品id删除购物车的商品
	 * @param userId
	 * @param goodsId
	 * @return
	 */
	int delCartByUserAndGoodsId(int userId, int goodsId);
	
	/**
	 * 插入一条购物车数据
	 * @param cart
	 * @return
	 */
	int insCart(Cart cart);
	
}
