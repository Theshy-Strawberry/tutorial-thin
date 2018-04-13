package jp.terasoluna.thin.tutorial.web.transcosmos.blogic;

import jp.terasoluna.fw.dao.QueryDAO;
import jp.terasoluna.fw.service.thin.BLogic;
import jp.terasoluna.fw.service.thin.BLogicResult;
import jp.terasoluna.thin.tutorial.web.transcosmos.dto.JNTCIBusinessVerifyDetailedInput;

public class JNTCIBusinessVerifyDetailedUpdateBLogic001  implements  BLogic<JNTCIBusinessVerifyDetailedInput>{
	private QueryDAO queryDAO = null;

	public QueryDAO getQueryDAO() {
		return queryDAO;
	}

	public void setQueryDAO(QueryDAO queryDAO) {
		this.queryDAO = queryDAO;
	}

	public BLogicResult execute(JNTCIBusinessVerifyDetailedInput param) {
		BLogicResult result = new BLogicResult();
		JNTCIBusinessVerifyDetailedInput output = new  JNTCIBusinessVerifyDetailedInput();
		output.setEvectionId(param.getEvectionId());
		output.setDept_Id(param.getDept_Id());
		output.setUser_Id(param.getUser_Id());
		output.setUser_Name(param.getUser_Name());
		output.setStartIndex(param.getStartIndex());
		output.setExamine_Status(param.getExamine_Status());
		result.setResultObject(output);
		result.setResultString("success");
		return result;
	}

}
