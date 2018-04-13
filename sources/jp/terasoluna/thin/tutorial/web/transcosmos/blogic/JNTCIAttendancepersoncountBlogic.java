package jp.terasoluna.thin.tutorial.web.transcosmos.blogic;

import java.util.List;

import jp.terasoluna.fw.dao.QueryDAO;
import jp.terasoluna.fw.dao.UpdateDAO;
import jp.terasoluna.fw.service.thin.BLogic;
import jp.terasoluna.fw.service.thin.BLogicResult;
import jp.terasoluna.thin.tutorial.web.transcosmos.dto.JNTCIAttenceParamBean;
import jp.terasoluna.thin.tutorial.web.transcosmos.dto.JNTCIQueryInput;
import jp.terasoluna.thin.tutorial.web.transcosmos.dto.JNTCIQueryOut;
import jp.terasoluna.thin.tutorial.web.transcosmos.vo.JNTCIAttendance001;
import jp.terasoluna.thin.tutorial.web.transcosmos.vo.JNTCIAttendance002VO;

public class JNTCIAttendancepersoncountBlogic implements
		BLogic<JNTCIQueryInput> {
	private UpdateDAO updateDAO = null;
	private QueryDAO queryDAO = null;

	public UpdateDAO getUpdateDAO() {
		return updateDAO;
	}

	public void setUpdateDAO(UpdateDAO updateDAO) {
		this.updateDAO = updateDAO;
	}

	public QueryDAO getQueryDAO() {
		return queryDAO;
	}

	public void setQueryDAO(QueryDAO queryDAO) {
		this.queryDAO = queryDAO;
	}

	public BLogicResult execute(JNTCIQueryInput param) {
		BLogicResult result = new BLogicResult();
		String month = param.getMonth();
		int allhour = 0;
		JNTCIQueryOut output = new JNTCIQueryOut();
		// 我们用这个别人建的类JNTCIAttenceParamBean来作为一个封装类，用来对月份进行赋值。
		JNTCIAttenceParamBean tempMap = new JNTCIAttenceParamBean();
		// 从TEMP_ATTENCE_MANAGER1表中查询年月日和卡号
		List<JNTCIAttendance001> searchdate001 = queryDAO.executeForObjectList(
				"searchdate001", param);
		int ss = searchdate001.size();
		String[] monthcollect = new String[searchdate001.size()];
		for (int i = 0; i < searchdate001.size(); i++) {
			String dateaaa = searchdate001.get(i).getHIDUKE();
			String[] splitdate = dateaaa.split("/");
			String getmonth = splitdate[1];
			tempMap.setMonth(getmonth);
			tempMap.setHIDUKE(searchdate001.get(i).getHIDUKE());
			tempMap.setJn_card(searchdate001.get(i).getJN_CARD());
			// 应该用update更新语句，将日期和卡号两个联合主键对应的月份更新到TEMP_ATTENCE_MANAGER1表中。
			int dd = updateDAO.execute("kaoqinmonth", tempMap);
			monthcollect[i] = getmonth;
		}
		// 遍历盛有所有月份的集合monthcollect
		// 注意：这个月份集合的遍历会影响到下面考勤是间的输出，所以当下面的逻辑处理完成后可以使用return跳出这个月份循环
		for (int m = 0; m < monthcollect.length; m++) {
			if (monthcollect[m].equals(month)) {
				// 根据输入的月份查询出该月的所有信息
				List<JNTCIAttendance002VO> searchshismonthmessage = queryDAO
						.executeForObjectList("searchthismonthmessage", param);
				// 数组hours用来接收得到的上班时间
				Integer[] hours = new Integer[searchshismonthmessage.size()];
				// 集合searchdate002用来存放查询出来的所有卡号
				List<JNTCIAttendance001> searchdate002 = queryDAO
						.executeForObjectList("searchdate002", param);
				// 遍历本月的所有信息，查询出同一卡号的上班时间，加班时间，旷工时间等。
				for (int j = 0; j < searchdate002.size(); j++) {
					for (int n = 0; n < searchshismonthmessage.size(); n++) {
						if (searchdate002
								.get(j)
								.getJN_CARD()
								.equals(searchshismonthmessage.get(n)
										.getJN_CARD())) {
							hours[n] = searchshismonthmessage.get(n)
									.getTIME_COUNT();
							Integer hour = hours[n];
							allhour = allhour + hour;
						}
					}
					allhour = 0;
				}
				result.setResultString("success");
				return result;
			}
			break;
		}
		result.setResultString("success");
		return result;
	}
}