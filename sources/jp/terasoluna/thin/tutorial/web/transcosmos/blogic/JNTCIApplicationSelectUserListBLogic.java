package jp.terasoluna.thin.tutorial.web.transcosmos.blogic;

import java.util.List;

import jp.terasoluna.fw.dao.QueryDAO;
import jp.terasoluna.fw.service.thin.BLogic;
import jp.terasoluna.fw.service.thin.BLogicResult;
import jp.terasoluna.thin.tutorial.web.transcosmos.dto.JNTCIOverTimeApplicationSelectInput;
import jp.terasoluna.thin.tutorial.web.transcosmos.dto.JNTCIOverTimeApplicationSelectOutput;

public class JNTCIApplicationSelectUserListBLogic implements BLogic<JNTCIOverTimeApplicationSelectInput>{
	private QueryDAO queryDAO = null;

	public QueryDAO getQueryDAO() {
		return queryDAO;
	}

	public void setQueryDAO(QueryDAO queryDAO) {
		this.queryDAO = queryDAO;
	}

	public BLogicResult execute(JNTCIOverTimeApplicationSelectInput param) {
		String strIndex = param.getStartIndex();
		String strRow = param.getRow();

		int startIndex = 0;
		int row = 5;
		if (strIndex != null) {
			startIndex = Integer.parseInt(strIndex);

		}
		if (strRow != null) {
			row = Integer.parseInt(strRow);
		}
		String user_id =param.getUser_id();
		String totalCount = queryDAO.executeForObject("selecttotalCount",user_id,
				String.class);

		List<JNTCIOverTimeApplicationSelectInput> jntciovertimeapplicationselectinput = queryDAO.executeForObjectList("selectallextraByuser_id",
				user_id,startIndex, row);

		JNTCIOverTimeApplicationSelectOutput output = new JNTCIOverTimeApplicationSelectOutput();
		output.setJntciovertimeapplicationselectinput(jntciovertimeapplicationselectinput);
		output.setTotalCount(totalCount);
		BLogicResult result = new BLogicResult();
		result.setResultObject(output);
		result.setResultString("success");
		return result;
	}

}
