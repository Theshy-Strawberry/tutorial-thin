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
<link rel="stylesheet" type="text/css" href="Style/skin.css" />
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
    })
    function onSubimitfun() {
        var kubun = $("#setsubikubenList").val();
               if (kubun == "PJN" || kubun == "") {
       $("#katabanId").validate({
                rules : {
                    host_CPU : {
                        required : true,
                    },
                    cpu_haichi : {
                        required : true,
                    },
                    memori : {
                        required : true,
                        number : true,
                    },
                    harddisk : {
                        required : true,
                        number : true,
                    },
                    harddisk_total : {
                        required : true,
                        number : true,
                    }
                },
       messages:{
    	   host_CPU :{
    		   required :"空にはできない"
    	   },
                cpu_haichi : {
                    required :"空にはできない",
                },
                memori : {
                    required :"空にはできない",
                    number :"数字にはならない",
                },
                harddisk : {
                    required :"空にはできない",
                    number :"数字にはならない",
                },
                harddisk_total : {
                    required :"空にはできない",
                    number :"数字にはならない",
                }
       }
            })
        }
        $("#katabanId").submit();
    }
    $(document).ready(function() {
        getSetsubiValue(value);
    })
    //設備種類のvalueを取得
    function getSetsubiValue(value) {
        if (value == "PJN" || value == "") {
            $('.host').show();
        } else {
            $('.host').hide();
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
        <div id="equipKtb" class="rightWidht">
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
                    <li class="on"><a href="#">設備型番追加</a></li>
                    <li><ts:link action="/JNTCIEquipInsertBL01.do">設備番号追加</ts:link></li>
                </ul>
            </div>
            <div class="main-ctn ul-li equip-apply">
                <!-- 設備型番を追加する -->
                <div>
                    <ts:form action="/JNTCIEquipkatabanBL"
                        styleId="katabanId" method="post">
                        <div class="clearfix">
                            <div style="max-height: 100px; overflow: auto; width: 500px; margin-left: 70px;">
                                <html:errors />
                                <html:messages id="message"
                                    message="true">
                                    <bean:write name="message" />
                                </html:messages>
                            </div>
                         <textarea rows="1" cols="20" Id="textid" style="color: red; display: none"></textarea>
                            <ul>
                                <li><label>設備種類：</label> <t:defineCodeList
                                        id="setsubikubenList" /> <html:select
                                        name="_JNTCIEquipKatabanForm"
                                        styleId="setsubikubenList"
                                        property="setsubi_kuben"
                                        style="width:156px; "
                                        onchange="getSetsubiValue(this.value)">
                                        <option value=""
                                            selected="selected"></option>
                                        <html:options
                                            collection="setsubikubenList"
                                            property="id"
                                            labelProperty="name" />
                                    </html:select> <i class="red">*</i></li>
                                <li><label>設備型番：</label> <html:text
                                        property="setsubi_kataban"
                                        styleId="setsubi_kataban" /> <i
                                    class="red">*</i></li>
                                <li><label>単価(&yen;)：</label> <html:text
                                        property="setsubi_tanka"
                                        styleId="setsubi_tanka" /> <i
                                    class="red">*</i></li>
                                <li><label>設備規格：</label> <html:text
                                        property="setsubi_kikaku"
                                        styleId="setsubi_kikaku" /> <i
                                    class="red">*</i></li>
                                <!--設備種類はホスト時に表示されて  -->
                                <li class="host"><label>CPU：</label>
                                    <html:text property="host_CPU"
                                        styleId="host_CPU" /> <i
                                    class="red">*</i></li>
                                <li class="host"><label>CPU配置：</label>
                                    <t:defineCodeList
                                        id="getCPUHaichiList" /> <html:select
                                        name="_JNTCIEquipKatabanForm"
                                        styleId="getCPUHaichiList"
                                        property="cpu_haichi"
                                        style="width:156px; ">
                                        <option value=""
                                            selected="selected"></option>
                                        <html:options
                                            collection="getCPUHaichiList"
                                            property="id"
                                            labelProperty="name" />
                                    </html:select> <i class="red">*</i></li>
                                <li class="host"><label>メモリ(G)：</label>
                                    <html:text property="memori"
                                        styleId="memori" /> <i
                                    class="red">*</i></li>
                                <li class="host"><label>ハードディスク(G)：</label>
                                    <html:text property="harddisk"
                                        styleId="harddisk" /> <i
                                    class="red">*</i></li>
                                <li class="host"><label>ハードディスク総量(G)：</label>
                                    <html:text property="harddisk_total"
                                        styleId="harddisk_total" /> <i
                                    class="red">*</i></li>
                                <!--設備種類はホスト時に表示されて  -->
                                <li><label>購入日：</label> <html:text
                                        property="kounyu_hiduke"
                                        styleClass="inline laydate-icon"
                                        styleId="kounyu_hiduke"
                                        readonly="true"></html:text> <i
                                    class="red">*</i></li>
                                <li><label>購入者：</label> <html:text
                                        property="kounyu_user"
                                        maxlength="4"
                                        styleId="kounyu_user" /> <i
                                    class="red">*</i></li>
                                <li><label>設備メーカー：</label> <html:text
                                        property="setsubi_maker"
                                        styleId="setsubi_maker" /> <i
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
                                    style="margin-left: 20px;width:60px;height:25px"
                                    styleId="reset" onclick="reset()"></html:reset>
                            </p>
                        </div>
                    </ts:form>
                </div>
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

    //購入日
    var kounyu_hiduke = {
        elem : '#kounyu_hiduke',
        format : 'YYYY/MM/DD',
        max : laydate.now(),
        istime : true,
        istoday : false
    };
    laydate(kounyu_hiduke);
</script>