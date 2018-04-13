package jp.terasoluna.thin.tutorial.web.transcosmos.blogic;

import jp.terasoluna.fw.dao.QueryDAO;
import jp.terasoluna.fw.dao.UpdateDAO;
import jp.terasoluna.fw.service.thin.BLogic;
import jp.terasoluna.fw.service.thin.BLogicResult;
import jp.terasoluna.fw.service.thin.BLogicMessage;
import jp.terasoluna.fw.service.thin.BLogicMessages;
import jp.terasoluna.thin.tutorial.web.transcosmos.dto.JNTCIEquipKatabanInput;

public class JNTCIEquipKatabanBLogic implements BLogic<JNTCIEquipKatabanInput> {

	/**
	 * UpdateDAO Springによりインスタンス生成され設定される。
	 */
	private UpdateDAO updateDAO = null;

	private QueryDAO queryDAO = null;

	/**
	 * 登録を行う
	 */
	public BLogicResult execute(JNTCIEquipKatabanInput param) {

		BLogicResult result = new BLogicResult();
		// 付ける単位
		param.setMemori(param.getMemori() + "G");
		param.setHarddisk(param.getHarddisk() + "G");
		param.setHarddisk_total(param.getHarddisk_total() + "G");
		// 設備区分
		String kubun = param.getSetsubi_kuben();
		// 設備！=PJN（主機）場合
		if (!("PJN".equals(kubun))) {
			param.setHost_CPU("");
			param.setCpu_haichi("");
			param.setHarddisk("");
			param.setHarddisk_total("");
			param.setMemori("");
		}
		// 設備型番件数
		String kantabanCount = queryDAO.executeForObject("getKatabanCount",
				param, String.class);

		if (!"0".equals(kantabanCount)) {
			BLogicMessages messages = new BLogicMessages();
			messages.add("message", new BLogicMessage(
					"JNTCIEquip.setsubiKatabanNo", param.getSetsubi_kataban()));
			result.setErrors(messages);
			result.setResultString("failure");
			return result;
		}

		try {
			// 追加設備型番
			updateDAO.execute("insertKataban", param);
		} catch (Exception e) {
			BLogicMessages messages = new BLogicMessages();
			messages.add("message", new BLogicMessage("message.failure",
					"追加した設備型番"));
			result.setErrors(messages);
			result.setResultString("failure");
			return result;
		}

		BLogicMessages messages = new BLogicMessages();
		messages.add("message", new BLogicMessage("message.insert.repeat",
				param.getSetsubi_kataban()));
		result.setMessages(messages);
		result.setResultString("success");

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
