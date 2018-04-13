package jp.terasoluna.thin.tutorial.web.transcosmos.blogic;

/*import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;*/

import jp.terasoluna.fw.dao.QueryDAO;
import jp.terasoluna.fw.dao.UpdateDAO;
import jp.terasoluna.fw.service.thin.BLogic;
import jp.terasoluna.fw.service.thin.BLogicMessage;
import jp.terasoluna.fw.service.thin.BLogicMessages;
import jp.terasoluna.fw.service.thin.BLogicResult;
/*import jp.terasoluna.thin.tutorial.web.common.controller.Mail;*/
import jp.terasoluna.thin.tutorial.web.transcosmos.dto.JNTCIBusinessVerify01Output;
import jp.terasoluna.thin.tutorial.web.transcosmos.dto.JNTCIBusinessVerify02Input;


public class JNTCIBusinessVerifyUnSureBLogic implements
BLogic<JNTCIBusinessVerify02Input> {

	/**
	 * QueryDAO?B Spring????C???X?^???X?????????????B
	 */
	private QueryDAO queryDAO = null;

	public QueryDAO getQueryDAO() {
		return queryDAO;
	}

	/**
	 * QueryDAO??????B
	 *
	 * @param queryDAO
	 */
	public void setQueryDAO(QueryDAO queryDAO) {
		this.queryDAO = queryDAO;
	}

	private UpdateDAO updateDAO = null;

	public void setUpdateDAO(UpdateDAO updateDAO) {
		this.updateDAO = updateDAO;
	}

	public UpdateDAO getUpdateDAO() {
		return updateDAO;
	}

public BLogicResult execute(JNTCIBusinessVerify02Input param) {
	 BLogicMessages messages = new BLogicMessages();
	JNTCIBusinessVerify01Output output = new JNTCIBusinessVerify01Output();
	BLogicResult result = new BLogicResult();
	if(param.getUserName()==null){
		String userId=param.getUserId();
		 String userName=queryDAO.executeForObject("selectuserName11", userId, String.class);
		 param.setUserName(userName);
	}
	if("4".equals(param.getFlag())){
	if (param.getDeleteId_card() != null) {
		String deleteId_card = "";
		if (param.getDeleteId_card().contains(",")) {
			String[] cards = param.getDeleteId_card().split(",");
			for (int i = 0; i < cards.length; i++) {
				deleteId_card = cards[i];
				String examineStatus=queryDAO.executeForObject("selectexamineStatus",deleteId_card,String.class);
				 if("A04".equals(examineStatus) || "A01".equals(examineStatus)){
					 updateDAO.execute("JNTCIBusinessVerifyUpdateLeader1", null);
					 updateDAO.execute("JNTCIBusinessVerifyUpdateDisagree", deleteId_card);
				 }else{
						messages.add("message",new BLogicMessage("errors.shujucaozuo",deleteId_card));
				 }
				 result.setErrors(messages);
			}
		}else{
			deleteId_card = param.getDeleteId_card();
			String examineStatus=queryDAO.executeForObject("selectexamineStatus",deleteId_card,String.class);
			 if("A04".equals(examineStatus) || "A01".equals(examineStatus)){
				 updateDAO.execute("JNTCIBusinessVerifyUpdateDisagree", deleteId_card);
				 updateDAO.execute("JNTCIBusinessVerifyUpdateLeader1", null);
			 }else{
				 messages.add("message",new BLogicMessage("errors.shujucaozuo",deleteId_card));
			 }
			 result.setErrors(messages);
		}
	}
	}else if("1".equals(param.getFlag())){
		if (param.getDeleteId_card() != null) {
			String deleteId_card = "";
			if (param.getDeleteId_card().contains(",")) {
				String[] cards = param.getDeleteId_card().split(",");
				for (int i = 0; i < cards.length; i++) {
					deleteId_card = cards[i];
					String examineStatus=queryDAO.executeForObject("selectexamineStatus",deleteId_card,String.class);
					String ShenQingRen=queryDAO.executeForObject("selectShenQingRen",deleteId_card,String.class);
					String id=param.getUserId();
					param.setExamineStatus(examineStatus);
					if("1002".equals(id)){}else{
						if("A06".equals(examineStatus)){
							param.setExamineStatus("");
						}
					}
					if("A01".equals(examineStatus) || "A06".equals(param.getExamineStatus())|| "A04".equals(examineStatus)|| "A08".equals(examineStatus)){
						if("1002".equals(id)){
							 int chaxuncount=queryDAO.executeForObject("JNTCIBusinessVerifycountDeleteChaxun",param,Integer.class);
					    	  if(chaxuncount!=0){
					    		  updateDAO.execute("JNTCIBusinessVerifycountDeleteone", param);
					    	  }
							 param.setExaminePerson(param.getUserName());
							 param.setDeleteId_card(deleteId_card);
							 updateDAO.execute("JNTCIBusinessVerify1UpdateDisagree", param);
						}else{
							 param.setDeleteId_card(deleteId_card);
							 param.setExaminePerson(param.getUserName());
							updateDAO.execute("JNTCIBusinessVerify1Update6Disagree", param);
						}

						/*  int chaxuncount=queryDAO.executeForObject("JNTCIBusinessVerifycountDeleteChaxun",param,Integer.class);
				    	  if(chaxuncount!=0){
				    		  updateDAO.execute("JNTCIBusinessVerifycountDelete", param);
				    	  }*/
				    	  /*String offic_mail=queryDAO.executeForObject("selectyouxiang2",param,String.class);
							String address =offic_mail+ "@trans-cosmos.com.cn";
								InternetAddress sendTo[] = new InternetAddress[1];
								try {
									sendTo[0]= new InternetAddress(address);
								} catch (AddressException e) {
									e.printStackTrace();
								}
								String content ="xingさん<br>お疲れ様です。nameです。<br><br> 申请不批准。<br><br>以上です、よろしくお願い致します。";
								content = content.replaceAll("name", param.getUserName());
								content = content.replaceAll("xing", ShenQingRen.substring(0,1));
								String jncard=param.getUserId();
								String officemail = queryDAO.executeForObject("findOfficEmail",
										jncard, String.class);
								String maillian = "@trans-cosmos.com.cn";
								String from = officemail + maillian;
								String subject="加班申请未批准";
								Mail.sendAll(from, "123456", sendTo, null, null, subject, content,
										null);*/
					}else{
						messages.add("message",new BLogicMessage("errors.shujucaozuo",deleteId_card));
					 }
					 result.setErrors(messages);
				}
			}else{
				deleteId_card = param.getDeleteId_card();
				String examineStatus=queryDAO.executeForObject("selectexamineStatus",deleteId_card,String.class);
				String ShenQingRen=queryDAO.executeForObject("selectShenQingRen",deleteId_card,String.class);
				String id=param.getUserId();
				param.setExamineStatus(examineStatus);
				if("1002".equals(id)){}else{
					if("A06".equals(examineStatus)){
						param.setExamineStatus("");
					}
				}
				if("A01".equals(examineStatus) || "A06".equals(param.getExamineStatus())|| "A04".equals(examineStatus)|| "A08".equals(examineStatus)){
					if("1002".equals(id)){
						 int chaxuncount=queryDAO.executeForObject("JNTCIBusinessVerifycountDeleteChaxun",param,Integer.class);
				    	  if(chaxuncount!=0){
				    		  updateDAO.execute("JNTCIBusinessVerifycountDeleteone", param);
				    	  }
						 param.setExaminePerson(param.getUserName());
						 param.setDeleteId_card(deleteId_card);
						 updateDAO.execute("JNTCIBusinessVerify1UpdateDisagree", param);
					}else{
						 param.setDeleteId_card(deleteId_card);
						 param.setExaminePerson(param.getUserName());
						updateDAO.execute("JNTCIBusinessVerify1Update6Disagree", param);
					}
					/*  int chaxuncount=queryDAO.executeForObject("JNTCIBusinessVerifycountDeleteChaxun",param,Integer.class);
			    	  if(chaxuncount!=0){
			    		  updateDAO.execute("JNTCIBusinessVerifycountDelete", param);
			    	  }*/
			    	  /*String offic_mail=queryDAO.executeForObject("selectyouxiang2",param,String.class);
						String address =offic_mail+ "@trans-cosmos.com.cn";
							InternetAddress sendTo[] = new InternetAddress[1];
							try {
								sendTo[0]= new InternetAddress(address);
							} catch (AddressException e) {
								e.printStackTrace();
							}
							String content ="xingさん<br>お疲れ様です。nameです。<br><br> 申请不批准。<br><br>以上です、よろしくお願い致します。";
							content = content.replaceAll("name", param.getUserName());
							content = content.replaceAll("xing", ShenQingRen.substring(0,1));
							String jncard=param.getUserId();
							String officemail = queryDAO.executeForObject("findOfficEmail",
									jncard, String.class);
							String maillian = "@trans-cosmos.com.cn";
							String from = officemail + maillian;
							String subject="加班申请未批准";
							Mail.sendAll(from, "123456", sendTo, null, null, subject, content,
									null);*/
				}else{
					messages.add("message",new BLogicMessage("errors.shujucaozuo",deleteId_card));
				 }
				 result.setErrors(messages);
			}
		}
	}else if("0".equals(param.getFlag())){

	}else if("1072".equals(param.getUserId())){

	}else{

	        messages.add("message",
	                new BLogicMessage("message.info"));
	        result.setMessages(messages);
	        result.setResultString("success");
	        return result;
	}

	result.setResultString("success");
	output.setDeleteId_card(param.getDeleteId_card());
	output.setUserId(param.getUserId());
	output.setUserName(param.getUserName());
	result.setResultObject(output);
	return result;
}

}
