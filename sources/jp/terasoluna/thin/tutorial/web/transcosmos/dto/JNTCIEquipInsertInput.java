package jp.terasoluna.thin.tutorial.web.transcosmos.dto;

public class JNTCIEquipInsertInput {

	// 設備番号
	private String setsubi_no = null;
	// 設備種類
	private String setsubi_kuben = null;
	// ユーザーId
	private String userId = null;
	// 部門id
	private String deptId = null;
	// 設備状態
	private String setsubi_state = null;
	// 設備型番
	private String setsubi_kataban = null;
	// 購入日
	private String kounyu_hiduke = null;
	// 設備数
	private String setsubi_su = null;
	// 棚卸人
	private String tanaoroshi_user = null;
	// 棚卸日付
	private String tanaoroshi_hiduke = null;
	// 出入庫
	private String shunyuko = null;
	// 出入庫日付
	private String shunyuko_date = null;
	// 出入庫番号
	private String shunyuko_no = null;
	// 棚卸番号
	private String setsubi_kanaoroshi_no = null;
	// 保管方式
	private String hokanhoushiki = null;
	// 保管場所
	private String hokanbasho = null;
	// 用途
	private String youto = null;
	// MAC
	private String mac_address = null;
    //動作
	private String dousa = null;
	//原来的设备番号
	private String before_no=null;
	//状态
	private String hidden_state=null;
	//标记
	private String mark=null;

	//系统时间
	private String xttime=null;
	//强制归庫者
   private String reutrnman=null;

   private String userpg=null;

   private String startIndex;
   private String code;
   private String setsubiKubun;
 //原来的设备入库番号
   private String before_shunyuko_no=null;
 	public String getBefore_shunyuko_no() {
 			return before_shunyuko_no;
 		}

 		public void setBefore_shunyuko_no(String before_shunyuko_no) {
 			this.before_shunyuko_no = before_shunyuko_no;
 		}


	 public String getStartIndex() {
	return startIndex;
}

public void setStartIndex(String startIndex) {
	this.startIndex = startIndex;
}

public String getCode() {
	return code;
}

public void setCode(String code) {
	this.code = code;
}

public String getSetsubiKubun() {
	return setsubiKubun;
}

public void setSetsubiKubun(String setsubiKubun) {
	this.setsubiKubun = setsubiKubun;
}

	//equipLocation
	 private String equipLocation=null;
	 private String cod;

	public String getCod() {
		return cod;
	}

	public void setCod(String cod) {
		this.cod = cod;
	}

	public String getEquipLocation() {
		return equipLocation;
	}

	public void setEquipLocation(String equipLocation) {
		this.equipLocation = equipLocation;
	}

	public String getUserpg() {
	return userpg;
}

public void setUserpg(String userpg) {
	this.userpg = userpg;
}

	public String getReutrnman() {
	return reutrnman;
}

public void setReutrnman(String reutrnman) {
	this.reutrnman = reutrnman;
}

	public String getXttime() {
		return xttime;
	}

	public void setXttime(String xttime) {
		this.xttime = xttime;
	}

	public String getMark() {
		return mark;
	}

	public void setMark(String mark) {
		this.mark = mark;
	}

	public String getHidden_state() {
		return hidden_state;
	}

	public void setHidden_state(String hidden_state) {
		this.hidden_state = hidden_state;
	}

	public String getBefore_no() {
		return before_no;
	}

	public void setBefore_no(String before_no) {
		this.before_no = before_no;
	}

	public String getSetsubi_no() {
		return setsubi_no;
	}

	public void setSetsubi_no(String setsubi_no) {
		this.setsubi_no = setsubi_no;
	}

	public String getSetsubi_kuben() {
		return setsubi_kuben;
	}

	public void setSetsubi_kuben(String setsubi_kuben) {
		this.setsubi_kuben = setsubi_kuben;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getDeptId() {
		return deptId;
	}

	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}

	public String getSetsubi_state() {
		return setsubi_state;
	}

	public void setSetsubi_state(String setsubi_state) {
		this.setsubi_state = setsubi_state;
	}

	public String getSetsubi_kataban() {
		return setsubi_kataban;
	}

	public void setSetsubi_kataban(String setsubi_kataban) {
		this.setsubi_kataban = setsubi_kataban;
	}
	public String getKounyu_hiduke() {
		return kounyu_hiduke;
	}

	public void setKounyu_hiduke(String kounyu_hiduke) {
		this.kounyu_hiduke = kounyu_hiduke;
	}

	public String getSetsubi_su() {
		return setsubi_su;
	}

	public void setSetsubi_su(String setsubi_su) {
		this.setsubi_su = setsubi_su;
	}

	public String getTanaoroshi_user() {
		return tanaoroshi_user;
	}

	public void setTanaoroshi_user(String tanaoroshi_user) {
		this.tanaoroshi_user = tanaoroshi_user;
	}

	public String getTanaoroshi_hiduke() {
		return tanaoroshi_hiduke;
	}

	public void setTanaoroshi_hiduke(String tanaoroshi_hiduke) {
		this.tanaoroshi_hiduke = tanaoroshi_hiduke;
	}

	public String getShunyuko() {
		return shunyuko;
	}

	public void setShunyuko(String shunyuko) {
		this.shunyuko = shunyuko;
	}

	public String getShunyuko_date() {
		return shunyuko_date;
	}

	public void setShunyuko_date(String shunyuko_date) {
		this.shunyuko_date = shunyuko_date;
	}

	public String getShunyuko_no() {
		return shunyuko_no;
	}

	public void setShunyuko_no(String shunyuko_no) {
		this.shunyuko_no = shunyuko_no;
	}

	public String getSetsubi_kanaoroshi_no() {
		return setsubi_kanaoroshi_no;
	}

	public void setSetsubi_kanaoroshi_no(String setsubi_kanaoroshi_no) {
		this.setsubi_kanaoroshi_no = setsubi_kanaoroshi_no;
	}

	public String getHokanhoushiki() {
		return hokanhoushiki;
	}

	public void setHokanhoushiki(String hokanhoushiki) {
		this.hokanhoushiki = hokanhoushiki;
	}

	public String getHokanbasho() {
		return hokanbasho;
	}

	public void setHokanbasho(String hokanbasho) {
		this.hokanbasho = hokanbasho;
	}

	public String getYouto() {
		return youto;
	}

	public void setYouto(String youto) {
		this.youto = youto;
	}

	public String getMac_address() {
		return mac_address;
	}

	public void setMac_address(String mac_address) {
		this.mac_address = mac_address;
	}

	public String getDousa() {
		return dousa;
	}

	public void setDousa(String dousa) {
		this.dousa = dousa;
	}

}
