package top.ttt.bean;

public class Goods {
	private int goodsId;					//商品id
	private String goodsName;   			//商品名称
	private String goodsPrice;  			//商品价格
	private String goodsPicture;			//商品图片
	private String goodsInfo;				//商品信息
	private String goodsType;				//商品类型
	
	
	
	
	public Goods() {
		super();
	}
	public Goods(String goodsName, String goodsPrice, String goodsPicture, String goodsInfo, String goodsType) {
		super();
		this.goodsName = goodsName;
		this.goodsPrice = goodsPrice;
		this.goodsPicture = goodsPicture;
		this.goodsInfo = goodsInfo;
		this.goodsType = goodsType;
	}
	public Goods(int goodsId, String goodsName, String goodsPrice, String goodsPicture, String goodsInfo,
			String goodsType) {
		super();
		this.goodsId = goodsId;
		this.goodsName = goodsName;
		this.goodsPrice = goodsPrice;
		this.goodsPicture = goodsPicture;
		this.goodsInfo = goodsInfo;
		this.goodsType = goodsType;
	}
	@Override
	public String toString() {
		return "Goods [goodsId=" + goodsId + ", goodsName=" + goodsName + ", goodsPrice=" + goodsPrice
				+ ", goodsPicture=" + goodsPicture + ", goodsInfo=" + goodsInfo + ", goodsType=" + goodsType + "]";
	}
	public int getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(int goodsId) {
		this.goodsId = goodsId;
	}
	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	public String getGoodsPrice() {
		return goodsPrice;
	}
	public void setGoodsPrice(String goodsPrice) {
		this.goodsPrice = goodsPrice;
	}
	public String getGoodsPicture() {
		return goodsPicture;
	}
	public void setGoodsPicture(String goodsPicture) {
		this.goodsPicture = goodsPicture;
	}
	public String getGoodsInfo() {
		return goodsInfo;
	}
	public void setGoodsInfo(String goodsInfo) {
		this.goodsInfo = goodsInfo;
	}
	public String getGoodsType() {
		return goodsType;
	}
	public void setGoodsType(String goodsType) {
		this.goodsType = goodsType;
	}
	
	
	
}
