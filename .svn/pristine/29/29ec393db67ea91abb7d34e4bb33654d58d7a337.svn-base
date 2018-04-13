package jp.terasoluna.thin.tutorial.web.transcosmos.blogic;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

import jp.terasoluna.fw.dao.QueryDAO;
import jp.terasoluna.fw.dao.UpdateDAO;
import jp.terasoluna.fw.service.thin.BLogic;
import jp.terasoluna.fw.service.thin.BLogicMessage;
import jp.terasoluna.fw.service.thin.BLogicMessages;
import jp.terasoluna.fw.service.thin.BLogicResult;
import jp.terasoluna.thin.tutorial.web.common.controller.GetWorkDay;
import jp.terasoluna.thin.tutorial.web.common.controller.Mail;
import jp.terasoluna.thin.tutorial.web.transcosmos.dto.JNTCIAttendance03Dto;
import jp.terasoluna.thin.tutorial.web.transcosmos.dto.JNTCIBusinessVerify01Output;
import jp.terasoluna.thin.tutorial.web.transcosmos.dto.JNTCIBusinessVerify02Input;
import jp.terasoluna.thin.tutorial.web.transcosmos.vo.JNTCIBusinessVerifyVo;

public class JNTCIBusinessVerify02BLogic implements
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
		if("back".equals(param.getExamineStatus())){
			int startIndex = 0;
			int row = 10;
			JNTCIBusinessVerify01Output output = new JNTCIBusinessVerify01Output();
			BLogicResult result = new BLogicResult();
			 List<JNTCIBusinessVerifyVo> JNTCIBusinessVerifyVoInfo = queryDAO.executeForObjectList("JNTCIBusinessVerifyVoInfo", null,startIndex, row);
			    String totalCount = queryDAO.executeForObject("JNTCIBusinessVerifyVoInfoCount", null, String.class);
			    List<JNTCIBusinessVerifyVo> examineList = queryDAO.executeForObjectList("examineStatus", null);
			    List<JNTCIBusinessVerifyVo> deptList = queryDAO.executeForObjectList("deptId", null);
					//審査者list
			    List<JNTCIAttendance03Dto> examinePersonList = queryDAO.executeForObjectList("examinePerson", null);

					 output.setJNTCIBusinessVerifyVoInfo(JNTCIBusinessVerifyVoInfo);
				        output.setTotalCount(totalCount);
				        output.setExamineList(examineList);
				        output.setDeptList(deptList);
				        output.setExaminePersonList(examinePersonList);

				output.setJNTCIBusinessVerifyVoInfo(JNTCIBusinessVerifyVoInfo);
				result.setResultObject(output);
			result.setResultString("success");
			return result;
		}else{

		int startIndex = 0;
		int row = 10;
		JNTCIBusinessVerify01Output output = new JNTCIBusinessVerify01Output();
		BLogicResult result = new BLogicResult();
		//


       if("4".equals(param.getFlag())){
    	   param.setExaminePerson("張棟");
    	 if("A07".equals(param.getExamineStatus())){
    		param.setExaminePerson("");
    		String offic_mail=queryDAO.executeForObject("selectyouxiang2",param,String.class);
			String address =offic_mail+ "@trans-cosmos.com.cn";
				InternetAddress sendTo[] = new InternetAddress[1];
				try {
					sendTo[0]= new InternetAddress(address);
				} catch (AddressException e) {
					e.printStackTrace();
				}
				String content ="xingさん<br>お疲れ様です。nameです。<br><br> 出差申请不批准。<br><br>以上です、よろしくお願い致します。";
				content = content.replaceAll("name", param.getUserName());
				content = content.replaceAll("xing", param.getUname1().substring(0,1));
				String jncard=param.getUserId();
				String officemail = queryDAO.executeForObject("findOfficEmail",jncard, String.class);
				String maillian = "@trans-cosmos.com.cn";
				String from = officemail + maillian;
				String subject="【系统邮件】【不批准】【出差申请】";
				Mail.sendAll(from, "123456", sendTo, null, null, subject, content,null);

    	 }else if("".equals(param.getExaminePerson())&&"A01".equals(param.getExamineStatus())){
    		 BLogicMessages messages = new BLogicMessages();
 			messages.add("message", new BLogicMessage("message.examineStatus"));/*message.examinePerson*/
 			result.setErrors(messages);
 			result.setResultString("success1");

 			return result;
    	 }else if("A04".equals(param.getExamineStatus())){
    		 param.setExaminePerson("");
    	 }
    	 else{
			 String offic_mail=queryDAO.executeForObject("selectyouxiang1",param,String.class);
				String address =offic_mail+ "@trans-cosmos.com.cn";
					InternetAddress sendTo[] = new InternetAddress[1];
					try {
						sendTo[0]= new InternetAddress(address);
					} catch (AddressException e) {
						e.printStackTrace();
					}
					String content ="xingさん<br>お疲れ様です。nameです。<br><br> 因项目需求，yuangong申请出差。<br><br>时间：start至end<br><br>望批准。<br><br>以上です、よろしくお願い致します。";
					content = content.replaceAll("name", param.getUserName());
					content = content.replaceAll("yuangong", param.getUname1());
					content = content.replaceAll("xing", param.getExaminePerson().substring(0,1));
					content = content.replaceAll("start", param.getEvectionStartTime());
					content = content.replaceAll("end", param.getEvectionEndTime());

					String jncard=param.getUserId();
					String officemail = queryDAO.executeForObject("findOfficEmail",jncard, String.class);
					String maillian = "@trans-cosmos.com.cn";
					String from = officemail + maillian;
					String subject="【系统邮件】【出差申请】";
					Mail.sendAll(from, "123456", sendTo, null, null, subject, content,null);
    	 }
      }
     if("1".equals(param.getFlag())){
       if("1002".equals(param.getUserId())){
	 int chaxuncount=queryDAO.executeForObject("JNTCIBusinessVerifycountDeleteChaxun",param,Integer.class);
	  if(chaxuncount!=0){
		  updateDAO.execute("JNTCIBusinessVerifycountDelete", param);
	  }
}

     if("A08".equals(param.getExamineStatus())){
    	 param.setExaminePerson("田東啓");
    	 String offic_mail=queryDAO.executeForObject("selectyouxiang1",param,String.class);
	     String address =offic_mail+ "@trans-cosmos.com.cn";
		 InternetAddress sendTo[] = new InternetAddress[1];
				try {
					sendTo[0]= new InternetAddress(address);
				} catch (AddressException e) {
					e.printStackTrace();
				}
				String content ="xingさん<br>お疲れ様です。nameです。<br><br> 因项目需求，yuangong申请出差。<br><br>时间：start至end<br><br>望批准。<br><br>以上です、よろしくお願い致します。";
				content = content.replaceAll("name", param.getUserName());
				content = content.replaceAll("xing", param.getExaminePerson().substring(0,1));
				content = content.replaceAll("start", param.getEvectionStartTime());
				content = content.replaceAll("end", param.getEvectionEndTime());
				content = content.replaceAll("yuangong", param.getUname1());
				String jncard=param.getUserId();
				String officemail = queryDAO.executeForObject("findOfficEmail",
						jncard, String.class);
				String maillian = "@trans-cosmos.com.cn";
				String from = officemail + maillian;
				String subject="【系统邮件】【批准】【出差申请】";
				Mail.sendAll(from, "123456", sendTo, null, null, subject, content,
						null);

     }
     if("A09".equals(param.getExamineStatus())){
    	 param.setExaminePerson(param.getUserName());
    	 String offic_mail=queryDAO.executeForObject("selectyouxiang2",param,String.class);
			String address =offic_mail+ "@trans-cosmos.com.cn";
				InternetAddress sendTo[] = new InternetAddress[1];
				try {
					sendTo[0]= new InternetAddress(address);
				} catch (AddressException e) {
					e.printStackTrace();
				}
				String content ="xingさん<br>お疲れ様です。nameです。<br><br> 出差申请不批准。<br><br>以上です、よろしくお願い致します。";
				content = content.replaceAll("name", param.getUserName());
				content = content.replaceAll("xing", param.getUname1().substring(0,1));
				String jncard=param.getUserId();
				String officemail = queryDAO.executeForObject("findOfficEmail",jncard, String.class);
				String maillian = "@trans-cosmos.com.cn";
				String from = officemail + maillian;
				String subject="【系统邮件】【不批准】【出差申请】";
				Mail.sendAll(from, "123456", sendTo, null, null, subject, content,null);

     }
     if("A06".equals(param.getExamineStatus())){
    	 param.setExaminePerson("田東啓");
    	  List<Date> holidaylist = queryDAO.executeForObjectList("holidaylist", null);
    	     String start = param.getEvectionStartTime();
    	     String end = param.getEvectionEndTime();
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
    	   //于琪?箱
     	    String yuqi =queryDAO.executeForObject("SearchyuqiEmail","1072" , java.lang.String.class);
     	    String yuqiEmail = yuqi+"@trans-cosmos.com.cn";
	        String offic_mail=queryDAO.executeForObject("selectyouxiang2",param,String.class);
			String address =offic_mail+ "@trans-cosmos.com.cn";
				InternetAddress sendTo[] = new InternetAddress[1];
				InternetAddress yuqis[]=new InternetAddress[1];
				try {
					yuqis[0] = new InternetAddress(yuqiEmail);
				} catch (AddressException e) {
					e.printStackTrace();
				}
				try {
					sendTo[0]= new InternetAddress(address);
				} catch (AddressException e) {
					e.printStackTrace();
				}
				String content ="xingさん<br>お疲れ様です。nameです。<br><br> 出差申请批准。<br><br>以上です、よろしくお願い致します。";
				content = content.replaceAll("name", param.getExaminePerson());
				content = content.replaceAll("xing", param.getUname1().substring(0,1));
				String jncard=param.getUserId();
				String officemail = queryDAO.executeForObject("findOfficEmail",jncard, String.class);
				String maillian = "@trans-cosmos.com.cn";
				String from = officemail + maillian;
				String subject="【系统邮件】【批准】【出差申请】";
				Mail.sendAll(from, "123456", sendTo, yuqis, null, subject, content,null);
     }
     if("A04".equals(param.getExamineStatus())){
    	 param.setExaminePerson("");
     }
      if ("A05".equals(param.getExamineStatus())){
    	  param.setExaminePerson("田東啓");
    	  String offic_mail=queryDAO.executeForObject("selectyouxiang2",param,String.class);
			String address =offic_mail+ "@trans-cosmos.com.cn";
				InternetAddress sendTo[] = new InternetAddress[1];
				try {
					sendTo[0]= new InternetAddress(address);
				} catch (AddressException e) {
					e.printStackTrace();
				}
				String content ="xingさん<br>お疲れ様です。nameです。<br><br> 申请不批准。<br><br>以上です、よろしくお願い致します。";
				content = content.replaceAll("name", param.getUserName());
				content = content.replaceAll("xing", param.getUname1().substring(0,1));
				String jncard=param.getUserId();
				String officemail = queryDAO.executeForObject("findOfficEmail",
						jncard, String.class);
				String maillian = "@trans-cosmos.com.cn";
				String from = officemail + maillian;
				String subject="【系统邮件】【未批准】【出差申请】";
				Mail.sendAll(from, "123456", sendTo, null, null, subject, content,
						null);

	/*	  updateDAO.execute("JNTCIBusinessVerifycountDelete", param);*/
 	  }
     }
		updateDAO.execute("JNTCIBusinessVerify02Update", param);
		result.setResultString("success");
	    List<JNTCIBusinessVerifyVo> JNTCIBusinessVerifyVoInfo = queryDAO.executeForObjectList("JNTCIBusinessVerifyVoInfo", null,startIndex, row);
	    String totalCount = queryDAO.executeForObject("JNTCIBusinessVerifyVoInfoCount", null, String.class);
	    List<JNTCIBusinessVerifyVo> examineList = queryDAO.executeForObjectList("examineStatus", null);
	    List<JNTCIBusinessVerifyVo> deptList = queryDAO.executeForObjectList("deptId", null);
			//審査者list
	    List<JNTCIAttendance03Dto> examinePersonList = queryDAO.executeForObjectList("examinePerson", null);

			    output.setJNTCIBusinessVerifyVoInfo(JNTCIBusinessVerifyVoInfo);
		        output.setTotalCount(totalCount);
		        output.setExamineList(examineList);
		        output.setDeptList(deptList);
		        output.setExaminePersonList(examinePersonList);

		output.setJNTCIBusinessVerifyVoInfo(JNTCIBusinessVerifyVoInfo);
		output.setUser_Id(param.getUser_Id());
		output.setUser_Name(param.getUser_Name());
		output.setExamineStatus(param.getExamineStatus());
		result.setResultObject(output);

		return result;
	}
	}
}
