<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="/struts-html" prefix="html"%>
<%@ taglib uri="/struts-bean" prefix="bean"%>
<%@ taglib uri="/struts-logic" prefix="logic"%>
<%@ taglib uri="/terasoluna-struts" prefix="ts"%>
<%@ taglib uri="/terasoluna" prefix="t"%>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>申請詳細</title>
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
</script>
<script type="text/javascript">
    function checkstartholidaydate() {
        var aa = document.getElementById("startholidaydate").value;
        var e = aa.substr(0, 4);
        var c = aa.match(/\/(\S*)\//)[1];
        var d = aa.match(/\/(\S*)/)[1];
        var f = d.match(/\/(\S*)/)[1];
        if (c.length == 1) {
            c = "0" + c;
        }
        if (f.length == 1) {
            f = "0" + f;
        }
        document.getElementById("startholidaydate").value = e + "/" + c + "/"
                + f;
    }
    function checkendholidaydate() {
        var aa = document.getElementById("endholidaydate").value;
        var e = aa.substr(0, 4);
        var c = aa.match(/\/(\S*)\//)[1];
        var d = aa.match(/\/(\S*)/)[1];
        var f = d.match(/\/(\S*)/)[1];
        if (c.length == 1) {
            c = "0" + c;
        }
        if (f.length == 1) {
            f = "0" + f;
        }
        document.getElementById("endholidaydate").value = e + "/" + c + "/" + f;
    }
</script>
<script type="text/javascript">
    function ac(type, index) {
        if (type == "1") {
            alert("aaa");
            var a = document.getElementById("aaa").value;
            alert(a);
            $(index).val("delete");
            this.form.submit();
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
                    <li><a href="#">休暇追加</a></li>
                    <li class="ico">&gt;</li>
                    <li><a href="#">假期詳細</a></li>
                </ul>
            </div>
            <div
                style="max-height: 100px; overflow: auto; width: 500px; margin-left: 40px;">
                <html:errors />
                <html:messages id="message" message="true">
                    <bean:write name="message" />
                </html:messages>
            </div>
            <div class="main-ctn ul-li">
                <ts:form action="/JNTCIholidayByIdUpdate">
                    <ul>
                         <html:hidden property="holidayid" />
                         <html:hidden property="startIndex" name="_Wform"/>
                        <html:hidden property="name1" name="_Wform"/>
                        <li class="auto"><label>休暇名称：</label> <html:text
                                styleId="name" name="_Wform" maxlength="6"
                                property="name" /><span style="color:red"> *</span></li>
                        <li class="auto"><label>開始時間：</label> <html:text
                                styleId="startholidaydate" name="_Wform" maxlength="10"
                                property="startholidaydate"
                                onblur="checkstartholidaydate()" /><span style="color:red"> *</span></li>
                        <li class="auto"><label>終了時間：</label> <html:text
                                styleId="endholidaydate" name="_Wform" maxlength="10"
                                property="endholidaydate"
                                onblur="checkendholidaydate()" /><span style="color:red"> *</span></li>
                        <li class="auto" style="padding-left: 170px;"><ts:submit
                                styleClass="btn btn-blue" value="保存"
                                onclick="return confirm('保存しますか?')"
                                property="forward_save" />
                            &nbsp;&nbsp;&nbsp; <ts:submit
                                styleClass="btn btn-green" value="戻る"
                                property="forward_list" /></li>
                    </ul>
                </ts:form>
                <table class="ctn" width="20%" style="margin-left: 30px">
                    <caption>假期时间一覧</caption>
                    <tr>
                        <th>假期时间</th>
                        <th>操作</th>
                    </tr>
                    <logic:notEmpty name="_Wform"
                        property="holidaytimelist">
                        <logic:iterate id="_WformBean" name="_Wform"
                            property="holidaytimelist">
                            <ts:form action="/deleteholidatytime.do"
                                method="post">
                                <tr align="center" class="d">
                                    <td align="center"><bean:write
                                            name="_WformBean"
                                            property="xDay" /></td>
                                    <td><input type="hidden"
                                        name="holidayid"
                                        value="<bean:write name="_WformBean" property="holidayid"/>" />
                                        <input type="hidden" name="xDay"
                                        value="<bean:write name="_WformBean" property="xDay"/>" />
                                        <html:hidden property="holidayid" />
                                        <input class="btn btn-red"
                                        onclick="return confirm('本当に削除しますか?')"
                                        type="submit" value="削除" /></td>
                                </tr>
                            </ts:form>
                        </logic:iterate>
                    </logic:notEmpty>
                </table>
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
</html>



