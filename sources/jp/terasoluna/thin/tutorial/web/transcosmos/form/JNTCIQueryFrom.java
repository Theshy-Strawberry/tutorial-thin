package jp.terasoluna.thin.tutorial.web.transcosmos.form;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.apache.struts.upload.FormFile;

import jp.terasoluna.fw.web.struts.form.ValidatorActionFormEx;
import jp.terasoluna.thin.tutorial.web.transcosmos.dto.JNTCIQueryOutput;
import jp.terasoluna.thin.tutorial.web.transcosmos.vo.JNTCIAttendance001;
import jp.terasoluna.thin.tutorial.web.transcosmos.vo.JNTCIAttendance002VO;
import jp.terasoluna.thin.tutorial.web.transcosmos.vo.JNTCIQueryOutvo;

public class JNTCIQueryFrom extends ValidatorActionFormEx {
    private String user_id = null;
    private String time;
    private String dept;
    private String name;
    private String jn_card;
    private Date car_date;
    private String machine_id;
    private String cp_mthod;
    private String card_id;
    private String no;
    private FormFile file;
    private String file_path;
    private int listsize = 0;
    private String user_Id;
    private String userId;
    private double remain_days;
    private String flag;
    private double january;
    private double february;
    private double march;
    private double april;
    private double may;
    private double june;
    private double july;
    private double august;
    private double september;
    private double octorber;
    private double november;
    private double december;
    private String user_name;
    private String transcode;
    private String fileName;
    private String scrollPosit;

	public String getScrollPosit() {
		return scrollPosit;
	}

	public void setScrollPosit(String scrollPosit) {
		this.scrollPosit = scrollPosit;
	}

    public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
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

	public double getJanuary() {
		return january;
	}

	public void setJanuary(double january) {
		this.january = january;
	}

	public double getFebruary() {
		return february;
	}

	public void setFebruary(double february) {
		this.february = february;
	}

	public double getMarch() {
		return march;
	}

	public void setMarch(double march) {
		this.march = march;
	}

	public double getApril() {
		return april;
	}

	public void setApril(double april) {
		this.april = april;
	}

	public double getMay() {
		return may;
	}

	public void setMay(double may) {
		this.may = may;
	}

	public double getJune() {
		return june;
	}

	public void setJune(double june) {
		this.june = june;
	}

	public double getJuly() {
		return july;
	}

	public void setJuly(double july) {
		this.july = july;
	}

	public double getAugust() {
		return august;
	}

	public void setAugust(double august) {
		this.august = august;
	}

	public double getSeptember() {
		return september;
	}

	public void setSeptember(double september) {
		this.september = september;
	}

	public double getOctorber() {
		return octorber;
	}

	public void setOctorber(double octorber) {
		this.octorber = octorber;
	}

	public double getNovember() {
		return november;
	}

	public void setNovember(double november) {
		this.november = november;
	}

	public double getDecember() {
		return december;
	}

	public void setDecember(double december) {
		this.december = december;
	}

	/**
     * 年月
     */
    private String ym;



    public double getRemain_days() {
		return remain_days;
	}

	public void setRemain_days(double remain_days) {
		this.remain_days = remain_days;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	// 勤务照会一览
    private List<JNTCIQueryOutput> tempList = null;


    public String getUser_Id() {
		return user_Id;
	}

	public void setUser_Id(String user_Id) {
		this.user_Id = user_Id;
	}

	public String getYm() {
        return ym;
    }

    public void setYm(String ym) {
        this.ym = ym;
    }

    public int getListsize() {
        return listsize;
    }

    public void setListsize(int listsize) {
        this.listsize = listsize;
    }

    public String getFile_path() {
        return file_path;
    }

    public void setFile_path(String file_path) {
        this.file_path = file_path;
    }

    public FormFile getFile() {
        return file;
    }

    public void setFile(FormFile file) {
        this.file = file;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    private String jnCard;
    private String jnName;

    public String getJnName() {
        return jnName;
    }

    public void setJnName(String jnName) {
        this.jnName = jnName;
    }

    private String userName;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    private String deptid;

    public String getDeptid() {
        return deptid;
    }

    public void setDeptid(String deptid) {
        this.deptid = deptid;
    }

    private String deptCode;

    public String getCheckValue() {
        return checkValue;
    }

    public void setCheckValue(String checkValue) {
        this.checkValue = checkValue;
    }

    private String checkValue;

    public String getDeptCode() {
        return deptCode;
    }

    public void setDeptCode(String deptCode) {
        this.deptCode = deptCode;
    }

    public String getJnCard() {
        return jnCard;
    }

    public void setJnCard(String jnCard) {
        this.jnCard = jnCard;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJn_card() {
        return jn_card;
    }

    public void setJn_card(String jn_card) {
        this.jn_card = jn_card;
    }

    public Date getCar_date() {
        return car_date;
    }

    public void setCar_date(Date car_date) {
        this.car_date = car_date;
    }

    public String getMachine_id() {
        return machine_id;
    }

    public void setMachine_id(String machine_id) {
        this.machine_id = machine_id;
    }

    public String getCp_mthod() {
        return cp_mthod;
    }

    public void setCp_mthod(String cp_mthod) {
        this.cp_mthod = cp_mthod;
    }

    public String getCard_id() {
        return card_id;
    }

    public void setCard_id(String card_id) {
        this.card_id = card_id;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    // jin xing ji shou chan shu
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    private int ATTENDANCE_ID;
    /**
     * user_id
     */
    private String JN_CARD;
    /**
     * user_name
     */
    private String NAME;
    /**
     * dept_id
     */
    private String DEPT_ID;
    /**
     * dept_name
     */
    private String DEPT_NAME;
    /**
     * time chu
     */
    private String START_TIME;
    /**
     * time tui
     */
    private String END_TIME;
    /**
     * ji qi ID
     */
    private String MACHINE_NO;
    /**
     * she pin ka hao
     */
    private String CARD_NO;
    /**
     * qing jia shi jian
     */
    private String LEAVE_TOTALTIME;
    /**
     * qing jia lei xing
     */
    private String LEAVE_TYPE;
    /**
     * jia ban shi jian
     */
    private String EXTRA_TIME;
    /**
     * jia ban lei xing
     */
    private String EXTRA_TYPE;
    /**
     * chu cai
     */
    private String USER_ID;

    private String REMAIN_DAYS;

    private String deptuser_id;

    private String attendanceStatus;

    private double yearsJa;

    private String eveUSER_ID;
    private String eveUser_NAME;

    private String row = "5";

    private String startIndex = "0";

    private String totalCount = null;

    private List<JNTCIQueryOutvo> userList = null;

    private List<JNTCIQueryOutvo> userDeptList = null;

    private List<JNTCIQueryOutvo> userCcList;

    private String checkException;
    private String jiaqi;
    private String shijia;

    /**
     * Dept
     */

    private String CD_KUBUN;

    private String CD_CODE;

    private String KJ_NAME;

    private String department;

    private String dept_id;

    private String leave_starttime;
    private String leave_endtime;

    private double sumTwo;
    private double sumJBpr;
    private double sumJBxiuxi;
    private double sumJBjiari;
    private String riqi;

    public String getRiqi() {
        return riqi;
    }

    public void setRiqi(String riqi) {
        this.riqi = riqi;
    }

    public double getYearsJa() {
        return yearsJa;
    }

    public void setYearsJa(double yearsJa) {
        this.yearsJa = yearsJa;
    }

    public String getAttendanceStatus() {
        return attendanceStatus;
    }

    public void setAttendanceStatus(String attendanceStatus) {
        this.attendanceStatus = attendanceStatus;
    }

    public String getShijia() {
        return shijia;
    }

    public void setShijia(String shijia) {
        this.shijia = shijia;
    }

    public String getJiaqi() {
        return jiaqi;
    }

    public void setJiaqi(String jiaqi) {
        this.jiaqi = jiaqi;
    }

    public String getCheckException() {
        return checkException;
    }

    public void setCheckException(String checkException) {
        this.checkException = checkException;
    }

    public double getSumJBjiari() {
        return sumJBjiari;
    }

    public void setSumJBjiari(double sumJBjiari) {
        this.sumJBjiari = sumJBjiari;
    }

    public double getSumJBxiuxi() {
        return sumJBxiuxi;
    }

    public void setSumJBxiuxi(double sumJBxiuxi) {
        this.sumJBxiuxi = sumJBxiuxi;
    }

    public double getSumJBpr() {
        return sumJBpr;
    }

    public void setSumJBpr(double sumJBpr) {
        this.sumJBpr = sumJBpr;
    }

    /**
     * set get
     *
     * @return
     */

    public double getSumTwo() {
        return sumTwo;
    }

    public void setSumTwo(double sumTwo) {
        this.sumTwo = sumTwo;
    }

    public String getDeptuser_id() {
        return deptuser_id;
    }

    public void setDeptuser_id(String deptuser_id) {
        this.deptuser_id = deptuser_id;
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

    public void setDept_id(String dept_id) {
        this.dept_id = dept_id;
    }

    public String getUSER_ID() {
        return USER_ID;
    }

    public void setUSER_ID(String uSER_ID) {
        USER_ID = uSER_ID;
    }

    public String getDepartment() {
        return department;
    }

    public List<JNTCIQueryOutvo> getUserCcList() {
        return userCcList;
    }

    public void setUserCcList(List<JNTCIQueryOutvo> userCcList) {
        this.userCcList = userCcList;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getLeave_starttime() {
        return leave_starttime;
    }

    public void setLeave_starttime(String leave_starttime) {
        this.leave_starttime = leave_starttime;
    }

    public List<JNTCIQueryOutvo> getUserDeptList() {
        return userDeptList;
    }

    public void setUserDeptList(List<JNTCIQueryOutvo> userDeptList) {
        this.userDeptList = userDeptList;
    }

    public List<JNTCIQueryOutvo> getUserList() {
        return userList;
    }

    public void setUserList(List<JNTCIQueryOutvo> userList) {
        this.userList = userList;
    }

    public int getATTENDANCE_ID() {
        return ATTENDANCE_ID;
    }

    public void setATTENDANCE_ID(int aTTENDANCE_ID) {
        ATTENDANCE_ID = aTTENDANCE_ID;
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

    public String getDEPT_ID() {
        return DEPT_ID;
    }

    public void setDEPT_ID(String dEPT_ID) {
        DEPT_ID = dEPT_ID;
    }

    public String getDEPT_NAME() {
        return DEPT_NAME;
    }

    public void setDEPT_NAME(String dEPT_NAME) {
        DEPT_NAME = dEPT_NAME;
    }

    public String getSTART_TIME() {
        return START_TIME;
    }

    public void setSTART_TIME(String sTART_TIME) {
        START_TIME = sTART_TIME;
    }

    public String getEND_TIME() {
        return END_TIME;
    }

    public void setEND_TIME(String eND_TIME) {
        END_TIME = eND_TIME;
    }

    public String getMACHINE_NO() {
        return MACHINE_NO;
    }

    public void setMACHINE_NO(String mACHINE_NO) {
        MACHINE_NO = mACHINE_NO;
    }

    public String getCARD_NO() {
        return CARD_NO;
    }

    public void setCARD_NO(String cARD_NO) {
        CARD_NO = cARD_NO;
    }

    public String getStartIndex() {
        return startIndex;
    }

    public void setStartIndex(String startIndex) {
        this.startIndex = startIndex;
    }

    private String temp;

    public String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }

    public String getRow() {
        return row;
    }

    public void setRow(String row) {
        this.row = row;
    }

    public String getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(String totalCount) {
        this.totalCount = totalCount;
    }

    public String getCD_KUBUN() {
        return CD_KUBUN;
    }

    public void setCD_KUBUN(String cD_KUBUN) {
        CD_KUBUN = cD_KUBUN;
    }

    public String getCD_CODE() {
        return CD_CODE;
    }

    public void setCD_CODE(String cD_CODE) {
        CD_CODE = cD_CODE;
    }

    public String getKJ_NAME() {
        return KJ_NAME;
    }

    public void setKJ_NAME(String kJ_NAME) {
        KJ_NAME = kJ_NAME;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    public String getLEAVE_TOTALTIME() {
        return LEAVE_TOTALTIME;
    }

    public void setLEAVE_TOTALTIME(String lEAVE_TOTALTIME) {
        LEAVE_TOTALTIME = lEAVE_TOTALTIME;
    }

    public String getLEAVE_TYPE() {
        return LEAVE_TYPE;
    }

    public void setLEAVE_TYPE(String lEAVE_TYPE) {
        LEAVE_TYPE = lEAVE_TYPE;
    }

    public String getEXTRA_TIME() {
        return EXTRA_TIME;
    }

    public void setEXTRA_TIME(String eXTRA_TIME) {
        EXTRA_TIME = eXTRA_TIME;
    }

    public String getEXTRA_TYPE() {
        return EXTRA_TYPE;
    }

    public void setEXTRA_TYPE(String eXTRA_TYPE) {
        EXTRA_TYPE = eXTRA_TYPE;
    }

    public String getREMAIN_DAYS() {
        return REMAIN_DAYS;
    }

    public void setREMAIN_DAYS(String rEMAIN_DAYS) {
        REMAIN_DAYS = rEMAIN_DAYS;
    }

    public String getEveUSER_ID() {
        return eveUSER_ID;
    }

    public void setEveUSER_ID(String eveUSER_ID) {
        this.eveUSER_ID = eveUSER_ID;
    }

    public String getEveUser_NAME() {
        return eveUser_NAME;
    }

    public void setEveUser_NAME(String eveUser_NAME) {
        this.eveUser_NAME = eveUser_NAME;
    }

    private String work_date;// 工作时长
    private String start_date;// 开始时间
    private String end_date;// 结束时间
    private String ijyou_flag;// 是否异常
    private double time_count;// 合计时长
    private String toroku_user;// 登录者
    private Timestamp toroku_timestamp;// 登录时间
    private double comelate;// 迟到
    private double leave_earlier;// 早退

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

    public double getTime_count() {
        return time_count;
    }

    public void setTime_count(double time_count) {
        this.time_count = time_count;
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

    public void setToroku_timestamp(Timestamp toroku_timestamp) {
        this.toroku_timestamp = toroku_timestamp;
    }

    private List<JNTCIQueryFrom> kaoqinmessage;
    private List<JNTCIQueryFrom> jiansuomessage;

    public List<JNTCIQueryFrom> getJiansuomessage() {
        return jiansuomessage;
    }

    public void setJiansuomessage(List<JNTCIQueryFrom> jiansuomessage) {
        this.jiansuomessage = jiansuomessage;
    }

    public List<JNTCIQueryFrom> getKaoqinmessage() {
        return kaoqinmessage;
    }

    public void setKaoqinmessage(List<JNTCIQueryFrom> kaoqinmessage) {
        this.kaoqinmessage = kaoqinmessage;
    }

    // month以备用来通过月份查找个人考勤信息汇总的月份属性
    private String month;
    // 通过月份查找个人考勤信息汇总的第一次查找日期的属性
    private String HIDUKE;

    public String getHIDUKE() {
        return HIDUKE;
    }

    public void setHIDUKE(String hIDUKE) {
        HIDUKE = hIDUKE;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    // 通过月份查找个人考勤信息汇总的第一次查找日期的集合
    private List<JNTCIAttendance001> searchdate001;
    // 通过月份查找个人考勤信息汇总的查找某月所有人该月的考勤信息的集合
    List<JNTCIQueryFrom> searchshismonthmessage;

    public List<JNTCIAttendance001> getSearchdate001() {
        return searchdate001;
    }

    public void setSearchdate001(List<JNTCIAttendance001> searchdate001) {
        this.searchdate001 = searchdate001;
    }

    public List<JNTCIQueryFrom> getSearchshismonthmessage() {
        return searchshismonthmessage;
    }

    public void setSearchshismonthmessage(
            List<JNTCIQueryFrom> searchshismonthmessage) {
        this.searchshismonthmessage = searchshismonthmessage;
    }

    public List<JNTCIQueryOutput> getTempList() {
        return tempList;
    }

    public void setTempList(List<JNTCIQueryOutput> tempList) {
        this.tempList = tempList;
    }

    private String year;// 年份
    // 以下集合用于向前台返回个人考勤信息汇总
    List<JNTCIAttendance002VO> personalcount001;

    public List<JNTCIAttendance002VO> getPersonalcount001() {
        return personalcount001;
    }

    public void setPersonalcount001(List<JNTCIAttendance002VO> personalcount001) {
        this.personalcount001 = personalcount001;
    }

    // 计算出勤的天数
    private String DAYS;
    // 加班时间
    private String extra_time;
    // 加班类型
    private String extra_type;
    // 天津卡号
    private String tj_card;
    // 个人月度加班总时间
    private Double overtimeall;
    // 加班超过2.5小时，能过获得加班用餐补助的天数
    private Integer mealtimes;
    // 总迟到时间
    private Double COMELATETIME;
    // 早退总时间
    private Double LEAVEEARLYTIME;
    private Integer WORKDAYS;// 应该出勤天数
    private Integer OUTDAYS;// 该月出差天数
    private Double ONLEAVE;// 请假小时数
    private Double WEEKOVERTIMEALL;// 周末加班总时间
    private Double HOLIDAYOVERTIMEALL;// 节假日加班总时间
    private Integer ONHOLIDAYSMEALTIMES;// 周末或节假日用餐次数
    private String ABNORMAL;// 设置是否异常
    private Integer HANGOVER;// 旷工天数
    // 用减法来做考勤汇总的查询Temp_ATTENCE_MANAGER1表的集合
    List<JNTCIAttendance002VO> distinctpeople;
    // 用减法来做考勤汇总的向前台返值的集合
    List<JNTCIAttendance002VO> frontcount;

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getDAYS() {
        return DAYS;
    }

    public void setDAYS(String dAYS) {
        DAYS = dAYS;
    }

    public String getExtra_time() {
        return extra_time;
    }

    public void setExtra_time(String extra_time) {
        this.extra_time = extra_time;
    }

    public String getExtra_type() {
        return extra_type;
    }

    public void setExtra_type(String extra_type) {
        this.extra_type = extra_type;
    }

    public String getTj_card() {
        return tj_card;
    }

    public void setTj_card(String tj_card) {
        this.tj_card = tj_card;
    }

    public Double getOvertimeall() {
        return overtimeall;
    }

    public void setOvertimeall(Double overtimeall) {
        this.overtimeall = overtimeall;
    }

    public Integer getMealtimes() {
        return mealtimes;
    }

    public void setMealtimes(Integer mealtimes) {
        this.mealtimes = mealtimes;
    }

    public Double getCOMELATETIME() {
        return COMELATETIME;
    }

    public void setCOMELATETIME(Double cOMELATETIME) {
        COMELATETIME = cOMELATETIME;
    }

    public Double getLEAVEEARLYTIME() {
        return LEAVEEARLYTIME;
    }

    public void setLEAVEEARLYTIME(Double lEAVEEARLYTIME) {
        LEAVEEARLYTIME = lEAVEEARLYTIME;
    }

    public Integer getWORKDAYS() {
        return WORKDAYS;
    }

    public void setWORKDAYS(Integer wORKDAYS) {
        WORKDAYS = wORKDAYS;
    }

    public Integer getOUTDAYS() {
        return OUTDAYS;
    }

    public void setOUTDAYS(Integer oUTDAYS) {
        OUTDAYS = oUTDAYS;
    }

    public Double getONLEAVE() {
        return ONLEAVE;
    }

    public void setONLEAVE(Double oNLEAVE) {
        ONLEAVE = oNLEAVE;
    }

    public Double getWEEKOVERTIMEALL() {
        return WEEKOVERTIMEALL;
    }

    public void setWEEKOVERTIMEALL(Double wEEKOVERTIMEALL) {
        WEEKOVERTIMEALL = wEEKOVERTIMEALL;
    }

    public Double getHOLIDAYOVERTIMEALL() {
        return HOLIDAYOVERTIMEALL;
    }

    public void setHOLIDAYOVERTIMEALL(Double hOLIDAYOVERTIMEALL) {
        HOLIDAYOVERTIMEALL = hOLIDAYOVERTIMEALL;
    }

    public Integer getONHOLIDAYSMEALTIMES() {
        return ONHOLIDAYSMEALTIMES;
    }

    public void setONHOLIDAYSMEALTIMES(Integer oNHOLIDAYSMEALTIMES) {
        ONHOLIDAYSMEALTIMES = oNHOLIDAYSMEALTIMES;
    }

    public String getABNORMAL() {
        return ABNORMAL;
    }

    public void setABNORMAL(String aBNORMAL) {
        ABNORMAL = aBNORMAL;
    }

    public Integer getHANGOVER() {
        return HANGOVER;
    }

    public void setHANGOVER(Integer hANGOVER) {
        HANGOVER = hANGOVER;
    }

    public List<JNTCIAttendance002VO> getDistinctpeople() {
        return distinctpeople;
    }

    public void setDistinctpeople(List<JNTCIAttendance002VO> distinctpeople) {
        this.distinctpeople = distinctpeople;
    }

    public List<JNTCIAttendance002VO> getFrontcount() {
        return frontcount;
    }

    public void setFrontcount(List<JNTCIAttendance002VO> frontcount) {
        this.frontcount = frontcount;
    }

}
