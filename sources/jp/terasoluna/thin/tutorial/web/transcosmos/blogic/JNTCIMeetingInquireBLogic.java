package jp.terasoluna.thin.tutorial.web.transcosmos.blogic;

import java.util.List;

import jp.terasoluna.fw.dao.QueryDAO;
import jp.terasoluna.fw.service.thin.BLogic;
import jp.terasoluna.fw.service.thin.BLogicMessage;
import jp.terasoluna.fw.service.thin.BLogicMessages;
import jp.terasoluna.fw.service.thin.BLogicResult;
import jp.terasoluna.thin.tutorial.web.transcosmos.dto.JNTCIMeetingInquireInfo;
import jp.terasoluna.thin.tutorial.web.transcosmos.dto.JNTCIMeetingInquireInput;
import jp.terasoluna.thin.tutorial.web.transcosmos.dto.JNTCIMeetingInquireOutput;

public class JNTCIMeetingInquireBLogic implements BLogic<JNTCIMeetingInquireInput>{


	private QueryDAO queryDAO;

	public QueryDAO getQueryDAO() {
		return queryDAO;
	}

	public void setQueryDAO(QueryDAO queryDAO) {
		this.queryDAO = queryDAO;
	}

	public BLogicResult execute(JNTCIMeetingInquireInput param) {

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
        String totalCount= queryDAO.executeForObject("getMTRRemarkCount", param, String.class);
         if(startIndex>=Integer.parseInt(totalCount)){
        	 startIndex=startIndex-row;
        	 if(startIndex<0){
        		 startIndex=0;
        	 }
         }
        List<JNTCIMeetingInquireInfo> mtrRemarks = queryDAO.executeForObjectList("getMTRRemark", param, startIndex, row);

        JNTCIMeetingInquireOutput output = new JNTCIMeetingInquireOutput();
        output.setEnd_time_serch(param.getEnd_time_serch());
        output.setStart_time_serch(param.getStart_time_serch());
        output.setRoom_no_serch(param.getRoom_no_serch());
        output.setMtrRemarks(mtrRemarks);
        output.setTotalCount(totalCount);

        BLogicResult result = new BLogicResult();
        result.setResultObject(output);
        result.setResultString("success");
		if(mtrRemarks == null || mtrRemarks.size() == 0){
			BLogicMessages messages = new BLogicMessages();
			messages.add("message", new BLogicMessage("message.null"));
			result.setMessages(messages);
		}
		if (param.getJn_card_serch() != null && !"".equals(param.getJn_card_serch())) {
			boolean isNum = param.getJn_card_serch().matches("[0-9*]{4}");
			if (!isNum) {
				BLogicMessages messages = new BLogicMessages();
				messages.add("message", new BLogicMessage(
						"attendance04.alphaNumericString", "社員カード", "4"));
				result.setMessages(messages);
			}
			output.setJn_card_serch(param.getJn_card_serch());
		}
        return result;
    }

}
