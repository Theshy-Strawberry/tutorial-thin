package jp.terasoluna.thin.tutorial.web.transcosmos.blogic;
import jp.terasoluna.fw.dao.QueryDAO;
import jp.terasoluna.fw.dao.UpdateDAO;
import jp.terasoluna.fw.service.thin.BLogic;
import jp.terasoluna.fw.service.thin.BLogicResult;
import jp.terasoluna.thin.tutorial.web.transcosmos.dto.JNTCLOvertimePostMessage04Input;

public class JNTCIEquipHomePage04ComDelBLogic implements BLogic<JNTCLOvertimePostMessage04Input>{

	private UpdateDAO updateDAO = null;


	public void setUpdateDAO(UpdateDAO updateDAO) {
		this.updateDAO = updateDAO;
	}

	private QueryDAO queryDAO = null;


	public void setQueryDAO(QueryDAO queryDAO) {
		this.queryDAO = queryDAO;
	}

	public BLogicResult execute(JNTCLOvertimePostMessage04Input param) {
		BLogicResult result = new BLogicResult();
		JNTCLOvertimePostMessage04Input input = new JNTCLOvertimePostMessage04Input();

		if ("delete".equals(param.getFlag())) {

			input.setStartIndex1(param.getStartIndex1());

	    	updateDAO.execute("deleteCom", param);
	          result.setResultString("delete");
	          result.setResultObject(input);
		}
		return result;
	}
}
