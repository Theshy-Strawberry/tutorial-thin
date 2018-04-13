package jp.terasoluna.thin.tutorial.web.transcosmos.form;

import java.util.List;

import jp.terasoluna.fw.web.struts.form.ValidatorActionFormEx;
import jp.terasoluna.thin.tutorial.web.transcosmos.vo.JNTCIEquip02equip;
import jp.terasoluna.thin.tutorial.web.transcosmos.vo.SelectListOutput;

public class JNTCIEquipListForm extends ValidatorActionFormEx {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	// 区分
	private String code = null ;
	// 設備区分
	private String setsubiKubun = null ;
	// 所属部門Id
	private String deptId = null ;
	// 社員ID
	private String userId = null ;

    private String flags = null;

	private String row = "10";

	private String startIndex = "0";

	private String totalCount = null;

	private List<SelectListOutput> list = null;

	 //設備詳細
	private List<SelectListOutput> lists =null;

	private String shunyuNo =null;

	private String setsubiNo =null;

	    //設備状態
		private String   setsubiJyoutai =null;
		//設備型番
		private String   setsubiKataban =null;
		//設備種類
		private String setsubiShurui = null;
		//購入日
		private String   setsubiKonyuhi =null;
		//購入者
		private String setsubiKonYusya =null;
		//設備規格
		private String setsubiKiKaku =null;
		//設備メーカー
		private String setsubiMaker =null;
		//単価
		private String setsubiTanka =null;
		//CPU
		private String cpu =null;
		//CPU配置
		private String cpuHaichi =null;
		//メモリ
		private String memori =null;
		//ハードディスク
		private String hardDisk =null;
		//ハードディスク総量
		private String hardDiskTotal =null;
		//MACアドレス
		private String mac =null;

		  private String setsubi_kuben=null;
		  private String setsubi_kataban=null;
		  private String kounyu_hiduke=null;
		  private String mac_address=null;
		  private String tanaoroshi_hiduke=null;
		  private String setsubi_kanaoroshi_no=null;
		  private String tanaoroshi_user=null;
		  private String shunyuko_no=null;
		  private String shunyuko_date=null;
		  private String youto=null;
		  private String userpg=null;
		  private List<JNTCIEquip02equip> jNTCIEquip02equip= null;
		  private List<JNTCIEquip02equip> equipEditorList= null;
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

		public List<JNTCIEquip02equip> getEquipEditorList() {
			return equipEditorList;
		}

		public void setEquipEditorList(List<JNTCIEquip02equip> equipEditorList) {
			this.equipEditorList = equipEditorList;
		}

		public List<JNTCIEquip02equip> getjNTCIEquip02equip() {
			return jNTCIEquip02equip;
		}

		public void setjNTCIEquip02equip(List<JNTCIEquip02equip> jNTCIEquip02equip) {
			this.jNTCIEquip02equip = jNTCIEquip02equip;
		}



		public String getUserpg() {
			return userpg;
		}

		public void setUserpg(String userpg) {
			this.userpg = userpg;
		}

		public String getTanaoroshi_hiduke() {
			return tanaoroshi_hiduke;
		}

		public void setTanaoroshi_hiduke(String tanaoroshi_hiduke) {
			this.tanaoroshi_hiduke = tanaoroshi_hiduke;
		}

		public String getSetsubi_kanaoroshi_no() {
			return setsubi_kanaoroshi_no;
		}

		public void setSetsubi_kanaoroshi_no(String setsubi_kanaoroshi_no) {
			this.setsubi_kanaoroshi_no = setsubi_kanaoroshi_no;
		}

		public String getTanaoroshi_user() {
			return tanaoroshi_user;
		}

		public void setTanaoroshi_user(String tanaoroshi_user) {
			this.tanaoroshi_user = tanaoroshi_user;
		}

		public String getShunyuko_no() {
			return shunyuko_no;
		}

		public void setShunyuko_no(String shunyuko_no) {
			this.shunyuko_no = shunyuko_no;
		}

		public String getShunyuko_date() {
			return shunyuko_date;
		}

		public void setShunyuko_date(String shunyuko_date) {
			this.shunyuko_date = shunyuko_date;
		}

		public String getYouto() {
			return youto;
		}

		public void setYouto(String youto) {
			this.youto = youto;
		}

		//设备番号
		   private String setsubi_no=null;

		public String getSetsubi_no() {
			return setsubi_no;
		}

		public void setSetsubi_no(String setsubi_no) {
			this.setsubi_no = setsubi_no;
		}

		public String getMac_address() {
			return mac_address;
		}

		public void setMac_address(String mac_address) {
			this.mac_address = mac_address;
		}

		public String getKounyu_hiduke() {
			return kounyu_hiduke;
		}

		public void setKounyu_hiduke(String kounyu_hiduke) {
			this.kounyu_hiduke = kounyu_hiduke;
		}

		public String getSetsubi_kataban() {
			return setsubi_kataban;
		}

		public void setSetsubi_kataban(String setsubi_kataban) {
			this.setsubi_kataban = setsubi_kataban;
		}

		public String getSetsubi_kuben() {
			return setsubi_kuben;
		}

		public void setSetsubi_kuben(String setsubi_kuben) {
			this.setsubi_kuben = setsubi_kuben;
		}

		public String getSetsubiJyoutai() {
			return setsubiJyoutai;
		}

		public void setSetsubiJyoutai(String setsubiJyoutai) {
			this.setsubiJyoutai = setsubiJyoutai;
		}

		public String getSetsubiKataban() {
			return setsubiKataban;
		}

		public void setSetsubiKataban(String setsubiKataban) {
			this.setsubiKataban = setsubiKataban;
		}

		public String getSetsubiKonyuhi() {
			return setsubiKonyuhi;
		}

		public void setSetsubiKonyuhi(String setsubiKonyuhi) {
			this.setsubiKonyuhi = setsubiKonyuhi;
		}

		public String getSetsubiKonYusya() {
			return setsubiKonYusya;
		}

		public void setSetsubiKonYusya(String setsubiKonYusya) {
			this.setsubiKonYusya = setsubiKonYusya;
		}

		public String getSetsubiKiKaku() {
			return setsubiKiKaku;
		}

		public void setSetsubiKiKaku(String setsubiKiKaku) {
			this.setsubiKiKaku = setsubiKiKaku;
		}

		public String getSetsubiMaker() {
			return setsubiMaker;
		}

		public void setSetsubiMaker(String setsubiMaker) {
			this.setsubiMaker = setsubiMaker;
		}

		public String getSetsubiTanka() {
			return setsubiTanka;
		}

		public void setSetsubiTanka(String setsubiTanka) {
			this.setsubiTanka = setsubiTanka;
		}

		public String getCpu() {
			return cpu;
		}

		public void setCpu(String cpu) {
			this.cpu = cpu;
		}

		public String getCpuHaichi() {
			return cpuHaichi;
		}

		public void setCpuHaichi(String cpuHaichi) {
			this.cpuHaichi = cpuHaichi;
		}

		public String getMemori() {
			return memori;
		}

		public void setMemori(String memori) {
			this.memori = memori;
		}

		public String getHardDisk() {
			return hardDisk;
		}

		public void setHardDisk(String hardDisk) {
			this.hardDisk = hardDisk;
		}

		public String getHardDiskTotal() {
			return hardDiskTotal;
		}

		public void setHardDiskTotal(String hardDiskTotal) {
			this.hardDiskTotal = hardDiskTotal;
		}

		public String getMac() {
			return mac;
		}

		public void setMac(String mac) {
			this.mac = mac;
		}

		public static long getSerialversionuid() {
			return serialVersionUID;
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

	public String getDeptId() {
		return deptId;
	}

	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getRow() {
		return row;
	}

	public void setRow(String row) {
		this.row = row;
	}

	public String getStartIndex() {
		return startIndex;
	}

	public void setStartIndex(String startIndex) {
		this.startIndex = startIndex;
	}

	public String getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(String totalCount) {
		this.totalCount = totalCount;
	}

	public List<SelectListOutput> getList() {
		return list;
	}

	public void setList(List<SelectListOutput> list) {
		this.list = list;
	}

	public String getFlags() {
		return flags;
	}

	public void setFlags(String flags) {
		this.flags = flags;
	}

	public String getSetsubiNo() {
		return setsubiNo;
	}

	public void setSetsubiNo(String setsubiNo) {
		this.setsubiNo = setsubiNo;
	}

	public String getShunyuNo() {
		return shunyuNo;
	}

	public void setShunyuNo(String shunyuNo) {
		this.shunyuNo = shunyuNo;
	}

	public List<SelectListOutput> getLists() {
		return lists;
	}

	public void setLists(List<SelectListOutput> lists) {
		this.lists = lists;
	}

	public String getSetsubiShurui() {
		return setsubiShurui;
	}

	public void setSetsubiShurui(String setsubiShurui) {
		this.setsubiShurui = setsubiShurui;
	}

}
