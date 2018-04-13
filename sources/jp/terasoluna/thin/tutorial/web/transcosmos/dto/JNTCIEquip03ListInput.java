package jp.terasoluna.thin.tutorial.web.transcosmos.dto;

public class JNTCIEquip03ListInput {

	//Equip04の検索条件保持
		private String userId1 = null;
		private String  deptName = null;
		private String  shinsaJyoutai = null;
		private String  shinseiStartDate = null;
		private String  shinseiEndDate = null;
		private String  startIndex = null;

		//ボタン区分
		private String  buttonKubun = null;

    private String row = null;
    //部门id
    private String dept = null;
    private String state = null;
    private String cardnumber = null;
    private String name = null;
    private String type = null;
    //按钮区分
    private String hidden_state;
    private String apply_no = null;
    private String apply_user_id = null;
    private String apply_dept_name = null;
    private String apply_user_name = null;
    private String apply_setsubi_no = null;
    private String apply_reason = null;
    private String apply_state = null;
    private String apply_setsubi_kuben = null;
    private String equipType = null;
    private String setsubi_kubun = null;
      //系统时间
    private String xttime = null;
    private String userId = null;
    private String apply_date = null;
     //出入库番号
    private String stockNo=null;
    private String apply_setsubi_number=null;
    // 保有者
    private String hoyusha = null;
    // 审查理由
    private String investigate_reason = null;

    public String getUserId1() {
		return userId1;
	}

	public void setUserId1(String userId1) {
		this.userId1 = userId1;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getShinsaJyoutai() {
		return shinsaJyoutai;
	}

	public void setShinsaJyoutai(String shinsaJyoutai) {
		this.shinsaJyoutai = shinsaJyoutai;
	}

	public String getShinseiStartDate() {
		return shinseiStartDate;
	}

	public void setShinseiStartDate(String shinseiStartDate) {
		this.shinseiStartDate = shinseiStartDate;
	}

	public String getShinseiEndDate() {
		return shinseiEndDate;
	}

	public void setShinseiEndDate(String shinseiEndDate) {
		this.shinseiEndDate = shinseiEndDate;
	}

	public String getButtonKubun() {
		return buttonKubun;
	}

	public void setButtonKubun(String buttonKubun) {
		this.buttonKubun = buttonKubun;
	}

	public String getApply_setsubi_number() {
		return apply_setsubi_number;
	}

	public void setApply_setsubi_number(String apply_setsubi_number) {
		this.apply_setsubi_number = apply_setsubi_number;
	}

	public String getStockNo() {
		return stockNo;
	}

	public void setStockNo(String stockNo) {
		this.stockNo = stockNo;
	}

	public String getApply_date() {
        return apply_date;
    }

    public void setApply_date(String apply_date) {
        this.apply_date = apply_date;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getXttime() {
        return xttime;
    }

    public void setXttime(String xttime) {
        this.xttime = xttime;
    }

    public String getSetsubi_kubun() {
        return setsubi_kubun;
    }

    public void setSetsubi_kubun(String setsubi_kubun) {
        this.setsubi_kubun = setsubi_kubun;
    }

    public String getApply_setsubi_kuben() {
        return apply_setsubi_kuben;
    }

    public void setApply_setsubi_kuben(String apply_setsubi_kuben) {
        this.apply_setsubi_kuben = apply_setsubi_kuben;
    }


    public String getInvestigate_reason() {
        return investigate_reason;
    }

    public void setInvestigate_reason(String investigate_reason) {
        this.investigate_reason = investigate_reason;
    }

    public String getHidden_state() {
        return hidden_state;
    }

    public void setHidden_state(String hidden_state) {
        this.hidden_state = hidden_state;
    }

    public String getApply_user_id() {
        return apply_user_id;
    }

    public void setApply_user_id(String apply_user_id) {
        this.apply_user_id = apply_user_id;
    }

    public String getApply_dept_name() {
        return apply_dept_name;
    }

    public void setApply_dept_name(String apply_dept_name) {
        this.apply_dept_name = apply_dept_name;
    }

    public String getApply_user_name() {
        return apply_user_name;
    }

    public void setApply_user_name(String apply_user_name) {
        this.apply_user_name = apply_user_name;
    }

    public String getEquipType() {
        return equipType;
    }

    public void setEquipType(String equipType) {
        this.equipType = equipType;
    }

    public String getApply_setsubi_no() {
        return apply_setsubi_no;
    }

    public void setApply_setsubi_no(String apply_setsubi_no) {
        this.apply_setsubi_no = apply_setsubi_no;
    }

    public String getApply_reason() {
        return apply_reason;
    }

    public void setApply_reason(String apply_reason) {
        this.apply_reason = apply_reason;
    }

    public String getApply_state() {
        return apply_state;
    }

    public void setApply_state(String apply_state) {
        this.apply_state = apply_state;
    }

    public String getApply_no() {
        return apply_no;
    }

    public void setApply_no(String apply_no) {
        this.apply_no = apply_no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCardnumber() {
        return cardnumber;
    }

    public void setCardnumber(String cardnumber) {
        this.cardnumber = cardnumber;
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

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getHoyusha() {
        return hoyusha;
    }

    public void setHoyusha(String hoyusha) {
        this.hoyusha = hoyusha;
    }

}
