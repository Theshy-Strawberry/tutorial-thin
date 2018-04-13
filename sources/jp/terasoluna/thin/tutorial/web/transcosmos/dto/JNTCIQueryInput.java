package jp.terasoluna.thin.tutorial.web.transcosmos.dto;

import org.apache.struts.upload.FormFile;

import jp.terasoluna.fw.web.struts.form.ValidatorActionFormEx;

public class JNTCIQueryInput extends ValidatorActionFormEx {

    /**
	 *
	 */
    private static final long serialVersionUID = 1L;
    private String user_Id;
    private String userId;
    private String user_id;
    private String checkValue;
    private Integer leave_Id;
    private String START_TIME;
    private String jnName;
    private FormFile file;
    private String flag;
    private String ym;
    private double comelate;//迟到时间汇总
    private double leave_earlier;//早退时间汇总
    private double remain_days;//年休
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



	public String getYm() {
        return ym;
    }

    public void setYm(String ym) {
        this.ym = ym;
    }

    public FormFile getFile() {
        return file;
    }

    public void setFile(FormFile file) {
        this.file = file;
    }

    public String getJnName() {
        return jnName;
    }

    public void setJnName(String jnName) {
        this.jnName = jnName;
    }

    public String getSTART_TIME() {
        return START_TIME;
    }

    public void setSTART_TIME(String sTART_TIME) {
        START_TIME = sTART_TIME;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    public Integer getLeave_Id() {
        return leave_Id;
    }

    public void setLeave_Id(Integer leave_Id) {
        this.leave_Id = leave_Id;
    }

    public String getCheckValue() {
        return checkValue;
    }

    public void setCheckValue(String checkValue) {
        this.checkValue = checkValue;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUser_Id() {
        return user_Id;
    }

    public void setUser_Id(String user_Id) {
        this.user_Id = user_Id;
    }


    public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}


	private String userName;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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


	public double getRemain_days() {
		return remain_days;
	}

	public void setRemain_days(double remain_days) {
		this.remain_days = remain_days;
	}

	private String row = null;
    private String startIndex = null;
    private String JN_CARD;
    private String NAME;
    private String dept_id;
    private String leave_starttime;
    private String leave_endtime;
    private String USER_ID;
    private String deptuser_id;
    private String attendanceStatus;
    private String attendanceId;
    // month以备用来通过月份查找个人考勤信息汇总
    private String month;
    private String year;// 年份

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

    public String getAttendanceId() {
        return attendanceId;
    }

    public void setAttendanceId(String attendanceId) {
        this.attendanceId = attendanceId;
    }

    public String getAttendanceStatus() {
        return attendanceStatus;
    }

    public void setAttendanceStatus(String attendanceStatus) {
        this.attendanceStatus = attendanceStatus;
    }

    public String getDeptuser_id() {
        return deptuser_id;
    }

    public void setDeptuser_id(String deptuser_id) {
        this.deptuser_id = deptuser_id;
    }

    public String getUSER_ID() {
        return USER_ID;
    }

    public void setUSER_ID(String uSER_ID) {
        USER_ID = uSER_ID;
    }

    public String getLeave_endtime() {
        return leave_endtime;
    }

    public void setLeave_endtime(String leave_endtime) {
        this.leave_endtime = leave_endtime;
    }

    public String getDept_id() {
        return dept_id;
    }

    public String getLeave_starttime() {
        return leave_starttime;
    }

    public void setLeave_starttime(String leave_starttime) {
        this.leave_starttime = leave_starttime;
    }

    public void setDept_id(String dept_id) {
        this.dept_id = dept_id;
    }

    public String getJN_CARD() {
        return JN_CARD;
    }

    public void setJN_CARD(String jN_CARD) {
        JN_CARD = jN_CARD;
    }

    public String getNAME() {
        return NAME;
    }

    public void setNAME(String nAME) {
        NAME = nAME;
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
