<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="/struts-html" prefix="html"%>
<%@ taglib uri="/struts-bean" prefix="bean"%>
<%@ taglib uri="/struts-logic" prefix="logic"%>
<%@ taglib uri="/terasoluna-struts" prefix="ts"%>
<%@ taglib uri="/terasoluna" prefix="t"%>
<%
   response.setHeader("Cache-Control", "no-store");
   response.setDateHeader("Expires", 0);
   response.setHeader("Pragma", "no-cache");
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html:html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>済南大宇宙内部管理システム登録頁</title>
<link rel="stylesheet" type="text/css" href="css/base.css" />
<link rel="stylesheet" type="text/css" href="css/main.css" />
<script type="text/javascript">
    function getUserId(value) {
        var path = document.getElementById("jncardform");
        path.action = value;
        path.submit();
    }
</script>
</head>
<body>
    <div
        style="height: 100px; overflow: auto; width: 500px; margin: 0 auto">
        <html:errors />
        <html:messages id="message" message="true">
            <bean:write name="message" />
        </html:messages>
    </div>
    <!--login-main-->
    <div class="login-main">

        <h1>済南大宇宙内部管理システム</h1>
        <!--login-info-->

        <ts:form styleId="jncardform" action="/loginBL">
            <div class="login-info">
                <p>
                    <label>ユーザーID：</label>
                    <html:text property="userId" styleId="usercard"
                        maxlength="4" />
                    <i class="red">*</i>
                </p>
                <p>
                    <label>パスワード：</label>
                    <html:password property="password" />
                    <i class="red">*</i>
                </p>
                <p>
                    <ts:submit value="登録" />
                    <html:reset value="クリア" />
                </p>
            </div>
            <p align="center">
                如果有问题请联系<a href='mailto:wang.yujie@trans-cosmos.com.cn'>管理员</a>,忘记或丢失密码请点击
                <ts:link onclick="getUserId(this);return false;"
                    action="/loginGetPassWord" style="font-color:red;"
                    title="输入卡号，点击该链接后日报系统会自动将密码发送到您的公司邮箱">获取密码</ts:link>
            </p>
        </ts:form>
        <!--/login-info-->
    </div>
    <!-- /login-main-->
</body>
</html:html>