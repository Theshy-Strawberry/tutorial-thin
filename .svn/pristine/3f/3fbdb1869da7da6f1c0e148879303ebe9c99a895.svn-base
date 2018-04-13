package jp.terasoluna.thin.tutorial.web.transcosmos.blogic;

import jp.terasoluna.fw.service.thin.BLogic;
import jp.terasoluna.fw.service.thin.BLogicResult;
import jp.terasoluna.thin.tutorial.web.transcosmos.dto.JNTCIQueryInput;

public class JNTCISeek_QueryDetailBlogic implements BLogic<JNTCIQueryInput>{

	public BLogicResult execute(JNTCIQueryInput param) {
		 BLogicResult result = new BLogicResult();
	        JNTCIQueryInput out = new JNTCIQueryInput();
	        out.setScrollPosit(param.getScrollPosit());
	        out.setYm(param.getYm());
	        out.setUser_id(param.getUser_id());
	        result.setResultObject(out);
	        result.setResultString("success");
	        return result;
	}
}
