package jp.terasoluna.thin.tutorial.web.transcosmos.form;

import java.util.Date;
import java.util.List;

import jp.terasoluna.fw.web.struts.form.ValidatorActionFormEx;
import jp.terasoluna.thin.tutorial.web.transcosmos.dto.JNTCISuperButtonInput;

public class JNTCISuperButtonForm  extends ValidatorActionFormEx{
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private String  userName;
	private String  projectId;
	private String  projectId1;
	private String  projectId2;
	private String  power;
	private String userNameTwo=null;
	private String quanxianid;
	private String quanxianname;
	private String userId;
	private Date updatetime;
	private String projectno;
	private String projectname;
	private String usersId;
	private String rolename;
	private List<JNTCISuperButtonInput>rolelist;
	private String code_id;
	private String kj_name;
	private List<JNTCISuperButtonInput> projectlist;
	private List<JNTCISuperButtonInput> pmlist;//项目负责人的集合
	private String pro;
	private String proname;
	private String pro1;//在查询项目人员的时候用到的项目ID
	private String proname1;//在查询项目人员的时候用到的项目名
	private String projectdutyname;//项目负责人
	private String  deleteprojectname;
	private String project_pl;//项目担当
	private String newaa;//往数据库放一条项目负责人的新数据
	private String checkresult;
	private String concat;//选择项目负责人下拉框中的连接卡号和姓名的复合字符串
	private List<JNTCISuperButtonInput> selectprojectusernamelist;//通过项目查询出的在该项目的人员名单
	private List<JNTCISuperButtonInput> projectnamelist;//查询表中的项目集合
	private String nameandcard;//查询出的某项目的所在人员的卡号和姓名

	public String getProjectId2() {
		return projectId2;
	}
	public void setProjectId2(String projectId2) {
		this.projectId2 = projectId2;
	}
	public String getNameandcard() {
		return nameandcard;
	}
	public void setNameandcard(String nameandcard) {
		this.nameandcard = nameandcard;
	}
	public String getProjectId1() {
		return projectId1;
	}
	public void setProjectId1(String projectId1) {
		this.projectId1 = projectId1;
	}
	public String getPro1() {
		return pro1;
	}
	public void setPro1(String pro1) {
		this.pro1 = pro1;
	}
	public String getProname1() {
		return proname1;
	}
	public void setProname1(String proname1) {
		this.proname1 = proname1;
	}
	public List<JNTCISuperButtonInput> getProjectnamelist() {
		return projectnamelist;
	}
	public void setProjectnamelist(List<JNTCISuperButtonInput> projectnamelist) {
		this.projectnamelist = projectnamelist;
	}
	public List<JNTCISuperButtonInput> getSelectprojectusernamelist() {
		return selectprojectusernamelist;
	}
	public void setSelectprojectusernamelist(
			List<JNTCISuperButtonInput> selectprojectusernamelist) {
		this.selectprojectusernamelist = selectprojectusernamelist;
	}
	public String getConcat() {
		return concat;
	}
	public void setConcat(String concat) {
		this.concat = concat;
	}
	public String getCheckresult() {
		return checkresult;
	}
	public void setCheckresult(String checkresult) {
		this.checkresult = checkresult;
	}
	public String getNewaa() {
		return newaa;
	}
	public void setNewaa(String newaa) {
		this.newaa = newaa;
	}
	public String getProject_pl() {
		return project_pl;
	}
	public void setProject_pl(String project_pl) {
		this.project_pl = project_pl;
	}
	public List<JNTCISuperButtonInput> getPmlist() {
		return pmlist;
	}
	public void setPmlist(List<JNTCISuperButtonInput> pmlist) {
		this.pmlist = pmlist;
	}
	public String getDeleteprojectname() {
		return deleteprojectname;
	}
	public void setDeleteprojectname(String deleteprojectname) {
		this.deleteprojectname = deleteprojectname;
	}
	public String getProjectdutyname() {
		return projectdutyname;
	}
	public void setProjectdutyname(String projectdutyname) {
		this.projectdutyname = projectdutyname;
	}
	public String getPro() {
		return pro;
	}
	public void setPro(String pro) {
		this.pro = pro;
	}
	public String getProname() {
		return proname;
	}
	public void setProname(String proname) {
		this.proname = proname;
	}
	public List<JNTCISuperButtonInput> getProjectlist() {
		return projectlist;
	}
	public void setProjectlist(List<JNTCISuperButtonInput> projectlist) {
		this.projectlist = projectlist;
	}
	public String getKj_name() {
		return kj_name;
	}
	public void setKj_name(String kj_name) {
		this.kj_name = kj_name;
	}
	public String getCode_id() {
		return code_id;
	}
	public void setCode_id(String code_id) {
		this.code_id = code_id;
	}
	public List<JNTCISuperButtonInput> getRolelist() {
		return rolelist;
	}
	public void setRolelist(List<JNTCISuperButtonInput> rolelist) {
		this.rolelist = rolelist;
	}
	public String getRolename() {
		return rolename;
	}
	public void setRolename(String rolename) {
		this.rolename = rolename;
	}
	public String getUsersId() {
		return usersId;
	}
	public void setUsersId(String usersId) {
		this.usersId = usersId;
	}
	public String getProjectno() {
		return projectno;
	}
	public void setProjectno(String projectno) {
		this.projectno = projectno;
	}
	public String getProjectname() {
		return projectname;
	}
	public void setProjectname(String projectname) {
		this.projectname = projectname;
	}
	public Date getUpdatetime() {
		return updatetime;
	}
	public void setUpdatetime(Date updatetime) {
		this.updatetime = updatetime;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getQuanxianid() {
		return quanxianid;
	}
	public void setQuanxianid(String quanxianid) {
		this.quanxianid = quanxianid;
	}
	public String getQuanxianname() {
		return quanxianname;
	}
	public void setQuanxianname(String quanxianname) {
		this.quanxianname = quanxianname;
	}
	public String getUserNameTwo() {
		return userNameTwo;
	}
	public void setUserNameTwo(String userNameTwo) {
		this.userNameTwo = userNameTwo;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPower() {
		return power;
	}
	public void setPower(String power) {
		this.power = power;
	}
	public String getProjectId() {
		return projectId;
	}
	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}
}
