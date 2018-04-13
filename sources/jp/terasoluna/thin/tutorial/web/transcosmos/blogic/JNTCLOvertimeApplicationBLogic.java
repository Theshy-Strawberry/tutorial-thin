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
import jp.terasoluna.thin.tutorial.web.transcosmos.dto.JNTCLOvertimeApplicationInput;
import jp.terasoluna.thin.tutorial.web.transcosmos.dto.JNTCLOvertimeApplicationOutput;

public class JNTCLOvertimeApplicationBLogic implements BLogic<JNTCLOvertimeApplicationInput>{
	private UpdateDAO updateDAO = null;
	private QueryDAO queryDAO = null;
	public QueryDAO getQueryDAO() {
		return queryDAO;
	}

	public void setQueryDAO(QueryDAO queryDAO) {
		this.queryDAO = queryDAO;
	}

	public BLogicResult execute(JNTCLOvertimeApplicationInput param) {
		BLogicResult result = new BLogicResult();
		result.setResultString("success");
		String checkDate = queryDAO.executeForObject("equalsDate", param, String.class);
		if(checkDate != null){
			BLogicMessages messages = new BLogicMessages();
			messages.add("message", new BLogicMessage(
					"errors.leaveTimeFrame.error"));
			result.setErrors(messages);
			return result;
		}
		param.getEvectionStartTime();
		param.getEvectionEndTime();
		String checkTime = queryDAO.executeForObject("equalsTime", param, String.class);
		if(checkTime != null){
			BLogicMessages messages = new BLogicMessages();
			messages.add("message", new BLogicMessage(
					"errors.leaveEvection.error"));
			result.setErrors(messages);
			return result;
		}
		//只能在下个月三个工作日之前之前补
        Date Systime = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");//可以方便地修改日期格式
        String sfd = dateFormat.format( Systime );
        List<Date> holidaylist = queryDAO.executeForObjectList("holidaylist", null);
        String start=sfd.substring(0,8).concat("01");

        //申请年月
        int ShenseiM=Integer.parseInt(param.getExtra_starttime().substring(5, 7));
        int ShenseiY=Integer.parseInt(param.getExtra_starttime().substring(0, 4));
        //系统年月
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


		String ID = param.getUser_id();

		JNTCLOvertimeApplicationInput applicationInput = queryDAO.executeForObject("selectUser",ID, JNTCLOvertimeApplicationInput.class);
		param.setUser_name(applicationInput.getUser_name());
		param.setProject_PM(applicationInput.getProject_PM());
		String flag=applicationInput.getFlag();
		/*String project_id = applicationInput.getProject();*/
		/*String project_Name = queryDAO.executeForObject("selectProject_Name",project_id, String.class);
*/
		/*param.setProject(project_Name);*/
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");//隶ｾ鄂ｮ譌･譛滓�蠑�
		Date date=null;
		try {
			date = df.parse(df.format(new Date()));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		param.setCre_datetm(date);
		String extra_id = queryDAO.executeForObject("primarykey",1,String.class);
		if(extra_id==null){
			extra_id="0";
		}
		int newsextra_id = Integer.parseInt(extra_id);
		newsextra_id=newsextra_id+1;
		if(newsextra_id<10){
				extra_id="W0000000"+newsextra_id;
		}else if(newsextra_id<=99&&newsextra_id>9){
			extra_id="W000000"+newsextra_id;
		}else if(newsextra_id<=999&&newsextra_id>99){
			extra_id="W00000"+newsextra_id;
		}else if(newsextra_id<=9999&&newsextra_id>999){
			extra_id="W0000"+newsextra_id;
		}else if(newsextra_id<=99999&&newsextra_id>9999){
			extra_id="W000"+newsextra_id;
		}else if(newsextra_id<=999999&&newsextra_id>99999){
			extra_id="W00"+newsextra_id;
		}else if(newsextra_id<=9999999&&newsextra_id>999999){
			extra_id="W0"+newsextra_id;
		}else if(newsextra_id<=99999999&&newsextra_id>9999999){
			extra_id="W"+newsextra_id;
		}
		 String offic_mail=queryDAO.executeForObject("chaxunyouxiang",param,String.class);
			String address =offic_mail+ "@trans-cosmos.com.cn";
				InternetAddress sendTo[] = new InternetAddress[1];
				try {
					sendTo[0]= new InternetAddress(address);
				} catch (AddressException e) {
					e.printStackTrace();
				}
				//代玉珍邮箱号
				String daiyuzhen =queryDAO.executeForObject("SearchdaiyuzhenEmail","1070" , java.lang.String.class);
				//代玉珍邮箱
				String daiyuzhenEmail = daiyuzhen + "@trans-cosmos.com.cn";
				String content ="xingさん<br>お疲れ様です。nameです。<br><br>因项目需求，申请加班<br><br>时间：start至end<br><br>以上です、よろしくお願い致します。";
				content = content.replaceAll("name", param.getUser_name());
				content = content.replaceAll("xing", param.getProject_PM().substring(0,1));
				content = content.replaceAll("start", param.getExtra_starttime());
					content = content.replaceAll("end", param.getExtra_endtime());
				String jncard=param.getUser_id();
				String officemail = queryDAO.executeForObject("findOfficEmail",
						jncard, String.class);
				String maillian = "@trans-cosmos.com.cn";
				String from = officemail + maillian;
				String subject="【系统邮件】【加班申请】";
				InternetAddress[] daiyuzhenMail = new InternetAddress[1];
				try {
					daiyuzhenMail[0] = new InternetAddress(daiyuzhenEmail);
				} catch (AddressException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}
				Mail.sendAll(from, "123456", sendTo, daiyuzhenMail, null, subject, content,
						null);

		String in_month=param.getExtra_starttime().substring(5, 7);
		param.setIn_month(in_month);
		param.setExtra_id(extra_id);
		JNTCLOvertimeApplicationOutput output= new JNTCLOvertimeApplicationOutput();
		output.setExtra_type(param.getExtra_type());
		output.setExtra_reason(param.getExtra_reason());
		output.setProject_PM(applicationInput.getProject_PM());
		updateDAO.execute("insertExtraRecord", param);
		BLogicMessages messages = new BLogicMessages();
		messages.add("message",new BLogicMessage("message.attendance05.insert", param.getUser_id()));
		result.setMessages(messages);
        result.setResultObject(output);
		return result;
        }
        else{
               BLogicMessages messages = new BLogicMessages();
               messages.add("message", new BLogicMessage(
                                    "errors.attendance05.timeOut"));
               result.setErrors(messages);
               return result;

}
	}


	public UpdateDAO getUpdateDAO() {
		return updateDAO;
	}

	public void setUpdateDAO(UpdateDAO updateDAO) {
		this.updateDAO = updateDAO;
	}

}
