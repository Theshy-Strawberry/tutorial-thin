package jp.terasoluna.thin.tutorial.web.transcosmos.blogic;

import java.util.List;

import jp.terasoluna.fw.dao.QueryDAO;
import jp.terasoluna.fw.dao.UpdateDAO;
import jp.terasoluna.fw.service.thin.BLogic;
import jp.terasoluna.fw.service.thin.BLogicResult;
import jp.terasoluna.thin.tutorial.web.transcosmos.dto.JNTCIEquip02Input;
import jp.terasoluna.thin.tutorial.web.transcosmos.dto.JNTCIEquip02Output;
import jp.terasoluna.thin.tutorial.web.transcosmos.vo.JNTCIEquip02dept;
import jp.terasoluna.thin.tutorial.web.transcosmos.vo.JNTCIEquip02equipType;
import jp.terasoluna.thin.tutorial.web.transcosmos.vo.JNTCIEquip02equip;

public class JNTCIEquip02ListBLogic implements BLogic<JNTCIEquip02Input>{
	private QueryDAO queryDAO = null;
	private UpdateDAO updateDAO = null;





	public UpdateDAO getUpdateDAO() {
		return updateDAO;
	}





	public void setUpdateDAO(UpdateDAO updateDAO) {
		this.updateDAO = updateDAO;
	}





	public QueryDAO getQueryDAO() {
		return queryDAO;
	}





	public void setQueryDAO(QueryDAO queryDAO) {
		this.queryDAO = queryDAO;
	}



	public BLogicResult execute(JNTCIEquip02Input param){
		BLogicResult result = new BLogicResult();
		String JN_CARD = param.getUserId();
		JNTCIEquip02dept dept = queryDAO.executeForObject("getDeptJNTCIEquip02", JN_CARD, JNTCIEquip02dept.class);

        List<JNTCIEquip02equipType> jNTCIEquip02equipType
        = queryDAO.executeForObjectList("getEquipTypeJNTCIEquip02",null);
        JNTCIEquip02equipType ET=new JNTCIEquip02equipType();
		ET.setEquipTypeID("");
		ET.setEquipTypeName("");
		jNTCIEquip02equipType.add(0, ET);

        String typeTemp =null;
        if(null != jNTCIEquip02equipType){
        	typeTemp = jNTCIEquip02equipType.get(0).getEquipTypeID();
        }
        JNTCIEquip02Input typeInput = new JNTCIEquip02Input();
        typeInput.setTypeTemp(typeTemp);
        List<JNTCIEquip02equip> jNTCIEquip02equip
        = queryDAO.executeForObjectList("getEquipJNTCIEquip02",typeInput);

        JNTCIEquip02Output output = new JNTCIEquip02Output();
        String nil="66";
        output.setNil(nil);
        output.setId(JN_CARD);
        output.setName(param.getUserName());
        output.setDept(dept.getDept());
        output.setDeptName(dept.getDeptName());
        output.setEquipList(jNTCIEquip02equip);
        output.setEquipTypeList(jNTCIEquip02equipType);
        result.setResultObject(output);
		result.setResultString("success");
		return result;
	}





}
