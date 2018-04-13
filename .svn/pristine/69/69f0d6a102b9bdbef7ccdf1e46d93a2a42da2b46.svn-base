<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-html" prefix="html"%>
<%@ taglib uri="/struts-bean" prefix="bean"%>
<%@ taglib uri="/struts-logic" prefix="logic"%>
<%@ taglib uri="/terasoluna-struts" prefix="ts"%>
<%@ taglib uri="/terasoluna" prefix="t"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html:html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" type="text/css" href="css/base.css" />
<link rel="stylesheet" type="text/css" href="css/main.css" />
<script type="text/javascript" src="js/jquery-1.11.3.min.js"></script>
<script type="text/javascript" src="js/jquery.validate.js"></script>
<title>設備申請状態修正</title>
<script type="text/javascript">
    function onSubimitfun(type) {
        if (type == "1") {
            $("#hidden_state").val("1");
            if (confirm('拒否を確認しますか？')) {
                $("#formid").submit();
            } else {
                return false;
            }
        } else if(type == "2"){
            $("#hidden_state").val("2");
            if (confirm('承認を確認しますか？')) {
                if ((!($(".firstul li:last-child textarea").val() == ""))) {
                    $(".Err").hide();
                    $(".Error2").show();
                    $("#formid").submit();
                } else {
                    $(".Err").show();
                    $(".Error2").show();

                }
            } else {
                return false;
            }
        }else if(type == "4"){
        	$("#buttonKubun").val("back");
       	    $("#formid").submit();
      }
    }
    $(document).ready(function() {
        var m = '<bean:write name="_JNTCIEquip03ListForm" property="CF"/>';
        if ((!(m == "0")) && (!(m == "3"))) {
            $("#buttonShuRiChu1").attr('disabled', true);
            $("#buttonShuRiChu2").attr('disabled', true);
        } else {
        }
    });
    $(function() {
        $('#left-container .content').hide();
        $('#Equip').show();
        $('h2.tit').click(function() {
            $(this).next('.content').stop().slideToggle();
        })
    })
</script>
</head>
<body>
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
                    <li><a href="#">設備管理</a></li>
                    <li class="ico">&gt;</li>
                    <li><a href="#">設備申請</a></li>
                </ul>
            </div>
            <div class="main-ctn equip-apply">
                <ts:form action="/JNTCIEquip0308BL" styleId="formid"
                    method="post">
                    <div
                        style="max-height: 100px; overflow: auto; width: 500px; margin-left: 40px;">
                        <div style="color: red; display: none"
                            class="Err">
                            <h3>以下のエラーが発生しました。</h3>

                            <div style="color: red; display: none"
                                class="Error2">●審査理由は入力必須項目です.</div>
                        </div>
                    </div>
                    <br>
                    <ul>
                        <li>
                            <ul style="display: inline-block;"
                                class="firstul">
                                <li><label>申請者： <input
                                        type="hidden"
                                        name="apply_user_name"
                                        value="<bean:write name="_JNTCIEquip03ListForm" property="apply_user_name"/>" />
                                </label> <span><bean:write
                                            name="_JNTCIEquip03ListForm"
                                            property="apply_user_name" />-<bean:write
                                            name="_JNTCIEquip03ListForm"
                                            property="apply_user_id" /></span>
                                    <label><input type="hidden"
                                        name="apply_no"
                                        value="<bean:write name="_JNTCIEquip03ListForm" property="apply_no"/>" />
                                        <input type="hidden"
                                        name="apply_user_id"
                                        value="<bean:write name="_JNTCIEquip03ListForm" property="apply_user_id"/>" />
                                        <input type="hidden"
                                        id="hidden_state"
                                        name="hidden_state" /></label> <span
                                    style="display: none"><bean:write
                                            name="_JNTCIEquip03ListForm"
                                            property="apply_no" /></span></li>
                                <li><label>申請日付：</label> <span>
                                <html:hidden property="userId1" name="_JNTCIEquip03ListForm"/>
                                           <html:hidden property="deptName" name="_JNTCIEquip03ListForm"/>
                                           <html:hidden property="shinsaJyoutai" name="_JNTCIEquip03ListForm"/>
                                           <html:hidden property="shinseiStartDate" name="_JNTCIEquip03ListForm"/>
                                           <html:hidden property="shinseiEndDate" name="_JNTCIEquip03ListForm"/>
                                           <html:hidden property="startIndex" name="_JNTCIEquip03ListForm"/>
                                           <html:hidden  styleId="buttonKubun"  property="buttonKubun" name="_JNTCIEquip03ListForm"/>
                                        <bean:write
                                            name="_JNTCIEquip03ListForm"
                                            property="apply_date" />
                                </span></li>
                                <li><label>申請区分：</label> <span><bean:write
                                            name="_JNTCIEquip03ListForm"
                                            property="shinseiKubun" /></span></li>
                                <li><label>申請理由：</label> <span><html:textarea
                                            rows="1" cols="20"
                                            name="_JNTCIEquip03ListForm"
                                            property="apply_reason"
                                            readonly="true" /></span></li>
                                <li><label>審査理由：</label> <html:textarea
                                        rows="2" cols="20"
                                        name="_JNTCIEquip03ListForm"
                                        property="investigate_reason" />
                                    <i class="red">*</i></li>

                            </ul>
                            <div class="yu"
                                style="display: inline-block;">
                                <ul>
                                    <li><label>申請部門名称：</label> <span><bean:write
                                                name="_JNTCIEquip03ListForm"
                                                property="apply_dept_name" /></span></li>
                                    <li><label>申請設備区分：</label> <span>
                                            <bean:write
                                                name="_JNTCIEquip03ListForm"
                                                property="apply_setsubi_kuben" />
                                    </span></li>
                                    <li>
                                    <li><label>申請設備数量：</label> <span>
                                            <bean:write
                                                name="_JNTCIEquip03ListForm"
                                                property="apply_setsubi_number" />
                                    </span></li>
                                    <li><label>申請設備状態：</label> <span><bean:write
                                                name="_JNTCIEquip03ListForm"
                                                property="apply_state" /></span>
                                    </li>
                                </ul>
                            </div>
                        </li>
                        <li style="padding: 10px 0 0 12%;"><input
                            id="buttonShuRiChu1" name="承認" type="button"
                            style="min-width: 70px; margin-right: 20px"
                            class="btn btn-blue" value="拒否"
                            onclick="onSubimitfun(1)" /> <input
                            id="buttonShuRiChu2" name="拒否" type="button"
                            style="min-width: 70px; margin-right: 20px"
                            class="btn btn-red" value="承認"
                            onclick="onSubimitfun(2)" />
                            <input id="goback" name="戻る" type="button"
                             style="min-width: 70px; margin-right: 20px"
                             class="btn btn-blue" value="戻る" onclick="onSubimitfun(4)"  /></li>
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
</html:html>