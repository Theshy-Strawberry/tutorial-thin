package jp.terasoluna.thin.tutorial.web.transcosmos.blogic;

import jp.terasoluna.fw.dao.QueryDAO;
import jp.terasoluna.fw.dao.UpdateDAO;
import jp.terasoluna.fw.service.thin.BLogic;
import jp.terasoluna.fw.service.thin.BLogicResult;
/*import jp.terasoluna.thin.tutorial.web.transcosmos.dto.JNTCIEquipNoticeMgVoInput;*/
import jp.terasoluna.thin.tutorial.web.transcosmos.dto.JNTCLOvertimePostMessage04Input;

public class JNTCIEquipHomePage04DEBLogic implements
		BLogic<JNTCLOvertimePostMessage04Input> {

	private UpdateDAO updateDAO = null;

	public void setUpdateDAO(UpdateDAO updateDAO) {
		this.updateDAO = updateDAO;
	}

	private QueryDAO queryDAO = null;

	public void setQueryDAO(QueryDAO queryDAO) {
		this.queryDAO = queryDAO;
	}

	public BLogicResult execute(JNTCLOvertimePostMessage04Input param) {
		String totalCount = queryDAO.executeForObject("selectInfoCnt", param,
				String.class);
		if (!(totalCount == null || "".equals(totalCount))) {
			updateDAO.execute("DeleteInfo", param);
		}
		BLogicResult result = new BLogicResult();
		result.setResultString("success");
		return result;
	}

}
