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
<script type="text/javascript" src="js/laydate/laydate.js"></script>
<script type="text/javascript" src="js/jquery-1.11.3.min.js"></script>
<script type="text/javascript">
    $(document)
            .ready(
                    function() {
                        var kubun = $("#setsubikubenList").val();
                        var f = '<bean:write name="_JNTCIEquip02Form" property="nil" />';
                        var c = '<bean:write name="_JNTCIEquip02Form" property="hiddenstate" />';
                        var b = $("input[name='code']:checked").val();
                        if (f == "88") {
                            $(".equipNo").hide();
                            $("input[name=code]:eq(0)").attr("checked",
                                    'checked');
                            $("#time1").val('');
                            $("#reason").val('');
                            $("#setmailpersonList ").get(0).selectedIndex = 0;
                            $("#setsubikubenList ").get(0).selectedIndex = 0;
                            $("#equip").empty();
                        } else if (f == "11") {
                            $("#time1").val('');
                            $("#setmailpersonList ").get(0).selectedIndex = 0;
                            $("#setsubikubenList ").get(0).selectedIndex = 0;
                            $("#reason").val('');
                        } else if (f == "33") {
                        	$(".Errorr").show();
                        	$(".Errorone").show();
                        }
                        else {
                        }
                        if (b == "0") {
                            $(".equipNo").hide();
                        } else {
                        }
                    });
    function onSubimitfun(type) {
        var kubun = $("#equip").val();
        var b = $("input[name='code']:checked").val();
        var c = $('#equip option:eq(0)').val();
        var e = $("#time1").val();
        var f = $('#setmailpersonList').val();
        var g = $('#setsubikubenList').val();
        var h = $("#reason").val();
        if (type == "1") {
        	var rea = document.getElementById("reason").value;
    		if(rea.length >= 15){
    			$(".Errortwo").show();
    			return false;
    		}
            $(hokj).val("1");
            if (b == "0") {
                if ((e == "") || (f == "") || (g == "") || (h == "")) {
                    $(".Error").show();
                } else {
                    $("#tempform").submit();
                }
            } else if (b == "1") {
                if ((c == null) || (e == "") || (f == "") || (g == "")
                        || (h == "")) {
                    $(".Error").show();
                } else {
                    $("#tempform").submit();
                }
            } else if (b == "2") {
                if ((c == null) || (e == "") || (f == "") || (g == "")
                        || (h == "")) {
                    $(".Error").show();
                } else {
                    $("#tempform").submit();
                }
            } else {
                $("#tempform").submit();
            }
        } else {
            $("#tempform").attr('action',
                    '/tutorial-thin/JNTCIEquipapply02BL.do?yichang=9');
            $("#tempform").submit();
        }
    }
    $(function() {
        $('#left-container .content').hide();
        $('#Equip').show();
        $('h2.tit').click(function() {
            $(this).next('.content').stop().slideToggle();
        });

        $(":radio")
                .on(
                        "click",
                        function() {
                            var b = $("input[name='code']:checked").val();
                            if (b == "0") {
                                $(".equipNo").hide();
                            } else if (b == "1") {
                                $(".equipNo").show();
                            } else {
                                $(".equipNo").show();
                            }
                            var kubun = $("#setsubikubenList").val();
                            if (!(kubun == "")) {
                                $(hokj).val("6");
                                if ($(hokj).val() == "6") {
                                    var a = $("input[name='code']:checked")
                                            .val();
                                    if (a == "0") {
                                        $(".equipNo").hide();
                                    } else if (a == "1") {
                                        $("#tempform")
                                                .attr('action',
                                                        '/tutorial-thin/JNTCIEquipapply02BL.do');
                                        $("#tempform").submit();
                                    } else {
                                        $("#tempform")
                                                .attr('action',
                                                        '/tutorial-thin/JNTCIEquipapply02BL.do');
                                        $("#tempform").submit();
                                    }
                                }
                            } else {
                                $(hokj).val("0");
                            }
                        });
    });
    function getKubun() {
        var kubun = $("#setsubikubenList").val();
        if (!(kubun == "")) {
            $(hokj).val("6");
            if ($(hokj).val() == "6") {
                var a = $("input[name='code']:checked").val();
                if (a == "0") {
                    $(".equipNo").hide();
                } else if (a == "1") {
                    $("#tempform").attr('action',
                            '/tutorial-thin/JNTCIEquipapply02BL.do');
                    $("#tempform").submit();
                } else {
                    $("#tempform").attr('action',
                            '/tutorial-thin/JNTCIEquipapply02BL.do');
                    $("#tempform").submit();
                }
            }
        } else {
            $(hokj).val("0");
        }
    }
</script>
<title>設備申請</title>
</head>
<body>
    <!--头部分 -->
    <div>
        <jsp:include page="/top.jsp" flush="true" />
    </div>
    <!--/头部分 -->
    <div class="clearfix" style="position: relative;">
        <!--左侧部分 -->
        <div style="position: absolute;" class="cleary">
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
                <ts:form action="/JNTCIEquip02BL" styleId="tempform">
                    <div
                        style="max-height: 100px; overflow: auto; width: 500px; margin-left: 40px;"
                        class="Errorr">
                        <html:errors />
                        <html:messages id="message" message="true">
                            <bean:write name="message" />
                        </html:messages>
                        <div style="color: red; display: none"
                            class="Errorone">
                            <h3>以下のエラーが発生しました。</h3>
                           ●失敗を申請し、同種の設備は繰り返し申請できない.
                        </div>
                        <div style="color: red; display: none"
                            class="Error">
                            <h3>以下のエラーが発生しました。</h3>
                            ●入力項目(*)は空にできません.
                        </div>
                        <div style="color: red; display: none"
                            class="Errortwo">
                            <h3>以下のエラーが発生しました。</h3>
                            ●申請理由の長さ は超える.
                        </div>
                    </div>
                    <p>
                        <label>申請日付：<input type="hidden"
                            name="yichang" id="hokj"
                            value="<bean:write name="yichang" scope="session" ignore="true"/>" />

                        </label>
                        <html:text property="time1"
                            styleClass="inline laydate-icon"
                            styleId="time1" readonly="true"></html:text>
                        <i class="red">*</i>
                    </p>
                    <p>
                        <label>申請者：</label>
                        <bean:write name="userName" scope="session"
                            ignore="true" />
                        -
                        <bean:write name="userId" scope="session"
                            ignore="true" />
                        <input name="id" type="hidden"
                            value="<bean:write name="userId" scope="session" />" />
                        <input name="name" type="hidden"
                            value="<bean:write name="userName" scope="session" />" />
                    </p>
                    <p>
                        <label>申請部門名称：</label> <span> <bean:write
                                name="_JNTCIEquip02Form"
                                property="deptName" />
                        </span>
                        <html:hidden property="dept" />
                    </p>
                    <p>
                        <label>宛先：</label>
                        <t:defineCodeList id="setmailpersonList" />
                        <html:select name="_JNTCIEquip02Form"
                            styleId="setmailpersonList"
                            property="mailperson" style="width:156px; ">
                            <option value="" selected="selected"></option>
                            <html:options collection="setmailpersonList"
                                property="id" labelProperty="name" />
                        </html:select>
                        <i class="red">*</i>
                    </p>
                    <p>
                        <label>申請設備区分：</label>
                        <t:defineCodeList id="setsubikubenList" />
                        <html:select name="_JNTCIEquip02Form"
                            styleId="setsubikubenList"
                            property="equipType" style="width:156px; "
                            onchange="getKubun()">
                            <option value="" selected="selected"></option>
                            <html:options collection="setsubikubenList"
                                property="id" labelProperty="name" />
                        </html:select>
                        <i class="red">*</i>
                    </p>
                    <p>
                        <label>申請区分：</label> <i> <html:radio
                                styleId="code1" property="code"
                                value="0" name="_JNTCIEquip02Form">設備申請</html:radio>
                        </i> <i> <html:radio styleId="code2"
                                property="code" value="1"
                                name="_JNTCIEquip02Form">設備修理申請</html:radio>
                        </i> <i> <html:radio styleId="code3"
                                property="code" value="2"
                                name="_JNTCIEquip02Form">設備返還</html:radio>
                        </i>
                    </p>
                    <p class="equipNo">
                        <label>申請設備NO：</label>
                        <html:select styleId="equip" property="equip"  name="_JNTCIEquip02Form">
                            <html:optionsCollection property="equipList" name="_JNTCIEquip02Form"
                                label="equipID" value="equipID" />
                        </html:select>

                        <i class="red">*</i>
                    </p>
                    <p>
                        <label>申請理由：</label>
                        <html:textarea styleId="reason"
                            property="reason" name="_JNTCIEquip02Form" />
                        <i class="red">*</i>
                    </p>
                    <p style="padding: 10px 0 0 10%;">
                        <input id="buttonShuRiChu1" name="承認"
                            type="button"
                            style="min-width: 70px; margin-right: 20px; width: 60px; height: 25px"
                            class="btn btn-blue" value="申請"
                            onclick="onSubimitfun(1)" /> <input
                            id="buttonShuRiChu2" name="クリア"
                            type="button"
                            style="min-width: 70px; margin-right: 50px; width: 60px; height: 25px"
                            class="btn btn-green" value="クリア"
                            onclick="onSubimitfun(2)" />
                    </p>
                </ts:form>
                <div class="footer">
                    <p>
                        連絡メール：<a href="mailto:jinan@trans-cosmos.com.cn"
                            target="_blank">jinan@trans-cosmos.com.cn</a>
                    </p>
                </div>
            </div>
        </div>
        <!--/右侧部分 -->
    </div>
    <script type="text/javascript">
                    laydate({
                        format : 'YYYY-MM-DD',
                        min : laydate.now(),
                        max : laydate.now(+6),
                        elem : '#time1',
                    })
                </script>
</body>
</html:html>