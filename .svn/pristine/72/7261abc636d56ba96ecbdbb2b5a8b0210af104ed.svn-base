/*
 * Copyright (c) 2007 NTT DATA Corporation
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package jp.terasoluna.thin.tutorial.web.transcosmos.blogic;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import jp.terasoluna.fw.dao.QueryDAO;
import jp.terasoluna.fw.dao.UpdateDAO;
import jp.terasoluna.fw.service.thin.BLogic;
import jp.terasoluna.fw.service.thin.BLogicMessage;
import jp.terasoluna.fw.service.thin.BLogicMessages;
import jp.terasoluna.fw.service.thin.BLogicResult;
import jp.terasoluna.thin.tutorial.web.transcosmos.dto.JNTCIPersonalInfoLoginInput;
import jp.terasoluna.thin.tutorial.web.transcosmos.dto.JNTCIVocationInput;
import jp.terasoluna.thin.tutorial.web.transcosmos.dto.JNTCIVocationOutput;

public class JNTCIVocationResetBLogic implements BLogic<JNTCIVocationInput> {

	private UpdateDAO updateDAO = null;
	private QueryDAO queryDAO = null;

	public BLogicResult execute(JNTCIVocationInput param) {

		updateDAO.execute("deleteTtvocation", param);

		List<JNTCIPersonalInfoLoginInput> all = queryDAO.executeForObjectList(
				"reset", null);
		JNTCIVocationOutput vocationOutput = new JNTCIVocationOutput();
		JNTCIVocationInput vocationInput = new JNTCIVocationInput();

		for (int i = 0; i < all.size(); i++) {
			String id = all.get(i).getJn_card();
			String name = all.get(i).getUserName();
			String sex = all.get(i).getSex();
			if ("1".equals(sex)) {
				sex = "男";
			} else {
				sex = "女";
			}
			String departmentid = all.get(i).getDepartment();
			String education = all.get(i).getEducation();
			String entrytime = all.get(i).getEntry_Time();
			vocationInput.setUserId(id);
			vocationInput.setUserName(name);
			vocationInput.setUserSex(sex);
			vocationInput.setDeptId(departmentid);
			vocationInput.setUserType(education);
			vocationInput.setEntyrTime(entrytime);
			/*
			 * String beginday = queryDAO.executeForObject("sociaDay",
			 * id,java.lang.String.class);
			 *
			 * if(beginday==null){ continue; } //2014-02-14 00:00:00.0 int
			 * compare = dayAway(beginday); double remainDays=0.0;
			 * if(compare>=1&&compare<10){ remainDays=40.0; }else
			 * if(compare>=10&&compare<20){ remainDays=80.0; }else
			 * if(compare>=20){ remainDays=160.0; }
			 */
			vocationInput.setRemainDays(0.0);
			updateDAO.execute("updateVocationDate", vocationInput);
		}

		BLogicResult result = new BLogicResult();

		BLogicMessages messages = new BLogicMessages();
		messages.add("message",new BLogicMessage("message.vocation.success"));
		result.setMessages(messages);
		result.setResultString("success");
		return result;

	}

	private int dayAway(String beginday) {
		int result = 0;
		Date date = new Date();
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		// 系统年月日
		String systemtime = format.format(date);
		int sysyear = Integer.parseInt(systemtime.replace("-", "").substring(0,
				4));
		int sysmonthday = Integer.parseInt(systemtime.replace("-", "")
				.substring(4, 8));
		// 计算 开始年月日
		int year = Integer.parseInt(beginday.replace("-", "").substring(0, 4));
		int monthday = Integer.parseInt(beginday.replace("-", "").substring(4,
				8));
		result = sysyear - year - 1;
		if (sysmonthday >= monthday) {
			result++;
		}
		return result;
	}

	public void setUpdateDAO(UpdateDAO updateDAO) {
		this.updateDAO = updateDAO;

	}

	public void setQueryDAO(QueryDAO queryDAO) {
		this.queryDAO = queryDAO;
	}

}
