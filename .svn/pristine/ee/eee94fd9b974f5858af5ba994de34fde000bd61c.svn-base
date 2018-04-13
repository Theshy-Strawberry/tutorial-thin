package jp.terasoluna.thin.tutorial.web.transcosmos.blogic;

import java.util.List;

import jp.terasoluna.fw.dao.QueryDAO;
import jp.terasoluna.fw.service.thin.BLogic;
import jp.terasoluna.fw.service.thin.BLogicResult;
import jp.terasoluna.thin.tutorial.web.transcosmos.dto.Winput;

public class WriteholidayBlogicSelect  implements BLogic<Winput>{
	private QueryDAO queryDAO=null;

	public QueryDAO getQueryDAO() {
		return queryDAO;
	}

	public void setQueryDAO(QueryDAO queryDAO) {
		this.queryDAO = queryDAO;
	}

	public BLogicResult execute(Winput param) {
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
		String totalCount = queryDAO.executeForObject("selectholidayTotalCount",param ,String.class);

		List<Winput> holidaylist1= queryDAO.executeForObjectList("selectholiday",param);
		List<Winput> holidaylist = queryDAO.executeForObjectList("selectholiday",param,startIndex, row);
		Winput output=new Winput();
		output.setHolidaylist(holidaylist);
		output.setHolidaylist1(holidaylist1);
		output.setTotalCount(totalCount);
		output.setName1(param.getName1());
		output.setStartIndex(param.getStartIndex());
		output.setName2(param.getName2());
		output.setStartyear(param.getStartyear());
		output.setEndyear(param.getEndyear());
		BLogicResult result = new BLogicResult();
		result.setResultObject(output);
		result.setResultString("success");
		return result;
	}
}
