package jp.terasoluna.thin.tutorial.web.transcosmos.blogic;

import jp.terasoluna.fw.dao.UpdateDAO;
import jp.terasoluna.fw.service.thin.BLogic;
import jp.terasoluna.fw.service.thin.BLogicResult;
import jp.terasoluna.thin.tutorial.web.transcosmos.dto.JNTCIPersonalInfoInquireInput;
import jp.terasoluna.thin.tutorial.web.transcosmos.dto.JNTCIPersonalInfoInquireOutput;

public class JNTCIPersonalInfoDeleteBLogic implements BLogic<JNTCIPersonalInfoInquireInput>{

	private UpdateDAO updateDAO = null;


	public void setUpdateDAO(UpdateDAO updateDAO) {
		this.updateDAO = updateDAO;
	}


	public BLogicResult execute(JNTCIPersonalInfoInquireInput personal) {
		JNTCIPersonalInfoInquireOutput output = new JNTCIPersonalInfoInquireOutput();
		if(personal.getDeleteId_card() != null){
			String deleteId_card = "";
			if(personal.getDeleteId_card().contains(",")){
				String[] cards = personal.getDeleteId_card().split(",");
				for (int i = 0; i < cards.length; i++) {
					deleteId_card = cards[i];
					updateDAO.execute("deletePersonInfoByCrad", deleteId_card);
					updateDAO.execute("deleteQualInfoByCrad", deleteId_card);
					updateDAO.execute("deleteWorkInfoByCrad", deleteId_card);
					updateDAO.execute("deleteUserInfoByCrad", deleteId_card);
				}
			}else {
				deleteId_card = personal.getDeleteId_card();
				updateDAO.execute("deletePersonInfoByCrad", deleteId_card);
				updateDAO.execute("deleteQualInfoByCrad", deleteId_card);
				updateDAO.execute("deleteWorkInfoByCrad", deleteId_card);
				updateDAO.execute("deleteUserInfoByCrad", deleteId_card);
			}
		}
		output.setDeleteId_card(personal.getDeleteId_card());
		BLogicResult result = new BLogicResult();
		String str = "success";
		result.setResultObject(output);
		result.setResultString(str);
		return result;
	}

}
