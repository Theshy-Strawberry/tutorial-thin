package jp.terasoluna.thin.tutorial.web.transcosmos.form;


import java.util.List;

import jp.terasoluna.fw.web.struts.form.ValidatorActionFormEx;
import jp.terasoluna.thin.tutorial.web.transcosmos.vo.JNTCIEquip02equip;
import jp.terasoluna.thin.tutorial.web.transcosmos.vo.JNTCIEquip02equipType;
import jp.terasoluna.thin.tutorial.web.transcosmos.vo.SelectSetsubiShinsa;

public class JNTCIEquip02Form extends ValidatorActionFormEx
{
	private static final long serialVersionUID = 1L;
	private String id = null;
	private String name = null;
	private String dept = null;
	private String deptName = null;
	private String equipType = null;
	private String equip = null;
	private String code="0";
	private String reason = null;
	private String time1=null;
	private String yichang=null;
	private String hiddenstate=null;
    private String nil=null;
    private String shinseiNo=null;
    private String shinsaNo=null;
    private String admin=null;
    private List<SelectSetsubiShinsa> offic_mail=null;
    private String mailperson=null;
	public String getMailperson() {
		return mailperson;
	}
	public void setMailperson(String mailperson) {
		this.mailperson = mailperson;
	}
	public List<SelectSetsubiShinsa> getOffic_mail() {
		return offic_mail;
	}
	public void setOffic_mail(List<SelectSetsubiShinsa> offic_mail) {
		this.offic_mail = offic_mail;
	}
	public String getAdmin() {
		return admin;
	}
	public void setAdmin(String admin) {
		this.admin = admin;
	}
	public String getShinsaNo() {
		return shinsaNo;
	}
	public void setShinsaNo(String shinsaNo) {
		this.shinsaNo = shinsaNo;
	}
	public String getShinseiNo() {
		return shinseiNo;
	}
	public void setShinseiNo(String shinseiNo) {
		this.shinseiNo = shinseiNo;
	}
	public String getNil() {
		return nil;
	}
	public void setNil(String nil) {
		this.nil = nil;
	}
	public String getHiddenstate() {
		return hiddenstate;
	}
	public void setHiddenstate(String hiddenstate) {
		this.hiddenstate = hiddenstate;
	}
	public String getYichang() {
		return yichang;
	}
	public void setYichang(String yichang) {
		this.yichang = yichang;
	}
	private List<JNTCIEquip02equip> jNTCIEquip02equip = null;



	public List<JNTCIEquip02equip> getjNTCIEquip02equip() {
		return jNTCIEquip02equip;
	}
	public void setjNTCIEquip02equip(List<JNTCIEquip02equip> jNTCIEquip02equip) {
		this.jNTCIEquip02equip = jNTCIEquip02equip;
	}
	public String getTime1() {
		return time1;
	}
	public void setTime1(String time1) {
		this.time1 = time1;
	}
	private List<JNTCIEquip02equip> equipList = null;
	public List<JNTCIEquip02equip> getEquipList() {
		return equipList;
	}
	public void setEquipList(List<JNTCIEquip02equip> equipList) {
		this.equipList = equipList;
	}
	private List<JNTCIEquip02equipType> equipTypeList = null;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}

	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public String getEquipType() {
		return equipType;
	}
	public void setEquipType(String equipType) {
		this.equipType = equipType;
	}
	public String getEquip() {
		return equip;
	}
	public void setEquip(String equip) {
		this.equip = equip;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}

	public List<JNTCIEquip02equipType> getEquipTypeList() {
		return equipTypeList;
	}
	public void setEquipTypeList(List<JNTCIEquip02equipType> equipTypeList) {
		this.equipTypeList = equipTypeList;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}



}
