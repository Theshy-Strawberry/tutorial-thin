package jp.terasoluna.thin.tutorial.web.transcosmos.blogic;

import java.io.UnsupportedEncodingException;
import java.util.List;

import jp.terasoluna.fw.dao.QueryDAO;
import jp.terasoluna.fw.service.thin.BLogic;
import jp.terasoluna.fw.service.thin.BLogicMessage;
import jp.terasoluna.fw.service.thin.BLogicMessages;
import jp.terasoluna.fw.service.thin.BLogicResult;
import jp.terasoluna.thin.tutorial.web.transcosmos.dto.JNTCIOverTimeVerifyInput;
import jp.terasoluna.thin.tutorial.web.transcosmos.dto.JNTCIOverTimeVerifyOutput;
import jp.terasoluna.thin.tutorial.web.transcosmos.vo.JNTCIOverTimeVerifyOutvo;

public class JNTCIOverTimeVerifyOutBLogic implements
		BLogic<JNTCIOverTimeVerifyInput> {
	private QueryDAO queryDAO = null;

	public BLogicResult execute(JNTCIOverTimeVerifyInput param) {


		String strIndex = param.getStartIndex().trim();
		String strRow = param.getRow();
		int startIndex =0;
		int row = 10;
		if (strIndex != null) {
			startIndex = Integer.parseInt(strIndex);

		}
		if (strRow != null) {
			row = Integer.parseInt(strRow);
		}
		if(param.getUser_name2()!=null &&!"reset".equals(param.getCod())){
    		try {
    			param.setUser_name2(new String(param.getUser_name2().getBytes("ISO-8859-1"),"utf-8"));
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
		BLogicResult result = new BLogicResult();
		JNTCIOverTimeVerifyOutput jntciovertimeout = new JNTCIOverTimeVerifyOutput();
		if("1070".equals(param.getUserId())||"1002".equals(param.getUserId())){
	       	String totalCount= queryDAO.executeForObject("selectTotalCountBoss",param ,String.class);
	       	if(startIndex>= Integer.parseInt(totalCount)){
	       		startIndex=startIndex-row;
	       		if(startIndex<0){
	       			startIndex=0;
	       		}
	       	}
	      	 List<JNTCIOverTimeVerifyOutvo> users = queryDAO.executeForObjectList("getextratimeBoss",param,startIndex, row);
	      	 jntciovertimeout.setUsers(users);
	      	 jntciovertimeout.setTotalCount(totalCount);
	      	 if(users.isEmpty()){
		        	 BLogicMessages messages = new BLogicMessages();
		 	        messages.add("message", new BLogicMessage("message.null"));
		 	        result.setMessages(messages);
		        }
		}else if("1004".equals(param.getUserId())){
			  String totalCount = queryDAO.executeForObject("selectTotalCountGLB",param ,String.class);
			 	if(startIndex>= Integer.parseInt(totalCount)){
		       		startIndex=startIndex-row;
		       		if(startIndex<0){
		       			startIndex=0;
		       		}
		       	}
		       List<JNTCIOverTimeVerifyOutvo> users = queryDAO.executeForObjectList("getextratimeGLB",param,startIndex, row);
		       jntciovertimeout.setUsers(users);
		       jntciovertimeout.setTotalCount(totalCount);
		       if(users.isEmpty()){
		        	 BLogicMessages messages = new BLogicMessages();
		 	        messages.add("message", new BLogicMessage("message.null"));
		 	        result.setMessages(messages);
		        }
		}else if("1003".equals(param.getUserId())){
			 String totalCount = queryDAO.executeForObject("selectTotalCountKFB",param ,String.class);
			 	if(startIndex>= Integer.parseInt(totalCount)){
		       		startIndex=startIndex-row;
		       		if(startIndex<0){
		       			startIndex=0;
		       		}
		       	}
		       List<JNTCIOverTimeVerifyOutvo> users = queryDAO.executeForObjectList("getextratimeKFB",param,startIndex, row);
		       jntciovertimeout.setUsers(users);
		       jntciovertimeout.setTotalCount(totalCount);
		       if(users.isEmpty()){
		        	 BLogicMessages messages = new BLogicMessages();
		 	        messages.add("message", new BLogicMessage("message.null"));
		 	        result.setMessages(messages);
		        }
		}else {
			  String totalCount = queryDAO.executeForObject("selectTotalCountPM",param ,String.class);
			 	if(startIndex>= Integer.parseInt(totalCount)){
		       		startIndex=startIndex-row;
		       		if(startIndex<0){
		       			startIndex=0;
		       		}
		       	}
		       List<JNTCIOverTimeVerifyOutvo> users = queryDAO.executeForObjectList("getextratimePM",param,startIndex, row);
		       jntciovertimeout.setUsers(users);
		       jntciovertimeout.setTotalCount(totalCount);
		       if(users.isEmpty()){
		        	 BLogicMessages messages = new BLogicMessages();
		 	        messages.add("message", new BLogicMessage("message.null"));
		 	        result.setMessages(messages);
		        }
		}
		jntciovertimeout.setUser_id1(param.getUser_id2());
		jntciovertimeout.setExtra_auditss_search(param.getExtra_auditss_search());

	      if(param.getUser_id2()!=null&&!"".equals(param.getUser_id2())){
	      	boolean isNum=param.getUser_id2().matches("[0-9*]{4}");
	      	if(!isNum){
			 BLogicMessages messages = new BLogicMessages();
		        messages.add("message",
		                new BLogicMessage("attendance04.alphaNumericString","社員カード","4"));
		        result.setMessages(messages);
	      }}
	        jntciovertimeout.setDept_id2(param.getDept_id2());
	        jntciovertimeout.setExtra_auditss_search(param.getExtra_auditss_search());
	        jntciovertimeout.setExtra_starttime1(param.getExtra_starttime1());
	        jntciovertimeout.setExtra_endtime1(param.getExtra_endtime1());
	        jntciovertimeout.setUser_id2(param.getUser_id2());
	        jntciovertimeout.setUser_name2(param.getUser_name2());
	        jntciovertimeout.setSelectlist(param.getSelectlist());
			result.setResultObject(jntciovertimeout);
			result.setResultString("success");
			return result;
	}
	public void setQueryDAO(QueryDAO queryDao) {
		this.queryDAO = queryDao;
	}

}
