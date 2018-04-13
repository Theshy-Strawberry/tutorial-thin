package jp.terasoluna.thin.tutorial.web.transcosmos.blogic;

import java.util.List;

import jp.terasoluna.fw.dao.QueryDAO;
import jp.terasoluna.fw.service.thin.BLogic;
import jp.terasoluna.fw.service.thin.BLogicMessage;
import jp.terasoluna.fw.service.thin.BLogicMessages;
import jp.terasoluna.fw.service.thin.BLogicResult;
import jp.terasoluna.thin.tutorial.web.transcosmos.dto.JNTCIEquipListInput;
import jp.terasoluna.thin.tutorial.web.transcosmos.dto.JNTCIEquipListOutput;
import jp.terasoluna.thin.tutorial.web.transcosmos.vo.SelectListOutput;

public class JNTCIEquipListBLogic implements BLogic<JNTCIEquipListInput> {

	private QueryDAO queryDAO = null;

	public QueryDAO getQueryDAO() {
		return queryDAO;
	}

	public void setQueryDAO(QueryDAO queryDAO) {
		this.queryDAO = queryDAO;
	}

	public BLogicResult execute(JNTCIEquipListInput param) {

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

		BLogicResult result = new BLogicResult();
		JNTCIEquipListOutput output = new JNTCIEquipListOutput();

        //一覧
		List<SelectListOutput> setsubiList = null;
		//一覧件数
        String  totalCount = null;

		try{
			//一覧件数取得
			 totalCount = queryDAO.executeForObject("getSetsubiListCount", param,
					String.class);
			setsubiList = queryDAO.executeForObjectList("getSetsubiList", param,
					startIndex, row);
		}catch(Exception e){
			e.printStackTrace();
		}
       //一覧件数=0場合
		if("0".equals(totalCount) ){
			BLogicMessages messages = new BLogicMessages();
			messages.add("message", new BLogicMessage("message.null",
					param));
			result.setErrors(messages);
			result.setResultString("failure");
			return result;
		}

		String userId = null;
		String userName= null;
		String shokika="--" ;
		for ( int i=0;i<setsubiList.size();i++ ) {

			 userId = setsubiList.get(i).getUserId();
			userName=setsubiList.get(i).getUserName();
			if(shokika.equals(userId)){
				setsubiList.get(i).setUserId(userId);
				setsubiList.get(i).setDeptName("--");
				setsubiList.get(i).setHokanbasho("--");
			}else{
				setsubiList.get(i).setUserId(userName+"-"+userId);
			}
		}

		//検索条件の保持
		output.setCode(param.getCode());
		output.setDeptId(param.getDeptId());
		output.setUserId(param.getUserId());

		output.setList(setsubiList);
		output.setTotalCount(totalCount);
		result.setResultObject(output);
		result.setResultString("success");

		return result;
	}

}
