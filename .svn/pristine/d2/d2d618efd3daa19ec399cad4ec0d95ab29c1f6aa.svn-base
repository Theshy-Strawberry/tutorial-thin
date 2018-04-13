package jp.terasoluna.thin.tutorial.web.transcosmos.blogic;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.struts.upload.FormFile;
import jp.terasoluna.fw.dao.QueryDAO;
import jp.terasoluna.fw.dao.UpdateDAO;
import jp.terasoluna.fw.service.thin.BLogic;
import jp.terasoluna.fw.service.thin.BLogicMessage;
import jp.terasoluna.fw.service.thin.BLogicMessages;
import jp.terasoluna.fw.service.thin.BLogicResult;
import jp.terasoluna.thin.tutorial.web.transcosmos.dto.JNTCIHomePage02Input;
import jp.terasoluna.thin.tutorial.web.transcosmos.dto.JNTCIHomePage02Output;

public class JNTCIHomePageUpdate02BLogic implements
		BLogic<JNTCIHomePage02Input> {
	private QueryDAO queryDAO = null;
	private UpdateDAO updateDAO = null;

	public UpdateDAO getUpdateDAO() {
		return updateDAO;
	}

	public void setUpdateDAO(UpdateDAO updateDAO) {
		this.updateDAO = updateDAO;
	}

	public QueryDAO getQueryDAO() {
		return queryDAO;
	}

	public void setQueryDAO(QueryDAO queryDAO) {
		this.queryDAO = queryDAO;
	}

	private String uploadPath = this.getClass().getClassLoader()
			.getResource("").getPath()
			+ "../../file/uploadFile/";

	public BLogicResult execute(JNTCIHomePage02Input param) {

		JNTCIHomePage02Output infoTitle = queryDAO.executeForObject(
				"infoTitle", param, JNTCIHomePage02Output.class);
		BLogicResult result = new BLogicResult();
		if (infoTitle != null) {
			// upload
			String filePath = null;
			FileOutputStream fos;
			FormFile formFile = param.getUploadFile();
			String fileName = param.getUploadFile().getFileName();
			// 没有重新上传新文件时执行
			if ((fileName == null || "".equals(fileName))) {
				// 原来有文件，且没有重新传文件，且没有点击消除按钮（文件路径框有值）时，执行以下方法
				if (param.getTenpu_path() != null
						&& (param.getFileNameJsp() != null && !("".equals(param
								.getFileNameJsp())))) {
					filePath = param.getTenpu_path();
					// 取得系统时间
					SimpleDateFormat df = new SimpleDateFormat();
					String date = df.format(new Date());
					param.setInfo_date(date);

					param.setFilePath(filePath);

					// update
					updateDAO.execute("infoTitleUpdate", param);
					// 画面再検索
					JNTCIHomePage02Output output = queryDAO.executeForObject(
							"infoTitle", param, JNTCIHomePage02Output.class);

					//传递修改的startIndex
					output.setStartIndex(param.getStartIndex());



					result.setResultObject(output);
					BLogicMessages messages = new BLogicMessages();
					messages.add("message", new BLogicMessage("homepage03.insert.success"));
					result.setMessages(messages);
					result.setResultString("success2");
					return result;
				} else {
					// 只要文件路径框无值就执行到这（原来无文件；原来有文件，但点了消除按钮）
					// 取得系统时间
					SimpleDateFormat df = new SimpleDateFormat();
					String date = df.format(new Date());
					param.setInfo_date(date);

					param.setFilePath(filePath);

					// update
					updateDAO.execute("infoTitleUpdate", param);
					// 画面再検索
					JNTCIHomePage02Output output = queryDAO.executeForObject(
							"infoTitle", param, JNTCIHomePage02Output.class);

					//传递修改的startIndex
					output.setStartIndex(param.getStartIndex());


					result.setResultObject(output);
					BLogicMessages messages = new BLogicMessages();
					messages.add("message", new BLogicMessage("homepage03.insert.success"));
					result.setMessages(messages);
					result.setResultString("success2");
					return result;
				}
			} else {
				// 重新上传了文件执行这
				filePath = param.getUploadFile().getFileName();
				try {
					File folder = new File(uploadPath);
					if (!folder.exists() && !folder.isDirectory()) {
						folder.mkdirs();
					}
					File file = new File(uploadPath + filePath);// 创建文件
					InputStream fin = formFile.getInputStream();
					fos = new FileOutputStream(file);

					byte[] buffer = new byte[fin.available()];
					while (true) {
						int ins = fin.read(buffer);
						if (ins == -1) {
							fin.close();
							fos.flush();
							fos.close();
							break;
						} else {

							fos.write(buffer);

						}
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				// 取得系统时间
				SimpleDateFormat df = new SimpleDateFormat();
				String date = df.format(new Date());
				param.setInfo_date(date);

				param.setFilePath(filePath);

				// update
				updateDAO.execute("infoTitleUpdate", param);
				// 画面再検索
				JNTCIHomePage02Output output = queryDAO.executeForObject(
						"infoTitle", param, JNTCIHomePage02Output.class);

			//传递修改的startIndex
				output.setStartIndex(param.getStartIndex());


				result.setResultObject(output);
				BLogicMessages messages = new BLogicMessages();
				messages.add("message", new BLogicMessage("homepage03.insert.success"));
				result.setMessages(messages);
				result.setResultString("success2");
				return result;
			}
		} else {
			BLogicMessages messages = new BLogicMessages();
			messages.add("message", new BLogicMessage("homepage02.FileNull"));
			result.setErrors(messages);
			result.setResultString("failure");
			return result;
		}
	}
}
