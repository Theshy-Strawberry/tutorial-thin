package jp.terasoluna.thin.tutorial.web.transcosmos.blogic;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

import oracle.net.aso.s;
import jp.terasoluna.fw.dao.QueryDAO;
import jp.terasoluna.fw.dao.UpdateDAO;
import jp.terasoluna.fw.service.thin.BLogic;
import jp.terasoluna.fw.service.thin.BLogicMessage;
import jp.terasoluna.fw.service.thin.BLogicMessages;
import jp.terasoluna.fw.service.thin.BLogicResult;
import jp.terasoluna.thin.tutorial.web.common.controller.GetWorkDay;
import jp.terasoluna.thin.tutorial.web.common.controller.LeaveDetail;
import jp.terasoluna.thin.tutorial.web.common.controller.Mail;
import jp.terasoluna.thin.tutorial.web.transcosmos.dto.JNTCIAttendance04selectInfo;
import jp.terasoluna.thin.tutorial.web.transcosmos.dto.JNTCIAttendance04selectInput;
import jp.terasoluna.thin.tutorial.web.transcosmos.dto.JNTCIAttendance04selectOutput;
import jp.terasoluna.thin.tutorial.web.transcosmos.dto.JNTCIAttendance04updateInput;
import jp.terasoluna.thin.tutorial.web.transcosmos.vo.JNTCIAttendanceVo;

public class JNTCIAttendance04updateBLogic implements
		BLogic<JNTCIAttendance04updateInput> {

	private UpdateDAO updateDAO = null;

	public void setUpdateDAO(UpdateDAO updateDAO) {
		this.updateDAO = updateDAO;
	}

	private QueryDAO queryDAO = null;

	public void setQueryDAO(QueryDAO queryDAO) {
		this.queryDAO = queryDAO;
	}

	public BLogicResult execute(JNTCIAttendance04updateInput param) {

		int ShenseiM = 0;
		 int ShenseiY = 0;
		 String leave_id = param.getLeave_id();
		  String  examine_reason =param.getExamine_reason();

		  if(examine_reason==null){
			  examine_reason = "";
		  }
		if("goback".equals(param.getExamine_person())){
			BLogicResult result = new BLogicResult();
			JNTCIAttendance04selectOutput output = new JNTCIAttendance04selectOutput();
			output.setCod(param.getCod());
			output.setStartIndex(param.getStartIndex());
			output.setUserId(param.getUserId());
			output.setApplication_type_serch(param.getApplication_type_serch());
			output.setDept_id_serch(param.getDept_id_serch());
			output.setExamine_status_serch(param.getExamine_status_serch());
			output.setName_serch(param.getName_serch());
			output.setJn_card_serch(param.getJn_card_serch());
			output.setLeave_endtime_serch(param.getLeave_endtime_serch());
			output.setLeave_starttime_serch(param.getLeave_starttime_serch());
			output.setLeave_type_serch(param.getLeave_type_serch());
		   //该处是从详细页面随意传一个值，用来判断是不是页码跳转的
			output.setExamine_status(param.getExamine_status());
			result.setResultObject(output);
			result.setResultString("success2");
			return result;

}else{
	/* if( leave_id!=null){
		  updateDAO.execute("deleteLeaveDetail", leave_id);
	  }*/
	        if(examine_reason.length()<=33){
		//只能在下个月三个工作日之前之前补限制，
        Date Systime = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");//可以方便地修改日期格式
        String sfd = dateFormat.format( Systime );
        List<Date> holidaylist1 = queryDAO.executeForObjectList("holidaylist", null);
        String start=sfd.substring(0,8).concat("01");

        //申请年月
        String lSt = param.getLeave_starttime();
        if( lSt != null){
        	ShenseiM=Integer.parseInt(lSt.substring(5, 7));
            ShenseiY=Integer.parseInt(lSt.substring(0, 4));
        }

        //系统年月
        int SM=Integer.parseInt(sfd.substring(5, 7));
        int SY=Integer.parseInt(sfd.substring(0, 4));
        int dayCount = GetWorkDay.workDays(start,sfd,holidaylist1);
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
if(ShenseiM==0&&ShenseiY==0)
{BLogicResult result = new BLogicResult();
result.setResultString("success1");
return result;}
else        if((ShenseiM>=SM&&ShenseiY>=SY)||(dayCount<4&&ShenseiMNext==SM&&ShenseiYNext==SY)){
	 if( leave_id!=null){
		  updateDAO.execute("deleteLeaveDetail", leave_id);
	  }
        if(param.getExamine_status().equals("flag")){
        	param.setExamine_paper_fg("0");
        }
		String uername = param.getUserName();
		int startIndex = 0;
		int row = 10;
		String user_id = param.getJn_card();
		/*String leave_id = param.getLeave_id();*/
        if("3".equals(param.getCode())){
            updateDAO.execute("deleteLeaveDetail", leave_id);
            updateDAO.execute("updateLeavemenageDetail", leave_id);
        }
		BLogicResult result = new BLogicResult();
		//如果上级审查且时间不大于三天并且返回值为未审查状态
		if ("flag".equals(param.getExamine_status())&&Double.parseDouble(param.getLeave_totaltime())<24) {

			double totalDays;
			// 假期剩余


				List<JNTCIAttendance04selectInfo> vocationCountListR = queryDAO
						.executeForObjectList("Vocation", user_id);
				//当年假时间不为零
				if (vocationCountListR.size() != 0) {
					if (vocationCountListR.get(0).getRemain_days() != null) {
						// 数据库内
						totalDays = vocationCountListR.get(0).getRemain_days();
						// 这次请假
						param.setTotalDays(totalDays);
						updateDAO.execute("JNTCIAttendance04rollback3", param);
						//返回年假 更新数据
					}

			} else {
				/*updateDAO.execute("JNTCIAttendance04rollback2", param);*///修改在此注销掉语句
				//当年假为零时，直接更新数据
				updateDAO.execute("JNTCIAttendance04rollback3", param);
			}
			//如果审查者是田总并且审查结果为审查济
		}else if("1002".equals(param.getUserId())&&"A08".equals(param.getExamine_status())){
			double totalDays;
			// 假期剩余

				List<JNTCIAttendance04selectInfo> vocationCountListR = queryDAO
						.executeForObjectList("Vocation", user_id);
				if (vocationCountListR.size() != 0) {
					if (vocationCountListR.get(0).getRemain_days() != null) {
						// 数据库内
						totalDays = vocationCountListR.get(0).getRemain_days();
						param.setTotalDays(totalDays);
						//updateDAO.execute("JNTCIAttendance04rollback", param);
						/*updateDAO.execute("JNTCIAttendance04rollback2", param);*///修改在此注销掉语句
						updateDAO.execute("JNTCIAttendance04rollback5", param);
					}

			} else {
				/*updateDAO.execute("JNTCIAttendance04rollback2", param);*///修改在此注销掉语句
				updateDAO.execute("JNTCIAttendance04rollback3", param);
			}
	  //如果登录用户是衣总或者是栋桑 返回结果是未审查并且时间还小于24小时
		}else if(("1003".equals(param.getUserId())||"1004".equals(param.getUserId()))&&"A04".equals(param.getExamine_status())&&Double.parseDouble(param.getLeave_totaltime())<24){
			double totalDays;
			// 假期剩余
			/*	double absence = queryDAO.executeForObject(
						"JNTCIAttendance04rollback4", param.getLeave_id(),
						Double.class);//修改在此添加的查询语句
*/				List<JNTCIAttendance04selectInfo> vocationCountListR = queryDAO
						.executeForObjectList("Vocation", user_id);
				if (vocationCountListR.size() != 0) {
					if (vocationCountListR.get(0).getRemain_days() != null) {
						// 数据库内
						totalDays = vocationCountListR.get(0).getRemain_days();
						// 这次请假
					/*	String leaveTotal = param.getLeave_totaltime();
						double temp = Double.parseDouble(leaveTotal);
						totalDays = totalDays + temp - absence;//修改在此计算年假的返回时间
*/						param.setTotalDays(totalDays);
					//	updateDAO.execute("JNTCIAttendance04rollback", param);
						/*updateDAO.execute("JNTCIAttendance04rollback2", param);*///修改在此注销掉语句
						updateDAO.execute("JNTCIAttendance04rollback3", param);
					}

			} else {
				/*updateDAO.execute("JNTCIAttendance04rollback2", param);*///修改在此注销掉语句
				updateDAO.execute("JNTCIAttendance04rollback3", param);
			}

		}else if("1004".equals(param.getUserId())&&"A04".equals(param.getExamine_status())){
			double totalDays;
			// 假期剩余
				/*double absence = queryDAO.executeForObject(
						"JNTCIAttendance04rollback4", param.getLeave_id(),
						Double.class);//修改在此添加的查询语句
*/				List<JNTCIAttendance04selectInfo> vocationCountListR = queryDAO
						.executeForObjectList("Vocation", user_id);
				if (vocationCountListR.size() != 0) {
					if (vocationCountListR.get(0).getRemain_days() != null) {
						// 数据库内
						totalDays = vocationCountListR.get(0).getRemain_days();
						// 这次请假
						//String leaveTotal = param.getLeave_totaltime();
						//double temp = Double.parseDouble(leaveTotal);
					/*	totalDays = totalDays + temp - absence;//修改在此计算年假的返回时间
*/						param.setTotalDays(totalDays);
						//updateDAO.execute("JNTCIAttendance04rollback", param);
						/*updateDAO.execute("JNTCIAttendance04rollback2", param);*///修改在此注销掉语句
						updateDAO.execute("JNTCIAttendance04rollback3", param);
					}

			} else {
				/*updateDAO.execute("JNTCIAttendance04rollback2", param);*///修改在此注销掉语句
				updateDAO.execute("JNTCIAttendance04rollback3", param);
			}
			//当状态是许可、未许可
		} else if("A02".equals(param.getExamine_status())||"A03".equals(param.getExamine_status())||"A10".equals(param.getExamine_status())||"A12".equals(param.getExamine_status())||"A13".equals(param.getExamine_status())){

		 // 假期剩余
            List<JNTCIAttendance04selectInfo> vocationCountList = queryDAO
                    .executeForObjectList("Vocation", user_id);
            String type = param.getLeave_type();
            String leave_type = queryDAO.executeForObject("selecttype", type, String.class);
            // 年假天数
            double totalDays = 0;
            double exCount = 0;
            if(param.getLeave_totaltime() != null){
                exCount = Double.parseDouble(param.getLeave_totaltime());
            }
            // 取得数据库中的假期List
            List<Date> holidaylist = queryDAO.executeForObjectList("holidaylist", null);
         // 同意的话
            if ("A03".equals(param.getExamine_status())||"A10".equals(param.getExamine_status())||"A13".equals(param.getExamine_status())) {
                if (vocationCountList != null && vocationCountList.size() > 0) {
                    double total = Double.parseDouble(param
                            .getLeave_totaltime());

                    if (vocationCountList.get(0).getRemain_days() != null) {
                        totalDays = vocationCountList.get(0).getRemain_days();
                    } else {
                        totalDays = 0;
                    }
                    if ("年休".equals(param.getLeave_type())
                            || "私用休暇".equals(param.getLeave_type())) {
                        if (totalDays >= total) {//修改在此做的年假扣除得修改，其中把param.setLeave_totaltime改为param.setTotalDays并删除了param.setJn_card(user_id);
                            double absence=0;
                            param.setAbsence(absence);
                            double upTotaltime = totalDays - total;
                            param.setTotalDays(upTotaltime);
                            //updateDAO.execute("vocationUpdate3", param);
                        }else{
                            double absence=total-totalDays;
                            param.setAbsence(absence);
                            double upTotaltime=0;
                            param.setTotalDays(upTotaltime);
                            //updateDAO.execute("vocationUpdate3", param);
                        }//修改到此结束
                    }else{
                        param.setAbsence(total);
                    }
                }
                List<JNTCIAttendanceVo> detailList = LeaveDetail.getAttendance(param.getLeave_id(), param.getLeave_starttime(), param.getLeave_endtime(),
                        exCount, leave_type, holidaylist);
                for(int i = 0; i < detailList.size(); i++){
                    updateDAO.execute("leaveDetail", detailList.get(i));
                }
            }else if (!"A02".equals(param.getExamine_status())||!"A12".equals(param.getExamine_status())) {
                param.setAbsence(Double.parseDouble(param.getLeave_totaltime()));
            }
            updateDAO.execute("JNTCIAttendance04disagree", param);//此语句从66行移至此
            updateDAO.execute("JNTCIAttendance04disagree2", param);//此语句从67行移至此
            param.setJn_card("");
			//如果返回状态是以下状态，直接更新状态
		}else if("A01".equals(param.getExamine_status())||"flag".equals(param.getExamine_status())||"A08".equals(param.getExamine_status())||"A11".equals(param.getExamine_status())||("1003".equals(param.getUserId())||"1004".equals(param.getUserId())||"1002".equals(param.getUserId()))&&"A04".equals(param.getExamine_status())) {
			if("flag".equals(param.getExamine_status())){
				param.setExamine_status("A04");
				updateDAO.execute("JNTCIAttendance04disagree", param);//此语句从66行移至此
				updateDAO.execute("JNTCIAttendance04disagree2", param);//此语句从67行移至此
				updateDAO.execute("reasonback", param);
			}else{

				updateDAO.execute("JNTCIAttendance04disagree", param);//此语句从66行移至此
				updateDAO.execute("JNTCIAttendance04disagree2", param);//此语句从67行移至此

			}
		}









/*
 * A01承认中
 * A08承认济
 *
 * A13二级许可
 * A03一级许可
 *
 * A02一级未许可
 * A11二级未许可

 * A12三级未许可
 * A10三级许可
 *
 *
 * 直属上司 project_pm
 * leave_id 休假id
 * examine_status 审查状态
 * leave_type 休假种类
 * leave_totaltime 休假时长
 * jn_card  请假人济南卡号
 * examine_person 审查人
 * userName  登录者用户名
 * examine_paper_fg  请假资料确认
 * userId 登录者
 *
*/
		if(!"flag".equals(param.getExamine_status())){
		//登录者
		String userId = param.getUserId();
		//登录者邮箱号
		String user = queryDAO.executeForObject("SerachUserEmail", userId, java.lang.String.class);
		//登录者邮箱
		String userEmail = user + "@trans-cosmos.com.cn";
		//请假员工卡号
		//String jn_card = param.getJn_card();

		//请假员工姓名
		String leavePeopleName =queryDAO.executeForObject("SearchMyName", user_id, java.lang.String.class);
		//请假员工直属上司（审查人名字）
		String  bossName = queryDAO.executeForObject("SearchBossName", leavePeopleName, java.lang.String.class);
		String  examine_person_Card=queryDAO.executeForObject("SearchExamineCard", bossName, java.lang.String.class);
		//代玉珍邮箱号
		String daiyuzhen =queryDAO.executeForObject("SearchdaiyuzhenEmail","1070" , java.lang.String.class);
		//代玉珍邮箱
		String daiyuzhenEmail = daiyuzhen+"@trans-cosmos.com.cn";
		//pl员工名字
		String plName = queryDAO.executeForObject("SearchPlName", bossName, java.lang.String.class);
		//pl员工号
		String plId = queryDAO.executeForObject("SearchPlId", plName, java.lang.String.class);
		//pl张栋邮箱号
		String pl = queryDAO.executeForObject("SearchPlEmail",plId , java.lang.String.class);
		//pl张栋邮箱
		String plEmail = pl+"@trans-cosmos.com.cn";
		//老田的名字
		String managerName = queryDAO.executeForObject("SearchManagerName",plName , java.lang.String.class);
		//老田的员工号
		String managerId = queryDAO.executeForObject("SearchManagerId", managerName, java.lang.String.class);
		//老田的邮箱号
		String manager = queryDAO.executeForObject("SearchManagerEmail", managerId, java.lang.String.class);
		//老田的邮箱
		String managerEmail = manager +"@trans-cosmos.com.cn";
		//请假者的邮箱号
		String leavePeople = queryDAO.executeForObject("SerachMyEmail", user_id, java.lang.String.class);
		//请假者的邮箱
		String leavePeopleEmail = leavePeople + "@trans-cosmos.com.cn";
		//批准理由
		String reason = param.getExamine_reason();
		//请假理由
		String leaveReason = param.getLeave_reason();
		//请假时长
		String leaveTotal = param.getLeave_totaltime();
		//请假开始时间和结束时间
		String Leave_starttime = param.getLeave_starttime();
		Leave_starttime= Leave_starttime.split(" ")[0]+" "+ Leave_starttime.split(" ")[ Leave_starttime.split(" ").length-1];
		String Leave_endtime = param.getLeave_endtime();
		Leave_endtime = Leave_endtime.split(" ")[0]+" "+ Leave_endtime.split(" ")[ Leave_endtime.split(" ").length-1];
		double temp = Double.parseDouble(leaveTotal);
		//信标题（同意）
		String subject = "【系统邮件】【批准】【请假申请】 "+user_id+"."+leavePeopleName+"."+Leave_starttime+"—"+Leave_endtime;
		//新标题（不同意）
		String subjectNotAgree = "【系统邮件】【不批准】【请假申请】 "+user_id+"."+leavePeopleName+"."+Leave_starttime+"—"+Leave_endtime;
		//信同意正文
		String agreeContent = null;
		if(temp>=24){
		if(userId.equals(examine_person_Card)){
			agreeContent = plName+"桑<br><br>工作辛苦了<br><br>"+leaveReason+"<br><br>以上";
		}else if(userId.equals(plId)){
			agreeContent = managerName+"桑<br><br>工作辛苦了<br><br>"+leaveReason+"<br><br>以上";
		}else if(userId.equals(managerId)){
			agreeContent = leavePeopleName+"桑 代宇珍桑<br><br>工作辛苦了<br><br>"+leaveReason+"<br><br>以上";
		}
		}else if(temp<24){
			if(userId.equals(examine_person_Card)){
				agreeContent = leavePeopleName+"桑 代宇珍桑<br><br>工作辛苦了<br><br>"+leaveReason+"<br><br>以上";
			}
		}


		//不同意的信正文
		String disagreeContent = leavePeopleName+"桑<br><br>工作辛苦了<br><br> 非常抱歉，不能同意你的请假，请以工作为重<br><br>以上";
		  InternetAddress[] daiyuzhens = new InternetAddress[1];
		  InternetAddress[] leave = new InternetAddress[1];
		  InternetAddress[] pls = new InternetAddress[1];
		  InternetAddress[] managers = new InternetAddress[1];
		  try {
				 daiyuzhens[0] = new InternetAddress(daiyuzhenEmail);
				 leave[0] = new InternetAddress(leavePeopleEmail);
				 pls[0] = new InternetAddress(plEmail);
				 managers[0] = new InternetAddress(managerEmail);
			} catch (AddressException e) {
				e.printStackTrace();
			}
		//请假小于24小时
		if(temp<24){
			//同意
			if("A03".equals(param.getExamine_status())||"A13".equals(param.getExamine_status())){
				//发信给代玉珍和请假者
				       Mail.sendAll(userEmail, "123456", leave, daiyuzhens, null, subject, agreeContent, null);
			}else{
				//发信给请假者
				       Mail.sendAll(userEmail, "123456", leave, null, null, subjectNotAgree, disagreeContent, null);
			}
			//大于24小时
		}else if(temp>=24){
			//pm承认后（承认中）
			if("A01".equals(param.getExamine_status())){
				//发信给张栋
				Mail.sendAll(userEmail, "123456", pls, null, null, subject, agreeContent, null);
				//pl承认 （承认济）
			}else if("A08".equals(param.getExamine_status())){
				//发信给老田
				Mail.sendAll(userEmail, "123456", managers, null, null, subject, agreeContent, null);
				//老田同意后（三级许可）
			}else if("A10".equals(param.getExamine_status())){
				//发信给代玉珍和请假者
				Mail.sendAll(userEmail, "123456", leave, daiyuzhens, null, subject, agreeContent, null);
				//pm不同意或者pl不同意或者老田不同意
			}else if("A02".equals(param.getExamine_status())||"A11".equals(param.getExamine_status())||"A12".equals(param.getExamine_status())){
				//发信给请假者
				Mail.sendAll(userEmail, "123456", leave, null, null, subjectNotAgree, disagreeContent, null);
			}
		}
		}
		result.setResultString("success");
		// 休暇種類list取得
		List<JNTCIAttendance04selectInfo> kj_nameList = queryDAO
				.executeForObjectList("LeaveType", null);
		// 部門list取得
		List<JNTCIAttendance04selectInfo> dept_List = queryDAO
				.executeForObjectList("DeptId", null);
		List<JNTCIAttendance04selectInfo> application_List= queryDAO
				.executeForObjectList("ApplicationType", null);
		// 監査状態list取得
		List<JNTCIAttendance04selectInfo> status_List = queryDAO
				.executeForObjectList("ExamineStatus", null);
		// 一覧件数取得
		JNTCIAttendance04selectInput all = new JNTCIAttendance04selectInput();
		all.setUserName(uername);
		String totalCount = queryDAO.executeForObject(
				"JNTCIAttendance04selectCount", all, String.class);
		String totalCount1 = queryDAO.executeForObject(
				"JNTCIAttendance04selectCount1", all, String.class);
		String totalCount2 = queryDAO.executeForObject(
				"JNTCIAttendance04selectCount2", all, String.class);
		// 一覧データ取得
		List<JNTCIAttendance04selectInfo> JNTCIAttendance04selectInfo = queryDAO
				.executeForObjectList("JNTCIAttendance04select", all,
						startIndex, row);
		List<JNTCIAttendance04selectInfo> JNTCIAttendance04selectInfo1 = queryDAO
				.executeForObjectList("JNTCIAttendance04select1", all,
						startIndex, row);
		List<JNTCIAttendance04selectInfo> JNTCIAttendance04selectInfo2 = queryDAO
				.executeForObjectList("JNTCIAttendance04select2", all,
						startIndex, row);
		JNTCIAttendance04selectOutput output = new JNTCIAttendance04selectOutput();
		//获取前台登陆用户名
		String userName=param.getUserName();
		//如果用户名是张栋或者衣兰凯
		if("張棟".equals(userName)||"衣蘭凱".equals(userName)){
				output.setJn_card(null);
				output.setLeave_type(null);
				output.setApplication_type(null);
				output.setJNTCIAttendance04selectInfo(JNTCIAttendance04selectInfo1);
				output.setKj_cdList(kj_nameList);
				output.setDept_List(dept_List);
				output.setApplication_List(application_List);
				output.setStatus_List(status_List);
				output.setTotalCount(totalCount1);
				output.setExamine_status(param.getExamine_status());
				result.setResultObject(output);
				output.setCod(param.getCod());
				//如果登录用户是田东启
		}else if("田東啓".equals(userName)){
			output.setJn_card(null);
			output.setLeave_type(null);
			output.setApplication_type(null);
			output.setJNTCIAttendance04selectInfo(JNTCIAttendance04selectInfo2);
			output.setKj_cdList(kj_nameList);
			output.setDept_List(dept_List);
			output.setApplication_List(application_List);
			output.setStatus_List(status_List);
			output.setTotalCount(totalCount2);
			output.setExamine_status(null);
			result.setResultObject(output);
			output.setCod(param.getCod());
		}else{
				 output.setJn_card(null);
					output.setLeave_type(null);
					output.setApplication_type(null);
					output.setJNTCIAttendance04selectInfo(JNTCIAttendance04selectInfo);
					output.setKj_cdList(kj_nameList);
					output.setDept_List(dept_List);
					output.setApplication_List(application_List);
					output.setStatus_List(status_List);
					output.setTotalCount(totalCount);
					output.setExamine_status(null);
					result.setResultObject(output);
					output.setCod(param.getCod());
			}
		output.setStartIndex(param.getStartIndex());
		output.setUserId(param.getUserId());
		output.setApplication_type_serch(param.getApplication_type_serch());
		output.setDept_id_serch(param.getDept_id_serch());
		output.setExamine_status_serch(param.getExamine_status_serch());
		output.setName_serch(param.getName_serch());
		output.setJn_card_serch(param.getJn_card_serch());
		output.setLeave_endtime_serch(param.getLeave_endtime_serch());
		output.setLeave_starttime_serch(param.getLeave_starttime_serch());
		output.setLeave_type_serch(param.getLeave_type_serch());
		result.setResultObject(output);
		output.setCod(param.getCod());
		result.setResultString("success2");
		return result;
        }
      /*  if( ShenseiM == 0 &&  ShenseiY == 0
		 ){
        	BLogicResult result = new BLogicResult();
        	  result.setResultString("success1");
              return result;
        }*/
        	else{
        	BLogicMessages messages = new BLogicMessages();
       	    BLogicResult result = new BLogicResult();
            messages.add("message", new BLogicMessage(
                                 "errors.attendance05.timeOut"));
            result.setResultString("success1");
            result.setErrors(messages);
            return result;
        }}
  else{
	  BLogicMessages messages = new BLogicMessages();
	  BLogicResult result = new BLogicResult();
			messages.add("message", new BLogicMessage(
					"errors.maxlength", "休暇審査理由", "33"));
			result.setResultString("success1");
			result.setErrors(messages);
			return result;
}
	}

}
}