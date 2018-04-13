package jp.terasoluna.thin.tutorial.web.transcosmos.blogic;

import java.io.File;
import java.util.Date;
import java.util.List;

import jp.terasoluna.fw.dao.QueryDAO;
import jp.terasoluna.fw.service.thin.BLogic;
import jp.terasoluna.fw.service.thin.BLogicMessage;
import jp.terasoluna.fw.service.thin.BLogicMessages;
import jp.terasoluna.fw.service.thin.BLogicResult;
import jp.terasoluna.thin.tutorial.web.transcosmos.dto.JNTCIEquipHomePageOutput;
import jp.terasoluna.thin.tutorial.web.transcosmos.dto.JNTCLOvertimePostMessage04Input;
import jp.terasoluna.thin.tutorial.web.transcosmos.vo.JNTCIEquipHomePage04Vo;
import jp.terasoluna.thin.tutorial.web.transcosmos.vo.JNTCIEquipNoticeMgVo;

public class JNTCIEquipHomePage04BLogic implements
		BLogic<JNTCLOvertimePostMessage04Input> {
	private QueryDAO queryDAO = null;

	public QueryDAO getQueryDAO() {
		return queryDAO;
	}

	public void setQueryDAO(QueryDAO queryDAO) {
		this.queryDAO = queryDAO;
	}
	private String uploadPath = this.getClass().getClassLoader()
	.getResource("").getPath()
	+ "../../images/HomePageImg/";
	public BLogicResult execute(JNTCLOvertimePostMessage04Input param) {
		//传递修改的startIndex
		String strIndex = param.getStartIndex1();
		String strRow = param.getRow();
		int startIndex1 = 0;
		int row = 10;
		if (strIndex != null) {
			startIndex1 = Integer.parseInt(strIndex);
		}
		if (strRow != null) {
			row = Integer.parseInt(strRow);
		}
		String totalCount = queryDAO.executeForObject("QueryCommentCount",param,String.class);
		// 增加评论一览
		List<JNTCIEquipHomePage04Vo> comment = queryDAO.executeForObjectList("QueryComment04", param,startIndex1, row);

		BLogicResult result = new BLogicResult();
		int count = queryDAO.executeForObject("QueryInfo04Count", param, Integer.class);
		if(count==0){
			result.setResultString("failure");
			BLogicMessages messages = new BLogicMessages();
			messages.add("message",new BLogicMessage("message.selectinfo1"));
			result.setErrors(messages);
		}else{
			List<JNTCIEquipHomePage04Vo> postmessage04 = queryDAO.executeForObjectList("QueryInfoComment", param);
			for (int i = 0; i < postmessage04.size(); i++) {
				String tenpu_path=postmessage04.get(i).getTenpu_path();
				 try {
			            File file = new File(uploadPath + tenpu_path);
			            if(file.exists()){
			            	tenpu_path= "images/HomePageImg/" + tenpu_path + "?id=" + new Date();
			            }
			            else {
			            	tenpu_path=null;
						}
			        } catch (Exception e) {
			            e.printStackTrace();
			        }
			        postmessage04.get(i).setTenpu_path(tenpu_path);
			}
			List<JNTCIEquipNoticeMgVo> noticeMg = queryDAO.executeForObjectList("QueryInfo02", null);



			JNTCIEquipHomePageOutput output = new JNTCIEquipHomePageOutput();
			String LoginUser= param.getUserId();
			String DBUser= postmessage04.get(0).getUser_id();
			if(LoginUser.equals(DBUser)){
				output.setUserFlag(1);
			}else{
				output.setUserFlag(0);
			}
			output.setPostmessage04(postmessage04);
			output.setNoticeMg(noticeMg);
			output.setComment(comment);

			output.setTotalCount(totalCount);
           // output.setStartIndex(param.getStartIndex());
			//传递修改的startIndex
			output.setStartIndex(param.getStartIndex());

			result.setResultObject(output);
			result.setResultString("success");
		}
		return result;

	}
}
