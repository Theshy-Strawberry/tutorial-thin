package jp.terasoluna.thin.tutorial.web.transcosmos.dto;

import org.apache.struts.upload.FormFile;

public class JNTCIImportDataInput {



	private String jn_card;
	private String car_date;//打卡的时间（年月日 时分秒）
	private String work_date;//工作日期（年月日）
	private String time_count;
	private String userId;
	private FormFile file;
	private String file_path;


	public String getFile_path() {
		return file_path;
	}
	public void setFile_path(String file_path) {
		this.file_path = file_path;
	}
	public FormFile getFile() {
		return file;
	}
	public void setFile(FormFile file) {
		this.file = file;
	}
	public String getJn_card() {
		return jn_card;
	}
	public void setJn_card(String jn_card) {
		this.jn_card = jn_card;
	}

	public String getCar_date() {
		return car_date;
	}
	public void setCar_date(String car_date) {
		this.car_date = car_date;
	}
	public String getWork_date() {
		return work_date;
	}
	public void setWork_date(String work_date) {
		this.work_date = work_date;
	}
	public String getTime_count() {
		return time_count;
	}
	public void setTime_count(String time_count) {
		this.time_count = time_count;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}



}
