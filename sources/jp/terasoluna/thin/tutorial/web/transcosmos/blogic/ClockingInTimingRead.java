package jp.terasoluna.thin.tutorial.web.transcosmos.blogic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import jp.terasoluna.fw.dao.QueryDAO;
import jp.terasoluna.fw.dao.UpdateDAO;
import jp.terasoluna.thin.tutorial.web.transcosmos.vo.JNTCISelectPersonalInfo;

public class ClockingInTimingRead {

    private QueryDAO queryDAO = null;
    private UpdateDAO updateDAO;

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

    private SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd");

    public void timingRead() {
        // 获取系统日期前一天
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.DAY_OF_MONTH, -1);
        Date dateBe = calendar.getTime();
        String date = df.format(dateBe);
        // 拷贝并读取考勤MDB文件中的数据，导入数据库
        Properties prop = new Properties();
        prop.put("charSet", System.getProperty("file.encoding")); // 这里是解决中文乱码
        prop.put("user", "");
        prop.put("password", "");
        String url = "jdbc:odbc:driver={Microsoft Access Driver (*.mdb)};DBQ=E://123.mdb";
        Statement stmt = null;
        ResultSet rs = null;
        try {
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            // 连接到mdb文件
            Connection conn = DriverManager.getConnection(url, prop);
            stmt = (Statement) conn.createStatement();

            // 获取考勤ID
            int attendance_id = queryDAO.executeForObject("GetAttendanceId", 0,
                    Integer.class);
            // 获取员工信息
            List<JNTCISelectPersonalInfo> jntciSelectPersonalInfo = queryDAO
                    .executeForObjectList("GetDetailedInfo", 0);
            for (int i = 0; i < jntciSelectPersonalInfo.size(); i++) {
                attendance_id++;
                String id_card = jntciSelectPersonalInfo.get(i).getJn_Card();
                // 读取表的内容
                rs = stmt.executeQuery("SELECT " + "CHECKINOUT.CHECKTIME,"
                        + "CHECKINOUT.SENSORID," + "USERINFO.BADGENUMBER "
                        + "FROM CHECKINOUT LEFT JOIN USERINFO "
                        + "ON CHECKINOUT.USERID = USERINFO.USERID "
                        + "WHERE USERINFO.BADGENUMBER = '" + id_card + "' "
                        + "AND CHECKINOUT.CHECKTIME LIKE '%" + date + "%' "
                        + "ORDER BY CHECKINOUT.CHECKTIME");
                // 第一次打卡时间
                String firstCheckTime = "";
                // 最后一次打卡时间
                String lastCheckTime = "";
                // 机器码
                String sensorId = "";
                if (rs.next()) {
                    firstCheckTime = rs.getString(1);
                    sensorId = rs.getString(2);
                }
                while (rs.next()) {
                    String checkTime = rs.getString(1);
                    String machine_no = rs.getString(2);
                    if (!rs.next()) {
                        lastCheckTime = checkTime;
                        sensorId = sensorId + "," + machine_no;
                    }
                }
                if (rs.getRow() == 1) {
                    int hours = Integer.parseInt(firstCheckTime.substring(11,
                            13));
                    if (hours >= 12 && hours <= 23) {
                        lastCheckTime = firstCheckTime;
                        firstCheckTime = "";
                    }
                }
                Map<String, Object> map = new HashMap<String, Object>();
                map.put("attendance_id", attendance_id);
                map.put("jn_card", id_card);
                map.put("name", jntciSelectPersonalInfo.get(i).getUserName());
                map.put("dept_id", jntciSelectPersonalInfo.get(i)
                        .getDepartment());
                map.put("start_time", firstCheckTime);
                map.put("end_time", lastCheckTime);
                map.put("machine_no", sensorId);
                updateDAO.execute("InsertAttendance", map);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
