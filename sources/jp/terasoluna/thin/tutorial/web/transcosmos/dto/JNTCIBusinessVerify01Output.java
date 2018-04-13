package jp.terasoluna.thin.tutorial.web.transcosmos.dto;
import java.util.List;

import jp.terasoluna.fw.web.struts.form.ValidatorActionFormEx;
import jp.terasoluna.thin.tutorial.web.transcosmos.vo.JNTCIBusinessVerifyVo;

public class JNTCIBusinessVerify01Output extends ValidatorActionFormEx {


	private static final long serialVersionUID = 1L;
	 /**
     * �\���p���[�U���X�g�B
     */
    private List<JNTCIBusinessVerifyVo> JNTCIBusinessVerifyVoInfo = null;

    /**
     * ���[�U���X�g�̑S�����B
     */
    private String userId;
    private String totalCount;
    private String deleteId_card;
    private String KJ_NAME = null;
    private String CD_CODE = null;
    private String examineStatus = null;
    private String user_Name = null;
    private String examinePerson = null;
    private String uname1;
    private String uid1;
    private String user_Id;
    private String deptId;
    private String dept_Id;
    private String examine_Status = null;
    private String cod;

    private String startIndex;
    private String evectionId;


    public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getStartIndex() {
		return startIndex;
	}

	public void setStartIndex(String startIndex) {
		this.startIndex = startIndex;
	}

	public String getEvectionId() {
		return evectionId;
	}

	public void setEvectionId(String evectionId) {
		this.evectionId = evectionId;
	}

	public String getCod() {
		return cod;
	}

	public void setCod(String cod) {
		this.cod = cod;
	}

	public String getExamine_Status() {
		return examine_Status;
	}

	public void setExamine_Status(String examine_Status) {
		this.examine_Status = examine_Status;
	}

	public String getDept_Id() {
		return dept_Id;
	}

	public void setDept_Id(String dept_Id) {
		this.dept_Id = dept_Id;
	}

	public String getUser_Id() {
		return user_Id;
	}

	public void setUser_Id(String user_Id) {
		this.user_Id = user_Id;
	}

	public String getDeptId() {
		return deptId;
	}

	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}

	public String getUid1() {
		return uid1;
	}

	public void setUid1(String uid1) {
		this.uid1 = uid1;
	}

	public String getUname1() {
		return uname1;
	}

	public void setUname1(String uname1) {
		this.uname1 = uname1;
	}

	public List<JNTCIAttendance03Dto> examinePersonList;//審査人の名前List;

    public List<JNTCIAttendance03Dto> getExaminePersonList() {
		return examinePersonList;
	}

	public void setExaminePersonList(List<JNTCIAttendance03Dto> examinePersonList) {
		this.examinePersonList = examinePersonList;
	}

	private String userName = null;




    public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}




	public String getDeleteId_card() {
		return deleteId_card;
	}

	public void setDeleteId_card(String deleteId_card) {
		this.deleteId_card = deleteId_card;
	}

	public String getUser_Name() {
		return user_Name;
	}

	public void setUser_Name(String user_Name) {
		this.user_Name = user_Name;
	}

	public String getExamineStatus() {
		return examineStatus;
	}

	public void setExamineStatus(String examineStatus) {
		this.examineStatus = examineStatus;
	}

	public String getKJ_NAME() {
		return KJ_NAME;
	}

	public void setKJ_NAME(String kJ_NAME) {
		KJ_NAME = kJ_NAME;
	}

	public String getCD_CODE() {
		return CD_CODE;
	}

	public void setCD_CODE(String cD_CODE) {
		CD_CODE = cD_CODE;
	}

	private List<JNTCIBusinessVerifyVo> examineList = null;

    private List<JNTCIBusinessVerifyVo> deptList = null;





    public List<JNTCIBusinessVerifyVo> getExamineList() {
		return examineList;
	}

	public void setExamineList(List<JNTCIBusinessVerifyVo> examineList) {
		this.examineList = examineList;
	}

	public List<JNTCIBusinessVerifyVo> getDeptList() {
		return deptList;
	}

	public void setDeptList(List<JNTCIBusinessVerifyVo> deptList) {
		this.deptList = deptList;
	}

	/**
     * �\���p���[�U���X�g��ԋp����B
     * @return �\���p���[�U���X�g
     */
    public List<JNTCIBusinessVerifyVo> getJNTCIBusinessVerifyVoInfo() {
		return JNTCIBusinessVerifyVoInfo;
	}

    /**
     * �\���p���[�U���X�g��ݒ肷��B
     * @param users �\���p���[�U���X�g
     */
    public void setJNTCIBusinessVerifyVoInfo(
			List<JNTCIBusinessVerifyVo> jNTCIBusinessVerifyVoInfo) {
		this.JNTCIBusinessVerifyVoInfo = jNTCIBusinessVerifyVoInfo;
	}


	/**
     * ���[�U���X�g�̑S������ԋp����B
     * @return ���[�U���X�g�̑S����
     */
    public String getTotalCount() {
        return totalCount;
    }

    /**
     * ���[�U���X�g�̑S������ݒ肷��B
     * @param totalCount ���[�U���X�g�̑S����
     */
    public void setTotalCount(String totalCount) {
        this.totalCount = totalCount;
    }

	public String getExaminePerson() {
		return examinePerson;
	}

	public void setExaminePerson(String examinePerson) {
		this.examinePerson = examinePerson;
	}

}
