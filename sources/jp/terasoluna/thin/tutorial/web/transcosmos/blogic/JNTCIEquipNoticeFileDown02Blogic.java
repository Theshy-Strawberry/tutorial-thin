package jp.terasoluna.thin.tutorial.web.transcosmos.blogic;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import jp.terasoluna.fw.dao.QueryDAO;
import jp.terasoluna.fw.dao.UpdateDAO;
import jp.terasoluna.fw.service.thin.BLogic;
import jp.terasoluna.fw.service.thin.BLogicMessage;
import jp.terasoluna.fw.service.thin.BLogicMessages;
import jp.terasoluna.fw.service.thin.BLogicResult;
import jp.terasoluna.fw.web.struts.actions.DownloadFile;
import jp.terasoluna.thin.tutorial.web.transcosmos.dto.JNTCIEquipNoticeMgVoInput;
import jp.terasoluna.thin.tutorial.web.transcosmos.dto.JNTCIHomePage02Input;
import jp.terasoluna.thin.tutorial.web.transcosmos.dto.JNTCIHomePage02Output;


public class JNTCIEquipNoticeFileDown02Blogic implements BLogic<JNTCIEquipNoticeMgVoInput> {
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
	public BLogicResult execute(JNTCIEquipNoticeMgVoInput param) {
		String fileName = queryDAO.executeForObject("DownLoadFileId",param, String.class);

		BLogicResult result = new BLogicResult();
		String resulePath=uploadPath+fileName;
		File file = new File(resulePath);
		if(file.exists()==false){
			JNTCIHomePage02Output infoTitle =queryDAO.executeForObject("infoTitle",param,JNTCIHomePage02Output.class);
			JNTCIHomePage02Input input=new JNTCIHomePage02Input();
			if(infoTitle!=null){
				input.setFilePath(null);
				Date now = new Date();
				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");//???f?[?t?H???gTime zone
				String time=dateFormat.format( now );
				input.setInfo_date(time);
				input.setInfo_details(infoTitle.getInfo_details());
				input.setInfo_id(infoTitle.getInfo_id());
				input.setInfo_title(infoTitle.getInfo_title());
				input.setUser_id(infoTitle.getUser_id());
				updateDAO.execute("infoTitleUpdate", input);
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
