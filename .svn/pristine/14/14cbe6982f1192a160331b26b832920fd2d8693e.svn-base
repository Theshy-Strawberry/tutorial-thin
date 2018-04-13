package jp.terasoluna.thin.tutorial.web.transcosmos.blogic;

import java.io.UnsupportedEncodingException;
import java.util.List;

import jp.terasoluna.fw.dao.QueryDAO;
import jp.terasoluna.fw.service.thin.BLogic;
import jp.terasoluna.fw.service.thin.BLogicMessage;
import jp.terasoluna.fw.service.thin.BLogicMessages;
import jp.terasoluna.fw.service.thin.BLogicResult;
import jp.terasoluna.thin.tutorial.web.transcosmos.dto.JNTCIBusinessVerify01Input;
import jp.terasoluna.thin.tutorial.web.transcosmos.dto.JNTCIBusinessVerify01Output;
import jp.terasoluna.thin.tutorial.web.transcosmos.vo.JNTCIBusinessVerifyVo;


public  class JNTCIBusinessVerify01BLogic implements BLogic<JNTCIBusinessVerify01Input>{

	/**
     * QueryDAO�B
     * Spring�ɂ��C���X�^���X��������ݒ肳���B
     */
    private QueryDAO queryDAO = null;


    public QueryDAO getQueryDAO() {
		return queryDAO;
	}

	/**
     * QueryDAO��ݒ肷��B
     * @param queryDAO
     */
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

		if("4".equals(param.getFlag())){
        String totalCount = queryDAO.executeForObject("JNTCIBusinessVerifyVoInfoCount", param, String.class);
        int totalCounts = Integer.parseInt(totalCount);
        if(startIndex >= totalCounts){
        	startIndex = startIndex-row;
        if(startIndex < 0){
        	startIndex = 0;
        }
        }
        List<JNTCIBusinessVerifyVo> JNTCIBusinessVerifyVoInfo = queryDAO.executeForObjectList("JNTCIBusinessVerifyVoInfo", param, startIndex, row);

        JNTCIBusinessVerify01Output output = new JNTCIBusinessVerify01Output();
        output.setJNTCIBusinessVerifyVoInfo(JNTCIBusinessVerifyVoInfo);
        output.setTotalCount(totalCount);

        output.setEvectionId(param.getEvectionId());
        output.setDept_Id(param.getDept_Id());
        output.setUser_Id(param.getUser_Id());
        output.setUser_Name(param.getUser_Name());
        output.setStartIndex(param.getStartIndex());
        output.setExamine_Status(param.getExamine_Status());
        BLogicResult result = new BLogicResult();
  		  if(JNTCIBusinessVerifyVoInfo.isEmpty()){
  	        	 BLogicMessages messages = new BLogicMessages();
  	 	        messages.add("message",
  	 	                new BLogicMessage("message.null"));
  	 	        result.setMessages(messages);
  	        }
          result.setResultObject(output);
          result.setResultString("success");
          return result;
        }
		if("1".equals(param.getFlag())){
			if("1002".equals(param.getUserId())){
		String totalCount = queryDAO.executeForObject("JNTCIBusinessVerifyVoInfoCountGGL", param, String.class);
		int totalCounts = Integer.parseInt(totalCount);
		 if(startIndex >= totalCounts){
	        	startIndex = startIndex-row;
	        if(startIndex < 0){
	        	startIndex = 0;
	        }
	        }
               List<JNTCIBusinessVerifyVo> JNTCIBusinessVerifyVoInfo = queryDAO.executeForObjectList("JNTCIBusinessVerifyVoInfoGGL", param, startIndex, row);

               JNTCIBusinessVerify01Output output = new JNTCIBusinessVerify01Output();
               output.setJNTCIBusinessVerifyVoInfo(JNTCIBusinessVerifyVoInfo);
               output.setTotalCount(totalCount);

               output.setEvectionId(param.getEvectionId());
               output.setDept_Id(param.getDept_Id());
               output.setUser_Id(param.getUser_Id());
               output.setUser_Name(param.getUser_Name());
               output.setStartIndex(param.getStartIndex());
               output.setExamine_Status(param.getExamine_Status());

               BLogicResult result = new BLogicResult();
         		  if(JNTCIBusinessVerifyVoInfo.isEmpty()){
         	        	 BLogicMessages messages = new BLogicMessages();
         	 	        messages.add("message",
         	 	                new BLogicMessage("message.null"));
         	 	        result.setMessages(messages);
         	        }
                 result.setResultObject(output);
                 result.setResultString("success");
                 return result;
			}else if("1003".equals(param.getUserId())){


			   	String totalCount = queryDAO.executeForObject("JNTCIBusinessVerifyVoInfoCountGL", param, String.class);
				int totalCounts = Integer.parseInt(totalCount);
				 if(startIndex >= totalCounts){
			        	startIndex = startIndex-row;
			        if(startIndex < 0){
			        	startIndex = 0;
			        }
			        }

		               List<JNTCIBusinessVerifyVo> JNTCIBusinessVerifyVoInfo = queryDAO.executeForObjectList("JNTCIBusinessVerifyVoInfoGL", param, startIndex, row);
		               BLogicResult result = new BLogicResult();
		               if(JNTCIBusinessVerifyVoInfo.isEmpty()){
		            	   	 BLogicMessages messages = new BLogicMessages();
		            	        messages.add("message",
		            	                new BLogicMessage("message.null"));
		            	        result.setMessages(messages);

		            	   }
		            	JNTCIBusinessVerify01Output output = new JNTCIBusinessVerify01Output();
		            	 output.setJNTCIBusinessVerifyVoInfo(JNTCIBusinessVerifyVoInfo);
		            	 output.setTotalCount(totalCount);
		            	 output.setEvectionId(param.getEvectionId());
		            	 output.setDept_Id(param.getDept_Id());
		            	 output.setUser_Id(param.getUser_Id());
		            	 output.setUser_Name(param.getUser_Name());
		            	 output.setStartIndex(param.getStartIndex());
		            	 output.setExamine_Status(param.getExamine_Status());
		            	result.setResultObject(output);
		            	result.setResultString("success");
		            	return result;
			}else if("1004".equals(param.getUserId())){

				String totalCount = queryDAO.executeForObject("JNTCIBusinessVerifyVoInfoCountGGGL", param, String.class);
				int totalCounts = Integer.parseInt(totalCount);
				 if(startIndex >= totalCounts){
			        	startIndex = startIndex-row;
			        if(startIndex < 0){
			        	startIndex = 0;
			        }
			        }

		               List<JNTCIBusinessVerifyVo> JNTCIBusinessVerifyVoInfo = queryDAO.executeForObjectList("JNTCIBusinessVerifyVoInfoGLL", param, startIndex, row);
		               BLogicResult result = new BLogicResult();
		               if(JNTCIBusinessVerifyVoInfo.isEmpty()){
		            	   	 BLogicMessages messages = new BLogicMessages();
		            	        messages.add("message",
		            	                new BLogicMessage("message.null"));
		            	        result.setMessages(messages);

		            	   }
		            	JNTCIBusinessVerify01Output output = new JNTCIBusinessVerify01Output();
		            	 output.setJNTCIBusinessVerifyVoInfo(JNTCIBusinessVerifyVoInfo);
		            	 output.setTotalCount(totalCount);
		            	 output.setEvectionId(param.getEvectionId());
		            	 output.setDept_Id(param.getDept_Id());
		            	 output.setUser_Id(param.getUser_Id());
		            	 output.setUser_Name(param.getUser_Name());
		            	 output.setStartIndex(param.getStartIndex());
		            	 output.setExamine_Status(param.getExamine_Status());
		            	result.setResultObject(output);
		            	result.setResultString("success");
		            	return result;

			}else{}

		}	else if("0".equals(param.getFlag())){
			String totalCount = queryDAO.executeForObject("JNTCIBusinessVerifyVoInfoCountGL", param, String.class);
			int totalCounts = Integer.parseInt(totalCount);
			if(startIndex >= totalCounts){
	        	startIndex = startIndex-row;
	        if(startIndex < 0){
	        	startIndex = 0;
	        }
	        }
            List<JNTCIBusinessVerifyVo> JNTCIBusinessVerifyVoInfo = queryDAO.executeForObjectList("JNTCIBusinessVerifyVoInfoGL", param, startIndex, row);
            JNTCIBusinessVerify01Output output = new JNTCIBusinessVerify01Output();
            output.setJNTCIBusinessVerifyVoInfo(JNTCIBusinessVerifyVoInfo);
            output.setTotalCount(totalCount);

            output.setEvectionId(param.getEvectionId());
            output.setDept_Id(param.getDept_Id());
            output.setUser_Id(param.getUser_Id());
            output.setUser_Name(param.getUser_Name());
            output.setStartIndex(param.getStartIndex());
            output.setExamine_Status(param.getExamine_Status());
            BLogicResult result = new BLogicResult();
      		  if(JNTCIBusinessVerifyVoInfo.isEmpty()){
      	        	 BLogicMessages messages = new BLogicMessages();
      	 	        messages.add("message",
      	 	                new BLogicMessage("message.null"));
      	 	        result.setMessages(messages);
      	        }
              result.setResultObject(output);
              result.setResultString("success");
              return result;
		}else if("1072".equals(param.getUserId())){
			   String totalCount = queryDAO.executeForObject("JNTCIBusinessVerifyVoInfoCountLL", param, String.class);
			   int totalCounts = Integer.parseInt(totalCount);
			   if(startIndex >= totalCounts){
		        	startIndex = startIndex-row;
		        if(startIndex < 0){
		        	startIndex = 0;
		        }
		        }
               List<JNTCIBusinessVerifyVo> JNTCIBusinessVerifyVoInfo = queryDAO.executeForObjectList("JNTCIBusinessVerifyVoInfoLL", param, startIndex, row);
               JNTCIBusinessVerify01Output output = new JNTCIBusinessVerify01Output();
               output.setJNTCIBusinessVerifyVoInfo(JNTCIBusinessVerifyVoInfo);
               output.setTotalCount(totalCount);
               output.setEvectionId(param.getEvectionId());
               output.setDept_Id(param.getDept_Id());
               output.setUser_Id(param.getUser_Id());
               output.setUser_Name(param.getUser_Name());
               output.setStartIndex(param.getStartIndex());
               output.setExamine_Status(param.getExamine_Status());

               BLogicResult result = new BLogicResult();
         		  if(JNTCIBusinessVerifyVoInfo.isEmpty()){
         	        	 BLogicMessages messages = new BLogicMessages();
         	 	        messages.add("message",
         	 	                new BLogicMessage("message.null"));
         	 	        result.setMessages(messages);
         	        }
                 result.setResultObject(output);
                 result.setResultString("success");
                 return result;
                 }else{
    	 BLogicResult result = new BLogicResult();
         result.setResultString("success");
         return result;
        }
		BLogicResult result = new BLogicResult();
        result.setResultString("success");
        return result;
     }
}




