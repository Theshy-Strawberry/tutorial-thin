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
<html:html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>済南大宇宙内部システム-内容区</title>
<link rel="stylesheet" type="text/css" href="css/base.css" />
<link rel="stylesheet" type="text/css" href="css/main.css" />
<script type="text/javascript" src="js/laydate/laydate.js"></script>
<script type="text/javascript" src="js/jquery-1.11.3.min.js"></script>
<script type="text/javascript" src="js/jquery.validate.js" ></script>
<script type="text/javascript">
$(function() {
	var value = $("#selectCheck1").val();
	if(value != null || value != ""){
		$("#retroactive02 option[value='"+value+"']").attr("selected", false);
		$("#retroactive02 option[value='"+value+"']").attr("selected", true);
	}

	$("#retroactive02").change(function() {
		var dropBox = $("#retroactive02").val();
		if(dropBox !=""){

			$("#retroactive02 option[value='"+dropBox+"']").attr("selected", true);
		}
	})
});
</script>
<script type="text/javascript">
function fileChange(file) {
    var fn = document.getElementById('uploadFile').value;
    if (fn != null) {
        document.getElementById('fileName').value = fn
    }
}
$(function() {
    $("#uploadFileBt").click(function() {
        $("#uploadFile").click();
    })
})

	$(function() {
		var b = document.getElementById("retroactive02").value;
		if (b== 4) {
			$("#hid").hide();
		} else if (b== 5) {
			$("#hid").show();
		} else {

		}
		var retroactive_type_keepval = $("#retroactive_type_keepval").val();
		//1度選んだ値
		var valre = $("#retroactive_type_forwardval").val();
		var value = $("#selectCheck").val();
		var value1 = $("#selectCheck2").val();
		if(value != null || value != ""){
			$("#retroactive option[value='"+value1+"']").attr("selected", false);
			$("#retroactive option[value='"+value1+"']").attr("selected", true);
		}
		$("#retroactive").change(function() {
			var dropBox = $("#retroactive").val();
			if(dropBox !=""){

				$("#retroactive option[value='"+dropBox+"']").attr("selected", true);
			}
		})
		if (valre == 3||value == 3 || value1==3) {
			$("#line").show();
			$("#endDateTime").show();
			$("#startDateTime").show();
			$("#startDateTime").removeAttr("style");
			$("#endDateTime").removeAttr("style");
		} else if (valre == 2||value == 2  || value1==2) {
			$("#line").hide();
			$("#startDateTime").hide();
			$("#endDateTime").show();
			$("#endDateTime").removeAttr("style");
		} else {
			$("#line").hide();
			$("#endDateTime").hide();
			$("#startDateTime").show();
			$("#startDateTime").removeAttr("style");
		}

		$('#left-container .content').hide();
		$('#Attendance').show();
		$('h2.tit').click(function() {
			$(this).next('.content').stop().slideToggle();

		});
	})
</script>
<script type="text/javascript">
		function onload(){
			if($("#userfilename").val()!=null){
				$("#fileName").val($("#userfilename").val());
			}
		}
	function getIndex() {
		//プルダウンフレームの補を取得するタイプ
		var a = document.getElementById("retroactive").value;
		if (a == 3) {
			$("#line").show();
			$("#endDateTime").show();
			$("#startDateTime").show();
			$("#startDateTime").removeAttr("style");
			$("#endDateTime").removeAttr("style");
		} else if (a == 2) {
			$("#line").hide();
			$("#startDateTime").hide();
			$("#endDateTime").show();
			$("#endDateTime").removeAttr("style");
		} else {
			$("#line").hide();
			$("#endDateTime").hide();
			$("#startDateTime").show();
			$("#startDateTime").removeAttr("style");
		}
		$("#retroactive_type_forwardval").val(a);
	}


	function getIndex6() {
		//プルダウンフレームの補を取得するタイプ
		var b = document.getElementById("retroactive02").value;
		if (b== 4) {
			$("#hid").hide();
		} else if (b== 5) {
			$("#hid").show();
		} else {

		}

	}
	//リセットフォーム
	function clearInput() {
		var b = document.getElementById("retroactive").value;
		if(b == 2){
			$("#startDateTime").show();
		}
		$("#jnCard").val("");
		$("#retroactive_type_forwardval").val("");
		$("#startDateTime").val("");
		$("#line").hide();
		$("#endDateTime").hide();
		$("#endDateTime").val("");
		$("#reason").val("");
		$("#retroactive").val("");
		$("#retroactive02").val("");
	    $("#fileName").val("");
	}
	//日付チェック
	function checkDate() {
		var a = document.getElementById("retroactive").value;
		var b = document.getElementById("retroactive02").value;
		var c = document.getElementById("uploadFile").value;
		var startDate = $("#startDateTime").val();
		var subStartDate = startDate.substring(11, 16);
		var hm1 = subStartDate.replace(":", "").trim();
		var hm11 = '0830';
		var hm12 = '1200';
		var endDate = $("#endDateTime").val();
		var subEndDate = endDate.substring(11, 16);
		var hm2 = subEndDate.replace(":", "").trim();
		var hm21 = '1300';
		var hm22 = '1730';

       if(b==4){

      }else if(b==5){
    	  if(c==""){
    		  alert("添付ファイルは入力必須項目です.");
    		  return false;
    	  }else{
    	  }


     }

		if (a == 3) {
			if (startDate == "" || endDate == "") {
				$("#time_is_null_flag").val("");
			} else {
				$("#time_is_null_flag").val("1");
				if ( hm1 <hm2 ) {
					$("#time_format_flag").val("2016-04-14 09:00:00");
				} else {
					$("#time_format_flag").val("1");
				}
			}
		} else if (a == 2) {
			if (endDate == "") {
				$("#time_is_null_flag").val("");
			} else {
				$("#time_is_null_flag").val("1");
					$("#time_format_flag").val("2016-04-14 09:00:00");
			}
		} else if (a == 1) {
			if (startDate == "") {
				$("#time_is_null_flag").val("");
			} else {
				$("#time_is_null_flag").val("1");
					$("#time_format_flag").val("2016-04-14 09:00:00");
			}
		}
	}
	function delect(){
		$("#updateQuFen").val("2");
	}
	function update(){
		$("#updateQuFen").val("1");
		$("#endDateTime").show();
		$("#startDateTime").show();
	}
</script>
<script type="text/javascript">
	function delect(){
		if(confirm('このデータを削除するかどうか')){
			 $("[name='updateQuFen']").val(2);
			 return true;
		}
		  	return false;
	}
	function update(){
		$("[name='updateQuFen']").val(1);
	}

</script>
</head>
<body onload="onload()">
	<!--?部分 -->
	<div>
		<jsp:include page="/top.jsp" flush="true" />
	</div>
	<!--/?部分 -->
	<div style="position: relative;">
		<!--左?部分 -->
		<div style="position: absolute;">
			<jsp:include page="/left.jsp" flush="true" />
		</div>
		<!--/左?部分 -->
		<!--右?部分 -->
		<div class="rightWidht">
			<div class="header">
				<ul class="breadcrumbs clearfix">
					<li>ステップチャート：</li>
					<li><a href="#">勤務管理</a></li>
					<li class="ico">&gt;</li>
					<li><a href="#">稼働修正申請</a></li>
				</ul>
			</div>
			<div style="max-height: 100px; overflow: auto; width: 500px; margin-left: 80px;">
				<html:errors />
				<html:messages id="message" message="true">
				<bean:write name="message" />
				</html:messages>
			</div>

			<div class="main-ctn ul-li">
				<ts:form action="/insertBLforAttendance05" enctype="multipart/form-data">
					<ul>
						<li>
						  <label>申請者カード：</label>
					      <bean:write name="_JNTCIAttendance06Form" property="user_id" />
					      <html:hidden name="_JNTCIAttendance06Form" property="user_id"/>
						</li>
						<li>
						   <label>申請者名前：</label>
						   <bean:write name="_JNTCIAttendance06Form" property="user_name"/>
						   <html:hidden name="_JNTCIAttendance06Form" property="user_name"/>
						</li>
                        <li>
					       <label>所属部門：</label>
					       <bean:write name="_JNTCIAttendance06Form" property="dept_id" />
					       <html:hidden name="_JNTCIAttendance06Form" property="dept_id"/>
					       <html:hidden name="_JNTCIAttendance06Form" property="dept_id_hide"/>

				        </li>
				        <li>
					       <label>所属上司：</label>
					       <bean:write name="_JNTCIAttendance06Form" property="leader" />
					       <html:hidden name="_JNTCIAttendance06Form" property="leader"/>
			        	</li>
			        	<li>
			        		<label for="category">理由種別：<input type="hidden" id="selectCheck"
								value="<bean:write name="_JNTCIAttendance06Form" property="cd_code"/>" /></label>
									<input type="hidden" id="selectCheck1"
								value="<bean:write name="_JNTCIAttendance06Form" property="typecode1"/>" />
			        		<html:select property="reason_type" styleId="retroactive02" name="_JNTCIAttendance06Form"  style="width:150px;" onchange="getIndex6()" >
								<option value="" selected="selected">-選択してください-</option>
								<logic:notEmpty name="_JNTCIAttendance06Form" property="attendance06SelectRecOutput02">
									<logic:iterate id="jNTCIAttendance06" name="_JNTCIAttendance06Form" property="attendance06SelectRecOutput02">
										<option
											value="<bean:write name="jNTCIAttendance06" property="cd_code" />">
											<bean:write name="jNTCIAttendance06" property="kj_name" />
										</option>
									</logic:iterate>
								</logic:notEmpty>
							</html:select>
							<i class="red">*</i>
			        	</li>
						<li>
						   <label for="category">補くじタイプ：<input type="hidden" id="selectCheck"
								value="<bean:write name="_JNTCIAttendance06Form" property="cd_code"/>" /></label>
								<input id="selectCheck2" type="hidden"
								value="<bean:write name="_JNTCIAttendance06Form" property="typecode2"/>" />
						   <html:hidden name="_JNTCIAttendance06Form" property="time_is_null_flag" styleId="time_is_null_flag"></html:hidden>
						    <html:hidden name="_JNTCIAttendance06Form" property="delete_flag" styleId="delete_flag" ></html:hidden>
						    <html:hidden name="_JNTCIAttendance06Form" property="time_format_flag" styleId="time_format_flag"></html:hidden>
							<html:hidden name="_JNTCIAttendance06Form" property="retroactive_type_forwardval" styleId="retroactive_type_forwardval" />
 						    <html:hidden name="_JNTCIAttendance06Form" property="retroactive_type_keepval" styleId="retroactive_type_keepval" />
							<html:select property="retroactive_type" styleId="retroactive" onchange="getIndex()" style="width:150px;">
								<option value="" selected="selected">-選択してください-</option>
								<logic:notEmpty name="_JNTCIAttendance06Form" property="attendance06SelectRecOutput">
									<logic:iterate id="jNTCIAttendance06" name="_JNTCIAttendance06Form" property="attendance06SelectRecOutput">
										<option
											value="<bean:write name="jNTCIAttendance06" property="cd_code" />">
											<bean:write name="jNTCIAttendance06" property="kj_name" />
										</option>
									</logic:iterate>
								</logic:notEmpty>
							</html:select><i class="red">*</i></li>
						<li>
						   <label for="time">補くじ時間：</label>
						   <html:text property="start_time_add" styleId="startDateTime" name="_JNTCIAttendance06Form" styleClass="inline laydate-icon"></html:text>
						    <small id="line" style="display: none;"> - </small>
						    <html:text property="end_time_add" styleId="endDateTime" name="_JNTCIAttendance06Form" styleClass="inline laydate-icon" style="display:none;"></html:text>
						<i class="red">*</i></li>
						<li class="reason">
						   <label for="reason">補くじ理由：</label>
							<html:textarea property="retroactive_reason" name="_JNTCIAttendance06Form" styleId="reason" cols="30" rows="6"></html:textarea>
							 <html:hidden styleId="userfilename" property="fileName" name="_JNTCIAttendance06Form"/>
						<i class="red">*</i></li>

     <li id="hid"  style="display:none">
     <label>添付ファイル:</label>
     <html:text property="fileName" styleId="fileName" name="_JNTCIAttendance06Form"></html:text>

                        <input type="file" name="uploadFile"
                        id="uploadFile" value="" style="display:none"
                        onchange="fileChange(this)" />
                        <input type="button" class="btn btn-blue"
                            style="width: 100px;height:26px;margin: 0 0 0 20px;" id="uploadFileBt" value="アップロード"/><i class="red">*</i>
                    </li>
						<li style="padding: 10px 0 0 170px">
						<html:hidden name="_JNTCIAttendance06Form" property="retroactive_id" styleId="retroactive_id" />
						  <ts:submit value="申請" styleClass="btn btn-blue" onclick="return checkDate();" style="margin-right:20px"></ts:submit>
						  <input type="button" class="btn btn-green" value="クリア" onclick="clearInput();" />
						</li>
					</ul>
				</ts:form>

				<ts:pageLinks id="JNTCIAttendancePageLinks"
					action="/Attendance05listBL?user_id=${_JNTCIAttendance06Form.user_id}&user_name=${_JNTCIAttendance06Form.user_name}
					&leader=${_JNTCIAttendance06Form.leader}&dept_id=${_JNTCIAttendance06Form.dept_id}"
					name="_JNTCIAttendance06Form" rowProperty="row"
					totalProperty="totalCount" indexProperty="startIndex"
					currentPageIndex="now" totalPageCount="total">
				</ts:pageLinks>
             <logic:notEmpty name="_JNTCIAttendance06Form" property="attendance06ListOutput">
				<hr />
				<table class="ctn" width="100%">
					<caption>社員補くじ調査</caption>
					<tr>
						<th style="width: 8%;">社員ID</th>
						<th style="width: 8%;">氏名</th>
						<th style="width: 8%;">補くじタイプ</th>
						<th>出勤時間</th>
						<th>退勤時間</th>
						<th>補くじ理由</th>
						<th>提出時間</th>
						<th style="width: 8%;">監査状態</th>
					<%-- 	<th>補くじ未通過理由</th> --%>
						<th style="width: 15%; align:center">操作</th>
					</tr>

						<logic:iterate id="attendance05Bean" name="_JNTCIAttendance06Form"
							property="attendance06ListOutput" indexId="index">
							<ts:form action="/delectionforAttendance05">
								<tr>
									<td align="center">
									   <bean:write name="attendance05Bean" property="user_id" />
									   <html:hidden name="attendance05Bean" property="user_id"/>
									</td>
									<td>
									   <bean:write name="attendance05Bean" property="name" />
									</td>
									<td align="center"><bean:write name="attendance05Bean" property="retroactive_type" />
									<c:if test="${attendance05Bean.retroactive_type == '午前修正'}">
											<html:hidden name="_JNTCIAttendance06Form" property="flagfortype" styleId="flagfortype" value="1"></html:hidden>
									</c:if>
									<c:if test="${attendance05Bean.retroactive_type == '午後修正'}">
											<html:hidden name="_JNTCIAttendance06Form" property="flagfortype" styleId="flagfortype" value="2"></html:hidden>
									</c:if>
									<c:if test="${attendance05Bean.retroactive_type == '終日修正'}">
											<html:hidden name="_JNTCIAttendance06Form" property="flagfortype" styleId="flagfortype" value="3"></html:hidden>
									</c:if>
									</td>
									<td align="right">
									  <bean:write name="attendance05Bean" property="start_time" />
									   <html:hidden name="attendance05Bean" property="start_time"/>
									</td>
									<td>
									  <bean:write name="attendance05Bean" property="end_time" />
									   <html:hidden name="attendance05Bean" property="end_time"/>
									</td>
									<td>
									  <bean:write name="attendance05Bean" property="retroactive_reason" />
									 </td>
									<td>
									  <bean:write name="attendance05Bean" property="sub_time" />
									  <html:hidden name="attendance05Bean" property="sub_time"/>
									 </td>
									<td>
									  <bean:write name="attendance05Bean" property="retroactive_status" />
									  <html:hidden name="attendance05Bean" property="status_value"/>
									 </td>
									<td>
									<c:if test="${attendance05Bean.status_value == 'A06'}">
											<input type="button" class="btn btn-red" disabled="disabled" value="削除" style="width: 50px; height: 25px; background: #CCCCCC" />
											<input type="button" class="btn btn-green" style="width: 50px; height: 25px; background: #CCCCCC" disabled="disabled" value="修正" />
									</c:if>
									<c:if test="${attendance05Bean.status_value == 'A01'}">
											<input type="button" class="btn btn-red" disabled="disabled" value="削除" style="width: 50px; height: 25px; background: #CCCCCC" />
											<input type="button" class="btn btn-green" style="width: 50px; height: 25px; background: #CCCCCC" disabled="disabled" value="修正" />
									</c:if>
									<c:if test="${attendance05Bean.status_value == 'A04'}">
									 <html:hidden property="startIndex" name="_JNTCIAttendance06Form"/>
									 <html:hidden name="_JNTCIAttendance06Form" property="updateQuFen" styleId="updateQuFen" />
									 <ts:submit value="削除" styleClass="btn btn-blue" style="width: 50px;height:25px" onclick="return delect()"></ts:submit>
									 <ts:submit value="修正" styleClass="btn btn-green" style="width: 50px;height:25px" onclick="update()" />
                                    </c:if>
                                    <c:if test="${attendance05Bean.status_value == 'A05'}">
									 <html:hidden property="startIndex" name="_JNTCIAttendance06Form"/>
									 <html:hidden name="_JNTCIAttendance06Form" property="updateQuFen" styleId="updateQuFen" />
									 <ts:submit value="削除" styleClass="btn btn-blue" style="width: 50px;height:25px" onclick="return delect()"></ts:submit>
									 <ts:submit value="修正" styleClass="btn btn-green" style="width: 50px;height:25px" onclick="update()" />
                                    </c:if>
                                    <c:if test="${attendance05Bean.status_value == 'A07'}">
									 <html:hidden property="startIndex" name="_JNTCIAttendance06Form"/>
									 <html:hidden name="_JNTCIAttendance06Form" property="updateQuFen" styleId="updateQuFen" />
									 <ts:submit value="削除" styleClass="btn btn-blue" style="width: 50px;height:25px" onclick="return delect()"></ts:submit>
									 <ts:submit value="修正" styleClass="btn btn-green" style="width: 50px;height:25px" onclick="update()" />
                                    </c:if>
									 </td>
								</tr>
							</ts:form>
						</logic:iterate>

				</table>
				<div class="pagination">
					<ul>
						<li>計<b><bean:write name="_JNTCIAttendance06Form"
									property="totalCount" /></b>レコード数
						</li>

						<li><bean:write name="now" />／<bean:write name="total" /> &nbsp;</li>

						<li><bean:write name="JNTCIAttendancePageLinks" filter="false" /></li>
					</ul>
				</div>
				</logic:notEmpty>
				<div class="footer">
					<p>
						連絡メール：<a href="mailto:jinan@trans-cosmos.com.cn" target="_blank">jinan@trans-cosmos.com.cn</a>
					</p>
				</div>
			</div>

			<!--/main-ctn-->

			<script type="text/javascript">
				!function() {
					laydate.skin('yahui');
					laydate({
						elem : '#demo'
					});//縫い付け元素
				}();

				//日期范?限制
				var start = {
					elem : '#startDateTime',
					format : 'YYYY-MM-DD hh:mm:ss',
					start: laydate.now(-1, "YYYY/MM/DD 08:30:00"),
					min : laydate.now(-45), //最小の日付を設定する
					max : laydate.now(-1), //最大日付
					istime : true,
					istoday : false,
					choose : function(datas) {
						//end.min = datas; //日に?好、リセット日の最小日付をリセットする
						/* end.start = datas //瞭日の初期値設定を開始日に設定 */
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
				     end.min = dt+hour+":"+min; //?始日?好后，重置?束日的最小日期 */
					}
				};


				var end = {
					elem : '#endDateTime',
					format : 'YYYY-MM-DD hh:mm:ss',
					start: laydate.now(-1, "YYYY/MM/DD 17:30:00"),
					min : laydate.now(-45),
					max : laydate.now(-1),
					istime : true,
					istoday : false,
					choose : function(datas) {
						start.max = datas; //日には、リチャージの開始日の最大の日には、リチャージ
					}
				};
				laydate(start);
				laydate(end);
			</script>
		</div>
	</div>
</body>
</html:html>