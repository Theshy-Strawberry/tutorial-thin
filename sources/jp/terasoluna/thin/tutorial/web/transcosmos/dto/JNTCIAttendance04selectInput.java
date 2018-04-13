package jp.terasoluna.thin.tutorial.web.transcosmos.dto;

public class JNTCIAttendance04selectInput {
	private String  jn_card_serch;
	private String  name_serch;
	private String  dept_id_serch;
	private String  leave_starttime_serch;
	private String  leave_endtime_serch;
	private String  leave_type_serch;
	private String  application_type_serch;
	private String  examine_status_serch;
	private String mark;

	public String getMark() {
		return mark;
	}

	public void setMark(String mark) {
		this.mark = mark;
	}
	private String userId;// 获取当前登录用户Id
	private String deleteAllId;

	public String getDeleteAllId() {
		return deleteAllId;
	}

	public void setDeleteAllId(String deleteAllId) {
		this.deleteAllId = deleteAllId;
	}
	private String admitAllId;// 一括承认

	private String unadmitAllId;// 一括不承认

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getAdmitAllId() {
		return admitAllId;
	}

	public void setAdmitAllId(String admitAllId) {
		this.admitAllId = admitAllId;
	}

	public String getUnadmitAllId() {
		return unadmitAllId;
	}

	public void setUnadmitAllId(String unadmitAllId) {
		this.unadmitAllId = unadmitAllId;
	}
	// 行
	private String row = null;
	// 始め件数
	private String startIndex = null;
	// 済南カード
	private String jn_card = null;
	// 名前
	private String name = null;
	// 休暇開始時間
	private String leave_starttime = null;
	// 休暇終了時間
	private String leave_endtime = null;
	// 休暇類型
	private String leave_type = null;
	//休暇類型編號
	private String type_leave=null;
	// 所属部門ID
	private String dept_id = null;
	// 状態
	private String examine_status = null;
	// 紙の資料が必要なのかどうか
	private String examine_paper_fg = null;

	public String getExamine_paper_fg() {
		return examine_paper_fg;
	}

	public void setExamine_paper_fg(String examine_paper_fg) {
		this.examine_paper_fg = examine_paper_fg;
	}
    private String applicationtype;
	public String getApplicationtype() {
		return applicationtype;
	}
	public void setApplicationtype(String applicationtype) {
		this.applicationtype = applicationtype;
	}
private String application_type;

	public String getApplication_type() {
		return application_type;
	}
	public void setApplication_type(String application_type) {
		this.application_type = application_type;
	}
	private String leader = null;
	private String flag = null;
	private String cod = null;
	private String userName = null;

	private String examineStatus;
	private Integer leaveId;

	public Integer getLeaveId() {
		return leaveId;
	}

	public void setLeaveId(Integer leaveId) {
		this.leaveId = leaveId;
	}

	public String getExamineStatus() {
		return examineStatus;
	}

	public void setExamineStatus(String examineStatus) {
		this.examineStatus = examineStatus;
	}



	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getCod() {
		return cod;
	}

	public void setCod(String cod) {
		this.cod = cod;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public String getLeader() {
		return leader;
	}

	public void setLeader(String leader) {
		this.leader = leader;
	}

	/*
	 * 状態の取得
	 */
	public String getExamine_status() {
		return examine_status;
	}

	/*
	 * 状態の設定
	 */
	public void setExamine_status(String examine_status) {
		this.examine_status = examine_status;
	}

	/*
	 * 行の取得
	 */

	public String getRow() {
		return row;
	}

	public String getJn_card_serch() {
		return jn_card_serch;
	}

	public void setJn_card_serch(String jn_card_serch) {
		this.jn_card_serch = jn_card_serch;
	}

	public String getName_serch() {
		return name_serch;
	}

	public void setName_serch(String name_serch) {
		this.name_serch = name_serch;
	}

	public String getDept_id_serch() {
		return dept_id_serch;
	}

	public void setDept_id_serch(String dept_id_serch) {
		this.dept_id_serch = dept_id_serch;
	}

	public String getLeave_starttime_serch() {
		return leave_starttime_serch;
	}

	public void setLeave_starttime_serch(String leave_starttime_serch) {
		this.leave_starttime_serch = leave_starttime_serch;
	}

	public String getLeave_endtime_serch() {
		return leave_endtime_serch;
	}

	public void setLeave_endtime_serch(String leave_endtime_serch) {
		this.leave_endtime_serch = leave_endtime_serch;
	}

	public String getLeave_type_serch() {
		return leave_type_serch;
	}

	public void setLeave_type_serch(String leave_type_serch) {
		this.leave_type_serch = leave_type_serch;
	}

	public String getApplication_type_serch() {
		return application_type_serch;
	}

	public void setApplication_type_serch(String application_type_serch) {
		this.application_type_serch = application_type_serch;
	}

	public String getExamine_status_serch() {
		return examine_status_serch;
	}

	public void setExamine_status_serch(String examine_status_serch) {
		this.examine_status_serch = examine_status_serch;
	}

	/*
	 * 行の設定
	 */
	public void setRow(String row) {
		this.row = row;
	}

	/*
	 * 始め件数の取得
	 */
	public String getStartIndex() {
		return startIndex;
	}

	/*
	 * 始め件数の設定
	 */
	public void setStartIndex(String startIndex) {
		this.startIndex = startIndex;
	}

	/*
	 * 済南カードの取得
	 */
	public String getJn_card() {
		return jn_card;
	}

	/*
	 * 済南カードの設定
	 */
	public void setJn_card(String jn_card) {
		this.jn_card = jn_card;
	}

	/*
	 * 名前の取得
	 */
	public String getName() {
		return name;
	}

	/*
	 * 名前の設定
	 */
	public void setName(String name) {
		this.name = name;
	}

	/*
	 * 休暇開始時間の取得
	 */
	public String getLeave_starttime() {
		return leave_starttime;
	}

	/*
	 * 休暇開始時間の設定
	 */
	public void setLeave_starttime(String leave_starttime) {
		this.leave_starttime = leave_starttime;
	}

	/*
	 * 休暇終了時間の取得
	 */
	public String getLeave_endtime() {
		return leave_endtime;
	}

	/*
	 * 休暇終了時間の設定
	 */
	public void setLeave_endtime(String leave_endtime) {
		this.leave_endtime = leave_endtime;
	}

	/*
	 * 休暇類型の取得
	 */
	public String getLeave_type() {
		return leave_type;
	}

	/*
	 * 休暇類型の設定
	 */
	public void setLeave_type(String leave_type) {
		this.leave_type = leave_type;
	}
	/*
	 * 休暇類型編號の取得
	 */
	public String getType_leave() {
		return type_leave;
	}
	/*
	 * 休暇類型編號の設定
	 */
	public void setType_leave(String type_leave) {
		this.type_leave = type_leave;
	}

	/*
	 * 所属部門IDの取得
	 */
	public String getDept_id() {
		return dept_id;
	}

	/*
	 * 所属部門IDの設定
	 */
	public void setDept_id(String dept_id) {
		this.dept_id = dept_id;
	}

}
