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
<title>トップページ</title>
<link rel="stylesheet" type="text/css" href="css/base.css" />
<link rel="stylesheet" type="text/css" href="css/main.css" />
<link rel="stylesheet" type="text/css" href="css/page02.css" />
<script src ="webapps/js/jquery.min.js" ></script>
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
    //削除バターン
    $(function() {
        $("#fileDelete").click(function() {
            $("#fileName").val(null);
            $("#uploadFile").val(null);
        })
    })
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
    //(删除更改按钮)管理员显示可用
    function load() {
        var flag = document.getElementById("flag").value;
        if (flag != 0 && flag != 1 && flag != 2 && flag != 5) {
            $('#deletedip').hide();
            $('#updatedip').hide();
        }
    }
</script>

</head>
<body onload="load();">
    <!--/头部分 -->
    <div>
        <jsp:include page="/top.jsp" flush="true" />
    </div>
    <!--左侧部分 -->
    <div style="position: relative;" class="top-page">
        <div style="position: absolute;">
            <jsp:include page="/left.jsp" flush="true" />
        </div>
    </div>
    <!--/左侧部分 -->

    <div id="main1">
        <div style="margin-left: 15%">
            <div
                style="max-height: 100px; overflow: auto; width: 500px; margin-left: 40px;">
                <html:errors />
                <h3>
                    <html:messages id="message" message="true">
                        <bean:write name="message" />
                    </html:messages>
                </h3>
            </div>
        </div>
        <div id="main-top">

            <div id="main-titr">
                <bean:write name="_JNTCIHomePage02Form"
                    property="info_title" />

            </div>

            <div id="main-left" style="font-size:0; text-align: right;">
                <logic:equal name="flag" scope="session" value="0">
                    <span id="deletedip"
                        onclick="return confirm('削除しますか?')"><a
                        href="${pageContext.request.contextPath}/JNTCIHomePageDelete02BL.do?info_id=<bean:write name='_JNTCIHomePage02Form' property='info_id'/>&startIndex=<bean:write name='_JNTCIHomePage02Form' property='startIndex' />">削除</a></span>
                    <span id="updatedip"> <a href="#"
                        onclick="document.getElementById('light').style.display='block';document.getElementById('fade').style.display='block'">
                            改修 </a></span>
                </logic:equal>
                <logic:equal name="flag" scope="session" value="1">
                    <span id="deletedip"
                        onclick="return confirm('削除しますか?')"><a
                        href="${pageContext.request.contextPath}/JNTCIHomePageDelete02BL.do?info_id=<bean:write name='_JNTCIHomePage02Form' property='info_id'/>&startIndex=<bean:write name='_JNTCIHomePage02Form' property='startIndex' />">削除</a></span>
                    <span id="updatedip"> <a href="#"
                        onclick="document.getElementById('light').style.display='block';document.getElementById('fade').style.display='block'">
                            改修 </a></span>
                </logic:equal>
                <logic:equal name="flag" scope="session" value="2">
                    <span id="deletedip"
                        onclick="return confirm('削除しますか?')"><a
                        href="${pageContext.request.contextPath}/JNTCIHomePageDelete02BL.do?info_id=<bean:write name='_JNTCIHomePage02Form' property='info_id'/>&startIndex=<bean:write name='_JNTCIHomePage02Form' property='startIndex' />">削除</a></span>
                    <span id="updatedip"> <a href="#"
                        onclick="document.getElementById('light').style.display='block';document.getElementById('fade').style.display='block'">
                            改修 </a></span>
                </logic:equal>
                <logic:equal name="flag" scope="session" value="5">
                    <span id="deletedip"
                        onclick="return confirm('削除しますか?')"><a
                        href="${pageContext.request.contextPath}/JNTCIHomePageDelete02BL.do?info_id=<bean:write name='_JNTCIHomePage02Form' property='info_id'/>&startIndex=<bean:write name='_JNTCIHomePage02Form' property='startIndex' />">削除</a></span>
                    <span id="updatedip"> <a href="#"
                        onclick="document.getElementById('light').style.display='block';document.getElementById('fade').style.display='block'">
                            改修 </a></span>
                </logic:equal>
                <a onclick="javascript:history.back(-1);"
                    href="${pageContext.request.contextPath}/JNTCIEquipHomePageBL.do?startIndex=<bean:write name='_JNTCIHomePage02Form' property='startIndex'/>" style="padding: 3px 5px;">戻る>>
                   <html:hidden property="startIndex" name="_JNTCIHomePage02Form"></html:hidden>
                    </a>
            </div>
        </div>
        <div id="main-con" style="height: 50%; word-wrap: break-word;">
            <bean:write name="_JNTCIHomePage02Form"
                property="info_details" />
        </div>
        <div id="yejiao">
            <logic:notEmpty name="_JNTCIHomePage02Form"
                property="tenpu_path">
                <div id="al">
                    <span>添付ファイルダウンロード：</span> <a
                        href="${pageContext.request.contextPath}/NoticeFileDown.do?info_id=<bean:write name='_JNTCIHomePage02Form' property='info_id'/>">
                        <bean:write name='_JNTCIHomePage02Form'
                            property='tenpu_path' />
                    </a>
                </div>
            </logic:notEmpty>

            <div id="ar">
                <%-- <p>管理部</p>--%>
                <p>
                    <bean:write name="_JNTCIHomePage02Form"
                        property="user_name" />
                </p>
                <p>
                    <bean:write name="_JNTCIHomePage02Form"
                        property="info_date" />
                </p>

            </div>
        </div>

    </div>

    <!-- 20160905-改修画面 Start -->
    <div id="light" class="white_content">
        <a id="close"
            onclick="document.getElementById('reset').click();  document.getElementById('light').style.display='none';document.getElementById('fade').style.display='none'"
            href="javascript:void(0)"> 閉じる</a>
        <div class="N_Fram">
            <!--20160907-JNTCIHomePageUpdate02BL -->
            <ts:form action="/JNTCIHomePageUpdate02BL"
                enctype="multipart/form-data" method="post">
                <ul>
                    <li><span style="width: 110px">&emsp;&emsp;タイトル:</span>
                        <html:hidden name="_JNTCIHomePage02Form"
                            property="info_id" /> <html:text
                            name="_JNTCIHomePage02Form"
                            property="info_title" size="12px;"
                            style="text-align:center;" maxlength="10" /></li>
                    <li><span style="width: 110px">&emsp;&emsp;内&emsp;&emsp;容:</span>
                        <html:textarea name="_JNTCIHomePage02Form"
                            property="info_details">
                        </html:textarea></li>
                    <li><span style="width: 110px">添付ファイル:</span> <html:hidden
                            property="tenpu_path"
                            name="_JNTCIHomePage02Form" /> <input
                        type="text" id="fileName" name="fileNameJsp"
                        value="<bean:write name='_JNTCIHomePage02Form' property='tenpu_path'/>"
                        size="12px;" readonly="readonly" /> <input
                        type="file" name="uploadFile" id="uploadFile"
                        style="display: none"
                        onchange="fileChange(this)" />
                        <button type="button" class="btn btn-blue"
                            style="width: 100px" id="uploadFileBt">参照</button>
                        <input type="button" class="btn btn-blue"
                        id="fileDelete" value="削 除 " /></li>
                    <li style="text-align: center;">
                    <input
                        type="submit" class="btn btn-blue" value="登 録 "
                        onclick="return confirm('修正しますか?')" />&emsp;&emsp;&emsp;<html:hidden property="startIndex" name="_JNTCIHomePage02Form"></html:hidden>
                        <input type="reset" class="btn btn-blue" id="reset"
                        value="リセット" /></li>
                </ul>
            </ts:form>
        </div>
    </div>
    <!-- 20160905-改修画面 End -->
</body>
</html:html>