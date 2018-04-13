package jp.terasoluna.thin.tutorial.web.transcosmos.blogic;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

import jp.terasoluna.fw.dao.QueryDAO;
import jp.terasoluna.fw.service.thin.BLogic;
import jp.terasoluna.fw.service.thin.BLogicResult;
import jp.terasoluna.fw.web.struts.actions.DownloadFile;
import jp.terasoluna.thin.tutorial.web.common.controller.DateController;
import jp.terasoluna.thin.tutorial.web.transcosmos.dto.JNTCIAttendance04selectInfo;
import jp.terasoluna.thin.tutorial.web.transcosmos.dto.JNTCIAttendance04selectInput;

public class JNTCIAttendance04downloadBLogic implements BLogic<JNTCIAttendance04selectInput> {

	private QueryDAO queryDAO = null;

	public void setQueryDAO(QueryDAO queryDAO) {
		this.queryDAO = queryDAO;
	}

	public BLogicResult execute(JNTCIAttendance04selectInput param) {

		List<JNTCIAttendance04selectInfo> status_List = queryDAO.executeForObjectList("AgreeExamineStatus", null);
		// 选择模板文件：
		String realpath = this.getClass().getClassLoader().getResource("").getPath() + "AnnualLeave.xls";
		String time = DateController.getDateToString(new Date(),
				DateController.YMDHMSS);
		String resultPath = "AnnualLeave" + time + ".xls";
		try {
			POIFSFileSystem fs = new POIFSFileSystem(new FileInputStream(
					realpath));
			HSSFWorkbook wb = new HSSFWorkbook(fs);
			// 第三步：选择模板中名称为StateResult的Sheet：
			HSSFSheet sheet = wb.getSheetAt(1);
			HSSFRow row = null;
			for (int i = 0; i < status_List.size(); i++) {
				 row = sheet.getRow(i+3);
					row.getCell(0).setCellValue(status_List.get(i).getJn_card());
					row.getCell(1).setCellValue(status_List.get(i).getName());
					row.getCell(2).setCellValue(status_List.get(i).getProject_pm());
					row.getCell(3).setCellValue(status_List.get(i).getExamine_person());
					String[] status_start = status_List.get(i).getLeave_starttime().split(":");
					String start =null;
					if(status_start[1].length()==1){
						status_start[1]="0"+status_start[1];
						start =status_start[0]+":"+status_start[1];
					}else{
					start =status_start[0]+":"+status_start[1];
					}
					String[] status_end = status_List.get(i).getLeave_endtime().split(":");
					String end=null;
					if(status_end[1].length()==1){
						status_end[1]="0"+status_end[1];
						end =status_end[0]+":"+status_end[1];
					}else{
						end =status_end[0]+":"+status_end[1];
					}
					row.getCell(4).setCellValue(start+" / "+end);
					row.getCell(5).setCellValue(status_List.get(i).getLeave_totaltime());
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
		file.getAbsolutePath();
		try {
			file.getCanonicalPath();
		} catch (IOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		DownloadFile downloadFile = new DownloadFile(file);
		result.setResultObject(downloadFile);
		//result.setResultString("success");
		return result;
	}
}
