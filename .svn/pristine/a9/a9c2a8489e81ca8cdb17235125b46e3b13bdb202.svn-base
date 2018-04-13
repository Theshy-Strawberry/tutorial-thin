package jp.terasoluna.thin.tutorial.web.transcosmos.blogic;

import java.util.List;
import jp.terasoluna.fw.dao.QueryDAO;
import jp.terasoluna.fw.service.thin.BLogic;
import jp.terasoluna.fw.service.thin.BLogicResult;
import jp.terasoluna.thin.tutorial.web.transcosmos.dto.JNTCIEquip03ListInput;
import jp.terasoluna.thin.tutorial.web.transcosmos.dto.JNTCIEquip03ListOutput;
import jp.terasoluna.thin.tutorial.web.transcosmos.vo.SelectEqipApplyOutput;

public class JNTCIEquip03ListBLogic implements BLogic<JNTCIEquip03ListInput> {
	/**
	 * ���O�I���������s��
	 */
	private QueryDAO queryDAO = null;

	public QueryDAO getQueryDAO() {
		return queryDAO;
	}

	public void setQueryDAO(QueryDAO queryDAO) {
		this.queryDAO = queryDAO;
	}

	public BLogicResult execute(JNTCIEquip03ListInput param) {

		String strIndex = param.getStartIndex();
		String strRow = param.getRow();

		int startIndex = 0;
		int row = 8;
		if (strIndex != null) {
			startIndex = Integer.parseInt(strIndex);

		}

		if (strRow != null) {
			row = Integer.parseInt(strRow);
		}
		//getEquipapply
		String totalCount = queryDAO.executeForObject("getEquipapplyCount",
				param, String.class);
		List<SelectEqipApplyOutput> eqipApply = queryDAO.executeForObjectList(
				"getEquipApply", param, startIndex, row);
		JNTCIEquip03ListOutput output = new JNTCIEquip03ListOutput();
		output.setEqipApply(eqipApply);
		output.setTotalCount(totalCount);

		BLogicResult result = new BLogicResult();
		result.setResultObject(output);
		result.setResultString("success");
		return result;

	}

}
