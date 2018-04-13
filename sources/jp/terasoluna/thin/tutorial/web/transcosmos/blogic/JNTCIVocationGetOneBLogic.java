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

import jp.terasoluna.fw.dao.QueryDAO;
import jp.terasoluna.fw.dao.UpdateDAO;
import jp.terasoluna.fw.service.thin.BLogic;
import jp.terasoluna.fw.service.thin.BLogicMessage;
import jp.terasoluna.fw.service.thin.BLogicMessages;
import jp.terasoluna.fw.service.thin.BLogicResult;
import jp.terasoluna.thin.tutorial.web.transcosmos.dto.JNTCIVocationInput;
import jp.terasoluna.thin.tutorial.web.transcosmos.dto.JNTCIVocationOutput;
import jp.terasoluna.thin.tutorial.web.transcosmos.vo.JNTCIVocationOutvo;

/**
 * �ꗗ�f�[�^���擾����r�W�l�X���W�b�N�B
 *
 */
public class JNTCIVocationGetOneBLogic implements BLogic<JNTCIVocationInput> {

    /**
     * QueryDAO�B Spring�ɂ��C���X�^���X��������ݒ肳���B
     */
    private UpdateDAO updateDAO = null;

    public void setUpdateDAO(UpdateDAO updateDAO) {
        this.updateDAO = updateDAO;
    }

    private QueryDAO queryDAO = null;

    public void setQueryDAO(QueryDAO queryDAO) {
        this.queryDAO = queryDAO;
    }

    /**
     * �ꗗ�f�[�^�擾�������s��
     */
    public BLogicResult execute(JNTCIVocationInput param) {
        BLogicResult result = new BLogicResult();
        if ("0".equals(param.getFlag()) || "2".equals(param.getFlag())) {
            if ("update".equals(param.getUpdeflag())) {
                JNTCIVocationOutvo oneUser = queryDAO.executeForObject(
                        "getuser", param, JNTCIVocationOutvo.class);
                // �r�W�l�X���W�b�N�̏o�̓N���X�Ɍ��ʂ�ݒ肷��
                JNTCIVocationOutput output = new JNTCIVocationOutput();
                if(oneUser.getNianjia()!=null){}else{
                	oneUser.setNianjia(0.0);
                }
                output.setTotalnianjia(oneUser.getNianjia());
                output.setStartIndex(param.getStartIndex());
                output.setDeptId1(param.getDeptId1());
                output.setUserSelectId(param.getUserSelectId());
                output.setUsernameSelect(param.getUsernameSelect());
                output.setUserId(oneUser.getUserId());
                output.setUserName(oneUser.getUserName());
                output.setDeptId(oneUser.getDeptId());
                output.setEntryDate(oneUser.getEntryDate());
                output.setUserSex(oneUser.getUserSex());
                output.setTotalDays(oneUser.getTotalDays());
                output.setUserType(oneUser.getUserType());
                output.setRemainDays(oneUser.getRemainDays());
                output.setExDays(oneUser.getExDays());
                output.setJanuary(oneUser.getJanuary());
                output.setFebruary(oneUser.getFebruary());
                output.setMarch(oneUser.getMarch());
                output.setApril(oneUser.getApril());
                output.setMay(oneUser.getMay());
                output.setJune(oneUser.getJune());
                output.setJuly(oneUser.getJuly());
                output.setAugust(oneUser.getAugust());
                output.setSeptember(oneUser.getSeptember());
                output.setOctorber(oneUser.getOctorber());
                output.setNovember(oneUser.getNovember());
                output.setDecember(oneUser.getDecember());
                result.setResultObject(output);
                result.setResultString("success");
            } else if ("delete".equals(param.getUpdeflag())) {
                updateDAO.execute("deletevocation", param);
                BLogicMessages messages = new BLogicMessages();
                messages.add("message",new BLogicMessage("deletesuccess"));
                result.setMessages(messages);
                result.setResultString("delete");
            }
        }else{
        	BLogicMessages messages = new BLogicMessages();
        	messages.add("message",new BLogicMessage("errors.upde"));
        	result.setErrors(messages);
        	result.setResultString("fail");
        }
        return result;

    }

    /**
     * QueryDAO��ݒ肷��B
     *
     * @param queryDAO
     */
}