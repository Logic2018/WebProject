package top.ttt.test;



import top.ttt.bean.UserInfo;
import top.ttt.service.IUserService;
import top.ttt.service.impl.UserServiceImpl;

public class Test01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IUserService userService = new UserServiceImpl();
		System.out.println(userService.getAllUser());
		System.out.println(userService.getUserByName("Curtai"));
		System.out.println(userService.getUserByNameAndPass("Curtain", "13"));
		System.out.println(userService.getUserById(0));
		UserInfo userInfo = new UserInfo("xuqiang","123","female","13658468858","159@qq.com");
		System.out.println(userService.insUser(userInfo));
	}

}
