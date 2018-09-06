package top.ttt.service.impl;

import java.util.List;
import java.util.Map;

import top.ttt.dao.IGoodsDao;
import top.ttt.dao.impl.GoodsDaoImpl;
import top.ttt.service.IGoodsService;

public class GoodsServiceImpl implements IGoodsService{

	IGoodsDao goodsDao = new GoodsDaoImpl();
	@Override
	public List<Map<String, Object>> getAllGoods() {
		// TODO Auto-generated method stub
		return goodsDao.getAllGoods();
	}

	@Override
	public List<Map<String, Object>> getGoodsByType(String goodsType) {
		// TODO Auto-generated method stub
		return goodsDao.getGoodsByType(goodsType);
	}

	@Override
	public List<Map<String, Object>> getGoodsByIds(int[] ids) {
		// TODO Auto-generated method stub
		return goodsDao.getGoodsByIds(ids);
	}

	@Override
	public List<Map<String, Object>> getGoodsByPage(int begin, int pageSize) {
		
		return goodsDao.getGoodsByPage(begin, pageSize);
	}

	@Override
	public List<Map<String, Object>> getGoodsById(int id) {
		// TODO Auto-generated method stub
		return goodsDao.getGoodsById(id);
	}

}
