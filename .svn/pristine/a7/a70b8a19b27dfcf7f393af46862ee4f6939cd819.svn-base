package jp.terasoluna.thin.tutorial.web.transcosmos.blogic;

import java.util.List;

import jp.terasoluna.fw.dao.QueryDAO;
import jp.terasoluna.fw.dao.UpdateDAO;
import jp.terasoluna.fw.service.thin.BLogic;
import jp.terasoluna.fw.service.thin.BLogicResult;
import jp.terasoluna.thin.tutorial.web.transcosmos.dto.JNTCIAttendance03Dto;
import jp.terasoluna.thin.tutorial.web.transcosmos.dto.JNTCIBusinessApplicationInput;
import jp.terasoluna.thin.tutorial.web.transcosmos.dto.JNTCIBusinessDept;
import jp.terasoluna.thin.tutorial.web.transcosmos.dto.JNTCISelectApplicationOutput;


public class JNTCIModifyApplicationBLogic implements BLogic<JNTCIBusinessApplicationInput> {

	/**
     * QueryDAO。
     * Springによりインスタンス生成され設定される。
     */
	 private UpdateDAO updateDAO = null;
	    private QueryDAO queryDAO = null;

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

	/**
     * 一覧データ取得処理を行う
     */
	public BLogicResult execute(JNTCIBusinessApplicationInput param) {
		BLogicResult result = new BLogicResult();
		param.setEvectionId(param.getEvectionId12());
		if ("delete".equals(param.getFlag())) {
			updateDAO.execute("deleteApplication", param);
            result.setResultString("delete");
        } else {
	        //一覧データを取得する
	       JNTCISelectApplicationOutput users = queryDAO.executeForObject("modifyUsers", param, JNTCISelectApplicationOutput.class);

	       List<JNTCIBusinessDept> deptTypeList = queryDAO.executeForObjectList("deptType",null);
	       users.setDeptTypeList(deptTypeList);
           users.setStartIndex(param.getStartIndex());
	       //多选框的返回处理

	       String[] articleNAME = null;

	       String arcticStr = users.getArticle_NAME();
	       if(arcticStr != null){
	       		if(arcticStr.indexOf(";")>0){
	       			articleNAME = arcticStr.split(";");
	       		}else{
	       			articleNAME = arcticStr.split("");
	       		}

	       }

	              users.setArticleNAME(articleNAME);

	       List<JNTCIAttendance03Dto> examinePersonList = queryDAO.executeForObjectList("examinePerson", null);
	        //ビジネスロジックの出力クラスに結果を設定する
	        users.setExaminePersonList(examinePersonList);
	        result.setResultObject(users);
	        result.setResultString("success");

        }
	        return result;
	}


}
