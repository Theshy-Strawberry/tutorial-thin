package jp.terasoluna.thin.tutorial.web.transcosmos.blogic;

import java.util.List;

import jp.terasoluna.fw.dao.QueryDAO;
import jp.terasoluna.fw.dao.UpdateDAO;
import jp.terasoluna.fw.service.thin.BLogic;
import jp.terasoluna.fw.service.thin.BLogicResult;
import jp.terasoluna.thin.tutorial.web.transcosmos.dto.JNTCIIntelligenceInput;
import jp.terasoluna.thin.tutorial.web.transcosmos.dto.JNTCIIntelligenceOut;
import jp.terasoluna.thin.tutorial.web.transcosmos.vo.JNTCIIntelligenceVo;


public class JNTCIIntelligenceBLogic  implements BLogic<JNTCIIntelligenceInput>{
	private QueryDAO queryDAO = null;
	private UpdateDAO updateDAO = null;

	public void setUpdateDAO(UpdateDAO updateDAO) {
		this.updateDAO = updateDAO;
	}

	  public void setQueryDAO(QueryDAO queryDAO) {
	        this.queryDAO = queryDAO;
	    }


	public BLogicResult execute(JNTCIIntelligenceInput arg0) {
		List<JNTCIIntelligenceVo> deptListName = queryDAO.executeForObjectList("getDeptNameListA", String.class);
		//bu men fu ze ren
		List<JNTCIIntelligenceVo> kubunListName = queryDAO.executeForObjectList("getkubunList", String.class);
		//zhijie fu ze ren
		List<JNTCIIntelligenceVo> personListName = queryDAO.executeForObjectList("personList", String.class);
		//xiang mu ming bian geng
		List<JNTCIIntelligenceVo> entryListName = queryDAO.executeForObjectList("entryList", String.class);

		List<JNTCIIntelligenceVo> userIdList = queryDAO.executeForObjectList("USERIdList",arg0.getUserId());

		JNTCIIntelligenceOut deptList=new JNTCIIntelligenceOut();
		deptList.setUpdateUser(deptListName);
		deptList.setKubunList(kubunListName);
		deptList.setPersonList(personListName);
		deptList.setEntryName(entryListName);
		deptList.setUserIdList(userIdList);
		deptList.setDeptName(arg0.getDept_id());
		deptList.setDepartmentName(arg0.getKu_id());
		deptList.setDirectName(arg0.getPer_id());
		deptList.setProjectName(arg0.getEntry_id());
		updateDAO.execute("userUpdate", arg0);
		BLogicResult result=new BLogicResult();
		result.setResultObject(deptList);
		result.setResultString("success");
		return result;
	}



}
