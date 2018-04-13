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
import jp.terasoluna.thin.tutorial.web.common.controller.Mail;
import jp.terasoluna.thin.tutorial.web.transcosmos.dto.JNTCIBusinessApplicationInput;
import jp.terasoluna.thin.tutorial.web.transcosmos.dto.JNTCIBusinessApplicationOutput;

public class JNTCIBusinessApplicationBLogic implements
		BLogic<JNTCIBusinessApplicationInput> {

	private QueryDAO queryDAO = null;
	private UpdateDAO updateDAO = null;

	public void setUpdateDao(UpdateDAO updateDAO) {
		this.updateDAO = updateDAO;
	}

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

	public BLogicResult execute(JNTCIBusinessApplicationInput param) {

		String evectionStarttime = param.getEvectionStarttime();
		String evectionEndtime = param.getEvectionEndtime();
		String userId = param.getUserId();
		Integer businessDays = param.getBusinessDays();
		Boolean aBoolean = null;
		//于琪?箱
		String yuqi =queryDAO.executeForObject("SearchyuqiEmail","1072" , java.lang.String.class);
		String yuqiEmail = yuqi+"@trans-cosmos.com.cn";
		String offic_mail = queryDAO.executeForObject("selectyouxiangpm",
				param, String.class);
		String address = offic_mail + "@trans-cosmos.com.cn";
		InternetAddress sendTo[] = new InternetAddress[1];
		InternetAddress yuqis[]=new InternetAddress[1];
		try {
			yuqis[0] = new InternetAddress(yuqiEmail);
		} catch (AddressException e) {
			e.printStackTrace();
		}
		try {
			sendTo[0] = new InternetAddress(address);
		} catch (AddressException e) {
			e.printStackTrace();
		}
		String content = "xingさん<br>お疲れ様です。nameです。<br><br>因项目需求，申请出差<br><br>时间：start至end<br><br>以上です、よろしくお願い致します。";
		content = content.replaceAll("name", param.getUserName());
		content = content.replaceAll("xing",
				param.getProjectPm().substring(0, 1));
		content = content.replaceAll("start", param.getEvectionStarttime());
		content = content.replaceAll("end", param.getEvectionEndtime());
		String jncard = param.getUserId();
		String officemail = queryDAO.executeForObject("findOfficEmail", jncard,
				String.class);
		String maillian = "@trans-cosmos.com.cn";
		String from = officemail + maillian;
		String subject = "【系统邮件】【出差申请】";
		Mail.sendAll(from, "123456", sendTo, yuqis, null, subject, content, null);
		try {
			aBoolean = validateTime(evectionStarttime, evectionEndtime, userId);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		if (false == aBoolean) {
			BLogicMessages messages = new BLogicMessages();
			messages.add("message", new BLogicMessage(
					"JNTCIBusiness.compareDate"));

			BLogicResult result = new BLogicResult();
			result.setMessages(messages);
			result.setResultString("success");

			return result;
		} else {
			try {
				aBoolean = checkbusinessDays(evectionStarttime,
						evectionEndtime, businessDays);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			if (false == aBoolean) {
				BLogicMessages messages = new BLogicMessages();
				messages.add("message", new BLogicMessage(
						"JNTCIBusiness.checkBusinessDays"));

				BLogicResult result = new BLogicResult();
				result.setMessages(messages);
				result.setResultString("success");

				return result;
			} else {
				Integer countDays = param.getBusinessDays();
				if (0 >= countDays) {
					BLogicMessages messages = new BLogicMessages();
					messages.add("message", new BLogicMessage(
							"JNTCIBusiness.countDays"));

					BLogicResult result = new BLogicResult();
					result.setMessages(messages);
					result.setResultString("success");

					return result;
				} else {
					String evectionId = queryDAO.executeForObject(
							"getMaxEvectionId", null, String.class);

					if (evectionId == null || evectionId == "") {
						evectionId = "E00000001";
					} else {
						String retroactive = evectionId.substring(1, 9);
						Integer num_id_dec = Integer.parseInt(retroactive);
						if (num_id_dec >= 1 && num_id_dec < 9) {
							num_id_dec += 1;
							evectionId = "E0000000" + num_id_dec;
						} else if (num_id_dec >= 9 && num_id_dec < 99) {
							num_id_dec += 1;
							evectionId = "E000000" + num_id_dec;
						} else if (num_id_dec >= 99 && num_id_dec < 999) {
							num_id_dec += 1;
							evectionId = "E00000" + num_id_dec;
						}else if(num_id_dec >= 999 && num_id_dec < 9999){
							num_id_dec += 1;
							evectionId = "E0000" + num_id_dec;
						}else if(num_id_dec >= 9999 && num_id_dec < 99999){
							num_id_dec += 1;
							evectionId = "E000" + num_id_dec;
						}else if(num_id_dec >= 99999 && num_id_dec < 999999){
							num_id_dec += 1;
							evectionId = "E00" + num_id_dec;
						}else if(num_id_dec >= 999999 && num_id_dec < 9999999){
							num_id_dec += 1;
							evectionId = "E0" + num_id_dec;
						}else if(num_id_dec >= 9999999 && num_id_dec < 99999999){
							num_id_dec += 1;
							evectionId = "E" + num_id_dec;
						}
					}

					param.setEvectionId(evectionId);
					param.setExamineStatus("A04");
					String ID = param.getUserId();
					JNTCIBusinessApplicationInput applicationInput = queryDAO
							.executeForObject("businessUser", ID,
									JNTCIBusinessApplicationInput.class);
					String flag = applicationInput.getFlag();
					String projectPm = applicationInput.getProjectPm();
					param.setProjectPm(projectPm);
					if (Integer.parseInt(flag) <= 4) {
						updateDAO.execute("businessApplication1", param);
						BLogicMessages messages = new BLogicMessages();
						messages.add("message", new BLogicMessage(
								"JNTCIBusiness.submit", param.getDeptId()));

						BLogicResult result = new BLogicResult();

						result.setMessages(messages);
						result.setResultString("success");
						return result;
					} else {

                        if(param.getDeptId().equals("001")){
                        	updateDAO.execute("businessApplicationGLB", param);
						}else{
                        updateDAO.execute("businessApplication", param);
                        }
						BLogicMessages messages = new BLogicMessages();
						messages.add("message", new BLogicMessage(
								"JNTCIBusiness.submit", param.getDeptId()));

						BLogicResult result = new BLogicResult();

						result.setMessages(messages);
						result.setResultString("success");

						return result;
					}
				}
			}
		}
	}

	private boolean checkbusinessDays(String startTime, String endTime,
			Integer businessDays) throws ParseException {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Long daysLong = sdf.parse(endTime).getTime()
					- sdf.parse(startTime).getTime();
			Long nd = (long) (1000 * 24 * 60 * 60);
			Integer checkDays = (int) (daysLong / nd) + 1;
			if (checkDays.equals(businessDays)) {
				return true;
			} else {
				return false;
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}

		return true;
	}

	private boolean validateTime(String sTime, String eTime, String userId)
			throws ParseException {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date sTimeDate = sdf.parse(sTime);
		Date sEndDate = sdf.parse(eTime);

		List<JNTCIBusinessApplicationOutput> timeList = queryDAO
				.executeForObjectList("compareDate", userId);
		if (timeList.size() == 0) {
			return true;

		} else {

			for (JNTCIBusinessApplicationOutput selectDate : timeList) {
				Date start = sdf.parse(selectDate.getEvectionStarttime());
				Date end = sdf.parse(selectDate.getEvectionEndtime());
				if ((sTimeDate.compareTo(start) == 0)
						|| (sEndDate.compareTo(end) == 0)
						|| (sTimeDate.after(start) && sTimeDate.before(end))
						|| (sEndDate.after(start) && sEndDate.before(end))
						|| (start.after(sTimeDate) && end.before(sEndDate))) {

					return false;

				}

			}
		}

		return true;

	}

}
