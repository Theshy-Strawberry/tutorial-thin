<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="/struts-html" prefix="html"%>
<%@ taglib uri="/struts-bean" prefix="bean"%>
<%@ taglib uri="/struts-logic" prefix="logic"%>
<%@ taglib uri="/terasoluna-struts" prefix="ts"%>
<%@ taglib uri="/terasoluna" prefix="t"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html:html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>会議室申請</title>
<link rel="stylesheet" type="text/css" href="css/base.css" />
<link rel="stylesheet" type="text/css" href="css/main.css" />
<script type="text/javascript" src="js/jquery-1.11.3.min.js"></script>
<script type="text/javascript">
    $(function() {
        $('#left-container .content').hide();
        $('#MtRoom').show();
        $('h2.tit').click(function() {
            $(this).next('.content').stop().slideToggle();

        })
    })
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
                    <li><a href="#">会議室申請</a></li>
                    <li class="ico">&gt;</li>
                    <li><a href="#">会議室申請成功</a></li>
                </ul>
            </div>
            <div class="main-ctn">
                <ts:form action="/searchMTR">
                 <p style="font-size: 16px;">
                        会議室の申請が成功しました、申請時間通りに使用してください。ご協力ありがどうございます！
                    </p>
                    <p>
                        <label>会議室番号：</label>
                        <bean:write name="_JNTCIMeetingApplyForm"
                            property="roomNo" />
                    </p>
                    <p>
                        <label>会議室名称：</label>
                        <bean:write name="_JNTCIMeetingApplyForm"
                            property="roomName" />
                    </p>
                    <p>
                        <label>申請者カード：</label>
                        <bean:write name="_JNTCIMeetingApplyForm"
                            property="jnCard" />
                    </p>
                    <p>
                        <label>申請者名称：</label>
                        <bean:write name="_JNTCIMeetingApplyForm"
                            property="username" />
                    </p>
                    <p>
                        <label>申請時間：</label>
                        <bean:write name="_JNTCIMeetingApplyForm"
                            property="applyTime" />
                    </p>
                    <p>
                        <label>会議時間：</label>
                        <bean:write name="_JNTCIMeetingApplyForm"
                            property="useTime" />
                    </p>
                    <p>
                        <label>申請原因：</label>
                        <bean:write name="_JNTCIMeetingApplyForm"
                            property="remark" />
                    </p>
                    <p>
                        <label>内容：</label>
                        <bean:write name="_JNTCIMeetingApplyForm"
                            property="subject" />
                    </p>

                    <p>
                        <input style="margin-left: 170px" type="submit"
                            value="査看全て" class="btn btn-blue" />
                    </p>
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
</body>
</html:html>
