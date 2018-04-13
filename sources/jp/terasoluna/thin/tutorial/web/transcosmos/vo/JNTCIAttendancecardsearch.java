package jp.terasoluna.thin.tutorial.web.transcosmos.vo;

public class JNTCIAttendancecardsearch {
	private String work_date;//工作时长
    private String start_date;//开始时间
    private String end_date;//结束时间
    private String ijyou_flag;//是否异常
    private String jn_card;
    private String name;
    private String dept_id;
    private String extra_time;
    private String extra_type;

	public String getExtra_type() {
		return extra_type;
	}
	public void setExtra_type(String extra_type) {
		this.extra_type = extra_type;
	}
	public String getExtra_time() {
		return extra_time;
	}
	public void setExtra_time(String extra_time) {
		this.extra_time = extra_time;
	}
	public String getWork_date() {
		return work_date;
	}
	public void setWork_date(String work_date) {
		this.work_date = work_date;
	}
	public String getStart_date() {
		return start_date;
	}
	public void setStart_date(String start_date) {
		this.start_date = start_date;
	}
	public String getEnd_date() {
		return end_date;
	}
	public void setEnd_date(String end_date) {
		this.end_date = end_date;
	}
	public String getIjyou_flag() {
		return ijyou_flag;
	}
	public void setIjyou_flag(String ijyou_flag) {
		this.ijyou_flag = ijyou_flag;
	}
	public String getJn_card() {
		return jn_card;
	}
	public void setJn_card(String jn_card) {
		this.jn_card = jn_card;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDept_id() {
		return dept_id;
	}
	public void setDept_id(String dept_id) {
		this.dept_id = dept_id;
	}

}
