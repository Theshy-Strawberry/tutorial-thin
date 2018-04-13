package jp.terasoluna.thin.tutorial.web.transcosmos.blogic;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import jp.terasoluna.fw.dao.QueryDAO;
import jp.terasoluna.fw.service.thin.BLogic;
import jp.terasoluna.fw.service.thin.BLogicMessage;
import jp.terasoluna.fw.service.thin.BLogicMessages;
import jp.terasoluna.fw.service.thin.BLogicResult;
import jp.terasoluna.thin.tutorial.web.common.controller.DateController;
import jp.terasoluna.thin.tutorial.web.common.controller.GetWorkDay;
import jp.terasoluna.thin.tutorial.web.common.controller.TimeCompare;
import jp.terasoluna.thin.tutorial.web.common.controller.Vocation;
import jp.terasoluna.thin.tutorial.web.transcosmos.dto.JNTCIQueryInput;
import jp.terasoluna.thin.tutorial.web.transcosmos.dto.JNTCIQueryOutput;
import jp.terasoluna.thin.tutorial.web.transcosmos.vo.JNTCIVocationVo;

public class JNTCIQuerycount implements BLogic<JNTCIQueryInput> {

	private QueryDAO queryDAO = null;

	public BLogicResult execute(JNTCIQueryInput param) {

		BLogicResult result = new BLogicResult();
		String ym = null;
		// 取得数据库中的假期List
		List<Date> holidaylist = queryDAO.executeForObjectList("holidaylist", null);

		String time = DateController.getDateToString(new Date(), DateController.YyM);
		String timeym = time.substring(0, 7);
		try {
			ym = param.getYm();
		} catch (NullPointerException exception) {
		}
		if (ym == null) {
			ym = timeym;
		}

		SimpleDateFormat df = new SimpleDateFormat("yyyy/MM");
		Calendar sdate = Calendar.getInstance();

		Date dateaa = null;
		int days = 0;
		String jn_card = param.getUser_id();
		JNTCIQueryOutput cardMap = new JNTCIQueryOutput();
		cardMap.setYm(ym);
		if (jn_card != null && !("".equals(jn_card))) {
			cardMap.setJn_card(jn_card);
		} else {
			jn_card = null;
			cardMap.setJn_card(jn_card);
		}
		List<JNTCIQueryOutput> userList = queryDAO.executeForObjectList("userListId", cardMap);
		List<JNTCIQueryOutput> absenceList = new ArrayList<JNTCIQueryOutput>();
		double absence = 0;
		int overCount = 0;
		int l = 0;
		for (int m = 0; m < userList.size(); m++) {
		    if(m > 0){
		        if(!(userList.get(m).getJn_card().equals(userList.get(m - 1).getJn_card()))){
		            overCount = 0;
		        }
		    }
			int t = 0;
			// 判断是否是工作日
			t = GetWorkDay.workDays(GetWorkDay.getYearMonthDay(userList.get(m).getYmd()),
					GetWorkDay.getYearMonthDay(userList.get(m).getYmd()), holidaylist);
			// 是工作日时
			if (t > 0) {
				cardMap = new JNTCIQueryOutput();
				cardMap.setJn_card(userList.get(m).getJn_card());

				cardMap.setYmd(userList.get(m).getYmd());
				// 取得某员工一天的打卡与请假数据
				List<JNTCIQueryOutput> timeList = queryDAO.executeForObjectList("timeListId", cardMap);
				double absenceeach = 0;
				int hangover = 0;
				// 当数据只有一条时
				if (timeList.size() == 1) {
					// 如果一天中某段缺勤时间大于一小时
					if ("08:30:00".compareTo(GetWorkDay.getHms(timeList.get(0).getEndtime())) > 0
							|| "17:30:00".compareTo(GetWorkDay.getHms(timeList.get(0).getStarttime())) < 0
							|| timeList.get(0).getStarttime().compareTo(timeList.get(0).getEndtime()) == 0) {
						// 算作旷工一天
						hangover = 1;
					} else {
						// 取得一天中缺勤总时间
						double timeCount = 8 - TimeCompare.getTimeCount(timeList.get(0).getStarttime(), timeList.get(0)
								.getEndtime());
						// 如果缺勤总时间小于一小时
						if (timeCount <= 1) {
							// 算作迟到早退
							absenceeach += timeCount;
						} else if (timeCount > 1) {
							// 如果一天中某段缺勤时间大于一小时
							if (TimeCompare.getAbsenceCount("08:30:00", timeList.get(0).getStarttime()) > 1
									|| TimeCompare.getAbsenceCount(timeList.get(0).getEndtime(), "17:30:00") > 1) {
								// 算作旷工一天
								hangover = 1;
								absenceeach = 0;
							} else {
								// 算作迟到早退
								absenceeach += (8 - TimeCompare.getTimeCount(timeList.get(0).getStarttime(), timeList
										.get(0).getEndtime()));
							}
						}
					}
				} else {
					if (timeList.size() != 0) {
						// 如果一天中打卡与请假数据最早时间比08：00：00晚一小时 或
						// 打卡与请假数据最晚时间比08：00：00早一小时
						if (TimeCompare.getAbsenceCount("08:30:00", timeList.get(0).getStarttime()) > 1
								|| TimeCompare.getAbsenceCount(timeList.get(timeList.size() - 1).getEndtime(),
										"17:30:00") > 1) {
							// 算作旷工一天
							hangover = 1;
							absenceeach = 0;
						} else {
							for (int z = 1; z < timeList.size(); z++) {
								// 如果一天中打卡与请假数据出现一条数据包含另一条数据的情况
								if (GetWorkDay.getHms(timeList.get(z - 1).getEndtime()).compareTo(
										GetWorkDay.getHms(timeList.get(z).getEndtime())) > 0) {
									timeList.get(z).setEndtime(timeList.get(z - 1).getEndtime());
								} else {
									// 如果一天中某段缺勤时间大于一小时
									if (TimeCompare.getAbsenceCount(timeList.get(z - 1).getEndtime(), timeList.get(z)
											.getStarttime()) > 1) {
										// 算作旷工一天
										hangover = 1;
										absenceeach = 0;
									} else {
										absenceeach += TimeCompare.getAbsenceCount(timeList.get(z - 1).getEndtime(),
												timeList.get(z).getStarttime());
									}
								}
							}

							// 第一条数据的开始时间与08：30：00去比较
							if (TimeCompare.getAbsenceCount("08:30:00", timeList.get(0).getStarttime()) < 1) {
								absenceeach += TimeCompare.getAbsenceCount("08:30:00", timeList.get(0).getStarttime());
							}

							// 最后一条数据的结束时间与17：30：00去比较
							if (TimeCompare.getAbsenceCount(timeList.get(timeList.size() - 1).getEndtime(), "17:30:00") < 1) {
								absenceeach += TimeCompare.getAbsenceCount(timeList.get(timeList.size() - 1)
										.getEndtime(), "17:30:00");
							}
						}
					}
				}
				if (hangover == 1) {
					absenceeach = 0;
				}
				if (m > 0) {
					if (userList.get(m).getJn_card().equals(userList.get(m - 1).getJn_card())) {
						absence += absenceeach;
						overCount += hangover;
						if (m == (userList.size() - 1)) {
							cardMap = new JNTCIQueryOutput();
							cardMap.setJn_card(userList.get(m).getJn_card());
							cardMap.setAbsence(absence);
							cardMap.setHangover(overCount);
							absenceList.add(l, cardMap);
						}
					} else {
						cardMap = new JNTCIQueryOutput();
						cardMap.setJn_card(userList.get(m - 1).getJn_card());
						cardMap.setAbsence(absence);
						cardMap.setHangover(overCount);
						absenceList.add(l, cardMap);
						l++;
						absence = 0;
						overCount = 0;
						overCount += hangover;
						absence += absenceeach;
					}
				} else {
					overCount += hangover;
					absence += absenceeach;
					if (m == (userList.size() - 1)) {
						cardMap = new JNTCIQueryOutput();
						cardMap.setJn_card(userList.get(m).getJn_card());
						cardMap.setAbsence(absence);
						cardMap.setHangover(overCount);
						absenceList.add(l, cardMap);
					}
				}
			}

		}

		try {
			dateaa = df.parse(ym);
			sdate.setTime(dateaa);

			// 取得该月的最后一天
			int day = sdate.getActualMaximum(Calendar.DAY_OF_MONTH);
			String start = ym + "/01";
			String end = ym + "/" + day;

			// 取得该月的应该出勤天数
			days = GetWorkDay.workDays(start, end, holidaylist);
			int count = 0;
			JNTCIQueryInput tempMap = new JNTCIQueryInput();
			tempMap.setYm(ym);
			tempMap.setUser_id(param.getUser_id());
			tempMap.setUser_name(param.getUser_name());
			// 查询结果
			List<JNTCIQueryOutput> tempList = queryDAO.executeForObjectList("queryList", tempMap);
			if (tempList.isEmpty()) {
				BLogicMessages messages = new BLogicMessages();
				messages.add("message", new BLogicMessage("message.null"));
				result.setMessages(messages);
			}
			int listsize = tempList.size();
			if (listsize != 0) {
				for (int i = 0; i < tempList.size(); i++) {

					String userId = tempList.get(i).getJn_card();
					count = days * 8;
					cardMap = new JNTCIQueryOutput();
					cardMap.setYm(ym);
					cardMap.setJn_card(userId);
					List<JNTCIQueryOutput> temList = queryDAO.executeForObjectList("userListId", cardMap);
					int tempCount = 0;
					int attendence = 0;
					for (int n = 0; n < temList.size(); n++) {
						tempCount = GetWorkDay.workDays(temList.get(n).getYmd(), temList.get(n).getYmd(), holidaylist);
						if (tempCount > 0) {
							attendence += 1;
						}
					}
					// 取得旷工时间
					int resultCount = days - tempList.get(i).getEvection_count() - attendence;
					int entryCount = 0;
					int outCount = 0;
					String entry_time = tempList.get(i).getEntry_time();
					String out_time = tempList.get(i).getOut_time();
					if (entry_time != null) {
						if (ym.equals(entry_time.substring(0, 7))) {
							entryCount = GetWorkDay.workDays(ym + "/01", entry_time, holidaylist) - 1;
						}
					}
					if (out_time.equals("2099/12/31")) {
						if (ym.equals(out_time.substring(0, 7))) {
							outCount = GetWorkDay.workDays(out_time, ym + "/" + GetWorkDay.maxDays(ym, "yyyy/MM"),
									holidaylist)-1;
						}
					}
					resultCount = resultCount - entryCount - outCount;
					for (int m = 0; m < absenceList.size(); m++) {
						if (userId.equals(absenceList.get(m).getJn_card())) {
							// 取得迟到早退总时间
							tempList.get(i).setAbsence(absenceList.get(m).getAbsence());
							// 取得旷工总时间
							resultCount = resultCount + absenceList.get(m).getHangover();
						}
					}
					if (resultCount <= 0) {
						resultCount = 0;
						tempList.get(i).setHangover(0);
					} else {
						tempList.get(i).setHangover(resultCount);
						tempList.get(i).setIjyou_flag(1);
					}

					// 取得应该出勤天数
					tempList.get(i).setDay(days);
					double kojyoCount = tempList.get(i).getKojyo_time();
					if (kojyoCount > 2) {
						kojyoCount -= 2;
					} else {
						kojyoCount = 0;
					}
					tempList.get(i).setKojyo_time(kojyoCount / 2);
					// 出勤总时间
					double resultTime = count - resultCount * 8 - tempList.get(i).getLeave_count()
							- tempList.get(i).getAbsence() - tempList.get(i).getKojyo_time();
					tempList.get(i).setCount(resultTime);
					// 事假、补卡扣除、迟到、早退总时间
					double overCountbf = 0;
					overCountbf = tempList.get(i).getKojyo_time() + tempList.get(i).getAbsence()
							+ tempList.get(i).getLeave_count1();
					tempList.get(i).setOvercountbf(overCountbf);
					if (overCountbf > 30) {
						tempList.get(i).setOverflag(1);
					} else {
						tempList.get(i).setOverflag(0);
					}
					// 事假、补卡扣除、迟到、早退抵消年假后的总时间
					JNTCIVocationVo vocation = queryDAO.executeForObject("vocationDetail", userId,
							JNTCIVocationVo.class);
					double overCountAf = overCountbf;
					if (vocation != null) {
						overCountAf = Vocation.getOverCountAf(vocation, overCountbf, ym);
					}
					tempList.get(i).setOvercountaf(overCountAf);
					if (entry_time != null) {
						if (ym.compareTo(entry_time.substring(0, 7)) < 0) {
							tempList.get(i).setIjyou_flag(0);
							tempList.get(i).setDay(0);
							tempList.get(i).setHangover(0);
						}
					}
				}
			}
			JNTCIQueryOutput out = new JNTCIQueryOutput();
			out.setScrollPosit(param.getScrollPosit());

			out.setUser_name(param.getUser_name());
			out.setJn_card(param.getUser_id());
			out.setYm(ym);
			out.setTempList(tempList);
			out.setListsize(listsize);
			result.setResultObject(out);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		result.setResultString("success");
		return result;
	}

	public QueryDAO getQueryDAO() {
		return queryDAO;
	}

	public void setQueryDAO(QueryDAO queryDAO) {
		this.queryDAO = queryDAO;
	}

}