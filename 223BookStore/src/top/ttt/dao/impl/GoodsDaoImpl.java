package top.ttt.dao.impl;

import java.util.List;
import java.util.Map;

import top.ttt.dao.IGoodsDao;
import top.ttt.util.DBUtil;

public class GoodsDaoImpl implements IGoodsDao{
	

	@Override
	public List<Map<String, Object>> getAllGoods() {
		String sql = "SELECT * FROM goods";
		return DBUtil.executeQuery(sql);
	}

	@Override
	public List<Map<String, Object>> getGoodsByType(String goodsType) {
		String sql = "SELECT * FROM goods " + 
				"WHERE goods_type = ? ";
		return DBUtil.executeQuery(sql, goodsType);
	}

	@Override
	public List<Map<String, Object>> getGoodsByIds(int[] ids) {
		String sql = "SELECT * FROM goods " + 
				"WHERE goods_id IN(?,?,?,?) ";
		return DBUtil.executeQuery(sql, ids[0], ids[1], ids[2], ids[3]);
	}

	@Override
	public List<Map<String, Object>> getGoodsByPage(int begin, int pageSize) {
		String sql = "SELECT * FROM goods limit ?,?";
		
		return DBUtil.executeQuery(sql, begin, pageSize);
	}

	@Override
	public List<Map<String, Object>> getGoodsById(int id) {
		String sql = "SELECT * FROM goods where goods_id = ?";
		return DBUtil.executeQuery(sql, id);
	}
	
}
