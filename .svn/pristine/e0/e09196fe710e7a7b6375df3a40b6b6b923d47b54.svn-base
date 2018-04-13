package jp.terasoluna.thin.tutorial.web.transcosmos.form;

import java.util.List;

import org.apache.struts.upload.FormFile;

import jp.terasoluna.fw.web.struts.form.ValidatorActionFormEx;
import jp.terasoluna.thin.tutorial.web.transcosmos.dto.JNTCIAttendance06GetTypeListDto;
import jp.terasoluna.thin.tutorial.web.transcosmos.dto.JNTCIAttendance06Input;

@SuppressWarnings("serial")
public class JNTCIAttendance06Form extends ValidatorActionFormEx{
	//ユーザーID
	private String jn_card = null;
	//補くじタイプ
	private String retroactive_type = null;
	private String reason_type = null;
	private String fileName = null;


	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}



	//隠す補くじタイプ
	private String retroactive_type_forwardval = null;
	//補くじ人
	private String retroactive_person = null;
	//出勤時間追加
	private String start_time_add = null;
	//退勤時間追加
	private String end_time_add = null;
	//補くじ理由
	private String retroactive_reason = null;
	private String tenpu_path = null;
	private FormFile uploadFile = null;

	public FormFile getUploadFile() {
			return uploadFile;
		}

		public void setUploadFile(FormFile uploadFile) {
			this.uploadFile = uploadFile;
		}

	public String getTenpu_path() {
		return tenpu_path;
	}
	public void setTenpu_path(String tenpu_path) {
		this.tenpu_path = tenpu_path;
	}



	//非暇時間いフラグ
	private String time_is_null_flag = null;

	//時間判断フラグ
	private String time_format_flag = null;
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
	private String user_id = null;
    private String user_name = null;
    private String leader = null;
    private String dept_id= null;
    private String retroactive_status = null;
    private String status_value = null;
    private String examine_id = null;
    private String examine_status = null;
    private String cd_code = null;
    private String retroactive_type_keepval = null;
    private String retro_examine_reason = null;
    private String dept_id_hide = null;
    private int updateQuFen;
    private int updateQuFen1;
    private String retroactive_id = null;
    private String typecode1;//补卡类型代码
    private String typecode2;


    public String getTypecode1() {
		return typecode1;
	}

	public void setTypecode1(String typecode1) {
		this.typecode1 = typecode1;
	}

	public String getTypecode2() {
		return typecode2;
	}

	public void setTypecode2(String typecode2) {
		this.typecode2 = typecode2;
	}

	public String getDept_id_hide() {
		return dept_id_hide;
	}
	public void setDept_id_hide(String dept_id_hide) {
		this.dept_id_hide = dept_id_hide;
	}


	/**
     * 表示行数。
     */
    private String row = "5";

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
	 * 補くじタイプタイププルダウンフレームの設定
	 */
	private List<JNTCIAttendance06GetTypeListDto> attendance06SelectRecOutput = null;
	private List<JNTCIAttendance06GetTypeListDto> attendance06SelectRecOutput02 = null;
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
	public String getJn_card() {
		return jn_card;
	}
	/*
	 * ユーザーIDの設定
	 */
	public void setJn_card(String jn_card) {
		this.jn_card = jn_card;
	}
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
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getLeader() {
		return leader;
	}
	public void setLeader(String leader) {
		this.leader = leader;
	}
	public String getDept_id() {
		return dept_id;
	}
	public void setDept_id(String dept_id) {
		this.dept_id = dept_id;
	}
	public String getRetroactive_status() {
		return retroactive_status;
	}
	public void setRetroactive_status(String retroactive_status) {
		this.retroactive_status = retroactive_status;
	}
	public String getStatus_value() {
		return status_value;
	}
	public void setStatus_value(String status_value) {
		this.status_value = status_value;
	}
	public String getExamine_id() {
		return examine_id;
	}
	public void setExamine_id(String examine_id) {
		this.examine_id = examine_id;
	}
	public String getExamine_status() {
		return examine_status;
	}
	public void setExamine_status(String examine_status) {
		this.examine_status = examine_status;
	}
	public String getCd_code() {
		return cd_code;
	}
	public void setCd_code(String cd_code) {
		this.cd_code = cd_code;
	}

	public String getTime_is_null_flag() {
		return time_is_null_flag;
	}
	public void setTime_is_null_flag(String time_is_null_flag) {
		this.time_is_null_flag = time_is_null_flag;
	}
	public String getRetroactive_type_keepval() {
		return retroactive_type_keepval;
	}
	public void setRetroactive_type_keepval(String retroactive_type_keepval) {
		this.retroactive_type_keepval = retroactive_type_keepval;
	}
	public String getRetroactive_type_forwardval() {
		return retroactive_type_forwardval;
	}
	public void setRetroactive_type_forwardval(String retroactive_type_forwardval) {
		this.retroactive_type_forwardval = retroactive_type_forwardval;
	}
	public String getTime_format_flag() {
		return time_format_flag;
	}
	public void setTime_format_flag(String time_format_flag) {
		this.time_format_flag = time_format_flag;
	}
	public String getRetro_examine_reason() {
		return retro_examine_reason;
	}
	public void setRetro_examine_reason(String retro_examine_reason) {
		this.retro_examine_reason = retro_examine_reason;
	}
	public List<JNTCIAttendance06GetTypeListDto> getAttendance06SelectRecOutput02() {
		return attendance06SelectRecOutput02;
	}
	public void setAttendance06SelectRecOutput02(
			List<JNTCIAttendance06GetTypeListDto> attendance06SelectRecOutput02) {
		this.attendance06SelectRecOutput02 = attendance06SelectRecOutput02;
	}
	public String getReason_type() {
		return reason_type;
	}
	public void setReason_type(String reason_type) {
		this.reason_type = reason_type;
	}
	public int getUpdateQuFen() {
		return updateQuFen;
	}
	public void setUpdateQuFen(int updateQuFen) {
		this.updateQuFen = updateQuFen;
	}
	public int getUpdateQuFen1() {
		return updateQuFen1;
	}
	public void setUpdateQuFen1(int updateQuFen1) {
		this.updateQuFen1 = updateQuFen1;
	}
	public String getRetroactive_id() {
		return retroactive_id;
	}
	public void setRetroactive_id(String retroactive_id) {
		this.retroactive_id = retroactive_id;
	}

}
