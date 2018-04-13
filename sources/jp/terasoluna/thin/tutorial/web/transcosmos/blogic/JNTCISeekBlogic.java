package jp.terasoluna.thin.tutorial.web.transcosmos.blogic;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;

import jp.terasoluna.fw.dao.QueryDAO;
import jp.terasoluna.fw.service.thin.BLogic;
import jp.terasoluna.fw.service.thin.BLogicResult;
import jp.terasoluna.thin.tutorial.web.transcosmos.dto.JNTCISeekInput;
import jp.terasoluna.thin.tutorial.web.transcosmos.dto.JNTCISeekOutput;
import jp.terasoluna.thin.tutorial.web.transcosmos.dto.JNTCISeekWeek;

public class JNTCISeekBlogic implements BLogic<JNTCISeekInput> {

	private QueryDAO queryDAO = null;

	public void setQueryDAO(QueryDAO queryDAO) {
		this.queryDAO = queryDAO;
	}

	public BLogicResult execute(JNTCISeekInput param) {


		int entryTime = 0;
		int outTime = 999999;
		String entry_time = queryDAO.executeForObject("getSeekSelect1", param,String.class);//查询出入社时间
		String out_time = queryDAO.executeForObject("getSeekSelect2", param,String.class);//查询出退职时间
		if(entry_time != null){
			//得到入社时间的年月，並去掉斜杠
		 entryTime = Integer.parseInt(entry_time.substring(0,8).replace("/", ""));}
		if(out_time != null){
		 outTime = Integer.parseInt(out_time.substring(0,8).replace("/", ""));}//得到退职时间的年月，並去掉斜杠
		int subTime = 0;

		Map<Integer, JNTCISeekOutput> map = new HashMap<Integer, JNTCISeekOutput>();// 储存打卡日期在表中的位置和打卡记录
		List<JNTCISeekOutput> mid = new ArrayList<JNTCISeekOutput>();// 为了填满所有的日历空格。
		List<JNTCISeekOutput> leaveList = new ArrayList<JNTCISeekOutput>();
		List<JNTCISeekOutput> evectionlist = new ArrayList<JNTCISeekOutput>();
		int dateOfMonth = 0;
		int limit1 = 42;
		int limit2 = 6;
		List<JNTCISeekWeek> weekList = new ArrayList<JNTCISeekWeek>();// 为了迭代日历表做的特殊变量
		int dt = 0;
		BLogicResult result = new BLogicResult();
		JNTCISeekOutput output = new JNTCISeekOutput();
		output.setScrollPosit(param.getScrollPosit());
		TimeZone.setDefault(TimeZone.getTimeZone("GMT+8"));//设置时区为（当前时区（东八区）的时间）
		Calendar calendar = Calendar.getInstance();//getInstance()方法中返回的是createCalendar()方法，在这个createCalendar()方法中通过多态new了Calendar的子类，创建了对象。

		if (param.getYymm() == null) {// 默认设置为上个月的打卡记录，组成和数据库一样的日期格式
			SimpleDateFormat df = new SimpleDateFormat("yyyy/MM");// 设置日期格式
			param.setYymm(df.format(new Date()));


			int year = Integer.parseInt(param.getYymm().substring(0, 4));
			int mm = Integer.parseInt(param.getYymm().substring(5, 7));
			calendar.set(year, mm - 1, 1);//猜测该段代码可能是将得到的月份加一，得到的天数减一
			// Calendar.DATE只是java里面Calendar定义的一个常量，相当于用来取出日期的key，比如一个map中含有key和value的是差不多道理.....
			dateOfMonth = calendar.getActualMaximum(Calendar.DATE);//根据你传入的参数代表的意思(年、月、周等)查询当前(年、月、周)拥有的最大值。如果是年就查询这一年中的天数，如果月份就查询当前月中的天数，如果是周就查询当前周的天数
			dt = calendar.get(Calendar.DAY_OF_WEEK);


			subTime = Integer.parseInt(param.getYymm().replace("/", ""));
		} else {// 查询特定月份，设置月份变量的格式
			int year = Integer.parseInt(param.getYymm().substring(0, 4));
			int mm = Integer.parseInt(param.getYymm().substring(5, 7));
			calendar.set(year, mm - 1, 1);
			dateOfMonth = calendar.getActualMaximum(Calendar.DATE);
			dt = calendar.get(Calendar.DAY_OF_WEEK);//返回的是当前周的第几天，星期天是第一天，也就是星期几要减1
			subTime = Integer.parseInt(param.getYymm().replace("/", ""));//用subTime来接收传过来的年月并去掉斜杠
		}
		List<JNTCISeekOutput> su = queryDAO.executeForObjectList("s1", param);// 获取打卡记录
		List<JNTCISeekOutput> su1 = queryDAO.executeForObjectList("s2", param);// 获取请假
		List<JNTCISeekOutput> holidaylist = queryDAO.executeForObjectList("s4",
				param);// 获取本月涉及到法定节假日
		List<JNTCISeekOutput> extra_list = queryDAO.executeForObjectList("s5",
				param);//获取加班时间相关
		List<JNTCISeekOutput> evection_list = queryDAO.executeForObjectList(
				"s6", param);// 获取出差
		Integer[] a = new Integer[su.size()];// 存储打卡的日期所在日历标的位置，位置开始从零算,数组长度为该人出勤的天数
		Map<Integer, String> evection_dt = new HashMap<Integer, String>();
		Map<Integer, String> extra_dt = new HashMap<Integer, String>();
		for (int i = 0; i < extra_list.size(); i++) {// 加班处理
			int sz = Integer.parseInt(extra_list.get(i).getDt());
			extra_dt.put(sz, extra_list.get(i).getExtra_state());
			extra_list.get(i).setShowId(
					"" + Integer.parseInt(extra_list.get(i).getDt()));
		}
		for (int i = 0; i < evection_list.size(); i++) {// 出差处理
			if ("false".equalsIgnoreCase(evection_list.get(i).getMm_start())) {
				evection_list.get(i).setDt("01");
			}
			if ("false".equalsIgnoreCase(evection_list.get(i).getMm_end())) {
				evection_list.get(i).setDt_end(String.valueOf(dateOfMonth));
			}
			int evection_dd_str = Integer
					.parseInt(evection_list.get(i).getDt());// 获取出差的开始日期
			int evection_dd_end = Integer.parseInt(evection_list.get(i)
					.getDt_end());// 获取出差的结束日期
			for (int j = evection_dd_str; j <= evection_dd_end; j++) {
				JNTCISeekOutput evection = new JNTCISeekOutput();
				evection_dt.put(j, String.valueOf(j));
				evection.setShowId(String.valueOf(j));
				evection.setEvectionStarttime(evection_list.get(i)
						.getEvectionStarttime());
				evection.setEvectionEndtime(evection_list.get(i)
						.getEvectionEndtime());
				evection.setEvectionDestination(evection_list.get(i)
						.getEvectionDestination());
				evectionlist.add(evection);
			}
		}
		for (int n = 0; n < su.size(); n++) {// 打卡记录处理
			long st_time = noonTime(su.get(n).getStart_time());
			long ed_time = noonTime(su.get(n).getEnd_time());
			if (su.get(n).getStart_time() == null
					&& su.get(n).getEnd_time() == null) {
				if (noonTime(su.get(n).getLeaveStartTime()) < 83100
						|| noonTime(su.get(n).getLeaveEndTime()) >= 173000) {
					su.get(n).setComeState(0);
				} else {
					su.get(n).setComeState(1);
				}
			} else {
				if ((noonTime(su.get(n).getLeaveStartTime()) < 83100 && ((st_time <= noonTime(su
						.get(n).getLeaveEndTime()) && ed_time >= 173000) || noonTime(su
						.get(n).getLeaveEndTime()) >= 173000))
						|| (st_time < 83100 && ((ed_time >= noonTime(su.get(n)
								.getLeaveStartTime()) && noonTime(su.get(n)
								.getLeaveEndTime()) >= 173000) || ed_time >= 173000))) {
					su.get(n).setComeState(0);
				} else {
					su.get(n).setComeState(1);
				}
			}
			Integer date = Integer.parseInt(su.get(n).getDt()) + dt - 2;// 每月的第一天是从1开始的，强制从零开始，系统计算周几也是从一开始的，强制0是周天
			su.get(n).setDt(String.valueOf(date - dt + 2));
			if (st_time != 0 && ed_time != 0) {
				su.get(n).setEnd_time(
						"last_card : "
								+ su.get(n)
										.getEnd_time()
										.substring(
												su.get(n).getEnd_time()
														.indexOf(" ") + 1,
												su.get(n).getEnd_time()
														.length()));
				su.get(n).setStart_time(
						"first_card : "
								+ su.get(n)
										.getStart_time()
										.substring(
												su.get(n).getStart_time()
														.indexOf(" ") + 1,
												su.get(n).getStart_time()
														.length()));
			}
			map.put(date, su.get(n));
			a[n] = date;
		}
		if (dateOfMonth + dt - 1 <= 35) {
			limit1 = 35;
			limit2 = 5;
		}
		for (Integer n = 0; n < limit1; n++) {
			boolean simble = false;
			JNTCISeekOutput adddto = new JNTCISeekOutput();
			for (int i = 0; i < a.length; i++) {
				if (n == a[i]) {
					simble = true;
					mid.add(map.get(a[i]));
				}
			}
			if (simble == false) {
				if (n >= (dt - 1) && n < (dateOfMonth + dt - 1)) {
					adddto.setDt(String.valueOf(n + 2 - dt));
				}
				mid.add(adddto);
			}
		}

		for (int i = 0; i < su1.size(); i++) {// 请假管理的处理
			String start_mm = su1.get(i).getLeaveStartTime();
			String end_mm = su1.get(i).getLeaveEndTime();
			int leave_time_start = 1;
			if (su1.get(i)
					.getLeaveStartTime()
					.substring(0,
							su1.get(i).getLeaveStartTime().lastIndexOf("/"))
					.trim().compareTo(param.getYymm()) != 0) {
				start_mm = param.getYymm() + "/" + "01" + " " + "00" + ":"
						+ "00" + ":" + "00";
			} else {
				leave_time_start = Integer
						.parseInt(su1
								.get(i)
								.getLeaveStartTime()
								.substring(
										su1.get(i).getLeaveStartTime()
												.lastIndexOf("/") + 1,
										su1.get(i).getLeaveStartTime()
												.indexOf(" ")));
			}
			int leave_time_end = 0;
			if (su1.get(i)
					.getLeaveEndTime()
					.substring(0, su1.get(i).getLeaveEndTime().lastIndexOf("/"))
					.trim().compareTo(param.getYymm()) != 0) {// 请假结束日期是夸月的，则设置为本月的最后一天
				leave_time_end = dateOfMonth;
				end_mm = su1
						.get(i)
						.getLeaveEndTime()
						.substring(0,
								su1.get(i).getLeaveEndTime().lastIndexOf("/"))
						.trim()
						+ "/" + dateOfMonth + " " + "24:00:00";
			} else {
				leave_time_end = Integer
						.parseInt(su1
								.get(i)
								.getLeaveEndTime()
								.substring(
										su1.get(i).getLeaveEndTime()
												.lastIndexOf("/") + 1,
										su1.get(i).getLeaveEndTime()
												.indexOf(" ")));
			}
			long str1 = 0;
			long str2 = 0;
			str1 = sub(start_mm);// 在此调用在最下写的截取值得方法
			// 请假的开始与结束时间不在工作时间内，不在同一个月内的处理
			if (str1 >= 173000) {
				if (leave_time_start == dateOfMonth) {
					continue;
				}
				leave_time_start = leave_time_start + 1;
			}
			str2 = sub(end_mm);
			if (str2 < 83100) {
				if (leave_time_end == 1) {
					continue;
				}
				leave_time_end = leave_time_end - 1;
			}
			for (int j = 0; j < mid.size(); j++) {
				JNTCISeekOutput leaveDto = new JNTCISeekOutput();
				if (mid.get(j).getDt() == null || "".equals(mid.get(j).getDt())) {
					continue;
				}
				int x = Integer.parseInt(mid.get(j).getDt());
				if (x >= leave_time_start && x <= leave_time_end) {
					if ((j + 7) % 7 != 0 && (j + 7) % 7 != 6) {
						mid.get(j).setExamineState("会社を休む");
						leaveDto.setShowId(mid.get(j).getDt());
						leaveDto.setLeaveEndTime(su1.get(i).getLeaveEndTime());
						leaveDto.setLeaveStartTime(su1.get(i)
								.getLeaveStartTime());
						leaveDto.setLeaveType(su1.get(i).getLeaveType());
						leaveList.add(leaveDto);
					}
				}
			}
		}
		for (int i = 0; i < holidaylist.size(); i++) {// 国家法定节假日内处理打卡记录
			String start_mm = holidaylist
					.get(i)
					.getHoliday_start_time()
					.substring(
							0,
							holidaylist.get(i).getHoliday_start_time()
									.lastIndexOf("/")).trim();// 获取节假日的年月
			String end_mm = holidaylist
					.get(i)
					.getHoliday_end_time()
					.substring(
							0,
							holidaylist.get(i).getHoliday_end_time()
									.lastIndexOf("/")).trim();
			if (start_mm.compareTo(param.getYymm()) != 0) {
				holidaylist.get(i).setHoliday_start_time(
						param.getYymm() + "/" + "01" + " " + "00" + ":" + "00"
								+ ":" + "00");
			} else {
				holidaylist.get(i).setHoliday_start_time(
						holidaylist.get(i).getHoliday_start_time() + " "
								+ "00:00:00");
			}
			int holiday_time_start = Integer.parseInt(holidaylist
					.get(i)
					.getHoliday_start_time()
					.substring(
							holidaylist.get(i).getHoliday_start_time()
									.lastIndexOf("/") + 1,
							holidaylist.get(i).getHoliday_start_time()
									.indexOf(" ")));
			int holiday_time_end = 0;
			if (end_mm.compareTo(param.getYymm()) != 0) {// 请假结束日期是夸月的，则设置为本月的最后一天
				holiday_time_end = dateOfMonth;
				holidaylist.get(i).setHoliday_end_time(
						end_mm + "/" + dateOfMonth + " " + "24:00:00");
			} else {
				holidaylist.get(i).setHoliday_end_time(
						holidaylist.get(i).getHoliday_end_time() + " "
								+ "00:00:00");
				holiday_time_end = Integer.parseInt(holidaylist
						.get(i)
						.getHoliday_end_time()
						.substring(
								holidaylist.get(i).getHoliday_end_time()
										.lastIndexOf("/") + 1,
								holidaylist.get(i).getHoliday_end_time()
										.indexOf(" ")));
			}
			for (int j = 0; j < mid.size(); j++) {
				if (mid.get(j).getDt() == null || "".equals(mid.get(j).getDt())) {
					continue;
				}
				int x = Integer.parseInt(mid.get(j).getDt());
				if (x >= holiday_time_start && x <= holiday_time_end) {// 节假日打卡没有迟到异常
					mid.get(j).setExamineState(
							holidaylist.get(i).getHoliday_name());
					mid.get(j).setEarlier_state(null);
					mid.get(j).setLate_state(null);
					mid.get(j).setState(true);
				}
			}
		}
		for (int i = 0; i < limit2; i++) {// 获取当前年月日
			JNTCISeekWeek midWeek = new JNTCISeekWeek();
			weekList.add(midWeek);
		}
		Calendar this_calendar = Calendar.getInstance();
		int this_mm = this_calendar.get(Calendar.MONTH) + 1;
		String this_date;
		if (this_mm < 10) {
			this_date = this_calendar.get(Calendar.YEAR) + "/" + "0" + this_mm;
		} else {
			this_date = this_calendar.get(Calendar.YEAR) + "/" + this_mm;
		}
		for (int i = 0; i < mid.size(); i++) {// 将数据表做成二维数据表

			if ((i + 7) % 7 != 0 || (i + 7) % 7 != 6) {
				if (param.getYymm().equals(this_date)) {
					if ((mid.get(i).getExamineState() == null || "".equals(mid
							.get(i).getExamineState()))
							&& ((mid.get(i).getStart_time() == null || ""
									.equals(mid.get(i).getStart_time())) && (mid
									.get(i).getEnd_time() == null || ""
									.equals(mid.get(i).getEnd_time())))
							&& mid.get(i).getDt() != null
							&& Integer.parseInt(mid.get(i).getDt()) < this_calendar
									.get(Calendar.DATE)) {
							 if(entryTime>subTime){
						        	mid.get(i).setLate_state("未入社");
									mid.get(i).setState(false);
						        }else if(outTime<subTime){
						        	mid.get(i).setLate_state("退職");
									mid.get(i).setState(false);
						        }else{
						        	mid.get(i).setLate_state("欠勤");
									mid.get(i).setState(false);
						        }
					}
				} else if (Long.parseLong(this_date.replaceAll("/", "")) > Long
						.parseLong(param.getYymm().replaceAll("/", ""))) {

					if ((mid.get(i).getExamineState() == null || "".equals(mid
							.get(i).getExamineState()))
							&& ((mid.get(i).getStart_time() == null || ""
									.equals(mid.get(i).getStart_time())) && (mid
									.get(i).getEnd_time() == null || ""
									.equals(mid.get(i).getEnd_time())))
							&& mid.get(i).getDt() != null) {
						 if(entryTime>subTime){
					        	mid.get(i).setLate_state("未入社");
								mid.get(i).setState(false);
					        }else if(outTime<subTime){
					        	mid.get(i).setLate_state("退職");
								mid.get(i).setState(false);
					        }else{
					        	mid.get(i).setLate_state("欠勤");
								mid.get(i).setState(false);
					        }
					}
				}
			}
			if (evection_dt.get(i + 2 - dt) != null) {
				mid.get(i).setLate_state("出張");
			}
			if (extra_dt.get(i + 2 - dt) != null) {
				mid.get(i).setExtra_symbol("殘業");
				mid.get(i).setExtra_state(extra_dt.get(i + 2 - dt));
			}
			int x = (i + 7) % 7;// 计算所在列
			int y = i / 7;// 计算所在的行数
			switch (x) {
			case 0:
				weekList.get(y).setSunday(mid.get(i));
				break;
			case 1:
				weekList.get(y).setMonday(mid.get(i));
				break;
			case 2:
				weekList.get(y).setTuesday(mid.get(i));
				break;
			case 3:
				weekList.get(y).setWednesday(mid.get(i));
				break;
			case 4:
				weekList.get(y).setTursday(mid.get(i));
				break;
			case 5:
				weekList.get(y).setFriday(mid.get(i));
				break;
			case 6:
				weekList.get(y).setSaturday(mid.get(i));
				break;
			}
		      //  }
		}
		String name = queryDAO.executeForObject("s3", param.getJn_card(),
				String.class);
		output.setName(name);

		output.setYymm(param.getYymm());
		output.setCard(param.getJn_card());
		output.setWeekList(weekList);
		output.setExtra_list(extra_list);
		output.setEvectionlist(evectionlist);
		output.setLeaveList(leaveList);
		result.setResultObject(output);
		result.setResultString("success");

		return result;
	}

	public long sub(String Time) {
		if (Time == null || Time.equals("")) {
			return 0;
		}
		String str1 = Time.substring(Time.indexOf(" ") + 1, Time.indexOf(":"));
		String str2 = Time.substring(Time.indexOf(":") + 1,
				Time.lastIndexOf(":"));
		String str3 = Time.substring(Time.lastIndexOf(":") + 1, Time.length());
		if (Integer.parseInt(str1) < 10) {
			str1 = "0" + Integer.parseInt(str1);
		}
		if (Integer.parseInt(str2) < 10) {
			str2 = "0" + Integer.parseInt(str2);
		}
		if (Integer.parseInt(str3) < 10) {
			str3 = "0" + Integer.parseInt(str3);
		}
		long x = Long.parseLong(str1 + str2 + str3);
		return x;

	}

	public long noonTime(String Time) {
		long noon_Time = sub(Time);
		if (noon_Time >= 115000 && noon_Time <= 135000) {
			noon_Time = 115000;
		}
		return noon_Time;
	}
}
