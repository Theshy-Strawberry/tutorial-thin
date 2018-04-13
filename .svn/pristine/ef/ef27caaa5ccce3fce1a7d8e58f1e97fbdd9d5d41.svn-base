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
import jp.terasoluna.fw.dao.UpdateDAO;
import jp.terasoluna.fw.service.thin.BLogic;
import jp.terasoluna.fw.service.thin.BLogicMessage;
import jp.terasoluna.fw.service.thin.BLogicMessages;
import jp.terasoluna.fw.service.thin.BLogicResult;
import jp.terasoluna.fw.web.struts.actions.DownloadFile;
import jp.terasoluna.thin.tutorial.web.common.controller.DateController;
import jp.terasoluna.thin.tutorial.web.common.controller.Vocation;
import jp.terasoluna.thin.tutorial.web.transcosmos.dto.JNTCIQueryOutput;
import jp.terasoluna.thin.tutorial.web.transcosmos.vo.JNTCIVocationVo;
import jp.terasoluna.thin.tutorial.web.transcosmos.vo.JNTCIparam;

public class JNTCIAttendanceDownloadBlogic implements BLogic<JNTCIQueryOutput> {
	public QueryDAO queryDAO = null;

	public void setQueryDAO(QueryDAO queryDAO) {
		this.queryDAO = queryDAO;
	}

	public UpdateDAO updateDAO = null;

	public UpdateDAO getUpdateDAO() {
		return updateDAO;
	}

	public void setUpdateDAO(UpdateDAO updateDAO) {
		this.updateDAO = updateDAO;
	}
	public BLogicResult execute(JNTCIQueryOutput param) {

		String flag = param.getFlag();
		BLogicResult result = new BLogicResult();

		if("0".equals(flag) || "2".equals(flag)){
		List<JNTCIQueryOutput> tempList = param.getTempList();
		String[] ym = param.getYm().split("/");
		String month = ym[1];
		// 选择模板文件：
		String realpath = this.getClass().getClassLoader().getResource("")
				.getPath()
				+ "attence.xls";
		String time = DateController.getDateToString(new Date(),
				DateController.YMDHMSS);
		String resultPath = "考勤" + time + ".xls";
		try {
			POIFSFileSystem fs = new POIFSFileSystem(new FileInputStream(
					realpath));
			HSSFWorkbook wb = new HSSFWorkbook(fs);
			// 第三步：选择模板中名称为StateResult的Sheet：
			HSSFSheet sheet = wb.getSheetAt(1);
			HSSFRow row = null;
			double extra_timeSum = 0;// 所有员工平时加班时间汇总
			int extra_time_countSum = 0;// 所有员工平时加班时间大于2.5小时的天数
			double week_extra_timeSum = 0;// 所有员工周末加班时间汇总
			double hld_extra_timeSum = 0;// 所有员工节假日加班时间汇总
			int week_extra_time_countSum = 0;// 所有员工周末和节假日加班时间大于5小时的天数
			double comelateSum = 0;// 所有员工迟到时间汇总
			double TotalOvertimeWorkSum = 0;// 所有员工综合工时加班小时数
			double leave_countSum = 0;// 所有员工请假总时间
			double specialHolidaysSumSum = 0;// 所有员工特殊假期和
			int hangoverSum = 0;// 所有员工存在旷工的天数

			// 查询年休
			List<JNTCIVocationVo> vocationList = queryDAO.executeForObjectList(
					"nianxiu", null);

			for (int i = 0; i < tempList.size(); i++) {
				row=sheet.getRow(i+3);
				row.getCell(0).setCellValue(i + 1);
				row.getCell(1).setCellValue(tempList.get(i).getTj_card());
				row.getCell(2).setCellValue(tempList.get(i).getUsername());
				row.getCell(3).setCellValue(tempList.get(i).getExtra_time());
				extra_timeSum += tempList.get(i).getExtra_time();
				row.getCell(4).setCellValue(
						tempList.get(i).getExtra_time_count());
				extra_time_countSum += tempList.get(i).getExtra_time_count();
				row.getCell(5).setCellValue(
						tempList.get(i).getWeek_extra_time());
				week_extra_timeSum += tempList.get(i).getWeek_extra_time();
				row.getCell(6)
						.setCellValue(tempList.get(i).getHld_extra_time());
				hld_extra_timeSum += tempList.get(i).getHld_extra_time();
				row.getCell(7).setCellValue(
						tempList.get(i).getWeek_extra_time_count());
				week_extra_time_countSum += tempList.get(i)
						.getWeek_extra_time_count();
				row.getCell(9).setCellValue(
						tempList.get(i).getExtra_time()
								+ tempList.get(i).getWeek_extra_time()
								+ tempList.get(i).getHld_extra_time());
				TotalOvertimeWorkSum += tempList.get(i).getExtra_time()
						+ tempList.get(i).getWeek_extra_time()
						+ tempList.get(i).getHld_extra_time();
				double specialHolidaysSum =
						tempList.get(i).getLeave_count2()
						+ tempList.get(i).getLeave_count3()
						+ tempList.get(i).getLeave_count4()
						+ tempList.get(i).getLeave_count5()
						+ tempList.get(i).getLeave_count6()
						+ tempList.get(i).getLeave_count7()
						+ tempList.get(i).getLeave_count8()
						+ tempList.get(i).getLeave_count9();
				row.getCell(11).setCellValue(specialHolidaysSum);
				specialHolidaysSumSum += specialHolidaysSum;
				row.getCell(12).setCellValue(tempList.get(i).getHangover());
				hangoverSum += tempList.get(i).getHangover();
				row.getCell(8).setCellValue(tempList.get(i).getComelate());
                comelateSum += tempList.get(i).getComelate();
                row.getCell(10).setCellValue(tempList.get(i).getOvercountbf());
                double overCountAf = tempList.get(i).getOvercountbf();
                for (int j = 0; j < vocationList.size(); j++) {
					if (tempList.get(i).getJn_card()
							.equals(vocationList.get(j).getUSER_ID())) {
						JNTCIparam holList = Vocation.getHolidaysAf(
								vocationList.get(j), param.getYm());
						// 操作月份抵扣的年休时长
						double holidays = holList.getHolidays();
						double remain_time = 0;
						double holcount = 0;
						// 年休剩余时长
						double remain_days = vocationList.get(j)
								.getRemain_days();
						double count = holidays + remain_days;
						if (count >= tempList.get(i).getOvercountbf()) {
							row.getCell(8).setCellValue(0);
							comelateSum += 0;
							row.getCell(10).setCellValue(0);
							overCountAf = 0;
							holcount = tempList.get(i).getOvercountbf();
							remain_time = count - holcount;
						}else if(count < tempList.get(i).getOvercountbf() && count >= (tempList.get(i).getLeave_count1() + tempList.get(i).getComelate())){
							row.getCell(8).setCellValue(0);
							comelateSum += 0;
							row.getCell(10).setCellValue(tempList.get(i).getOvercountbf() - count);
							overCountAf = tempList.get(i).getOvercountbf() - count;
							holcount = count;
							remain_time = 0;
						}else if(count < (tempList.get(i).getLeave_count1() + tempList.get(i).getComelate()) && count >= tempList.get(i).getLeave_count1()){
							row.getCell(8).setCellValue(tempList.get(i).getLeave_count1() + tempList.get(i).getComelate() - count);
							comelateSum += tempList.get(i).getLeave_count1() + tempList.get(i).getComelate() - count;
							row.getCell(10).setCellValue(tempList.get(i).getOvercountbf() - count);
							overCountAf = tempList.get(i).getOvercountbf() - count;
							holcount = count;
							remain_time = 0;
						}else if(count < tempList.get(i).getLeave_count1()){
							row.getCell(8).setCellValue(tempList.get(i).getComelate());
							comelateSum += tempList.get(i).getComelate();
							row.getCell(10).setCellValue(tempList.get(i).getOvercountbf() - count);
							overCountAf = tempList.get(i).getOvercountbf() - count;
							holcount = count;
							remain_time = 0;
						}
						JNTCIVocationVo vocationParam = Vocation.getUpdateVaction(vocationList.get(j), holList.getMonth(), holcount, remain_time);
						updateDAO.execute("alterVocation", vocationParam);
					}
				}
                leave_countSum += overCountAf;
			}
			row = sheet.getRow(0);
			row.getCell(0).setCellValue(month + "月月度考勤结算表");
			// 合计所在行
			row = sheet.getRow(219);
			// 合计数据
			row.getCell(3).setCellValue(extra_timeSum);
			row.getCell(4).setCellValue(extra_time_countSum);
			row.getCell(5).setCellValue(week_extra_timeSum);
			row.getCell(6).setCellValue(hld_extra_timeSum);
			row.getCell(7).setCellValue(week_extra_time_countSum);
			row.getCell(8).setCellValue(comelateSum);
			row.getCell(9).setCellValue(TotalOvertimeWorkSum);
			row.getCell(10).setCellValue(leave_countSum);
			row.getCell(11).setCellValue(specialHolidaysSumSum);
			row.getCell(12).setCellValue(hangoverSum);
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