package jp.terasoluna.thin.tutorial.web.transcosmos.blogic;

import jp.terasoluna.fw.dao.QueryDAO;
import jp.terasoluna.fw.service.thin.BLogic;
import jp.terasoluna.fw.service.thin.BLogicResult;
import jp.terasoluna.thin.tutorial.web.transcosmos.dto.JNTCIQueryInput;

public class JNTCIQueryDetailBLogic implements BLogic<JNTCIQueryInput>{

    private QueryDAO queryDAO = null;
    public BLogicResult execute(JNTCIQueryInput param) {

        BLogicResult result = new BLogicResult();
        JNTCIQueryInput out = new JNTCIQueryInput();
        out.setJN_CARD(param.getJN_CARD());
        out.setScrollPosit(param.getScrollPosit());
        out.setYm(param.getYm());
        out.setUser_name(param.getUser_name());
        out.setUser_id(param.getUser_id());
        result.setResultObject(out);
        result.setResultString("success");
        return result;
    }
    public QueryDAO getQueryDAO() {
        return queryDAO;
    }
    public void setQueryDAO(QueryDAO queryDAO) {
        this.queryDAO = queryDAO;
    }


}
