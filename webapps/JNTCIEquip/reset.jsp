<%@ page contentType="text/html; charset=UTF-8"%>
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
<title>パスワードの修正画面</title>
</head>
<script type="text/javascript">
    $(function() {
        $('#left-container .content').hide();
        $('#First').show();
        $('h2.tit').click(function() {
            $(this).next('.content').stop().slideToggle();
        })
    })
    function clearMethod1() {
        window.location.href = 'http://172.17.1.26:8080/tutorial-thin/resetSCR.do?r=4879844357802300710'
    }
</script>
<body>
    <div>
        <jsp:include page="/top.jsp" flush="true" />
    </div>
    <div class="clearfix" style="position: relative;">
        <div style="position: absolute;">
            <jsp:include page="/left.jsp" flush="true" />
        </div>
        <div style="padding-left: 210px">
            <div class="header">
                <ul class="breadcrumbs clearfix">
                    <li>ステップチャート：</li>
                    <li>パスワードの修正</li>
                </ul>
            </div>
            <ts:form action="/resetBL">
                <div class="main-ctn">
                    <fieldset
                        style="border: 0pt solid black; padding: 20px; width: 100%;">
                        <div class="change-pwd">
                            <div
                                style="max-height: 100px; overflow: auto; width: 500px; margin-left: 25px;">
                                <html:errors />
                                <html:messages id="message"
                                    message="true">
                                    <bean:write name="message" />
                                </html:messages>
                            </div>
                            <p>
                                <label for="pwd">旧パスワード：</label>
                                <html:password property="password1" />
                                <i class="red">*</i>
                            </p>
                            <p>
                                <label for="pwd-new">新パスワード：</label>
                                <html:password property="password2" />
                                <i class="red">*</i>
                            </p>
                            <p>
                                <label for="rpwd">新パスワード確認：</label>
                                <html:password property="password3" />
                                <i class="red">*</i>
                            </p>
                            <p>
                                <input type="submit" value="確定"
                                    class="btn btn-blue" />
                                <html:reset styleClass="btn btn-green"
                                    value="リセット"
                                    style="margin-left:20px"
                                    styleId="reset"
                                    onclick="clearMethod1();" />
                            </p>
                        </div>
                    </fieldset>
                </div>
                <div class="footer">
                    <p>
                        連絡メール：<a href="mailto:jinan@trans-cosmos.com.cn"
                            target="_blank">jinan@trans-cosmos.com.cn</a>
                    </p>
                </div>
            </ts:form>
        </div>
    </div>
</body>
</html:html>