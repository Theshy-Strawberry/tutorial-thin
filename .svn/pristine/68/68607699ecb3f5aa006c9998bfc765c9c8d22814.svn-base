package jp.terasoluna.thin.tutorial.web.transcosmos.blogic;


import java.util.List;

import jp.terasoluna.fw.dao.QueryDAO;
import jp.terasoluna.fw.service.thin.BLogic;
import jp.terasoluna.fw.service.thin.BLogicResult;
import jp.terasoluna.thin.tutorial.web.transcosmos.dto.JNTCIAttendance03Dto;


public class JNTCIAttendance03Blogic implements BLogic<JNTCIAttendance03Dto> {

		    private QueryDAO queryDAO = null;
		    public void setQueryDAO(QueryDAO queryDAO) {
				this.queryDAO = queryDAO;
			}


			public BLogicResult execute(JNTCIAttendance03Dto dto) {
				String JN_CARD = dto.getJnCard();
				// SELECT 個人情報
				JNTCIAttendance03Dto attendance = queryDAO.executeForObject("leave", JN_CARD, JNTCIAttendance03Dto.class);
						attendance.setDeptId(attendance.getDeptId());
						attendance.setDeptName(attendance.getDeptName());
						String ProjectPmName = attendance.getProjectPm();
						String card = attendance.getJnCard();
				//根据leader姓名查询工号和email
					String projectPmCard =	queryDAO.executeForObject("SerachPmCard",ProjectPmName , java.lang.String.class);
					String PmEmailName = queryDAO.executeForObject("SerachPmEmail",projectPmCard ,  java.lang.String.class);
					String pmEmail = PmEmailName + "@trans-cosmos.com.cn";
					//根据自己工号查询自己的email
					String myEmailStart = queryDAO.executeForObject("SerachMyEmail",card, java.lang.String.class);
					String myEmail = myEmailStart + "@trans-cosmos.com.cn";
				//获取数据库中的节假日列表
				List<JNTCIAttendance03Dto> detailDateList = queryDAO.executeForObjectList("detailDate", null);
				BLogicResult result = new BLogicResult();
				int i=0;
				String array[]=new String[detailDateList.size()];
				String aaString=new String();
				//循环遍历节假日列表取出需要的字段
				for (i=0;i<detailDateList.size();i++) {
				   array[i]=detailDateList.get(i).getDetailDate();
				   aaString=array[i]+" "+aaString;
				}
				attendance.setDetailDate(aaString);

				// 休むをタイプ(List)
				List<JNTCIAttendance03Dto> leaveTypeList = queryDAO.executeForObjectList("leaveType", null);
				attendance.setLeaveTypeList(leaveTypeList);
				attendance.setPreserVation("2");
				attendance.setPmEmail(pmEmail);
				attendance.setMyEmail(myEmail);
		    	result.setResultObject(attendance);
		    	result.setResultString("success");

		    	return result;
			}
	}
