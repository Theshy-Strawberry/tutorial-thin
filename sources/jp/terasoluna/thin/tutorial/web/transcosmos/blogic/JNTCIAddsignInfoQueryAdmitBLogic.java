package jp.terasoluna.thin.tutorial.web.transcosmos.blogic;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import jp.terasoluna.fw.dao.QueryDAO;
import jp.terasoluna.fw.dao.UpdateDAO;
import jp.terasoluna.fw.service.thin.BLogic;
import jp.terasoluna.fw.service.thin.BLogicMessage;
import jp.terasoluna.fw.service.thin.BLogicMessages;
import jp.terasoluna.fw.service.thin.BLogicResult;
import jp.terasoluna.thin.tutorial.web.common.controller.GetWorkDay;
import jp.terasoluna.thin.tutorial.web.common.controller.TimeCompare;
import jp.terasoluna.thin.tutorial.web.transcosmos.dto.JNTCIAddsignInfoInput;
import jp.terasoluna.thin.tutorial.web.transcosmos.dto.JNTCIAddsignInfoOut;
import jp.terasoluna.thin.tutorial.web.transcosmos.vo.JNTCIAddsignInfoVo;

public class JNTCIAddsignInfoQueryAdmitBLogic implements
        BLogic<JNTCIAddsignInfoInput> {

    private UpdateDAO updateDAO = null;
    private QueryDAO queryDAO=null;


    public QueryDAO getQueryDAO() {
		return queryDAO;
	}

	public void setQueryDAO(QueryDAO queryDAO) {
		this.queryDAO = queryDAO;
	}

	public void setUpdateDAO(UpdateDAO updateDAO) {
        this.updateDAO = updateDAO;
    }

	BLogicMessages admitList(JNTCIAddsignInfoInput InfoQueryDelete){
		BLogicMessages messages = new BLogicMessages();
		JNTCIAddsignInfoOut output = new JNTCIAddsignInfoOut();
		output.setSureId_card(InfoQueryDelete.getSureId_card());
		output.setStartIndex(InfoQueryDelete.getStartIndex());
		output.setJN_CARD_SEARCH(InfoQueryDelete.getJN_CARD_SEARCH());
		output.setUSER_NAME_SEARCH(InfoQueryDelete.getUSER_NAME_SEARCH());
		output.setRetroactive_type2(InfoQueryDelete.getRetroactive_type2());
		output.setRetroactive_auditss_search(InfoQueryDelete.getRetroactive_auditss_search());
		output.setRetroactive_starttime_search(InfoQueryDelete.getRetroactive_starttime_search());
		output.setRetroactive_endtime_search(InfoQueryDelete.getRetroactive_endtime_search());
		int count = 0;
		if (!("".equals(InfoQueryDelete.getStart_time_add_search())||InfoQueryDelete.getStart_time_add_search()==null)) {
			count = queryDAO.executeForObject("adddaytime", InfoQueryDelete,
					Integer.class);
		}
		if ("午前修正".equals(InfoQueryDelete.getRETROACTIVE_TYPE())) {
			if (count == 1) {
				// 先添加出退勤时间
				String start_time_before = queryDAO.executeForObject(
						"selectStartTime", InfoQueryDelete, String.class);
				InfoQueryDelete.setStart_time_before(start_time_before);
				String end_time_before = queryDAO.executeForObject(
						"selectEndTime", InfoQueryDelete, String.class);
				InfoQueryDelete.setEnd_time_before(end_time_before);
				updateDAO.execute("addManager_update_starttime", InfoQueryDelete);
				String startTimeDB = queryDAO.executeForObject(
						"selectStartTime", InfoQueryDelete, String.class);
				String endTimeDB = queryDAO.executeForObject(
						"selectEndTime", InfoQueryDelete, String.class);
				// 根据公用私用，进行不同的处理，公用就是栋桑，私用就是代于珍，除了
				//数据，唯一的不同就是状态
				if ("5".equals(InfoQueryDelete.getReason_type())) {
					InfoQueryDelete.setTimeCount(TimeCompare.getTimeCount(startTimeDB,
							endTimeDB));
					InfoQueryDelete.setMonth(startTimeDB.substring(5, 7));
					Date now = new Date();
					InfoQueryDelete.setToroku_timeStamp(now);
					updateDAO.execute("updateManager", InfoQueryDelete);

					InfoQueryDelete.setKojyo_time(1);
					String YM = InfoQueryDelete.getStart_time_add_search().substring(
							0, 7);
					InfoQueryDelete.setShnsei_time(YM);
					// 更新补卡申请表
					updateDAO.execute("updateAddSign", InfoQueryDelete);
				} else {
					// 因公直接默认8：30和17：30
					String ST = InfoQueryDelete.getStart_time_add_search().concat(
							" 08:30:00");
					String END = InfoQueryDelete.getStart_time_add_search().concat(
							" 17:30:00");
					InfoQueryDelete.setStart_time_add(ST);
					InfoQueryDelete.setEnd_time_add(END);
					updateDAO.execute("addManager_update_starttime", InfoQueryDelete);
					updateDAO.execute("addManager_update_endtime", InfoQueryDelete);
					InfoQueryDelete.setTimeCount(8);
					Date now = new Date();
					InfoQueryDelete.setToroku_timeStamp(now);
					InfoQueryDelete.setMonth(ST.substring(5, 7));
					updateDAO.execute("updateManager", InfoQueryDelete);
					String YM = InfoQueryDelete.getStart_time_add_search().substring(
							0, 7);
					InfoQueryDelete.setShnsei_time(YM);
					updateDAO.execute("updateAddSign", InfoQueryDelete);
				}
				updateDAO.execute("statusUpdate", InfoQueryDelete);
			} else {
				messages.add("message", new BLogicMessage(
						"errors.attendance05.notexist"));
			}
		} else if ("午後修正".equals(InfoQueryDelete.getRETROACTIVE_TYPE())) {
			if (count == 1) {
				// 进行更新
				String start_time_before = queryDAO.executeForObject(
						"selectStartTime", InfoQueryDelete, String.class);
				InfoQueryDelete.setStart_time_before(start_time_before);
				String end_time_before = queryDAO.executeForObject(
						"selectEndTime", InfoQueryDelete, String.class);
				InfoQueryDelete.setEnd_time_before(end_time_before);
				updateDAO.execute("addManager_update_endtime", InfoQueryDelete);
				String startTimeDB = queryDAO.executeForObject(
						"selectStartTime", InfoQueryDelete, String.class);
				String endTimeDB = queryDAO.executeForObject(
						"selectEndTime", InfoQueryDelete, String.class);

				if ("5".equals(InfoQueryDelete.getReason_type())) {
					InfoQueryDelete.setTimeCount(TimeCompare.getTimeCount(startTimeDB,
							endTimeDB));
					InfoQueryDelete.setMonth(startTimeDB.substring(5, 7));
					Date now = new Date();
					InfoQueryDelete.setToroku_timeStamp(now);
					updateDAO.execute("updateManager", InfoQueryDelete);

					InfoQueryDelete.setKojyo_time(1);
					String YM = InfoQueryDelete.getStart_time_add_search().substring(
							0, 7);
					InfoQueryDelete.setShnsei_time(YM);
					// 更新补卡申请表
					updateDAO.execute("updateAddSign", InfoQueryDelete);

				}
				// 因公
				else {
					String ST = InfoQueryDelete.getStart_time_add_search().concat(
							" 08:30:00");
					String END = InfoQueryDelete.getStart_time_add_search().concat(
							" 17:30:00");
					InfoQueryDelete.setStart_time_add(ST);
					InfoQueryDelete.setEnd_time_add(END);
					updateDAO.execute("addManager_update_starttime", InfoQueryDelete);
					updateDAO.execute("addManager_update_endtime", InfoQueryDelete);
					InfoQueryDelete.setTimeCount(8);
					Date now = new Date();
					InfoQueryDelete.setToroku_timeStamp(now);
					InfoQueryDelete.setMonth(ST.substring(5, 7));
					updateDAO.execute("updateManager", InfoQueryDelete);
					String YM = InfoQueryDelete.getStart_time_add_search().substring(
							0, 7);
					InfoQueryDelete.setShnsei_time(YM);
					updateDAO.execute("updateAddSign", InfoQueryDelete);
				}
				updateDAO.execute("statusUpdate", InfoQueryDelete);
			} else {
				messages.add("message", new BLogicMessage(
						"errors.attendance05.notexist"));
			}
		}
		// 全天补卡
		else {
			if (count == 0) {
				String start_time_before = queryDAO.executeForObject(
						"selectStartTime", InfoQueryDelete, String.class);
				InfoQueryDelete.setStart_time_before(start_time_before);
				String end_time_before = queryDAO.executeForObject(
						"selectEndTime", InfoQueryDelete, String.class);
				InfoQueryDelete.setEnd_time_before(end_time_before);
				updateDAO.execute("addManager_update_alltime", InfoQueryDelete);
				// 查询更新出退勤时间后的时间
				String startTimeDB = queryDAO.executeForObject(
						"selectStartTime", InfoQueryDelete, String.class);
				String endTimeDB = queryDAO.executeForObject(
						"selectEndTime", InfoQueryDelete, String.class);

				if ("5".equals(InfoQueryDelete.getReason_type())) {
					InfoQueryDelete.setTimeCount(TimeCompare.getTimeCount(startTimeDB,
							endTimeDB));
					InfoQueryDelete.setMonth(startTimeDB.substring(5, 7));
					Date now = new Date();
					InfoQueryDelete.setToroku_timeStamp(now);
					updateDAO.execute("updateManager", InfoQueryDelete);
					InfoQueryDelete.setKojyo_time(1);
					String YM = InfoQueryDelete.getStart_time_add_search().substring(
							0, 7);
					InfoQueryDelete.setShnsei_time(YM);
					// 更新补卡申请表
					updateDAO.execute("updateAddSign", InfoQueryDelete);

				}
				// 因公
				else {
					String ST = InfoQueryDelete.getStart_time_add_search().concat(
							" 08:30:00");
					String END = InfoQueryDelete.getStart_time_add_search().concat(
							" 17:30:00");
					InfoQueryDelete.setStart_time_add(ST);
					InfoQueryDelete.setEnd_time_add(END);
					updateDAO.execute("addManager_update_starttime", InfoQueryDelete);
					updateDAO.execute("addManager_update_endtime", InfoQueryDelete);
					InfoQueryDelete.setTimeCount(8);
					Date now = new Date();
					InfoQueryDelete.setToroku_timeStamp(now);
					InfoQueryDelete.setMonth(ST.substring(5, 7));
					updateDAO.execute("updateManager", InfoQueryDelete);
					String YM = InfoQueryDelete.getStart_time_add_search().substring(
							0, 7);
					InfoQueryDelete.setShnsei_time(YM);
					updateDAO.execute("updateAddSign", InfoQueryDelete);

				}
				updateDAO.execute("statusUpdate", InfoQueryDelete);
			} else {
				messages.add("message", new BLogicMessage(
						"errors.attendance05.exist"));
			}
		}
		return messages;
	}
    public BLogicResult execute(JNTCIAddsignInfoInput InfoQueryDelete) {
    	BLogicResult result= new BLogicResult();
    	JNTCIAddsignInfoOut output = new JNTCIAddsignInfoOut();
		output.setSureId_card(InfoQueryDelete.getSureId_card());
		output.setStartIndex(InfoQueryDelete.getStartIndex());
		output.setJN_CARD_SEARCH(InfoQueryDelete.getJN_CARD_SEARCH());
		output.setUSER_NAME_SEARCH(InfoQueryDelete.getUSER_NAME_SEARCH());
		output.setRetroactive_type2(InfoQueryDelete.getRetroactive_type2());
		output.setRetroactive_auditss_search(InfoQueryDelete.getRetroactive_auditss_search());
		output.setRetroactive_starttime_search(InfoQueryDelete.getRetroactive_starttime_search());
		output.setRetroactive_endtime_search(InfoQueryDelete.getRetroactive_endtime_search());
    	BLogicMessages messages = new BLogicMessages();
    	String sysUser=InfoQueryDelete.getUserId();
    	if (InfoQueryDelete.getDeleteExtra_Id() != null) {
            String deleteExtra_Id = "";
            if (InfoQueryDelete.getDeleteExtra_Id().contains(",")) {
                String[] cards = InfoQueryDelete.getDeleteExtra_Id().split(",");
                for (int i = 0; i < cards.length; i++) {
                    deleteExtra_Id = cards[i];
                    String card_id=deleteExtra_Id;
                    InfoQueryDelete.setRETROACTIVE_ID(deleteExtra_Id);
                    JNTCIAddsignInfoVo vo=queryDAO.executeForObject("gerenList", card_id, JNTCIAddsignInfoVo.class);
                    if (vo!=null) {
                        String status=vo.getRETROACTIVE_STATUS();
                        if (!("A06".equals(status))) {
    	                    InfoQueryDelete.setJN_CARD(vo.getJN_CARD());
    	                    InfoQueryDelete.setReason_type(vo.getReason_type());
    	                    InfoQueryDelete.setUSER_NAME(vo.getPerson());
    	                    String userId=queryDAO.executeForObject("selectuserId", InfoQueryDelete, String.class);
    	                    //获取部门id，全天补卡插入使用
    	                    InfoQueryDelete.setK_name(vo.getK_name());
    	                    InfoQueryDelete.setUserId(userId);

    	                    if(!("".equals(vo.getStart_time_add())||vo.getStart_time_add()==null)){
    	                    	InfoQueryDelete.setStart_time_add(vo.getStart_time_add());
    	                    	String day= vo.getStart_time_add().substring(0, 10);
    	    					InfoQueryDelete.setStart_time_add_search(day);
    	                    }
    	                    if (!("".equals(vo.getEnd_time_add())||vo.getEnd_time_add()==null)) {
    	                    	InfoQueryDelete.setEnd_time_add(vo.getEnd_time_add());
    	                    	String day= vo.getEnd_time_add().substring(0, 10);
    	    					InfoQueryDelete.setStart_time_add_search(day);
    						}

    	                	//只能在下个月三个工作日之前之前补卡限制，
    	            		Date Systime = new Date();
    	            		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");//可以方便地修改日期格式
    	            		String sfd = dateFormat.format( Systime );
    	            		List<Date> holidaylist = queryDAO.executeForObjectList("holidaylist", null);
    	            		String start=sfd.substring(0,8).concat("01");

    	            		//申请年月
    	            		int ShenseiM=Integer.parseInt(InfoQueryDelete.getStart_time_add_search().substring(5, 7));
    	            		int ShenseiY=Integer.parseInt(InfoQueryDelete.getStart_time_add_search().substring(0, 4));
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

    	            		if((ShenseiM==SM&&ShenseiY==SY)||(dayCount<4&&ShenseiMNext==SM&&ShenseiYNext==SY)){
    	            			if("1003".equals(sysUser)||"1004".equals(userId)){
    	            					InfoQueryDelete.setExamine_status("A06");
    	        						result.setErrors(admitList(InfoQueryDelete));

    	            			}
    	            			else if ("1070".equals(sysUser)) {
    	            				InfoQueryDelete.setExamine_status("A06");
    	            				result.setErrors(admitList(InfoQueryDelete));
    							}
    	            			else {
    	            				InfoQueryDelete.setExamine_status("A01");
    	    						updateDAO.execute("statusUpdate", InfoQueryDelete);
    							}
    	            		}
    	                    else {
    	            			messages.add("message", new BLogicMessage(
    	            						"errors.attendance05.timeOut1",InfoQueryDelete.getRETROACTIVE_ID()));

    						}
    	            		result.setErrors(messages);
                        }
                    }
                }
            } else {
                deleteExtra_Id = InfoQueryDelete.getDeleteExtra_Id();
                String card_id=deleteExtra_Id;
                InfoQueryDelete.setRETROACTIVE_ID(deleteExtra_Id);
                JNTCIAddsignInfoVo vo=queryDAO.executeForObject("gerenList", card_id, JNTCIAddsignInfoVo.class);
                if (vo!=null) {
                    String status=vo.getRETROACTIVE_STATUS();

                    if (!("A06".equals(status))) {
	                    InfoQueryDelete.setJN_CARD(vo.getJN_CARD());
	                    InfoQueryDelete.setReason_type(vo.getReason_type());
	                    InfoQueryDelete.setUSER_NAME(vo.getPerson());
	                    String userId=queryDAO.executeForObject("selectuserId", InfoQueryDelete, String.class);
	                    //获取部门id，全天补卡插入使用
	                    InfoQueryDelete.setK_name(vo.getK_name());
	                    InfoQueryDelete.setUserId(userId);

	                    if(!("".equals(vo.getStart_time_add())||vo.getStart_time_add()==null)){
	                    	InfoQueryDelete.setStart_time_add(vo.getStart_time_add());
	                    	String day= vo.getStart_time_add().substring(0, 10);
	    					InfoQueryDelete.setStart_time_add_search(day);
	                    }
	                    if (!("".equals(vo.getEnd_time_add())||vo.getEnd_time_add()==null)) {
	                    	InfoQueryDelete.setEnd_time_add(vo.getEnd_time_add());
	                    	String day= vo.getEnd_time_add().substring(0, 10);
	    					InfoQueryDelete.setStart_time_add_search(day);
						}

	                	//只能在下个月三个工作日之前之前补卡限制，
	            		Date Systime = new Date();
	            		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");//可以方便地修改日期格式
	            		String sfd = dateFormat.format( Systime );
	            		List<Date> holidaylist = queryDAO.executeForObjectList("holidaylist", null);
	            		String start=sfd.substring(0,8).concat("01");

	            		//申请年月
	            		int ShenseiM=Integer.parseInt(InfoQueryDelete.getStart_time_add_search().substring(5, 7));
	            		int ShenseiY=Integer.parseInt(InfoQueryDelete.getStart_time_add_search().substring(0, 4));
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

	            		if((ShenseiM==SM&&ShenseiY==SY)||(dayCount<4&&ShenseiMNext==SM&&ShenseiYNext==SY)){
	            			if("1003".equals(sysUser)||"1004".equals(userId)){
	            					InfoQueryDelete.setExamine_status("A06");
	            					messages.add(admitList(InfoQueryDelete));

	            			}
	            			else if ("1070".equals(sysUser)) {
	            				InfoQueryDelete.setExamine_status("A06");
	            				messages.add(admitList(InfoQueryDelete));
							}
	            			else {
	            				InfoQueryDelete.setExamine_status("A01");
	    						updateDAO.execute("statusUpdate", InfoQueryDelete);
							}
	            		}
	                    else {
	            			messages.add("message", new BLogicMessage(
	            						"errors.attendance05.timeOut"));
						}
            			result.setErrors(messages);
	                }
                }
            }
        }
		result.setResultObject(output);
    	result.setResultString("success");
        return result;
    }

}
