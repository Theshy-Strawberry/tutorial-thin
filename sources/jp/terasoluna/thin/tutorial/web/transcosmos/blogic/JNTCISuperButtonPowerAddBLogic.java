package jp.terasoluna.thin.tutorial.web.transcosmos.blogic;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import jp.terasoluna.fw.dao.QueryDAO;
import jp.terasoluna.fw.dao.UpdateDAO;
import jp.terasoluna.fw.service.thin.BLogic;
import jp.terasoluna.fw.service.thin.BLogicMessage;
import jp.terasoluna.fw.service.thin.BLogicMessages;
import jp.terasoluna.fw.service.thin.BLogicResult;
import jp.terasoluna.thin.tutorial.web.transcosmos.dto.JNTCIAttendance03Dto;
import jp.terasoluna.thin.tutorial.web.transcosmos.dto.JNTCISuperButtonInput;
import jp.terasoluna.thin.tutorial.web.transcosmos.vo.ADDPROJECTDUTYNAME;

public class JNTCISuperButtonPowerAddBLogic implements BLogic<JNTCISuperButtonInput>{
	private QueryDAO queryDAO=null;

	public QueryDAO getQueryDAO() {
		return queryDAO;
	}
	public void setQueryDAO(QueryDAO queryDAO) {
		this.queryDAO = queryDAO;
	}
	private UpdateDAO updateDAO = null;
	public BLogicResult execute(JNTCISuperButtonInput param) {

		JNTCISuperButtonInput input = new JNTCISuperButtonInput();
		BLogicResult result = new BLogicResult();
		/*Integer [] am = new Integer[100];
		int max = 0;
		List<String> codelist = queryDAO.executeForObjectList("codevaluelist", null);
		 if(codelist.isEmpty()){
			 codelist.set(0, "0");
		}
		for(int co = 0; co < codelist.size(); co++){
			String vm = codelist.get(co);
			String vm1 = vm.substring(2);
			int in = Integer.parseInt(vm1);
			am [co] = in;
		}
		for(int cm = 0; cm < codelist.size(); cm++){
			if(am[cm] > max){
				max = am[cm];
			}
		}

		int max1 =max+1;
*/
 		String projectno = queryDAO.executeForObject("selectprojectmax",1,String.class);
		if(projectno==null){
			projectno="0";
		}
		int newsprojectno = Integer.parseInt(projectno);
		newsprojectno=newsprojectno+1;
		projectno="SL"+newsprojectno;
		param.setNewaa(projectno);
		String quanxianid = queryDAO.executeForObject("selectmax",null,String.class);
		if(quanxianid==null){
			 quanxianid="1";
		}
		/*String fuzeren = queryDAO.executeForObject("selectmax",null,String.class);
		if(fuzeren==null){
			fuzeren="1";
		}*/
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");//隶ｾ鄂ｮ譌･譛滓�蠑�
		Date date=null;
		try {
			date = df.parse(df.format(new Date()));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		param.setUpdatetime(date);
		param.setQuanxianid(quanxianid);
		param.setProjectno(projectno);

		BLogicMessages messages = new BLogicMessages();
		int powerCount = queryDAO.executeForObject("selectPower",param,Integer.class);
		int projectCount = queryDAO.executeForObject("selectProject",param,Integer.class);
		if("0".equals(param.getFlag())){
			if((!"".equals(param.getQuanxianname()))&&(!"".equals(param.getProjectname()))){
				if((powerCount>0) && (projectCount>0)){
					messages.add("message", new BLogicMessage("message.SuperButton.powerProjectn"));
					result.setErrors(messages);
					result.setResultString("success");
					}else if(powerCount>0){
						messages.add("message", new BLogicMessage("message.SuperButton.power"));
						result.setErrors(messages);
						result.setResultString("success");
					}else if(projectCount>0){
						messages.add("message", new BLogicMessage("message.SuperButton.projectn"));
						result.setErrors(messages);
						result.setResultString("success");
					}else{
						try{
						input.setCheckresult("success");
						updateDAO.execute("AddPower", param);
						updateDAO.execute("AddProject", param);
						updateDAO.execute("AddProjectdutyname", param);
						updateDAO.execute("AddProjectfuzeren", param);
						//updateDAO.execute("newmessage", param);
						}
						catch(Exception e){}
						//messages.add("message", new BLogicMessage("messageaddpower.success"));
						result.setErrors(messages);
						result.setResultObject(input);
						result.setResultString("success");
					}
			}else if(("".equals(param.getQuanxianname()))&&("".equals(param.getProjectname()))){
				messages.add("message", new BLogicMessage("message.addpower"));
				result.setErrors(messages);
				result.setResultString("success1");
			}else if(("".equals(param.getQuanxianname()))&&(!"".equals(param.getProjectname()))){
				if(projectCount>0){
					messages.add("message", new BLogicMessage("message.SuperButton.projectn"));
					result.setErrors(messages);
					result.setResultString("success");
				}else{
					try{
					input.setCheckresult("success");
					updateDAO.execute("AddProject", param);
					updateDAO.execute("AddProjectdutyname", param);
					updateDAO.execute("AddProjectfuzeren", param);
					//updateDAO.execute("newmessage", param);
					}
					catch(Exception e){}
					//messages.add("message", new BLogicMessage("messageaddpower.success"));
					result.setErrors(messages);
					result.setResultObject(input);
					result.setResultString("success");
				}
			}else if((!"".equals(param.getQuanxianname()))&&("".equals(param.getProjectname()))){
				if(powerCount>0){
					messages.add("message", new BLogicMessage("message.SuperButton.power"));
					result.setErrors(messages);
					result.setResultString("success");
				}else{
					updateDAO.execute("AddPower", param);
					messages.add("message", new BLogicMessage("messageaddpower.success"));
					result.setErrors(messages);
					result.setResultString("success");
				}
			}
		}else if("1".equals(param.getFlag()) || "4".equals(param.getFlag())){
			if(!"".equals(param.getProjectname())){
				if(projectCount>0){
					messages.add("message", new BLogicMessage("message.SuperButton.projectn"));
					result.setErrors(messages);
					result.setResultString("success");
				}else{
					try{
					input.setCheckresult("success");
					updateDAO.execute("AddProject", param);
					updateDAO.execute("AddProjectdutyname", param);
					updateDAO.execute("AddProjectfuzeren", param);
					//updateDAO.execute("newmessage", param);
					}
					catch(Exception e){}
					//messages.add("message", new BLogicMessage("messageaddpower.success"));
					result.setErrors(messages);
					result.setResultObject(input);
					result.setResultString("success");
				}
			}else if("".equals(param.getProjectname())){
				messages.add("message", new BLogicMessage("message.SuperButton.project"));
				result.setErrors(messages);
				result.setResultString("success");
			}

		}

		return result;
	}
	public UpdateDAO getUpdateDAO() {
		return updateDAO;
	}
	public void setUpdateDAO(UpdateDAO updateDAO) {
		this.updateDAO = updateDAO;
	}

}
