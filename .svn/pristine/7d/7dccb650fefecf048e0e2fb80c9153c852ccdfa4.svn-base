package jp.terasoluna.thin.tutorial.web.transcosmos.blogic;

import java.sql.Timestamp;
import java.util.Date;

import jp.terasoluna.fw.dao.QueryDAO;
import jp.terasoluna.fw.dao.UpdateDAO;
import jp.terasoluna.fw.service.thin.BLogic;
import jp.terasoluna.fw.service.thin.BLogicMessage;
import jp.terasoluna.fw.service.thin.BLogicMessages;
import jp.terasoluna.fw.service.thin.BLogicResult;
import jp.terasoluna.thin.tutorial.web.common.controller.DateController;
import jp.terasoluna.thin.tutorial.web.transcosmos.dto.JNTCIEmpPositionInput;
public class JNTCIdeletepeople implements BLogic<JNTCIEmpPositionInput> {
	private QueryDAO queryDAO = null;
	private UpdateDAO updateDAO  = null;
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
	public BLogicResult execute(JNTCIEmpPositionInput param) {
		BLogicMessages messages = new BLogicMessages();
		Timestamp time = DateController.getStringToTimestamp(DateController.getDateToString(new Date(), DateController.YMDHMSs));
		param.setSystemTime(time);
		BLogicResult result = new BLogicResult();
		String postion = param.getEmp_Position();
	    String subPosition = postion.substring(0, 1);
	    if("A".equals(subPosition)){
	    	result.setResultString("south");
	    }else{
	    	result.setResultString("north");
	    }
		try {
		updateDAO.execute("DeletePosition", param);
		updateDAO.execute("Deleteman", param);
		} catch (Exception e) {
			messages.add("message", new BLogicMessage("JNTCIPosition.deletefailure"));
			result.setErrors(messages);
		}
		messages.add("message", new BLogicMessage("JNTCIPosition.deletesuccess"));
		result.setMessages(messages);
		return result;
	}
}
