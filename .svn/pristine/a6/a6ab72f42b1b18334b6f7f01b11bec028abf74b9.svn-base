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
import java.util.List;

import jp.terasoluna.fw.dao.QueryDAO;
import jp.terasoluna.fw.dao.UpdateDAO;
import jp.terasoluna.fw.service.thin.BLogic;
import jp.terasoluna.fw.service.thin.BLogicMessage;
import jp.terasoluna.fw.service.thin.BLogicMessages;
import jp.terasoluna.fw.service.thin.BLogicResult;
import jp.terasoluna.thin.tutorial.web.transcosmos.dto.JNTCIVocationInput;
import jp.terasoluna.thin.tutorial.web.transcosmos.dto.JNTCIVocationOutput;
import jp.terasoluna.thin.tutorial.web.transcosmos.vo.JNTCIVocationDeptOutvo;
import jp.terasoluna.thin.tutorial.web.transcosmos.vo.JNTCIVocationOutvo;

/**
 * 一覧データを取得するビジネスロジック。
 *
 */
public class JNTCIVocationBLogic implements BLogic<JNTCIVocationInput> {

	/**
	 * QueryDAO。 Springによりインスタンス生成され設定される。
	 */
	private QueryDAO queryDAO = null;
	private UpdateDAO updateDAO = null;

	public UpdateDAO getUpdateDAO() {
		return updateDAO;
	}

	public void setUpdateDAO(UpdateDAO updateDAO) {
		this.updateDAO = updateDAO;
	}

	/**
	 * 一覧データ取得処理を行う
	 */
	public BLogicResult execute(JNTCIVocationInput param) {
		if(param.getUsernameSelect()!=null && !"reset".equals(param.getCod())){
    		try {
    			param.setUsernameSelect(new String(param.getUsernameSelect().getBytes("ISO-8859-1"),"utf-8"));
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
    	}


      String mark =param.getMark();
/*
		//放在遍历里
		String userId="";
		String t1=queryDAO.executeForObject("getTime1", userId,String.class);
		String t2=queryDAO.executeForObject("getTime2", userId,String.class);
		String t3=queryDAO.executeForObject("getTime3", null,String.class);
		param.setT1(t1);
		param.setT2(t2);
		param.setT3(t3);
        int  m1=queryDAO.executeForObject("getUsershebaomanyinianTime", userId,Integer.class);
        int  m2=queryDAO.executeForObject("getUserrushemanshebaoTime", param,Integer.class);
        int  m3=queryDAO.executeForObject("getUserrushekuanianTime", param,Integer.class);
        int  m4=queryDAO.executeForObject("getUsershebaokuanianTime", userId,Integer.class);
        int  m5=queryDAO.executeForObject("getUsershebaoshichangTime", userId,Integer.class);
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
        	nianjia=0;
        }
        if(0<=m1&&m2>=0&&m3<365){
        	float c=(m3/365)*m;
        	nianjia=(int) Math.floor(c);
        }
        if(0<=m1&&m2>=0&&m3>=365){
        	nianjia=m;
        }
        if(0<=m1&&m2<0&&m4<365){
        	float c=(m4/365)*m;
        	nianjia=(double) Math.floor(c);
        }
        if(0<=m1&&m2<0&&m4>=365){
        	nianjia=m;
        }
       param.setRemainDays(nianjia);
//以上放在遍历
*/

		String strIndex = param.getStartIndex();
		String strRow = param.getRow();

		int startIndex = 0;
		int row = 10;
		if (strIndex != null) {
			startIndex = Integer.parseInt(strIndex);

		}

		if (strRow != null) {
			row = Integer.parseInt(strRow);
		}
		BLogicResult result = new BLogicResult();
		// 件数を取得する
		String totalCount = queryDAO.executeForObject("getUserCount", param,
				String.class);

		List<JNTCIVocationDeptOutvo> deptList = queryDAO.executeForObjectList(
				"DeptId", null);

		// 一覧データを取得する
		List<JNTCIVocationOutvo> users1 = queryDAO.executeForObjectList(
				"getuservocation2",null);


		String userId ="";
   if("1".equals(mark)){
		for ( int i=0;i<users1.size();i++ ) {
			    userId = users1.get(i).getUserId();
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
		        updateDAO.execute("updateShengyuNianjiaMonthone", param);
			    }else{
			        double nianjia = 0.0;
			        param.setNianjia(nianjia);
			        param.setUserId(userId);
			        updateDAO.execute("updateTotalNianjia", param);
			        updateDAO.execute("updateShengyuNianjia", param);
			        updateDAO.execute("updateShengyuNianjiaMonthone", param);
			    }
		}
		 BLogicMessages messages = new BLogicMessages();
	        messages.add("message",
	                new BLogicMessage("message.Updatesuccess"));
			result.setMessages(messages);
}
		List<JNTCIVocationOutvo> users = queryDAO.executeForObjectList(
				"getuservocation", param, startIndex, row);
		/*
		 * JNTCIVocationOutvo oneUser = queryDAO.executeForObject("getuser",
		 * param, JNTCIVocationOutvo.class);
		 */
		// ビジネスロジックの出力クラスに結果を設定する
		JNTCIVocationOutput output = new JNTCIVocationOutput();

		 if(users.isEmpty()){
        	 BLogicMessages messages = new BLogicMessages();
 	        messages.add("message",
 	                new BLogicMessage("message.null"));
			result.setMessages(messages);
        }
		if (param.getDeptId() != null) {
			output.setDeptId(param.getDeptId());
		}
		output.setUsers(users);
		output.setTotalCount(totalCount);
		output.setDeptList(deptList);
		output.setStartIndex(param.getStartIndex());
		output.setDeptId1(param.getDeptId1());
        output.setUsernameSelect(param.getUsernameSelect());
		output.setUserSelectId(param.getUserSelectId());
		/* output.setUserId(oneUser.getUserId()); */

		result.setResultObject(output);
		result.setResultString("success");

		return result;
	}

	/**
	 * QueryDAOを設定する。
	 *
	 * @param queryDAO
	 */
	public void setQueryDAO(QueryDAO queryDAO) {
		this.queryDAO = queryDAO;
	}
}
