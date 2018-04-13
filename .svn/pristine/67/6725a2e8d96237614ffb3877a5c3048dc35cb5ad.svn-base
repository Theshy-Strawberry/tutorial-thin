package jp.terasoluna.thin.tutorial.web.transcosmos.blogic;

import java.util.List;

import jp.terasoluna.fw.dao.QueryDAO;
import jp.terasoluna.fw.service.thin.BLogic;
import jp.terasoluna.fw.service.thin.BLogicResult;
import jp.terasoluna.thin.tutorial.web.transcosmos.dto.JNTCIAttendance03Dto;
import jp.terasoluna.thin.tutorial.web.transcosmos.dto.JNTCIBusinessApplicationInput;
import jp.terasoluna.thin.tutorial.web.transcosmos.dto.JNTCIBusinessListInput;
import jp.terasoluna.thin.tutorial.web.transcosmos.dto.JNTCIListOutput;
import jp.terasoluna.thin.tutorial.web.transcosmos.dto.JNTCISelectApplicationOutput;

public class JNTCIViewApplicationBLogic implements
		BLogic<JNTCIBusinessListInput> {

	/**
	 * QueryDAO邵ｲ�ｽ
	 * Spring邵ｺ�ｫ郢ｧ蛹ｻ�顔ｹｧ�､郢晢ｽｳ郢ｧ�ｹ郢ｧ�ｿ郢晢ｽｳ郢ｧ�ｹ騾墓ｻ難ｿｽ邵ｺ霈費ｽ碁坎�ｭ陞ｳ螢ｹ��ｹｧ蠕鯉ｽ狗ｸｲ�ｽ
	 */
	private QueryDAO queryDAO = null;

	public QueryDAO getQueryDAO() {
		return queryDAO;
	}

	public void setQueryDAO(QueryDAO queryDAO) {
		this.queryDAO = queryDAO;
	}

	/**
	 * 闕ｳ�ｽ�ｦ�ｧ郢晢ｿｽ�ｽ郢ｧ�ｿ陷ｿ髢�ｽｾ諤懶ｿｽ騾�ｿｽ�帝勗蠕娯鴬
	 */
	public BLogicResult execute(JNTCIBusinessListInput param) {

		String userId = param.getUserId();
		//審査者list


		if (null == userId) {
			BLogicResult result = new BLogicResult();

			result.setResultString("failure");

			return result;
		} else {
			JNTCIListOutput output = new JNTCIListOutput();
			JNTCIBusinessApplicationInput businessUser = queryDAO
					.executeForObject("businessUser", userId,
							JNTCIBusinessApplicationInput.class);
			output.setUserId(userId);
			output.setUserName(businessUser.getUserName());
             output.setStartIndex(param.getStartIndex());
			if (null != businessUser.getProjectPm()) {
			output.setProjectPm(businessUser.getProjectPm());
			}
			JNTCIBusinessApplicationInput businessLogin = queryDAO
					.executeForObject("businessLogin", userId,
							JNTCIBusinessApplicationInput.class);

			if (null != businessLogin) {

				output.setDeptId(businessLogin.getDeptId());
				output.setProjectPm(businessLogin.getProjectPm());
				output.setDeptName(businessLogin.getDeptName());
				output.setProjectPm(businessLogin.getProjectPm());
				output.setPosition_ID(businessLogin.getPosition_ID());
				output.setProject(businessLogin.getProject());;
				output.setProject_ID(businessLogin.getProject_ID());
				output.setTj_USER_ID(businessLogin.getTj_USER_ID());
				output.setSex(businessLogin.getSex());
				 output.setStartIndex(param.getStartIndex());

			}

			String strIndex = param.getStartIndex();
			String strRow = param.getRow();

			int startIndex = 0;
			int row = 6;
			if (strIndex != null) {
				startIndex = Integer.parseInt(strIndex);

			}

			if (strRow != null) {
				row = Integer.parseInt(strRow);
			}

			// 闔会ｽｶ隰ｨ�ｰ郢ｧ雋槫徐陟募干笘�ｹｧ�ｽ
			String totalCount = queryDAO.executeForObject(
					"getApplicationCount", userId, String.class);

			// 闕ｳ�ｽ�ｦ�ｧ郢晢ｿｽ�ｽ郢ｧ�ｿ郢ｧ雋槫徐陟募干笘�ｹｧ�ｽ
			List<JNTCISelectApplicationOutput> users = queryDAO
					.executeForObjectList("getUsers", userId, startIndex, row);

			//审查者examinePerson
			List<JNTCIAttendance03Dto> examinePersonList = queryDAO.executeForObjectList("examinePerson", null);
			// 郢晁侭縺夂ｹ晞亂縺帷ｹ晢ｽｭ郢ｧ�ｸ郢晢ｿｽ縺醍ｸｺ�ｮ陷�ｽｺ陷牙ｸ吶￠郢晢ｽｩ郢ｧ�ｹ邵ｺ�ｫ驍ｨ蜈域｣｡郢ｧ螳夲ｽｨ�ｭ陞ｳ螢ｹ笘�ｹｧ�ｽ
			output.setUsers(users);
			output.setTotalCount(totalCount);
			output.setExaminePersonList(examinePersonList);
			 output.setStartIndex(param.getStartIndex());


			BLogicResult result = new BLogicResult();

			result.setResultObject(output);
			result.setResultString("success");

			return result;
		}
	}

}

