package jp.terasoluna.thin.tutorial.web.transcosmos.blogic;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/*import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;*/

import jp.terasoluna.fw.dao.QueryDAO;
import jp.terasoluna.fw.dao.UpdateDAO;
import jp.terasoluna.fw.service.thin.BLogic;
import jp.terasoluna.fw.service.thin.BLogicMessage;
import jp.terasoluna.fw.service.thin.BLogicMessages;
import jp.terasoluna.fw.service.thin.BLogicResult;
import jp.terasoluna.thin.tutorial.web.common.controller.GetWorkDay;
/*import jp.terasoluna.thin.tutorial.web.common.controller.Mail;*/
import jp.terasoluna.thin.tutorial.web.transcosmos.dto.JNTCIBusinessVerify01Output;
import jp.terasoluna.thin.tutorial.web.transcosmos.dto.JNTCIBusinessVerify02Input;


public class JNTCIBusinessVerifySureBLogic implements
BLogic<JNTCIBusinessVerify02Input> {

	/**
	 * QueryDAO?B Spring????C???X?^???X?????????????B
	 */
	private QueryDAO queryDAO = null;

	public QueryDAO getQueryDAO() {
		return queryDAO;
	}

	/**
	 * QueryDAO??????B
	 *
	 * @param queryDAO
	 */
	public void setQueryDAO(QueryDAO queryDAO) {
		this.queryDAO = queryDAO;
	}

	private UpdateDAO updateDAO = null;

	public void setUpdateDAO(UpdateDAO updateDAO) {
		this.updateDAO = updateDAO;
	}

	public UpdateDAO getUpdateDAO() {
		return updateDAO;
	}

public BLogicResult execute(JNTCIBusinessVerify02Input param) {
	JNTCIBusinessVerify01Output output = new JNTCIBusinessVerify01Output();
	BLogicResult result = new BLogicResult();
	BLogicMessages messages = new BLogicMessages();
	if(param.getUserName()==null){
		String userId=param.getUserId();
		 String userName=queryDAO.executeForObject("selectuserName11", userId, String.class);
		 param.setUserName(userName);
	}
	if("4".equals(param.getFlag())){
	if (param.getDeleteId_card() != null) {
		String deleteId_card = "";
		String cardss=param.getDeleteId_card();
		if (param.getDeleteId_card().contains(",")) {
			String[] cards = param.getDeleteId_card().split(",");
			for (int i = 0; i < cards.length; i++) {
				deleteId_card = cards[i];
				String examineStatus=queryDAO.executeForObject("selectexamineStatus",deleteId_card,String.class);
				String ShenQingRen=queryDAO.executeForObject("selectShenQingRen",deleteId_card,String.class);
				String userId=param.getUserId();
				String leader=queryDAO.executeForObject("selectleaderChuchai",userId,String.class);
				param.setLeader(leader);
				param.setDeleteId_card(deleteId_card);
				String starttime=queryDAO.executeForObject("selectEvectionStartTime",deleteId_card,String.class);
				String endtime=queryDAO.executeForObject("selectEvectionEndTime",deleteId_card,String.class);
				 if("A04".equals(examineStatus) || "A07".equals(examineStatus)){
					 updateDAO.execute("JNTCIBusinessVerifyUpdate", deleteId_card);
					 updateDAO.execute("JNTCIBusinessVerifyUpdateLeader", param);
					/*String offic_mail=queryDAO.executeForObject("selectyouxiangbyLeader",leader,String.class);
						String address =offic_mail+ "@trans-cosmos.com.cn";
							InternetAddress sendTo[] = new InternetAddress[1];
							try {
								sendTo[0]= new InternetAddress(address);
							} catch (AddressException e) {
								e.printStackTrace();
							}
							String content ="xingさん<br>お疲れ様です。nameです。<br><br> 因项目需求，yuangong申请出差。<br><br>时间：start至end<br><br>望批准。<br><br>以上です、よろしくお願い致します。";
							content = content.replaceAll("name", param.getUserName());
							content = content.replaceAll("yuangong", ShenQingRen);
							content = content.replaceAll("xing", leader.substring(0,1));
							content = content.replaceAll("start", starttime);
							content = content.replaceAll("end", endtime);

							String jncard=param.getUserId();
							String officemail = queryDAO.executeForObject("findOfficEmail",jncard, String.class);
							String maillian = "@trans-cosmos.com.cn";
							String from = officemail + maillian;
							String subject="出差申请";
							Mail.sendAll(from, "123456", sendTo, null, null, subject, content,null);*/
				 }else{
					 messages.add("message",new BLogicMessage("errors.shujucaozuo",deleteId_card));
				 }
				 }


			  result.setErrors(messages);
			result.setResultString("success");
			output.setDeleteId_card(cardss);
			result.setResultObject(output);
			return result;
		}else{
			deleteId_card = param.getDeleteId_card();
			String examineStatus=queryDAO.executeForObject("selectexamineStatus",deleteId_card,String.class);
			String userId=param.getUserId();
			String ShenQingRen=queryDAO.executeForObject("selectShenQingRen",deleteId_card,String.class);
			String starttime=queryDAO.executeForObject("selectEvectionStartTime",deleteId_card,String.class);
			String endtime=queryDAO.executeForObject("selectEvectionEndTime",deleteId_card,String.class);
			String leader=queryDAO.executeForObject("selectleaderChuchai",userId,String.class);
			 if("A04".equals(examineStatus) || "A07".equals(examineStatus)){
				 updateDAO.execute("JNTCIBusinessVerifyUpdate", deleteId_card);
				 updateDAO.execute("JNTCIBusinessVerifyUpdateLeader", leader);
				 /*String offic_mail=queryDAO.executeForObject("selectyouxiang1",param,String.class);
					String address =offic_mail+ "@trans-cosmos.com.cn";
						InternetAddress sendTo[] = new InternetAddress[1];
						try {
							sendTo[0]= new InternetAddress(address);
						} catch (AddressException e) {
							e.printStackTrace();
						}
						String content ="xingさん<br>お疲れ様です。nameです。<br><br> 因?目需求，yuangong申请出差。<br><br>时间：start至end<br><br>望批准。<br><br>以上です、よろしくお願い致します。";
						content = content.replaceAll("name", param.getUserName());
						content = content.replaceAll("yuangong", ShenQingRen);
						content = content.replaceAll("xing", leader.substring(0,1));
						content = content.replaceAll("start", starttime);
						content = content.replaceAll("end", endtime);

						String jncard=param.getUserId();
						String officemail = queryDAO.executeForObject("findOfficEmail",jncard, String.class);
						String maillian = "@trans-cosmos.com.cn";
						String from = officemail + maillian;
						String subject="出差申请";
						Mail.sendAll(from, "123456", sendTo, null, null, subject, content,null);*/
			 }else{
				 messages.add("message",new BLogicMessage("errors.shujucaozuo",deleteId_card));
				 }
			 result.setErrors(messages);
			result.setResultString("success");
			output.setDeleteId_card(cardss);
			result.setResultObject(output);
			return result;
			 }
	}
	}else if("1".equals(param.getFlag())){
		if (param.getDeleteId_card() != null) {
			String deleteId_card = "";
			if (param.getDeleteId_card().contains(",")) {
				String[] cards = param.getDeleteId_card().split(",");
				for (int i = 0; i < cards.length; i++) {
					deleteId_card = cards[i];
					String examineStatus=queryDAO.executeForObject("selectexamineStatus",deleteId_card,String.class);
					String starttime=queryDAO.executeForObject("selectEvectionStartTime",deleteId_card,String.class);
					String endtime=queryDAO.executeForObject("selectEvectionEndTime",deleteId_card,String.class);
					String ShenQingRen=queryDAO.executeForObject("selectShenQingRen",deleteId_card,String.class);
					String id=param.getUserId();
					param.setExamineStatus(examineStatus);
					if("1002".equals(id)){

						if("A09".equals(examineStatus)){
							param.setExamineStatus("");
						}
					}else{
						if("A05".equals(examineStatus)){
							param.setExamineStatus("");
						}
						if("A08".equals(examineStatus)){
							param.setExamineStatus("");
						}

					}
					if("A01".equals(examineStatus) || "A05".equals(param.getExamineStatus())|| "A04".equals(examineStatus)|| "A09".equals(param.getExamineStatus())|| "A08".equals(param.getExamineStatus())){
						/* param.setExaminePerson(param.getUserName());*/
/*						 String start=starttime;
						 String end=endtime;
					     // 取得数据?中的假期List
					    	  int chaxuncount=queryDAO.executeForObject("JNTCIBusinessVerifycountDeleteChaxun",param,Integer.class);
					    	  if(chaxuncount!=0){
					    		  updateDAO.execute("JNTCIBusinessVerifycountDelete", param);
					    	  }
					     List<Date> holidaylist = queryDAO.executeForObjectList("holidaylist", null);
					     String format = "yyyy/MM";
					     String[] end1 = end.split("/");
					     String[] start1 =start.split("/");
					     String end2 = end1[0] + "/" + end1[1];
					     String start2 = start1[0] + "/" + start1[1];

					     Date datestart = null;
					     try
					     {

					         SimpleDateFormat sdf = new SimpleDateFormat(format);
					         Calendar sdate = Calendar.getInstance();
					         String sfd = start;
					         SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy/MM");

					       while(end2.compareTo(start2) > 0){
					             datestart = sdf.parse(start);
					             sdate.setTime(datestart);
					             int day = sdate.getActualMaximum(Calendar.DAY_OF_MONTH);
					             sfd = start2 + "/" + day;
					             int count = GetWorkDay.workDays(start,sfd,holidaylist);
					             param.setDay(start2);
					             param.setCount(count);
					             //sql
					             updateDAO.execute("JNTCIBusinessVerifycount", param);
					             sdate.add(Calendar.MONTH, +1);
					             String dateStr = sdf1.format(sdate.getTime());
					             start = dateStr + "/01";
					             start1 =start.split("/");
					             end2 = end1[0] + "/" + end1[1];
					             start2 = start1[0] + "/" + start1[1];

					         }
					          int count = GetWorkDay.workDays(start,end,holidaylist);
					          param.setDay(start2);
					          param.setCount(count);
					         //sql
					          updateDAO.execute("JNTCIBusinessVerifycount", param);

					     }
					     catch (Exception e)
					     {
					         e.printStackTrace();
					     }
*/
					     if("1002".equals(id)){
					    	 String start=starttime;
							 String end=endtime;
						     // 取得数据?中的假期List
						    	  int chaxuncount=queryDAO.executeForObject("JNTCIBusinessVerifycountDeleteChaxun",param,Integer.class);
						    	     param.setDeleteId_card(deleteId_card);
						    	  if(chaxuncount!=0){
						    		  updateDAO.execute("JNTCIBusinessVerifycountDelete", param);
						    	  }
						     List<Date> holidaylist = queryDAO.executeForObjectList("holidaylist", null);
						     String format = "yyyy/MM";
						     String[] end1 = end.split("/");
						     String[] start1 =start.split("/");
						     String end2 = end1[0] + "/" + end1[1];
						     String start2 = start1[0] + "/" + start1[1];

						     Date datestart = null;
						     try
						     {

						         SimpleDateFormat sdf = new SimpleDateFormat(format);
						         Calendar sdate = Calendar.getInstance();
						         String sfd = start;
						         SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy/MM");

						       while(end2.compareTo(start2) > 0){
						             datestart = sdf.parse(start);
						             sdate.setTime(datestart);
						             int day = sdate.getActualMaximum(Calendar.DAY_OF_MONTH);
						             sfd = start2 + "/" + day;
						             int count = GetWorkDay.workDays(start,sfd,holidaylist);
						             param.setDay(start2);
						             param.setCount(count);
						             //sql
						             param.setDeleteId_card(deleteId_card);
						             updateDAO.execute("JNTCIBusinessVerifycountone", param);
						             sdate.add(Calendar.MONTH, +1);
						             String dateStr = sdf1.format(sdate.getTime());
						             start = dateStr + "/01";
						             start1 =start.split("/");
						             end2 = end1[0] + "/" + end1[1];
						             start2 = start1[0] + "/" + start1[1];

						         }
						          int count = GetWorkDay.workDays(start,end,holidaylist);
						          param.setDay(start2);
						          param.setCount(count);
						          param.setDeleteId_card(deleteId_card);
						         //sql
						          updateDAO.execute("JNTCIBusinessVerifycountone", param);

						     }
						     catch (Exception e)
						     {
						         e.printStackTrace();
						     }
				    	     param.setExaminePerson(param.getUserName());
				    	     param.setDeleteId_card(deleteId_card);
							updateDAO.execute("JNTCIBusinessVerify1Update", param);
						}else{
							 param.setDeleteId_card(deleteId_card);
							 param.setExaminePerson("田東啓");
							updateDAO.execute("JNTCIBusinessVerify6Update", param);
						}


						/*String offic_mail=queryDAO.executeForObject("selectyouxiang2",param,String.class);
							String address =offic_mail+ "@trans-cosmos.com.cn";
								InternetAddress sendTo[] = new InternetAddress[1];
								try {
									sendTo[0]= new InternetAddress(address);
								} catch (AddressException e) {
									e.printStackTrace();
								}
								String content ="xingさん<br>お疲れ様です。nameです。<br><br> 出差申请批准。<br><br>以上です、よろしくお願い致します。";
								content = content.replaceAll("name", param.getUserName());
								content = content.replaceAll("xing", ShenQingRen.substring(0,1));
								String jncard=param.getUserId();
								String officemail = queryDAO.executeForObject("findOfficEmail",jncard, String.class);
								String maillian = "@trans-cosmos.com.cn";
								String from = officemail + maillian;
								String subject="出差申请批准";
								Mail.sendAll(from, "123456", sendTo, null, null, subject, content,null);*/
					}else{
						messages.add("message",new BLogicMessage("errors.shujucaozuo",deleteId_card));
						 }
				}


				  result.setErrors(messages);
					result.setResultString("success");
					output.setDeleteId_card(param.getDeleteId_card());
					result.setResultObject(output);
					return result;
			}else{
				deleteId_card = param.getDeleteId_card();
				String examineStatus=queryDAO.executeForObject("selectexamineStatus",deleteId_card,String.class);
				String starttime=queryDAO.executeForObject("selectEvectionStartTime",deleteId_card,String.class);
				String endtime=queryDAO.executeForObject("selectEvectionEndTime",deleteId_card,String.class);
				String ShenQingRen=queryDAO.executeForObject("selectShenQingRen",deleteId_card,String.class);
				param.setExamineStatus(examineStatus);
				String id=param.getUserId();
				if("1002".equals(id)){

					if("A09".equals(examineStatus)){
						param.setExamineStatus("");
					}
				}else{
					if("A05".equals(examineStatus)){
						param.setExamineStatus("");
					}
					if("A08".equals(examineStatus)){
						param.setExamineStatus("");
					}

				}
				if("A01".equals(examineStatus) || "A05".equals(param.getExamineStatus())|| "A04".equals(examineStatus)|| "A09".equals(param.getExamineStatus())|| "A08".equals(param.getExamineStatus())){
				/*	updateDAO.execute("JNTCIBusinessVerify1Update", deleteId_card);*/

				     // 取得数据?中的假期List
					 /*String start=starttime;
					 String end=endtime;
				    	  int chaxuncount=queryDAO.executeForObject("JNTCIBusinessVerifycountDeleteChaxun",param,Integer.class);
				    	  if(chaxuncount!=0){
				    		  updateDAO.execute("JNTCIBusinessVerifycountDelete", param);
				    	  }
				     List<Date> holidaylist = queryDAO.executeForObjectList("holidaylist", null);
				     String format = "yyyy/MM";
				     String[] end1 = end.split("/");
				     String[] start1 =start.split("/");
				     String end2 = end1[0] + "/" + end1[1];
				     String start2 = start1[0] + "/" + start1[1];

				     Date datestart = null;
				     try
				     {

				         SimpleDateFormat sdf = new SimpleDateFormat(format);
				         Calendar sdate = Calendar.getInstance();
				         String sfd = start;
				         SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy/MM");

				       while(end2.compareTo(start2) > 0){
				             datestart = sdf.parse(start);
				             sdate.setTime(datestart);
				             int day = sdate.getActualMaximum(Calendar.DAY_OF_MONTH);
				             sfd = start2 + "/" + day;
				             int count = GetWorkDay.workDays(start,sfd,holidaylist);
				             param.setDay(start2);
				             param.setCount(count);
				             //sql
				             updateDAO.execute("JNTCIBusinessVerifycount", param);
				             sdate.add(Calendar.MONTH, +1);
				             String dateStr = sdf1.format(sdate.getTime());
				             start = dateStr + "/01";
				             start1 =start.split("/");
				             end2 = end1[0] + "/" + end1[1];
				             start2 = start1[0] + "/" + start1[1];

				         }
				          int count = GetWorkDay.workDays(start,end,holidaylist);
				          param.setDay(start2);
				          param.setCount(count);
				         //sql
				          updateDAO.execute("JNTCIBusinessVerifycount", param);

				     }
				     catch (Exception e)
				     {
				         e.printStackTrace();
				     }*/
				     if("1002".equals(id)){
				    	 String start=starttime;
						 String end=endtime;
					    	  int chaxuncount=queryDAO.executeForObject("JNTCIBusinessVerifycountDeleteChaxun",param,Integer.class);
					    	  if(chaxuncount!=0){
					    		  updateDAO.execute("JNTCIBusinessVerifycountDelete", param);
					    	  }
					     List<Date> holidaylist = queryDAO.executeForObjectList("holidaylist", null);
					     String format = "yyyy/MM";
					     String[] end1 = end.split("/");
					     String[] start1 =start.split("/");
					     String end2 = end1[0] + "/" + end1[1];
					     String start2 = start1[0] + "/" + start1[1];

					     Date datestart = null;
					     try
					     {

					         SimpleDateFormat sdf = new SimpleDateFormat(format);
					         Calendar sdate = Calendar.getInstance();
					         String sfd = start;
					         SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy/MM");

					       while(end2.compareTo(start2) > 0){
					             datestart = sdf.parse(start);
					             sdate.setTime(datestart);
					             int day = sdate.getActualMaximum(Calendar.DAY_OF_MONTH);
					             sfd = start2 + "/" + day;
					             int count = GetWorkDay.workDays(start,sfd,holidaylist);
					             param.setDay(start2);
					             param.setCount(count);
					             //sql
					             updateDAO.execute("JNTCIBusinessVerifycountone", param);
					             sdate.add(Calendar.MONTH, +1);
					             String dateStr = sdf1.format(sdate.getTime());
					             start = dateStr + "/01";
					             start1 =start.split("/");
					             end2 = end1[0] + "/" + end1[1];
					             start2 = start1[0] + "/" + start1[1];

					         }
					          int count = GetWorkDay.workDays(start,end,holidaylist);
					          param.setDay(start2);
					          param.setCount(count);
					         //sql
					          updateDAO.execute("JNTCIBusinessVerifycountone", param);

					     }
					     catch (Exception e)
					     {
					         e.printStackTrace();
					     }
				    	     param.setExaminePerson(param.getUserName());
				    	     param.setDeleteId_card(deleteId_card);
							updateDAO.execute("JNTCIBusinessVerify1Update", param);
						}else{
							 param.setDeleteId_card(deleteId_card);
							 param.setExaminePerson("田東啓");
							updateDAO.execute("JNTCIBusinessVerify6Update", param);
						}


				/*String offic_mail=queryDAO.executeForObject("selectyouxiang2",param,String.class);
				String address =offic_mail+ "@trans-cosmos.com.cn";
					InternetAddress sendTo[] = new InternetAddress[1];
					try {
						sendTo[0]= new InternetAddress(address);
					} catch (AddressException e) {
						e.printStackTrace();
					}
					String content ="xingさん<br>お疲れ様です。nameです。<br><br> 出差申请批准。<br><br>以上です、よろしくお願い致します。";
					content = content.replaceAll("name", param.getUserName());
					content = content.replaceAll("xing", ShenQingRen.substring(0,1));
					String jncard=param.getUserId();
					String officemail = queryDAO.executeForObject("findOfficEmail",jncard, String.class);
					String maillian = "@trans-cosmos.com.cn";
					String from = officemail + maillian;
					String subject="出差申请批准";
					Mail.sendAll(from, "123456", sendTo, null, null, subject, content,null);*/
				}else{
					 messages.add("message",new BLogicMessage("errors.shujucaozuo",deleteId_card));
				        result.setErrors(messages);
				 }
			}
		}
	}else if("0".equals(param.getFlag())){

	}else if("1072".equals(param.getUserId())){

	}else{

	        messages.add("message",
	                new BLogicMessage("message.info"));
	        result.setMessages(messages);
	}

	result.setResultString("success");
	output.setDeleteId_card(param.getDeleteId_card());
	result.setResultObject(output);
	return result;
}

}

