package jp.terasoluna.thin.tutorial.web.transcosmos.dto;

import java.util.Date;

import org.apache.struts.upload.FormFile;

public class JNTCLOvertimePostMessageInput {

	private int info_id;
	private String info_title;
	private int view_id;
	private String info_details;
	private String userId;
	private Date info_date;
//sxh-add
	private String totalCount = null;
	private String startIndex;
	private String row = null;
	//图片上传
	private FormFile uploadFile=null;
	private String tenpu_path=null;



	public String getTenpu_path() {
		return tenpu_path;
	}
	public void setTenpu_path(String tenpu_path) {
		this.tenpu_path = tenpu_path;
	}
	public FormFile getUploadFile() {
		return uploadFile;
	}
	public void setUploadFile(FormFile uploadFile) {
		this.uploadFile = uploadFile;
	}
	public String getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(String totalCount) {
		this.totalCount = totalCount;
	}
	public String getStartIndex() {
		return startIndex;
	}
	public void setStartIndex(String startIndex) {
		this.startIndex = startIndex;
	}
	public String getRow() {
		return row;
	}
	public void setRow(String row) {
		this.row = row;
	}
	public int getInfo_id() {
		return info_id;
	}
	public void setInfo_id(int info_id) {
		this.info_id = info_id;
	}
	public int getView_id() {
		return view_id;
	}
	public void setView_id(int view_id) {
		this.view_id = view_id;
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
	public Date getInfo_date() {
		return info_date;
	}
	public void setInfo_date(Date info_date) {
		this.info_date = info_date;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}

}
