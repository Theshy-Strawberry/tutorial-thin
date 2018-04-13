package jp.terasoluna.thin.tutorial.web.transcosmos.blogic;

import jp.terasoluna.fw.dao.UpdateDAO;
import jp.terasoluna.fw.service.thin.BLogic;
import jp.terasoluna.fw.service.thin.BLogicResult;
import jp.terasoluna.thin.tutorial.web.transcosmos.dto.JNTCLOvertimeApplicationInput;

public class JNTCIOvertimeApplicationDeleteBLogic implements BLogic<JNTCLOvertimeApplicationInput> {

	private UpdateDAO updateDAO = null;

	public UpdateDAO getUpdateDAO() {
		return updateDAO;
	}

	public void setUpdateDAO(UpdateDAO updateDAO) {
		this.updateDAO = updateDAO;
	}

	public BLogicResult execute(JNTCLOvertimeApplicationInput param) {
		BLogicResult result = new BLogicResult();
		updateDAO.execute("deleteextra", param);
		result.setResultString("success");
		return result;
	}

}
