package top.ttt.service;

import java.util.List;
import java.util.Map;

import top.ttt.bean.UserInfo;

public interface IUserService {

	/**
	 * 查询所有用户信息
	 * @return
	 */
	 List<Map<String, Object>> getAllUser();
	 
	 /**
	  * 判断用户名是否存在
	  * @param userName 用户名
	  * @return
	  */
	 int getUserByName(String userName);
	 
	 /**
	  * 通过用户id查询用户
	  * @param userId
	  * @return
	  */
	 List<Map<String, Object>> getUserById(int userId);
	 
	 /**
	  * 登录是否成功
	  * @param userName 用户名
	  * @param userPass 密码
	  * @return
	  */
	 int getUserByNameAndPass(String userName, String userPass);
	 
	 /**
	  * 注册是否成功
	  * @param userInfo
	  * @return
	  */
	 int insUser(UserInfo userInfo);
}
