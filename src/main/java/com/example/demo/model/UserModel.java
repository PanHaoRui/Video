package com.example.demo.model;


/**
 * @author 醒岩
 *
 */
//实现序列化？
public class UserModel {
	// 登录账号（唯一）
	private String loginName;
	// 登录密码
	private String passWord;
	//唯一id
	private int id;
	//权限
	private int jurisdiction;
	//戏剧
	private int comedy;
	//动作
	private int action;
	//恐怖
	private int terror;
	//科幻
	private int scienceFiction;
	//卡通
	private int cartoon;
	//爱情
	private int love;
	//枪战
	private int gunplay;
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getJurisdiction() {
		return jurisdiction;
	}
	public void setJurisdiction(int jurisdiction) {
		this.jurisdiction = jurisdiction;
	}
	public int getComedy() {
		return comedy;
	}
	public void setComedy(int comedy) {
		this.comedy = comedy;
	}
	public int getAction() {
		return action;
	}
	public void setAction(int action) {
		this.action = action;
	}
	public int getTerror() {
		return terror;
	}
	public void setTerror(int terror) {
		this.terror = terror;
	}
	public int getScienceFiction() {
		return scienceFiction;
	}
	public void setScienceFiction(int scienceFiction) {
		this.scienceFiction = scienceFiction;
	}
	public int getCartoon() {
		return cartoon;
	}
	public void setCartoon(int cartoon) {
		this.cartoon = cartoon;
	}
	public int getLove() {
		return love;
	}
	public void setLove(int love) {
		this.love = love;
	}
	public int getGunplay() {
		return gunplay;
	}
	public void setGunplay(int gunplay) {
		this.gunplay = gunplay;
	}
	@Override
	public String toString() {
		return "UserModel [loginName=" + loginName + ", passWord=" + passWord + ", id=" + id + ", jurisdiction="
				+ jurisdiction + ", comedy=" + comedy + ", action=" + action + ", terror=" + terror
				+ ", scienceFiction=" + scienceFiction + ", cartoon=" + cartoon + ", love=" + love + ", gunplay="
				+ gunplay + "]";
	}
	

}
