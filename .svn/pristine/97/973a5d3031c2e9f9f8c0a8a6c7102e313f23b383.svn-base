package jp.terasoluna.thin.tutorial.web.transcosmos.blogic;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

import javax.imageio.ImageIO;

import org.apache.struts.upload.FormFile;

import jp.terasoluna.fw.dao.QueryDAO;
import jp.terasoluna.fw.dao.UpdateDAO;
import jp.terasoluna.fw.service.thin.BLogic;
import jp.terasoluna.fw.service.thin.BLogicMessage;
import jp.terasoluna.fw.service.thin.BLogicMessages;
import jp.terasoluna.fw.service.thin.BLogicResult;
import jp.terasoluna.thin.tutorial.web.transcosmos.dto.JNTCLOvertimePostMessageInput;

public class JNTCIEquipPostMessageBLogic implements BLogic<JNTCLOvertimePostMessageInput>{
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
	+ "../../images/HomePageImg/";

	public BLogicResult execute(JNTCLOvertimePostMessageInput param){
		String upload=param.getUploadFile().getFileName();
		if (!"".equals(upload)) {
			FormFile formFile = param.getUploadFile();
			String uploadFileName = formFile.getFileName();
			String suffix = uploadFileName.substring(uploadFileName
					.lastIndexOf(".") + 1);
			String[] suffixs = { "bmp", "dib", "gif", "jfif", "jpe", "jpeg",
					"jpg", "png", "tif", "tiff", "ico" };
			List<String> imgSuffix = Arrays.asList(suffixs);
			if (imgSuffix.contains(suffix)) {
				String filename = uploadFileName;
				FileOutputStream fos;
				try {
					File folder = new File(uploadPath);
					if (!folder.exists() && !folder.isDirectory()) {
						folder.mkdirs();
					}
					File file = new File(uploadPath + filename);// 创建文件
					fos = new FileOutputStream(file);// 创建输出流
					// 获取输入流
					InputStream fileInputStream = formFile.getInputStream();
					// 压缩上传
					// 创建图片对象
					BufferedImage prevImage = ImageIO.read(fileInputStream);
					// 设置新分辨率
					int newWidth = 200;
					int newHeight = 210;
					// 生成新图片
					BufferedImage image = new BufferedImage(newWidth,
							newHeight, BufferedImage.TYPE_INT_BGR);
					Graphics graphics = image.createGraphics();
					graphics.drawImage(prevImage, 0, 0, newWidth, newHeight,
							null);
					ImageIO.write(image, suffix, fos);
					fos.flush();// 释放
					fos.close(); // 关闭
					param.setTenpu_path(filename);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		Integer k = queryDAO.executeForObject("SelectId",null, Integer.class);
		int j;
		if(k==null){j=1;}
		else{
			j=k.intValue()+1;
		}
		param.setInfo_id(j);
		j=updateDAO.execute("InsertInfo",param);
		BLogicResult result = new BLogicResult();
	BLogicMessages messages = new BLogicMessages();

		messages.add("message",new BLogicMessage("homepage03.insert.success"));

		result.setMessages(messages);
		result.setResultString("success");
		return result;
	}

}
