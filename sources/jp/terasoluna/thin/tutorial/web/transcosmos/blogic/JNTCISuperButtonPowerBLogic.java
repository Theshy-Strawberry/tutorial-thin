package jp.terasoluna.thin.tutorial.web.transcosmos.blogic;

import java.util.List;

import jp.terasoluna.fw.dao.QueryDAO;
import jp.terasoluna.fw.service.thin.BLogic;
import jp.terasoluna.fw.service.thin.BLogicResult;
import jp.terasoluna.thin.tutorial.web.transcosmos.dto.JNTCISuperButtonInput;

public class JNTCISuperButtonPowerBLogic  implements BLogic<JNTCISuperButtonInput>{
	private QueryDAO queryDAO=null;

	public QueryDAO getQueryDAO() {
		return queryDAO;
	}

	public void setQueryDAO(QueryDAO queryDAO) {
		this.queryDAO = queryDAO;
	}
	public BLogicResult execute(JNTCISuperButtonInput param) {
		BLogicResult result = new BLogicResult();
		// select CD_CODE as code_id,KJ_NAME as kj_name  from TT_CODE where CD_KUBUN='A0'
		List<JNTCISuperButtonInput> rolelist=queryDAO.executeForObjectList("selectrolelist", param);
		List<JNTCISuperButtonInput> projectlist=queryDAO.executeForObjectList("selectprojectlist", param);
		List<JNTCISuperButtonInput> pmlist=queryDAO.executeForObjectList("pmlist", param);
		List<JNTCISuperButtonInput> projectnamelist=queryDAO.executeForObjectList("projectnamelist", param);
		JNTCISuperButtonInput input=new JNTCISuperButtonInput();
		input.setProjectnamelist(projectnamelist);
		input.setProjectlist(projectlist);
		input.setRolelist(rolelist);
		input.setPmlist(pmlist);
		result.setResultObject(input);
		result.setResultString("success");
		return result;

	}

}
