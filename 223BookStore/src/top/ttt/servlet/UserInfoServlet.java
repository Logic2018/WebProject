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

import top.ttt.bean.UserInfo;
import top.ttt.dao.IUserInfoDao;
import top.ttt.dao.impl.UserInfoDaoImpl;
import top.ttt.service.IUserService;
import top.ttt.service.impl.UserServiceImpl;

@WebServlet("/UserInfoServlet")
public class UserInfoServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("进入了UserInfoServlet的Get方法:");
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("进入了UserInfoServlet的Post方法:");
		IUserService userService = new UserServiceImpl();
		IUserInfoDao userInfoDao = new UserInfoDaoImpl();
		//map存放键值对
		Gson gson = new Gson();
		String json = "";
		Map<String,Object> map = new HashMap<String,Object>();
		String flag = req.getParameter("flag");
		
		if ("login".equals(flag)) {
			String username = req.getParameter("username");
			String password = req.getParameter("password");
			int a = -1;
			a = userService.getUserByNameAndPass(username, password);
			if (a == 1) {
				map.put("code", 200);
				List<Map<String, Object>> userList = userInfoDao.getUserByName(username);
				int id = (int) userList.get(0).get("user_id");
				String name = (String) userList.get(0).get("user_name");
				String pass = (String) userList.get(0).get("user_pass");
				String sex = (String) userList.get(0).get("user_sex");
				String tel = (String) userList.get(0).get("user_tel");
				String email = (String) userList.get(0).get("user_email");
				UserInfo userInfo = new UserInfo(id,name,pass,sex,tel,email);
				req.getSession().setAttribute("userInfo", userInfo);
			}else {
				map.put("code", 100);
			}
			
			json = gson.toJson(map);
			resp.getWriter().print(json);			
		}
		
		if("register".equals(flag)) {
			System.out.println("进入register:");
			String name = req.getParameter("username");
			String pass = req.getParameter("password");
			String tel = req.getParameter("tel");
			String email = req.getParameter("email");
			String sex = req.getParameter("sex");
			UserInfo userInfo = new UserInfo(name, pass, sex, tel, email);
			int i = -1;
			i = userService.insUser(userInfo);
			if (i == 1) {
				map.put("code", 200);
			}
			json = gson.toJson(map);
			resp.getWriter().print(json);
		}
		
		if ("checkName".equals(flag)) {
			String name = req.getParameter("username");
			int i = userService.getUserByName(name);
			if (i == 1) {
				map.put("code", 200);
			}
			json = gson.toJson(map);
			resp.getWriter().print(json);
		}
		
		if ("user".equals(flag)) {
			UserInfo userInfo = (UserInfo) req.getSession().getAttribute("userInfo");
			System.out.println(userInfo);
			map.put("userInfo", userInfo);
			json = gson.toJson(map);
			resp.getWriter().print(json);
		}
		
		
	}

}
