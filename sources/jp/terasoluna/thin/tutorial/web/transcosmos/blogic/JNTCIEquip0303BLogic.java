package jp.terasoluna.thin.tutorial.web.transcosmos.blogic;


import jp.terasoluna.fw.dao.QueryDAO;
import jp.terasoluna.fw.service.thin.BLogic;
import jp.terasoluna.fw.service.thin.BLogicResult;
import jp.terasoluna.thin.tutorial.web.transcosmos.dto.JNTCIEquip03ListInput;
import jp.terasoluna.thin.tutorial.web.transcosmos.dto.JNTCIEquip03ListOutput;
import jp.terasoluna.thin.tutorial.web.transcosmos.vo.SelectEqipApplyOutput;

public class JNTCIEquip0303BLogic implements BLogic<JNTCIEquip03ListInput> {
	private QueryDAO queryDAO = null;

	public QueryDAO getQueryDAO() {
		return queryDAO;
	}

	public void setQueryDAO(QueryDAO queryDAO) {
		this.queryDAO = queryDAO;
	}

	public BLogicResult execute(JNTCIEquip03ListInput param){
		int CF=queryDAO.executeForObject("JNTCIEquip04ChangeStateCount1",
				param,Integer.class);
		param.setApply_no(param.getApply_no().trim());
		SelectEqipApplyOutput  	JNTCIEquip0303 = queryDAO.executeForObject("getEquipapplyRepair0303", param, SelectEqipApplyOutput.class);
		BLogicResult result = new BLogicResult();
		JNTCIEquip03ListOutput output = new JNTCIEquip03ListOutput();
		output.setCF(CF);
		output.setShinseiKubun(JNTCIEquip0303.getShinseiKubun());
		output.setApply_date(JNTCIEquip0303.getApply_date());
		output.setApply_user_id(JNTCIEquip0303.getApply_user_id());
		output.setApply_dept_name(JNTCIEquip0303.getApply_dept_name());
		output.setApply_user_name(JNTCIEquip0303.getApply_user_name());
		output.setApply_setsubi_kuben(JNTCIEquip0303.getApply_setsubi_kuben());
		output.setApply_setsubi_no(JNTCIEquip0303.getApply_setsubi_no());
		output.setApply_reason(JNTCIEquip0303.getApply_reason());
		output.setApply_state(JNTCIEquip0303.getApply_state());
		result.setResultObject(output);
		result.setResultString("success");

		return result;






	}

}
