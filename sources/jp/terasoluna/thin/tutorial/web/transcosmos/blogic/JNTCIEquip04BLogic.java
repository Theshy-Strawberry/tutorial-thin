package jp.terasoluna.thin.tutorial.web.transcosmos.blogic;

import java.util.List;

import jp.terasoluna.fw.dao.QueryDAO;
import jp.terasoluna.fw.dao.UpdateDAO;
import jp.terasoluna.fw.service.thin.BLogic;
import jp.terasoluna.fw.service.thin.BLogicMessage;
import jp.terasoluna.fw.service.thin.BLogicMessages;
import jp.terasoluna.fw.service.thin.BLogicResult;
import jp.terasoluna.thin.tutorial.web.transcosmos.dto.JNTCIEquip04Input;
import jp.terasoluna.thin.tutorial.web.transcosmos.dto.JNTCIEquip04Output;
import jp.terasoluna.thin.tutorial.web.transcosmos.vo.SelectSetsubiShinsa;

public class JNTCIEquip04BLogic implements BLogic<JNTCIEquip04Input> {
	private UpdateDAO updateDAO = null;

	public void setUpdateDAO(UpdateDAO updateDAO) {
		this.updateDAO = updateDAO;
	}
	private QueryDAO queryDAO = null;
	public QueryDAO getQueryDAO() {
		return queryDAO;
	}

	public void setQueryDAO(QueryDAO queryDAO) {
		this.queryDAO = queryDAO;
	}

	public BLogicResult execute(JNTCIEquip04Input param) {

		// 画面のページ数

		String strIndex = param.getStartIndex();
		String strRow = param.getRow();
		int startIndex = 0;
		//画面表示データ数
		int row = 10;
		if (strIndex != null) {
			startIndex = Integer.parseInt(strIndex);
		}
		if (strRow != null) {
			row = Integer.parseInt(strRow);
		}
		String totalCount =null;
		List<SelectSetsubiShinsa> setsubiShinsaList =null;
		BLogicResult result = new BLogicResult();
		BLogicMessages messages = new BLogicMessages();
		//申請日付の検証
		String startTime=param.getShinseiStartDate();
		String endTime=param.getShinseiEndDate();
		if(startTime!=null&&endTime!=null){
			//申請日付の長さ
			int start = startTime.length();
			int end = endTime.length();
			if( start != 0 && end != 0){
		            if(startTime.compareTo(endTime)>0){
		            	messages.add("message", new BLogicMessage("message.dateErrors"));
		    			result.setErrors(messages);
		    			result.setResultString("false");
		    			return result;
		             }
				}
		}
		if(!(param.getQwerr()!=null)){
			param.setDeleteId_card("");
		}
		int CF=queryDAO.executeForObject("JNTCIEquip04ChangeStateCount",
				param,Integer.class);
			if((!(CF==0))&&(!(CF==3))){
				 totalCount = queryDAO.executeForObject("getEquipshinsaCount1",
							param, String.class);
					 //設備審査リストを取得する
					 setsubiShinsaList = queryDAO
							.executeForObjectList("getEquipshinsaList1", param, startIndex,row);
					 if (("1").equals(param.getQwerr())) {
						 param.setQwerr("");
							String deleteId_card = "";
							if (param.getDeleteId_card().contains(",")) {
								String[] cards = param.getDeleteId_card().split(",");
								for (int i = 0; i < cards.length; i++) {
									deleteId_card = cards[i];
									param.setDeleteId_card(deleteId_card);
									updateDAO.execute("deleteList0", param);

								}
							} else {
								deleteId_card = param.getDeleteId_card();
								updateDAO.execute("deleteList0", param);

							}
							messages.add("message", new BLogicMessage("message.deletesucess"));
							result.setMessages(messages);

						}
			}
			else{

				 totalCount = queryDAO.executeForObject("getEquipshinsaCount",param, String.class);
		 //設備審査リストを取得する
		setsubiShinsaList = queryDAO.executeForObjectList("getEquipshinsaList", param, startIndex,row);
		if (("1").equals(param.getQwerr())) {
			String deleteId_card = "";
			if (param.getDeleteId_card().contains(",")) {
				String[] cards = param.getDeleteId_card().split(",");
				for (int i = 0; i < cards.length; i++) {
					deleteId_card = cards[i];
					param.setDeleteId_card(deleteId_card);
					updateDAO.execute("deleteList0",param);
				}
			} else {
				deleteId_card = param.getDeleteId_card();
				updateDAO.execute("deleteList0", param);
			}
			param.setQwerr("");
			messages.add("message", new BLogicMessage("message.deletesucess"));
			result.setMessages(messages);


		}else{}
				 totalCount = queryDAO.executeForObject("getEquipshinsaCount",
							param, String.class);
		 //設備審査リストを取得する
		setsubiShinsaList = queryDAO
				.executeForObjectList("getEquipshinsaList", param, startIndex,row);
		// 設備審査件数を取得

			}
		//検索対象データ = 0件場合
				if("0".equals(totalCount) ){

					messages.add("message", new BLogicMessage("message.null"));
					result.setErrors(messages);
					result.setResultString("false");
					return result;
				}

			for ( int i=0;i<setsubiShinsaList.size();i++ ){

				String 	shinsaHiduke=setsubiShinsaList.get(i).getShinsaHiduke();
                     if(shinsaHiduke!=null){
                    	 setsubiShinsaList.get(i).setShinsaHiduke(shinsaHiduke);
}else{setsubiShinsaList.get(i).setShinsaHiduke("-");
}
				}
			JNTCIEquip04Output output = new JNTCIEquip04Output();
        //検索条件の保持
        output.setDeleteId_card(param.getDeleteId_card());
		output.setMark(param.getMark());
		output.setShenqingId(param.getShenqingId());
		output.setQwerr(param.getQwerr());
		output.setApply_no(param.getApply_no());
		output.setCF(CF);
		output.setStartIndex(param.getStartIndex());
		output.setShinseiStartDate(param.getShinseiStartDate());
		output.setShinseiEndDate(param.getShinseiEndDate());
		output.setUserId(param.getUserId());
		output.setDeptName(param.getDeptName());
		output.setShinsaJyoutai(param.getShinsaJyoutai());
		output.setShinseiDate(param.getShinseiDate());
        output.setShenqingId(param.getShenqingId());
		output.setSetsubiShinsaList(setsubiShinsaList);
		output.setTotalCount(totalCount);
		output.setQwerr(param.getQwerr());
		result.setResultObject(output);
		result.setResultString("success");
		return result;
	}
}