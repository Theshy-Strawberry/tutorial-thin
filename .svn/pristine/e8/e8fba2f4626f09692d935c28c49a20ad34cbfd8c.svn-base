package jp.terasoluna.thin.tutorial.web.transcosmos.form;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jp.terasoluna.fw.web.struts.form.ValidatorActionFormEx;
import jp.terasoluna.thin.tutorial.web.transcosmos.dto.JNTCIPersonalInfoLoginOccupation;
import jp.terasoluna.thin.tutorial.web.transcosmos.dto.JNTCIPersonalInfoLoginWork;
import jp.terasoluna.thin.tutorial.web.transcosmos.dto.JNTCIPersonalInfoLoginworkStr;
import jp.terasoluna.thin.tutorial.web.transcosmos.dto.JNTCIPersonalInfoLoginDataBase;
import jp.terasoluna.thin.tutorial.web.transcosmos.dto.JNTCIPersonalInfoLoginEditTool;
import jp.terasoluna.thin.tutorial.web.transcosmos.dto.JNTCIPersonalInfoLoginJEnvirnment;
import jp.terasoluna.thin.tutorial.web.transcosmos.dto.JNTCIPersonalInfoLoginLanguage;
import jp.terasoluna.thin.tutorial.web.transcosmos.dto.JNTCIPersonalInfoLoginOperatSys;
import jp.terasoluna.thin.tutorial.web.transcosmos.dto.JNTCIPersonalInfoLoginjLanguage;










import org.apache.struts.upload.FormFile;

public class JNTCIPersonalInfoLoginForm extends ValidatorActionFormEx {
  	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private String count = null;
  	private String checkResult = null;
  	private String leader = null;
	private String deptPerson = null;
	private String out_Time = null;
	 private String id_card;
	 private String SYAHO_JIKAN=null;

	  	public String getSYAHO_JIKAN() {
		return SYAHO_JIKAN;
	}

	public void setSYAHO_JIKAN(String sYAHO_JIKAN) {
		SYAHO_JIKAN = sYAHO_JIKAN;
	}
		private String jn_card;
	  	private String cardnum;//单纯用于传用于检索条件的卡号
	  	//入社时间——开始
	  	private String entryTime_Begin;
	  	//入社时间——结束
	  	private String entryTime_End;
	  	private Integer startIndex;

	public String getId_card() {
			return id_card;
		}

		public void setId_card(String id_card) {
			this.id_card = id_card;
		}

		public String getJn_card() {
			return jn_card;
		}

		public void setJn_card(String jn_card) {
			this.jn_card = jn_card;
		}

		public String getCardnum() {
			return cardnum;
		}

		public void setCardnum(String cardnum) {
			this.cardnum = cardnum;
		}

		public String getEntryTime_Begin() {
			return entryTime_Begin;
		}

		public void setEntryTime_Begin(String entryTime_Begin) {
			this.entryTime_Begin = entryTime_Begin;
		}

		public String getEntryTime_End() {
			return entryTime_End;
		}

		public void setEntryTime_End(String entryTime_End) {
			this.entryTime_End = entryTime_End;
		}

		public Integer getStartIndex() {
			return startIndex;
		}

		public void setStartIndex(Integer startIndex) {
			this.startIndex = startIndex;
		}

	public String getOut_Time() {
		return out_Time;
	}

	public void setOut_Time(String out_Time) {
		this.out_Time = out_Time;
	}

	public String getLeader() {
		return leader;
	}

	public void setLeader(String leader) {
		this.leader = leader;
	}

	public String getDeptPerson() {
		return deptPerson;
	}

	public void setDeptPerson(String deptPerson) {
		this.deptPerson = deptPerson;
	}
  	public String getCheckResult() {
		return checkResult;
	}
	public void setCheckResult(String checkResult) {
		this.checkResult = checkResult;
	}
	private String socialSecurity = null;


	public String getSocialSecurity() {
		return socialSecurity;
	}
	public void setSocialSecurity(String socialSecurity) {
		this.socialSecurity = socialSecurity;
	}
	public String getCount() {
		return count;
	}
	public void setCount(String count) {
		this.count = count;
	}
	//更新状態
		private String status;

		public String getStatus() {
			return status;
		}
		public void setStatus(String status) {
			this.status = status;
		}

	private String password = null;
	//浠曚簨绲岄〒闆嗗悎
	 private String list = null;
		private String userId = null;
	public String getUserId() {
			return userId;
		}
		public void setUserId(String userId) {
			this.userId = userId;
		}


	//澶╂触銈兗銉�
    private String tj_Card = null;
    //娓堝崡銈兗銉�
    private String jn_Card = null;
    //鍚嶅墠
    private String userName = null;
    //鎬у埆
    private String sex = null;
    //鐢熴伨銈屽勾鏈堛伄鏃�
    private String birthday = null;
    //姘戞棌
    private String nation = null;
    //韬垎瑷兼槑鏇�
    private String id_Card = null;
    //鍑鸿韩
    private String born_In = null;
    //瑭崇窗銇綇鎵�
    private String address = null;
    //閫ｇ怠闆昏┍
    private String telephone = null;
    //绶婃�閫ｇ怠鍏�
    private String emerg_Contact = null;
    //绶婃�閫ｇ怠鍏堥浕瑭�
    private String emerg_Contact_tel = null;
    //閮ㄩ杸
    private String department = null;
    //銉濄偣銉�
    private String position = null;
    //鍏ョぞ鏅傞枔
    private String entry_Time = null;
    //濠氬Щ鐘舵硜
    private String marital_Status = null;
    //瀛︽
    private String education = null;
    //鏃ユ湰瑾炪伄鍚嶅墠
    private String jn_Name = null;
    //鍥界睄
    private String nationality = null;
    //鍊嬩汉銉°兗銉儨銉冦偗銈�
    private String pesonal_Mall = null;
    //绀惧唴銉°兗銉儨銉冦偗銈�
    private String offic_Mail = null;
    //鎶�鍔�
    private String tech_capability = null;
    //銉戙偣銉濄兗銉�
    private String passport = null;
    //銉撱偠
    private String visa = null;
    //鑱锋キ璩囨牸
    private String vaca_quali = null;
  	//鑱锋キ璩囨牸闆嗗悎
  	private String qualificationStr = null;
    //浣滄キ绲岄〒
    private String work_Experience = null;
    //浣滄キ骞撮檺
  	private String work_time = null;
    //浣滄キ绲岄〒闆嗗悎
    private String work_ExperienceStr = null;
    //鍐欑湡
	private FormFile uploadFile = null;
	//
	private String photo_Path = null;
	private String photo_Path_Old = null;
    //鐗归暦
    private String specialty = null;
    //鍌欒�
    private String remarks = null;

    private  List<JNTCIPersonalInfoLoginOccupation> occupation = new ArrayList<JNTCIPersonalInfoLoginOccupation>();

    //TT_VOCATIONAL_QUALI 鑱锋キ璩囨牸琛�

    //鍙楄碁鏃ヤ粯
    private String winning_date = null;
    //鍙楄碁瑷兼浉
    private String wining_certificate = null;

	public List<JNTCIPersonalInfoLoginOccupation> getOccupation() {
		return occupation;
	}
	public void setOccupation(List<JNTCIPersonalInfoLoginOccupation> occupation) {
		this.occupation = occupation;
	}


    //TT_WORK_EXPERIENCE 浠曚簨绲岄〒

    //闋嗗簭鐣彿
    private Integer order_no = null;
    //妤ó
    private String careers_type = null;
    //銉椼儹銈搞偍銈儓鍚�
    private String proj_name = null;
    //鍙傚姞浜烘暟
    private String attend_nm = null;
    //鍙傚姞浜烘湀
    private String attend_month = null;
   //鍙傚姞褰㈡厠
    private String attend_states = null;
    //闁嬬櫤锞岋姜锝帮浇锞�
    private String develop_phase = null;
    //妤嫏鍐呭
    private String firm_content = null;
    //浣跨敤瑷�獮鍙娿伋銉勩兗銉�
    private String lang_tool = null;
    //DB
    private String data_base = null;
    //OS
    private String technical_sys = null;
    //姗熺ó鍙娿伋浣跨敤銉囥儛銈ゃ偣
    private String model_device = null;
    //闁嬬櫤鎷呭綋鏈熼枔
    private String develop_period = null;
    //鍚堣▓鏈熼枔
    private String total_period = null;



    public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public String getJavalanguage() {
		return javalanguage;
	}
	public void setJavalanguage(String javalanguage) {
		this.javalanguage = javalanguage;
	}
	public String getJavaenvironment() {
		return javaenvironment;
	}
	public void setJavaenvironment(String javaenvironment) {
		this.javaenvironment = javaenvironment;
	}
	public String getTool() {
		return tool;
	}
	public void setTool(String tool) {
		this.tool = tool;
	}
	public String getDb() {
		return db;
	}
	public void setDb(String db) {
		this.db = db;
	}
	public String getOs() {
		return os;
	}
	public void setOs(String os) {
		this.os = os;
	}
	public String getJapaneselevel() {
		return japaneselevel;
	}
	public void setJapaneselevel(String japaneselevel) {
		this.japaneselevel = japaneselevel;
	}
	public String getEnglishlevel() {
		return englishlevel;
	}
	public void setEnglishlevel(String englishlevel) {
		this.englishlevel = englishlevel;
	}
	public String getLanguageStr() {
		return languageStr;
	}
	public void setLanguageStr(String languageStr) {
		this.languageStr = languageStr;
	}
	public String getYanyu() {
		return yanyu;
	}
	public void setYanyu(String yanyu) {
		this.yanyu = yanyu;
	}
	public String getJavahuanjing() {
		return javahuanjing;
	}
	public void setJavahuanjing(String javahuanjing) {
		this.javahuanjing = javahuanjing;
	}
	public String getYuyan() {
		return yuyan;
	}
	public void setYuyan(String yuyan) {
		this.yuyan = yuyan;
	}
	public Integer getPersoninfoid() {
		return personinfoid;
	}
	public void setPersoninfoid(Integer personinfoid) {
		this.personinfoid = personinfoid;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getJavaenvironmentStr() {
		return javaenvironmentStr;
	}
	public void setJavaenvironmentStr(String javaenvironmentStr) {
		this.javaenvironmentStr = javaenvironmentStr;
	}
	public String getJavalanguageStr() {
		return javalanguageStr;
	}
	public void setJavalanguageStr(String javalanguageStr) {
		this.javalanguageStr = javalanguageStr;
	}
	public String getJavayuyan() {
		return javayuyan;
	}
	public void setJavayuyan(String javayuyan) {
		this.javayuyan = javayuyan;
	}
	public String getToolid() {
		return toolid;
	}
	public void setToolid(String toolid) {
		this.toolid = toolid;
	}
	public String getToolStr() {
		return toolStr;
	}
	public void setToolStr(String toolStr) {
		this.toolStr = toolStr;
	}
	public String getDbid() {
		return dbid;
	}
	public void setDbid(String dbid) {
		this.dbid = dbid;
	}
	public String getDbStr() {
		return dbStr;
	}
	public void setDbStr(String dbStr) {
		this.dbStr = dbStr;
	}
	public String getOsid() {
		return osid;
	}
	public void setOsid(String osid) {
		this.osid = osid;
	}
	public String getOsStr() {
		return osStr;
	}
	public void setOsStr(String osStr) {
		this.osStr = osStr;
	}
	public String getJapanl() {
		return japanl;
	}
	public void setJapanl(String japanl) {
		this.japanl = japanl;
	}
	public String getJapanStr() {
		return japanStr;
	}
	public void setJapanStr(String japanStr) {
		this.japanStr = japanStr;
	}
	public String getJapan() {
		return japan;
	}
	public void setJapan(String japan) {
		this.japan = japan;
	}
	public String getEnglishl() {
		return englishl;
	}
	public void setEnglishl(String englishl) {
		this.englishl = englishl;
	}
	public String getEnglishStr() {
		return englishStr;
	}
	public void setEnglishStr(String englishStr) {
		this.englishStr = englishStr;
	}
	public String getEnglish() {
		return english;
	}
	public void setEnglish(String english) {
		this.english = english;
	}

	private String languageStr =null;
	private String javalanguage =null;
	private String language2 = null;
	private String level =null;
    private String javaenvironment = null;
    private String tool = null;
    private String db = null;
    private String os = null;
    private String japaneselevel = null;
    private String englishlevel = null;
    private String yanyu = null;
    private String javahuanjing = null;
    private String yuyan = null;
    private Integer personinfoid =null;
    private Integer id =null;
    private String javaenvironmentStr = null;
    private String javalanguageStr = null;
    private String javayuyan = null;
    private String toolid = null;
    private String toolStr = null;
    private String dbid = null;
    private String dbStr = null;
    private String osid = null;
    private String osStr = null;
    private String japanl = null;
    private String japanStr = null;
    private String japan = null;
    private String englishl = null;
    private String englishStr = null;
    private String english = null;

    private  List<JNTCIPersonalInfoLoginLanguage> language = new ArrayList<JNTCIPersonalInfoLoginLanguage>();

    private  List<JNTCIPersonalInfoLoginJEnvirnment> jEnvirnment = new ArrayList<JNTCIPersonalInfoLoginJEnvirnment>();

    private  List<JNTCIPersonalInfoLoginjLanguage> jLanguage = new ArrayList<JNTCIPersonalInfoLoginjLanguage>();

    private  List<JNTCIPersonalInfoLoginEditTool> editTool = new ArrayList<JNTCIPersonalInfoLoginEditTool>();

    private  List<JNTCIPersonalInfoLoginDataBase> dataBase = new ArrayList<JNTCIPersonalInfoLoginDataBase>();


    private  List<JNTCIPersonalInfoLoginOperatSys> operatSys = new ArrayList<JNTCIPersonalInfoLoginOperatSys>();

    private String[] jap_skill = null;

 	private String jap_level = null;

 	private String[] eng_skill = null;

 	private String eng_level = null;

	public List<JNTCIPersonalInfoLoginLanguage> getLanguage() {
		return language;
	}
	public void setLanguage(List<JNTCIPersonalInfoLoginLanguage> language) {
		this.language = language;
	}
	public List<JNTCIPersonalInfoLoginJEnvirnment> getjEnvirnment() {
		return jEnvirnment;
	}
	public void setjEnvirnment(List<JNTCIPersonalInfoLoginJEnvirnment> jEnvirnment) {
		this.jEnvirnment = jEnvirnment;
	}
	public List<JNTCIPersonalInfoLoginjLanguage> getjLanguage() {
		return jLanguage;
	}
	public void setjLanguage(List<JNTCIPersonalInfoLoginjLanguage> jLanguage) {
		this.jLanguage = jLanguage;
	}
	public List<JNTCIPersonalInfoLoginEditTool> getEditTool() {
		return editTool;
	}
	public void setEditTool(List<JNTCIPersonalInfoLoginEditTool> editTool) {
		this.editTool = editTool;
	}
	public List<JNTCIPersonalInfoLoginDataBase> getDataBase() {
		return dataBase;
	}
	public void setDataBase(List<JNTCIPersonalInfoLoginDataBase> dataBase) {
		this.dataBase = dataBase;
	}
	public List<JNTCIPersonalInfoLoginOperatSys> getOperatSys() {
		return operatSys;
	}
	public void setOperatSys(List<JNTCIPersonalInfoLoginOperatSys> operatSys) {
		this.operatSys = operatSys;
	}
	public String[] getJap_skill() {
		return jap_skill;
	}
	public void setJap_skill(String[] jap_skill) {
		this.jap_skill = jap_skill;
	}
	public String getJap_level() {
		return jap_level;
	}
	public void setJap_level(String jap_level) {
		this.jap_level = jap_level;
	}
	public String[] getEng_skill() {
		return eng_skill;
	}
	public void setEng_skill(String[] eng_skill) {
		this.eng_skill = eng_skill;
	}
	public String getEng_level() {
		return eng_level;
	}
	public void setEng_level(String eng_level) {
		this.eng_level = eng_level;
	}
	public String getLanguage2() {
		return language2;
	}
	public void setLanguage2(String language2) {
		this.language2 = language2;
	}


	private  List<JNTCIPersonalInfoLoginWork> workList = new ArrayList<JNTCIPersonalInfoLoginWork>();

    private  List<JNTCIPersonalInfoLoginworkStr> workStr = new ArrayList<JNTCIPersonalInfoLoginworkStr>();

    //鏀捐矾寰�
    private Boolean disable = null;
    //鏀綽utton鍚嶅瓧
    private String button_name = null;

    //鐧婚尣銇嬩慨姝ｃ亱鍒ゆ柇
  	private Integer judge_flg = null;

    //鐧婚尣鏅傞枔
  	private Date login_time = null;
  	//鏇存柊鏅傞枔
  	private Date update_time = null;

 // 銈裤偆銉�
 	private String type = null;
 	// 鍥藉銈炽兗銉�
 	private String countryCode = null;
 	// 銉戙偣銉濄兗銉堝彿
 	private String passportNo = null;
 	// 鐧鸿鏃ヤ粯
 	private String issueDate = null;
 	// 鏈夊姽鏈熻嚦
 	private String expiryDate = null;
 	// 鐧鸿姗熼枹
 	private String authority = null;
 	// 鐧鸿鍫存墍
 	private String issuePlace = null;

	public String getTj_Card() {
		return tj_Card;
	}
	public void setTj_Card(String tj_Card) {
		this.tj_Card = tj_Card;
	}
	public String getJn_Card() {
		return jn_Card;
	}
	public void setJn_Card(String jn_Card) {
		this.jn_Card = jn_Card;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getNation() {
		return nation;
	}
	public void setNation(String nation) {
		this.nation = nation;
	}
	public String getId_Card() {
		return id_Card;
	}
	public void setId_Card(String id_Card) {
		this.id_Card = id_Card;
	}
	public String getBorn_In() {
		return born_In;
	}
	public void setBorn_In(String born_In) {
		this.born_In = born_In;
	}


	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getEmerg_Contact() {
		return emerg_Contact;
	}
	public void setEmerg_Contact(String emerg_Contact) {
		this.emerg_Contact = emerg_Contact;
	}
	public String getEmerg_Contact_tel() {
		return emerg_Contact_tel;
	}
	public void setEmerg_Contact_tel(String emerg_Contact_tel) {
		this.emerg_Contact_tel = emerg_Contact_tel;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getEntry_Time() {
		return entry_Time;
	}
	public void setEntry_Time(String entry_Time) {
		this.entry_Time = entry_Time;
	}
	public String getMarital_Status() {
		return marital_Status;
	}
	public void setMarital_Status(String marital_Status) {
		this.marital_Status = marital_Status;
	}
	public String getEducation() {
		return education;
	}
	public void setEducation(String education) {
		this.education = education;
	}
	public String getJn_Name() {
		return jn_Name;
	}
	public void setJn_Name(String jn_Name) {
		this.jn_Name = jn_Name;
	}
	public String getNationality() {
		return nationality;
	}
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	public String getPesonal_Mall() {
		return pesonal_Mall;
	}
	public void setPesonal_Mall(String pesonal_Mall) {
		this.pesonal_Mall = pesonal_Mall;
	}
	public String getOffic_Mail() {
		return offic_Mail;
	}
	public void setOffic_Mail(String offic_Mail) {
		this.offic_Mail = offic_Mail;
	}
	public String getTech_capability() {
		return tech_capability;
	}
	public void setTech_capability(String tech_capability) {
		this.tech_capability = tech_capability;
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
	public String getVaca_quali() {
		return vaca_quali;
	}
	public void setVaca_quali(String vaca_quali) {
		this.vaca_quali = vaca_quali;
	}

	public String getQualificationStr() {
		return qualificationStr;
	}
	public void setQualificationStr(String qualificationStr) {
		this.qualificationStr = qualificationStr;
	}
	public String getWork_Experience() {
		return work_Experience;
	}
	public void setWork_Experience(String work_Experience) {
		this.work_Experience = work_Experience;
	}

	public String getWork_time() {
		return work_time;
	}
	public void setWork_time(String work_time) {
		this.work_time = work_time;
	}
	public String getWork_ExperienceStr() {
		return work_ExperienceStr;
	}
	public void setWork_ExperienceStr(String work_ExperienceStr) {
		this.work_ExperienceStr = work_ExperienceStr;
	}
	public FormFile getUploadFile() {
		return uploadFile;
	}
	public void setUploadFile(FormFile uploadFile) {
		this.uploadFile = uploadFile;
	}

	public String getPhoto_Path() {
		return photo_Path;
	}
	public void setPhoto_Path(String photo_Path) {
		this.photo_Path = photo_Path;
	}
	public String getSpecialty() {
		return specialty;
	}
	public void setSpecialty(String specialty) {
		this.specialty = specialty;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public String getWinning_date() {
		return winning_date;
	}
	public void setWinning_date(String winning_date) {
		this.winning_date = winning_date;
	}


	public String getWining_certificate() {
		return wining_certificate;
	}
	public void setWining_certificate(String wining_certificate) {
		this.wining_certificate = wining_certificate;
	}

	public Integer getOrder_no() {
		return order_no;
	}
	public void setOrder_no(Integer order_no) {
		this.order_no = order_no;
	}
	public String getCareers_type() {
		return careers_type;
	}
	public void setCareers_type(String careers_type) {
		this.careers_type = careers_type;
	}
	public String getProj_name() {
		return proj_name;
	}
	public void setProj_name(String proj_name) {
		this.proj_name = proj_name;
	}
	public String getAttend_nm() {
		return attend_nm;
	}
	public void setAttend_nm(String attend_nm) {
		this.attend_nm = attend_nm;
	}
	public String getAttend_month() {
		return attend_month;
	}
	public void setAttend_month(String attend_month) {
		this.attend_month = attend_month;
	}
	public String getAttend_states() {
		return attend_states;
	}
	public void setAttend_states(String attend_states) {
		this.attend_states = attend_states;
	}
	public String getDevelop_phase() {
		return develop_phase;
	}
	public void setDevelop_phase(String develop_phase) {
		this.develop_phase = develop_phase;
	}
	public String getFirm_content() {
		return firm_content;
	}
	public void setFirm_content(String firm_content) {
		this.firm_content = firm_content;
	}
	public String getLang_tool() {
		return lang_tool;
	}
	public void setLang_tool(String lang_tool) {
		this.lang_tool = lang_tool;
	}
	public String getData_base() {
		return data_base;
	}
	public void setData_base(String data_base) {
		this.data_base = data_base;
	}
	public String getTechnical_sys() {
		return technical_sys;
	}
	public void setTechnical_sys(String technical_sys) {
		this.technical_sys = technical_sys;
	}
	public String getModel_device() {
		return model_device;
	}
	public void setModel_device(String model_device) {
		this.model_device = model_device;
	}
	public String getDevelop_period() {
		return develop_period;
	}
	public void setDevelop_period(String develop_period) {
		this.develop_period = develop_period;
	}
	public String getTotal_period() {
		return total_period;
	}
	public void setTotal_period(String total_period) {
		this.total_period = total_period;
	}

	public Boolean getDisable() {
		return disable;
	}
	public void setDisable(Boolean disable) {
		this.disable = disable;
	}
	public String getButton_name() {
		return button_name;
	}
	public void setButton_name(String button_name) {
		this.button_name = button_name;
	}
	public Integer getJudge_flg() {
		return judge_flg;
	}
	public void setJudge_flg(Integer judge_flg) {
		this.judge_flg = judge_flg;
	}
	public String getList() {
		return list;
	}
	public void setList(String list) {
		this.list = list;
	}
	public List<JNTCIPersonalInfoLoginWork> getWorkList() {
		return workList;
	}
	public void setWorkList(List<JNTCIPersonalInfoLoginWork> workList) {
		this.workList = workList;
	}
	public List<JNTCIPersonalInfoLoginworkStr> getWorkStr() {
		return workStr;
	}
	public void setWorkStr(List<JNTCIPersonalInfoLoginworkStr> workStr) {
		this.workStr = workStr;
	}
	public Date getLogin_time() {
		return login_time;
	}
	public void setLogin_time(Date login_time) {
		this.login_time = login_time;
	}
	public Date getUpdate_time() {
		return update_time;
	}
	public void setUpdate_time(Date update_time) {
		this.update_time = update_time;
	}
	public String getPhoto_Path_Old() {
		return photo_Path_Old;
	}
	public void setPhoto_Path_Old(String photo_Path_Old) {
		this.photo_Path_Old = photo_Path_Old;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getCountryCode() {
		return countryCode;
	}
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	public String getPassportNo() {
		return passportNo;
	}
	public void setPassportNo(String passportNo) {
		this.passportNo = passportNo;
	}
	public String getIssueDate() {
		return issueDate;
	}
	public void setIssueDate(String issueDate) {
		this.issueDate = issueDate;
	}
	public String getExpiryDate() {
		return expiryDate;
	}
	public void setExpiryDate(String expiryDate) {
		this.expiryDate = expiryDate;
	}
	public String getAuthority() {
		return authority;
	}
	public void setAuthority(String authority) {
		this.authority = authority;
	}
	public String getIssuePlace() {
		return issuePlace;
	}
	public void setIssuePlace(String issuePlace) {
		this.issuePlace = issuePlace;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

}
