package jp.terasoluna.thin.tutorial.web.transcosmos.blogic;

import java.util.List;

import jp.terasoluna.fw.dao.QueryDAO;
import jp.terasoluna.fw.service.thin.BLogic;
import jp.terasoluna.fw.service.thin.BLogicResult;
import jp.terasoluna.thin.tutorial.web.transcosmos.dto.JNTCIMeetingApplyAjaxOutput;
import jp.terasoluna.thin.tutorial.web.transcosmos.dto.JNTCIMeetingApplyInput;

public class AjaxBLogic implements BLogic<JNTCIMeetingApplyInput> {

    private QueryDAO queryDAO = null;

    public void setQueryDAO(QueryDAO queryDAO) {
        this.queryDAO = queryDAO;
    }

    public BLogicResult execute(JNTCIMeetingApplyInput param) {

        if ("0".equals(param.getEmailSearchCode())) {
            param.setOfficeMail(param.getEmailSearchValue());

        } else if ("1".equals(param.getEmailSearchCode())) {
            param.setUsername(param.getEmailSearchValue());

        } else if ("2".equals(param.getEmailSearchCode())) {

            param.setJnCard(param.getEmailSearchValue());
        }
        BLogicResult result = new BLogicResult();
        List<JNTCIMeetingApplyAjaxOutput> list = queryDAO.executeForObjectList(
                "ajaxSearchEmail", param);
        result.setResultObject(list);
        result.setResultString("success");
        return result;

    }
}
