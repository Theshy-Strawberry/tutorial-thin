package jp.terasoluna.thin.tutorial.web.transcosmos.blogic;

import java.util.List;

import jp.terasoluna.fw.dao.QueryDAO;
import jp.terasoluna.fw.service.thin.BLogic;
import jp.terasoluna.fw.service.thin.BLogicResult;
import jp.terasoluna.thin.tutorial.web.transcosmos.dto.JNTCIOverTimeVerifyCondition;

public class JNTCIOverTimeVerifyconditonBLogic implements
		BLogic<JNTCIOverTimeVerifyCondition> {

	private QueryDAO queryDAO = null;

	public void setQueryDAO(QueryDAO queryDAO) {
		this.queryDAO = queryDAO;
	}

	public BLogicResult execute(JNTCIOverTimeVerifyCondition param) {
		JNTCIOverTimeVerifyCondition jntciextraconditiondto = queryDAO
				.executeForObject("JNTCIOVERTIME", param,
						JNTCIOverTimeVerifyCondition.class);
		List<JNTCIOverTimeVerifyCondition> shenchalist = queryDAO
				.executeForObjectList("selectleader", param);
		jntciextraconditiondto.setShenchalist(shenchalist);
		BLogicResult result = new BLogicResult();
		jntciextraconditiondto.setStartIndex(param.getStartIndex());
		jntciextraconditiondto.setDept_id2(param.getDept_id2());
		jntciextraconditiondto.setExtra_auditss_search(param.getExtra_auditss_search());
		jntciextraconditiondto.setExtra_starttime1(param.getExtra_starttime1());
		jntciextraconditiondto.setExtra_endtime1(param.getExtra_endtime1());
		jntciextraconditiondto.setUser_id2(param.getUser_id2());
		jntciextraconditiondto.setUser_name2(param.getUser_name2());
		result.setResultObject(jntciextraconditiondto);
		result.setResultString("success1");
		return result;
	}

}
