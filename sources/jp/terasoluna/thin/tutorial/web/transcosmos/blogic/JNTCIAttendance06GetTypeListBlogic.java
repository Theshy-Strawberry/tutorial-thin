package jp.terasoluna.thin.tutorial.web.transcosmos.blogic;

import java.util.List;

import jp.terasoluna.fw.dao.QueryDAO;
import jp.terasoluna.fw.service.thin.BLogic;
import jp.terasoluna.fw.service.thin.BLogicResult;
import jp.terasoluna.thin.tutorial.web.transcosmos.dto.Attendance06SelectRecOutput;
import jp.terasoluna.thin.tutorial.web.transcosmos.dto.JNTCIAttendance06GetTypeListDto;
import jp.terasoluna.thin.tutorial.web.transcosmos.dto.JNTCIAttendance06Input;

public class JNTCIAttendance06GetTypeListBlogic implements BLogic<JNTCIAttendance06Input> {
	private QueryDAO queryDAO = null;

	public void setQueryDAO(QueryDAO queryDAO) {
		this.queryDAO = queryDAO;
	}

	public BLogicResult execute(JNTCIAttendance06Input param) {
		//プルダウンフレームの値を得る
		List<JNTCIAttendance06GetTypeListDto> attendance06SelectRecOutput = queryDAO.executeForObjectList("getTypeList", 1);
		List<JNTCIAttendance06GetTypeListDto> attendance06SelectRecOutput02 = queryDAO.executeForObjectList("getTypeList02", 1);
		Attendance06SelectRecOutput output = new Attendance06SelectRecOutput();
		output.setAttendance06SelectRecOutput(attendance06SelectRecOutput);
		output.setAttendance06SelectRecOutput02(attendance06SelectRecOutput02);
		output.setUser_id(param.getUser_id());
		output.setUser_name(param.getUser_name());
		output.setDept_id(param.getDept_id());
		output.setLeader(param.getLeader());
		output.setUser_id(param.getUser_id());
		output.setSub_time(param.getSub_time());
        output.setFileName(param.getFileName());
		output.setUser_id(param.getUser_id());
		output.setSub_time(param.getSub_time());
		output.setUpdateQuFen(param.getUpdateQuFen());
		BLogicResult result = new BLogicResult();
		int update = param.getUpdateQuFen();
		if(update == 1){
			Attendance06SelectRecOutput attendance06DeletOutput =
					queryDAO.executeForObject("SelectUpdateAttendance05", param,Attendance06SelectRecOutput.class);
			output.setStart_time_add(attendance06DeletOutput.getStart_time_add());
			output.setEnd_time_add(attendance06DeletOutput.getEnd_time_add());
			output.setRetroactive_reason(attendance06DeletOutput.getRetroactive_reason());   //理由
			output.setRetroactive_type(attendance06DeletOutput.getRetroactive_type());      //???型
			//output.setReason_type(attendance06DeletOutput.getReason_type());         //公用、私用
			output.setRetroactive_id(attendance06DeletOutput.getRetroactive_id());
			output.setTypecode1(attendance06DeletOutput.getReason_type());
			output.setTypecode2(attendance06DeletOutput.getRetroactive_type());
			output.setFileName(attendance06DeletOutput.getFileName());
			output.setUpdateQuFen(0);
		}else{

		//判断delete_flag値があるかどうか
		if(param.getDelete_flag()==null||param.getDelete_flag()==""){

			output.setRetroactive_type_keepval(param.getRetroactive_type());
			output.setStart_time_add(param.getStart_time_add());
			output.setEnd_time_add(param.getEnd_time_add());
			output.setRetroactive_reason(param.getRetroactive_reason());
		}else{
			output.setDelete_flag(null);
		}

		output.setTypecode1(param.getReason_type());
		output.setTypecode2(param.getRetroactive_type());
		}
		result.setResultObject(output);
		result.setResultString("success");
		return result;
	}

}
