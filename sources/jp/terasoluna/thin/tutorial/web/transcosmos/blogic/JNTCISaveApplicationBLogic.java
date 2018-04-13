package jp.terasoluna.thin.tutorial.web.transcosmos.blogic;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import jp.terasoluna.fw.dao.QueryDAO;
import jp.terasoluna.fw.dao.UpdateDAO;
import jp.terasoluna.fw.service.thin.BLogic;
import jp.terasoluna.fw.service.thin.BLogicMessage;
import jp.terasoluna.fw.service.thin.BLogicMessages;
import jp.terasoluna.fw.service.thin.BLogicResult;
import jp.terasoluna.thin.tutorial.web.transcosmos.dto.JNTCIBusinessApplicationInput;
import jp.terasoluna.thin.tutorial.web.transcosmos.dto.JNTCIBusinessApplicationOutput;

public class JNTCISaveApplicationBLogic implements
		BLogic<JNTCIBusinessApplicationInput> {

	private UpdateDAO updateDAO = null;

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

	public BLogicResult execute(JNTCIBusinessApplicationInput param) {

		String evectionStarttime = param.getEvectionStarttime();
		String evectionEndtime = param.getEvectionEndtime();
		Integer businessDays = param.getBusinessDays();
		Boolean aBoolean = null;
		try {
			aBoolean = validateTime(evectionStarttime, evectionEndtime, param);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		if (false == aBoolean) {
			BLogicMessages messages = new BLogicMessages();
			messages.add("message", new BLogicMessage(
					"JNTCIBusiness.compareDate"));

			BLogicResult result = new BLogicResult();
			result.setMessages(messages);
			result.setResultString("success1");

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
				result.setResultString("success1");

				return result;
			} else {
				BLogicResult result = new BLogicResult();

				updateDAO.execute("saveApplication", param);

				JNTCIBusinessApplicationInput output=new JNTCIBusinessApplicationInput();
				output.setStartIndex(param.getStartIndex());
				output.setEvectionId(param.getEvectionId());
				result.setResultObject(output);


				result.setResultString("success");

				return result;
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

	private boolean validateTime(String sTime, String eTime,
			JNTCIBusinessApplicationInput param) throws ParseException {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date sTimeDate = sdf.parse(sTime);
		Date sEndDate = sdf.parse(eTime);

		List<JNTCIBusinessApplicationOutput> timeList = queryDAO
				.executeForObjectList("selectDate", param);
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
