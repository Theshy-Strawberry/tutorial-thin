package jp.terasoluna.thin.tutorial.web.transcosmos.blogic;

import jp.terasoluna.fw.dao.QueryDAO;
import jp.terasoluna.fw.service.thin.BLogic;
import jp.terasoluna.fw.service.thin.BLogicMessage;
import jp.terasoluna.fw.service.thin.BLogicMessages;
import jp.terasoluna.fw.service.thin.BLogicResult;
import jp.terasoluna.thin.tutorial.web.transcosmos.dto.JNTCIAddsignInfoInput;
import jp.terasoluna.thin.tutorial.web.transcosmos.dto.JNTCIAddsignInfoOut;
import jp.terasoluna.thin.tutorial.web.transcosmos.vo.JNTCIAddsignInfoVo;

public class JNTCIAuditstatusUpdateBLogic implements
              BLogic<JNTCIAddsignInfoInput> {
       private QueryDAO queryDAO = null;

       public void setQueryDAO(QueryDAO queryDAO) {
              this.queryDAO = queryDAO;
       }

	public BLogicResult execute(JNTCIAddsignInfoInput arg0) {
		 BLogicResult result = new BLogicResult();
		JNTCIAddsignInfoVo vo = queryDAO.executeForObject("gerenList", arg0,
				JNTCIAddsignInfoVo.class);
		JNTCIAddsignInfoOut infoOut = new JNTCIAddsignInfoOut();

              BLogicMessages messages = new BLogicMessages();
              if(vo==null){

      	        messages.add("message",
      	                new BLogicMessage("message.null"));
     			result.setMessages(messages);
     			 result.setResultString("false");
             }else{
                 if ("4".equals(vo.getReason_type())) {
                        vo.setReason_type("公用修正");
                 } else {
                        vo.setReason_type("私用修正");
                 }
                 ;

         		vo.setStartIndex(arg0.getStartIndex());
         		vo.setJN_CARD_SEARCH(arg0.getJN_CARD_SEARCH());
         		vo.setUSER_NAME_SEARCH(arg0.getUSER_NAME_SEARCH());
         		vo.setRetroactive_type2(arg0.getRetroactive_type2());
         		vo.setRetroactive_auditss_search(arg0.getRetroactive_auditss_search());
         		vo.setRetroactive_starttime_search(arg0.getRetroactive_starttime_search());
         		vo.setRetroactive_endtime_search(arg0.getRetroactive_endtime_search());
         		arg0.setUSER_NAME(vo.getUSER_NAME());
            	  result.setResultObject(vo);
                  result.setResultString("success");

              }


              return result;
       }

       }
