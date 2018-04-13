package jp.terasoluna.thin.tutorial.web.transcosmos.form;

import java.util.Date;
import java.util.List;

import jp.terasoluna.fw.web.struts.form.ValidatorActionFormEx;
import jp.terasoluna.thin.tutorial.web.transcosmos.dto.JNTCIAttendanceSelect03Dto;

public class JNTCIAttendanceSelect03Form extends ValidatorActionFormEx{

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	public Integer leaveId;// 休暇ID

	public String jnCard;// ユーザID

	public String name;// ユーザ名称

	public String deptId;// 所属部門

	public String projectPm;// プロジェクトPM

	public String leaveType;// 休暇種類

	public Date leaveStartTime;// 休暇開始時間

	public Date leaveEndTime;// 休暇終了時間

	public String leaveTotalTime;// 合計時長

	public String leaveReason;// 休暇理由

	public Date leaveSubtime;// 提交時間

	public Integer examineTime;// 殘業時長

	public String examineStatus;// 審査状態

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


	public Date getLeaveStartTime() {
		return leaveStartTime;
	}

	public void setLeaveStartTime(Date leaveStartTime) {
		this.leaveStartTime = leaveStartTime;
	}

	public Date getLeaveEndTime() {
		return leaveEndTime;
	}

	public void setLeaveEndTime(Date leaveEndTime) {
		this.leaveEndTime = leaveEndTime;
	}

	public String getLeaveTotalTime() {
		return leaveTotalTime;
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

	public Date getLeaveSubtime() {
		return leaveSubtime;
	}

	public void setLeaveSubtime(Date leaveSubtime) {
		this.leaveSubtime = leaveSubtime;
	}

	public Integer getExamineTime() {
		return examineTime;
	}

	public void setExamineTime(Integer examineTime) {
		this.examineTime = examineTime;
	}

	public String getExamineStatus() {
		return examineStatus;
	}

	public void setExamineStatus(String examineStatus) {
		this.examineStatus = examineStatus;
	}
	private List<JNTCIAttendanceSelect03Dto> jntciAttendanceSelect03Dto = null;

	public List<JNTCIAttendanceSelect03Dto> getJntciAttendanceSelect03Dto() {
		return jntciAttendanceSelect03Dto;
	}

	public void setJntciAttendanceSelect03Dto(
			List<JNTCIAttendanceSelect03Dto> jntciAttendanceSelect03Dto) {
		this.jntciAttendanceSelect03Dto = jntciAttendanceSelect03Dto;
	}

}
