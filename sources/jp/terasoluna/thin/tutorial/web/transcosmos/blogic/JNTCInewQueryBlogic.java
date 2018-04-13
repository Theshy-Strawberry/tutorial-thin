package jp.terasoluna.thin.tutorial.web.transcosmos.blogic;


import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

import jp.terasoluna.fw.dao.QueryDAO;
import jp.terasoluna.fw.dao.UpdateDAO;
import jp.terasoluna.fw.service.thin.BLogic;
import jp.terasoluna.fw.service.thin.BLogicResult;
import jp.terasoluna.thin.tutorial.web.common.controller.DateController;
import jp.terasoluna.thin.tutorial.web.common.controller.GetWorkDay;
import jp.terasoluna.thin.tutorial.web.transcosmos.dto.JNTCIAttenceParamBean;
import jp.terasoluna.thin.tutorial.web.transcosmos.dto.JNTCIAttenceResultBean;


public class JNTCInewQueryBlogic implements BLogic<JNTCIAttenceResultBean> {
	private UpdateDAO updateDAO = null;
	public UpdateDAO getUpdateDAO() {
		return updateDAO;
	}

	public void setUpdateDAO(UpdateDAO updateDAO) {
		this.updateDAO = updateDAO;
	}
	private QueryDAO queryDAO = null;

	public void setQueryDAO(QueryDAO queryDAO) {
		this.queryDAO = queryDAO;
	}


	public QueryDAO getQueryDAO() {
		return queryDAO;
	}


	public BLogicResult execute(JNTCIAttenceResultBean param) {
			BLogicResult result = new BLogicResult();
			JNTCIAttenceParamBean output =new JNTCIAttenceParamBean();
			// システムタイム定義
	        Timestamp time = DateController.getStringToTimestamp(DateController.getDateToString(new Date(), DateController.YMDHMSs));
	        SimpleDateFormat df = new SimpleDateFormat("yyyy/MM");
	        String ym = df.format(time);
	        ym = GetWorkDay.getBeforeMonth(ym);
	        output.setYm(ym);
			result.setResultObject(output);
			result.setResultString("success");
			return result;
	}

}