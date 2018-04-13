package jp.terasoluna.thin.tutorial.web.transcosmos.blogic;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import jp.terasoluna.fw.dao.QueryDAO;
import jp.terasoluna.fw.dao.UpdateDAO;
import jp.terasoluna.fw.service.thin.BLogic;
import jp.terasoluna.fw.service.thin.BLogicMessage;
import jp.terasoluna.fw.service.thin.BLogicMessages;
import jp.terasoluna.fw.service.thin.BLogicResult;
import jp.terasoluna.thin.tutorial.web.common.controller.Mail;
import jp.terasoluna.thin.tutorial.web.transcosmos.dto.JNTCIEquip02Input;
import jp.terasoluna.thin.tutorial.web.transcosmos.dto.JNTCIEquip02Output;
import jp.terasoluna.thin.tutorial.web.transcosmos.vo.JNTCIEquip02equip;

public class JNTCIEquip02BLogic implements BLogic<JNTCIEquip02Input> {
	// 接收equip02里的数据
	private QueryDAO queryDAO = null;// 对象用来查询
	private UpdateDAO updateDAO = null;// 对象用来更新

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

	/*
	 * (�� Javadoc)
	 *
	 * @see jp.terasoluna.fw.service.thin.BLogic#execute(java.lang.Object)
	 */
	public BLogicResult execute(JNTCIEquip02Input param) {
		TimeZone.setDefault(TimeZone.getTimeZone("GMT+8"));
		Date now = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat(
				"yyyy/MM/dd HH:mm:ss");// �ݒ�f�[�t�H���gTime zone
		String time = dateFormat.format(now);
		param.setTOROKU_TIMESTAMP(time);// 登录时间
		param.setKoshinTimestamp(time);// 更新时间
		String code = param.getCode();
		String a = param.getYichang();
		/*
		 * String
		 * admin=queryDAO.executeForObject("adminmailperson",param,String.
		 * class);
		 */
		String ShinsaNo = queryDAO.executeForObject("EquipShinsaNo", param,
				String.class);
		String ApplyNo = queryDAO.executeForObject("EquipApplyNo", param,
				String.class);
		/* param.setAdmin(admin); */
		if ((ShinsaNo == null)) {
			param.setShinsaNo("1");
		} else {
			param.setShinsaNo(ShinsaNo);
		}
		if (ApplyNo == null) {
			param.setShinseiNo("1");
		} else {
			param.setShinseiNo(ApplyNo);
		}
		if ("9".equals(a)) {
			String nil = "88";
			BLogicResult result = new BLogicResult();
			JNTCIEquip02Output output = new JNTCIEquip02Output();
			List<JNTCIEquip02equip> jNTCIEquip02equip = queryDAO
					.executeForObjectList("getEquipapplynumber2", param);
			output.setEquipList(jNTCIEquip02equip);
			String d = queryDAO.executeForObject(
					"JNTCIEquip02ChangeStateCountmn", param, String.class);
			output.setDeptName(d);
			output.setTime1(param.getTime1());
			output.setEquip(param.getEquip());
			output.setReason(param.getReason());
			output.setNil(nil);
			result.setResultObject(output);
			result.setResultString("success");
			return result;
		}
		if ("0".equals(code))// 当申请设备时
		{
			if ("1".equals(a)) {
				param.setKoshinPGM("2");
				updateDAO.execute("insertEquipRequireJNTCIEquip02", param);
				updateDAO.execute("insertEquipShinsaNo", param);
				String offic_mail = queryDAO.executeForObject("mailperson",
						param, String.class);
				String address = offic_mail + "@trans-cosmos.com.cn";
				InternetAddress sendTo[] = new InternetAddress[1];
				try {
					sendTo[0] = new InternetAddress(address);
				} catch (AddressException e) {
					e.printStackTrace();
				}
				param.setMail(offic_mail);
				String admin = queryDAO.executeForObject("adminmailperson",
						param, String.class);
				param.setAdmin(admin);
				String content = "adminさん<br>お疲れ様です。<br>私はnameです。<br><br>reason .<br><br>以上です、よろしくお願い致します。";
				content = content.replaceAll("name", param.getName());
				content = content.replaceAll("reason", param.getReason());
				content = content.replaceAll("admin", param.getAdmin()
						.substring(0, 1));
				String jncard = param.getId();

				String officemail = queryDAO.executeForObject("findOfficEmail",
						jncard, String.class);
				String maillian = "@trans-cosmos.com.cn";
				String from = officemail + maillian;
				String subject = "【系统邮件】【設備申請】";
				Mail.sendAll(from, "123456", sendTo, null, null, subject,
						content, null);
			} else {
			}
		} else if ("1".equals(code)) {

			param.setB(param.getEquip());
			int CSSS = queryDAO.executeForObject(
					"JNTCIEquip02ChangeStateCount3", param, Integer.class);// 修理中不能再次申请修理
			int CSSSS = queryDAO.executeForObject(
					"JNTCIEquip02ChangeStateCount33", param, Integer.class);// 返还中不能申请修理
			if ("1".equals(a)) {
				// 表单验证
				if ((CSSS == 0) && (CSSSS == 0)) {
					param.setKoshinPGM("3");
					updateDAO.execute("JNTCIEquip04insert", param);
					updateDAO.execute("insertEquipShinsaNo", null);

					String offic_mail = queryDAO.executeForObject("mailperson",
							param, String.class);
					String address = offic_mail + "@trans-cosmos.com.cn";
					InternetAddress sendTo[] = new InternetAddress[1];
					try {
						sendTo[0] = new InternetAddress(address);
					} catch (AddressException e) {
						e.printStackTrace();
					}
					param.setMail(offic_mail);
					String admin = queryDAO.executeForObject("adminmailperson",
							param, String.class);
					param.setAdmin(admin);
					String content = "adminさん<br>お疲れ様です。<br>私はnameです。<br><br>reason .<br><br>以上です、よろしくお願い致します。";
					content = content.replaceAll("name", param.getName());
					content = content.replaceAll("reason", param.getReason());
					content = content.replaceAll("admin", param.getAdmin()
							.substring(0, 1));
					String jncard = param.getId();

					String officemail = queryDAO.executeForObject(
							"findOfficEmail", jncard, String.class);
					String maillian = "@trans-cosmos.com.cn";
					String from = officemail + maillian;
					String subject = "【系统邮件】【設備修理申請】";
					Mail.sendAll(from, "123456", sendTo, null, null, subject,
							content, null);
				} else {
					if (!(CSSS == 0) || !(CSSSS == 0)) {
						BLogicResult result = new BLogicResult();
						String d = queryDAO.executeForObject(
								"JNTCIEquip02ChangeStateCountm", param,
								String.class);
						JNTCIEquip02Output output = new JNTCIEquip02Output();
						List<JNTCIEquip02equip> jNTCIEquip02equip = queryDAO
								.executeForObjectList("getEquipapplynumber2",
										param);
						String nil = "33";
						output.setNil(nil);
						output.setEquipList(jNTCIEquip02equip);
						output.setEquip(param.getEquip());
						output.setDeptName(d);
						output.setTime1(param.getTime1());
						output.setReason(param.getReason());
						result.setResultObject(output);
						result.setResultString("success");
						return result;
					}
				}
			} else {
				BLogicResult result = new BLogicResult();
				JNTCIEquip02Output output = new JNTCIEquip02Output();
				List<JNTCIEquip02equip> jNTCIEquip02equip = queryDAO
						.executeForObjectList("getEquipapplynumber2", param);
				output.setEquipList(jNTCIEquip02equip);
				String d = queryDAO.executeForObject(
						"JNTCIEquip02ChangeStateCountm", param, String.class);
				output.setDeptName(d);
				output.setTime1(param.getTime1());
				output.setEquip(param.getEquip());
				output.setReason(param.getReason());
				result.setResultObject(output);
				result.setResultString("success");
				return result;
			}
		} else if ("2".equals(code)) {
			param.setB(param.getEquip());
			int CSCount2 = queryDAO.executeForObject(
					"JNTCIEquip02ChangeStateCount3", param, Integer.class);
			int CSCount3 = queryDAO.executeForObject(
					"JNTCIEquip02ChangeStateCount33", param, Integer.class);
			if ("1".equals(a)) {
				if ((CSCount2 == 0) && (CSCount3 == 0)) {
					param.setKoshinPGM("4");
					updateDAO.execute("JNTCIEquip05insert", param);
					updateDAO.execute("insertEquipShinsaNo", null);

					String offic_mail = queryDAO.executeForObject("mailperson",
							param, String.class);
					String address = offic_mail + "@trans-cosmos.com.cn";
					InternetAddress sendTo[] = new InternetAddress[1];
					try {
						sendTo[0] = new InternetAddress(address);
					} catch (AddressException e) {
						e.printStackTrace();
					}
					param.setMail(offic_mail);
					String admin = queryDAO.executeForObject("adminmailperson",
							param, String.class);
					param.setAdmin(admin);
					String content = "adminさん<br>お疲れ様です。<br>私はnameです。<br><br>reason .<br><br>以上です、よろしくお願い致します。";
					content = content.replaceAll("name", param.getName());
					content = content.replaceAll("reason", param.getReason());
					content = content.replaceAll("admin", param.getAdmin()
							.substring(0, 1));
					String jncard = param.getId();

					String officemail = queryDAO.executeForObject(
							"findOfficEmail", jncard, String.class);
					String maillian = "@trans-cosmos.com.cn";
					String from = officemail + maillian;
					String subject = "【系统邮件】【設備返還申請】";
					Mail.sendAll(from, "123456", sendTo, null, null, subject,
							content, null);
				} else {
					if (!(CSCount2 == 0) || !(CSCount3 == 0)) {
						BLogicResult result = new BLogicResult();
						String d = queryDAO.executeForObject(
								"JNTCIEquip02ChangeStateCountm", param,
								String.class);
						JNTCIEquip02Output output = new JNTCIEquip02Output();
						List<JNTCIEquip02equip> jNTCIEquip02equip = queryDAO
								.executeForObjectList("getEquipapplynumber2",
										param);
						String nil = "33";
						output.setNil(nil);
						output.setEquipList(jNTCIEquip02equip);
						output.setEquip(param.getEquip());
						output.setDeptName(d);
						output.setTime1(param.getTime1());
						output.setReason(param.getReason());
						result.setResultObject(output);
						result.setResultString("success");
						result.setResultObject(output);
						return result;
					}
				}
			} else {
				BLogicResult result = new BLogicResult();
				JNTCIEquip02Output output = new JNTCIEquip02Output();
				List<JNTCIEquip02equip> jNTCIEquip02equip = queryDAO
						.executeForObjectList("getEquipapplynumber2", param);
				output.setEquipList(jNTCIEquip02equip);
				result.setResultObject(output);
				String d = queryDAO.executeForObject(
						"JNTCIEquip02ChangeStateCountm", param, String.class);
				output.setDeptName(d);
				output.setTime1(param.getTime1());
				output.setEquip(param.getEquip());
				output.setReason(param.getReason());
				result.setResultString("success");
				return result;
			}
		}
		BLogicResult result = new BLogicResult();
		String d = queryDAO.executeForObject("JNTCIEquip02ChangeStateCountm",
				param, String.class);
		JNTCIEquip02Output output = new JNTCIEquip02Output();
		List<JNTCIEquip02equip> jNTCIEquip02equip = queryDAO
				.executeForObjectList("getEquipapplynumber2", param);
		String nil = "66";
		output.setNil(nil);
		output.setEquipList(jNTCIEquip02equip);
		output.setEquip(param.getEquip());
		output.setDeptName(d);
		output.setTime1(param.getTime1());
		output.setReason(param.getReason());
		result.setResultObject(output);
		BLogicMessages messages = new BLogicMessages();
		messages.add("message", new BLogicMessage("message.insert.success",
				param.getEquip()));
		result.setMessages(messages);
		result.setResultString("success");
		return result;
	}

}
