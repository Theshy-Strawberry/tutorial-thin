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
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/laydate/laydate.js"></script>
<script type="text/javascript" src="js/jquery-1.11.3.min.js"></script>
<link rel="stylesheet" type="text/css" href="css/base.css" />
<link rel="stylesheet" type="text/css" href="css/main.css" />
<link rel="stylesheet" type="text/css" href="Style/skin.css" />
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
    	 function onSubimitfun(type){
			  if (type == "1") {
				$("#extra_auditss").val("A06");
			 }else if(type == "2") {
				$("#extra_auditss").val("A05");
			 }else{
			    $("#extra_auditss").val("A04");
			 }
$("#formid").submit();
}
</script>
<script type="text/javascript">
    function subimit() {
        $("#extra_auditss").val("back");
        $("#formid").submit();
    }
</script>
<script type="text/javascript">
function getf(){
    var extra_auditss =  document.getElementById("extra_auditss").value
	   var flag = document.getElementById("flag").value
	   var userId = document.getElementById("userId").value
	   var userName = document.getElementById("userName").value
    if(userId=="1070"||userId=="1002"){
			  $('#l1').hide();
			  $('#l2').hide();
		    }else{
			  if(extra_auditss=="A05"){
		      	$('#disagree').attr('disabled', "true");
		      }
		      if(extra_auditss=="A06"){
		    		$('#agree').attr('disabled', "true");
		      }
		    }
}
</script>
</head>

<body onload="getf();">
    <!--头部分 -->
    <div>
        <jsp:include page="/top.jsp" flush="true" />
    </div>
    <!--/头部分 -->
    <div style="position: relative;">
        <!--左侧部分 -->
        <div style="position: absolute;">
            <jsp:include page="/left.jsp" flush="true" />
            <input id="flag" type="hidden"
                value="<bean:write name="flag" scope="session" />" /> <input
                id="userId" type="hidden"
                value="<bean:write name="userId" scope="session" />" />
            <input id="userName" type="hidden"
                value="<bean:write name="userName" scope="session" />" />
        </div>
        <!--/左侧部分 -->
        <!--右侧部分 -->
        <div class="rightWidht">
            <div class="header">
                <ul class="breadcrumbs clearfix">
                    <li>ステップチャート：</li>
                    <li><a href="#">勤務管理</a></li>
                    <li class="ico">&gt;</li>
                    <li><a href="#">残業審査詳細</a></li>
                </ul>
            </div>
            <div class="main-ctn"
                style="max-height: 100px; overflow: auto;">
                <html:errors />
                <html:messages id="message" message="true">
                    <bean:write name="message" />
                </html:messages>
            </div>
            <div class="main-ctn ul-li">
                <ts:form styleId="formid"
                    action="/JNTCIOverTimeVerifyresultupdate.do">

                    <ul>
                        <html:hidden name="_JNTCIOverTimeVerify02Form"
                            property="extra_id"></html:hidden>
                        <html:hidden styleId="extra_auditss"
                            name="_JNTCIOverTimeVerify02Form"
                            property="extra_auditss"></html:hidden>
                        <html:hidden styleId="examinePerson"
                            name="_JNTCIOverTimeVerify02Form"
                            property="examinePerson"></html:hidden>
                        <li><label>社員カード：<html:hidden
                                    name="_JNTCIOverTimeVerify02Form"
                                    property="startIndex"></html:hidden>
                                <html:hidden
                                    name="_JNTCIOverTimeVerify02Form"
                                    property="user_id2"></html:hidden> <html:hidden
                                    name="_JNTCIOverTimeVerify02Form"
                                    property="user_name2"></html:hidden>
                                <html:hidden
                                    name="_JNTCIOverTimeVerify02Form"
                                    property="dept_id2"></html:hidden> <html:hidden
                                    name="_JNTCIOverTimeVerify02Form"
                                    property="extra_starttime1"></html:hidden>
                                <html:hidden
                                    name="_JNTCIOverTimeVerify02Form"
                                    property="extra_endtime1"></html:hidden>
                                <html:hidden
                                    name="_JNTCIOverTimeVerify02Form"
                                    property="extra_auditss_search"></html:hidden></label>
                            <span><bean:write
                                    name="_JNTCIOverTimeVerify02Form"
                                    property="user_id" />
                                     <html:hidden
                                    name="_JNTCIOverTimeVerify02Form"
                                    property="user_id" ></html:hidden>
                                    </span> <label>社員名前：</label>
                            <span><bean:write
                                    name="_JNTCIOverTimeVerify02Form"
                                    property="user_name" /></span> <html:hidden
                                name="_JNTCIOverTimeVerify02Form"
                                property="user_name"></html:hidden></li>
                        <li><label>プロジェクトPM：</label> <span><bean:write
                                    name="_JNTCIOverTimeVerify02Form"
                                    property="leader" /></span> <label>所属部門：</label>
                            <span><bean:write
                                    name="_JNTCIOverTimeVerify02Form"
                                    property="dept_id" /></span></li>
                      <li> <label>残業種類：</label> <span> <html:hidden
                                    name="_JNTCIOverTimeVerify02Form"
                                    property="extra_type" /> <bean:write
                                    name="_JNTCIOverTimeVerify02Form"
                                    property="extra_name" /></span></li>
                        <li class="vt"><label>残業開始時間：</label> <bean:write
                                name="_JNTCIOverTimeVerify02Form"
                                property="extra_starttime" /> 至 <bean:write
                                name="_JNTCIOverTimeVerify02Form"
                                property="extra_endtime" /> <html:hidden
                                name="_JNTCIOverTimeVerify02Form"
                                property="extra_starttime"></html:hidden>
                            <html:hidden
                                name="_JNTCIOverTimeVerify02Form"
                                property="extra_endtime"></html:hidden></li>
                        <li class="vt"><label>合計時長：</label> <bean:write
                                name="_JNTCIOverTimeVerify02Form"
                                property="extra_time" /> (小时)</li>
                        <li class="vt"><label>残業原因：</label> <bean:write
                                name="_JNTCIOverTimeVerify02Form"
                                property="extra_reason" /></li>
                        <li
                            style="display: inline-block; padding: 10px 0 0 150px;"
                            id="l2"><input name="承認" id="agree"
                            type="button"
                            style="min-width: 70px; margin-right: 20px"
                            class="btn btn-blue" value="承認"
                            onclick="onSubimitfun(1)" /> <input
                            id="disagree" name="承認しない" type="button"
                            class="btn btn-red" value="承認しない"
                            onclick="onSubimitfun(2)" />
                            <input
							  id="back"  name="back" type="button"
							  style="min-width: 70px; margin-left: 20px"
							  class="btn btn-blue" value="差戻し"
							  onclick="onSubimitfun(3)" />
                            </li>
                        <li
                            style="display: inline-block; margin-left: 20px"><input
                            id="getback" name="戻る" type="button"
                            class="btn btn-green" value="戻る"
                            onclick="subimit()" /></li>
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
</body>
</html>