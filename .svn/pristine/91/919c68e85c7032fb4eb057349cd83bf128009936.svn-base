<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-html" prefix="html"%>
<%@ taglib uri="/struts-bean" prefix="bean"%>
<%@ taglib uri="/struts-logic" prefix="logic"%>
<%@ taglib uri="/terasoluna-struts" prefix="ts"%>
<%@ taglib uri="/terasoluna" prefix="t"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html:html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>年休照会</title>
<link rel="stylesheet" type="text/css" href="css/base.css" />
<link rel="stylesheet" type="text/css" href="css/main.css" />

<script type="text/javascript" src="js/jquery-1.11.3.min.js"></script>
<script type="text/javascript">
    $(function() {
        $("#yonghu").val("");
        $('#left-container .content').hide();
        $('#Attendance').show();
        $('h2.tit').click(function() {
            $(this).next('.content').stop().slideToggle();

        })
        var dpt = $("#dept_idBC").val();
        if (dpt != null) {
            $("#dept_id option[value='" + dpt + "']").attr("selected", true);
        }
    })

    function onSubimitfun(type, index) {
        if (type == "1") {
            $(index).val("delete");
            this.form.submit();
        } else if (type == "2") {
            $(index).val("update");
            this.form.submit();
        }

    }
    function showConfirm() {
        if (confirm('本当にリセットしますか？')) {
            location.href = 'vocationReset.do';
        }
        return false;
    };


    	  function updatenianjiaConfirm() {
        if (confirm('本当に年休の更新しますか？')) {
        	location.href='VocationlistBL.do?mark=1';
        }
        return false;
    };
</script>
</head>
<body>
    <div>
        <jsp:include page="/top.jsp" flush="true" />
    </div>
    <!--/头部分 -->
    <div class="clearfix" style="position: relative;">
        <!--左侧部分 -->
        <div style="position: absolute;">
            <jsp:include page="/left.jsp" flush="true" />
        </div>
        <!--/左侧部分 -->
        <!--右侧部分 -->
        <div class="rightWidht">
            <div class="header">
                <ul class="breadcrumbs clearfix">
                    <li>ステップチャート：</li>
                    <li><a href="#">勤務管理</a></li>
                    <li class="ico">&gt;</li>
                    <li><a href="#">年休照会 <input id="flag"
                            type="hidden"
                            value='<bean:write name="flag" scope="session" />' /></a></li>
                </ul>
            </div>

            <div class="main-ctn">
                <p style="color: red;">
                    <html:errors />
                    <html:messages id="message" message="true">
                        <bean:write name="message" />
                    </html:messages>
                </p>
                <ts:form styleId="formid" action="/revocationSelect">
                    <div class="clearfix">
                        <table class="fl table-bar">
                            <colgroup>
                                <col style="width: 120px" />
                                <col style="width: 130px" />
                                <col style="width: 120px" />
                                <col style="width: 130px" />

                            </colgroup>
                            <tr>
                                <th>社員カード：</th>
                                <td><input type="hidden"
                                    id="cod" name="cod" value="reset"/><html:text
                                        name="_JNTCIVocationForm"
                                        property="userSelectId"
                                        maxlength="4" /></td>
                                        <th>社員名前:</th>
                                <td><html:text
                                        name="_JNTCIVocationForm"
                                        property="usernameSelect" maxlength="20"
                                        /></td>
                                <th>部門所属：</th>
                                <td><input type="hidden"
                                    id="dept_idBC" name="dept_idBC"
                                    value="<bean:write name="_JNTCIVocationForm" property="deptId1"/>" />
                                    <html:select property="deptId1"
                                        styleId="dept_id">
                                        <option value=""></option>
                                        <logic:iterate
                                            id="JNTCIAttendance04selectFormBean"
                                            name="_JNTCIVocationForm"
                                            property="deptList">
                                            <option
                                                value="<bean:write name="JNTCIAttendance04selectFormBean" property="cd_code" />">
                                                <bean:write
                                                    name="JNTCIAttendance04selectFormBean"
                                                    property="kj_name" /></option>
                                        </logic:iterate>
                                    </html:select></td>
                            </tr>
                        </table>
                        <input type="submit" style="margin: 16px 15px 0;"
                            class="btn btn-blue fl" id="vocation_search"
                            value="検索"/>
                        <logic:equal name="flag" scope="session"
                            value="0">
                            <input type="button"
                                style="margin: 16px 10px 0;"
                                class="btn btn-blue fl"
                                id="vocation_add" value="追加"
                                onClick="location.href='vocationAddInit.do'" />
                                 <input type="button"
                                style="margin: 16px 10px 0;"
                                class="btn btn-blue fl"
                                id="vocation_update" value="年休更新"
                                onClick="updatenianjiaConfirm()" />
                            <input type="button"
                                style="margin: 16px 10px 0;"
                                class="btn btn-red fl"
                                id="vocation_reset" value="リセット"
                                onclick="showConfirm()" />
                                 <input type="button"
                                style="margin: 16px 15px 0;"
                                class="btn btn-blue fl"
                                id="vocation_add" value="下载"
                                onClick="location.href='vocationdownload.do'" />
                        </logic:equal>

                        <logic:equal name="flag" scope="session"
                            value="2">
                            <input type="button"
                                style="margin: 16px 15px 0;"
                                class="btn btn-blue fl"
                                id="vocation_add" value="追加"
                                onClick="location.href='vocationAddInit.do'" />
                                   <input type="button"
                                style="margin: 16px 10px 0;"
                                class="btn btn-blue fl"
                                id="vocation_update" value="年休更新"
                                onClick="updatenianjiaConfirm()" />
                            <input type="button"
                                style="margin: 16px 15px 0;"
                                class="btn btn-red fl"
                                id="vocation_reset" value="リセット"
                                onclick="showConfirm()" />
                                 <input type="button"
                                style="margin: 16px 15px 0;"
                                class="btn btn-blue fl"
                                id="vocation_add" value="下载"
                                onClick="location.href='vocationdownload.do'" />


                        </logic:equal>
                    </div>
                </ts:form>


                <ts:pageLinks id="JNTCIVocationPageLinks"
                    action="/revocationSelect?deptId1=${_JNTCIVocationForm.deptId1}&usernameSelect=${_JNTCIVocationForm.usernameSelect}"
                    name="_JNTCIVocationForm" rowProperty="row"
                    totalProperty="totalCount"
                    indexProperty="startIndex" currentPageIndex="now"
                    totalPageCount="total" />

                <hr style="margin:18px 0 5px 0"/>
                <logic:notEmpty name="_JNTCIVocationForm"
                    property="users">
                    <table class="ctn" width="100%" id="vocation_tbl">
                        <caption>社員年休一覧</caption>
                        <tr>
                            <th>社員カード</th>
                            <th>社員名前</th>
                            <th>性別</th>
                            <th>部門所属</th>
                            <th>年假总数</th>
                            <th>残り時間</th>
                            <th>1月</th>
                            <th>2月</th>
                            <th>3月</th>
                            <th>4月</th>
                            <th>5月</th>
                            <th>6月</th>
                            <th>7月</th>
                            <th>8月</th>
                            <th>9月</th>
                            <th>10月</th>
                            <th>11月</th>
                            <th>12月</th>
                            <th style="width: 15%;">操作</th>
                        </tr>
                        <logic:iterate id="userBean"
                            name="_JNTCIVocationForm" property="users"
                            indexId="index">
                            <form action="/tutorial-thin/revocation.do"
                                method="post">
                                <tr>
                                    <td align="center"><bean:write
                                            name="userBean"
                                            property="userId" />
                                     <html:hidden property="startIndex" name="_JNTCIVocationForm"/>
                                     <html:hidden property="userSelectId" name="_JNTCIVocationForm"/>
                                     <html:hidden property="usernameSelect" name="_JNTCIVocationForm"/>
                                     <html:hidden property="deptId1" name="_JNTCIVocationForm"/>
                                    </td>
                                    <td><bean:write name="userBean"
                                            property="userName" /></td>
                                    <td align="center"><bean:write
                                            name="userBean"
                                            property="userSex" /></td>
                                    <td align="right"><bean:write
                                            name="userBean"
                                            property="deptId" /></td>
                                    <td><bean:write name="userBean"
                                            property="nianjia" /></td>
                                    <td><bean:write name="userBean"
                                            property="remainDays" /></td>
                                    <td><bean:write name="userBean"
                                            property="january" /></td>
                                    <td><bean:write name="userBean"
                                            property="february" /></td>
                                    <td><bean:write name="userBean"
                                            property="march" /></td>
                                    <td><bean:write name="userBean"
                                            property="april" /></td>
                                    <td><bean:write name="userBean"
                                            property="may" /></td>
                                    <td><bean:write name="userBean"
                                            property="june" /></td>
                                    <td><bean:write name="userBean"
                                            property="july" /></td>
                                    <td><bean:write name="userBean"
                                            property="august" /></td>
                                    <td><bean:write name="userBean"
                                            property="september" /></td>
                                    <td><bean:write name="userBean"
                                            property="octorber" /></td>
                                    <td><bean:write name="userBean"
                                            property="november" /></td>
                                    <td><bean:write name="userBean"
                                            property="december" /></td>
                                    <td><input type="hidden"
                                        name="userId"
                                        value="<bean:write name="userBean"  property="userId"/>" />
                                        <input type="hidden" name="updeflag"
                                        id=index value="" /> <logic:equal
                                            name="flag" scope="session"
                                            value="0">
                                            <input type="submit"
                                                value="削除"
                                                class="btn btn-red"
                                                onclick="onSubimitfun(1,index)" />
                                            <input type="submit"
                                                value="修正"
                                                class="btn btn-blue"
                                                onclick="onSubimitfun(2,index)" />
                                        </logic:equal>
                                        <logic:equal name="flag" scope="session"
                                            value="1">
                                            <input type="button"
                                                value="削除"
                                                class="btn btn-red" disabled="disabled" />
                                            <input type="button"
                                                value="修正"
                                                class="btn btn-blue" disabled="disabled" />
                                        </logic:equal>
                                         <logic:equal name="flag" scope="session"
                                            value="7">
                                            <input type="button"
                                                value="削除"
                                                class="btn btn-red" disabled="disabled" />
                                            <input type="button"
                                                value="修正"
                                                class="btn btn-blue" disabled="disabled" />
                                        </logic:equal>
                                        <logic:equal name="flag"
                                            scope="session" value="2">
                                            <input type="submit"
                                                value="削除"
                                                class="btn btn-red"
                                                onclick="onSubimitfun(1,index)" />
                                            <input type="submit"
                                                value="修正"
                                                class="btn btn-blue"
                                                onclick="onSubimitfun(2,index)" />
                                        </logic:equal>
                                        <logic:equal
                                            name="flag" scope="session"
                                            value="3">
                                            <input type="button"
                                                value="削除"
                                                class="btn btn-red" disabled="disabled" />
                                            <input type="button"
                                                value="修正"
                                                class="btn btn-blue" disabled="disabled" />
                                        </logic:equal>
                                        <logic:equal
                                            name="flag" scope="session"
                                            value="4">
                                            <input type="button"
                                                value="削除"
                                                class="btn btn-red" disabled="disabled" />
                                            <input type="button"
                                                value="修正"
                                                class="btn btn-blue" disabled="disabled" />
                                        </logic:equal>
                                        <logic:equal
                                            name="flag" scope="session"
                                            value="5">
                                            <input type="button"
                                                value="削除"
                                                class="btn btn-red" disabled="disabled"  />
                                            <input type="button"
                                                value="修正"
                                                class="btn btn-blue" disabled="disabled" />
                                        </logic:equal>
                                        <logic:equal
                                            name="flag" scope="session"
                                            value="6">
                                            <input type="button"
                                                value="削除"
                                                class="btn btn-red" disabled="disabled" />
                                            <input type="button"
                                                value="修正"
                                                class="btn btn-blue" disabled="disabled" />
                                        </logic:equal></td>
                                </tr>
                            </form>
                        </logic:iterate>

                    </table>
                    <div class="pagination">
                        <ul>
                            <li>計<b><bean:write
                                        name="_JNTCIVocationForm"
                                        property="totalCount" /></b>レコード
                            </li>
                            <li><bean:write name="now" />/<bean:write
                                    name="total" /></li>
                            <li><bean:write
                                    name="JNTCIVocationPageLinks"
                                    filter="false" /></li>
                        </ul>
                    </div>
                </logic:notEmpty>
                <div class="footer">
                    <p>
                        連絡メール：<a href="mailto:jinan@trans-cosmos.com.cn"
                            target="_blank">jinan@trans-cosmos.com.cn</a>
                    </p>
                </div>
            </div>
        </div>
    </div>
</body>
</html:html>