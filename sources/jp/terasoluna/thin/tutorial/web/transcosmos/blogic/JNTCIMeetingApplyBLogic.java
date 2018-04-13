package jp.terasoluna.thin.tutorial.web.transcosmos.blogic;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import jp.terasoluna.fw.dao.QueryDAO;
import jp.terasoluna.fw.dao.UpdateDAO;
import jp.terasoluna.fw.service.thin.BLogic;
import jp.terasoluna.fw.service.thin.BLogicMessage;
import jp.terasoluna.fw.service.thin.BLogicMessages;
import jp.terasoluna.fw.service.thin.BLogicResult;
import jp.terasoluna.thin.tutorial.web.common.controller.Mail;
import jp.terasoluna.thin.tutorial.web.transcosmos.dto.JNTCIMeetingApplyInput;
import jp.terasoluna.thin.tutorial.web.transcosmos.dto.JNTCIMeetingApplyOutput;

public class JNTCIMeetingApplyBLogic implements BLogic<JNTCIMeetingApplyInput> {

	private QueryDAO queryDAO = null;

	private UpdateDAO updateDAO = null;

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

	public BLogicResult execute(JNTCIMeetingApplyInput param) {

		BLogicResult result = new BLogicResult();

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm");
		String applyTime = sdf.format(new Date());
		param.setApplyTime(applyTime);

		String jncard = param.getJnCard();
		String remark = param.getRemark();
		String roomNo = param.getRoomNo();
		String startTime = param.getStartTime();
		String endTime = param.getEndTime();
		String useTime = getUseTime(startTime, endTime);

		String username = queryDAO.executeForObject("findUserByCard", jncard,
				String.class);
		param.setUsername(username);

		String roomName = queryDAO.executeForObject("findRoomNameByNo", roomNo,
				String.class);
		param.setRoomName(roomName);

		try {
			if (username == null || "".equals(username)) {

				BLogicMessages messages = new BLogicMessages();
				messages.add("message",
						new BLogicMessage("errors.validateCard"));
				result.setErrors(messages);
				result.setResultString("fail");

				return result;
			}
			if (!validatePastTime(startTime)) {
				BLogicMessages messages = new BLogicMessages();
				messages.add("message", new BLogicMessage(
						"errors.validatePastTime"));
				result.setErrors(messages);
				result.setResultString("fail");

				return result;
			}
			if (!validateSameDate(startTime, endTime)) {
				BLogicMessages messages = new BLogicMessages();
				messages.add("message", new BLogicMessage(
						"errors.validateSameDate"));
				result.setErrors(messages);
				result.setResultString("fail");

				return result;
			}
			if (!validateMinute(startTime, endTime)) {
				BLogicMessages messages = new BLogicMessages();
				messages.add("message", new BLogicMessage(
						"errors.validateMinute"));
				result.setErrors(messages);
				result.setResultString("fail");

				return result;
			}
			if (!validatePattern(startTime, endTime)) {
				BLogicMessages messages = new BLogicMessages();
				messages.add("message", new BLogicMessage(
						"errors.validatePattern"));
				result.setErrors(messages);
				result.setResultString("fail");

				return result;
			}

			if (!validateTime(startTime, endTime, roomNo)) {

				BLogicMessages messages = new BLogicMessages();
				messages.add("message", new BLogicMessage(
						"errors.validateTime", param.getRoomNo()));
				result.setErrors(messages);
				result.setResultString("fail");

				return result;
			}

		} catch (ParseException e) {
			e.printStackTrace();
		}
		// 将申请记录插入
		String toId = param.getToId();
		//String filePath = "D:/workspace/tutorial-thin/sources/";
		// 下面这个才是真正的路径，上面这个是假的
	    String filePath = this.getClass().getResource("/").getFile();
		Properties props = new Properties();

		if (toId != null && (!"".equals(toId))) {
			String CodeAndMailFileName = "CodeAndMail.properties";
			InputStream in = null;
			try {
				in = new FileInputStream(filePath + CodeAndMailFileName);
				props.load(in);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}

			String toIdstr[] = toId.split(";");
			String codes = param.getJnCard() + ";";

			for (String to : toIdstr) {
				String value = props.getProperty(to);
				codes = codes + value + ";";
			}

			param.setToId(codes);

		} else {
			param.setToId(param.getJnCard());
		}

		String mailContent = param.getMailContent();
		updateDAO.execute("insertRecord", param);

		if (toId != null && (!"".equals(toId))) {

			String userMailFileName = "userMail.properties";
			InputStream in = null;
			try {
				in = new FileInputStream(filePath + userMailFileName);
				props.load(in);
				toId = toId + props.getProperty(param.getJnCard());
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}

			String toIdstr1[] = toId.split(";");
			InternetAddress sendTo[] = new InternetAddress[toIdstr1.length];

			String subject = param.getSubject();
			String content = param.getMailContent();

			if (content != null) {
				content = content.replaceAll("\r\n", "<br>");
			}

			for (int i = 0; i < toIdstr1.length; i++) {
				try {
					sendTo[i] = new InternetAddress(toIdstr1[i]);
				} catch (AddressException e) {
					e.printStackTrace();
				}
			}

			String officemail = queryDAO.executeForObject("findOfficEmail",
					jncard, String.class);
			String maillian = "@trans-cosmos.com.cn";
			String from = officemail + maillian;

			Mail.sendAll(from, "123456", sendTo, null, null, subject, content,
					null);
		}
		JNTCIMeetingApplyOutput output = new JNTCIMeetingApplyOutput();
		output.setUseTime(useTime);
		output.setJnCard(jncard);
		output.setRemark(remark);
		output.setRoomNo(roomNo);
		output.setRoomName(roomName);
		output.setApplyTime(applyTime);
		output.setUsername(username);
		output.setEndTime(endTime);
		output.setStartTime(startTime);
		output.setToId(toId);
		output.setCcId("");
		output.setMailContent(mailContent);
		output.setSubject(param.getSubject());

		result.setResultObject(output);
		result.setResultString("success");

		return result;
	}

	// 将开始时间和结束时间拼接到一起在页面显示用
	public String getUseTime(String sTime, String eTime) {
		StringBuffer sb = new StringBuffer();
		sb.append(sTime.substring(0, 16)).append("-")
				.append(eTime.substring(11, 16));
		String useTime = sb.toString();
		return useTime;
	}

	// 验证选择的时间是否已经被占用
	public boolean validateTime(String sTime, String eTime, String roomNo)
			throws ParseException {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		Date sTimeDate = sdf.parse(sTime);
		Date sEndDate = sdf.parse(eTime);

		List<JNTCIMeetingApplyOutput> timeList = queryDAO.executeForObjectList(
				"findUseTimeByRoomNo", roomNo);
		if (timeList.size() == 0) {
			return true;

		} else {

			for (JNTCIMeetingApplyOutput l : timeList) {
				Date start = sdf.parse(l.getStartTime());
				Date end = sdf.parse(l.getEndTime());
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

	// 验证开始时间是否小于结束时间
	public boolean validatePattern(String sTime, String eTime)
			throws ParseException {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		Date sTimeDate = sdf.parse(sTime);
		Date sEndDate = sdf.parse(eTime);
		if (sTimeDate.after(sEndDate) || (sTimeDate.compareTo(sEndDate) == 0)) {
			return false;
		}

		return true;
	}

	public boolean validatePastTime(String sTime) throws ParseException {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		Date nowTime = new Date();
		Date sTimeDate = sdf.parse(sTime);
		// Date snowTime = sdf.parse(nowTime);
		if (sTimeDate.before(nowTime)) {
			return false;
		}

		return true;
	}

	// 验证开始时间和结束时间是否是同一天
	public boolean validateSameDate(String sTime, String eTime)
			throws ParseException {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date sTimeDate = sdf.parse(sTime);
		Date sEndDate = sdf.parse(eTime);
		if (sTimeDate.compareTo(sEndDate) != 0) {
			return false;
		}

		return true;
	}

	// 验证时、分是否选中
	public boolean validateMinute(String sTime, String eTime) {

		String subStart = sTime.substring(11);
		String subEnd = eTime.substring(11);
		String str = "00:00";
		if (str.equals(subStart) || str.equals(subEnd)) {
			return false;
		}
		return true;
	}
}
