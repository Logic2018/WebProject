package top.ttt.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import top.ttt.service.IGoodsService;
import top.ttt.service.impl.GoodsServiceImpl;

@WebServlet("/GoodsServlet")
public class GoodsServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("进入了GoodsServlet的Get方法:");
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("进入了GoodsServlet的Post方法:");
		//取消浏览器缓存防止图片更新不及时
		resp.setHeader("pragma", "no-cache");
		resp.setHeader("cache-Control", "no-cache");
		resp.setDateHeader("expires",0);
		//创建Gson对象，转换Json数据
		//map存放键值对
		Gson gson = new Gson();
		String json = "";
		Map<String,Object> map = new HashMap<String,Object>();
		//创建service
		IGoodsService goodsService = new GoodsServiceImpl();
		//获取进入servlet的标志
		String flag = req.getParameter("flag");
		
		//显示所有商品
		if ("show".equals(flag)) {
			System.out.println("进入showAll快");
			List<Map<String, Object>> goodsList = goodsService.getAllGoods();			
			map.put("data", goodsList);
			json = gson.toJson(map);
			resp.getWriter().print(json);
		}
		
		//根据id显示单个商品
		if ("single".equals(flag)) {
			String id = req.getParameter("id");
			System.out.println(id);
			int gId = -1;
			if(id == null || "".equals(id)) {
				return;
			}else {
				gId = Integer.parseInt(id);
			}
			List<Map<String, Object>> goodsList = goodsService.getGoodsById(gId);
			map.put("data", goodsList);
			json = gson.toJson(map);
			resp.getWriter().print(json);
		}
		
		//显示所有商品
		if ("show1".equals(flag)) {
			System.out.println("进入showAll快");
			List<Map<String, Object>> goodsList = goodsService.getAllGoods();
			int[] ids = {1,2,3,4};
			List<Map<String, Object>> goodsList1 = goodsService.getGoodsByIds(ids);
			map.put("data", goodsList);
			map.put("data1", goodsList1);
			json = gson.toJson(map);
			resp.getWriter().print(json);
		}
	}

}
