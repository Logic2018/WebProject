package top.ttt.bean;
/**
 * 用户信息表
 * @author Curtain
 *
 */
public class UserInfo {

	private int userId;           //学生id
	private String userName;	  //学生姓名
	private String userPass;	  //学生密码
	private String userSex;		  //学生性别
	private String userTel;		  //学生手机号
	private String userEmail;	  //学生邮箱
	
	
	
	
	
	public UserInfo() {
		super();
	}
	public UserInfo(String userName, String userPass, String userSex, String userTel, String userEmail) {
		super();
		this.userName = userName;
		this.userPass = userPass;
		this.userSex = userSex;
		this.userTel = userTel;
		this.userEmail = userEmail;
	}
	public UserInfo(int userId, String userName, String userPass, String userSex, String userTel, String userEmail) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userPass = userPass;
		this.userSex = userSex;
		this.userTel = userTel;
		this.userEmail = userEmail;
	}
	@Override
	public String toString() {
		return "UserInfo [userId=" + userId + ", userName=" + userName + ", userPass=" + userPass + ", userSex="
				+ userSex + ", userTel=" + userTel + ", userEmail=" + userEmail + "]";
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPass() {
		return userPass;
	}
	public void setUserPass(String userPass) {
		this.userPass = userPass;
	}
	public String getUserSex() {
		return userSex;
	}
	public void setUserSex(String userSex) {
		this.userSex = userSex;
	}
	public String getUserTel() {
		return userTel;
	}
	public void setUserTel(String userTel) {
		this.userTel = userTel;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	
	
	
}
