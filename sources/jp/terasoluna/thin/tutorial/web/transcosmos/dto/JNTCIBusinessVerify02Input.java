package jp.terasoluna.thin.tutorial.web.transcosmos.dto;

import java.io.Serializable;

public class JNTCIBusinessVerify02Input implements Serializable  {

	 /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	/**
     * �o���ԍ��B
     */
	private String leader;
	private String uname1 = null;
	private String uid1= null;
    private String evectionId = null;

    private String examineStatus;
    private String day;
    private int count;
    private String examinePerson = null;

    private String deptPerson = null;
    private String flag=null;
    private String userId=null;
    private String userName;
    private String evectionStartTime;
    private String evectionEndTime;
    private String dept_Id;
    private String examine_Status;
    private String deleteId_card;

    private String cod = null;




		public String getLeader() {
		return leader;
	}


	public void setLeader(String leader) {
		this.leader = leader;
	}


		public String getDeleteId_card() {
		return deleteId_card;
	}


	public void setDeleteId_card(String deleteId_card) {
		this.deleteId_card = deleteId_card;
	}


		public String getCod() {
		return cod;
	}


	public void setCod(String cod) {
		this.cod = cod;
	}



		public String getDept_Id() {
		return dept_Id;
	}


	public void setDept_Id(String dept_Id) {
		this.dept_Id = dept_Id;
	}


	public String getExamine_Status() {
		return examine_Status;
	}


	public void setExamine_Status(String examine_Status) {
		this.examine_Status = examine_Status;
	}

    public String getUser_Name() {
		return user_Name;
	}

	public void setUser_Name(String user_Name) {
		this.user_Name = user_Name;
	}

	private String user_Name;

    private String user_Id;

    private String deptId;



	public String getDeptId() {
		return deptId;
	}

	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}

	public String getUser_Id() {
		return user_Id;
	}

	public void setUser_Id(String user_Id) {
		this.user_Id = user_Id;
	}

	/**
     * 表示行数。
     */
    private String row = null;

    /**
     * 開始インデックス。
     */
    private String startIndex = null;

    /**
     * 总计页数
     */
    private String total = null;

    /**
     * 当前页数
     */
    private String now = null;




	public String getRow() {
		return row;
	}

	public void setRow(String row) {
		this.row = row;
	}

	public String getStartIndex() {
		return startIndex;
	}

	public void setStartIndex(String startIndex) {
		this.startIndex = startIndex;
	}

	public String getTotal() {
		return total;
	}

	public void setTotal(String total) {
		this.total = total;
	}

	public String getNow() {
		return now;
	}

	public void setNow(String now) {
		this.now = now;
	}

	public String getUname1() {
		return uname1;
	}

	public void setUname1(String uname1) {
		this.uname1 = uname1;
	}

	public String getUid1() {
		return uid1;
	}

	public void setUid1(String uid1) {
		this.uid1 = uid1;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public String getEvectionStartTime() {
		return evectionStartTime;
	}

	public void setEvectionStartTime(String evectionStartTime) {
		this.evectionStartTime = evectionStartTime;
	}

	public String getEvectionEndTime() {
		return evectionEndTime;
	}

	public void setEvectionEndTime(String evectionEndTime) {
		this.evectionEndTime = evectionEndTime;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getDeptPerson() {
		return deptPerson;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public void setDeptPerson(String deptPerson) {
		this.deptPerson = deptPerson;
	}

	public String getExaminePerson() {
		return examinePerson;
	}

	public void setExaminePerson(String examinePerson) {
		this.examinePerson = examinePerson;
	}

	public String getExamineStatus() {
		return examineStatus;
	}

	public void setExamineStatus(String examineStatus) {
		this.examineStatus = examineStatus;
	}

	public String getEvectionId() {
		return evectionId;
	}

	public void setEvectionId(String evectionId) {
		this.evectionId = evectionId;
	}



}
