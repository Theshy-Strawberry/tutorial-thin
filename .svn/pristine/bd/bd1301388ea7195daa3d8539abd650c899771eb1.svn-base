<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="/struts-html" prefix="html"%>
<%@ taglib uri="/struts-bean" prefix="bean"%>
<%@ taglib uri="/struts-logic" prefix="logic"%>
<%@ taglib uri="/terasoluna-struts" prefix="ts"%>
<%@ taglib uri="/terasoluna" prefix="t"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<link rel="stylesheet" type="text/css" href="css/base.css" />
<link rel="stylesheet" type="text/css" href="css/main.css" />
<script type="text/javascript" src="js/laydate/laydate.js"></script>
<script type="text/javascript" src="js/laydate/laydate.dev.js"></script>
<script type="text/javascript" src="js/jquery-1.11.3.min.js"></script>
<!-- 日付コントロールの修正しました -->
<script type="text/javascript">
function checkStartTime1(){
//$("#timeCheck").style.display="block";
  //残業種類code
  var leaveType = $("#leaveType").val();
  //残業始止時間
  var startDateTime = $("#startDateTime").val();
  var endDateTime = $("#endDateTime").val();
  alert(startDateTime >= endDateTime);
  //残業始止時間の該当日
  var startDateTimeWeekDay = new Date(startDateTime).getDay();
  var endDateTimeWeekDay = new Date(endDateTime).getDay();
  alert(leaveType+":::"+startDateTime+":::"+startDateTimeWeekDay);
  if(startDateTime >= endDateTime){
	 // document.getElementById("timeCheck").innerHTML="「残業始止時間」を確認してください";
	  $("#timeCheck").text("「残業始止時間」を確認してください");
	  $("#timeCheck").css("display","inline");
  }else{
   if(leaveType == 1){
	  if(startDateTimeWeekDay == 0 || startDateTimeWeekDay == 6 || endDateTimeWeekDay == 0 || endDateTimeWeekDay == 6 ){
		 // alert("bu qi pai ");
		  $("#timeCheck").css("display","inline");
		//  document.getElementById("timeCheck").innerHTML="??入?的公司正?名称";
	  }else{
		  $("#timeCheck").css("display","none");
	  }
  }else if(leaveType == 2){
	  if(startDateTimeWeekDay != 0 ){
		  if(startDateTimeWeekDay != 6){
		  alert("bu qi pai ");
		  $("#timeCheck").css("display","inline");
		 // document.getElementById("timeCheck").innerHTML="??入?的公司正?名称";
		  }
	  }
  }else{
        alert("残業種類：");
  }
  }
//alert("sfdfsdf");
}

     function checkStartTime() {
    	 alert($("#startDateTime").val());
    var startDateTime = new Date($("#startDateTime").val()).getDay();
    var endDateTime = $("#endDateTime").val();
    var leaveType = $("#leaveType").val();

    alert(startDateTime);
    if(leaveType.length !=0){
		if(leaveType == 1){
              alert("leaveType == 1");
		}else if(leaveType == 2 && startDateTime == 0){
			 alert("leaveType == 2 && startDateTime == 0");
		}else{
		}

    }else{
    	alert(leaveType+"leaveType = null");
    }
}

</script>

<script type="text/javascript">
//时间检查
function chooseDateCallBack(){

        console.warn("endDateCallBack run()");

        var startDateTime = $("#startDateTime").val();   //开始时间字符串
        var endDateTime = $("#endDateTime").val();     //结束时间字符串


        var result = dateProcess(startDateTime,endDateTime);

        $("#date").val(result);


}

$(function(){
    var value = $("#codeId").val();
    if(value != null || value != ""){
        $("#leaveType option[value='"+value+"']").attr("selected", false);
        $("#leaveType option[value='"+value+"']").attr("selected", true);
    }
	$("#leaveType").change(function() {
		var dropBox = $("#leaveType").val();
		if(dropBox !=""){
			$("#leaveType option[value='"+dropBox+"']").attr("selected", true);
		}
	})
    var reason = $("#extra_reason").val();
    $("#textId").val(reason);


    $('#left-container .content').hide();
    $('#Attendance').show();
    $('h2.tit').click(function(){
        $(this).next('.content').stop().slideToggle();
    })
})
</script>
<script type="text/javascript">
function clearInput() {
	$("#textId").val("");
    $("#startDateTime").val("")
    $("#endDateTime").val("");
    $("#extra_time_txt").val("");
	$("#leaveType").val("");
}
</script>
<script type="text/javascript">
function timeSubmit(){
	 var leaveType = $("#leaveType").val()
	    var str1 = $("#startDateTime").val();        //开始时间字符串
	    var str2 = $("#endDateTime").val();			//结束时间字符串
	    var time1 = str1.replace(/\-/g,"\/");
	    var time2 = str2.replace(/\-/g,"\/");
	    var startDateTimeWeekTime = new Date(time1).getTime();
	    var endDateTimeWeekTime = new Date(time2).getTime();
	    if(startDateTimeWeekTime > endDateTimeWeekTime){
	    	 $("#timeCheck").text("「残業の始める時間は終了時間より大きくない!");
	    	 //alert("「残業の始める時間は終了時間より大きくない!");
	    	 return false;
	    }else{
	    	$("#timeCheck").text("");
	    }

	    var startDateTimeWeekDay = new Date(time1).getDay();
	    var endDateTimeWeekDay = new Date(time2).getDay();
	    var hoursStart =  new Date(time1).getHours();
		var hoursEnd = new Date(time2).getHours();
		 var minutesStart = new Date(time1).getMinutes();
		 var minutesEnd = new Date(time2).getMinutes();
	    if(leaveType == 1){
	    		if(hoursStart < 17 || (hoursStart ==17&&minutesStart < 30)){
	    			 $("#timeCheck").text("残業の時間は17時30分から始める!!");
	    			   return false;
	    		}
	    		if(startDateTimeWeekDay == 0 || startDateTimeWeekDay == 6 || endDateTimeWeekDay == 0 || endDateTimeWeekDay == 6 ){
	    			 $("#timeCheck").text("「残業の種類は残業の時間とぴったり合わない!!");
	    			return false;
	   		}
	    }
	    if(leaveType == 2){
	    	if(startDateTimeWeekDay !=0 ){
	    		if(startDateTimeWeekDay !=6 ){
				 $("#timeCheck").text("「残業の種類は残業の時間とぴったり合わない!!");
				//alert("残業の種類は残業の時間とぴったり合わない!!");
				 return false;
	    		}
			}
	   }
	   if(leaveType == 3){
		  var timestart= time1.substring(0,10);
		  var timeend= time2.substring(0,10);
	   var a=0;
	   var holiday=document.getElementById("detailDate").value;
	   var arr=new Array();
	   arr=holiday.split(" ");
	   for(var i=0;i<arr.length;i++){
		  	arr2=arr[i];
		       	if(timestart==arr2 || timeend==arr2){
		    			a++;
		    		}
		      }
	  if(a==0){
			 $("#timeCheck").text("「残業の種類は残業の時間とぴったり合わない!!");
			 return false;
	  }}
	    //开始构造两个日期对象
	    if(str1!==""&&str2!=""){
	    var datetime1 = new Date();
	    var datetime2 = new Date();
	    datetime1.setFullYear(str1.substr(0,4),str1.substr(5,2) - 1,str1.substr(8,2));
	    datetime2.setFullYear(str2.substr(0,4),str2.substr(5,2) - 1,str2.substr(8,2));
	    var date1 = datetime1.setHours(0,0,0);    //?始日期，毫秒表示
	    var date2 = datetime2.setHours(0,0,0);    //?束日期，毫秒表示
	    datetime1.setHours(str1.substr(11,2),str1.substr(14,2),0);
	    datetime2.setHours(str2.substr(11,2),str2.substr(14,2),0);
	    if (date2 !== date1){
	    	 $("#timeCheck").text("開始日と終わり日は同じ日にならない！");
	    	 return false;
	    }
	    }
}

$(function() {
	Date.prototype.Format = function (fmt) { //author: meizz
	    var o = {
	        "M+": this.getMonth() + 1, //月份
	        "d+": this.getDate(), //日
	        "h+": this.getHours(), //小时
	        "m+": this.getMinutes(), //分
	        "s+": this.getSeconds(), //秒
	        "q+": Math.floor((this.getMonth() + 3) / 3), //季度
	        "S": this.getMilliseconds() //毫秒
	    };
	    if (/(y+)/.test(fmt)) fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
	    for (var k in o)
	    if (new RegExp("(" + k + ")").test(fmt)) fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
	    return fmt;
	}
   $(".auto").mouseover(function() {
   	 //残業種類code
   	 var leaveType = $("#leaveType").val()
	    var str1 = $("#startDateTime").val();        //开始时间字符串
	    var str2 = $("#endDateTime").val();
	//结束时间字符串
	    var time1 = str1.replace(/\-/g,"\/");
	    var time2 = str2.replace(/\-/g,"\/");
	    var startDateTimeWeekTime = new Date(time1).getTime();
	    var endDateTimeWeekTime = new Date(time2).getTime();
	    if(startDateTimeWeekTime > endDateTimeWeekTime){
	    	 $("#timeCheck").text("「残業の始める時間は終了時間より大きくない!");
	    	 //alert("「残業の始める時間は終了時間より大きくない!");
	    	 return false;
	    }else{
	    	$("#timeCheck").text("");
	    }

	    var startDateTimeWeekDay = new Date(time1).getDay();
	    var endDateTimeWeekDay = new Date(time2).getDay();
	    var hoursStart =  new Date(time1).getHours();
		var hoursEnd = new Date(time2).getHours();
		 var minutesStart = new Date(time1).getMinutes();
		 var minutesEnd = new Date(time2).getMinutes();
   if(leaveType == 1){
   		if(hoursStart < 17 || (hoursStart ==17 && minutesStart < 30)){
   			 $("#timeCheck").text("残業の種類は残業の時間とぴったり合わない!!");
   		}
   		if(startDateTimeWeekDay == 0 || startDateTimeWeekDay == 6 || endDateTimeWeekDay == 0 || endDateTimeWeekDay == 6 ){
   			 $("#timeCheck").text("残業の種類は残業の時間とぴったり合わない!!");
  		}
   }
   if(leaveType == 2){
   	if(startDateTimeWeekDay !=0 ){
   		if(startDateTimeWeekDay !=6 ){
			 $("#timeCheck").text("「残業の種類は残業の時間とぴったり合わない!!");
			//alert("残業の種類は残業の時間とぴったり合わない!!");
   		}
		}
  }
   if(leaveType == 3){
	  var timestart= time1.substring(0,10);
	  var timeend= time2.substring(0,10);
   var a=0;
   var holiday=document.getElementById("detailDate").value;
   var arr=new Array();
   arr=holiday.split(" ");
   for(var i=0;i<arr.length;i++){
	  	arr2=arr[i];
	       	if(timestart==arr2 || timeend==arr2){
	    			a++;
	    		}
	      }
  if(a==0){
		 $("#timeCheck").text("「残業の種類は残業の時間とぴったり合わない!!");
  }}
    //开始构造两个日期对象
    if(str1!==""&&str2!=""){
    var datetime1 = new Date();
    var datetime2 = new Date();
    datetime1.setFullYear(str1.substr(0,4),str1.substr(5,2) - 1,str1.substr(8,2));
    datetime2.setFullYear(str2.substr(0,4),str2.substr(5,2) - 1,str2.substr(8,2));
    var date1 = datetime1.setHours(0,0,0);    //?始日期，毫秒表示
    var date2 = datetime2.setHours(0,0,0);    //?束日期，毫秒表示
    datetime1.setHours(str1.substr(11,2),str1.substr(14,2),0);
    datetime2.setHours(str2.substr(11,2),str2.substr(14,2),0);
    if (date2 !== date1){
    	 $("#timeCheck").text("開始日と終わり日は同じ日にならない！");
    	//alert("始める日と終了日は同じ日にしなければなりません")
    }
    else{
    	var dayHouse = calculationData(datetime1.getTime(),datetime2.getTime(),datetime1.getHours(),datetime2.getHours());
                     $("#extra_time").val(dayHouse);
                     $("#extra_time_txt").val(dayHouse);
            }
    }
   });
  function calculationData(date1,date2,date1Hours,date2Hours){
        var date3 = (date2-date1)/3600000;

        if(date1Hours < 12 && date2Hours > 12){
            date3 = date3 - 1;
        }
        if(date3%1 == 0){
            return date3;
        }else if(date3%1 >= 0.5){
            date3 = (date3 - date3%1)+0.5;
            return date3;
        }else{
        	 date3 = date3 - date3%1;
        	 return date3;
        	 }
    }
    document.onkeydown = function(event) {
        var target, code, tag;
        if (!event) {
            event = window.event; //针对ie浏览器
            target = event.srcElement;
            code = event.keyCode;
            if (code == 13) {
                tag = target.tagName;
                if (tag == "TEXTAREA") { return true; }
                else { return false; }
            }
        }
        else {
            target = event.target; //针对遵循w3c标准的浏览器，如Firefox
            code = event.keyCode;
            if (code == 13) {
                tag = target.tagName;
                if (tag == "INPUT") { return false; }
                else { return true; }
           }
        }
    };
    });
</script>
<script type="text/javascript">
    $(function(){

        $("input[name='delete']").on("click",function(){
            if(confirm("削除するか"))
            {
                var extra_id = $.trim($(this).parent().children("input[name='extra_id']").val());
                var startIndex = $.trim($(this).parent().children("input[name='startIndex']").val());
                $.ajax({
                    cache: true,
                    type: "POST",
                    url: '/tutorial-thin/JNTCIOvertimeApplicationDelete.do',
                    data:{'extra_id':extra_id,'startIndex':startIndex},
                    async: false,
                    error: function(request) {
                        alert("削除が失敗しました！");
                        window.location.href='/tutorial-thin/JNTCLOvertimeApplicationSCR.do';
                    },
                    success: function(data) {
                          alert("削除が成功しました！");
                          window.location.href='/tutorial-thin/JNTCLOvertimeApplicationSCR.do';
                    }
                });
            }
        });
    })
</script>
<script type="text/javascript">
$(function(){
    $("input[name='modify']").on("click",function(){
        var extra_id = $.trim($(this).parent().children("input[name='extra_id']").val());
        var startIndex = $.trim($(this).parent().children("input[name='startIndex']").val());
            $.ajax({
                cache: true,
                type: "POST",
                url: '/tutorial-thin/selectExtrabyextraid.do',
                data:{'extra_id':extra_id,'startIndex':startIndex},
                async: false,
                error: function(request) {
                    location.reload();
                },
                success:  function (data) {
                        location.reload(true);
                        if (false != isIE()) {
                        if(confirm("修正するか"))
                            {
                        window.location.href='/tutorial-thin/selectExtrabyextraid.do?extra_id='+extra_id+'&startIndex='+startIndex;
                        }
                        } else {
                            window.location.href='/tutorial-thin/selectExtrabyextraid.do?extra_id='+extra_id+'&startIndex='+startIndex;
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

<style>
.title {
    width: 115px;
    text-align: right;
    padding-top: 20px;
}

#left {
    margin-left: -300px;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>残業申請</title>
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
                    <li><a href="#">残業管理</a></li>
                    <li class="ico">&gt;</li>
                    <li><a href="#">残業申請</a></li>
                </ul>
            </div>
            <div
                style="max-height: 100px; overflow: auto; width: 500px; margin-left: 80px;">
                <html:errors />
                <html:messages id="message" message="true">
                    <bean:write name="message" />
                </html:messages>
            </div>
            <div class="main-ctn ul-li" style="margin: 10px auto;">
                <ts:form styleId="formId"
                    action="/JNTCLOvertimeApplicationSCR00Insert">
                    <label id="timeSubmit"
                        style="width: 230px; color: red"></label>
                    <ul>
                    <li><input type="hidden" id="detailDate"
                                value="<bean:write name="_JNTCLOvertimeApplicationForm" property="detailDate"/>" /></li>
                        <li><label>申請者カード：</label> <bean:write
                                name="_JNTCLOvertimeApplicationForm"
                                property="user_id" /></li>
                        <li><label>申請者名前：</label> <bean:write
                                name="_JNTCLOvertimeApplicationForm"
                                property="user_name" /></li>
                        <li><label>所属部門：<html:hidden
                                    property="dept_code" /></label> <bean:write
                                name="_JNTCLOvertimeApplicationForm"
                                property="dept_id" /></li>
                        <li><label>項目名：</label>
                                <bean:write
                                name="_JNTCLOvertimeApplicationForm"
                                property="project" />
                                <input type="hidden"
                                        name="project"
                                        value="<bean:write name="_JNTCLOvertimeApplicationForm" property="project"/>" />
                                                                  </li>
                        <li><label>項目番号：</label> <bean:write
                                name="_JNTCLOvertimeApplicationForm"
                                property="project_id" /></li>
                        <li><label>項目責任者：</label> <bean:write
                                name="_JNTCLOvertimeApplicationForm"
                                property="project_PM" /></li>
                        <li><label>残業種類： <html:hidden
                                    property="codeId"
                                    name="_JNTCLOvertimeApplicationForm"
                                    styleId="codeId" />
                        </label> <html:select property="extra_type"
                                name="_JNTCLOvertimeApplicationForm"
                                styleId="leaveType">
                                <option value=""></option>
                                <logic:iterate
                                    id="JNTCIAttendance04selectFormBean"
                                    name="_JNTCLOvertimeApplicationForm"
                                    property="extralist">
                                    <option
                                        value="<bean:write name="JNTCIAttendance04selectFormBean" property="code_id" />">
                                        <bean:write
                                            name="JNTCIAttendance04selectFormBean"
                                            property="kj_name" /></option>
                                </logic:iterate>
                            </html:select><i class="red">*</i></li>
                        <li><label>残業始止時間：</label> <html:text
                                property="extra_starttime"
                                name="_JNTCLOvertimeApplicationForm"
                                readonly="true"
                                onclick="laydate({choose:chooseDateCallBack, istime: true, format: 'YYYY-MM-DD hh:mm'});"
                                styleId="startDateTime"
                                styleClass="inline laydate-icon"
                                 /> - <html:text
                                property="extra_endtime"
                                name="_JNTCLOvertimeApplicationForm"
                                readonly="true"
                                onclick="laydate({choose:chooseDateCallBack, istime: true, format: 'YYYY-MM-DD hh:mm'});"
                                styleId="endDateTime"
                                styleClass="inline laydate-icon"
                                /><i class="red">*</i><label id="timeCheck"
                            style="width: 250px; color: red"></label></li>
                        <li class="auto"><label>残業時間：</label> <html:hidden
                                styleId="extra_time"
                                property="extra_time"
                                name="_JNTCLOvertimeApplicationForm" />
                            <html:text styleId="extra_time_txt"
                                name="_JNTCLOvertimeApplicationForm"
                                property="extra_time_txt" />(時間) <i
                            class="red">*</i></li>
                        <li class="auto"><label
                            style="vertical-align: top">備考： </label> <html:hidden
                                property="extra_beiZhu"
                                name="_JNTCLOvertimeApplicationForm"
                                styleId="extra_reason" /> <textarea
                                name="extra_reason" Id="textId"></textarea>
                                <i class="red">*</i>
                        </li>
                        <li class="auto" style="padding-left: 170px;">
                            <ts:submit styleId="tiJiao"
                                styleClass="btn btn-blue" value="申請"
                                onclick="return timeSubmit()" />&nbsp;&nbsp;&nbsp;
                             <input type="button" class="btn btn-green" value="クリア" onclick="clearInput();" />
                        </li>
                    </ul>
                </ts:form>
                <ts:pageLinks id="Attendance04ListPageLinks"
                    action="/LeaveAppction?user_id=${_JNTCLOvertimeApplicationForm.user_id}"
                    name="_JNTCLOvertimeApplicationForm"
                    rowProperty="row" totalProperty="totalCount"
                    indexProperty="startIndex" currentPageIndex="now"
                    totalPageCount="total" />
                 <logic:notEmpty name="_JNTCLOvertimeApplicationForm"
                        property="jntciovertimeapplicationselectinput"><hr />
                <table class="ctn" width="100%">
                    <caption>残業申請一覧</caption>
                    <tr>
                        <th>社員カード</th>
                        <th>社員名前</th>
                        <th>所属部門</th>
                        <th>項目責任者</th>
                        <th>項目名</th>
                        <th>項目番号</th>
                        <th style="width: 320px;">残業始止時間</th>
                        <th>合計時間</th>
                        <th style="width: 90px;">残業種類</th>
                        <th style="width: 90px;">申請状態</th>
                        <th style="width: 200px">申請変更</th>
                    </tr>
                        <logic:iterate
                            id="_JNTCLOvertimeApplicationFormBean"
                            name="_JNTCLOvertimeApplicationForm"
                            property="jntciovertimeapplicationselectinput">
                            <tr align="center" class="d">
                                <td align="center"><bean:write
                                        name="_JNTCLOvertimeApplicationFormBean"
                                        property="user_id" /></td>
                                <td align="center"><bean:write
                                        name="_JNTCLOvertimeApplicationFormBean"
                                        property="user_name" /></td>
                                <td align="center"><bean:write
                                        name="_JNTCLOvertimeApplicationFormBean"
                                        property="dept_id" /></td>
                                <td align="center"><bean:write
                                        name="_JNTCLOvertimeApplicationFormBean"
                                        property="project_PM" /></td>
                                <td align="center"><bean:write
                                        name="_JNTCLOvertimeApplicationFormBean"
                                        property="project" /></td>
                                <td align="center"><bean:write
                                        name="_JNTCLOvertimeApplicationFormBean"
                                        property="project_id" /></td>
                                <td align="center"><bean:write
                                        name="_JNTCLOvertimeApplicationFormBean"
                                        property="extra_starttime" /> -
                                    <bean:write
                                        name="_JNTCLOvertimeApplicationFormBean"
                                        property="extra_endtime" /></td>
                                <td align="center"><bean:write
                                        name="_JNTCLOvertimeApplicationFormBean"
                                        property="extra_time" /></td>
                                <td align="center"><bean:write
                                        name="_JNTCLOvertimeApplicationFormBean"
                                        property="extra_type" /></td>
                                <td align="center"><bean:write
                                        name="_JNTCLOvertimeApplicationFormBean"
                                        property="extra_reason" /></td>

                                 <td><input type="hidden"
                                    name="extra_id"
                                    value="<bean:write name="_JNTCLOvertimeApplicationFormBean" property="extra_id"/>" />
                                    <input type="hidden"
                                    name="startIndex"
                                    value="<bean:write name="_JNTCLOvertimeApplicationForm" property="startIndex"/>" />
                                    <input class="btn btn-green"
                                    type="button" value="修正"
                                    ${_JNTCLOvertimeApplicationFormBean.extra_reason == "終了"? "disabled='true'" : ""}
                                    name="modify" />&nbsp;&nbsp; <input
                                    class="btn btn-red" type="button"
                                    value="削除"
                                    ${_JNTCLOvertimeApplicationFormBean.extra_reason == "終了"? "disabled='true'" : ""}
                                    name="delete" /></td>
                            </tr>
                        </logic:iterate>

                </table>
                <div class="pagination">
                    <ul>
                        <li>計<b> <bean:write
                                    name="_JNTCLOvertimeApplicationForm"
                                    property="totalCount" /></b>レコード数
                        </li>
                        <li><bean:write name="now" />／<bean:write
                                name="total" /></li>
                        <li><bean:write
                                name="Attendance04ListPageLinks"
                                filter="false" /></li>
                    </ul>
                </div> </logic:notEmpty>
                <div class="footer">
                    <p>
                        連絡メール：<a href="mailto:jinan@trans-cosmos.com.cn"
                            target="_blank">jinan@trans-cosmos.com.cn</a>
                    </p>
                </div>
            </div>

            <script type="text/javascript">
        !function() {
            laydate.skin('yahui');//切换皮肤，请查看skins下面皮肤库
            laydate({
                elem : '#demo'
            });//绑定元素
        }();

        //日期范围限制
        var start = {
            elem : '#startDateTime',
            format : 'YYYY-MM-DD hh:mm',
            /* min : laydate.now(), //设定最小日期为当前日期
            max : laydate.now(+6), //最大日期 */
            istime : true,
            istoday : false,
            choose : function(datas) {
                end.min = datas; //开始日选好后，重置结束日的最小日期
                end.start = datas; //将结束日的初始值设定为开始日
            }
        };

        var end = {
            elem : '#endDateTime',
            format : 'YYYY-MM-DD hh:mm',
            /* min : laydate.now(),
            max : laydate.now(+6), */
            istime : true,
            istoday : false,
            choose : function(datas) {
                start.max = datas; //结束日选好后，重置开始日的最大日期
            }
        };
        laydate(start);
        laydate(end);
    </script>
        </div>
    </div>
</body>
</html>