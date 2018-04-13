package jp.terasoluna.thin.tutorial.web.transcosmos.form;


import java.util.List;

import jp.terasoluna.fw.web.struts.form.ValidatorActionFormEx;
import jp.terasoluna.thin.tutorial.web.transcosmos.dto.JNTCIAttendance03Dto;
import jp.terasoluna.thin.tutorial.web.transcosmos.vo.JNTCIBusinessVerifyVo;

public class JNTCIBusinessVerify01Form extends ValidatorActionFormEx{

	 /**
     * 郢ｧ�ｷ郢晢ｽｪ郢ｧ�｢郢晢ｽｫ郢晁��ｽ郢ｧ�ｸ郢晢ｽｧ郢晢ｽｳID邵ｲ�ｽ
     */
    private static final long serialVersionUID = 1L;

    /**
     * 陷�ｽｺ陟托ｽｵ騾｡�ｪ陷ｿ�ｷ邵ｲ�ｽ
     */

    private String evectionId = null;
    private String user_id=null;
    private String uname1=null;
    private String uid1;
    private String back;
    private String backs;
    private String mark;



	public String getMark() {
		return mark;
	}
	public void setMark(String mark) {
		this.mark = mark;
	}
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
	/**
     * 郢晢ｽｦ郢晢ｽｼ郢ｧ�ｶID邵ｲ�ｽ
     */
	private String userId = null;
	private String user_Id = null;
	private String flag;
	/**
     * 郢晢ｽｦ郢晢ｽｼ郢ｧ�ｶ陷ｷ蜥ｲ�ｧ�ｰ邵ｲ�ｽ
     */
	private String user_Name = null;

	private String userName = null;

	/**
     * 隰�ｿｽ�ｱ讓｣ﾎ夐ｫ｢�ｽ�ｽ
     */
	private String deptId = null;

	/**
     * 鬮｢蜿･�ｧ蛹ｺ蜃ｾ鬮｢阮呻ｿｽ
     */
	private String evectionStartTime = null;


	/**
     * 驍ｨ繧画､夊ｭ弱ｋ菫｣邵ｲ�ｽ
     */
	private String evectionEndTime = null;


	/**
     * 陷�ｽｺ陝ｾ�ｮ陜ｨ�ｰ邵ｲ�ｽ
     */
	private String evectionDestination = null;


	/**
     * 陷�ｽｺ陝ｾ�ｮ陷ｴ貅ｷ螻冗ｸｲ�ｽ
     */
	private String evectionReason = null;


	/**
     *騾包ｽｳ髫ｲ蛹ｺ蜃ｾ鬮｢阮呻ｿｽ
     */
	private String creDateTm = null;
	private String examinePerson;
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
	/**
    * 陞ｳ�｡隴ｬ�ｸ霑･�ｶ隲､竏夲ｿｽ
    */
	private String examineStatus = null;

	private String businessDays = null;

	private String deleteId_card;


/*闕ｳ�ｽ�ｦ�ｧ騾包ｽｻ鬮ｱ�｢邵ｺ�ｧ闖ｴ�ｿ騾包ｽｨ邵ｺ蜷ｶ��/

   /**
    * 髯ｦ�ｨ驕会ｽｺ髯ｦ譴ｧ辟夂ｸｲ�ｽ
    */
   private String row = "10";

   /**
    * 鬮｢蜿･�ｧ荵昴≧郢晢ｽｳ郢晢ｿｽ繝｣郢ｧ�ｯ郢ｧ�ｹ邵ｲ�ｽ
    */
   private String startIndex = "0";

   /**
    * 陷茨ｽｨ闔会ｽｶ隰ｨ�ｰ邵ｲ�ｽ
    */
   private String totalCount = null;

	private String tjUserId = null;
	private String sex = null;
	private String deptName = null;
	private String projectPm = null;
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

	private String articleName;
	private String transferStartTime;
	private String transferEndTime;
	private String recipient;
	private String storAges;
	private String passportLength;
	private String articleRemark;

	private String[] article_NAME;


   /**
    * 髯ｦ�ｨ驕会ｽｺ騾包ｽｨ郢晢ｽｦ郢晢ｽｼ郢ｧ�ｶ郢晢ｽｪ郢ｧ�ｹ郢晏現�ｽ
    */
   private List<JNTCIBusinessVerifyVo> JNTCIBusinessVerifyVoInfo = null;

   private List<JNTCIBusinessVerifyVo> examineList = null;

   private List<JNTCIBusinessVerifyVo> deptList = null;

   private String deptPerson;

   private String cod = null;


   /**
    * 总计页数
    */
   private String total = "0";

   /**
    * 当前页数
    */
   private String now = "0";

   private String dept_Id;
   private String examine_Status;




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



public String[] getArticle_NAME() {
	return article_NAME;
}
public void setArticle_NAME(String[] article_NAME) {
	this.article_NAME = article_NAME;
}
public String getExaminePerson() {
	return examinePerson;
}
public void setExaminePerson(String examinePerson) {
	this.examinePerson = examinePerson;
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
	public String getDeptPerson() {
		return deptPerson;
	}
	public void setDeptPerson(String deptPerson) {
		this.deptPerson = deptPerson;
	}


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



public String getBusinessDays() {
	return businessDays;
}

public void setBusinessDays(String businessDays) {
	this.businessDays = businessDays;
}



	/**
     * evectionId郢ｧ螳夲ｽｿ豕悟陪邵ｺ蜷ｶ�狗ｸｲ�ｽ
     *
     * @return 闖ｫ譎�亜邵ｺ蜷ｶ�菊vectionId
     */
	public String getEvectionId() {
		return evectionId;
	}

	/**
     * evectionId郢ｧ螳夲ｽｨ�ｭ陞ｳ螢ｹ笘�ｹｧ荵晢ｿｽ
     *
     * @param evectionId 陷�ｽｺ陟托ｽｵ騾｡�ｪ陷ｿ�ｷ
     */
	public void setEvectionId(String evectionId) {
		this.evectionId = evectionId;
	}


	/**
     * userId郢ｧ螳夲ｽｿ豕悟陪邵ｺ蜷ｶ�狗ｸｲ�ｽ
     *
     * @return 闖ｫ譎�亜邵ｺ蜷ｶ�丘serId
     */
	public String getUserId() {
		return userId;
	}


	/**
     * userId郢ｧ螳夲ｽｨ�ｭ陞ｳ螢ｹ笘�ｹｧ荵晢ｿｽ
     *
     * @param userId 郢晢ｽｦ郢晢ｽｼ郢ｧ�ｶID
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
     * deptId郢ｧ螳夲ｽｿ豕悟陪邵ｺ蜷ｶ�狗ｸｲ�ｽ
     *
     * @return 闖ｫ譎�亜邵ｺ蜷ｶ�掬eptId
     */
	public String getDeptId() {
		return deptId;
	}

	/**
     * deptId郢ｧ螳夲ｽｨ�ｭ陞ｳ螢ｹ笘�ｹｧ荵晢ｿｽ
     *
     * @param deptId 隰�ｿｽ�ｱ讓｣ﾎ夐ｫ｢�ｽ
     */
	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}


	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
	/**
     * evectionStartTime郢ｧ螳夲ｽｿ豕悟陪邵ｺ蜷ｶ�狗ｸｲ�ｽ
     *
     * @return 闖ｫ譎�亜邵ｺ蜷ｶ�菊vectionStartTime
     */
	public String getEvectionStartTime() {
		return evectionStartTime;
	}

	/**
     * evectionStartTime郢ｧ螳夲ｽｨ�ｭ陞ｳ螢ｹ笘�ｹｧ荵晢ｿｽ
     *
     * @param evectionStartTime 鬮｢蜿･�ｧ蛹ｺ蜃ｾ鬮｢�ｽ
     */
	public void setEvectionStartTime(String evectionStartTime) {
		this.evectionStartTime = evectionStartTime;
	}

	/**
     * evectionEndTime郢ｧ螳夲ｽｿ豕悟陪邵ｺ蜷ｶ�狗ｸｲ�ｽ
     *
     * @return 闖ｫ譎�亜邵ｺ蜷ｶ�菊vectionEndTime
     */
	public String getEvectionEndTime() {
		return evectionEndTime;
	}

	/**
     * evectionEndTime郢ｧ螳夲ｽｨ�ｭ陞ｳ螢ｹ笘�ｹｧ荵晢ｿｽ
     *
     * @param evectionEndTime 驍ｨ繧画､夊ｭ弱ｋ菫｣
     */
	public void setEvectionEndTime(String evectionEndTime) {
		this.evectionEndTime = evectionEndTime;
	}


	/**
     * evectionDestination郢ｧ螳夲ｽｿ豕悟陪邵ｺ蜷ｶ�狗ｸｲ�ｽ
     *
     * @return 闖ｫ譎�亜邵ｺ蜷ｶ�菊vectionDestination
     */
	public String getEvectionDestination() {
		return evectionDestination;
	}

	/**
     * evectionDestination郢ｧ螳夲ｽｨ�ｭ陞ｳ螢ｹ笘�ｹｧ荵晢ｿｽ
     *
     * @param evectionDestination 陷�ｽｺ陝ｾ�ｮ陜ｨ�ｰ
     */
	public void setEvectionDestination(String evectionDestination) {
		this.evectionDestination = evectionDestination;
	}

	/**
     * evectionReason郢ｧ螳夲ｽｿ豕悟陪邵ｺ蜷ｶ�狗ｸｲ�ｽ
     *
     * @return 闖ｫ譎�亜邵ｺ蜷ｶ�菊vectionReason
     */
	public String getEvectionReason() {
		return evectionReason;
	}

	/**
     * evectionReason郢ｧ螳夲ｽｨ�ｭ陞ｳ螢ｹ笘�ｹｧ荵晢ｿｽ
     *
     * @param evectionReason 陷�ｽｺ陝ｾ�ｮ陷ｴ貅ｷ螻�
     */
	public void setEvectionReason(String evectionReason) {
		this.evectionReason = evectionReason;
	}

	/**
     * creDateTm郢ｧ螳夲ｽｿ豕悟陪邵ｺ蜷ｶ�狗ｸｲ�ｽ
     *
     * @return 闖ｫ譎�亜邵ｺ蜷ｶ�議reDateTm
     */
	public String getCreDateTm() {
		return creDateTm;
	}


	/**
     * creDateTm郢ｧ螳夲ｽｨ�ｭ陞ｳ螢ｹ笘�ｹｧ荵晢ｿｽ
     *
     * @param creDateTm 騾包ｽｳ髫ｲ蛹ｺ蜃ｾ鬮｢�ｽ
     */
	public void setCreDateTm(String creDateTm) {
		this.creDateTm = creDateTm;
	}


	/**
     * examineStatus郢ｧ螳夲ｽｿ豕悟陪邵ｺ蜷ｶ�狗ｸｲ�ｽ
     *
     * @return 闖ｫ譎�亜邵ｺ蜷ｶ�菊xamineStatus
     */
	public String getExamineStatus() {
		return examineStatus;
	}

	/**
     * examineStatus郢ｧ螳夲ｽｨ�ｭ陞ｳ螢ｹ笘�ｹｧ荵晢ｿｽ
     *
     * @param examineStatus 陞ｳ�｡隴ｬ�ｸ霑･�ｶ隲､�ｽ
     */
	public void setExamineStatus(String examineStatus) {
		this.examineStatus = examineStatus;
	}


	 /**
     * 髯ｦ�ｨ驕会ｽｺ髯ｦ譴ｧ辟夂ｹｧ螳夲ｽｿ豕悟陪邵ｺ蜷ｶ�狗ｸｲ�ｽ
     * @return 髯ｦ�ｨ驕会ｽｺ髯ｦ譴ｧ辟�
     */
    public String getRow() {
        return row;
    }

	 public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public void setRow(String row) {
		this.row = row;
	}

	/**
     * 鬮｢蜿･�ｧ荵昴≧郢晢ｽｳ郢晢ｿｽ繝｣郢ｧ�ｯ郢ｧ�ｹ郢ｧ螳夲ｽｿ豕悟陪邵ｺ蜷ｶ�狗ｸｲ�ｽ
     * @return 鬮｢蜿･�ｧ荵昴≧郢晢ｽｳ郢晢ｿｽ繝｣郢ｧ�ｯ郢ｧ�ｹ
     */
	 public String getStartIndex() {
			return startIndex;
		}

	/**
     * 鬮｢蜿･�ｧ荵昴≧郢晢ｽｳ郢晢ｿｽ繝｣郢ｧ�ｯ郢ｧ�ｹ郢ｧ螳夲ｽｨ�ｭ陞ｳ螢ｹ笘�ｹｧ荵晢ｿｽ
     * @param startIndex 鬮｢蜿･�ｧ荵昴≧郢晢ｽｳ郢晢ｿｽ繝｣郢ｧ�ｯ郢ｧ�ｹ
     */
    public void setStartIndex(String startIndex) {
        this.startIndex = startIndex;
    }

    /**
     * 陷茨ｽｨ闔会ｽｶ隰ｨ�ｰ郢ｧ螳夲ｽｿ豕悟陪邵ｺ蜷ｶ�狗ｸｲ�ｽ
     * @return 陷茨ｽｨ闔会ｽｶ隰ｨ�ｰ
     */
    public String getTotalCount() {
        return totalCount;
    }

    /**
     * 陷茨ｽｨ闔会ｽｶ隰ｨ�ｰ郢ｧ螳夲ｽｿ豕悟陪邵ｺ蜷ｶ�狗ｸｲ�ｽ
     * @param totalCount 陷茨ｽｨ闔会ｽｶ隰ｨ�ｰ
     */
    public void setTotalCount(String totalCount) {
        this.totalCount = totalCount;
    }

    /**
     * 髯ｦ�ｨ驕会ｽｺ騾包ｽｨ郢晢ｽｦ郢晢ｽｼ郢ｧ�ｶ郢晢ｽｪ郢ｧ�ｹ郢晏現�帝恆豕悟陪邵ｺ蜷ｶ�狗ｸｲ�ｽ
     * @return 髯ｦ�ｨ驕会ｽｺ騾包ｽｨ郢晢ｽｦ郢晢ｽｼ郢ｧ�ｶ郢晢ｽｪ郢ｧ�ｹ郢晢ｿｽ
     */

    public List<JNTCIBusinessVerifyVo> getJNTCIBusinessVerifyVoInfo() {
		return JNTCIBusinessVerifyVoInfo;
	}


    /**
     * 髯ｦ�ｨ驕会ｽｺ騾包ｽｨ郢晢ｽｦ郢晢ｽｼ郢ｧ�ｶ郢晢ｽｪ郢ｧ�ｹ郢晏現�帝坎�ｭ陞ｳ螢ｹ笘�ｹｧ荵晢ｿｽ
     * @param users 髯ｦ�ｨ驕会ｽｺ騾包ｽｨ郢晢ｽｦ郢晢ｽｼ郢ｧ�ｶ郢晢ｽｪ郢ｧ�ｹ郢晢ｿｽ
     */
    public void setJNTCIBusinessVerifyVoInfo(
			List<JNTCIBusinessVerifyVo> JNTCIBusinessVerifyVoInfo) {
		this.JNTCIBusinessVerifyVoInfo = JNTCIBusinessVerifyVoInfo;
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

	public String getUser_Id() {
		return user_Id;
	}
	public void setUser_Id(String user_Id) {
		this.user_Id = user_Id;
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

}
