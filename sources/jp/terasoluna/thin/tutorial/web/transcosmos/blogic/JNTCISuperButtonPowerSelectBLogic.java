package jp.terasoluna.thin.tutorial.web.transcosmos.blogic;

import jp.terasoluna.fw.dao.QueryDAO;
import jp.terasoluna.fw.service.thin.BLogic;
import jp.terasoluna.fw.service.thin.BLogicMessage;
import jp.terasoluna.fw.service.thin.BLogicMessages;
import jp.terasoluna.fw.service.thin.BLogicResult;
import jp.terasoluna.thin.tutorial.web.transcosmos.dto.JNTCISuperButtonInput;

public class JNTCISuperButtonPowerSelectBLogic implements BLogic<JNTCISuperButtonInput>{
	private QueryDAO queryDAO=null;

	public QueryDAO getQueryDAO() {
		return queryDAO;
	}

	public void setQueryDAO(QueryDAO queryDAO) {
		this.queryDAO = queryDAO;
	}

	public BLogicResult execute(JNTCISuperButtonInput param) {
		BLogicResult result = new BLogicResult();
		String selectcount=queryDAO.executeForObject("selectid", param, String.class);
		if("1".equals(selectcount)){
			JNTCISuperButtonInput output=queryDAO.executeForObject("selectusername", param,JNTCISuperButtonInput.class);
			output.setUsersId(param.getUsersId());
			result.setResultObject(output);
			result.setResultString("success");
		}else if((!"".equals(param.getUsersId()))&& "0".equals(selectcount)){
			BLogicMessages messages = new BLogicMessages();
			messages.add("message", new BLogicMessage("message.selectinfo1"));
			result.setErrors(messages);
			result.setResultString("success1");
		}else if("".equals(param.getUsersId())){
			BLogicMessages messages = new BLogicMessages();
			messages.add("message", new BLogicMessage("message.selectinfo"));
			result.setErrors(messages);
			result.setResultString("success1");
		}
		return result;
	}

}
