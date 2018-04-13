package jp.terasoluna.thin.tutorial.web.transcosmos.blogic;

import java.util.List;

import jp.terasoluna.fw.dao.QueryDAO;
import jp.terasoluna.fw.service.thin.BLogic;
import jp.terasoluna.fw.service.thin.BLogicResult;
import jp.terasoluna.thin.tutorial.web.transcosmos.dto.Attendance06SelectRecOutput;
import jp.terasoluna.thin.tutorial.web.transcosmos.dto.JNTCIAttendance06Input;

public class JNTCIAttendance06QueryBlogic implements
		BLogic<JNTCIAttendance06Input> {
	private QueryDAO queryDAO = null;
	public void setQueryDAO(QueryDAO queryDAO) {
		this.queryDAO = queryDAO;
	}
	public BLogicResult execute(JNTCIAttendance06Input param) {
		String strIndex = param.getStartIndex();
		String strRow = param.getRow();
		int startIndex = 0;
		int row = 10;
		if (strIndex != null) {
			startIndex = Integer.parseInt(strIndex);
		}
		if (strRow != null) {
			row = Integer.parseInt(strRow);
		}
		// 一覧件数取得
		String totalCount = queryDAO.executeForObject(
				"getJNTCIAttendance05selectCount", param, String.class);
		// 一覧データ取得
		List<JNTCIAttendance06Input> jntciAttendance05selectInfo = queryDAO.executeForObjectList("getJNTCIAttendance05select", param,startIndex, row);
		Attendance06SelectRecOutput output = new Attendance06SelectRecOutput();
		output.setAttendance06ListOutput(jntciAttendance05selectInfo);
		output.setTotalCount(totalCount);
		//output.setUser_id(param.getUser_id());
		//output.setUser_name(param.getUser_name());
		//output.setDept_id(param.getDept_id());
		//output.setLeader(param.getLeader());
		output.setDelete_flag(param.getDelete_flag());
		output.setRetroactive_type(param.getRetroactive_type());
		output.setEnd_time_add(param.getEnd_time_add());
		output.setStart_time_add(param.getStart_time_add());
		output.setRetroactive_reason(param.getRetroactive_reason());
		output.setReason_type(param.getReason_type());
		output.setUser_id(param.getUser_id());
		output.setSub_time(param.getSub_time());
		output.setUpdateQuFen(param.getUpdateQuFen());
        output.setFileName(param.getFileName());
		BLogicResult result = new BLogicResult();
		//
		String user_id = param.getUser_id();
 		Attendance06SelectRecOutput attendance06SelectRecOutput = queryDAO.executeForObject("getUserInfoforAttendance05", user_id,Attendance06SelectRecOutput.class);
        String user_name= attendance06SelectRecOutput.getUser_name();
        String dept_id = attendance06SelectRecOutput.getDept_id();
        String leader = attendance06SelectRecOutput.getLeader();
        String dept_name = queryDAO.executeForObject("getDeptnameforAttendance05", dept_id,String.class);

		output.setUser_id(user_id);
		output.setUser_name(user_name);
        output.setLeader(leader);
        output.setDept_id(dept_name);
        output.setDept_id_hide(dept_id);



        //
		result.setResultObject(output);
		result.setResultString("success");
		return result;
	}

}
