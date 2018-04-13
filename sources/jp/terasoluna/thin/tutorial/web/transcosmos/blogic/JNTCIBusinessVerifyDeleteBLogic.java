package jp.terasoluna.thin.tutorial.web.transcosmos.blogic;

import jp.terasoluna.fw.dao.QueryDAO;
import jp.terasoluna.fw.dao.UpdateDAO;
import jp.terasoluna.fw.service.thin.BLogic;
import jp.terasoluna.fw.service.thin.BLogicMessage;
import jp.terasoluna.fw.service.thin.BLogicMessages;
import jp.terasoluna.fw.service.thin.BLogicResult;
import jp.terasoluna.thin.tutorial.web.transcosmos.dto.JNTCIBusinessVerify01Input;

public class JNTCIBusinessVerifyDeleteBLogic implements
		BLogic<JNTCIBusinessVerify01Input> {
	private QueryDAO queryDAO = null;

	public QueryDAO getQueryDAO() {
		return queryDAO;
	}

	/**
	 * QueryDAO??????B
	 *
	 * @param queryDAO
	 */
	public void setQueryDAO(QueryDAO queryDAO) {
		this.queryDAO = queryDAO;
	}
	private UpdateDAO updateDAO = null;

	public void setUpdateDAO(UpdateDAO updateDAO) {
		this.updateDAO = updateDAO;
	}

	public BLogicResult execute(JNTCIBusinessVerify01Input param) {
		BLogicMessages messages = new BLogicMessages();
		BLogicResult result = new BLogicResult();
		if("1072".equals(param.getUserId())){
			messages.add("message", new BLogicMessage("message.deletefail"));
			result.setMessages(messages);
		}else{
		if (param.getDeleteId_card() != null) {
			String deleteId_card = "";
			if (param.getDeleteId_card().contains(",")) {
				String[] cards = param.getDeleteId_card().split(",");
				for (int i = 0; i < cards.length; i++) {
					deleteId_card = cards[i];
					String examineStatus=queryDAO.executeForObject("selectexamineStatus",deleteId_card,String.class);
					if("A05".equals(examineStatus)||"A06".equals(examineStatus)){
						messages.add("message",new BLogicMessage("errors.shujucaozuo",deleteId_card));
						  result.setMessages(messages);
					}else{
						updateDAO.execute("deleteBusinessVerify", deleteId_card);
					}

				}
			} else {
				deleteId_card = param.getDeleteId_card();
				String examineStatus=queryDAO.executeForObject("selectexamineStatus",deleteId_card,String.class);
				if("A05".equals(examineStatus)||"A06".equals(examineStatus)){
					messages.add("message",new BLogicMessage("errors.shujucaozuo",deleteId_card));
					  result.setMessages(messages);
				}else{
					updateDAO.execute("deleteBusinessVerify", deleteId_card);
				}

			}

		}
		}

		result.setResultString("success");
    	return result;
	}

}
