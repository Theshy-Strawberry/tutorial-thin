package jp.terasoluna.thin.tutorial.web.transcosmos.blogic;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

import jp.terasoluna.fw.dao.QueryDAO;
import jp.terasoluna.fw.dao.UpdateDAO;
import jp.terasoluna.fw.service.thin.BLogic;
import jp.terasoluna.fw.service.thin.BLogicMessage;
import jp.terasoluna.fw.service.thin.BLogicMessages;
import jp.terasoluna.fw.service.thin.BLogicResult;
import jp.terasoluna.thin.tutorial.web.common.controller.Mail;
import jp.terasoluna.thin.tutorial.web.transcosmos.dto.JNTCIEquipNoticeMgVoInput;

import org.apache.struts.upload.FormFile;

public class JNTCIEquipPostMessage02BLogic implements BLogic<JNTCIEquipNoticeMgVoInput>{

	private UpdateDAO updateDAO = null;


	public void setUpdateDAO(UpdateDAO updateDAO) {
		this.updateDAO = updateDAO;
	}

	private QueryDAO queryDAO = null;


	public void setQueryDAO(QueryDAO queryDAO) {
		this.queryDAO = queryDAO;
	}

	private String uploadPath = this.getClass().getClassLoader()
			.getResource("").getPath()
			+ "../../file/uploadFile/";

	public BLogicResult execute(JNTCIEquipNoticeMgVoInput param){
		Integer k = queryDAO.executeForObject("SelectId",null, Integer.class);
		String filePath = null;
		FileOutputStream fos;
		FormFile formFile = param.getUploadFile();
		if(!(param.getUploadFile().getFileName() == null||"".equals(param.getUploadFile().getFileName()))){
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
				while(true){
					int ins = fin.read(buffer);
					if(ins == -1){
						fin.close();
						fos.flush();
						fos.close();
						break;
					}else{

						fos.write(buffer);

					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		param.setFilePath(filePath);
		int j;
		if(k==null){j=1;}
		else{
			j=k.intValue()+1;
		}
		param.setInfo_id(j);

		j=updateDAO.execute("InsertNotice02",param);

		//收件人列表
		String jncard =param.getUserId();
		String[] toIdstr = queryDAO.executeForObjectArray("queryMail", jncard, String.class);
		InternetAddress sendTo[] = new InternetAddress[toIdstr.length];
		for (int i = 0; i < toIdstr.length; i++) {
			try {
				sendTo[i] = new InternetAddress(toIdstr[i]+"@trans-cosmos.com.cn");
			} catch (AddressException e) {
				e.printStackTrace();
			}
		}
		//发件人邮箱
		//String jncard =param.getUserId();
		String officemail = queryDAO.executeForObject("findOfficEmail", jncard,
				String.class);
		String maillian = "@trans-cosmos.com.cn";
		String from = officemail + maillian;
		String username = queryDAO.executeForObject("findUserByCard", jncard,
				String.class);
		//标题
		String subject="お知らせ";
		//内容
		String content="皆さん <br> お疲れ様です。".concat(username)
					   .concat("です。<br> <br> こちらは、お知らせを一件投稿しました。<br> タイトル：")
					   .concat(param.getInfo_caption()).concat("<br> 内容:")
					   .concat(param.getInfo_content());
		if(!(param.getUploadFile().getFileName() == null||"".equals(param.getUploadFile().getFileName()))){
			content=content.concat("<br>添付ファイール：<a href='#'>").concat(param.getUploadFile().getFileName())
				   .concat("</a>&nbsp;<b>（内部システムからダウンロードできます。）</b>");

		}

		content=content.concat("<br>ご確認をお願い致します。")
					   .concat("<br> <br>以上です。 <br> ").concat(username);


		Mail.sendAll(from, "123456", sendTo, null, null,subject, content, null);
		BLogicResult result = new BLogicResult();

		BLogicMessages messages = new BLogicMessages();
		messages.add("message",new BLogicMessage("homepage03.insert.success"));
		result.setMessages(messages);

		result.setResultString("success");
		return result;
	}
}
