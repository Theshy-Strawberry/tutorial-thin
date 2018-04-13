package jp.terasoluna.thin.tutorial.web.transcosmos.dto;

import java.sql.Timestamp;

public class JNTCIPositionUpdateInput {

private String scrollPosit;

	public String getScrollPosit() {
		return scrollPosit;
	}
	public void setScrollPosit(String scrollPosit) {
		this.scrollPosit = scrollPosit;
	}
	/**
	 * 席次号
	 */
	private String emp_Position;

	/**
	 * ユーザー号
	 */
	private String info_EmpNo;

	/**
	 * システムタイム
	 */
	private Timestamp systemTime;

	/**
	 * 更新者
	 */
	private String userId;

	public String getEmp_Position() {
		return emp_Position;
	}

	public void setEmp_Position(String emp_Position) {
		this.emp_Position = emp_Position;
	}

	public String getInfo_EmpNo() {
		return info_EmpNo;
	}

	public void setInfo_EmpNo(String info_EmpNo) {
		this.info_EmpNo = info_EmpNo;
	}

	public Timestamp getSystemTime() {
		return systemTime;
	}

	public void setSystemTime(Timestamp systemTime) {
		this.systemTime = systemTime;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}



}
