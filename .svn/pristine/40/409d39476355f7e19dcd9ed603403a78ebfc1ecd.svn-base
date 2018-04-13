package jp.terasoluna.thin.tutorial.web.transcosmos.blogic;

import java.sql.Timestamp;
import java.util.Date;

import jp.terasoluna.fw.dao.QueryDAO;
import jp.terasoluna.fw.dao.UpdateDAO;
import jp.terasoluna.fw.service.thin.BLogic;
import jp.terasoluna.fw.service.thin.BLogicResult;
import jp.terasoluna.thin.tutorial.web.common.controller.DateController;
import jp.terasoluna.thin.tutorial.web.common.controller.JiaMi;
import jp.terasoluna.thin.tutorial.web.common.controller.Message;
import jp.terasoluna.thin.tutorial.web.transcosmos.dto.LoginInput;
import jp.terasoluna.thin.tutorial.web.transcosmos.dto.LoginOutput;

public class LoginBLogic implements BLogic<LoginInput> {

	// 照会系のDAO定義
    private QueryDAO queryDAO = null;

    // 更新系のDAO定義
    private UpdateDAO updateDAO = null;

	public BLogicResult execute(LoginInput param) {

		// 戻り値定義
		BLogicResult result = new BLogicResult();

		// システムタイム定義
		Timestamp time = DateController.getStringToTimestamp(DateController.getDateToString(new Date(), DateController.YMDHMSs));

		param.setTime(time);

		// ユーザーが存在するかどうかを判断する
		int tempCount = 0;
		try {
			String pwd=param.getPassword();
			JiaMi jm=new JiaMi();
			String      encrypted = JiaMi.bytesToHex(jm.encrypt(pwd));
			param.setPassword(encrypted);
			tempCount = queryDAO.executeForObject("loginCount", param ,Integer.class);
			if(tempCount != 1){
				result = Message.getMessage2("message.login", 0, "ユーザーID", "パスワード");
				return result;
			}
		} catch (Exception e) {
			result = Message.getMessage2("message.login", 0, "ユーザーID", "パスワード");
			return result;
		}

		// カード番号とユーザー名を得る
		LoginOutput logininfo;
		try {
			logininfo = queryDAO.executeForObject("login", param ,LoginOutput.class);
		} catch (Exception e1) {
			result = Message.getMessage1("message.failure", 0, "検索");
			return result;
		}

		//
        String flag = logininfo.getFlag();
        param.setFlag(flag);
        String flagName = queryDAO.executeForObject("flagName", param, String.class);
        logininfo.setFlagName(flagName);

        // 登録が成功するか否か判断する
		int retCount = 0;
		try {
			retCount = updateDAO.execute("retCount", param);
			if(retCount != 1){
				result = Message.getMessage1("message.failure", 0, "登録");
				return result;
			}
		} catch (Exception e) {
			result = Message.getMessage1("message.failure", 0, "登録");
			return result;
		}

        // 戻り値の編集
		result.setResultString("success");
        result.setResultObject(logininfo);

        return result;
    }

	// 照会系のDAOのgetメソード
	public QueryDAO getQueryDAO() {
		return queryDAO;
	}

	// 照会系のDAOのsetメソード
	public void setQueryDAO(QueryDAO queryDAO) {
		this.queryDAO = queryDAO;
	}

	// 更新系のDAOのgetメソード
	public UpdateDAO getUpdateDAO() {
		return updateDAO;
	}

	// 更新系のDAOのsetメソード
	public void setUpdateDAO(UpdateDAO updateDAO) {
		this.updateDAO = updateDAO;
	}

}
