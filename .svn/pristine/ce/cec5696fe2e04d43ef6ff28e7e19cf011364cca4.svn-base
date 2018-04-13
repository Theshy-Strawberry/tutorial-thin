package jp.terasoluna.thin.tutorial.web.transcosmos.blogic;

import java.io.IOException;
import java.io.InputStream;

import jp.terasoluna.fw.dao.QueryDAO;
import jp.terasoluna.fw.dao.UpdateDAO;
import jp.terasoluna.fw.service.thin.BLogic;
import jp.terasoluna.fw.service.thin.BLogicMessage;
import jp.terasoluna.fw.service.thin.BLogicMessages;
import jp.terasoluna.fw.service.thin.BLogicResult;
import jp.terasoluna.thin.tutorial.web.transcosmos.dto.JNTCIImportDataInput;
import jp.terasoluna.thin.tutorial.web.transcosmos.dto.JNTCIQueryInput;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.struts.upload.FormFile;

public class JNTCIimportdataBlogic implements BLogic<JNTCIQueryInput> {

	private QueryDAO queryDAO = null;
	private UpdateDAO updateDAO = null;
	POIFSFileSystem fs;
	HSSFWorkbook wb;
	HSSFSheet sheet;
	HSSFRow row;

	public BLogicResult execute(JNTCIQueryInput param) {
		String flag = param.getFlag();
		BLogicResult result = new BLogicResult();
		if(!flag.equals("2")  && !flag.equals("0")){
			BLogicMessages messages = new BLogicMessages();
			messages.add("message", new BLogicMessage("errors.qxerror", null, null));
			result.setErrors(messages);
			result.setResultString("qxfail");
			return result;
		}else{
		String filename = param.getFile().getFileName();// 获取文件名
		int count = filename.lastIndexOf(".");
		String ExtensionName = filename.substring(count + 1, filename.length());// 得到文件扩展名
		if (!"xls".equals(ExtensionName)) {
			BLogicMessages messages = new BLogicMessages();
			messages.add("message", new BLogicMessage("errors.importfileformat", null, null));
			result.setErrors(messages);
			result.setResultString("fail");
			return result;
		} else {
			FormFile formFile = param.getFile();
			try {
				InputStream fileInputStream = formFile.getInputStream();
				fs = new POIFSFileSystem(fileInputStream);
				wb = new HSSFWorkbook(fs);
			} catch (IOException e) {
				e.printStackTrace();
			}
			 updateDAO.execute("CleanTemporaryTable", null);
			for (int j = 0; j < wb.getNumberOfSheets(); j++) {
				sheet = wb.getSheetAt(j);
				// 得到总行数
				int rowNum = sheet.getLastRowNum();
				row = sheet.getRow(0);
				// 正文内容应该从第二行开始,第一行为表头的标题
				for (int i = 1; i <= rowNum; i++) {
					row = sheet.getRow(i);
					JNTCIImportDataInput fileinfo = new JNTCIImportDataInput();
					if (row != null) {
						if (row.getCell(3) != null && row.getCell(2) != null
								&& !"".equals(row.getCell(3))
								&& !"".equals(row.getCell(2))) {
							String carddatestring = row.getCell(3).toString().trim();
							String jncardstr = row.getCell(2).toString().trim();
							if (carddatestring.contains(" ")
									&& carddatestring.contains("/")
									&& carddatestring.contains(":")
									&& jncardstr.length() == 4) {
								fileinfo.setJn_card(jncardstr);
								String[] date = carddatestring.split(" ");
								String ymd = date[0];// 年月日
								String[] ymds = ymd.split("/");
								String month = ymds[1];
								String day = ymds[2];
								if (month.length() <= 1) {
									month = "0" + month;
								}
								if (day.length() <= 1) {
									day = "0" + day;
								}
								String hms = date[1];// 时分秒
								String[] hmss = hms.split(":");
								String hour = hmss[0];
								String Minute = hmss[1];
								String second = hmss[2];
								if (hour.length() <= 1) {
									hour = "0" + hour;
								}
								if (Minute.length() <= 1) {
									Minute = "0" + Minute;
								}
								if (second.length() <= 1) {
									second = "0" + second;
								}
								carddatestring = ymds[0] + "/" + month + "/"
										+ day + " " + hour + ":" + Minute + ":"
										+ second;
								fileinfo.setWork_date(ymds[0] + "/" + month+ "/" + day);
								fileinfo.setCar_date(carddatestring);
								updateDAO.execute("InsertWorkDate", fileinfo);
								BLogicMessages messages = new BLogicMessages();
								messages.add("message", new BLogicMessage(
										"message.importdata.success"));
								result.setMessages(messages);
								result.setResultString("success");
							} else {
								result.setResultString("fail");
								BLogicMessages messages = new BLogicMessages();
								messages.add("message", new BLogicMessage("errors.importfilevalue", null, null));
								result.setErrors(messages);
							}
						}
					}else{
						continue;
					}
				}
			}
		}
			return result;
		}

	}

	public QueryDAO getQueryDAO() {
		return queryDAO;
	}

	public void setQueryDAO(QueryDAO queryDAO) {
		this.queryDAO = queryDAO;
	}

	public UpdateDAO getUpdateDAO() {
		return updateDAO;
	}

	public void setUpdateDAO(UpdateDAO updateDAO) {
		this.updateDAO = updateDAO;
	}

}