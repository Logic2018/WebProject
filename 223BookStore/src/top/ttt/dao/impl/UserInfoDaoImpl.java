package top.ttt.dao.impl;

import java.util.List;
import java.util.Map;

import top.ttt.bean.UserInfo;
import top.ttt.dao.IUserInfoDao;
import top.ttt.util.DBUtil;

public class UserInfoDaoImpl implements IUserInfoDao{

	@Override
	public  List<Map<String, Object>> getAllUser() {
		String sql = "select * from userinfo";
		
		return DBUtil.executeQuery(sql);
	}

	@Override
	public List<Map<String, Object>> getUserByName(String userName) {
		String sql = "SELECT * from userinfo where user_name = ?";
		
		return DBUtil.executeQuery(sql, userName);
	}

	@Override
	public List<Map<String, Object>> getUserById(int userId) {
		String sql = "SELECT * from userinfo where user_id = ?";
		
		return DBUtil.executeQuery(sql, userId);
	}

	@Override
	public List<Map<String, Object>> getUserByNameAndPass(String userName, String userPass) {
		String sql = "SELECT * from userinfo where user_name = ? and user_pass = ?";
		
		return DBUtil.executeQuery(sql, userName, userPass);
	}

	@Override
	public int insUser(UserInfo userInfo) {
		String sql = "INSERT into userinfo(user_name,user_pass, user_sex, user_tel, user_email) VALUES(?,?,?,?,?)";
		String name = userInfo.getUserName();
		String pass = userInfo.getUserPass();
		String sex = userInfo.getUserSex();
		String tel = userInfo.getUserTel();
		String email = userInfo.getUserEmail();
		return DBUtil.executeUpdate(sql, name,pass,sex,tel,email);
	}
	
}
