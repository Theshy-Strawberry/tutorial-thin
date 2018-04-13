package jp.terasoluna.thin.tutorial.web.transcosmos.blogic;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

import jp.terasoluna.fw.dao.QueryDAO;
import jp.terasoluna.fw.dao.UpdateDAO;
import jp.terasoluna.fw.service.thin.BLogic;
import jp.terasoluna.fw.service.thin.BLogicMessage;
import jp.terasoluna.fw.service.thin.BLogicMessages;
import jp.terasoluna.fw.service.thin.BLogicResult;
import jp.terasoluna.thin.tutorial.web.common.controller.Mail;
import jp.terasoluna.thin.tutorial.web.transcosmos.dto.JNTCIEquip03ListInput;
import jp.terasoluna.thin.tutorial.web.transcosmos.dto.JNTCIEquip03ListOutput;

public class JNTCIEquip0302BLogic implements BLogic<JNTCIEquip03ListInput> {
	private UpdateDAO updateDAO = null;
	BLogicResult result = new BLogicResult();
	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");// 设置日期格式
	String time = (df.format(new Date()));// new Date()为获取当前系统时间
	private QueryDAO queryDAO = null;

	public QueryDAO getQueryDAO() {
		return queryDAO;
	}

	public void setQueryDAO(QueryDAO queryDAO) {
		this.queryDAO = queryDAO;
	}

	public UpdateDAO getUpdateDAO() {
		return updateDAO;
	}

	public void setUpdateDAO(UpdateDAO updateDAO) {
		this.updateDAO = updateDAO;
	}

	public BLogicResult execute(JNTCIEquip03ListInput param) {

		if(param.getButtonKubun().equals("back")){
			BLogicResult result = new BLogicResult();
			JNTCIEquip03ListOutput output = new JNTCIEquip03ListOutput();
	        //検索条件の保持

			output.setUserId1(param.getUserId1());
			output.setDeptName(param.getDeptName());
			output.setShinsaJyoutai(param.getShinsaJyoutai());
			output.setShinseiStartDate(param.getShinseiStartDate());
			output.setShinseiEndDate(param.getShinseiEndDate());

			output.setStartIndex(param.getStartIndex());


			result.setResultObject(output);
			result.setResultString("back");
			return result;
		}
		int CF=queryDAO.executeForObject("JNTCIEquip04ChangeStateCount1",
				param,Integer.class);
		if((CF==0)||(CF==3)){
		if ("1".equals(param.getHidden_state())) {

			param.setApply_no(param.getApply_no().trim());
			param.setXttime(time);
			param.setHoyusha("倉庫");
			updateDAO.execute("getEquipapply0302", param);
			updateDAO.execute("getEquipapply03023", param);
			updateDAO.execute("getEquipapply03022", param);
			String offic_mail = queryDAO.executeForObject("sendmailperson",
					param, String.class);
			String address = offic_mail + "@trans-cosmos.com.cn";
			InternetAddress sendTo[] = new InternetAddress[1];
			try {
				sendTo[0] = new InternetAddress(address);
			} catch (AddressException e) {
				e.printStackTrace();
			}
			String content = "nameさん<br>お疲れ様です。 <br><br>設備申請失败。<br><br>result.<br><br>以上。";
			content = content.replaceAll("name", param.getApply_user_name()
					.substring(0, 1));
			content = content.replaceAll("result",
					param.getInvestigate_reason());
			String jncard = param.getUserId();

			String officemail = queryDAO.executeForObject("findOfficEmail",
					jncard, String.class);
			String maillian = "@trans-cosmos.com.cn";
			String from = officemail + maillian;
			String subject = "【系统邮件】【未批准】【設備申請】";
			Mail.sendAll(from, "123456", sendTo, null, null, subject, content,
					null);

			BLogicMessages messages = new BLogicMessages();
			messages.add("message", new BLogicMessage("JNTCIEquip.shenqingjujue"
				));
			result.setMessages(messages);

			JNTCIEquip03ListOutput output = new JNTCIEquip03ListOutput();
			result.setResultObject(output);
			result.setResultString("back");

		} else {
			param.setApply_no(param.getApply_no().trim());
			param.setXttime(time);
			param.setHoyusha(param.getApply_user_name());
			updateDAO.execute("getEquipapply0303", param);
			updateDAO.execute("getEquipapply03031", param);
			updateDAO.execute("getEquipapply03032", param);

			String offic_mail = queryDAO.executeForObject("sendmailperson",
					param, String.class);

			String address = offic_mail + "@trans-cosmos.com.cn";
			InternetAddress sendTo[] = new InternetAddress[1];
			try {
				sendTo[0] = new InternetAddress(address);
			} catch (AddressException e) {
				e.printStackTrace();
			}
			String content = "nameさん<br>お疲れ様です。<br><br>設備申請成功。<br><br>result .<br><br>以上。";
			content = content.replaceAll("name", param.getApply_user_name()
					.substring(0, 1));
			content = content.replaceAll("result",
					param.getInvestigate_reason());
			String jncard = param.getUserId();

			String officemail = queryDAO.executeForObject("findOfficEmail",
					jncard, String.class);
			String maillian = "@trans-cosmos.com.cn";
			String from = officemail + maillian;
			String subject = "【系统邮件】【批准】【設備申請】";
			Mail.sendAll(from, "123456", sendTo, null, null, subject, content,
					null);


			BLogicMessages messages = new BLogicMessages();
			messages.add("message", new BLogicMessage("JNTCIEquip.shenqingchenggong"
				));
			result.setMessages(messages);

			JNTCIEquip03ListOutput output = new JNTCIEquip03ListOutput();
			result.setResultObject(output);
			result.setResultString("back");
		}



		return result;

	}else{
		result.setResultString("cuowu");
		return result;
	}

}
}
