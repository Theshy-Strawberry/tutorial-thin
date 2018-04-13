package jp.terasoluna.thin.tutorial.web.transcosmos.blogic;

import java.io.UnsupportedEncodingException;
import java.util.List;

import jp.terasoluna.fw.dao.QueryDAO;
import jp.terasoluna.fw.service.thin.BLogic;
import jp.terasoluna.fw.service.thin.BLogicMessage;
import jp.terasoluna.fw.service.thin.BLogicMessages;
import jp.terasoluna.fw.service.thin.BLogicResult;
import jp.terasoluna.thin.tutorial.web.transcosmos.dto.JNTCIAttendance04selectInfo;
import jp.terasoluna.thin.tutorial.web.transcosmos.dto.JNTCIAttendance04selectInput;
import jp.terasoluna.thin.tutorial.web.transcosmos.dto.JNTCIAttendance04selectOutput;

public class JNTCIAttendance04selectBLogic implements
		BLogic<JNTCIAttendance04selectInput> {

	private QueryDAO queryDAO = null;

	public void setQueryDAO(QueryDAO queryDAO) {
		this.queryDAO = queryDAO;
	}

	public BLogicResult execute(JNTCIAttendance04selectInput param) {

		String strIndex = param.getStartIndex();
		String strRow = param.getRow();

		if("6".equals(param.getMark())){


			if (param.getApplication_type_serch() != null
					&& !"reset".equals(param.getCod())) {
				try {
					param.setApplication_type_serch(new String(param
							.getApplication_type_serch().getBytes("ISO-8859-1"), "utf-8"));
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
			}
			if (param.getExamine_status_serch() != null
					&& !"reset".equals(param.getCod())) {
				try {
					String examine_status_serch = new String(param.getExamine_status_serch()
							.getBytes("ISO-8859-1"), "utf-8");
					param.setExamine_status_serch(examine_status_serch);
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}

		}


			if (param.getName_serch() != null
					&& !"reset".equals(param.getCod())) {
				try {
					String name_serch = new String(param.getName_serch()
							.getBytes("ISO-8859-1"), "utf-8");
					param.setName_serch(name_serch);
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
			}

		}else{}
		/*if (param.getExamine_status_serch() != null
				&& !"reset".equals(param.getCod())) {
			try {
				String examine_status_serch = new String(param.getExamine_status_serch()
						.getBytes("ISO-8859-1"), "utf-8");
				param.setExamine_status_serch(examine_status_serch);
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}*/

		/*if (param.getName_serch() != null
				&& !"reset".equals(param.getCod())) {
			try {
				String name_serch = new String(param.getName_serch()
						.getBytes("ISO-8859-1"), "utf-8");
				param.setName_serch(name_serch);
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}*/

		 //用从详细页面传过来的值进行判断，如果是从详细页面传过来的值，将不进行下边的汉字转码
		/*	if (param.getName_serch() != null && !"reset".equals(param.getCod())) {
				try {
					param.setName_serch(new String(param.getName_serch().getBytes(
							"ISO-8859-1"), "utf-8"));

				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
			}*/


		int startIndex = 0;
		int row = 10;
		if (strIndex != null) {
			startIndex = Integer.parseInt(strIndex);

		}
		if (strRow != null) {
			row = Integer.parseInt(strRow);
		}
		String userName = param.getUserName();

		// 休暇種類list取得
		List<JNTCIAttendance04selectInfo> kj_nameList = queryDAO
				.executeForObjectList("LeaveType", null);
		// 部門list取得
		List<JNTCIAttendance04selectInfo> dept_List = queryDAO
				.executeForObjectList("DeptId", null);
		// 申請方式
		List<JNTCIAttendance04selectInfo> application_List = queryDAO
				.executeForObjectList("ApplicationType", null);
		// 監査状態list取得
		List<JNTCIAttendance04selectInfo> status_List = queryDAO
				.executeForObjectList("ExamineStatus", null);

		BLogicResult result = new BLogicResult(); // データ取得なし場合
		JNTCIAttendance04selectOutput output = new JNTCIAttendance04selectOutput();

		if("代宇珍".equals(param.getUserName())){
			String totalCount3 = queryDAO.executeForObject(
					"JNTCIAttendance04selectCount3", param, String.class);
			List<JNTCIAttendance04selectInfo> JNTCIAttendance04selectInfo3 = queryDAO
					.executeForObjectList("JNTCIAttendance04select3", param,
							startIndex, row);
			output.setJNTCIAttendance04selectInfo(JNTCIAttendance04selectInfo3);
			output.setKj_cdList(kj_nameList);
			output.setDept_List(dept_List);
			output.setApplication_List(application_List);
			output.setStatus_List(status_List);
			output.setTotalCount(totalCount3);
			output.setStartIndex(param.getStartIndex());
			if (param.getName_serch() != null && !"".equals(param.getName_serch())) {
				output.setName_serch(param.getName_serch());
			}
			if (param.getDept_id_serch() != null && !"".equals(param.getDept_id_serch())) {
				output.setDept_id_serch(param.getDept_id_serch());
			}
			if (param.getLeave_type_serch() != null
					&& !"".equals(param.getLeave_type_serch())) {
				output.setLeave_type_serch(param.getLeave_type_serch());
			}

			if (param.getApplication_type_serch() != null
					&& !"".equals(param.getApplication_type_serch())) {
				output.setApplication_type_serch(param.getApplication_type_serch());
			}
			if (param.getExamine_status_serch() != null
					&& !"".equals(param.getExamine_status_serch())) {
				output.setExamine_status_serch(param.getExamine_status_serch());
			}
			if (param.getLeave_endtime_serch() != null
					&& !"".equals(param.getLeave_endtime_serch())) {
				output.setLeave_endtime_serch(param.getLeave_endtime_serch());
			}
			if (param.getLeave_starttime_serch() != null
					&& !"".equals(param.getLeave_starttime_serch())) {
				output.setLeave_starttime_serch(param.getLeave_starttime_serch());
			}
			if (JNTCIAttendance04selectInfo3.isEmpty()) {
				BLogicMessages messages = new BLogicMessages();
				messages.add("message", new BLogicMessage("message.null"));
				result.setMessages(messages);
			}
			// 桁数チェック
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
			result.setResultObject(output);
			result.setResultString("success");
			return result;
		}else if(param.getUserName().equals("張棟")||param.getUserName().equals("衣蘭凱")){
			if(param.getUserName().equals("張棟")){
			String	totalCount1 = queryDAO.executeForObject(
						"JNTCIAttendance04selectCount1", param, String.class);
			List<JNTCIAttendance04selectInfo> JNTCIAttendance04selectInfo1 = queryDAO.executeForObjectList(
								"JNTCIAttendance04select1", param, startIndex, row);
			output.setJNTCIAttendance04selectInfo(JNTCIAttendance04selectInfo1);
			output.setKj_cdList(kj_nameList);
			output.setDept_List(dept_List);
			output.setApplication_List(application_List);
			output.setStatus_List(status_List);
			output.setTotalCount(totalCount1);
			output.setStartIndex(param.getStartIndex());
			output.setAdmitAllId(param.getAdmitAllId());
			if (param.getName_serch() != null && !"".equals(param.getName_serch())) {
				output.setName_serch(param.getName_serch());
			}
			if (param.getDept_id_serch() != null && !"".equals(param.getDept_id_serch())) {
				output.setDept_id_serch(param.getDept_id_serch());
			}
			if (param.getLeave_type_serch() != null
					&& !"".equals(param.getLeave_type_serch())) {
				output.setLeave_type_serch(param.getLeave_type_serch());
			}
			if (param.getApplication_type_serch() != null
					&& !"".equals(param.getApplication_type_serch())) {
				output.setApplication_type_serch(param.getApplication_type_serch());
			}
			if (param.getExamine_status_serch() != null
					&& !"".equals(param.getExamine_status_serch())) {
				output.setExamine_status_serch(param.getExamine_status_serch());
			}
			if (param.getLeave_endtime_serch() != null
					&& !"".equals(param.getLeave_endtime_serch())) {
				output.setLeave_endtime_serch(param.getLeave_endtime_serch());
			}
			if (param.getLeave_starttime_serch() != null
					&& !"".equals(param.getLeave_starttime_serch())) {
				output.setLeave_starttime_serch(param.getLeave_starttime_serch());
			}
			if (JNTCIAttendance04selectInfo1.isEmpty()) {
				BLogicMessages messages = new BLogicMessages();
				messages.add("message", new BLogicMessage("message.null"));
				result.setMessages(messages);
			}
			// 桁数チェック
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
			result.setResultObject(output);
			result.setResultString("success");
			return result;

			}else{
				String	totalCount1 = queryDAO.executeForObject(
						"JNTCIAttendance04selectCount4", param, String.class);
			// 衣总一覧データ取得
			List<JNTCIAttendance04selectInfo> JNTCIAttendance04selectInfo1 = queryDAO.executeForObjectList(
								"JNTCIAttendance04select4", param, startIndex, row);
			output.setJNTCIAttendance04selectInfo(JNTCIAttendance04selectInfo1);
			output.setKj_cdList(kj_nameList);
			output.setDept_List(dept_List);
			output.setApplication_List(application_List);
			output.setStatus_List(status_List);
			output.setTotalCount(totalCount1);
			output.setStartIndex(param.getStartIndex());
			output.setAdmitAllId(param.getAdmitAllId());
			if (param.getName_serch() != null && !"".equals(param.getName_serch())) {
				output.setName_serch(param.getName_serch());
			}
			if (param.getDept_id_serch() != null && !"".equals(param.getDept_id_serch())) {
				output.setDept_id_serch(param.getDept_id_serch());
			}
			if (param.getLeave_type_serch() != null
					&& !"".equals(param.getLeave_type_serch())) {
				output.setLeave_type_serch(param.getLeave_type_serch());
			}
			if (param.getApplication_type_serch() != null
					&& !"".equals(param.getApplication_type_serch())) {
				output.setApplication_type_serch(param.getApplication_type_serch());
			}
			if (param.getExamine_status_serch() != null
					&& !"".equals(param.getExamine_status_serch())) {
				output.setExamine_status_serch(param.getExamine_status_serch());
			}
			if (param.getLeave_endtime_serch() != null
					&& !"".equals(param.getLeave_endtime_serch())) {
				output.setLeave_endtime_serch(param.getLeave_endtime_serch());
			}
			if (param.getLeave_starttime_serch() != null
					&& !"".equals(param.getLeave_starttime_serch())) {
				output.setLeave_starttime_serch(param.getLeave_starttime_serch());
			}
			if (JNTCIAttendance04selectInfo1.isEmpty()) {
				BLogicMessages messages = new BLogicMessages();
				messages.add("message", new BLogicMessage("message.null"));
				result.setMessages(messages);
			}
			// 桁数チェック
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
			result.setResultObject(output);
			result.setResultString("success");
			return result;
			}


		}else if("田東啓".equals(userName)){
			// 田总所能看见的件数
		String	totalCount2 = queryDAO.executeForObject(
					"JNTCIAttendance04selectCount2", param, String.class);

			// 田总一覧データ取得
		List<JNTCIAttendance04selectInfo> JNTCIAttendance04selectInfo2 = queryDAO.executeForObjectList(
					"JNTCIAttendance04select2", param, startIndex, row);

		output.setJNTCIAttendance04selectInfo(JNTCIAttendance04selectInfo2);
		output.setKj_cdList(kj_nameList);
		output.setDept_List(dept_List);
		output.setApplication_List(application_List);
		output.setStatus_List(status_List);
		output.setTotalCount(totalCount2);
		output.setStartIndex(param.getStartIndex());
		output.setAdmitAllId(param.getAdmitAllId());
		if (param.getName_serch() != null && !"".equals(param.getName_serch())) {
			output.setName_serch(param.getName_serch());
		}
		if (param.getDept_id_serch() != null && !"".equals(param.getDept_id_serch())) {
			output.setDept_id_serch(param.getDept_id_serch());
		}
		if (param.getLeave_type_serch() != null
				&& !"".equals(param.getLeave_type_serch())) {
			output.setLeave_type_serch(param.getLeave_type_serch());
		}

		if (param.getApplication_type_serch() != null
				&& !"".equals(param.getApplication_type_serch())) {
			output.setApplication_type_serch(param.getApplication_type_serch());
		}
		if (param.getExamine_status_serch() != null
				&& !"".equals(param.getExamine_status_serch())) {
			output.setExamine_status_serch(param.getExamine_status_serch());
		}
		if (param.getLeave_endtime_serch() != null
				&& !"".equals(param.getLeave_endtime_serch())) {
			output.setLeave_endtime_serch(param.getLeave_endtime_serch());
		}
		if (param.getLeave_starttime_serch() != null
				&& !"".equals(param.getLeave_starttime_serch())) {
			output.setLeave_starttime_serch(param.getLeave_starttime_serch());
		}
		if (JNTCIAttendance04selectInfo2.isEmpty()) {
			BLogicMessages messages = new BLogicMessages();
			messages.add("message", new BLogicMessage("message.null"));
			result.setMessages(messages);
		}
		// 桁数チェック
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
		result.setResultObject(output);
		result.setResultString("success");
		return result;

		}else{//上司
			// leader所能看见的件数
			String totalCount = queryDAO.executeForObject(
					"JNTCIAttendance04selectCount", param, String.class);
			// leader一覧データ取得
			List<JNTCIAttendance04selectInfo> JNTCIAttendance04selectInfo = queryDAO
					.executeForObjectList("JNTCIAttendance04select", param,
							startIndex, row);
			output.setJNTCIAttendance04selectInfo(JNTCIAttendance04selectInfo);
			output.setKj_cdList(kj_nameList);
			output.setDept_List(dept_List);
			output.setApplication_List(application_List);
			output.setStatus_List(status_List);
			output.setTotalCount(totalCount);
			output.setStartIndex(param.getStartIndex());
			output.setAdmitAllId(param.getAdmitAllId());
			if (param.getName_serch() != null && !"".equals(param.getName_serch())) {
				output.setName_serch(param.getName_serch());
			}
			if (param.getDept_id_serch() != null && !"".equals(param.getDept_id_serch())) {
				output.setDept_id_serch(param.getDept_id_serch());
			}
			if (param.getLeave_type_serch() != null
					&& !"".equals(param.getLeave_type_serch())) {
				output.setLeave_type_serch(param.getLeave_type_serch());
			}
			if (param.getApplication_type_serch() != null
					&& !"".equals(param.getApplication_type_serch())) {
				output.setApplication_type_serch(param.getApplication_type_serch());
			}

			if (param.getExamine_status_serch() != null
					&& !"".equals(param.getExamine_status_serch())) {
				output.setExamine_status_serch(param.getExamine_status_serch());
			}
			if (param.getLeave_endtime_serch() != null
					&& !"".equals(param.getLeave_endtime_serch())) {
				output.setLeave_endtime_serch(param.getLeave_endtime_serch());
			}
			if (param.getLeave_starttime_serch() != null
					&& !"".equals(param.getLeave_starttime_serch())) {
				output.setLeave_starttime_serch(param.getLeave_starttime_serch());
			}

			if (JNTCIAttendance04selectInfo.isEmpty()) {
				BLogicMessages messages = new BLogicMessages();
				messages.add("message", new BLogicMessage("message.null"));
				result.setMessages(messages);
			}
			// 桁数チェック
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

			result.setResultObject(output);
			result.setResultString("success");
			return result;
		}
	}
}