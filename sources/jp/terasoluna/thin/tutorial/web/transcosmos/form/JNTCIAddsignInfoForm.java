package jp.terasoluna.thin.tutorial.web.transcosmos.form;

import java.util.List;

import org.apache.struts.upload.FormFile;

import jp.terasoluna.fw.web.struts.form.ValidatorActionFormEx;
import jp.terasoluna.thin.tutorial.web.transcosmos.dto.JNTCIAttendance06GetTypeListDto;
import jp.terasoluna.thin.tutorial.web.transcosmos.dto.JNTCIAttendance06Input;
import jp.terasoluna.thin.tutorial.web.transcosmos.vo.JNTCIAddsignInfoVo;

public class JNTCIAddsignInfoForm extends ValidatorActionFormEx {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private String JN_CARD;
	private String JN_CARD_SEARCH;
	private String USER_NAME;
	private String k_name;
	private String person;
	private String RETROACTIVE_TYPE;
	private String RETROACTIVE_REASON;
	private String infoqueryId;
	private String caozuo;
	private String card_id;
	private String shencha;
	private String USER_NAME_SEARCH;
	private String cod;
	private String sureId_card;
	private String deleteId_c;
	private String mark;
	private String retroactive_auditss_search;
	private String retroactive_starttime_search;
	private String retroactive_endtime_search;
	private String leader;

	public String getLeader() {
		return leader;
	}
	public void setLeader(String leader) {
		this.leader = leader;
	}
	public String getRetroactive_starttime_search() {
		return retroactive_starttime_search;
	}
	public void setRetroactive_starttime_search(String retroactive_starttime_search) {
		this.retroactive_starttime_search = retroactive_starttime_search;
	}
	public String getRetroactive_endtime_search() {
		return retroactive_endtime_search;
	}
	public void setRetroactive_endtime_search(String retroactive_endtime_search) {
		this.retroactive_endtime_search = retroactive_endtime_search;
	}
	public String getRetroactive_auditss_search() {
		return retroactive_auditss_search;
	}
	public void setRetroactive_auditss_search(String retroactive_auditss_search) {
		this.retroactive_auditss_search = retroactive_auditss_search;
	}
	public String getMark() {
		return mark;
	}
	public void setMark(String mark) {
		this.mark = mark;
	}
	public String getDeleteId_c() {
		return deleteId_c;
	}
	public void setDeleteId_c(String deleteId_c) {
		this.deleteId_c = deleteId_c;
	}
	public String getSureId_card() {
		return sureId_card;
	}
	public void setSureId_card(String sureId_card) {
		this.sureId_card = sureId_card;
	}
	public String getCod() {
		return cod;
	}
	public void setCod(String cod) {
		this.cod = cod;
	}
	public String getUSER_NAME_SEARCH() {
		return USER_NAME_SEARCH;
	}
	public void setUSER_NAME_SEARCH(String uSER_NAME_SEARCH) {
		USER_NAME_SEARCH = uSER_NAME_SEARCH;
	}
	public String getShencha() {
		return shencha;
	}
	public void setShencha(String shencha) {
		this.shencha = shencha;
	}

	JNTCIAddsignInfoVo vo;
	 private String examine_status;
	 private String examine_reason;
	 private String RETROACTIVE_ID;
	 private String retroactive_type_hide;
	 private String flag_date_format;
	 private String deleteExtra_Id;
	 private String reason_type ;
	 private String retroactive_status ;
	   private String userName;
	   private String starttimeString;

		public String getStarttimeString() {
		return starttimeString;
	}
	public void setStarttimeString(String starttimeString) {
		this.starttimeString = starttimeString;
	}
		public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getRetroactive_status() {
		return retroactive_status;
	}
	public void setRetroactive_status(String retroactive_status) {
		this.retroactive_status = retroactive_status;
	}
	public String getReason_type() {
		return reason_type;
	}
	public void setReason_type(String reason_type) {
		this.reason_type = reason_type;
	}
	public String getDeleteExtra_Id() {
		return deleteExtra_Id;
	}
	public void setDeleteExtra_Id(String deleteExtra_Id) {
		this.deleteExtra_Id = deleteExtra_Id;
	}
	public String getFlag_date_format() {
		return flag_date_format;
	}
	public void setFlag_date_format(String flag_date_format) {
		this.flag_date_format = flag_date_format;
	}
	public String getRetroactive_type_hide() {
		return retroactive_type_hide;
	}
	public String getJN_CARD_SEARCH() {
		return JN_CARD_SEARCH;
	}
	public void setJN_CARD_SEARCH(String jN_CARD_SEARCH) {
		JN_CARD_SEARCH = jN_CARD_SEARCH;
	}
	public void setRetroactive_type_hide(String retroactive_type_hide) {
		this.retroactive_type_hide = retroactive_type_hide;
	}
	public String getExamine_status() {
		return examine_status;
	}
	public void setExamine_status(String examine_status) {
		this.examine_status = examine_status;
	}
	public String getExamine_reason() {
		return examine_reason;
	}
	public void setExamine_reason(String examine_reason) {
		this.examine_reason = examine_reason;
	}
	public String getRETROACTIVE_ID() {
		return RETROACTIVE_ID;
	}
	public void setRETROACTIVE_ID(String rETROACTIVE_ID) {
		RETROACTIVE_ID = rETROACTIVE_ID;
	}
	public JNTCIAddsignInfoVo getVo() {
		return vo;
	}
	public void setVo(JNTCIAddsignInfoVo vo) {
		this.vo = vo;
	}
	public String getCard_id() {
		return card_id;
	}
	public void setCard_id(String card_id) {
		this.card_id = card_id;
	}
	public String getCaozuo() {
		return caozuo;
	}
	public void setCaozuo(String caozuo) {
		this.caozuo = caozuo;
	}

	private List<JNTCIAddsignInfoVo> addsignInfoList;
	//繝ｦ繝ｼ繧ｶ繝ｼID
	/*	private String jn_card = null;*/
		//陬懊￥縺倥ち繧､繝�
		private String retroactive_type2 = null;
		//髫�☆陬懊￥縺倥ち繧､繝�
		private String retroactive_type1 = null;
		//陬懊￥縺倅ｺｺ
		private String retroactive_person = null;
		//蜃ｺ蜍､譎る俣霑ｽ蜉�
		private String start_time_add = null;
		private String start_time_add_search = null;
		//騾�共譎る俣霑ｽ蜉�
		private String end_time_add = null;
		//陬懊￥縺倡炊逕ｱ
		private String retroactive_reason = null;
		private String tenpu_path = null;
		public String getTenpu_path() {
			return tenpu_path;
		}
		public void setTenpu_path(String tenpu_path) {
			this.tenpu_path = tenpu_path;
		}
		private FormFile uploadFile = null;

		public FormFile getUploadFile() {
			return uploadFile;
		}
		public void setUploadFile(FormFile uploadFile) {
			this.uploadFile = uploadFile;
		}

		//髱樊嚊譎る俣縺�ヵ繝ｩ繧ｰ
		private String flag = null;
		//譎る俣蛻､譁ｭ繝輔Λ繧ｰ
		private String flag1 = null;
		//繝ｭ繧ｰ繧､繝ｳ閠�D
		private String userId = null;
		 //荳�ｦｧ逕ｻ髱｢縺ｧ菴ｿ逕ｨ縺吶ｋ
		private List<JNTCIAttendance06Input> attendance06ListOutput = null;
		//蜃ｺ蜍､譎る俣
		private String start_time = null;
		//騾�共譎る俣
		private String end_time = null;
		//謠仙�譎る俣
		private String sub_time = null;
		//陬懊￥縺�繧ｿ繧､繝励ヵ繝ｩ繧ｰ
		private String flagfortype = null;
		//蛻�勁繝輔Λ繧ｰ
		private String delete_flag = null;

		public String getStart_time_add_search() {
			return start_time_add_search;
		}
		public void setStart_time_add_search(String start_time_add_search) {
			this.start_time_add_search = start_time_add_search;
		}

		public String kj_name;
		public String cd_code;
	    public String getKj_name() {
			return kj_name;
		}
		public void setKj_name(String kj_name) {
			this.kj_name = kj_name;
		}
		public String getCd_code() {
			return cd_code;
		}
		public void setCd_code(String cd_code) {
			this.cd_code = cd_code;
		}

		private String row = "10";

		private String startIndex ="0";

		private String totalCount=null;



	    /*
		 * 陦ｨ遉ｺ陦梧焚縺ｮ蜿門ｾ�
		 */
	    public String getRow() {
			return row;
		}
	    /*
		 * 陦ｨ遉ｺ陦梧焚縺ｮ險ｭ螳�
		 */
		public void setRow(String row) {
			this.row = row;
		}
		/*
		 * 髢句ｧ九う繝ｳ繝�ャ繧ｯ繧ｹ縺ｮ蜿門ｾ�
		 */
		public String getStartIndex() {
			return startIndex;
		}
		/*
		 * 髢句ｧ九う繝ｳ繝�ャ繧ｯ繧ｹ縺ｮ險ｭ螳�
		 */
		public void setStartIndex(String startIndex) {
			this.startIndex = startIndex;
		}
		/*
		 * 蜈ｨ莉ｶ謨ｰ縺ｮ蜿門ｾ�
		 */
		public String getTotalCount() {
			return totalCount;
		}
		/*
		 * 蜈ｨ莉ｶ謨ｰ縺ｮ險ｭ螳�
		 */
		public void setTotalCount(String totalCount) {
			this.totalCount = totalCount;
		}

		/*
		 * 繝ｭ繧ｰ繧､繝ｳ閠�D縺ｮ蜿門ｾ�
		 */
		public String getUserId() {
			return userId;
		}
		/*
		 * 繝ｭ繧ｰ繧､繝ｳ閠�D縺ｮ險ｭ螳�
		 */
		public void setUserId(String userId) {
			this.userId = userId;
		}
		/*
		 * 髱樊嚊譎る俣縺�ヵ繝ｩ繧ｰ縺ｮ蜿門ｾ�
		 */
		public String getFlag() {
			return flag;
		}
		/*
		 * 髱樊嚊譎る俣縺�ヵ繝ｩ繧ｰ縺ｮ險ｭ螳�
		 */
		public void setFlag(String flag) {
			this.flag = flag;
		}
		/*
		 * 譎る俣蛻､譁ｭ繝輔Λ繧ｰ縺ｮ蜿門ｾ�
		 */
		public String getFlag1() {
			return flag1;
		}
		/*
		 * 譎る俣蛻､譁ｭ繝輔Λ繧ｰ縺ｮ險ｭ螳�
		 */
		public void setFlag1(String flag1) {
			this.flag1 = flag1;
		}
		/*
		 * 陬懊￥縺倥ち繧､繝励ち繧､繝励�繝ｫ繝�え繝ｳ繝輔Ξ繝ｼ繝��險ｭ螳�
		 */
		private List<JNTCIAttendance06GetTypeListDto> attendance06SelectRecOutput = null;
		/*
		 * 陬懊￥縺倥ち繧､繝励ち繧､繝励�繝ｫ繝�え繝ｳ繝輔Ξ繝ｼ繝��蜿門ｾ�
		 */
		public List<JNTCIAttendance06GetTypeListDto> getAttendance06SelectRecOutput() {
			return attendance06SelectRecOutput;
		}
		/*
		 * 陬懊￥縺倥ち繧､繝励ち繧､繝励�繝ｫ繝�え繝ｳ繝輔Ξ繝ｼ繝��險ｭ螳�
		 */
		public void setAttendance06SelectRecOutput(
				List<JNTCIAttendance06GetTypeListDto> attendance06SelectRecOutput) {
			this.attendance06SelectRecOutput = attendance06SelectRecOutput;
		}

		/*
		 * 繝ｦ繝ｼ繧ｶ繝ｼID縺ｮ蜿門ｾ�
		 */
		/*public String getJn_card() {
			return jn_card;
		}

		 * 繝ｦ繝ｼ繧ｶ繝ｼID縺ｮ險ｭ螳�

		public void setJn_card(String jn_card) {
			this.jn_card = jn_card;
		}*/
		/*
		 * 陬懊￥縺倥ち繧､繝励�蜿門ｾ�
		 */

		/*
		 * 陬懊￥縺倅ｺｺ縺ｮ蜿門ｾ�
		 */
		public String getRetroactive_person() {
			return retroactive_person;
		}
		public String getRetroactive_type2() {
			return retroactive_type2;
		}
		public void setRetroactive_type2(String retroactive_type2) {
			this.retroactive_type2 = retroactive_type2;
		}
		/*
		 * 陬懊￥縺倅ｺｺ縺ｮ險ｭ螳�
		 */
		public void setRetroactive_person(String retroactive_person) {
			this.retroactive_person = retroactive_person;
		}
		/*
		 * 蜃ｺ蜍､譎る俣霑ｽ蜉��蜿門ｾ�
		 */
		public String getStart_time_add() {
			return start_time_add;
		}
		/*
		 * 蜃ｺ蜍､譎る俣霑ｽ蜉��險ｭ螳�
		 */
		public void setStart_time_add(String start_time_add) {
			this.start_time_add = start_time_add;
		}
		/*
		 * 騾�共譎る俣霑ｽ蜉��蜿門ｾ�
		 */
		public String getEnd_time_add() {
			return end_time_add;
		}
		/*
		 * 騾�共譎る俣霑ｽ蜉��險ｭ螳�
		 */
		public void setEnd_time_add(String end_time_add) {
			this.end_time_add = end_time_add;
		}
		/*
		 * 陬懊￥縺倡炊逕ｱ縺ｮ蜿門ｾ�
		 */
		public String getRetroactive_reason() {
			return retroactive_reason;
		}

		/*
		 * 陬懊￥縺倡炊逕ｱ縺ｮ險ｭ螳�
		 */
		public void setRetroactive_reason(String retroactive_reason) {
			this.retroactive_reason = retroactive_reason;
		}
		/*
		 * 髫�☆陬懊￥縺倥ち繧､繝励�蜿門ｾ�
		 */
		public String getRetroactive_type1() {
			return retroactive_type1;
		}
		/*
		 * 髫�☆陬懊￥縺倥ち繧､繝励�險ｭ螳�
		 */
		public void setRetroactive_type1(String retroactive_type1) {
			this.retroactive_type1 = retroactive_type1;
		}
		/*
		 * 荳�ｦｧ逕ｻ髱｢縺ｧ菴ｿ逕ｨ縺吶ｋ縺ｮ蜿門ｾ�
		 */
		public List<JNTCIAttendance06Input> getAttendance06ListOutput() {
			return attendance06ListOutput;
		}
		/*
		 * 荳�ｦｧ逕ｻ髱｢縺ｧ菴ｿ逕ｨ縺吶ｋ縺ｮ險ｭ螳�
		 */
		public void setAttendance06ListOutput(
				List<JNTCIAttendance06Input> attendance06ListOutput) {
			this.attendance06ListOutput = attendance06ListOutput;
		}
		/*
		 * 蜃ｺ蜍､譎る俣縺ｮ蜿門ｾ�
		 */
		public String getStart_time() {
			return start_time;
		}
		/*
		 * 蜃ｺ蜍､譎る俣縺ｮ險ｭ螳�
		 */
		public void setStart_time(String start_time) {
			this.start_time = start_time;
		}
		/*
		 * 騾�共譎る俣縺ｮ蜿門ｾ�
		 */
		public String getEnd_time() {
			return end_time;
		}
		/*
		 * 騾�共譎る俣縺ｮ險ｭ螳�
		 */
		public void setEnd_time(String end_time) {
			this.end_time = end_time;
		}
		/*
		 * 謠仙�譎る俣縺ｮ蜿門ｾ�
		 */
		public String getSub_time() {
			return sub_time;
		}
		/*
		 * 謠仙�譎る俣縺ｮ險ｭ螳�
		 */
		public void setSub_time(String sub_time) {
			this.sub_time = sub_time;
		}
		/*
		 * 陬懊￥縺�繧ｿ繧､繝励ヵ繝ｩ繧ｰ縺ｮ蜿門ｾ�
		 */
		public String getFlagfortype() {
			return flagfortype;
		}
		/*
		 * 陬懊￥縺�繧ｿ繧､繝励ヵ繝ｩ繧ｰ縺ｮ險ｭ螳�
		 */
		public void setFlagfortype(String flagfortype) {
			this.flagfortype = flagfortype;
		}
		/*
		 * 蛻�勁繝輔Λ繧ｰ縺ｮ蜿門ｾ�
		 */
		public String getDelete_flag() {
			return delete_flag;
		}
		/*
		 * 蛻�勁繝輔Λ繧ｰ縺ｮ險ｭ螳�
		 */
		public void setDelete_flag(String delete_flag) {
			this.delete_flag = delete_flag;
		}

	public String getJN_CARD() {
		return JN_CARD;
	}
	public void setJN_CARD(String jN_CARD) {
		JN_CARD = jN_CARD;
	}
	public String getRETROACTIVE_TYPE() {
		return RETROACTIVE_TYPE;
	}
	public void setRETROACTIVE_TYPE(String rETROACTIVE_TYPE) {
		RETROACTIVE_TYPE = rETROACTIVE_TYPE;
	}
	public String getRETROACTIVE_REASON() {
		return RETROACTIVE_REASON;
	}
	public void setRETROACTIVE_REASON(String rETROACTIVE_REASON) {
		RETROACTIVE_REASON = rETROACTIVE_REASON;
	}

	public List<JNTCIAddsignInfoVo> getAddsignInfoList() {
		return addsignInfoList;
	}
	public void setAddsignInfoList(List<JNTCIAddsignInfoVo> addsignInfoList) {
		this.addsignInfoList = addsignInfoList;
	}
	public String getInfoqueryId() {
		return infoqueryId;
	}
	public void setInfoqueryId(String infoqueryId) {
		this.infoqueryId = infoqueryId;
	}

	public String getUSER_NAME() {
		return USER_NAME;
	}
	public void setUSER_NAME(String uSER_NAME) {
		USER_NAME = uSER_NAME;
	}
	public String getK_name() {
		return k_name;
	}
	public void setK_name(String k_name) {
		this.k_name = k_name;
	}
	public String getPerson() {
		return person;
	}
	public void setPerson(String person) {
		this.person = person;
	}



}
