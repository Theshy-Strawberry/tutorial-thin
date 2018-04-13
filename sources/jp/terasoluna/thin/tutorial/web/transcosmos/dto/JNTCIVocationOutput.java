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

import java.util.List;

import jp.terasoluna.thin.tutorial.web.transcosmos.vo.JNTCIVocationDeptOutvo;
import jp.terasoluna.thin.tutorial.web.transcosmos.vo.JNTCIVocationOutvo;


/**
 * ログオン処理の出力クラス。
 *
 */
public class JNTCIVocationOutput {

    /**
     * 表示用ユーザリスト。
     */
    private List<JNTCIVocationOutvo> users = null;

    public List<JNTCIVocationOutvo> getUsers() {
		return users;
	}
    private String flag = null;
	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public void setUsers(List<JNTCIVocationOutvo> users) {
		this.users = users;
	}

	/**
     * 表示用deptリスト。
     */
    private List<JNTCIVocationDeptOutvo> deptList = null;
    private List<JNTCIAttendance06GetTypeListDto> deptTypeIdOutput = null;
    private List<JNTCIAttendance06GetTypeListDto> userTypeIdOutput = null;

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

    private Double totalnianjia = null;
    private Double REMAIN_DAYS;
    public Double getREMAIN_DAYS() {
		return REMAIN_DAYS;
	}

	public void setREMAIN_DAYS(Double rEMAIN_DAYS) {
		REMAIN_DAYS = rEMAIN_DAYS;
	}

	public Double getTotalnianjia() {
		return totalnianjia;
	}

	public void setTotalnianjia(Double totalnianjia) {
		this.totalnianjia = totalnianjia;
	}

	private Double remainDays = null;

    /**
     * 调休天。
     */
    private Double exDays = null;
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
   private String  startIndex;
   private String userSelectId;
   private String deptId1;
   private String  row;
   private String usernameSelect;
   private String cod;
   private Double HOLIDAY_DAYS;


    public Double getHOLIDAY_DAYS() {
	return HOLIDAY_DAYS;
}

public void setHOLIDAY_DAYS(Double hOLIDAY_DAYS) {
	HOLIDAY_DAYS = hOLIDAY_DAYS;
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

	public String getRow() {
	return row;
}

public void setRow(String row) {
	this.row = row;
}

	public String getUserSelectId() {
	return userSelectId;
}

public void setUserSelectId(String userSelectId) {
	this.userSelectId = userSelectId;
}

public String getDeptId1() {
	return deptId1;
}

public void setDeptId1(String deptId1) {
	this.deptId1 = deptId1;
}

	public String getStartIndex() {
	return startIndex;
}

public void setStartIndex(String startIndex) {
	this.startIndex = startIndex;
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

	public String getUserId() {
		return userId;
	}

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
     * ユーザリストの全件数。
     */
    private String totalCount;

    /**
     * 表示用ユーザリストを返却する。
     * @return 表示用ユーザリスト
     */



    public List<JNTCIVocationDeptOutvo> getDeptList() {
		return deptList;
	}

	public void setDeptList(List<JNTCIVocationDeptOutvo> deptList) {
		this.deptList = deptList;
	}

    /**
     * ユーザリストの全件数を返却する。
     * @return ユーザリストの全件数
     */
    public String getTotalCount() {
        return totalCount;
    }

    /**
     * ユーザリストの全件数を設定する。
     * @param totalCount ユーザリストの全件数
     */
    public void setTotalCount(String totalCount) {
        this.totalCount = totalCount;
    }


}
