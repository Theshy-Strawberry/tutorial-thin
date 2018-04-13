package jp.terasoluna.thin.tutorial.web.transcosmos.blogic;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import jp.terasoluna.fw.dao.QueryDAO;
import jp.terasoluna.fw.service.thin.BLogic;
import jp.terasoluna.fw.service.thin.BLogicResult;
import jp.terasoluna.fw.web.struts.actions.DownloadFile;
import jp.terasoluna.thin.tutorial.web.common.controller.DateController;
import jp.terasoluna.thin.tutorial.web.transcosmos.dto.JNTICIEmpPositionDownloadInput;
import jp.terasoluna.thin.tutorial.web.transcosmos.dto.JNTICIEmpPositionDownloadOutput;

public class JNTCIEmpPositionDownloadBLogic implements
		BLogic<JNTICIEmpPositionDownloadInput> {

	private QueryDAO queryDAO = null;

	public void setQueryDAO(QueryDAO queryDAO) {
		this.queryDAO = queryDAO;
	}

	public BLogicResult execute(JNTICIEmpPositionDownloadInput param) {

		// 個人基本情報
		List<JNTICIEmpPositionDownloadOutput> jntciEmpPositionlInfo = queryDAO
				.executeForObjectList("selectNameInfoList", null);

		// 选择模板文件：
		String realpath = this.getClass().getClassLoader().getResource("")
				.getPath()
				+ "empposition.xls";
		String time = DateController.getDateToString(new Date(),
				DateController.YMDHMSS);
		String resultPath = "座席図_テンプレート" + time + ".xls";
		try {
			POIFSFileSystem fs = new POIFSFileSystem(new FileInputStream(
					realpath));
			HSSFWorkbook wb = new HSSFWorkbook(fs);
			// 第三步：选择模板中名称为StateResult的Sheet：
			HSSFSheet sheet = wb.getSheetAt(1);
			HSSFCell cell = null;
			int shiwei = 0;
			for (int i = 0; i < jntciEmpPositionlInfo.size(); i++) {
				int excel_position_y = Integer.parseInt(jntciEmpPositionlInfo
						.get(i).getExcel_Position_y());
				String excel_position_x = jntciEmpPositionlInfo.get(i)
						.getExcel_Position_x();

				if (excel_position_x.length() > 1) {
					shiwei = (excel_position_x.substring(0, 1).hashCode() - 64)
							* 26 + excel_position_x.substring(1, 2).hashCode()
							- 65;
				} else {
					shiwei = excel_position_x.hashCode() - 65;
				}
				cell = sheet.getRow(excel_position_y - 1).getCell(shiwei);
				cell.setCellValue(jntciEmpPositionlInfo.get(i).getUser_Name());
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
}
