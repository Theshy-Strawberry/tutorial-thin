package jp.terasoluna.thin.tutorial.web.transcosmos.blogic;

import java.util.List;

import jp.terasoluna.fw.dao.QueryDAO;
import jp.terasoluna.fw.dao.UpdateDAO;
import jp.terasoluna.fw.service.thin.BLogic;
import jp.terasoluna.fw.service.thin.BLogicResult;
import jp.terasoluna.thin.tutorial.web.transcosmos.dto.JNTCIEquip02Input;
import jp.terasoluna.thin.tutorial.web.transcosmos.dto.JNTCIEquip02name;
import jp.terasoluna.thin.tutorial.web.transcosmos.vo.JNTCIEquip02dept;
import jp.terasoluna.thin.tutorial.web.transcosmos.vo.JNTCIEquip02equip;
import jp.terasoluna.thin.tutorial.web.transcosmos.vo.JNTCIEquip02equipType;

public class JNTCIEquip02displayBLogic implements BLogic<JNTCIEquip02Input> {
	private QueryDAO queryDAO = null;
	private UpdateDAO updateDAO = null;

	public QueryDAO getQueryDAO() {
		return queryDAO;
	}

	public void setQueryDAO(QueryDAO queryDAO) {
		this.queryDAO = queryDAO;
	}

	public UpdateDAO getUpdateDAO() {
		return updateDAO;
	}

	public void setUpdateDAO(UpdateDAO updateDAO) {
		this.updateDAO = updateDAO;
	}

	public BLogicResult execute(JNTCIEquip02Input param) {
		BLogicResult result = new BLogicResult();



			List<JNTCIEquip02equipType> jNTCIEquip02equipType = queryDAO
					.executeForObjectList("getEquipTypeJNTCIEquip02", null);
			JNTCIEquip02equipType ET=new JNTCIEquip02equipType();
			ET.setEquipTypeID("");
			ET.setEquipTypeName("");
			jNTCIEquip02equipType.add(0, ET);

			String code=param.getCodeTemp();
			List<JNTCIEquip02equip> jNTCIEquip02equip=null;
			if("0".equals(code)){
			 jNTCIEquip02equip = queryDAO
					.executeForObjectList("getEquipJNTCIEquip02", param);
			}else if("1".equals(code)){
				param.setHoyusha(param.getUserName());
				jNTCIEquip02equip = queryDAO
						.executeForObjectList("getEquipJNTCIEquip04", param);
			}else{
				jNTCIEquip02equip = queryDAO
						.executeForObjectList("getEquipJNTCIBack", param);
			}
			JNTCIEquip02equip EQ=new JNTCIEquip02equip();
			EQ.setEquipID("");
			EQ.setEquipName("");
			jNTCIEquip02equip.add(0, EQ);

			String JN_CARD = param.getUserId();
			JNTCIEquip02dept dept = queryDAO.executeForObject("getDeptJNTCIEquip02", JN_CARD, JNTCIEquip02dept.class);
			JNTCIEquip02name output = new JNTCIEquip02name();
			output.setName(param.getUserName());
			output.setDept(dept.getDept());
			output.setDeptName(dept.getDeptName());

			output.setId(JN_CARD);
			output.setEquipTemp(param.getEquipTemp());
			output.setCodeTemp(param.getCodeTemp());
			output.setReasonTemp(param.getReasonTemp());
			output.setTypeTemp(param.getTypeTemp());
	        output.setEquipList(jNTCIEquip02equip);
	        output.setEquipTypeList(jNTCIEquip02equipType);
			result.setResultObject(output);
			result.setResultString("success");

		return result;
	}

}
