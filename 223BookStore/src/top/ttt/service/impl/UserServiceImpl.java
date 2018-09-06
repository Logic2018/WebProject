package top.ttt.service.impl;

import java.util.List;
import java.util.Map;

import top.ttt.bean.UserInfo;
import top.ttt.dao.IUserInfoDao;
import top.ttt.dao.impl.UserInfoDaoImpl;
import top.ttt.service.IUserService;

public class UserServiceImpl implements IUserService{

	IUserInfoDao userInfoDao = new UserInfoDaoImpl();
	@Override
	public List<Map<String, Object>> getAllUser() {
		
		return userInfoDao.getAllUser();
	}

	@Override
	public int getUserByName(String userName) {
		List<Map<String, Object>> list = userInfoDao.getUserByName(userName);
		if (list.size() == 0 || list == null) {
			return 0;
		}
		return 1;
	}

	@Override
	public List<Map<String, Object>> getUserById(int userId) {
		
		return userInfoDao.getUserById(userId);
	}

	@Override
	public int getUserByNameAndPass(String userName, String userPass) {
		// TODO Auto-generated method stub
		List<Map<String, Object>> list = userInfoDao.getUserByNameAndPass(userName, userPass);
		if (list.size() == 0 || list == null) {
			return 0;
		}
		return 1;
	}

	@Override
	public int insUser(UserInfo userInfo) {
		// TODO Auto-generated method stub
		return userInfoDao.insUser(userInfo);
	}
	

}
