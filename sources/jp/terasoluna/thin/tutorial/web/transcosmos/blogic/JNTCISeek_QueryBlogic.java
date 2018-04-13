package jp.terasoluna.thin.tutorial.web.transcosmos.blogic;

import jp.terasoluna.fw.service.thin.BLogic;
import jp.terasoluna.fw.service.thin.BLogicResult;
import jp.terasoluna.thin.tutorial.web.transcosmos.dto.JNTCISeekInput;

public class JNTCISeek_QueryBlogic implements BLogic<JNTCISeekInput>{

	public BLogicResult execute(JNTCISeekInput param) {
        BLogicResult result = new BLogicResult();
        JNTCISeekInput out = new JNTCISeekInput();
        out.setScrollPosit(param.getScrollPosit());
        out.setYymm(param.getYymm());
        out.setUser_id(param.getUser_id());
        out.setUser_name(param.getUser_name());
        result.setResultObject(out);
        result.setResultString("success");
        return result;
	}

}
