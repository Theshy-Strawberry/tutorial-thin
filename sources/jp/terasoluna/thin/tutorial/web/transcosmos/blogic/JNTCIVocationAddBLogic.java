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

/**
 * 荳�ｦｧ繝��繧ｿ繧貞叙蠕励☆繧九ン繧ｸ繝阪せ繝ｭ繧ｸ繝�け縲�
 *
 */
public class JNTCIVocationAddBLogic implements BLogic<JNTCIVocationInput> {

    /**
     * QueryDAO縲�
     * Spring縺ｫ繧医ｊ繧､繝ｳ繧ｹ繧ｿ繝ｳ繧ｹ逕滓�縺輔ｌ險ｭ螳壹＆繧後ｋ縲�
     */
    private QueryDAO queryDAO = null;
    private UpdateDAO updateDAO =null;

    /**
     * 荳�ｦｧ繝��繧ｿ蜿門ｾ怜�逅�ｒ陦後≧
     */
    public BLogicResult execute(JNTCIVocationInput param) {
    	BLogicResult result = new BLogicResult();
    	if("back".equals(param.getMark())){
    		result.setResultString("success1");
    		return result;
    	}
    	if(param.getUserSex()!=null){
    	if("man".equals(param.getUserSex())){
    		param.setUserSex("男");
    	}else{
    		param.setUserSex("女");
    	}
    	}
    	int resultcount = queryDAO.executeForObject("selectRecforVocation", param,
    			Integer.class);
		// そのデータがなかったら
    	if (resultcount == 0) {
			updateDAO.execute("inserVocation", param);
			/*BLogicMessages messages = new BLogicMessages();
			messages.add("message", new BLogicMessage("errors.attendance05.copyinsert"));
			result.setErrors(messages);*/
			  String userId = param.getUserId();
			    String t0=queryDAO.executeForObject("getTime0", userId,String.class);//社保开始时间
				String t1=queryDAO.executeForObject("getTime1", userId,String.class);//入职时间
				String t2=queryDAO.executeForObject("getTime2", userId,String.class);//社保满一年
				String t3=queryDAO.executeForObject("getTime3", null,String.class);//系统年底
				String t4=queryDAO.executeForObject("getTime4", null,String.class);//系统当前时间
				String t5=queryDAO.executeForObject("getTime5", null,String.class);//系统年初

                param.setT0(t0);
				param.setT1(t1);
				param.setT2(t2);
				param.setT3(t3);
				param.setT4(t4);
				param.setT5(t5);
			    if((t0!=null)&&(t1!=null)&&(t3!=null)){
		        int  m1=queryDAO.executeForObject("getUsershebaomanyinianTime", param,Integer.class);
		        int  m2=queryDAO.executeForObject("getUserrushemanshebaoTime", param,Integer.class);
		        float m3=queryDAO.executeForObject("getUserrushekuanianTime", param,Float.class);
		        float m4=queryDAO.executeForObject("getUsershebaokuanianTime", param,Float.class);
		        int  m5=queryDAO.executeForObject("getUsershebaoshichangTime", param,Integer.class);
		        int m6=(m5/365);
		       int m=0;
		        double nianjia = 0.0;
		        if(m6<10){
		        	m=5;
		        }
		        if(10<=m6&&m6<20){
		        	m=10;
		        }
		        if(20<=m6){
		        	m=15;
		        }
		//Math.floor() 向下取整
		        if(m1<0){
		        	nianjia=0.0;
		        }
		        if(0<=m1&&m2>=0&&m3<365){
		        	int c=(int) ((m3/365)*m);
		        	nianjia=c;


		        }
		        if(0<=m1&&m2>=0&&m3>=365){
		        	nianjia=m;

		        }
		        if(0<=m1&&m2<0&&m4<365){
		        	int c= (int) ((m4/365)*m);
		        	nianjia=c;


		        }
		        if(0<=m1&&m2<0&&m4>=365){
		        	nianjia=m;

		        }
		        nianjia=nianjia*8;
		        param.setNianjia(nianjia);
		        param.setUserId(userId);
		        updateDAO.execute("updateTotalNianjia", param);
		        updateDAO.execute("updateShengyuNianjia", param);
		        updateDAO.execute("updateShengyuNianjiaMonth", param);
			    }else{
			        double nianjia = 0.0;
			        param.setNianjia(nianjia);
			        param.setUserId(userId);
			        updateDAO.execute("updateTotalNianjia", param);
			        updateDAO.execute("updateShengyuNianjia", param);
			        updateDAO.execute("updateShengyuNianjiaMonth", param);
			    }



			result.setResultString("success");
		}else{
			BLogicMessages messages = new BLogicMessages();
			messages.add("message", new BLogicMessage("errors.attendance05.copyinsert"));
			result.setErrors(messages);
			result.setResultString("failure");
			return result;
		}
		return result;



    }

    /**
     * QueryDAO繧定ｨｭ螳壹☆繧九�
     * @param queryDAO
     */
    public void setQueryDAO(QueryDAO queryDAO) {
        this.queryDAO = queryDAO;
    }
    public void setUpdateDAO(UpdateDAO updateDAO){
    	this.updateDAO = updateDAO;

    }
}
