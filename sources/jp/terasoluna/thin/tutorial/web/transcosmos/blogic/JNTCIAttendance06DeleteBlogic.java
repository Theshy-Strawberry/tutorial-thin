package jp.terasoluna.thin.tutorial.web.transcosmos.blogic;

import jp.terasoluna.fw.dao.UpdateDAO;
import jp.terasoluna.fw.service.thin.BLogic;
import jp.terasoluna.fw.service.thin.BLogicMessage;
import jp.terasoluna.fw.service.thin.BLogicMessages;
import jp.terasoluna.fw.service.thin.BLogicResult;
import jp.terasoluna.thin.tutorial.web.transcosmos.dto.Attendance06SelectRecOutput;
import jp.terasoluna.thin.tutorial.web.transcosmos.dto.JNTCIAttendance06Input;

public class JNTCIAttendance06DeleteBlogic implements
		BLogic<JNTCIAttendance06Input> {

	private UpdateDAO updateDAO = null;

	public void setUpdateDAO(UpdateDAO updateDAO) {
		this.updateDAO = updateDAO;
	}

	public BLogicResult execute(JNTCIAttendance06Input param) {
		// 补签フラグ
		String flag = param.getFlagfortype();
		// 提出時間
		String sub_time = param.getSub_time().trim();
		// 切り取る提出時間

		param.setSub_time(sub_time);
		// 操作の戻りの数を削除する
		int deletecount;

		int update;
		update = param.getUpdateQuFen();
		BLogicResult result = new BLogicResult();
		Attendance06SelectRecOutput output = new Attendance06SelectRecOutput();

		if(update==1){
			output.setUser_id(param.getUser_id());
			output.setSub_time(param.getSub_time());
			output.setUpdateQuFen(param.getUpdateQuFen());
			output.setStart_time_add(param.getStart_time());
			output.setEnd_time_add(param.getEnd_time());
		}else{
		deletecount = updateDAO.execute("deleteRecforAttendance05", param);
		BLogicMessages messages = new BLogicMessages();
		messages.add("message",
				new BLogicMessage("message.attendance05.delete"));
		result.setMessages(messages);
		}
		output.setUser_id(param.getUser_id());
		output.setStartIndex(param.getStartIndex());
		output.setUser_name(param.getUser_name());
		output.setDept_id(param.getDept_id());
		output.setLeader(param.getLeader());
		result.setResultObject(output);
		result.setResultString("success");
		return result;
	}
}
