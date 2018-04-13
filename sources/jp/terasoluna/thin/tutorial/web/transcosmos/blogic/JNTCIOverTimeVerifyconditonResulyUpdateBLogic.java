package jp.terasoluna.thin.tutorial.web.transcosmos.blogic;

import java.text.ParseException;
import java.text.SimpleDateFormat;
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
import jp.terasoluna.thin.tutorial.web.transcosmos.dto.JNTCIOverTimeVerifyResultInput;

public class JNTCIOverTimeVerifyconditonResulyUpdateBLogic implements
		BLogic<JNTCIOverTimeVerifyResultInput> {

	private UpdateDAO updateDAO = null;
	private QueryDAO queryDAO = null;

	public void setUpdateDAO(UpdateDAO updateDAO) {
		this.updateDAO = updateDAO;
	}

	public UpdateDAO getUpdateDAO() {
		return updateDAO;
	}

	public QueryDAO getQueryDAO() {
		return queryDAO;
	}

	public void setQueryDAO(QueryDAO queryDAO) {
		this.queryDAO = queryDAO;
	}

	public BLogicResult execute(JNTCIOverTimeVerifyResultInput param) {
		if(param.getExtra_auditss().equals("back")){
			BLogicResult result = new BLogicResult();
			JNTCIOverTimeVerifyResultInput output = new  JNTCIOverTimeVerifyResultInput();
			output.setStartIndex(param.getStartIndex());
			output .setDept_id2(param.getDept_id2());
			output .setExtra_auditss_search(param.getExtra_auditss_search());
			output .setExtra_starttime1(param.getExtra_starttime1());
			output .setExtra_endtime1(param.getExtra_endtime1());
			output .setUser_id2(param.getUser_id2());
			output .setUser_name2(param.getUser_name2());
			result.setResultObject(output);
			result.setResultString("success2");
			return result;
		}else{
			  Date Systime = new Date();
	            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");//蜿ｯ莉･譁ｹ萓ｿ蝨ｰ菫ｮ謾ｹ譌･譛滓?蠑?
	            String sfd = dateFormat.format( Systime );
	            List<Date> holidaylist = queryDAO.executeForObjectList("holidaylist", null);
	            String start=sfd.substring(0,8).concat("01");
	            int ShenseiM=Integer.parseInt(param.getExtra_starttime().substring(5, 7));
	            int ShenseiY=Integer.parseInt(param.getExtra_starttime().substring(0, 4));
	            int SM=Integer.parseInt(sfd.substring(5, 7));
	            int SY=Integer.parseInt(sfd.substring(0, 4));
	            int dayCount = GetWorkDay.workDays(start,sfd,holidaylist);
	            int ShenseiMNext;
	            int ShenseiYNext;
	            if(ShenseiM==12){
	                   ShenseiMNext=1;
	                   ShenseiYNext=ShenseiY+1;
	            }
	            else {
	                   ShenseiMNext=ShenseiM+1;
	                   ShenseiYNext=ShenseiY;
	            }
		if((ShenseiM==SM&&ShenseiY==SY)||(dayCount<4&&ShenseiMNext==SM&&ShenseiYNext==SY)){
				if ("A06".equals(param.getExtra_auditss())) {

		     	    String daiyuzhen =queryDAO.executeForObject("SearchdaiyuzhenEmail","1070" , java.lang.String.class);
		     	    String daiyuzhenEmail = daiyuzhen+"@trans-cosmos.com.cn";
						String offic_mail = queryDAO.executeForObject(
								"chaxunyouxiang2", param, String.class);
						String address = offic_mail + "@trans-cosmos.com.cn";
						InternetAddress sendTo[] = new InternetAddress[1];
						InternetAddress daiyuzhens[]=new InternetAddress[1];
						try {
							daiyuzhens[0] = new InternetAddress(daiyuzhenEmail);
						} catch (AddressException e) {
							e.printStackTrace();
						}
						try {
							sendTo[0] = new InternetAddress(address);
						} catch (AddressException e) {
							e.printStackTrace();
						}
						String content = "xingさん<br>お疲れ様です。nameです。<br><br> 加班申请批准。<br><br>以上です、よろしくお願い致します。";
						content = content.replaceAll("name",
								param.getUserName());
						content = content.replaceAll("xing", param
								.getUser_name().substring(0, 1));
						String jncard = param.getUserId();
						String officemail = queryDAO.executeForObject(
								"findOfficEmail", jncard, String.class);
						String maillian = "@trans-cosmos.com.cn";
						String from = officemail + maillian;
						String subject = "【系统邮件】【批准】【加班申请】";
						Mail.sendAll(from, "123456", sendTo,daiyuzhens, null,
								subject, content, null);
					}else if("A05".equals(param.getExtra_auditss())){
						String offic_mail = queryDAO.executeForObject(
								"chaxunyouxiang2", param, String.class);
						String address = offic_mail + "@trans-cosmos.com.cn";
						InternetAddress sendTo[] = new InternetAddress[1];
						try {
							sendTo[0] = new InternetAddress(address);
						} catch (AddressException e) {
							e.printStackTrace();
						}
						String content = "xingさん<br>お疲れ様です。nameです。<br><br> 加班申请未批准。<br><br>以上です、よろしくお願い致します。";
						content = content.replaceAll("name",
								param.getUserName());
						content = content.replaceAll("xing", param
								.getUser_name().substring(0, 1));
						String jncard = param.getUserId();
						String officemail = queryDAO.executeForObject(
								"findOfficEmail", jncard, String.class);
						String maillian = "@trans-cosmos.com.cn";
						String from = officemail + maillian;
						String subject = "【系统邮件】【未批准】【加班申请】";
						Mail.sendAll(from, "123456", sendTo, null, null,
								subject, content, null);
					}else{

					}
				BLogicResult result = new BLogicResult();
				updateDAO.execute("resultupdate", param);
				JNTCIOverTimeVerifyResultInput output = new  JNTCIOverTimeVerifyResultInput();
				output.setStartIndex(param.getStartIndex());
				output .setDept_id2(param.getDept_id2());
				output .setExtra_auditss_search(param.getExtra_auditss_search());
				output .setExtra_starttime1(param.getExtra_starttime1());
				output .setExtra_endtime1(param.getExtra_endtime1());
				output .setUser_id2(param.getUser_id2());
				output .setUser_name2(param.getUser_name2());
				result.setResultObject(output);
				result.setResultString("success2");
				return result;
	     }else{
	    	 BLogicResult result = new BLogicResult();
             BLogicMessages messages = new BLogicMessages();
             messages.add("message", new BLogicMessage(
                                  "errors.attendance05.timeOut"));
          result.setErrors(messages);
         	JNTCIOverTimeVerifyResultInput output = new  JNTCIOverTimeVerifyResultInput();
			output.setStartIndex(param.getStartIndex());
			output .setDept_id2(param.getDept_id2());
			output .setExtra_auditss_search(param.getExtra_auditss_search());
			output .setExtra_starttime1(param.getExtra_starttime1());
			output .setExtra_endtime1(param.getExtra_endtime1());
			output .setUser_id2(param.getUser_id2());
			output .setUser_name2(param.getUser_name2());
			result.setResultObject(output);
          result.setResultString("success1");
         	return result;
        }
	}


 }
}





