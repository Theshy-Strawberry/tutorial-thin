<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="/struts-html" prefix="html"%>
<%@ taglib uri="/struts-bean" prefix="bean"%>
<%@ taglib uri="/struts-logic" prefix="logic"%>
<%@ taglib uri="/terasoluna-struts" prefix="ts"%>
<%@ taglib uri="/terasoluna" prefix="t"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>済南大宇宙内部システム-个人信息查询区</title>
<link rel="stylesheet" type="text/css" href="css/base.css" />
<link rel="stylesheet" type="text/css" href="css/main.css" />
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript">
    function logo() {
        window.location.href = "index.jsp";
    }
</script>
<script type="text/javascript">
    $(
            function() {
                $('#left-container .content').hide();
                $('#PersonInfo').show();
                $('h2.tit').click(function() {
                    $(this).next('.content').stop().slideToggle();

                })
                var deptName = $("#deptName").val();
                var departmentName = $("#departmentName").val();
                var directName = $("#directName").val();
                var projectName = $("#projectName").val();
                $("#dept_id").find("option[value='" + deptName + "']").attr(
                        "selected", true);
                $("#ku_id").find("option[value='" + departmentName + "']")
                        .attr("selected", true);
                $("#per_id").find("option[value='" + directName + "']").attr(
                        "selected", true);
                $("#entry_id").find("option[value='" + projectName + "']")
                        .attr("selected", true);

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
                    <li>あなたの位置：</li>
                    <li><a href="#">个人情報</a></li>
                    <li class="ico">&gt;</li>
                    <li><a href="#">信息变更</a></li>
                </ul>
            </div>

            <div class="main-ctn ul-li">
                <html:form method="post" action="/JNTCIIntelligenceBL">
                    <ul>
                        <li><label for="cardId"><i
                                class="red">*</i>部 门 变 更</label> <html:hidden
                                name="_JNTCIintelligence"
                                property="deptName" styleId="deptName"></html:hidden>
                            <html:select property="dept_id"
                                styleId="dept_id"
                                name="_JNTCIintelligence">

                                <logic:iterate id="bbb"
                                    name="_JNTCIintelligence"
                                    property="updateUser">
                                    <option
                                        value="<bean:write name="bbb" property="CD_CODE" />"><bean:write
                                            name="bbb"
                                            property="kj_name" /></option>
                                </logic:iterate>
                            </html:select></li>
                        <li><label for="category"><i
                                class="red">*</i>部门负责人</label> <html:hidden
                                name="_JNTCIintelligence"
                                property="departmentName"
                                styleId="departmentName"></html:hidden>
                            <html:select property="ku_id"
                                name="_JNTCIintelligence">
                                <logic:iterate id="aaa"
                                    name="_JNTCIintelligence"
                                    property="kubunList">
                                    <option
                                        value="<bean:write name="aaa" property="kj_name" />"><bean:write
                                            name="aaa"
                                            property="kj_name" /></option>
                                </logic:iterate>
                            </html:select></li>
                        <li><label for="time"><i
                                class="red">*</i>直接负责人</label> <html:hidden
                                name="_JNTCIintelligence"
                                property="directName"
                                styleId="directName"></html:hidden> <html:select
                                property="per_id"
                                name="_JNTCIintelligence">
                                <logic:iterate id="per"
                                    name="_JNTCIintelligence"
                                    property="personList">
                                    <option
                                        value="<bean:write name="per" property="LEADER" />"><bean:write
                                            name="per" property="LEADER" /></option>
                                </logic:iterate>
                            </html:select></li>
                        <li><label for="reason"><i
                                class="red">*</i>项目名变更</label> <html:hidden
                                name="_JNTCIintelligence"
                                property="projectName"
                                styleId="projectName"></html:hidden> <html:select
                                property="entry_id"
                                name="_JNTCIintelligence">
                                <logic:iterate id="entry"
                                    name="_JNTCIintelligence"
                                    property="entryName">
                                    <option
                                        value="<bean:write name="entry" property="CD_CODE" />"><bean:write
                                            name="entry"
                                            property="kj_name" /></option>
                                </logic:iterate>
                            </html:select></li>
                        <li style="padding: 10px 0 0 5%"><input
                            type="reset" onClick="logo()" name="save"
                            class="btn btn-blue" value="登录" />
                            &nbsp;&nbsp; <input type="submit"
                            name="reset" class="btn btn-green"
                            value="修改" /></li>
                    </ul>
                </html:form>
            </div>
            <!--/main-ctn-->
            <div class="footer">
                <p>
                    意见反馈邮箱：<a href="mailto:jinan@trans-cosmos.com.cn"
                        target="_blank">jinan@trans-cosmos.com.cn</a>
                </p>
            </div>
        </div>
    </div>
</body>
</html>