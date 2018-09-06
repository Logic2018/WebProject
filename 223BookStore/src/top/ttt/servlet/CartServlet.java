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

import top.ttt.bean.Cart;
import top.ttt.bean.UserInfo;
import top.ttt.service.ICartService;
import top.ttt.service.IGoodsService;
import top.ttt.service.impl.CartServiceImpl;
import top.ttt.service.impl.GoodsServiceImpl;
@WebServlet("/CartServlet")
public class CartServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("进入了CartServlet的Get方法:");
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		System.out.println("进入了CartServlet的Post方法:");
		//创建service
		ICartService cartService = new CartServiceImpl();

		//取消浏览器缓存防止图片更新不及时
		resp.setHeader("pragma", "no-cache");
		resp.setHeader("cache-Control", "no-cache");
		resp.setDateHeader("expires",0);
		//创建Gson对象，转换Json数据
		//map存放键值对
		Gson gson = new Gson();
		String json = "";
		Map<String,Object> map = new HashMap<String,Object>();
		//获取进入servlet的标志
		String flag = req.getParameter("flag");
		

		
		if ("add".equals(flag)) {
			UserInfo userInfo = (UserInfo) req.getSession().getAttribute("userInfo");
			String id = req.getParameter("id");
			String num = req.getParameter("num");
			
			int gId = -1;
			int gNum = -1;
			if(id == null || "".equals(id)) {
				return;
			}else {
				gId = Integer.parseInt(id);
			}
			
			if(num == null || "".equals(num)) {
				return;
			}else {
				gNum = Integer.parseInt(num);
			}
			Cart cart = new Cart();
			cart.setUserId(userInfo.getUserId());
			cart.setGoodsId(gId);
			cart.setGoodsNum(gNum);
			cartService.insCart(cart);
			
			map.put("code",200);
			json = gson.toJson(map);
			resp.getWriter().print(json);
		}
		
		if ("show".equals(flag)) {
			System.out.println("进入showAll快");
			UserInfo userInfo = (UserInfo) req.getSession().getAttribute("userInfo");
			int id = userInfo.getUserId();
			List<Map<String, Object>> cartList = cartService.getCartByUserId(id);			
			map.put("data", cartList);
			json = gson.toJson(map);
			resp.getWriter().print(json);
		}
		
		if ("del".equals(flag)) {
			System.out.println("进入del");
			String gid = req.getParameter("id");
			System.out.println(gid);
			int gId = -1;
			if(gid == null || "".equals(gid)) {
				return;
			}else {
				gId = Integer.parseInt(gid);
			}
			UserInfo userInfo = (UserInfo) req.getSession().getAttribute("userInfo");
			int id = userInfo.getUserId();
			int f = cartService.delCartByUserAndGoodsId(id, gId);
			if (f == 1) {
				map.put("code", 200);
			}
			json = gson.toJson(map);
			resp.getWriter().print(json);
		}
	}

}
