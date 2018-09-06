package top.ttt.dao.impl;

import java.util.List;
import java.util.Map;

import top.ttt.bean.Cart;
import top.ttt.dao.ICartDao;
import top.ttt.util.DBUtil;

public class CartDaoImpl implements ICartDao{

	@Override
	public List<Map<String, Object>> getCartByUserId(int userId) {
		String sql = "SELECT c.goods_num, g.goods_name, g.goods_price, g.goods_picture, g.goods_id " + 
				"FROM cart c, goods g " + 
				"where c.user_id = ? " + 
				"AND g.goods_id = c.goods_id";
		return DBUtil.executeQuery(sql, userId);
	}

	@Override
	public int delCartByUserAndGoodsId(int userId, int goodsId) {
		String sql = "DELETE FROM cart " + 
				"where goods_id = ? " + 
				"AND user_id = ? ";
		
		return DBUtil.executeUpdate(sql, goodsId, userId);
	}

	@Override
	public int insCart(Cart cart) {
		String sql = "INSERT INTO cart " + 
				"VALUES(?,?,?)";
		int userId = cart.getUserId();
		int goodsId = cart.getGoodsId();
		int goodsNum = cart.getGoodsNum();
		return DBUtil.executeUpdate(sql, userId, goodsId, goodsNum);
	}

}
