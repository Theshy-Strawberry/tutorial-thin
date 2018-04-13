package jp.terasoluna.thin.tutorial.web.transcosmos.blogic;

import java.util.List;

import jp.terasoluna.fw.dao.QueryDAO;
import jp.terasoluna.fw.service.thin.BLogic;
import jp.terasoluna.fw.service.thin.BLogicResult;
import jp.terasoluna.thin.tutorial.web.transcosmos.dto.JNTCIMeetingSelectInput;
import jp.terasoluna.thin.tutorial.web.transcosmos.dto.JNTCIMeetingSelectOutput;

public class JNTCIMeetingSelectBLogic implements BLogic<JNTCIMeetingSelectInput> {

	 private  QueryDAO queryDAO = null;

	public void setQueryDAO(QueryDAO queryDAO) {
		this.queryDAO = queryDAO;
	}
     public BLogicResult execute(JNTCIMeetingSelectInput param){

    	List<JNTCIMeetingSelectOutput> list = queryDAO.executeForObjectList("selectTime", param);
    	 BLogicResult result = new BLogicResult();
         result.setResultObject(list);
         result.setResultString("success");
         return result;
     }

}

