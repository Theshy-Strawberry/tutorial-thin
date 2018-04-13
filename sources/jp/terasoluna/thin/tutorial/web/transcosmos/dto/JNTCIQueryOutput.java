package jp.terasoluna.thin.tutorial.web.transcosmos.dto;

import java.util.List;

public class JNTCIQueryOutput {

    private String jn_card;
    private String tj_card;
    private String username;
    private String kj_name;//所属部門
    private int actual_days;//实际出勤天数
    private double comelate;//迟到时间汇总
    private double leave_earlier;//早退时间汇总
    private double extra_time;//平时加班时间汇总
    private int extra_time_count;//平时加班时间大于2.5小时的天数
    private double week_extra_time;//周末加班时间汇总
    private int week_extra_time_count;//周末和节假日加班时间大于5小时的天数
    private int hld_extra_time;//节假日加班时间汇总
    private int evection_count;//出差的天数
    private double leave_count;//请假总时间
    private double leave_count1;//
    private double leave_count2;
    private double leave_count3;
    private double leave_count4;
    private double leave_count5;
    private double leave_count6;
    private double leave_count7;
    private double leave_count8;
    private double leave_count9;
    private double leave_count10;
    private double time_count;
    private double kojyo_time;//补卡扣除总时间
    private int ijyou_flag;//异常flag
    private int day;//该月应该出勤天数
    private double count;//总出勤時間
    private int hangover;//存在旷工的天数
    private double overcountbf;//扣除总时间
    private int overflag;//超出flag
    private String ymd;
    private String ym;
    private String starttime;
    private String endtime;
    private double absence;
    private double overcountaf;//扣除总时间
    private String entry_time;
    private String out_time;
    private String flag;
    private String user_name;
    private String transcode;
    private String scrollPosit;

	public String getScrollPosit() {
		return scrollPosit;
	}

	public void setScrollPosit(String scrollPosit) {
		this.scrollPosit = scrollPosit;
	}

    public String getTranscode() {
		return transcode;
	}

	public void setTranscode(String transcode) {
		this.transcode = transcode;
	}

    public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
	public String getOut_time() {
        return out_time;
    }
    public void setOut_time(String out_time) {
        this.out_time = out_time;
    }
    public String getEntry_time() {
        return entry_time;
    }
    public void setEntry_time(String entry_time) {
        this.entry_time = entry_time;
    }
    public double getAbsence() {
        return absence;
    }
    public void setAbsence(double absence) {
        this.absence = absence;
    }
    public String getStarttime() {
        return starttime;
    }
    public void setStarttime(String starttime) {
        this.starttime = starttime;
    }
    public String getEndtime() {
        return endtime;
    }
    public void setEndtime(String endtime) {
        this.endtime = endtime;
    }
    public String getYm() {
        return ym;
    }
    public void setYm(String ym) {
        this.ym = ym;
    }
    public String getYmd() {
        return ymd;
    }
    public void setYmd(String ymd) {
        this.ymd = ymd;
    }
    public void setWeek_extra_time_count(int week_extra_time_count) {
        this.week_extra_time_count = week_extra_time_count;
    }
    public int getWeek_extra_time_count() {
        return week_extra_time_count;
    }
    private List<JNTCIQueryOutput> tempList = null;
    private int listsize = 0;
    public String getJn_card() {
        return jn_card;
    }
    public void setJn_card(String jn_card) {
        this.jn_card = jn_card;
    }
    public String getTj_card() {
        return tj_card;
    }
    public void setTj_card(String tj_card) {
        this.tj_card = tj_card;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getKj_name() {
        return kj_name;
    }
    public void setKj_name(String kj_name) {
        this.kj_name = kj_name;
    }
    public int getActual_days() {
        return actual_days;
    }
    public void setActual_days(int actual_days) {
        this.actual_days = actual_days;
    }
    public double getComelate() {
        return comelate;
    }
    public void setComelate(double comelate) {
        this.comelate = comelate;
    }
    public double getLeave_earlier() {
        return leave_earlier;
    }
    public void setLeave_earlier(double leave_earlier) {
        this.leave_earlier = leave_earlier;
    }
    public double getExtra_time() {
        return extra_time;
    }
    public void setExtra_time(double extra_time) {
        this.extra_time = extra_time;
    }
    public int getExtra_time_count() {
        return extra_time_count;
    }
    public void setExtra_time_count(int extra_time_count) {
        this.extra_time_count = extra_time_count;
    }
    public double getWeek_extra_time() {
        return week_extra_time;
    }
    public void setWeek_extra_time(double week_extra_time) {
        this.week_extra_time = week_extra_time;
    }
    public int getHld_extra_time() {
        return hld_extra_time;
    }
    public void setHld_extra_time(int hld_extra_time) {
        this.hld_extra_time = hld_extra_time;
    }
    public int getEvection_count() {
        return evection_count;
    }
    public void setEvection_count(int evection_count) {
        this.evection_count = evection_count;
    }
    public double getLeave_count1() {
        return leave_count1;
    }
    public void setLeave_count1(double leave_count1) {
        this.leave_count1 = leave_count1;
    }
    public double getLeave_count2() {
        return leave_count2;
    }
    public void setLeave_count2(double leave_count2) {
        this.leave_count2 = leave_count2;
    }
    public double getLeave_count3() {
        return leave_count3;
    }
    public void setLeave_count3(double leave_count3) {
        this.leave_count3 = leave_count3;
    }
    public double getLeave_count4() {
        return leave_count4;
    }
    public void setLeave_count4(double leave_count4) {
        this.leave_count4 = leave_count4;
    }
    public double getLeave_count5() {
        return leave_count5;
    }
    public void setLeave_count5(double leave_count5) {
        this.leave_count5 = leave_count5;
    }
    public double getLeave_count6() {
        return leave_count6;
    }
    public void setLeave_count6(double leave_count6) {
        this.leave_count6 = leave_count6;
    }
    public double getLeave_count7() {
        return leave_count7;
    }
    public void setLeave_count7(double leave_count7) {
        this.leave_count7 = leave_count7;
    }
    public double getLeave_count8() {
        return leave_count8;
    }
    public void setLeave_count8(double leave_count8) {
        this.leave_count8 = leave_count8;
    }
    public double getLeave_count9() {
        return leave_count9;
    }
    public void setLeave_count9(double leave_count9) {
        this.leave_count9 = leave_count9;
    }
    public double getLeave_count10() {
        return leave_count10;
    }
    public void setLeave_count10(double leave_count10) {
        this.leave_count10 = leave_count10;
    }
    public double getTime_count() {
        return time_count;
    }
    public void setTime_count(double time_count) {
        this.time_count = time_count;
    }
    public int getDay() {
        return day;
    }
    public void setDay(int day) {
        this.day = day;
    }
    public double getCount() {
        return count;
    }
    public void setCount(double count) {
        this.count = count;
    }
    public double getKojyo_time() {
        return kojyo_time;
    }
    public void setKojyo_time(double kojyo_time) {
        this.kojyo_time = kojyo_time;
    }
    public double getLeave_count() {
        return leave_count;
    }
    public void setLeave_count(double leave_count) {
        this.leave_count = leave_count;
    }

    public int getIjyou_flag() {
        return ijyou_flag;
    }
    public void setIjyou_flag(int ijyou_flag) {
        this.ijyou_flag = ijyou_flag;
    }
    public int getHangover() {
        return hangover;
    }
    public void setHangover(int hangover) {
        this.hangover = hangover;
    }
    public double getOvercountbf() {
        return overcountbf;
    }
    public void setOvercountbf(double overcountbf) {
        this.overcountbf = overcountbf;
    }
    public double getOvercountaf() {
        return overcountaf;
    }
    public void setOvercountaf(double overcountaf) {
        this.overcountaf = overcountaf;
    }
    public int getOverflag() {
        return overflag;
    }
    public void setOverflag(int overflag) {
        this.overflag = overflag;
    }
    public List<JNTCIQueryOutput> getTempList() {
        return tempList;
    }
    public void setTempList(List<JNTCIQueryOutput> tempList) {
        this.tempList = tempList;
    }
    public int getListsize() {
        return listsize;
    }
    public void setListsize(int listsize) {
        this.listsize = listsize;
    }

}