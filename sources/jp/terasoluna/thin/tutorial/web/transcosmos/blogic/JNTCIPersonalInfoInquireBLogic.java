package jp.terasoluna.thin.tutorial.web.transcosmos.blogic;

import java.io.UnsupportedEncodingException;
import java.util.Calendar;
import java.util.List;

import jp.terasoluna.fw.dao.QueryDAO;
import jp.terasoluna.fw.service.thin.BLogic;
import jp.terasoluna.fw.service.thin.BLogicMessage;
import jp.terasoluna.fw.service.thin.BLogicMessages;
import jp.terasoluna.fw.service.thin.BLogicResult;
import jp.terasoluna.thin.tutorial.web.transcosmos.dto.JNTCIPersonalInfoInquireInfo;
import jp.terasoluna.thin.tutorial.web.transcosmos.dto.JNTCIPersonalInfoInquireInput;
import jp.terasoluna.thin.tutorial.web.transcosmos.dto.JNTCIPersonalInfoInquireOutput;

public class JNTCIPersonalInfoInquireBLogic implements BLogic<JNTCIPersonalInfoInquireInput>{

	private QueryDAO queryDAO = null;


	public void setQueryDAO(QueryDAO queryDAO) {
		this.queryDAO = queryDAO;
	}


	public BLogicResult execute(JNTCIPersonalInfoInquireInput personal) {
		if(personal.getRow()==0){
			personal.setRow(10);
		}
		if( personal.getUserName() != null && !"reset".equals(personal.getCod())){
			String userName = personal.getUserName();
			try {
				String testpara = new String(userName.getBytes(
						"ISO-8859-1"), "utf-8");
				personal.setUserName(testpara);
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}

		String id_card = personal.getId_card();
		if(null == id_card){  id_card = "";}
        String entryTime_Begin = personal.getEntryTime_Begin();
        if(null == entryTime_Begin){  entryTime_Begin = "";}
        String entryTime_End = personal.getEntryTime_End();
        if(null == entryTime_End){  entryTime_End = "";}
        String department = personal.getDepartment();
        if(null == department){  department = "";}
        String zhuangtai = personal.getZhuangtai();
        if(null == zhuangtai){  zhuangtai = "";}
		int startIndex = personal.getStartIndex();
		if(0 == startIndex){  startIndex = 0 ;}
		int row = personal.getRow();
		int totalCount = queryDAO.executeForObject("selectPersonInfoCount", personal,
				Integer.class);
		List<JNTCIPersonalInfoInquireInfo> JNTCIPersonalInfoInquireInfo = queryDAO.executeForObjectList("selectPersonInfo",
				personal, startIndex, row);

		for (int i = 0; i < JNTCIPersonalInfoInquireInfo.size(); i++) {
			String birthday = JNTCIPersonalInfoInquireInfo.get(i).getBirthday();
			if(birthday != null){

				if(birthday.indexOf("/")!=-1){
					birthday=birthday.replace('/','-');
				}
				String[] ymd;
				if(birthday.indexOf("/")!=-1){
					 ymd = birthday.split("/");
				}else {
					ymd = birthday.split("-");
				}
				int year = Integer.parseInt(ymd[0]);
				int month = Integer.parseInt(ymd[1]);
				int day = Integer.parseInt(ymd[2]);
				Calendar calendar = Calendar.getInstance();
				int yearNow = calendar.get(Calendar.YEAR);
				int monthNow = calendar.get(Calendar.MONTH) + 1;
				int dayNow = calendar.get(Calendar.DATE);

				int age = yearNow - year;
				if(monthNow < month){
					age = age - 1;
				}
				if(monthNow == month && dayNow < day){
					age = age - 1;
				}
				JNTCIPersonalInfoInquireInfo.get(i).setAge(age);
			}
		}

		JNTCIPersonalInfoInquireOutput output = new JNTCIPersonalInfoInquireOutput();
		output.setPersonalInfos(JNTCIPersonalInfoInquireInfo);
		output.setTotalCount(totalCount);
        output.setUserName(personal.getUserName());
        output.setEntryTime_Begin(entryTime_Begin);
        output.setEntryTime_End(entryTime_End);
        output.setDepartment(department);
        output.setZhuangtai(zhuangtai);
        output.setStartIndex(startIndex);
        output.setId_card(id_card);
        output.setDeleteId_card(personal.getDeleteId_card());
        BLogicResult result = new BLogicResult();
		result.setResultObject(output);
		result.setResultString("success");
		if(JNTCIPersonalInfoInquireInfo == null || JNTCIPersonalInfoInquireInfo.size() == 0){
			BLogicMessages messages = new BLogicMessages();
			messages.add("message", new BLogicMessage("message.null"));
			result.setMessages(messages);
		}

		return result;
	}
}
