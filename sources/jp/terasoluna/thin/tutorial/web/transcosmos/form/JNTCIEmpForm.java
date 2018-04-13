package jp.terasoluna.thin.tutorial.web.transcosmos.form;

import java.util.List;

import org.apache.struts.upload.FormFile;

import jp.terasoluna.thin.tutorial.web.transcosmos.vo.JNTCIEmpPositionVo;

public class JNTCIEmpForm {
	private String info_EmpNo;
	private String user_Name;
	private String emp_Position;
	private String photo;
	private int count;
	private String dept;
	private String scrollPosit;
	private List<JNTCIEmpPositionVo> empList;
	private String excel_Position_x;
	private String excel_Position_y;
	private FormFile photo_path;

	private String selectUserId;

	private List<JNTCIEmpPositionVo> infoEmpNoList;

	private String KEY;
	private String VALUE;

	public List<JNTCIEmpPositionVo> getEmpList() {
		return empList;
	}

	public void setEmpList(List<JNTCIEmpPositionVo> empList) {
		this.empList = empList;
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


	public String getScrollPosit() {
		return scrollPosit;
	}

	public void setScrollPosit(String scrollPosit) {
		this.scrollPosit = scrollPosit;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getEmp_Position() {
		return emp_Position;
	}

	public void setEmp_Position(String emp_Position) {
		this.emp_Position = emp_Position;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public String getExcel_Position_x() {
		return excel_Position_x;
	}

	public void setExcel_Position_x(String excel_Position_x) {
		this.excel_Position_x = excel_Position_x;
	}

	public String getExcel_Position_y() {
		return excel_Position_y;
	}

	public void setExcel_Position_y(String excel_Position_y) {
		this.excel_Position_y = excel_Position_y;
	}

	public FormFile getPhoto_path() {
		return photo_path;
	}

	public void setPhoto_path(FormFile photo_path) {
		this.photo_path = photo_path;
	}

	public String getSelectUserId() {
		return selectUserId;
	}

	public void setSelectUserId(String selectUserId) {
		this.selectUserId = selectUserId;
	}

	public List<JNTCIEmpPositionVo> getInfoEmpNoList() {
		return infoEmpNoList;
	}

	public void setInfoEmpNoList(List<JNTCIEmpPositionVo> infoEmpNoList) {
		this.infoEmpNoList = infoEmpNoList;
	}

	public String getKEY() {
		return KEY;
	}

	public void setKEY(String kEY) {
		KEY = kEY;
	}

	public String getVALUE() {
		return VALUE;
	}

	public void setVALUE(String vALUE) {
		VALUE = vALUE;
	}

}
