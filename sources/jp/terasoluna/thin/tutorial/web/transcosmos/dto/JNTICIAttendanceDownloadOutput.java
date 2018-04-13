package jp.terasoluna.thin.tutorial.web.transcosmos.dto;

public class JNTICIAttendanceDownloadOutput {

	//卡号
	  private String tj_card;
	//姓名
	 private String username;
	//平日加班小时数
	private double extra_time;//平时加班时间汇总
	//公休日加班小时数
	private double week_extra_time;//周末加班时间汇总
	//迟到/早退合计
	 private double comelate;
	//综合工时加班小时数
	 double TotalOvertimeWork;
	//事假小时数
	 String LeaveSun;
	 //特殊假小时数（所有特殊假）
	 String specialHolidaysSum;
	//餐补次数
	 String MealSupplement;
	 private double extra_time_count;//平时加班时间大于2.5小时的天数
	 private double hld_extra_time;//周末和节假日加班时间大于5小时的天数
		//旷工小时数
		private double hangover;//存在旷工的天数


	    private double week_extra_time_count;//节假日加班时间汇总

	    private double leave_count;//请假总时间
	    private double kojyo_time;//补卡扣除总时间
	    private int ijyou_flag;//异常flag

	    private double overcount;//扣除总时间
		public String getTj_card() {
			return tj_card;
		}
		public void setTj_card(String tj_card) {
			this.tj_card = tj_card;
		}
		public String getUsername() {
			return username;
		}
		public void setUsername(String username) {
			this.username = username;
		}
		public double getComelate() {
			return comelate;
		}
		public void setComelate(double comelate) {
			this.comelate = comelate;
		}
		public double getExtra_time() {
			return extra_time;
		}
		public void setExtra_time(double extra_time) {
			this.extra_time = extra_time;
		}
		public double getExtra_time_count() {
			return extra_time_count;
		}
		public void setExtra_time_count(double extra_time_count) {
			this.extra_time_count = extra_time_count;
		}
		public double getWeek_extra_time() {
			return week_extra_time;
		}
		public void setWeek_extra_time(double week_extra_time) {
			this.week_extra_time = week_extra_time;
		}
		public double getWeek_extra_time_count() {
			return week_extra_time_count;
		}
		public void setWeek_extra_time_count(double week_extra_time_count) {
			this.week_extra_time_count = week_extra_time_count;
		}
		public double getHld_extra_time() {
			return hld_extra_time;
		}
		public void setHld_extra_time(double hld_extra_time) {
			this.hld_extra_time = hld_extra_time;
		}
		public double getLeave_count() {
			return leave_count;
		}
		public void setLeave_count(double leave_count) {
			this.leave_count = leave_count;
		}
		public double getKojyo_time() {
			return kojyo_time;
		}
		public void setKojyo_time(double kojyo_time) {
			this.kojyo_time = kojyo_time;
		}
		public int getIjyou_flag() {
			return ijyou_flag;
		}
		public void setIjyou_flag(int ijyou_flag) {
			this.ijyou_flag = ijyou_flag;
		}
		public double getHangover() {
			return hangover;
		}
		public void setHangover(double hangover) {
			this.hangover = hangover;
		}
		public double getOvercount() {
			return overcount;
		}
		public void setOvercount(double overcount) {
			this.overcount = overcount;
		}
		public double getTotalOvertimeWork() {
			return TotalOvertimeWork;
		}
		public void setTotalOvertimeWork(double totalOvertimeWork) {
			TotalOvertimeWork = totalOvertimeWork;
		}
		public String getLeaveSun() {
			return LeaveSun;
		}
		public void setLeaveSun(String leaveSun) {
			LeaveSun = leaveSun;
		}
		public String getSpecialHolidaysSum() {
			return specialHolidaysSum;
		}
		public void setSpecialHolidaysSum(String specialHolidaysSum) {
			this.specialHolidaysSum = specialHolidaysSum;
		}
		public String getMealSupplement() {
			return MealSupplement;
		}
		public void setMealSupplement(String mealSupplement) {
			MealSupplement = mealSupplement;
		}


}
