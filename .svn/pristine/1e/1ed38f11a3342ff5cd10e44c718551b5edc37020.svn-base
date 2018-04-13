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


import java.util.List;

import jp.terasoluna.fw.dao.QueryDAO;
import jp.terasoluna.fw.service.thin.BLogic;
import jp.terasoluna.fw.service.thin.BLogicResult;
import jp.terasoluna.thin.tutorial.web.transcosmos.dto.JNTCIAttendance06GetTypeListDto;
import jp.terasoluna.thin.tutorial.web.transcosmos.dto.JNTCIVocationInput;
import jp.terasoluna.thin.tutorial.web.transcosmos.dto.JNTCIVocationOutput;

/**
 * 荳�ｦｧ繝��繧ｿ繧貞叙蠕励☆繧九ン繧ｸ繝阪せ繝ｭ繧ｸ繝�け縲�
 *
 */
public class JNTCIVocationAddInitBLogic implements BLogic<JNTCIVocationInput> {

    /**
     * QueryDAO縲�
     * Spring縺ｫ繧医ｊ繧､繝ｳ繧ｹ繧ｿ繝ｳ繧ｹ逕滓�縺輔ｌ險ｭ螳壹＆繧後ｋ縲�
     */
    private QueryDAO queryDAO = null;

    /**
     * 荳�ｦｧ繝��繧ｿ蜿門ｾ怜�逅�ｒ陦後≧
     */
    public BLogicResult execute(JNTCIVocationInput param) {
    	List<JNTCIAttendance06GetTypeListDto> deptTypeIdList = queryDAO.executeForObjectList("DeptIdforVocation", 1);
    	List<JNTCIAttendance06GetTypeListDto> userTypeIdList = queryDAO.executeForObjectList("UserTypeforVocation", 1);
        JNTCIVocationOutput output = new JNTCIVocationOutput();
        output.setDeptTypeIdOutput(deptTypeIdList);
        output.setUserTypeIdOutput(userTypeIdList);
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
