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

package jp.terasoluna.thin.tutorial.web.transcosmos.dto;

/**
 * ログオン処理の入力クラス。
 */
public class JNTCIVocationInput {

	/**
	 * ユーザID。
	 */
	private String userId = null;

	/**
	 * ユーザID。
	 */
	private String userSelectId = null;
	private String usernameSelect = null;
	private String cod;
	private String t1;
	private String mark;
	public String getMark() {
		return mark;
	}

	public void setMark(String mark) {
		this.mark = mark;
	}

	private double nianjia;
	private int c;


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

	private String t2;
	private String t3;
	private String t;
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

	public String getT() {
		return t;
	}

	public void setT(String t) {
		this.t = t;
	}

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
	 * 表示行数。
	 */
	private String row = null;

	/**
	 * 開始インデックス。
	 */
	private String startIndex = null;

	private String userName = null;

	/**
	 * 性别。
	 */
	private String userSex = null;

	/**
	 * 所属部门。
	 */
	private String deptId = null;
	private String deptId1 = null;


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
	private Double january = null;//一月
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

	public String getUpdeflag() {
        return updeflag;
    }

    public void setUpdeflag(String updeflag) {
        this.updeflag = updeflag;
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

	public String getEntyrTime() {
		return entyrTime;
	}

	public void setEntyrTime(String entyrTime) {
		this.entyrTime = entyrTime;
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

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	/**
	 * ユーザIDを返却する。
	 *
	 * @return 保持するユーザID
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * ユーザIDを設定する。
	 *
	 * @param userId
	 *            ユーザID
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
	 * @param userName
	 *            ユーザ名
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
	 * @param userSex
	 *            性别
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
	 * @param deptId
	 *            所属部门
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
	 * @param entryDate
	 *            入职时间
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
	 * @param userType
	 *            人员类别
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
	 * @param totalDays
	 *            总天
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
	 * @param remainDays
	 *            剩余天
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
	 * @param exDays
	 *            调休天
	 */

	public void setExDays(Double exDays) {
		this.exDays = exDays;
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
	 * @param userSelectId
	 *            ユーザID
	 */
	public void setUserSelectId(String userSelectId) {
		this.userSelectId = userSelectId;
	}

	/**
	 * 表示行数を返却する。
	 *
	 * @return 表示行数
	 */
	public String getRow() {
		return row;
	}

	/**
	 * 表示行数を設定する。
	 *
	 * @param row
	 *            表示行数
	 */
	public void setRow(String row) {
		this.row = row;
	}

	/**
	 * 開始インデックスを返却する。
	 *
	 * @return 開始インデックス
	 */
	public String getStartIndex() {
		return startIndex;
	}

	/**
	 * 開始インデックスを設定する。
	 *
	 * @param startIndex
	 *            開始インデックス
	 */
	public void setStartIndex(String startIndex) {
		this.startIndex = startIndex;
	}

}
