package jp.terasoluna.thin.tutorial.web.transcosmos.blogic;

import java.util.List;

import jp.terasoluna.fw.dao.QueryDAO;
import jp.terasoluna.fw.service.thin.BLogic;
import jp.terasoluna.fw.service.thin.BLogicResult;
import jp.terasoluna.thin.tutorial.web.transcosmos.dto.JNTCIEquipHomePageOutput;
import jp.terasoluna.thin.tutorial.web.transcosmos.dto.JNTCLOvertimePostMessageInput;
import jp.terasoluna.thin.tutorial.web.transcosmos.vo.JNTCIEquipHomePageVo;
import jp.terasoluna.thin.tutorial.web.transcosmos.vo.JNTCIEquipNoticeMg02Vo;
import jp.terasoluna.thin.tutorial.web.transcosmos.vo.JNTCIEquipNoticeMgVo;
import jp.terasoluna.thin.tutorial.web.transcosmos.vo.JNTCIEquipPostMessageVo;

public class JNTCIEquipHomePageBLogic implements BLogic<JNTCLOvertimePostMessageInput>{
	private QueryDAO queryDAO = null;
	public QueryDAO getQueryDAO() {
		return queryDAO;
	}
	public void setQueryDAO(QueryDAO queryDAO) {
		this.queryDAO = queryDAO;
	}

	public BLogicResult execute(JNTCLOvertimePostMessageInput param){

		String strIndex = param.getStartIndex();
		String strRow = param.getRow();
		int startIndex = 0;
		int row = 10;
		if (strIndex != null) {
			startIndex = Integer.parseInt(strIndex);

		}
		if (strRow != null) {
			row = Integer.parseInt(strRow);
		}
		String totalCount = queryDAO.executeForObject("QueryInfo04",null,String.class);

		List<JNTCIEquipHomePageVo> classList =  queryDAO.executeForObjectList("QueryView",null);

		List<JNTCIEquipPostMessageVo> postmessage = queryDAO.executeForObjectList("QueryInfo",null);

		List<JNTCIEquipNoticeMgVo> noticeMg = queryDAO.executeForObjectList("QueryInfo02",null,startIndex, row);

		List<JNTCIEquipNoticeMg02Vo> noticeMg02 = queryDAO.executeForObjectList("QueryInfo03",null);

		JNTCIEquipHomePageOutput output = new JNTCIEquipHomePageOutput();
		output.setClassList(classList);
		output.setPostmessage(postmessage);
		output.setNoticeMg(noticeMg);
		output.setNoticeMg02(noticeMg02);
		output.setTotalCount(totalCount);


		//返回用
		output.setStartIndex(param.getStartIndex());

		BLogicResult result = new BLogicResult();
		result.setResultObject(output);
		result.setResultString("success");
		return result;
	}
}
