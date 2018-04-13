package jp.terasoluna.thin.tutorial.web.transcosmos.blogic;

import jp.terasoluna.fw.dao.QueryDAO;
import jp.terasoluna.fw.service.thin.BLogic;
import jp.terasoluna.fw.service.thin.BLogicResult;
import jp.terasoluna.thin.tutorial.web.transcosmos.dto.JNTCIEquipListInput;

public class JNTCIEquipListBLogic001 implements BLogic<JNTCIEquipListInput>{
	private QueryDAO queryDAO = null;

	public QueryDAO getQueryDAO() {
		return queryDAO;
	}

	public void setQueryDAO(QueryDAO queryDAO) {
		this.queryDAO = queryDAO;
	}

	public BLogicResult execute(JNTCIEquipListInput param) {
		BLogicResult result = new BLogicResult();
		JNTCIEquipListInput output=new JNTCIEquipListInput();
		output.setCode(param.getCode());
		output.setDeptId(param.getDeptId());
		output.setUserId(param.getUserId());
		output.setStartIndex(param.getStartIndex());
		output.setSetsubiKubun(param.getSetsubiKubun());
		result.setResultObject(output);
		result.setResultString("success");
		return result;
	}

}
