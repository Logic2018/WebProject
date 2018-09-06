package top.ttt.dao;

import java.util.List;
import java.util.Map;

import top.ttt.bean.UserInfo;

public interface IUserInfoDao {

	/**
	 * 查询所有用户信息
	 * @return
	 */
	 List<Map<String, Object>> getAllUser();
	 
	 /**
	  * 通过用户名查询用户
	  * @param userName 用户名
	  * @return
	  */
	 List<Map<String, Object>> getUserByName(String userName);
	 
	 /**
	  * 通过用户id查询用户
	  * @param userId
	  * @return
	  */
	 List<Map<String, Object>> getUserById(int userId);
	 
	 /**
	  * 通过用户名和密码查询用户信息
	  * @param userName 用户名
	  * @param userPass 密码
	  * @return
	  */
	 List<Map<String, Object>> getUserByNameAndPass(String userName, String userPass);
	 
	 /**
	  * 插入用户信息
	  * @param userInfo 用户信息
	  * @return
	  */
	 int insUser(UserInfo userInfo);
}
