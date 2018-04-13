package jp.terasoluna.thin.tutorial.web.transcosmos.blogic;

import jp.terasoluna.fw.dao.QueryDAO;
import jp.terasoluna.fw.dao.UpdateDAO;
import jp.terasoluna.fw.service.thin.BLogic;
import jp.terasoluna.fw.service.thin.BLogicResult;
import jp.terasoluna.thin.tutorial.web.transcosmos.dto.JNTCIEquipInsertInput;

public class JNTCIEquipEditorInsertBLogic001  implements BLogic<JNTCIEquipInsertInput>{
	private QueryDAO queryDAO = null;

	private UpdateDAO updateDAO = null;

	public QueryDAO getQueryDAO() {
		return queryDAO;
	}

	public void setQueryDAO(QueryDAO queryDAO) {
		this.queryDAO = queryDAO;
	}

	public UpdateDAO getUpdateDAO() {
		return updateDAO;
	}

	public void setUpdateDAO(UpdateDAO updateDAO) {
		this.updateDAO = updateDAO;
	}

	public BLogicResult execute(JNTCIEquipInsertInput param) {
		BLogicResult result = new BLogicResult();
		JNTCIEquipInsertInput output=new JNTCIEquipInsertInput();
		output.setCode(param.getCode());
		output.setSetsubiKubun(param.getSetsubiKubun());
		output.setDeptId(param.getDeptId());
		output.setUserId(param.getUserId());
		output.setStartIndex(param.getStartIndex());
		result.setResultObject(output);
		result.setResultString("success");
		return result;
	}

}
