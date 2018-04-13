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
<title>出張申請修正</title>
<link rel="stylesheet" type="text/css" href="css/base.css" />
<link rel="stylesheet" type="text/css" href="css/main.css" />
<script type="text/javascript" src="js/laydate/laydate.dev.js"></script>
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/laydate/laydate.js"></script>
<script type="text/javascript" src="js/JNTCIPersonInfo.js"></script>

<script type="text/javascript">
    $(function() {

        var dept = $("#dept").val();
        if (dept == '管理部') {
            $('#deptid option:eq(2)').attr('selected', 'selected');
        }
        if (dept == '技術開発部') {
            $('#deptid option:eq(1)').attr('selected', 'selected');
        }

        var sex = $("#sex").val();

        if (sex == '男') {
            $('#nan').attr('checked', true);
        }
        if (sex == '女') {
            $('#nv').attr('checked', true);
        }

        var passport = $("#passport").val();
        if (passport == '有') {
            $('#p-yes').attr('checked', true);
        }
        if (passport == '無') {
            $('#p-no').attr('checked', true);
        }

        var visaa = $("#visa").val();
        if (visaa == '有') {
            $('#v-yes').attr('checked', true);
        }
        if (visaa == '無') {
            $('#v-no').attr('checked', true);
        }

        var passportLength = $("#passportLength").val();
        if (passportLength == '長签') {
            $('#p-ch').attr('checked', true);
        }
        if (passportLength == '短签') {
            $('#p-du').attr('checked', true);
        }

        $('#left-container .content').hide();
        $('#eveid').hide();
        $('#Attendance').show();
        $('h2.tit').click(function() {
            $(this).next('.content').stop().slideToggle();

        })
    })
</script>
<script type="text/javascript">
 $(function(){
  $("#p-no").click(function(){
	  $("#passport_ID").attr("disabled",true);
	  $("#passport_ID").css("background-color","#E3E3E3");
	  $("#passportValidity").attr("disabled",true);
	  $("#passportValidity").css("background-color","#E3E3E3");
  });
  $("#p-yes").click(function(){
	  $("#passport_ID").attr("disabled",false);
	  $("#passport_ID").css("background-color","#FFFFFF");
	  $("#passportValidity").attr("disabled",false);
	  $("#passportValidity").css("background-color","#FFFFFF");
  });
 });
</script>
<!-- 移交物品的选择 -->
<script>
    $(document).ready(function() {
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
    });

</script>
<script>
    $(function() {

        $(".readonly").attr("readonly", true);
        $(".readonly").attr("style", "background-color:#DDDDDD")
    });
</script>
<script type="text/javascript">
    $(function() {
        $(".display").each(function(index) {
            if (index != 0) {
                $(this).text("");
            }
        });
    });
</script>
<script type="text/javascript">
    $(function() {
        $(function() {
            $("body")
                    .mouseover(
                            function() {
                                var startDateTimeValue1 = $("#startDateTime").val().substring(0, 10);
                                var startDateTimeValue2 = $("#endDateTime").val().substring(0, 10);
                                var departure_TIMEValue = $("#departure_TIME").val().substring(0, 10);
                                var hotel_STARTTIMEValue= $("#hotel_STARTTIME").val().substring(0, 10);
                                var hotel_ENDTIMEValue= $("#hotel_ENDTIME").val().substring(0, 10);
                                var transfer_STARTTIMEValue=$("#transfer_STARTTIME").val().substring(0, 10);
                                var transfer_ENDTIMEValue=$("#transfer_ENDTIME").val().substring(0, 10);
                                startDateTimeValue1 = startDateTimeValue1.split("-");
                                startDateTimeValue2 = startDateTimeValue2.split("-");
                                departure_TIMEValue= departure_TIMEValue.split("-");
                                hotel_STARTTIMEValue=hotel_STARTTIMEValue.split("-");
                                hotel_ENDTIMEValue=hotel_ENDTIMEValue.split("-");
                                transfer_STARTTIMEValue=transfer_STARTTIMEValue.split("-");
                                transfer_ENDTIMEValue=transfer_ENDTIMEValue.split("-");
                                var dateFromat1 = new Date(
                                        startDateTimeValue1[0],
                                        startDateTimeValue1[1] - 1,
                                        startDateTimeValue1[2]);
                                var dateFromat2 = new Date(
                                        startDateTimeValue2[0],
                                        startDateTimeValue2[1] - 1,
                                        startDateTimeValue2[2]);
                                var departure_TIMEFromat = new Date(
                                		departure_TIMEValue[0],
                                		departure_TIMEValue[1] - 1,
                                		departure_TIMEValue[2]);
                                var hotel_STARTTIMEFromat = new Date(
                                		hotel_STARTTIMEValue[0],
                                		hotel_STARTTIMEValue[1] - 1,
                                		hotel_STARTTIMEValue[2]);
                                var  hotel_ENDTIMEFromat = new Date(
                                		 hotel_ENDTIMEValue[0],
                                		 hotel_ENDTIMEValue[1] - 1,
                                		 hotel_ENDTIMEValue[2]);
                                var   transfer_STARTTIMEFromat = new Date(
                                		 transfer_STARTTIMEValue[0],
                                		 transfer_STARTTIMEValue[1] - 1,
                                		 transfer_STARTTIMEValue[2]);
                                var   transfer_ENDTIMEFromat = new Date(
                                		transfer_ENDTIMEValue[0],
                                		transfer_ENDTIMEValue[1] - 1,
                                		transfer_ENDTIMEValue[2]);
                               if(startDateTimeValue1!=""&& startDateTimeValue2!=""){
                                if (null != dateFromat1.getTime()&&null != dateFromat2.getTime()) {

                                    if (dateFromat2.getTime() >= dateFromat1
                                            .getTime()) {
                                        var day = (dateFromat2.getTime() - dateFromat1
                                                .getTime())
                                                / (1000 * 60 * 60 * 24) + 1;
                                        $("#businessDays").val(day);
                                      if(departure_TIMEValue!=""){
                                        	  if (null != departure_TIMEFromat.getTime()) {
										if(departure_TIMEFromat.getTime() < dateFromat1.getTime()||departure_TIMEFromat.getTime()>dateFromat2.getTime()){
											 $("#timeCheck1").text("出張時間に、出張開始日と出張終了日以内の日付を入力してください！");
										}else{$("#timeCheck1").text("");}}}
																if(hotel_STARTTIMEFromat.getTime() < dateFromat1.getTime()||hotel_STARTTIMEFromat.getTime()>dateFromat2.getTime()){
																	 $("#timeCheck2").text("宿泊時間に、出張開始日と出張終了日以内の日付を入力してください！");
																}else{$("#timeCheck2").text("");}
																if(hotel_ENDTIMEFromat.getTime() < dateFromat1.getTime()||hotel_ENDTIMEFromat.getTime()>dateFromat2.getTime()){
																	 $("#timeCheck3").text("退宿時間に、出張開始日と出張終了日以内の日付を入力してください！");
																}else{$("#timeCheck3").text("");}

															 if(transfer_STARTTIMEFromat.getTime()>dateFromat1.getTime()){
																 $("#timeCheck4").text("移管開始時間に、出張開始日の前日付を入力してください！");
																}else{$("#timeCheck4").text("");}
															 if(transfer_ENDTIMEFromat.getTime()<dateFromat2.getTime()){
																 $("#timeCheck5").text("移管終了時間に、出張終了日の後日付を入力してください！");
																}else{$("#timeCheck5").text("");}
                                    } else {
                                        $("#businessDays").val("");
                                    }
                                }}
                            });
        });
    });
</script>
<script type="text/javascript">
    function subimit() {
        $("#back").val("back");
        $("#loginForm").submit();
    }
</script>
<script type="text/javascript">
$(function() {
    $(".project").click(function() {
    	var deptId =$("#deptid").val();
    	if(deptId == 002){
    		$("#Check").text("●プロジェクト名は入力必須項目です.");
    	}else{
    		$("#Check").text("");
    	}
    });
});

$(function() {
    $(".project_ID").click(function() {
    	var deptId = $("#deptid").val();
    	if(deptId == 002){
    		$("#Check").text("●プロジェクト番号は入力必須項目です.");
    	}else{
    		$("#Check").text("");
    	}
    });
});

function projectSubmit(){
	var deptId = $("#deptid").val();
	var project = $("#project").val();
	var project_ID = $("#project_ID").val();
	if(deptId == 002){
		if(project == "" || project == null){
			$("#Check").text("●プロジェクト名は入力必須項目です.");
			return false;
		}
		if(project_ID == "" || project_ID == null){
			$("#Check").text("●プロジェクト番号は入力必須項目です.");
			return false;
		}
	}
}
</script>
</head>
<body>
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
                    <li><a href="#">出張審査修正</a></li>
                </ul>
            </div>
            <div
                style="max-height: 100px; overflow: auto; width: 500px; margin-left: 40px; margin-right: 200px;">
                <label id="Check"
                            style="width: 300px; color: red"></label>
                <html:errors />
                <html:messages id="message" message="true">
                    <span style="color: green" id="spanId"><bean:write
                            name="message" /></span>
                </html:messages>
            </div>
            <!-- SmartUpload su = new SmartUpload(); -->
            <ts:form styleId="loginForm"
                action="/JNTCIBusinessVerifyDetailedUpdateBL01"
                method="POST" enctype="multipart/form-data">
                <div id="errorMessageDIV" class="main-ctn,display"
                    style="max-height: 100px; overflow: auto; color: red; padding-left: 50px"></div>
                <div class="main-ctn self-info">
                    <div class="clearfix">
                        <!-- 个人基本信息 -->
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
                            <tr id="eveid">
                                <td>出張id：</td>
                                <td colspan="3"><html:text
                                        name="_JNTCIBusinessVerifyDetailedForm"
                                        property="evectionId" />

                                        <html:hidden property="startIndex" name="_JNTCIBusinessVerifyDetailedForm"/>
                                     <html:hidden property="user_Id" name="_JNTCIBusinessVerifyDetailedForm"/>
                                     <html:hidden property="user_Name" name="_JNTCIBusinessVerifyDetailedForm"/>
                                     <html:hidden property="dept_Id" name="_JNTCIBusinessVerifyDetailedForm"/>
                                     <html:hidden property="examine_Status" name="_JNTCIBusinessVerifyDetailedForm"/>
                                     <html:hidden property="evectionId" name="_JNTCIBusinessVerifyDetailedForm"/>


                                        </td>
                                <td rowspan="10"></td>
                            </tr>
                            <tr>
                                <td><i class="red">*</i>天津社員カード：
                                <input
                                    type="hidden" id="back" name="back"
                                    value="" /></td>
                                <td class="required"><html:text
                                        name="_JNTCIBusinessVerifyDetailedForm"
                                        property="tjUserId"
                                        maxlength="4"
                                        styleClass="readonly" />
                                        <html:hidden property="tjUserId" styleId="tjUserId" name="_JNTCIBusinessVerifyDetailedForm"/>
                                        </td>
                                <td><i class="red">*</i>济南カード：</td>
                                <td class="required"><html:text
                                        name="_JNTCIBusinessVerifyDetailedForm"
                                        property="userId" maxlength="4"
                                        styleClass="readonly" /></td>
                            </tr>
                            <tr>
                                <td><i class="red">*</i>申請者名前：</td>
                                <td class="required"><html:text
                                        name="_JNTCIBusinessVerifyDetailedForm"
                                        property="userName"
                                        maxlength="4"
                                        styleClass="readonly" /></td>
                                <td>所属部門：</td>
                                <td><input type="hidden" id="dept"
                                    value="<bean:write name="_JNTCIBusinessVerifyDetailedForm" property="deptId"/>" />

                                    <t:defineCodeList id="deptIdList" />
                                    <html:select
                                        name="_JNTCIBusinessVerifyDetailedForm"
                                        property="deptId"
                                        styleId="deptid">
                                        <html:options
                                            collection="deptIdList"
                                            property="id"
                                            labelProperty="name" />
                                    </html:select></td>

                            </tr>
                            <tr>
                                <td><i class="red">*</i>性别：<input
                                    type="hidden" id="sex"
                                    value="<bean:write name="_JNTCIBusinessVerifyDetailedForm" property="sex"/>" /></td>
                                <td><html:radio styleId="nan"
                                        name="_JNTCIBusinessVerifyDetailedForm"
                                        property="sex" value="1" /> <label
                                    for="man">男</label> <html:radio
                                        styleId="nv"
                                        name="_JNTCIBusinessVerifyDetailedForm"
                                        property="sex" value="0" /> <label
                                    for="woman">女</label></td>
                                <td class="required">职位编号：</td>
                                <td><html:text
                                        name="_JNTCIBusinessVerifyDetailedForm"
                                        property="positionId"
                                        styleClass="readonly" /></td>
                            </tr>
                            <tr>
                                <td class="required">部門PM：</td>
                                <td><html:text
                                        name="_JNTCIBusinessVerifyDetailedForm"
                                        property="projectPm"
                                        styleClass="readonly" /></td>
                            </tr>
                            <tr>
                                <td>プロジェクト番号：</td>
                                <td class="project_ID"><html:text
                                        name="_JNTCIBusinessVerifyDetailedForm"
                                        property="projectId" styleId="project_ID"/></td>
                                <td>プロジェクト名：</td>
                                <td class="project"><html:text
                                        name="_JNTCIBusinessVerifyDetailedForm"
                                        property="projectName" styleId="project"/></td>
                            </tr>
                            <tr>
                                <td>労働关系属地：</td>
                                <td><html:text
                                        name="_JNTCIBusinessVerifyDetailedForm"
                                        property="dependency" /></td>
                                <td>出張先：</td>
                                <td><html:text
                                        name="_JNTCIBusinessVerifyDetailedForm"
                                        property="evectionDestination" /><i
                                    class="red">*</i></td>
                            </tr>
                            <tr>
                            <tr>
                                <td>開始時間：</td>
                                <td><html:text readonly="true"
                                        styleId="startTime"
                                        name="_JNTCIBusinessVerifyDetailedForm"
                                        property="evectionStartTime"
                                        maxlength="10"
                                        styleClass="inline laydate-icon" /><i
                                    class="red">*</i></td>
                                <td>终了時間：</td>
                                <td><html:text readonly="true"
                                        name="_JNTCIBusinessVerifyDetailedForm"
                                        property="evectionEndTime"
                                        maxlength="10" styleId="endTime"
                                        styleClass="inline laydate-icon" /><i
                                    class="red">*</i></td>
                            </tr>

                            <tr>
                                <td>出張日数：</td>
                                <td colspan="3"><html:text
                                        name="_JNTCIBusinessVerifyDetailedForm"
                                        property="businessDays"
                                        maxlength="20"
                                        styleId="businessDays" /><i
                                    class="red">*</i></td>
                            </tr>

                            <tr>
                                <td>出張任务描述：</td>
                                <td colspan="3"><html:textarea
                                        name="_JNTCIBusinessVerifyDetailedForm"
                                        property="evectionReason" /><i
                                    class="red">*</i></td>
                            </tr>
                        </table>
                    </div>
                    <!-- 交通说明 -->
                    <div id="hidden">
                        <table width="100%">
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
                                <td>身分証明書：</td>
                                <td class="required"><html:text
                                        name="_JNTCIBusinessVerifyDetailedForm"
                                        property="idCard"
                                        styleClass="readonly" /></td>
                                <td>出張時間：</td>
                                <td><html:text
                                        name="_JNTCIBusinessVerifyDetailedForm"
                                        property="departureTime"
                                        maxlength="10"
                                        styleId="leave_STARTTIME"
                                        styleClass="inline laydate-icon"
                                        readonly="true" /><label id="timeCheck1"style="width: 250px; color: red"></label></td>
                                <td rowspan="6"></td>
                            </tr>
                            <tr>
                                <td>パスポート： <input type="hidden"
                                    id="passport"
                                    value="<bean:write name="_JNTCIBusinessVerifyDetailedForm" property="passport"/>" /></td>
                                <td><html:radio styleId="p-yes"
                                        name="_JNTCIBusinessVerifyDetailedForm"
                                        property="passport" value="1" />
                                    <label for="p-yes">有</label> <html:radio
                                        styleId="p-no"
                                        name="_JNTCIBusinessVerifyDetailedForm"
                                        property="passport" value="0" />
                                    <label for="p-no">無</label></td>
                                <td>ビザ： <input type="hidden"
                                    id="visa"
                                    value="<bean:write name="_JNTCIBusinessVerifyDetailedForm" property="visa"/>" /></td>
                                <td><html:radio styleId="v-yes"
                                        name="_JNTCIBusinessVerifyDetailedForm"
                                        property="visa" value="1" /> <label
                                    for="v-yes">有</label> <html:radio
                                        styleId="v-no"
                                        name="_JNTCIBusinessVerifyDetailedForm"
                                        property="visa" value="0" /> <label
                                    for="v-no">無</label></td>
                            </tr>
                            <tr>

                                <td>パスポート番号：</td>
                                <td><html:text
                                        name="_JNTCIBusinessVerifyDetailedForm"
                                        property="passportId"
                                        maxlength="9" styleId="passport_ID"/></td>
                                <td>パスポート有効期：</td>
                                <td><html:text
                                        name="_JNTCIBusinessVerifyDetailedForm"
                                        property="passportValidity"
                                        maxlength="10"
                                        styleId="passportValidity"
                                        styleClass="inline laydate-icon"
                                        readonly="true" /></td>
                            </tr>
                            <tr>
                                <td>出発場所：</td>
                                <td><html:text
                                        name="_JNTCIBusinessVerifyDetailedForm"
                                        property="leave" /></td>
                                <td>到着場所：</td>
                                <td><html:text
                                        name="_JNTCIBusinessVerifyDetailedForm"
                                        property="reachPlace" /></td>
                            </tr>
                            <tr>
                                <td>名前ピンイン：</td>
                                <td class="required"><html:text
                                        name="_JNTCIBusinessVerifyDetailedForm"
                                        property="namePinyin"
                                        maxlength="30"
                                        styleClass="readonly" /></td>
                                <td>予約担当者：</td>
                                <td><html:text
                                        name="_JNTCIBusinessVerifyDetailedForm"
                                        property="trafficReservePerson" /></td>
                            </tr>
                            <tr>
                                <td>需求說明：</td>
                                <td colspan="3"><html:textarea
                                        name="_JNTCIBusinessVerifyDetailedForm"
                                        property="trafficExplain" /></td>
                            </tr>
                        </table>
                    </div>
                    <!-- 住宿预订需求 -->

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
                            <td><html:text
                                    name="_JNTCIBusinessVerifyDetailedForm"
                                    property="hotelStartTime"
                                    maxlength="10"
                                    styleId="hotel_STARTTIME"
                                    styleClass="inline laydate-icon"
                                    readonly="true" /><label id="timeCheck2"style="width: 250px; color: red"></label></td>
                            <td>退宿時間：</td>
                            <td><html:text
                                    name="_JNTCIBusinessVerifyDetailedForm"
                                    property="hotelEndtime"
                                    maxlength="10"
                                    styleId="hotel_ENDTIME"
                                    styleClass="inline laydate-icon"
                                    readonly="true" /><label id="timeCheck3"style="width: 250px; color: red"></label></td>
                            <td rowspan="4"></td>
                        </tr>
                        <tr>
                            <td>宿泊場所：</td>
                            <td><html:text
                                    name="_JNTCIBusinessVerifyDetailedForm"
                                    property="hotelDestination" /></td>
                            <td>宿泊人：</td>
                            <td><html:text
                                    name="_JNTCIBusinessVerifyDetailedForm"
                                    property="hotelPerson" /></td>
                        </tr>
                        <tr>
                            <td>宿泊人數：</td>
                            <td><html:text
                                    name="_JNTCIBusinessVerifyDetailedForm"
                                    property="hotelNumber" /></td>
                            <td>予約担当者：</td>
                            <td><html:text
                                    name="_JNTCIBusinessVerifyDetailedForm"
                                    property="hotelReservePerson" /></td>
                        </tr>
                        <tr>
                            <td>需求説明：</td>
                            <td colspan="3"><html:textarea
                                    name="_JNTCIBusinessVerifyDetailedForm"
                                    property="hotelExplain" /></td>
                        </tr>
                    </table>
                    <!-- 出差期间物品移交 -->
                    <div>
                        <table width="100%">
                            <colgroup>
                                <col width="70px" />
                                <col width="80px" />
                                <col width="70px" />
                                <col width="100px" />
                                <col width="180px" />
                            </colgroup>
                            <tr>
                                <th colspan="5">出張期間の物渡し</th>
                            </tr>
                        </table>
                        <ul
                            style="padding: 15px 0 5px 83px; font-size: 13px; font-weight: bold;">
                            <li id="articleSelect"><label>物品名称：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>
                            <html:hidden property="articleName"
                                    name="_JNTCIBusinessVerifyDetailedForm"
                                    styleId="article_NAME" />
                                <html:multibox
                                    name="_JNTCIBusinessVerifyDetailedForm"
                                    property="article_NAME" value="1" />食事カード
                                <html:multibox
                                    name="_JNTCIBusinessVerifyDetailedForm"
                                    property="article_NAME" value="2" />パソコン設備
                                <html:multibox
                                    name="_JNTCIBusinessVerifyDetailedForm"
                                    property="article_NAME" value="3" />個人所有物
                                <html:multibox
                                    name="_JNTCIBusinessVerifyDetailedForm"
                                    property="article_NAME" value="4" />出勤考勤备案
                                <html:multibox
                                    name="_JNTCIBusinessVerifyDetailedForm"
                                    property="article_NAME" value="5" />パスポート/出張マニュアル
                                <html:multibox
                                    name="_JNTCIBusinessVerifyDetailedForm"
                                    property="article_NAME" value="6" />herデータ審査/変更
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
                                <td>移管開始時間：</td>
                                <td><html:text
                                        name="_JNTCIBusinessVerifyDetailedForm"
                                        property="transferStartTime"
                                        maxlength="10"
                                        styleId="transfer_STARTTIME"
                                        styleClass="inline laydate-icon"
                                        readonly="true" /><label id="timeCheck4"style="width: 250px; color: red"></label></td>
                                <td>移管終了時間：</td>
                                <td><html:text
                                        name="_JNTCIBusinessVerifyDetailedForm"
                                        property="transferEndTime"
                                        maxlength="10"
                                        styleId="transfer_ENDTIME"
                                        styleClass="inline laydate-icon"
                                        readonly="true" /><label id="timeCheck5"style="width: 250px; color: red"></label></td>
                                <td rowspan="4"></td>
                            </tr>
                            <tr>
                                <td>受取人：</td>
                                <td><html:text
                                        name="_JNTCIBusinessVerifyDetailedForm"
                                        property="recipient" /></td>
                                <td>個人所有物保存先：</td>
                                <td><html:text
                                        name="_JNTCIBusinessVerifyDetailedForm"
                                        property="storAges" /></td>
                            </tr>
                            <tr>
                                <td>ビザ長短：<input type="hidden"
                                    id="passportLength"
                                    value="<bean:write name="_JNTCIBusinessVerifyDetailedForm" property="passportLength"/>" /></td>
                                <td colspan="3"><html:radio
                                        styleId="p-ch"
                                        name="_JNTCIBusinessVerifyDetailedForm"
                                        property="passportLength"
                                        value="1" /> <label for="p-ch">長签</label>
                                    <html:radio styleId="p-du"
                                        name="_JNTCIBusinessVerifyDetailedForm"
                                        property="passportLength"
                                        value="0" /> <label for="p-du">短签</label>
                                </td>
                            </tr>
                            <tr>
                                <td>コメント：</td>
                                <td colspan="3"><html:textarea
                                        name="_JNTCIBusinessVerifyDetailedForm"
                                        property="articleRemark" /></td>
                        </table>
                    </div>

                    <div style="margin: 35px 85px">
                            <ts:submit
                                styleClass="btn btn-green" value="保存"
                                property="forward_save"  onclick="return projectSubmit()"
                                style="margin-left: 40px;"/>

                            <input
                            type="reset" value="重置"
                            class="btn btn-green"
                            style="margin-left: 40px;" />

                            <ts:submit   styleId="getback"
                                styleClass="btn btn-green" value="戻る"
                                property="forward_list" style="margin-left: 40px;"
                                onclick="submit()" />
                    </div>

            <div class="footer">
                <p>
                    連絡メール：<a href="mailto:jinan@trans-cosmos.com.cn"
                        target="_blank">jinan@trans-cosmos.com.cn</a>
                </p>
            </div>

                </div>
            </ts:form>
        </div>
    </div>
    <!-- 出张开始结束时间 -->
        <script>
                    !function() {
                        laydate.skin('yahui');//切换皮肤，请查看skins下面皮肤库
                        laydate({
                            elem : '#demo'
                        });//绑定元素
                    }();

                    //日期范围限制
                    var start3 = {
                        elem : '#leave_STARTTIME',
                        format : 'YYYY-MM-DD',
                        istime : true,
                        istoday : false,
                        choose : function(datas) {
                            /* end.min = datas; //开始日选好后，重置结束日的最小日期
                            end.start = datas //将结束日的初始值设定为开始日 */
                        }
                    };
                    var end3 = {
                        elem : '#leave_STARTTIME',
                        format : 'YYYY-MM-DD',
                        istime : true,
                        istoday : false,
                        choose : function(datas) {
                          /*   start.max = datas; //结束日选好后，充值开始日的最大日期 */
                        }
                    };
                    laydate(start3);
                    laydate(end3);
                </script>
    <!-- 出差时间 -->
    <script>
                    !function() {
                        laydate.skin('yahui');//切换皮肤，请查看skins下面皮肤库
                        laydate({
                            elem : '#demo'
                        });//绑定元素
                    }();
                    //日期范围限制
                    var start = {
                        elem : '#startTime',
                        format : 'YYYY-MM-DD',
                        max : '2099-06-16', //最大日期
                        istime : true,
                        istoday : false,
                        choose : function(datas) {
                            end.min = datas; //开始日选好后，重置结束日的最小日期
                            end.start = datas //将结束日的初始值设定为开始日
                        }
                    };
                    var end = {
                        elem : '#endTime',
                        format : 'YYYY-MM-DD',
                        max : '2099-06-16', //最大日期
                        istime : true,
                        istoday : false,
                        choose : function(datas) {
                           start.max = datas; //结束日选好后，充值开始日的最大日期
                        }
                    };
                    laydate(start);
                    laydate(end);
                </script>
    <!-- 护照有效期 -->
    <script>
                    !function() {
                        laydate.skin('yahui');//切换皮肤，请查看skins下面皮肤库
                        laydate({
                            elem : '#demo'
                        });//绑定元素
                    }();

                    //日期范围限制
                    var start4 = {
                        elem : '#passportValidity',
                        format : 'YYYY-MM-DD',
                        istime : true,
                        istoday : false,
                        choose : function(datas) {
                         end.min = datas; //开始日选好后，重置结束日的最小日期
                            end.start = datas //将结束日的初始值设定为开始日
                        }
                    };
                    laydate(start4);
                </script>
    <!-- 住宿时间 -->
    <script>
                    !function() {
                        laydate.skin('yahui');//切换皮肤，请查看skins下面皮肤库
                        laydate({
                            elem : '#demo'
                        });//绑定元素
                    }();

                    //日期范围限制
                    var start1 = {
                        elem : '#hotel_STARTTIME',
                        format : 'YYYY-MM-DD',
                        istime : true,
                        istoday : false,
                        choose : function(datas) {
                            end1.min = datas; //开始日选好后，重置结束日的最小日期
                            end1.start = datas //将结束日的初始值设定为开始日
                        }
                    };

                    var end1= {
                        elem : '#hotel_ENDTIME',
                        format : 'YYYY-MM-DD',
                        istime : true,
                        istoday : false,
                        choose : function(datas) {
                        start1.max = datas; //结束日选好后，充值开始日的最大日期
                        }
                    };
                    laydate(start1);
                    laydate(end1);
                </script>
    <!-- 物品移交时间 -->
    <script>
                    !function() {
                        laydate.skin('yahui');//切换皮肤，请查看skins下面皮肤库
                        laydate({
                            elem : '#demo'
                        });//绑定元素
                    }();

                    //移交日期范围限制
                    var start2 = {
                        elem : '#transfer_STARTTIME',
                        format : 'YYYY-MM-DD',
                        istime : true,
                        istoday : false,
                        choose : function(datas) {
                            end2.min = datas; //开始日选好后，重置结束日的最小日期
                            end2.start = datas //将结束日的初始值设定为开始日
                        }
                    };
                    var end2= {
                            elem : '#transfer_ENDTIME',
                            format : 'YYYY-MM-DD',
                            istime : true,
                            istoday : false,
                            choose : function(datas) {
                             start2.max = datas; //结束日选好后，充值开始日的最大日期
                            }
                        };
                    laydate(start2);
                    laydate(end2);
                </script>

    <script type="text/javascript">
                    $(function() {

                        var value = $("#managerCheckOut").val();
                        if (value != null || value != "") {
                            $("#examineName option[value='" + value + "']")
                                    .attr("selected", false);
                            $("#examineName option[value='" + value + "']")
                                    .attr("selected", true);
                        }

                        $("#examineName").change(
                                function() {
                                    var dropBox = $("#examineName").val();
                                    if (dropBox != "") {

                                        $(
                                                "#examineName option[value='"
                                                        + dropBox + "']").attr(
                                                "selected", true);
                                    }
                                })
                    });
                </script>


</body>
</html>