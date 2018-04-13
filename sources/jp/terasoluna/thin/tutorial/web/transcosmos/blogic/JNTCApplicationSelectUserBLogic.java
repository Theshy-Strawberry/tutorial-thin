package jp.terasoluna.thin.tutorial.web.transcosmos.blogic;

import java.util.List;

import jp.terasoluna.fw.dao.QueryDAO;
import jp.terasoluna.fw.service.thin.BLogic;
import jp.terasoluna.fw.service.thin.BLogicResult;
import jp.terasoluna.thin.tutorial.web.transcosmos.dto.JNTCIAttendance03Dto;
import jp.terasoluna.thin.tutorial.web.transcosmos.dto.JNTCLOvertimeApplicationInput;
import jp.terasoluna.thin.tutorial.web.transcosmos.dto.JNTCLOvertimeApplicationOutput;

public class JNTCApplicationSelectUserBLogic implements
        BLogic<JNTCLOvertimeApplicationInput> {

    private QueryDAO queryDAO = null;

    public QueryDAO getQueryDAO() {
        return queryDAO;
    }

    public void setQueryDAO(QueryDAO queryDAO) {
        this.queryDAO = queryDAO;
    }

    public BLogicResult execute(JNTCLOvertimeApplicationInput param) {

        String ID = param.getUser_id();
        JNTCLOvertimeApplicationInput applicationInput = queryDAO
                .executeForObject("selectUser", ID,
                        JNTCLOvertimeApplicationInput.class);

        String dept_id = applicationInput.getDept_id();
        String selectDept = queryDAO.executeForObject("selectDept", dept_id,
                String.class);
        /*String project_id = applicationInput.getProject();
        String project_Name = queryDAO.executeForObject("selectProject_Name",
                project_id, String.class);*/
        String project_id = applicationInput.getProject_id();
        String project= applicationInput.getProject();

        List<JNTCLOvertimeApplicationInput> extralist = queryDAO
                .executeForObjectList("selectType", 1);

        // 審査者list
        List<JNTCIAttendance03Dto> examinePersonList = queryDAO
                .executeForObjectList("examinePerson", null);
    	List<JNTCIAttendance03Dto> detailDateList = queryDAO.executeForObjectList("detailDate1", null);
		int i=0;
		String array[]=new String[detailDateList.size()];
		String aaString=new String();
		//循环遍历节假日列表取出需要的字段
		for (i=0;i<detailDateList.size();i++) {
		   array[i]=detailDateList.get(i).getDetailDate();
		   aaString=array[i]+" "+aaString;
		}

        JNTCLOvertimeApplicationOutput output = new JNTCLOvertimeApplicationOutput();
        output.setDetailDate(aaString);
        output.setProject_id(project_id);
        output.setUser_id(applicationInput.getUser_id());
        output.setUser_name(applicationInput.getUser_name());
        output.setDept_code(dept_id);
        output.setProject_PM(applicationInput.getProject_PM());
        output.setProject(project);
        output.setDept_id(selectDept);
        output.setExtralist(extralist);
        output.setExaminePersonList(examinePersonList);
        output.setExtra_type(param.getExtra_type());
        output.setCodeId(param.getExtra_type());
        output.setExtra_beiZhu(param.getExtra_reason());
        output.setExtra_starttime(param.getExtra_starttime());
        output.setExtra_endtime(param.getExtra_endtime());
        BLogicResult result = new BLogicResult();
        result.setResultObject(output);
        result.setResultString("success");

        return result;
    }

}
