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
<title>設備返還状態修正</title>
<script type="text/javascript">
    function onSubimitfun(type) {
        if (type == "1") {
            $("#hidden_state").val("1");
            if (confirm('修理の失敗を確認するか？')) {
                $("#formid").submit();
            } else {
                return false;
            }
        } else if(type == "0") {
            $("#hidden_state").val("0");
            if (confirm('修理の完成を確認するか？')) {
                $("#formid").submit();
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
                    <li><a href="#">設備修理申請</a></li>
                </ul>
            </div>
            <div class="main-ctn equip-apply" style="padding: 20px 20px 0 20px;">
                <ts:form action="/JNTCIEquip0304BL" styleId="formid"
                    method="post">
                    <ul>
                        <li>
                            <ul style="display: inline-block;">
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
                                        name="apply_setsubi_no"
                                        value="<bean:write name="_JNTCIEquip03ListForm" property="apply_setsubi_no"/>" />
                                        <input type="hidden"
                                        id="hidden_state"
                                        name="hidden_state" /> <input
                                        type="hidden"
                                        name="apply_user_id"
                                        value="<bean:write name="_JNTCIEquip03ListForm" property="apply_user_id"/>" />
                                        <input type="hidden"
                                        name="apply_user_name"
                                        value="<bean:write name="_JNTCIEquip03ListForm" property="apply_user_name"/>" /></label>
                                    <span style="display: none"><bean:write
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

                                <li><label>設備番号：</label> <span><bean:write
                                            name="_JNTCIEquip03ListForm"
                                            property="apply_setsubi_no" /></span>
                                </li>
                                <li><label>申請理由：</label> <span><bean:write
                                            name="_JNTCIEquip03ListForm"
                                            property="apply_reason" /></span></li>
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
                                    <li><label>申請設備状態：</label> <span><bean:write
                                                name="_JNTCIEquip03ListForm"
                                                property="apply_state" /></span>
                                    </li>
                                </ul>

                            </div>
                        </li>
                        <li style="padding: 10px 0 0 12%;">
                            <input id="buttonShuRiChu1" name="修理失敗"
                            type="button"
                            style="min-width: 70px; margin-right: 20px"
                            class="btn btn-blue" value="修理失敗"
                            onclick="onSubimitfun(1)" /> <input
                            id="buttonShuRiChu2" name="修理完成"
                            type="button"
                            style="min-width: 70px; margin-right: 20px"
                            class="btn btn-red" value="修理完成"
                            onclick="onSubimitfun(0)" />
                            <input id="goback" name="戻る" type="button"
                             style="min-width: 70px; margin-right: 20px"
                             class="btn btn-blue" value="戻る" onclick="onSubimitfun(4)"  />
                        </li>
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