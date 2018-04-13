package jp.terasoluna.thin.tutorial.web.transcosmos.dto;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;



public class JNTCIMeetingInquireInfo{

	private String room_no;

	private String room_name;

	private String username;

	private String use_date;

	private String jn_card;

	private String start_time;

	private String start_time_show;

	private String end_time;

	private String remark;

	private String apply_time;

	private String totoku_user;

	private String totoku_pgm;

	private String totoku_timestamp;

	private String koshin_user;

	private String koshin_pgm;

	private String koshin_timestamp;

	private boolean disabledflag = true;

	public boolean isDisabledflag() {

			Date startDate = null;
			Date endDate = null;
			//Date nowDate = null;
			Date now = new Date();

			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
			try {
				 startDate = sdf.parse(this.getStart_time());
				 endDate = sdf.parse(this.getEnd_time());

			} catch (ParseException e) {
				e.printStackTrace();
			}

			if( (now.after(startDate) && now.before(endDate))
					|| now.after(endDate)){

				this.disabledflag = false;
			}
			return disabledflag;
	}

	public void setDisabledflag(boolean disabledflag) {
		this.disabledflag = disabledflag;
	}

	public String getRoom_name() {
		return room_name;
	}

	public void setRoom_name(String room_name) {
		this.room_name = room_name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getRoom_no() {
		return room_no;
	}

	public void setRoom_no(String room_no) {
		this.room_no = room_no;
	}

	public String getUse_date() {
		return use_date;
	}

	public void setUse_date(String use_date) {
		this.use_date = use_date;
	}

	public String getJn_card() {
		return jn_card;
	}

	public void setJn_card(String jn_card) {
		this.jn_card = jn_card;
	}

	public String getStart_time() {
		return start_time;
	}

	public void setStart_time(String start_time) {
		this.start_time = start_time;
	}

	public String getStart_time_show() {
		String new_time_show = this.getStart_time();//.substring(0, this.getStart_time().lastIndexOf(":"));
		return new_time_show;
	}

	public void setStart_time_show(String start_time_show) {
		this.start_time_show = start_time_show;
	}

	public String getEnd_time() {
		return end_time;
	}

	public void setEnd_time(String end_time) {
		this.end_time =  end_time;//.substring(0, end_time.lastIndexOf(":"));
	}

	public String getTotoku_user() {
		return totoku_user;
	}

	public void setTotoku_user(String totoku_user) {
		this.totoku_user = totoku_user;
	}

	public String getTotoku_pgm() {
		return totoku_pgm;
	}

	public void setTotoku_pgm(String totoku_pgm) {
		this.totoku_pgm = totoku_pgm;
	}

	public String getTotoku_timestamp() {
		return totoku_timestamp;
	}

	public void setTotoku_timestamp(String totoku_timestamp) {
		this.totoku_timestamp = totoku_timestamp;
	}

	public String getKoshin_user() {
		return koshin_user;
	}

	public void setKoshin_user(String koshin_user) {
		this.koshin_user = koshin_user;
	}

	public String getKoshin_pgm() {
		return koshin_pgm;
	}

	public void setKoshin_pgm(String koshin_pgm) {
		this.koshin_pgm = koshin_pgm;
	}

	public String getKoshin_timestamp() {
		return koshin_timestamp;
	}

	public void setKoshin_timestamp(String koshin_timestamp) {
		this.koshin_timestamp = koshin_timestamp;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getApply_time() {
		return apply_time;
	}

	public void setApply_time(String apply_time) {

		//int index = apply_time.lastIndexOf(":");
		this.apply_time =apply_time;//.substring(0, index);
	}


}

