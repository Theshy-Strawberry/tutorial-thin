<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="/struts-html" prefix="html"%>
<%@ taglib uri="/struts-bean" prefix="bean"%>
<%@ taglib uri="/struts-logic" prefix="logic"%>
<%@ taglib uri="/terasoluna-struts" prefix="ts"%>
<%@ taglib uri="/terasoluna" prefix="t"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%
	request.setCharacterEncoding("utf-8");
%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/base.css" />
<link rel="stylesheet" type="text/css" href="css/main.css" />
<link rel="stylesheet" type="text/css" href="Style/skin.css" />
<script type="text/javascript" src="js/laydate/laydate.js"></script>
<script type="text/javascript" src="js/jquery-1.11.3.min.js"></script>
<script type="text/javascript">
function onSubimitfun(type){
	if(type == "1"){
		$("#examine_status").val("A06");
	}else if(type == "2"){
		$("#examine_status").val("A05");
	}else if(type == "3"){
		$("#examine_status").val("A04");
	}else if(type == "4"){
		$("#examine_status").val("back");
	}
	 $("#formid").submit();
}
	$(function() {
		$('#left-container .content').hide();
		$('#Attendance').show();
		$('h2.tit').click(function() {
			$(this).next('.content').stop().slideToggle();

		})
	});
function buttonHidden(){
	var hideFlag=$("#shencha").val();
	var userId=$("#userId").val();
	if(hideFlag=="終了"){
		$("#admit").attr("disabled",true);
	}
	if(userId!="1070"&&userId!="1003"&&userId!="1004"&&hideFlag=="承認中"){
		$("#admit").attr("disabled",true);
	}
	if(hideFlag=="承認しない"){
		$("#refuse").attr("disabled",true);
	}
	if(hideFlag=="PM承認しない"){
		$("#refuse").attr("disabled",true);
	}
	if(hideFlag=="未審査"){
		$("#rollback").attr("disabled",true);
	}

}

</script>
</head>
<body onload="buttonHidden()">
	<div>
		<jsp:include page="/top.jsp" flush="true" />
	</div>
	<!--/头部分 -->
	<div style="position:relative;" >
		<!--左侧部分 -->
		<div style="position:absolute;">
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
					<li><a href="#">考勤監査 </a></li>
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
				  <ts:form action="/JNTCIAuditstatBL" method="post"  styleId="formid">
            	<ul>
                    <li>
	                    <input type="hidden" id="examine_status" name="examine_status" value=""/>
	                    <input type="hidden" id="RETROACTIVE_ID" name="RETROACTIVE_ID" value="<bean:write name="_JNTCIaddsignInfo" property="RETROACTIVE_ID"/>"/>
                        <label>社員カード：
						            <html:hidden name="_JNTCIaddsignInfo" property="startIndex"></html:hidden>
									<html:hidden name="_JNTCIaddsignInfo" property="JN_CARD_SEARCH"></html:hidden>
									<html:hidden name="_JNTCIaddsignInfo" property="USER_NAME_SEARCH"></html:hidden>
									<html:hidden name="_JNTCIaddsignInfo" property="retroactive_type2"></html:hidden>
									<html:hidden name="_JNTCIaddsignInfo" property="retroactive_auditss_search"></html:hidden>
									<html:hidden name="_JNTCIaddsignInfo" property="retroactive_starttime_search"></html:hidden>
									<html:hidden name="_JNTCIaddsignInfo" property="retroactive_endtime_search"></html:hidden></label>
                        <span> <bean:write name="_JNTCIaddsignInfo" property="JN_CARD"/>
                        		 <html:hidden property="JN_CARD" name="_JNTCIaddsignInfo"/>
                        		 <html:hidden property="RETROACTIVE_ID" name="_JNTCIaddsignInfo"/>
                        </span>
                        <label>社員名前：</label>
                        <span>
                        	<bean:write name="_JNTCIaddsignInfo" property="USER_NAME"/>
						</span>
                    </li>
                    <li>
                        <label>所属上司：</label>
                     	<html:hidden styleId="shencha" name="_JNTCIaddsignInfo" property="shencha"/>
                        <span><bean:write name="_JNTCIaddsignInfo" property="person"/></span>
                        <label>部門所属：</label>
                        <span>
                        	<bean:write name="_JNTCIaddsignInfo" property="k_name"/>
                        	<html:hidden name="_JNTCIaddsignInfo" property="k_name"/>
                        </span>
                    </li>
                    <li><label>補くじタイプ:</label>
                        <span><bean:write name="_JNTCIaddsignInfo" property="reason_type"/>
                        	  <html:hidden name="_JNTCIaddsignInfo" property="reason_type"/>
						</span>
                    </li>
                    <li class="vt">
                       <label>出勤始止時間：</label>
                       <bean:write name="_JNTCIaddsignInfo" property="start_time_add"/> ～
                       <bean:write name="_JNTCIaddsignInfo" property="end_time_add"/>
                       <html:hidden property="start_time_add" name="_JNTCIaddsignInfo"/>
                       <html:hidden property="end_time_add" name="_JNTCIaddsignInfo"/>
                       <html:hidden property="RETROACTIVE_TYPE" name="_JNTCIaddsignInfo"/>
                       <html:hidden property="USER_NAME" name="_JNTCIaddsignInfo"/>
                    </li>
                    <li class="vt">
                        <label>補くじ理由：</label>
                        <span> <bean:write name="_JNTCIaddsignInfo" property="retroactive_reason"/></span>
                    </li>
                    <li >
                         <logic:notEmpty name="_JNTCIaddsignInfo"
                property="tenpu_path">
                        <label  >添付ファイル:</label>
                 <a href="${pageContext.request.contextPath}/DownloadFile.do?RETROACTIVE_ID=<bean:write name='_JNTCIaddsignInfo' property='RETROACTIVE_ID'/>">
                     <span   style="width: 80%;" > <bean:write name="_JNTCIaddsignInfo" property="tenpu_path"/>
                        	</span></a></logic:notEmpty>
                    </li>
                    <li style=" padding:10px 0 0 170px;">
                    	<input id="userId" type="hidden" value="<bean:write name="userId" scope="session" />"/>
                       	<input name="承認" type="button" id="admit" style="min-width:70px; margin-right:20px" class="btn btn-blue" value="承認" onclick="onSubimitfun(1)"/>
                        <input name="承認しない" type="button" id="refuse" style="min-width:70px; margin-right:20px" class="btn btn-red" value="承認しない" onclick="onSubimitfun(2)"/>
                        <input name="差戻し" type="button" id="rollback" style="min-width:70px; margin-right:20px" class="btn btn-green" value="差戻し" onclick="onSubimitfun(3)"/>
                        <input id="goback" name="戻る" type="button" style="min-width: 70px; margin-right: 20px" class="btn btn-blue" value="戻る" onclick="onSubimitfun(4)"  />
                    </li>
                </ul>
		</ts:form>
        <div class="footer">
       		<p>連絡メール：<a href="mailto:jinan@trans-cosmos.com.cn" target="_blank">jinan@trans-cosmos.com.cn</a></p>
    	</div>
    </div>
		</div>
	</div>
</body>
</html>