package jp.terasoluna.thin.tutorial.web.transcosmos.blogic;

import jp.terasoluna.fw.dao.QueryDAO;
import jp.terasoluna.fw.service.thin.BLogic;
import jp.terasoluna.fw.service.thin.BLogicResult;
import jp.terasoluna.thin.tutorial.web.transcosmos.dto.JNTCIBusinessVerifyDetailedInput;


import jp.terasoluna.thin.tutorial.web.transcosmos.vo.JNTCIBusinessVerifyVo2;


public  class JNTCIBusinessVerifyDetailedBLogic implements BLogic<JNTCIBusinessVerifyDetailedInput> {

    private QueryDAO queryDAO = null;

    public void setQueryDAO(QueryDAO queryDAO) {
        this.queryDAO = queryDAO;
    }

	public BLogicResult execute(JNTCIBusinessVerifyDetailedInput param) {
		JNTCIBusinessVerifyVo2 output = new JNTCIBusinessVerifyVo2();
		 BLogicResult result = new BLogicResult();
		if("back".equals(param.getBack())){
			output.setEvectionId(param.getEvectionId());
	        output.setDept_Id(param.getDept_Id());
	        output.setUser_Id(param.getUser_Id());
	        output.setUser_Name(param.getUser_Name());
	        output.setStartIndex(param.getStartIndex());
	        output.setExamine_Status(param.getExamine_Status());
			 result.setResultObject(output);
		     result.setResultString("success1");
		 }else{
        //個人基本情報
		output = queryDAO.executeForObject("selectBusinessVerifyDetailed", param,JNTCIBusinessVerifyVo2.class);

	     String[] article_NAME = null;

	       String arcticStr = output.getArticleName();
	       if(arcticStr != null){
	       		if(arcticStr.indexOf(";")>0){
	       			article_NAME = arcticStr.split(";");
	       		}else{
	       			article_NAME = arcticStr.split("");
	       		}

	       }
	       output.setArticle_NAME(article_NAME);

	        output.setEvectionId(param.getEvectionId());
	        output.setDept_Id(param.getDept_Id());
	        output.setUser_Id(param.getUser_Id());
	        output.setUser_Name(param.getUser_Name());
	        output.setStartIndex(param.getStartIndex());
	        output.setExamine_Status(param.getExamine_Status());

        result.setResultObject(output);
        result.setResultString("success");
		}
        return result;
	}

}
