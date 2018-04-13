package jp.terasoluna.thin.tutorial.web.transcosmos.blogic;

import java.sql.Timestamp;
import java.util.Date;

import jp.terasoluna.fw.dao.QueryDAO;
import jp.terasoluna.fw.dao.UpdateDAO;
import jp.terasoluna.fw.service.thin.BLogic;
import jp.terasoluna.fw.service.thin.BLogicMessage;
import jp.terasoluna.fw.service.thin.BLogicMessages;
import jp.terasoluna.fw.service.thin.BLogicResult;
import jp.terasoluna.thin.tutorial.web.common.controller.DateController;
import jp.terasoluna.thin.tutorial.web.transcosmos.dto.JNTCIPositionUpdateInput;
import jp.terasoluna.thin.tutorial.web.transcosmos.dto.JNTCIPositionUpdateOutput;

public class JNTCIPositionUpdateBLogic implements BLogic<JNTCIPositionUpdateInput>{

	//検索DAO
	private QueryDAO queryDAO = null;
	//更新DAO
	private UpdateDAO updateDAO = null;

	public BLogicResult execute(JNTCIPositionUpdateInput param){

		//戻る値
		BLogicResult result = new BLogicResult();
		JNTCIPositionUpdateOutput out = new JNTCIPositionUpdateOutput();
		if(param.getScrollPosit()==null){
			param.setScrollPosit("0");
		}
		out.setScrollPosit(param.getScrollPosit());
		BLogicMessages messages = new BLogicMessages();
		String postion = param.getEmp_Position();
	    String subPosition = postion.substring(0, 1);
	    if("A".equals(subPosition)){
	    	result.setResultString("south");
	    }else{
	    	result.setResultString("north");
	    }
		//個人情報表に指定社員が存在する。
	    int userCount = queryDAO.executeForObject("JNTCIPositionUpdateUserCount", param ,Integer.class);

	    //席次表に指定席号が存在する
	    int positionCount = queryDAO.executeForObject("JNTCIPositionUpdatePositionCount", param ,Integer.class);

	    if(userCount != 1 || positionCount != 1){
			messages.add("message", new BLogicMessage("JNTCIPosition.defect", "座席", "JN_CARD"));
			result.setErrors(messages);
			return result;
	    }

	    // システムタイム定義
	    Timestamp time = DateController.getStringToTimestamp(DateController.getDateToString(new Date(), DateController.YMDHMSs));
	    param.setSystemTime(time);

	    int oldPositionCount = 0;
	    int oldPersonalCount = 0;
	    int newPositioncount = 0;
	    int newPersonalCount = 0;
	    try {
			oldPositionCount = updateDAO.execute("OldPositionUserId", param);
			oldPersonalCount = updateDAO.execute("OldPersonalPositionId", param);
			newPositioncount = updateDAO.execute("NewPositionUserId", param);
			newPersonalCount = updateDAO.execute("NewPersonalPositionId", param);
			if(newPositioncount == 0 || newPersonalCount == 0){
				messages.add("message", new BLogicMessage("JNTCIPosition.updatefailure"));
				result.setErrors(messages);
				return result;
			}
		} catch (Exception e) {
			messages.add("message", new BLogicMessage("JNTCIPosition.updatefailure"));
			result.setErrors(messages);
			return result;
		}


		messages.add("message", new BLogicMessage("JNTCIPosition.updatesuccess"));
		result.setMessages(messages);

		return result;
	}

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

}
