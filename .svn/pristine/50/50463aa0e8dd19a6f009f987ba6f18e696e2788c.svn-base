package jp.terasoluna.thin.tutorial.web.transcosmos.blogic;

import jp.terasoluna.fw.dao.QueryDAO;
import jp.terasoluna.fw.dao.UpdateDAO;
import jp.terasoluna.fw.service.thin.BLogic;
import jp.terasoluna.fw.service.thin.BLogicResult;
import jp.terasoluna.thin.tutorial.web.common.controller.JiaMi;
import jp.terasoluna.thin.tutorial.web.common.controller.Message;
import jp.terasoluna.thin.tutorial.web.transcosmos.dto.JNTCIResetInput;

public class JNTCIResetBLogic implements BLogic<JNTCIResetInput>{

    /**
     * QueryDAO�B
     * Spring�ɂ��C���X�^���X��������ݒ肳���B
     */
    private QueryDAO queryDAO = null;

	/**
     * UpdateDAO�B
     * Spring�ɂ��C���X�^���X��������ݒ肳���B
     */
    private UpdateDAO updateDAO = null;

	public BLogicResult execute(JNTCIResetInput param) {

		BLogicResult result = new BLogicResult();

		String password1 = param.getPassword1();

		String password2 = param.getPassword2();

		String password3 = param.getPassword3();

		if(password1.equals(password2) || password1.equals(password3)){
			result = Message.getMessage("message.passwordreset1", 0);
			return result;
		}else if(!(password2.equals(password3))){
			result = Message.getMessage("message.passwordreset2", 0);
			return result;
		}

		int Count = 0;
		JiaMi jm=new JiaMi();
		try {
			String pwd=param.getPassword1();
			String      encrypted = JiaMi.bytesToHex(jm.encrypt(pwd));
			param.setPassword1(encrypted);
			Count = queryDAO.executeForObject("getCount", param, Integer.class);
			if(Count != 1){
				result = Message.getMessage1("message.failure", 0, "パスワード");
				return result;
			}
		} catch (Exception e) {
			result = Message.getMessage1("message.failure", 0, "パスワード");
			return result;
		}

        int tempCount = 0;
        try {

        String pwd=param.getPassword2();
		String      encrypted = JiaMi.bytesToHex(jm.encrypt(pwd));
		param.setPassword2(encrypted);
			tempCount = updateDAO.execute("resetPassword", param);
			if(tempCount != 1){
				result = Message.getMessage1("message.failure", 0, "パスワード");
				return result;
			}
		} catch (Exception e) {
			result = Message.getMessage1("message.failure", 0, "パスワード");
			return result;
		}

		result = Message.getMessage1("message.success", 1, "パスワード");

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
