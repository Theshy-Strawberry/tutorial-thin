package jp.terasoluna.thin.tutorial.web.transcosmos.dto;

import java.io.Serializable;

public class JNTCIPersonalInfoInquireInfo implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	//天津卡号
	private String tj_card;

	//济南卡号
	private String jn_card;

	//姓名
	private String userName;

	//性别
	private String sex;

	//出生日期
	private String birthday;

	//年龄
	private Integer age = 0;

	//入社时间
	private String entryTime;

	//职位
	private String position;

	//联系电话
	private String telephone;

	//地址
	private String address;
	private String out_time;;
	public String getOut_time() {
		return out_time;
	}

	public void setOut_time(String out_time) {
		this.out_time = out_time;
	}

	public String getTj_card() {
		return tj_card;
	}

	public void setTj_card(String tj_card) {
		this.tj_card = tj_card;
	}

	public String getJn_card() {
		return jn_card;
	}

	public void setJn_card(String jn_card) {
		this.jn_card = jn_card;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getEntryTime() {
		return entryTime;
	}

	public void setEntryTime(String entryTime) {
		this.entryTime = entryTime;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
