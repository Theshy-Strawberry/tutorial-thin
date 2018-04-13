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

import jp.terasoluna.fw.dao.UpdateDAO;
import jp.terasoluna.fw.service.thin.BLogic;
import jp.terasoluna.fw.service.thin.BLogicMessage;
import jp.terasoluna.fw.service.thin.BLogicMessages;
import jp.terasoluna.fw.service.thin.BLogicResult;
import jp.terasoluna.thin.tutorial.web.transcosmos.dto.JNTCIVocationInput;

/**
 * 一覧データを取得するビジネスロジック。
 *
 */
public class JNTCIVocationUpdateBLogic implements BLogic<JNTCIVocationInput> {

	/**
	 * UpdateDAO。 Springによりインスタンス生成され設定される。
	 */
	private UpdateDAO updateDao = null;

	/**
	 * 一覧データ取得処理を行う
	 */
	public BLogicResult execute(JNTCIVocationInput param) {

		// ビジネスロジックの出力クラスに結果を設定する

		BLogicResult result = new BLogicResult();
		JNTCIVocationInput output=new JNTCIVocationInput();
		if(param.getUserId().equals("qa")){

			output.setDeptId1(param.getDeptId1());
			output.setStartIndex(param.getStartIndex());
			output.setUserSelectId(param.getUserSelectId());
			output.setUsernameSelect(param.getUsernameSelect());
			result.setResultObject(output);
			result.setResultString("success1");
		}else{

		updateDao.execute("vocationUpdate", param);
		BLogicMessages messages = new BLogicMessages();
		output.setDeptId1(param.getDeptId1());
		output.setStartIndex(param.getStartIndex());
		output.setUserSelectId(param.getUserSelectId());
		output.setUsernameSelect(param.getUsernameSelect());
		result.setResultObject(output);
		messages.add("message",
				new BLogicMessage("message.update", param.getUserId()));
		result.setMessages(messages);
		result.setResultString("success");

		}

		return result;
	}

	/**
	 * UpdateDAOを設定する。
	 *
	 * @param updateDAO
	 */
	public void setUpdateDAO(UpdateDAO updateDao) {
		this.updateDao = updateDao;
	}
}
