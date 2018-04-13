package jp.terasoluna.thin.tutorial.web.transcosmos.dto;

import java.util.List;

import jp.terasoluna.thin.tutorial.web.transcosmos.vo.JNTCIEmpPositionVo;

public class JNTCIEmpPositionOutput{


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
	 * 従業員ID
	 */
	private String info_EmpNo;
	/**
	 * 従業員名
	 */
	private String user_Name;
	/**
	 * 写真
	 */
	private String photo;
	/**
	 * レコード数
	 */
	private int count;
	/**
	 * 一覧の従業員情報
	 */
	private List<JNTCIEmpPositionVo> empList;
	/**
	 * 部門
	 */
	private  String dept;
	/**
	 * プルダウンリストに従業員情報
	 */
	private List<JNTCIEmpPositionVo> infoEmpNoList;

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
	public String getUser_Name() {
		return user_Name;
	}
	public void setUser_Name(String user_Name) {
		this.user_Name = user_Name;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public List<JNTCIEmpPositionVo> getEmpList() {
		return empList;
	}
	public void setEmpList(List<JNTCIEmpPositionVo> empList) {
		this.empList = empList;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public List<JNTCIEmpPositionVo> getInfoEmpNoList() {
		return infoEmpNoList;
	}
	public void setInfoEmpNoList(List<JNTCIEmpPositionVo> infoEmpNoList) {
		this.infoEmpNoList = infoEmpNoList;
	}
}
