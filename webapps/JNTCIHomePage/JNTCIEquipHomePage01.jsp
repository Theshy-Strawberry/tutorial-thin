

<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="/struts-html" prefix="html"%>
<%@ taglib uri="/struts-bean" prefix="bean"%>
<%@ taglib uri="/struts-logic" prefix="logic"%>
<%@ taglib uri="/terasoluna-struts" prefix="ts"%>
<%@ taglib uri="/terasoluna" prefix="t"%>

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
<title>トップページ</title>
<script type="text/javascript">

    function fileChange(file) {
        var fn = document.getElementById('uploadFile').value;
        if (fn != null) {
            document.getElementById('fileName').value = fn
        }
    }
    $(function() {
        $("#uploadFileBt").click(function() {
            $("#uploadFile").click();
        })
    })
    //totalCount==0時
    $(document).ready(function() {
        var isNull = $("#noticeList").val();
        if (isNull == 0) {
            $("#pagination").hide();
        }
    })
</script>
</head>
<body>
    <!-- ===頭部分=== -->
    <div>
        <jsp:include page="/top.jsp" flush="true" />
    </div>
    <div style="position: relative;" class="top-page">
        <!-- ===左側メニュー部分=== -->
        <div style="position: absolute;">
            <jsp:include page="/left.jsp" flush="true" />
        </div>
        <div class="clearfix"
            style="padding: 2em 3%; margin-left: 190px;">
            <!-- ===発表後情報表示 === -->
            <div
                style="max-height: 100px; overflow: auto; width: 500px; margin-left: 40px;">
                <html:errors />
                <h3>
                    <html:messages id="message" message="true">
                        <bean:write name="message" />
                    </html:messages>
                </h3>
            </div>
            <div class="homepageDiv fl">
                <!-- ===お知らせ一覧表示 === -->
                <div class="">
                    <div id="tabs" class="pos">
                        <div id="tab-top">
                            <ul>
                                <li class="on"><a href="#">お知らせ</a></li>
                                <li><ts:link
                                        action="/JNTCIEquipHomePage03BL.do">フォーラム</ts:link></li>
                            </ul>
                        </div>

                        <div class="tab-content">
                            <!-- === ページング処理 === -->
                            <ts:pageLinks id="userListPageLinks"
                                action="/JNTCIEquipHomePageBL"
                                name="_JNTCIEquipHomePageForm"
                                rowProperty="row"
                                totalProperty="totalCount"
                                indexProperty="startIndex"
                                currentPageIndex="now"
                                totalPageCount="total" />
                            <logic:notEmpty
                                name="_JNTCIEquipHomePageForm"
                                property="noticeMg">
                                <div class="topRec_List1">
                                    <div class="content1"
                                        style="display: hidden;">
                                        <a title="戻る"
                                            href="javascript:;">戻る »</a>
                                    </div>
                                    <dl>
                                        <dd>タイトル</dd>
                                        <dd>内容</dd>
                                        <dd>時間</dd>
                                        <dd>名前</dd>
                                    </dl>
                                    <div>
                                        <ul>
                                            <logic:iterate
                                                id="noticeMgBean"
                                                name="_JNTCIEquipHomePageForm"
                                                property="noticeMg">
                                                <li class="clearfix"
                                                    style="line-height: 50px;">
                                                    <div  style="white-space: nowrap; text-overflow: ellipsis; overflow: hidden;">
                                                        <a   href="${pageContext.request.contextPath}/JNTCIHomePage02BL.do?info_id=<bean:write name='noticeMgBean' property='info_id' />&startIndex=<bean:write name='_JNTCIEquipHomePageForm' property='startIndex' />"
                                                            title="タイトル"
                                                        >
                                                            <bean:write
                                                                name="noticeMgBean"
                                                                property="info_title" />
                                                        </a>
                                                    </div>
                                                    <html:hidden property="startIndex" name="_JNTCIEquipHomePageForm"></html:hidden>

                                                    <div
                                                        style="white-space: nowrap; text-overflow: ellipsis; overflow: hidden;">
                                                        <bean:write
                                                            name="noticeMgBean"
                                                            property="info_details" />
                                                    </div>
                                                    <div>
                                                        <bean:write
                                                            name="noticeMgBean"
                                                            property="info_date" />
                                                    </div>
                                                    <div>
                                                        <bean:write
                                                            name="noticeMgBean"
                                                            property="user_name" />
                                                    </div>
                                                </li>
                                            </logic:iterate>
                                        </ul>
                                    </div>
                                </div>
                            </logic:notEmpty>
                            <logic:empty name="_JNTCIEquipHomePageForm"
                                property="noticeMg">
                                <div class="topRec_List">
                                    <p style="text-align: center;">☞
                                        お知らせはまだありません。^_^</p>
                                </div>
                            </logic:empty>
                        </div>
                    </div>
                </div>
                <!-- === ページング処理 === -->
                <div id="pagination" class="pagination"
                   >
                    計<b><html:hidden styleId="noticeList"
                            name="_JNTCIEquipHomePageForm"
                            property="totalCount" /> <bean:write
                            name="_JNTCIEquipHomePageForm"
                            property="totalCount" /></b>レコード数
                    <bean:write name="now" />
                    ／
                    <bean:write name="total" />
                    <bean:write name="userListPageLinks" filter="false" />
                </div>
                <logic:equal value="0" name="flag" scope="session" >
                <input id="Submission" type="button"
                    class="btn btn-green" value="投稿"
                    style="float: right; margin-top: 30px;"
                    onclick="document.getElementById('light').style.display='block';document.getElementById('fade').style.display='block';document.getElementById('reset').click()" />
            </logic:equal>
             <logic:equal value="1" name="flag" scope="session" >
                <input id="Submission" type="button"
                    class="btn btn-green" value="投稿"
                    style="float: right; margin-top: 30px;"
                    onclick="document.getElementById('light').style.display='block';document.getElementById('fade').style.display='block';document.getElementById('reset').click()" />
            </logic:equal>
             <logic:equal value="2" name="flag" scope="session" >
                <input id="Submission" type="button"
                    class="btn btn-green" value="投稿"
                    style="float: right; margin-top: 30px;"
                    onclick="document.getElementById('light').style.display='block';document.getElementById('fade').style.display='block';document.getElementById('reset').click()" />
            </logic:equal>
             <logic:equal value="5" name="flag" scope="session" >
                <input id="Submission" type="button"
                    class="btn btn-green" value="投稿"
                    style="float: right; margin-top: 30px;"
                    onclick="document.getElementById('light').style.display='block';document.getElementById('fade').style.display='block';document.getElementById('reset').click()" />
            </logic:equal>
            </div>
            <!-- === 右側最新のお知らせ部分=== -->
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
                                    href="${pageContext.request.contextPath}/JNTCIHomePage02BL.do?info_id=<bean:write name='noticeMgBean' property='info_id' />&startIndex=<bean:write name='_JNTCIEquipHomePageForm' property='startIndex' />">
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
                            <li style="padding: 5px">☞ 特にありません。^_^
                            </li>
                        </ul>
                    </div>
                </logic:empty>
            </div>
        </div>
    </div>
    <!-- === お知らせを発布する部分=== -->
    <div id="light" class="white_content">
        <a
            onclick="document.getElementById('light').style.display='none';document.getElementById('fade').style.display='none'"
            href="javascript:void(0)"> 閉じる </a>
        <div class="N_Fram">
            <ts:form action="/JNTCIEquipPostMessage02BL.do"
                enctype="multipart/form-data" method="post">
                <ul class="N_Fram_ul">
                    <li><span>タイトル:</span> <html:text value=""
                            property="info_caption"
                            name="_JNTCIEquipHomePageForm" size="12px;" />
                    <font style="color:red"> *</font></li>
                    <li><span>内&emsp;&emsp;容:</span> <html:textarea
                            value="" name="_JNTCIEquipHomePageForm"
                            property="info_content"></html:textarea><font style="color:red"> *</font></li>
                    <li><span>添付ファイル:</span> <input type="text"
                        id="fileName" size="12px;" readonly="readonly" />
                        <input type="file" name="uploadFile"
                        id="uploadFile" value="" style="display: none"
                        onchange="fileChange(this)" />
                        <button type="button" class="btn btn-blue"
                            style="width: 100px" id="uploadFileBt">参照</button>
                    </li>
                    <li style="text-align: center;"><input
                        class="btn btn-blue" type="submit" value="登録" />&emsp;&emsp;&emsp;&emsp;&emsp;
                        <input class="btn btn-blue" id="reset"
                        type="reset" value="リセット" /></li>
                </ul>
            </ts:form>
        </div>
    </div>
    <div id="fade" class="black_overlay"></div>
</body>
</html:html>


