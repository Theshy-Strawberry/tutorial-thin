package jp.terasoluna.thin.tutorial.web.transcosmos.blogic;

import java.io.File;
import java.util.Date;
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

public class JNTCIEquipHomePage03BLogic implements
		BLogic<JNTCLOvertimePostMessageInput> {
	private QueryDAO queryDAO = null;

	public QueryDAO getQueryDAO() {
		return queryDAO;
	}

	public void setQueryDAO(QueryDAO queryDAO) {
		this.queryDAO = queryDAO;
	}

	private String uploadPath = this.getClass().getClassLoader()
			.getResource("").getPath()
			+ "../../images/HomePageImg/";

	public BLogicResult execute(JNTCLOvertimePostMessageInput param) {
		String strIndex = param.getStartIndex();	//传递修改的startIndex
		String strRow = param.getRow();
		int startIndex = 0;
		int row = 6;
		if (strIndex != null) {
			startIndex = Integer.parseInt(strIndex);

		}
		if (strRow != null) {
			row = Integer.parseInt(strRow);
		}
		String totalCount = queryDAO.executeForObject("QueryInfoCount", null,
				String.class);

		List<JNTCIEquipHomePageVo> classList = queryDAO.executeForObjectList(
				"QueryView", null);

		List<JNTCIEquipPostMessageVo> postmessage = queryDAO
				.executeForObjectList("QueryInfo", null, startIndex, row);
		for (int i = 0; i < postmessage.size(); i++) {
			String tenpu_path = postmessage.get(i).getTenpu_path();
			try {
				File file = new File(uploadPath + tenpu_path);
				if (file.exists()) {
					tenpu_path = "images/HomePageImg/" + tenpu_path + "?id="
							+ new Date();
				} else {
					tenpu_path = null;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			postmessage.get(i).setTenpu_path(tenpu_path);
		}

		List<JNTCIEquipNoticeMgVo> noticeMg = queryDAO.executeForObjectList(
				"QueryInfo02", null);

		List<JNTCIEquipNoticeMg02Vo> noticeMg02 = queryDAO
				.executeForObjectList("QueryInfo03", null);

		JNTCIEquipHomePageOutput output = new JNTCIEquipHomePageOutput();
		output.setClassList(classList);
		output.setPostmessage(postmessage);
		output.setNoticeMg(noticeMg);
		output.setTotalCount(totalCount);

		output.setNoticeMg02(noticeMg02);

		//传递修改的startIndex
		output.setStartIndex(param.getStartIndex());

		BLogicResult result = new BLogicResult();
		result.setResultObject(output);

		result.setResultString("success");
		return result;
	}
}
