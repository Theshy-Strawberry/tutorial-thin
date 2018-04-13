package jp.terasoluna.thin.tutorial.web.transcosmos.form;

import java.util.Date;
import java.util.List;

import jp.terasoluna.fw.web.struts.form.ValidatorActionFormEx;
import jp.terasoluna.thin.tutorial.web.transcosmos.dto.Winput;

public class Wform extends ValidatorActionFormEx {

    private static final long serialVersionUID = 1L;

    private String startyear;
    private String startmonth;
    private String startday;
    private String endyear;
    private String endmonth;
    private String endday;
    private String name;
    private String startholidaydate;
    private String endholidaydate;
    private String holidayid;
    private Date updatetime;
    private List<Winput> holidaylist;
    private List<Winput> holidaylist1;
    private List<Winput> holidaytimelist;
    private String flag;
    private String xDay;
    private String name1;
    private String name2;

	public String getName2() {
		return name2;
	}
	public void setName2(String name2) {
		this.name2 = name2;
	}
    public String getName1() {
		return name1;
	}

	public void setName1(String name1) {
		this.name1 = name1;
	}

	public List<Winput> getHolidaytimelist() {
        return holidaytimelist;
    }

    public void setHolidaytimelist(List<Winput> holidaytimelist) {
        this.holidaytimelist = holidaytimelist;
    }

    public String getxDay() {
        return xDay;
    }

    public void setxDay(String xDay) {
        this.xDay = xDay;
    }

    private String row = "5";
    private String startIndex = "0";
    private String totalCount = null;

    private String total;

    public List<Winput> getHolidaylist1() {
        return holidaylist1;
    }

    public void setHolidaylist1(List<Winput> holidaylist1) {
        this.holidaylist1 = holidaylist1;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
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

    public String getStartyear() {
        return startyear;
    }

    public void setStartyear(String startyear) {
        this.startyear = startyear;
    }

    public String getStartmonth() {
        return startmonth;
    }

    public void setStartmonth(String startmonth) {
        this.startmonth = startmonth;
    }

    public String getStartday() {
        return startday;
    }

    public void setStartday(String startday) {
        this.startday = startday;
    }

    public String getEndyear() {
        return endyear;
    }

    public void setEndyear(String endyear) {
        this.endyear = endyear;
    }

    public String getEndmonth() {
        return endmonth;
    }

    public void setEndmonth(String endmonth) {
        this.endmonth = endmonth;
    }

    public String getEndday() {
        return endday;
    }

    public void setEndday(String endday) {
        this.endday = endday;
    }

    public List<Winput> getHolidaylist() {
        return holidaylist;
    }

    public void setHolidaylist(List<Winput> holidaylist) {
        this.holidaylist = holidaylist;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getHolidayid() {
        return holidayid;
    }

    public void setHolidayid(String holidayid) {
        this.holidayid = holidayid;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStartholidaydate() {
        return startholidaydate;
    }

    public void setStartholidaydate(String startholidaydate) {
        this.startholidaydate = startholidaydate;
    }

    public String getEndholidaydate() {
        return endholidaydate;
    }

    public void setEndholidaydate(String endholidaydate) {
        this.endholidaydate = endholidaydate;
    }

}
