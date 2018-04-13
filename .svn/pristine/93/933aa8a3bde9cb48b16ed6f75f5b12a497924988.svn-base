package jp.terasoluna.thin.tutorial.web.transcosmos.blogic;


import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

import jp.terasoluna.fw.dao.QueryDAO;
import jp.terasoluna.fw.service.thin.BLogic;
import jp.terasoluna.fw.service.thin.BLogicResult;
import jp.terasoluna.thin.tutorial.web.common.controller.Constant;
import jp.terasoluna.thin.tutorial.web.common.controller.JiaMi;
import jp.terasoluna.thin.tutorial.web.common.controller.Mail;
import jp.terasoluna.thin.tutorial.web.common.controller.Message;
import jp.terasoluna.thin.tutorial.web.transcosmos.dto.LoginInput;
import jp.terasoluna.thin.tutorial.web.transcosmos.dto.LoginOutput;

public class JNTCIGetPwdBLogic implements BLogic<LoginInput>{

	private QueryDAO queryDAO = null;
	public BLogicResult execute(LoginInput param) {

		BLogicResult result = new BLogicResult();

		int count = 0;
		try {
			count = queryDAO.executeForObject("getPwdCount", param , Integer.class);
			if(count != 1){
				result = Message.getMessage("message.getpassword", 0);
				return result;
			}
		} catch (Exception e) {
			result = Message.getMessage("message.getpassword", 0);
			return result;
		}

		LoginOutput sendinfo = null;
		try {
			sendinfo = queryDAO.executeForObject("getPwdinfo", param , LoginOutput.class);
		} catch (Exception e) {
			result = Message.getMessage("message.getpassword", 0);
			return result;
		}

		String sendTo = sendinfo.getSendTo() + "@trans-cosmos.com.cn";
		JiaMi jm=new JiaMi();
		String pwd=sendinfo.getPassword();
	    try {
			pwd=new String(jm.decrypt(pwd));
		} catch (Exception e) {
			e.printStackTrace();
		}
		String info = "您的内部管理システム登录密码是：" + pwd;


		InternetAddress[] address = new InternetAddress[1];

		try {
			address[0] = new InternetAddress(sendTo);// 这一句才是想要的
		} catch (AddressException e) {
			e.printStackTrace();
		}

		boolean sendflag = Mail.sendAll(sendTo, "123456", address, null, null,Constant.sendtitle , info, null);

        if(sendflag == false){
        	result = Message.getMessage1("message.failure", 0, "パスワードの送信");
			return result;
        }
		result = Message.getMessage1("message.success", 1, "パスワードの送信");
		return result;
	}
	public QueryDAO getQueryDAO() {
		return queryDAO;
	}
	public void setQueryDAO(QueryDAO queryDAO) {
		this.queryDAO = queryDAO;
	}


}
