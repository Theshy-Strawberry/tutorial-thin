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
<title>設備申請一覧</title>
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
<style type="text/css">
table th {
    height: 20px;
    padding: 5px 0;
    border: 1px solid #E1E5EE;
    background-color: #E7F1FE;
}
</style>
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
                    <li><a href="#">設備申請一覧</a></li>
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
                <ts:form action="/JNTCIEquip03BL">
                    <div class="clearfix">
                        <table width="80%" class="fl">
                            <colgroup>

                                <col width="120px" />
                                <col width="105px" />
                                <col width="120px" />
                                <col width="105px" />
                                <col width="120px" />
                                <col width="100px" />
                                <col width="120px" />
                                <col width="120px" />
                                <col width="120px" />
                                <col width="120px" />
                            </colgroup>
                            <tr>
                                <th>申請部門名称：</th>
                                <td><html:select property="dept"
                                        name="_JNTCIEquip03Form">
                                        <html:optionsCollection
                                            property="deptname"
                                            label="APPLY_DEPT_NAME"
                                            value="APPLY_DEPT_ID" />
                                    </html:select></td>
                                <th>申請設備種類：</th>
                                <td><html:select property="type"
                                        name="_JNTCIEquip03Form">
                                        <html:optionsCollection
                                            property="equiptype"
                                            label="APPLY_SETSUBI_KUBEN"
                                            value="APPLY_SETSUBI_KUBEN_ID"
                                            style="" />
                                    </html:select></td>
                                <th>申請設備状態：</th>
                                <td><html:select property="state"
                                        name="_JNTCIEquip03Form">
                                        <html:optionsCollection
                                            property="equipstate"
                                            label="APPLY_STATE"
                                            value="APPLY_STATE_ID" />
                                    </html:select></td>
                                <th>申請者カード：</th>
                                <td><html:text
                                        property="cardnumber"
                                        name="_JNTCIEquip03Form"
                                        maxlength="4" size="12px;" /></td>
                                <th>申請者名前：</th>
                                <td><html:text property="name"
                                        name="_JNTCIEquip03Form"
                                        size="12px;" /></td>
                            </tr>
                        </table>
                        <html:errors />
                        <ts:submit property="button"
                            styleClass="fl btn btn-blue"
                            style="margin:5px 50px 0;">検索</ts:submit>
                    </div>

                </ts:form>

                <ts:pageLinks id="JNTCIEquip03ListPageLinks"
                    action="/JNTCIEquip03BL" name="_JNTCIEquip03Form"
                    rowProperty="row" totalProperty="totalCount"
                    indexProperty="startIndex" currentPageIndex="now"
                    totalPageCount="total" />
                <logic:notEmpty name="_JNTCIEquip03Form"
                    property="eqipApply">
                    <hr />
                    <table width="90%" class="ctn">
                        <caption>設備申請一覧</caption>
                        <tr>
                            <th>申請者カード</th>
                            <th>申請番号</th>
                            <th>申請部門名称</th>
                            <th>申請者</th>
                            <th>申請設備種類</th>
                            <th>申請設備番号</th>
                            <th>申請理由</th>
                            <th>申請設備状態</th>

                        </tr>
                        <logic:iterate id="euqipBean"
                            name="_JNTCIEquip03Form"
                            property="eqipApply">
                            <tr>
                                <td><bean:write name="euqipBean"
                                        property="apply_user_id" /></td>
                                <td><bean:write name="euqipBean"
                                        property="apply_no" /></td>
                                <td><bean:write name="euqipBean"
                                        property="apply_dept_name" /></td>
                                <td><bean:write name="euqipBean"
                                        property="apply_user_name" /></td>
                                <td><bean:write name="euqipBean"
                                        property="apply_setsubi_kuben" />
                                </td>
                                <td><bean:write name="euqipBean"
                                        property="apply_setsubi_no" />
                                </td>
                                <td><bean:write name="euqipBean"
                                        property="apply_reason" /></td>

                                <td><a
                                    href="${pageContext.request.contextPath}/JNTCIEquip0301BL.do?apply_no=<bean:write name="euqipBean" property="apply_no" />&apply_setsubi_kuben=<bean:write name="euqipBean"  property="apply_setsubi_kuben" />">
                                        <bean:write name="euqipBean"
                                            property="apply_state" />
                                </a></td>

                            </tr>
                        </logic:iterate>
                    </table>
                </logic:notEmpty>
                <div class="pagination">
                    <ul>
                        <li>計<b><bean:write
                                    name="_JNTCIEquip03Form"
                                    property="totalCount" /></b>レコード数
                        </li>
                        <li><bean:write name="now" />／<bean:write
                                name="total" /></li>
                        <li><bean:write
                                name="JNTCIEquip03ListPageLinks"
                                filter="false" /></li>
                    </ul>

                </div>
                <div class="footer">
                    <p>
                        連絡メール：<a href="mailto:jinan@trans-cosmos.com.cn"
                            target="_blank">jinan@trans-cosmos.com.cn</a>
                    </p>
                </div>
            </div>

        </div>
        <!--/右侧部分 -->
    </div>
</body>
</html:html>