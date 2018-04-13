package jp.terasoluna.thin.tutorial.web.transcosmos.blogic;

import java.util.LinkedList;
import java.util.List;

import org.apache.struts.util.LabelValueBean;

import jp.terasoluna.fw.dao.QueryDAO;
import jp.terasoluna.fw.service.thin.BLogic;
import jp.terasoluna.fw.service.thin.BLogicResult;
import jp.terasoluna.thin.tutorial.web.transcosmos.dto.JNTCIEquipListInput;
import jp.terasoluna.thin.tutorial.web.transcosmos.dto.JNTCIEquipListOutput;
import jp.terasoluna.thin.tutorial.web.transcosmos.vo.SelectDeptName;

public class JNTCIEquipListCodeBLogic implements BLogic<JNTCIEquipListInput> {

	private QueryDAO queryDAO = null;

	public QueryDAO getQueryDAO() {
		return queryDAO;
	}

	public void setQueryDAO(QueryDAO queryDAO) {
		this.queryDAO = queryDAO;
	}
	private String nvl(Object object ){
		return object == null?"":(String)object;
	}
	public BLogicResult execute(JNTCIEquipListInput param) {
		BLogicResult result = new BLogicResult();

		List<SelectDeptName> codes = queryDAO.executeForObjectList(
				"SelectCode", null);

		LinkedList<LabelValueBean> codeList = new LinkedList<LabelValueBean>();
		String flag = param.getFlag();
		if ("1".equals(flag)) {
			for (SelectDeptName code : codes) {
				codeList.add(new LabelValueBean(code.getCODE(), code.getCODE()));
			}
		} else {
			for (int i = 0; i < codes.size(); i++) {
				if (!("設備状態照会".equals(codes.get(i).getCODE()))) {
					codes.remove(i);
					i--;
				}
			}
		}

		List<SelectDeptName> deptNames = queryDAO.executeForObjectList(
				"SelectDeptNames", null);

		SelectDeptName selectDeptName = new SelectDeptName();
		selectDeptName.setAPPLY_DEPT_ID("");
		selectDeptName.setAPPLY_DEPT_NAME("");
		deptNames.add(0, selectDeptName);

		LinkedList<LabelValueBean> deptList = new LinkedList<LabelValueBean>();

		for (SelectDeptName dept : deptNames) {
			deptList.add(new LabelValueBean(dept.getAPPLY_DEPT_NAME(), dept
					.getAPPLY_DEPT_ID()));
		}

		JNTCIEquipListOutput output = new JNTCIEquipListOutput();
		output.setCode(nvl(param.getCode()));
		output.setUserId(nvl(param.getUserId()));
		result.setResultObject(output);
		result.setResultString("success");
		return result;
	}

}
