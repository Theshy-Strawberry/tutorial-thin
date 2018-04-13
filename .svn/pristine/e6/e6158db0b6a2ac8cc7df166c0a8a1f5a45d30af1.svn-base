<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="/struts-html" prefix="html"%>
<%@ taglib uri="/struts-bean" prefix="bean"%>
<%@ taglib uri="/struts-logic" prefix="logic"%>
<%@ taglib uri="/terasoluna-struts" prefix="ts"%>
<%@ taglib uri="/terasoluna" prefix="t"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>出張申請一覧</title>
<link rel="stylesheet" type="text/css" href="css/base.css" />
<link rel="stylesheet" type="text/css" href="css/main.css" />

<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/laydate/laydate.js"></script>
<script type="text/javascript" src="js/JNTCIPersonInfo.js"></script>

<script type="text/javascript">
    $(function() {
        $('#left-container .content').hide();
        $('#Attendance').show();
        $('h2.tit').click(function() {
            $(this).next('.content').stop().slideToggle();

        })
    })
</script>
<script type="text/javascript">
    $(function() {
        $(".display").each(function(index) {
            if (index != 0) {
                $(this).text("");
            }
        });
    });

    function getMethod() {
        var Type = document.getElementById("evectionType").value;
        if (Type == 1) {
            $('#traffic').hide();
        } else if (Type != 1) {
            $('#traffic').show();

        }
    }
</script>
<script>
    $(document).ready(function() {
        $("#articleSelect").click(function() {
            var article_NAME = "";
            $("[type='multibox']").each(function() {
                if (this.checked == true) {
                    article_NAME += $(this).val() + ";";
                }
                article = article_NAME.substring(0, article_NAME.length - 1);
            });
            $("#article_NAME").val(article);
        });
    });
</script>
<script type="text/javascript">
    function subimit() {
        $("#back").val("back");
        $("#loginForm1").submit();
    }
</script>
</head>
<style>
body {
    font-family: "Microsoft YaHei";
    font-weight: normal;
    margin: 0;
}
</style>
<body onload="getMethod()">

    <!--头部分 -->
    <div>
        <jsp:include page="/top.jsp" flush="true" />
    </div>
    <!--/头部分 -->
    <div style="position: relative;">
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
                    <li><a href="#">出張審査</a></li>
                    <li class="ico">&gt;</li>
                    <li><a href="#">出張審査詳細</a></li>
                </ul>
            </div>
            <div class="main-ctn self-info">
                <div class="clearfix">
                </div>
                <html:form action="/JNTCIBusinessVerifyBL"  styleId="loginForm1"
                        method="post">
                <table width="100%">
                    <colgroup>
                        <col width="70px" />
                        <col width="80px" />
                        <col width="70px" />
                        <col width="100px" />
                        <col width="180px" />
                    </colgroup>
                    <tr>
                        <th colspan="5">個人情報</th>
                    </tr>
                    <tr>
                        <td><i class="red">*</i>天津社員カード:
                        <input
                                    type="hidden" id="back" name="back"
                                    value="" /></td>
                        <td><bean:write
                                name="_JNTCIBusinessVerifyDetailedForm"
                                property="tjUserId" />
                                </td>
                        <td><i class="red">*</i>济南カード：</td>
                        <td><bean:write
                                name="_JNTCIBusinessVerifyDetailedForm"
                                property="userId" /></td>
                        <td rowspan="9"></td>
                    </tr>
                    <tr>
                        <td><i class="red">*</i>申請者名前：</td>
                        <td><bean:write
                                name="_JNTCIBusinessVerifyDetailedForm"
                                property="userName" /></td>
                        <td>所属部門：</td>
                        <td><bean:write
                                name="_JNTCIBusinessVerifyDetailedForm"
                                property="deptId" /></td>
                    </tr>
                    <tr>
                        <td>性别：</td>
                        <td colspan="3"><bean:write
                                name="_JNTCIBusinessVerifyDetailedForm"
                                property="sex" /></td>
                    </tr>
                    <tr>
                        <td>出張先：</td>
                        <td><bean:write
                                name="_JNTCIBusinessVerifyDetailedForm"
                                property="evectionDestination" /></td>
                        <td>职位编号：</td>
                        <td><bean:write
                                name="_JNTCIBusinessVerifyDetailedForm"
                                property="positionId" /></td>
                    </tr>
                    <tr>
                        <td>プロジェクト番号：</td>
                        <td><bean:write
                                name="_JNTCIBusinessVerifyDetailedForm"
                                property="projectId" /></td>
                        <td>プロジェクト名：</td>
                        <td><bean:write
                                name="_JNTCIBusinessVerifyDetailedForm"
                                property="projectName" /></td>
                    </tr>
                    <tr>
                        <td>労働关系属地：</td>
                        <td><bean:write
                                name="_JNTCIBusinessVerifyDetailedForm"
                                property="dependency" />

                                     <html:hidden property="startIndex" name="_JNTCIBusinessVerifyDetailedForm"/>
                                     <html:hidden property="user_Id" name="_JNTCIBusinessVerifyDetailedForm"/>
                                     <html:hidden property="user_Name" name="_JNTCIBusinessVerifyDetailedForm"/>
                                     <html:hidden property="dept_Id" name="_JNTCIBusinessVerifyDetailedForm"/>
                                     <html:hidden property="examine_Status" name="_JNTCIBusinessVerifyDetailedForm"/>
                                     <html:hidden property="evectionId" name="_JNTCIBusinessVerifyDetailedForm"/>
                                </td>
                        <td>部門PM：</td>
                        <td><bean:write
                                name="_JNTCIBusinessVerifyDetailedForm"
                                property="projectPm" /></td>

                    </tr>
                    <tr>
                        <td>開始時間：</td>
                        <td><bean:write
                                name="_JNTCIBusinessVerifyDetailedForm"
                                property="evectionStartTime" /></td>
                        <td>终了時間：</td>
                        <td><bean:write
                                name="_JNTCIBusinessVerifyDetailedForm"
                                property="evectionEndTime" /></td>
                    </tr>
                    <tr>
                        <td>出張日数：</td>
                        <td colspan="3"><bean:write
                                name="_JNTCIBusinessVerifyDetailedForm"
                                property="businessDays" /></td>
                    </tr>
                    <tr>
                        <td>出張任务描述：</td>
                        <td colspan="3"><bean:write
                                name="_JNTCIBusinessVerifyDetailedForm"
                                property="evectionReason" /></td>
                    </tr>
                </table>
                <div id="traffic">
                    <table width="100%" id="traffic">
                        <colgroup>
                            <col width="70px" />
                            <col width="80px" />
                            <col width="70px" />
                            <col width="100px" />
                            <col width="180px" />
                        </colgroup>

                        <tr>
                            <th colspan="5">交通手段予約</th>
                        </tr>
                        <tr>
                            <td>Id カード：</td>
                            <td><bean:write
                                    name="_JNTCIBusinessVerifyDetailedForm"
                                    property="idCard" /></td>
                            <td>出張時間：</td>
                            <td><bean:write
                                    name="_JNTCIBusinessVerifyDetailedForm"
                                    property="departureTime" /></td>
                            <td rowspan="6"></td>
                        </tr>
                        <tr>
                            <td>パスポート：</td>
                            <td><bean:write
                                    name="_JNTCIBusinessVerifyDetailedForm"
                                    property="passport" /></td>
                            <td>ビザ：</td>
                            <td><bean:write
                                    name="_JNTCIBusinessVerifyDetailedForm"
                                    property="visa" /></td>
                        </tr>
                        <tr>
                            <td>パスポート番号：</td>
                            <td><bean:write
                                    name="_JNTCIBusinessVerifyDetailedForm"
                                    property="passportId" /></td>
                            <td>パスポート有効期:</td>
                            <td><bean:write
                                    name="_JNTCIBusinessVerifyDetailedForm"
                                    property="passportValidity" /></td>
                        </tr>
                        <tr>
                            <td>出発場所：</td>
                            <td><bean:write
                                    name="_JNTCIBusinessVerifyDetailedForm"
                                    property="leave" /></td>
                            <td>到着場所：</td>
                            <td><bean:write
                                    name="_JNTCIBusinessVerifyDetailedForm"
                                    property="reachPlace" /></td>
                        </tr>
                        <tr>
                            <td>名前ピンイン：</td>
                            <td><bean:write
                                    name="_JNTCIBusinessVerifyDetailedForm"
                                    property="namePinyin" /></td>
                            <td>予約担当者：</td>
                            <td><bean:write
                                    name="_JNTCIBusinessVerifyDetailedForm"
                                    property="trafficReservePerson" /></td>
                        </tr>
                        <tr>
                            <td>需求說明 ：</td>
                            <td colspan="3"><bean:write
                                    name="_JNTCIBusinessVerifyDetailedForm"
                                    property="trafficExplain" /></td>
                        </tr>
                    </table>
                </div>
                <table width="100%">
                    <colgroup>
                        <col width="70px" />
                        <col width="80px" />
                        <col width="70px" />
                        <col width="100px" />
                        <col width="180px" />
                    </colgroup>
                    <tr>
                        <th colspan="5">宿泊予約</th>
                    </tr>
                    <tr>
                        <td>宿泊時間：</td>
                        <td><bean:write
                                name="_JNTCIBusinessVerifyDetailedForm"
                                property="hotelStartTime" /></td>
                        <td>退宿時間 ：</td>
                        <td><bean:write
                                name="_JNTCIBusinessVerifyDetailedForm"
                                property="hotelEndtime" /></td>
                        <td rowspan="4"></td>
                    </tr>
                    <tr>
                        <td>宿泊場所 ：</td>
                        <td><bean:write
                                name="_JNTCIBusinessVerifyDetailedForm"
                                property="hotelDestination" /></td>
                        <td>宿泊人：</td>
                        <td><bean:write
                                name="_JNTCIBusinessVerifyDetailedForm"
                                property="hotelPerson" /></td>
                    </tr>
                    <tr>
                        <td>宿泊人數：</td>
                        <td><bean:write
                                name="_JNTCIBusinessVerifyDetailedForm"
                                property="hotelNumber" /></td>
                        <td>予約担当者 ：</td>
                        <td><bean:write
                                name="_JNTCIBusinessVerifyDetailedForm"
                                property="hotelReservePerson" /></td>
                    </tr>
                    <tr>
                        <td>需求説明：</td>
                        <td colspan="3"><bean:write
                                name="_JNTCIBusinessVerifyDetailedForm"
                                property="hotelExplain" /></td>
                    <tr>
                        <th colspan="5">出張期間の物渡し</th>
                    </tr>
                </table>
                <ul
                    style="padding: 15px 0 5px 137px; font-size: 13px; font-weight: bold;">
                    <li id="articleSelect">物品名称：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<html:hidden
                            property="articleName"
                            name="_JNTCIBusinessVerifyDetailedForm"
                            styleId="article_NAME" /> <html:multibox
                            name="_JNTCIBusinessVerifyDetailedForm"
                            property="article_NAME" value="1"
                            onclick="return false;" />食事カード <html:multibox
                            name="_JNTCIBusinessVerifyDetailedForm"
                            property="article_NAME" value="2"
                            onclick="return false;" />パソコン設備 <html:multibox
                            name="_JNTCIBusinessVerifyDetailedForm"
                            property="article_NAME" value="3"
                            onclick="return false;" />個人所有物 <html:multibox
                            name="_JNTCIBusinessVerifyDetailedForm"
                            property="article_NAME" value="4"
                            onclick="return false;" />出勤考勤备案 <html:multibox
                            name="_JNTCIBusinessVerifyDetailedForm"
                            property="article_NAME" value="5"
                            onclick="return false;" />パスポート/出張マニュアル<html:multibox
                            name="_JNTCIBusinessVerifyDetailedForm"
                            property="article_NAME" value="6"
                            onclick="return false;" />herデータ審査/変更
                    </li>
                </ul>
                <table width="100%">
                    <colgroup>
                        <col width="70px" />
                        <col width="80px" />
                        <col width="70px" />
                        <col width="100px" />
                        <col width="180px" />
                    </colgroup>
                    <tr>
                        <td>移管から時間：</td>
                        <td><bean:write
                                name="_JNTCIBusinessVerifyDetailedForm"
                                property="transferStartTime" /></td>
                        <td>移管終了時間：</td>
                        <td><bean:write
                                name="_JNTCIBusinessVerifyDetailedForm"
                                property="transferEndTime" /></td>
                        <td rowspan="4"></td>
                    </tr>
                    <tr>
                        <td>受取人：</td>
                        <td><bean:write
                                name="_JNTCIBusinessVerifyDetailedForm"
                                property="recipient" /></td>

                        <td>個人所有物保存先：</td>
                        <td><bean:write
                                name="_JNTCIBusinessVerifyDetailedForm"
                                property="storAges" /></td>
                    </tr>
                    <tr>
                        <td>ビザ長短：</td>
                        <td colspan="3"><bean:write
                                name="_JNTCIBusinessVerifyDetailedForm"
                                property="passportLength" /></td>
                    </tr>
                    <tr>
                        <td>コメント：</td>
                        <td colspan="3"><bean:write
                                name="_JNTCIBusinessVerifyDetailedForm"
                                property="articleRemark" /></td>
                    </tr>
                </table>

                <div style="margin: 35px 85px">
                      <ts:submit
                                styleClass="btn btn-green" value="修正" style="margin-left: 40px;"
                                property="forward_update" />
                      <ts:submit
                                styleClass="btn btn-green" value="ダウンロード" style="margin-left: 40px;"
                                property="forward_download" />
                       <ts:submit
                                styleClass="btn btn-green" value="戻る" style="margin-left: 40px;"
                                property="forward_list"  onclick="subimit()"/>
                </div>
                </html:form>
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
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
</html>