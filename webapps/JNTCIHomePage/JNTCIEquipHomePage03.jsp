<%@ page contentType="text/html; charset=utf-8"%>
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
    //翻页下标隐藏
    $(document).ready(function() {
        var isNull = $("#infoList").val();
        if (isNull == 0) {
            $(".pagination").hide();
        }
    })
    //reset
    $(function() {
        $("#reset").click(function() {
            $("#imghead").attr("src", "images/upload.jpg");
        })
    })
    function aa(){
    	var titlelength = document.getElementById("titlelength").value;
        if(titlelength.length >= 37){
        	document.getElementById('Errortitle').style.display='block';
        	return false;
        }
    }
    function bb() {
    	var contentlength = document.getElementById("contentlength").value;
        if (contentlength.length >= 1900) {
        	document.getElementById("contentlength").value = contentlength.substr(0,1900);
        	document.getElementById('Errorcontent').style.display='block';
        }
    }
</script>
<title>トップページ</title>
</head>
<body>
    <div><jsp:include page="/top.jsp" flush="true" /></div>
    <div style="position: relative;" class="top-page">
        <div style="position: absolute;">
            <jsp:include page="/left.jsp" flush="true" />
        </div>
    </div>

    <div class="clearfix" style="padding: 2em 3%; margin-left: 190px;">
        <div
            style="max-height: 100px; overflow: auto; width: 500px; margin-left: 40px;">
            <html:errors />
            <h3>
                <html:messages id="message" message="true">
                    <bean:write name="message" />
                </html:messages>
            </h3>
        </div>
        <div class="leftDiv fl">
            <div class="">
                <div id="tabs" class="pos">
                    <div id="tab-top">
                        <ul>
                            <li><ts:link
                                    action="/JNTCIEquipHomePageBL.do">お知らせ</ts:link></li>
                            <li class="on"><a href="#">フォーラム</a></li>
                        </ul>
                    </div>
                </div>
                <!--不为空-->
                <logic:notEmpty name="_JNTCIEquipHomePageForm"
                    property="postmessage">
                    <div class="topRec_List" style="height: 50px;">
                        <ts:pageLinks id="userListPageLinks"
                            action="/JNTCIEquipHomePage03BL"
                            name="_JNTCIEquipHomePageForm"
                            rowProperty="row" totalProperty="totalCount"
                            indexProperty="startIndex"
                            currentPageIndex="now"
                            totalPageCount="total" />
                        <ul>

                            <logic:iterate id="postmessageBean"
                                name="_JNTCIEquipHomePageForm"
                                property="postmessage">
                                <li class="clearfix"
                                    style="padding: 0px; border-bottom: 0;">
                                    <div id="listDiv" class="main-list"
                                        style="width: 100%;">
                                        <div
                                            style="width: 100%; float: left; margin: 1%;">
                                            <div class="main-class"
                                                style="width: 15%; float: left">
                                                <bean:write
                                                    name="postmessageBean"
                                                    property="class_name" />
                                            </div>
                                            <div class="main-title"
                                                style="width: 50%; float: left; margin-right: 15%; text-align: left">
                                                <a  style="display:block;width:800px;"
                                                    href="${pageContext.request.contextPath}/JNTCIEquipHomePage04BL.do?info_id=<bean:write name="postmessageBean" property="info_id" />&startIndex=<bean:write name='_JNTCIEquipHomePageForm' property='startIndex' />">
                                                    <bean:write
                                                        name="postmessageBean"
                                                        property="info_title" />
                                                </a>
                                            </div>

                                            <html:hidden property="startIndex" name="_JNTCIEquipHomePageForm"></html:hidden>

                                            <div class="main-username"
                                                style="width: 20%; float: left">
                                                <bean:write
                                                    name="postmessageBean"
                                                    property="user_name" />
                                            </div>
                                        </div>
                                        <div
                                            style="width: 100%; float: left; margin: 1%;">
                                            <div
                                                style="width: 15%; float: left;">
                                                <p></p>
                                            </div>
                                            <div class="main-info"
                                                style="width: 50%; margin-right: 15%; float: left; text-align: left; white-space: nowrap; overflow: hidden; text-overflow: ellipsis;">
                                                <bean:write
                                                    name="postmessageBean"
                                                    property="info_details" />
                                            </div>
                                            <div class="main-date"
                                                style="width: 20%; float: left">
                                                <bean:write
                                                    name="postmessageBean"
                                                    property="info_date" />
                                            </div>
                                        </div>
                                        <c:if
                                            test="${postmessageBean.tenpu_path ne null }">
                                            <div id="photoDiv"
                                                style="width: 120px; float: left; margin: 1%; margin-left: 15%">
                                                <div
                                                    style="border: 1px solid #E9E9E4; padding: 1px 1px 1px 1px;">
                                                    <html:hidden
                                                        name="postmessageBean"
                                                        property="tenpu_path" />
                                                    <img id="imghead01"
                                                        src="<bean:write name="postmessageBean" property="tenpu_path" />"
                                                        width="100"
                                                        height="110" />
                                                </div>
                                            </div>
                                        </c:if>
                                    </div>
                                </li>
                            </logic:iterate>
                        </ul>

                    </div>
                </logic:notEmpty>
                <input id="Submission" type="button"
                    class="btn btn-green" value="投稿"
                    style="float: right; margin-top: 73px;"
                    onclick="document.getElementById('light').style.display='block';document.getElementById('fade').style.display='block'" />
                <!-- 为空-->
                <logic:empty name="_JNTCIEquipHomePageForm"
                    property="postmessage">
                    <div class="topRec_List">
                        <p style="text-align: center;">☞
                            フォーラムはまだありません。^_^</p>
                    </div>
                </logic:empty>
            </div>

 <div class="pagination" ><span
                                style="width: 100%; font-size: 14; float: right">計<b>
                                        <html:hidden styleId="infoList"
                                            name="_JNTCIEquipHomePageForm"
                                            property="totalCount" /> <bean:write
                                            name="_JNTCIEquipHomePageForm"
                                            property="totalCount" />
                                </b>レコード数 <bean:write name="now" />／<bean:write
                                        name="total" /> <bean:write
                                        name="userListPageLinks"
                                        filter="false" /></span></div>
        </div>

        <div class="rightDiv fl">
            <h2>最新のお知らせ</h2>
            <logic:notEmpty name="_JNTCIEquipHomePageForm"
                property="noticeMg02">
                <div class="maquee">
                    <ul>
                        <logic:iterate id="noticeMgBean"
                            name="_JNTCIEquipHomePageForm"
                            property="noticeMg02">
                            <li style="padding: 5px"><a
                                href="${pageContext.request.contextPath}/JNTCIHomePage02BL.do?info_id=<bean:write name='noticeMgBean' property='info_id' />&startIndex=<bean:write name='_JNTCIEquipHomePageForm' property='startIndex' />&">
                                    <bean:write name="noticeMgBean"
                                        property="info_title" />
                            </a></li>
                        </logic:iterate>
                    </ul>
                </div>
            </logic:notEmpty>
            <logic:empty name="_JNTCIEquipHomePageForm"
                property="noticeMg02">
                <div class="maquee">
                    <ul>
                        <li style="padding: 5px">☞特にありません。^_^</li>
                    </ul>
                </div>
            </logic:empty>
        </div>
    </div>

    <div id="light" class="white_content">
        <a
            onclick="document.getElementById('light').style.display='none';document.getElementById('fade').style.display='none';document.getElementById('reset').click()"
            href="javascript:void(0)"> 閉じる</a>
        <div class="N_Fram">
            <ts:form action="/JNTCIEquipPostMessageBL" method="post"
                enctype="multipart/form-data">
                <ul>
					<div style="color: red; display: none" id="Errortitle">
                            <h3>以下のエラーが発生しました。</h3>
                            ●タイトルの長さ は超える.37字だけを保留する
                        </div>
                    <li><span>タイトル：</span> <html:text
                            property="info_title"
                            name="_JNTCIEquipHomePageForm" value=""
                            size="12px;" styleId="titlelength"  onkeydown="aa()" onkeyup="aa()" maxlength="38"/><font style="color:red"> *</font></li>
                    <li><span>種&emsp;類：</span> <html:select
                            style="background-color:#E8E8FF;"
                            property="view_id"
                            name="_JNTCIEquipHomePageForm">
                            <html:optionsCollection property="classList"
                                name="_JNTCIEquipHomePageForm"
                                label="class_name" value="view_id" />
                        </html:select></li>
                        <div style="color: red; display: none" id="Errorcontent">
                            <h3>以下のエラーが発生しました。</h3>
                            ●内容の長さ は超える.1900字だけを保留する
                        </div>
                    <li><span>内&emsp;容：</span> <html:textarea
                            name="_JNTCIEquipHomePageForm" value=""
                            property="info_details" styleId="contentlength"  onkeydown="bb()" onkeyup="bb()"  ></html:textarea><font style="color:red"> *</font></li>
                    <li>
                        <div id="preview"
                            style="margin-left: 17%; border: 1px solid; width: 200px;">
                            <img id="imghead" src="images/upload.jpg"
                                width="200" height="210" />
                        </div> <br /> <input type="file" name="uploadFile"
                        onchange="previewImage(this)"
                        accept="image/jpeg" id="photo"
                        style="display: none" />
                        <button type="button" class="btn1"
                            style="margin-top: 10px; margin-left: 17%; width: 110px"
                            id="photoUpload">選択画像</button>
                    </li>
                    <li style="text-align: center;"><input
                        type="submit" class="btn btn-blue" value="登録" />&emsp;&emsp;&emsp;
                        <input type="reset" id="reset"
                        class="btn btn-blue" value="リセット" /></li>
                </ul>
            </ts:form>
        </div>
    </div>
    <div id="fade" class="black_overlay"></div>
</body>
</html:html>