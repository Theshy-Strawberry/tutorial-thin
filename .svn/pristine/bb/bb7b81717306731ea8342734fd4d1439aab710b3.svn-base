package jp.terasoluna.thin.tutorial.web.transcosmos.form;
import java.util.List;

import jp.terasoluna.fw.web.struts.form.ValidatorActionFormEx;
import jp.terasoluna.thin.tutorial.web.transcosmos.dto.JNTCISeekOutput;
import jp.terasoluna.thin.tutorial.web.transcosmos.dto.JNTCISeekWeek;
public class JNTCISeekForm extends ValidatorActionFormEx{

	private static final long serialVersionUID = 1L;
	private String username;
	private String jn_card;
	private String dept_id;
	private String start_time;
	private String end_time;
	private Integer month;
	private String card;
	private String name;
	private Integer seek_query;//用此变量表示是否是从信息综合页面跳转来的
	private Integer day;
	private String machine_no;
	private Integer year;
	private String user_id;
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

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
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

	public Integer getYear() {
		return year;
	}
	public void setYear(Integer year) {
		this.year = year;
	}

	public Integer getSeek_query() {
		return seek_query;
	}

	public void setSeek_query(Integer seek_query) {
		this.seek_query = seek_query;
	}

	public Integer getDay() {
		return day;
	}
	public void setDay(Integer day) {
		this.day = day;
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
	public Integer getMonth() {
		return month;
	}
	public void setMonth(Integer month) {
		this.month = month;
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

	public String getMachine_no() {
		return machine_no;
	}
	public void setMachine_no(String machine_no) {
		this.machine_no = machine_no;
	}

	private String yymm;
	List<JNTCISeekOutput> extra_list;
	private List<JNTCISeekWeek> weekList;//每周的泛型
	private List<JNTCISeekOutput> leaveList;
	private String dt;//日期
	private double comeLate;//迟到了时间
	private double leave_earlier;//早退了时间
	private String late_state;//迟到
	private String earlier_state;//早退
	private boolean state=true;//确定打卡是不准时
	private String examineState;//标志是否请假并批准
	private String extra_time;//加班时间
	private String extra_starttime;//加班开始时间
	private String extra_endtime;//加班结束时间
	private String extra_type;//加班类型
	private String extra_symbol;//是否加班的标志
	private String extra_state="true";//加班异常的标志
	List<JNTCISeekOutput> evectionlist;


	public String getYymm() {
		return yymm;
	}
	public void setYymm(String yymm) {
		this.yymm = yymm;
	}
	public List<JNTCISeekOutput> getEvectionlist() {
		return evectionlist;
	}
	public void setEvectionlist(List<JNTCISeekOutput> evectionlist) {
		this.evectionlist = evectionlist;
	}
	private List<JNTCISeekForm> time;
	private List<JNTCISeekForm> jihe;
	private List<JNTCISeekForm> su=null;
	private List<JNTCISeekForm> shijian;



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
	public List<JNTCISeekOutput> getLeaveList() {
		return leaveList;
	}
	public void setLeaveList(List<JNTCISeekOutput> leaveList) {
		this.leaveList = leaveList;
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

	public double getComeLate() {
		return comeLate;
	}
	public void setComeLate(double comeLate) {
		this.comeLate = comeLate;
	}
	public double getLeave_earlier() {
		return leave_earlier;
	}
	public void setLeave_earlier(double leave_earlier) {
		this.leave_earlier = leave_earlier;
	}
	public String getExamineState() {
		return examineState;
	}
	public void setExamineState(String examineState) {
		this.examineState = examineState;
	}
	public boolean isState() {
		return state;
	}
	public void setState(boolean state) {
		this.state = state;
	}
	public List<JNTCISeekForm> getShijian() {
		return shijian;
	}
	public void setShijian(List<JNTCISeekForm> shijian) {
		this.shijian = shijian;
	}
	public List<JNTCISeekForm> getTime() {
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

	public String getDt() {
		return dt;
	}
	public void setDt(String dt) {
		this.dt = dt;
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
