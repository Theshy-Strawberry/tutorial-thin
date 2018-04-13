package jp.terasoluna.thin.tutorial.web.common.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import jp.terasoluna.thin.tutorial.web.transcosmos.vo.JNTCIAttendanceVo;

public class LeaveDetail {

    public static List<JNTCIAttendanceVo> getAttendance(String leave_id,
            String start, String end, double exCount, String type, List<Date> holidaylist) {

        // 将传入的时间变为yyyy/MM/dd HH:mm:ss格式的
        start = start.replace("-", "/");
        end = end.replace("-", "/");
        String[] startTime = start.split(" ");
        String[] endTime = end.split(" ");
        start = startTime[0] + " " + startTime[startTime.length - 1] + ":00";
        end = endTime[0] + " " + endTime[endTime.length - 1] + ":00";

        // 将时间变为yyyy/MM/dd格式的
        String startYMD = GetWorkDay.getYearMonthDay(start);
        String endYMD = GetWorkDay.getYearMonthDay(end);

        // 创建返回结果集
        List<JNTCIAttendanceVo> detailList = new ArrayList<JNTCIAttendanceVo>();

        int i = 0;
        // 请假开始时间与结束时间在同一天的情况
        if (startYMD.compareTo(endYMD) == 0) {
            // 判断请假日是不是工作日
            int tempCount = GetWorkDay.workDays(startYMD, endYMD, holidaylist);
            if (tempCount > 0) {
                // 创建返回结果对象
                JNTCIAttendanceVo param = new JNTCIAttendanceVo();
                param.setLEAVE_ID(leave_id);
                param.setLEAVE_YMD(startYMD);
                param.setLEAVE_START(start);
                param.setLEAVE_END(end);
                param.setLEAVE_COUNT(exCount);
                param.setLEAVE_TYPE(type);
                detailList.add(i, param);
            }
            return detailList;
        }

        String dates = startYMD;
        String dateend = end;
        // 取得该条记录的每日请假时长
        double count = 0;
        while (endYMD.compareTo(startYMD) >= 0) {
            // 判断请假日是不是工作日
            int tempCount = GetWorkDay
                    .workDays(startYMD, startYMD, holidaylist);
            // 创建返回结果对象
            JNTCIAttendanceVo param = new JNTCIAttendanceVo();
            if (tempCount > 0) {
                if (startYMD.compareTo(dates) == 0) {
                    end = startYMD + " 17:30:00";
                    count = TimeCompare.getTimeCount(start, end);
                } else if (startYMD.compareTo(endYMD) == 0) {
                    start = startYMD + " 08:30:00";
                    end = dateend;
                    count = TimeCompare.getTimeCount(start, end);

                } else {
                    start = startYMD + " 08:30:00";
                    end = startYMD + " 17:30:00";
                    count = 8;
                }
                param.setLEAVE_ID(leave_id);
                param.setLEAVE_YMD(startYMD);
                param.setLEAVE_START(start);
                param.setLEAVE_END(end);
                param.setLEAVE_COUNT(count);
                param.setLEAVE_TYPE(type);
                detailList.add(i, param);
                i++;
            }
            startYMD = GetWorkDay.getNextDay(startYMD);
        }
        return detailList;
    }
}
