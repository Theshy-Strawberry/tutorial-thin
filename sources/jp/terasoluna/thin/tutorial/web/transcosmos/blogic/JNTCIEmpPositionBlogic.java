package jp.terasoluna.thin.tutorial.web.transcosmos.blogic;

import jp.terasoluna.fw.dao.QueryDAO;
import jp.terasoluna.fw.dao.UpdateDAO;
import jp.terasoluna.fw.service.thin.BLogic;
import jp.terasoluna.fw.service.thin.BLogicResult;
import jp.terasoluna.thin.tutorial.web.transcosmos.dto.JNTCIEmpPositionInput;
import jp.terasoluna.thin.tutorial.web.transcosmos.dto.JNTCIEmpPositionOutput;


public class JNTCIEmpPositionBlogic implements BLogic<JNTCIEmpPositionInput> {
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

		updateDAO.execute("UpdateEmpPosition", param);

		JNTCIEmpPositionOutput output = queryDAO.executeForObject("SelectEmpInfo", param, JNTCIEmpPositionOutput.class);
		BLogicResult result = new BLogicResult();
		result.setResultObject(output);
		result.setResultString("success");
		return result;

	}
}
