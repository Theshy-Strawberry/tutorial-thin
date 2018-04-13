package jp.terasoluna.thin.tutorial.web.transcosmos.blogic;

import jp.terasoluna.fw.dao.QueryDAO;
import jp.terasoluna.fw.dao.UpdateDAO;
import jp.terasoluna.fw.service.thin.BLogic;
import jp.terasoluna.fw.service.thin.BLogicMessage;
import jp.terasoluna.fw.service.thin.BLogicMessages;
import jp.terasoluna.fw.service.thin.BLogicResult;
import jp.terasoluna.thin.tutorial.web.transcosmos.dto.JNTCIHomePage02Input;
import jp.terasoluna.thin.tutorial.web.transcosmos.dto.JNTCIHomePage02Output;

public class JNTCIHomePageDelete02Blogic implements BLogic<JNTCIHomePage02Input> {
	private QueryDAO queryDAO=null;
	private UpdateDAO updateDAO=null;

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
	public BLogicResult execute(JNTCIHomePage02Input param) {

		JNTCIHomePage02Output infoTitle =queryDAO.executeForObject("infoTitle",param,JNTCIHomePage02Output.class);
		updateDAO.execute("infoTitleDelete", param);
		BLogicResult result = new BLogicResult();
		result.setResultString("success2");
		return result;
	}

}
