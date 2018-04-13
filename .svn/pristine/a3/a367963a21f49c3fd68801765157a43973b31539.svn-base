<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="/struts-html" prefix="html"%>
<%@ taglib uri="/struts-bean" prefix="bean"%>
<%@ taglib uri="/struts-logic" prefix="logic"%>
<%@ taglib uri="/terasoluna-struts" prefix="ts"%>
<%@ taglib uri="/terasoluna" prefix="t"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>済南大宇宙内部システム-個人信息登録区</title>
<link rel="stylesheet" type="text/css" href="css/base.css" />
<link rel="stylesheet" type="text/css" href="css/main.css" />
<link rel="stylesheet" type="text/css" href="css/JNTCIPersonInfo.css" />
<script type="text/javascript" src="js/laydate/laydate.js"></script>
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/JNTCIPersonInfo.js"></script>
<script type="text/javascript">
$(document).ready(function(){
  $("#spanid").focus(function(){
	  $("#spanidd").css("display","block");
  });
  $("#spanid").blur(function(){
	  $("#spanidd").css("display","none");
  });

  $("#spanid2").focus(function(){
	  $("#spanidd2").css("display","block");
  });
  $("#spanid2").blur(function(){
	  $("#spanidd2").css("display","none");
  });
});
</script>
<script type="text/javascript">
    $(function() {
        $('#left-container .content').hide();
        $('#PersonInfo').show();
        $('h2.tit').click(function() {
            $(this).next('.content').stop().slideToggle();

        })
    })
</script>

<script>
    $(function() {
        $(".tdDisplay").each(function(index) {
            if (index != 0) {
                $(this).text("");
            }
        });
    });

    $(function() {
        $(".Display").each(function(index) {
            if (index != 0) {
                $(this).text("");
            }
        });
    });

    function resets() {
        var controls = document.getElementsByTagName('input');
        for (var i = 0; i < controls.length; i++) {
            if (controls[i].type == 'text') {
                controls[i].value = '';
            }
            if (controls[i].type == 'radio') {
                if (controls[i].value == "1") {
                    controls[i].checked = true;
                }
            }
        }
        var controls1 = document.getElementsByTagName('select');
        for (var i = 0; i < controls1.length; i++) {
            controls1[i].selectedIndex = -1;
        }
    }
    $(function() {
        var count = $("#count").val();
        if (count == '1') {
            alert("登録成功");
        } else if (count == '0') {
            alert("登録失敗");
        }
    });

    function test() {
        var JnCard = '<bean:write name="_JNTCIPersonalInfoLoginForm" property="jn_Card" />';
        if (JnCard == "" || JnCard == null) {
            var controls1 = document.getElementsByTagName('select');
            for (var i = 0; i < controls1.length; i++) {
                controls1[i].selectedIndex = -1;
            }
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
        <div class="rightWidht">
            <div class="header">
                <ul class="breadcrumbs clearfix">
                    <li>ステップチャート：</li>
                    <li><a href="#">個人情報</a></li>
                    <li class="ico">&gt;</li>
                    <li><a href="#">社员情報登録</a></li>
                </ul>
            </div>
            <div
                style="max-height: 100px; overflow: auto; width: 500px; margin-left: 80px;">
                <html:errors />
                <html:messages id="message" message="true">
                    <bean:write name="message" />
                </html:messages>
            </div>
            <ts:form styleId="loginForm"
                action="/JNTCIPersonalInfo01insertBLAdd" method="POST"
                enctype="multipart/form-data">
                <div id="errorMessageDIV" class="main-ctn,display"
                    style="max-height: 100px; overflow: auto; color: red; padding-left: 50px"></div>

                <div class="main-ctn self-info">
                    <form method="get" action="#">
                        <table width="100%">
                            <colgroup>
                                <col width="65" />
                                <col width="80" />
                                <col width="65" />
                                <col width="100" />
                                <col width="180" />
                            </colgroup>
                            <tr>
                                <th colspan="5">基本情報<input
                                    type="hidden" id="count"
                                    value="<bean:write
									name="_JNTCIPersonalInfoLoginForm" property="count"/>" /></th>
                            </tr>
                            <tr>
                                <td>済南カード：</td>
                                <td ><html:text
                                        name="_JNTCIPersonalInfoLoginForm"
                                        property="jn_Card"
                                        styleClass="readonly" maxlength="4" styleId="spanid"/>
                                        <i class="red">*</i> <i id="spanidd" style="display:none;color:red;">真剣に记入してください</i></td>

                                <td>天津カード：</td>
                                <td ><input
                                    type="text" name="tj_Card"
                                    class="readonly" maxlength="4"
                                    value="<bean:write
									name="_JNTCIPersonalInfoLoginForm"
									property="tj_Card"/>" id="spanid2"/><i class="red">*</i> <i id="spanidd2" style="display:none;color:red;">真剣に记入してください</i></td>

                                <td rowspan="5" class="pic">
                                    <div id="preview"
                                        style="border: 2px solid; padding: 3px 5px 5px 3px;">
                                        <img id="imghead"
                                            src="images/defaultHeadPortrait.jpg"
                                            width="100" height="110" />
                                    </div> <br /> <input type="file"
                                    name="uploadFile"
                                    onchange="previewImage(this)"
                                    accept="image/jpeg" id="photo"
                                    style="display: none" />
                                    <button type="button" class="btn"
                                        style="margin-top: 10px; width: 110px"
                                        id="photoUpload">選択画像</button>
                                </td>
                            </tr>
                            <tr>
                                <td>名前：</td>
                                <td ><html:text
                                        name="_JNTCIPersonalInfoLoginForm"
                                        property="userName" maxlength="13"/><i
                                    class="red">*</i></td>
                                <td>性別：</td>
                                <td><html:radio
                                        name="_JNTCIPersonalInfoLoginForm"
                                        property="sex" value="1" /> <label
                                    for="man">男</label> <html:radio
                                        name="_JNTCIPersonalInfoLoginForm"
                                        property="sex" value="0" /> <label
                                    for="woman">女</label><i class="red">*</i></td>
                            </tr>
                            <tr>
                                <td>ローマ字：</td>
                                <td><html:text
                                        name="_JNTCIPersonalInfoLoginForm"
                                        property="jn_Name"
                                        maxlength="16" /></td>
                                <td>民族：</td>
                                <td><html:text
                                        name="_JNTCIPersonalInfoLoginForm"
                                        property="nation"
                                        maxlength="6" /></td>
                            </tr>
                            <tr>
                                <td>生年月日：</td>
                                <td><html:text styleId="BIRTHDAR"
                                        name="_JNTCIPersonalInfoLoginForm"
                                        property="birthday"
                                        styleClass="inline laydate-icon"
                                        readonly="true"
                                        maxlength="20"/></td>
                                <td>国籍：</td>
                                <td><html:text
                                        name="_JNTCIPersonalInfoLoginForm"
                                        property="nationality"
                                        maxlength="6" /></td>
                            </tr>
                            <tr>
                                <td>婚姻状況：</td>
                                <td><html:radio
                                        name="_JNTCIPersonalInfoLoginForm"
                                        property="marital_Status"
                                        value="1" /> <label
                                    for="unmarried">未婚</label> <html:radio
                                        name="_JNTCIPersonalInfoLoginForm"
                                        property="marital_Status"
                                        value="0" /> <label
                                    for="married">既婚</label></td>
                                <td>身分証明書：</td>
                                <td><html:text
                                        name="_JNTCIPersonalInfoLoginForm"
                                        property="id_Card"
                                        maxlength="18" /><i class="red">*</i></td>
                            </tr>
                            <tr>
                                <td>連絡電話：</td>
                                <td><html:text
                                        name="_JNTCIPersonalInfoLoginForm"
                                        property="telephone"
                                        maxlength="11" /></td>
                                <td>出身：</td>
                                <td><html:text
                                        name="_JNTCIPersonalInfoLoginForm"
                                        property="born_In"
                                        maxlength="16" /></td>
                            </tr>
                            <tr>
                                <td>緊急連絡先：</td>
                                <td><html:text
                                        name="_JNTCIPersonalInfoLoginForm"
                                        property="emerg_Contact"
                                        maxlength="13"/></td>
                                <td>緊急連絡先電話：</td>
                                <td><html:text
                                        name="_JNTCIPersonalInfoLoginForm"
                                        property="emerg_Contact_tel"
                                        maxlength="11" /></td>
                            </tr>
                            <tr>
                                <td>入社時間：</td>
                                <td><html:text styleId="ENTRY_TIME"
                                        name="_JNTCIPersonalInfoLoginForm"
                                        property="entry_Time"
                                        styleClass="inline laydate-icon"
                                        readonly="true" /><i class="red">*</i></td>
                            </tr>
                            <tr>
                                <td>今詳細な住所：</td>
                                <td colspan="3"><html:text
                                        name="_JNTCIPersonalInfoLoginForm"
                                        property="address"
                                        style="width:450px"/></td>
                            </tr>
                            <tr>
                                <th colspan="5">詳細情報</th>
                            </tr>
                            <tr>
                                <td>所属部門：</td>
                                <td><t:defineCodeList
                                        id="departmentList" /> <html:select
                                        name="_JNTCIPersonalInfoLoginForm"
                                        property="department">
                                        <html:option value=""></html:option>
                                        <html:options
                                            collection="departmentList"
                                            property="id"
                                            labelProperty="name" />
                                    </html:select><i class="red">*</i></td>
                                <td>ポスト：</td>
                                <td colspan="2"><t:defineCodeList
                                        id="positionList" /> <html:select
                                        name="_JNTCIPersonalInfoLoginForm"
                                        property="position"
                                        style="width:120px; ">
                                        <html:option value=""></html:option>
                                        <html:options
                                            collection="positionList"
                                            property="id"
                                            labelProperty="name" />
                                    </html:select><i class="red">*</i></td>
                            </tr>
                            <tr>
                                <td>所属上司：</td>
                                <td><t:defineCodeList
                                        id="leaderlist" /> <html:select
                                        name="_JNTCIPersonalInfoLoginForm"
                                        property="leader">
                                        <html:option value=""></html:option>
                                        <html:options
                                            collection="leaderlist"
                                            property="id"
                                            labelProperty="name" />
                                    </html:select><i class="red">*</i></td>
                                <td>部门负责人：</td>
                                <td colspan="2"><html:select
                                        name="_JNTCIPersonalInfoLoginForm"
                                        property="deptPerson">
                                        <html:option value=""></html:option>
                                        <html:option value="田東啓">田東啓</html:option>
                                        <html:option value="衣蘭凱">衣蘭凱</html:option>
                                        <html:option value="張棟">張棟</html:option>
                                    </html:select> <i class="red">*</i></td>
                            </tr>
                            <tr>



                                <td>パスポート：</td>
                                <td class="passportTd"><html:radio
                                        styleId="p-has"
                                        name="_JNTCIPersonalInfoLoginForm"
                                        property="passport" value="1" />
                                    <label for="p-has">無</label> <html:radio
                                        styleId="p-hasnot"
                                        name="_JNTCIPersonalInfoLoginForm"
                                        property="passport" value="0" />
                                    <label for="p-hasnot">有</label>
                                </td>
                                <td>ビザ：</td>
                                <td colspan="2"><html:radio
                                        name="_JNTCIPersonalInfoLoginForm"
                                        property="visa" value="1" /> <label
                                    for="v-has">無</label> <html:radio
                                        name="_JNTCIPersonalInfoLoginForm"
                                        property="visa" value="0"
                                        title="ビザの詳細情報" /> <label
                                    for="v-hasnot">有</label></td>
                            </tr>
                            <tr>

                                <td>社保開始日：</td>
                                <td><html:text styleId="SOCIAL"
                                        name="_JNTCIPersonalInfoLoginForm"
                                        property="socialSecurity"
                                        styleClass="inline laydate-icon"
                                        readonly="true" /><i class="red">*</i></td>
                                <td>最終学歴：</td>
                                <td colspan="2"><t:defineCodeList
                                        id="educationList" /> <html:select
                                        name="_JNTCIPersonalInfoLoginForm"
                                        property="education"
                                        style="width:120px">
                                        <html:option value=""></html:option>
                                        <html:options
                                            collection="educationList"
                                            property="id"
                                            labelProperty="name" />
                                    </html:select><i class="red">*</i></td>
                            </tr>
                            <tr>
                                <td>個人メールボックス：</td>
                                <td><html:text
                                        name="_JNTCIPersonalInfoLoginForm"
                                        property="pesonal_Mall"/></td>
                                <td>社内メールボックス：</td>
                                <td colspan="2"><html:text
                                        name="_JNTCIPersonalInfoLoginForm"
                                        property="offic_Mail"/><label
                                    style="margin: 0 3px;">@trans-cosmos.com.cn
                                </label><i class="red">*</i></td>
                            </tr>
                        </table>
                        <div style="margin: 32px 0px 0px 400px;">
                            <input id="submitForm" type="button"
                                value="登録"
                                style="width: 60px; height: 25px"
                                class="btn btn-blue" /> <input
                                type="button" onclick="resets()"
                                value="クリア" class="btn btn-green"
                                style="margin-left: 20px; width: 60px; height: 25px" />
                        </div>
                        <html:hidden name="_JNTCIPersonalInfoLoginForm"
                            property="judge_flg" />
                        <html:hidden name="_JNTCIPersonalInfoLoginForm"
                            property="list" styleId="list" />

                        <div class="login-bg"></div>
                    </form>
                    <div class="footer">
		                <p>
		                    意見反馈メール：<a href="mailto:jinan@trans-cosmos.com.cn"
		                        target="_blank">jinan@trans-cosmos.com.cn</a>
		                </p>
		            </div>
                </div>
            </ts:form>
            <script type="text/javascript">
                                                    !function() {
                                                        laydate.skin('yahui');//切换皮肤，请查看skins下面皮肤库
                                                        laydate({
                                                            elem : '#demo'
                                                        });//绑定元素
                                                    }();
                                                    //日期范围限制
                                                    var start = {
                                                        elem : '#BIRTHDAR',
                                                        format : 'YYYY\/MM\/DD',
                                                        max : laydate.now(), //设定最小日期为当前日期
                                                        istoday : false,
                                                    };
                                                    var soc = {
                                                        elem : '#SOCIAL',
                                                        format : 'YYYY\/MM\/DD',
                                                        istoday : false,
                                                    };

                                                    var out = {
                                                        elem : '#OUT_TIME',
                                                        format : 'YYYY\/MM\/DD',
                                                        max : laydate.now(),
                                                        istoday : false,
                                                    };
                                                    var end = {
                                                        elem : '#ENTRY_TIME',
                                                        format : 'YYYY\/MM\/DD',
                                                        max : laydate.now(),
                                                        istoday : false,
                                                    };

                                                    var start1 = {
                                                        elem : '#ISSUE_DATE',
                                                        format : 'YYYY-MM-DD',
                                                        istoday : false,
                                                    };
                                                    var end1 = {
                                                        elem : '#EXPIRY_DATE',
                                                        format : 'YYYY-MM-DD',
                                                        istoday : false,
                                                    };
                                                    laydate(start);
                                                    laydate(end);
                                                    laydate(start1);
                                                    laydate(end1);
                                                    laydate(soc);
                                                    laydate(out);
                                                </script>
        </div>
    </div>
</body>
</html>
