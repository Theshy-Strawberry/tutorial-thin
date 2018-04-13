package jp.terasoluna.thin.tutorial.web.transcosmos.blogic;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import jp.terasoluna.fw.dao.QueryDAO;
import jp.terasoluna.fw.dao.UpdateDAO;
import jp.terasoluna.fw.service.thin.BLogic;
import jp.terasoluna.fw.service.thin.BLogicMessage;
import jp.terasoluna.fw.service.thin.BLogicMessages;
import jp.terasoluna.fw.service.thin.BLogicResult;
import jp.terasoluna.thin.tutorial.web.common.controller.GetWorkDay;
import jp.terasoluna.thin.tutorial.web.transcosmos.dto.JNTCLOvertimeApplicationInput;

public class JNTCIApplicationUpdateExteaByidBLogic implements
        BLogic<JNTCLOvertimeApplicationInput> {

    private UpdateDAO updateDAO = null;
    private QueryDAO queryDAO = null;

    public QueryDAO getQueryDAO() {
        return queryDAO;
    }

    public void setQueryDAO(QueryDAO queryDAO) {
        this.queryDAO = queryDAO;
    }

    public BLogicResult execute(JNTCLOvertimeApplicationInput param) {
    	BLogicResult result = new BLogicResult();

    	JNTCLOvertimeApplicationInput output=new JNTCLOvertimeApplicationInput();
		String checkDate = queryDAO.executeForObject("equalsDate22", param, String.class);
		if(checkDate != null){
			BLogicMessages messages = new BLogicMessages();
			messages.add("message", new BLogicMessage(
					"errors.leaveTimeFrame.error"));
			result.setErrors(messages);
			result.setResultString("success1");
			return result;
		}

		param.getExtra_starttime();
		param.getExtra_endtime();
		String checkTime = queryDAO.executeForObject("equalsTime1", param, String.class);
		if(checkTime != null){
			BLogicMessages messages = new BLogicMessages();
			messages.add("message", new BLogicMessage(
					"errors.leaveEvection.error"));
			result.setErrors(messages);
			result.setResultString("success1");
			return result;
		}
		//只能在下个月三个工作日之前之前补
        Date Systime = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");//可以方便地修改日期格式
        String sfd = dateFormat.format( Systime );
        List<Date> holidaylist = queryDAO.executeForObjectList("holidaylist", null);
        String start=sfd.substring(0,8).concat("01");

        //申请年月
        int ShenseiM=Integer.parseInt(param.getExtra_starttime().substring(5, 7));
        int ShenseiY=Integer.parseInt(param.getExtra_starttime().substring(0, 4));
        //系统年月
        int SM=Integer.parseInt(sfd.substring(5, 7));
        int SY=Integer.parseInt(sfd.substring(0, 4));
        int dayCount = GetWorkDay.workDays(start,sfd,holidaylist);
        int ShenseiMNext;
        int ShenseiYNext;
        if(ShenseiM==12){
               ShenseiMNext=1;
               ShenseiYNext=ShenseiY+1;
        }
        else {
               ShenseiMNext=ShenseiM+1;
               ShenseiYNext=ShenseiY;
        }
        if((ShenseiM==SM&&ShenseiY==SY)||(dayCount<4&&ShenseiMNext==SM&&ShenseiYNext==SY)){

        String examineTrueName = queryDAO.executeForObject(
                "selectexamineTrueName", param, String.class);
        param.setExamineTrueName(examineTrueName);
        // TODO �����������ꂽ���\�b�h�E�X�^�u
        updateDAO.execute("updateExtraByID", param);
        output.setExtra_reason(param.getExtra_auditss());
        output.setStartIndex(param.getStartIndex());
		result.setResultObject(output);
        result.setResultString("success");
        return result;
    }else{
        BLogicMessages messages = new BLogicMessages();
        messages.add("message", new BLogicMessage(
                             "errors.attendance05.timeOut"));
        result.setErrors(messages);
        result.setResultString("success1");
        return result;
}
  }

    public UpdateDAO getUpdateDAO() {
        return updateDAO;
    }

    public void setUpdateDAO(UpdateDAO updateDAO) {
        this.updateDAO = updateDAO;
    }

}
