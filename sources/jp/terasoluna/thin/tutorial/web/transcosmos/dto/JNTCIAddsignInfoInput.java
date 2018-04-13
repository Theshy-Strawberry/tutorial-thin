package jp.terasoluna.thin.tutorial.web.transcosmos.dto;
import java.util.Date;

import jp.terasoluna.thin.tutorial.web.transcosmos.vo.JNTCIAddsignInfoVo;
public class JNTCIAddsignInfoInput {
	private String row = null;
	private String startIndex = null;
	private String JN_CARD;
	private String JN_CARD_SEARCH;
	private String USER_NAME_SEARCH;
	private String retroactive_type_hide;
	private String cod = null;
	private String tenpu_path;
	private String filePath = null;
	private String sureId_card;
	private String deleteId_c;
    private String mark;
    private String retroactive_auditss_search;
    private String retroactive_starttime_search;
    private String retroactive_endtime_search;
    private String leader;

	public String getLeader() {
		return leader;
	}
	public void setLeader(String leader) {
		this.leader = leader;
	}
	public String getRetroactive_starttime_search() {
		return retroactive_starttime_search;
	}
	public void setRetroactive_starttime_search(String retroactive_starttime_search) {
		this.retroactive_starttime_search = retroactive_starttime_search;
	}
	public String getRetroactive_endtime_search() {
		return retroactive_endtime_search;
	}
	public void setRetroactive_endtime_search(String retroactive_endtime_search) {
		this.retroactive_endtime_search = retroactive_endtime_search;
	}
	public String getRetroactive_auditss_search() {
		return retroactive_auditss_search;
	}
	public void setRetroactive_auditss_search(String retroactive_auditss_search) {
		this.retroactive_auditss_search = retroactive_auditss_search;
	}
	public String getMark() {
	return mark;
}
public void setMark(String mark) {
	this.mark = mark;
}
	public String getDeleteId_c() {
		return deleteId_c;
	}
	public void setDeleteId_c(String deleteId_c) {
		this.deleteId_c = deleteId_c;
	}
	public String getSureId_card() {
		return sureId_card;
	}
	public void setSureId_card(String sureId_card) {
		this.sureId_card = sureId_card;
	}
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	public String getTenpu_path() {
		return tenpu_path;
	}
	public void setTenpu_path(String tenpu_path) {
		this.tenpu_path = tenpu_path;
	}
	public String getCod() {
		return cod;
	}
	public void setCod(String cod) {
		this.cod = cod;
	}
	public String getUSER_NAME_SEARCH() {
		return USER_NAME_SEARCH;
	}
	public void setUSER_NAME_SEARCH(String uSER_NAME_SEARCH) {
		USER_NAME_SEARCH = uSER_NAME_SEARCH;
	}

	public String getRetroactive_type_hide() {
		return retroactive_type_hide;
	}
	public void setRetroactive_type_hide(String retroactive_type_hide) {
		this.retroactive_type_hide = retroactive_type_hide;
	}

	private String USER_NAME;
	private String retroactive_type2;
	private String card_id;
	JNTCIAddsignInfoVo vo;
	private String k_name;
	private String examine_status;
	private String examine_reason;
	private String RETROACTIVE_ID;
	private String RETROACTIVE_TYPE;
	private String shnsei_time;
	private double kojyo_time;
	private double vocation;

	public String getK_name() {
		return k_name;
	}
	public void setK_name(String k_name) {
		this.k_name = k_name;
	}
	public String getShnsei_time() {
		return shnsei_time;
	}
	public void setShnsei_time(String shnsei_time) {
		this.shnsei_time = shnsei_time;
	}

	public double getKojyo_time() {
		return kojyo_time;
	}
	public void setKojyo_time(double kojyo_time) {
		this.kojyo_time = kojyo_time;
	}

	public double getVocation() {
		return vocation;
	}
	public void setVocation(double vocation) {
		this.vocation = vocation;
	}

	//更新考勤一览用
	private double timeCount;
	private  String dept_id;
	private Date toroku_timeStamp;
	private String month;
	private String timeFlag;
	private String start_time_before;
	private String end_time_before;

	public String getStart_time_before() {
		return start_time_before;
	}
	public void setStart_time_before(String start_time_before) {
		this.start_time_before = start_time_before;
	}
	public String getEnd_time_before() {
		return end_time_before;
	}
	public void setEnd_time_before(String end_time_before) {
		this.end_time_before = end_time_before;
	}
	public String getTimeFlag() {
		return timeFlag;
	}
	public void setTimeFlag(String timeFlag) {
		this.timeFlag = timeFlag;
	}
	public double getTimeCount() {
		return timeCount;
	}
	public void setTimeCount(double timeCount) {
		this.timeCount = timeCount;
	}
	public String getDept_id() {
		return dept_id;
	}
	public void setDept_id(String dept_id) {
		this.dept_id = dept_id;
	}
	public Date getToroku_timeStamp() {
		return toroku_timeStamp;
	}
	public void setToroku_timeStamp(Date toroku_timeStamp) {
		this.toroku_timeStamp = toroku_timeStamp;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}

	public String getRETROACTIVE_TYPE() {
		return RETROACTIVE_TYPE;
	}
	public void setRETROACTIVE_TYPE(String retroactive_type) {
		RETROACTIVE_TYPE = retroactive_type;
	}
	private  Date  starttime;
	public Date getStarttime() {
		return starttime;
	}
	public void setStarttime(Date starttime) {
		this.starttime = starttime;
	}
	public Date getEndtime() {
		return endtime;
	}
	public void setEndtime(Date endtime) {
		this.endtime = endtime;
	}
	private  Date  endtime;
	private String start_time_add;
	private String end_time_add;
	private String start_time_add_search;
	private String flag_date_format;
    private String deleteExtra_Id=null;
    /*syh*/
    private String retroactive_status ;
   	public String getRetroactive_status() {
   		return retroactive_status;
   	}
   	public void setRetroactive_status(String retroactive_status) {
   		this.retroactive_status = retroactive_status;
   	}
    private String reason_type ;
    private String userId ;
    private String userName;
 	public String getUserName() {
 	return userName;
 }
 public void setUserName(String userName) {
 	this.userName = userName;
 }
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getReason_type() {
		return reason_type;
	}

	public void setReason_type(String reason_type) {
		this.reason_type = reason_type;
	}

	public String getDeleteExtra_Id() {
		return deleteExtra_Id;
	}

	public void setDeleteExtra_Id(String deleteExtra_Id) {
		this.deleteExtra_Id = deleteExtra_Id;
	}

	public String getFlag_date_format() {
		return flag_date_format;
	}

	public void setFlag_date_format(String flag_date_format) {
		this.flag_date_format = flag_date_format;
	}

	public String getJN_CARD_SEARCH() {
		return JN_CARD_SEARCH;
	}

	public void setJN_CARD_SEARCH(String jN_CARD_SEARCH) {
		JN_CARD_SEARCH = jN_CARD_SEARCH;
	}

	public String getStart_time_add_search() {
		return start_time_add_search;
	}

	public void setStart_time_add_search(String start_time_add_search) {
		this.start_time_add_search = start_time_add_search;
	}


	public String getEnd_time_add() {
		return end_time_add;
	}

	public void setEnd_time_add(String end_time_add) {
		this.end_time_add = end_time_add;
	}

	public String getRETROACTIVE_ID() {
		return RETROACTIVE_ID;
	}

	public String getStart_time_add() {
		return start_time_add;
	}

	public void setStart_time_add(String start_time_add) {
		this.start_time_add = start_time_add;
	}

	public void setRETROACTIVE_ID(String rETROACTIVE_ID) {
		RETROACTIVE_ID = rETROACTIVE_ID;
	}

	public String getExamine_reason() {
		return examine_reason;
	}

	public void setExamine_reason(String examine_reason) {
		this.examine_reason = examine_reason;
	}

	public String getExamine_status() {
		return examine_status;
	}

	public void setExamine_status(String examine_status) {
		this.examine_status = examine_status;
	}

	public JNTCIAddsignInfoVo getVo() {
		return vo;
	}

	public void setVo(JNTCIAddsignInfoVo vo) {
		this.vo = vo;
	}

	public String getCard_id() {
		return card_id;
	}

	public void setCard_id(String card_id) {
		this.card_id = card_id;
	}

	public String getRetroactive_type2() {
		return retroactive_type2;
	}

	public void setRetroactive_type2(String retroactive_type2) {
		this.retroactive_type2 = retroactive_type2;
	}

	public String getJN_CARD() {
		return JN_CARD;
	}

	public void setJN_CARD(String jN_CARD) {
		JN_CARD = jN_CARD;
	}

	public String getUSER_NAME() {
		return USER_NAME;
	}

	public void setUSER_NAME(String uSER_NAME) {
		USER_NAME = uSER_NAME;
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

	}





