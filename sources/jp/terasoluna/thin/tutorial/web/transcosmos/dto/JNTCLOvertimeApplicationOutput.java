package jp.terasoluna.thin.tutorial.web.transcosmos.dto;

import java.util.Date;
import java.util.List;

public class JNTCLOvertimeApplicationOutput {
	private String user_id = null; // �ｽ�ｽ�ｽ[�ｽUID
	private String user_name = null; // �ｽ�ｽ�ｽ[�ｽU�ｽ�ｽ�ｽ�ｽ
	private String dept_id = null; // �ｽ�ｽ�ｽ�ｽ�ｽ�ｽ�ｽ�ｽ
	private String project = null; // �ｽv�ｽ�ｽ�ｽW�ｽF�ｽN�ｽg
	private String extra_starttime = null; // �ｽJ�ｽn�ｽ�ｽ�ｽ�ｽ
	private String extra_endtime = null; // �ｽﾄ趣ｿｽ�ｽ�ｽ
	private String extra_type = null; // �ｽk�ｽ�ｽ �ｽ^�ｽC�ｽv
	private String extra_time = null;//残業時間hidden
	private String extra_time_txt = null;//残業時間
	public String examineId;   //審査人Id
	private String code_id=null;
	private String flag;
	private String startIndex;
	public String detailDate;//总节假日

	public String getDetailDate() {
		return detailDate;
	}

	public void setDetailDate(String detailDate) {
		this.detailDate = detailDate;
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
	public String getCode_id() {
		return code_id;
	}

	public void setCode_id(String code_id) {
		this.code_id = code_id;
	}

	private String examinePerson=null;

	public String getExtra_time_txt() {
		return extra_time_txt;
	}

	public void setExtra_time_txt(String extra_time_txt) {
		this.extra_time_txt = extra_time_txt;
	}

	public String getExaminePerson() {
		return examinePerson;
	}

	public void setExaminePerson(String examinePerson) {
		this.examinePerson = examinePerson;
	}

	public String getExamineId() {
		return examineId;
	}

	public void setExamineId(String examineId) {
		this.examineId = examineId;
	}

	public List<JNTCIAttendance03Dto> examinePersonList;

	public List<JNTCIAttendance03Dto> getExaminePersonList() {
		return examinePersonList;
	}

	public void setExaminePersonList(List<JNTCIAttendance03Dto> examinePersonList) {
		this.examinePersonList = examinePersonList;
	}



	public String getProject_id() {
		return project_id;
	}

	public void setProject_id(String project_id) {
		this.project_id = project_id;
	}

	private String pay_id = null; // �ｽl�ｽ�ｽ �ｽ^�ｽC�ｽv
	private Date cre_datetm = null; // �ｽ\�ｽ�ｽ�ｽ�ｽ�ｽ�ｽ
	private String extra_reason = null; // �ｽ�ｽ
	private String dept_code = null;
	private String project_id = null;
	private String extra_beiZhu;
	public String getExtra_beiZhu() {
		return extra_beiZhu;
	}

	public void setExtra_beiZhu(String extra_beiZhu) {
		this.extra_beiZhu = extra_beiZhu;
	}

	private List<JNTCLOvertimeApplicationInput> extralist;
	private String codeId;

	public String getCodeId() {
		return codeId;
	}

	public void setCodeId(String codeId) {
		this.codeId = codeId;
	}

	private String project_PM=null;
	private String extra_auditss = null;

	public String getExtra_auditss() {
		return extra_auditss;
	}

	public void setExtra_auditss(String extra_auditss) {
		this.extra_auditss = extra_auditss;
	}


	public String getProject_PM() {
		return project_PM;
	}

	public void setProject_PM(String project_PM) {
		this.project_PM = project_PM;
	}

	public String getDept_code() {
		return dept_code;
	}

	public void setDept_code(String dept_code) {
		this.dept_code = dept_code;
	}




	public List<JNTCLOvertimeApplicationInput> getExtralist() {
		return extralist;
	}

	public void setExtralist(List<JNTCLOvertimeApplicationInput> extralist) {
		this.extralist = extralist;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getDept_id() {
		return dept_id;
	}

	public void setDept_id(String dept_id) {
		this.dept_id = dept_id;
	}

	public String getProject() {
		return project;
	}

	public void setProject(String project) {
		this.project = project;
	}

	public void setExtra_starttime(String extra_starttime) {
		this.extra_starttime = extra_starttime;
	}

	public String getExtra_starttime() {
		return extra_starttime;
	}

	public String getExtra_endtime() {
		return extra_endtime;
	}

	public void setExtra_endtime(String extra_endtime) {
		this.extra_endtime = extra_endtime;
	}

	public String getExtra_type() {
		return extra_type;
	}

	public void setExtra_type(String extra_type) {
		this.extra_type = extra_type;
	}

	public String getExtra_time() {
		return extra_time;
	}

	public void setExtra_time(String extra_time) {
		this.extra_time = extra_time;
	}



	public String getPay_id() {
		return pay_id;
	}

	public void setPay_id(String pay_id) {
		this.pay_id = pay_id;
	}

	public Date getCre_datetm() {
		return cre_datetm;
	}

	public void setCre_datetm(Date cre_datetm) {
		this.cre_datetm = cre_datetm;
	}

	public String getExtra_reason() {
		return extra_reason;
	}

	public void setExtra_reason(String extra_reason) {
		this.extra_reason = extra_reason;
	}

}
