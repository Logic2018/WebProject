package top.ttt.bean;

public class Cart {
	private int userId;  		//用户id
	private int goodsId;		//商品id
	private int goodsNum;		//商品数量
	
	
	
	public Cart() {
		super();
	}



	public Cart(int userId, int goodsId, int goodsNum) {
		super();
		this.userId = userId;
		this.goodsId = goodsId;
		this.goodsNum = goodsNum;
	}



	public int getUserId() {
		return userId;
	}



	public void setUserId(int userId) {
		this.userId = userId;
	}



	public int getGoodsId() {
		return goodsId;
	}



	public void setGoodsId(int goodsId) {
		this.goodsId = goodsId;
	}



	public int getGoodsNum() {
		return goodsNum;
	}



	public void setGoodsNum(int goodsNum) {
		this.goodsNum = goodsNum;
	}
	
	
}
