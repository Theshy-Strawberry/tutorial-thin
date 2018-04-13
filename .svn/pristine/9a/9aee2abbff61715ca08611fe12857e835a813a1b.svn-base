package jp.terasoluna.thin.tutorial.web.transcosmos.blogic;

import jp.terasoluna.fw.dao.QueryDAO;
import jp.terasoluna.fw.dao.UpdateDAO;
import jp.terasoluna.fw.service.thin.BLogic;
import jp.terasoluna.fw.service.thin.BLogicMessage;
import jp.terasoluna.fw.service.thin.BLogicMessages;
import jp.terasoluna.fw.service.thin.BLogicResult;
import jp.terasoluna.thin.tutorial.web.transcosmos.dto.Winput;

public class JNTCIHolidayTimeDeleteBLogic  implements BLogic<Winput>{
	private UpdateDAO updateDAO = null;
	private QueryDAO queryDAO = null;

    public QueryDAO getQueryDAO() {
        return queryDAO;
    }

    public void setQueryDAO(QueryDAO queryDAO) {
        this.queryDAO = queryDAO;
    }


	public UpdateDAO getUpdateDAO() {
		return updateDAO;
	}

	public void setUpdateDAO(UpdateDAO updateDAO) {
		this.updateDAO = updateDAO;
	}

	public BLogicResult execute(Winput param) {
		BLogicResult result = new BLogicResult();
		BLogicMessages messages = new BLogicMessages();
		messages.add("message", new BLogicMessage("JNTCIPosition.deletesuccess"));
		updateDAO.execute("deleteholidaytime", param);
		int xDayCount = queryDAO.executeForObject("selectxdaycount",param,Integer.class);
		if(xDayCount == 0){
			updateDAO.execute("deleteholidaytime1", param);
			result.setResultString("success1");
			return result;
		}else{
			result.setResultString("success");
	        result.setMessages(messages);
			return result;
		}
	}

}
