/*
 * Copyright (c) 2007 NTT DATA Corporation
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package jp.terasoluna.thin.tutorial.web.transcosmos.form;

import java.util.List;

import jp.terasoluna.fw.web.struts.form.ValidatorActionFormEx;
import jp.terasoluna.thin.tutorial.web.transcosmos.dto.JNTCIAttendance06GetTypeListDto;
import jp.terasoluna.thin.tutorial.web.transcosmos.vo.JNTCIVocationDeptOutvo;
import jp.terasoluna.thin.tutorial.web.transcosmos.vo.JNTCIVocationOutvo;

/**
 * ログオン業務で使用するアクションフォーム。
 *
 */
public class JNTCIVocationForm extends ValidatorActionFormEx {

	/**
     * シリアルバージョンID。
     */
    private static final long serialVersionUID = 1L;

    /*登録画面で使用する*/
    /**
     * ユーザID。
     */
    private String userId = null;

    /**
     * ユーザ名。
     */

    private String userName = null;

	/**
     * 性别。
     */
    private String userSex = null;

    /**
     * 所属部门。
     */
    private String deptId = null;
    private String deptId1= null;
    private double nianjia;
    private double HOLIDAY_DAYS;
    public double getHOLIDAY_DAYS() {
		return HOLIDAY_DAYS;
	}

	public void setHOLIDAY_DAYS(double hOLIDAY_DAYS) {
		HOLIDAY_DAYS = hOLIDAY_DAYS;
	}

	private int c;
    private String mark;

    private double totalnianjia;
    private double REMAIN_DAYS;
	public double getREMAIN_DAYS() {
		return REMAIN_DAYS;
	}

	public void setREMAIN_DAYS(double rEMAIN_DAYS) {
		REMAIN_DAYS = rEMAIN_DAYS;
	}

	public double getTotalnianjia() {
		return totalnianjia;
	}

	public void setTotalnianjia(double totalnianjia) {
		this.totalnianjia = totalnianjia;
	}

	public String getMark() {
		return mark;
	}

	public void setMark(String mark) {
		this.mark = mark;
	}

	public int getC() {
		return c;
	}

	public void setC(int c) {
		this.c = c;
	}

	public double getNianjia() {
		return nianjia;
	}

	public void setNianjia(double nianjia) {
		this.nianjia = nianjia;
	}

	public String getDeptId1() {
		return deptId1;
	}

	public void setDeptId1(String deptId1) {
		this.deptId1 = deptId1;
	}

	/**
     * 入职时间。
     */
    private String entryDate = null;


    /**
     * 人员类别。
     */
    private String userType = null;

    /**
     * 总天。
     */
    private Double totalDays = null;

    /**
     * 剩余天。
     */
    private Double remainDays = null;
    private String entyrTime = null;
    private Double january = null;
    private Double february = null;
    private Double march = null;
    private Double april = null;
    private Double may = null;
    private Double june = null;
    private Double july = null;
    private Double august = null;
    private Double september = null;
    private Double octorber = null;
    private Double november = null;
    private Double december = null;
    private String updeflag = null;
    private String t0;
	private String t4;
	private String t5;

    public String getT0() {
		return t0;
	}

	public void setT0(String t0) {
		this.t0 = t0;
	}

	public String getT4() {
		return t4;
	}

	public void setT4(String t4) {
		this.t4 = t4;
	}

	public String getT5() {
		return t5;
	}

	public void setT5(String t5) {
		this.t5 = t5;
	}

	public String getT1() {
		return t1;
	}

	public void setT1(String t1) {
		this.t1 = t1;
	}

	public String getT2() {
		return t2;
	}

	public void setT2(String t2) {
		this.t2 = t2;
	}

	public String getT3() {
		return t3;
	}

	public void setT3(String t3) {
		this.t3 = t3;
	}

	private String t1;
    private String t2;
    private String t3;
    private String t;
    public String getT() {
		return t;
	}

	public void setT(String t) {
		this.t = t;
	}

	public String getUpdeflag() {
        return updeflag;
    }

    public void setUpdeflag(String updeflag) {
        this.updeflag = updeflag;
    }
	public Double getMarch() {
		return march;
	}

	public void setMarch(Double march) {
		this.march = march;
	}

	public Double getApril() {
		return april;
	}

	public void setApril(Double april) {
		this.april = april;
	}

	public Double getMay() {
		return may;
	}

	public void setMay(Double may) {
		this.may = may;
	}

	public Double getJune() {
		return june;
	}

	public void setJune(Double june) {
		this.june = june;
	}

	public Double getJuly() {
		return july;
	}

	public void setJuly(Double july) {
		this.july = july;
	}

	public Double getAugust() {
		return august;
	}

	public void setAugust(Double august) {
		this.august = august;
	}

	public Double getSeptember() {
		return september;
	}

	public void setSeptember(Double september) {
		this.september = september;
	}

	public Double getOctorber() {
		return octorber;
	}

	public void setOctorber(Double octorber) {
		this.octorber = octorber;
	}

	public Double getNovember() {
		return november;
	}

	public void setNovember(Double november) {
		this.november = november;
	}

	public Double getDecember() {
		return december;
	}

	public void setDecember(Double december) {
		this.december = december;
	}

	public void setRow(String row) {
		this.row = row;
	}

	public Double getJanuary() {
		return january;
	}

	public void setJanuary(Double january) {
		this.january = january;
	}

	public Double getFebruary() {
		return february;
	}

	public void setFebruary(Double february) {
		this.february = february;
	}

	public String getEntyrTime() {
		return entyrTime;
	}

	public void setEntyrTime(String entyrTime) {
		this.entyrTime = entyrTime;
	}

	private List<JNTCIAttendance06GetTypeListDto> deptTypeIdOutput = null;
    private List<JNTCIAttendance06GetTypeListDto> userTypeIdOutput = null;
    private String cd_code = null;
    private String kj_name = null;


    public String getCd_code() {
		return cd_code;
	}

	public void setCd_code(String cd_code) {
		this.cd_code = cd_code;
	}

	public String getKj_name() {
		return kj_name;
	}

	public void setKj_name(String kj_name) {
		this.kj_name = kj_name;
	}

	public List<JNTCIAttendance06GetTypeListDto> getDeptTypeIdOutput() {
		return deptTypeIdOutput;
	}

	public void setDeptTypeIdOutput(
			List<JNTCIAttendance06GetTypeListDto> deptTypeIdOutput) {
		this.deptTypeIdOutput = deptTypeIdOutput;
	}

	public List<JNTCIAttendance06GetTypeListDto> getUserTypeIdOutput() {
		return userTypeIdOutput;
	}

	public void setUserTypeIdOutput(
			List<JNTCIAttendance06GetTypeListDto> userTypeIdOutput) {
		this.userTypeIdOutput = userTypeIdOutput;
	}

	private String yonghu;

    public String getYonghu() {
		return yonghu;
	}

	public void setYonghu(String yonghu) {
		this.yonghu = yonghu;
	}

	/**
     * 调休天。
     */
    private Double exDays = null;
    private String flag = null;



    /*一覧画面で使用する*/

    public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	/**
     * 表示行数。
     */
    private String row = "10";

    /**
     * 開始インデックス。
     */
    private String startIndex ="0";

    /**
     * 全件数。
     */
    private String totalCount = null;

    /**
     * 表示用ユーザリスト。
     */
    private List<JNTCIVocationOutvo> users = null;

    /**
     * 表示用deptリスト。
     */
    private List<JNTCIVocationDeptOutvo> deptList = null;

    /**
     * ユーザID。
     */
    private String userSelectId = null;
    private String usernameSelect = null;
    private String cod;


    public String getCod() {
		return cod;
	}

	public void setCod(String cod) {
		this.cod = cod;
	}

	public String getUsernameSelect() {
		return usernameSelect;
	}

	public void setUsernameSelect(String usernameSelect) {
		this.usernameSelect = usernameSelect;
	}

	/**
     * ユーザIDを返却する。
     *
     * @return 保持するユーザID
     */
    public String getUserId() {
        return userId;
    }

    public List<JNTCIVocationDeptOutvo> getDeptList() {
		return deptList;
	}

	public void setDeptList(List<JNTCIVocationDeptOutvo> deptList) {
		this.deptList = deptList;
	}

	/**
     * ユーザIDを設定する。
     *
     * @param userId ユーザID
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * ユーザ名を返却する。
     *
     * @return 保持するユーザ名
     */
    public String getUserName() {
        return userName;
    }

    /**
     * ユーザ名を設定する。
     *
     * @param userName ユーザ名
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * 性别を返却する。
     *
     * @return 保持する性别
     */
    public String getUserSex() {
        return userSex;
    }

    /**
     * 年齢を設定する。
     *
     * @param userSex 性别
     */
    public void setUserSex(String userSex) {
        this.userSex = userSex;
    }

    /**
     * 所属部门を返却する。
     *
     * @return 保持する所属部门
     */
    public String getDeptId() {
        return deptId;
    }

    /**
     * 所属部门を設定する。
     *
     * @param deptId 所属部门
     */
    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }

    /**
     * 入职时间を返却する。
     *
     * @return 保持する入职时间
     */
    public String getEntryDate() {
        return entryDate;
    }

    /**
     * 入职时间を設定する。
     *
     * @param entryDate 入职时间
     */
    public void setEntryDate(String entryDate) {
        this.entryDate = entryDate;
    }


    /**
     * 人员类别を返却する。
     *
     * @return 保持する人员类别
     */
    public String getUserType() {
        return userType;
    }

    /**
     * 人员类别を設定する。
     *
     * @param userType 人员类别
     */
    public void setUserType(String userType) {
        this.userType = userType;
    }

    /**
     * 总天を返却する。
     *
     * @return 保持する总天
     */
    public Double getTotalDays() {
        return totalDays;
    }

    /**
     * 总天を設定する。
     *
     * @param totalDays 总天
     */
    public void setTotalDays(Double totalDays) {
        this.totalDays = totalDays;
    }


    /**
     * 剩余天を返却する。
     *
     * @return 保持する剩余天
     */
    public Double getRemainDays() {
        return remainDays;
    }

    /**
     * 剩余天を設定する。
     *
     * @param remainDays 剩余天
     */
    public void setRemainDays(Double remainDays) {
        this.remainDays = remainDays;
    }

    /**
     * 调休天を返却する。
     *
     * @return 保持する调休天
     */
    public Double getExDays() {
        return exDays;
    }

    /**
     * 调休天を設定する。
     *
     * @param exDays 调休天
     */
    public void setExDays(Double exDays) {
        this.exDays = exDays;
    }

    /**
     * 表示行数を返却する。
     * @return 表示行数
     */
    public String getRow() {
        return row;
    }

    /**
     * 開始インデックスを返却する。
     * @return 開始インデックス
     */
    public String getStartIndex() {
        return startIndex;
    }

    /**
     * 開始インデックスを設定する。
     * @param startIndex 開始インデックス
     */
    public void setStartIndex(String startIndex) {
        this.startIndex = startIndex;
    }

    /**
     * 全件数を返却する。
     * @return 全件数
     */
    public String getTotalCount() {
        return totalCount;
    }

    /**
     * 全件数を返却する。
     * @param totalCount 全件数
     */
    public void setTotalCount(String totalCount) {
        this.totalCount = totalCount;
    }

    /**
     * 表示用ユーザリストを返却する。
     * @return 表示用ユーザリスト
     */
    public List<JNTCIVocationOutvo> getUsers() {
        return users;
    }

    /**
     * 表示用ユーザリストを設定する。
     * @param users 表示用ユーザリスト
     */
    public void setUsers(List<JNTCIVocationOutvo> users) {
        this.users = users;
    }


    /**
     * ユーザIDを返却する。
     *
     * @return 保持するユーザID
     */
    public String getUserSelectId() {
        return userSelectId;
    }

    /**
     * ユーザIDを設定する。
     *
     * @param userSelectId ユーザID
     */
    public void setUserSelectId(String userSelectId) {
        this.userSelectId = userSelectId;
    }


}
