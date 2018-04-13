package jp.terasoluna.thin.tutorial.web.transcosmos.blogic;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

import jp.terasoluna.fw.dao.QueryDAO;
import jp.terasoluna.fw.dao.UpdateDAO;
import jp.terasoluna.fw.service.thin.BLogic;
import jp.terasoluna.fw.service.thin.BLogicMessage;
import jp.terasoluna.fw.service.thin.BLogicMessages;
import jp.terasoluna.fw.service.thin.BLogicResult;
import jp.terasoluna.thin.tutorial.web.common.controller.GetWorkDay;
import jp.terasoluna.thin.tutorial.web.common.controller.Mail;
import jp.terasoluna.thin.tutorial.web.common.controller.TimeCompare;
import jp.terasoluna.thin.tutorial.web.transcosmos.dto.JNTCIAddsignInfoInput;
import jp.terasoluna.thin.tutorial.web.transcosmos.vo.JNTCIAddsignVO;

public class JNTCIAuditstatusBLogic implements BLogic<JNTCIAddsignInfoInput> {
	private QueryDAO queryDAO = null;
	private UpdateDAO updateDAO = null;

	public QueryDAO getQueryDAO() {
		return queryDAO;
	}

	public void setQueryDAO(QueryDAO queryDAO) {
		this.queryDAO = queryDAO;
	}

	public void setUpdateDAO(UpdateDAO updateDAO) {
		this.updateDAO = updateDAO;
	}

	//最终承认的处理
	private BLogicResult admit(JNTCIAddsignInfoInput arg0) {
		JNTCIAddsignVO JVO = new JNTCIAddsignVO();
		String jncard1 = arg0.getJN_CARD();
		String timestart = arg0.getStart_time_add();
		String timeend = arg0.getEnd_time_add();
		String nianyue =  "";
		if(timestart != null && !"".equals(timestart)){
		    nianyue = timestart.substring(0, 7);
		}else if(timeend != null && !"".equals(timeend)){
		    nianyue = timeend.substring(0, 7);
		}

		JVO.setJN_CARD(jncard1);
		JVO.setYm(nianyue);

		//代玉珍邮箱号
				String daiyuzhen =queryDAO.executeForObject("SearchdaiyuzhenEmail","1070" , java.lang.String.class);
				//代玉珍邮箱
				String daiyuzhenEmail = daiyuzhen+"@trans-cosmos.com.cn";
		// 查询TT_ATTENCE_MANAGER表中是否有当天数据，count=0，则说明需要全天补卡
		int count = 0;
		if (!"".equals(arg0.getStart_time_add_search())) {
			count = queryDAO.executeForObject("adddaytime", arg0,
					Integer.class);
		}
		BLogicResult result = new BLogicResult();
		if ("出勤時間".equals(arg0.getRETROACTIVE_TYPE())) {
			if (count == 1) {
				// 先添加出退勤时间
				String start_time_before = queryDAO.executeForObject(
						"selectStartTime", arg0, String.class);
				arg0.setStart_time_before(start_time_before);
				String end_time_before = queryDAO.executeForObject(
						"selectEndTime", arg0, String.class);
				arg0.setEnd_time_before(end_time_before);
				updateDAO.execute("addManager_update_starttime", arg0);
				String startTimeDB = queryDAO.executeForObject(
						"selectStartTime", arg0, String.class);
				String endTimeDB = queryDAO.executeForObject(
						"selectEndTime", arg0, String.class);
				// 根据公用私用，进行不同的处理，公用就是栋桑，私用就是代于珍，除了
				//数据，唯一的不同就是状态
				if ("私用修正".equals(arg0.getReason_type())) {
					arg0.setTimeCount(TimeCompare.getTimeCount(startTimeDB,
							endTimeDB));
					arg0.setMonth(startTimeDB.substring(5, 7));
					Date now = new Date();
					arg0.setToroku_timeStamp(now);
					updateDAO.execute("updateManager", arg0);

					 Integer buqiantimes  = queryDAO.executeForObject("buqiantimes", JVO,
	        					Integer.class);
	                    if(buqiantimes >= 2){
						arg0.setKojyo_time(0.5);}
	                    else if(buqiantimes < 2){
	                    	arg0.setKojyo_time(0);
	                    }

					String YM = arg0.getStart_time_add_search().substring(
							0, 7);
					arg0.setShnsei_time(YM);
					// 更新补卡申请表
					updateDAO.execute("updateAddSign", arg0);
					updateDAO.execute("statusUpdate", arg0);
					if ("A06".equals(arg0.getExamine_status())) {

						String offic_mail = queryDAO.executeForObject(
								"emailMessage", arg0, String.class);
						String address = offic_mail + "@trans-cosmos.com.cn";
						InternetAddress sendTo[] = new InternetAddress[1];
						try {
							sendTo[0] = new InternetAddress(address);
						} catch (AddressException e) {
							e.printStackTrace();
						}
						String content = "xingさん<br>お疲れ様です。nameです。<br><br>     稼働修正申請批准。<br><br>以上です、よろしくお願い致します。";
						content = content.replaceAll("name",
								arg0.getUserName());
						content = content.replaceAll("xing", arg0
								.getUSER_NAME().substring(0, 1));
						String jncard = arg0.getUserId();
						String officemail = queryDAO.executeForObject(
								"findOfficEmail", jncard, String.class);
						String maillian = "@trans-cosmos.com.cn";
						String from = officemail + maillian;
						String subject = "【系统邮件】【批准】【稼働修正申請】";
						Mail.sendAll(from, "123456", sendTo, null, null,
								subject, content, null);
					}else if("A05".equals(arg0.getExamine_status())){
						String offic_mail = queryDAO.executeForObject(
								"emailMessage", arg0, String.class);
						String address = offic_mail + "@trans-cosmos.com.cn";
						InternetAddress sendTo[] = new InternetAddress[1];
						try {
							sendTo[0] = new InternetAddress(address);
						} catch (AddressException e) {
							e.printStackTrace();
						}
						String content = "xingさん<br>お疲れ様です。nameです。<br><br> 稼働修正申請未批准。<br><br>以上です、よろしくお願い致します。";
						content = content.replaceAll("name",
								arg0.getUserName());
						content = content.replaceAll("xing", arg0
								.getUSER_NAME().substring(0, 1));
						String jncard = arg0.getUserId();
						String officemail = queryDAO.executeForObject(
								"findOfficEmail", jncard, String.class);
						String maillian = "@trans-cosmos.com.cn";
						String from = officemail + maillian;
						String subject = "【系统邮件】【未批准】【稼働修正申請】";
						Mail.sendAll(from, "123456", sendTo, null, null,
								subject, content, null);
					}else{

					}
				} else {
					// 因公直接默认8：30和17：30
					String ST = arg0.getStart_time_add_search().concat(
							" 08:30:00");
					String END = arg0.getStart_time_add_search().concat(
							" 17:30:00");
					arg0.setStart_time_add(ST);
					arg0.setEnd_time_add(END);
					updateDAO.execute("addManager_update_starttime", arg0);
					updateDAO.execute("addManager_update_endtime", arg0);
					arg0.setTimeCount(8);
					Date now = new Date();
					arg0.setToroku_timeStamp(now);
					arg0.setMonth(ST.substring(5, 7));
					updateDAO.execute("updateManager", arg0);
					String YM = arg0.getStart_time_add_search().substring(
							0, 7);
					arg0.setShnsei_time(YM);
					updateDAO.execute("updateAddSign", arg0);
					updateDAO.execute("statusUpdate", arg0);
					if ("A06".equals(arg0.getExamine_status())) {

						String offic_mail = queryDAO.executeForObject(
								"emailMessage", arg0, String.class);
						String address = offic_mail + "@trans-cosmos.com.cn";
						InternetAddress sendTo[] = new InternetAddress[1];
						InternetAddress daiyuzhens[]=new InternetAddress[1];
						try {
										daiyuzhens[0] = new InternetAddress(daiyuzhenEmail);
									} catch (AddressException e) {
										e.printStackTrace();
									}

						try {
							sendTo[0] = new InternetAddress(address);
						} catch (AddressException e) {
							e.printStackTrace();
						}
						String content = "xingさん<br>お疲れ様です。nameです。<br><br>     稼働修正申請批准。<br><br>以上です、よろしくお願い致します。";
						content = content.replaceAll("name",arg0.getUserName());
						content = content.replaceAll("xing", arg0.getUSER_NAME().substring(0, 1));
						String jncard = arg0.getUserId();
						String officemail = queryDAO.executeForObject(
								"findOfficEmail", jncard, String.class);
						String maillian = "@trans-cosmos.com.cn";
						String from = officemail + maillian;

						String subject = "【系统邮件】【批准】【稼働修正申請】";
						Mail.sendAll(from, "123456", sendTo, daiyuzhens, null,
								subject, content, null);
					}else if("A05".equals(arg0.getExamine_status())){
						String offic_mail = queryDAO.executeForObject(
								"emailMessage", arg0, String.class);
						String address = offic_mail + "@trans-cosmos.com.cn";
						InternetAddress sendTo[] = new InternetAddress[1];
						try {
							sendTo[0] = new InternetAddress(address);
						} catch (AddressException e) {
							e.printStackTrace();
						}
						String content = "xingさん<br>お疲れ様です。nameです。<br><br> 稼働修正申請未批准。<br><br>以上です、よろしくお願い致します。";
						content = content.replaceAll("name",
								arg0.getUserName());
						content = content.replaceAll("xing", arg0
								.getUSER_NAME().substring(0, 1));
						String jncard = arg0.getUserId();
						String officemail = queryDAO.executeForObject(
								"findOfficEmail", jncard, String.class);
						String maillian = "@trans-cosmos.com.cn";
						String from = officemail + maillian;
						String subject = "【系统邮件】【未批准】【稼働修正申請】";
						Mail.sendAll(from, "123456", sendTo, null, null,
								subject, content, null);
					}else{

					}
				}

				BLogicMessages messages = new BLogicMessages();
				messages.add("message", new BLogicMessage(
						"message.attendance05.success"));
				result.setMessages(messages);
			} else {
				BLogicMessages messages = new BLogicMessages();
				messages.add("message", new BLogicMessage(
						"errors.attendance05.notexist"));
				result.setErrors(messages);
			}
		} else if ("退勤時間".equals(arg0.getRETROACTIVE_TYPE())) {
			if (count == 1) {
				// 进行更新
				String start_time_before = queryDAO.executeForObject(
						"selectStartTime", arg0, String.class);
				arg0.setStart_time_before(start_time_before);
				String end_time_before = queryDAO.executeForObject(
						"selectEndTime", arg0, String.class);
				arg0.setEnd_time_before(end_time_before);
				updateDAO.execute("addManager_update_endtime", arg0);
				String startTimeDB = queryDAO.executeForObject(
						"selectStartTime", arg0, String.class);
				String endTimeDB = queryDAO.executeForObject(
						"selectEndTime", arg0, String.class);

				if ("私用修正".equals(arg0.getReason_type())) {
					arg0.setTimeCount(TimeCompare.getTimeCount(startTimeDB,
							endTimeDB));
					arg0.setMonth(startTimeDB.substring(5, 7));
					Date now = new Date();
					arg0.setToroku_timeStamp(now);
					updateDAO.execute("updateManager", arg0);

					 Integer buqiantimes  = queryDAO.executeForObject("buqiantimes", JVO,
	        					Integer.class);
	                    if(buqiantimes >= 2){
						arg0.setKojyo_time(0.5);}
	                    else if(buqiantimes < 2){
	                    	arg0.setKojyo_time(0);
	                    }

					String YM = arg0.getStart_time_add_search().substring(
							0, 7);
					arg0.setShnsei_time(YM);
					// 更新补卡申请表
					updateDAO.execute("updateAddSign", arg0);
					updateDAO.execute("statusUpdate", arg0);
					if ("A06".equals(arg0.getExamine_status())) {

						String offic_mail = queryDAO.executeForObject(
								"emailMessage", arg0, String.class);
						String address = offic_mail + "@trans-cosmos.com.cn";
						InternetAddress sendTo[] = new InternetAddress[1];
						try {
							sendTo[0] = new InternetAddress(address);
						} catch (AddressException e) {
							e.printStackTrace();
						}
						String content = "xingさん<br>お疲れ様です。nameです。<br><br>     稼働修正申請批准。<br><br>以上です、よろしくお願い致します。";
						content = content.replaceAll("name",
								arg0.getUserName());
						content = content.replaceAll("xing", arg0
								.getUSER_NAME().substring(0, 1));
						String jncard = arg0.getUserId();
						String officemail = queryDAO.executeForObject(
								"findOfficEmail", jncard, String.class);
						String maillian = "@trans-cosmos.com.cn";
						String from = officemail + maillian;
						String subject = "【系统邮件】【批准】【稼働修正申請】";
						Mail.sendAll(from, "123456", sendTo, null, null,
								subject, content, null);
					}else if("A05".equals(arg0.getExamine_status())){
						String offic_mail = queryDAO.executeForObject(
								"emailMessage", arg0, String.class);
						String address = offic_mail + "@trans-cosmos.com.cn";
						InternetAddress sendTo[] = new InternetAddress[1];
						try {
							sendTo[0] = new InternetAddress(address);
						} catch (AddressException e) {
							e.printStackTrace();
						}
						String content = "xingさん<br>お疲れ様です。nameです。<br><br> 稼働修正申請未批准。<br><br>以上です、よろしくお願い致します。";
						content = content.replaceAll("name",
								arg0.getUserName());
						content = content.replaceAll("xing", arg0
								.getUSER_NAME().substring(0, 1));
						String jncard = arg0.getUserId();
						String officemail = queryDAO.executeForObject(
								"findOfficEmail", jncard, String.class);
						String maillian = "@trans-cosmos.com.cn";
						String from = officemail + maillian;
						String subject = "【系统邮件】【未批准】【稼働修正申請】";
						Mail.sendAll(from, "123456", sendTo, null, null,
								subject, content, null);
					}else{

					}
				}
				// 因公
				else {
					String ST = arg0.getStart_time_add_search().concat(
							" 08:30:00");
					String END = arg0.getStart_time_add_search().concat(
							" 17:30:00");
					arg0.setStart_time_add(ST);
					arg0.setEnd_time_add(END);
					updateDAO.execute("addManager_update_starttime", arg0);
					updateDAO.execute("addManager_update_endtime", arg0);
					arg0.setTimeCount(8);
					Date now = new Date();
					arg0.setToroku_timeStamp(now);
					arg0.setMonth(ST.substring(5, 7));
					updateDAO.execute("updateManager", arg0);
					String YM = arg0.getStart_time_add_search().substring(
							0, 7);
					arg0.setShnsei_time(YM);
					updateDAO.execute("updateAddSign", arg0);
					updateDAO.execute("statusUpdate", arg0);
					if ("A06".equals(arg0.getExamine_status())) {

						String offic_mail = queryDAO.executeForObject(
								"emailMessage", arg0, String.class);
						String address = offic_mail + "@trans-cosmos.com.cn";
						InternetAddress sendTo[] = new InternetAddress[1];
						InternetAddress daiyuzhens[]=new InternetAddress[1];
						try {
										daiyuzhens[0] = new InternetAddress(daiyuzhenEmail);
									} catch (AddressException e) {
										e.printStackTrace();
									}

						try {
							sendTo[0] = new InternetAddress(address);
						} catch (AddressException e) {
							e.printStackTrace();
						}
						String content = "xingさん<br>お疲れ様です。nameです。<br><br>     稼働修正申請批准。<br><br>以上です、よろしくお願い致します。";
						content = content.replaceAll("name",arg0.getUserName());
						content = content.replaceAll("xing", arg0.getUSER_NAME().substring(0, 1));
						String jncard = arg0.getUserId();
						String officemail = queryDAO.executeForObject(
								"findOfficEmail", jncard, String.class);
						String maillian = "@trans-cosmos.com.cn";
						String from = officemail + maillian;
						String subject = "【系统邮件】【批准】【稼働修正申請】";
						Mail.sendAll(from, "123456", sendTo, daiyuzhens, null,
								subject, content, null);
					}else if("A05".equals(arg0.getExamine_status())){
						String offic_mail = queryDAO.executeForObject(
								"emailMessage", arg0, String.class);
						String address = offic_mail + "@trans-cosmos.com.cn";
						InternetAddress sendTo[] = new InternetAddress[1];
						try {
							sendTo[0] = new InternetAddress(address);
						} catch (AddressException e) {
							e.printStackTrace();
						}
						String content = "xingさん<br>お疲れ様です。nameです。<br><br> 稼働修正申請未批准。<br><br>以上です、よろしくお願い致します。";
						content = content.replaceAll("name",
								arg0.getUserName());
						content = content.replaceAll("xing", arg0
								.getUSER_NAME().substring(0, 1));
						String jncard = arg0.getUserId();
						String officemail = queryDAO.executeForObject(
								"findOfficEmail", jncard, String.class);
						String maillian = "@trans-cosmos.com.cn";
						String from = officemail + maillian;
						String subject = "【系统邮件】【未批准】【稼働修正申請】";
						Mail.sendAll(from, "123456", sendTo, null, null,
								subject, content, null);
					}else{

					}
				}

				BLogicMessages messages = new BLogicMessages();
				messages.add("message", new BLogicMessage(
						"message.attendance05.success"));
				result.setMessages(messages);
			} else {
				BLogicMessages messages = new BLogicMessages();
				messages.add("message", new BLogicMessage(
						"errors.attendance05.notexist"));
				result.setErrors(messages);
			}
		}
		// 全天补卡
		else {
			if (count == 0) {
				String start_time_before = queryDAO.executeForObject(
						"selectStartTime", arg0, String.class);
				arg0.setStart_time_before(start_time_before);
				String end_time_before = queryDAO.executeForObject(
						"selectEndTime", arg0, String.class);
				arg0.setEnd_time_before(end_time_before);
				updateDAO.execute("addManager_update_alltime", arg0);
				// 查询更新出退勤时间后的时间
				String startTimeDB = queryDAO.executeForObject(
						"selectStartTime", arg0, String.class);
				String endTimeDB = queryDAO.executeForObject(
						"selectEndTime", arg0, String.class);

				if ("私用修正".equals(arg0.getReason_type())) {
					arg0.setTimeCount(TimeCompare.getTimeCount(startTimeDB,
							endTimeDB));
					arg0.setMonth(startTimeDB.substring(5, 7));
					Date now = new Date();
					arg0.setToroku_timeStamp(now);
					updateDAO.execute("updateManager", arg0);

					 Integer buqiantimes  = queryDAO.executeForObject("buqiantimes", JVO,
	        					Integer.class);
	                    if(buqiantimes >= 2){
						arg0.setKojyo_time(0.5);}
	                    else if(buqiantimes < 2){
	                    	arg0.setKojyo_time(0);
	                    }


					String YM = arg0.getStart_time_add_search().substring(
							0, 7);
					arg0.setShnsei_time(YM);
					// 更新补卡申请表
					updateDAO.execute("updateAddSign", arg0);
					updateDAO.execute("statusUpdate", arg0);
					if ("A06".equals(arg0.getExamine_status())) {

						String offic_mail = queryDAO.executeForObject(
								"emailMessage", arg0, String.class);
						String address = offic_mail + "@trans-cosmos.com.cn";
						InternetAddress sendTo[] = new InternetAddress[1];
						try {
							sendTo[0] = new InternetAddress(address);
						} catch (AddressException e) {
							e.printStackTrace();
						}
						String content = "xingさん<br>お疲れ様です。nameです。<br><br>     稼働修正申請批准。<br><br>以上です、よろしくお願い致します。";
						content = content.replaceAll("name",
								arg0.getUserName());
						content = content.replaceAll("xing", arg0
								.getUSER_NAME().substring(0, 1));
						String jncard = arg0.getUserId();
						String officemail = queryDAO.executeForObject(
								"findOfficEmail", jncard, String.class);
						String maillian = "@trans-cosmos.com.cn";
						String from = officemail + maillian;
						String subject = "【系统邮件】【批准】【稼働修正申請】";
						Mail.sendAll(from, "123456", sendTo, null, null,
								subject, content, null);
					}else if("A05".equals(arg0.getExamine_status())){
						String offic_mail = queryDAO.executeForObject(
								"emailMessage", arg0, String.class);
						String address = offic_mail + "@trans-cosmos.com.cn";
						InternetAddress sendTo[] = new InternetAddress[1];
						try {
							sendTo[0] = new InternetAddress(address);
						} catch (AddressException e) {
							e.printStackTrace();
						}
						String content = "xingさん<br>お疲れ様です。nameです。<br><br> 稼働修正申請未批准。<br><br>以上です、よろしくお願い致します。";
						content = content.replaceAll("name",
								arg0.getUserName());
						content = content.replaceAll("xing", arg0
								.getUSER_NAME().substring(0, 1));
						String jncard = arg0.getUserId();
						String officemail = queryDAO.executeForObject(
								"findOfficEmail", jncard, String.class);
						String maillian = "@trans-cosmos.com.cn";
						String from = officemail + maillian;
						String subject = "【系统邮件】【未批准】【稼働修正申請】";
						Mail.sendAll(from, "123456", sendTo, null, null,
								subject, content, null);
					}else{

					}
				}
				// 因公
				else {
					String ST = arg0.getStart_time_add_search().concat(
							" 08:30:00");
					String END = arg0.getStart_time_add_search().concat(
							" 17:30:00");
					arg0.setStart_time_add(ST);
					arg0.setEnd_time_add(END);
					updateDAO.execute("addManager_update_starttime", arg0);
					updateDAO.execute("addManager_update_endtime", arg0);
					arg0.setTimeCount(8);
					Date now = new Date();
					arg0.setToroku_timeStamp(now);
					arg0.setMonth(ST.substring(5, 7));
					updateDAO.execute("updateManager", arg0);
					String YM = arg0.getStart_time_add_search().substring(
							0, 7);
					arg0.setShnsei_time(YM);
					updateDAO.execute("updateAddSign", arg0);
					updateDAO.execute("statusUpdate", arg0);
					if ("A06".equals(arg0.getExamine_status())) {

						String offic_mail = queryDAO.executeForObject(
								"emailMessage", arg0, String.class);
						String address = offic_mail + "@trans-cosmos.com.cn";
						InternetAddress sendTo[] = new InternetAddress[1];
						InternetAddress daiyuzhens[]=new InternetAddress[1];
						try {
										daiyuzhens[0] = new InternetAddress(daiyuzhenEmail);
									} catch (AddressException e) {
										e.printStackTrace();
									}

						try {
							sendTo[0] = new InternetAddress(address);
						} catch (AddressException e) {
							e.printStackTrace();
						}
						String content = "xingさん<br>お疲れ様です。nameです。<br><br>     稼働修正申請批准。<br><br>以上です、よろしくお願い致します。";
						content = content.replaceAll("name",arg0.getUserName());
						content = content.replaceAll("xing", arg0.getUSER_NAME().substring(0, 1));
						String jncard = arg0.getUserId();
						String officemail = queryDAO.executeForObject(
								"findOfficEmail", jncard, String.class);
						String maillian = "@trans-cosmos.com.cn";
						String from = officemail + maillian;
						String subject = "【系统邮件】【批准】【稼働修正申請】";
						Mail.sendAll(from, "123456", sendTo, daiyuzhens, null,
								subject, content, null);
					}else if("A05".equals(arg0.getExamine_status())){
						String offic_mail = queryDAO.executeForObject(
								"emailMessage", arg0, String.class);
						String address = offic_mail + "@trans-cosmos.com.cn";
						InternetAddress sendTo[] = new InternetAddress[1];
						try {
							sendTo[0] = new InternetAddress(address);
						} catch (AddressException e) {
							e.printStackTrace();
						}
						String content = "xingさん<br>お疲れ様です。nameです。<br><br> 稼働修正申請未批准。<br><br>以上です、よろしくお願い致します。";
						content = content.replaceAll("name",
								arg0.getUserName());
						content = content.replaceAll("xing", arg0
								.getUSER_NAME().substring(0, 1));
						String jncard = arg0.getUserId();
						String officemail = queryDAO.executeForObject(
								"findOfficEmail", jncard, String.class);
						String maillian = "@trans-cosmos.com.cn";
						String from = officemail + maillian;
						String subject = "【系统邮件】【未批准】【稼働修正申請】";
						Mail.sendAll(from, "123456", sendTo, null, null,
								subject, content, null);
					}else{

					}
				}

				BLogicMessages messages = new BLogicMessages();
				messages.add("message", new BLogicMessage(
						"message.attendance05.success"));
				result.setMessages(messages);
			} else {
				BLogicMessages messages = new BLogicMessages();
				messages.add("message", new BLogicMessage(
						"errors.attendance05.exist"));
				result.setErrors(messages);
			}
		}
		return result;
	}

	//取消
	private BLogicResult rollback(JNTCIAddsignInfoInput arg0) {
		BLogicResult result = new BLogicResult();
		if ("出勤時間".equals(arg0.getRETROACTIVE_TYPE())) {

			// 设定出勤时间
			String startTimeBefore = queryDAO.executeForObject(
					"selectStartTimeBefore", arg0, String.class);
			arg0.setStart_time_add(startTimeBefore);
			// 如果是私用，这个为null，公用的话为原来的打卡时间
			String endTimeBefore = queryDAO.executeForObject(
					"selectEndTimeBefore", arg0, String.class);
			arg0.setEnd_time_add(endTimeBefore);
			arg0.setStart_time_before(null);
			arg0.setEnd_time_before(null);
			updateDAO.execute("addManager_update_starttime", arg0);
			if ("公用修正".equals(arg0.getReason_type())) {
				updateDAO.execute("addManager_update_endtime", arg0);
			}
			String endTimeDB = queryDAO.executeForObject(
					"selectEndTime", arg0, String.class);
			double timeCount = TimeCompare.getTimeCount(
					startTimeBefore, endTimeDB);
			arg0.setTimeCount(timeCount);
			Date now = new Date();
			arg0.setToroku_timeStamp(now);
			arg0.setMonth(startTimeBefore.substring(5, 7));
			updateDAO.execute("updateManager", arg0);
			String YM = arg0.getStart_time_add_search().substring(0, 7);
			arg0.setShnsei_time(YM);
			arg0.setKojyo_time(0);
			updateDAO.execute("updateAddSign", arg0);
		} else if ("退勤時間".equals(arg0.getRETROACTIVE_TYPE())) {

			// 设置退勤时间
			// 如果是私用，这个为null，公用的话为原来的打卡时间
			String startTimeBefore = queryDAO.executeForObject(
					"selectStartTimeBefore", arg0, String.class);
			arg0.setStart_time_add(startTimeBefore);
			String endTimeBefore = queryDAO.executeForObject(
					"selectEndTimeBefore", arg0, String.class);
			arg0.setEnd_time_add(endTimeBefore);
			arg0.setStart_time_before(null);
			arg0.setEnd_time_before(null);
			updateDAO.execute("addManager_update_endtime", arg0);
			if ("公用修正".equals(arg0.getReason_type())) {
				updateDAO.execute("addManager_update_starttime", arg0);
			}
			String startTimeDB = queryDAO.executeForObject(
					"selectStartTime", arg0, String.class);
			double timeCount = TimeCompare.getTimeCount(startTimeDB,
					endTimeBefore);
			arg0.setTimeCount(timeCount);
			Date now = new Date();
			arg0.setToroku_timeStamp(now);
			arg0.setMonth(endTimeBefore.substring(5, 7));
			updateDAO.execute("updateManager", arg0);
			String YM = arg0.getStart_time_add_search().substring(0, 7);
			arg0.setShnsei_time(YM);
			arg0.setKojyo_time(0);
			updateDAO.execute("updateAddSign", arg0);
		} else {

			String YM = arg0.getStart_time_add_search().substring(0, 7);
			arg0.setShnsei_time(YM);
			arg0.setKojyo_time(0);
			updateDAO.execute("updateAddSign", arg0);
			updateDAO.execute("deleteManager", arg0);
		}
		updateDAO.execute("statusUpdate", arg0);
		if ("A06".equals(arg0.getExamine_status())) {

			String offic_mail = queryDAO.executeForObject(
					"emailMessage", arg0, String.class);
			String address = offic_mail + "@trans-cosmos.com.cn";
			InternetAddress sendTo[] = new InternetAddress[1];
			try {
				sendTo[0] = new InternetAddress(address);
			} catch (AddressException e) {
				e.printStackTrace();
			}
			String content = "xingさん<br>お疲れ様です。nameです。<br><br>     稼働修正申請批准。<br><br>以上です、よろしくお願い致します。";
			content = content.replaceAll("name",
					arg0.getUserName());
			content = content.replaceAll("xing", arg0
					.getUSER_NAME().substring(0, 1));
			String jncard = arg0.getUserId();
			String officemail = queryDAO.executeForObject(
					"findOfficEmail", jncard, String.class);
			String maillian = "@trans-cosmos.com.cn";
			String from = officemail + maillian;
			String subject = "【系统邮件】【批准】【稼働修正申請】";
			Mail.sendAll(from, "123456", sendTo, null, null,
					subject, content, null);
		}else if("A05".equals(arg0.getExamine_status())){
			String offic_mail = queryDAO.executeForObject(
					"emailMessage", arg0, String.class);
			String address = offic_mail + "@trans-cosmos.com.cn";
			InternetAddress sendTo[] = new InternetAddress[1];
			try {
				sendTo[0] = new InternetAddress(address);
			} catch (AddressException e) {
				e.printStackTrace();
			}
			String content = "xingさん<br>お疲れ様です。nameです。<br><br> 稼働修正申請未批准。<br><br>以上です、よろしくお願い致します。";
			content = content.replaceAll("name",
					arg0.getUserName());
			content = content.replaceAll("xing", arg0
					.getUSER_NAME().substring(0, 1));
			String jncard = arg0.getUserId();
			String officemail = queryDAO.executeForObject(
					"findOfficEmail", jncard, String.class);
			String maillian = "@trans-cosmos.com.cn";
			String from = officemail + maillian;
			String subject = "【系统邮件】【未批准】【稼働修正申請】";
			Mail.sendAll(from, "123456", sendTo, null, null,
					subject, content, null);
		}else{

		}
		return result;
	}
	//最终不承认
	private BLogicResult refuse(JNTCIAddsignInfoInput arg0) {
		BLogicResult result = new BLogicResult();
		if ("出勤時間".equals(arg0.getRETROACTIVE_TYPE())) {

			// 设定出勤时间，并把*_time_before变为空
			String startTimeBefore = queryDAO.executeForObject(
					"selectStartTimeBefore", arg0, String.class);
			arg0.setStart_time_add(startTimeBefore);
			// 如果是私用，这个为null，公用的话为原来的打卡时间
			String endTimeBefore = queryDAO.executeForObject(
					"selectEndTimeBefore", arg0, String.class);
			arg0.setEnd_time_add(endTimeBefore);
			arg0.setStart_time_before(null);
			arg0.setEnd_time_before(null);
			//更新考勤表的时间
			updateDAO.execute("addManager_update_starttime", arg0);
			if ("公用修正".equals(arg0.getReason_type())) {
				updateDAO.execute("addManager_update_endtime", arg0);
			}
			String endTimeDB = queryDAO.executeForObject(
					"selectEndTime", arg0, String.class);
			double timeCount = TimeCompare.getTimeCount(
					startTimeBefore, endTimeDB);
			arg0.setTimeCount(timeCount);
			Date now = new Date();
			arg0.setToroku_timeStamp(now);
			arg0.setMonth(startTimeBefore.substring(5, 7));
			updateDAO.execute("updateManager", arg0);
			updateDAO.execute("statusUpdate", arg0);
			if ("A06".equals(arg0.getExamine_status())) {

				String offic_mail = queryDAO.executeForObject(
						"emailMessage", arg0, String.class);
				String address = offic_mail + "@trans-cosmos.com.cn";
				InternetAddress sendTo[] = new InternetAddress[1];
				try {
					sendTo[0] = new InternetAddress(address);
				} catch (AddressException e) {
					e.printStackTrace();
				}
				String content = "xingさん<br>お疲れ様です。nameです。<br><br>     稼働修正申請批准。<br><br>以上です、よろしくお願い致します。";
				content = content.replaceAll("name",
						arg0.getUserName());
				content = content.replaceAll("xing", arg0
						.getUSER_NAME().substring(0, 1));
				String jncard = arg0.getUserId();
				String officemail = queryDAO.executeForObject(
						"findOfficEmail", jncard, String.class);
				String maillian = "@trans-cosmos.com.cn";
				String from = officemail + maillian;
				String subject = "【系统邮件】【批准】【稼働修正申請】";
				Mail.sendAll(from, "123456", sendTo, null, null,
						subject, content, null);
			}else if("A05".equals(arg0.getExamine_status())){
				String offic_mail = queryDAO.executeForObject(
						"emailMessage", arg0, String.class);
				String address = offic_mail + "@trans-cosmos.com.cn";
				InternetAddress sendTo[] = new InternetAddress[1];
				try {
					sendTo[0] = new InternetAddress(address);
				} catch (AddressException e) {
					e.printStackTrace();
				}
				String content = "xingさん<br>お疲れ様です。nameです。<br><br> 稼働修正申請未批准。<br><br>以上です、よろしくお願い致します。";
				content = content.replaceAll("name",
						arg0.getUserName());
				content = content.replaceAll("xing", arg0
						.getUSER_NAME().substring(0, 1));
				String jncard = arg0.getUserId();
				String officemail = queryDAO.executeForObject(
						"findOfficEmail", jncard, String.class);
				String maillian = "@trans-cosmos.com.cn";
				String from = officemail + maillian;
				String subject = "【系统邮件】【未批准】【稼働修正申請】";
				Mail.sendAll(from, "123456", sendTo, null, null,
						subject, content, null);
			}else{

			}
			arg0.setKojyo_time(0);
			updateDAO.execute("updateAddSign", arg0);
		} else if ("退勤時間".equals(arg0.getRETROACTIVE_TYPE())) {

			// 设置退勤时间，并把*_time_before变为空
			// //如果是私用，这个为null，公用的话为原来的打卡时间
			String startTimeBefore = queryDAO.executeForObject(
					"selectStartTimeBefore", arg0, String.class);
			arg0.setStart_time_add(startTimeBefore);
			String endTimeBefore = queryDAO.executeForObject(
					"selectEndTimeBefore", arg0, String.class);
			arg0.setEnd_time_add(endTimeBefore);
			arg0.setStart_time_before(null);
			arg0.setEnd_time_before(null);
			updateDAO.execute("addManager_update_endtime", arg0);
			if ("公用修正".equals(arg0.getReason_type())) {
				updateDAO.execute("addManager_update_starttime", arg0);
			}
			String startTimeDB = queryDAO.executeForObject(
					"selectStartTime", arg0, String.class);
			double timeCount = TimeCompare.getTimeCount(startTimeDB,
					endTimeBefore);
			arg0.setTimeCount(timeCount);

			Date now = new Date();
			arg0.setToroku_timeStamp(now);
			arg0.setMonth(endTimeBefore.substring(5, 7));
			updateDAO.execute("updateManager", arg0);
			updateDAO.execute("statusUpdate", arg0);
			if ("A06".equals(arg0.getExamine_status())) {

				String offic_mail = queryDAO.executeForObject(
						"emailMessage", arg0, String.class);
				String address = offic_mail + "@trans-cosmos.com.cn";
				InternetAddress sendTo[] = new InternetAddress[1];
				try {
					sendTo[0] = new InternetAddress(address);
				} catch (AddressException e) {
					e.printStackTrace();
				}
				String content = "xingさん<br>お疲れ様です。nameです。<br><br>     稼働修正申請批准。<br><br>以上です、よろしくお願い致します。";
				content = content.replaceAll("name",
						arg0.getUserName());
				content = content.replaceAll("xing", arg0
						.getUSER_NAME().substring(0, 1));
				String jncard = arg0.getUserId();
				String officemail = queryDAO.executeForObject(
						"findOfficEmail", jncard, String.class);
				String maillian = "@trans-cosmos.com.cn";
				String from = officemail + maillian;
				String subject = "【系统邮件】【批准】【稼働修正申請】";
				Mail.sendAll(from, "123456", sendTo, null, null,
						subject, content, null);
			}else if("A05".equals(arg0.getExamine_status())){
				String offic_mail = queryDAO.executeForObject(
						"emailMessage", arg0, String.class);
				String address = offic_mail + "@trans-cosmos.com.cn";
				InternetAddress sendTo[] = new InternetAddress[1];
				try {
					sendTo[0] = new InternetAddress(address);
				} catch (AddressException e) {
					e.printStackTrace();
				}
				String content = "xingさん<br>お疲れ様です。nameです。<br><br> 稼働修正申請未批准。<br><br>以上です、よろしくお願い致します。";
				content = content.replaceAll("name",
						arg0.getUserName());
				content = content.replaceAll("xing", arg0
						.getUSER_NAME().substring(0, 1));
				String jncard = arg0.getUserId();
				String officemail = queryDAO.executeForObject(
						"findOfficEmail", jncard, String.class);
				String maillian = "@trans-cosmos.com.cn";
				String from = officemail + maillian;
				String subject = "【系统邮件】【未批准】【稼働修正申請】";
				Mail.sendAll(from, "123456", sendTo, null, null,
						subject, content, null);
			}else{

			}
			arg0.setKojyo_time(0);
			updateDAO.execute("updateAddSign", arg0);
		} else {
			updateDAO.execute("statusUpdate", arg0);
			if ("A06".equals(arg0.getExamine_status())) {

				String offic_mail = queryDAO.executeForObject(
						"emailMessage", arg0, String.class);
				String address = offic_mail + "@trans-cosmos.com.cn";
				InternetAddress sendTo[] = new InternetAddress[1];
				try {
					sendTo[0] = new InternetAddress(address);
				} catch (AddressException e) {
					e.printStackTrace();
				}
				String content = "xingさん<br>お疲れ様です。nameです。<br><br>     稼働修正申請批准。<br><br>以上です、よろしくお願い致します。";
				content = content.replaceAll("name",
						arg0.getUserName());
				content = content.replaceAll("xing", arg0
						.getUSER_NAME().substring(0, 1));
				String jncard = arg0.getUserId();
				String officemail = queryDAO.executeForObject(
						"findOfficEmail", jncard, String.class);
				String maillian = "@trans-cosmos.com.cn";
				String from = officemail + maillian;
				String subject = "【系统邮件】【批准】【稼働修正申請】";
				Mail.sendAll(from, "123456", sendTo, null, null,
						subject, content, null);
			}else if("A05".equals(arg0.getExamine_status())){
				String offic_mail = queryDAO.executeForObject(
						"emailMessage", arg0, String.class);
				String address = offic_mail + "@trans-cosmos.com.cn";
				InternetAddress sendTo[] = new InternetAddress[1];
				try {
					sendTo[0] = new InternetAddress(address);
				} catch (AddressException e) {
					e.printStackTrace();
				}
				String content = "xingさん<br>お疲れ様です。nameです。<br><br> 稼働修正申請未批准。<br><br>以上です、よろしくお願い致します。";
				content = content.replaceAll("name",
						arg0.getUserName());
				content = content.replaceAll("xing", arg0
						.getUSER_NAME().substring(0, 1));
				String jncard = arg0.getUserId();
				String officemail = queryDAO.executeForObject(
						"findOfficEmail", jncard, String.class);
				String maillian = "@trans-cosmos.com.cn";
				String from = officemail + maillian;
				String subject = "【系统邮件】【未批准】【稼働修正申請】";
				Mail.sendAll(from, "123456", sendTo, null, null,
						subject, content, null);
			}else{

			}
			arg0.setKojyo_time(0);
			updateDAO.execute("updateAddSign", arg0);
			updateDAO.execute("deleteManager", arg0);
		}
		return result;
	}




	public BLogicResult execute(JNTCIAddsignInfoInput arg0) {
		BLogicResult result = new BLogicResult();
		String day = "";
		if (!("".equals(arg0.getStart_time_add()) || arg0
				.getStart_time_add() == null)) {
			day = arg0.getStart_time_add().substring(0, 10);
			arg0.setStart_time_add_search(day);
		}
		if (!("".equals(arg0.getEnd_time_add()) || arg0.getEnd_time_add() == null)) {
			day = arg0.getEnd_time_add().substring(0, 10);
			arg0.setStart_time_add_search(day);
		}
		//查询申请是否还在
		int ShenseiCnt=queryDAO.executeForObject("selectAddsign", arg0, Integer.class);
		//查询申请状态
		String status = queryDAO.executeForObject("queryStatus", arg0,
				String.class);
		//只能在下个月三个工作日之前之前补卡限制，
		Date Systime = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");//可以方便地修改日期格式
		String sfd = dateFormat.format( Systime );
		List<Date> holidaylist = queryDAO.executeForObjectList("holidaylist", null);
		String start=sfd.substring(0,8).concat("01");

		//申请年月
		int ShenseiM=Integer.parseInt(arg0.getStart_time_add_search().substring(5, 7));
		int ShenseiY=Integer.parseInt(arg0.getStart_time_add_search().substring(0, 4));
		//系统年月
		int SM=Integer.parseInt(sfd.substring(5, 7));
		int SY=Integer.parseInt(sfd.substring(0, 4));
		int dayCount = GetWorkDay.workDays(start,sfd,holidaylist);
		int ShenseiMNext;
		int ShenseiYNext;
		if(ShenseiM==12){
			ShenseiMNext=1;
			ShenseiYNext=ShenseiY+1;
		}
		else {
			ShenseiMNext=ShenseiM+1;
			ShenseiYNext=ShenseiY;
		}

		if ("A06".equals(arg0.getExamine_status())) {
			String st = "08:30";
			String en = "17:30";
			// 判断有没有午前补卡，然后是否小于8：30
			if (!("".equals(arg0.getStart_time_add()) || arg0
					.getStart_time_add() == null)) {
				String starttime = arg0.getStart_time_add().substring(11, 16);
				if (st.compareTo(starttime) >= 0) {
					starttime = arg0.getStart_time_add().substring(0, 11) + st
							+ ":00";
				} else {
					starttime = arg0.getStart_time_add();
				}
				arg0.setStart_time_add(starttime);
			}
			// 判断有没有午后补卡，然后是否大于17：30
			if (!("".equals(arg0.getEnd_time_add()) || arg0.getEnd_time_add() == null)) {
				String endtime = arg0.getEnd_time_add().substring(11, 16);
				if (en.compareTo(endtime) < 0) {
					endtime = arg0.getEnd_time_add().substring(0, 11) + en
							+ ":00";
				} else {
					endtime = arg0.getEnd_time_add();
				}
				arg0.setEnd_time_add(endtime);
			}

			if((ShenseiM==SM&&ShenseiY==SY)||(dayCount<4&&ShenseiMNext==SM&&ShenseiYNext==SY)){
				// 考勤出退勤时间更新，
				String userId=arg0.getUserId();
				//如果是栋桑，需要保证申请还存在，并且状态为A01或者A05
				if(ShenseiCnt!=0){
					if("1003".equals(userId)||"1004".equals(userId)){
						arg0.setExamine_status("A06");
						result=admit(arg0);
					}
					else if ("1070".equals(userId)) {
						result=admit(arg0);
					}
					else {
						arg0.setExamine_status("A01");
						updateDAO.execute("statusUpdate", arg0);
						String leader=queryDAO.executeForObject("selectperson", arg0, String.class);
						arg0.setLeader(leader);
						if ("A01".equals(arg0.getExamine_status())) {

							String offic_mail = queryDAO.executeForObject(
									"emailMessage1", arg0, String.class);
							String address = offic_mail + "@trans-cosmos.com.cn";
							InternetAddress sendTo[] = new InternetAddress[1];
							try {
								sendTo[0] = new InternetAddress(address);
							} catch (AddressException e) {
								e.printStackTrace();
							}
							String content = "xingさん<br>お疲れ様です。nameです。<br><br> 因项目需求，yuangong申请稼働修正。<br><br>望批准。<br><br>以上です、よろしくお願い致します。";
							content = content.replaceAll("name",
									arg0.getUserName());
							content = content.replaceAll("xing", leader.substring(0, 1));
							content = content.replaceAll("yuangong",
									arg0.getUSER_NAME());
							String jncard = arg0.getUserId();
							String officemail = queryDAO.executeForObject(
									"findOfficEmail", jncard, String.class);
							String maillian = "@trans-cosmos.com.cn";
							String from = officemail + maillian;
							String subject = "【系统邮件】【批准】【稼働修正申請】";
							Mail.sendAll(from, "123456", sendTo, null, null,
									subject, content, null);
						}else if("A07".equals(arg0.getExamine_status())){
							String offic_mail = queryDAO.executeForObject(
									"emailMessage", arg0, String.class);
							String address = offic_mail + "@trans-cosmos.com.cn";
							InternetAddress sendTo[] = new InternetAddress[1];
							try {
								sendTo[0] = new InternetAddress(address);
							} catch (AddressException e) {
								e.printStackTrace();
							}
							String content = "xingさん<br>お疲れ様です。nameです。<br><br> 稼働修正申請未批准。<br><br>以上です、よろしくお願い致します。";
							content = content.replaceAll("name",
									arg0.getUserName());
							content = content.replaceAll("xing", arg0
									.getUSER_NAME().substring(0, 1));
							String jncard = arg0.getUserId();
							String officemail = queryDAO.executeForObject(
									"findOfficEmail", jncard, String.class);
							String maillian = "@trans-cosmos.com.cn";
							String from = officemail + maillian;
							String subject = "【系统邮件】【未批准】【稼働修正申請】";
							Mail.sendAll(from, "123456", sendTo, null, null,
									subject, content, null);
						}else{

						}
						BLogicMessages messages = new BLogicMessages();
						messages.add("message", new BLogicMessage(
									"message.attendance05.success"));
						result.setMessages(messages);
					}
				}
				else {
					BLogicMessages messages = new BLogicMessages();
					messages.add("message", new BLogicMessage(
							"errors.attendance05.notexist"));
				}
			}else {
				BLogicMessages messages = new BLogicMessages();
				/*messages.add("message", new BLogicMessage(
						"errors.attendance05.timeOut"));*/
				messages.add("message", new BLogicMessage(
						"errors.attendance05.timeOut1",arg0.getRETROACTIVE_ID()));
				result.setErrors(messages);
			}
		}
		//变为未审查状态
		else if ("A04".equals(arg0.getExamine_status())) {
			arg0.setExamine_status("A04");
			if((ShenseiM==SM&&ShenseiY==SY)||(dayCount<4&&ShenseiMNext==SM&&ShenseiYNext==SY)){
				if ("A06".equals(status)) {
					result = rollback(arg0);
				}
				else {
					updateDAO.execute("statusUpdate", arg0);
					if ("A06".equals(arg0.getExamine_status())) {

						String offic_mail = queryDAO.executeForObject(
								"emailMessage", arg0, String.class);
						String address = offic_mail + "@trans-cosmos.com.cn";
						InternetAddress sendTo[] = new InternetAddress[1];
						try {
							sendTo[0] = new InternetAddress(address);
						} catch (AddressException e) {
							e.printStackTrace();
						}
						String content = "xingさん<br>お疲れ様です。nameです。<br><br>     稼働修正申請批准。<br><br>以上です、よろしくお願い致します。";
						content = content.replaceAll("name",
								arg0.getUserName());
						content = content.replaceAll("xing", arg0
								.getUSER_NAME().substring(0, 1));
						String jncard = arg0.getUserId();
						String officemail = queryDAO.executeForObject(
								"findOfficEmail", jncard, String.class);
						String maillian = "@trans-cosmos.com.cn";
						String from = officemail + maillian;
						String subject = "【系统邮件】【批准】【稼働修正申請】";
						Mail.sendAll(from, "123456", sendTo, null, null,
								subject, content, null);
					}else if("A05".equals(arg0.getExamine_status())){
						String offic_mail = queryDAO.executeForObject(
								"emailMessage", arg0, String.class);
						String address = offic_mail + "@trans-cosmos.com.cn";
						InternetAddress sendTo[] = new InternetAddress[1];
						try {
							sendTo[0] = new InternetAddress(address);
						} catch (AddressException e) {
							e.printStackTrace();
						}
						String content = "xingさん<br>お疲れ様です。nameです。<br><br> 稼働修正申請未批准。<br><br>以上です、よろしくお願い致します。";
						content = content.replaceAll("name",
								arg0.getUserName());
						content = content.replaceAll("xing", arg0
								.getUSER_NAME().substring(0, 1));
						String jncard = arg0.getUserId();
						String officemail = queryDAO.executeForObject(
								"findOfficEmail", jncard, String.class);
						String maillian = "@trans-cosmos.com.cn";
						String from = officemail + maillian;
						String subject = "【系统邮件】【未批准】【稼働修正申請】";
						Mail.sendAll(from, "123456", sendTo, null, null,
								subject, content, null);
					}else{

					}
				}
			}
			else {
				BLogicMessages messages = new BLogicMessages();
				messages.add("message", new BLogicMessage(
							"errors.attendance05.timeOut1",arg0.getRETROACTIVE_ID()));
				result.setErrors(messages);
			}

		}
		/*
		 * 不承认操作，两种情况：已经承认和之前没承认 之前承认 就把数据还原，之前没承认直接把申请状态变为A05
		 */
		else if("A05".equals(arg0.getExamine_status())) {
			// 如果该条已经承认
			String userId=arg0.getUserId();
			if((ShenseiM==SM&&ShenseiY==SY)||(dayCount<4&&ShenseiMNext==SM&&ShenseiYNext==SY)){
				if ("A06".equals(status)) {
					result=refuse(arg0);
				}
				else{
					//除了代于珍，栋桑，衣总
					if(!("1070".equals(userId)||"1003".equals(userId)||"1004".equals(userId))){
						arg0.setExamine_status("A07");
					}
					updateDAO.execute("statusUpdate", arg0);
					if ("A01".equals(arg0.getExamine_status())) {

						String offic_mail = queryDAO.executeForObject(
								"emailMessage", arg0, String.class);
						String address = offic_mail + "@trans-cosmos.com.cn";
						InternetAddress sendTo[] = new InternetAddress[1];
						try {
							sendTo[0] = new InternetAddress(address);
						} catch (AddressException e) {
							e.printStackTrace();
						}
						String content = "xingさん<br>お疲れ様です。nameです。<br><br>     稼働修正申請批准。<br><br>以上です、よろしくお願い致します。";
						content = content.replaceAll("name",
								arg0.getUserName());
						content = content.replaceAll("xing", arg0
								.getUSER_NAME().substring(0, 1));
						String jncard = arg0.getUserId();
						String officemail = queryDAO.executeForObject(
								"findOfficEmail", jncard, String.class);
						String maillian = "@trans-cosmos.com.cn";
						String from = officemail + maillian;
						String subject = "【系统邮件】【批准】【稼働修正申請】";
						Mail.sendAll(from, "123456", sendTo, null, null,
								subject, content, null);
					}else if("A07".equals(arg0.getExamine_status())){
						String offic_mail = queryDAO.executeForObject(
								"emailMessage", arg0, String.class);
						String address = offic_mail + "@trans-cosmos.com.cn";
						InternetAddress sendTo[] = new InternetAddress[1];
						try {
							sendTo[0] = new InternetAddress(address);
						} catch (AddressException e) {
							e.printStackTrace();
						}
						String content = "xingさん<br>お疲れ様です。nameです。<br><br> 稼働修正申請未批准。<br><br>以上です、よろしくお願い致します。";
						content = content.replaceAll("name",
								arg0.getUserName());
						content = content.replaceAll("xing", arg0
								.getUSER_NAME().substring(0, 1));
						String jncard = arg0.getUserId();
						String officemail = queryDAO.executeForObject(
								"findOfficEmail", jncard, String.class);
						String maillian = "@trans-cosmos.com.cn";
						String from = officemail + maillian;
						String subject = "【系统邮件】【未批准】【稼働修正申請】";
						Mail.sendAll(from, "123456", sendTo, null, null,
								subject, content, null);
					}else{

					}
				}
			}
			else {
				BLogicMessages messages = new BLogicMessages();
				messages.add("message", new BLogicMessage(
							"errors.attendance05.timeOut1",arg0.getRETROACTIVE_ID()));
				result.setErrors(messages);
			}
		}
		//返回,不做处理直接返回，原因....可能是跳转时返回了那几个检索条件

		result.setResultString("success");
		return result;
	}
}
