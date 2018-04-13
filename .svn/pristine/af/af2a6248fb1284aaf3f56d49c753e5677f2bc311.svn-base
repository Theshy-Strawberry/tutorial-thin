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
<title>年休追加</title>
<link rel="stylesheet" type="text/css" href="css/base.css" />
<link rel="stylesheet" type="text/css" href="css/main.css" />
<script type="text/javascript" src="js/laydate/laydate.js"></script>
<script type="text/javascript" src="js/jquery-1.11.3.min.js"></script>
<script type="text/javascript">
    $(function() {
        $('#left-container .content').hide();
        $('#Attendance').show();
        $('h2.tit').click(function() {
            $(this).next('.content').stop().slideToggle();

        })
    })
    $(function() {
        $("#add").click(
                function() {
                    var errorMessage = "";
                    var num4Check = /^\d{4}$/;
                    var remaiDayCheck = /^\d{1,3}\.[0-9]{0,1}$/;
                    var numpointCheck = /^[\d]+(\.\d)?$/;
                    var userId = $("input[name='userId']").val();
                    var userName = $("input[name='userName']").val();
                    var userSex = $("input[name='userSex']:checked").val();
                    var deptId = $("#deptId option:selected").val();
                    var userType = $("userType  option:selected").val();
                    var remainDays = $("input[name='remainDays']").val();
                    if (!isNaN(remainDays)) {
                        remainDays = parseFloat(remainDays).toFixed(1);
                    }
                    var entyrTime = $("input[name='entyrTime']").val();

                    if (userId == "" || userName == "" || userSex == ""
                            || deptId == "" || userType == ""
                            || remainDays == "" || entyrTime == "") {
                        errorMessage = errorMessage + "●すべて入力しなければなりません</br>";
                    }
                    if (userId != "" && !num4Check.test(userId)) {

                        errorMessage = errorMessage
                                + "● 社員カード必須四位数字を入力してください.</br>"
                    }
                    if (remainDays != "" && !remaiDayCheck.test(remainDays)) {

                        errorMessage = errorMessage
                                + "● 休暇総時数必須3位数字以内を入力してください.</br>"
                    }
                    $("#errorMessageDIV").html("");
                    if (errorMessage.indexOf("●") != -1) {
                        $("#errorMessageDIV").append(errorMessage);
                        $("#errorMessageDIV").removeClass("display");
                        return false;
                    } else {
                        $('#formids').submit();

                    }

                });

    });
</script>
<script type="text/javascript">
function subimit() {
        $("#formids").attr('action',
                '/tutorial-thin/JNTCIVocationBack.do?mark=back');
        $("#formids").submit();
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
                    <li><a href="#">勤務管理</a></li>
                    <li class="ico">&gt;</li>
                    <li><a href="#">年休追加</a></li>
                </ul>
            </div>
            <div
                style="max-height: 100px; overflow: auto; width: 500px; margin-left: 25px;">
                <html:errors />
                <html:messages id="message" message="true">
                    <bean:write name="message" />
                </html:messages>
            </div>
            <div id="errorMessageDIV" class="main-ctn,display"
                style="max-height: 100px; overflow: auto; color: red; padding-left: 50px"></div>
            <div class="main-ctn ul-li">
                <ts:form action="/insertBLforVocation" styleId="formids">
                    <ul>
                        <li><label>社員カード：</label> <html:text
                                property="userId" styleId="userId"
                                name="_JNTCIVocationForm"></html:text></li>
                        <li><label>社員名前：</label> <html:text
                                property="userName" styleId="userName"
                                name="_JNTCIVocationForm"></html:text></li>
                        <li><label>性別：</label> <html:radio
                                property="userSex" value="man"
                                styleId="userSex"
                                name="_JNTCIVocationForm">男</html:radio>
                            <html:radio property="userSex" value="woman"
                                styleId="userSex"
                                name="_JNTCIVocationForm">女</html:radio>
                        </li>

                        <li><label>部門所属：</label> <t:defineCodeList
                                id="deptIdList" /> <html:select
                                name="_JNTCIVocationForm"
                                property="deptId" styleId="deptid">
                                <option value="" selected="selected">-選択してください-</option>
                                <html:options collection="deptIdList"
                                    property="id" labelProperty="name" />
                            </html:select></li>

                        <li><label>社員学歴：</label> <t:defineCodeList
                                id="educationList" /> <html:select
                                name="_JNTCIVocationForm"
                                property="userType" style="width:120px">
                                <option value="" selected="selected">-選択してください-</option>
                                <html:options collection="educationList"
                                    property="id" labelProperty="name" />
                            </html:select></li>
                        <li><label>休暇総時数：</label> <html:text
                                property="remainDays"
                                styleId="remainDays"
                                name="_JNTCIVocationForm"></html:text></li>
                        <li><label>入職時間：</label> <html:text
                                styleId="entyrTime"
                                name="_JNTCIVocationForm"
                                property="entyrTime"
                                styleClass="inline laydate-icon"
                                readonly="true" /></li>
                        <li><input type="button"
                            style="margin-left: 100px;"
                            class="btn btn-blue fl" value="追加" id="add" />
                           <input type="hidden" id="mark" name="mark" value="back" />
                            <input type="button"
                            style="margin-left: 20px; margin-top:1px"
                            class="btn btn-blue fl" value="戻る" id="back" onclick="subimit()"/>
                        </li>
                    </ul>
                </ts:form>
                <div class="footer" style="padding:40px 0 0">
                    <p>
                        連絡メール：<a href="mailto:jinan@trans-cosmos.com.cn"
                            target="_blank">jinan@trans-cosmos.com.cn</a>
                    </p>
                </div>
            </div>
            <!--/main-ctn-->
        </div>
        <script type="text/javascript">
                                    !function() {
                                        laydate.skin('yahui');//切换皮肤，请查看skins下面皮肤库
                                        laydate({
                                            elem : '#demo'
                                        });//绑定元素
                                    }();
                                    //日期范围限制
                                    var entyr = {
                                        elem : '#entyrTime',
                                        format : 'YYYY-MM-DD',
                                        max : laydate.now(), //设定最小日期为当前日期
                                        istoday : false,
                                    };
                                    laydate(entyr);
                                </script>
    </div>
</body>
</html:html>