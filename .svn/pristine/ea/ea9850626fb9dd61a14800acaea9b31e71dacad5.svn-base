package jp.terasoluna.thin.tutorial.web.transcosmos.blogic;

import jp.terasoluna.fw.dao.QueryDAO;
import jp.terasoluna.fw.dao.UpdateDAO;
import jp.terasoluna.fw.service.thin.BLogic;
import jp.terasoluna.fw.service.thin.BLogicResult;
import jp.terasoluna.thin.tutorial.web.transcosmos.dto.JNTCIBusinessVerifyDetailedInput;
import jp.terasoluna.thin.tutorial.web.transcosmos.dto.JNTCIBusinessVerifyDetailedOutput;

public class JNTCIBusinessVerifyDetailedUpdateBLogic implements
		BLogic<JNTCIBusinessVerifyDetailedInput> {

	private UpdateDAO updateDAO = null;
	private QueryDAO queryDao = null;

	public QueryDAO getQueryDao() {
		return queryDao;
	}

	public void setQueryDao(QueryDAO queryDao) {
		this.queryDao = queryDao;
	}

	public UpdateDAO getUpdateDAO() {
		return updateDAO;
	}

	public void setUpdateDAO(UpdateDAO updateDAO) {
		this.updateDAO = updateDAO;

	}

	public BLogicResult execute(JNTCIBusinessVerifyDetailedInput param) {
		BLogicResult result = new BLogicResult();
		JNTCIBusinessVerifyDetailedOutput detailedOutput = new JNTCIBusinessVerifyDetailedOutput();
		if("back".equals(param.getBack())){
			detailedOutput.setStartIndex(param.getStartIndex());
			detailedOutput.setUser_Id(param.getUser_Id());
			detailedOutput.setUser_Name(param.getUser_Name());
			detailedOutput.setDept_Id(param.getDept_Id());
			detailedOutput.setExamine_Status(param.getExamine_Status());
			result.setResultObject(detailedOutput);
			result.setResultString("success1");
		}else{

		if (detailedOutput != null && !"".equals(detailedOutput)) {
			updateDAO.execute("verifyupdate", param);
			detailedOutput.setEvectionId(param.getEvectionId());
			detailedOutput.setStartIndex(param.getStartIndex());
			detailedOutput.setUser_Id(param.getUser_Id());
			detailedOutput.setUser_Name(param.getUser_Name());
			detailedOutput.setDept_Id(param.getDept_Id());
			detailedOutput.setExamine_Status(param.getExamine_Status());
			//多选框的返回处理
		       String[] articleName = null;
		       String arcticStr = param.getArticleName();
		       if(arcticStr != null){
		       		if(arcticStr.indexOf(";")>0){
		       			articleName = arcticStr.split(";");
		       		}else{
		       			articleName = arcticStr.split("");
		       		}
		       }
			detailedOutput.setArticle_NAME(articleName);
			result.setResultObject(detailedOutput);
			result.setResultString("success");
		}
		}
		return result;
	}

}
