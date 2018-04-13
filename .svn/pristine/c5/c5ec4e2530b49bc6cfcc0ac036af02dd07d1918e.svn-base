<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="/struts-html" prefix="html"%>
<%@ taglib uri="/struts-bean" prefix="bean"%>
<%@ taglib uri="/struts-logic" prefix="logic"%>
<%@ taglib uri="/terasoluna-struts" prefix="ts"%>
<%@ taglib uri="/terasoluna" prefix="t"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html:html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>設備修理一覧</title>
<link rel="stylesheet" type="text/css" href="css/base.css" />
<link rel="stylesheet" type="text/css" href="css/main.css" />
<script type="text/javascript" src="js/jquery-1.11.3.min.js"></script>
<script type="text/javascript">
    $(function() {
        $('#left-container .content').hide();
        $('#Equip').show();
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
                    <li><a href="#">設備管理</a></li>
                    <li class="ico">&gt;</li>
                    <li><a href="#">設備修理一覧</a></li>
                </ul>
            </div>

            <div class="main-ctn"
                style="max-height: 100px; overflow: auto;">
                <html:errors />
                <html:messages id="message" message="true">
                    <bean:write name="message" />
                </html:messages>
            </div>

            <div class="main-ctn">
                <ts:form action="/JNTCIEquip05BL"
                    onsubmit="return validateRegist(this);">
                    <div class="clearfix">
                        <table class="fl table-bar">
                            <colgroup>
                                <col width="120px" />
                                <col width="150px" />
                                <col width="120px" />

                                <col width="145px" />
                                <col width="120px" />
                                <col width="145px" />

                            </colgroup>
                            <tr>
                                <th><label>申請部門名称：</label></th>
                                <td><html:select
                                        property="APPLY_REPAIR_DEPT_NAME"
                                        name="_JNTCIEquip05Form">
                                        <html:optionsCollection
                                            property="deptNames"
                                            label="APPLY_REPAIR_DEPT_NAME"
                                            value="APPLY_REPAIR_DEPT_ID" />
                                    </html:select></td>
                                <th><label>申請修理者ID：</label></th>
                                <td><html:text
                                        name="_JNTCIEquip05Form"
                                        property="APPLY_REPAIR_USER_ID"
                                        maxlength="4"></html:text></td>
                                <th><label>修理設備ID：</label></th>
                                <td><html:text
                                        property="APPLY_REPAIR_SETSUBI_NO"
                                        name="_JNTCIEquip05Form"
                                        maxlength="20"></html:text></td>
                            </tr>
                        </table>
                        <ts:submit styleClass="fl btn btn-blue"
                            style="margin:5px 50px 0;" value="検索"
                            property="forward_list"></ts:submit>
                    </div>
                    <logic:notEmpty name="_JNTCIEquip05Form"
                        property="list">
                        <ts:pageLinks id="JNTCIEquip05ListPageLinks"
                            action="/JNTCIEquip05BL"
                            name="_JNTCIEquip05Form" rowProperty="row"
                            totalProperty="totalCount"
                            indexProperty="startIndex"
                            currentPageIndex="now"
                            totalPageCount="total" />
                        <hr />
                        <table class="ctn" width="90%">
                            <caption>設備修理一覧</caption>
                            <tr>
                                <th>&nbsp;</th>
                                <th>申請修理番号</th>
                                <th>申請部門ID</th>
                                <th>申請部門名称</th>
                                <th>申請修理者ID</th>
                                <th>申請修理者</th>
                                <th>修理設備の種類</th>
                                <th>修理設備番号</th>
                                <th>修理状態</th>
                                <th width="12%">修理時間</th>
                                <th>修理理由</th>
                            </tr>
                            <logic:iterate id="listBean"
                                name="_JNTCIEquip05Form" property="list">

                                <tr align="center" class="d">
                                    <td><html:button
                                            property="button"
                                            styleClass="btn btn-green">検索</html:button>
                                    </td>
                                    <td><bean:write name="listBean"
                                            property="APPLY_REPAIR_NO" />
                                    </td>
                                    <td><bean:write name="listBean"
                                            property="APPLY_REPAIR_DEPT_ID" />
                                    </td>
                                    <td><bean:write name="listBean"
                                            property="APPLY_REPAIR_DEPT_NAME" />
                                    </td>
                                    <td align="center"><bean:write
                                            name="listBean"
                                            property="APPLY_REPAIR_USER_ID" />
                                    </td>
                                    <td align="center"><bean:write
                                            name="listBean"
                                            property="APPLY_REPAIR_USER_NAME" />
                                    </td>
                                    <td align="center"><bean:write
                                            name="listBean"
                                            property="APPLY_REPAIR_SETSUBI_KUBEN" />
                                    </td>
                                    <td align="center"><bean:write
                                            name="listBean"
                                            property="APPLY_REPAIR_SETSUBI_NO" />
                                    </td>
                                    <td align="center"><bean:write
                                            name="listBean"
                                            property="APPLY_REPAIR_STATE" />
                                    </td>
                                    <td align="center"><bean:write
                                            name="listBean"
                                            property="TOROKU_TIMESTAMP" />
                                    </td>
                                    <td align="center"><bean:write
                                            name="listBean"
                                            property="APPLY_REPAIR_REASON" />
                                    </td>
                                </tr>
                            </logic:iterate>


                        </table>

                        <div class="pagination">
                            <ul>
                                <li>計<b><bean:write
                                            name="_JNTCIEquip05Form"
                                            property="totalCount" /></b>レコード数
                                </li>
                                <li><bean:write name="now" />／<bean:write
                                        name="total" /></li>
                                <li><bean:write
                                        name="JNTCIEquip05ListPageLinks"
                                        filter="false" /></li>
                            </ul>
                        </div>
                    </logic:notEmpty>
                </ts:form>

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
</html:html>

