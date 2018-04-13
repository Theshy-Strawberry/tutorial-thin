package jp.terasoluna.thin.tutorial.web.transcosmos.dto;

public class JNTCIEquip01Input {

    //申請番号
    private String shinseiNo = null;
    //審査番号
    private String shinsaNo = null;
  // 申請日付
  private String shinsei_hiduke = null;
  // 申請者
  private String userId = null;
  // 申請者
  private String userName = null;
  // 部門名称
  private String deptName = null;
  // 物品名
  private String aitemuName = null;
  // 物品数
  private String aitemuNumber = null;
  // 申請原因
  private String reason = null;
  //宛先
  private String toId=null;
  //件名
  private String subject=null;
 //邮件
  private String officeMail=null;
public String getOfficeMail() {
	return officeMail;
}
public void setOfficeMail(String officeMail) {
	this.officeMail = officeMail;
}
public String getSubject() {
	return subject;
}
public void setSubject(String subject) {
	this.subject = subject;
}
public String getToId() {
	return toId;
}
public void setToId(String toId) {
	this.toId = toId;
}
public String getShinseiNo() {
    return shinseiNo;
}
public void setShinseiNo(String shinseiNo) {
    this.shinseiNo = shinseiNo;
}
public String getShinsaNo() {
    return shinsaNo;
}
public void setShinsaNo(String shinsaNo) {
    this.shinsaNo = shinsaNo;
}
public String getShinsei_hiduke() {
  return shinsei_hiduke;
}
public void setShinsei_hiduke(String shinsei_hiduke) {
  this.shinsei_hiduke = shinsei_hiduke;
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
public String getDeptName() {
  return deptName;
}
public void setDeptName(String deptName) {
  this.deptName = deptName;
}
public String getAitemuName() {
  return aitemuName;
}
public void setAitemuName(String aitemuName) {
  this.aitemuName = aitemuName;
}
public String getAitemuNumber() {
  return aitemuNumber;
}
public void setAitemuNumber(String aitemuNumber) {
  this.aitemuNumber = aitemuNumber;
}
public String getReason() {
  return reason;
}
public void setReason(String reason) {
  this.reason = reason;
}

}
