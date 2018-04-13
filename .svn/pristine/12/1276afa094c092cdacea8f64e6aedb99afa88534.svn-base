package jp.terasoluna.thin.tutorial.web.transcosmos.blogic;



import java.text.SimpleDateFormat;
import java.util.Date;

import jp.terasoluna.fw.dao.QueryDAO;
import jp.terasoluna.fw.dao.UpdateDAO;
import jp.terasoluna.fw.service.thin.BLogic;
import jp.terasoluna.fw.service.thin.BLogicResult;
import jp.terasoluna.fw.service.thin.BLogicMessage;
import jp.terasoluna.fw.service.thin.BLogicMessages;
import jp.terasoluna.thin.tutorial.web.common.controller.Constant;
import jp.terasoluna.thin.tutorial.web.transcosmos.dto.JNTCIEquipInsertInput;

public class JNTCIEquipEditorInsertBLogic implements BLogic<JNTCIEquipInsertInput> {

	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");// 设置日期格式
	String time = (df.format(new Date()));// new Date()为获取当前系统时间
	/**
	 * QueryDAO Springによりインスタンス生成され設定される。
	 */
	private QueryDAO queryDAO = null;

	/**
	 * UpdateDAO Springによりインスタンス生成され設定される。
	 */
	private UpdateDAO updateDAO = null;

	/**
	 * 登録を行う
	 */
	public QueryDAO getQueryDAO() {
		return queryDAO;
	}

	public void setQueryDAO(QueryDAO queryDAO) {
		this.queryDAO = queryDAO;
	}

	public UpdateDAO getUpdateDAO() {
		return updateDAO;
	}

	public void setUpdateDAO(UpdateDAO updateDAO) {
		this.updateDAO = updateDAO;
	}
	public BLogicResult execute(JNTCIEquipInsertInput param) {

		BLogicResult result = new BLogicResult();


      String  flags=param.getHidden_state();
     if("back".equals(param.getCod())){
    	  JNTCIEquipInsertInput output=new JNTCIEquipInsertInput();
    	  output.setStartIndex(param.getStartIndex());
    	  output.setSetsubiKubun(param.getSetsubiKubun());
    	  output.setDeptId(param.getDeptId());
    	  output.setUserId(param.getUserId());
    	  output.setCode(param.getCode());
    	  result.setResultObject(output);
    	  result.setResultString("success1");
    	  return result;
      }
      if(flags.equals("1")){

			try {
				updateDAO.execute("EquipEditor", param);
			} catch (Exception e) {
				BLogicMessages messages = new BLogicMessages();
				messages.add("message", new BLogicMessage("message.failure",
						"更新"));
				result.setErrors(messages);
				return result;
			}
		BLogicMessages messages = new BLogicMessages();
		messages.add("message", new BLogicMessage("message.update.repeat",param.getSetsubi_no()));
		result.setMessages(messages);
		result.setResultString("success");

		return result;
      }else if(flags.equals("2")){
    	  try {
    			String zhuangtai=queryDAO.executeForObject("selectzhuangtai",
    					param,String.class);
             if(zhuangtai.equals("1")){
    			//設備が初めて入庫する場合
    			//userId=-- 場合は
    			param.setUserId("--");
    			//deptId= -- 場合は
    			param.setDeptId("--");
    			// hokanbasho=4場合は入庫
    			param.setHokanbasho("4");
    			// hokanhoushiki=4場合は入庫
    			param.setHokanhoushiki("4");
    			// setsubi_state=0場合は入庫
    			param.setSetsubi_state("0");
    			// shunyuko=0場合は入庫
    			param.setShunyuko("0");
    		    param.setYouto("0");

				int CSSS = queryDAO.executeForObject("JNTCIEquip06select", param, Integer.class);
				if(!(CSSS == 0)){
				String mark=queryDAO.executeForObject("selectSHINSA_NO",
				param,String.class);
				param.setMark(mark);
				param.setXttime(time);
				updateDAO.execute("updateTT_SETSUBI_SHINSA", param);
				updateDAO.execute("updateTT_SETSUBI_SHINSEI",param);
				}
				else{}
				 updateDAO.execute("EquipEditorReturn", param);
        }else{
	   BLogicMessages messages = new BLogicMessages();
		messages.add("message", new BLogicMessage("message.equipfailure",
				"この設備"));
		result.setErrors(messages);
		result.setResultString("success");
	  return result;
}
			} catch (Exception e) {
				BLogicMessages messages = new BLogicMessages();
				messages.add("message", new BLogicMessage("message.failure",
						"強制帰庫"));
				result.setErrors(messages);
				result.setResultString("success");
				return result;
			}

    	  BLogicMessages messages = new BLogicMessages();
  		messages.add("message", new BLogicMessage("message.return.repeat",
  				param.getSetsubi_no()));
  		result.setMessages(messages);
  		result.setResultString("success");
    	  return result;
      }else{
    	  BLogicMessages messages = new BLogicMessages();
			messages.add("message", new BLogicMessage("message.failure",
					"更新"));
			result.setErrors(messages);
			result.setResultString("success");
    	  return result;
      }

	}

}