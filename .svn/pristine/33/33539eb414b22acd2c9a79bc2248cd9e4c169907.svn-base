package jp.terasoluna.thin.tutorial.web.transcosmos.blogic;

import jp.terasoluna.fw.dao.UpdateDAO;
import jp.terasoluna.fw.service.thin.BLogic;
import jp.terasoluna.fw.service.thin.BLogicResult;
import jp.terasoluna.thin.tutorial.web.transcosmos.dto.JNTCIOverTimeVerifyResultInput;

public class JNTCIOverTimeVerifyDeleteBLogic implements
		BLogic<JNTCIOverTimeVerifyResultInput> {

	private UpdateDAO updateDAO = null;

	public void setUpdateDAO(UpdateDAO updateDAO) {
		this.updateDAO = updateDAO;
	}

	public BLogicResult execute(JNTCIOverTimeVerifyResultInput overtime) {
		if (overtime.getDeleteExtra_Id() != null) {
			String deleteExtra_Id = "";
			if (overtime.getDeleteExtra_Id().contains(",")) {
				String[] cards = overtime.getDeleteExtra_Id().split(",");
				for (int i = 0; i < cards.length; i++) {
					deleteExtra_Id = cards[i];
					updateDAO.execute("deleteOverTimeById", deleteExtra_Id);
				}
			} else {
				deleteExtra_Id = overtime.getDeleteExtra_Id();
				updateDAO.execute("deleteOverTimeById", deleteExtra_Id);

			}
		}
		return new BLogicResult();
	}

}
