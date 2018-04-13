package jp.terasoluna.thin.tutorial.web.transcosmos.blogic;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
import jp.terasoluna.thin.tutorial.web.transcosmos.dto.JNTCIOverTimeVerifyInput;
import jp.terasoluna.thin.tutorial.web.transcosmos.dto.JNTCIOverTimeVerifyResultInput;

public class JNTCIOverTimeVerifyAllowListBLogic implements
		BLogic<JNTCIOverTimeVerifyInput> {
	private UpdateDAO updateDAO = null;
	private QueryDAO queryDAO = null;

	public BLogicResult execute(JNTCIOverTimeVerifyInput param) {
		if(param.getUser_name2()!=null&&!"reset".equals(param.getCod())){
    		try {
    			param.setUser_name2(new String(param.getUser_name2().getBytes("ISO-8859-1"),"utf-8"));
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
		List<String> select_list=new ArrayList<String>();
		String[] selectlist=param.getSelectlist().trim().split(",");
		for (int i = 0; i < selectlist.length; i++) {
			if(selectlist[i].trim()==null||selectlist[i].trim().equals("")){
			}else{
				select_list.add(selectlist[i]);
			}
		}
		String news = "";
		for (int i = 0; i < select_list.size(); i++) {
			JNTCIOverTimeVerifyResultInput over_work;
			String extra_id =select_list.get(i);
			try {
				over_work = queryDAO.executeForObject("over_work_select",
						extra_id, JNTCIOverTimeVerifyResultInput.class);
			} catch (Exception e) {
				continue;
			}
			if ((over_work.getExtra_auditss().equals("A06")&&param.getExtra_auditss1().equals("A06"))||(over_work.getExtra_auditss().equals("A05")&&param.getExtra_auditss1().equals("A05"))) {
				continue;
			} else {
				over_work.setUserName(param.getUserName());
				over_work.setUserId(param.getUserId());
				over_work.setExtra_auditss(param.getExtra_auditss1());
			}
			Date Systime = new Date();
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
			String sfd = dateFormat.format(Systime);
			List<Date> holidaylist = queryDAO.executeForObjectList(
					"holidaylist", null);
			String start = sfd.substring(0, 8).concat("01");
			int ShenseiM = Integer.parseInt(over_work.getExtra_starttime()
					.substring(5, 7));
			int ShenseiY = Integer.parseInt(over_work.getExtra_starttime()
					.substring(0, 4));
			int SM = Integer.parseInt(sfd.substring(5, 7));
			int SY = Integer.parseInt(sfd.substring(0, 4));
			int dayCount = GetWorkDay.workDays(start, sfd, holidaylist);
			int ShenseiMNext;
			int ShenseiYNext;
			if (ShenseiM == 12) {
				ShenseiMNext = 1;
				ShenseiYNext = ShenseiY + 1;
			} else {
				ShenseiMNext = ShenseiM + 1;
				ShenseiYNext = ShenseiY;
			}
			if ((ShenseiM == SM && ShenseiY == SY)
					|| (dayCount < 4 && ShenseiMNext == SM && ShenseiYNext == SY)) {
				if ("A06".equals(over_work.getExtra_auditss())) {
					String offic_mail = queryDAO.executeForObject(
							"mailsearch", over_work, String.class);
					String address = offic_mail + "@trans-cosmos.com.cn";
					InternetAddress sendTo[] = new InternetAddress[1];
					try {
						sendTo[0] = new InternetAddress(address);
					} catch (AddressException e) {
						e.printStackTrace();
					}
					String content = "xingさん<br>お疲れ様です。nameです。<br><br> 加班申请批准。<br><br>以上です、よろしくお願い致します。";
					content = content.replaceAll("name", over_work.getUserName());
					content = content.replaceAll("xing", over_work.getUser_name()
							.substring(0, 1));
					String jncard = over_work.getUserId();
					String officemail = queryDAO.executeForObject(
							"findOfficEmail", jncard, String.class);
					String maillian = "@trans-cosmos.com.cn";
					String from = officemail + maillian;
					String subject = "加班申请批准";
					Mail.sendAll(from, "123456", sendTo, null, null, subject,
							content, null);
				}else if("A05".equals(over_work.getExtra_auditss())){
					String offic_mail = queryDAO.executeForObject(
							"mailsearch", over_work, String.class);
					String address = offic_mail + "@trans-cosmos.com.cn";
					InternetAddress sendTo[] = new InternetAddress[1];
					try {
						sendTo[0] = new InternetAddress(address);
					} catch (AddressException e) {
						e.printStackTrace();
					}
					String content = "xingさん<br>お疲れ様です。nameです。<br><br> 加班申请未批准。<br><br>以上です、よろしくお願い致します。";
					content = content.replaceAll("name",
							over_work.getUserName());
					content = content.replaceAll("xing", over_work
							.getUser_name().substring(0, 1));
					String jncard = over_work.getUserId();
					String officemail = queryDAO.executeForObject(
							"findOfficEmail", jncard, String.class);
					String maillian = "@trans-cosmos.com.cn";
					String from = officemail + maillian;
					String subject = "加班申请未批准";
					Mail.sendAll(from, "123456", sendTo, null, null,
							subject, content, null);
				}
					updateDAO.execute("resultupdate", over_work);
			}else{
				news="残業カード:"+over_work.getExtra_id()+" 社員カード:"+over_work.getUser_id()+"  社員名前:"+over_work.getUser_name()+"<br/>"+news;
			}
		}
		JNTCIOverTimeVerifyInput output = new  JNTCIOverTimeVerifyInput();
		output.setSelectlist(param.getSelectlist());
		output.setStartIndex(param.getStartIndex());
		output.setUser_name2(param.getUser_name2());
		output.setRow(param.getRow());
		output.setCod(param.getCod());
		output.setUser_id(param.getUser_id());
		output.setUser_id2(param.getUser_id2());
		output.setExtra_auditss(param.getExtra_auditss());
		output.setExaminePerson(param.getExaminePerson());
		output.setExtra_starttime1(param.getExtra_starttime1());
		output.setExtra_endtime1(param.getExtra_endtime1());
		output.setExtra_auditss_search(param.getExtra_auditss_search());
		BLogicResult result = new BLogicResult();
		if(news==null||"".equalsIgnoreCase(news)){}else{
			BLogicMessages messages = new BLogicMessages();
			messages.add("message", new BLogicMessage(
					"errors.attendance05.timeOut1",news));
			result.setErrors(messages);
		}
		result.setResultObject(output);
		result.setResultString("success2");
		return result;
	}
	public UpdateDAO getUpdateDAO() {
		return updateDAO;
	}

	public void setUpdateDAO(UpdateDAO updateDAO) {
		this.updateDAO = updateDAO;
	}

	public QueryDAO getQueryDAO() {
		return queryDAO;
	}

	public void setQueryDAO(QueryDAO queryDAO) {
		this.queryDAO = queryDAO;
	}

}
