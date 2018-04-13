package jp.terasoluna.thin.tutorial.web.transcosmos.blogic;

import java.util.List;

import jp.terasoluna.fw.dao.QueryDAO;
import jp.terasoluna.fw.service.thin.BLogic;
import jp.terasoluna.fw.service.thin.BLogicResult;
import jp.terasoluna.thin.tutorial.web.transcosmos.dto.JNTCIAttendance03Dto;
import jp.terasoluna.thin.tutorial.web.transcosmos.dto.JNTCIOverTimeApplicationSelectInput;
import jp.terasoluna.thin.tutorial.web.transcosmos.dto.JNTCLOvertimeApplicationInput;
import jp.terasoluna.thin.tutorial.web.transcosmos.dto.JNTCLOvertimeApplicationOutput;

public class JNTCIApplicationSelectUserByExtraBLogic implements BLogic<JNTCIOverTimeApplicationSelectInput> {

	private QueryDAO queryDAO = null;

	public QueryDAO getQueryDAO() {
		return queryDAO;
	}

	public void setQueryDAO(QueryDAO queryDAO) {
		this.queryDAO = queryDAO;
	}


	public BLogicResult execute(JNTCIOverTimeApplicationSelectInput param) {
		// TODO �����������ꂽ���\�b�h�E�X�^�u
		JNTCLOvertimeApplicationInput jntciovertimeapplication = queryDAO.executeForObject("selectExtrabyextraid",param, JNTCLOvertimeApplicationInput.class);
		List<JNTCLOvertimeApplicationInput> extralist = queryDAO.executeForObjectList("selectType",1);
		JNTCLOvertimeApplicationOutput output =new JNTCLOvertimeApplicationOutput();

		//審査者list
		List<JNTCIAttendance03Dto> examinePersonList = queryDAO.executeForObjectList("examinePerson", null);
		List<JNTCIAttendance03Dto> detailDateList = queryDAO.executeForObjectList("detailDate1", null);
		int i=0;
		String array[]=new String[detailDateList.size()];
		String aaString=new String();
		//循环遍历节假日列表取出需要的字段
		for (i=0;i<detailDateList.size();i++) {
		   array[i]=detailDateList.get(i).getDetailDate();
		   aaString=array[i]+" "+aaString;
		}
        output.setDetailDate(aaString);
		output.setStartIndex(param.getStartIndex());
		output.setExaminePerson(jntciovertimeapplication.getExaminePerson());
		output.setUser_id(jntciovertimeapplication.getUser_id());
		output.setProject_PM(jntciovertimeapplication.getProject_PM());
		output.setExtra_starttime(jntciovertimeapplication.getExtra_starttime());
		output.setExtra_endtime(jntciovertimeapplication.getExtra_endtime());
		output.setExtra_time(jntciovertimeapplication.getExtra_time());
		output.setExtra_reason(jntciovertimeapplication.getExtra_reason());
		output.setExtra_type(jntciovertimeapplication.getExtra_type());
		output.setCodeId(jntciovertimeapplication.getExtra_type());
		output.setUser_name(jntciovertimeapplication.getUser_name());
		output.setProject(jntciovertimeapplication.getProject());
		output.setDept_code(jntciovertimeapplication.getDept_code());
		output.setExtra_auditss(jntciovertimeapplication.getExtra_auditss());
		output.setExtralist(extralist);
		output.setExtra_reason(jntciovertimeapplication.getExtra_auditss());
		output.setExaminePersonList(examinePersonList);
		output.setExaminePerson(jntciovertimeapplication.getExaminePerson());
        output.setProject_id(jntciovertimeapplication.getProject_id());

		BLogicResult result = new BLogicResult();
		result.setResultObject(output);
		result.setResultString("success");
		return result;
	}

}
