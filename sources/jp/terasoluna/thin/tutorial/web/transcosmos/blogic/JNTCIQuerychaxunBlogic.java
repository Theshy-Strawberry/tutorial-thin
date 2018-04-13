package jp.terasoluna.thin.tutorial.web.transcosmos.blogic;

import java.util.List;
import jp.terasoluna.fw.dao.QueryDAO;
import jp.terasoluna.fw.dao.UpdateDAO;
import jp.terasoluna.fw.service.thin.BLogic;
import jp.terasoluna.fw.service.thin.BLogicResult;
import jp.terasoluna.thin.tutorial.web.transcosmos.dto.JNTCIQueryInput;
import jp.terasoluna.thin.tutorial.web.transcosmos.dto.JNTCIQueryOut;
import jp.terasoluna.thin.tutorial.web.transcosmos.vo.JNTCIAttendancecardsearch;

public class JNTCIQuerychaxunBlogic implements BLogic<JNTCIQueryInput> {
	private UpdateDAO updateDAO = null;

	public UpdateDAO getUpdateDAO() {
		return updateDAO;
	}

	public void setUpdateDAO(UpdateDAO updateDAO) {
		this.updateDAO = updateDAO;
	}

	private QueryDAO queryDAO = null;

	public void setQueryDAO(QueryDAO queryDAO) {
		this.queryDAO = queryDAO;
	}

	public QueryDAO getQueryDAO() {
		return queryDAO;
	}

	public BLogicResult execute(JNTCIQueryInput param) {
		BLogicResult result = new BLogicResult();
		JNTCIQueryOut output = new JNTCIQueryOut();
		List<JNTCIAttendancecardsearch> jiansuomessage = queryDAO
				.executeForObjectList("search001", param);
		output.setJiansuomessage(jiansuomessage);
		result.setResultObject(output);
		result.setResultString("success");
		return result;
	}
}