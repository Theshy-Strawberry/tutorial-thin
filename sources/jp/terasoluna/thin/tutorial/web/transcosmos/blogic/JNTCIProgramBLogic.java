package jp.terasoluna.thin.tutorial.web.transcosmos.blogic;


import java.util.List;

import jp.terasoluna.fw.dao.QueryDAO;
import jp.terasoluna.fw.service.thin.BLogic;
import jp.terasoluna.fw.service.thin.BLogicResult;
import jp.terasoluna.thin.tutorial.web.transcosmos.dto.JNTCIProgramInput;

public class JNTCIProgramBLogic implements BLogic<JNTCIProgramInput> {

	private QueryDAO queryDAO = null;


	public void setQueryDAO(QueryDAO queryDAO) {
		this.queryDAO = queryDAO;
	}



	public BLogicResult execute(JNTCIProgramInput param){

		BLogicResult result = new BLogicResult();
		System.out.println("===================================");

		//データ再検索
//		List<JNTCIAttendance04selectInfo> JNTCIAttendance04selectInfoList = queryDAO.executeForObjectList("JNTCIAttendance04forward",
//				param);
//if(JNTCIAttendance04selectInfoList.size()!=0){
//
//		//詳細表示
//		JNTCIAttendance04selectInfo JNTCIAttendance04selectInfo = JNTCIAttendance04selectInfoList.get(0);
//
//		JNTCIAttendance04selectInfo.setCod(param.getCd_code());
//		JNTCIAttendance04selectInfo.setExamine_reason(JNTCIAttendance04selectInfo.getExamine_reason());
//		JNTCIAttendance04selectInfo.setStartIndex(param.getStartIndex());
//		JNTCIAttendance04selectInfo.setUserId(param.getUserId());
//		JNTCIAttendance04selectInfo.setApplication_type_serch(param.getApplication_type_serch());
//		JNTCIAttendance04selectInfo.setDept_id_serch(param.getDept_id_serch());
//		JNTCIAttendance04selectInfo.setExamine_status_serch(param.getExamine_status_serch());
//		JNTCIAttendance04selectInfo.setName_serch(param.getName_serch());
//		JNTCIAttendance04selectInfo.setJn_card_serch(param.getJn_card_serch());
//		JNTCIAttendance04selectInfo.setLeave_endtime_serch(param.getLeave_endtime_serch());
//		JNTCIAttendance04selectInfo.setLeave_starttime_serch(param.getLeave_starttime_serch());
//		JNTCIAttendance04selectInfo.setLeave_type_serch(param.getLeave_type_serch());
//		result.setResultObject(JNTCIAttendance04selectInfo);
//		result.setResultString("success");}
//else {
//
//
//	result.setResultString("false");}

		return result;
	}
}
