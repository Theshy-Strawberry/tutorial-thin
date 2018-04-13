package jp.terasoluna.thin.tutorial.web.transcosmos.blogic;

import jp.terasoluna.fw.dao.QueryDAO;
import jp.terasoluna.fw.service.thin.BLogic;
import jp.terasoluna.fw.service.thin.BLogicResult;
import jp.terasoluna.thin.tutorial.web.transcosmos.dto.JNTCIBusinessVerify01Input;


public class JNTCIBusinessVerify01BLogic002  implements  BLogic<JNTCIBusinessVerify01Input>{
	private QueryDAO queryDAO = null;


	public QueryDAO getQueryDAO() {
		return queryDAO;
	}


	public void setQueryDAO(QueryDAO queryDAO) {
		this.queryDAO = queryDAO;
	}

	public BLogicResult execute(JNTCIBusinessVerify01Input param) {
		BLogicResult result = new BLogicResult();
		JNTCIBusinessVerify01Input output=new  JNTCIBusinessVerify01Input();
		output.setStartIndex(param.getStartIndex());
		output.setEvectionId(param.getEvectionId());
		output.setUser_Id(param.getUser_Id());
		output.setUser_Name(param.getUser_Name());
		output.setDept_Id(param.getDept_Id());
		output.setExamine_Status(param.getExamine_Status());
		result.setResultObject(output);
		result.setResultString("success");
		return result;
	}

}
