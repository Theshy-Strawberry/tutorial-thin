package jp.terasoluna.thin.tutorial.web.transcosmos.blogic;

import java.io.File;
import jp.terasoluna.fw.dao.QueryDAO;
import jp.terasoluna.fw.dao.UpdateDAO;
import jp.terasoluna.fw.service.thin.BLogic;
import jp.terasoluna.fw.service.thin.BLogicMessage;
import jp.terasoluna.fw.service.thin.BLogicMessages;
import jp.terasoluna.fw.service.thin.BLogicResult;
import jp.terasoluna.fw.web.struts.actions.DownloadFile;
import jp.terasoluna.thin.tutorial.web.transcosmos.dto.JNTCIAddsignInfoInput;
import jp.terasoluna.thin.tutorial.web.transcosmos.dto.JNTCIAddsignInfoOut;


public class JNTCIAddsignDownloadFileBlogic implements BLogic<JNTCIAddsignInfoInput> {
	private UpdateDAO updateDAO = null;


	public void setUpdateDAO(UpdateDAO updateDAO) {
		this.updateDAO = updateDAO;
	}

	private QueryDAO queryDAO = null;


	public void setQueryDAO(QueryDAO queryDAO) {
		this.queryDAO = queryDAO;
	}

//	/E:/Myworkspace/20160901/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/tutorial-thin/WEB-INF/classes/../../file/uploadFile/
	private String uploadPath = this.getClass().getClassLoader()
			.getResource("").getPath() + "../../file/uploadFile/";
//例：下記のファイルに/* E:/Myworkspace/20160901/.metadata/.plugins/org.eclipse.wst.server.core/tmp0\wtpwebapps\tutorial-thin\file\"uploadFile" */
//ファイルの名前はfirefoxで文字化けがあります
	public BLogicResult execute(JNTCIAddsignInfoInput  param) {
		// TODO 自動生成されたメソッド・スタブ
		BLogicResult result = new BLogicResult();
  		String fileName = queryDAO.executeForObject("infoListDownLoadFileId",param, String.class);


		String resulePath=uploadPath+fileName;
		File file = new File(resulePath);
		if(file.exists()==false){
			JNTCIAddsignInfoOut infoTitle =queryDAO.executeForObject("infoListDownLoad",param,JNTCIAddsignInfoOut.class);
			JNTCIAddsignInfoInput input=new JNTCIAddsignInfoInput();
			if(infoTitle!=null){
				input.setFilePath(null);

				input.setJN_CARD(input.getJN_CARD());
				input.setUSER_NAME(input.getUSER_NAME());


			input.setStart_time_add(input.getStart_time_add());
			input.setEnd_time_add(input.getEnd_time_add());
			input.setReason_type(input.getReason_type());
				updateDAO.execute("infoListDownLoadFileIdUpdate", input);
				BLogicMessages messages = new BLogicMessages();
				messages.add("message", new BLogicMessage("homepage02.FileNull"));
				result.setErrors(messages);
				result.setResultString("fail");
			}
			else{
				BLogicMessages messages = new BLogicMessages();
				messages.add("message", new BLogicMessage("homepage02.dataNull"));
				result.setErrors(messages);
				result.setResultString("fail");

			}

		}else {
			//文件时
			DownloadFile downloadFile = new DownloadFile(file);
			result.setResultObject(downloadFile);
		}
		return result;


	}
}
