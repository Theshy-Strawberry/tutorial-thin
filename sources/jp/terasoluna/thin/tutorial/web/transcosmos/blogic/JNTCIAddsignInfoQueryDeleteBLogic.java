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
import jp.terasoluna.thin.tutorial.web.transcosmos.vo.JNTCIAddsignInfoVo;

public class JNTCIAddsignInfoQueryDeleteBLogic implements
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

    public BLogicResult execute(JNTCIAddsignInfoInput InfoQueryDelete) {
    	BLogicResult result= new BLogicResult();
    	BLogicMessages messages = new BLogicMessages();
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
                        InfoQueryDelete.setJN_CARD(vo.getJN_CARD());
                        InfoQueryDelete.setReason_type(vo.getReason_type());
                        InfoQueryDelete.setUSER_NAME(vo.getPerson());
                        String userId=queryDAO.executeForObject("selectuserId", InfoQueryDelete, String.class);
                        InfoQueryDelete.setUserId(userId);

                        if(!("".equals(vo.getStart_time_add())||vo.getStart_time_add()==null)){
                        	String day= vo.getStart_time_add().substring(0, 10);
        					InfoQueryDelete.setStart_time_add_search(day);
                        }
                        if(! ("".equals(vo.getEnd_time_add())||vo.getEnd_time_add()==null)) {
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


                        if("A06".equals(status)){
                        	if((ShenseiM==SM&&ShenseiY==SY)||(dayCount<4&&ShenseiMNext==SM&&ShenseiYNext==SY)){
	            				if ("午前修正".equals(vo.getRETROACTIVE_TYPE())) {
	            					//数据库取出补卡前的时间，并把*_time_before变为空
	            					String startTimeBefore=queryDAO.executeForObject("selectStartTimeBefore", InfoQueryDelete, String.class);
	            					InfoQueryDelete.setStart_time_add(startTimeBefore);
	            					InfoQueryDelete.setStart_time_before(null);
	            					InfoQueryDelete.setJN_CARD(vo.getJN_CARD());
	            					updateDAO.execute("addManager_update_starttime", InfoQueryDelete);
	            					String endTimeDB=queryDAO.executeForObject("selectEndTime", InfoQueryDelete, String.class);
	        						double timeCount=TimeCompare.getTimeCount(startTimeBefore, endTimeDB);
	        						InfoQueryDelete.setTimeCount(timeCount);
	        						Date now =new Date();
	        						InfoQueryDelete.setToroku_timeStamp(now);
	        						InfoQueryDelete.setMonth(startTimeBefore.substring(5,7));
	        						updateDAO.execute("updateManager", InfoQueryDelete);
	            					updateDAO.execute("deleteAddsign", InfoQueryDelete);
	            				}
	            				else if ("午後修正".equals(vo.getRETROACTIVE_TYPE())) {
	            					//数据库取出补卡前的时间，并把*_time_before变为空
	            					String endTimeBefore=queryDAO.executeForObject("selectEndTimeBefore", InfoQueryDelete, String.class);
	            					InfoQueryDelete.setEnd_time_add(endTimeBefore);
	            					InfoQueryDelete.setEnd_time_before(null);
	            					InfoQueryDelete.setJN_CARD(vo.getJN_CARD());
	            					updateDAO.execute("addManager_update_endtime",InfoQueryDelete );
	            					String startTimeDB=queryDAO.executeForObject("selectStartTime", InfoQueryDelete, String.class);
	        						double timeCount=TimeCompare.getTimeCount(startTimeDB, endTimeBefore);
	        						InfoQueryDelete.setTimeCount(timeCount);
	        						Date now =new Date();
	        						InfoQueryDelete.setToroku_timeStamp(now);
	        						InfoQueryDelete.setMonth(endTimeBefore.substring(5,7));
	        						updateDAO.execute("updateManager", InfoQueryDelete);
	            					updateDAO.execute("deleteAddsign", InfoQueryDelete);
	            				}
	            				else {
	            					updateDAO.execute("deleteAddsign", InfoQueryDelete);
	            					updateDAO.execute("deleteManager", InfoQueryDelete);
	            				}
                        	}
                        	else {
                				messages.add("message", new BLogicMessage(
                						"errors.attendance05.timeOut1",InfoQueryDelete.getRETROACTIVE_ID()));

							}
            			} else {
            				updateDAO.execute("deleteAddsign", InfoQueryDelete);
            			}
					}
                }
                result.setErrors(messages);
            } else {
                deleteExtra_Id = InfoQueryDelete.getDeleteExtra_Id();
                String card_id=deleteExtra_Id;
                InfoQueryDelete.setRETROACTIVE_ID(deleteExtra_Id);
                JNTCIAddsignInfoVo vo=queryDAO.executeForObject("gerenList", card_id, JNTCIAddsignInfoVo.class);
                if (vo!=null) {
                    String status=vo.getRETROACTIVE_STATUS();
                    InfoQueryDelete.setJN_CARD(vo.getJN_CARD());
                    InfoQueryDelete.setReason_type(vo.getReason_type());
                    InfoQueryDelete.setUSER_NAME(vo.getPerson());
                    String userId=queryDAO.executeForObject("selectuserId", InfoQueryDelete, String.class);
                    InfoQueryDelete.setUserId(userId);

                    if(!("".equals(vo.getStart_time_add())||vo.getStart_time_add()==null)){
                    	String day= vo.getStart_time_add().substring(0, 10);
    					InfoQueryDelete.setStart_time_add_search(day);
                    }
                    if (!("".equals(vo.getEnd_time_add())||vo.getEnd_time_add()==null)) {
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

                    if("A06".equals(status)){
                    	if((ShenseiM==SM&&ShenseiY==SY)||(dayCount<4&&ShenseiMNext==SM&&ShenseiYNext==SY)){
	                    	if ("午前修正".equals(vo.getRETROACTIVE_TYPE())) {
	        					//数据库取出补卡前的时间，并把*_time_before变为空
	        					String startTimeBefore=queryDAO.executeForObject("selectStartTimeBefore", InfoQueryDelete, String.class);
	        					InfoQueryDelete.setStart_time_add(startTimeBefore);
	        					String endTimeBefore=queryDAO.executeForObject("selectEndTimeBefore", InfoQueryDelete, String.class);
	        					InfoQueryDelete.setStart_time_add(startTimeBefore);
	        					InfoQueryDelete.setEnd_time_add(endTimeBefore);
	        					InfoQueryDelete.setStart_time_before(null);
	        					InfoQueryDelete.setEnd_time_before(null);
	        					InfoQueryDelete.setJN_CARD(vo.getJN_CARD());
	        					updateDAO.execute("addManager_update_starttime", InfoQueryDelete);
	        					if("4".equals(InfoQueryDelete.getReason_type())){
	        						updateDAO.execute("addManager_update_endtime", InfoQueryDelete);
	        					}
	        					String endTimeDB=queryDAO.executeForObject("selectEndTime", InfoQueryDelete, String.class);
	    						double timeCount=TimeCompare.getTimeCount(startTimeBefore, endTimeDB);
	    						InfoQueryDelete.setTimeCount(timeCount);
	    						Date now =new Date();
	    						InfoQueryDelete.setToroku_timeStamp(now);
	    						InfoQueryDelete.setMonth(startTimeBefore.substring(5,7));
	    						updateDAO.execute("updateManager", InfoQueryDelete);
	        					updateDAO.execute("deleteAddsign", InfoQueryDelete);
	        				}
	        				else if ("午後修正".equals(vo.getRETROACTIVE_TYPE())) {
	        					//数据库取出补卡前的时间，并把*_time_before变为空
	        					String startTimeBefore=queryDAO.executeForObject("selectStartTimeBefore", InfoQueryDelete, String.class);
	        					String endTimeBefore=queryDAO.executeForObject("selectEndTimeBefore", InfoQueryDelete, String.class);
	        					InfoQueryDelete.setStart_time_add(startTimeBefore);
	        					InfoQueryDelete.setEnd_time_add(endTimeBefore);
	        					InfoQueryDelete.setStart_time_before(null);
	        					InfoQueryDelete.setEnd_time_before(null);
	        					InfoQueryDelete.setJN_CARD(vo.getJN_CARD());
	        					updateDAO.execute("addManager_update_endtime",InfoQueryDelete );
	        					if("4".equals(InfoQueryDelete.getReason_type())){
	        						updateDAO.execute("addManager_update_starttime", InfoQueryDelete);
	        					}
	        					String startTimeDB=queryDAO.executeForObject("selectStartTime", InfoQueryDelete, String.class);
	    						double timeCount=TimeCompare.getTimeCount(startTimeDB, endTimeBefore);
	    						InfoQueryDelete.setTimeCount(timeCount);

	    						Date now =new Date();
	    						InfoQueryDelete.setToroku_timeStamp(now);
	    						InfoQueryDelete.setMonth(endTimeBefore.substring(5,7));
	    						updateDAO.execute("updateManager", InfoQueryDelete);
	        					updateDAO.execute("deleteAddsign", InfoQueryDelete);
	        				}
	        				else {
	        					updateDAO.execute("deleteAddsign", InfoQueryDelete);
	        					updateDAO.execute("deleteManager", InfoQueryDelete);
	        				}
                    	}
                    	else {
            				messages.add("message", new BLogicMessage(
            						"errors.attendance05.timeOut"));
            				result.setErrors(messages);
						}
                    }
                }
                updateDAO.execute("deleteAddsignInfoById", deleteExtra_Id);
            }
        }
    	JNTCIAddsignInfoInput output=new JNTCIAddsignInfoInput();
    	output.setStartIndex(InfoQueryDelete.getStartIndex());
    	output.setJN_CARD_SEARCH(InfoQueryDelete.getJN_CARD_SEARCH());
    	output.setUSER_NAME_SEARCH(InfoQueryDelete.getUSER_NAME_SEARCH());
    	output.setRetroactive_type2(InfoQueryDelete.getRetroactive_type2());
    	output.setRetroactive_auditss_search(InfoQueryDelete.getRetroactive_auditss_search());
    	output.setRetroactive_starttime_search(InfoQueryDelete.getRetroactive_starttime_search());
    	output.setRetroactive_endtime_search(InfoQueryDelete.getRetroactive_endtime_search());
    	result.setResultObject(output);
    	result.setResultString("success");
        return result;
    }

}
