package jp.terasoluna.thin.tutorial.web.transcosmos.blogic;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import jp.terasoluna.fw.dao.QueryDAO;
import jp.terasoluna.fw.dao.UpdateDAO;
import jp.terasoluna.fw.service.thin.BLogic;
import jp.terasoluna.fw.service.thin.BLogicMessages;
import jp.terasoluna.fw.service.thin.BLogicMessage;
import jp.terasoluna.fw.service.thin.BLogicResult;
import jp.terasoluna.thin.tutorial.web.common.controller.GetWorkDay;
import jp.terasoluna.thin.tutorial.web.common.controller.LeaveDetail;
import jp.terasoluna.thin.tutorial.web.transcosmos.dto.JNTCIAttendance04selectInput;
import jp.terasoluna.thin.tutorial.web.transcosmos.vo.JNTCIAttendanceVo;


public  class JNTCIAttendance03DeleteBlogic implements BLogic<JNTCIAttendance04selectInput>{
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
	public BLogicResult execute(JNTCIAttendance04selectInput param) {
		BLogicResult result= new BLogicResult();
    	BLogicMessages messages = new BLogicMessages();
		//休假审查删除
		if(param.getDeleteAllId() != null){
			String deleteAllId = "";
			if(param.getDeleteAllId().contains(",")){
				String[] cards = param.getDeleteAllId().split(",");
				for (int i = 0; i < cards.length; i++) {
					deleteAllId = cards[i];
					 String unadmitAllId=deleteAllId;
					 String admit_leader_es=queryDAO.executeForObject("admit_leader_es", unadmitAllId, String.class);
					 if("A10".equals(admit_leader_es)||"A13".equals(admit_leader_es)||"A03".equals(admit_leader_es)){}else{
					updateDAO.execute("JNTCIAttendance03DeleteTTLM", deleteAllId);
					updateDAO.execute("JNTCIAttendance03DeleteTTAS", deleteAllId);
					 }
				}
			}else {
				deleteAllId = param.getDeleteAllId();
				 String unadmitAllId=deleteAllId;
				 String admit_leader_es=queryDAO.executeForObject("admit_leader_es", unadmitAllId, String.class);
				 if("A10".equals(admit_leader_es)||"A13".equals(admit_leader_es)||"A03".equals(admit_leader_es)){}else{
				updateDAO.execute("JNTCIAttendance03DeleteTTLM", deleteAllId);
				updateDAO.execute("JNTCIAttendance03DeleteTTAS", deleteAllId);
			}
			}
			messages.add("message", new BLogicMessage("message.deletesucess"));
			result.setMessages(messages);
		}
		if("1003".equals(param.getUserId())){
			//休假审查页面一括承认
			if(param.getAdmitAllId() != null){
				String admitAllId = "";
				if(param.getAdmitAllId().contains(",")){
					String[] cards = param.getAdmitAllId().split(",");
					for (int i = 0; i < cards.length; i++) {
					    admitAllId = cards[i];

					    JNTCIAttendance04selectInput  jntciAttendance04selectInput=new JNTCIAttendance04selectInput();
					    jntciAttendance04selectInput.setLeaveId(Integer.parseInt(admitAllId));
					    jntciAttendance04selectInput.setUserName(param.getUserName());

					    String admit_leader_lt1=queryDAO.executeForObject("admit_leader_lt", admitAllId, String.class);
		                Double  admit_leader_lt=Double.parseDouble(admit_leader_lt1);
					    String admit_leader_es=queryDAO.executeForObject("admit_leader_es", admitAllId, String.class);

					    String begintime=queryDAO.executeForObject("selectbegintime", admitAllId, String.class);



					    String leave_type=queryDAO.executeForObject("admit_leader_ltT", admitAllId, String.class);
					    String endtime=queryDAO.executeForObject("selectendtime", admitAllId, String.class);
					    double exCount = 0;
			            if(admit_leader_lt1 != null){
			                exCount = Double.parseDouble(admit_leader_lt1);
			            }
			        	List<Date> holidaylist = queryDAO.executeForObjectList("holidaylist", null);
					    Date Systime = new Date();
						SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
						String sfd = dateFormat.format(Systime);
						String start = sfd.substring(0, 8).concat("01");
						int ShenseiM = Integer.parseInt(begintime
								.substring(5, 7));
						int ShenseiY = Integer.parseInt(begintime
								.substring(0, 4));
						int SM = Integer.parseInt(sfd.substring(5, 7));
						int SY = Integer.parseInt(sfd.substring(0, 4));
						int dayCount = GetWorkDay.workDays(start, sfd, holidaylist);
						int ShenseiMNext;
						int ShenseiYNext;
						if (ShenseiM == 12) {
							ShenseiMNext = 1;
							ShenseiYNext = ShenseiY + 1;
						} else {
							ShenseiMNext = ShenseiM + 1;
							ShenseiYNext = ShenseiY;
						}
						if ((ShenseiM >= SM && ShenseiY >= SY)
								|| (dayCount < 4 && ShenseiMNext == SM && ShenseiYNext == SY)) {

					 if("A04".equals(admit_leader_es)||"A11".equals(admit_leader_es)||"A01".equals(admit_leader_es)){
						  String leave_id =admitAllId;
						    if( leave_id!=null){
								  updateDAO.execute("deleteLeaveDetail", leave_id);
							  }
						if(admit_leader_lt >= 24){
							jntciAttendance04selectInput.setExamineStatus("A08");
							updateDAO.execute("update_admit_leader_ttas", jntciAttendance04selectInput);
							updateDAO.execute("update_admit_leader_ttlm", jntciAttendance04selectInput);
						}else {
							List<JNTCIAttendanceVo> detailList = LeaveDetail.getAttendance(admitAllId,begintime, endtime,
			                        exCount, leave_type, holidaylist);
			                for(int x = 0; x < detailList.size(); x++){
			                    updateDAO.execute("leaveDetail", detailList.get(x));
			                }

							jntciAttendance04selectInput.setExamineStatus("A13");//许可
							updateDAO.execute("update_admit_leader_ttas", jntciAttendance04selectInput);
							updateDAO.execute("update_admit_leader_ttlm", jntciAttendance04selectInput);

						}

					 }
						}else{
							messages.add("message", new BLogicMessage(
		    						"errors.attendance05.timeOut1",jntciAttendance04selectInput.getLeaveId()));
						    result.setErrors(messages);
						}
					}
				}
			}
			//休假审查页面一括不承认
			if(param.getUnadmitAllId() != null){
				String unadmitAllId = "";
				if(param.getUnadmitAllId().contains(",")){
					String[] cards = param.getUnadmitAllId().split(",");
					for (int i = 0; i < cards.length; i++) {
					    unadmitAllId = cards[i];

					    JNTCIAttendance04selectInput  jntciAttendance04selectInput=new JNTCIAttendance04selectInput();
					    jntciAttendance04selectInput.setLeaveId(Integer.parseInt(unadmitAllId));
					    jntciAttendance04selectInput.setUserName(param.getUserName());
					    String admit_leader_es=queryDAO.executeForObject("admit_leader_es", unadmitAllId, String.class);

					    String begintime=queryDAO.executeForObject("selectbegintime", unadmitAllId, String.class);
					    Date Systime = new Date();
						SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
						String sfd = dateFormat.format(Systime);
						List<Date> holidaylist = queryDAO.executeForObjectList(
								"holidaylist", null);
						String start = sfd.substring(0, 8).concat("01");
						int ShenseiM = Integer.parseInt(begintime
								.substring(5, 7));
						int ShenseiY = Integer.parseInt(begintime
								.substring(0, 4));
						int SM = Integer.parseInt(sfd.substring(5, 7));
						int SY = Integer.parseInt(sfd.substring(0, 4));
						int dayCount = GetWorkDay.workDays(start, sfd, holidaylist);
						int ShenseiMNext;
						int ShenseiYNext;
						if (ShenseiM == 12) {
							ShenseiMNext = 1;
							ShenseiYNext = ShenseiY + 1;
						} else {
							ShenseiMNext = ShenseiM + 1;
							ShenseiYNext = ShenseiY;
						}
						if ((ShenseiM >= SM && ShenseiY >= SY)
								|| (dayCount < 4 && ShenseiMNext == SM && ShenseiYNext == SY)) {

					 if("A04".equals(admit_leader_es)||"A01".equals(admit_leader_es)||"A08".equals(admit_leader_es)||"A13".equals(admit_leader_es)){
						  String leave_id =unadmitAllId;
						    if( leave_id!=null){
								  updateDAO.execute("deleteLeaveDetail", leave_id);
							  }
						 jntciAttendance04selectInput.setExamineStatus("A11");
							updateDAO.execute("update_admit_leader_ttas", jntciAttendance04selectInput);
							updateDAO.execute("update_admit_leader_ttlm", jntciAttendance04selectInput);
					 }
						}else{
							messages.add("message", new BLogicMessage(
		    						"errors.attendance05.timeOut1",jntciAttendance04selectInput.getLeaveId()));
						    result.setErrors(messages);
						}
					}
				}
		}
			}else if("1004".equals(param.getUserId())){
			//休假审查页面一括承认
			if(param.getAdmitAllId() != null){
				String admitAllId = "";
				if(param.getAdmitAllId().contains(",")){
					String[] cards = param.getAdmitAllId().split(",");
					for (int i = 0; i < cards.length; i++) {
					    admitAllId = cards[i];

					    JNTCIAttendance04selectInput  jntciAttendance04selectInput=new JNTCIAttendance04selectInput();
					    jntciAttendance04selectInput.setLeaveId(Integer.parseInt(admitAllId));
					    jntciAttendance04selectInput.setUserName(param.getUserName());

					    String admit_leader_lt1=queryDAO.executeForObject("admit_leader_lt", admitAllId, String.class);
		                Double  admit_leader_lt=Double.parseDouble(admit_leader_lt1);
					    String admit_leader_es=queryDAO.executeForObject("admit_leader_es", admitAllId, String.class);

					    String begintime=queryDAO.executeForObject("selectbegintime", admitAllId, String.class);
					    String leave_type=queryDAO.executeForObject("admit_leader_ltT", admitAllId, String.class);
					    String endtime=queryDAO.executeForObject("selectendtime", admitAllId, String.class);
					    double exCount = 0;
			            if(admit_leader_lt1 != null){
			                exCount = Double.parseDouble(admit_leader_lt1);
			            }
			        	List<Date> holidaylist = queryDAO.executeForObjectList("holidaylist", null);
					    Date Systime = new Date();
						SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
						String sfd = dateFormat.format(Systime);

						String start = sfd.substring(0, 8).concat("01");
						int ShenseiM = Integer.parseInt(begintime
								.substring(5, 7));
						int ShenseiY = Integer.parseInt(begintime
								.substring(0, 4));
						int SM = Integer.parseInt(sfd.substring(5, 7));
						int SY = Integer.parseInt(sfd.substring(0, 4));
						int dayCount = GetWorkDay.workDays(start, sfd, holidaylist);
						int ShenseiMNext;
						int ShenseiYNext;
						if (ShenseiM == 12) {
							ShenseiMNext = 1;
							ShenseiYNext = ShenseiY + 1;
						} else {
							ShenseiMNext = ShenseiM + 1;
							ShenseiYNext = ShenseiY;
						}
						if ((ShenseiM >= SM && ShenseiY >= SY)
								|| (dayCount < 4 && ShenseiMNext == SM && ShenseiYNext == SY)) {

							if("A04".equals(admit_leader_es)||"A11".equals(admit_leader_es)){
								  String leave_id =admitAllId;
								    if( leave_id!=null){
										  updateDAO.execute("deleteLeaveDetail", leave_id);
									  }
						  if(admit_leader_lt >= 24){
							jntciAttendance04selectInput.setExamineStatus("A08");
							updateDAO.execute("update_admit_leader_ttas", jntciAttendance04selectInput);
							updateDAO.execute("update_admit_leader_ttlm", jntciAttendance04selectInput);
						}else {
							jntciAttendance04selectInput.setExamineStatus("A13");

							List<JNTCIAttendanceVo> detailList = LeaveDetail.getAttendance(admitAllId,begintime, endtime,
			                        exCount, leave_type, holidaylist);
			                for(int x = 0; x < detailList.size(); x++){
			                    updateDAO.execute("leaveDetail", detailList.get(x));
			                }
							updateDAO.execute("update_admit_leader_ttas", jntciAttendance04selectInput);
							updateDAO.execute("update_admit_leader_ttlm", jntciAttendance04selectInput);

						}

					 }
						}else{
							messages.add("message", new BLogicMessage(
		    						"errors.attendance05.timeOut1",jntciAttendance04selectInput.getLeaveId()));
						    result.setErrors(messages);
						}
					}
				}
			}
			//休假审查页面一括不承认
			if(param.getUnadmitAllId() != null){
				String unadmitAllId = "";
				if(param.getUnadmitAllId().contains(",")){
					String[] cards = param.getUnadmitAllId().split(",");
					for (int i = 0; i < cards.length; i++) {
					    unadmitAllId = cards[i];

					    JNTCIAttendance04selectInput  jntciAttendance04selectInput=new JNTCIAttendance04selectInput();
					    jntciAttendance04selectInput.setLeaveId(Integer.parseInt(unadmitAllId));
					    jntciAttendance04selectInput.setUserName(param.getUserName());
					    String admit_leader_es=queryDAO.executeForObject("admit_leader_es", unadmitAllId, String.class);

					    String begintime=queryDAO.executeForObject("selectbegintime", unadmitAllId, String.class);
					    Date Systime = new Date();
						SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
						String sfd = dateFormat.format(Systime);
						List<Date> holidaylist = queryDAO.executeForObjectList(
								"holidaylist", null);
						String start = sfd.substring(0, 8).concat("01");
						int ShenseiM = Integer.parseInt(begintime
								.substring(5, 7));
						int ShenseiY = Integer.parseInt(begintime
								.substring(0, 4));
						int SM = Integer.parseInt(sfd.substring(5, 7));
						int SY = Integer.parseInt(sfd.substring(0, 4));
						int dayCount = GetWorkDay.workDays(start, sfd, holidaylist);
						int ShenseiMNext;
						int ShenseiYNext;
						if (ShenseiM == 12) {
							ShenseiMNext = 1;
							ShenseiYNext = ShenseiY + 1;
						} else {
							ShenseiMNext = ShenseiM + 1;
							ShenseiYNext = ShenseiY;
						}
						if ((ShenseiM >= SM && ShenseiY >= SY)
								|| (dayCount < 4 && ShenseiMNext == SM && ShenseiYNext == SY)) {

					 if("A04".equals(admit_leader_es)||"A08".equals(admit_leader_es)||"A13".equals(admit_leader_es)){
						 String leave_id =unadmitAllId;
						    if( leave_id!=null){
								  updateDAO.execute("deleteLeaveDetail", leave_id);
							  }
						 jntciAttendance04selectInput.setExamineStatus("A11");
							updateDAO.execute("update_admit_leader_ttas", jntciAttendance04selectInput);
							updateDAO.execute("update_admit_leader_ttlm", jntciAttendance04selectInput);
						}
						}else{
							messages.add("message", new BLogicMessage(
		    						"errors.attendance05.timeOut1",jntciAttendance04selectInput.getLeaveId()));
						    result.setErrors(messages);
						}
					 }

					}
				}
		}else if("1002".equals(param.getUserId())){
			//休假审查页面一括承认
 			if(param.getAdmitAllId() != null){
				String admitAllId = "";
				if(param.getAdmitAllId().contains(",")){
					String[] cards = param.getAdmitAllId().split(",");
					for (int i = 0; i < cards.length; i++) {
					    admitAllId = cards[i];

					    JNTCIAttendance04selectInput  jntciAttendance04selectInput=new JNTCIAttendance04selectInput();
					    jntciAttendance04selectInput.setLeaveId(Integer.parseInt(admitAllId));
					    jntciAttendance04selectInput.setUserName(param.getUserName());
					    String admit_leader_es=queryDAO.executeForObject("admit_leader_es", admitAllId, String.class);
//
					    String begintime=queryDAO.executeForObject("selectbegintime", admitAllId, String.class);
					    String admit_leader_lt1=queryDAO.executeForObject("admit_leader_lt", admitAllId, String.class);
					    String leave_type=queryDAO.executeForObject("admit_leader_ltT", admitAllId, String.class);
					    String endtime=queryDAO.executeForObject("selectendtime", admitAllId, String.class);
					    double exCount = 0;
			            if(admit_leader_lt1 != null){
			                exCount = Double.parseDouble(admit_leader_lt1);
			            }
			        	List<Date> holidaylist = queryDAO.executeForObjectList("holidaylist", null);
	//
					    Date Systime = new Date();
						SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
						String sfd = dateFormat.format(Systime);

						String start = sfd.substring(0, 8).concat("01");
						int ShenseiM = Integer.parseInt(begintime
								.substring(5, 7));
						int ShenseiY = Integer.parseInt(begintime
								.substring(0, 4));
						int SM = Integer.parseInt(sfd.substring(5, 7));
						int SY = Integer.parseInt(sfd.substring(0, 4));
						int dayCount = GetWorkDay.workDays(start, sfd, holidaylist);
						int ShenseiMNext;
						int ShenseiYNext;
						if (ShenseiM == 12) {
							ShenseiMNext = 1;
							ShenseiYNext = ShenseiY + 1;
						} else {
							ShenseiMNext = ShenseiM + 1;
							ShenseiYNext = ShenseiY;
						}
						if ((ShenseiM >= SM && ShenseiY >= SY)
								|| (dayCount < 4 && ShenseiMNext == SM && ShenseiYNext == SY)) {


					 if("A04".equals(admit_leader_es)||"A08".equals(admit_leader_es)||"A12".equals(admit_leader_es)){
						 String leave_id =admitAllId;
						    if( leave_id!=null){
								  updateDAO.execute("deleteLeaveDetail", leave_id);
							  }
						 jntciAttendance04selectInput.setExamineStatus("A10");


					List<JNTCIAttendanceVo> detailList = LeaveDetail.getAttendance(admitAllId,begintime, endtime,
	                        exCount, leave_type, holidaylist);
	                for(int x = 0; x < detailList.size(); x++){
	                    updateDAO.execute("leaveDetail", detailList.get(x));
	                }


							updateDAO.execute("update_admit_leader_ttas", jntciAttendance04selectInput);
							updateDAO.execute("update_admit_leader_ttlm", jntciAttendance04selectInput);
					 }
						}else{
							 messages.add("message", new BLogicMessage(
			    						"errors.attendance05.timeOut1",jntciAttendance04selectInput.getLeaveId()));
							    result.setErrors(messages);

						}
					}
				}
			}
			//休假审查页面一括不承认
			if(param.getUnadmitAllId() != null){
				String unadmitAllId = "";
				if(param.getUnadmitAllId().contains(",")){
					String[] cards = param.getUnadmitAllId().split(",");
					for (int i = 0; i < cards.length; i++) {
					    unadmitAllId = cards[i];

					    JNTCIAttendance04selectInput  jntciAttendance04selectInput=new JNTCIAttendance04selectInput();
					    jntciAttendance04selectInput.setLeaveId(Integer.parseInt(unadmitAllId));
					    jntciAttendance04selectInput.setUserName(param.getUserName());
					    String admit_leader_es=queryDAO.executeForObject("admit_leader_es", unadmitAllId, String.class);

					    String begintime=queryDAO.executeForObject("selectbegintime", unadmitAllId, String.class);
					    Date Systime = new Date();
						SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
						String sfd = dateFormat.format(Systime);
						List<Date> holidaylist = queryDAO.executeForObjectList(
								"holidaylist", null);
						String start = sfd.substring(0, 8).concat("01");
						int ShenseiM = Integer.parseInt(begintime
								.substring(5, 7));
						int ShenseiY = Integer.parseInt(begintime
								.substring(0, 4));
						int SM = Integer.parseInt(sfd.substring(5, 7));
						int SY = Integer.parseInt(sfd.substring(0, 4));
						int dayCount = GetWorkDay.workDays(start, sfd, holidaylist);
						int ShenseiMNext;
						int ShenseiYNext;
						if (ShenseiM == 12) {
							ShenseiMNext = 1;
							ShenseiYNext = ShenseiY + 1;
						} else {
							ShenseiMNext = ShenseiM + 1;
							ShenseiYNext = ShenseiY;
						}
						if ((ShenseiM >= SM && ShenseiY >= SY)
								|| (dayCount < 4 && ShenseiMNext == SM && ShenseiYNext == SY)) {


					 if("A04".equals(admit_leader_es)||"A08".equals(admit_leader_es)||"A10".equals(admit_leader_es)){
						   String leave_id =unadmitAllId;
						    if( leave_id!=null){
								  updateDAO.execute("deleteLeaveDetail", leave_id);
							  }
						 jntciAttendance04selectInput.setExamineStatus("A12");
							updateDAO.execute("update_admit_leader_ttas", jntciAttendance04selectInput);
							updateDAO.execute("update_admit_leader_ttlm", jntciAttendance04selectInput);
						}
						}else{
							messages.add("message", new BLogicMessage(
		    						"errors.attendance05.timeOut1",jntciAttendance04selectInput.getLeaveId()));
						    result.setErrors(messages);
						}
					 }

					}
				}
		}else {
		//休假审查页面一括承认
		if(param.getAdmitAllId() != null){
			String admitAllId = "";
			if(param.getAdmitAllId().contains(",")){
				String[] cards = param.getAdmitAllId().split(",");
				for (int i = 0; i < cards.length; i++) {
				    admitAllId = cards[i];

				    JNTCIAttendance04selectInput  jntciAttendance04selectInput=new JNTCIAttendance04selectInput();
				    jntciAttendance04selectInput.setLeaveId(Integer.parseInt(admitAllId));
				    jntciAttendance04selectInput.setUserName(param.getUserName());

				    String admit_leader_lt1=queryDAO.executeForObject("admit_leader_lt", admitAllId, String.class);
	                Double  admit_leader_lt=Double.parseDouble(admit_leader_lt1);
				    String admit_leader_es=queryDAO.executeForObject("admit_leader_es", admitAllId, String.class);


				    String begintime=queryDAO.executeForObject("selectbegintime", admitAllId, String.class);

				    String leave_type=queryDAO.executeForObject("admit_leader_ltT", admitAllId, String.class);
				    String endtime=queryDAO.executeForObject("selectendtime", admitAllId, String.class);
				    double exCount = 0;
		            if(admit_leader_lt1 != null){
		                exCount = Double.parseDouble(admit_leader_lt1);
		            }
		        	List<Date> holidaylist = queryDAO.executeForObjectList("holidaylist", null);




				    Date Systime = new Date();
					SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
					String sfd = dateFormat.format(Systime);

					String start = sfd.substring(0, 8).concat("01");
					int ShenseiM = Integer.parseInt(begintime
							.substring(5, 7));
					int ShenseiY = Integer.parseInt(begintime
							.substring(0, 4));
					int SM = Integer.parseInt(sfd.substring(5, 7));
					int SY = Integer.parseInt(sfd.substring(0, 4));
					int dayCount = GetWorkDay.workDays(start, sfd, holidaylist);
					int ShenseiMNext;
					int ShenseiYNext;
					if (ShenseiM == 12) {
						ShenseiMNext = 1;
						ShenseiYNext = ShenseiY + 1;
					} else {
						ShenseiMNext = ShenseiM + 1;
						ShenseiYNext = ShenseiY;
					}
					if ((ShenseiM >= SM && ShenseiY >= SY)
							|| (dayCount < 4 && ShenseiMNext == SM && ShenseiYNext == SY)) {

				 if("A04".equals(admit_leader_es)||"A02".equals(admit_leader_es)){
					  String leave_id =admitAllId;
					    if( leave_id!=null){
							  updateDAO.execute("deleteLeaveDetail", leave_id);
						  }
					if(admit_leader_lt >= 24){
						jntciAttendance04selectInput.setExamineStatus("A01");
						updateDAO.execute("update_admit_leader_ttas", jntciAttendance04selectInput);
						updateDAO.execute("update_admit_leader_ttlm", jntciAttendance04selectInput);
					}else {

						/* List<JNTCIAttendanceVo> detailList = LeaveDetail.getAttendance(jntciAttendance04selectInput.getLeave_id(), jntciAttendance04selectInput.getLeave_starttime(), param.getLeave_endtime(),
			                        exCount, leave_type, holidaylist);
			                for(int i = 0; i < detailList.size(); i++){
			                    updateDAO.execute("leaveDetail", detailList.get(i));
			                }*/
						List<JNTCIAttendanceVo> detailList = LeaveDetail.getAttendance(admitAllId,begintime, endtime,
		                        exCount, leave_type, holidaylist);
		                for(int x = 0; x < detailList.size(); x++){
		                    updateDAO.execute("leaveDetail", detailList.get(x));
		                }
						jntciAttendance04selectInput.setExamineStatus("A03");
						updateDAO.execute("update_admit_leader_ttas", jntciAttendance04selectInput);
						updateDAO.execute("update_admit_leader_ttlm", jntciAttendance04selectInput);

					}

				 }
					}else{
					    messages.add("message", new BLogicMessage(
	    						"errors.attendance05.timeOut1",jntciAttendance04selectInput.getLeaveId()));
					    result.setErrors(messages);


					}

				}
			}
		}
		//休假审查页面一括不承认
		if(param.getUnadmitAllId() != null){
			String unadmitAllId = "";
			if(param.getUnadmitAllId().contains(",")){
				String[] cards = param.getUnadmitAllId().split(",");
				for (int i = 0; i < cards.length; i++) {
				    unadmitAllId = cards[i];

				    JNTCIAttendance04selectInput  jntciAttendance04selectInput=new JNTCIAttendance04selectInput();
				    jntciAttendance04selectInput.setLeaveId(Integer.parseInt(unadmitAllId));
				    jntciAttendance04selectInput.setUserName(param.getUserName());
				    String admit_leader_es=queryDAO.executeForObject("admit_leader_es", unadmitAllId, String.class);

				    String begintime=queryDAO.executeForObject("selectbegintime", unadmitAllId, String.class);
				    Date Systime = new Date();
					SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
					String sfd = dateFormat.format(Systime);
					List<Date> holidaylist = queryDAO.executeForObjectList(
							"holidaylist", null);
					String start = sfd.substring(0, 8).concat("01");
					int ShenseiM = Integer.parseInt(begintime
							.substring(5, 7));
					int ShenseiY = Integer.parseInt(begintime
							.substring(0, 4));
					int SM = Integer.parseInt(sfd.substring(5, 7));
					int SY = Integer.parseInt(sfd.substring(0, 4));
					int dayCount = GetWorkDay.workDays(start, sfd, holidaylist);
					int ShenseiMNext;
					int ShenseiYNext;
					if (ShenseiM == 12) {
						ShenseiMNext = 1;
						ShenseiYNext = ShenseiY + 1;
					} else {
						ShenseiMNext = ShenseiM + 1;
						ShenseiYNext = ShenseiY;
					}
					if ((ShenseiM >= SM && ShenseiY >= SY)
							|| (dayCount < 4 && ShenseiMNext == SM && ShenseiYNext == SY)) {

				           if("A04".equals(admit_leader_es)||"A01".equals(admit_leader_es)||"A03".equals(admit_leader_es)){
				        	    String leave_id =unadmitAllId;
							    if( leave_id!=null){
									  updateDAO.execute("deleteLeaveDetail", leave_id);
								  }
					             jntciAttendance04selectInput.setExamineStatus("A02");
						         updateDAO.execute("update_admit_leader_ttas", jntciAttendance04selectInput);
						         updateDAO.execute("update_admit_leader_ttlm", jntciAttendance04selectInput);
					      }
					}else{
						messages.add("message", new BLogicMessage(
	    						"errors.attendance05.timeOut1",jntciAttendance04selectInput.getLeaveId()));
					    result.setErrors(messages);
					}
				 }

				}
			}
		}
		/*BLogicResult result = new BLogicResult();*/
		result.setResultString("success");
		return result;
	}
}
