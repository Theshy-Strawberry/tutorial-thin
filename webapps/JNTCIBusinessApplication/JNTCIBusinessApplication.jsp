<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="/struts-html" prefix="html"%>
<%@ taglib uri="/struts-bean" prefix="bean"%>
<%@ taglib uri="/struts-logic" prefix="logic"%>
<%@ taglib uri="/terasoluna-struts" prefix="ts"%>
<%@ taglib uri="/terasoluna" prefix="t"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>出張申請</title>
<link rel="stylesheet" type="text/css" href="css/base.css" />
<link rel="stylesheet" type="text/css" href="css/main.css" />
<script type="text/javascript" src="js/laydate/laydate.js"></script>
<script type="text/javascript" src="js/jquery-1.11.3.min.js"></script>

<style>
.title {
    width: 115px;
    text-align: right;
    padding-top: 20px
}

.text {
    padding-top: 20px
}
</style>
<script type="text/javascript">
/* $(function() {
    $(".project").click(function() {
    	var deptId =$("#deptId").val();
    	if(deptId == 002){
    		$("#Check").text("●プロジェクト名は入力必須項目です.");
    	}else{
    		$("#Check").text("");
    	}
    });
});

$(function() {
    $(".project_ID").click(function() {
    	var deptId = $("#deptId").val();
    	if(deptId == 002){
    		$("#Check").text("●プロジェクト番号は入力必須項目です.");
    	}else{
    		$("#Check").text("");
    	}
    });
});*/

    $(function(){
        $("#resetButton").click(function(){
            $("input[type='text']").attr("value", "");
            $("#traffic_EXPLAIN").html(null);
            $("#hotel_EXPLAIN").html(null);
            $("#evectionReason").html(null);
            $("#article_REMARK").html(null);
            $("[type='radio'][name=visa]").attr("checked", false);
            $("[type='radio'][name=passport_LENGTH]").attr("checked", false);
            $("[type='radio'][name=passport]").attr("checked", false);
            $("[type='checkbox']").attr("checked", false);
        });
    })
    $(function() {
        $('#left-container .content').hide();
        $('#Attendance').show();
        $('h2.tit').click(function() {
            $(this).next('.content').stop().slideToggle();

        })
    });
</script>
<script type="text/javascript">
 $(function(){
  $("#passporthasnot").click(function(){
	  $("#passport_ID").attr("disabled",true);
	  $("#passport_ID").css("background-color","#E3E3E3");
	  $("#passport_VALIDITY").attr("disabled",true);
	  $("#passport_VALIDITY").css("background-color","#E3E3E3");
  });
  $("#nopassporthasnot").click(function(){
	  $("#passport_ID").attr("disabled",false);
	  $("#passport_ID").css("background-color","#FFFFFF");
	  $("#passport_VALIDITY").attr("disabled",false);
	  $("#passport_VALIDITY").css("background-color","#FFFFFF");
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
<script type="text/javascript">
 function projectSubmit(){
	var deptId = $("#deptId").val();
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
    $(function() {

        $("input[name='delete']")
                .on(
                        "click",
                        function() {
                            if (confirm("削除するか")) {
                                var evectionId = $.trim($(this).parent()
                                        .children("input[name='evectionId']")
                                        .val());
                                $
                                        .ajax({
                                            cache : true,
                                            type : "POST",
                                            url : '/tutorial-thin/JNTCIDeleteApplicationBL.do',
                                            data : {
                                                'evectionId' : evectionId
                                            },
                                            async : false,
                                            error : function(request) {
                                                alert("削除が失敗しました！");
                                                location.reload();
                                            },
                                            success : function(data) {
                                                alert("削除が成功しました！");
                                                location.href = '/tutorial-thin/JNTCIViewApplicationBL.do';
                                            }
                                        });
                            }
                        });
    })
</script>
<script type="text/javascript">
    $(function() {

        $("input[name='modify']")
                .on(
                        "click",
                        function() {

                            var evectionId = $.trim($(this).parent().children(
                                    "input[name='evectionId']").val());
                            $
                                    .ajax({
                                        cache : true,
                                        type : "POST",
                                        url : '/tutorial-thin/JNTCIModifyApplicationBL.do',
                                        data : {
                                            'evectionId' : evectionId
                                        },
                                        async : false,
                                        error : function(request) {

                                            location.reload();
                                        },
                                        success : function(data) {
                                            location.reload(true);

                                            if (false != isIE()) {

                                                if (confirm("修正するか")) {
                                                    window.location.href = '/tutorial-thin/JNTCIModifyApplicationBL.do?evectionId='
                                                            + evectionId;//你可以跟换里面的网址，以便成功后跳转
                                                }
                                            } else {
                                                window.location.href = '/tutorial-thin/JNTCIModifyApplicationBL.do?evectionId='
                                                        + evectionId;//你可以跟换里面的网址，以便成功后跳转
                                            }
                                        },
                                    });
                        });
    });
</script>
<script type="text/javascript">
    function isIE() { //ie?
        if (!!window.ActiveXObject || "ActiveXObject" in window)
            return true;
        else
            return false;
    }
</script>
<script type="text/javascript">
 function toDetail1(value) {
        var id = value.id;
        var indexs = id.split('-');
        var index = indexs[1];
        var evection = $("#evectionId-" + index).val();
        $("#userhdId").val(evection);
        $("#index1").val("update");
        $("#detailId").click();

    }
 </script>
 <script type="text/javascript">
  function toDetail2(value) {
     var id = value.id;
     var indexs = id.split('-');
     var index = indexs[1];
     var evection = $("#evectionId-" + index).val();
     $("#userhdId").val(evection);
     $("#index1").val("delete");
     $("#detailId1").click();
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
                    <li><a href="#">出張申請</a></li>
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
            <div class="main-ctn ">
                <ts:form action="/JNTCIBusinessApplicationDSP">
                    <div class="clearfix self-info">
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
                            <tr>
                                <td>天津社員カード：</td>
                                <td><bean:write
                                        name="_JNTCIBusinessApplicationForm"
                                        property="tj_USER_ID" /> <html:hidden
                                        name="_JNTCIBusinessApplicationForm"
                                        property="tj_USER_ID" /></td>
                                <td>申請者カード：</td>
                                <td><bean:write
                                        name="_JNTCIBusinessApplicationForm"
                                        property="userId" /></td>
                                <td rowspan="9"></td>
                            </tr>
                            <tr>
                                <td>申請者名前：</td>
                                <td><bean:write
                                        name="_JNTCIBusinessApplicationForm"
                                        property="userName" /></td>
                                <td>申請部門：<html:hidden
                                        property="deptId"
                                        name="_JNTCIBusinessApplicationForm" styleId="deptId"></html:hidden></td>
                                <td><bean:write
                                        name="_JNTCIBusinessApplicationForm"
                                        property="deptName" /></td>
                            </tr>
                            <tr>
                                <td>性别：</td>
                                <td><html:radio
                                        name="_JNTCIBusinessApplicationForm"
                                        property="sex" value="1"
                                        style="position:relative; z-index:2" />
                                    男<html:radio
                                        name="_JNTCIBusinessApplicationForm"
                                        property="sex" value="0"
                                        style="position:relative; z-index:2" />
                                    女</td>
                                <td>职位编号：</td>
                                <td><bean:write
                                        name="_JNTCIBusinessApplicationForm"
                                        property="position_ID" /> <html:hidden
                                        name="_JNTCIBusinessApplicationForm"
                                        property="position_ID" /></td>
                            </tr>
                            <tr>
                                <td>部門PM：</td>
                                <td colspan="3"><bean:write
                                        name="_JNTCIBusinessApplicationForm"
                                        property="projectPm" /> <html:hidden
                                        name="_JNTCIBusinessApplicationForm"
                                        property="projectPm" /></td>
                            </tr>
                            <tr>
                                <td>プロジェクト名：</td>
                                <td class="project"><html:text
                                        name="_JNTCIBusinessApplicationForm"
                                        property="project" styleId="project"/></td>

                                <td>プロジェクト番号：</td>
                                <td class="project_ID"><html:text
                                        name="_JNTCIBusinessApplicationForm"
                                        property="project_ID"
                                        maxlength="20" styleId="project_ID"/></td>
                            </tr>
                            <tr>
                                <td>労働关系属地：</td>
                                <td><html:text
                                        name="_JNTCIBusinessApplicationForm"
                                        property="dependency" /></td>

                                <td>出張先：</td>
                                <td><html:text
                                        name="_JNTCIBusinessApplicationForm"
                                        property="evectionDestination"
                                        maxlength="20" /> <i
                                    class="red">*</i></td>
                            </tr>
                            <tr>
                                <td>出張開始日：</td>
                                <td><html:text
                                        name="_JNTCIBusinessApplicationForm"
                                        property="evectionStarttime"
                                        maxlength="10"
                                        styleId="startDateTime"
                                        styleClass="inline laydate-icon"
                                        readonly="true" /><i
                                    class="red">*</i></td>
                                <td>出張終了日：</td>
                                <td><html:text
                                        name="_JNTCIBusinessApplicationForm"
                                        property="evectionEndtime"
                                        maxlength="10"
                                        styleId="endDateTime"
                                        styleClass="inline laydate-icon"
                                        readonly="true" /><i
                                    class="red">*</i></td>
                            </tr>
                            <tr>
                                <td id="time">出張日数：</td>
                                <td colspan="3"><html:text
                                        name="_JNTCIBusinessApplicationForm"
                                        property="businessDays"
                                        maxlength="20"
                                        styleId="businessDays" /> <i
                                    class="red">*</i></td>

                            </tr>

                            <tr>
                                <td class="reason">出張任务描述：</td>
                                <td colspan="3" ><html:textarea
                                        name="_JNTCIBusinessApplicationForm"
                                        property="evectionReason"
                                        styleId="evectionReason" />
                                        <i class="red">*</i></td>
                            </tr>
                        </table>
                    </div>
                    <div class="self-info">
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
                                <td><html:text
                                        name="_JNTCIBusinessApplicationForm"
                                        property="id_CARD"
                                        maxlength="18" /></td>
                                <td>出張時間：</td>
                                <td><html:text
                                        name="_JNTCIBusinessApplicationForm"
                                        property="departure_TIME"
                                        maxlength="10"
                                        styleId="departure_TIME"
                                        styleClass="inline laydate-icon"
                                        readonly="true" /><label id="timeCheck1"
                            style="width: 250px; color: red"></label></td>
                            </tr>
                            <tr>
                                <td>パスポート：</td>
                                <td><html:radio
                                        styleId="passporthasnot"
                                        name="_JNTCIBusinessApplicationForm"
                                        property="passport" value="1" />
                                    無<html:radio
                                        styleId="nopassporthasnot"
                                        name="_JNTCIBusinessApplicationForm"
                                        property="passport" value="0" />
                                    有</td>
                                <td>ビザ：</td>
                                <td><html:radio
                                        styleId="visahasnot"
                                        name="_JNTCIBusinessApplicationForm"
                                        property="visa" value="1" />無 <html:radio
                                        styleId="visahasnot"
                                        name="_JNTCIBusinessApplicationForm"
                                        property="visa" value="0" />有</td>
                            </tr>
                            <tr>
                                <td>パスポート番号：</td>
                                <td><html:text
                                        name="_JNTCIBusinessApplicationForm"
                                        property="passport_ID"
                                        styleId="passport_ID"/></td>
                                <td>パスポート有効期：</td>
                                <td><html:text
                                        name="_JNTCIBusinessApplicationForm"
                                        property="passport_VALIDITY"
                                        maxlength="10"
                                        styleId="passport_VALIDITY"
                                        styleClass="inline laydate-icon"
                                        readonly="true" /></td>
                            </tr>
                            <tr>
                                <td>出発場所：</td>
                                <td><html:text
                                        name="_JNTCIBusinessApplicationForm"
                                        property="leave" /></td>
                                <td>到着場所：</td>
                                <td><html:text
                                        name="_JNTCIBusinessApplicationForm"
                                        property="reach_PLACE" /></td>
                            </tr>
                            <tr>
                                <td>名前ピンイン：</td>
                                <td><html:text
                                        name="_JNTCIBusinessApplicationForm"
                                        property="name_PINYIN" /></td>
                                <td>予約担当者：</td>
                                <td><html:text
                                        name="_JNTCIBusinessApplicationForm"
                                        property="traffic_RESERVE_PERSON" /></td>
                            </tr>
                            <tr>
                                <td>需求說明：</td>
                                <td colspan="3"><html:textarea
                                        name="_JNTCIBusinessApplicationForm"
                                        property="traffic_EXPLAIN"
                                        styleId="traffic_EXPLAIN"
                                        /></td>
                            </tr>
                        </table>
                    </div>
                    <div class="self-info">
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
                                        name="_JNTCIBusinessApplicationForm"
                                        property="hotel_STARTTIME"
                                        maxlength="10"
                                        styleId="hotel_STARTTIME"
                                        styleClass="inline laydate-icon"
                                        readonly="true" /><label id="timeCheck2"
                            style="width: 250px; color: red"></label></td>
                                <td>退宿時間：</td>
                                <td><html:text
                                        name="_JNTCIBusinessApplicationForm"
                                        property="hotel_ENDTIME"
                                        maxlength="10"
                                        styleId="hotel_ENDTIME"
                                        styleClass="inline laydate-icon"
                                        readonly="true" />
                                        <label id="timeCheck3"style="width: 250px; color: red"></label></td>
                                <td rowspan="4"></td>
                            </tr>
                            <tr>
                                <td id="hotel_DESTINATION">宿泊場所：</td>
                                <td><html:text
                                        name="_JNTCIBusinessApplicationForm"
                                        property="hotel_DESTINATION" /></td>
                                <td>宿泊人：</td>
                                <td><html:text
                                        name="_JNTCIBusinessApplicationForm"
                                        property="hotel_PERSON" /></td>
                            </tr>
                            <tr>
                                <td id="hotel_NUMBER">宿泊人数：</td>
                                <td><html:text
                                        name="_JNTCIBusinessApplicationForm"
                                        property="hotel_NUMBER" /></td>
                                <td id="hotel_RESERVE_PERSON">予約担当者：</td>
                                <td><html:text
                                        name="_JNTCIBusinessApplicationForm"
                                        property="hotel_RESERVE_PERSON" /></td>
                            </tr>
                            <tr>
                                <td>需求説明：</td>
                                <td colspan="3"><html:textarea
                                        name="_JNTCIBusinessApplicationForm"
                                        property="hotel_EXPLAIN"
                                        styleId="hotel_EXPLAIN"
                                        /></td>
                            </tr>
                            <tr>
                                <th colspan="5">出張期間の物渡し</th>
                            </tr>
                        </table>
                    </div>
                    <div class="self-info">
                        <table>
                            <colgroup>
                               <col width="230px" />
                            </colgroup>
                            <tr>
                                <td id="articleSelect">物品名称：</td>
                                <html:hidden property="article_NAME"
                                    name="_JNTCIBusinessApplicationForm"
                                    styleId="article_NAME" />
                                <td colspan="3">
                                    <html:multibox
                                        name="_JNTCIBusinessApplicationForm"
                                        property="articleNAME" value="1" />食事カード
                                    <html:multibox
                                        name="_JNTCIBusinessApplicationForm"
                                        property="articleNAME" value="2" />パソコン設備
                                    <html:multibox
                                        name="_JNTCIBusinessApplicationForm"
                                        property="articleNAME" value="3" />個人所有物
                                    <html:multibox
                                        name="_JNTCIBusinessApplicationForm"
                                        property="articleNAME" value="4" />出勤考勤备案
                                    <html:multibox
                                        name="_JNTCIBusinessApplicationForm"
                                        property="articleNAME" value="5" />パスポート/出張マニュアル
                                    <html:multibox
                                        name="_JNTCIBusinessApplicationForm"
                                        property="articleNAME" value="6" />herデータ審査/変更
                                </td>
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
                                <td>移管開始時間：</td>
                                <td><html:text
                                        name="_JNTCIBusinessApplicationForm"
                                        property="transfer_STARTTIME"
                                        maxlength="10"
                                        styleId="transfer_STARTTIME"
                                        styleClass="inline laydate-icon"
                                        readonly="true" /><label id="timeCheck4"style="width: 250px; color: red"></label></td>
                                <td>移管終了時間：</td>
                                <td><html:text
                                        name="_JNTCIBusinessApplicationForm"
                                        property="transfer_ENDTIME"
                                        maxlength="10"
                                        styleId="transfer_ENDTIME"
                                        styleClass="inline laydate-icon"
                                        readonly="true" />
                                        <label id="timeCheck5"style="width: 250px; color: red"></label></td>
                                <td rowspan="4"></td>

                            </tr>
                            <tr>
                                <td>受取人：</td>
                                <td><html:text
                                        name="_JNTCIBusinessApplicationForm"
                                        property="recipient" /></td>

                                <td>個人所有物保存先：</td>
                                <td><html:text
                                        name="_JNTCIBusinessApplicationForm"
                                        property="storage" /></td>

                            </tr>
                            <tr>
                                <td>ビザ長短：</td>
                                <td colspan="3"><html:radio
                                        name="_JNTCIBusinessApplicationForm"
                                        property="passport_LENGTH"
                                        value="1" />長期 <html:radio
                                        name="_JNTCIBusinessApplicationForm"
                                        property="passport_LENGTH"
                                        value="0" />短期</td>

                            </tr>
                            <tr>
                                <td>物品コメント：</td>
                                <td colspan="3"><html:textarea
                                        name="_JNTCIBusinessApplicationForm"
                                        property="article_REMARK"
                                        styleId="article_REMARK"
                                        /></td>

                            </tr>
                        </table>
                    </div>
                    <div style="margin: 20px 400px">
                        <ts:submit value="申請" styleClass="btn btn-blue"
                            property="forward_insert" onclick="return projectSubmit()"/>
                        &nbsp;&nbsp;&nbsp;
                       <html:reset styleClass="btn btn-green"
								styleId="resetButton" value="クリア"/>
                    </div>
                </ts:form>
                <table class="ctn"
                    style="width: 100%; margin-top: 35px;">
                    <caption>出張審査一覧</caption>
                    <tr>
                        <th style="width: 90px">カード</th>
                        <th>ユーザ</th>
                        <th>部門所属</th>
                        <th>出張開始時間</th>
                        <th>出張終了時間</th>
                        <th>出張日数</th>
                        <th>出張先</th>
                        <th>申請理由</th>
                        <th>申請状態</th>
                        <th style="width: 200px">申請変更</th>

                    </tr>
                    <logic:iterate id="userBean"
                        name="_JNTCIBusinessApplicationForm"
                        property="users" indexId="index">
                       <html:form action="/JNTCIModifyApplicationBL" styleId="formid"  >
                            <tr>
                                <td><bean:write name="userBean"
                                        property="userId" />
                                <html:hidden
                                                    styleId="evectionId-${index}"
                                                    property="evectionId"
                                                    name="userBean"
                                                    indexed="true" />
                                </td>
                                <td><bean:write name="userBean"
                                        property="userName" />
                                        <html:hidden  styleId="startIndex"  property="startIndex" name="_JNTCIBusinessApplicationForm"></html:hidden></td>
                                <td><bean:write name="userBean"
                                        property="deptId" /></td>
                                <td><bean:write name="userBean"
                                        property="evectionStarttime" />
                                </td>
                                <td><bean:write name="userBean"
                                        property="evectionEndtime" />
                                </td>
                                <td><bean:write name="userBean"
                                        property="businessDays" /></td>
                                <td><bean:write name="userBean"
                                        property="evectionDestination" /></td>
                                <td><bean:write name="userBean"
                                        property="evectionReason" /></td>
                                <td><bean:write name="userBean"
                                        property="examineStatus" /><input
                                    type="hidden" id="examineStatus"
                                    name="examineStatus"
                                    value="<bean:write name="userBean" property="examineStatus" />" /></td>
                                <td>
                                    <input class="btn btn-green"  id="detailId-${index}"
                                    type="button" value="修正" onclick="toDetail1(this)"
                                    ${userBean.examineStatus == "終了" || userBean.examineStatus == "承認中" || userBean.examineStatus == "承認済"? "disabled='true'" : ""}
                                     />&nbsp;&nbsp; <input
                                    type="hidden" name="evectionId"
                                    value="<bean:write name="userBean" property="evectionId"/>" />
                                    <input class="btn btn-red" id="detailId-${index}" name="delete"
                                    type="button" value="削除"  onclick="toDetail2(this)"
                                    ${userBean.examineStatus == "終了"|| userBean.examineStatus == "承認中" || userBean.examineStatus == "承認済"? "disabled='true'" : ""}
                                    />
                                    </td>

                            </tr>
                        </html:form>
                    </logic:iterate>
                    <html:form action="/JNTCIModifyApplicationBL" styleId="formid1">
                         <input type="hidden" name="evectionId12" id="userhdId" value="" />
                         <html:hidden  styleId="startIndex"  property="startIndex" name="_JNTCIBusinessApplicationForm"/>
                         <input type="hidden" name="flag" id="index1" value="" />
                         <ts:submit styleId="detailId" value="修正" style="display:none" />
                         <ts:submit styleId="detailId1" value="削除" style="display:none" />

                    </html:form>
                </table>
                <ts:pageLinks id="userListPageLinks"
                    action="/JNTCIViewApplicationBL"
                    name="_JNTCIBusinessApplicationForm"
                    rowProperty="row" totalProperty="totalCount"
                    indexProperty="startIndex" currentPageIndex="now"
                    totalPageCount="total" />

                <div>
                    <p style="text-align: right; width: 100%;">
                        計
                        <bean:write name="_JNTCIBusinessApplicationForm"
                            property="totalCount" />
                        レコード
                        <bean:write name="now" />
                        ／
                        <bean:write name="total" />

                        <bean:write name="userListPageLinks"
                            filter="false" />
                    </p>
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

    <!-- 出发时间 -->
    <script>
                    !function() {
                        laydate.skin('yahui');//切换皮肤，请查看skins下面皮肤库
                        laydate({
                            elem : '#demo'
                        });//绑定元素
                    }();

                    //日期范围限制
                    var start3 = {
                        elem : '#departure_TIME',
                        format : 'YYYY-MM-DD',
                        istime : true,
                        istoday : false,
                        choose : function(datas) {
                            /* end.min = datas; //开始日选好后，重置结束日的最小日期
                            end.start = datas //将结束日的初始值设定为开始日 */
                        }
                    };
                    var end3 = {
                        elem : '#departure_TIME',
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
                        elem : '#startDateTime',
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
                        elem : '#endDateTime',
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
                        elem : '#passport_VALIDITY',
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
