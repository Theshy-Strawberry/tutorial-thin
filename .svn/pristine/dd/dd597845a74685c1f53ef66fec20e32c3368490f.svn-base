package jp.terasoluna.thin.tutorial.web.transcosmos.blogic;

import jp.terasoluna.fw.dao.UpdateDAO;
import jp.terasoluna.fw.service.thin.BLogic;
import jp.terasoluna.fw.service.thin.BLogicMessage;
import jp.terasoluna.fw.service.thin.BLogicMessages;
import jp.terasoluna.fw.service.thin.BLogicResult;
import jp.terasoluna.thin.tutorial.web.transcosmos.dto.JNTCISuperButtonInput;

public class JNTCISuperButtonProjectdeleteBLogic implements
		BLogic<JNTCISuperButtonInput> {

	private UpdateDAO updateDAO = null;

	public BLogicResult execute(JNTCISuperButtonInput param) {

		BLogicResult result = new BLogicResult();
		//JNTCISuperButtonInput output = new JNTCISuperButtonInput();
		updateDAO.execute("deleteProjectByname", param);
		updateDAO.execute("setProjectNull", param);
		BLogicMessages messages = new BLogicMessages();
		messages.add("message", new BLogicMessage("messageprojectdelete.success"));
		//result.setResultObject(output);
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
