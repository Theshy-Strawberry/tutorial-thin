package jp.terasoluna.thin.tutorial.web.transcosmos.blogic;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.IOUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.ClientAnchor;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Drawing;
import org.apache.poi.ss.usermodel.Picture;

import jp.terasoluna.fw.dao.QueryDAO;
import jp.terasoluna.fw.service.thin.BLogic;
import jp.terasoluna.fw.service.thin.BLogicResult;
import jp.terasoluna.fw.web.struts.actions.DownloadFile;
import jp.terasoluna.thin.tutorial.web.transcosmos.dto.JNTCIPersonalInfoDetailedInput;
import jp.terasoluna.thin.tutorial.web.transcosmos.vo.JNTCISelectPersonalInfo;
import jp.terasoluna.thin.tutorial.web.transcosmos.vo.JNTCISelectPersonalSkillInfo;
import jp.terasoluna.thin.tutorial.web.transcosmos.vo.SelectQualificationTR;
import jp.terasoluna.thin.tutorial.web.transcosmos.vo.SelectWorkExperience;

public class JNTCIDownloadBLogic implements
		BLogic<JNTCIPersonalInfoDetailedInput> {

	private QueryDAO queryDAO = null;

	public void setQueryDAO(QueryDAO queryDAO) {
		this.queryDAO = queryDAO;
	}

	private String uploadPath = this.getClass().getClassLoader()
			.getResource("").getPath()
			+ "../../images/photo/";

	public BLogicResult execute(JNTCIPersonalInfoDetailedInput param) {

		if (param.getId_card() == null) {
			param.setId_card(param.getUserId());
		}
		// 個人基本情報
		JNTCISelectPersonalInfo jntciSelectPersonalInfo = queryDAO
				.executeForObject("selectDetailedInfo", param,
						JNTCISelectPersonalInfo.class);

		// 職業資格
		List<SelectQualificationTR> qualificationTR = queryDAO
				.executeForObjectList("selectQualificationTR", param);

		// 仕事経験
		List<SelectWorkExperience> workExperience = queryDAO
				.executeForObjectList("selectWorkExperience", param);
		// sheet2
		List<JNTCISelectPersonalSkillInfo> list = new ArrayList<JNTCISelectPersonalSkillInfo>();
		// 转换成map集合
		list = queryDAO.executeForObjectList("selectSkill", param);

		Map<String, JNTCISelectPersonalSkillInfo> map = new HashMap<String, JNTCISelectPersonalSkillInfo>();

		for (int i = 0; i < list.size(); i++) {
			JNTCISelectPersonalSkillInfo jif = (JNTCISelectPersonalSkillInfo) list
					.get(i);
			map.put((jif).getSoftwarename(), jif);
		}

		// 选择模板文件：
		String realpath = this.getClass().getClassLoader().getResource("")
				.getPath()
				+ "template.xls";
		String resultPath = "D:/" + jntciSelectPersonalInfo.getJn_Card() + "_"
				+ jntciSelectPersonalInfo.getUserName() + "_テンプレート.xls";
		try {
			POIFSFileSystem fs = new POIFSFileSystem(new FileInputStream(
					realpath));
			HSSFWorkbook wb = new HSSFWorkbook(fs);

			// sheet1
			String username = jntciSelectPersonalInfo.getUserName();
			excels(map, wb, username);

			// 第三步：选择模板中名称为StateResult的Sheet：
			HSSFSheet sheet = wb.getSheetAt(0);
			Date nowTimeDate = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String nowTime = sdf.format(nowTimeDate);
			HSSFCell cell = sheet.getRow(0).getCell(3);
			cell.setCellValue(nowTime);
			cell = sheet.getRow(1).getCell(3);
			cell.setCellValue(jntciSelectPersonalInfo.getUserName());
			cell = sheet.getRow(2).getCell(3);
			cell.setCellValue(jntciSelectPersonalInfo.getJp_Name());
			cell = sheet.getRow(1).getCell(17);
			cell.setCellValue(jntciSelectPersonalInfo.getSex());
			cell = sheet.getRow(2).getCell(17);
			cell.setCellValue(jntciSelectPersonalInfo.getBirthdar());
			cell = sheet.getRow(3).getCell(17);
			cell.setCellValue(jntciSelectPersonalInfo.getNationality());
			cell = sheet.getRow(3).getCell(3);
			cell.setCellValue(jntciSelectPersonalInfo.getEducation());
			// 得意分野TECH_CAPABILITY
			cell = sheet.getRow(3).getCell(24);
			cell.setCellValue(jntciSelectPersonalInfo.getTech_capability());

			String workStr = jntciSelectPersonalInfo.getWork_Experience();

			int count = 0;
			int pmNum = 0;
			int leaderNum = 0;
			int seNum = 0;
			int pgNum = 0;
			if (workStr != null) {
				if (workStr.indexOf(",") > 0) {
					String[] strs = workStr.split(",");
					for (String s : strs) {
						String[] ms = s.split(":");
						if (ms.length > 1) {
							if ("PM".equals(ms[0])) {
								pmNum = pmNum + Integer.parseInt(ms[1].trim());
							}
							if ("Leader".equals(ms[0])) {
								leaderNum = leaderNum + Integer.parseInt(ms[1].trim());
							}
							if ("SE".equals(ms[0])) {
								seNum = seNum + Integer.parseInt(ms[1].trim());
							}
							if ("PG".equals(ms[0])) {
								pgNum = pgNum + Integer.parseInt(ms[1].trim());
							}
							count = count + Integer.parseInt(ms[1].trim());
							cell = sheet.getRow(2).getCell(24);
							cell.setCellValue(pmNum);
							cell = sheet.getRow(2).getCell(26);
							cell.setCellValue(leaderNum);
							cell = sheet.getRow(2).getCell(28);
							cell.setCellValue(seNum);
							cell = sheet.getRow(2).getCell(30);
							cell.setCellValue(pgNum);
						}

					}
				} else {
					String[] ms = workStr.split(":");
					if (ms.length > 1) {
						if ("PM".equals(ms[0])) {
							pmNum = Integer.parseInt(ms[1]);
						}
						if ("Leader".equals(ms[0])) {
							leaderNum = Integer.parseInt(ms[1]);
						}
						if ("SE".equals(ms[0])) {
							seNum = Integer.parseInt(ms[1]);
						}
						if ("PG".equals(ms[0])) {
							pgNum = Integer.parseInt(ms[1]);
						}

						cell = sheet.getRow(2).getCell(24);
						cell.setCellValue(pmNum);
						cell = sheet.getRow(2).getCell(26);
						cell.setCellValue(leaderNum);
						cell = sheet.getRow(2).getCell(28);
						cell.setCellValue(seNum);
						cell = sheet.getRow(2).getCell(30);
						cell.setCellValue(pgNum);
						count = Integer.parseInt(ms[1]);
					}
				}
			}
			cell = sheet.getRow(2).getCell(34);
			cell.setCellValue(count);

			// 写真
			if (jntciSelectPersonalInfo.getPhotoPath() != null) {
				File file = new File(uploadPath
						+ jntciSelectPersonalInfo.getPhotoPath());
				if (file.exists()) {
					insertImgToExcel(wb, file);
				}
			}

			if (qualificationTR != null) {
				int index = 5;
				for (SelectQualificationTR sqtr : qualificationTR) {
					cell = sheet.getRow(index).getCell(3);
					cell.setCellValue("受賞日付 : " + sqtr.getWinning_date()
							+ "           受賞証書 : "
							+ sqtr.getWinning_certificate());
					index++;
					if (index > 7) {
						break;
					}
				}
			}

			if (workExperience != null) {
				// 業種
				int index = 11;
				for (SelectWorkExperience swe : workExperience) {
					cell = sheet.getRow(index).getCell(1);
					cell.setCellValue(swe.getCareers_type());
					index += 3;
				}
				// プロジエクト名
				index = 13;
				for (SelectWorkExperience swe : workExperience) {
					cell = sheet.getRow(index).getCell(1);
					cell.setCellValue(swe.getProj_name());
					index += 3;
				}
				// 参加人数
				index = 11;
				for (SelectWorkExperience swe : workExperience) {
					cell = sheet.getRow(index).getCell(9);
					cell.setCellValue(swe.getAttend_nm() + "人 * "
							+ swe.getAttend_month() + "ヶ月");
					index += 3;
				}
				// 参加形態ATTEND_STATES
				index = 11;
				for (SelectWorkExperience swe : workExperience) {
					cell = sheet.getRow(index).getCell(11);
					cell.setCellValue(swe.getAttend_states());
					index += 3;
				}
				// 開発ﾌｪｰｽﾞDEVELOP_PHASE
				index = 11;
				for (SelectWorkExperience swe : workExperience) {
					cell = sheet.getRow(index).getCell(13);
					cell.setCellValue(swe.getAttend_states());
					index += 3;
				}
				// 業務内容FIRM_CONTENT
				index = 11;
				for (SelectWorkExperience swe : workExperience) {
					cell = sheet.getRow(index).getCell(15);
					cell.setCellValue(swe.getFirm_content());
					index += 3;
				}
				// 使用言語及びツールLANG_TOOL
				index = 11;
				for (SelectWorkExperience swe : workExperience) {
					cell = sheet.getRow(index).getCell(21);
					cell.setCellValue(swe.getLang_tool());
					index += 3;
				}
				// DB DATA_BASE
				index = 11;
				for (SelectWorkExperience swe : workExperience) {
					cell = sheet.getRow(index).getCell(25);
					cell.setCellValue(swe.getData_base());
					index += 3;
				}
				// OS TECHNICAL_SYS
				index = 11;
				for (SelectWorkExperience swe : workExperience) {
					cell = sheet.getRow(index).getCell(28);
					cell.setCellValue(swe.getTechnical_sys());
					index += 3;
				}
				// 機種及び使用デバイス MODEL_DEVICE
				index = 11;
				for (SelectWorkExperience swe : workExperience) {
					cell = sheet.getRow(index).getCell(31);
					cell.setCellValue(swe.getModel_device());
					index += 3;
				}
				// 開発担当期間 DEVELOP_PERIOD
				index = 13;
				for (SelectWorkExperience swe : workExperience) {
					cell = sheet.getRow(index).getCell(25);
					cell.setCellValue(swe.getDevelop_period());
					index += 3;
				}
				// 合計期間 TOTAL_PERIOD
				index = 13;
				for (SelectWorkExperience swe : workExperience) {
					cell = sheet.getRow(index).getCell(34);
					cell.setCellValue(swe.getTotal_period());
					index += 3;
				}
			}
			FileOutputStream out = new FileOutputStream(resultPath);
			wb.write(out);
			wb.close();
			out.close();
		} catch (Exception e) {
			e.printStackTrace();

		}

		BLogicResult result = new BLogicResult();
		File file = new File(resultPath);
		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		DownloadFile downloadFile = new DownloadFile(file);
		result.setResultObject(downloadFile);
		return result;
	}

	private void insertImgToExcel(HSSFWorkbook wb, File imgFile) {
		try {

			// 打开图片
			FileInputStream is = new FileInputStream(imgFile);
			byte[] bytes = IOUtils.toByteArray(is);
			// 增加图片到 Workbook
			int pictureIdx = wb.addPicture(bytes,
					HSSFWorkbook.PICTURE_TYPE_JPEG);
			is.close();
			// 写入辅助类
			CreationHelper helper = wb.getCreationHelper();
			// 获取sheet页
			HSSFSheet sheet = wb.getSheetAt(0);
			// 生成画笔
			Drawing drawing = sheet.createDrawingPatriarch();
			// 坐标
			ClientAnchor anchor = helper.createClientAnchor();
			// 设置图片位置
			// 定点
			anchor.setCol1(31);
			anchor.setRow1(5);
			// 微调
			anchor.setDx1(50);
			anchor.setDy1(25);
			// 生成图片
			Picture pict = drawing.createPicture(anchor, pictureIdx);
			pict.resize(4, 3.2);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 录入信息
	public void excels(Map<String, JNTCISelectPersonalSkillInfo> map,
			HSSFWorkbook wb, String username) {
		int j = 7;
		String[] str = { "eng", "jap", "C", "C++", "C#", "ASP", "Delphi",
				"HTML", "XML", "Cobol", "VBNET", "PHP", "Android", "Objectc",
				"JAVA", "WebLogic", "WebShpere", "TomCat", "null", "Sprogram",
				"Servlet", "JSP", "Beans", "JDBC", "EJB", "null", "VisualC",
				"VisualBasic", "Jbuilder", "TL-Delphi", "MicrosoftAccess",
				"Developer2000", "PowerBuiler", "Eclipse", "Xcode",
				"PhotoShop", "null", "DB2", "Oracle", "SQLServer", "Tuning",
				"DBinviro", "DBOpera", "SQLgern", "PLSQL", "PostgreSQL",
				"MYSQL", "Sqlite", "HiRDB", "UNIXRedhat", "UNIXSolaris",
				"UNIXHPUX", "UNIXLinux", "WindowsNTServer",
				"WindowsServer2003", "WindowsXP", "WindwosVista", "MacOS",
				"OSAndroid", "IOS" };

		HSSFSheet sheeta = wb.getSheetAt(1);
		HSSFCell cell = sheeta.getRow(0).getCell(3);
		cell.setCellValue(username);

		HSSFSheet sheetl = wb.getSheetAt(1);
		for (int i = 0; i < str.length; i++) {
			j++;
			JNTCISelectPersonalSkillInfo jf = (JNTCISelectPersonalSkillInfo) map
					.get(str[i]);
			if (jf != null) {
				String laname = jf.getSoftwarename();
				if ("jap".equals(laname)) {
					String jpanese = jf.getSorts();
					if (jpanese != null) {
						String[] st = jpanese.trim().split("-");

						for (int n = 0; n < st.length; n++) {
							if ("4".equals(st[n])) {
								cell = sheetl.getRow(3).getCell(3);
								cell.setCellValue("○");

							} else if ("5".equals(st[n])) {
								cell = sheetl.getRow(4).getCell(3);
								cell.setCellValue("○");

							} else if ("6".equals(st[n])) {
								cell = sheetl.getRow(5).getCell(3);
								cell.setCellValue("○");

							} else if ("7".equals(st[n])) {
								cell = sheetl.getRow(6).getCell(3);
								cell.setCellValue("○");

							} else if ("8".equals(st[n])) {
								cell = sheetl.getRow(7).getCell(3);
								cell.setCellValue("○");
							}
						}

						continue;
					}
				} else if ("eng".equals(laname)) {
					String english = jf.getSorts();
					if (english != null) {
						String[] st = english.trim().split("-");

						for (int n = 0; n < st.length; n++) {
							if ("4".equals(st[n])) {
								cell = sheetl.getRow(3).getCell(10);
								cell.setCellValue("○");

							} else if ("5".equals(st[n])) {
								cell = sheetl.getRow(4).getCell(10);
								cell.setCellValue("○");

							} else if ("6".equals(st[n])) {
								cell = sheetl.getRow(5).getCell(10);
								cell.setCellValue("○");

							} else if ("7".equals(st[n])) {
								cell = sheetl.getRow(6).getCell(10);
								cell.setCellValue("○");

							} else if ("8".equals(st[n])) {
								cell = sheetl.getRow(7).getCell(10);
								cell.setCellValue("○");
							}
						}
						continue;
					}
				}
				cell = sheetl.getRow(j).getCell(14);
				cell.setCellValue(jf.getSoftwarename());
				cell = sheetl.getRow(j).getCell(27);
				cell.setCellValue(jf.getSkill_level());
				cell = sheetl.getRow(j).getCell(30);
				cell.setCellValue(jf.getExperienceyears());
			}

		}
	}

}
