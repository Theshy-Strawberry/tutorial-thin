package jp.terasoluna.thin.tutorial.web.transcosmos.blogic;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import jp.terasoluna.fw.dao.QueryDAO;
import jp.terasoluna.fw.dao.UpdateDAO;
import jp.terasoluna.fw.service.thin.BLogic;
import jp.terasoluna.fw.service.thin.BLogicMessage;
import jp.terasoluna.fw.service.thin.BLogicMessages;
import jp.terasoluna.fw.service.thin.BLogicResult;
import jp.terasoluna.thin.tutorial.web.transcosmos.dto.Winput;


public class JNTCIHolidayUpdateExteaByidBLogic implements BLogic<Winput>{
	private UpdateDAO updateDAO = null;
	private QueryDAO  queryDAO  = null;
	public QueryDAO getQueryDAO() {
		return queryDAO;
	}

	public void setQueryDAO(QueryDAO queryDAO) {
		this.queryDAO = queryDAO;
	}

	public BLogicResult execute(Winput param) {
		String startholidaydate=param.getStartholidaydate();
		String endholidaydate=param.getEndholidaydate();
        String startdate=queryDAO.executeForObject("selectstartdate",param,String.class);
        String enddate=queryDAO.executeForObject("selectenddate",param,String.class);
        if(startholidaydate.equals(startdate)&&endholidaydate.equals(enddate)){
        	  updateDAO.execute("updateHolidayByID", param);
        }else{
        	  updateDAO.execute("updateHolidayByID", param);
        	  updateDAO.execute("deleteXDayByID", param);
   		      SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
   	          try{
   	              Date dateOne = dateFormat.parse(startholidaydate);
   	              Date dateTwo = dateFormat.parse(endholidaydate);
   	              Calendar calendar = Calendar.getInstance();
   	              calendar.setTime(dateOne);
   	              while(calendar.getTime().before(dateTwo)||calendar.getTime().equals(dateTwo)){
   	                  String xDay=dateFormat.format(calendar.getTime());
   	                  param.setxDay(xDay);
   	                  calendar.add(Calendar.DAY_OF_MONTH, 1);
   	                  updateDAO.execute("addDay", param);
   	              }
   	          }catch(Exception e){
   		              e.printStackTrace();
   		        }
        }
        BLogicResult result = new BLogicResult();
		BLogicMessages messages = new BLogicMessages();
		messages.add("message", new BLogicMessage("homepage04.insert.success"));
        result.setResultString("success");
        result.setMessages(messages);
		return result;
	}
	public UpdateDAO getUpdateDAO() {
		return updateDAO;
	}

	public void setUpdateDAO(UpdateDAO updateDAO) {
		this.updateDAO = updateDAO;
	}
}
