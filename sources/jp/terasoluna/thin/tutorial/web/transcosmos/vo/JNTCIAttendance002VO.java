package jp.terasoluna.thin.tutorial.web.transcosmos.vo;

import java.util.Date;

public class JNTCIAttendance002VO {

    private String JN_CARD;
    private String NAME;
    private String DEPT_ID;
    private String START_TIME;
    private String END_TIME;
    private Integer TIME_COUNT;
    private String IJYOU_FLAG;
    private String TOROKU_USER;
    private String TOROKU_TIMESTAMP;
    private String month;
    private String year;
    private String HIDUKE;
    // 计算出勤的天数
    private Integer DAYS;
    // 天津卡号
    private String tj_card;
    // 个人月度加班总时间
    private Double overtimeall;
    // 加班超过2.5小时，能过获得加班用餐补助的天数
    private Integer mealtimes;
    // 总迟到时间
    private Double COMELATETIME;
    // 总早退时间
    private Double LEAVEEARLYTIME;
    private Integer WORKDAYS;// 应该出勤天数
    private Integer OUTDAYS;// 该月出差天数
    private Double ONLEAVE;// 请假小时数
    private Double WEEKOVERTIMEALL;// 周末加班总时间
    private Double HOLIDAYOVERTIMEALL;// 节假日加班总时间
    private Integer ONHOLIDAYSMEALTIMES;// 周末或节假日用餐次数
    private String ABNORMAL;// 设置是否异常
    private Integer HANGOVER;// 旷工天数
    private Date LEAVE_STARTTIME;// 请假开始时间
    private Date LEAVE_ENDTIME;// 请假结束时间
    private Date EVECTION_STARTTIME;// 出差开始时间
    private Date EVECTION_ENDTIME;// 出差结束时间

    public Date getEVECTION_STARTTIME() {
        return EVECTION_STARTTIME;
    }

    public void setEVECTION_STARTTIME(Date eVECTION_STARTTIME) {
        EVECTION_STARTTIME = eVECTION_STARTTIME;
    }

    public Date getEVECTION_ENDTIME() {
        return EVECTION_ENDTIME;
    }

    public void setEVECTION_ENDTIME(Date eVECTION_ENDTIME) {
        EVECTION_ENDTIME = eVECTION_ENDTIME;
    }

    public Date getLEAVE_STARTTIME() {
        return LEAVE_STARTTIME;
    }

    public void setLEAVE_STARTTIME(Date lEAVE_STARTTIME) {
        LEAVE_STARTTIME = lEAVE_STARTTIME;
    }

    public Date getLEAVE_ENDTIME() {
        return LEAVE_ENDTIME;
    }

    public void setLEAVE_ENDTIME(Date lEAVE_ENDTIME) {
        LEAVE_ENDTIME = lEAVE_ENDTIME;
    }

    public Integer getHANGOVER() {
        return HANGOVER;
    }

    public void setHANGOVER(Integer hANGOVER) {
        HANGOVER = hANGOVER;
    }

    public String getABNORMAL() {
        return ABNORMAL;
    }

    public void setABNORMAL(String aBNORMAL) {
        ABNORMAL = aBNORMAL;
    }

    public Integer getONHOLIDAYSMEALTIMES() {
        return ONHOLIDAYSMEALTIMES;
    }

    public void setONHOLIDAYSMEALTIMES(Integer oNHOLIDAYSMEALTIMES) {
        ONHOLIDAYSMEALTIMES = oNHOLIDAYSMEALTIMES;
    }

    public Double getHOLIDAYOVERTIMEALL() {
        return HOLIDAYOVERTIMEALL;
    }

    public void setHOLIDAYOVERTIMEALL(Double hOLIDAYOVERTIMEALL) {
        HOLIDAYOVERTIMEALL = hOLIDAYOVERTIMEALL;
    }

    public Double getWEEKOVERTIMEALL() {
        return WEEKOVERTIMEALL;
    }

    public void setWEEKOVERTIMEALL(Double wEEKOVERTIMEALL) {
        WEEKOVERTIMEALL = wEEKOVERTIMEALL;
    }

    public Double getLEAVEEARLYTIME() {
        return LEAVEEARLYTIME;
    }

    public void setLEAVEEARLYTIME(Double lEAVEEARLYTIME) {
        LEAVEEARLYTIME = lEAVEEARLYTIME;
    }

    public Double getONLEAVE() {
        return ONLEAVE;
    }

    public void setONLEAVE(Double oNLEAVE) {
        ONLEAVE = oNLEAVE;
    }

    public Integer getOUTDAYS() {
        return OUTDAYS;
    }

    public void setOUTDAYS(Integer oUTDAYS) {
        OUTDAYS = oUTDAYS;
    }

    public Integer getWORKDAYS() {
        return WORKDAYS;
    }

    public void setWORKDAYS(Integer wORKDAYS) {
        WORKDAYS = wORKDAYS;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public Double getCOMELATETIME() {
        return COMELATETIME;
    }

    public void setCOMELATETIME(Double cOMELATETIME) {
        COMELATETIME = cOMELATETIME;
    }

    public Integer getMealtimes() {
        return mealtimes;
    }

    public void setMealtimes(Integer mealtimes) {
        this.mealtimes = mealtimes;
    }

    public Double getOvertimeall() {
        return overtimeall;
    }

    public void setOvertimeall(Double overtimeall) {
        this.overtimeall = overtimeall;
    }

    public String getTj_card() {
        return tj_card;
    }

    public void setTj_card(String tj_card) {
        this.tj_card = tj_card;
    }

    public Integer getDAYS() {
        return DAYS;
    }

    public void setDAYS(Integer dAYS) {
        DAYS = dAYS;
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

    public Integer getTIME_COUNT() {
        return TIME_COUNT;
    }

    public void setTIME_COUNT(Integer tIME_COUNT) {
        TIME_COUNT = tIME_COUNT;
    }

    public String getIJYOU_FLAG() {
        return IJYOU_FLAG;
    }

    public void setIJYOU_FLAG(String iJYOU_FLAG) {
        IJYOU_FLAG = iJYOU_FLAG;
    }

    public String getTOROKU_USER() {
        return TOROKU_USER;
    }

    public void setTOROKU_USER(String tOROKU_USER) {
        TOROKU_USER = tOROKU_USER;
    }

    public String getTOROKU_TIMESTAMP() {
        return TOROKU_TIMESTAMP;
    }

    public void setTOROKU_TIMESTAMP(String tOROKU_TIMESTAMP) {
        TOROKU_TIMESTAMP = tOROKU_TIMESTAMP;
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
