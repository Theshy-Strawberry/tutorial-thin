package jp.terasoluna.thin.tutorial.web.transcosmos.blogic;
import jp.terasoluna.fw.dao.QueryDAO;
import jp.terasoluna.fw.service.thin.BLogic;
import jp.terasoluna.fw.service.thin.BLogicResult;
import jp.terasoluna.thin.tutorial.web.transcosmos.dto.JNTCIEquip03ListInput;
import jp.terasoluna.thin.tutorial.web.transcosmos.dto.JNTCIEquip03ListOutput;
import jp.terasoluna.thin.tutorial.web.transcosmos.vo.SelectEqipApplyOutput;
public class JNTCIEquip0307BLogic implements BLogic<JNTCIEquip03ListInput> {
	private QueryDAO queryDAO = null;
	BLogicResult result = new BLogicResult();
	JNTCIEquip03ListOutput output = new JNTCIEquip03ListOutput();

	public QueryDAO getQueryDAO() {
		return queryDAO;
	}

	public void setQueryDAO(QueryDAO queryDAO) {
		this.queryDAO = queryDAO;
	}

	public BLogicResult execute(JNTCIEquip03ListInput param) {
		param.setApply_no(param.getApply_no().trim());
		SelectEqipApplyOutput JNTCIEquip0301 = queryDAO.executeForObject(
				"getEquipapply0304", param, SelectEqipApplyOutput.class);
		SelectEqipApplyOutput JNTCIshencha0301 = queryDAO.executeForObject(
				"getEquipshencha0301", param, SelectEqipApplyOutput.class);

		int CF = queryDAO.executeForObject("JNTCIEquip04ChangeStateCount1",
				param, Integer.class);
		output.setInvestigate_reason(JNTCIshencha0301.getInvestigate_reason());
		output.setCF(CF);
		output.setShinseiKubun(JNTCIEquip0301.getShinseiKubun());
		output.setApply_user_id(JNTCIEquip0301.getApply_user_id());
		output.setApply_dept_name(JNTCIEquip0301.getApply_dept_name());
		output.setApply_user_name(JNTCIEquip0301.getApply_user_name());
		output.setApply_setsubi_kuben(JNTCIEquip0301.getApply_setsubi_kuben());
		output.setApply_reason(JNTCIEquip0301.getApply_reason());
		output.setApply_state(JNTCIEquip0301.getApply_state());
		output.setApply_date(JNTCIEquip0301.getApply_date());
		output.setApply_setsubi_number(JNTCIEquip0301.getApply_setsubi_number());
		result.setResultObject(output);
		result.setResultString("success");

		return result;
	}

}
