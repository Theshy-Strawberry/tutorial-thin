package jp.terasoluna.thin.tutorial.web.transcosmos.dto;

import java.util.List;





















import jp.terasoluna.thin.tutorial.web.transcosmos.form.JNTCIQueryFrom;
import jp.terasoluna.thin.tutorial.web.transcosmos.vo.JNTCIAttendance001;
import jp.terasoluna.thin.tutorial.web.transcosmos.vo.JNTCIAttendance002VO;
import jp.terasoluna.thin.tutorial.web.transcosmos.vo.JNTCIAttendancecardsearch;
import jp.terasoluna.thin.tutorial.web.transcosmos.vo.JNTCIQueryOutvo;


public class JNTCIQueryOut {

	private List<JNTCIQueryOutvo> userList= null;

	private List<JNTCIQueryOutvo> userDeptList;

	private List<JNTCIQueryOutvo> userCcList;
	private String deptCode;
	public String getDeptCode() {
		return deptCode;
	}

	public void setDeptCode(String deptCode) {
		this.deptCode = deptCode;
	}

	private String attendanceStatus;
	public String getAttendanceStatus() {
		return attendanceStatus;
	}

	public void setAttendanceStatus(String attendanceStatus) {
		this.attendanceStatus = attendanceStatus;
	}

	// zhong shu
	private String totalCount;
	private String userId;
	private String JN_CARD;
	private String jnCard;
	private String jnName;
	public String getJnName() {
		return jnName;
	}

	public void setJnName(String jnName) {
		this.jnName = jnName;
	}

	private String deptuser_id;

	public String getDeptuser_id() {
		return deptuser_id;
	}

	public void setDeptuser_id(String deptuser_id) {
		this.deptuser_id = deptuser_id;
	}

	public String getJnCard() {
		return jnCard;
	}

	public void setJnCard(String jnCard) {
		this.jnCard = jnCard;
	}

	public String getJN_CARD() {
		return JN_CARD;
	}

	public void setJN_CARD(String jN_CARD) {
		JN_CARD = jN_CARD;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	private double sumTwo;
	private double sumJBpr;
	private double sumJBxiuxi;
	private double sumJBjiari;
	private double yearsJa;


	public double getYearsJa() {
		return yearsJa;
	}

	public void setYearsJa(double yearsJa) {
		this.yearsJa = yearsJa;
	}

	public double getSumJBjiari() {
		return sumJBjiari;
	}

	public void setSumJBjiari(double sumJBjiari) {
		this.sumJBjiari = sumJBjiari;
	}

	public double getSumJBpr() {
		return sumJBpr;
	}

	public void setSumJBpr(double sumJBpr) {
		this.sumJBpr = sumJBpr;
	}

	public double getSumTwo() {
		return sumTwo;
	}

	public double getSumJBxiuxi() {
		return sumJBxiuxi;
	}

	public void setSumJBxiuxi(double sumJBxiuxi) {
		this.sumJBxiuxi = sumJBxiuxi;
	}

	public void setSumTwo(double sumTwo) {
		this.sumTwo = sumTwo;
	}



	public List<JNTCIQueryOutvo> getUserList() {
		return userList;
	}

	public void setUserList(List<JNTCIQueryOutvo> userList) {
		this.userList = userList;
	}

	public String getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(String totalCount) {
		this.totalCount = totalCount;
	}

	public List<JNTCIQueryOutvo> getUserDeptList() {
		return userDeptList;
	}

	public void setUserDeptList(List<JNTCIQueryOutvo> userDeptList) {
		this.userDeptList = userDeptList;
	}

	public List<JNTCIQueryOutvo> getUserCcList() {
		return userCcList;
	}

	public void setUserCcList(List<JNTCIQueryOutvo> userCcList) {
		this.userCcList = userCcList;
	}



	private List<JNTCIAttendancecardsearch> jiansuomessage;

public List<JNTCIAttendancecardsearch> getJiansuomessage() {
		return jiansuomessage;
	}

	public void setJiansuomessage(List<JNTCIAttendancecardsearch> jiansuomessage) {
		this.jiansuomessage = jiansuomessage;
	}

private String jn_card;
private String work_date;
private String name;
private String dept_id;
private String start_date;
private String end_date;
private String ijyou_flag;
public String getJn_card() {
	return jn_card;
}

public void setJn_card(String jn_card) {
	this.jn_card = jn_card;
}

public String getWork_date() {
	return work_date;
}

public void setWork_date(String work_date) {
	this.work_date = work_date;
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


//通过月份查找个人考勤信息汇总的第一次查找日期的属性
		 private String HIDUKE;
//作为与数据库中月份对应的字段
		 private String month;


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
		//通过月份查找个人考勤信息汇总的第一次查找日期的集合
private List<JNTCIAttendance001> searchdate001;
//通过月份查找个人考勤信息汇总的查找某月所有人该月的考勤信息的集合
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

		//以下集合用于向前台返回个人考勤信息汇总
		private List<JNTCIAttendance002VO> personalcount001;

		public List<JNTCIAttendance002VO> getPersonalcount001() {
			return personalcount001;
		}
		public void setPersonalcount001(List<JNTCIAttendance002VO> personalcount001) {
			this.personalcount001 = personalcount001;
		}

		//前台页面遍历输出<bean:write name="" property="" />中的property属性与OUT输出类有关
		private String NAME;
		private String DEPT_ID;
		private Integer TIME_COUNT;
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

		public Integer getTIME_COUNT() {
			return TIME_COUNT;
		}

		public void setTIME_COUNT(Integer tIME_COUNT) {
			TIME_COUNT = tIME_COUNT;
		}
		//加班时间
		private String extra_time;
		//加班类型
		 private String extra_type;
		//天津卡号
		 private String tj_card;
		//个人月度加班总时间
			private Double overtimeall;
			//加班超过2.5小时，能过获得加班用餐补助的天数
			private Integer mealtimes;
			//总迟到时间
			private Double COMELATETIME;
//早退总时间
			private Double LEAVEEARLYTIME;
			private Integer WORKDAYS;//应该出勤天数
			private Integer OUTDAYS;//该月出差天数
			private Double ONLEAVE;//请假小时数
			private Double WEEKOVERTIMEALL;//周末加班总时间
			private Double HOLIDAYOVERTIMEALL;//节假日加班总时间
			private Integer ONHOLIDAYSMEALTIMES;//周末或节假日用餐次数
			private String ABNORMAL;//设置是否异常
			private Integer HANGOVER;//旷工天数

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




		public Double getLEAVEEARLYTIME() {
				return LEAVEEARLYTIME;
			}

			public void setLEAVEEARLYTIME(Double lEAVEEARLYTIME) {
				LEAVEEARLYTIME = lEAVEEARLYTIME;
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

		public String getExtra_time() {
			return extra_time;
		}
		public void setExtra_time(String extra_time) {
			this.extra_time = extra_time;
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

			public String getExtra_type() {
				return extra_type;
			}
			public void setExtra_type(String extra_type) {
				this.extra_type = extra_type;
			}
			//用减法来做考勤汇总的查询Temp_ATTENCE_MANAGER1表的集合
			List<JNTCIAttendance002VO> distinctpeople;
			//用减法来做考勤汇总的向前台返值的集合
			 List<JNTCIAttendance002VO> frontcount;
			public List<JNTCIAttendance002VO> getFrontcount() {
				return frontcount;
			}

			public void setFrontcount(List<JNTCIAttendance002VO> frontcount) {
				this.frontcount = frontcount;
			}

			public List<JNTCIAttendance002VO> getDistinctpeople() {
				return distinctpeople;
			}

			public void setDistinctpeople(List<JNTCIAttendance002VO> distinctpeople) {
				this.distinctpeople = distinctpeople;
			}

}
