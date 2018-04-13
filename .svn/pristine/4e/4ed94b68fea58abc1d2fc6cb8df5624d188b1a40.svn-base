<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="/struts-html" prefix="html"%>
<%@ taglib uri="/struts-bean" prefix="bean"%>
<%@ taglib uri="/struts-logic" prefix="logic"%>
<%@ taglib uri="/terasoluna-struts" prefix="ts"%>
<%@ taglib uri="/terasoluna" prefix="t"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html:html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>設備追加</title>
<link rel="stylesheet" type="text/css" href="css/base.css" />
<link rel="stylesheet" type="text/css" href="css/main.css" />
<link rel="stylesheet" type="text/css"
    href="${pageContext.request.contextPath}/css/scroll.css" />
<script type="text/javascript" src="js/laydate/laydate.js"></script>
<script type="text/javascript" src="js/jquery-1.11.3.min.js"></script>
<script type="text/javascript" src="js/jquery.validate.js"></script>
<script type="text/javascript">
    $(function() {
        $('#left-container .content').hide();
        $('#Equip').show();
        $('h2.tit').click(function() {
            $(this).next('.content').stop().slideToggle();

        })
        var kubun = $("#setsubikubenList").val();
        if (kubun == "PJN" || kubun == "") {
            $('.host').show();
            $("#setsubi_su").val("1");
            $("#setsubi_su").attr('disabled', true);
        } else {
            $('.host').hide();
        }
    })
    function onSubimitfun() {
        var kubun = $("#setsubikubenList").val();
        if (kubun == "PJN" || kubun == "") {
            $("#formId").validate({
                rules : {
                    mac_address : {
                        required : true,
                    },
                }

            })
        } else {
            $("#formId").validate({
                rules : {
                    setsubi_su : {
                        min : 1,
                    },
                }
            })
        }
        $("#formId").submit();
    }
    //設備型番によって購入日付を取得
    function getKonyuhi() {
        var kataban = $("#setsubiKatabanList").val();
        var kubun = $("#setsubikubenList").val();
        if (kataban != null && kubun != null) {
            if (kataban.length != 0 && kubun.length != 0) {
                $("#dousa").val("1");
                $("#formId").attr('action',
                        '/tutorial-thin/JNTCIEquipInsert02BL.do');
                $("#formId").submit();
            } else {
                return false;
            }
        }
    }
    //設備種類によって設備番号と設備型番を取得
    function getKubun() {
        var kubun = $("#setsubikubenList").val();
        if (kubun == "") {
            $("#setsubi_no").val("");
        } else {
            $("#formId").attr('action',
                    '/tutorial-thin/JNTCIEquipInsertBL01.do');
            $("#formId").submit();
        }
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
        <div id="insertMg" class="rightWidht">
            <div class="header">
                <ul class="breadcrumbs clearfix">
                    <li>ステップチャート：</li>
                    <li><a href="#">設備管理</a></li>
                    <li class="ico">&gt;</li>
                    <li><a href="#">設備追加</a></li>
                </ul>
            </div>
            <div id="tab-top" style="margin-top: 10px;">
                <ul>
                    <li><ts:link action="/JNTCIEquipKatabanSCR.do">設備型番追加</ts:link></li>
                    <li class="on"><a href="#">設備番号追加</a></li>
                </ul>
            </div>
            <div class="main-ctn ul-li equip-apply">
                <!-- 設備番号を追加する -->
                <ts:form action="/JNTCIEquipInsertBL" styleId="formId"
                    method="post">
                    <div class="clearfix">
                        <div
                            style="max-height: 100px; overflow: auto; width: 500px; margin-left: 70px;">
                            <html:errors />
                            <html:messages id="message" message="true">
                                <bean:write name="message" />
                            </html:messages>
                        </div>
                        <html:hidden styleId="dousa" property="dousa"
                            name="_JNTCIEquipInsertForm" />
                        <ul>
                            <li><label>設備種類：</label> <t:defineCodeList
                                    id="setsubikubenList" /> <html:select
                                    name="_JNTCIEquipInsertForm"
                                    styleId="setsubikubenList"
                                    property="setsubi_kuben"
                                    style="width:156px; "
                                    onchange="getKubun()">
                                    <option value="" selected="selected"></option>
                                    <html:options
                                        collection="setsubikubenList"
                                        property="id"
                                        labelProperty="name" />
                                </html:select> <i class="red">*</i></li>
                            <li><label>設備番号：</label> <html:text
                                    property="setsubi_no"
                                    styleId="setsubi_no" readonly="true" />
                                <i class="red">*</i></li>
                            <li><label>設備型番：</label> <t:defineCodeList
                                    id="setsubiKatabanList" /> <html:select
                                    name="_JNTCIEquipInsertForm"
                                    styleId="setsubiKatabanList"
                                    property="setsubi_kataban"
                                    style="width:156px; "
                                    onchange="getKonyuhi()">
                                    <option value="" selected="selected"></option>
                                    <html:optionsCollection
                                        property="setsubiKatabanList"
                                        label="setsubi_kataban_value"
                                        value="setsubi_kataban_key" />
                                </html:select> <i class="red">*</i></li>
                            <li><label>購入日付：</label> <t:defineCodeList
                                    id="setsubiKonyuhiList" /> <html:select
                                    property="kounyu_hiduke"
                                    name="_JNTCIEquipInsertForm"
                                    style="width:156px; ">
                                    <option value="" selected="selected"></option>
                                    <html:optionsCollection
                                        property="setsubiKonyuhiList"
                                        label="setsubi_konyuhi_value"
                                        value="setsubi_konyuhi_key" />
                                </html:select> <i class="red">*</i></li>
                            <li><label>設備用途：</label> <t:defineCodeList
                                    id="getYoutoList" /> <html:select
                                    name="_JNTCIEquipInsertForm"
                                    styleId="getYoutoList"
                                    property="youto"
                                    style="width:156px; ">
                                    <option value="" selected="selected"></option>
                                    <html:options
                                        collection="getYoutoList"
                                        property="id"
                                        labelProperty="name" />
                                </html:select> <i class="red">*</i></li>
                            <li><label>入庫日付：</label> <html:text
                                    property="shunyuko_date"
                                    styleClass="inline laydate-icon"
                                    styleId="shunyuko_date"
                                    readonly="true"></html:text> <i
                                class="red">*</i></li>
                            <li><label>入庫番号：</label> <html:text
                                    property="shunyuko_no"
                                    styleId="shunyuko_no" /> <i
                                class="red">*</i></li>
                            <li><label>棚卸番号：</label> <html:text
                                    property="setsubi_kanaoroshi_no"
                                    styleId="setsubi_kanaoroshi_no" />
                                <i class="red">*</i></li>
                            <li><label>設備数：</label> <html:text
                                    property="setsubi_su"
                                    disabled="false"
                                    styleId="setsubi_su" /> <i
                                class="red">*</i></li>
                            <li><label>棚卸人カード：</label> <html:text
                                    property="tanaoroshi_user"
                                    styleId="tanaoroshi_user"
                                    maxlength="4" /> <i class="red">*</i></li>
                            <li><label>棚卸日付：</label> <html:text
                                    property="tanaoroshi_hiduke"
                                    styleClass="inline laydate-icon"
                                    styleId="tanaoroshi_hiduke"
                                    readonly="true"></html:text> <i
                                class="red">*</i></li>
                            <li class="host"><label>MAC：</label> <html:text
                                    property="mac_address"
                                    styleId="mac_address" /> <i
                                class="red">*</i></li>
                        </ul>
                        <p>
                            <input
                                style="margin-left: 170px; width: 60px; height: 25px"
                                type="submit" value="申請"
                                onclick="onSubimitfun()"
                                class="btn btn-blue" />
                            <html:reset styleClass="btn btn-green"
                                value="クリア"
                                style="margin-left:20px;width:60px;height:25px"
                                styleId="reset" onclick="reset()"></html:reset>
                        </p>
                    </div>
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
<script type="text/javascript">
    !function() {
        laydate.skin('yahui');//切换皮肤，请查看skins下面皮肤库
        laydate({
            elem : '#demo'
        });//绑定元素
    }();
    //購入日付
    var kounyu_hiduke = {
        elem : '#kounyu_hiduke',
        format : 'YYYY/MM/DD',
        max : laydate.now(),
        istime : true,
        istoday : false
    };
    //入庫日付
    var shunyuko_date = {
        elem : '#shunyuko_date',
        format : 'YYYY/MM/DD',
        max : laydate.now(),
        istime : true,
        istoday : false
    };
    //棚卸日付
    var tanaoroshi_hiduke = {
        elem : '#tanaoroshi_hiduke',
        format : 'YYYY/MM/DD',
        max : laydate.now(),
        istime : true,
        istoday : false
    };
    laydate(kounyu_hiduke);
    laydate(shunyuko_date);
    laydate(tanaoroshi_hiduke);
</script>