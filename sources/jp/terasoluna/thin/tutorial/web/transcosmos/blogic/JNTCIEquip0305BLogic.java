package jp.terasoluna.thin.tutorial.web.transcosmos.blogic;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

import jp.terasoluna.fw.dao.QueryDAO;
import jp.terasoluna.fw.dao.UpdateDAO;
import jp.terasoluna.fw.service.thin.BLogic;
import jp.terasoluna.fw.service.thin.BLogicResult;
import jp.terasoluna.thin.tutorial.web.common.controller.Mail;
import jp.terasoluna.thin.tutorial.web.transcosmos.dto.JNTCIEquip03ListInput;
import jp.terasoluna.thin.tutorial.web.transcosmos.dto.JNTCIEquip03ListOutput;

public class JNTCIEquip0305BLogic implements BLogic<JNTCIEquip03ListInput> {
	private UpdateDAO updateDAO = null;
	private QueryDAO queryDAO = null;

	public QueryDAO getQueryDAO() {
		return queryDAO;
	}

	public void setQueryDAO(QueryDAO queryDAO) {
		this.queryDAO = queryDAO;
	}

	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");// 设置日期格式
	String time = (df.format(new Date()));// new Date()为获取当前系统时间

	public UpdateDAO getUpdateDAO() {
		return updateDAO;
	}

	public void setUpdateDAO(UpdateDAO updateDAO) {
		this.updateDAO = updateDAO;
	}

	public BLogicResult execute(JNTCIEquip03ListInput param) {
		param.setApply_no(param.getApply_no().trim());
		param.setXttime(time);
		int CF=queryDAO.executeForObject("JNTCIEquip04ChangeStateCount1",
				param,Integer.class);
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
		if((CF==0)||(CF==3)){
		if ("0".equals(param.getHidden_state())) {
			updateDAO.execute("updateEquipapplyReturn03051", param);
			updateDAO.execute("updateEquipapplyReturn0305", param);
			updateDAO.execute("updateEquipapplyReturn03053", param);
			String offic_mail = queryDAO.executeForObject("sendmailperson",
					param, String.class);
			String address = offic_mail + "@trans-cosmos.com.cn";
			InternetAddress sendTo[] = new InternetAddress[1];
			try {
				sendTo[0] = new InternetAddress(address);
			} catch (AddressException e) {
				e.printStackTrace();
			}
			String content = "nameさん<br>お疲れ様です。<br><br>返还成功 .<br><br>以上。";
			content = content.replaceAll("name", param.getApply_user_name()
					.substring(0, 1));
			String jncard = param.getUserId();

			String officemail = queryDAO.executeForObject("findOfficEmail",
					jncard, String.class);
			String maillian = "@trans-cosmos.com.cn";
			String from = officemail + maillian;
			String subject = "【系统邮件】【批准】【設備返還】";
			Mail.sendAll(from, "123456", sendTo, null, null, subject, content,
					null);
			BLogicResult result = new BLogicResult();
			result.setResultString("continue");
			return result;
		} else {

			updateDAO.execute("updateEquipapplyReturn03052", param);
			updateDAO.execute("updateEquipapplyReturn03055", param);
			updateDAO.execute("updateEquipapplyReturn03054", param);
			String offic_mail = queryDAO.executeForObject("sendmailperson",
					param, String.class);
			String address = offic_mail + "@trans-cosmos.com.cn";
			InternetAddress sendTo[] = new InternetAddress[1];
			try {
				sendTo[0] = new InternetAddress(address);
			} catch (AddressException e) {
				e.printStackTrace();
			}
			String content = "nameさん<br>お疲れ様です。<br><br>设备返还失败.<br><br>以上。";
			content = content.replaceAll("name", param.getApply_user_name()
					.substring(0, 1));
			String jncard = param.getUserId();

			String officemail = queryDAO.executeForObject("findOfficEmail",
					jncard, String.class);
			String maillian = "@trans-cosmos.com.cn";
			String from = officemail + maillian;
			String subject = "【系统邮件】【未批准】【設備返還】";
			Mail.sendAll(from, "123456", sendTo, null, null, subject, content,
					null);
			BLogicResult result = new BLogicResult();

			result.setResultString("success");

			return result;
		}

	}else{

		BLogicResult result = new BLogicResult();
		result.setResultString("cuowu");
		return result;
	}

}
}