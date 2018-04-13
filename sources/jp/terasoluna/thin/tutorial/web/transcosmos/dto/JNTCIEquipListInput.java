package jp.terasoluna.thin.tutorial.web.transcosmos.dto;

public class JNTCIEquipListInput {

	//区分
	private String code = null ;
    //設備区分
	private String setsubiKubun =null ;
	//所属部門Id
	private String deptId = null ;
    //社員ID
	private String userId= null ;

	private String row = null;

	private String startIndex = null;

	private String flag = null;

	private String flags = null;

	private String setsubiNo =null;

	private String shunyuNo = null;


	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getSetsubiKubun() {
		return setsubiKubun;
	}

	public void setSetsubiKubun(String setsubiKubun) {
		this.setsubiKubun = setsubiKubun;
	}

	public String getDeptId() {
		return deptId;
	}

	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

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

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public String getFlags() {
		return flags;
	}

	public void setFlags(String flags) {
		this.flags = flags;
	}

	public String getShunyuNo() {
		return shunyuNo;
	}

	public void setShunyuNo(String shunyuNo) {
		this.shunyuNo = shunyuNo;
	}

	public String getSetsubiNo() {
		return setsubiNo;
	}

	public void setSetsubiNo(String setsubiNo) {
		this.setsubiNo = setsubiNo;
	}

}
