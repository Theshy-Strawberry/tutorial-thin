package jp.terasoluna.thin.tutorial.web.transcosmos.blogic;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

import org.apache.struts.upload.FormFile;

import jp.terasoluna.fw.dao.QueryDAO;
import jp.terasoluna.fw.dao.UpdateDAO;
import jp.terasoluna.fw.service.thin.BLogic;
import jp.terasoluna.fw.service.thin.BLogicMessage;
import jp.terasoluna.fw.service.thin.BLogicMessages;
import jp.terasoluna.fw.service.thin.BLogicResult;
import jp.terasoluna.thin.tutorial.web.common.controller.GetWorkDay;
import jp.terasoluna.thin.tutorial.web.common.controller.Mail;
import jp.terasoluna.thin.tutorial.web.transcosmos.dto.Attendance06SelectRecOutput;
import jp.terasoluna.thin.tutorial.web.transcosmos.dto.JNTCIAttendance06Input;

public class JNTCIAttendance06Blogic implements BLogic<JNTCIAttendance06Input> {
	private QueryDAO queryDAO = null;
	private UpdateDAO updateDAO = null;

	public void setQueryDAO(QueryDAO queryDAO) {
		this.queryDAO = queryDAO;
	}
	public void setUpdateDAO(UpdateDAO updateDAO) {
		this.updateDAO = updateDAO;
	}
	private String uploadPath = this.getClass().getClassLoader()
			.getResource("").getPath() + "../../file/uploadFile/";

	public BLogicResult execute(JNTCIAttendance06Input param) {


 		BLogicResult result = new BLogicResult();
 		int update = 0;
		String retroactive_id = param.getRetroactive_id();
		if(retroactive_id == null || "".equals(retroactive_id)){
		Integer retro_num = queryDAO.executeForObject("getMaxId", null, Integer.class);
		if(retro_num == null){
			retroactive_id = "A00000001";
		}else{
			if (retro_num >= 1 && retro_num < 9) {
				retro_num += 1;
				retroactive_id = "A0000000" + retro_num;
			} else if (retro_num >= 9 && retro_num < 99) {
				retro_num += 1;
				retroactive_id = "A000000" + retro_num;
			} else if (retro_num >= 99 && retro_num < 999) {
				retro_num += 1;
				retroactive_id = "A00000" + retro_num;
			}else if(retro_num >= 999 && retro_num < 9999){
				retro_num += 1;
				retroactive_id = "A0000" + retro_num;
			}else if(retro_num >= 9999 && retro_num < 99999){
				retro_num += 1;
				retroactive_id = "A000" + retro_num;
			}else if(retro_num >= 99999 && retro_num < 999999){
				retro_num += 1;
				retroactive_id = "A00" + retro_num;
			}else if(retro_num >= 999999 && retro_num < 9999999){
				retro_num += 1;
				retroactive_id = "A0" + retro_num;
			}else if(retro_num >= 9999999 && retro_num < 99999999){
				retro_num += 1;
				retroactive_id = "A" + retro_num;
			}
		}
 		}else{
 			retroactive_id = param.getRetroactive_id();
 			update = 1;
 		}
		param.setRetroactive_id(retroactive_id);

		String filePath = null;
		FileOutputStream fos;
		FormFile formFile = param.getUploadFile();
		param.setTenpu_path(param.getUploadFile().getFileName());

		String aa = param.getTenpu_path();
		Integer exit = queryDAO.executeForObject("namename", param.getTenpu_path(), Integer.class);



		if(!(param.getUploadFile().getFileName() == null||"".equals(param.getUploadFile().getFileName()))){
			filePath = param.getUploadFile().getFileName();
			if(exit > 0 ){
				BLogicMessages messages = new BLogicMessages();
				messages.add("message", new BLogicMessage("errors.attendance05.copyinsert1"));
				result.setErrors(messages);
				result.setResultString("failure");
				return result;
			}else{


			try {
				File folder = new File(uploadPath);
				if (!folder.exists() && !folder.isDirectory()) {
					folder.mkdirs();
				}
				File file = new File(uploadPath + filePath);// 创建文件
				InputStream fin = formFile.getInputStream();
				fos = new FileOutputStream(file);

				byte[] buffer = new byte[fin.available()];
				while(true){
					int ins = fin.read(buffer);
					if(ins == -1){
						fin.close();
						fos.flush();
						fos.close();
						break;
					}else{

						fos.write(buffer);

					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		}
		// 補くじ記録を挿入し、勤怠情報表の改正について
		//前台取值
		String start_time = null;
		int startTime = 0;
		String end_time = null;
		int endTime = 0;
		int time_count = 0;
		//????日期的打???
		int checkStartTime = 0;
		int checkEndTime = 0;
		//截取月份和年份
		int ShenseiMouth = 0;
		int ShenseiYear = 0;


		//?面?取??
		if(!"".equals(param.getStart_time_add())){
			param.setST(param.getStart_time_add().substring(0, 10).replace("-", "/"));
			start_time = param.getStart_time_add().substring(11, 19).replace(":", "").replace(".", "").replace(" ", "");
			startTime = Integer.parseInt(start_time);
			String ShenseiMouth1 = param.getStart_time_add().substring(5, 7).replace(":", "");
			ShenseiMouth = Integer.parseInt(ShenseiMouth1);
			String ShenseiYear1 = param.getStart_time_add().substring(0, 4).replace(":", "");
			ShenseiYear = Integer.parseInt(ShenseiYear1);
		}
		if(!"".equals(param.getEnd_time_add())){
			param.setNT(param.getEnd_time_add().substring(0, 10).replace("-", "/"));
			end_time = param.getEnd_time_add().substring(11, 19).replace(":", "").replace(".", "").replace(" ", "");
			endTime = Integer.parseInt(end_time);
			String ShenseiMouth1 = param.getEnd_time_add().substring(5, 7).replace(":", "");
			ShenseiMouth = Integer.parseInt(ShenseiMouth1);
			String ShenseiYear1 = param.getEnd_time_add().substring(0, 4).replace(":", "");
			ShenseiYear = Integer.parseInt(ShenseiYear1);
		}
		int check_count  = queryDAO.executeForObject("getJNTCIAttendance05CheckRec", param, Integer.class);
		if(check_count!=0){   // 考勤表不?0
			//????日期的出勤??
			time_count  = queryDAO.executeForObject("getJNTCIAttendance05CheckTimeCount", param, Integer.class);
			//????日期的打???
			String check_time  = queryDAO.executeForObject("getJNTCIAttendance05CheckTime", param, String.class);
			String checkTime1 = check_time.substring(11, 19).replace(":", "");
			checkStartTime = Integer.parseInt(checkTime1);
			String check_time1  = queryDAO.executeForObject("getJNTCIAttendance05CheckTime1", param, String.class);
			String checkTime2 = check_time1.substring(11, 19).replace(":", "");
			checkEndTime = Integer.parseInt(checkTime2);
		}
		int check_copy_count = queryDAO.executeForObject("getJNTCIAttendance05CheckCheckInsert", param, Integer.class);
		if(check_copy_count != 0){
			BLogicMessages messages = new BLogicMessages();
			messages.add("message", new BLogicMessage("errors.attendance05.copyinsert"));
			result.setErrors(messages);
			result.setResultString("failure");
			return result;
		}
		String type = param.getRetroactive_type();
		String max_status_count = queryDAO.executeForObject("getStatusCount", param, String.class);
		param.setExamine_id(max_status_count);
		param.setRetroactive_status("A04");
		//补卡表
		int rec_count  = queryDAO.executeForObject("getRertoactiveRec", param, Integer.class);
		int rec_count1  = queryDAO.executeForObject("getRertoactiveRec1", param, Integer.class);
		//系统时间，前三个工作日
		Date Systime = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");//可以方便地修改日期格式
		String sfd = dateFormat.format( Systime );
		List<Date> holidaylist = queryDAO.executeForObjectList("holidaylist", null);  //非工作日
		String start=sfd.substring(0,8).concat("01");    //提交申请月的月初
		//获取当前月份
		String SYSMouth1=sfd.substring(5, 7);
		int SYSMouth = 0;
		SYSMouth =  Integer.parseInt(SYSMouth1);
		//获取当前年份
		String SYSYear1=sfd.substring(0, 4);
		int SYSYear = 0;
		SYSYear =  Integer.parseInt(SYSYear1);
		int dayCount = GetWorkDay.workDays(start,sfd,holidaylist);
		if(update==1){
			if(ShenseiMouth==SYSMouth    ||    (dayCount < 4    &&    ((ShenseiMouth+1)==SYSMouth || ((ShenseiYear+1)==SYSYear&& SYSMouth==1&&ShenseiMouth==12) ) ) ){
				if(type.equals("3")){  //补卡表=0
					if(check_count!=0){  // 考勤表不=0
						BLogicMessages messages = new BLogicMessages();
						messages.add("message", new BLogicMessage("errors.attendance05.alreadyexist"));
						result.setErrors(messages);
						result.setResultString("failure");
						return result;
					}else {
						String sub_start_time=null;
			 			String sub_end_time=null;
			 			if(param.getStart_time_add()!=""){
			 				sub_start_time= param.getStart_time_add().substring(0, 10).replace("/", "").replace("-", "");
			 			}
			 			if(param.getEnd_time_add()!=""){
			 				sub_end_time= param.getEnd_time_add().substring(0, 10).replace("/", "").replace("-", "");
			 			}
			 			if(!sub_start_time.equals(sub_end_time)){
							BLogicMessages messages = new BLogicMessages();
							messages.add("message", new BLogicMessage("errors.attendance05.notoneday"));
							result.setErrors(messages);
							result.setResultString("failure");
							return result;
						}
						updateDAO.execute("updateRec3", param);
					}
				}else if(type.equals("1")){
						if(check_count!=0){   // 考勤表不?0
							if(time_count<8){  //出勤???0
								if(startTime>checkStartTime){
									BLogicMessages messages = new BLogicMessages();
									messages.add("message", new BLogicMessage("errors.attendance05.alreadyexist"));
									result.setErrors(messages);
									result.setResultString("failure");
									return result;
								}else {
									updateDAO.execute("insertRec3", param);
								}
								//updateDAO.execute("insertRec1", param);
							}else {
								BLogicMessages messages = new BLogicMessages();
								messages.add("message", new BLogicMessage("errors.attendance05.alreadyexist"));
								result.setErrors(messages);
								result.setResultString("failure");
								return result;
							}
						}else if(check_count==0){
							BLogicMessages messages = new BLogicMessages();
							messages.add("message", new BLogicMessage("errors.attendance05.alreadyexist01"));
							result.setErrors(messages);
							result.setResultString("failure");
							return result;
						}
				}else if(type.equals("2")){
						if(check_count!=0){   // 考勤表不?0
							if(time_count<8){  //出勤???0
								if(endTime<checkEndTime){
									BLogicMessages messages = new BLogicMessages();
									messages.add("message", new BLogicMessage("errors.attendance05.alreadyexist"));
									result.setErrors(messages);
									result.setResultString("failure");
									return result;
								}else {
									updateDAO.execute("updateRec2", param);
								}
								//updateDAO.execute("insertRec2", param);
							}else {
								BLogicMessages messages = new BLogicMessages();
								messages.add("message", new BLogicMessage("errors.attendance05.alreadyexist"));
								result.setErrors(messages);
								result.setResultString("failure");
								return result;
							}
						}else if(check_count==0){
							BLogicMessages messages = new BLogicMessages();
							messages.add("message", new BLogicMessage("errors.attendance05.alreadyexist01"));
							result.setErrors(messages);
							result.setResultString("failure");
							return result;
						}
				}else {
					BLogicMessages messages = new BLogicMessages();
					messages.add("message", new BLogicMessage("errors.attendance05.alreadyexist"));
					result.setErrors(messages);
					result.setResultString("failure");
					return result;
				}
			}else{
				BLogicMessages messages = new BLogicMessages();
				messages.add("message", new BLogicMessage("errors.attendance05.timeOut"));
				result.setErrors(messages);
				result.setResultString("failure");
				return result;
			}
		}else{
		if(ShenseiMouth==SYSMouth    ||    (dayCount < 4    &&    ((ShenseiMouth+1)==SYSMouth || ((ShenseiYear+1)==SYSYear&& SYSMouth==1&&ShenseiMouth==12) ) ) ){
			if(rec_count1 == 0 && rec_count == 0 && type.equals("3")){  //补卡表=0
				if(check_count!=0){  // 考勤表不?0
					BLogicMessages messages = new BLogicMessages();
					messages.add("message", new BLogicMessage("errors.attendance05.alreadyexist"));
					result.setErrors(messages);
					result.setResultString("failure");
					return result;
				}else {
					String sub_start_time=null;
		 			String sub_end_time=null;
		 			if(param.getStart_time_add()!=""){
		 				sub_start_time= param.getStart_time_add().substring(0, 10);
		 			}
		 			if(param.getEnd_time_add()!=""){
		 				sub_end_time= param.getEnd_time_add().substring(0, 10);
		 			}
		 			if(!sub_start_time.equals(sub_end_time)){
						BLogicMessages messages = new BLogicMessages();
						messages.add("message", new BLogicMessage("errors.attendance05.notoneday"));
						result.setErrors(messages);
						result.setResultString("failure");
						return result;
					}
					updateDAO.execute("insertRec3", param);
				}
			}else if(type.equals("1")){
				if(rec_count == 0){ //补卡表
					if(check_count!=0){   // 考勤表不?0
						if(time_count<8){  //出勤???0
							if(startTime>checkStartTime){
								BLogicMessages messages = new BLogicMessages();
								messages.add("message", new BLogicMessage("errors.attendance05.alreadyexist"));
								result.setErrors(messages);
								result.setResultString("failure");
								return result;
							}else {
								updateDAO.execute("insertRec1", param);
							}
							//updateDAO.execute("insertRec1", param);
						}else {
							BLogicMessages messages = new BLogicMessages();
							messages.add("message", new BLogicMessage("errors.attendance05.alreadyexist"));
							result.setErrors(messages);
							result.setResultString("failure");
							return result;
						}
					}else if(check_count==0){
						BLogicMessages messages = new BLogicMessages();
						messages.add("message", new BLogicMessage("errors.attendance05.alreadyexist01"));
						result.setErrors(messages);
						result.setResultString("failure");
						return result;
					}
				}else if(rec_count!=0){
					BLogicMessages messages = new BLogicMessages();
					messages.add("message", new BLogicMessage("errors.attendance05.alreadyexist"));
					result.setErrors(messages);
					result.setResultString("failure");
					return result;
				}
			}else if(type.equals("2")){
				if(rec_count1 == 0){
					if(check_count!=0){   // 考勤表不?0
						if(time_count<24){  //出勤???0
							if(endTime<checkEndTime){
								BLogicMessages messages = new BLogicMessages();
								messages.add("message", new BLogicMessage("errors.attendance05.alreadyexist"));
								result.setErrors(messages);
								result.setResultString("failure");
								return result;
							}else {
								updateDAO.execute("insertRec2", param);
							}
							//updateDAO.execute("insertRec2", param);
						}else {
							BLogicMessages messages = new BLogicMessages();
							messages.add("message", new BLogicMessage("errors.attendance05.alreadyexist"));
							result.setErrors(messages);
							result.setResultString("failure");
							return result;
						}
					}else if(check_count==0){
						BLogicMessages messages = new BLogicMessages();
						messages.add("message", new BLogicMessage("errors.attendance05.alreadyexist01"));
						result.setErrors(messages);
						result.setResultString("failure");
						return result;
					}
				}else if(rec_count1!=0){
					BLogicMessages messages = new BLogicMessages();
					messages.add("message", new BLogicMessage("errors.attendance05.alreadyexist"));
					result.setErrors(messages);
					result.setResultString("failure");
					return result;
				}
			}else {
				BLogicMessages messages = new BLogicMessages();
				messages.add("message", new BLogicMessage("errors.attendance05.alreadyexist"));
				result.setErrors(messages);
				result.setResultString("failure");
				return result;
			}
		}else{
			BLogicMessages messages = new BLogicMessages();
			messages.add("message", new BLogicMessage("errors.attendance05.timeOut"));
			result.setErrors(messages);
			result.setResultString("failure");
			return result;
		}
	}

		Attendance06SelectRecOutput output = new Attendance06SelectRecOutput();
		output.setUser_id(param.getUser_id());
		output.setUser_name(param.getUser_name());
		output.setDept_id(param.getDept_id());
		output.setLeader(param.getLeader());

		output.setStart_time_add(param.getStart_time());
		output.setStart_time_add(param.getStart_time_add());
		output.setEnd_time_add(param.getEnd_time_add());
		output.setRetroactive_reason(param.getRetroactive_reason());   //理由
		output.setRetroactive_type(param.getRetroactive_type());      //???型
		output.setReason_type(param.getReason_type());            //公用、私用
		/*output.setTenpu_path(param.getTenpu_path());*/
		output.setFileName(param.getTenpu_path());
if("4".equals(param.getReason_type())){
		 String offic_mail=queryDAO.executeForObject("emailMessage2",param,String.class);
			String address =offic_mail+ "@trans-cosmos.com.cn";
			//代玉珍邮箱号
			String daiyuzhen =queryDAO.executeForObject("SearchdaiyuzhenEmail","1070" , java.lang.String.class);
			//代玉珍邮箱
			String daiyuzhenEmail = daiyuzhen+"@trans-cosmos.com.cn";
			InternetAddress daiyuzhens[]=new InternetAddress[1];
				InternetAddress sendTo[] = new InternetAddress[1];
				try {
					sendTo[0]= new InternetAddress(address);
				} catch (AddressException e) {
					e.printStackTrace();
				}
				try {
					daiyuzhens[0] = new InternetAddress(daiyuzhenEmail);
				} catch (AddressException e) {
					e.printStackTrace();
				}
				String content ="xingさん<br>お疲れ様です。nameです。<br><br>申請稼働修正,望批准。<br><br>以上です、よろしくお願い致します。";
				content = content.replaceAll("name", param.getUser_name());
				content = content.replaceAll("xing", param.getLeader().substring(0,1));
				/*content = content.replaceAll("start", param.getStart_time_add());
				content = content.replaceAll("end", param.getEnd_time_add());*/
				String jncard=param.getUser_id();
				String officemail = queryDAO.executeForObject("findOfficEmail",
						jncard, String.class);
				String maillian = "@trans-cosmos.com.cn";
				String from = officemail + maillian;
				String subject="【系统邮件】【稼働修正申請】";
				Mail.sendAll(from, "123456", sendTo, daiyuzhens, null, subject, content,
						null);}
else if("5".equals(param.getReason_type())){
	//代玉珍邮箱号
	String daiyuzhen =queryDAO.executeForObject("SearchdaiyuzhenEmail","1070" , java.lang.String.class);
	String daiyuzhenName =queryDAO.executeForObject("daiyuzhenName","1070" , java.lang.String.class);
	//代玉珍邮箱
	String daiyuzhenEmail = daiyuzhen+"@trans-cosmos.com.cn";
	InternetAddress daiyuzhens[]=new InternetAddress[1];
	try {
					daiyuzhens[0] = new InternetAddress(daiyuzhenEmail);
				} catch (AddressException e) {
					e.printStackTrace();
				}
	String content = "xingさん<br>お疲れ様です。nameです。<br><br>稼働修正申請,,望批准。<br><br>以上です、よろしくお願い致します。";
	content = content.replaceAll("name",param.getUser_name());
	content = content.replaceAll("xing", daiyuzhenName.substring(0, 1));
/*	content = content.replaceAll("start", param.getStart_time_add());
	content = content.replaceAll("end", param.getEnd_time_add());*/
	String jncard=param.getUser_id();
	String officemail = queryDAO.executeForObject(
			"findOfficEmail", jncard, String.class);
	String maillian = "@trans-cosmos.com.cn";
	String from = officemail + maillian;

	String subject = "【系统邮件】【稼働修正申請】";
	Mail.sendAll(from, "123456", daiyuzhens, null, null,
			subject, content, null);
}
		BLogicMessages messages = new BLogicMessages();
		messages.add("message",new BLogicMessage("message.attendance05.insert", param.getUser_id()));
		result.setMessages(messages);
		result.setResultString("success");
		result.setResultObject(output);
		return result;
	}


}
