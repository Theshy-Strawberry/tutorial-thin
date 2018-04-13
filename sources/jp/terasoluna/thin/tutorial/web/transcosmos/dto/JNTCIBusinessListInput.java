package jp.terasoluna.thin.tutorial.web.transcosmos.dto;

public class JNTCIBusinessListInput {

	
	private String userId;

	private String userName;

	private String deptId;

	/**
     * �ｽ\�ｽ�ｽ�ｽs�ｽ�ｽ�ｽB
     */
    private String row = null;

    /**
     * �ｽJ�ｽn�ｽC�ｽ�ｽ�ｽf�ｽb�ｽN�ｽX�ｽB
     */
    private String startIndex = null;

    private String examineStatus;

    private Integer businessDays;

    private String deptName; //

	private String projectPm;// プロジェクトPM

	private String examinePerson;




    public String getExaminePerson() {
		return examinePerson;
	}

	public void setExaminePerson(String examinePerson) {
		this.examinePerson = examinePerson;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getProjectPm() {
		return projectPm;
	}

	public void setProjectPm(String projectPm) {
		this.projectPm = projectPm;
	}

	public String getDeptId() {
		return deptId;
	}

	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}

	public Integer getBusinessDays() {
		return businessDays;
	}

	public void setBusinessDays(Integer businessDays) {
		this.businessDays = businessDays;
	}

	public String getExamineStatus() {
		return examineStatus;
	}

	public void setExamineStatus(String examineStatus) {
		this.examineStatus = examineStatus;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
     * �ｽ\�ｽ�ｽ�ｽs�ｽ�ｽ�ｽ�ｽﾔ却�ｽ�ｽ�ｽ�ｽB
     * @return �ｽ\�ｽ�ｽ�ｽs�ｽ�ｽ
     */
    public String getRow() {
        return row;
    }

    /**
     * �ｽ\�ｽ�ｽ�ｽs�ｽ�ｽ�ｽ�ｽﾝ定す�ｽ�ｽB
     * @param row �ｽ\�ｽ�ｽ�ｽs�ｽ�ｽ
     */
    public void setRow(String row) {
        this.row = row;
    }

    /**
     * �ｽJ�ｽn�ｽC�ｽ�ｽ�ｽf�ｽb�ｽN�ｽX�ｽ�ｽﾔ却�ｽ�ｽ�ｽ�ｽB
     * @return �ｽJ�ｽn�ｽC�ｽ�ｽ�ｽf�ｽb�ｽN�ｽX
     */
    public String getStartIndex() {
        return startIndex;
    }

    /**
     * �ｽJ�ｽn�ｽC�ｽ�ｽ�ｽf�ｽb�ｽN�ｽX�ｽ�ｽﾝ定す�ｽ�ｽB
     * @param startIndex �ｽJ�ｽn�ｽC�ｽ�ｽ�ｽf�ｽb�ｽN�ｽX
     */
    public void setStartIndex(String startIndex) {
        this.startIndex = startIndex;
    }

}
