package jp.terasoluna.thin.tutorial.web.transcosmos.blogic;

import java.util.List;

import jp.terasoluna.fw.dao.QueryDAO;
import jp.terasoluna.fw.service.thin.BLogic;
import jp.terasoluna.fw.service.thin.BLogicMessage;
import jp.terasoluna.fw.service.thin.BLogicMessages;
import jp.terasoluna.fw.service.thin.BLogicResult;
import jp.terasoluna.thin.tutorial.web.transcosmos.dto.JNTCISuperButtonInput;


public class JNTCISuperButtonProjectPersonSelectBLogic implements BLogic<JNTCISuperButtonInput>{
	private QueryDAO queryDAO=null;

	public QueryDAO getQueryDAO() {
		return queryDAO;
	}

	public void setQueryDAO(QueryDAO queryDAO) {
		this.queryDAO = queryDAO;
	}

	public BLogicResult execute(JNTCISuperButtonInput param) {
		BLogicResult result = new BLogicResult();
		JNTCISuperButtonInput input = new JNTCISuperButtonInput();
		String projectId1 = param.getProjectId1();
		List<JNTCISuperButtonInput> selectprojectusernamelist=queryDAO.executeForObjectList("selectprojectusername", param);
			input.setSelectprojectusernamelist(selectprojectusernamelist);
			input.setProjectId1(projectId1);
			result.setResultObject(input);
			result.setResultString("success");
		return result;
	}

}
