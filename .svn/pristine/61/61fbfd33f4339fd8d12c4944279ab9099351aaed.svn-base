package jp.terasoluna.thin.tutorial.web.transcosmos.blogic;

import jp.terasoluna.fw.dao.UpdateDAO;
import jp.terasoluna.fw.service.thin.BLogic;
import jp.terasoluna.fw.service.thin.BLogicResult;
import jp.terasoluna.thin.tutorial.web.transcosmos.dto.JNTCIBusinessApplicationInput;

public class JNTCIDeleteApplicationBLogic implements BLogic<JNTCIBusinessApplicationInput>{

private UpdateDAO updateDAO = null;

	public UpdateDAO getUpdateDAO() {
		return updateDAO;
	}

	public void setUpdateDAO(UpdateDAO updateDAO) {
		this.updateDAO = updateDAO;
	}

	public BLogicResult execute(JNTCIBusinessApplicationInput param) {

		BLogicResult result = new BLogicResult();
		updateDAO.execute("deleteApplication", param);
		result.setResultString("success");

		return result;
	}

}
