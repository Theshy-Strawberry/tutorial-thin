package jp.terasoluna.thin.tutorial.web.transcosmos.blogic;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

import jp.terasoluna.fw.dao.QueryDAO;
import jp.terasoluna.fw.dao.UpdateDAO;
import jp.terasoluna.fw.service.thin.BLogic;
import jp.terasoluna.fw.service.thin.BLogicMessage;
import jp.terasoluna.fw.service.thin.BLogicMessages;
import jp.terasoluna.fw.service.thin.BLogicResult;
import jp.terasoluna.thin.tutorial.web.common.controller.Mail;
import jp.terasoluna.thin.tutorial.web.transcosmos.dto.JNTCIEquip01Input;

public class JNTCIEquip01BLogic implements BLogic<JNTCIEquip01Input>{

	private QueryDAO queryDAO = null;
	private UpdateDAO updateDAO = null;

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

	public BLogicResult execute(JNTCIEquip01Input param){

		BLogicResult result = new BLogicResult();
		BLogicMessages messages = new BLogicMessages();
		try{
		String shinsaMaxNo  = queryDAO.executeForObject("getShinsaMaxNo",
				null, String.class);
		String shinseiMaxNo = queryDAO.executeForObject("getShinseiMaxNo",
				null, String.class);
		if(shinseiMaxNo == null){
			param.setShinseiNo("1");
		}else{
			param.setShinseiNo(shinseiMaxNo);
		}
		if(shinsaMaxNo == null){
			param.setShinsaNo("1");
		}else{
		    param.setShinsaNo(shinsaMaxNo);
		}

		updateDAO.execute("insertShinsaMaxNo", param);
		updateDAO.execute("JNTCIEquip01", param);
		 if (param.getToId() != null) {
				String toId = param.getToId();
				if (param.getToId().contains(";")) {

					String toIdstr1[] = toId.split(";");
					InternetAddress sendTo[] = new InternetAddress[toIdstr1.length];
					String subject = param.getSubject();
					String content = param.getReason();
					for (int i = 0; i < toIdstr1.length; i++) {
						try {
							sendTo[i] = new InternetAddress(toIdstr1[i]);
							/*String a =toIdstr1[i];
							String b=null;*/
							String jncard = param.getUserId();
							String officemail = queryDAO.executeForObject("findOfficEmail",
									jncard, String.class);
							String maillian = "@trans-cosmos.com.cn";
							String from = officemail + maillian;
							Mail.sendAll(from, "123456", sendTo, null, null, subject, content,
									null);
						} catch (AddressException e) {
							e.printStackTrace();
						}
					}
				} else {
					String address = param.getToId();
					InternetAddress sendTo[] = new InternetAddress[1];
					try {
						sendTo[0] = new InternetAddress(address);
					} catch (AddressException e) {
						e.printStackTrace();
					}
					String subject = param.getSubject();
					String content = param.getReason();
					String jncard = param.getUserId();
					String officemail = queryDAO.executeForObject("findOfficEmail",
							jncard, String.class);
					String maillian = "@trans-cosmos.com.cn";
					String from = officemail + maillian;
					Mail.sendAll(from, "123456", sendTo, null, null, subject, content,
							null);
				}
			}
		}
		catch(Exception e){
			messages.add("message", new BLogicMessage("message.insert.failure"	));
			result.setErrors(messages);
			result.setResultString("failure");
			return result;
		}
		messages.add("message",new BLogicMessage("message.insert.success"));
		result.setMessages(messages);
		result.setResultString("success");

		return result;
	}
}
