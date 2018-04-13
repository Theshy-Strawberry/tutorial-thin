<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="/struts-html" prefix="html"%>
<%@ taglib uri="/struts-bean" prefix="bean"%>
<%@ taglib uri="/struts-logic" prefix="logic"%>
<%@ taglib uri="/terasoluna-struts" prefix="ts"%>
<%@ taglib uri="/terasoluna" prefix="t"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/base.css" />
<link rel="stylesheet" type="text/css" href="css/main.css" />
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/jquery-1.11.3.min.js"></script>
<script type="text/javascript" src="js/fixed_midashi_src.js"></script>
<script type="text/javascript" src="js/fixed_midashi.js"></script>
<script type="text/javascript" src="js/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript">
    $(function() {
        $('#left-container .content').hide();
        $('#Attendance').show();
        $('h2.tit').click(function() {
            $(this).next('.content').stop().slideToggle();
        })
    })
    $(function() {
        $("#importfile").click(function() {
            $("#file").click();
        });
    });
    function toDetail(value) {
    	doScroll();
        var id = value.id;
        var indexs = id.split('-');
        var index = indexs[1];
        var jncard = $("#jncardId-" + index).val();
        $("#userhdId").val(jncard);
        $("#detailId").click();
    }
    function fileChange(file) {
        var fn = document.getElementById('file').value;
        if (fn != null) {
            document.getElementById('fileName').value = fn
        }
    }
</script>
<script type="text/javascript">
function doScroll(){
    var form = document.forms[0];
    $('#scrollPosit').val($('#scroll').scrollTop());
}

function scrollback(){
    var form = document.forms[0];
    $('#scroll').scrollTop($('#scrollPosit').val());
}
</script>
<title>勤務照会</title>
</head>
<body onLoad="FixedMidashi.create();scrollback()">
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
                    <li><a href="#">勤務管理</a></li>
                    <li class="ico">&gt;</li>
                    <li><a href="#">勤務照会</a></li>
                </ul>
            </div>
            <div class="main-ctn">
                <p style="color: red;">
                    <html:errors />
                    <html:messages id="message" message="true">
                        <bean:write name="message" />
                    </html:messages>
                </p>
                <html:form action="/JNTCIQueryListDSP.do" method="POST"
                    enctype="MULTIPART/FORM-DATA" styleId="forid">
                        <div style="width: 100%;">
                        <div style="display: table-cell">
                            <table class="fl table-bar" align="center">
                                <colgroup>
                                    <col width="120px" />
                                    <col width="140px" />
                                    <col width="120px" />
                                    <col width="140px" />
                                    <col width="120px" />
                                    <col width="160px" />
                                    <col width="50px" />

                                </colgroup>
                                  <html:hidden property="scrollPosit" name="_JNTCIQueryForm" styleId="scrollPosit"/>
                                <tr>
                                    <th>社員カード:</th>
                                    <td><html:text size="5"
                                            property="user_id"
                                            name="_JNTCIQueryForm"
                                            styleId="userid" maxlength="4" /></td>
                                     <th>社員名前:</th>
                                    <td><html:text
                                            property="user_name"
                                            name="_JNTCIQueryForm"
                                            styleId="username" maxlength="20"/></td>
                                    <th>出勤年月：</th>
                                    <td><html:text property="ym"
                                            styleClass="Wdate"
                                            onclick="WdatePicker({dateFmt:'yyyy/MM'})" /></td>
                              </tr>
                            </table>
                            </div>
							<div style="display: table-cell">
								<ts:submit value="検索" property="forward_search"
									styleClass="btn btn-blue fl"  style="margin: 4px 10px 5px 5px;width:75px;height:28px" />

                  <logic:equal name="flag" scope="session"
                                value="0">
                        <span>     <html:text property="fileName" styleId="fileName"  name="_JNTCIQueryForm"  style="margin: 4px 10px 0px 5px;float:left ;width:150px" ></html:text></span>
                                <html:file property="file" value="FILE"   onchange="fileChange(this)"
                                    styleId="file" style="display: none" />

                                <input type="button" value="选择文件"
                                    class="btn btn-blue fl"
                                    style="margin: 4px 10px 0px 5px;width:75px;height:28px" id="importfile" />
                                <ts:submit value="开始导入"
                                  styleClass="btn btn-blue fl"
                                    property="forward_upload"
                                    style="margin: 4px 10px 0px 5px;width:75px;height:28px"/>
                                <ts:submit value="下载"
                                  styleClass="btn btn-blue fl"
                                    property="forward_download"
                                    style="margin: 4px 10px 0px 5px;width:75px;height:28px"/>
                            </logic:equal>
                            <logic:equal name="flag" scope="session"
                                value="2">
                        <span>     <html:text property="fileName" styleId="fileName"  name="_JNTCIQueryForm"  style="margin: 4px 10px 0px 5px;float:left ;width:150px" ></html:text></span>
                                <html:file property="file" value="FILE"   onchange="fileChange(this)"
                                    styleId="file" style="display: none" />

                                <input type="button" value="选择文件"
                                    class="btn btn-blue fl"
                                    style="margin: 4px 10px 0px 5px;width:75px;height:28px" id="importfile" />
                                <ts:submit value="开始导入"
                                  styleClass="btn btn-blue fl"
                                    property="forward_upload"
                                    style="margin: 4px 10px 0px 5px;width:75px;height:28px"/>
                                <ts:submit value="下载"
                                  styleClass="btn btn-blue fl"
                                    property="forward_download"
                                    style="margin: 4px 10px 0px 5px;width:75px;height:28px"/>
                            </logic:equal>
                            </div>
                        </div>

                    <p style="text-align: left; margin: 30px 0 0 0;">
                        <span>勤務照会</span> <span>合計<bean:write
                                name="_JNTCIQueryForm"
                                property="listsize" />人
                        </span>
                    </p>
                    <div class="scroll-y" id="scroll"
                        style="height: 600px; width: 100%">
                        <table class="ctn" _fixedhead="rows:1;">
                            <colgroup>
                                <col style="width: 3%;"></col>
                                <col style="width: 3%;"></col>
                                <col style="width: 3.5%;"></col>
                                <col style="width: 3.5%;"></col>
                                <col style="width: 3.4%;"></col>
                                <col style="width: 3.4%;"></col>
                                <col style="width: 3.4%;"></col>
                                <col style="width: 3.4%;"></col>
                                <col style="width: 3.4%;"></col>
                                <col style="width: 3.4%;"></col>
                                <col style="width: 3.4%;"></col>
                                <col style="width: 3.4%;"></col>
                                <col style="width: 3.4%;"></col>
                                <col style="width: 3.4%;"></col>
                                <col style="width: 3.4%;"></col>
                                <col style="width: 3.4%;"></col>
                                <col style="width: 3.4%;"></col>
                                <col style="width: 3.4%;"></col>
                                <col style="width: 3.4%;"></col>
                                <col style="width: 3.4%;"></col>
                                <col style="width: 3.4%;"></col>
                                <col style="width: 3.4%;"></col>
                                <col style="width: 3.4%;"></col>
                                <col style="width: 3.4%;"></col>
                                <col style="width: 3.4%;"></col>
                                <col style="width: 4.0%;"></col>
                                <col style="width: 4.0%;"></col>
                                <col style="width: 3.4%;"></col>
                            </colgroup>
                            <thead>
                                <tr>
                                    <th>済南<br>カード
                                    </th>
                                    <th>天津<br>カード
                                    </th>
                                    <th>名前</th>
                                    <th>部門</th>
                                    <th>実際出<br>勤日数
                                    </th>
                                    <th>应该出<br>勤日数
                                    </th>
                                    <th>総出勤<br>時間（/小時）
                                    </th>
                                    <th>遅刻/早退<br>時間合計
                                    </th>
                                    <th>平日残業<br>時間合計
                                    </th>
                                    <th>平日残<br>業日数（大于2.5)
                                    </th>
                                    <th>休日残業<br>時間合計
                                    </th>
                                    <th>残業日<br>数(大于5)
                                    </th>
                                    <th>祝日残業<br>時間合計
                                    </th>
                                    <th>出張<br>日数
                                    </th>
                                    <th>補カード<br>時間合計
                                    </th>
                                    <th>休暇時<br>間合計
                                    </th>
                                    <th>病気休暇<br>時間合計
                                    </th>
                                    <th>結婚休暇<br>時間合計
                                    </th>
                                    <th>葬儀休暇<br>時間合計
                                    </th>
                                    <th>妊娠健診<br>時間合計
                                    </th>
                                    <th>出産休暇<br>時間合計
                                    </th>
                                    <th>出产介护<br>時間合計
                                    </th>
                                    <th>授乳休暇<br>時間合計
                                    </th>
                                    <th>労働災害<br>時間合計
                                    </th>
                                    <th>欠勤時<br>間合計(天)
                                    </th>
                                    <th>年休相殺前<br>(除特殊假)
                                    </th>
                                    <th>年休相殺後<br>(除特殊假)
                                    </th>
                                    <th>異常<br>是否
                                    </th>
                                </tr>
                            </thead>
                            <tbody>
                                <logic:notEmpty name="_JNTCIQueryForm"
                                    property="tempList">
                                    <logic:iterate id="userBean"
                                        name="_JNTCIQueryForm"
                                        property="tempList"
                                        indexId="index">
                                        <tr>
                                            <td><bean:write
                                                    name="userBean"
                                                    property="jn_card" />
                                                <html:hidden
                                                    styleId="jncardId-${index}"
                                                    property="jn_card"
                                                    name="userBean"
                                                    indexed="true" /></td>
                                            <td><bean:write
                                                    name="userBean"
                                                    property="tj_card" /></td>
                                            <td><bean:write
                                                    name="userBean"
                                                    property="username" /></td>
                                            <td><bean:write
                                                    name="userBean"
                                                    property="kj_name" /></td>
                                            <td><bean:write
                                                    name="userBean"
                                                    property="actual_days" /></td>
                                            <td><bean:write
                                                    name="userBean"
                                                    property="day" /></td>
                                            <td><bean:write
                                                    name="userBean"
                                                    property="count" /></td>
                                            <td><bean:write
                                                    name="userBean"
                                                    property="absence" /></td>
                                            <td><bean:write
                                                    name="userBean"
                                                    property="extra_time" /></td>
                                            <td><bean:write
                                                    name="userBean"
                                                    property="extra_time_count" /></td>
                                            <td><bean:write
                                                    name="userBean"
                                                    property="week_extra_time" /></td>
                                            <td><bean:write
                                                    name="userBean"
                                                    property="week_extra_time_count" />
                                            </td>
                                            <td><bean:write
                                                    name="userBean"
                                                    property="hld_extra_time" /></td>
                                            <td><bean:write
                                                    name="userBean"
                                                    property="evection_count" /></td>
                                            <td><bean:write
                                                    name="userBean"
                                                    property="kojyo_time" /></td>
                                            <td><bean:write
                                                    name="userBean"
                                                    property="leave_count1" /></td>
                                            <td><bean:write
                                                    name="userBean"
                                                    property="leave_count2" /></td>
                                            <td><bean:write
                                                    name="userBean"
                                                    property="leave_count3" /></td>
                                            <td><bean:write
                                                    name="userBean"
                                                    property="leave_count4" /></td>
                                            <td><bean:write
                                                    name="userBean"
                                                    property="leave_count5" /></td>
                                            <td><bean:write
                                                    name="userBean"
                                                    property="leave_count6" /></td>
                                            <td><bean:write
                                                    name="userBean"
                                                    property="leave_count7" /></td>
                                            <td><bean:write
                                                    name="userBean"
                                                    property="leave_count8" /></td>
                                            <td><bean:write
                                                    name="userBean"
                                                    property="leave_count9" /></td>
                                            <td><bean:write
                                                    name="userBean"
                                                    property="hangover" /></td>
                                            <td><bean:write
                                                    name="userBean"
                                                    property="overcountbf" /></td>
                                            <td><bean:write
                                                    name="userBean"
                                                    property="overcountaf" /></td>
                                            <td>
                                            <c:if
                                                    test="${userBean.ijyou_flag == '1'}">
                                                    <html:button
                                                        styleId="detailId-${index}"
                                                        value="异常"
                                                        property="forward_detail"
                                                        styleClass="btn btn-red"
                                                        onclick="toDetail(this)" />
                                                </c:if> <c:if
                                                    test="${userBean.ijyou_flag == '0'}">
                                                    <html:button
                                                        styleId="detailId-${index}"
                                                        value="正常"
                                                        property="forward_detail"
                                                        styleClass="btn btn-blue"
                                                        onclick="toDetail(this)" />
                                                </c:if></td>
                                        </tr>
                                    </logic:iterate>
                                </logic:notEmpty>
                                <html:hidden property="user_Id"
                                    styleId="userhdId" />
                                <ts:submit styleId="detailId" value="正常"
                                    style="display:none"
                                    property="forward_detail" />
                            </tbody>
                        </table>
                    </div>
                    <div class="footer">
		                <p>
		                    意見反馈メール：<a href="mailto:jinan@trans-cosmos.com.cn"
		                        target="_blank">jinan@trans-cosmos.com.cn</a>
		                </p>
		            </div>
                </html:form>
            </div>
        </div>
    </div>

</body>
</html>