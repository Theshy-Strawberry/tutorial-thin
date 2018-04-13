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
<title>权限管理</title>
<link rel="stylesheet" type="text/css" href="css/base.css" />
<link rel="stylesheet" type="text/css" href="css/main.css" />
<script type="text/javascript" src="js/laydate/laydate.js"></script>
<script src="js/laydate/laydate.js" type="text/javascript"></script>
<script type="text/javascript" src="js/jquery-1.11.3.min.js"></script>
<script type="text/javascript" src="js/fixed_midashi_src.js"></script>
<script type="text/javascript" src="js/fixed_midashi.js"></script>
<script type="text/javascript">
	$(function() {
		$('#left-container .content').hide();
		$('#kengenhenkou').show();
		$('h2.tit').click(function() {
			$(this).next('.content').stop().slideToggle();

		})
	})
</script>
<script type="text/javascript">
	$(function() {
		var value = $("#selectCheck").val();
		if (value != null) {
			$("#leaveType option[value='" + value + "']").attr("selected",
					false);
			$("#leaveType option[value='" + value + "']")
					.attr("selected", true);
		}
	})
	$(function() {
		var value = $("#selectCheck1").val();
		if (value != null) {
			$("#leaveType1 option[value='" + value + "']").attr("selected",
					false);
			$("#leaveType1 option[value='" + value + "']").attr("selected",
					true);
		}
	})
	$(function() {
		var value = $("#duty").val();
		if (value != null) {
			$("#dutyyy option[value='" + value + "']").attr("selected",
					false);
			$("#dutyyy option[value='" + value + "']").attr("selected",
					true);
		}
	})
	$(function() {
		var value = $("#selectCheck2").val();
		if (value != null) {
			$("#leaveType2 option[value='" + value + "']").attr("selected",
					false);
			$("#leaveType2 option[value='" + value + "']").attr("selected",
					true);
		}
	})
	$(function() {
		var value = $("#selected").val();
		if (value != null) {
			$("#qwetr option[value='" + value + "']").attr("selected",
					false);
			$("#qwetr option[value='" + value + "']").attr("selected",
					true);
		}
	})
</script>
<script type="text/javascript">
$(function(){
   $("#resetButton").click(function(){
        $("#quanxianname").text(null);
        $("#projectname").text(null);

    });
})

$(function() {
		var checkResult= $("#checkResult").val();
		if(checkResult=='success'){
			alert("修改成功");
			$("#checkResult").val("");
		}
	});
</script>
<script>
	function bao(s) {
		$("#selectCheck").val(s);
	}
	function bao1(ss) {
		$("#selectCheck1").val(ss);
	}
	function bao2(sss) {
		$("#selectCheck2").val(sss);
	}
	function bao3(sss) {
		$("#selected").val(sss);
	}
	function getvalue(aaa){
		$("#duty").val(aaa);
	}
</script>
</head>
<body onload="getflagMethod();">
	..
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
                value="<bean:write name="flag" scope="session" />" />
			<input id="userId" type="hidden"
				value="<bean:write name="userId" scope="session" />" />
		</div>
		<!--/左侧部分 -->
		<!--右侧部分 -->
		<div class="rightWidht">
			<div class="header">
				<ul class="breadcrumbs clearfix">
					<li>ステップチャート：</li>
					<li><a href="#">権限管理</a></li>
					<li class="ico">&gt;</li>
					<li><a href="#">権限変更</a></li>
				</ul>
			</div>

			<div
				style="max-height: 150px; overflow: auto; width: 500px; margin-left: 40px;">
				<html:errors />
				<html:messages id="message" message="true">
					<bean:write name="message" />
				</html:messages>
			</div>


<!-- <div style="display: table-cell"> -->


			<div class="main-ctn">

<ts:form action="/JNTCISuperButtonPowerSelect">
					<table>
						<tr>
							<th style="border: none; padding-left: 10px"><label>卡&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;号：</label> <html:text
									property="usersId"  maxlength="4"  name="_JNTCISuperButtonForm" />
									<html:hidden property="usersId" name="_JNTCISuperButtonForm"/> </th>
							<th style="border: none; padding-left: 75px"><ts:submit
									styleClass="btn btn-green" value="检索" /></th>
						</tr>
					</table>
				</ts:form>
			<div>

				<div style="display: table-cell">

				 <ts:form action="/JNTCISuperButtonProjectModify">
					<table width="100%" style="margin-top: 0px; margin-bottom: 0px">
						<colgroup>
							<col width="80px" />
							<col width="80px" />
							<col width="80px" />
						</colgroup>
						<tr>
							<th colspan="2"
								style="border: none; text-align: left; padding-left: 10px">項目変更</th>
						</tr>
						<tr>
							<td style="text-align: left; padding-left: 10px"><label>名&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;前：</label>
								<html:text property="userName" name="_JNTCISuperButtonForm"
									readonly="true" /><html:hidden property="usersId" name="_JNTCISuperButtonForm"/></td>
							<td style="text-align: left; padding-left: 10px"><label>項目名前と項目负责人：
									<html:hidden property="projectId" name="_JNTCISuperButtonForm"
										styleId="selectCheck1" />
							</label> <html:select name="_JNTCISuperButtonForm" property="projectId"
									styleId="leaveType1"
									onchange="bao1(this.options[this.options.selectedIndex].value)">
									<option value=""></option>
									<logic:iterate id="JNTCISuperButtonFormBean"
										name="_JNTCISuperButtonForm" property="projectlist">
										<option
											value="<bean:write name="JNTCISuperButtonFormBean" property="pro" />"><bean:write
												name="JNTCISuperButtonFormBean" property="proname" /></option>
									</logic:iterate>
								</html:select></td>
						</tr>
						<tr>
							<td style="border: none; text-align: center; padding-left: 55px"><ts:submit
									styleClass="btn btn-green" value="確認" property="forward_sure" /></td>
							<td style="border: none; text-align: left; padding-left: 55px"><html:reset
									styleClass="btn btn-red" style="" value="重置" property="forward_reset" /></td>
						</tr>

					</table>
				</ts:form>

				</div>

				<div style="display: table-cell">
				<ts:form action="/JNTCISuperButtonModify">
					<table width="60%" style="margin-top: 0px; margin-bottom: 0px">
						<colgroup>
							<col width="80px" />
							<col width="80px" />
						</colgroup>
						  <logic:equal name="flag" scope="session"
                                value="0">
						<tr>
							<th colspan="2"
								style="border: none; text-align: left; padding-left: 10px">権限変更</th>
						</tr>
						<tr>
							<td style="text-align: left; padding-left: 30px"><label>名前：</label>
								<html:text property="userName" name="_JNTCISuperButtonForm"
									readonly="true" /><html:hidden property="usersId" name="_JNTCISuperButtonForm"/></td>
							<td style="text-align: left; padding-left: 10px"><label>権&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;限：
									<html:hidden property="power" name="_JNTCISuperButtonForm"
										styleId="selectCheck" />
							</label> <html:select name="_JNTCISuperButtonForm" property="power"
									styleId="leaveType"
									onchange="bao(this.options[this.options.selectedIndex].value)">
									<option value=""></option>
									<logic:iterate id="JNTCISuperButtonFormBean"
										name="_JNTCISuperButtonForm" property="rolelist">
										<option
											value="<bean:write name="JNTCISuperButtonFormBean" property="code_id" />"><bean:write
												name="JNTCISuperButtonFormBean" property="kj_name" /></option>
									</logic:iterate>
								</html:select></td>
						</tr>
						<tr>
							<td style="border: none; text-align: center; padding-left: 30px"><ts:submit
									styleClass="btn btn-green" value="確認" property="forward_sure" /></td>
							<td style="border: none; text-align: left; padding-left: 30px"><html:reset
									styleClass="btn btn-red" style="" value="重置" property="forward_reset" /></td>
						</tr>
                     </logic:equal>
					</table>
				</ts:form>

				</div>




				</div>

<hr style=" padding: 0px 0;margin:0px 0">
				<div style=" padding: 0px 0;margin:0px 0">
<div style="display: table-cell">
				 <ts:form action="/JNTCISuperButtonPowerAdd">
					<table width="66%" style="margin-top:0px">
						<colgroup>
							<col width="80px" />
							<col width="80px" />
						</colgroup>
						  <logic:equal name="flag" scope="session"
                                value="0">
						<tr>
							<th style="border: none; text-align: left; padding-left: 10px">新增権限</th>

						</tr>
						<tr>
							<td><label>権限名前：</label> <html:text property="quanxianname"
									name="_JNTCISuperButtonForm"  styleId="quanxianname"/></td>
						</tr>
</logic:equal>
						<tr>
							<th style="border: none; text-align: left; padding-left: 10px">新增項目</th>
						</tr>
						<tr>
							<td><label>項目名前：</label>
							<input type="hidden" id="checkResult" value="<bean:write
									name="_JNTCISuperButtonForm" property="checkresult"/>"/>
							<html:text property="projectname"
									name="_JNTCISuperButtonForm"  styleId="projectname"/></td>
									<td><label>項目负责人：
									<html:hidden property="projectdutyname" name="_JNTCISuperButtonForm" styleId="duty"/>
							</label>  <html:select name="_JNTCISuperButtonForm" property="projectdutyname"  styleId="dutyyy"
									onchange="getvalue(this.options[this.options.selectedIndex].value)">
									<option value=""></option>
									 <logic:iterate id="JNTCISuperButtonFormBean"
										name="_JNTCISuperButtonForm" property="pmlist">
										<option
											value="<bean:write name="JNTCISuperButtonFormBean" property="projectdutyname" />"><bean:write
												name="JNTCISuperButtonFormBean" property="concat" /></option>
									</logic:iterate>

								</html:select>
									</td>
						</tr>
						<tr>
							<td style="border: none; text-align: center;padding-left: 55px"><ts:submit
									styleClass="btn btn-green" value="追加" style="" /></td>
								<td style="border: none; text-align: left;padding-left: 55px">
								<html:reset styleClass="btn btn-red" style="" value="クリア" styleId="resetButton"/></td>
						</tr>
					</table>
				</ts:form>
				</div>



				<div style="display: table-cell">
					<ts:form action="/JNTCISuperButtonProjectdelete">
					<table  width="50%" style="margin-top: 0px; margin-bottom: 0px;">
<tr>
							<th
								style="border: none; text-align: left; padding-left: 10px">項目编辑</th>
</tr>
<tr>
<tr>
										<td style="text-align: left; padding-left: 10px"><label>項目名前と項目负责人：
									<html:hidden property="projectId2" name="_JNTCISuperButtonForm"
										styleId="selectCheck2" />
							</label> <html:select name="_JNTCISuperButtonForm" property="projectId2"
									styleId="leaveType2"
									onchange="bao2(this.options[this.options.selectedIndex].value)">
									<option value=""></option>
									<logic:iterate id="JNTCISuperButtonFormBean"
										name="_JNTCISuperButtonForm" property="projectlist">
										<option
											value="<bean:write name="JNTCISuperButtonFormBean" property="pro" />"><bean:write
												name="JNTCISuperButtonFormBean" property="proname" /></option>
									</logic:iterate>

								</html:select></td>
						</tr>
<tr>
							<td style="border: none; text-align: center"><ts:submit
									styleClass="btn btn-green" value="削除" style="margin-right:135px"  />
								</td>
						</tr>
</table>
</ts:form>



</div>

</div>

<hr style=" padding: 0px 0;margin:0px 0">

				<ts:form action="/ProjectPersonSelect">
					 <table  width="30%" >
<tr>							<th
								style="border: none; text-align: left; padding-left: 10px">項目成員检索</th>
</tr>
<tr>
										<td style="text-align: left; padding-left: 10px"><label>項目名前：
									<html:hidden property="projectId1" name="_JNTCISuperButtonForm"
										styleId="selected" />
							</label> <html:select name="_JNTCISuperButtonForm" property="projectId1"
									styleId="qwetr"
									onchange="bao3(this.options[this.options.selectedIndex].value)">
									<option value=""></option>
									<logic:iterate id="JNTCISuperButtonFormBean"
										name="_JNTCISuperButtonForm" property="projectnamelist">
										<option
											value="<bean:write name="JNTCISuperButtonFormBean" property="pro1" />"><bean:write
												name="JNTCISuperButtonFormBean" property="proname1" /></option>
									</logic:iterate>

								</html:select></td>
								<td style="border: none; text-align: center"><ts:submit
									styleClass="btn btn-green" value="检索" style="margin-right:14px"  />
								</td>
						</tr>
</table>
</ts:form>
<div class="scroll-y" id="scroll" style="width:240px; height:200px; overflow:auto; border:0px solid #000000;">
<table >
                            <tbody>
                                <logic:notEmpty name="_JNTCISuperButtonForm"
                                    property="selectprojectusernamelist">
                                    <logic:iterate id="userBean"
                                        name="_JNTCISuperButtonForm"
                                        property="selectprojectusernamelist"
                                        indexId="index">
                                        <tr style="height:5px;padding:0px 0">
                                                    <td style="height:0px;padding:0px 0;width:220px;"><bean:write
                                                    name="userBean"
                                                    property="nameandcard" /></td>
                                        </tr>
                                    </logic:iterate>
                                </logic:notEmpty>
                            </tbody>
                        </table>
                        </div>
<div class="footer">
					<p>
						連絡メール：<a href="mailto:jinan@trans-cosmos.com.cn" target="_blank">jinan@trans-cosmos.com.cn</a>
					</p>
				</div>
			</div>
		</div>
	</div>
</body>
</html>