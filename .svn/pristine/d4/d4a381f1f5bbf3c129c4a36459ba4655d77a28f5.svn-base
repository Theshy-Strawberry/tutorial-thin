package jp.terasoluna.thin.tutorial.web.transcosmos.form;

import java.util.ArrayList;
import java.util.List;

import jp.terasoluna.thin.tutorial.web.transcosmos.dto.JNTCIPersonalInfoLoginDataBase;
import jp.terasoluna.thin.tutorial.web.transcosmos.dto.JNTCIPersonalInfoLoginEditTool;
import jp.terasoluna.thin.tutorial.web.transcosmos.dto.JNTCIPersonalInfoLoginEnglish;
import jp.terasoluna.thin.tutorial.web.transcosmos.dto.JNTCIPersonalInfoLoginJEnvirnment;
import jp.terasoluna.thin.tutorial.web.transcosmos.dto.JNTCIPersonalInfoLoginJapanese;
import jp.terasoluna.thin.tutorial.web.transcosmos.dto.JNTCIPersonalInfoLoginLanguage;
import jp.terasoluna.thin.tutorial.web.transcosmos.dto.JNTCIPersonalInfoLoginOperatSys;
import jp.terasoluna.thin.tutorial.web.transcosmos.dto.JNTCIPersonalInfoLoginjLanguage;
import jp.terasoluna.thin.tutorial.web.transcosmos.vo.JNTCISelectPersonalInfo;
import jp.terasoluna.thin.tutorial.web.transcosmos.vo.SelectQualificationTR;
import jp.terasoluna.thin.tutorial.web.transcosmos.vo.SelectWorkExperience;

import org.apache.struts.validator.ValidatorActionForm;

public class JNTCIPersonalInfoDetailedForm extends ValidatorActionForm {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    //id_card


    private String entryTime;
    private String out_time;




  //�Q��ID_CARD
    private String userId;
    //id_card
    private String id_card;
  //姓名
  	private String userName;
  	private String jn_card;
  	private String cardnum;//单纯用于传用于检索条件的卡号
  	//部门
  	private String department;

  	//入社时间——开始
  	private String entryTime_Begin;

  	//入社时间——结束
  	private String entryTime_End;

  	private Integer startIndex;
    //個人基本情報
    private JNTCISelectPersonalInfo jntciSelectPersonalInfo = new JNTCISelectPersonalInfo();
    //職業資格
    private List<SelectQualificationTR> qualificationTR = new ArrayList<SelectQualificationTR>();
    //仕事経験
    private List<SelectWorkExperience> workExperience = new ArrayList<SelectWorkExperience>();
    //言语
    private List<JNTCIPersonalInfoLoginLanguage> languagelist = new ArrayList<JNTCIPersonalInfoLoginLanguage>();
    //java环境
    private List<JNTCIPersonalInfoLoginJEnvirnment> envirnmentlist = new ArrayList<JNTCIPersonalInfoLoginJEnvirnment>();
    //java语言
    private List<JNTCIPersonalInfoLoginjLanguage> jlanguagelist = new ArrayList<JNTCIPersonalInfoLoginjLanguage>();
    //tool
    private List<JNTCIPersonalInfoLoginEditTool> editToollist = new ArrayList<JNTCIPersonalInfoLoginEditTool>();
    //db
    private List<JNTCIPersonalInfoLoginDataBase> dataBaselist = new ArrayList<JNTCIPersonalInfoLoginDataBase>();
    //os
    private List<JNTCIPersonalInfoLoginOperatSys> operatSyslist = new ArrayList<JNTCIPersonalInfoLoginOperatSys>();
    //日语
    private JNTCIPersonalInfoLoginJapanese japaneselist = new JNTCIPersonalInfoLoginJapanese();
    //英语
    private JNTCIPersonalInfoLoginEnglish englishlist = new JNTCIPersonalInfoLoginEnglish();
    private String zhuangtai;


	public String getZhuangtai() {
		return zhuangtai;
	}

	public void setZhuangtai(String zhuangtai) {
		this.zhuangtai = zhuangtai;
	}

	public String getCardnum() {
		return cardnum;
	}

	public void setCardnum(String cardnum) {
		this.cardnum = cardnum;
	}

	public String getEntryTime() {
		return entryTime;
	}

	public void setEntryTime(String entryTime) {
		this.entryTime = entryTime;
	}

	public String getOut_time() {
		return out_time;
	}

	public void setOut_time(String out_time) {
		this.out_time = out_time;
	}

	public String getJn_card() {
		return jn_card;
	}

	public void setJn_card(String jn_card) {
		this.jn_card = jn_card;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
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

	public List<JNTCIPersonalInfoLoginLanguage> getLanguagelist() {
		return languagelist;
	}

	public void setLanguagelist(List<JNTCIPersonalInfoLoginLanguage> languagelist) {
		this.languagelist = languagelist;
	}

	public List<JNTCIPersonalInfoLoginJEnvirnment> getEnvirnmentlist() {
		return envirnmentlist;
	}

	public void setEnvirnmentlist(
			List<JNTCIPersonalInfoLoginJEnvirnment> envirnmentlist) {
		this.envirnmentlist = envirnmentlist;
	}

	public List<JNTCIPersonalInfoLoginjLanguage> getJlanguagelist() {
		return jlanguagelist;
	}

	public void setJlanguagelist(List<JNTCIPersonalInfoLoginjLanguage> jlanguagelist) {
		this.jlanguagelist = jlanguagelist;
	}

	public List<JNTCIPersonalInfoLoginEditTool> getEditToollist() {
		return editToollist;
	}

	public void setEditToollist(List<JNTCIPersonalInfoLoginEditTool> editToollist) {
		this.editToollist = editToollist;
	}

	public List<JNTCIPersonalInfoLoginDataBase> getDataBaselist() {
		return dataBaselist;
	}

	public void setDataBaselist(List<JNTCIPersonalInfoLoginDataBase> dataBaselist) {
		this.dataBaselist = dataBaselist;
	}

	public List<JNTCIPersonalInfoLoginOperatSys> getOperatSyslist() {
		return operatSyslist;
	}

	public void setOperatSyslist(List<JNTCIPersonalInfoLoginOperatSys> operatSyslist) {
		this.operatSyslist = operatSyslist;
	}



	public JNTCIPersonalInfoLoginJapanese getJapaneselist() {
		return japaneselist;
	}

	public void setJapaneselist(JNTCIPersonalInfoLoginJapanese japaneselist) {
		this.japaneselist = japaneselist;
	}

	public JNTCIPersonalInfoLoginEnglish getEnglishlist() {
		return englishlist;
	}

	public void setEnglishlist(JNTCIPersonalInfoLoginEnglish englishlist) {
		this.englishlist = englishlist;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	//--------------------------
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getId_card() {
        return id_card;
    }

    public void setId_card(String id_card) {
        this.id_card = id_card;
    }

    public JNTCISelectPersonalInfo getJntciSelectPersonalInfo() {
        return jntciSelectPersonalInfo;
    }

    public void setJntciSelectPersonalInfo(JNTCISelectPersonalInfo jntciSelectPersonalInfo) {
        this.jntciSelectPersonalInfo = jntciSelectPersonalInfo;
    }

    public List<SelectQualificationTR> getQualificationTR() {
        return qualificationTR;
    }

    public void setQualificationTR(List<SelectQualificationTR> qualificationTR) {
        this.qualificationTR = qualificationTR;
    }

    public List<SelectWorkExperience> getWorkExperience() {
        return workExperience;
    }

    public void setWorkExperience(List<SelectWorkExperience> workExperience) {
        this.workExperience = workExperience;
    }

}
