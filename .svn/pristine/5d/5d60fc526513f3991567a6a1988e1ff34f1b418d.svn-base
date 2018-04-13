package jp.terasoluna.thin.tutorial.web.transcosmos.form;

import java.util.Date;
import java.util.List;

import org.apache.struts.upload.FormFile;

import jp.terasoluna.fw.web.struts.form.ValidatorActionFormEx;
import jp.terasoluna.thin.tutorial.web.transcosmos.vo.JNTCIEquipHomePageVo;
import jp.terasoluna.thin.tutorial.web.transcosmos.vo.JNTCIEquipNoticeMg02Vo;
import jp.terasoluna.thin.tutorial.web.transcosmos.vo.JNTCIEquipNoticeMgVo;
import jp.terasoluna.thin.tutorial.web.transcosmos.vo.JNTCIEquipPostMessageVo;

public class JNTCIEquipHomePageForm extends ValidatorActionFormEx {
	private static final long serialVersionUID = 1L;

	private int view_id;
	private String class_name;

	private int info_id;
	private String info_title;
	private String info_details;
	private Date info_date;
	private String userId;
	private String user_name;
	private String flag;
	//sxh-add
		private String row = "10";
		private String startIndex = "0";
		private String totalCount = null;

		private FormFile uploadFile = null;

	public FormFile getUploadFile() {
			return uploadFile;
		}

		public void setUploadFile(FormFile uploadFile) {
			this.uploadFile = uploadFile;
		}


	public String getFlag() {
			return flag;
		}

		public void setFlag(String flag) {
			this.flag = flag;
		}

	public String getRow() {
			return row;
		}

		public void setRow(String row) {
			this.row = row;
		}

		public String getStartIndex() {
			return startIndex;
		}

		public void setStartIndex(String startIndex) {
			this.startIndex = startIndex;
		}

		public String getTotalCount() {
			return totalCount;
		}

		public void setTotalCount(String totalCount) {
			this.totalCount = totalCount;
		}

		public void setInfo_date(Date info_date) {
			this.info_date = info_date;
		}

	private String info_content;
	private String info_caption;
	private List<JNTCIEquipNoticeMgVo> noticeMg;
	private List<JNTCIEquipNoticeMg02Vo> noticeMg02;
	private List<JNTCIEquipPostMessageVo> postmessage;
	private List<JNTCIEquipHomePageVo> classList;



	public List<JNTCIEquipPostMessageVo> getPostmessage() {
		return postmessage;
	}

	public void setPostmessage(List<JNTCIEquipPostMessageVo> postmessage) {
		this.postmessage = postmessage;
	}

	public List<JNTCIEquipHomePageVo> getClassList() {
		return classList;
	}

	public void setClassList(List<JNTCIEquipHomePageVo> classList) {
		this.classList = classList;
	}

	public int getView_id() {
		return view_id;
	}

	public void setView_id(int view_id) {
		this.view_id = view_id;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getClass_name() {
		return class_name;
	}

	public void setClass_name(String class_name) {
		this.class_name = class_name;
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

	public String getInfo_content() {
		return info_content;
	}

	public void setInfo_content(String info_content) {
		this.info_content = info_content;
	}

	public String getInfo_caption() {
		return info_caption;
	}

	public void setInfo_caption(String info_caption) {
		this.info_caption = info_caption;
	}

	public List<JNTCIEquipNoticeMgVo> getNoticeMg() {
		return noticeMg;
	}

	public void setNoticeMg(List<JNTCIEquipNoticeMgVo> noticeMg) {
		this.noticeMg = noticeMg;
	}

	public List<JNTCIEquipNoticeMg02Vo> getNoticeMg02() {
		return noticeMg02;
	}

	public void setNoticeMg02(List<JNTCIEquipNoticeMg02Vo> noticeMg02) {
		this.noticeMg02 = noticeMg02;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

}
