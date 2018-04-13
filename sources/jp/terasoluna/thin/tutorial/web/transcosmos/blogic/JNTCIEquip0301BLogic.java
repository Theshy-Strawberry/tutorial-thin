package jp.terasoluna.thin.tutorial.web.transcosmos.blogic;

import java.util.List;

import jp.terasoluna.fw.dao.QueryDAO;
import jp.terasoluna.fw.service.thin.BLogic;
import jp.terasoluna.fw.service.thin.BLogicResult;
import jp.terasoluna.thin.tutorial.web.transcosmos.dto.JNTCIEquip03ListInput;
import jp.terasoluna.thin.tutorial.web.transcosmos.dto.JNTCIEquip03ListOutput;
import jp.terasoluna.thin.tutorial.web.transcosmos.vo.JNTCIEquip02equip;
import jp.terasoluna.thin.tutorial.web.transcosmos.vo.SelectEqipApplyOutput;
import jp.terasoluna.thin.tutorial.web.transcosmos.vo.SelectEquipTypeOutput;

public class JNTCIEquip0301BLogic implements BLogic<JNTCIEquip03ListInput> {
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
		int CF = queryDAO.executeForObject("JNTCIEquip04ChangeStateCount1",param, Integer.class);
		String qufen =queryDAO.executeForObject("JNTCIEquip0301qufen",param, String.class);

if("2".equals(qufen)){
	SelectEqipApplyOutput JNTCIEquip0301 = queryDAO.executeForObject("getEquipapply0301", param, SelectEqipApplyOutput.class);
      if((JNTCIEquip0301.getApply_setsubi_no())!=null){
            param.setApply_setsubi_no(JNTCIEquip0301.getApply_setsubi_no());
            SelectEqipApplyOutput JNTCIshencha0301 = queryDAO.executeForObject("getEquipshencha0301", param, SelectEqipApplyOutput.class);
            SelectEqipApplyOutput JNTCIshebeifanhao0301 = queryDAO.executeForObject("getEquipshebei0301", param, SelectEqipApplyOutput.class);
    		output.setInvestigate_reason(JNTCIshencha0301.getInvestigate_reason());
    		output.setStockNo(JNTCIshebeifanhao0301.getStockNo());
        }else{
        	output.setInvestigate_reason(null);
    		output.setStockNo(null);
        }
		String yu = JNTCIEquip0301.getApply_setsubi_kuben();

		// 检索出设备类名及Id，在判断类名与传进来的类名是否相等，等的话把对应ID赋给传进来的类名字段
		List<SelectEquipTypeOutput> equiptype = queryDAO.executeForObjectList(
				"getEquipType", String.class);
		int a = equiptype.size();
		String s = null;
		for (int i = 0; i < a; i++) {
			s = equiptype.get(i).getAPPLY_SETSUBI_KUBEN();
			if (yu.equals(s)) {
				param.setApply_setsubi_kuben(s);
			}
		}
		List<JNTCIEquip02equip> jNTCIEquip02equip = queryDAO
				.executeForObjectList("getEquipapplynumber1", param);
		JNTCIEquip02equip currentEquip02equip = new JNTCIEquip02equip();
		currentEquip02equip.setEquipID(param.getApply_setsubi_no());
		jNTCIEquip02equip.add(0, currentEquip02equip);
		output.setjNTCIEquip02equip(jNTCIEquip02equip);
		output.setCF(CF);
		output.setShinseiKubun(JNTCIEquip0301.getShinseiKubun());
		output.setApply_user_id(JNTCIEquip0301.getApply_user_id());
		output.setApply_dept_name(JNTCIEquip0301.getApply_dept_name());
		output.setApply_user_name(JNTCIEquip0301.getApply_user_name());
		output.setApply_setsubi_kuben(JNTCIEquip0301.getApply_setsubi_kuben());
		output.setApply_setsubi_no(JNTCIEquip0301.getApply_setsubi_no());
		output.setApply_reason(JNTCIEquip0301.getApply_reason());
		output.setApply_state(JNTCIEquip0301.getApply_state());
		output.setApply_date(JNTCIEquip0301.getApply_date());
		output.setUserId1(param.getUserId1());
		output.setDeptName(param.getDeptName());
		output.setShinsaJyoutai(param.getShinsaJyoutai());
		output.setShinseiStartDate(param.getShinseiStartDate());
		output.setShinseiEndDate(param.getShinseiEndDate());
		output.setStartIndex(param.getStartIndex());
		result.setResultObject(output);
		result.setResultString("shenqing");
		return result;
}else if("3".equals(qufen)){
	SelectEqipApplyOutput  	JNTCIEquip0303 = queryDAO.executeForObject("getEquipapplyRepair0303", param, SelectEqipApplyOutput.class);
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
	output.setUserId1(param.getUserId1());
	output.setDeptName(param.getDeptName());
	output.setShinsaJyoutai(param.getShinsaJyoutai());
	output.setShinseiStartDate(param.getShinseiStartDate());
	output.setShinseiEndDate(param.getShinseiEndDate());
	output.setStartIndex(param.getStartIndex());
	result.setResultObject(output);
	result.setResultString("xiuli");
	return result;
}else if("4".equals(qufen)){
	SelectEqipApplyOutput  	JNTCIEquip0303 = queryDAO.executeForObject("getEquipapplyRepair0303", param, SelectEqipApplyOutput.class);
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
	output.setUserId1(param.getUserId1());
	output.setDeptName(param.getDeptName());
	output.setShinsaJyoutai(param.getShinsaJyoutai());
	output.setShinseiStartDate(param.getShinseiStartDate());
	output.setShinseiEndDate(param.getShinseiEndDate());
	output.setStartIndex(param.getStartIndex());
	result.setResultObject(output);
	result.setResultString("fanhuan");
	return result;
}else if("5".equals(qufen)){
	SelectEqipApplyOutput JNTCIEquip0301 = queryDAO.executeForObject(
			"getEquipapply0304", param, SelectEqipApplyOutput.class);
	SelectEqipApplyOutput JNTCIshencha0301 = queryDAO.executeForObject(
			"getEquipshencha0301", param, SelectEqipApplyOutput.class);
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
	output.setUserId1(param.getUserId1());
	output.setDeptName(param.getDeptName());
	output.setShinsaJyoutai(param.getShinsaJyoutai());
	output.setShinseiStartDate(param.getShinseiStartDate());
	output.setShinseiEndDate(param.getShinseiEndDate());
	output.setStartIndex(param.getStartIndex());
	result.setResultObject(output);
	result.setResultString("gouru");
	return result;
}else{}
		// Equip04 検索条件の保持
return result;
	}

}
