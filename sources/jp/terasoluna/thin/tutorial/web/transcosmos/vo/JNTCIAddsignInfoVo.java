package jp.terasoluna.thin.tutorial.web.transcosmos.vo;

import java.util.List;

import org.apache.struts.upload.FormFile;

import jp.terasoluna.thin.tutorial.web.transcosmos.dto.JNTCIAttendance06GetTypeListDto;
import jp.terasoluna.thin.tutorial.web.transcosmos.dto.JNTCIAttendance06Input;

public class JNTCIAddsignInfoVo {
	private String JN_CARD;
	private String JN_CARD_SEARCH;
	private String USER_NAME;

	private String k_name;
	private String person;
	private String shencha;
	private String status;
	private String RETROACTIVE_ID;
	List<JNTCIAddsignInfoVo> gerenList;
	private String reason_type ;
	private String RETROACTIVE_STATUS;
	private String retroactive_type_hide;
    private FormFile uploadFile=null;
    private String retroactive_auditss_search;
    private String retroactive_starttime_search;
    private String retroactive_endtime_search;


	public String getRetroactive_auditss_search() {
		return retroactive_auditss_search;
	}
	public void setRetroactive_auditss_search(String retroactive_auditss_search) {
		this.retroactive_auditss_search = retroactive_auditss_search;
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
	public FormFile getUploadFile() {
			return uploadFile;
		}
		public void setUploadFile(FormFile uploadFile) {
			this.uploadFile = uploadFile;
		}
	public String getRetroactive_type_hide() {
		return retroactive_type_hide;
	}
	public void setRetroactive_type_hide(String retroactive_type_hide) {
		this.retroactive_type_hide = retroactive_type_hide;
	}
	public String getRETROACTIVE_STATUS() {
		return RETROACTIVE_STATUS;
	}
	public void setRETROACTIVE_STATUS(String retroactive_status) {
		RETROACTIVE_STATUS = retroactive_status;
	}
	public String getReason_type() {
		return reason_type;
	}
	public void setReason_type(String reason_type) {
		this.reason_type = reason_type;
	}
	public String getJN_CARD_SEARCH() {
		return JN_CARD_SEARCH;
	}
	public void setJN_CARD_SEARCH(String jN_CARD_SEARCH) {
		JN_CARD_SEARCH = jN_CARD_SEARCH;
	}
	public List<JNTCIAddsignInfoVo> getGerenList() {
		return gerenList;
	}
	public void setGerenList(List<JNTCIAddsignInfoVo> gerenList) {
		this.gerenList = gerenList;
	}
	public String getRETROACTIVE_ID() {
		return RETROACTIVE_ID;
	}
	public void setRETROACTIVE_ID(String rETROACTIVE_ID) {
		RETROACTIVE_ID = rETROACTIVE_ID;
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
	private String RETROACTIVE_TYPE;
	private String SUB_TIME;
	private String UPD_TIME;
	private String RETROACTIVE_REASON;
	private String START_TIME_ADD;
	private String END_TIME_ADD;
	private String infoqueryId;
	//ユーザーID
			//private String jn_card = null;
			//補くじタイプ
			private String retroactive_type = null;
			//隠す補くじタイプ
			private String retroactive_type1 = null;
			//補くじ人
			private String retroactive_person = null;
			//出勤時間追加
			private String start_time_add = null;
			//退勤時間追加
			private String end_time_add = null;
			//補くじ理由
			private String retroactive_reason = null;
			private String tenpu_path = null;
			public String getTenpu_path() {
				return tenpu_path;
			}
			public void setTenpu_path(String tenpu_path) {
				this.tenpu_path = tenpu_path;
			}
			//非暇時間いフラグ
			private String flag = null;
			//時間判断フラグ
			private String flag1 = null;
			//ログイン者ID
			private String userId = null;
			 //一覧画面で使用する
			private List<JNTCIAttendance06Input> attendance06ListOutput = null;
			//出勤時間
			private String start_time = null;
			//退勤時間
			private String end_time = null;
			//提出時間
			private String sub_time = null;
			//補くじ タイプフラグ
			private String flagfortype = null;
			//删除フラグ
			private String delete_flag = null;

		    /**
		     * 表示行数。
		     */
		    private String row = "1";

		    /**
		     * 開始インデックス。
		     */
		    private String startIndex ="0";

		    /**
		     * 全件数。
		     */
		    private String totalCount = null;


		    /*
			 * 表示行数の取得
			 */
		    public String getRow() {
				return row;
			}
		    /*
			 * 表示行数の設定
			 */
			public void setRow(String row) {
				this.row = row;
			}
			/*
			 * 開始インデックスの取得
			 */
			public String getStartIndex() {
				return startIndex;
			}
			/*
			 * 開始インデックスの設定
			 */
			public void setStartIndex(String startIndex) {
				this.startIndex = startIndex;
			}
			/*
			 * 全件数の取得
			 */
			public String getTotalCount() {
				return totalCount;
			}
			/*
			 * 全件数の設定
			 */
			public void setTotalCount(String totalCount) {
				this.totalCount = totalCount;
			}

			/*
			 * ログイン者IDの取得
			 */
			public String getUserId() {
				return userId;
			}
			/*
			 * ログイン者IDの設定
			 */
			public void setUserId(String userId) {
				this.userId = userId;
			}
			/*
			 * 非暇時間いフラグの取得
			 */
			public String getFlag() {
				return flag;
			}
			/*
			 * 非暇時間いフラグの設定
			 */
			public void setFlag(String flag) {
				this.flag = flag;
			}
			/*
			 * 時間判断フラグの取得
			 */
			public String getFlag1() {
				return flag1;
			}
			/*
			 * 時間判断フラグの設定
			 */
			public void setFlag1(String flag1) {
				this.flag1 = flag1;
			}
			/*
			 * 補くじタイプタイププルダウンフレームの設定
			 */
			private List<JNTCIAttendance06GetTypeListDto> attendance06SelectRecOutput = null;
			/*
			 * 補くじタイプタイププルダウンフレームの取得
			 */
			public List<JNTCIAttendance06GetTypeListDto> getAttendance06SelectRecOutput() {
				return attendance06SelectRecOutput;
			}
			/*
			 * 補くじタイプタイププルダウンフレームの設定
			 */
			public void setAttendance06SelectRecOutput(
					List<JNTCIAttendance06GetTypeListDto> attendance06SelectRecOutput) {
				this.attendance06SelectRecOutput = attendance06SelectRecOutput;
			}

			/*
			 * ユーザーIDの取得
			 */
		/*	public String getJn_card() {
				return jn_card;
			}

			 * ユーザーIDの設定

			public void setJn_card(String jn_card) {
				this.jn_card = jn_card;
			}*/
			/*
			 * 補くじタイプの取得
			 */
			public String getRetroactive_type() {
				return retroactive_type;
			}
			/*
			 * 補くじタイプの設定
			 */
			public void setRetroactive_type(String retroactive_type) {
				this.retroactive_type = retroactive_type;
			}
			/*
			 * 補くじ人の取得
			 */
			public String getRetroactive_person() {
				return retroactive_person;
			}
			/*
			 * 補くじ人の設定
			 */
			public void setRetroactive_person(String retroactive_person) {
				this.retroactive_person = retroactive_person;
			}
			/*
			 * 出勤時間追加の取得
			 */
			public String getStart_time_add() {
				return start_time_add;
			}
			/*
			 * 出勤時間追加の設定
			 */
			public void setStart_time_add(String start_time_add) {
				this.start_time_add = start_time_add;
			}
			/*
			 * 退勤時間追加の取得
			 */
			public String getEnd_time_add() {
				return end_time_add;
			}
			/*
			 * 退勤時間追加の設定
			 */
			public void setEnd_time_add(String end_time_add) {
				this.end_time_add = end_time_add;
			}
			/*
			 * 補くじ理由の取得
			 */
			public String getRetroactive_reason() {
				return retroactive_reason;
			}

			/*
			 * 補くじ理由の設定
			 */
			public void setRetroactive_reason(String retroactive_reason) {
				this.retroactive_reason = retroactive_reason;
			}
			/*
			 * 隠す補くじタイプの取得
			 */
			public String getRetroactive_type1() {
				return retroactive_type1;
			}
			/*
			 * 隠す補くじタイプの設定
			 */
			public void setRetroactive_type1(String retroactive_type1) {
				this.retroactive_type1 = retroactive_type1;
			}
			/*
			 * 一覧画面で使用するの取得
			 */
			public List<JNTCIAttendance06Input> getAttendance06ListOutput() {
				return attendance06ListOutput;
			}
			/*
			 * 一覧画面で使用するの設定
			 */
			public void setAttendance06ListOutput(
					List<JNTCIAttendance06Input> attendance06ListOutput) {
				this.attendance06ListOutput = attendance06ListOutput;
			}
			/*
			 * 出勤時間の取得
			 */
			public String getStart_time() {
				return start_time;
			}
			/*
			 * 出勤時間の設定
			 */
			public void setStart_time(String start_time) {
				this.start_time = start_time;
			}
			/*
			 * 退勤時間の取得
			 */
			public String getEnd_time() {
				return end_time;
			}
			/*
			 * 退勤時間の設定
			 */
			public void setEnd_time(String end_time) {
				this.end_time = end_time;
			}
			/*
			 * 提出時間の取得
			 */
			public String getSub_time() {
				return sub_time;
			}
			/*
			 * 提出時間の設定
			 */
			public void setSub_time(String sub_time) {
				this.sub_time = sub_time;
			}
			/*
			 * 補くじ タイプフラグの取得
			 */
			public String getFlagfortype() {
				return flagfortype;
			}
			/*
			 * 補くじ タイプフラグの設定
			 */
			public void setFlagfortype(String flagfortype) {
				this.flagfortype = flagfortype;
			}
			/*
			 * 删除フラグの取得
			 */
			public String getDelete_flag() {
				return delete_flag;
			}
			/*
			 * 删除フラグの設定
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
	public String getSUB_TIME() {
		return SUB_TIME;
	}
	public void setSUB_TIME(String sUB_TIME) {
		SUB_TIME = sUB_TIME;
	}
	public String getUPD_TIME() {
		return UPD_TIME;
	}
	public void setUPD_TIME(String uPD_TIME) {
		UPD_TIME = uPD_TIME;
	}
	public String getRETROACTIVE_REASON() {
		return RETROACTIVE_REASON;
	}
	public void setRETROACTIVE_REASON(String rETROACTIVE_REASON) {
		RETROACTIVE_REASON = rETROACTIVE_REASON;
	}
	public String getSTART_TIME_ADD() {
		return START_TIME_ADD;
	}
	public void setSTART_TIME_ADD(String sTART_TIME_ADD) {
		START_TIME_ADD = sTART_TIME_ADD;
	}
	public String getEND_TIME_ADD() {
		return END_TIME_ADD;
	}
	public void setEND_TIME_ADD(String eND_TIME_ADD) {
		END_TIME_ADD = eND_TIME_ADD;
	}
	public String getInfoqueryId() {
		return infoqueryId;
	}
	public void setInfoqueryId(String infoqueryId) {
		this.infoqueryId = infoqueryId;
	}
	public String getShencha() {
		return shencha;
	}
	public void setShencha(String shencha) {
		this.shencha = shencha;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	private String USER_NAME_SEARCH;
	private String retroactive_type2;

	public String getRetroactive_type2() {
		return retroactive_type2;
	}
	public void setRetroactive_type2(String retroactive_type2) {
		this.retroactive_type2 = retroactive_type2;
	}
	public String getUSER_NAME_SEARCH() {
		return USER_NAME_SEARCH;
	}
	public void setUSER_NAME_SEARCH(String uSER_NAME_SEARCH) {
		USER_NAME_SEARCH = uSER_NAME_SEARCH;
	}
}
