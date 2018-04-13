package jp.terasoluna.thin.tutorial.web.transcosmos.blogic;

import java.io.File;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import jp.terasoluna.fw.dao.QueryDAO;
import jp.terasoluna.fw.dao.UpdateDAO;
import jp.terasoluna.fw.service.thin.BLogic;
import jp.terasoluna.fw.service.thin.BLogicMessage;
import jp.terasoluna.fw.service.thin.BLogicMessages;
import jp.terasoluna.fw.service.thin.BLogicResult;
import jp.terasoluna.thin.tutorial.web.common.controller.DateController;
import jp.terasoluna.thin.tutorial.web.transcosmos.dto.JNTCIPersonalInfoLoginDataBase;
import jp.terasoluna.thin.tutorial.web.transcosmos.dto.JNTCIPersonalInfoLoginEditTool;
import jp.terasoluna.thin.tutorial.web.transcosmos.dto.JNTCIPersonalInfoLoginEnglish;
import jp.terasoluna.thin.tutorial.web.transcosmos.dto.JNTCIPersonalInfoLoginInput;
import jp.terasoluna.thin.tutorial.web.transcosmos.dto.JNTCIPersonalInfoLoginJEnvirnment;
import jp.terasoluna.thin.tutorial.web.transcosmos.dto.JNTCIPersonalInfoLoginJapanese;
import jp.terasoluna.thin.tutorial.web.transcosmos.dto.JNTCIPersonalInfoLoginLanguage;
import jp.terasoluna.thin.tutorial.web.transcosmos.dto.JNTCIPersonalInfoLoginOccupation;
import jp.terasoluna.thin.tutorial.web.transcosmos.dto.JNTCIPersonalInfoLoginOperatSys;
import jp.terasoluna.thin.tutorial.web.transcosmos.dto.JNTCIPersonalInfoLoginOutput;
import jp.terasoluna.thin.tutorial.web.transcosmos.dto.JNTCIPersonalInfoLoginWork;
import jp.terasoluna.thin.tutorial.web.transcosmos.dto.JNTCIPersonalInfoLoginjLanguage;
import jp.terasoluna.thin.tutorial.web.transcosmos.dto.JNTCIPersonalInfoLoginworkStr;
import jp.terasoluna.thin.tutorial.web.transcosmos.vo.SelectCardOutput;

public class JNTCIPersonalInfoLoginBLogic implements
		BLogic<JNTCIPersonalInfoLoginInput> {

	/**
	 * QueryDAO。 Springによりインスタンス生成され設定される。
	 */
	private QueryDAO queryDao = null;

	private UpdateDAO updateDao = null;
	private String denglutime = null;
	private String tj_card = null;
	private String uploadPath = this.getClass().getClassLoader()
			.getResource("").getPath()
			+ "../../images/photo/";
	private static String photoPath = "images/defaultHeadPortrait.jpg";

	/**
	 * 登録処理を行う。
	 */
	public BLogicResult execute(JNTCIPersonalInfoLoginInput param) {

		String jn_Card = param.getUserId();
		param.setJn_Card(jn_Card);
		denglutime = queryDao.executeForObject("selectLoginTime", jn_Card,
				String.class);

		param.setLogintime(denglutime);
		if (jn_Card != null && !("".equals(jn_Card.trim()))) {
			tj_card = queryDao.executeForObject("selectTjCard", jn_Card,
					String.class);
			param.setTj_Card(tj_card);
		}

		Timestamp time = DateController.getStringToTimestamp(DateController
				.getDateToString(new Date(), DateController.YMDHMSs));
		// 登録時間
		param.setLogin_time(time);

		BLogicResult result = new BLogicResult();

		// 登録
		if (param.getJudge_flg() == 0) {

			// 作業経験
			param.setWork_Experience(param.getWork_ExperienceStr());

			// 登録個人情報処理
			updateDao.execute("loginPersonalInfoEm", param);

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
					insertParam.setJn_Card(param.getUserId());
					insertParam.setTj_Card(tj_card);
					insertParam.setWinning_date(InputString[0].trim());
					insertParam.setWining_certificate(InputString[1].trim());
					// 登録時間
					insertParam.setLogin_time(time);
					// 登録職業資格処理
					updateDao.execute("loginPersonalInfoOccupation",
							insertParam);
				}
			}

			int check = queryDao.executeForObject("selectworkexp", param,
					java.lang.Integer.class);
			if (check == 0) {
				String listString = param.getList();
				String[] rowStrings = listString.split("semicolon");
				for (int i = 0; i < rowStrings.length; i++) {
					String[] InputString = rowStrings[i].split("comma");
					JNTCIPersonalInfoLoginInput insertParam = new JNTCIPersonalInfoLoginInput();
					insertParam.setJn_Card(param.getUserId());
					insertParam.setTj_Card(tj_card);
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
					// 登録時間
					insertParam.setLogin_time(time);

					// 登録仕事経験処理
					updateDao.execute("loginPersonalInfoWorkExperience",
							insertParam);
				}
			}

			result.setResultString("success");
		} else {
			// 修正
			SelectCardOutput selectCardOutput = queryDao.executeForObject(
					"getUser", param, SelectCardOutput.class);

			// 需要修正的数据存在
			if (selectCardOutput != null) {

				/*
				 * if (!param.getUploadFile().getFileName().equals("") &&
				 * param.getJn_Card() != null) { FormFile formFile =
				 * param.getUploadFile(); String uploadFileName =
				 * formFile.getFileName(); String suffix =
				 * uploadFileName.substring(uploadFileName .lastIndexOf(".") +
				 * 1); String[] suffixs = { "bmp", "dib", "gif", "jfif", "jpe",
				 * "jpeg", "jpg", "png", "tif", "tiff", "ico" }; List<String>
				 * imgSuffix = Arrays.asList(suffixs); if
				 * (imgSuffix.contains(suffix)) { String filename =
				 * param.getJn_Card() + "." + suffix; FileOutputStream fos; try
				 * { File folder = new File(uploadPath); if (!folder.exists() &&
				 * !folder.isDirectory()) { folder.mkdirs(); } File file = new
				 * File(uploadPath + filename);// 创建文件 fos = new
				 * FileOutputStream(file);// 创建输出流 // 获取输入流 InputStream
				 * fileInputStream = formFile.getInputStream(); // 压缩上传 //
				 * 创建图片对象 BufferedImage prevImage =
				 * ImageIO.read(fileInputStream); // 设置新分辨率 int newWidth = 78;
				 * int newHeight = 85; // 生成新图片 BufferedImage image = new
				 * BufferedImage(newWidth, newHeight,
				 * BufferedImage.TYPE_INT_BGR); Graphics graphics =
				 * image.createGraphics(); graphics.drawImage(prevImage, 0, 0,
				 * newWidth, newHeight, null); ImageIO.write(image, suffix,
				 * fos); fos.flush();// 释放 fos.close(); // 关闭
				 * param.setPhoto_Path(filename); } catch (Exception e) {
				 * e.printStackTrace(); } } } else if (param.getPhoto_Path() ==
				 * null && param.getPhoto_Path_Old() != null) { String
				 * uploadFileName = param.getPhoto_Path_Old(); if
				 * (uploadFileName.contains("?")) { uploadFileName =
				 * uploadFileName.substring(0, uploadFileName.indexOf("?")); }
				 * String filename = uploadFileName.substring(uploadFileName
				 * .lastIndexOf("/") + 1); param.setPhoto_Path(filename); }
				 *
				 * // 更新个人信息表 if(param.getPhoto_Path()==null){ String oldpath=
				 * param.getPhoto_Path_Old(); if(oldpath!=null){
				 * oldpath=oldpath.substring(13, 21);
				 * param.setPhoto_Path(oldpath);} }
				 */


				param.setWork_Experience(param.getWork_ExperienceStr());

				updateDao.execute("updatePersonalInfo2", param);
				//受赏证书
				updateDao.execute("updatePersonalInfo3", param);
				//
				// 削除职业资格表数据
				updateDao.execute("deleteQual", param);
				// 削除工作经验表数据
				updateDao.execute("deleteWork", param);

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
						insertParam.setJn_Card(param.getUserId());
						insertParam.setTj_Card(tj_card);
						insertParam.setWinning_date(InputString[0].trim());
						insertParam
								.setWining_certificate(InputString[1].trim());
						insertParam.setLogin_time(time);
						if (denglutime == null) {
							String tsStr = "";
							DateFormat sdf = new SimpleDateFormat(
									"yyyy/MM/dd HH:mm:ss");
							tsStr = sdf.format(time);
							insertParam.setLogintime(tsStr);
						} else {
							insertParam.setLogintime(denglutime);
						}
						// 登録職業資格処理
						updateDao.execute("updatePersonalInfoOccupation",
								insertParam);
					}
				}

				String listString = param.getList();
				String[] rowStrings = listString.split("semicolon");
				for (int i = 0; i < rowStrings.length; i++) {
					String[] InputString = rowStrings[i].split("comma");
					if ("".equals(InputString[0])
							|| " ".equals(InputString[10])) {
						continue;
					}
					JNTCIPersonalInfoLoginInput insertParam = new JNTCIPersonalInfoLoginInput();
					insertParam.setJn_Card(param.getUserId());
					insertParam.setTj_Card(tj_card);
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
					insertParam.setLogin_time(time);
					if (denglutime == null) {
						String tsStr = "";
						DateFormat sdf = new SimpleDateFormat(
								"yyyy/MM/dd HH:mm:ss");
						tsStr = sdf.format(time);
						insertParam.setLogintime(tsStr);
					} else {
						insertParam.setLogintime(denglutime);
					}

					// 登録仕事経験処理
					updateDao.execute("updatePersonalInfoWorkExperience",
							insertParam);

					result.setResultString("success");
				}
				Integer id = queryDao.executeForObject(
						"selectloginPersonalInfoLanguage", null, Integer.class);

				if (id == null) {
					id = 0;
				}
				updateDao.execute("deleteLanguage", param);

				String LanguageList = param.getLanguageStr();

				String[] rowsStringss = LanguageList.split("semicolon");
				// 循環遍?插入

				for (int i = 0; i < rowsStringss.length; i++) {
					String[] InputString = rowsStringss[i].split("comma");
						if(InputString.length!=0){
							if (" ".equals(InputString[1])
									|| " ".equals(InputString[2])
									|| "  ".equals(InputString[3])) {
								continue;
							}
							JNTCIPersonalInfoLoginInput insertParam = new JNTCIPersonalInfoLoginInput();
							insertParam.setJn_Card(param.getUserId());
							insertParam.setPersoninfoid(++id);
							insertParam.setYanyu(InputString[0].trim());
							insertParam.setLanguage2(InputString[1].trim());
							insertParam.setLevel(InputString[2].trim());
							insertParam.setWork_time(InputString[3].trim());
							updateDao.execute("loginPersonalInfoLanguage", insertParam);
						}
					}

				updateDao.execute("deleteJavaEnvironment", param);

				String JavaEnvironmentList = param.getJavaenvironmentStr();

				String[] rowsStringsss = JavaEnvironmentList.split("semicolon");
				// 循環遍?插入
				for (int i = 0; i < rowsStringsss.length; i++) {
					String[] InputString = rowsStringsss[i].split("comma");
					if (" ".equals(InputString[1])
							|| " ".equals(InputString[2])
							|| "  ".equals(InputString[3])) {
						continue;
					}
					JNTCIPersonalInfoLoginInput insertParam = new JNTCIPersonalInfoLoginInput();
					insertParam.setJn_Card(param.getUserId());
					insertParam.setPersoninfoid(++id);
					insertParam.setJavahuanjing(InputString[0].trim());
					insertParam.setJavaenvironment(InputString[1].trim());
					insertParam.setLevel(InputString[2].trim());
					insertParam.setWork_time(InputString[3].trim());

					updateDao.execute("loginPersonalInfoJavaEnvironment",
							insertParam);
				}

				updateDao.execute("deleteJavaLanguage", param);

				String JavaLanguageList = param.getJavalanguageStr();

				String[] rowsStringssss = JavaLanguageList.split("semicolon");
				// 循環遍?插入
				for (int i = 0; i < rowsStringssss.length; i++) {
					String[] InputString = rowsStringssss[i].split("comma");
					if (" ".equals(InputString[1])
							|| " ".equals(InputString[2])
							|| "  ".equals(InputString[3])) {
						continue;
					}
					JNTCIPersonalInfoLoginInput insertParam = new JNTCIPersonalInfoLoginInput();
					insertParam.setJn_Card(param.getUserId());
					insertParam.setPersoninfoid(++id);
					insertParam.setJavayuyan(InputString[0].trim());
					insertParam.setJavalanguage(InputString[1].trim());
					insertParam.setLevel(InputString[2].trim());
					insertParam.setWork_time(InputString[3].trim());

					updateDao.execute("loginPersonalInfoJavaLanguage",
							insertParam);
				}

				updateDao.execute("deleteTool", param);

				String ToolList = param.getToolStr();

				String[] rowsStringstool = ToolList.split("semicolon");
				// 循環遍?插入
				for (int i = 0; i < rowsStringstool.length; i++) {
					String[] InputString = rowsStringstool[i].split("comma");
					if (" ".equals(InputString[1])
							|| " ".equals(InputString[2])
							|| "  ".equals(InputString[3])) {
						continue;
					}
					JNTCIPersonalInfoLoginInput insertParam = new JNTCIPersonalInfoLoginInput();
					insertParam.setJn_Card(param.getUserId());
					insertParam.setPersoninfoid(++id);
					insertParam.setToolid(InputString[0].trim());
					insertParam.setTool(InputString[1].trim());
					insertParam.setLevel(InputString[2].trim());
					insertParam.setWork_time(InputString[3].trim());

					updateDao.execute("loginPersonalInfoTool", insertParam);

				}

				updateDao.execute("deleteDB", param);

				String DbList = param.getDbStr();

				String[] rowsStringsdb = DbList.split("semicolon");
				// 循環遍?插入
				for (int i = 0; i < rowsStringsdb.length; i++) {
					String[] InputString = rowsStringsdb[i].split("comma");
					if (" ".equals(InputString[1])
							|| " ".equals(InputString[2])
							|| "  ".equals(InputString[3])) {
						continue;
					}
					JNTCIPersonalInfoLoginInput insertParam = new JNTCIPersonalInfoLoginInput();
					insertParam.setJn_Card(param.getUserId());
					insertParam.setPersoninfoid(++id);
					insertParam.setDbid(InputString[0].trim());
					insertParam.setDb(InputString[1].trim());
					insertParam.setLevel(InputString[2].trim());
					insertParam.setWork_time(InputString[3].trim());

					updateDao.execute("loginPersonalInfoDb", insertParam);
				}

				updateDao.execute("deleteOs", param);

				String OsList = param.getOsStr();

				String[] rowsStringsos = OsList.split("semicolon");
				// 循環遍?插入
				for (int i = 0; i < rowsStringsos.length; i++) {
					String[] InputString = rowsStringsos[i].split("comma");
					if (" ".equals(InputString[1])
							|| " ".equals(InputString[2])
							|| "  ".equals(InputString[3])) {
						continue;
					}
					JNTCIPersonalInfoLoginInput insertParam = new JNTCIPersonalInfoLoginInput();
					insertParam.setJn_Card(param.getUserId());
					insertParam.setPersoninfoid(++id);
					insertParam.setOsid(InputString[0].trim());
					insertParam.setOs(InputString[1].trim());
					insertParam.setLevel(InputString[2].trim());
					insertParam.setWork_time(InputString[3].trim());

					updateDao.execute("loginPersonalInfoOs", insertParam);
				}

				updateDao.execute("deletejap", param);

				if (!"".equals(param.getJapanStr())) {

					param.setPersoninfoid(++id);
					param.setJapanl("jap");
					updateDao.execute("loginPersonalInfojapan", param);
				}

				updateDao.execute("deleteeng", param);

				if (!"".equals(param.getEnglishStr())) {
					param.setPersoninfoid(++id);
					param.setEnglishl("eng");
					updateDao.execute("loginPersonalInfoenglish", param);
				}

				result.setResultString("success");

				// 鍙栧緱涓汉鍩烘湰淇℃伅
				JNTCIPersonalInfoLoginOutput personalInfoLoginOutput = queryDao
						.executeForObject("selectUpdatePersonalInfo2", param,
								JNTCIPersonalInfoLoginOutput.class);
				personalInfoLoginOutput.setCount("");

				String workStr = personalInfoLoginOutput.getWork_Experience();

				JNTCIPersonalInfoLoginworkStr ff = null;

				List<JNTCIPersonalInfoLoginworkStr> workStrList = new ArrayList<JNTCIPersonalInfoLoginworkStr>();

				if (workStr != null) {

					String[] rowsString = workStr.split(",");

					for (int i = 0; i < rowsString.length; i++) {
						String[] InputString = rowsString[i].split(":");
						if (InputString.length > 1) {
							ff = new JNTCIPersonalInfoLoginworkStr();
							ff.setWork_Experience(InputString[0].trim());
							ff.setWork_time(InputString[1].trim());
							workStrList.add(ff);
						}
					}

				} else {
					ff = new JNTCIPersonalInfoLoginworkStr();
					ff.setWork_Experience("PG");
					ff.setWork_time("0");
					workStrList.add(ff);
				}

				List<JNTCIPersonalInfoLoginOccupation> occupation = queryDao
						.executeForObjectList(
								"selectUpdatePersonalInfoOccupation", param);
				if (occupation == null || occupation.size() == 0) {
					JNTCIPersonalInfoLoginOccupation personInfoOccupation = new JNTCIPersonalInfoLoginOccupation();
					personInfoOccupation.setWinning_date("");
					personInfoOccupation.setWining_certificate("");
					occupation.add(personInfoOccupation);
				}
				List<JNTCIPersonalInfoLoginLanguage> language = queryDao
						.executeForObjectList(
								"selectUpdatePersonalInfoLanguage", param);
				if (language == null || language.size() == 0) {
					JNTCIPersonalInfoLoginLanguage personInfoLanguage = new JNTCIPersonalInfoLoginLanguage();
					personInfoLanguage.setYy_language("");
					personInfoLanguage.setYy_level("");
					personInfoLanguage.setYy_year("");
					language.add(personInfoLanguage);
				}

				List<JNTCIPersonalInfoLoginJEnvirnment> jEnvirnment = queryDao
						.executeForObjectList(
								"selectUpdatePersonalInfojEnvirnment", param);
				if (jEnvirnment == null || jEnvirnment.size() == 0) {
					JNTCIPersonalInfoLoginJEnvirnment personInfojEnvirnment = new JNTCIPersonalInfoLoginJEnvirnment();
					personInfojEnvirnment.setJhj_Envirnment("");
					personInfojEnvirnment.setJhj_level("");
					personInfojEnvirnment.setJhj_year("");
					jEnvirnment.add(personInfojEnvirnment);
				}

				List<JNTCIPersonalInfoLoginjLanguage> jLanguage = queryDao
						.executeForObjectList(
								"selectUpdatePersonalInfojLanguage", param);
				if (jLanguage == null || jLanguage.size() == 0) {
					JNTCIPersonalInfoLoginjLanguage personInfojLanguage = new JNTCIPersonalInfoLoginjLanguage();
					personInfojLanguage.setJyy_language("");
					personInfojLanguage.setJyy_level("");
					personInfojLanguage.setJyy_year("");
					jLanguage.add(personInfojLanguage);
				}
				List<JNTCIPersonalInfoLoginEditTool> editTool = queryDao
						.executeForObjectList(
								"selectUpdatePersonalInfoEditTool", param);
				if (editTool == null || editTool.size() == 0) {
					JNTCIPersonalInfoLoginEditTool personInfoEditTool = new JNTCIPersonalInfoLoginEditTool();
					personInfoEditTool.setTl_tool("");
					personInfoEditTool.setTl_level("");
					personInfoEditTool.setTl_year("");
					editTool.add(personInfoEditTool);
				}
				List<JNTCIPersonalInfoLoginDataBase> dataBase = queryDao
						.executeForObjectList(
								"selectUpdatePersonalInfoDataBase", param);
				if (dataBase == null || dataBase.size() == 0) {
					JNTCIPersonalInfoLoginDataBase personInfoDataBase = new JNTCIPersonalInfoLoginDataBase();
					personInfoDataBase.setDb_datebase("");
					personInfoDataBase.setDb_level("");
					personInfoDataBase.setDb_year("");
					dataBase.add(personInfoDataBase);
				}
				List<JNTCIPersonalInfoLoginOperatSys> operatSys = queryDao
						.executeForObjectList(
								"selectUpdatePersonalInfoOperatSys", param);
				if (operatSys == null || operatSys.size() == 0) {
					JNTCIPersonalInfoLoginOperatSys personInfoOperatSys = new JNTCIPersonalInfoLoginOperatSys();
					personInfoOperatSys.setOs_operatsys("");
					personInfoOperatSys.setOs_level("");
					personInfoOperatSys.setOs_year("");
					operatSys.add(personInfoOperatSys);
				}

				List<JNTCIPersonalInfoLoginWork> workList = queryDao
						.executeForObjectList("selectUpdatePersonalInfoWork",
								param);
				if (workList == null || workList.size() == 0) {
					JNTCIPersonalInfoLoginWork personInfoworkList = new JNTCIPersonalInfoLoginWork();
					personInfoworkList.setOrder_no(1);
					workList.add(personInfoworkList);
				}

				for (int i = 0; i < workList.size(); i++) {
					workList.get(i).setOrder_no(i + 1);
				}

				JNTCIPersonalInfoLoginJapanese japanese = queryDao
						.executeForObject("selectUpdatePersonalInfojapanese",
								param, JNTCIPersonalInfoLoginJapanese.class);

				if (japanese != null) {
					String jap_level = japanese.getJap_level();

					String japStr = japanese.getJap_skill();

					String[] jap_skill = null;

					if (japStr != null) {
						if (japStr.indexOf("-") > 0) {
							jap_skill = japStr.split("-");

						} else {
							jap_skill = japStr.split("");
						}
					}
					personalInfoLoginOutput.setJap_level(jap_level);
					personalInfoLoginOutput.setJap_skill(jap_skill);
				}
				JNTCIPersonalInfoLoginEnglish english = queryDao
						.executeForObject("selectUpdatePersonalInfoenglish",
								param, JNTCIPersonalInfoLoginEnglish.class);

				if (english != null) {
					String eng_level = english.getEng_level();

					String engStr = english.getEng_skill();

					String[] eng_skill = null;

					if (engStr != null) {
						if (engStr.indexOf(",") > 0) {
							eng_skill = engStr.split(",");

						} else {
							eng_skill = engStr.split("");
						}
					}

					personalInfoLoginOutput.setEng_level(eng_level);
					personalInfoLoginOutput.setEng_skill(eng_skill);
				}
				personalInfoLoginOutput.setJn_Card(jn_Card);
				personalInfoLoginOutput.setWorkList(workList);
				personalInfoLoginOutput.setWorkStr(workStrList);
				personalInfoLoginOutput.setOccupation(occupation);
				personalInfoLoginOutput.setLanguage(language);
				personalInfoLoginOutput.setjEnvirnment(jEnvirnment);
				personalInfoLoginOutput.setjLanguage(jLanguage);
				personalInfoLoginOutput.setEditTool(editTool);
				personalInfoLoginOutput.setDataBase(dataBase);
				personalInfoLoginOutput.setOperatSys(operatSys);

				personalInfoLoginOutput.setButton_name("淇");
				personalInfoLoginOutput.setDisable(true);
				personalInfoLoginOutput.setJudge_flg(1);
				personalInfoLoginOutput.setCheckResult("success");

				if (personalInfoLoginOutput.getPhoto_Path() != null
						&& !"".equals(personalInfoLoginOutput.getPhoto_Path()
								.trim())) {
					personalInfoLoginOutput
							.setPhoto_Path(showPhoto(personalInfoLoginOutput
									.getPhoto_Path()));
				} else {
					personalInfoLoginOutput.setPhoto_Path(photoPath);
				}

				result.setResultObject(personalInfoLoginOutput);

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

	private String showPhoto(String photoName) {
		try {
			File file = new File(uploadPath + photoName);
			if (file.exists()) {
				return "images/photo/" + photoName + "?id=" + new Date();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return photoPath;
	}

	/**
	 * UpdateDAOを設定する。
	 *
	 * @param updateDAO
	 */
	public void setUpdateDAO(UpdateDAO updateDao) {
		this.updateDao = updateDao;
	}

	public boolean isNumeric(String str) {
		boolean flag = false;

		Pattern p = Pattern.compile(".*\\d+.*");

		Matcher m = p.matcher(str);

		if (m.matches())

			flag = true;

		return flag;

	}
}
