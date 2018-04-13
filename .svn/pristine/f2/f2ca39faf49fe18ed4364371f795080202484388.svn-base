package jp.terasoluna.thin.tutorial.web.transcosmos.blogic;

import java.io.UnsupportedEncodingException;
import java.util.List;

import jp.terasoluna.fw.dao.QueryDAO;
import jp.terasoluna.fw.service.thin.BLogic;
import jp.terasoluna.fw.service.thin.BLogicResult;
import jp.terasoluna.thin.tutorial.web.transcosmos.dto.JNTCIAttendance03Dto;
import jp.terasoluna.thin.tutorial.web.transcosmos.dto.JNTCIBusinessVerify01Input;
import jp.terasoluna.thin.tutorial.web.transcosmos.vo.JNTCIBusinessVerifyVo;



public  class JNTCIBusinessVerify02forwardBLogic implements BLogic<JNTCIBusinessVerify01Input>{


	private QueryDAO queryDAO = null;


	public QueryDAO getQueryDAO() {
		return queryDAO;
	}
	public void setQueryDAO(QueryDAO queryDAO) {
		this.queryDAO = queryDAO;
	}

	public BLogicResult execute(JNTCIBusinessVerify01Input param) {
		if(param.getUser_Name()!=null && !"reset".equals(param.getCod())){
    		try {
    			param.setUser_Name(new String(param.getUser_Name().getBytes("ISO-8859-1"),"utf-8"));
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
    	}
		BLogicResult result = new BLogicResult();

		JNTCIBusinessVerifyVo  jntciBusinessVerifyVo = new JNTCIBusinessVerifyVo();
		jntciBusinessVerifyVo = queryDAO.executeForObject("JNTCIBusinessVerify02", param, JNTCIBusinessVerifyVo.class);
		 String[] article_NAME = null;
		//審査者list
			List<JNTCIAttendance03Dto> examinePersonList = queryDAO.executeForObjectList("examinePersonGL", null);

	       String arcticStr = jntciBusinessVerifyVo.getArticleName();
	       if(arcticStr != null){
	       		if(arcticStr.indexOf(";")>0){
	       			article_NAME = arcticStr.split(";");
	       		}else{
	       			article_NAME = arcticStr.split("");
	       		}

	       }
	       jntciBusinessVerifyVo.setArticle_NAME(article_NAME);

	       jntciBusinessVerifyVo.setExaminePersonList(examinePersonList);

	    result.setResultObject(jntciBusinessVerifyVo);
		result.setResultString("success");
		return result;
	}

}

