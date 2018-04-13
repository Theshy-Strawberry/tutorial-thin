package jp.terasoluna.thin.tutorial.web.transcosmos.dto;

import java.util.List;

import jp.terasoluna.thin.tutorial.web.transcosmos.vo.SelectSetsubiShinsa;

public class JNTCIEquip04Output {

	//申請者ID
	private String userId = null;
	//部門名称
	private String deptName = null;
	//審査状態
	private String shinsaJyoutai = null;
	//日付-Start
	private String shinseiStartDate = null;
	//日付-End
	private int CF;
	private String qwerr=null;
	private String apply_no=null;
	//日付
	private String shinseiDate = null;
	private String row = "10";
	private String startIndex = "0";
	//一覧総ページ数
	private String totalCount;
	//検索結果List
	private List<SelectSetsubiShinsa> setsubiShinsaList=null;
	 //申请者Id
    private String shenqingId = null;
    //标记前台check
    private String mark=null;
  //删除番号
    private String deleteId_card=null;
    //
    private String shinseiEndDate=null;
	public String getShinseiEndDate() {
		return shinseiEndDate;
	}
	public void setShinseiEndDate(String shinseiEndDate) {
		this.shinseiEndDate = shinseiEndDate;
	}
	public String getDeleteId_card() {
		return deleteId_card;
	}
	public void setDeleteId_card(String deleteId_card) {
		this.deleteId_card = deleteId_card;
	}
	public String getMark() {
		return mark;
	}
	public void setMark(String mark) {
		this.mark = mark;
	}
	//一覧中データ数
	public String getQwerr() {
		return qwerr;
	}
	public void setQwerr(String qwerr) {
		this.qwerr = qwerr;
	}
	public int getCF() {
		return CF;
	}
	public void setCF(int cF) {
		CF = cF;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public String getShinsaJyoutai() {
		return shinsaJyoutai;
	}
	public void setShinsaJyoutai(String shinsaJyoutai) {
		this.shinsaJyoutai = shinsaJyoutai;
	}
	public String getShinseiStartDate() {
		return shinseiStartDate;
	}
	public void setShinseiStartDate(String shinseiStartDate) {
		this.shinseiStartDate = shinseiStartDate;
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
	public String getShenqingId() {
		return shenqingId;
	}
	public void setShenqingId(String shenqingId) {
		this.shenqingId = shenqingId;
	}
	public String getApply_no() {
		return apply_no;
	}
	public void setApply_no(String apply_no) {
		this.apply_no = apply_no;
	}
	public String getShinseiDate() {
		return shinseiDate;
	}
	public void setShinseiDate(String shinseiDate) {
		this.shinseiDate = shinseiDate;
	}
	public List<SelectSetsubiShinsa> getSetsubiShinsaList() {
		return setsubiShinsaList;
	}
	public void setSetsubiShinsaList(List<SelectSetsubiShinsa> setsubiShinsaList) {
		this.setsubiShinsaList = setsubiShinsaList;
	}

}
