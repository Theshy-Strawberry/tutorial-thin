package jp.terasoluna.thin.tutorial.web.transcosmos.vo;

public class SelectDeptName {

	private String APPLY_REPAIR_DEPT_ID = null;

	private String APPLY_REPAIR_DEPT_NAME = null;

	private String APPLY_DEPT_ID = null;

	private String APPLY_DEPT_NAME = null;

	private String CODE = null;

	public String getAPPLY_REPAIR_DEPT_ID() {
		return APPLY_REPAIR_DEPT_ID;
	}

	public void setAPPLY_REPAIR_DEPT_ID(String aPPLY_REPAIR_DEPT_ID) {
		APPLY_REPAIR_DEPT_ID = aPPLY_REPAIR_DEPT_ID;
	}

	public String getAPPLY_REPAIR_DEPT_NAME() {
		return APPLY_REPAIR_DEPT_NAME;
	}

	public void setAPPLY_REPAIR_DEPT_NAME(String aPPLY_REPAIR_DEPT_NAME) {
		APPLY_REPAIR_DEPT_NAME = aPPLY_REPAIR_DEPT_NAME;
	}


	public String getAPPLY_DEPT_ID() {
		return APPLY_DEPT_ID;
	}

	public void setAPPLY_DEPT_ID(String aPPLY_DEPT_ID) {
		APPLY_DEPT_ID = aPPLY_DEPT_ID;
	}

	public String getAPPLY_DEPT_NAME() {
		return APPLY_DEPT_NAME;
	}

	public void setAPPLY_DEPT_NAME(String aPPLY_DEPT_NAME) {
		APPLY_DEPT_NAME = aPPLY_DEPT_NAME;
	}

	public String getCODE() {
		return CODE;
	}

	public void setCODE(String cODE) {
		CODE = cODE;
	}


	private String deptName=null;
	private String deptID=null;

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getDeptID() {
		return deptID;
	}

	public void setDeptID(String deptID) {
		this.deptID = deptID;
	}



}
