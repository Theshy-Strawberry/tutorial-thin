package jp.terasoluna.thin.tutorial.web.transcosmos.blogic;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import jp.terasoluna.fw.dao.QueryDAO;
import jp.terasoluna.fw.dao.UpdateDAO;
import jp.terasoluna.fw.service.thin.BLogic;
import jp.terasoluna.fw.service.thin.BLogicMessage;
import jp.terasoluna.fw.service.thin.BLogicMessages;
import jp.terasoluna.fw.service.thin.BLogicResult;
import jp.terasoluna.thin.tutorial.web.transcosmos.dto.Winput;

public class WriteholidayBlogic implements BLogic<Winput> {
	private QueryDAO queryDAO = null;

	public void setQueryDAO(QueryDAO queryDAO) {
		this.queryDAO = queryDAO;
	}

	private UpdateDAO updateDAO = null;

	public void setUpdateDAO(UpdateDAO updateDAO) {
		this.updateDAO = updateDAO;
	}

	public BLogicResult execute(Winput param) {
		BLogicResult result = new BLogicResult();
		param.setName(param.getName2());
		String startholidaydate = param.getStartyear();
		String endholidaydate =param.getEndyear();
		String holidayname = param.getName2();
		String holidayid = queryDAO.executeForObject("holiMaxID", null,
				String.class);
		if (holidayid == null) {
			holidayid = "1";
		}
		param.setHolidayid(holidayid);
		param.setStartholidaydate(startholidaydate);
		param.setEndholidaydate(endholidaydate);
		param.setName2(holidayname);
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");// 隶ｾ鄂ｮ譌･譛滓�蠑�
		Date date = null;
		try {
			date = df.parse(df.format(new Date()));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		param.setUpdatetime(date);
		List<Winput> winputlist= queryDAO.executeForObjectList("selectholidaycount", param);

		List<Winput> namelist = queryDAO.executeForObjectList("selectholidaynamecount", param);
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		List<Winput> startyear = queryDAO.executeForObjectList("selectstartyear",param);
		List<Winput> endyear = queryDAO.executeForObjectList("selectendyear",param);
		try {
			Date dateOne = dateFormat.parse(startholidaydate);
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(dateOne);
			int inputyear1 =calendar.get(Calendar.YEAR);
			String year1=String.valueOf(inputyear1);
			Date dateTwo = dateFormat.parse(endholidaydate);
			calendar.setTime(dateTwo);
			int intputyear2 =calendar.get(Calendar.YEAR);
			String year2 = String.valueOf(intputyear2);
			//判断添加假日的名称是否相同
			if(namelist.size() !=0){//假日名称相同
				int count=0;
				for(int i=0;i<startyear.size();i++){
					for(int j=0;j<endyear.size();j++){
						String syear1 = startyear.get(i).getStartyear();
						String eyear1 = endyear.get(j).getEndyear();
						//判断年份是否相同
						if(syear1.equals(year1)){//年份相同时，报错：该年份，已经添加该节日
							if(eyear1.equals(year2)){
								BLogicMessages messages = new BLogicMessages();
								messages.add("message", new BLogicMessage(
										"holidaymessage.insert.failure1", param.getName()));
								result.setErrors(messages);
								result.setResultString("success");
								break;
							}
						}else if(!syear1.equals(year1)){//年份不相同时，判断添加的日期是否已被其他日期占领
							if(!eyear1.equals(year2)){
								if(winputlist.size()==0){//若该日期没有被其他节日占领，则直接添加数据
									count++;
									if(namelist.size()==count){
										calendar.setTime(dateOne);

										while (calendar.getTime().before(dateTwo)
												|| calendar.getTime().equals(dateTwo)) {
											String xDay = dateFormat.format(calendar.getTime());
											param.setxDay(xDay);
											calendar.add(Calendar.DAY_OF_MONTH, 1);
											updateDAO.execute("addDay", param);
										}
										updateDAO.execute("add", param);
										BLogicMessages messages = new BLogicMessages();
										messages.add("message", new BLogicMessage(
												"holidaymessage.insert.success", param.getName()));
										result.setMessages(messages);
										result.setResultString("success");
										//break;
									}
								}else{//若已被占领，则提示：重新输入日期
									BLogicMessages messages = new BLogicMessages();
									messages.add("message", new BLogicMessage(
											"holidaymessage.insert.failure2",  param.getName()));
									result.setErrors(messages);
									result.setResultString("success");
								}
							}
							break;
						}
					}
				}
			}else{//假日名称不存在时，应该判断输入的日期是否已被其他节日占领
				 if (winputlist.size() == 0) {//若没有，则直接添加信息
					 calendar.setTime(dateOne);

						while (calendar.getTime().before(dateTwo)
								|| calendar.getTime().equals(dateTwo)) {
							String xDay = dateFormat.format(calendar.getTime());
							param.setxDay(xDay);
							calendar.add(Calendar.DAY_OF_MONTH, 1);
							updateDAO.execute("addDay", param);
						}
						updateDAO.execute("add", param);
						BLogicMessages messages = new BLogicMessages();
						messages.add("message", new BLogicMessage(
								"holidaymessage.insert.success", param.getName()));
						result.setMessages(messages);
						result.setResultString("success");
				 }else{//若有，则提示：重新输入日期
					 BLogicMessages messages = new BLogicMessages();
						messages.add("message", new BLogicMessage(
								"holidaymessage.insert.failure2",  param.getName()));
						result.setErrors(messages);
						result.setResultString("success");
				 }
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}

		Winput output=new Winput();
		output.setName2(param.getName2());
		output.setStartyear(param.getStartyear());
		output.setEndyear(param.getEndyear());
		result.setResultObject(output);
		return result;
	}
}