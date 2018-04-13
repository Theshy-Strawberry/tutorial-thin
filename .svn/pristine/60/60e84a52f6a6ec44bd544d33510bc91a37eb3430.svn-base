package jp.terasoluna.thin.tutorial.web.transcosmos.blogic;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jp.terasoluna.fw.dao.QueryDAO;
import jp.terasoluna.fw.dao.UpdateDAO;
import jp.terasoluna.fw.service.thin.BLogic;
import jp.terasoluna.fw.service.thin.BLogicResult;
import jp.terasoluna.thin.tutorial.web.transcosmos.dto.JNTCIQueryInput;
import jp.terasoluna.thin.tutorial.web.transcosmos.dto.JNTCIQueryOut;
import jp.terasoluna.thin.tutorial.web.transcosmos.vo.JNTCIQueryOutvo;

public class JNTCIQueryBLogic implements BLogic<JNTCIQueryInput>{

	private QueryDAO queryDAO = null;
	private UpdateDAO updateDAO = null;
	public UpdateDAO getUpdateDAO() {
		return updateDAO;
	}

	public void setUpdateDAO(UpdateDAO updateDAO) {
		this.updateDAO = updateDAO;
	}

	public void setQueryDAO(QueryDAO queryDAO) {
		this.queryDAO = queryDAO;
	}

	public BLogicResult execute(JNTCIQueryInput param) {
		String strIndex  = param.getStartIndex();
		String strRow =param.getRow();
		int startIndex  =0;
		int row= 5;

		double sumTwo = 0;
		double sumJBpr =0;   //  ping ri jia  ban
		double sumJBxiuxi=0;  // xiu xi ri jia ban
		double sumJBjiari=0; // jia ri jia ban
		double yearsJa=0;

		if (strIndex != null) {
			startIndex = Integer.parseInt(strIndex);
		}

		if (strRow != null) {
			row = Integer.parseInt(strRow);
		}

		String datatime;
		Date date=new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
		String str=sdf.format(date);
		datatime= str;
		if(param.getJN_CARD()==null){
			param.setJN_CARD(param.getUser_id());
		}
		if(param.getNAME()==null){
			param.setNAME(param.getUserName());
		}
		// ri qi
		if(param.getLeave_starttime()==null || param.getLeave_starttime()==""){
			param.setLeave_starttime(datatime);
		}

		String totalCount = queryDAO.executeForObject("getUserCountList", param, String.class);
		List<JNTCIQueryOutvo> deptListName = queryDAO.executeForObjectList("getListDeptName", String.class);

		List<JNTCIQueryOutvo> users  = queryDAO.executeForObjectList("getUserList", param, startIndex, row);
		JNTCIQueryInput input = new JNTCIQueryInput();
		input.setLeave_starttime(param.getLeave_starttime());
		List<JNTCIQueryOutvo> usersList  = queryDAO.executeForObjectList("getUserShuJu", input);

		for(JNTCIQueryOutvo userList: usersList){
			JNTCIQueryOutvo outVo2 =new JNTCIQueryOutvo();
			String checkValue;

			if(userList.getSTART_TIME()==null|| userList.getEND_TIME() == null ){
				if(userList.getEND_TIME()== null){
					checkValue = "Yes";
					outVo2.setCheckValue(checkValue);
					outVo2.setATTENDANCE_ID(userList.getATTENDANCE_ID());
					if(outVo2.getATTENDANCE_ID() != null){
						updateDAO.execute("insertCheckValue", outVo2);
					}else{
						outVo2.setLeave_Id(userList.getLeave_Id());
						outVo2.setCheckValue("Yes");
						updateDAO.execute("insertLeaveCheckValue", outVo2);
					}

					userList.setCheckException(checkValue);
				}else if(userList.getSTART_TIME()==null){
					checkValue = "Yes";
					outVo2.setCheckValue(checkValue);
					outVo2.setATTENDANCE_ID(userList.getATTENDANCE_ID());
					if(outVo2.getATTENDANCE_ID() != null){
						updateDAO.execute("insertCheckValue", outVo2);
					}else{
						outVo2.setLeave_Id(userList.getLeave_Id());
						outVo2.setCheckValue("Yes");
						updateDAO.execute("insertLeaveCheckValue", outVo2);
					}
					userList.setCheckException(checkValue);
				}else if(userList.getSTART_TIME()==null&& userList.getEND_TIME() == null){

					checkValue = "Yes";
					outVo2.setCheckValue(checkValue);
					outVo2.setATTENDANCE_ID(userList.getATTENDANCE_ID());
					if(outVo2.getATTENDANCE_ID() != null){
						updateDAO.execute("insertCheckValue", outVo2);
					}else{
						outVo2.setLeave_Id(userList.getLeave_Id());
						outVo2.setCheckValue("Yes");
						updateDAO.execute("insertLeaveCheckValue", outVo2);
					}
					userList.setCheckException(checkValue);
				}
			}else{
			String date1 = (String) userList.getEND_TIME().subSequence(10, 16);
			date1 = date1.replace(":", ".");
			String date2 = (String) userList.getSTART_TIME().subSequence(10, 16);
			date2 = date2.replace(":", ".");
			String date3 = null;
			double shuZi3 = 0;
			if(userList.getLEAVE_TOTALTIME()!=null){
				date3 = (String) userList.getLEAVE_TOTALTIME();
				 shuZi3 = Double.parseDouble(date3);

			}

			double  shuZi1 = Double.parseDouble(date1);
			double  shuZi2 = Double.parseDouble(date2);

			// jieshu - kaishi
			double c=(shuZi1-shuZi2-1)+shuZi3;
			if(c >= 8.0){
				checkValue = "No";
				outVo2.setCheckValue(checkValue);
				outVo2.setATTENDANCE_ID(userList.getATTENDANCE_ID());
				if(outVo2.getATTENDANCE_ID() != null){
					updateDAO.execute("insertCheckValue", outVo2);
				}else{
					outVo2.setLeave_Id(userList.getLeave_Id());
					outVo2.setCheckValue("Yes");
					updateDAO.execute("insertLeaveCheckValue", outVo2);
				}
				userList.setCheckException(checkValue);
			}else if (c < 8.0){
				checkValue = "Yes";
				outVo2.setCheckValue(checkValue);
				outVo2.setATTENDANCE_ID(userList.getATTENDANCE_ID());
				if(outVo2.getATTENDANCE_ID() != null){
					updateDAO.execute("insertCheckValue", outVo2);
				}else{
					outVo2.setLeave_Id(userList.getLeave_Id());
					outVo2.setCheckValue("Yes");
					updateDAO.execute("insertLeaveCheckValue", outVo2);
				}
				userList.setCheckException(checkValue);
			}else {
				checkValue = "No";
				outVo2.setCheckValue(checkValue);
				outVo2.setATTENDANCE_ID(userList.getATTENDANCE_ID());
				if(outVo2.getATTENDANCE_ID() != null){
					updateDAO.execute("insertCheckValue", outVo2);
				}else{
					outVo2.setLeave_Id(userList.getLeave_Id());
					outVo2.setCheckValue("Yes");
					updateDAO.execute("insertLeaveCheckValue", outVo2);
				}
				userList.setCheckException(checkValue);
			}
		}
	}
		for(JNTCIQueryOutvo user: users){

			if(user.getSTART_TIME()!=null){
				user.setRiqi(user.getSTART_TIME().substring(0,10).trim());
			}


			if(user.getREMAIN_DAYS()!=null){
				double	jia =Double.parseDouble(user.getREMAIN_DAYS());
					yearsJa = yearsJa+jia;
				}
			if(user.getEXTRA_TYPE()!=null){
				if("平日残業".equals(user.getEXTRA_TYPE())){
					double sum = Double.parseDouble(user.getEXTRA_TIME());
					sumJBpr= sumJBpr+sum;
				}else if("休日残業".equals(user.getEXTRA_TYPE())){
					double sum = Double.parseDouble(user.getEXTRA_TIME());
					sumJBxiuxi = sumJBxiuxi+sum;
				}else if("暇日残業".equals(user.getEXTRA_TYPE())){
					double sum = Double.parseDouble(user.getEXTRA_TIME());
					sumJBjiari = sum+sumJBjiari;
				}
			}
		}

		List<JNTCIQueryOutvo> newusers = new ArrayList<JNTCIQueryOutvo>();
		JNTCIQueryOut  queryOutList =  new JNTCIQueryOut();
		String attendanceStatus = param.getAttendanceStatus();
		String yes = "Yes";
		String no = "No";
		if(attendanceStatus != null){
			if("1".equals(attendanceStatus)){
				for(JNTCIQueryOutvo user: users){
					if(user.getCheckException().contains(yes)){
						newusers.add(user);
					}else{
						int a = 1;
						int count = Integer.parseInt(totalCount);
						totalCount = String.valueOf(count - a);
					}
				}
				users = newusers;
			}else if("2".equals(attendanceStatus)){
				for(JNTCIQueryOutvo user: users){
					if(user.getCheckException().contains(no)){
						newusers.add(user);
					}else{
						int a = 1;
						int count = Integer.parseInt(totalCount);
						totalCount = String.valueOf(count - a);
					}
				}
				users = newusers;
			}

		}

		queryOutList.setUserList(users);
		queryOutList.setJnCard(param.getUser_id());
		queryOutList.setJnName(param.getUserName());

		queryOutList.setDeptCode(param.getDeptuser_id());
		queryOutList.setTotalCount(totalCount);
		queryOutList.setUserDeptList(deptListName);
		queryOutList.setSumTwo(sumTwo);
		queryOutList.setYearsJa(yearsJa);
		queryOutList.setSumJBpr(sumJBpr);
		queryOutList.setSumJBjiari(sumJBjiari);
		queryOutList.setSumJBxiuxi(sumJBxiuxi);
		queryOutList.setAttendanceStatus("5");
		BLogicResult result = new BLogicResult();
		result.setResultObject(queryOutList);
		result.setResultString("success");
		return result;
	}

}
