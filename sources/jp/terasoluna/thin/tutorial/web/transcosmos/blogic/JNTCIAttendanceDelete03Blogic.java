package jp.terasoluna.thin.tutorial.web.transcosmos.blogic;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jp.terasoluna.fw.dao.QueryDAO;
import jp.terasoluna.fw.dao.UpdateDAO;
import jp.terasoluna.fw.service.thin.BLogic;
import jp.terasoluna.fw.service.thin.BLogicMessage;
import jp.terasoluna.fw.service.thin.BLogicMessages;
import jp.terasoluna.fw.service.thin.BLogicResult;
import jp.terasoluna.thin.tutorial.web.transcosmos.dto.JNTCIAttendance03Dto;
import jp.terasoluna.thin.tutorial.web.transcosmos.dto.JNTCIAttendanceSelect03Dto;

public class JNTCIAttendanceDelete03Blogic implements BLogic<JNTCIAttendanceSelect03Dto>{
	private UpdateDAO updateDAO;
	private QueryDAO queryDAO;
	public QueryDAO getQueryDAO() {
		return queryDAO;
	}
	public void setQueryDAO(QueryDAO queryDAO) {
		this.queryDAO = queryDAO;
	}
	public void setUpdateDAO(UpdateDAO updateDAO) {
		this.updateDAO = updateDAO;
	}
	public UpdateDAO getUpdateDAO() {
		return updateDAO;
	}
	public BLogicResult execute(JNTCIAttendanceSelect03Dto param) {
		String update = param.getUpdateQuFen();
		String JN_CARD = param.getJnCard();
		JNTCIAttendance03Dto attendance = queryDAO.executeForObject("leave", JN_CARD, JNTCIAttendance03Dto.class);
		List<JNTCIAttendance03Dto> leaveTypeList = new ArrayList<JNTCIAttendance03Dto>();
		//获取数据库中的节假日列表
		List<JNTCIAttendance03Dto> detailDateList = queryDAO.executeForObjectList("detailDate", null);
		int i=0;
		String array[]=new String[detailDateList.size()];
		String aaString=new String();
		//循环遍历节假日列表取出需要的字段
		for (i=0;i<detailDateList.size();i++) {
		   array[i]=detailDateList.get(i).getDetailDate();
		   aaString=array[i]+" "+aaString;
		}

		if("Update".equals(update)){
			JNTCIAttendanceSelect03Dto attendanceSelect = queryDAO.executeForObject("updateLeaveId", param, JNTCIAttendanceSelect03Dto.class);
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");
			try {
				Date date1 = formatter.parse(attendanceSelect.getLeaveStartTime());
				Date date2 = formatter.parse(attendanceSelect.getLeaveEndTime());
				attendanceSelect.setLeaveStartTime(formatter.format(date1));
				attendanceSelect.setLeaveEndTime(formatter.format(date2));
				attendanceSelect.setDetailDate(aaString);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			attendance.setDetailDate(aaString);
			attendanceSelect.setLeaveCode(attendanceSelect.getLeaveType());

			// 休むをタイプ(List)
			leaveTypeList = queryDAO.executeForObjectList("leaveType",null);

			// 年休の余剰日数
			Double remainDays = queryDAO.executeForObject("remainDays", JN_CARD, Double.class);
			if(remainDays == null){
				remainDays = 0.0;
			}

			attendanceSelect.setLeaveTypeList(leaveTypeList);

			JNTCIAttendanceSelect03Dto deptDto = queryDAO.executeForObject("deptLeaveID", param, JNTCIAttendanceSelect03Dto.class);
			attendanceSelect.setDeptName(deptDto.getDeptName());
			attendanceSelect.setDeptId(deptDto.getDeptId());
			attendanceSelect.setPreserVation("preservation");
			attendanceSelect.setDetailDate(aaString);
			BLogicResult result = new BLogicResult();
			result.setResultObject(attendanceSelect);

			result.setResultString("success");

			return result;
		}else{
			updateDAO.execute("deleteLeave1", param);
			updateDAO.execute("deleteLeave2", param);
		}

			// SELECT 個人情報
			attendance = queryDAO.executeForObject("leave", JN_CARD,
					JNTCIAttendance03Dto.class);
			// IF 部門はNULL?
			if(attendance != null && attendance.deptId != null){
			}else{
				JNTCIAttendance03Dto attendanceDto =  queryDAO.executeForObject("selectdeptID", JN_CARD,
						JNTCIAttendance03Dto.class);
				attendance.setDetailDate(aaString);
				attendance.setDeptId(attendanceDto.getDeptId());
				attendance.setDeptName(attendanceDto.getDeptName());
			}
			// 休むをタイプ(List)
			leaveTypeList = queryDAO.executeForObjectList("leaveType", 1);
			// 年休の余剰日数
			Double remainDays = queryDAO.executeForObject("remainDays", JN_CARD, Double.class);
			if(remainDays == null){
				remainDays = 0.0;
			}
		attendance.setDetailDate(aaString);
		attendance.setLeaveTypeList(leaveTypeList);


		BLogicMessages messages = new BLogicMessages();
		messages.add("message", new BLogicMessage("message.leaveInputDelete.success"));
		BLogicResult result = new BLogicResult();
		result.setMessages(messages);
	  	result.setResultObject(attendance);
    	result.setResultString("success");
		return result;

	}

}
