package jp.terasoluna.thin.tutorial.web.transcosmos.dto;

import java.util.List;

import jp.terasoluna.fw.web.struts.form.ValidatorActionFormEx;

public class JNTCIAttendance03Dto extends ValidatorActionFormEx{

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	public Integer leaveId;// 休暇ID

	public String jnCard;// ユーザID

	public String name;// ユーザ名称

	public String deptId;// 所属部門ID

	public String deptName; // 所属部門名前

	public String projectPm;// プロジェクトPM

	public String pmEmail;//pm email 号

	public String leaveType;// 休暇種類

	public String leaveStartTime;// 休暇開始時間

	public String leaveEndTime;// 休暇終了時間

	public String leaveTotalTime;// 合計時長

	public String leaveReason;// 休暇理由

	public String leaveSubtime;// 提交時間
	public String examinePerson;
	private String applicationtype;

	private String daiyuzhen;//代玉珍的邮箱

	public String getDaiyuzhen() {
		return daiyuzhen;
	}
	public void setDaiyuzhen(String daiyuzhen) {
		this.daiyuzhen = daiyuzhen;
	}
	public String getApplicationtype() {
		return applicationtype;
	}
	public void setApplicationtype(String applicationtype) {
		this.applicationtype = applicationtype;
	}
	public String myEmail;

	public String getExaminePerson() {
		return examinePerson;
	}

	public void setExaminePerson(String examinePerson) {
		this.examinePerson = examinePerson;
	}

	public String getPmEmail() {
		return pmEmail;
	}

	public void setPmEmail(String pmEmail) {
		this.pmEmail = pmEmail;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}








	public String getMyEmail() {
		return myEmail;
	}

	public void setMyEmail(String myEmail) {
		this.myEmail = myEmail;
	}







	public String updTime; // 更新时间

	public String preserVation;// 保存 ボタン

	public String cdCode; // 部門番号

	public String kjName; //部門名

	public String leaveCode; // 休暇 を休む タイプ

	public String leaveName; // 休暇 を休む タイプ

	public String detailDate;//总节假日

	public  List<JNTCIAttendance03Dto> detailDateList;//总节假日集合

    public List<JNTCIAttendance03Dto> getDetailDateList() {
		return detailDateList;
	}

	public void setDetailDateList(List<JNTCIAttendance03Dto> detailDateList) {
		this.detailDateList = detailDateList;
	}

	public String getDetailDate() {
		return detailDate;
	}

	public void setDetailDate(String detailDate) {
		this.detailDate = detailDate;
	}

	public String examineId;   //審査人Id

	public String examineName;// 審査人名前

	public String examineStatus;

	public double remainDays;
	public String leaveTypeTime;//数据库婚假总时间

	public int countNum;//查询数据库中婚假的次数

	public int getCountNum() {
		return countNum;
	}

	public void setCountNum(int countNum) {
		this.countNum = countNum;
	}

	public String getLeaveTypeTime() {
		return leaveTypeTime;
	}

	public void setLeaveTypeTime(String leaveTypeTime) {
		this.leaveTypeTime = leaveTypeTime;
	}


	public String getExamineName() {
		return examineName;
	}

	public void setExamineName(String examineName) {
		this.examineName = examineName;
	}

	public String getExamineId() {
		return examineId;
	}

	public void setExamineId(String examineId) {
		this.examineId = examineId;
	}

	public double getRemainDays() {
		return remainDays;
	}

	public void setRemainDays(double remainDays) {
		this.remainDays = remainDays;
	}

	public List<JNTCIAttendance03Dto> leaveTypeList; // 休暇タイプ集合


	public String getExamineStatus() {
		return examineStatus;
	}

	public void setExamineStatus(String examineStatus) {
		this.examineStatus = examineStatus;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getLeaveCode() {
		return leaveCode;
	}

	public void setLeaveCode(String leaveCode) {
		this.leaveCode = leaveCode;
	}

	public String getLeaveName() {
		return leaveName;
	}

	public void setLeaveName(String leaveName) {
		this.leaveName = leaveName;
	}

	public List<JNTCIAttendance03Dto> getLeaveTypeList() {
		return leaveTypeList;
	}

	public void setLeaveTypeList(List<JNTCIAttendance03Dto> leaveTypeList) {
		this.leaveTypeList = leaveTypeList;
	}

	public String getCdCode() {
		return cdCode;
	}

	public void setCdCode(String cdCode) {
		this.cdCode = cdCode;
	}

	public String getKjName() {
		return kjName;
	}

	public void setKjName(String kjName) {
		this.kjName = kjName;
	}

	public String getPreserVation() {
		return preserVation;
	}

	public void setPreserVation(String preserVation) {
		this.preserVation = preserVation;
	}

	public String getUpdTime() {
		return updTime;
	}
	public void setUpdTime(String updTime) {
		this.updTime = updTime;
	}
	public String getLeaveSubtime() {
		return leaveSubtime;
	}
	public void setLeaveSubtime(String leaveSubtime) {
		this.leaveSubtime = leaveSubtime;
	}
	public Integer getLeaveId() {
		return leaveId;
	}
	public void setLeaveId(Integer leaveId) {
		this.leaveId = leaveId;
	}
	public String getJnCard() {
		return jnCard;
	}

	public void setJnCard(String jnCard) {
		this.jnCard = jnCard;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDeptId() {
		return deptId;
	}

	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}

	public String getProjectPm() {
		return projectPm;
	}

	public void setProjectPm(String projectPm) {
		this.projectPm = projectPm;
	}

	public String getLeaveType() {
		return leaveType;
	}

	public void setLeaveType(String leaveType) {
		this.leaveType = leaveType;
	}

	public String getLeaveTotalTime() {
		return leaveTotalTime;
	}

	public String getLeaveStartTime() {
		return leaveStartTime;
	}
	public void setLeaveStartTime(String leaveStartTime) {
		this.leaveStartTime = leaveStartTime;
	}
	public String getLeaveEndTime() {
		return leaveEndTime;
	}
	public void setLeaveEndTime(String leaveEndTime) {
		this.leaveEndTime = leaveEndTime;
	}
	public void setLeaveTotalTime(String leaveTotalTime) {
		this.leaveTotalTime = leaveTotalTime;
	}

	public String getLeaveReason() {
		return leaveReason;
	}

	public void setLeaveReason(String leaveReason) {
		this.leaveReason = leaveReason;
	}
}