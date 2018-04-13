package jp.terasoluna.thin.tutorial.web.transcosmos.blogic;


import jp.terasoluna.fw.service.thin.BLogic;
import jp.terasoluna.fw.service.thin.BLogicResult;
import jp.terasoluna.thin.tutorial.web.transcosmos.dto.JNTCISeekInput;

public class JNTCImonth2BLogic implements BLogic<JNTCISeekInput>{

    public BLogicResult execute(JNTCISeekInput param) {

        BLogicResult result = new BLogicResult();
        JNTCISeekInput out = new JNTCISeekInput();

        out.setJn_card(param.getJn_card());
        out.setUser_name(param.getUser_name());
        out.setSeek_query(1);
        out.setYymm(param.getYymm());
        out.setUser_id(param.getUser_id());
        result.setResultObject(out);
        result.setResultString("success");
        return result;
    }
}
