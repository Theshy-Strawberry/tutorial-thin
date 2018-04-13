<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="/struts-html" prefix="html"%>
<%@ taglib uri="/struts-bean" prefix="bean"%>
<%@ taglib uri="/struts-logic" prefix="logic"%>
<%@ taglib uri="/terasoluna-struts" prefix="ts"%>
<%@ taglib uri="/terasoluna" prefix="t"%>
<%@page import="java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
    request.setCharacterEncoding("utf-8");
%>
<%
    response.setCharacterEncoding("utf-8");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">
</style>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>稼働履歴</title>
<link rel="stylesheet" type="text/css" href="css/base.css" />
<link rel="stylesheet" type="text/css" href="css/main.css" />
<script type="text/javascript" src="js/laydate/laydate.js"></script>
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/JNTCIPersonInfo.js"></script>
<script type="text/javascript" src="js/jquery-1.11.3.min.js"></script>
<script type="text/javascript" src="js/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript">
    $(function() {
        $('#left-container .content').hide();
        $('#Attendance').show();
        $('h2.tit').click(function() {
            $(this).next('.content').stop().slideToggle();

        })

    })
</script>
<style>
#table td {
    padding: 0;
}

#leavelist li {
    color: red;
}

#extralist li {
    color: red;
}

#dingwei1 {
    position: absolute;
   right: 150px;
    //top: 10px;
}

#mon {
    position: absolute;
    position: fixed;
}

 .tdcls {
    width:90%;
    padding: 0;
    margin: 3px auto;
    text-align:center;
}
#fade img{
	display:block;
	width:auto;
	margin:0 auto;
	padding-top: 30px;
}
#fade font{
	display:block;
	text-align:center;
	width:100%;
}
.mainArea{
	width:95%;
	margin: 30px 60px;
}
.mainArea .search{
margin-bottom:10px;
}
#fieldset {
text-align:center;
}
#fieldset .tdcls{
	display:inline-block;
	width: auto;
	margin: 0;
}
</style>
<script type="text/javascript">
    function bodyLoad() {
        var dateTime = new Date();

        var hh = dateTime.getHours();
        var mm = dateTime.getMinutes();
        var ss = dateTime.getSeconds();

        var yy = dateTime.getFullYear();
        var MM = dateTime.getMonth() + 1; //因为1月这个方法返回为0，所以加1
        var dd = dateTime.getDate();

        var week = dateTime.getDay();

        if (hh < 10) {
            hh = "0" + hh;
        }
        if (mm < 10) {
            mm = "0" + mm;
        }
        if (ss < 10) {
            ss = "0" + ss;
        }
        if (MM < 10) {
            MM = "0" + MM;
        }
        if (dd < 10) {
            dd = "0" + dd;
        }
        var days = [ "日 ", "月 ", "火", "水", "木 ", "金 ", "土 ", ];

        document.getElementById("date").value = yy + "年" + MM + "月" + dd + "日 "
                + days[week] + "曜日";
        document.getElementById("time").value = hh + "時" + mm + "分" + ss + "秒";

        setTimeout(bodyLoad, 1000);

    }
</script>
</head>
<body onload="bodyLoad();">
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
                    <li><a href="#">稼働履歴</a></li>
                </ul>
            </div>
            <div
                style="max-height: 100px; overflow: auto;padding-left:30px;">
                <html:errors />
                <html:messages id="message" message="true">
                    <bean:write name="message" />
                </html:messages>
            </div>
            <div id="dingwei1">
                <input type="text" id="date" style="width: 150px; text-align: center;"/>
                <br /> <input type="text" id="time" style="width: 150px; text-align: center;"/><br>
            </div>
            <div class="mainArea clearfix">
                <div class="search">
				<input type="hidden" id="outMonth" name="month"
					value="<bean:write name="_SeekForm" property="month"/>" />
				<ts:form action="/seeklist">
				<div style="display: table-cell">
				      <html:hidden property="scrollPosit" name="_SeekForm" styleId="scrollPosit"/>
				 <table class="table-bar" >
                                <colgroup>
                                    <col width="120px" />
                                    <col width="120px" />
                                    <col width="120px" />
                                    <col width="120px" />

                                </colgroup>
                                <tr>
                                    <th>社員カード:</th>
					<td><html:text styleId="JN_card"
							property="jn_card" name="_SeekForm" />
					</td>
					 <th>出勤年月：</th>
					 <td>
					<html:text property="yymm" styleClass="Wdate" name="_SeekForm" styleId="shijian"
						onclick="WdatePicker({dateFmt:'yyyy/MM'})" />
					</td>
						<html:hidden property ="user_id" name="_SeekForm" styleId="userhdId"/>
                        <html:hidden property ="user_name" name="_JNTCIQueryForm" />
						 <html:hidden property ="user_id" name="_JNTCIQueryForm" />
					</tr>
		           </table>
					</div>
		       <div style="display: table-cell">
				<ts:submit value="検索" property="forward_search"
					styleClass="btn btn-blue fl" style="margin: 2px 8px 0px 30px;" />
				<c:if test="${_SeekForm.seek_query==1}">
					<ts:submit styleId="back" value="後退" property="forward_back"
						styleClass="btn btn-blue fl" style="margin: 2px 8px 0px;" />
				</c:if>
			</div>
				</ts:form>
			</div>
    <table cellspacing='0' cellpadding='0' width='1060px' id="table"
        style='border: 5px solid #87CEEB; border-top: 0;float:left;width:70%;' >
        <tr bgcolor='#87CEEB'>
            <td colspan='6'
                style='border: 5px solid #87CEEB; height: 50px; text-align: center'>
                <font color='#4169E1' size='3'>出勤記録（社員ユーザ）</font>
            </td>
            <td
                style='border: 5px solid #87CEEB; height: 50px; text-align: center'>名前：<bean:write
                    name="_SeekForm" property="name" /></td>
        </tr>
        <tr>
            <th align='center'
                style='border: 1px solid #4169E1; height: 30px'><font
                color='red'>日</font></th>
            <th align='center'
                style='border: 1px solid #4169E1; height: 30px'>月</th>
            <th align='center'
                style='border: 1px solid #4169E1; height: 30px'>火</th>
            <th align='center'
                style='border: 1px solid #4169E1; height: 30px'>水</th>
            <th align='center'
                style='border: 1px solid #4169E1; height: 30px'>木</th>
            <th align='center'
                style='border: 1px solid #4169E1; height: 30px'>金</th>
            <th align='center'
                style='border: 1px solid #4169E1; height: 30px'><font
                color='red'>土</font></th>
        </tr>
        <logic:iterate id="userBean" name="_SeekForm"
            property="weekList">
            <tr>
                <td
                    id='<bean:write  name="userBean" property="sunday.dt"/>00'
                    ${(userBean.sunday.dt==null) ? "":"onmouseover='bigger(this)'"}
                    style="background-color: #D6F7FA; padding: 0;">
                    <div class="tdcls" >
                      <bean:write name="userBean" property="sunday.dt" />
                    </div> <font
                    ${(userBean.sunday.extra_state==false) ? "color='red'":""}>
                        <bean:write name="userBean"
                            property="sunday.examineState" /><br>
                        <bean:write name="userBean"
                            property="sunday.extra_symbol" /><br>
                        <bean:write name="userBean"
                            property="sunday.start_time" /><br> <bean:write
                            name="userBean" property="sunday.end_time" />
                </font> <input type="hidden"
                    id='<bean:write  name="userBean" property="sunday.dt"/>0000'
                    value='<bean:write name="userBean" property="sunday.examineState" />'>
                </td>
                <td
                    ${(userBean.monday.dt==null) ? "style='background-color:#D7D9DA;'":"onmouseover='bigger(this)'"}
                    id='<bean:write  name="userBean" property="monday.dt"/>00'>
                    <div class="tdcls">
                        <bean:write name="userBean" property="monday.dt" />
                    </div> <font
                    ${(userBean.monday.state==false||userBean.monday.comeState==1||userBean.monday.extra_state==false) ? "color='red'":""}><bean:write
                            name="userBean"
                            property="monday.examineState" /><br>
                        <bean:write name="userBean"
                            property="monday.extra_symbol" /><br>
                        <bean:write name="userBean"
                            property="monday.late_state" /><br> <bean:write
                            name="userBean" property="monday.start_time" /><br>
                        <bean:write name="userBean"
                            property="monday.end_time" /></font> <input
                    type="hidden"
                    id='<bean:write  name="userBean" property="monday.dt"/>0000'
                    value='<bean:write name="userBean" property="monday.examineState" />'>
                </td>
                <td
                    ${(userBean.tuesday.dt==null) ? "style='background-color:#D7D9DA;'":"onmouseover='bigger(this)'"}
                    style="padding: 0;"
                    id='<bean:write  name="userBean" property="tuesday.dt"/>00'>
                    <div class="tdcls">
                        <bean:write name="userBean"
                            property="tuesday.dt" />
                    </div> <font
                    ${(userBean.tuesday.state ==false||userBean.tuesday.comeState==1||userBean.tuesday.extra_state==false) ? "color='red'":""}><bean:write
                            name="userBean"
                            property="tuesday.examineState" /><br>
                        <bean:write name="userBean"
                            property="tuesday.extra_symbol" /><br>
                        <bean:write name="userBean"
                            property="tuesday.late_state" /><br> <bean:write
                            name="userBean"
                            property="tuesday.start_time" /><br> <bean:write
                            name="userBean" property="tuesday.end_time" /></font>
                    <input type="hidden"
                    id='<bean:write  name="userBean" property="tuesday.dt"/>0000'
                    value='<bean:write name="userBean" property="tuesday.examineState" />'>
                </td>
                <td
                    ${(userBean.wednesday.dt==null) ? "style='background-color:#D7D9DA;'":"onmouseover='bigger(this)'"}
                    style="padding: 0;"
                    id='<bean:write  name="userBean" property="wednesday.dt"/>00'>
                    <div class="tdcls">
                        <bean:write name="userBean"
                            property="wednesday.dt" />
                    </div> <font
                    ${(userBean.wednesday.state ==false||userBean.wednesday.comeState==1||userBean.wednesday.extra_state==false) ? "color='red'":""}><bean:write
                            name="userBean"
                            property="wednesday.examineState" /><br>
                        <bean:write name="userBean"
                            property="wednesday.extra_symbol" /><br>
                        <bean:write name="userBean"
                            property="wednesday.late_state" /><br>
                        <bean:write name="userBean"
                            property="wednesday.start_time" /><br>
                        <bean:write name="userBean"
                            property="wednesday.end_time" /></font> <input
                    type="hidden"
                    id='<bean:write  name="userBean" property="wednesday.dt"/>0000'
                    value='<bean:write name="userBean" property="wednesday.examineState" />'>
                </td>
                <td
                    ${(userBean.tursday.dt==null) ? "style='background-color:#D7D9DA;'":"onmouseover='bigger(this)'"}
                    style="padding: 0;"
                    id='<bean:write  name="userBean" property="tursday.dt"/>00'>
                    <div class="tdcls">
                        <bean:write name="userBean"
                            property="tursday.dt" />
                    </div> <font
                    ${(userBean.tursday.state ==false||userBean.tursday.comeState==1||userBean.tursday.extra_state==false) ? "color='red'":""}><bean:write
                            name="userBean"
                            property="tursday.examineState" /><br>
                        <bean:write name="userBean"
                            property="tursday.extra_symbol" /><br>
                        <bean:write name="userBean"
                            property="tursday.late_state" /><br> <bean:write
                            name="userBean"
                            property="tursday.start_time" /><br> <bean:write
                            name="userBean" property="tursday.end_time" /></font>
                    <input type="hidden"
                    id='<bean:write  name="userBean" property="tursday.dt"/>0000'
                    value='<bean:write name="userBean" property="tursday.examineState" />'>
                </td>
                <td
                    ${(userBean.friday.dt==null) ? "style='background-color:#D7D9DA;'":"onmouseover='bigger(this)'"}
                    style="padding: 0;"
                    id='<bean:write  name="userBean" property="friday.dt"/>00'>
                    <div class="tdcls">
                        <bean:write name="userBean" property="friday.dt" />
                    </div> <font
                    ${(userBean.friday.state ==false||userBean.friday.comeState==1||userBean.friday.extra_state==false) ? "color='red'":""}><bean:write
                            name="userBean"
                            property="friday.examineState" /><br>
                        <bean:write name="userBean"
                            property="friday.extra_symbol" /><br>
                        <bean:write name="userBean"
                            property="friday.late_state" /><br> <bean:write
                            name="userBean" property="friday.start_time" /><br>
                        <bean:write name="userBean"
                            property="friday.end_time" /></font> <input
                    type="hidden"
                    id='<bean:write  name="userBean" property="friday.dt"/>0000'
                    value='<bean:write name="userBean" property="friday.examineState" />'>
                </td>
                <td
                    ${(userBean.saturday.dt==null) ? "":"onmouseover='bigger(this)'"}
                    style="background-color: #D6F7FA; padding: 0;"
                    id='<bean:write  name="userBean" property="saturday.dt"/>00'>
                    <div class="tdcls" >
                        <bean:write name="userBean"
                            property="saturday.dt" />
                    </div> <font
                    ${(userBean.saturday.extra_state==false) ? "color='red'":""}>
                        <bean:write name="userBean"
                            property="saturday.examineState" /><br>
                        <bean:write name="userBean"
                            property="saturday.extra_symbol" /><br>
                        <bean:write name="userBean"
                            property="saturday.start_time" /> <br>
                        <bean:write name="userBean"
                            property="saturday.end_time" />
                </font><input type="hidden"
                    id='<bean:write  name="userBean" property="saturday.dt"/>0000'
                    value='<bean:write name="userBean" property="saturday.examineState" />'>
                </td>
            </tr>
        </logic:iterate>
    </table>
    <div style="display: none; align: center;">
        <ul id="leavelist" style="display: inline-block; align: center;">
            <logic:iterate id="userBean1" name="_SeekForm"
                property="leaveList">
                <li
                    class='<bean:write name="userBean1" property="showId" />'><div>
                        休&nbsp;&nbsp;假&nbsp;&nbsp;种&nbsp;&nbsp;类：
                        <bean:write name="userBean1"
                            property="leaveType" />
                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<br>
                        休假開始時間：
                        <bean:write name="userBean1"
                            property="leaveStartTime" />
                        <br>休假終了時間：
                        <bean:write name="userBean1"
                            property="leaveEndTime" />
                    </div></li>
            </logic:iterate>
        </ul>
        <ul id="extralist" style="display: inline-block; align: center;">
            <logic:iterate id="userBean" name="_SeekForm"
                property="extra_list">
                <li
                    class='<bean:write name="userBean" property="showId" />000000'><div>
                        殘&nbsp;&nbsp;業&nbsp;&nbsp;种&nbsp;&nbsp;类：
                        <bean:write name="userBean"
                            property="extra_type" />
                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<br>
                        殘業開始時間：
                        <bean:write name="userBean"
                            property="extra_starttime" />
                        <br>殘業終了時間：
                        <bean:write name="userBean"
                            property="extra_endtime" />
                    </div></li>

            </logic:iterate>
        </ul>
        <ul id="evectionlist"
            style="display: inline-block; align: center;">
            <logic:iterate id="userBean" name="_SeekForm"
                property="evectionlist">
                <li
                    class='<bean:write name="userBean" property="showId" />00000000'><div>
                        出&nbsp;&nbsp;張&nbsp;&nbsp;場&nbsp;&nbsp;所：
                        <bean:write name="userBean"
                            property="evectionDestination" />
                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<br>
                        出張開始時間：
                        <bean:write name="userBean"
                            property="evectionStarttime" />
                        <br>出張終了時間：
                        <bean:write name="userBean"
                            property="evectionEndtime" />
                    </div></li>

            </logic:iterate>
        </ul>
    </div>
    <fieldset id="fieldset"
        style="display: none;background-color: #D6F7FA;width:23%; float:right; margin: 30px;">
        <legend>詳細情報</legend>
        <div id="fade"
            style="width: 300px; min-height: 490px;margin:0 auto;">

        </div>
    </fieldset>
</div>
        </div>
    </div>

</body>
<script type="text/javascript">
    function bigger(value) {
        var y = "src='images/photo/" + document.getElementById('JN_card').value
                + ".jpg'";
        document.getElementById('fieldset').style.display = 'block';//显示详细信息的区域
        var x = value.id;
        var ph = value.id / 100 ;
        var extra = value.id * 10000;
        var state = value.id * 100;
        var h_value = document.getElementById(state).value;
        var evection = extra + "00";
        var leave_html = " ";
        var extra_html = " ";
        var evection_html = " ";
        for (var i = 0; i < document.getElementsByClassName(ph).length; i++) {
            leave_html = leave_html
                    + document.getElementsByClassName(ph)[i].innerHTML;
        }
        for (var i = 0; i < document.getElementsByClassName(extra).length; i++) {
            extra_html = extra_html + "<br>"
                    + document.getElementsByClassName(extra)[i].innerHTML;
        }
        for (var i = 0; i < document.getElementsByClassName(evection).length; i++) {
            evection_html = evection_html
                    + document.getElementsByClassName(evection)[i].innerHTML;
        }
         if (document.getElementsByClassName(evection) == null) {

        	if (document.getElementsByClassName(extra) == null
                    && ((document.getElementsByClassName(ph) == null && (h_value == null || h_value == "")) || (h_value != "会社を休む"))) {
                document.getElementById('fade').innerHTML = "<img "+y+"/>"
                        + "<br>" +document.getElementById("shijian").value +"/" + document.getElementById(x).innerHTML
            }  else if (document.getElementsByClassName(extra) == null) {
                document.getElementById('fade').innerHTML = "<img "+y+"/>"
                        + "<br>" +document.getElementById("shijian").value +"/" + document.getElementById(x).innerHTML
                        + "<br>" + leave_html;
            } else if ((document.getElementsByClassName(ph) == null && (h_value == null || h_value == ""))
                    || (h_value != "会社を休む")) {
                document.getElementById('fade').innerHTML = "<img "+y+"/>"
                        + "<br>" +document.getElementById("shijian").value +"/" + document.getElementById(x).innerHTML
                        + "<br>" + extra_html;
            } else {
                document.getElementById('fade').innerHTML = "<img "+y+"/>"
                        + "<br>" + document.getElementById("shijian").value +"/" +document.getElementById(x).innerHTML
                        + "<br>" + leave_html + "<br>" + extra_html;
            }
        }  else {
            if (document.getElementsByClassName(extra) == null
                    && ((document.getElementsByClassName(ph) == null && (h_value == null || h_value == "")) || (h_value != "会社を休む"))) {
                document.getElementById('fade').innerHTML = "<img "+y+"/>"
                        + "<br>" + document.getElementById("shijian").value +"/" + document.getElementById(x).innerHTML
                        + "<br>" + evection_html;
            } else if (document.getElementsByClassName(extra) == null) {
                document.getElementById('fade').innerHTML = "<img "+y+"/>"
                        + "<br>" +document.getElementById("shijian").value +"/" + document.getElementById(x).innerHTML
                        + "<br>" + leave_html + "<br>" + evection_html;
            } else if ((document.getElementsByClassName(ph) == null && (h_value == null || h_value == ""))
                    || (h_value != "会社を休む")) {
            	//=照片+几号+加班+请假
                document.getElementById('fade').innerHTML = "<img "+y+"/>"
                        + "<br>" + document.getElementById("shijian").value +"/" +document.getElementById(x).innerHTML
                        + "<br>" + extra_html + "<br>" + evection_html;
            } else {
                document.getElementById('fade').innerHTML = "<img "+y+"/>"
                        + "<br>" + document.getElementById("shijian").value +"/" +document.getElementById(x).innerHTML
                        + "<br>" + leave_html + "<br>" + extra_html + "<br>"
                        + evection_html;
            }
        }
    }

     function smaller() {
        document.getElementById('fade').style.display = 'none';
    }
</script>
</html>

