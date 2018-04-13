package jp.terasoluna.thin.tutorial.web.transcosmos.blogic;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import jp.terasoluna.fw.dao.QueryDAO;
import jp.terasoluna.fw.dao.UpdateDAO;
import jp.terasoluna.fw.service.thin.BLogic;
import jp.terasoluna.fw.service.thin.BLogicResult;
import jp.terasoluna.thin.tutorial.web.common.controller.DateController;
import jp.terasoluna.thin.tutorial.web.common.controller.TimeCompare;
import jp.terasoluna.thin.tutorial.web.transcosmos.dto.JNTCIAttenceFileResultBean;
import jp.terasoluna.thin.tutorial.web.transcosmos.dto.JNTCIImportDataInput;
import jp.terasoluna.thin.tutorial.web.transcosmos.dto.JNTCIAttenceResultBean;
import jp.terasoluna.thin.tutorial.web.transcosmos.dto.JNTCIAttenceParamBean;
import jp.terasoluna.thin.tutorial.web.transcosmos.vo.JNTCIImportDataVO;

public class JNTCICardDataQueryBlogic implements BLogic<JNTCIImportDataInput> {

	private QueryDAO queryDAO = null;
	private UpdateDAO updateDAO = null;

	public BLogicResult execute(JNTCIImportDataInput args) {

		BLogicResult result = new BLogicResult();
		// 从TT_ATTENCE_MANAGER1表中查询所有的唯一的卡号（临时表）
		List<JNTCIImportDataVO> empNoList = queryDAO.executeForObjectList(
				"SelectEmpNo", null);
		String  workdata = args.getWork_date();
		String[] monthList = { "01", "02", "03", "04", "05", "06", "07", "08",
				"09", "10", "11", "12", "13", "14", "15", "16", "17", "18",
				"19", "20", "21", "22", "23", "24", "25", "26", "27", "28",
				"29", "30", "31" };
		// 记录系统时间
		Timestamp time = DateController.getStringToTimestamp(DateController
				.getDateToString(new Date(), DateController.YMDHMSs));
		for (int i = 1; i <= 31; i++) {
			// 获取一月之中的每一天
			String day = "/" + monthList[i - 1];
			JNTCIAttenceFileResultBean param = new JNTCIAttenceFileResultBean();
			// 设置一月中的每一天
			param.setWork_date(day);
/*			param.setYmd(workdata);*/
			// 遍历每一个卡号
			for (int j = 0; j < empNoList.size(); j++) {
				param.setJn_card(empNoList.get(j).getJn_card());// 设置卡号
				JNTCIAttenceResultBean carddatalist = new JNTCIAttenceResultBean();
				JNTCIAttenceParamBean tempMap = new JNTCIAttenceParamBean();
				// 通过卡号查询该人的姓名和部门编号 select USER_NAME as name,DEPT_ID as dept_id
				// from tt_sys_user where
				List<JNTCIAttenceResultBean> empinfo = queryDAO
						.executeForObjectList("SearchEmpInfo", param);

				if (empinfo.size() > 0) {
					tempMap.setDept_id(empinfo.get(0).getDept_id());
					tempMap.setName(empinfo.get(0).getName());
					// 从TT_ATTENCE_MANAGER1表中查询 打卡年月日，卡号，上班打卡时间，下班打卡时间。
					carddatalist = queryDAO.executeForObject("SelectCardDate",
							param, JNTCIAttenceResultBean.class);

					if (carddatalist != null) {
						JNTCIAttenceParamBean tempparam = new JNTCIAttenceParamBean();
						tempparam.setJn_card(carddatalist.getJn_card());
						tempparam.setWork_date(carddatalist.getWork_date());

						//查询出差表
						 int count = queryDAO.executeForObject("evectionInfo",tempparam ,Integer.class);


						// 根据某人的卡号和打卡日期从TEMP_ATTENCE_MANAGER1表中查询所有字段信息
						String tempCount = queryDAO.executeForObject(
								"SelectAttenceInfoCount", tempparam,
								String.class);
						if (tempCount == null && count != 1) {
							String starttime = carddatalist.getStart_date();
							String endtime = carddatalist.getEnd_date();
							String[] starttimes = starttime.split(" ");
							String[] ymd = starttimes[0].split("/");
							String month = ymd[1];
							double TIME_COUNT = TimeCompare.getTimeCount(
									starttime, endtime);
							if (TIME_COUNT <= 0) {
								TIME_COUNT = 0;
							}
							tempMap.setToroku_timestamp(time);
							tempMap.setTime_count(TIME_COUNT);
							tempMap.setEnd_date(carddatalist.getEnd_date());
							tempMap.setStart_date(carddatalist.getStart_date());
							tempMap.setJn_card(carddatalist.getJn_card());
							tempMap.setWork_date(carddatalist.getWork_date());
							tempMap.setToroku_user(args.getUserId());
							tempMap.setMonth(month);
							// 向TEMP_ATTENCE_MANAGER1表中插入数据
							updateDAO.execute("kaoqin", tempMap);
						}
					}
				}
			}
		}
		result.setResultString("success");
		return result;
	}

	public QueryDAO getQueryDAO() {
		return queryDAO;
	}

	public UpdateDAO getUpdateDAO() {
		return updateDAO;
	}

	public void setUpdateDAO(UpdateDAO updateDAO) {
		this.updateDAO = updateDAO;
	}

	public void setQueryDAO(QueryDAO queryDAO) {
		this.queryDAO = queryDAO;
	}
}
