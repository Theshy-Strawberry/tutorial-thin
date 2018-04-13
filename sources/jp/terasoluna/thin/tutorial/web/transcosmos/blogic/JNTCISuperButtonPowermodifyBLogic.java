package jp.terasoluna.thin.tutorial.web.transcosmos.blogic;

import jp.terasoluna.fw.dao.QueryDAO;
import jp.terasoluna.fw.dao.UpdateDAO;
import jp.terasoluna.fw.service.thin.BLogic;
import jp.terasoluna.fw.service.thin.BLogicMessage;
import jp.terasoluna.fw.service.thin.BLogicMessages;
import jp.terasoluna.fw.service.thin.BLogicResult;
import jp.terasoluna.thin.tutorial.web.transcosmos.dto.JNTCISuperButtonInput;

public class JNTCISuperButtonPowermodifyBLogic implements
		BLogic<JNTCISuperButtonInput> {

	private UpdateDAO updateDAO = null;
	private QueryDAO queryDAO = null;

	public QueryDAO getQueryDAO() {
		return queryDAO;
	}

	public void setQueryDAO(QueryDAO queryDAO) {
		this.queryDAO = queryDAO;
	}

	public BLogicResult execute(JNTCISuperButtonInput param) {
		BLogicResult result = new BLogicResult();
		JNTCISuperButtonInput output = new JNTCISuperButtonInput();
		String usersId=param.getUsersId();
		updateDAO.execute("updateProjectByname", param);
		String projectdutyname=queryDAO.executeForObject("updateProjectByname2", usersId, String.class);
        param.setProjectdutyname(projectdutyname);
		updateDAO.execute("updateProjectByname1", param);
		output.setUsersId(param.getUsersId());
		//output.setProjectdutyname(param.getProjectdutyname());
		BLogicMessages messages = new BLogicMessages();
		messages.add("message", new BLogicMessage("messageproject.success"));
		result.setResultObject(output);
		result.setResultString("success");
		result.setMessages(messages);
		return result;
	}

	public UpdateDAO getUpdateDAO() {
		return updateDAO;
	}

	public void setUpdateDAO(UpdateDAO updateDAO) {
		this.updateDAO = updateDAO;
	}
}
