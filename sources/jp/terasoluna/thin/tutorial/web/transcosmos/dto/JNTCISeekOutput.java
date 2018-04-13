package jp.terasoluna.thin.tutorial.web.transcosmos.dto;
import java.util.List;

import jp.terasoluna.thin.tutorial.web.transcosmos.form.JNTCISeekForm;

public class JNTCISeekOutput {
	private String username;
	private String jn_card;
	private String dept_id;
	private String start_time;
	private String end_time;
	private String card;
	private String name;
	 private String user_name;
	 private String scrollPosit;


		public String getScrollPosit() {
		return scrollPosit;
	}

	public void setScrollPosit(String scrollPosit) {
		this.scrollPosit = scrollPosit;
	}


		public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getCard() {
		return card;
	}
	public void setCard(String card) {
		this.card = card;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStart_time() {
		return start_time;
	}
	public void setStart_time(String start_time) {
		this.start_time = start_time;
	}
	public String getEnd_time() {
		return end_time;
	}
	public void setEnd_time(String end_time) {
		this.end_time = end_time;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getJn_card() {
		return jn_card;
	}
	public void setJn_card(String jn_card) {
		this.jn_card = jn_card;
	}
	public String getDept_id() {
		return dept_id;
	}
	public void setDept_id(String dept_id) {
		this.dept_id = dept_id;
	}

	//设置开始与结束时间是否夸月的信息符号
	private String mm_start;
	private String mm_end;
	public String getMm_start() {
		return mm_start;
	}
	public void setMm_start(String mm_start) {
		this.mm_start = mm_start;
	}
	public String getMm_end() {
		return mm_end;
	}
	public void setMm_end(String mm_end) {
		this.mm_end = mm_end;
	}

	private String yymm;
	private String holiday_name;//法定假日的名字
	private String holiday_start_time;//法定假日的开始时间
	private String holiday_end_time;//法定假日的结束时间

	private String leaveType;// 休暇種類

	private String leaveStartTime;// 休暇開始時間

	private String leaveEndTime;// 休暇終了時間
	private Integer year;
	private Integer month;
	List<JNTCISeekOutput> extra_list;
	private List<JNTCISeekWeek> weekList;//每周
	private List<JNTCISeekOutput> leaveList;//本月的请假日期
	private List<JNTCISeekOutput> holidayList;//本月的法定节假日
	private String dt;//日期
	private String dt_end;//日期
	private double comeState;//出勤与请假的状态值，0为正常，1为异常
	private String late_state;//迟到
	private String earlier_state;//早退
	private boolean state=true;//确定打卡是不准时
	private String examineState;//标志是否请假并批准
	private String showId;//打卡履历书中的id变量；
	private Integer leaveId;// 休暇ID
	private String extra_time;//加班时间
	private String extra_starttime;//加班开始时间
	private String extra_endtime;//加班结束时间
	private String extra_type;//加班类型
	private String extra_symbol;//是否加班的标志
	private String  extra_state="true";//加班异常的标志


	public String getYymm() {
		return yymm;
	}
	public void setYymm(String yymm) {
		this.yymm = yymm;
	}
	public List<JNTCISeekOutput> getExtra_list() {
		return extra_list;
	}
	public void setExtra_list(List<JNTCISeekOutput> extra_list) {
		this.extra_list = extra_list;
	}
	public String getExtra_symbol() {
		return extra_symbol;
	}
	public void setExtra_symbol(String extra_symbol) {
		this.extra_symbol = extra_symbol;
	}

	public String getExtra_state() {
		return extra_state;
	}
	public void setExtra_state(String extra_state) {
		this.extra_state = extra_state;
	}
	public String getDt_end() {
		return dt_end;
	}
	public void setDt_end(String dt_end) {
		this.dt_end = dt_end;
	}
	//出差变量值
	private String evectionStarttime;
	private String evectionEndtime;
	private String evectionDestination;
	List<JNTCISeekOutput> evectionlist;
	public List<JNTCISeekOutput> getEvectionlist() {
		return evectionlist;
	}
	public void setEvectionlist(List<JNTCISeekOutput> evectionlist) {
		this.evectionlist = evectionlist;
	}
	public String getEvectionStarttime() {
		return evectionStarttime;
	}
	public void setEvectionStarttime(String evectionStarttime) {
		this.evectionStarttime = evectionStarttime;
	}
	public String getEvectionEndtime() {
		return evectionEndtime;
	}
	public void setEvectionEndtime(String evectionEndtime) {
		this.evectionEndtime = evectionEndtime;
	}
	public String getEvectionDestination() {
		return evectionDestination;
	}
	public void setEvectionDestination(String evectionDestination) {
		this.evectionDestination = evectionDestination;
	}



	private List<JNTCISeekForm> jihe;
	private List<JNTCISeekForm> su;
	private List<JNTCISeekForm> time;
	private List<JNTCISeekForm> shijian;

	public List<JNTCISeekForm> getShijian() {
		return shijian;
	}
	public void setShijian(List<JNTCISeekForm> shijian) {
		this.shijian = shijian;
	}
	public List<JNTCISeekOutput> getLeaveList() {
		return leaveList;
	}
	public List<JNTCISeekForm>getTime() {
		return time;
	}
	public void setTime(List<JNTCISeekForm> time) {
		this.time = time;
	}
	public List<JNTCISeekForm> getJihe() {
		return jihe;
	}
	public void setJihe(List<JNTCISeekForm> jihe) {
		this.jihe = jihe;
	}
	public List<JNTCISeekForm> getSu() {
		return su;
	}
	public void setSu(List<JNTCISeekForm> su) {
		this.su = su;
	}
	public List<JNTCISeekWeek> getWeekList() {
		return weekList;
	}
	public void setWeekList(List<JNTCISeekWeek> weekList) {
		this.weekList = weekList;
	}
	public Integer getYear() {
		return year;
	}
	public void setYear(Integer year) {
		this.year = year;
	}
	public Integer getMonth() {
		return month;
	}
	public void setMonth(Integer month) {
		this.month = month;
	}
	public String getDt() {
		return dt;
	}
	public void setDt(String dt) {
		this.dt = dt;
	}

	public double getComeState() {
		return comeState;
	}
	public void setComeState(double comeState) {
		this.comeState = comeState;
	}
	public String getLate_state() {
		return late_state;
	}
	public void setLate_state(String late_state) {
		this.late_state = late_state;
	}
	public String getEarlier_state() {
		return earlier_state;
	}
	public void setEarlier_state(String earlier_state) {
		this.earlier_state = earlier_state;
	}
	public boolean isState() {
		return state;
	}
	public void setState(boolean state) {
		this.state = state;
	}
	public String getExamineState() {
		return examineState;
	}
	public void setExamineState(String examineState) {
		this.examineState = examineState;
	}
	public String getLeaveType() {
		return leaveType;
	}
	public void setLeaveType(String leaveType) {
		this.leaveType = leaveType;
	}
	public String getLeaveStartTime() {
		return leaveStartTime;
	}
	public void setLeaveStartTime(String leaveStartTime) {
		this.leaveStartTime = leaveStartTime;
	}
	public String getLeaveEndTime() {
		return leaveEndTime;
	}
	public void setLeaveEndTime(String leaveEndTime) {
		this.leaveEndTime = leaveEndTime;
	}
	public String getShowId() {
		return showId;
	}
	public void setShowId(String showId) {
		this.showId = showId;
	}
	public Integer getLeaveId() {
		return leaveId;
	}
	public void setLeaveId(Integer leaveId) {
		this.leaveId = leaveId;
	}
	public void setLeaveList(List<JNTCISeekOutput> leaveList) {
		this.leaveList = leaveList;
	}
	public String getHoliday_name() {
		return holiday_name;
	}
	public void setHoliday_name(String holiday_name) {
		this.holiday_name = holiday_name;
	}
	public String getHoliday_start_time() {
		return holiday_start_time;
	}
	public void setHoliday_start_time(String holiday_start_time) {
		this.holiday_start_time = holiday_start_time;
	}
	public String getHoliday_end_time() {
		return holiday_end_time;
	}
	public void setHoliday_end_time(String holiday_end_time) {
		this.holiday_end_time = holiday_end_time;
	}
	public List<JNTCISeekOutput> getHolidayList() {
		return holidayList;
	}
	public void setHolidayList(List<JNTCISeekOutput> holidayList) {
		this.holidayList = holidayList;
	}
	public String getExtra_time() {
		return extra_time;
	}
	public void setExtra_time(String extra_time) {
		this.extra_time = extra_time;
	}
	public String getExtra_starttime() {
		return extra_starttime;
	}
	public void setExtra_starttime(String extra_starttime) {
		this.extra_starttime = extra_starttime;
	}
	public String getExtra_endtime() {
		return extra_endtime;
	}
	public void setExtra_endtime(String extra_endtime) {
		this.extra_endtime = extra_endtime;
	}
	public String getExtra_type() {
		return extra_type;
	}
	public void setExtra_type(String extra_type) {
		this.extra_type = extra_type;
	}




}
