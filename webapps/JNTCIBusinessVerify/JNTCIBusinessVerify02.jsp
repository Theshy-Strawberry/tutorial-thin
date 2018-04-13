<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="/struts-html" prefix="html"%>
<%@ taglib uri="/struts-bean" prefix="bean"%>
<%@ taglib uri="/struts-logic" prefix="logic"%>
<%@ taglib uri="/terasoluna-struts" prefix="ts"%>
<%@ taglib uri="/terasoluna" prefix="t"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>出張審査</title>
<link rel="stylesheet" type="text/css" href="css/base.css" />
<link rel="stylesheet" type="text/css" href="css/main.css" />
<link rel="stylesheet" type="text/css" href="Style/skin.css" />
<script src="http://libs.baidu.com/jquery/1.9.0/jquery.js"
    type="text/javascript"></script>
<script type="text/javascript" src="js/jquery-1.11.3.min.js"></script>
<script type="text/javascript">
    $(function() {
        $('#left-container .content').hide();
        $('#Attendance').show();
        $('h2.tit').click(function() {
            $(this).next('.content').stop().slideToggle();

        })
    })
</script>
<script>
    $(document).ready(function() {
    	 var userId = document.getElementById("userId").value;
        $("#articleSelect").click(function() {
            var article_NAME = "";
            $("[type='checkbox']").each(function() {
                if (this.checked == true) {
                    article_NAME += $(this).val() + ";";
                }
                article = article_NAME.substring(0, article_NAME.length - 1);
            });
            $("#article_NAME").val(article);
        });
        if (userId == "1002" || userId == "1003" || userId == "1004"
            || userId == "1001") {

        $('#GL').hide();
    }
        }
    });
</script>
<script type="text/javascript">
    $(function() {

        var value = $("#managerCheckOut").val();
        if (value != null || value != "") {
            $("#examineName option[value='" + value + "']").attr("selected",
                    false);
            $("#examineName option[value='" + value + "']").attr("selected",
                    true);
        }

        $("#examineName").change(
                function() {
                    var dropBox = $("#examineName").val();
                    if (dropBox != "") {

                        $("#examineName option[value='" + dropBox + "']").attr(
                                "selected", true);
                    }
                })
    });
</script>
<script type="text/javascript">
    function onSubimitfun(type) {
        var flag = document.getElementById("flag").value;
        var userId = document.getElementById("userId").value;
        var user='<bean:write name="userId" scope="session" />';
        if (flag == "4") {
            if (type == "1") {
                $("#examineStatus").val("A01");
            } else if(type == "2"){
                $("#examineStatus").val("A07");
            }else{
            	$("#examineStatus").val("A04");
            }
        }
        else if (flag == "1") {
            if (type == "1") {
            	 if(user=="1003"){$("#examineStatus").val("A08");}
            	 else if(user=="1002"){$("#examineStatus").val("A06");}
            	 else if(user=="1004"){$("#examineStatus").val("A08");}
            } else if(type == "2") {
            	 if(user=="1003"){$("#examineStatus").val("A09");}
            	 else if(user=="1002"){$("#examineStatus").val("A05");}
            	 else if(user=="1004"){$("#examineStatus").val("A09");}
            }else if(type == "3"){/*
           	 if(user=="1003"){$("#examineStatus").val("A01");}
           	 else if(user=="1002"){$("#examineStatus").val("A08");}
           	 else if(user=="1004"){$("#examineStatus").val("A04");} */
           	if(user=="1003"){$("#examineStatus").val("A04");}
          	 else if(user=="1002"){$("#examineStatus").val("A04");}
          	 else if(user=="1004"){$("#examineStatus").val("A04");}
           }else{}
        }
        $("#form1").submit();
    }
</script>
<script type="text/javascript">
    function subimit() {
        $("#examineStatus").val("back");
        $("#form1").submit();
    }
</script>
<script type="text/javascript">
    function getf() {
        var examineStatus = document.getElementById("examineStatus").value
        var userId = document.getElementById("userId").value
        if (userId == "1002" || userId == "1003" || userId == "1004"
                || userId == "1001") {
           $('#GL').hide();
        } else if (userId == "1072") {
        	 $('#agree').hide();
             $('#disagree').hide();
             $('#back').hide();
             $('#GL').hide();
        }
        var flag = document.getElementById("flag").value
        if (flag == "4") {
        	$('#GL').hide();
            if (examineStatus == "A07") {
                $('#disagree').attr('disabled', "true");
            }
            if (examineStatus == "A01") {
                $('#agree').attr('disabled', "true");
                $('#GL').hide();
            }
            if (examineStatus == "A05" || examineStatus == "A06" || examineStatus == "A08" || examineStatus == "A09") {
                $('#agree').hide();
                $('#disagree').hide();
                $('#back').hide();
                $('#GL').hide();
            }
        }
        if (flag == "1") {
        	if(userId=="1002"){
        		 if (examineStatus == "A05") {
                     $('#disagree').attr('disabled', "true");

                 }
                 if (examineStatus == "A06") {
                     $('#agree').attr('disabled', "true");
                 }
                 if (examineStatus == "A09") {
                     $('#agree').hide();
                     $('#disagree').hide();
                     $('#GL').hide();
                     $('#back').hide();
                 }
        	}else{
        		 if (examineStatus == "A09") {
                     $('#disagree').attr('disabled', "true");
                 }
                 if (examineStatus == "A08") {
                     $('#agree').attr('disabled', "true");
                 }
                 if (examineStatus == "A05" || examineStatus == "A06") {
                     $('#agree').hide();
                     $('#disagree').hide();
                     $('#GL').hide();
                     $('#back').hide();
                 }
        	}
        }
    }
</script>
</head>

<body onload="getf();">
    <!--头部分 -->
    <div>
        <jsp:include page="/top.jsp" flush="true" />
        <input id="flag" type="hidden"
            value="<bean:write name="flag" scope="session" />" /> <input
            id="userId" type="hidden"
            value="<bean:write name="userId" scope="session" />" />
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
                </ul>
            </div>
            <div class="main-ctn"
                style="max-height: 100px; overflow: auto;">
                <html:errors />
                <html:messages id="message" message="true">
                    <bean:write name="message" />
                </html:messages>
            </div>
            <div class="main-ctn self-info">
                <div class="clearfix">
                    <ts:form action="/JNTCIBusinessVerify02BL"
                        method="post" styleId="form1">
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

                                <td>天津社員カード:</td>
                                <td><bean:write
                                        name="_JNTCIBusinessVerifyForm01"
                                        property="tjUserId" /> <input
                                    type="hidden" name="startIndex"
                                    value="<bean:write name="_JNTCIBusinessVerifyForm01" property="startIndex"/>" />
                                    <input type="hidden" name="user_Id"
                                    value="<bean:write name="_JNTCIBusinessVerifyForm01" property="user_Id"/>" />
                                </td>
                                <td>社員カード：</td>
                                <td><bean:write
                                        name="_JNTCIBusinessVerifyForm01"
                                        property="uid1" /> <input
                                    type="hidden" name="evectionId"
                                    value="<bean:write name="_JNTCIBusinessVerifyForm01" property="evectionId"/>" />
                                </td>
                                <td rowspan="9"></td>
                            </tr>
                            <tr>
                                <td>社員名前：</td>
                                <td><bean:write
                                        name="_JNTCIBusinessVerifyForm01"
                                        property="uname1" /> <html:hidden
                                        name="_JNTCIBusinessVerifyForm01"
                                        property="uname1" /> <html:hidden
                                        name="_JNTCIBusinessVerifyForm01"
                                        property="user_Name" /> <html:hidden
                                        name="_JNTCIBusinessVerifyForm01"
                                        property="dept_Id" /> <html:hidden
                                        name="_JNTCIBusinessVerifyForm01"
                                        property="examine_Status" /></td>
                                <td>所属部門：</td>
                                <td><bean:write
                                        name="_JNTCIBusinessVerifyForm01"
                                        property="deptId" /></td>
                            </tr>
                            <tr>
                                <td>性别：</td>
                                <td colspan="4"><bean:write
                                        name="_JNTCIBusinessVerifyForm01"
                                        property="sex" /></td>
                            </tr>
                            <tr>
                                <td>出張先：</td>
                                <td><bean:write
                                        name="_JNTCIBusinessVerifyForm01"
                                        property="evectionDestination" /></td>

                                <td>职位编号：</td>
                                <td><bean:write
                                        name="_JNTCIBusinessVerifyForm01"
                                        property="positionId" /></td>
                            </tr>
                            <tr>
                                <td>プロジェクト番号：</td>
                                <td><bean:write
                                        name="_JNTCIBusinessVerifyForm01"
                                        property="projectId" /></td>
                                <td>プロジェクト名：</td>
                                <td><bean:write
                                        name="_JNTCIBusinessVerifyForm01"
                                        property="projectName" /></td>
                            </tr>
                            <tr>
                                <td>労働关系属地：</td>
                                <td><bean:write
                                        name="_JNTCIBusinessVerifyForm01"
                                        property="dependency" /></td>
                                <td>部門PM：</td>
                                <td><bean:write
                                        name="_JNTCIBusinessVerifyForm01"
                                        property="projectPm" /></td>

                            </tr>
                            <tr>
                            </tr>
                            <tr>
                                <td width="580">出張時間：</td>
                                <td><bean:write
                                        name="_JNTCIBusinessVerifyForm01"
                                        property="evectionStartTime" />
                                    <html:hidden
                                        property="evectionStartTime"
                                        name="_JNTCIBusinessVerifyForm01" /></td>
                                <td>终了時間：</td>
                                <td><bean:write
                                        name="_JNTCIBusinessVerifyForm01"
                                        property="evectionEndTime" /> <html:hidden
                                        property="evectionEndTime"
                                        name="_JNTCIBusinessVerifyForm01" /></td>
                            </tr>
                            <tr>
                                <td>出張天数：</td>
                                <td colspan="4"><bean:write
                                        name="_JNTCIBusinessVerifyForm01"
                                        property="businessDays" /></td>
                            </tr>
                            <tr>
                                <td>出張原因：</td>
                                <td colspan="4"><bean:write
                                        name="_JNTCIBusinessVerifyForm01"
                                        property="evectionReason" /></td>
                            </tr>
                        </table>
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

                                <td>Id カード： <html:hidden
                                        styleId="examineStatus"
                                        name="_JNTCIBusinessVerifyForm01"
                                        property="examineStatus"></html:hidden></td>
                                <td><bean:write
                                        name="_JNTCIBusinessVerifyForm01"
                                        property="idCard" /></td>
                                <td>出発時間：</td>
                                <td><bean:write
                                        name="_JNTCIBusinessVerifyForm01"
                                        property="departureTime" /></td>
                                <td rowspan="6"></td>
                            </tr>
                            <tr>
                                <td>パスポート：</td>
                                <td><bean:write
                                        name="_JNTCIBusinessVerifyForm01"
                                        property="passport" /></td>
                                <td>ビザ：</td>
                                <td><bean:write
                                        name="_JNTCIBusinessVerifyForm01"
                                        property="visa" /></td>
                            </tr>
                            <tr>

                                <td>パスポート番号：</td>
                                <td><bean:write
                                        name="_JNTCIBusinessVerifyForm01"
                                        property="passportId" /></td>
                                <td>パスポート有効期：</td>
                                <td><bean:write
                                        name="_JNTCIBusinessVerifyForm01"
                                        property="passportValidity" /></td>
                            </tr>
                            <tr>
                                <td>出発場所：</td>
                                <td><bean:write
                                        name="_JNTCIBusinessVerifyForm01"
                                        property="leave" /></td>
                                <td>到着場所：</td>
                                <td><bean:write
                                        name="_JNTCIBusinessVerifyForm01"
                                        property="reachPlace" /></td>
                            </tr>
                            <tr>
                                <td>名前ピンイン：</td>
                                <td><bean:write
                                        name="_JNTCIBusinessVerifyForm01"
                                        property="namePinyin" /></td>
                                <td>交通担当者：</td>
                                <td><bean:write
                                        name="_JNTCIBusinessVerifyForm01"
                                        property="trafficReservePerson" /></td>
                            </tr>
                            <tr>
                                <td>交通說明 ：</td>
                                <td colspan="4"><bean:write
                                        name="_JNTCIBusinessVerifyForm01"
                                        property="trafficExplain" /></td>
                            </tr>
                        </table>
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
                                        name="_JNTCIBusinessVerifyForm01"
                                        property="hotelStartTime" /></td>
                                <td>退宿時間 ：</td>
                                <td><bean:write
                                        name="_JNTCIBusinessVerifyForm01"
                                        property="hotelEndtime" /></td>
                                <td rowspan="4"></td>
                            </tr>
                            <tr>
                                <td>宿泊場所 ：</td>
                                <td><bean:write
                                        name="_JNTCIBusinessVerifyForm01"
                                        property="hotelDestination" /></td>
                                <td>宿泊人：</td>
                                <td><bean:write
                                        name="_JNTCIBusinessVerifyForm01"
                                        property="hotelPerson" /></td>
                            </tr>
                            <tr>
                                <td>宿泊人數：</td>
                                <td><bean:write
                                        name="_JNTCIBusinessVerifyForm01"
                                        property="hotelNumber" /></td>
                                <td>予約担当者 ：</td>
                                <td><bean:write
                                        name="_JNTCIBusinessVerifyForm01"
                                        property="hotelReservePerson" /></td>
                            </tr>
                            <tr>
                                <td>需求説明：</td>
                                <td colspan="4"><bean:write
                                        name="_JNTCIBusinessVerifyForm01"
                                        property="hotelExplain" /></td>
                            </tr>
                            <tr>
                                <th colspan="5">出張期間の物渡し</th>
                            </tr>
                        </table>
                        <ul
                            style="padding: 15px 0 5px 137px; font-size: 13px; font-weight: bold;">
                            <li id="articleSelect">物品名称：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<html:hidden
                                    property="articleName"
                                    name="_JNTCIBusinessVerifyForm01"
                                    styleId="article_NAME" /> <html:multibox
                                    name="_JNTCIBusinessVerifyForm01"
                                    property="article_NAME" value="1"
                                    onclick="return false;" />食事カード <html:multibox
                                    name="_JNTCIBusinessVerifyForm01"
                                    property="article_NAME" value="2"
                                    onclick="return false;" />パソコン設備 <html:multibox
                                    name="_JNTCIBusinessVerifyForm01"
                                    property="article_NAME" value="3"
                                    onclick="return false;" />個人所有物 <html:multibox
                                    name="_JNTCIBusinessVerifyForm01"
                                    property="article_NAME" value="4"
                                    onclick="return false;" />出勤考勤备案 <html:multibox
                                    name="_JNTCIBusinessVerifyForm01"
                                    property="article_NAME" value="5"
                                    onclick="return false;" />パスポート/出張マニュアル <html:multibox
                                    name="_JNTCIBusinessVerifyForm01"
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
                                        name="_JNTCIBusinessVerifyForm01"
                                        property="transferStartTime" /></td>
                                <td>移管終了時間：</td>
                                <td><bean:write
                                        name="_JNTCIBusinessVerifyForm01"
                                        property="transferEndTime" /></td>
                                <td rowspan="5"></td>

                            </tr>
                            <tr>
                                <td>受取人：</td>
                                <td><bean:write
                                        name="_JNTCIBusinessVerifyForm01"
                                        property="recipient" /></td>

                                <td>個人所有物保存先：</td>
                                <td><bean:write
                                        name="_JNTCIBusinessVerifyForm01"
                                        property="storAges" /></td>
                            </tr>
                            <tr>
                                <td>ビザ長短：</td>
                                <td colspan="4"><bean:write
                                        name="_JNTCIBusinessVerifyForm01"
                                        property="passportLength" /></td>
                            </tr>
                            <tr>
                                <td>コメント：</td>
                                <td colspan="4"><bean:write
                                        name="_JNTCIBusinessVerifyForm01"
                                        property="articleRemark" /></td>
                            </tr>
                            <tr id="GL">
                                <td ><label>審査者： <input
                                        type="hidden"
                                        id="managerCheckOut"
                                        value="<bean:write name="_JNTCIBusinessVerifyForm01" property="examinePerson"/>" />
                                </label></td>
                                <td colspan="4"><html:select
                                        styleId="examineName"
                                        name="_JNTCIBusinessVerifyForm01"
                                        property="examinePerson"
                                        style="width=200px;">
                                        <option value=""></option>
                                        <logic:notEmpty
                                            name="_JNTCIBusinessVerifyForm01"
                                            property="examinePersonList">
                                            <logic:iterate
                                                id="examinePerson"
                                                name="_JNTCIBusinessVerifyForm01"
                                                property="examinePersonList">
                                                <option
                                                    value="<bean:write name="examinePerson" property="examinePerson"/>">
                                                    <bean:write
                                                        name="examinePerson"
                                                        property="examinePerson" /></option>
                                            </logic:iterate>
                                        </logic:notEmpty>

                                    </html:select></td>
                            </tr>
                        </table>
                        <ul>
                            <li
                                style="display: inline-block; padding: 25px 0 0 20%;"
                                id="GL1"><html:hidden
                                    styleId="examineStatus"
                                    name="_JNTCIBusinessVerifyForm01"
                                    property="examineStatus"></html:hidden>
                                <input name="承認" id="agree"
                                type="button"
                                style="min-width: 70px; margin-right: 20px"
                                class="btn btn-blue" value="承認"
                                onclick="onSubimitfun(1)" /> <input
                                name="承認しない" id="disagree" type="button"
                                class="btn btn-red" value="承認しない"
                                onclick="onSubimitfun(2)" /></li>
                            <li
                                style="display: inline-block; margin-left: 20px"><input
                                id="getback" name="戻る" type="button"
                                class="btn btn-green" value="戻る"
                                onclick="subimit()" />
                                <input
							  id="back"  name="back" type="button"
							  style="min-width: 70px; margin-left: 20px"
							  class="btn btn-blue" value="差戻し"
							  onclick="onSubimitfun(3)" />
                            </li>
                                </li>
                        </ul>
                    </ts:form>
                </div>
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
