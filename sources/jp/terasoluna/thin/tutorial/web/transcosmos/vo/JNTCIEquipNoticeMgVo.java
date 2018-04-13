package jp.terasoluna.thin.tutorial.web.transcosmos.vo;

public class JNTCIEquipNoticeMgVo {

	private int info_id;
	private String info_title;
	private String info_details;
	private String info_date;
	private String userId;
	private String totalCount;

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
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(String totalCount) {
		this.totalCount = totalCount;
	}

}
