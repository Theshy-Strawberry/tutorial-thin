package jp.terasoluna.thin.tutorial.web.transcosmos.blogic;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

import jp.terasoluna.fw.dao.QueryDAO;
import jp.terasoluna.fw.dao.UpdateDAO;
import jp.terasoluna.fw.service.thin.BLogic;
import jp.terasoluna.fw.service.thin.BLogicMessage;
import jp.terasoluna.fw.service.thin.BLogicMessages;
import jp.terasoluna.fw.service.thin.BLogicResult;
import jp.terasoluna.thin.tutorial.web.common.controller.GetWorkDay;
import jp.terasoluna.thin.tutorial.web.common.controller.Mail;
import jp.terasoluna.thin.tutorial.web.transcosmos.dto.JNTCIAttendance03AuditStatusDto;
import jp.terasoluna.thin.tutorial.web.transcosmos.dto.JNTCIAttendance03Dto;

public class JNTCIAttendanceUpdate03Blogic1 implements BLogic<JNTCIAttendance03Dto> {
	private UpdateDAO updateDAO;
	private QueryDAO queryDAO;

	public void setQueryDAO(QueryDAO queryDAO) {
		this.queryDAO = queryDAO;
	}

	public void setUpdateDAO(UpdateDAO updateDAO) {
		this.updateDAO = updateDAO;
	}

public BLogicResult execute(JNTCIAttendance03Dto param) {
	   Double leaveTotalTimeBJ =Double.parseDouble(param.getLeaveTotalTime());
	   String JN_CARD = param.getJnCard();
	   JNTCIAttendance03Dto attendance = new JNTCIAttendance03Dto();
		//只能在下个月三个工作日之前之前补限制，
        Date Systime = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");//可以方便地修改日期格式
        String sfd = dateFormat.format( Systime );
        List<Date> holidaylist = queryDAO.executeForObjectList("holidaylist", null);
        String start=sfd.substring(0,8).concat("01");

        //申请年月
        int ShenseiM=Integer.parseInt(param.getLeaveStartTime().substring(5, 7));
        int ShenseiY=Integer.parseInt(param.getLeaveStartTime().substring(0, 4));
        //系统年月
        int SM=Integer.parseInt(sfd.substring(5, 7));
        int SY=Integer.parseInt(sfd.substring(0, 4));
        int dayCount = GetWorkDay.workDays(start,sfd,holidaylist);
        int ShenseiMNext;
        int ShenseiYNext;
        if(ShenseiM==12){
               ShenseiMNext=1;
               ShenseiYNext=ShenseiY+1;
        }
        else {
               ShenseiMNext=ShenseiM+1;
               ShenseiYNext=ShenseiY;
        }
        if(!((ShenseiM==SM&&ShenseiY==SY)||(dayCount<4&&ShenseiMNext==SM&&ShenseiYNext==SY))){
        	 BLogicMessages messages = new BLogicMessages();
        	 BLogicResult result = new BLogicResult();
             messages.add("message", new BLogicMessage(
                                  "errors.attendance05.timeOut"));
             result.setResultString("success");
             result.setErrors(messages);
             return result;
        }else{
		// 監査状態
		JNTCIAttendance03AuditStatusDto auditStatus = new JNTCIAttendance03AuditStatusDto();
		auditStatus.setLEAVE_ID(param.getLeaveId());
		auditStatus.setEXAMINE_STATUS(param.getExamineStatus());
		auditStatus.setEXAMINE_PERSON(param.projectPm);
		String pmName = param.getProjectPm();
		String pmEmail = param.getPmEmail();
		String myEmail =param.getMyEmail();
		String jnCard = param.getJnCard();
		String  leaveStartTime  = param.getLeaveStartTime();
		String  leaveEndTime  = param.getLeaveEndTime();
		String  name  = param.getName();
		String reason = param.getLeaveReason();
		BLogicResult result = new BLogicResult();
      	result.setResultString("success");
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
				attendance.setDetailDate(aaString);
		     param.setLeaveType(param.getLeaveCode());
		
		 //查询前台的 LeaveTotalTime2
		   Double LeaveTotalTime2 = Double.parseDouble(param.getLeaveTotalTime());
		// preserVation:更新数据，直接将状态变更
		if(leaveTotalTimeBJ >= 24){
	        	BLogicMessages messages = new BLogicMessages();
	            messages.add("message", new BLogicMessage(
	                                 "errors.leaveTotalTimeBJ.error"));
	            attendance = queryDAO.executeForObject("leave", JN_CARD, JNTCIAttendance03Dto.class);
				if (attendance.deptId == null && attendance.leaveId == null) {
					JNTCIAttendance03Dto attendance03Dto = queryDAO.executeForObject("selectdeptID", JN_CARD, JNTCIAttendance03Dto.class);
					attendance.setDeptId(attendance03Dto.getDeptId());
					attendance.setDeptName(attendance03Dto.getDeptName());
				}
				List<JNTCIAttendance03Dto> leaveTypeList = queryDAO.executeForObjectList("leaveType", 1);
				        //審査人（List）
				attendance.setDetailDate(aaString);
				attendance.setLeaveTypeList(leaveTypeList);
				result.setResultObject(attendance);
				result.setMessages(messages);
				return result;
	    }else{
		if ("preservation".equals(param.getPreserVation())|| "preservation" == param.getPreserVation()) {
			BLogicMessages messages1 = new BLogicMessages();
			//如果前台休假类型为婚假
			if("AL3".equals(param.getLeaveType())){
				//查询数据库中婚假的总时间以及总次数
				JNTCIAttendance03Dto attendance03Dto1 = queryDAO.executeForObject("leaveTypeTime", JN_CARD, JNTCIAttendance03Dto.class);
				 String leaveTypeTime= attendance03Dto1.getLeaveTypeTime();
				 int countNum=attendance03Dto1.getCountNum();
				 Double LeaveTotalTime = Double.parseDouble(param.getLeaveTotalTime());
				 //获取数据库中leaveId的leaveType内容
	        	 JNTCIAttendance03Dto leaveType =queryDAO.executeForObject("searchTime", param, JNTCIAttendance03Dto.class);
	        	   // 如果数据库中婚假次数为0次
			         if(countNum==0){
			           if(LeaveTotalTime>24){
			        	   messages1.add("message", new BLogicMessage("errors.leaveTypeTime.error"));
						attendance = queryDAO.executeForObject("leave", JN_CARD, JNTCIAttendance03Dto.class);
						if (attendance.deptId == null && attendance.leaveId == null) {
							JNTCIAttendance03Dto attendance03Dto = queryDAO.executeForObject("selectdeptID", JN_CARD, JNTCIAttendance03Dto.class);
							attendance.setDeptId(attendance03Dto.getDeptId());
							attendance.setDeptName(attendance03Dto.getDeptName());
						}
						List<JNTCIAttendance03Dto> leaveTypeList = queryDAO.executeForObjectList("leaveType", 1);
						        //審査人（List）
						attendance.setDetailDate(aaString);
						attendance.setLeaveTypeList(leaveTypeList);
						result.setResultObject(attendance);
						result.setMessages(messages1);
						return result;
						}

			         //当数据库中婚假次数为1时
			         }else if(countNum==1){
			        	 if("AL3".equals(leaveType.getLeaveType())){
			        	 if(LeaveTotalTime2>24){
							 messages1.add("message", new BLogicMessage("errors.leaveTypeTime.error"));
								attendance = queryDAO.executeForObject("leave", JN_CARD, JNTCIAttendance03Dto.class);
								if (attendance.deptId == null && attendance.leaveId == null) {
									JNTCIAttendance03Dto attendance03Dto = queryDAO.executeForObject("selectdeptID", JN_CARD, JNTCIAttendance03Dto.class);
									attendance.setDeptId(attendance03Dto.getDeptId());
									attendance.setDeptName(attendance03Dto.getDeptName());
								}
								List<JNTCIAttendance03Dto> leaveTypeList = queryDAO.executeForObjectList("leaveType", 1);
								        //審査人（List）
								attendance.setDetailDate(aaString);
								attendance.setLeaveTypeList(leaveTypeList);
								result.setResultObject(attendance);
								result.setMessages(messages1);
								return result;
			        	}}else {
			        		Double leaveTypeTime1=Double.parseDouble(leaveTypeTime);
				        	 Double maxTime=24-leaveTypeTime1;
				            if(LeaveTotalTime>maxTime){
				            	messages1.add("message", new BLogicMessage("errors.leaveTypeTime.error"));
				            	attendance = queryDAO.executeForObject("leave", JN_CARD, JNTCIAttendance03Dto.class);
								if (attendance.deptId == null && attendance.leaveId == null) {
									JNTCIAttendance03Dto attendance03Dto = queryDAO.executeForObject("selectdeptID", JN_CARD, JNTCIAttendance03Dto.class);
									attendance.setDeptId(attendance03Dto.getDeptId());
									attendance.setDeptName(attendance03Dto.getDeptName());
								}
								List<JNTCIAttendance03Dto> leaveTypeList = queryDAO.executeForObjectList("leaveType", 1);
								        //審査人（List）
								attendance.setDetailDate(aaString);
								attendance.setLeaveTypeList(leaveTypeList);
								result.setResultObject(attendance);
								result.setMessages(messages1);
								return result;
					             }
						}

			          //当数据库中婚假次数大于2时
			         }else if(countNum>=2){

			        	 //如果休假种类不是婚假
			        	 if("AL3".equals(leaveType.getLeaveType())==false){
			        	 messages1.add("message", new BLogicMessage("errors.countNum.error"));
			        	 attendance = queryDAO.executeForObject("leave", JN_CARD, JNTCIAttendance03Dto.class);
							if (attendance.deptId == null && attendance.leaveId == null) {
								JNTCIAttendance03Dto attendance03Dto = queryDAO.executeForObject("selectdeptID", JN_CARD, JNTCIAttendance03Dto.class);
								attendance.setDeptId(attendance03Dto.getDeptId());
								attendance.setDeptName(attendance03Dto.getDeptName());
							}
							List<JNTCIAttendance03Dto> leaveTypeList = queryDAO.executeForObjectList("leaveType", 1);
							        //審査人（List）
							attendance.setDetailDate(aaString);
							attendance.setLeaveTypeList(leaveTypeList);
							result.setResultObject(attendance);
							result.setMessages(messages1);
							return result;
							}
			         }

			   JNTCIAttendance03Dto leaveTotalTime =queryDAO.executeForObject("searchTime", param, JNTCIAttendance03Dto.class);
			   //查询数据库中的leaveTotalTime1
			   Double leaveTotalTime1=Double.parseDouble(leaveTotalTime.getLeaveTotalTime());

			   //如果前台获取的休假种类是婚假
	        if("AL3".equals(leaveType.getLeaveType())){
	        		//查询数据库中的婚假总时间
	 			   Double leaveTypeTime1= Double.parseDouble(attendance03Dto1.getLeaveTypeTime());
	 			  //计算前台跟后台数据的和
	 			   Double sumTime=leaveTypeTime1-leaveTotalTime1+LeaveTotalTime2;
	 			  //判断计算的和是否大于24小时
	 			   if(sumTime>24){
	 				   messages1.add("message", new BLogicMessage("errors.leaveTypeTime.error"));

	 					attendance = queryDAO.executeForObject("leave", JN_CARD, JNTCIAttendance03Dto.class);
	 					if (attendance.deptId == null && attendance.leaveId == null) {
	 						JNTCIAttendance03Dto attendance03Dto = queryDAO.executeForObject("selectdeptID", JN_CARD, JNTCIAttendance03Dto.class);
	 						attendance.setDeptId(attendance03Dto.getDeptId());
	 						attendance.setDeptName(attendance03Dto.getDeptName());
	 					}
	 					List<JNTCIAttendance03Dto> leaveTypeList = queryDAO.executeForObjectList("leaveType", 1);
	 					        //審査人（List）
	 					attendance.setDetailDate(aaString);
	 					attendance.setLeaveTypeList(leaveTypeList);
	 					result.setResultObject(attendance);
	 					result.setMessages(messages1);
	 					return result;
	        	}//如果前台获取的休假种类不是婚假
			   }else  if("AL3".equals(leaveType.getLeaveType())==false){
				 if(LeaveTotalTime2>24){
					 messages1.add("message", new BLogicMessage("errors.leaveTypeTime.error"));

						attendance = queryDAO.executeForObject("leave", JN_CARD, JNTCIAttendance03Dto.class);
						if (attendance.deptId == null && attendance.leaveId == null) {
							JNTCIAttendance03Dto attendance03Dto = queryDAO.executeForObject("selectdeptID", JN_CARD, JNTCIAttendance03Dto.class);
							attendance.setDeptId(attendance03Dto.getDeptId());
							attendance.setDeptName(attendance03Dto.getDeptName());
						}
						List<JNTCIAttendance03Dto> leaveTypeList = queryDAO.executeForObjectList("leaveType", 1);
						        //審査人（List）
						attendance.setDetailDate(aaString);
						attendance.setLeaveTypeList(leaveTypeList);
						result.setResultObject(attendance);
						result.setMessages(messages1);
						return result;
				   }
				 }
		}

			updateDAO.execute("updateStatus", auditStatus);
			param.setLeaveType(param.getLeaveCode());
			String checkDate = queryDAO.executeForObject("selectCompareDate",
					param, String.class);
			List<JNTCIAttendance03Dto> leaveTypeList = new ArrayList<JNTCIAttendance03Dto>();
			if (checkDate != null) {
				// 休むをタイプ(List)
				leaveTypeList= queryDAO.executeForObjectList("leaveType", null);


				attendance = queryDAO.executeForObject("leave", JN_CARD, JNTCIAttendance03Dto.class);
				if (attendance.deptId == null && attendance.leaveId == null) {
					JNTCIAttendance03Dto attendance03Dto = queryDAO.executeForObject("selectdeptID", JN_CARD, JNTCIAttendance03Dto.class);

					attendance.setDeptId(attendance03Dto.getDeptId());
					attendance.setDeptName(attendance03Dto.getDeptName());
				}
				attendance.setDetailDate(aaString);
				attendance.setLeaveTypeList(leaveTypeList);
				BLogicMessages messages = new BLogicMessages();
				messages.add("message", new BLogicMessage("errors.leaveTimeFrame.error"));
				result.setResultObject(attendance);
				result.setMessages(messages);
				return result;
			}
else{
			updateDAO.execute("updateLeave", param);}
		} else {
			
			// 判断此时间段的数据是否已申请过
			String checkDate = queryDAO.executeForObject("selectCompareDate",
					param, String.class);
			List<JNTCIAttendance03Dto> leaveTypeList = new ArrayList<JNTCIAttendance03Dto>();


            //第一次申请休假类型为婚假
			BLogicMessages messages1 = new BLogicMessages();
			if("AL3".equals(param.getLeaveType())){
				//查询数据库中婚假的总时间以及总次数
				JNTCIAttendance03Dto attendance03Dto1 = queryDAO.executeForObject("leaveTypeTime", JN_CARD, JNTCIAttendance03Dto.class);
				 String leaveTypeTime= attendance03Dto1.getLeaveTypeTime();//获取数据库中婚假总时间
				 int countNum=attendance03Dto1.getCountNum();//获取数据库中婚假Count数
				 double LeaveTotalTime = Double.parseDouble(param.getLeaveTotalTime());//获取前台婚假的时间差
			     //如果数据库中Count数等于0
				 if(countNum==0){
			           if(LeaveTotalTime>24){
						messages1.add("message", new BLogicMessage("errors.leaveTypeTime.error"));
						//让选中的数据不会消失
						attendance = queryDAO.executeForObject("leave", JN_CARD, JNTCIAttendance03Dto.class);
						if (attendance.deptId == null && attendance.leaveId == null) {
							JNTCIAttendance03Dto attendance03Dto = queryDAO.executeForObject("selectdeptID", JN_CARD, JNTCIAttendance03Dto.class);
							attendance.setDeptId(attendance03Dto.getDeptId());
							attendance.setDeptName(attendance03Dto.getDeptName());
						}
						List<JNTCIAttendance03Dto> leaveTypeList1 = queryDAO.executeForObjectList("leaveType", 1);
						        //審査人（List）
						attendance.setDetailDate(aaString);
						attendance.setLeaveTypeList(leaveTypeList1);
						result.setResultObject(attendance);
						result.setMessages(messages1);
						return result;
			             }
			         //当数据库中婚假次数为1时
			         }else if(countNum==1){
			        	 Double leaveTypeTime1=Double.parseDouble(leaveTypeTime);
			        	 Double maxTime=24-leaveTypeTime1;
			            if(LeaveTotalTime>maxTime){
			            	messages1.add("message", new BLogicMessage("errors.leaveTypeTime.error"));
			            	attendance = queryDAO.executeForObject("leave", JN_CARD, JNTCIAttendance03Dto.class);
							if (attendance.deptId == null && attendance.leaveId == null) {
								JNTCIAttendance03Dto attendance03Dto = queryDAO.executeForObject("selectdeptID", JN_CARD, JNTCIAttendance03Dto.class);
								attendance.setDeptId(attendance03Dto.getDeptId());
								attendance.setDeptName(attendance03Dto.getDeptName());
							}
							List<JNTCIAttendance03Dto> leaveTypeList1 = queryDAO.executeForObjectList("leaveType", 1);
							        //審査人（List）
							attendance.setDetailDate(aaString);
							attendance.setLeaveTypeList(leaveTypeList1);
							result.setResultObject(attendance);
							result.setMessages(messages1);
							return result;
				             }
			          //当数据库中婚假次数大于等于2时
			         }else if(countNum>=2){
			        	 messages1.add("message", new BLogicMessage("errors.countNum.error"));
			        	 attendance = queryDAO.executeForObject("leave", JN_CARD, JNTCIAttendance03Dto.class);
							if (attendance.deptId == null && attendance.leaveId == null) {
								JNTCIAttendance03Dto attendance03Dto = queryDAO.executeForObject("selectdeptID", JN_CARD, JNTCIAttendance03Dto.class);
								attendance.setDeptId(attendance03Dto.getDeptId());
								attendance.setDeptName(attendance03Dto.getDeptName());
							}
							List<JNTCIAttendance03Dto> leaveTypeList1 = queryDAO.executeForObjectList("leaveType", 1);
							        //審査人（List）
							attendance.setDetailDate(aaString);
							attendance.setLeaveTypeList(leaveTypeList1);
							result.setResultObject(attendance);
							result.setMessages(messages1);
							return result;
			         }
			    }
			if (checkDate != null) {
				// 休むをタイプ(List)
				leaveTypeList= queryDAO.executeForObjectList("leaveType", null);


				attendance = queryDAO.executeForObject("leave", JN_CARD, JNTCIAttendance03Dto.class);
				if (attendance.deptId == null && attendance.leaveId == null) {
					JNTCIAttendance03Dto attendance03Dto = queryDAO.executeForObject("selectdeptID", JN_CARD, JNTCIAttendance03Dto.class);

					attendance.setDeptId(attendance03Dto.getDeptId());
					attendance.setDeptName(attendance03Dto.getDeptName());
				}
				attendance.setDetailDate(aaString);
				attendance.setLeaveTypeList(leaveTypeList);
				BLogicMessages messages = new BLogicMessages();
				messages.add("message", new BLogicMessage("errors.leaveTimeFrame.error"));
				result.setResultObject(attendance);
				result.setMessages(messages);
				return result;
			}

			//年休假期申请的判断
			/*if(param.getLeaveType().equals("AL10")){
				// 年休の余剰日数
				Double remainDays = queryDAO.executeForObject("remainDays", JN_CARD, Double.class);
				//
				if(remainDays == null){
					remainDays = 0.0;
				}
				double LeaveTotalTime = Double.parseDouble(param.getLeaveTotalTime());
				double remainder = remainDays - LeaveTotalTime;
				if(remainder <= 0.0){
					attendance = queryDAO.executeForObject("leave", JN_CARD, JNTCIAttendance03Dto.class);
					if (attendance.deptId != null && attendance.leaveId != null) {}
					else{
						JNTCIAttendance03Dto attendance03Dto = queryDAO.executeForObject("selectdeptID", JN_CARD, JNTCIAttendance03Dto.class);
						attendance.setDetailDate(aaString);
						attendance.setDeptId(attendance03Dto.getDeptId());
						attendance.setDeptName(attendance03Dto.getDeptName());

					}
					// 休むをタイプ(List)
					leaveTypeList= queryDAO.executeForObjectList("leaveType", null);

					attendance.setLeaveTypeList(leaveTypeList);

					examinePersonList= queryDAO.executeForObjectList("examinePerson", null);
					attendance.setDetailDate(aaString);
			        attendance.setExaminePersonList(examinePersonList);
			        attendance.setExaminePerson(param.getExaminePerson());
			        attendance.setExaminePersonCount(param.getExaminePersonCount());

					BLogicMessages messages = new BLogicMessages();
					messages.add("message", new BLogicMessage("errors.leaveLeaveOff.error"));
					result.setResultObject(attendance);
					result.setMessages(messages);
					return result;
				}else{
					param.setRemainDays(remainder);
					// 获取年假并时长减去，拿取减去的值更改剩余年假天数
					updateDAO.execute("UpdateRemainDays", param);
				}
			}*/

			TimeZone.setDefault(TimeZone.getTimeZone("GMT+8"));

			Calendar calendar = Calendar.getInstance();

			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");

			String systemdate = df.format(calendar.getTime());
			// 请假申请时间设为当前系统时间
			param.setLeaveSubtime(systemdate);
			// 更新时间设为当前系统时间
			param.setUpdTime(systemdate);
			// 判断请假原因是否为空
			if ("".equals(param.getLeaveReason())) {
				param.setLeaveReason(null);
			}

			// 获取表中的最大LEAVE_ID+1
			Integer LEAVE_ID = queryDAO.executeForObject("maxId", 1, Integer.class);

			if (LEAVE_ID == null) {
				LEAVE_ID = 1;
			}
			param.setLeaveId(LEAVE_ID);


			updateDAO.execute("JNTCIAttendance03Insert1", param);
			 String subject = "【系统邮件】【补假申请】 "+ jnCard +"."+ name +"." + leaveStartTime +"—"+ leaveEndTime;
		       String content = pmName + "桑<br><br>工作辛苦了<br><br>"+ reason +"<br><br>以上";
		     //代玉珍邮箱号
		       String daiyuzhen =queryDAO.executeForObject("SearchdaiyuzhenEmail","1070" , java.lang.String.class);
		     		//代玉珍邮箱
		       String daiyuzhenEmail = daiyuzhen+"@trans-cosmos.com.cn";
		   /*	String filePath = "D:/workspace/tutorial-thin/sources/";*/
			// 下面这个才是真正的路径，上面这个是假的
			// String filePath = this.getClass().getResource("/").getFile();
			/*Properties props = new Properties();

			if (pmEmail != null && (!"".equals(pmEmail))) {
				InputStream in = null;
				try {
					in = new FileInputStream(filePath +pmEmail);
					props.load(in);
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}*/
		       InternetAddress[] pmEmails = new InternetAddress[1];

		       try {
				 pmEmails[0] = new InternetAddress(pmEmail);//这一句才是想要的
		    	 //  pmEmails[0] = new InternetAddress(myEmail);//实验代码
			} catch (AddressException e) {
				e.printStackTrace();
			}
		       InternetAddress[] daiyuzhenMail = new InternetAddress[1];
				try {
					daiyuzhenMail[0] = new InternetAddress(daiyuzhenEmail);
				} catch (AddressException e) {
					e.printStackTrace();
				}
		       Mail.sendAll(myEmail, "123456", pmEmails, daiyuzhenMail, null, subject, content, null);

			// 申请请假审核
		JNTCIAttendance03AuditStatusDto auditStatus1 = new JNTCIAttendance03AuditStatusDto();

			String EXAMINE_ID = queryDAO.executeForObject("eaxMaxID", 1, String.class);
			if(EXAMINE_ID==null){
				EXAMINE_ID="1";
			}
			auditStatus1.setEXAMINE_ID(EXAMINE_ID);
			auditStatus1.setLEAVE_ID(param.getLeaveId());
			auditStatus1.setOBJECT_TYPE(param.getLeaveType());
			auditStatus1.setOBJECT_ID(param.getDeptId());
			auditStatus1.setUPD_TIME(systemdate);
			auditStatus1.setEXAMINE_PERSON(param.getProjectPm());
			// 添加申请请假信息
			auditStatus1.setEXAMINE_STATUS("A04");
			updateDAO.execute("AuditStatusInsert", auditStatus1);


		}


		attendance = queryDAO.executeForObject("leave", JN_CARD, JNTCIAttendance03Dto.class);
		if (attendance.deptId == null && attendance.leaveId == null) {
			JNTCIAttendance03Dto attendance03Dto = queryDAO.executeForObject("selectdeptID", JN_CARD, JNTCIAttendance03Dto.class);
			attendance.setDeptId(attendance03Dto.getDeptId());
			attendance.setDeptName(attendance03Dto.getDeptName());
		}
		// 休むをタイプ(List)
		List<JNTCIAttendance03Dto> leaveTypeList = queryDAO.executeForObjectList("leaveType", 1);
        //審査人（List）
		attendance.setDetailDate(aaString);
		attendance.setLeaveTypeList(leaveTypeList);

		BLogicMessages messages = new BLogicMessages();
		messages.add("message", new BLogicMessage("message.leaveInputInsert.success"));

		result.setResultObject(attendance);
		result.setMessages(messages);

		return result;
	}}
}
}