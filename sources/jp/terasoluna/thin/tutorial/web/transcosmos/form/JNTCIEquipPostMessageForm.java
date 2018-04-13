package jp.terasoluna.thin.tutorial.web.transcosmos.form;

import java.util.Date;
import java.util.List;

import jp.terasoluna.fw.web.struts.form.ValidatorActionFormEx;
import jp.terasoluna.thin.tutorial.web.transcosmos.vo.JNTCIEquipHomePageVo;
import jp.terasoluna.thin.tutorial.web.transcosmos.vo.JNTCIEquipPostMessageVo;

@SuppressWarnings("serial")
public class JNTCIEquipPostMessageForm extends ValidatorActionFormEx{

	private int info_id;
	private String info_title;
	private int view_id;
	private String info_details;
	private Date info_date;
	private String userId;
	private List<JNTCIEquipHomePageVo> classList;
	private List<JNTCIEquipPostMessageVo> postmessage = null;


	public List<JNTCIEquipHomePageVo> getClassList() {
		return classList;
	}
	public void setClassList(List<JNTCIEquipHomePageVo> classList) {
		this.classList = classList;
	}
	public List<JNTCIEquipPostMessageVo> getPostmessage() {
		return postmessage;
	}
	public void setPostmessage(List<JNTCIEquipPostMessageVo> postmessage) {
		this.postmessage = postmessage;
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
	public int getView_id() {
		return view_id;
	}
	public void setView_id(int view_id) {
		this.view_id = view_id;
	}
	public String getInfo_details() {
		return info_details;
	}
	public void setInfo_details(String info_details) {
		this.info_details = info_details;
	}
	public Date getInfo_date() {
		this.info_date = new Date();//获取系统时间
		return info_date;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public void setInfo_date(Date info_date) {
		this.info_date = info_date;
	}

}
