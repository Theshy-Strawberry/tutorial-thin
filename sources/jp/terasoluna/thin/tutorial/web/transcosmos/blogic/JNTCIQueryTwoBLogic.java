package jp.terasoluna.thin.tutorial.web.transcosmos.blogic;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jp.terasoluna.fw.dao.QueryDAO;
import jp.terasoluna.fw.service.thin.BLogic;
import jp.terasoluna.fw.service.thin.BLogicResult;
import jp.terasoluna.thin.tutorial.web.transcosmos.dto.JNTCIQueryInput;
import jp.terasoluna.thin.tutorial.web.transcosmos.dto.JNTCIQueryOut;
import jp.terasoluna.thin.tutorial.web.transcosmos.vo.JNTCIQueryOutvo;

public class JNTCIQueryTwoBLogic implements BLogic<JNTCIQueryInput> {
	private QueryDAO queryDAO = null;
	public void setQueryDAO(QueryDAO queryDAO) {
		this.queryDAO = queryDAO;
	}

	public QueryDAO getQueryDAO() {
		return queryDAO;
	}

	public BLogicResult execute(JNTCIQueryInput param) {
		String strIndex  = param.getStartIndex();
		String strRow =param.getRow();
		int startIndex  =0;
		int row= 5;
		if (strIndex != null) {
			startIndex = Integer.parseInt(strIndex);
		}

		if (strRow != null) {
			row = Integer.parseInt(strRow);
		}

		double sumTwo = 0;
		double sumJBpr =0;   //  ping ri jia  ban
		double sumJBxiuxi=0;  // xiu xi ri jia ban
		double sumJBjiari=0; // jia ri jia ban
		double yearsJa=0;

		String datatime;
		Date date=new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
		String str=sdf.format(date);
		datatime= str;
		// ri qi
		if(param.getLeave_starttime()==null || param.getLeave_starttime()==""){
			param.setLeave_starttime(datatime);
		}
		if(param.getJN_CARD()==null){
			param.setJN_CARD(param.getUser_id());
		}
		String status = param.getAttendanceStatus();
		if(param.getAttendanceStatus() == null){
			param.setAttendanceStatus(null);
		}else{
			if("1".equals(param.getAttendanceStatus())){
				param.setAttendanceStatus("Yes");
			}else if("2".equals(param.getAttendanceStatus())){
				param.setAttendanceStatus("No");
			}else if("5".equals(param.getAttendanceStatus())){
				param.setAttendanceStatus(null);
			}
		}

		String totalCount = queryDAO.executeForObject("getUserCountList", param, String.class);
		List<JNTCIQueryOutvo> deptListName = queryDAO.executeForObjectList("getListDeptName", String.class);
		List<JNTCIQueryOutvo> users  = queryDAO.executeForObjectList("getUserList", param, startIndex, row);

		for(JNTCIQueryOutvo user: users){
			if(user.getSTART_TIME()!=null){
				user.setRiqi(user.getSTART_TIME().substring(0,10).trim());
			}

			if(user.getLEAVE_TYPE()!=null){
				if(!"事假".equals(user.getLEAVE_TYPE())){
					user.setJiaqi(user.getLEAVE_TYPE()+":"+user.getLEAVE_TOTALTIME());
				}else{
					user.setShijia(user.getLEAVE_TOTALTIME());
				}
			}
			if(user.getLEAVE_TOTALTIME()!=null){
				user.setSTART_TIME(null);
				user.setEND_TIME(null);
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
			if(user.getLEAVE_TOTALTIME()!=null){
				double sum=Double.parseDouble(user.getLEAVE_TOTALTIME());
				sumTwo =sumTwo+sum;
			}
			if(user.getREMAIN_DAYS()!=null){
			double	jia =Double.parseDouble(user.getREMAIN_DAYS());
				yearsJa = yearsJa+jia;
			}
			Integer startTime = null;
			Integer endTime = null;
			double whenlong = 0.0;

			if(user.getSTART_TIME() != null && user.getEND_TIME() != null ){
				startTime = Integer.valueOf(user.getSTART_TIME().substring(10, 16).replace(":", "").trim());
				endTime = Integer.valueOf(user.getEND_TIME().substring(10, 16).replace(":", "").trim());

				if(user.getShijia()!= null ){
					whenlong = Double.parseDouble(user.getLEAVE_TOTALTIME());
					user.setShuzi((endTime - startTime) + whenlong);
				}else{
					user.setShuzi(endTime - startTime);
				}
				if(user.getShuzi() >= 800){
					user.setCheckException("No");

				}else{
					user.setCheckException("Yes");
				}

			}else{
				user.setCheckException("No");
			}
		}

		List<JNTCIQueryOutvo> newusers = new ArrayList<JNTCIQueryOutvo>();
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
					}
				}
				users = newusers;
			}

		}

		JNTCIQueryOut  queryOutList =  new JNTCIQueryOut();

		queryOutList.setJnCard(param.getJN_CARD());
		queryOutList.setDeptCode(param.getDeptuser_id());
		queryOutList.setSumTwo(sumTwo);
		queryOutList.setYearsJa(yearsJa);
		queryOutList.setSumJBpr(sumJBpr);
		queryOutList.setSumJBjiari(sumJBjiari);
		queryOutList.setSumJBxiuxi(sumJBxiuxi);
		queryOutList.setAttendanceStatus(status);

		queryOutList.setTotalCount(totalCount);
		queryOutList.setUserDeptList(deptListName);
		queryOutList.setUserList(users);
		BLogicResult  blresult = new BLogicResult();
		blresult.setResultObject(queryOutList);
		blresult.setResultString("success");
		return blresult;
	}

}
