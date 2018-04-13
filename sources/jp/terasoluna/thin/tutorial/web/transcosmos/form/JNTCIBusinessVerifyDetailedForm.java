package jp.terasoluna.thin.tutorial.web.transcosmos.form;

import java.util.List;

import jp.terasoluna.fw.web.struts.form.ValidatorActionFormEx;
import jp.terasoluna.thin.tutorial.web.transcosmos.dto.JNTCIBusinessDept;
import jp.terasoluna.thin.tutorial.web.transcosmos.dto.JNTCISelectApplicationOutput;

public class JNTCIBusinessVerifyDetailedForm extends ValidatorActionFormEx{


	private static final long serialVersionUID = 1L;

	private String userId;

	private String userName;

	private Integer businessDays;

	private String examineStatus;

	private String deptCode;
	private String back;
   private String backs;


	public String getBacks() {
	return backs;
}



public void setBacks(String backs) {
	this.backs = backs;
}



	public String getBack() {
		return back;
	}



	public void setBack(String back) {
		this.back = back;
	}



	private String user_Id;
	private String user_Name;
	private String dept_Id;
	private String examine_Status;




	public String getUser_Id() {
		return user_Id;
	}



	public void setUser_Id(String user_Id) {
		this.user_Id = user_Id;
	}



	public String getUser_Name() {
		return user_Name;
	}



	public void setUser_Name(String user_Name) {
		this.user_Name = user_Name;
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



	/**
	 * �ｽ�ｽ�ｽ�ｽ�ｽ�ｽ�ｽ�ｽ
	 */
	private String deptId;

	private String evectionId;

	/**
	 * �ｽJ�ｽn�ｽ�ｽ�ｽ�ｽ
	 */
	private String evectionStartTime;

	private String evectionEndTime;
	/**
	 * �ｽI�ｽﾄ趣ｿｽ�ｽ�ｽ
	 */
	private String evectionEndtime;

	/**
	 * �ｽo�ｽ�ｽ�ｽ�ｽ�ｽ�ｽ
	 */
	private String evectionReason;

	/**
	 * �ｽo�ｽ�ｽ�ｽn
	 */
	private String evectionDestination;

	private String creDateTm;

	private String tjUserId;
	private String sex;
	private String positionId;
	private String projectId;
	private String projectName;
	private String dependency;
	private String idCard;
	private String departureTime;

	private String passport;
	private String visa;
	private String passportId;
	private String passportValidity;
	private String leave;
	private String reachPlace;
	private String namePinyin;
	private String trafficReservePerson;
	private String trafficExplain;

	private String hotelStartTime;
	private String hotelEndtime;
	private String hotelDestination;
	private String hotelPerson;
	private String hotelNumber;
	private String hotelReservePerson;
	private String hotelExplain;
	private String[] article_NAME;

	public String[] getArticle_NAME() {
		return article_NAME;
	}



	public void setArticle_NAME(String[] article_NAME) {
		this.article_NAME = article_NAME;
	}



	private String articleName;
	private String transferStartTime;
	private String transferEndTime;
	private String recipient;
	private String storAges;
	private String passportLength;
	private String articleRemark;
	private String evectionType;

	private String examinePerson;

	 /*荳�ｦｧ逕ｻ髱｢縺ｧ菴ｿ逕ｨ縺吶ｋ*/

    /**
     * 陦ｨ遉ｺ陦梧焚縲�
     */
    private String row = "5";

    /**
     * 髢句ｧ九う繝ｳ繝�ャ繧ｯ繧ｹ縲�
     */
    private String startIndex ="0";

    /**
     * 蜈ｨ莉ｶ謨ｰ縲�
     */
    private String totalCount = null;

    /**
     * 陦ｨ遉ｺ逕ｨ繝ｦ繝ｼ繧ｶ繝ｪ繧ｹ繝医�
     */
    private List<JNTCISelectApplicationOutput> users = null;

    private List<JNTCIBusinessDept> deptTypeList;

    private String deptName; //

	private String projectPm;
////


    public String getDeptName() {
		return deptName;
	}



	public String getEvectionType() {
		return evectionType;
	}



	public void setEvectionType(String evectionType) {
		this.evectionType = evectionType;
	}



	public String getEvectionEndTime() {
		return evectionEndTime;
	}

	public void setEvectionEndTime(String evectionEndTime) {
		this.evectionEndTime = evectionEndTime;
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

	public String getDeptCode() {
		return deptCode;
	}

	public void setDeptCode(String deptCode) {
		this.deptCode = deptCode;
	}

	public String getExamineStatus() {
		return examineStatus;
	}

	public void setExamineStatus(String examineStatus) {
		this.examineStatus = examineStatus;
	}

    public List<JNTCIBusinessDept> getDeptTypeList() {
		return deptTypeList;
	}

	public void setDeptTypeList(List<JNTCIBusinessDept> deptTypeList) {
		this.deptTypeList = deptTypeList;
	}

	public Integer getBusinessDays() {
		return businessDays;
	}

	public void setBusinessDays(Integer businessDays) {
		this.businessDays = businessDays;
	}

	public String getEvectionId() {
		return evectionId;
	}

	public void setEvectionId(String evectionId) {
		this.evectionId = evectionId;
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

	public String getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(String totalCount) {
		this.totalCount = totalCount;
	}

	public List<JNTCISelectApplicationOutput> getUsers() {
		return users;
	}

	public void setUsers(List<JNTCISelectApplicationOutput> users) {
		this.users = users;
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

	public String getDeptId() {
		return deptId;
	}

	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}



	public String getEvectionStartTime() {
		return evectionStartTime;
	}

	public void setEvectionStartTime(String evectionStartTime) {
		this.evectionStartTime = evectionStartTime;
	}

	public String getEvectionEndtime() {
		return evectionEndtime;
	}

	public void setEvectionEndtime(String evectionEndtime) {
		this.evectionEndtime = evectionEndtime;
	}

	public String getEvectionReason() {
		return evectionReason;
	}

	public void setEvectionReason(String evectionReason) {
		this.evectionReason = evectionReason;
	}

	public String getEvectionDestination() {
		return evectionDestination;
	}

	public void setEvectionDestination(String evectionDestination) {
		this.evectionDestination = evectionDestination;
	}

	public String getCreDateTm() {
		return creDateTm;
	}

	public void setCreDateTm(String creDateTm) {
		this.creDateTm = creDateTm;
	}

	public String getTjUserId() {
		return tjUserId;
	}

	public void setTjUserId(String tjUserId) {
		this.tjUserId = tjUserId;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getPositionId() {
		return positionId;
	}

	public void setPositionId(String positionId) {
		this.positionId = positionId;
	}


	public String getProjectName() {
		return projectName;
	}



	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}



	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	public String getDependency() {
		return dependency;
	}

	public void setDependency(String dependency) {
		this.dependency = dependency;
	}

	public String getIdCard() {
		return idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	public String getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}

	public String getPassport() {
		return passport;
	}

	public void setPassport(String passport) {
		this.passport = passport;
	}

	public String getVisa() {
		return visa;
	}

	public void setVisa(String visa) {
		this.visa = visa;
	}

	public String getPassportId() {
		return passportId;
	}

	public void setPassportId(String passportId) {
		this.passportId = passportId;
	}

	public String getPassportValidity() {
		return passportValidity;
	}

	public void setPassportValidity(String passportValidity) {
		this.passportValidity = passportValidity;
	}

	public String getLeave() {
		return leave;
	}

	public void setLeave(String leave) {
		this.leave = leave;
	}

	public String getReachPlace() {
		return reachPlace;
	}

	public void setReachPlace(String reachPlace) {
		this.reachPlace = reachPlace;
	}

	public String getNamePinyin() {
		return namePinyin;
	}

	public void setNamePinyin(String namePinyin) {
		this.namePinyin = namePinyin;
	}

	public String getTrafficReservePerson() {
		return trafficReservePerson;
	}

	public void setTrafficReservePerson(String trafficReservePerson) {
		this.trafficReservePerson = trafficReservePerson;
	}

	public String getTrafficExplain() {
		return trafficExplain;
	}

	public void setTrafficExplain(String trafficExplain) {
		this.trafficExplain = trafficExplain;
	}

	public String getHotelStartTime() {
		return hotelStartTime;
	}

	public void setHotelStartTime(String hotelStartTime) {
		this.hotelStartTime = hotelStartTime;
	}



	public String getHotelEndtime() {
		return hotelEndtime;
	}

	public void setHotelEndtime(String hotelEndtime) {
		this.hotelEndtime = hotelEndtime;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getHotelDestination() {
		return hotelDestination;
	}

	public void setHotelDestination(String hotelDestination) {
		this.hotelDestination = hotelDestination;
	}

	public String getHotelPerson() {
		return hotelPerson;
	}

	public void setHotelPerson(String hotelPerson) {
		this.hotelPerson = hotelPerson;
	}

	public String getHotelNumber() {
		return hotelNumber;
	}

	public void setHotelNumber(String hotelNumber) {
		this.hotelNumber = hotelNumber;
	}

	public String getHotelReservePerson() {
		return hotelReservePerson;
	}

	public void setHotelReservePerson(String hotelReservePerson) {
		this.hotelReservePerson = hotelReservePerson;
	}

	public String getHotelExplain() {
		return hotelExplain;
	}

	public void setHotelExplain(String hotelExplain) {
		this.hotelExplain = hotelExplain;
	}

	public String getArticleName() {
		return articleName;
	}

	public void setArticleName(String articleName) {
		this.articleName = articleName;
	}

	public String getTransferStartTime() {
		return transferStartTime;
	}

	public void setTransferStartTime(String transferStartTime) {
		this.transferStartTime = transferStartTime;
	}

	public String getTransferEndTime() {
		return transferEndTime;
	}

	public void setTransferEndTime(String transferEndTime) {
		this.transferEndTime = transferEndTime;
	}

	public String getRecipient() {
		return recipient;
	}

	public void setRecipient(String recipient) {
		this.recipient = recipient;
	}

	public String getStorAges() {
		return storAges;
	}

	public void setStorAges(String storAges) {
		this.storAges = storAges;
	}

	public String getPassportLength() {
		return passportLength;
	}

	public void setPassportLength(String passportLength) {
		this.passportLength = passportLength;
	}

	public String getArticleRemark() {
		return articleRemark;
	}

	public void setArticleRemark(String articleRemark) {
		this.articleRemark = articleRemark;
	}



	public String getExaminePerson() {
		return examinePerson;
	}



	public void setExaminePerson(String examinePerson) {
		this.examinePerson = examinePerson;
	}





}
