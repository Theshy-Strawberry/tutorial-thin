package jp.terasoluna.thin.tutorial.web.transcosmos.dto;

public class JNTCIAttendance03AuditStatusDto {

	public String EXAMINE_ID;
	
	public String EXAMINE_PERSON;

	public Integer LEAVE_ID;

	public String OBJECT_TYPE;

	public String OBJECT_ID;

	public String EXAMINE_STATUS;

	public String UPD_TIME;

	public Integer getLEAVE_ID() {
		return LEAVE_ID;
	}
	public void setLEAVE_ID(Integer lEAVE_ID) {
		LEAVE_ID = lEAVE_ID;
	}
	
	public String getEXAMINE_PERSON() {
		return EXAMINE_PERSON;							//?????????
	}
	public void setEXAMINE_PERSON(String examine_person) {
		EXAMINE_PERSON = examine_person;
	}
	public String getEXAMINE_ID() {
		return EXAMINE_ID;
	}
	public void setEXAMINE_ID(String eXAMINE_ID) {
		EXAMINE_ID = eXAMINE_ID;
	}
	public String getOBJECT_TYPE() {
		return OBJECT_TYPE;
	}
	public void setOBJECT_TYPE(String oBJECT_TYPE) {
		OBJECT_TYPE = oBJECT_TYPE;
	}
	public String getOBJECT_ID() {
		return OBJECT_ID;
	}
	public void setOBJECT_ID(String oBJECT_ID) {
		OBJECT_ID = oBJECT_ID;
	}
	public String getEXAMINE_STATUS() {
		return EXAMINE_STATUS;
	}
	public void setEXAMINE_STATUS(String eXAMINE_STATUS) {
		EXAMINE_STATUS = eXAMINE_STATUS;
	}
	public String getUPD_TIME() {
		return UPD_TIME;
	}
	public void setUPD_TIME(String uPD_TIME) {
		UPD_TIME = uPD_TIME;
	}
}
