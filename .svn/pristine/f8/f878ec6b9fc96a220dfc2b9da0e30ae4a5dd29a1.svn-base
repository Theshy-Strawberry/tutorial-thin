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


import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import jp.terasoluna.fw.dao.QueryDAO;
import jp.terasoluna.fw.service.thin.BLogic;
import jp.terasoluna.fw.service.thin.BLogicMessage;
import jp.terasoluna.fw.service.thin.BLogicMessages;
import jp.terasoluna.fw.service.thin.BLogicResult;
import jp.terasoluna.thin.tutorial.web.transcosmos.dto.JNTCIVocationInput;
import jp.terasoluna.thin.tutorial.web.transcosmos.dto.JNTCIVocationOutput;
import jp.terasoluna.thin.tutorial.web.transcosmos.vo.JNTCIVocationDeptOutvo;
import jp.terasoluna.thin.tutorial.web.transcosmos.vo.JNTCIVocationOutvo;

/**
 * 荳�ｦｧ繝��繧ｿ繧貞叙蠕励☆繧九ン繧ｸ繝阪せ繝ｭ繧ｸ繝�け縲�
 *
 */
public class JNTCIVocationSelectBLogic implements BLogic<JNTCIVocationInput> {

    /**
     * QueryDAO縲�
     * Spring縺ｫ繧医ｊ繧､繝ｳ繧ｹ繧ｿ繝ｳ繧ｹ逕滓�縺輔ｌ險ｭ螳壹＆繧後ｋ縲�
     */
    private QueryDAO queryDAO = null;

    /**
     * 荳�ｦｧ繝��繧ｿ蜿門ｾ怜�逅�ｒ陦後≧
     */
    public BLogicResult execute(JNTCIVocationInput param) {

        String strIndex = param.getStartIndex();
        String strRow = param.getRow();
        if (param.getDeptId1()!= null) {
			try {
				param.setDeptId1(new String(param.getDeptId1().getBytes("ISO-8859-1"), "utf-8"));
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}

        if (param.getUserSelectId() != null
				) {
			try {
				param.setUserSelectId(new String(param
						.getUserSelectId().getBytes("ISO-8859-1"), "utf-8"));
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
		if (param.getUsernameSelect() != null
			) {
			try {
				String examine_status = new String(param.getUsernameSelect()
						.getBytes("ISO-8859-1"), "utf-8");
				param.setUsernameSelect(examine_status);
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}


        int startIndex = 0;
        int row = 10;
        if (strIndex != null) {
            startIndex = Integer.parseInt(strIndex);

        }

        if (strRow != null) {
            row = Integer.parseInt(strRow);
        }

        //莉ｶ謨ｰ繧貞叙蠕励☆繧�
        String totalCount
            = queryDAO.executeForObject("getUserCountSelect", param, String.class);

        //荳�ｦｧ繝��繧ｿ繧貞叙蠕励☆繧�
        List<JNTCIVocationOutvo> users = queryDAO.executeForObjectList("getUserCount", param, startIndex, row);
        List<JNTCIVocationDeptOutvo> deptList = new ArrayList<JNTCIVocationDeptOutvo>();
        JNTCIVocationDeptOutvo  arg0 = new JNTCIVocationDeptOutvo();

        //arg0.setValue("豁｣蠑�);
        arg0.setLabel("1");
        JNTCIVocationDeptOutvo  arg1 = new JNTCIVocationDeptOutvo();
        arg1.setValue("隸慕畑");
        arg1.setLabel("2");
        deptList.add(arg0);
        deptList.add(arg1);
        JNTCIVocationOutput output = new JNTCIVocationOutput();
        output.setUsers(users);
        output.setDeptList(deptList);
        output.setTotalCount(totalCount);
        output.setDeptId1(param.getDeptId1());
        output.setUserSelectId(param.getUserSelectId());
        output.setUsernameSelect(param.getUsernameSelect());
        BLogicResult result = new BLogicResult();
        result.setResultObject(output);
        result.setResultString("success");

        return result;
    }

    /**
     * QueryDAO繧定ｨｭ螳壹☆繧九�
     * @param queryDAO
     */
    public void setQueryDAO(QueryDAO queryDAO) {
        this.queryDAO = queryDAO;
    }
}
