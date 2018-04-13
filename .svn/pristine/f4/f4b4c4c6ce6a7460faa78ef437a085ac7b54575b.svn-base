package jp.terasoluna.thin.tutorial.web.transcosmos.blogic;

import jp.terasoluna.fw.dao.QueryDAO;
import jp.terasoluna.fw.dao.UpdateDAO;
import jp.terasoluna.fw.service.thin.BLogic;
import jp.terasoluna.fw.service.thin.BLogicResult;
import jp.terasoluna.fw.service.thin.BLogicMessage;
import jp.terasoluna.fw.service.thin.BLogicMessages;
import jp.terasoluna.thin.tutorial.web.common.controller.Constant;
import jp.terasoluna.thin.tutorial.web.transcosmos.dto.JNTCIEquipInsertInput;

public class JNTCIEquipInsertBLogic implements BLogic<JNTCIEquipInsertInput> {

	/**
	 * QueryDAO Springによりインスタンス生成され設定される。
	 */
	private QueryDAO queryDAO = null;

	/**
	 * UpdateDAO Springによりインスタンス生成され設定される。
	 */
	private UpdateDAO updateDAO = null;

	/**
	 * 登録を行う
	 */
	public BLogicResult execute(JNTCIEquipInsertInput param) {

		BLogicResult result = new BLogicResult();

		//設備が初めて入庫する場合
		//userId=-- 場合は
		param.setUserId("--");
		//deptId= -- 場合は
		param.setDeptId("--");
		// hokanbasho=4場合は入庫
		param.setHokanbasho("4");
		// hokanhoushiki=4場合は入庫
		param.setHokanhoushiki("4");
		// setsubi_state=0場合は入庫
		param.setSetsubi_state("0");
		// shunyuko=0場合は入庫
		param.setShunyuko("0");
        if(!("PJN".equals(param.getSetsubi_kuben()))){
        	param.setMac_address("");
        }
		int setsubi_su =  Integer.parseInt(param.getSetsubi_su());
        //追加データ数 = setsubi_su

		for (int i = 0; i < setsubi_su; i++) {

			try {
				updateDAO.execute("insertSetsubi", param);
			} catch (Exception e) {
				BLogicMessages messages = new BLogicMessages();
				messages.add("message", new BLogicMessage("message.failure",
						"追加"));
				result.setErrors(messages);
				return result;
			}
			String setsubiNo_param = param.getSetsubi_no();
			// AAA
			String setsubino02 = Constant.getSetsubinoSub01(setsubiNo_param);
			// -yyMM-
			String setsubino03 = Constant.getSetsubinoSub02(setsubiNo_param);
			// xxx
			String setsunino04 = Constant.getSetsubinoSub03(setsubiNo_param);
			// paramのsetsubino
			String param_setsubino = "";
			// 取得した番号の後3位，+1
			String added = String.valueOf(Integer.parseInt(setsunino04) + 1);
			if (added.length() == 3) {
				param_setsubino = setsubino02 + setsubino03
						+ String.valueOf(added);
			} else if (added.length() == 2) {
				param_setsubino = setsubino02 + setsubino03 + "0"
						+ String.valueOf(added);
			} else {
				param_setsubino = setsubino02 + setsubino03 + "00"
						+ String.valueOf(added);
			}
			param.setSetsubi_no(param_setsubino);
		}
		// 設備の追加に成功した時
		BLogicMessages messages = new BLogicMessages();
		messages.add("message", new BLogicMessage("message.insert.repeat",
				param.getSetsubi_no()));
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
