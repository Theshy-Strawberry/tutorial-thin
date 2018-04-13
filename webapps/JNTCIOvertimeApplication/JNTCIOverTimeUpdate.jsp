<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="/struts-html" prefix="html"%>
<%@ taglib uri="/struts-bean" prefix="bean"%>
<%@ taglib uri="/struts-logic" prefix="logic"%>
<%@ taglib uri="/terasoluna-struts" prefix="ts"%>
<%@ taglib uri="/terasoluna" prefix="t"%>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>申請詳細</title>
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
	$(
			function() {
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

				$('#left-container .content').hide();
				$('#Attendance').show();
				$('h2.tit').click(function() {
					$(this).next('.content').stop().slideToggle();

				})
				function testAction() {
					window.location.href = "/JNTCLOvertimeApplicationSCR";
				}

			})
</script>
<script type="text/javascript">
$(
		function() {
	var value = $("#Check").val();
	if (value != null) {
	$("#examineName option[value='" + value + "']").attr(
				"selected", false);
	$("#examineName option[value='" + value + "']").attr(
				"selected", true);
	}
})
</script>
<script>
 function bao(s)
{
	$("#selectCheck").val(s);
}
 function bao1(s)
 {
 	$("#Check").val(s);
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
	    	if(hoursStart < 17 || (hoursStart == 17 && minutesStart < 30)){
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
	    	 $("#timeCheck").text("開始日と終了日は同じ日にならない！");
	    	 return false;
	    	}
	    }
}

$(function() {

    $(".auto").mouseover(function() {
    	 //残業種類code
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
    	if(hoursStart < 17 || (hoursStart == 17 && minutesStart < 30)){
    			 $("#timeCheck").text("残業の時間は17時30分から始める!!");
    		}
    		if(startDateTimeWeekDay == 0 || startDateTimeWeekDay == 6 || endDateTimeWeekDay == 0 || endDateTimeWeekDay == 6 ){
    			 $("#timeCheck").text("残業の種類は残業の時間とぴったり合わない!!");
   		}
    }
    if(leaveType == 2){
    	if(startDateTimeWeekDay == 1 || startDateTimeWeekDay == 2 || startDateTimeWeekDay == 3 || startDateTimeWeekDay == 4 || startDateTimeWeekDay == 5  || endDateTimeWeekDay == 1 || endDateTimeWeekDay == 2|| endDateTimeWeekDay == 3|| endDateTimeWeekDay == 4|| endDateTimeWeekDay == 5){
			 $("#timeCheck").text("「残業の種類は残業の時間とぴったり合わない!!");
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
    	 $("#timeCheck").text("開始日と終了日は同じ日にならない！");
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
        <div style="padding-left: 180px">

            <div class="header">
                <ul class="breadcrumbs clearfix">
                    <li>ステップチャート：</li>
                    <li><a href="#">残業管理</a></li>
                    <li class="ico">&gt;</li>
                    <li><a href="#">申請詳細</a></li>
                </ul>
            </div>
            <div
                style="max-height: 100px; overflow: auto; width: 500px; margin-left: 80px;">
                <html:errors />
                <html:messages id="message" message="true">
                    <bean:write name="message" />
                </html:messages>
            </div>
            <div class="main-ctn ul-li">
                <ts:form action="/JNTCIextraByIdUpdate">
                    <input id="userId" type="hidden"
                        value="<bean:write name="userId" scope="session" />" />
                    <ul>
                        <html:hidden property="extra_id" />
                        <html:hidden property="extra_reason" />
                        <li><input type="hidden" id="detailDate"
                                value="<bean:write name="_JNTCLOvertimeApplicationForm" property="detailDate"/>" /></li>
                        <li><label>残業カード：</label> <bean:write
                                name="_JNTCLOvertimeApplicationForm"
                                property="extra_id" /></li>
                        <li><label>申請者カード：</label> <bean:write
                                name="_JNTCLOvertimeApplicationForm"
                                property="user_id" /></li>
                        <li><label>申請者名前：</label> <bean:write
                                name="_JNTCLOvertimeApplicationForm"
                                property="user_name" /></li>
                        <li><label>所属部門：<html:hidden
                                    property="dept_code" /></label> <bean:write
                                name="_JNTCLOvertimeApplicationForm"
                                property="dept_code" /></li>
                        <li><label>項目名：</label> <bean:write
                                name="_JNTCLOvertimeApplicationForm"
                                property="project" /></li>
                        <li><label>項目编号：</label> <bean:write
                                name="_JNTCLOvertimeApplicationForm"
                                property="project_id" /></li>
                        <li><label>所属上司：</label> <bean:write
                                name="_JNTCLOvertimeApplicationForm"
                                property="project_PM" /></li>
                        <li><label>残業種類：<html:hidden
                                    property="extra_type1"
                                    name="_JNTCLOvertimeApplicationForm"
                                    styleId="selectCheck" /><html:hidden
                                    property="codeId"
                                    name="_JNTCLOvertimeApplicationForm"
                                    styleId="codeId" /></label> <html:select
                                property="extra_type"
                                name="_JNTCLOvertimeApplicationForm"
                                styleId="leaveType"
                                onchange="bao(this.options[this.options.selectedIndex].value)">
                                <option value=""></option>
                                <logic:iterate
                                    id="JNTCIAttendance04selectFormBean"
                                    name="_JNTCLOvertimeApplicationForm"
                                    property="extralist">
                                    <option
                                        value="<bean:write name="JNTCIAttendance04selectFormBean" property="code_id" />"><bean:write
                                            name="JNTCIAttendance04selectFormBean"
                                            property="kj_name" /></option>
                                </logic:iterate>
                            </html:select></li>
                        <li><label>残業始止時間：</label> <html:text
                                property="extra_starttime"
                                name="_JNTCLOvertimeApplicationForm"
                                styleId="startDateTime"
                                styleClass="inline laydate-icon" /> -
                            <html:text property="extra_endtime"
                                name="_JNTCLOvertimeApplicationForm"
                                styleId="endDateTime"
                                styleClass="inline laydate-icon" /><label
                            id="timeCheck"
                            style="width: 230px; color: red"></label></li>
                        <li class="auto"><label>残業時間：</label> <html:text
                                styleId="extra_time"
                                style="width: 100px;"
                                name="_JNTCLOvertimeApplicationForm"
                                property="extra_time" />(時間)</li>
                        <li class="auto"><label
                            style="vertical-align: top">備考：</label> <textarea
                                name="extra_auditss"><bean:write
                                    name="_JNTCLOvertimeApplicationForm"
                                    property="extra_auditss" /></textarea></li>
                        <li class="auto" style="padding-left: 170px;"><ts:submit
                                styleClass="btn btn-blue" value="保存"
                                property="forward_save"
                                onclick="return timeSubmit()" />
                            &nbsp;&nbsp;&nbsp;
							<html:hidden styleId="startIndex"  property="startIndex" name="_JNTCLOvertimeApplicationForm"/>
							<ts:submit
                                styleClass="btn btn-green" value="戻る"
                                property="forward_list" /></li>
                        <!-- /JNTCLOvertimeApplicationSCR -->
                    </ul>
                </ts:form>
                <div class="footer">
                    <p>
                        連絡メール：<a href="mailto:jinan@trans-cosmos.com.cn"
                            target="_blank">jinan@trans-cosmos.com.cn</a>
                    </p>
                </div>
            </div>
        </div>
    </div>
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
			format : 'YYYY-MM-DD hh:mm',
			/* min : laydate.now(), //设定最小日期为当前日期
			max : laydate.now(+6), //最大日期 */
			istime : true,
			istoday : false,
			choose : function(datas) {
				end.min = datas; //开始日选好后，重置结束日的最小日期
				end.start = datas //将结束日的初始值设定为开始日
			}
		};

		var end = {
			elem : '#endDateTime',
			format : 'YYYY-MM-DD hh:mm',
			/* min : laydate.now(),
			max : laydate.now(+730), */
			istime : true,
			istoday : false,
			choose : function(datas) {
				start.max = datas; //结束日选好后，充值开始日的最大日期
			}
		};
		laydate(start);
		laydate(end);
	</script>
</body>
</html>
