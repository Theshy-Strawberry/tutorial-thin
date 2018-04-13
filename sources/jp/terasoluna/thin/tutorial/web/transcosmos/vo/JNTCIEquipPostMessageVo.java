package jp.terasoluna.thin.tutorial.web.transcosmos.vo;

public class JNTCIEquipPostMessageVo {

	private int info_id;
	private String info_title;
	private String class_name;
	private String info_details;
	private String info_date;
	private String userId;
	private String user_name;
	
	//图片显示
	private String tenpu_path=null;

	public String getTenpu_path() {
		return tenpu_path;
	}
	public void setTenpu_path(String tenpu_path) {
		this.tenpu_path = tenpu_path;
	}
	public int getInfo_id() {
		return info_id;
	}
	public void setInfo_id(int info_id) {
		this.info_id = info_id;
	}
	public String getInfo_title() {
		return info_title;
	}
	public void setInfo_title(String info_title) {
		this.info_title = info_title;
	}
	public String getInfo_details() {
		return info_details;
	}
	public void setInfo_details(String info_details) {
		this.info_details = info_details;
	}

	public String getInfo_date() {
		return info_date;
	}
	public void setInfo_date(String info_date) {
		this.info_date = info_date;
	}
	public String getClass_name() {
		return class_name;
	}
	public void setClass_name(String class_name) {
		this.class_name = class_name;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

}
