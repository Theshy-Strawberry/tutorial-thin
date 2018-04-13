<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="/struts-html" prefix="html"%>
<%@ taglib uri="/struts-bean" prefix="bean"%>
<%@ taglib uri="/struts-logic" prefix="logic"%>
<%@ taglib uri="/terasoluna-struts" prefix="ts"%>
<%@ taglib uri="/terasoluna" prefix="t"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html:html>
<head>
<meta http-equiv="Content-Type" content="text/html;  charset=utf-8" />
<title>残業審査</title>
<link rel="stylesheet" type="text/css" href="css/base.css" />
<link rel="stylesheet" type="text/css" href="css/main.css" />
<link rel="stylesheet" type="text/css" href="Style/skin.css" />
<script type="text/javascript" src="js/laydate/laydate.js"></script>
<script type="text/javascript" src="js/laydate/manhuaDate.1.0.js"></script>
<script type="text/javascript" src="js/jquery-1.11.3.min.js"></script>
<script type="text/javascript" src="js/JNTCIOverTimeVerify.js"></script>
<script type="text/javascript">
	$('#left-container .content').hide();
	$('#Attendance').show();
	$('h2.tit').click(function(){
		$(this).next('.content').stop().slideToggle();
	})
</script>
<script type="text/javascript">
$(function(){
	var power = $("#flag").val();
	var userId = $("#userId").val();
	if (power == 2) {
		$("[name='select']").prop("disabled", true);
		$("[name='selectAll']").prop("disabled", true);
	}
	if (power == 0) {
		$("[name='select']").prop("disabled", true);
		$("[name='selectAll']").prop("disabled", true);
	}
	/* if (power == 1) {
		$("[name='select']").prop("disabled", true);
		$("[name='selectAll']").prop("disabled", true);
	} */
	/* if (userId == 1003) {
		$("[name='select']").prop("disabled", true);
		$("[name='selectAll']").prop("disabled", true);
	} */
	if (userId == 1002) {
		$("[name='select']").prop("disabled", true);
		$("[name='selectAll']").prop("disabled", true);
	}

	var user_id = '<bean:write property="user_id2" name="_JNTCIOverTimeVerify01Form"/>';
	var user_name = '<bean:write property="user_name2" name="_JNTCIOverTimeVerify01Form"/>';
	var dept_id = '<bean:write property="dept_id2" name="_JNTCIOverTimeVerify01Form"/>';
	var extra_starttime = '<bean:write property="extra_starttime1" name="_JNTCIOverTimeVerify01Form"/>';
	var extra_endtime= '<bean:write property="extra_endtime1" name="_JNTCIOverTimeVerify01Form"/>';
	var extra_auditss_search = '<bean:write property="extra_auditss_search" name="_JNTCIOverTimeVerify01Form"/>';

	$(".pagination li a").click(function(){
		$(this).attr("href",$(this).attr("href") + "&user_id2=" +
				user_id + "&user_name2=" + user_name+ "&dept_id2=" + dept_id + "&extra_starttime1=" +
				extra_starttime + "&extra_endtime1=" + extra_endtime + "&extra_auditss_search=" + extra_auditss_search);
	})
})

</script>
<script type="text/javascript">

$("form :input.required").each(function(){
    var $required = $("<strong class='high'> *</strong>"); //创建元素
    $(this).parent().append($required); //然后将它追加到文档中
});

</script>
<script type="text/javascript">
 $(function(){
	$("#submitButId").click(function(){
		/* $("#cod").val("reset"); */
		$("#selectlistId").val("");
	})
})
</script>
<script type="text/javascript">
function charecter(){
	$("#cod").val("reset");
}

</script>
<script type="text/javascript">
function onSubimitfun(type) {
    if (type == "1") {
    	$("#formid").attr('action',
                '/tutorial-thin/allowlist.do');
        $("#formid").submit();
    } else if (type == "2") {
    	$("#formid").attr('action',
        '/tutorial-thin/allowlist.do');
        $("#formid").submit();
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
    <div class="clearfix" style="position: relative;">
        <!--左侧部分 -->
        <div style="position: absolute;">
            <jsp:include page="/left.jsp" flush="true" />
            <input id="flag" type="hidden"
                value="<bean:write name="flag" scope="session" />" /> <input
                id="userId" type="hidden"
                value="<bean:write name="userId" scope="session" />" />
        </div>
        <!--/左侧部分 -->
        <!--右侧部分 -->
        <div class="rightWidht">
            <div class="header">
                <ul class="breadcrumbs clearfix">
                    <li>ステップチャート：</li>
                    <li><a href="#">勤務管理</a></li>
                    <li class="ico">&gt;</li>
                    <li><a href="#">残業審査</a></li>
                </ul>
            </div>
            <div class="main-ctn">
                <p style="color: red;">
                    <html:errors />
                    <html:messages id="message" message="true">
                        <bean:write name="message" />
                    </html:messages>
                </p>
                <ts:form action="/dispath"
                    styleId="formid">
                    <div class="clearfix">
                        <table class="tb-align table-bar fl">
                            <colgroup>
                                <col style="width: 120px;">
                                <col style="width: 150px;">
                                <col style="width: 120px;">
                                <col style="width: 150px;">
                                <col style="width: 120px;">
                                <col style="width: 160px;">
                            </colgroup>

                            <tr>
                                <th>社員カード：<input type="hidden"
                                    id="cod" name="cod" value="reset" /></th>
                                <td><html:text property="user_id2"
                                        styleId="facilityId"
                                        maxlength="4" /></td>
                                <th>社員名前：</th>
                                <td><html:text
                                        property="user_name2" maxlength="20" /></td>
                                <th>部門所属：</th>
                                <td><html:select
                                        name="_JNTCIOverTimeVerify01Form"
                                        property="dept_id2">
                                        <option value=""></option>
                                        <t:defineCodeList
                                            id="overTimeVerify" />
                                        <html:options
                                            collection="overTimeVerify"
                                            property="id"
                                            labelProperty="name" />
                                    </html:select></td>

                            </tr>
                            <tr>
                                <th>日付：</th>
                                <td colspan="3" class="input-time">
                                    <html:text
                                        property="extra_starttime1"
                                        styleId="extra_starttime"
                                        styleClass="inline laydate-icon"
                                        readonly="true" /> -
                                    <html:text property="extra_endtime1"
                                        styleId="extra_endtime"
                                        styleClass="inline laydate-icon"
                                        readonly="true" />
                                </td>
                                <th>審査状態：</th>
                                <td>
                                    <html:select
                                        name="_JNTCIOverTimeVerify01Form"
                                        property="extra_auditss_search">
                                        <html:option value=""></html:option>
                                        <t:defineCodeList
                                            id="overTimeVerify1" />
                                        <html:options
                                            collection="overTimeVerify1"
                                            property="id"
                                            labelProperty="name" />
                                    </html:select> <html:hidden
                                        property="extra_auditss_search" />
                                </td>
                            </tr>
                        </table>
                        <ts:submit value="検索" property="forward_search"
                            style="margin: 55px 40px 0px;"
                            styleClass="btn btn-blue fl" styleId="submitButId" />
                    </div>



                <ts:pageLinks id="userListPageLinks"
                    action="/JNTCIOverTimeVerifySCR00"
                    name="_JNTCIOverTimeVerify01Form" rowProperty="row"
                    totalProperty="totalCount"
                    indexProperty="startIndex" currentPageIndex="now"
                    totalPageCount="total" />
                <logic:notEmpty name="_JNTCIOverTimeVerify01Form"
                    property="users">
                    <hr />
                    <table class="ctn" width="90%">
                        <caption>残業審査一覧表</caption>
                        <tr>
                            <th style="width: 90px;">選択</th>
                            <th style="width: 110px;">残業カード</th>
                            <th style="width: 110px;">社員カード</th>
                            <th style="width: 120px">社員名前</th>
                            <th style="width: 150px">部門所属</th>
                            <th style="width: 110px">項目責任者</th>
                            <th style="width: 150px">項目名</th>
                            <th style="width: 160px">開始時間</th>
                            <th style="width: 160px">終了時間</th>
                            <th style="width: 110px">合計時長</th>
                            <th style="width: 110px">残業種類</th>
                            <th class="t1" style="width: 110px">審査結果</th>
                        </tr>
                        <logic:iterate id="userBean"
                            name="_JNTCIOverTimeVerify01Form"
                            property="users">
                            <tr>
                                <td><input type="checkbox"
                                    name="select" id="select" value='<bean:write
                                        name="userBean"
                                        property="extra_id"/>'/></td>
                                <td style="width: 100px"><bean:write
                                        name="userBean"
                                        property="extra_id" /></td>
                                <td style="width: 100px"><bean:write
                                        name="userBean"
                                        property="user_id" /></td>
                                <td style="width: 100px"><bean:write
                                        name="userBean"
                                        property="user_name" /></td>
                                <td style="width: 160px"><bean:write
                                        name="userBean"
                                        property="dept_id" /></td>
                                <td style="width: 100px"><bean:write
                                        name="userBean"
                                        property="leader" /></td>
                                <td style="width: 160px"><bean:write
                                        name="userBean"
                                        property="project" /></td>
                                <td style="width: 180px"><bean:write
                                        name="userBean"
                                        property="extra_starttime" /></td>
                                <td style="width: 180px"><bean:write
                                        name="userBean"
                                        property="extra_endtime" /></td>
                                <td style="width: 100px"><bean:write
                                        name="userBean"
                                        property="extra_time" /></td>
                                <td style="width: 120px"><bean:write
                                        name="userBean"
                                        property="extra_type" /></td>
                                <td class="t1" style="width: 100px"><a
                                    href="${pageContext.request.contextPath}/JNTCIOverTimeVerifyBL.do?extra_id=<bean:write name="userBean" property="extra_id" />
								&user_id2=<bean:write name="_JNTCIOverTimeVerify01Form" property="user_id2" />
								&user_name2=<bean:write name="_JNTCIOverTimeVerify01Form" property="user_name2" />
								&dept_id2=<bean:write name="_JNTCIOverTimeVerify01Form" property="dept_id2" />
								&extra_starttime1=<bean:write name="_JNTCIOverTimeVerify01Form" property="extra_starttime1" />
								&extra_endtime1=<bean:write name="_JNTCIOverTimeVerify01Form" property="extra_endtime1" />
								&extra_auditss_search=<bean:write name="_JNTCIOverTimeVerify01Form" property="extra_auditss_search" />
								&startIndex=<bean:write name="_JNTCIOverTimeVerify01Form" property="startIndex" />">
                                        <bean:write name="userBean"
                                            property="extra_auditss" />
                                </a></td>
                            </tr>
                        </logic:iterate>

                        <tfoot>
                            <tr>
                                <td><label style="width: auto">全て選択</label><input
                                    type="checkbox" name="selectAll"
                                    id="selectAll" title="全て選択" /></td>
                                <td><input type="button" value="削除"
                                    class="btn btn-red" id="delete_list"
                                    disabled="disabled" /></td>

                                <html:hidden property="extra_auditss1" name="_JNTCIOverTimeVerify01Form" styleId="allowstate"/>
                                <html:hidden property="selectlist" name="_JNTCIOverTimeVerify01Form" styleId="selectlistId"/>
                                <html:hidden property="startIndex" name="_JNTCIOverTimeVerify01Form"/>

                                <td><input type="button" value="一括承認" onclick="allowliststate(1);charecter();onSubimitfun(1)" class="btn btn-red" id="allowlist" /></td>
                                <td><input type="button" value="一括承認しない" onclick="allowliststate(2);charecter();onSubimitfun(2)" class="btn btn-red" id="unallowlist" style="margin-left: 20px"/></td>
                                <td colspan="11">
                                    <div class="pagination clearfix">
                                        <ul style="float: right;">
                                            <li>計<b><bean:write
                                                        name="_JNTCIOverTimeVerify01Form"
                                                        property="totalCount" /></b>レコード数
                                            </li>
                                            <li><bean:write
                                                    name="now" />／<bean:write
                                                    name="total" /></li>
                                            <li><bean:write
                                                    name="userListPageLinks"
                                                    filter="false" /></li>
                                        </ul>
                                    </div>
                                </td>
                            </tr>
                        </tfoot>
                    </table>
                </logic:notEmpty>
                <div class="footer">
                    <p>
                        連絡メール：<a href="mailto:jinan@trans-cosmos.com.cn"
                            target="_blank">jinan@trans-cosmos.com.cn</a>
                    </p>
                </div>
            </ts:form>
            </div>

        </div>
    </div>
    <script>
		!function() {
			laydate.skin('yahui');
			laydate({
				elem : '#demo'
			});
		}();

		//日期范围限制
		var start = {
			elem : '#extra_starttime',
			format : 'YYYY-MM-DD hh:mm',
			istime : true,
			istoday : false,
			choose : function(datas) {
				end.min = datas; //開始日を選択した後、終了日が再設定する。
				end.start = datas //終了日が開始日を設定する。
			}
		};

		var end = {
			elem : '#extra_endtime',
			format : 'YYYY-MM-DD hh:mm',
			istime : true,
			istoday : false,
			choose : function(datas) {
				start.max = datas;
			}
		};
		laydate(start);
		laydate(end);
	</script>
</body>
</html:html>

