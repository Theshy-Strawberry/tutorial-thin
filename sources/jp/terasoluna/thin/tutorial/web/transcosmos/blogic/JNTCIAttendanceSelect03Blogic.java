package jp.terasoluna.thin.tutorial.web.transcosmos.blogic;

import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;

import jp.terasoluna.fw.dao.QueryDAO;
import jp.terasoluna.fw.service.thin.BLogic;
import jp.terasoluna.fw.service.thin.BLogicResult;
import jp.terasoluna.thin.tutorial.web.transcosmos.dto.JNTCIAttendance03OutputDto;
import jp.terasoluna.thin.tutorial.web.transcosmos.dto.JNTCIAttendanceSelect03Dto;

public class JNTCIAttendanceSelect03Blogic implements BLogic<JNTCIAttendanceSelect03Dto>{

	private QueryDAO queryDAO = null;
	public void setQueryDAO(QueryDAO queryDAO) {
		this.queryDAO = queryDAO;
	}

	public BLogicResult execute(JNTCIAttendanceSelect03Dto param) {
		String strIndex = param.getStartIndex();
		String strRow = param.getRow();
		int startIndex = 0;
		int row = 5;
		if (strIndex != null) {
			startIndex = Integer.parseInt (strIndex);

		}
		if (strRow != null) {
			row = Integer.parseInt (strRow);
		}
		String jnCard = param.getJnCard();
		String totalCount = queryDAO.executeForObject("viewCount", jnCard , String.class);

		List<JNTCIAttendanceSelect03Dto> jntciAttendanceSelect03Dto = queryDAO.executeForObjectList("JNTCIAttendance03select", jnCard,startIndex,row);
		for(int i=0;i<jntciAttendanceSelect03Dto.size();i++){//判断是不是请假日期在请假日的下个月的第三个工作日后不可修改
			String leaveSubtimeOver = "no";
			String leaveSubtime;
			leaveSubtime = jntciAttendanceSelect03Dto.get(i).getLeaveSubtime();
			int yrs=Integer.parseInt(leaveSubtime.substring(0, 4));
			int mm=Integer.parseInt(leaveSubtime.substring(5, 7))-1;
			TimeZone.setDefault(TimeZone.getTimeZone("GMT+8"));
			Calendar calendar= Calendar.getInstance();
			int years=calendar.get(Calendar.YEAR);
			int month=calendar.get(Calendar.MONTH);
			int days=calendar.get(Calendar.DAY_OF_MONTH);
			int x=4;
			if ((month - mm + 12) % 12 > 1 && years == yrs) {
				leaveSubtimeOver = "over";
			} else if ((years - yrs) == 1 && (month > 0 || mm < 11)) {
				leaveSubtimeOver = "over";
			} else if ((years - yrs) > 1) {
				leaveSubtimeOver = "over";
			} else if (days >= 4) {
				if ((month - mm + 12) % 12 == 1) {
					for (int j = 1; j < x; j++) {
						Calendar c = Calendar.getInstance();
						c.set(years, month, j);
						int weeks = c.get(Calendar.DAY_OF_WEEK);
						if (weeks == 1 || weeks == 7) {
							x = x + 1;
						}
					}
					if (days >= x) {
						leaveSubtimeOver = "over";
					}
				}
			}
			jntciAttendanceSelect03Dto.get(i).setLeaveSubtimeOver(leaveSubtimeOver);
		}




		JNTCIAttendance03OutputDto output = new JNTCIAttendance03OutputDto();
		output.setJntciAttendanceSelect03Dto(jntciAttendanceSelect03Dto);
		output.setTotalCount(totalCount);


		BLogicResult result = new BLogicResult();
		result.setResultObject(output);
		result.setResultString("success");
		return result;

	}
}