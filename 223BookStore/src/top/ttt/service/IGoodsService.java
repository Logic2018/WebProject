package top.ttt.service;

import java.util.List;
import java.util.Map;

public interface IGoodsService {
	

	/**
	 * 获取所有商品
	 * @return
	 */
	List<Map<String, Object>> getAllGoods();
	
	/**
	 * 根据商品类型查询商品
	 */
	List<Map<String, Object>> getGoodsByType(String goodsType);
	
	/**
	 * 显示特定几款新品
	 */
	List<Map<String, Object>> getGoodsByIds(int[] ids);
	
	/**
	 * 分页显示商品
	 * @param begin 
	 * @param pageSize
	 * @return
	 */
	List<Map<String, Object>> getGoodsByPage(int begin, int pageSize);
	
	/**
	 * 根据id获取商品信息
	 * @param id
	 * @return
	 */
	List<Map<String, Object>> getGoodsById(int id);
}
