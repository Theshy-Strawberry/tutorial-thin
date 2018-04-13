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
<title>済南大宇宙内部管理システム</title>
<script type="text/javascript">
//F12キーの制御
/* $(document).keydown(function(event){
    var keyCode = event.keyCode;
    if(keyCode == 112
         || keyCode == 123
          ){
          return false;
    }
  }); */
function winclose(){
    window.open('about:blank','_top').close();
}

</script>
</head>
<body>
<!--top-->
    <div class="top clearfix">
        <h1 class="fl">済南大宇宙内部管理システム</h1>
        <ul class="fr">
            <li>Hi&nbsp;,<bean:write name="flagName" scope="session" ignore="true"/>:<bean:write name="userName" scope="session" ignore="true"/>-<bean:write name="userId" scope="session" ignore="true"/>ログインに歓迎する！</li>
            <li><ts:link action="/resetSCR.do">[パスワードの修正]</ts:link></li>
            <li><ts:link action="#" onclick="winclose();">[ログアウト]</ts:link></li>
        </ul>
    </div>

<!--/top-->
</body>
</html:html>