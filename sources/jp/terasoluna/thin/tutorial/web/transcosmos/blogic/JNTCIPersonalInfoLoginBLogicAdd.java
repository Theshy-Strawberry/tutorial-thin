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
import jp.terasoluna.thin.tutorial.web.common.controller.JiaMi;
import jp.terasoluna.thin.tutorial.web.transcosmos.dto.JNTCIPersonalInfoLoginInput;
import jp.terasoluna.thin.tutorial.web.transcosmos.dto.JNTCIPersonalInfoLoginOutput;
import jp.terasoluna.thin.tutorial.web.transcosmos.vo.SelectCardOutput;

public class JNTCIPersonalInfoLoginBLogicAdd implements
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
		param.setOut_Time("2099/12/31");
		BLogicResult result = new BLogicResult();
		BLogicMessages messages = new BLogicMessages();

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
		// 登録
		if (param.getJudge_flg() == 0) {

			String selectCardOutput = queryDao.executeForObject(
					"getUser1", param, String.class);
			Integer count1 = Integer.valueOf(selectCardOutput);

			// 登録するcardが重複してる場合は異常処理をする
			if (count1 >0) {

				// エラーメッセージ処理
				messages = new BLogicMessages();
				messages.add("message", new BLogicMessage(
						"errors.input.id.repeat"));
				result.setErrors(messages);

				result.setResultString("failureCreate");
				return result;
			}

			// 登録個人情報処理
			updateDao.execute("loginPersonalInfo", param);

			try {
				JNTCIPersonalInfoLoginOutput out= new JNTCIPersonalInfoLoginOutput();
				out.setCount("");
				String user_password = param.getTj_Card();
				JiaMi jm = new JiaMi();
				String encrypted = JiaMi.bytesToHex(jm.encrypt(user_password));
				param.setPassword(encrypted);
				// 登録ユーザ表
				int count;
				count = updateDao.execute("loginPersonalUser", param);
				if(count==1){
				}
				out.setCount(String.valueOf(count));
				result.setResultObject(out);

			} catch (Exception e) {
			}

			result.setResultString("success");
		}
		 else {
			// 修正
			SelectCardOutput selectCardOutput = queryDao.executeForObject(
					"getUser", param, SelectCardOutput.class);

			// 需要修正的数据存在
			if (selectCardOutput != null) {
				// 作業経験
				param.setWork_Experience(param.getWork_ExperienceStr());
				//
				// 削除职业资格表数据
				updateDao.execute("deleteQual", param);
				// 削除工作经验表数据
				updateDao.execute("deleteWork", param);
				// 更新个人信息表
				updateDao.execute("updatePersonalInfo", param);

				// 取得職業資格集合
				String qualList = param.getQualificationStr();
				// 取得行数
				String[] rowsStrings = qualList.split("semicolon");
				// 循環遍历插入
				for (int i = 0; i < rowsStrings.length; i++) {
					String[] InputString = rowsStrings[i].split("comma");
					if (!("".equals(InputString[0].trim()))
							&& !("".equals(InputString[1].trim()))) {
						JNTCIPersonalInfoLoginInput insertParam = new JNTCIPersonalInfoLoginInput();
						insertParam.setJn_Card(param.getJn_Card());
						insertParam.setTj_Card(param.getTj_Card());
						insertParam.setWinning_date(InputString[0].trim());
						insertParam
								.setWining_certificate(InputString[1].trim());
						// 登録職業資格処理
						updateDao.execute("loginPersonalInfoOccupation",
								insertParam);
					}
				}

				String listString = param.getList();
				String[] rowStrings = listString.split("semicolon");
				for (int i = 0; i < rowStrings.length; i++) {
					String[] InputString = rowStrings[i].split("comma");
					JNTCIPersonalInfoLoginInput insertParam = new JNTCIPersonalInfoLoginInput();
					insertParam.setJn_Card(param.getJn_Card());
					insertParam.setTj_Card(param.getTj_Card());
					insertParam.setOrder_no(i + 1);
					insertParam.setCareers_type(InputString[0].trim());
					insertParam.setProj_name(InputString[10].trim());
					insertParam.setAttend_nm(InputString[1].trim());
					insertParam.setAttend_month(InputString[2].trim());
					insertParam.setAttend_states(InputString[3].trim());
					insertParam.setDevelop_phase(InputString[4].trim());
					insertParam.setFirm_content(InputString[5].trim());
					insertParam.setLang_tool(InputString[6].trim());
					insertParam.setData_base(InputString[7].trim());
					insertParam.setTechnical_sys(InputString[8].trim());
					insertParam.setModel_device(InputString[9].trim());
					insertParam.setDevelop_period(InputString[11].trim());
					insertParam.setTotal_period(InputString[12].trim());

					// 登録仕事経験処理
					updateDao.execute("loginPersonalInfoWorkExperience",
							insertParam);
				}

				result.setResultString("success");
		}

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
