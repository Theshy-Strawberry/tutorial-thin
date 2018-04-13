package jp.terasoluna.thin.tutorial.web.transcosmos.blogic;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import jp.terasoluna.fw.dao.QueryDAO;
import jp.terasoluna.fw.service.thin.BLogic;
import jp.terasoluna.fw.service.thin.BLogicMessage;
import jp.terasoluna.fw.service.thin.BLogicMessages;
import jp.terasoluna.fw.service.thin.BLogicResult;
import jp.terasoluna.fw.web.struts.actions.DownloadFile;
import jp.terasoluna.thin.tutorial.web.transcosmos.dto.JNTCIVocationInput;
import jp.terasoluna.thin.tutorial.web.transcosmos.dto.JNTCIVocationOutput;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;





public class JNTCIVocationdownloadBlogic implements BLogic<JNTCIVocationInput> {
	public QueryDAO queryDAO = null;

	public void setQueryDAO(QueryDAO queryDAO) {
		this.queryDAO = queryDAO;
	}



	public BLogicResult execute(JNTCIVocationInput param) {
		String flag = param.getFlag();
		BLogicResult result = new BLogicResult();
		if("0".equals(flag) || "2".equals(flag)){

		String realpath = this.getClass().getClassLoader().getResource("")
				.getPath()
				+ "vocation.xls";
		List<JNTCIVocationOutput> vocation = queryDAO.executeForObjectList(
				"downloadvocation", null);
		String resultPath = "社員年休" + ".xls";
		try {
			POIFSFileSystem fs = new POIFSFileSystem(new FileInputStream(
					realpath));
			HSSFWorkbook wb = new HSSFWorkbook(fs);
			HSSFRow row = null;
			HSSFSheet sheet = wb.getSheetAt(0);
			for (int i = 0; i < vocation.size(); i++) {
				row=sheet.getRow(i+3);
				row.getCell(0).setCellValue(i + 1);
				row.getCell(1).setCellValue(vocation.get(i).getUserId());
				row.getCell(2).setCellValue(vocation.get(i).getUserName());
				row.getCell(3).setCellValue(vocation.get(i).getUserSex());
				row.getCell(4).setCellValue(vocation.get(i).getDeptId());
				row.getCell(5).setCellValue(vocation.get(i).getHOLIDAY_DAYS());
				row.getCell(6).setCellValue(vocation.get(i).getREMAIN_DAYS());
				row.getCell(7).setCellValue(vocation.get(i).getJanuary());
				row.getCell(8).setCellValue(vocation.get(i).getFebruary());
				row.getCell(9).setCellValue(vocation.get(i).getMarch());
				row.getCell(10).setCellValue(vocation.get(i).getApril());
				row.getCell(11).setCellValue(vocation.get(i).getMay());
				row.getCell(12).setCellValue(vocation.get(i).getJune());
				row.getCell(13).setCellValue(vocation.get(i).getJuly());
				row.getCell(14).setCellValue(vocation.get(i).getAugust());
				row.getCell(15).setCellValue(vocation.get(i).getSeptember());
				row.getCell(16).setCellValue(vocation.get(i).getOctorber());
				row.getCell(17).setCellValue(vocation.get(i).getNovember());
				row.getCell(18).setCellValue(vocation.get(i).getDecember());
			}
			row = sheet.getRow(0);
			row.getCell(0).setCellValue( "社員年休表");
			FileOutputStream out = new FileOutputStream(resultPath);
			wb.write(out);
			wb.close();
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
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
	}else{
		BLogicMessages messages = new BLogicMessages();
		messages.add("message", new BLogicMessage("errors.download.error", null, null));
		result.setErrors(messages);
		result.setResultString("fail");
		return result;
	}
}
}