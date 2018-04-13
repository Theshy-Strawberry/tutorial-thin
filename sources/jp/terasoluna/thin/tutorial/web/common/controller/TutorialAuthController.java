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

package jp.terasoluna.thin.tutorial.web.common.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import jp.terasoluna.fw.util.PropertyUtil;
import jp.terasoluna.fw.web.RequestUtil;
import jp.terasoluna.fw.web.thin.AuthenticationController;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * �F�؃`�F�b�N���s���B
 *
 */
public class TutorialAuthController implements AuthenticationController {

    /**
     * ���O�N���X
     */
    private static Log log =
        LogFactory.getLog(TutorialAuthController.class);

    /**
     *  �F�؃`�F�b�N���s��Ȃ��p�X��񃊃X�g���擾�L�[�B
     */
    private static final String AUTHENTICATED_NOCHECK_PATH_PREFIX
                                 = "access.control.authenticated.escape.";

    /**
     *  �F�؃`�F�b�N���s��Ȃ��p�X��񃊃X�g���擾�L�[�B
     */
    private List<String> noCheckList = null;

    /**
     * ���N�G�X�g�̃p�X���ɑ΂��āA�w�肳�ꂽHTTP�Z�b�V������
     * �F�؍ς݂ł��邩�ǂ����𔻒肷��B
     *
     * @param pathInfo �p�X���
     * @param req HTTP���N�G�X�g
     *
     * @return �F�؂ɐ�������� <code>true</code>
     */
    public boolean isAuthenticated(String pathInfo, ServletRequest req) {

        if (log.isDebugEnabled()) {
            log.debug("call isAuthenticated");
        }

        //�Z�b�V��������UVO���擾����B
        HttpSession session = ((HttpServletRequest) req).getSession();
        String userId =(String) session.getAttribute("userId");

        //UVO�A�܂���UVO�ɓo�^����Ă���ID��null�̏ꍇ��false��ԋp����B
        if (userId != null && userId != "") {
            return true;
        }
        return false;
    }

    /**
     * �p�X���`�F�b�N�Ώۂ��ۂ����肷��B
     *
     * @param req ����ΏۂƂȂ� <code>ServletRequest</code> �C���X�^���X
     *
     * @return �`�F�b�N�Ώۂ̏ꍇ��<code>true</code>
     */
    public boolean isCheckRequired(ServletRequest req) {

        if (log.isDebugEnabled()) {
            log.debug("call isCheckRequired()");
        }

        //�p�X�����擾����B
        String pathInfo = RequestUtil.getPathInfo(req);

        if (noCheckList == null) {
            noCheckList = new ArrayList<String>();
            for (int i = 1; ; i++) {
                String path = PropertyUtil.getProperty(
                        AUTHENTICATED_NOCHECK_PATH_PREFIX + i);
                if (path == null) {
                    break;
                }
                noCheckList.add(path);
            }
        }
        if(Pattern.matches("(.*[.]do)|/", pathInfo)){
        for (String path : noCheckList) {
            if (pathInfo.startsWith(path) || "/".equals(pathInfo)) {
                return false;
            }
        }
        return true;
        }else{
        	return false;
        }

    }

}
