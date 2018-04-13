package jp.terasoluna.thin.tutorial.web.transcosmos.vo;

import java.io.Serializable;
import java.util.List;

import jp.terasoluna.thin.tutorial.web.transcosmos.dto.JNTCIAttendance03Dto;


/**
 * 繝ｦ繝ｼ繧ｶ諠��菫晄戟Bean縲�
 *
 * 繝��繧ｿ繝吶�繧ｹ縺九ｉ縺ｮ蜿門ｾ玲凾縲∫判髱｢縺九ｉ縺ｮ蜈･蜉帶凾縺ｫ菴ｿ逕ｨ縺輔ｌ繧九�
 *
 */
public class JNTCIBusinessVerifyVo implements Serializable {

    /**
     * 繧ｷ繝ｪ繧｢繝ｫ繝舌�繧ｸ繝ｧ繝ｳID縲�
     */
    private static final long serialVersionUID = 1L;
    private String storAges;

    private String trafficReservePerson;

    private String uid1;

    public String getUid1() {
		return uid1;
	}
	public void setUid1(String uid1) {
		this.uid1 = uid1;
	}


	private String deptName;
    /**
     * 蜃ｺ蠑ｵ逡ｪ蜿ｷ縲�
     */
    private String evectionId;

    /**
     * 繝ｦ繝ｼ繧ｶID縲�
     */
	private String userId;

	/**
     * 繝ｦ繝ｼ繧ｶ蜷咲ｧｰ縲�
     */
	private String user_Name;

	private String userName = null;
	private String uname1 = null;
	private String user_id;

	public String getUname1() {
		return uname1;
	}
	public void setUname1(String uname1) {
		this.uname1 = uname1;
	}

	/**
     * 謇�ｱ樣Κ髢��
     */
	private String deptId;

	/**
     * 髢句ｧ区凾髢薙�
     */
	private String evectionStartTime;


	/**
     * 邨ら椚譎る俣縲�
     */
	private String evectionEndTime;


	/**
     * 蜃ｺ蟾ｮ蝨ｰ縲�
     */
	private String evectionDestination;


	/**
     * 蜃ｺ蟾ｮ蜴溷屏縲�
     */
	private String evectionReason;


	/**
     *逕ｳ隲区凾髢薙�
     */
	private String creDateTm;

	private String businessDays = null;


	/**
    * 螳｡譬ｸ迥ｶ諤√�
    */
	private String examineStatus = null;

	private String examinePerson = null;

	private String projectPm;

	private String deptPerson;
	private String cod = null;

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

	private String trafficReservetPerson;

	private String trafficExplain;

	private String hotelStartTime;

	private String hotelEndtime;

	private String hotelEndTime;

	private String hotelDestination;

	private String hotelPerson;

	private String hotelNumber;

	private String hotelReservePerson;

	private String hotelExplain;

	private String articleName;

	private String transferStartTime;

	private String transferEndTime;

	private String recipient;

	private String storages;

	private String passportLength;

	private String articleRemark;

	private String evectionType;

	private String[] article_NAME;
    public List<JNTCIAttendance03Dto> examinePersonList;//審査人の名前List;






	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public List<JNTCIAttendance03Dto> getExaminePersonList() {
		return examinePersonList;
	}
	public void setExaminePersonList(List<JNTCIAttendance03Dto> examinePersonList) {
		this.examinePersonList = examinePersonList;
	}
	public String[] getArticle_NAME() {
		return article_NAME;
	}
	public void setArticle_NAME(String[] article_NAME) {
		this.article_NAME = article_NAME;
	}
	public String getHotelEndTime() {
		return hotelEndTime;
	}
	public void setHotelEndTime(String hotelEndTime) {
		this.hotelEndTime = hotelEndTime;
	}
	public String getStorAges() {
		return storAges;
	}
	public void setStorAges(String storAges) {
		this.storAges = storAges;
	}
	public String getHotelEndtime() {
		return hotelEndtime;
	}
	public void setHotelEndtime(String hotelEndtime) {
		this.hotelEndtime = hotelEndtime;
	}
	public String getTrafficReservePerson() {
		return trafficReservePerson;
	}
	public void setTrafficReservePerson(String trafficReservePerson) {
		this.trafficReservePerson = trafficReservePerson;
	}
	public String getProjectPm() {
		return projectPm;
	}
	public void setProjectPm(String projectPm) {
		this.projectPm = projectPm;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
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
	public String getTrafficReservetPerson() {
		return trafficReservetPerson;
	}
	public void setTrafficReservetPerson(String trafficReservetPerson) {
		this.trafficReservetPerson = trafficReservetPerson;
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
	public String getStorages() {
		return storages;
	}
	public void setStorages(String storages) {
		this.storages = storages;
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
	public String getEvectionType() {
		return evectionType;
	}
	public void setEvectionType(String evectionType) {
		this.evectionType = evectionType;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public String getCod() {
		return cod;
	}
	public void setCod(String cod) {
		this.cod = cod;
	}
	public String getDeptPerson() {
		return deptPerson;
	}
	public void setDeptPerson(String deptPerson) {
		this.deptPerson = deptPerson;
	}




	public String getBusinessDays() {
		return businessDays;
	}

	public void setBusinessDays(String businessDays) {
		this.businessDays = businessDays;
	}

	public String getExaminePerson() {
		return examinePerson;
	}

	public void setExaminePerson(String examinePerson) {
		this.examinePerson = examinePerson;
	}

	/**
     * evectionId繧定ｿ泌唆縺吶ｋ縲�
     *
     * @return 菫晄戟縺吶ｋevectionId
     */
	public String getEvectionId() {
		return evectionId;
	}

	/**
     * evectionId繧定ｨｭ螳壹☆繧九�
     *
     * @param evectionId 蜃ｺ蠑ｵ逡ｪ蜿ｷ
     */
	public void setEvectionId(String evectionId) {
		this.evectionId = evectionId;
	}


	/**
     * userId繧定ｿ泌唆縺吶ｋ縲�
     *
     * @return 菫晄戟縺吶ｋuserId
     */
	public String getUserId() {
		return userId;
	}


	/**
     * userId繧定ｨｭ螳壹☆繧九�
     *
     * @param userId 繝ｦ繝ｼ繧ｶID
     */
	public void setUserId(String userId) {
		this.userId = userId;
	}


	public String getUser_Name() {
		return user_Name;
	}
	public void setUser_Name(String user_Name) {
		this.user_Name = user_Name;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	/**
     * deptId繧定ｿ泌唆縺吶ｋ縲�
     *
     * @return 菫晄戟縺吶ｋdeptId
     */
	public String getDeptId() {
		return deptId;
	}

	/**
     * deptId繧定ｨｭ螳壹☆繧九�
     *
     * @param deptId 謇�ｱ樣Κ髢�
     */
	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}


	/**
     * evectionStartTime繧定ｿ泌唆縺吶ｋ縲�
     *
     * @return 菫晄戟縺吶ｋevectionStartTime
     */
	public String getEvectionStartTime() {
		return evectionStartTime;
	}

	/**
     * evectionStartTime繧定ｨｭ螳壹☆繧九�
     *
     * @param evectionStartTime 髢句ｧ区凾髢�
     */
	public void setEvectionStartTime(String evectionStartTime) {
		this.evectionStartTime = evectionStartTime;
	}

	/**
     * evectionEndTime繧定ｿ泌唆縺吶ｋ縲�
     *
     * @return 菫晄戟縺吶ｋevectionEndTime
     */
	public String getEvectionEndTime() {
		return evectionEndTime;
	}

	/**
     * evectionEndTime繧定ｨｭ螳壹☆繧九�
     *
     * @param evectionEndTime 邨ら椚譎る俣
     */
	public void setEvectionEndTime(String evectionEndTime) {
		this.evectionEndTime = evectionEndTime;
	}


	/**
     * evectionDestination繧定ｿ泌唆縺吶ｋ縲�
     *
     * @return 菫晄戟縺吶ｋevectionDestination
     */
	public String getEvectionDestination() {
		return evectionDestination;
	}

	/**
     * evectionDestination繧定ｨｭ螳壹☆繧九�
     *
     * @param evectionDestination 蜃ｺ蟾ｮ蝨ｰ
     */
	public void setEvectionDestination(String evectionDestination) {
		this.evectionDestination = evectionDestination;
	}

	/**
     * evectionReason繧定ｿ泌唆縺吶ｋ縲�
     *
     * @return 菫晄戟縺吶ｋevectionReason
     */
	public String getEvectionReason() {
		return evectionReason;
	}

	/**
     * evectionReason繧定ｨｭ螳壹☆繧九�
     *
     * @param evectionReason 蜃ｺ蟾ｮ蜴溷屏
     */
	public void setEvectionReason(String evectionReason) {
		this.evectionReason = evectionReason;
	}

	/**
     * creDateTm繧定ｿ泌唆縺吶ｋ縲�
     *
     * @return 菫晄戟縺吶ｋcreDateTm
     */
	public String getCreDateTm() {
		return creDateTm;
	}


	/**
     * creDateTm繧定ｨｭ螳壹☆繧九�
     *
     * @param creDateTm 逕ｳ隲区凾髢�
     */
	public void setCreDateTm(String creDateTm) {
		this.creDateTm = creDateTm;
	}

	/**
     * examineStatus繧定ｿ泌唆縺吶ｋ縲�
     *
     * @return 菫晄戟縺吶ｋexamineStatus
     */
	public String getExamineStatus() {
		return examineStatus;
	}

	/**
     * examineStatus繧定ｨｭ螳壹☆繧九�
     *
     * @param examineStatus 螳｡譬ｸ迥ｶ諤�
     */
	public void setExamineStatus(String examineStatus) {
		this.examineStatus = examineStatus;
	}

}


