﻿﻿﻿<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="/struts-html" prefix="html"%>
<%@ taglib uri="/struts-bean" prefix="bean"%>
<%@ taglib uri="/struts-logic" prefix="logic"%>
<%@ taglib uri="/terasoluna-struts" prefix="ts"%>
<%@ taglib uri="/terasoluna" prefix="t"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html:html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" type="text/css" href="./css/base.css" />
<link rel="stylesheet" type="text/css" href="./css/main.css" />
<link rel="stylesheet" type="text/css"
    href="${pageContext.request.contextPath}/css/JNTCIEquipHomePage.css" />
<link rel="stylesheet" type="text/css"
    href="${pageContext.request.contextPath}/css/scroll.css" />
<script type="text/javascript"
    src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
<script type="text/javascript"
    src="${pageContext.request.contextPath}/js/jquery-1.11.3.min.js"></script>
<script type="text/javascript"
    src="${pageContext.request.contextPath}/js/homePage.js"></script>
<script type="text/javascript">
    $(document).ready(function() {
        var isNull = $("#commentList").val();
        if (isNull == 0) {
            $(".pagination").hide();
        }
    })
    $(document).ready(function() {
        var isNull = $("#userFlag").val();
        //管理人と判断して
        var flag = $("#flag").val();
        if (isNull == 0 && flag != 0 && flag != 1 && flag != 2 && flag != 5) {
            $("#HomePage04Delete").hide();
        }
    })
    function onSubimitfun(type, index) {
        if (type == "1") {
            $(index).val("delete");
            this.form.submit();
        }
    }

</script>
<title>トップページ</title>
</head>

<body>
    <div>
        <jsp:include page="/top.jsp" flush="true" />
    </div>
    <div style="position: relative;" class="top-page"></div>
    <div style="position: absolute;">
        <jsp:include page="/left.jsp" flush="true" />
    </div>

    <div class="clearfix" style="padding: 1em 3%; margin-left: 190px;">
        <html:errors />
        <div class="main-box leftDiv fl">
            <!-- スレッド詳細 -->
            <div>
                <h2 style="font-size: 22px;">スレッド詳細</h2>
                <html:hidden styleId="userFlag"
                    name="_JNTCIEquipHomePage04Form" property="userFlag" />
                <logic:notEmpty name="_JNTCIEquipHomePage04Form"
                    property="postmessage04">
                    <div class="main-detail">
                        <div>
                            <ul style="list-style: none;">
                                <logic:iterate id="postmessageBean"
                                    name="_JNTCIEquipHomePage04Form"
                                    property="postmessage04">
                                    <div class="content2"
                                        style="text-align: right;">
                                        <a id="HomePage04Delete"
                                            onclick="return confirm('削除しますか?')"
                                            href="${pageContext.request.contextPath}/JNTCIEquipHomePage04DE.do?info_id=<bean:write property="info_id" name="postmessageBean"/>&startIndex=<bean:write name='_JNTCIEquipHomePage04Form' property='startIndex'/>"
                                            style="padding: 3px 10px;">   削除   <html:hidden property="startIndex" name="_JNTCIEquipHomePage04Form"></html:hidden></a> &nbsp;
                                       <a
                                           href="${pageContext.request.contextPath}/JNTCIEquipHomePage03BL.do?startIndex=<bean:write name='_JNTCIEquipHomePage04Form' property='startIndex'/>"
                                           style="padding: 3px 5px;">戻る >></a>
                                    </div>
                                    <li><span>タイトル： </span> <bean:write
                                            name="postmessageBean"
                                            property="info_title" /></li>

                                     <li><span>作 者： </span> <bean:write
                                            name="postmessageBean"
                                            property="user_name" /></li>
                                    <li><span>時 間：</span> <bean:write
                                            name="postmessageBean"
                                            property="info_date" /></li>
                                    <li><div
                                            style="word-break: break-all;">
                                            <span>内 容：</span>
                                            <bean:write
                                                name="postmessageBean"
                                                property="info_details" />
                                        </div></li>
                                    <li><c:if
                                            test="${postmessageBean.tenpu_path ne null }">
                                            <div id="photoDiv"
                                                style="width: 200; height: 210 float:left; margin: 1%; margin-left: 15%">
                                                <div
                                                    style="border: 1px solid #E9E9E4; padding: 1px 1px 1px 1px;">
                                                    <html:hidden
                                                        name="postmessageBean"
                                                        property="tenpu_path" />
                                                    <img id="imghead01"
                                                        src="<bean:write name="postmessageBean" property="tenpu_path" />"
                                                        width="200"
                                                        height="210" />
                                                </div>
                                            </div>
                                        </c:if></li>
                                </logic:iterate>
                            </ul>
                        </div>
                    </div>
                </logic:notEmpty>
            </div>
            <br /> <br />
            <!-- 評論一覧 -->
            <div class="leftFootDiv">
                <h2>評論一覧</h2><html:hidden property="startIndex1" name="_JNTCIEquipHomePage04Form"></html:hidden>
                <ts:pageLinks id="userListPageLinks"
                    action="/JNTCIEquipHomePage04BL?info_id=${postmessageBean.info_id}&startIndex=${_JNTCIEquipHomePage04Form.startIndex}"
                    name="_JNTCIEquipHomePage04Form" rowProperty="row"
                    totalProperty="totalCount"
                    indexProperty="startIndex1" currentPageIndex="now"
                    totalPageCount="total" />
                <logic:notEmpty name="_JNTCIEquipHomePage04Form"
                    property="comment">
                    <div class="topRec_List">
                        <dl>
                            <dd style="width: 10%">評論人</dd>
                            <dd style="width: 55%">内容</dd>
                            <dd style="width: 20%">時間</dd>
                            <dd style="width: 15%">
                                <span id="HomePage04Delete02">操作</span>
                            </dd>
                        </dl>
                        <div style="height: 250px">
                            <ul>
                                <logic:iterate id="postmessage04Bean"
                                    name="_JNTCIEquipHomePage04Form"
                                    property="comment">
                                    <li class="clearfix">
                                        <form
                                            action="/tutorial-thin/JNTCIEquipHomePage04ComDelBL.do?startIndex1=${_JNTCIEquipHomePage04Form.startIndex1}"
                                            method="post">
                                            <div style="width: 10%">
                                                <bean:write
                                                    name="postmessage04Bean"
                                                    property="comment_user_id" />
                                            </div>
                                            <div
                                                style="width: 55%; word-break: break-all;">
                                                <bean:write
                                                    name="postmessage04Bean"
                                                    property="commet_details" />
                                            </div>
                                            <div style="width: 20%">
                                                <bean:write
                                                    name="postmessage04Bean"
                                                    property="comment_date" />
                                            </div>
                                            <div style="width: 15%">
                                                <input type="hidden"
                                                    name="info_id"
                                                    value="<bean:write name="postmessageBean" property="info_id" />" />
                                                <input type="hidden"
                                                    name="comment_Id"
                                                    value="<bean:write name="postmessage04Bean" property="comment_id" />" />
                                                <input type="hidden"
                                                    name="flag"
                                                    id="index" value="" />
                                                <c:if
                                                    test="${_JNTCIEquipHomePage04Form.userFlag ne 1 and postmessage04Bean.comment_user_id eq sessionScope.userId and sessionScope.flag ne 0  and sessionScope.flag ne 1 and sessionScope.flag ne 2 and sessionScope.flag ne 5}">
                                                    <span id="tishi"
                                                        onclick="return confirm('削除しますか?')">
                                                              <input  type="image"  src="images/garbage.jpg"    style="padding-right: 33px; width:25px;height:25px;align:center"  onclick="onSubimitfun(1,index)">
                                                            </span>
                                                </c:if>
                                                <c:if
                                                    test="${_JNTCIEquipHomePage04Form.userFlag eq 1 or sessionScope.flag eq 0 or sessionScope.flag eq 1 or sessionScope.flag eq 2 or sessionScope.flag eq 5}">
                                                    <span id="tishi"
                                                        onclick="return confirm('削除しますか?')">
                                                        <html:hidden property="startIndex" name="_JNTCIEquipHomePage04Form"/>
                                                            <input  type="image"  src="images/garbage.jpg"    style="padding-right: 33px; width:25px;height:25px;align:center"  onclick="onSubimitfun(1,index)">
                                                            </span>
                                                </c:if>
                                            </div>
                                        </form>
                                    </li>
                                </logic:iterate>
                            </ul>
                        </div>
                    </div>
                </logic:notEmpty>
                <logic:empty name="_JNTCIEquipHomePage04Form"
                    property="comment">
                    <div class="topRec_List">
                        <p style="text-align: center;">☞
                            残念ながら、評論はまだありません。^_^</p>
                    </div>
                </logic:empty>
            </div>
            <div style="right: 40%;" class="pagination" >
                    <ul>
                        <li>計<b> <html:hidden
                                    styleId="commentList"
                                    name="_JNTCIEquipHomePage04Form"
                                    property="totalCount" /> <bean:write
                                    name="_JNTCIEquipHomePage04Form"
                                    property="totalCount" /></b>レコード数 <bean:write
                                name="now" />／<bean:write name="total" />
                            <bean:write name="userListPageLinks"
                                filter="false" /></li>
                    </ul>
                </div>
            <!--  評論 -->
            <div class="form-box">
                <ts:form action="/JNTCIEquipHomePage04ComBL?info_id=${postmessageBean.info_id}&startIndex=${_JNTCIEquipHomePage04Form.startIndex}"
                    method="post">
                    <h2>評論</h2>
                    <logic:notEmpty name="_JNTCIEquipHomePage04Form"
                        property="postmessage04">
                        <logic:iterate id="postmessageBean"
                            name="_JNTCIEquipHomePage04Form"
                            property="postmessage04">
                            <ul>
                                <li><input id="uid" type="hidden"
                                    name="userId"
                                    value="<bean:write name="userId" scope="session" ignore="true"/>" />
                                    <input type="hidden" name="info_id"
                                    value="<bean:write name="postmessageBean" property="info_id" />" />
                                    <span>内&emsp;容:</span>
                                <html:text value=""
                                        property="commet_details_txt"
                                        name="_JNTCIEquipHomePage04Form"
                                        style="width: 550px;margin-left: 10px;"
                                        maxlength="140" />&emsp;&emsp;&emsp;
                                    <input type="submit"
                                    class="btn btn-blue" value="登録" />
                                </li>
                            </ul>
                        </logic:iterate>
                    </logic:notEmpty>
                </ts:form>
            </div>
        </div>
        <!-- 最新のお知らせ -->
        <div class="rightDiv fl">
            <h2>最新のお知らせ</h2>
            <logic:notEmpty name="_JNTCIEquipHomePage04Form"
                property="noticeMg">
                <ul>
                    <logic:iterate id="noticeMgBean"
                        name="_JNTCIEquipHomePage04Form"
                        property="noticeMg">
                        <li><a
                            href="${pageContext.request.contextPath}/JNTCIHomePage02BL.do?info_id=<bean:write name='noticeMgBean' property='info_id' />&startIndex=<bean:write name='_JNTCIEquipHomePage04Form' property='startIndex'/>">
                                <bean:write name="noticeMgBean"
                                    property="info_title" />
                        </a></li>
                    </logic:iterate>
                </ul>
            </logic:notEmpty>
            <logic:empty name="_JNTCIEquipHomePage04Form"
                property="noticeMg">
                <div class="maquee">
                    <ul>
                     <li style="padding: 5px">特にありません。^_^</li>
                    </ul>
                </div>
            </logic:empty>
        </div>
    </div>
    <br />
    <br />
    <div id="fade" class="black_overlay"></div>
</body>
</html:html>
