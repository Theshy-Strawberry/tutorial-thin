package jp.terasoluna.thin.tutorial.web.transcosmos.form;

import jp.terasoluna.fw.web.struts.form.MultiFieldValidator;
/**
 * 休暇申請休暇時長のチェック
 * **/
public class LeaveTimeValidator implements MultiFieldValidator{

	public boolean validate(String leaveTotalTime,String[] arg1) {

		//必須入力チェック
		if(leaveTotalTime==null||"".equals(leaveTotalTime)){
			return true;
		}
		//0以上
		int TotalTime=Integer.parseInt(leaveTotalTime);
		if(TotalTime>0){
			return true;
		}
		return false;

	}

    }
