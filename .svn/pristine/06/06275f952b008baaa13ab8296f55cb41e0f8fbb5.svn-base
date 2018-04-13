<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="/struts-html" prefix="html"%>
<%@ taglib uri="/struts-bean" prefix="bean"%>
<%@ taglib uri="/struts-logic" prefix="logic"%>
<%@ taglib uri="/terasoluna-struts" prefix="ts"%>
<%@ taglib uri="/terasoluna" prefix="t"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
%>
<%
	response.setCharacterEncoding("utf-8");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0,maximum-scale=1.0,user-scalable=no">
<title>休暇審査</title>
<link rel="stylesheet" type="text/css" href="css/base.css" />
<link rel="stylesheet" type="text/css" href="css/main.css" />
<script type="text/javascript" src="js/laydate/laydate.js"></script>
<script type="text/javascript" src="js/jquery-1.11.3.min.js"></script>
<script src="../js/jquery-1.11.3.min.js" type="text/javascript"></script>
<script type="text/javascript">


    $(function() {
    	 $('#left-container .content').hide();
         $('#Attendance').show();
         $('h2.tit').click(function() {
             $(this).next('.content').stop().slideToggle();
         })
    	 $("#submitButId").click(function() {
             $("#cod").val("reset");
             $("#examine_person").val("goback");
             $("#formid").submit();
         });
        document.getElementById("delete").disabled = true;
        document.getElementById("admit").disabled = true;
        document.getElementById("unadmit").disabled = true;

        $("#selectAll").click(function() {
            if ($(this).prop("checked") == true) {
                $("[name='select']").prop("checked", true);
                document.getElementById("delete").disabled = false;
                document.getElementById("admit").disabled = false;
                document.getElementById("unadmit").disabled = false;
            } else {
                $("[name='select']").prop("checked", false);
                document.getElementById("delete").disabled = true;
                document.getElementById("admit").disabled = true;
                document.getElementById("unadmit").disabled = true;
            }
        });
        $("[name='select']").bind("click", function() {
            var bool = false;
            $("[name='select']").each(function() {
                if ($(this).prop("checked") == true) {
                    bool = false;
                    return false;
                } else {
                    bool = true;
                }
            });
            document.getElementById("delete").disabled = bool;
            document.getElementById("admit").disabled = bool;
            document.getElementById("unadmit").disabled = bool;
        });
        });
    $(function() {
        $("td a").on(
                "click",
                function() {
                    var record = "";
                    $("[name='select']").each(function() {
                        if ($(this).prop("checked") == true) {
                            var id_card = $(this).val();
                            var arraylist = $("#admitAllId").val().split(",");
                            var symb = 0;
                            for (var i = 0; i < arraylist.length-1; i++) {
                                if (id_card == arraylist[i]) {
                                    symb = symb + 1;
                                }
                            }
                            if (symb == 0) {
                                record = id_card + "," + record;
                            }
                        }
                    })
                    var selectlist = "";
                    var arraylist = $("#admitAllId").val().split(",");
                    if (arraylist.length > 1) {
                        for (var i = 0; i < arraylist.length-1; i++) {
                            var quality = "[name='select']" + "[value='"
                                    + arraylist[i] + "']";
                            if ($(quality).prop("checked") != false) {
                                selectlist = arraylist[i] + "," + selectlist;
                            }
                        }
                    }
                    $("#admitAllId").val(selectlist);
                    if (selectlist == "" || selectlist == " ") {
                    } else {
                        record = selectlist + record;
                    }
                    var address = $(this).attr("href") + "&admitAllId=" + record+"&mark=6";
                    $("#admitAllId").val(record);
                    $(this).attr("href", address);
                })
                var array = $("#admitAllId").val().split(",");
        for (var i = 0; i < array.length; i++) {
            var quality = "[name='select']" + "[value='" + array[i] + "']";
            $(quality).prop("checked", true);
        }
        var bool = false;
        $("[name='select']").each(function() {
            if ($(this).prop("checked") == true) {
                bool = false;
                return false;
            } else {
                bool = true;
            }
        });
        document.getElementById("delete").disabled = bool;
        document.getElementById("admit").disabled = bool;
        document.getElementById("unadmit").disabled = bool;
        var count = 0;
        $("[name='select']").each(function() {
            if ($(this).prop("checked") == true) {
                count++;
            }
        })
        if($("[name='select']").length==count){
            $("#selectAll").prop("checked",true);
        }
    })


    function submitClick(type) {
    	if(type==0){
        //是否确认删除
        if (confirm("注意：\r　　削除したら、復元することができません。本当に削除しますか。")) {
        	var cards = "";
            $("[name='select']").each(function() {
                if ($(this).prop("checked") == true) {
                	 var leave_id = $(this).val();
                     cards = cards + leave_id + ",";
                }
            })
          var record=  $("#admitAllId").val();
            cards=cards+record;
            $("#deleteAllId").val(cards);
            $('#formitDelete').submit();
        }

    	}else if(type==1){
        if (confirm("注意：\r　　「OK」をクリックする前に、紙の資料を確認してください。\r\r　　承認したら、復元することができません。本当に承認しますか。")) {
        	var cards = "";
            $("[name='select']").each(function() {
                if ($(this).prop("checked") == true) {
                    var leave_id = $(this).val();
                    cards = cards + leave_id + ",";
                }
            })
          var record=  $("#admitAllId").val();
            cards=cards+record;
            $("#admitAllId").val(cards);
            $('#formitOk').submit();
          //当type为2是，是一括不承认
        }
        }else if(type==2){
        if (confirm("注意：\r　　承認しないなら、復元することができません。本当に承認しませんか")) {
        	var cards = "";
            $("[name='select']").each(function() {
                if ($(this).prop("checked") == true) {
                	var leave_id = $(this).val();
                    cards = cards + leave_id + ",";
                }
            })
         var record=  $("#admitAllId").val();
            cards=cards+record;
            $("#admitAllId1").val(cards);
            $('#formitNO').submit();
        }
    }
    }
    $(function() {
        $("#submitButId").click(function() {
            $("#cod").val("reset");
            $("#formid").submit();
        });
        var dpt = $("#dept_idBC").val();
        if (dpt != null) {
            $("#dept_id").find("option").eq(dpt).attr("selected", "selected");
        }
        var ltp = $("#leave_typeBC").val();
        if (ltp != null) {
            $("#leave_type option[value='" + ltp + "']").attr("selected", true);
        }
        var app = $("#application_typeBC").val();
        if (app != null) {
            $("#application_type option[value='" + app + "']").attr("selected",
                    true);
        }
        var est = $("#examine_statusBC").val();
        if (est != null) {
            $("#examine_status option[value='" + est + "']").attr("selected",
                    true);
        }
        var lst = $("#leave_startBC").val();
        if (lst != null) {
            $("#startDateTime").val(lst);
        }
        var led = $("#leave_endBC").val();
        if (led != null) {
            $("#endDateTime").val(led);
        }
        var card = $("#jn_cardBC").val();
        if (card != null) {
            $("#jn_card").val(card);
        }
        var name = $("#nameBC").val();
        if (name != null) {
            $("#name").val(name);
        }
    })
    function onSubimitfun() {
        this.form.submit();
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

			<div class="header" style="width: 1663px;">
				<ul class="breadcrumbs clearfix">
					<li>ステップチャート：</li>
					<li><a href="#">勤務管理</a></li>
					<li class="ico">&gt;</li>
					<li><a href="#">休暇審査</a></li>
				</ul>
			</div>

			<div class="main-ctn attendance" style="width: 1637px">
				<p>
					<html:errors />
					<html:messages id="message" message="true">
						<bean:write name="message" />
					</html:messages>
				</p>

				<ts:form styleId="formid" action="/JNTCIAttendance04selectDSP"
					method="post">
					<div class="clearfix">
						<table class="tb-align table-bar fl">
							<colgroup>
								<col width="120px">
								<col width="150px">
								<col width="100px">
								<col width="150px">
								<col width="110px">
								<col width="150px">
								<col width="120px">
								<col width="120px">
								<col width="120px">
								<col width="98px">
							</colgroup>
							<tr>
								<th>社員カード：</th>
								<td><html:text property="jn_card_serch" styleId="jn_card"
										maxlength="4" style="width:150px; " /><input type="hidden" id="jn_cardBC"
									name="jn_cardBC"
									value="<bean:write name="_JNTCIAttendance04selectForm" property="jn_card_serch"/>" />
								</td>
								<th>社員名前： <input type="hidden" id="cod" name="cod" value="" />
								</th>
								<td><html:text property="name_serch" styleId="name" style="width:150px; "/><input
									type="hidden" id="nameBC" name="nameBC"
									value="<bean:write name="_JNTCIAttendance04selectForm" property="name_serch"/>" /></td>
								<th>部門ID：</th>
								<td><input type="hidden" id="dept_idBC" name="dept_idBC"
									value="<bean:write name="_JNTCIAttendance04selectForm" property="dept_id_serch"/>" />
							 <html:select name="_JNTCIAttendance04selectForm"
										property="dept_id_serch" style="width:156px; ">
										<option value=""></option>
										<t:defineCodeList id="overTimeVerify" />
										<html:options collection="overTimeVerify" property="id"
											labelProperty="name" />
									</html:select></td>
								<th>休暇時間：</th>
								<td class="input-time" colspan="4"><input type="hidden"
									id="leave_endBC" name="leave_endBC"
									value="<bean:write name="_JNTCIAttendance04selectForm" property="leave_endtime_serch"/>" />
									<input type="hidden" id="leave_startBC" name="leave_startBC"
									value="<bean:write name="_JNTCIAttendance04selectForm" property="leave_starttime_serch"/>" />
									<html:text property="leave_starttime_serch"
										styleId="startDateTime" styleClass="inline laydate-icon"
										readonly="false"/> - <html:text
										property="leave_endtime_serch" styleId="endDateTime"
										styleClass="inline laydate-icon" readonly="false" /></td>
							</tr>
							<tr>
								<th>休暇種類：</th>
								<td><input type="hidden" id="leave_typeBC"
									name="leave_typeBC"
									value="<bean:write name="_JNTCIAttendance04selectForm" property="leave_type_serch"/>" />
									<html:select name="_JNTCIAttendance04selectForm"
                                        property="leave_type_serch" style="width:156px; ">
                                        <option value=""></option>
                                        <t:defineCodeList id="leave_type" />
                                        <html:options collection="leave_type" property="id"
                                            labelProperty="name" />
                                    </html:select>
									</td>
								<th>申請方式：</th>
								<td><input type="hidden" id="application_typeBC"
									name="application_typeBC"
									value="<bean:write name="_JNTCIAttendance04selectForm" property="application_type_serch"/>" />
									<html:select name="_JNTCIAttendance04selectForm"
                                        property="application_type_serch" style="width:156px; ">
                                        <option value=""></option>
                                        <t:defineCodeList id="application_type" />
                                        <html:options collection="application_type" property="id"
                                            labelProperty="name" />
                                    </html:select>
									</td>
								<th>審査状態：</th>
								<td><input type="hidden" id="examine_statusBC"
									name="examine_statusBC"
									value="<bean:write name="_JNTCIAttendance04selectForm" property="examine_status_serch"/>" />
									<select id="examine_status" name="examine_status_serch">
										<option value=""></option>
										<option value="許可">許可</option>
										<option value="未許可">未許可</option>
										<option value="承認中">承認中</option>
										<option value="未審査">未審査</option>
										<option value="承認済">承認済</option>
								</select> </td>

							</tr>
						</table>
						<ts:submit property="forward_search"   styleClass="btn btn-blue fl" value="検索"  style="margin: 18px 10px 0px 30px;width:86px;height:28px"/>
				 	<ts:submit property="forward_download"  styleClass="btn btn-blue fl" value="ダウンロード"   style="margin: 18px 10px 0px 5px;width:86px;height:28px"/>
					</div>

				</ts:form>
				<ts:pageLinks id="Attendance04ListPageLinks"
					action="/JNTCIAttendance04selectBL?jn_card_serch=${_JNTCIAttendance04selectForm.jn_card_serch}&name_serch=${_JNTCIAttendance04selectForm.name_serch}&dept_id_serch=${_JNTCIAttendance04selectForm.dept_id_serch}&leave_type_serch=${_JNTCIAttendance04selectForm.leave_type_serch}&application_type_serch=${_JNTCIAttendance04selectForm.application_type_serch}&leave_starttime_serch=${_JNTCIAttendance04selectForm.leave_starttime_serch}&leave_endtime_serch=${_JNTCIAttendance04selectForm.leave_endtime_serch}&examine_status_serch=${_JNTCIAttendance04selectForm.examine_status_serch}"
					name="_JNTCIAttendance04selectForm" rowProperty="row"
					totalProperty="totalCount" indexProperty="startIndex"
					currentPageIndex="now" totalPageCount="total" />
				<logic:notEmpty name="_JNTCIAttendance04selectForm"
					property="JNTCIAttendance04selectInfo">
					<hr />
					<table class="adl ctn" width="96%">
						<caption>休暇審査一覧</caption>
						<tr>
							<th style="width: 60px;"><span>全选</span></th>
							<th style="width: 80px;">休暇ID</th>
							<th style="width: 80px;">社員カード</th>
							<th style="width: 80px;">社員名前</th>
							<th style="width: 80px;">部門所属</th>
							<th style="width: 80px;">所属上司</th>
							<th style="width: 150px;">提出時間</th>
							<th style="width: 150px;">審査時間</th>
							<th style="width: 80px;">審査人</th>
							<th style="width: 300px;">休暇始止時間</th>
							<th style="width: 85px;">合計時長</th>
							<th style="width: 85px;">休暇種類</th>
							<th style="width: 85px;">申請方式</th>
							<th style="width: 85px;">審査結果</th>
							<th style="width: 85px;">操作</th>
						</tr>
						<logic:iterate id="JNTCIAttendance04selectFormBean"
							name="_JNTCIAttendance04selectForm"
							property="JNTCIAttendance04selectInfo" indexId="index">
							<ts:form action="/JNTCIAttendance04forwardBL.do" method="post">
								<input type="hidden" name="leave_id"
									value="<bean:write name="JNTCIAttendance04selectFormBean" property="leave_id" />" />
								<tr align="center" class="d">

									<logic:equal name="flag" scope="session" value="4">
									<logic:equal value="許可"
                                        name="JNTCIAttendance04selectFormBean"
                                        property="examine_status">

                                    <td align="center">
                                    <input type="checkbox" name="select" id="select"  disabled="disabled"
										value="<bean:write name="JNTCIAttendance04selectFormBean" property="leave_id" />"
										onclick="selectRecord(this); "
									/></td>
                                        </logic:equal>
                                        <logic:equal value="承認済"
                                        name="JNTCIAttendance04selectFormBean"
                                        property="examine_status"> <td align="center">
                                    <input type="checkbox" name="select" id="select"  disabled="disabled"
										value="<bean:write name="JNTCIAttendance04selectFormBean" property="leave_id" />"
										onclick="selectRecord(this); "
									/></td>
                                        </logic:equal>


                                        <logic:equal  value="未許可"
                                        name="JNTCIAttendance04selectFormBean"
                                        property="examine_status">
                                       <logic:equal value="田東啓"
                                        name="JNTCIAttendance04selectFormBean"
                                        property="examine_person">
                                         <td align="center">
                                    <input type="checkbox" name="select" id="select"  disabled="disabled"
										value="<bean:write name="JNTCIAttendance04selectFormBean" property="leave_id" />"
										onclick="selectRecord(this); "
									/></td>
                                        </logic:equal>

                                        <logic:equal value="張棟"
                                        name="JNTCIAttendance04selectFormBean"
                                        property="examine_person">
                                         <td align="center">
                                    <input type="checkbox" name="select" id="select"  disabled="disabled"
										value="<bean:write name="JNTCIAttendance04selectFormBean" property="leave_id" />"
										onclick="selectRecord(this); "
									/></td>
                                        </logic:equal>

                                        <logic:notEqual value="田東啓"
                                        name="JNTCIAttendance04selectFormBean"
                                        property="examine_person">
                                    <logic:notEqual value="張棟"
                                        name="JNTCIAttendance04selectFormBean"
                                        property="examine_person">
                                         <td align="center">
                                    <input type="checkbox" name="select" id="select"
										value="<bean:write name="JNTCIAttendance04selectFormBean" property="leave_id" />"
										onclick="selectRecord(this); "
									/></td>
                                  </logic:notEqual>
                                        </logic:notEqual>
                                        </logic:equal>

                                      <logic:notEqual  value="未許可"
                                        name="JNTCIAttendance04selectFormBean"
                                        property="examine_status">
                                         <logic:notEqual  value="許可"
                                        name="JNTCIAttendance04selectFormBean"
                                        property="examine_status">
                                         <logic:notEqual  value="承認済"
                                        name="JNTCIAttendance04selectFormBean"
                                        property="examine_status">
                                        <td align="center">
                                    <input type="checkbox" name="select" id="select"
										value="<bean:write name="JNTCIAttendance04selectFormBean" property="leave_id" />"
										onclick="selectRecord(this); "
									/></td>
                                        </logic:notEqual>
                                        </logic:notEqual>
                                       </logic:notEqual>
									</logic:equal>
									<logic:equal name="userId" scope="session" value="1070">
                                        <td align="center">
                                    <input type="checkbox" name="select" id="select" disabled="disabled"
										value="<bean:write name="JNTCIAttendance04selectFormBean" property="leave_id" />"
										onclick="selectRecord(this); "
									/></td>
									</logic:equal>
									<logic:equal name="userId" scope="session" value="1002">
										<logic:equal value="許可"
                                        name="JNTCIAttendance04selectFormBean"
                                        property="examine_status">

                                    <td align="center">
                                    <input type="checkbox" name="select" id="select"  disabled="disabled"
										value="<bean:write name="JNTCIAttendance04selectFormBean" property="leave_id" />"
										onclick="selectRecord(this); "
									/></td>
                                        </logic:equal>
                                        <logic:notEqual  value="許可"
                                        name="JNTCIAttendance04selectFormBean"
                                        property="examine_status">
                                        <td align="center">
                                    <input type="checkbox" name="select" id="select"
										value="<bean:write name="JNTCIAttendance04selectFormBean" property="leave_id" />"
										onclick="selectRecord(this); "
									/></td>
									</logic:notEqual>
									</logic:equal>
									<logic:equal name="userId" scope="session" value="1001">
                                        <td align="center">
                                    <input type="checkbox" name="select" id="select"
										value="<bean:write name="JNTCIAttendance04selectFormBean" property="leave_id" />"
										onclick="selectRecord(this); "
									/></td>
									</logic:equal>

                           <logic:equal name="userId" scope="session" value="1004">



                                        <logic:equal value="許可"
                                        name="JNTCIAttendance04selectFormBean"
                                        property="examine_status">
                                        <td align="center">
                                    <input type="checkbox" name="select" id="select" disabled="disabled"
										value="<bean:write name="JNTCIAttendance04selectFormBean" property="leave_id" />"
										onclick="selectRecord(this); "
									/></td>
                                        </logic:equal>
                                       <logic:notEqual value="許可"
                                        name="JNTCIAttendance04selectFormBean"
                                        property="examine_status">
                                        <td align="center">
                                    <input type="checkbox" name="select" id="select"
										value="<bean:write name="JNTCIAttendance04selectFormBean" property="leave_id" />"
										onclick="selectRecord(this); "
									/></td>
                                       </logic:notEqual>

                                  </logic:equal>

									<logic:equal name="userId" scope="session" value="1003">


                                        <logic:equal value="許可"
                                        name="JNTCIAttendance04selectFormBean"
                                        property="examine_status">
                                        <td align="center">
                                    <input type="checkbox" name="select" id="select" disabled="disabled"
										value="<bean:write name="JNTCIAttendance04selectFormBean" property="leave_id" />"
										onclick="selectRecord(this); "
									/></td>
                                        </logic:equal>
                                       <logic:notEqual value="許可"
                                        name="JNTCIAttendance04selectFormBean"
                                        property="examine_status">
                                        <td align="center">
                                    <input type="checkbox" name="select" id="select"
										value="<bean:write name="JNTCIAttendance04selectFormBean" property="leave_id" />"
										onclick="selectRecord(this); "
									/></td>
                                       </logic:notEqual>

									</logic:equal>
									<td align="center"><bean:write
											name="JNTCIAttendance04selectFormBean" property="leave_id" /></td>
									<td align="center">
										<bean:write name="JNTCIAttendance04selectFormBean" property="jn_card" />
										<html:hidden property="jn_card_serch"	name="_JNTCIAttendance04selectForm" />
										<html:hidden property="name_serch" name="_JNTCIAttendance04selectForm" />
										<html:hidden property="dept_id_serch" name="_JNTCIAttendance04selectForm" />
										<html:hidden property="leave_starttime_serch" name="_JNTCIAttendance04selectForm" />
									    <html:hidden property="leave_endtime_serch" name="_JNTCIAttendance04selectForm" />
									    <html:hidden property="leave_type_serch" name="_JNTCIAttendance04selectForm" />
									    <html:hidden property="application_type_serch" name="_JNTCIAttendance04selectForm" />
									    <html:hidden property="examine_status_serch" name="_JNTCIAttendance04selectForm" />
									    <html:hidden property="startIndex" name="_JNTCIAttendance04selectForm" />
										<html:hidden property="startIndex" name="_JNTCIAttendance04selectForm"/></td>
									<td align="center"><bean:write
											name="JNTCIAttendance04selectFormBean" property="name" /></td>
									<td align="center"><bean:write
											name="JNTCIAttendance04selectFormBean" property="dept_id" /></td>
									<td align="center"><bean:write
											name="JNTCIAttendance04selectFormBean" property="project_pm" /></td>
									<td align="center"><bean:write
											name="JNTCIAttendance04selectFormBean"
											property="leave_subtime" /></td>
									<td align="center"><bean:write
											name="JNTCIAttendance04selectFormBean"
											property="examine_time" /></td>
									<td align="center"><bean:write
											name="JNTCIAttendance04selectFormBean"
											property="examine_person" /></td>
									<td align="center"><bean:write
											name="JNTCIAttendance04selectFormBean"
											property="leave_starttime" />~<bean:write
											name="JNTCIAttendance04selectFormBean"
											property="leave_endtime" /></td>
									<td align="center"><bean:write
											name="JNTCIAttendance04selectFormBean"
											property="leave_totaltime" /></td>
									<td align="center"><bean:write
											name="JNTCIAttendance04selectFormBean" property="leave_type" /></td>
									<td align="center"><bean:write
											name="JNTCIAttendance04selectFormBean"
											property="application_type" /></td>
									<td align="center"><bean:write
											name="JNTCIAttendance04selectFormBean"
											property="examine_status"  /></td>
									<td><input type="submit" class="btn btn-green" value="詳細" /></td>
								</tr>
							</ts:form>
						</logic:iterate>
						<tfoot>
							<tr>
							<logic:equal name="userId" scope="session" value="1070">
                        <td><label style="width: auto">全て選択</label>
                                <input type="checkbox" name="selectAll" disabled="disabled"
                                id="selectAll" title="全て選択" /></td>
                        </logic:equal>
                           <logic:notEqual name="userId" scope="session" value="1070">
                          <td><label style="width: auto">全て選択</label>
                                <input type="checkbox" name="selectAll"
                                id="selectAll" title="全て選択" /></td>
                           </logic:notEqual>

								<td><input type="button" value="複数削除" id="delete"
									class="btn btn-red" onclick="submitClick(0); "
									disabled="disabled" /></td>

								<html:form action="/deleteAll"  styleId="formitDelete" >
								<html:hidden property="deleteAllId" name="_JNTCIAttendance04selectForm" styleId="deleteAllId"/>
								        <html:hidden property="jn_card_serch"	name="_JNTCIAttendance04selectForm" />
										<html:hidden property="name_serch" name="_JNTCIAttendance04selectForm" />
										<html:hidden property="dept_id_serch" name="_JNTCIAttendance04selectForm" />
										<html:hidden property="leave_starttime_serch" name="_JNTCIAttendance04selectForm" />
									    <html:hidden property="leave_endtime_serch" name="_JNTCIAttendance04selectForm" />
									    <html:hidden property="leave_type_serch" name="_JNTCIAttendance04selectForm" />
									    <html:hidden property="application_type_serch" name="_JNTCIAttendance04selectForm" />
									    <html:hidden property="examine_status_serch" name="_JNTCIAttendance04selectForm" />
									    <html:hidden property="startIndex" name="_JNTCIAttendance04selectForm" />
                                </html:form>
                                <html:form action="/admit"  styleId="formitOk" >
                                <html:hidden property="admitAllId" name="_JNTCIAttendance04selectForm" styleId="admitAllId"/>

								        <html:hidden property="jn_card_serch"	name="_JNTCIAttendance04selectForm" />
										<html:hidden property="name_serch" name="_JNTCIAttendance04selectForm" />
										<html:hidden property="dept_id_serch" name="_JNTCIAttendance04selectForm" />
										<html:hidden property="leave_starttime_serch" name="_JNTCIAttendance04selectForm" />
									    <html:hidden property="leave_endtime_serch" name="_JNTCIAttendance04selectForm" />
									    <html:hidden property="leave_type_serch" name="_JNTCIAttendance04selectForm" />
									    <html:hidden property="application_type_serch" name="_JNTCIAttendance04selectForm" />
									    <html:hidden property="examine_status_serch" name="_JNTCIAttendance04selectForm" />
									    <html:hidden property="startIndex" name="_JNTCIAttendance04selectForm" />
                                </html:form>
                                <html:form action="/unadmit"  styleId="formitNO" >
                                <html:hidden property="unadmitAllId" name="_JNTCIAttendance04selectForm" styleId="admitAllId1"/>
                                        <html:hidden property="jn_card_serch"	name="_JNTCIAttendance04selectForm" />
										<html:hidden property="name_serch" name="_JNTCIAttendance04selectForm" />
										<html:hidden property="dept_id_serch" name="_JNTCIAttendance04selectForm" />
										<html:hidden property="leave_starttime_serch" name="_JNTCIAttendance04selectForm" />
									    <html:hidden property="leave_endtime_serch" name="_JNTCIAttendance04selectForm" />
									    <html:hidden property="leave_type_serch" name="_JNTCIAttendance04selectForm" />
									    <html:hidden property="application_type_serch" name="_JNTCIAttendance04selectForm" />
									    <html:hidden property="examine_status_serch" name="_JNTCIAttendance04selectForm" />
									    <html:hidden property="startIndex" name="_JNTCIAttendance04selectForm" />
                                </html:form>
                                <td><input type="button" value="一括承認" class="btn btn-red" id="admit"  onclick="submitClick(1);" style="margin-left:15px"/></td>
                                <td><input type="button" value="一括承認しない" class="btn btn-red" id="unadmit" onclick="submitClick(2);" style="margin-left:30px"/></td>
								<td colspan="12">

									<div class="pagination clearfix" style="width: 100%">

										<ul style="float: right;">
											<li>計<b><bean:write
														name="_JNTCIAttendance04selectForm" property="totalCount" /></b>レコード数
											</li>
											<li><bean:write name="now" />／<bean:write name="total" /></li>
											<li><bean:write name="Attendance04ListPageLinks"
													filter="false" /></li>
										</ul>

									</div>
								</td>
							</tr>
						</tfoot>
					</table>

				</logic:notEmpty>
				 <div class="footer">
                    <p>
                        意見反馈メール：<a
                            href="mailto:jinan@trans-cosmos.com.cn"
                            target="_blank">jinan@trans-cosmos.com.cn</a>
                    </p>
                </div>
			</div>
		</div>
	</div>
	<script>
                    !function() {
                        laydate.skin('yahui');
                        laydate({
                            elem : '#demo'
                        });
                    }();
                    //日期范围限制
                    var start = {
                        elem : '#startDateTime',
                        format : 'YYYY-MM-DD hh:mm',
                        istime : true,
                        istoday : false,
                        choose : function(datas) {
                            end.min = datas; //開始日を選択した後、終了日が再設定する。
                            end.start = datas //終了日が開始日を設定する。
                        }
                    };
                    var end = {
                        elem : '#endDateTime',
                        format : 'YYYY-MM-DD hh:mm',
                        istime : true,
                        istoday : false,
                        choose : function(datas) {
                            start.max = datas;
                        }
                    };
                    laydate(start);
                    laydate(end);
                </script>
</body>
</html>