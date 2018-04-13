package jp.terasoluna.thin.tutorial.web.transcosmos.blogic;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.imageio.ImageIO;

import org.apache.struts.upload.FormFile;

import jp.terasoluna.fw.dao.QueryDAO;
import jp.terasoluna.fw.dao.UpdateDAO;
import jp.terasoluna.fw.service.thin.BLogic;
import jp.terasoluna.fw.service.thin.BLogicMessage;
import jp.terasoluna.fw.service.thin.BLogicMessages;
import jp.terasoluna.fw.service.thin.BLogicResult;
import jp.terasoluna.thin.tutorial.web.common.controller.DateController;
import jp.terasoluna.thin.tutorial.web.transcosmos.dto.JNTCIPersonalInfoLoginInput;
import jp.terasoluna.thin.tutorial.web.transcosmos.dto.JNTCIPersonalInfoLoginOutput;
import jp.terasoluna.thin.tutorial.web.transcosmos.vo.SelectCardOutput;

public class JNTCIAdminInfoLoginBLogic implements
        BLogic<JNTCIPersonalInfoLoginInput> {

    /**
     * QueryDAO。 Springによりインスタンス生成され設定される。
     */
    private QueryDAO queryDao = null;

    private UpdateDAO updateDao = null;
    private String uploadPath = this.getClass().getClassLoader()
            .getResource("").getPath()
            + "../../images/photo/";

    /**
     * 登録処理を行う。
     */
    public BLogicResult execute(JNTCIPersonalInfoLoginInput param) {

        Timestamp time = DateController.getStringToTimestamp(DateController
                .getDateToString(new Date(), DateController.YMDHMSs));
        // 登録時間
        param.setLogin_time(time);

        BLogicResult result = new BLogicResult();

        if (!"".equals(param.getUploadFile().getFileName())
                && param.getJn_Card() != null) {
            FormFile formFile = param.getUploadFile();
            String uploadFileName = formFile.getFileName();
            String suffix = uploadFileName.substring(uploadFileName
                    .lastIndexOf(".") + 1);
            String[] suffixs = { "bmp", "dib", "gif", "jfif", "jpe", "jpeg",
                    "jpg", "png", "tif", "tiff", "ico" };
            List<String> imgSuffix = Arrays.asList(suffixs);
            if (imgSuffix.contains(suffix)) {
                String filename = param.getJn_Card() + "." + suffix;
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
                    int newWidth = 78;
                    int newHeight = 85;
                    // 生成新图片
                    BufferedImage image = new BufferedImage(newWidth,
                            newHeight, BufferedImage.TYPE_INT_BGR);
                    Graphics graphics = image.createGraphics();
                    graphics.drawImage(prevImage, 0, 0, newWidth, newHeight,
                            null);
                    ImageIO.write(image, suffix, fos);
                    fos.flush();// 释放
                    fos.close(); // 关闭
                    param.setPhoto_Path(filename);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } else if (param.getPhoto_Path() == null
                && param.getPhoto_Path_Old() != null) {
            String uploadFileName = param.getPhoto_Path_Old();
            if (uploadFileName.contains("?")) {
                uploadFileName = uploadFileName.substring(0,
                        uploadFileName.indexOf("?"));
            }
            String filename = uploadFileName.substring(uploadFileName
                    .lastIndexOf("/") + 1);
            param.setPhoto_Path(filename);
        }
        // 更改卡号的
        String selectCardOutput1 = queryDao.executeForObject(
				"getUser1", param, String.class);
		Integer count1 = Integer.valueOf(selectCardOutput1);

		if (count1 >1) {
			// エラーメッセージ処理
			BLogicMessages messages = new BLogicMessages();
			messages.add("message", new BLogicMessage(
					"errors.input.id.repeat"));
			result.setErrors(messages);
			result.setResultString("failureCreate");
			return result;
		}
        // 修正
        SelectCardOutput selectCardOutput = queryDao.executeForObject(
                "getUser", param, SelectCardOutput.class);

        // 需要修正的数据存在
        if (selectCardOutput != null) {
            updateDao.execute("updatePersonalInfo", param);
            updateDao.execute("updatePersonalInfouser", param);
            JNTCIPersonalInfoLoginOutput personalInfoLoginOutput = new JNTCIPersonalInfoLoginOutput();
            personalInfoLoginOutput.setPhoto_Path("images/photo/"
                    + param.getPhoto_Path());
            personalInfoLoginOutput.setStatus("true");
            result.setResultObject(personalInfoLoginOutput);
            result.setResultString("success");

        } else {
            JNTCIPersonalInfoLoginOutput personalInfoLoginOutput = new JNTCIPersonalInfoLoginOutput();
            personalInfoLoginOutput.setPhoto_Path("images/photo/"
                    + param.getPhoto_Path());
            personalInfoLoginOutput.setStatus("false");
            result.setResultObject(personalInfoLoginOutput);
            result.setResultString("success");
        }

        return result;

    }

    /**
     * QueryDAOを設定する。
     *
     * @param queryDAO
     */
    public void setQueryDAO(QueryDAO queryDao) {
        this.queryDao = queryDao;
    }

    /**
     * UpdateDAOを設定する。
     *
     * @param updateDAO
     */
    public void setUpdateDAO(UpdateDAO updateDao) {
        this.updateDao = updateDao;
    }
}
