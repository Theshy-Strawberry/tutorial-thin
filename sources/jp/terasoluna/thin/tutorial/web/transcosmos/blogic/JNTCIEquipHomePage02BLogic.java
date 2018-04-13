package jp.terasoluna.thin.tutorial.web.transcosmos.blogic;


import jp.terasoluna.fw.dao.QueryDAO;
import jp.terasoluna.fw.service.thin.BLogic;
import jp.terasoluna.fw.service.thin.BLogicMessage;
import jp.terasoluna.fw.service.thin.BLogicMessages;
import jp.terasoluna.fw.service.thin.BLogicResult;
import jp.terasoluna.thin.tutorial.web.transcosmos.dto.JNTCIHomePage02Input;
import jp.terasoluna.thin.tutorial.web.transcosmos.dto.JNTCIHomePage02Output;



public class JNTCIEquipHomePage02BLogic implements BLogic<JNTCIHomePage02Input>{


	private QueryDAO queryDAO=null;

	public QueryDAO getQueryDAO() {
		return queryDAO;
	}

	public void setQueryDAO(QueryDAO queryDAO) {
		this.queryDAO = queryDAO;
	}

	public BLogicResult execute(JNTCIHomePage02Input param) {
		BLogicResult result =new BLogicResult();

		int count = queryDAO.executeForObject("infoCount", param, Integer.class);
		if(count==0){
			result.setResultString("failure");
			BLogicMessages messages = new BLogicMessages();
			messages.add("message",new BLogicMessage("message.selectinfo1"));
			result.setErrors(messages);
		}else{

		JNTCIHomePage02Output infoTitle =queryDAO.executeForObject("infoTitle",param,JNTCIHomePage02Output.class);
		JNTCIHomePage02Output output = new JNTCIHomePage02Output();
		output.setInfo_date(infoTitle.getInfo_date());
		output.setInfo_details(infoTitle.getInfo_details());

		output.setInfo_id(infoTitle.getInfo_id());
		output.setInfo_title(infoTitle.getInfo_title());
		output.setTenpu_path(infoTitle.getTenpu_path());
		output.setUser_name(infoTitle.getUser_name());

		//返回用
		output.setStartIndex(param.getStartIndex());


		result.setResultObject(output);
		result.setResultString("success");
		}
		return result;
	}

}
