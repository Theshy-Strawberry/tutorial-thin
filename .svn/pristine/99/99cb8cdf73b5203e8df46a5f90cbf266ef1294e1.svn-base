package jp.terasoluna.thin.tutorial.web.transcosmos.blogic;

import java.util.List;
import jp.terasoluna.fw.dao.QueryDAO;
import jp.terasoluna.fw.service.thin.BLogic;
import jp.terasoluna.fw.service.thin.BLogicResult;
import jp.terasoluna.thin.tutorial.web.transcosmos.dto.JNTCIEmpPositionInput;
import jp.terasoluna.thin.tutorial.web.transcosmos.dto.JNTCIEmpPositionOutput;
import jp.terasoluna.thin.tutorial.web.transcosmos.vo.JNTCIEmpPositionVo;

public class JNTCIEmpInitSouthBlogic implements BLogic<JNTCIEmpPositionInput> {
	private QueryDAO queryDAO = null;

	public QueryDAO getQueryDAO() {
		return queryDAO;
	}

	public void setQueryDAO(QueryDAO queryDAO) {
		this.queryDAO = queryDAO;
	}

	public BLogicResult execute(JNTCIEmpPositionInput arg0) {

		List<JNTCIEmpPositionVo> emplist = queryDAO.executeForObjectList(
				"InitEmpInfoSouth", null);
		int count = emplist.size();
		List<JNTCIEmpPositionVo> infoEmpNoList = queryDAO.executeForObjectList(
				"infoEmpNoListId", null);
		BLogicResult result = new BLogicResult();
		JNTCIEmpPositionOutput out = new JNTCIEmpPositionOutput();
		if(arg0.getScrollPosit() == null){
			arg0.setScrollPosit("0");
			out.setScrollPosit(arg0.getScrollPosit());
		}
		out.setScrollPosit(arg0.getScrollPosit());
		out.setCount(count);
		out.setEmpList(emplist);
		out.setInfoEmpNoList(infoEmpNoList);
		result.setResultObject(out);
		result.setResultString("success");
		return result;

	}

}
