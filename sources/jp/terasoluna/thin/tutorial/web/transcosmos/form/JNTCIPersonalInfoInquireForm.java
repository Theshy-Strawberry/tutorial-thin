package jp.terasoluna.thin.tutorial.web.transcosmos.form;

import java.util.ArrayList;
import java.util.List;

import jp.terasoluna.thin.tutorial.web.transcosmos.dto.JNTCIPersonalInfoInquireInfo;

import org.apache.struts.validator.ValidatorActionForm;

public class JNTCIPersonalInfoInquireForm extends ValidatorActionForm{

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	//卡号
	private String id_card;
	private String jn_card;
	//卡号（删除操作）
	private String deleteId_card;
	private String cardnum;//单纯用于传用于检索条件的卡号
	//姓名
	private String userName;

	//部门
	private String department;

	//入社时间——开始
	private String entryTime_Begin;

	//入社时间——结束
	private String entryTime_End;
	private String entryTime;
	//数据总条数
	private Integer totalCount = 0;

	//开始下标
	private Integer startIndex = 0;
	private String out_time;
	//每页条数
	private Integer row = 10;

    private String cod = null;
    private String zhuangtai;

	public String getZhuangtai() {
		return zhuangtai;
	}
	public void setZhuangtai(String zhuangtai) {
		this.zhuangtai = zhuangtai;
	}
	public String getOut_time() {
		return out_time;
	}
	public void setOut_time(String out_time) {
		this.out_time = out_time;
	}
	public String getEntryTime() {
		return entryTime;
	}
	public void setEntryTime(String entryTime) {
		this.entryTime = entryTime;
	}
	public String getJn_card() {
		return jn_card;
	}
	public void setJn_card(String jn_card) {
		this.jn_card = jn_card;
	}
	public String getCod() {
		return cod;
	}
	public void setCod(String cod) {
		this.cod = cod;
	}

	//数据集合
	private List<JNTCIPersonalInfoInquireInfo> personalInfos = new ArrayList<JNTCIPersonalInfoInquireInfo>();

	public String getCardnum() {
		return cardnum;
	}
	public void setCardnum(String cardnum) {
		this.cardnum = cardnum;
	}
	public String getId_card() {
		return id_card;
	}

	public void setId_card(String id_card) {
		this.id_card = id_card;
	}

	public String getDeleteId_card() {
		return deleteId_card;
	}

	public void setDeleteId_card(String deleteId_card) {
		this.deleteId_card = deleteId_card;
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

	public Integer getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}

	public Integer getStartIndex() {
		return startIndex;
	}

	public void setStartIndex(Integer startIndex) {
		this.startIndex = startIndex;
	}

	public List<JNTCIPersonalInfoInquireInfo> getPersonalInfos() {
		return personalInfos;
	}

	public void setPersonalInfos(List<JNTCIPersonalInfoInquireInfo> personalInfos) {
		this.personalInfos = personalInfos;
	}

	public Integer getRow() {
		return row;
	}

	public void setRow(Integer row) {
		this.row = row;
	}



}
