package jp.terasoluna.thin.tutorial.web.transcosmos.dto;

import java.io.Serializable;

public class JNTCIPersonalInfoDetailedInput implements Serializable {

    private static final long serialVersionUID = 1L;

    //id_card
  	//部门
  	private String department;

  	//入社时间——开始
  	private String entryTime_Begin;

  	//入社时间——结束
  	private String entryTime_End;
  private String userId;
      //id_card
      private String id_card;
      private String userName;
      private String entryTime;
      private String out_time;
      private Integer startIndex = null;//索引号
    private String jn_card;
    private String cardnum;//单纯用于传用于检索条件的卡号
    private String zhuangtai;

	public String getZhuangtai() {
		return zhuangtai;
	}

	public void setZhuangtai(String zhuangtai) {
		this.zhuangtai = zhuangtai;
	}

	public String getCardnum() {
		return cardnum;
	}

	public void setCardnum(String cardnum) {
		this.cardnum = cardnum;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getEntryTime_Begin() {
		return entryTime_Begin;
	}

	public void setEntryTime_Begin(String entryTime_Begin) {
		this.entryTime_Begin = entryTime_Begin;
	}

	public String getEntryTime_End() {
		return entryTime_End;
	}

	public void setEntryTime_End(String entryTime_End) {
		this.entryTime_End = entryTime_End;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEntryTime() {
		return entryTime;
	}

	public void setEntryTime(String entryTime) {
		this.entryTime = entryTime;
	}

	public String getOut_time() {
		return out_time;
	}

	public void setOut_time(String out_time) {
		this.out_time = out_time;
	}

	public String getJn_card() {
		return jn_card;
	}

	public void setJn_card(String jn_card) {
		this.jn_card = jn_card;
	}

	public Integer getStartIndex() {
		return startIndex;
	}

	public void setStartIndex(Integer startIndex) {
		this.startIndex = startIndex;
	}

	public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getId_card() {
        return id_card;
    }

    public void setId_card(String id_card) {
        this.id_card = id_card;
    }

}
