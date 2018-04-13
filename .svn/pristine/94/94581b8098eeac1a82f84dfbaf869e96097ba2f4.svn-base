<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="/struts-html" prefix="html"%>
<%@ taglib uri="/struts-bean" prefix="bean"%>
<%@ taglib uri="/struts-logic" prefix="logic"%>
<%@ taglib uri="/terasoluna-struts" prefix="ts"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/terasoluna" prefix="t"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<link rel="stylesheet" type="text/css" href="css/base.css" />
<link rel="stylesheet" type="text/css" href="css/main.css" />
<link rel="stylesheet" type="text/css" href="Style/skin.css" />
<link rel="stylesheet" type="text/css"
        href="${pageContext.request.contextPath}/css/scroll.css" />
<script type="text/javascript" src="js/laydate/laydate.js"></script>
<script type="text/javascript" src="js/jquery-1.11.3.min.js"></script>
<script type="text/javascript" src="js/jquery.validate.js" ></script>
<script type="text/javascript">
$(function(){
	$('#left-container .content').hide();
	$('#Attendance').show();
	$('h2.tit').click(function(){
		$(this).next('.content').stop().slideToggle();

	})
})

</script>

<script type="text/javascript">
$(function() {
	var value = $("#selectCheck").val();
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
});
function resetCarel(){
	$("#leaveType").val("");
	$("#startDateTime").val("");
	$("#endDateTime").val("");
	$("#date").val("");
	$("#leaveReason").val("");

}
</script>
<script type="text/javascript">
function cleanDate(){
    if ($("#date").val() == 0)

    {$("#date").val(0);
    }

}
function getIndex() {
	var  leaveType= document.getElementById("leaveType").value;
	 document.getElementById("selectCheck1").value=leaveType;
}
//时间检查
function chooseDateCallBack(){
		var startDateTime = $("#startDateTime").val();   //开始时间字符串
		var endDateTime = $("#endDateTime").val();     //结束时间字符串
		//获取最终请假时间
		 var selectCheck1=document.getElementById("selectCheck1").value;
			//获取最终请假时间
			if(selectCheck1=='AL6'){
				 var result1 = dateProcess1(startDateTime,endDateTime);
				$("#date").val(result1); }
			else{var result = dateProcess(startDateTime,endDateTime);
			      $("#date").val(result);}
}

//时间处理
function dateProcess(beginDateStr,endDateStr)
{
	  if($("#startDateTime").val() == "" || $("#endDateTime").val() == "")
	  {
		return ;
	  }

	//截取时间字符串，将年月日分离
	  var beginYear = beginDateStr.substring(0,4);
	  var beginMonth = beginDateStr.substring(5,7);
	  var beginDay = beginDateStr.substring(8,10);
	  var beginHour = beginDateStr.substring(11,13);
	  var beginMinute = beginDateStr.substring(14,16);

	  var endYear = endDateStr.substring(0,4);
	  var endMonth = endDateStr.substring(5,7);
	  var endDay = endDateStr.substring(8,10);
	  var endHour = endDateStr.substring(11,13);
	  var endMinute = endDateStr.substring(14,16);

	  //创建两个时间对象，对应开始时间和结束时间
	  var beginDate = new Date(Date.UTC(beginYear,beginMonth - 1,beginDay,0,0,0,0));
	  var endDate = new Date(Date.UTC(endYear,endMonth - 1,endDay,0,0,0,0));

	  var checkBeginDate = new Date(Date.UTC(beginYear,beginMonth - 1,beginDay,beginHour,beginMinute,0,0));
	  var checkEndDate = new Date(Date.UTC(endYear,endMonth - 1,endDay,endHour,endMinute,0,0));


	  //开始时间备份
	  var beginDateOrign = new Date(Date.UTC(beginYear,beginMonth - 1,beginDay,0,0,0,0));

	  //开始空余
	  var BMinute = 0;
	  beginHour = parseInt(beginHour);
	  beginMinute = parseInt(beginMinute);


	  //结束空余
	  var EMinute = 0;
	  endHour = parseInt(endHour);
	  endMinute = parseInt(endMinute);

	  var fir=false;
	  var ed=false;

	  var startTime=beginDateOrign.getFullYear()+"/"+((beginDateOrign.getMonth() +1)<10?("0"+(beginDateOrign.getMonth() +1)):(beginDateOrign.getMonth() +1))+"/"+(beginDateOrign.getDate()<10?("0"+beginDateOrign.getDate()):beginDateOrign.getDate());
	  var endTime=endDate.getFullYear()+"/"+((endDate.getMonth() +1)<10?("0"+(endDate.getMonth() +1)):(endDate.getMonth() +1))+"/"+(endDate.getDate()<10?("0"+endDate.getDate()):endDate.getDate()) ;
	  var holiday=document.getElementById("detailDate").value;
	     var arr=new Array();
	     var arr1=new Array();
	     arr=holiday.split(" ");

	    for(var i=0;i<arr.length;i++){
	        arr2=arr[i];
	        if(arr2==startTime){
	        	fir=true;
	        }
	        if(arr2==endTime){
                ed=true;
            }
	    }
	  //请假第一天不是周六周日
	  if(beginDateOrign.getDay() != 0 && beginDateOrign.getDay() != 6&&fir!=true)
	  {
	    //请假时间在8：30 - 12：00之间
	    if((beginHour * 60 + beginMinute - 510 > 0) && (beginHour * 60 + beginMinute - 720 <= 0))
	    {
	      BMinute = (beginHour * 60 + beginMinute - 510);
	    }else if((beginHour * 60 + beginMinute - 720 > 0) && (beginHour * 60 + beginMinute - 780 <= 0))
	    {
	      //请假时间在12：00 - 13：00之间
	      BMinute = 210;
	    }
	    else if((beginHour * 60 + beginMinute - 780 > 0) && (beginHour * 60 + beginMinute - 1050 <= 0))
	    {
	      //请假时间在13：00 - 17：30之间
	      BMinute = (beginHour * 60 + beginMinute - 570);
	    }else if(beginHour * 60 + beginMinute - 1050 > 0)
	    {
	      //如果请假第一天从17：30以后开始，就直接跳到后一天
	      beginDate.setDate(beginDate.getDate() + 1);
	    }
	  }

	  //请假最后一天不是周六周日
	  if(endDate.getDay() != 0 && endDate.getDay() != 6&&ed!=true)
	  {
	    //请假时间在8：30之前
	    if((endHour * 60 + endMinute - 510 ) < 0 )
	    {
	      //请假时间减一天
	      endDate.setDate(endDate.getDate() - 1);
	    }else if ((endHour * 60 + endMinute - 510 ) >= 0 &&　(endHour * 60 + endMinute - 720 ) <= 0) {
	      //8:30 - 12:00
	      EMinute = 480 - (endHour * 60 + endMinute - 510 );
	    }else if((endHour * 60 + endMinute - 720 > 0) && (endHour * 60 + endMinute - 780 <= 0))
	    {
	      //请假结束时间在12：00 - 13：00之间
	      EMinute = 270;
	    }
	    else if ((endHour * 60 + endMinute - 780 ) > 0 && (endHour * 60 + endMinute - 1050 ) <= 0 ) {
	      //13:00 - 17:30
	      EMinute = 1050 - (endHour * 60 + endMinute);
	    }
	  }

	  //间隔天数
	  var days = (endDate.getTime() - beginDate.getTime())/1000/60/60/24 + 1;

	  //周六日的天数
	  var weekendsDays = 0;

	  // 获取入参字符串形式日期的Date型日期
      begin=document.getElementById("startDateTime").value;
      end=document.getElementById("endDateTime").value;
      d1=begin.substring(0,10);
      d2=end.substring(0,10);


      // 定义一天的毫秒数
      var dayMilliSeconds  = 1000*60*60*24;

      // 获取输入日期的毫秒数
      var d1Ms = beginDate.getTime();
      var d2Ms = endDate.getTime();

      // 定义返回值
      var ret;
      // 给Date对象添加getYMD方法，获取字符串形式的年月日
    Date.prototype.getYMD = function(){
      var retDate = this.getFullYear() + "/";  // 获取年份。
      retDate += (this.getMonth()+ 1<10?"0"+(this.getMonth()+ 1):(this.getMonth()+ 1))  + "/";    // 获取月份。
      retDate += (this.getDate()<10?"0"+this.getDate():this.getDate());               // 获取日。
      return retDate;                          // 返回日期。
  }

  // 给String对象添加getDate方法，使字符串形式的日期返回为Date型的日期
  String.prototype.getDate = function(){
      var strArr = this.split('/');
      var date = new Date(strArr[0], strArr[1] - 1, strArr[2]);
      return date;
  }
  // 对日期毫秒数进行循环比较，直到d1Ms 大于等于 d2Ms 时退出循环
  // 每次循环结束，给d1Ms 增加一天
  if(d1Ms <= d2Ms){
     for (d1Ms; d1Ms <= d2Ms; d1Ms =d1Ms+ dayMilliSeconds) {

      // 如果ret为空，则无需添加" "作为分隔符
      if (!ret) {
          // 将给的毫秒数转换为Date日期
          var day = new Date(d1Ms);

          // 获取其年月日形式的字符串
          ret = day.getYMD();
      } else {

      // 否则，给ret的每个字符日期间添加" "作为分隔符
          var day = new Date(d1Ms);
          ret = ret + ' ' + day.getYMD();
      }
     }
  }  else if(d1Ms >d2Ms){
	  for (d1Ms; d1Ms > d2Ms; d1Ms =d1Ms- dayMilliSeconds) {

	      // 如果ret为空，则无需添加" "作为分隔符
	      if (!ret) {
	          // 将给的毫秒数转换为Date日期
	          var day = new Date(d1Ms);

	          // 获取其年月日形式的字符串
	          ret = day.getYMD();
	      } else {

	      // 否则，给ret的每个字符日期间添加" "作为分隔符
	          var day = new Date(d1Ms);
	          ret = ret + ' ' + day.getYMD();
	      }
	     }

  }

     var holiday=document.getElementById("detailDate").value;
     var arr=new Array();
     var arr1=new Array();
     arr=holiday.split(" ");
     arr1=ret.split(" ");
     var holidays=0;

    for(var i=0;i<arr.length;i++){
    	arr2=arr[i];
    	for(var j=0;j<arr1.length;j++){
    		arr3=arr1[j];
    	  if(arr3==arr2){
    		holidays+=1;
    	  }

    	}
    }


	  //计算工作天数
	  for(var index = 1 ; index <= days ; index ++ )
	  {

	    if(beginDate.getDay() == 0 || beginDate.getDay() == 6)
	    {
	      weekendsDays += 1;
	    }
	    beginDate.setDate(beginDate.getDate() + 1);
	  }

	  //请假天数
	  var leaveDays = days - weekendsDays-holidays;
	  //请假分钟数
	  var leaveMinuts=leaveDays * 8 * 60 - BMinute - EMinute ;

	  //请假小时
	  var leaveHours = Math.floor(leaveMinuts/60);

	  //半小时制
	  if(leaveMinuts % 60 > 0 && leaveMinuts % 60 <= 30)
	  {
	    leaveHours = leaveHours + 0.5;
	  }else if (leaveMinuts % 60 > 30) {
	    leaveHours = leaveHours + 1;
	  }
 	 return leaveHours;

}
function dateProcess1(beginDateStr,endDateStr)
{
	  if($("#startDateTime").val() == "" || $("#endDateTime").val() == "")
	  {
		return ;
	  }

	//截取时间字符串，将年月日分离
	  var beginYear = beginDateStr.substring(0,4);
	  var beginMonth = beginDateStr.substring(5,7);
	  var beginDay = beginDateStr.substring(8,10);
	  var beginHour = beginDateStr.substring(11,13);
	  var beginMinute = beginDateStr.substring(14,16);

	  var endYear = endDateStr.substring(0,4);
	  var endMonth = endDateStr.substring(5,7);
	  var endDay = endDateStr.substring(8,10);
	  var endHour = endDateStr.substring(11,13);
	  var endMinute = endDateStr.substring(14,16);

	  //创建两个时间对象，对应开始时间和结束时间
	  var beginDate = new Date(Date.UTC(beginYear,beginMonth - 1,beginDay,0,0,0,0));
	  var endDate = new Date(Date.UTC(endYear,endMonth - 1,endDay,0,0,0,0));

	  var checkBeginDate = new Date(Date.UTC(beginYear,beginMonth - 1,beginDay,beginHour,beginMinute,0,0));
	  var checkEndDate = new Date(Date.UTC(endYear,endMonth - 1,endDay,endHour,endMinute,0,0));


	  //开始时间备份
	  var beginDateOrign = new Date(Date.UTC(beginYear,beginMonth - 1,beginDay,0,0,0,0));

	  //开始空余
	  var BMinute = 0;
	  beginHour = parseInt(beginHour);
	  beginMinute = parseInt(beginMinute);


	  //结束空余
	  var EMinute = 0;
	  endHour = parseInt(endHour);
	  endMinute = parseInt(endMinute);

	  var fir=false;
	  var ed=false;

	  var startTime=beginDateOrign.getFullYear()+"/"+((beginDateOrign.getMonth() +1)<10?("0"+(beginDateOrign.getMonth() +1)):(beginDateOrign.getMonth() +1))+"/"+(beginDateOrign.getDate()<10?("0"+beginDateOrign.getDate()):beginDateOrign.getDate());
	  var endTime=endDate.getFullYear()+"/"+((endDate.getMonth() +1)<10?("0"+(endDate.getMonth() +1)):(endDate.getMonth() +1))+"/"+(endDate.getDate()<10?("0"+endDate.getDate()):endDate.getDate()) ;
	  var holiday=document.getElementById("detailDate").value;
	     var arr=new Array();
	     var arr1=new Array();
	     arr=holiday.split(" ");

	    for(var i=0;i<arr.length;i++){
	        arr2=arr[i];
	        if(arr2==startTime){
	        	fir=true;
	        }
	        if(arr2==endTime){
                ed=true;
            }
	    }
	    //请假时间在8：30之前
	    if((endHour * 60 + endMinute - 510 ) < 0 )
	    {
	      //请假时间减一天
	      endDate.setDate(endDate.getDate() - 1);
	    }
	    //请假时间在8：30 - 12：00之间
	    else if((beginHour * 60 + beginMinute - 510 > 0) && (beginHour * 60 + beginMinute - 720 <= 0))
	    {
	      BMinute = (beginHour * 60 + beginMinute - 510);
	    }else if((beginHour * 60 + beginMinute - 720 > 0) && (beginHour * 60 + beginMinute - 780 <= 0))
	    {
	      //请假时间在12：00 - 13：00之间
	      BMinute = 210;
	    }
	    else if((beginHour * 60 + beginMinute - 780 > 0) && (beginHour * 60 + beginMinute - 1050 <= 0))
	    {
	      //请假时间在13：00 - 17：30之间
	      BMinute = (beginHour * 60 + beginMinute - 570);
	    }else if(beginHour * 60 + beginMinute - 1050 > 0)
	    {
	      //如果请假第一天从17：30以后开始，就直接跳到后一天
	      beginDate.setDate(beginDate.getDate() + 1);
	    }
	  //间隔天数
	  var days = (endDate.getTime() - beginDate.getTime())/1000/60/60/24 + 1;
	  // 获取入参字符串形式日期的Date型日期
      begin=document.getElementById("startDateTime").value;
      end=document.getElementById("endDateTime").value;
      d1=begin.substring(0,10);
      d2=end.substring(0,10);


      // 定义一天的毫秒数
      var dayMilliSeconds  = 1000*60*60*24;

      // 获取输入日期的毫秒数
      var d1Ms = beginDate.getTime();
      var d2Ms = endDate.getTime();

      // 定义返回值
      var ret;
      // 给Date对象添加getYMD方法，获取字符串形式的年月日
    Date.prototype.getYMD = function(){
      var retDate = this.getFullYear() + "/";  // 获取年份。
      retDate += (this.getMonth()+ 1<10?"0"+(this.getMonth()+ 1):(this.getMonth()+ 1))  + "/";    // 获取月份。
      retDate += (this.getDate()<10?"0"+this.getDate():this.getDate());               // 获取日。
      return retDate;                          // 返回日期。
  }

  // 给String对象添加getDate方法，使字符串形式的日期返回为Date型的日期
  String.prototype.getDate = function(){
      var strArr = this.split('/');
      var date = new Date(strArr[0], strArr[1] - 1, strArr[2]);
      return date;
  }
  // 对日期毫秒数进行循环比较，直到d1Ms 大于等于 d2Ms 时退出循环
  // 每次循环结束，给d1Ms 增加一天
  if(d1Ms <= d2Ms){
     for (d1Ms; d1Ms <= d2Ms; d1Ms =d1Ms+ dayMilliSeconds) {

      // 如果ret为空，则无需添加" "作为分隔符
      if (!ret) {
          // 将给的毫秒数转换为Date日期
          var day = new Date(d1Ms);

          // 获取其年月日形式的字符串
          ret = day.getYMD();
      } else {

      // 否则，给ret的每个字符日期间添加" "作为分隔符
          var day = new Date(d1Ms);
          ret = ret + ' ' + day.getYMD();
      }
     }
  }  else if(d1Ms >d2Ms){
	  for (d1Ms; d1Ms > d2Ms; d1Ms =d1Ms- dayMilliSeconds) {

	      // 如果ret为空，则无需添加" "作为分隔符
	      if (!ret) {
	          // 将给的毫秒数转换为Date日期
	          var day = new Date(d1Ms);

	          // 获取其年月日形式的字符串
	          ret = day.getYMD();
	      } else {

	      // 否则，给ret的每个字符日期间添加" "作为分隔符
	          var day = new Date(d1Ms);
	          ret = ret + ' ' + day.getYMD();
	      }
	     }

  }

     var holiday=document.getElementById("detailDate").value;
     var arr=new Array();
     var arr1=new Array();
     arr=holiday.split(" ");
     arr1=ret.split(" ");
     var holidays=0;

    for(var i=0;i<arr.length;i++){
    	arr2=arr[i];
    	for(var j=0;j<arr1.length;j++){
    		arr3=arr1[j];
    	  if(arr3==arr2){
    		holidays+=1;
    	  }

    	}
    }


	  //计算工作天数
	  for(var index = 1 ; index <= days ; index ++ )
	  {
	    beginDate.setDate(beginDate.getDate() + 1);
	  }

	  //请假天数
	  var leaveDays = days ;
	  //请假分钟数
	  var leaveMinuts=leaveDays * 8 * 60 - BMinute - EMinute ;

	  //请假小时
	  var leaveHours = Math.floor(leaveMinuts/60);

	  //半小时制
	  if(leaveMinuts % 60 > 0 && leaveMinuts % 60 <= 30)
	  {
	    leaveHours = leaveHours + 0.5;
	  }else if (leaveMinuts % 60 > 30) {
	    leaveHours = leaveHours + 1;
	  }
 	 return leaveHours;

}
</script>
<script type="text/javascript">
	function showConfirm(){
		 if(confirm('このデータを削除するか')){
			 $("[name='updateQuFen']").val("Delete");
			 return true;
		}
		  	return false;
	};
	function update(){
		$("[name='updateQuFen']").val("Update");
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
</script>
<style>
.title {
	text-align: right;
	padding-top: 10px;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>休暇申請</title>
</head>
<body onmousemove="chooseDateCallBack();">
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
			<div class="header"style="width:1663px">
				<ul class="breadcrumbs clearfix">
					<li>ステップチャート：</li>
					<li><a href="#">勤務管理</a></li>
					<li class="ico">&gt;</li>
					<li><a href="#">休暇申請</a></li>
				</ul>
			</div>
			<div id="tab-top" style="margin-top: 10px;">
              <ul>
              <li><ts:link action="/queryPersonalInformation.do">休暇申請</ts:link></li>
              <li class="on"><a href="#">补暇申請</a></li>
              </ul>
              </div>
			<div
				style="max-height: 100px; overflow: auto; width: 500px; margin-left: 80px;">
				<html:errors />
				<html:messages id="message" message="true">
					<span style="color: blue" id="spanId"><bean:write
							name="message" /></span>
				</html:messages>
			</div>
			<div class="main-ctn ul-li" >
				<ts:form styleId="formId" action="/updateLeave02">

					<ul>
	                      <!--节假日列表  -->
					    <li><input type="hidden" id="detailDate"
                                value="<bean:write name="_jnTCIAttendance03Form" property="detailDate"/>" /></li>
						<li><label>申請者カード：</label> <html:hidden property="jnCard" />
							<bean:write name="_jnTCIAttendance03Form" property="jnCard" /></li>
						<li><label>申請者名前：</label> <html:hidden property="name" /> <bean:write
								name="_jnTCIAttendance03Form" property="name" /></li>
						<li><label>部門所属：<html:hidden property="deptId"
									name="_jnTCIAttendance03Form"></html:hidden></label> <bean:write
								name="_jnTCIAttendance03Form" property="deptName" /></li>
						<li><label>審査者：</label> <html:hidden property="projectPm" />
							<bean:write  name="_jnTCIAttendance03Form" property="projectPm" />
							<html:hidden property="pmEmail" />
							<html:hidden property="myEmail" />
							</li>
						<li ><label>申請方式：</label> <html:html>補暇</html:html></li>
						<!-- 休暇 を休む タイプ -->
						<li><label>补暇種類：<input type="hidden" id="selectCheck"
								value="<bean:write name="_jnTCIAttendance03Form" property="leaveCode"/>" />
								<input type="hidden" id="selectCheck1"
								value="<bean:write name="_jnTCIAttendance03Form" property="leaveCode"/>" /></label>
							<html:select styleId="leaveType" onchange="getIndex()" name="_jnTCIAttendance03Form"
								property="leaveCode" style="width:125px;">
								<option value=""></option>
								<logic:notEmpty name="_jnTCIAttendance03Form"
									property="leaveTypeList">
									<logic:iterate id="jnTCIAttendance03"
										name="_jnTCIAttendance03Form" property="leaveTypeList">
										<option
											value="<bean:write name="jnTCIAttendance03" property="leaveCode"/>">
											<bean:write name="jnTCIAttendance03" property="leaveName" />
										</option>
									</logic:iterate>
								</logic:notEmpty>
							</html:select><i class="red">*</i></li>
						<li><label>补暇開始時間：</label> <html:text onclick="chooseDateCallBack();" onblur="cleanDate()"
								readonly="true" styleId="startDateTime" style="width: 140px;"
								name="_jnTCIAttendance03Form" property="leaveStartTime"
								styleClass="inline laydate-icon" /> - <html:text
								styleId="endDateTime"
								readonly="true" style="width: 140px;"  onblur="cleanDate()"
								name="_jnTCIAttendance03Form" property="leaveEndTime"
								styleClass="inline laydate-icon" /><i class="red">*</i></li>
						<li><label>补暇時長：</label> <html:text styleId="date"
								readonly="true" style="width: 100px;"
								name="_jnTCIAttendance03Form" property="leaveTotalTime" />（時間）<i class="red">*</i>
								</li>

						<!--the one who allow the leaving appeal-->
						<li class="reason"><label>补暇事由：</label> <html:textarea
								styleId="leaveReason" name="_jnTCIAttendance03Form"
								property="leaveReason"></html:textarea><i class="red">*</i></li>
						<li style="padding: 10px 0 0 200px;"><ts:submit styleClass="btn btn-blue"
								value="申請 " style="width:60px;height:25px" /> <html:hidden
								name="_jnTCIAttendance03Form" property="preserVation" /> <html:hidden
								name="_jnTCIAttendance03Form" property="examineStatus" /> <html:hidden
								name="_jnTCIAttendance03Form" property="leaveId" />
							    &nbsp;&nbsp;&nbsp; <input type="button"
								class="btn btn-green" id="resetButton"
								onclick="resetCarel()"  style="width:60px;height:25px" value="クリア" /></li>

					</ul>
				</ts:form>

				<ts:pageLinks id="userListPageLinks"
					action="/queryPersonalInformation1?jnCard=${_jnTCIAttendance03Form.jnCard}"
					name="_jnTCIAttendance03Form" rowProperty="row"
					totalProperty="totalCount" indexProperty="startIndex"
					currentPageIndex="now" totalPageCount="total" />

				<table class="ctn" style="width: 100%; margin-top: 35px;">
					<caption>补暇申請一覧</caption>
					<tr>
						<th style="width: 95px;">社員カード</th>
						<th style="width: 95px;">社員名前</th>
						<th style="width: 95px;">所属部門</th>
						<th style="width: 95px;">審査者</th>
						<th style="width: 95px;">申請方式</th>
						<th style="width: 95px;">審査時間</th>
						<th style="width: 300px;">休暇始止時間</th>
						<th style="width: 100px;">合計時長</th>
						<th style="width: 100px;">休暇種類</th>
						<th style="width: 150px;">理由認めない</th>
						<th style="width: 150px;">審査結果</th>
						<th style="width: 200px;">処理</th>
					</tr>
					<logic:notEmpty name="_jnTCIAttendance03Form"
						property="jntciAttendanceSelect03Dto">
						<logic:iterate id="_jnTCIAttendance03FormBeans"
							name="_jnTCIAttendance03Form"
							property="jntciAttendanceSelect03Dto">
							<ts:form action="/deleteEventAction1" method="post">

							<html:hidden property="startIndex" name="_jnTCIAttendance03Form"/>

								<tr align="center" class="d">
									<td align="center">
										<!--
									 如果审核状态不等于未提交则文本输出卡号，否则卡号加a标签，可以触发修改其内容  --> <bean:write
											name="_jnTCIAttendance03FormBeans" property="jnCard" />
									</td>
									<td align="center"><bean:write
											name="_jnTCIAttendance03FormBeans" property="name" /></td>
									<td align="center"><bean:write
											name="_jnTCIAttendance03FormBeans" property="deptId" /></td>
									<td align="center"><bean:write
											name="_jnTCIAttendance03FormBeans" property="projectPm" /></td>
									<td align="center"><bean:write
											name="_jnTCIAttendance03FormBeans" property="applicationtype" /></td>
									<td align="center"><bean:write
											name="_jnTCIAttendance03FormBeans" property="examineTime" /></td>
									<td align="center">&nbsp;<bean:write
											name="_jnTCIAttendance03FormBeans" property="leaveStartTime" />
										- <bean:write name="_jnTCIAttendance03FormBeans"
											property="leaveEndTime" /></td>
									<td align="center"><bean:write
											name="_jnTCIAttendance03FormBeans" property="leaveTotalTime" /></td>
									<td align="center"><bean:write
											name="_jnTCIAttendance03FormBeans" property="leaveType" /></td>
									<td align="center"><bean:write
											name="_jnTCIAttendance03FormBeans" property="exmineReason" /></td>
									<td align="center"><bean:write
											name="_jnTCIAttendance03FormBeans" property="examineStatus" /></td>
									<td align="center"><c:if
											test="${_jnTCIAttendance03FormBeans.examineStatus == '許可' || _jnTCIAttendance03FormBeans.examineStatus == '承認中'|| _jnTCIAttendance03FormBeans.examineStatus == '未許可'|| _jnTCIAttendance03FormBeans.examineStatus == '承認済'||_jnTCIAttendance03FormBeans.leaveSubtimeOver=='over'}">
											<input type="button" class="btn btn-red" disabled="disabled"
												value="削除"
												style="width: 50px; height: 25px; background: #CCCCCC" />
											<input type="button" class="btn btn-green"
												style="width: 50px; height: 25px; background: #CCCCCC"
												disabled="disabled" value="修正" />
										</c:if> <c:if
											test="${_jnTCIAttendance03FormBeans.examineStatus != '許可' && _jnTCIAttendance03FormBeans.examineStatus != '未許可'&& _jnTCIAttendance03FormBeans.examineStatus != '承認中'&& _jnTCIAttendance03FormBeans.examineStatus != '承認済'&&_jnTCIAttendance03FormBeans.leaveSubtimeOver!='over'}">
											<html:hidden name="_jnTCIAttendance03FormBeans"
												property="leaveId" />
											<html:hidden name="_jnTCIAttendance03FormBeans"
												property="jnCard" />
											<html:hidden name="_jnTCIAttendance03Form"
												property="updateQuFen" styleId="updateQuFen" />
											<ts:submit value="削除" styleClass="btn btn-red"
												style="width: 50px;height:25px"
												onclick="return showConfirm()" />
											<ts:submit value="修正" styleClass="btn btn-green"
												style="width: 50px;height:25px" onclick="update()" />
										</c:if></td>
								</tr>
							</ts:form>
						</logic:iterate>
					</logic:notEmpty>
				</table>
				<div class="pagination">
					<ul>
						<li>計<b><bean:write name="_jnTCIAttendance03Form"
									property="totalCount" /></b>レコード数
						</li>
						<li><bean:write name="now" />／<bean:write name="total" /></li>
						<li><bean:write name="userListPageLinks" filter="false" /></li>
					</ul>
				</div>
				<div class="footer">
					<p>
						連絡メール：<a href="mailto:jinan@trans-cosmos.com.cn" target="_blank">jinan@trans-cosmos.com.cn</a>
					</p>
				</div>
			</div>

			<script type="text/javascript">
		!function(){
			laydate.skin('yahui');//切换皮肤，请查看skins下面皮肤库
			laydate({elem: '#demo'});//绑定元素
		}();

		//日期范围限制
var start = {
  elem: '#startDateTime',
  format: 'YYYY-MM-DD hh:mm',
  /* min: laydate.now(), //设定最小日期为当前日期
  max: '2099-06-16 24:00', //最大日期 */
  istime: true,
  istoday: false,
  start: laydate.now(0, "YYYY/MM/DD 08:30:00"),
  choose: function(datas){
    /*  end.min = datas; //开始日选好后，重置结束日的最小日期 */
	  var hour;
		var min;
		hour=datas.substring(11,13);
		min=datas.substring(14,16);
		if(parseInt(min)<60&&parseInt(min)>0){
			if(parseInt(hour)<9){
			hour="0"+(parseInt(hour)+1);
			}
			min="00";
		}
		var dt=datas.substring(0,11);
   end.min = dt+hour+":"+min; //开始日选好后，重置结束日的最小日期 */
  }
};
var end = {
  elem: '#endDateTime',
  format: 'YYYY-MM-DD hh:mm',
  /* min: laydate.now(),
  max: '2099-06-16 24:00', */
  istime: true,
  istoday: false,
  start: laydate.now(0, "YYYY/MM/DD 17:30:00"),
  choose: function(datas){
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