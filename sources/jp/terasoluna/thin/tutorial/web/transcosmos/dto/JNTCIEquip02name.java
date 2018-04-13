package jp.terasoluna.thin.tutorial.web.transcosmos.dto;


import java.util.List;

import jp.terasoluna.fw.web.struts.form.ValidatorActionFormEx;
import jp.terasoluna.thin.tutorial.web.transcosmos.vo.JNTCIEquip02equip;
import jp.terasoluna.thin.tutorial.web.transcosmos.vo.JNTCIEquip02equipType;

public class JNTCIEquip02name extends ValidatorActionFormEx {
	private static final long serialVersionUID = 1L;
	private String id = null;
	private String name = null;
	private String dept = null;
	private String deptName = null;
	private String typeTemp = null;
	private String equipTemp = null;
	private String codeTemp=null;
	private String reasonTemp = null;
	private List<JNTCIEquip02equip> jNTCIEquip02equip= null;

public List<JNTCIEquip02equip> getjNTCIEquip02equip() {
		return jNTCIEquip02equip;
	}
	public void setjNTCIEquip02equip(List<JNTCIEquip02equip> jNTCIEquip02equip) {
		this.jNTCIEquip02equip = jNTCIEquip02equip;
	}
private List<JNTCIEquip02equip> equipList = null;
	public List<JNTCIEquip02equip> getEquipList() {
	return equipList;
}
public void setEquipList(List<JNTCIEquip02equip> equipList) {
	this.equipList = equipList;
}
	private List<JNTCIEquip02equipType> equipTypeList = null;

	public List<JNTCIEquip02equipType> getEquipTypeList() {
		return equipTypeList;
	}
	public void setEquipTypeList(List<JNTCIEquip02equipType> equipTypeList) {
		this.equipTypeList = equipTypeList;
	}

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
	public String getTypeTemp() {
		return typeTemp;
	}
	public void setTypeTemp(String typeTemp) {
		this.typeTemp = typeTemp;
	}
	public String getEquipTemp() {
		return equipTemp;
	}
	public void setEquipTemp(String equipTemp) {
		this.equipTemp = equipTemp;
	}
	public String getReasonTemp() {
		return reasonTemp;
	}
	public void setReasonTemp(String reasonTemp) {
		this.reasonTemp = reasonTemp;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public String getCodeTemp() {
		return codeTemp;
	}
	public void setCodeTemp(String codeTemp) {
		this.codeTemp = codeTemp;
	}



}
