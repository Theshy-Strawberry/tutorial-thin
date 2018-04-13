package jp.terasoluna.thin.tutorial.web.transcosmos.blogic;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import jp.terasoluna.fw.dao.QueryDAO;
import jp.terasoluna.fw.service.thin.BLogic;
import jp.terasoluna.fw.service.thin.BLogicResult;
import jp.terasoluna.thin.tutorial.web.transcosmos.dto.JNTCIAttendance03Dto;
import jp.terasoluna.thin.tutorial.web.transcosmos.dto.JNTCIAttendanceSelect03Dto;

public class JNTCIAttendanceUpdate03LeaveIDBlogic implements BLogic<JNTCIAttendanceSelect03Dto>{

	 private QueryDAO queryDAO = null;
	 public void setQueryDAO(QueryDAO queryDAO) {
		this.queryDAO = queryDAO;
	 }

	public BLogicResult execute(JNTCIAttendanceSelect03Dto param) {

		JNTCIAttendanceSelect03Dto attendance = queryDAO.executeForObject("updateLeaveId", param, JNTCIAttendanceSelect03Dto.class);
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		try {
			Date date1 = formatter.parse(attendance.getLeaveStartTime());
			Date date2 = formatter.parse(attendance.getLeaveEndTime());
			attendance.setLeaveStartTime(formatter.format(date1));
			attendance.setLeaveEndTime(formatter.format(date2));
		} catch (ParseException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		attendance.setLeaveCode(attendance.getLeaveType());
		String JN_CARD = param.getJnCard();
		// 休むをタイプ(List)
		List<JNTCIAttendance03Dto> leaveTypeList = queryDAO.executeForObjectList("leaveType",null);

		// 年休の余剰日数
		Double remainDays = queryDAO.executeForObject("remainDays", JN_CARD, Double.class);
		if(remainDays == null){
			remainDays = 0.0;
		}

		attendance.setLeaveTypeList(leaveTypeList);

		JNTCIAttendanceSelect03Dto deptDto = queryDAO.executeForObject("deptLeaveID", param, JNTCIAttendanceSelect03Dto.class);
		attendance.setDeptName(deptDto.getDeptName());
		attendance.setDeptId(deptDto.getDeptId());
		attendance.setPreserVation("preservation");
		BLogicResult result = new BLogicResult();
		result.setResultObject(attendance);
		result.setResultString("success");

		return result;
	}
}
