package jp.terasoluna.thin.tutorial.web.transcosmos.dto;

import java.sql.Timestamp;
import java.util.List;

import jp.terasoluna.thin.tutorial.web.transcosmos.form.JNTCIQueryFrom;

public class JNTCIAttenceParamBean {
    private String work_date;// 工作时长
    private String jn_card;// 济南卡号
    private String start_date;// 开始时间
    private String end_date;// 结束时间
    private String ijyou_flag;// 是否异常
    private String dept_id;
    private String name;
    private String toroku_user;// 登录者
    private Timestamp toroku_timestamp;// 登录时间
    private Double time_count;// 合计时长
    private List<JNTCIQueryFrom> kaoqinmessage;
    private Double leave_earlier;// 早退属性
    private Double comelate;// 迟到属性
    private String HANGOVER;
    private String userId;
    private String ym;


    public String getYm() {
        return ym;
    }

    public void setYm(String ym) {
        this.ym = ym;
    }

    public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getHANGOVER() {
        return HANGOVER;
    }

    public void setHANGOVER(String hANGOVER) {
        HANGOVER = hANGOVER;
    }

    public Double getLeave_earlier() {
        return leave_earlier;
    }

    public void setLeave_earlier(Double leave_earlier) {
        this.leave_earlier = leave_earlier;
    }

    public Double getComelate() {
        return comelate;
    }

    public void setComelate(Double comelate) {
        this.comelate = comelate;
    }

    public Double getTime_count() {
        return time_count;
    }

    public void setTime_count(Double time_count) {
        this.time_count = time_count;
    }
    public List<JNTCIQueryFrom> getKaoqinmessage() {
        return kaoqinmessage;
    }

    public void setKaoqinmessage(List<JNTCIQueryFrom> kaoqinmessage) {
        this.kaoqinmessage = kaoqinmessage;
    }
    public String getWork_date() {
        return work_date;
    }

    public void setWork_date(String work_date) {
        this.work_date = work_date;
    }

    public String getJn_card() {
        return jn_card;
    }

    public void setJn_card(String jn_card) {
        this.jn_card = jn_card;
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

    public String getDept_id() {
        return dept_id;
    }

    public void setDept_id(String dept_id) {
        this.dept_id = dept_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getToroku_user() {
        return toroku_user;
    }

    public void setToroku_user(String toroku_user) {
        this.toroku_user = toroku_user;
    }

    public Timestamp getToroku_timestamp() {
        return toroku_timestamp;
    }

    public void setToroku_timestamp(Timestamp time) {
        this.toroku_timestamp = time;
    }

    private String month;
    private String HIDUKE;
    private String year;
    private String day;

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getHIDUKE() {
        return HIDUKE;
    }

    public void setHIDUKE(String hIDUKE) {
        HIDUKE = hIDUKE;
    }

}
