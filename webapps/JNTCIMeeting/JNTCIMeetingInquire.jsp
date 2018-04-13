<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="/struts-html" prefix="html"%>
<%@ taglib uri="/struts-bean" prefix="bean"%>
<%@ taglib uri="/struts-logic" prefix="logic"%>
<%@ taglib uri="/terasoluna-struts" prefix="ts"%>
<%@ taglib uri="/terasoluna" prefix="t"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>会議室状態照会</title>
<link rel="stylesheet" type="text/css" href="css/base.css" />
<link rel="stylesheet" type="text/css" href="css/main.css" />
<script type="text/javascript" src="js/laydate/laydate.js"></script>
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
<script type="text/javascript">
    $(function() {

        $("input[name='delete']").on(
                "click",
                function() {
                    if (confirm("削除したら、復元することができません。本当に削除しますか？")) {
                        var room_no = $.trim($(this).parent().parent()
                                .children(":eq(0)").text());
                        var start_time = $.trim($(this).parent().parent()
                                .children("input[name='start_time']").val());

                        $.ajax({
                            cache : true,
                            type : "POST",
                            url : '/tutorial-thin/deleteMTRremark.do',
                            data : {
                                'room_no' : room_no,
                                'start_time' : start_time
                            },
                            async : false,
                            error : function(request) {
                                alert("削除が失敗しました！");
                                location.reload();
                            },
                            success : function(data) {
                                alert("削除が成功しました！");
                                location = location;
                            }
                        });
                    }
                });
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
                    <li><a href="#">会議室管理</a></li>
                    <li class="ico">&gt;</li>
                    <li><a href="#">会議室状態照会</a></li>
                </ul>
            </div>
            <div class="main-ctn"
                style="max-height: 100px; overflow: auto; color: red">
                <html:errors />
                <html:messages id="message" message="true">
                    <bean:write name="message" />
                </html:messages>
            </div>
            <div class="main-ctn">

                <ts:form action="/searchMTR?startIndex=0"
                    styleId="selectForm">
                    <div class="clearfix">
                        <table class="fl table-bar">
                            <colgroup>
                                <col width="120px" />
                                <col width="150px" />
                                <col width="120px" />
                                <col width="150px" />
                                <col width="120px" />
                                <col width="450px" />
                            </colgroup>
                            <tr>
                                <th>申請者カード：</th>
                                <td><html:text
                                        name="_JNTCIMeetingInquireForm"
                                        property="jn_card_serch" maxlength="4" /></td>
                                <th>会議室名称：</th>
                                <td><t:defineCodeList
                                        id="roomNoCodeList" /> <html:select
                                        name="_JNTCIMeetingInquireForm"
                                        property="room_no_serch"
                                        style="width:145px;">
                                        <html:options
                                            collection="roomNoCodeList"
                                            property="id"
                                            labelProperty="name" />
                                    </html:select></td>
                                <th>会議時間：</th>
                                <td class="input-time"><html:text
                                        name="_JNTCIMeetingInquireForm"
                                        styleId="startDateTime"
                                        styleClass="inline laydate-icon"
                                        property="start_time_serch"
                                        readonly="true" /> - <html:text
                                        name="_JNTCIMeetingInquireForm"
                                        styleId="endDateTime"
                                        styleClass="inline laydate-icon"
                                        property="end_time_serch"
                                        readonly="true" /></td>
                            </tr>
                        </table>
                        <input class="fl btn btn-blue"
                            style="margin: 5px 50px 0;" type="submit"
                            value="検索" />
                    </div>
                </ts:form>
                <logic:notEmpty name="_JNTCIMeetingInquireForm"
                    property="mtrRemarks">
                    <hr style="margin:15px 0 5px 0"/>
                    <table class="ctn" width="90%">
                        <caption>会議申請記録一覧表</caption>
                        <tr>
                            <th>会議室番号</th>
                            <th>会議室名称</th>
                            <th>申請者カード</th>
                            <th>申請者名前</th>
                            <th>使用時間（自）</th>
                            <th>使用時間（至）</th>
                            <th>申請理由</th>
                            <th>申請時間</th>
                            <th>操作</th>
                        </tr>

                        <logic:iterate id="remark"
                            name="_JNTCIMeetingInquireForm"
                            property="mtrRemarks">
                            <tr>
                                <td><bean:write name="remark"
                                        property="room_no" /></td>
                                <td><bean:write name="remark"
                                        property="room_name" /></td>
                                <td><bean:write name="remark"
                                        property="jn_card" /></td>
                                <td><bean:write name="remark"
                                        property="username" /></td>
                                <td><bean:write name="remark"
                                        property="start_time_show" /></td>
                                <td><bean:write name="remark"
                                        property="end_time" /></td>
                                <td><bean:write name="remark"
                                        property="remark" /></td>
                                <td><bean:write name="remark"
                                        property="apply_time" /></td>
                                <html:hidden name="remark"
                                    property="start_time" />
                                <td><input class="btn btn-green"
                                    type="button" value="取消"
                                    ${(remark.disabledflag and remark.jn_card == sessionScope.userId) ? "" : "disabled='disabled'"}
                                    name="delete" /></td>
                            </tr>
                        </logic:iterate>
                    </table>
                    <ts:pageLinks id="userListPageLinks" action="/searchMTR?jn_card_serch=${_JNTCIMeetingInquireForm.jn_card_serch }&room_no_serch=${_JNTCIMeetingInquireForm.room_no_serch }&
		start_time_serch=${_JNTCIMeetingInquireForm.start_time_serch }&end_time_serch=${_JNTCIMeetingInquireForm.end_time_serch }"
		name="_JNTCIMeetingInquireForm" rowProperty="row" totalProperty="totalCount"
		indexProperty="startIndex" currentPageIndex="now"
		totalPageCount="total" />
                    <div class="pagination">
                        <ul>
                            <li>計<b><bean:write
                                        name="_JNTCIMeetingInquireForm"
                                        property="totalCount" /></b>レコード数
                            </li>
                            <li><bean:write name="now" />／<bean:write
                                    name="total" /></li>
                            <li><bean:write
                                    name="userListPageLinks"
                                    filter="false" /></li>
                        </ul>
                    </div>
                </logic:notEmpty>
                <div class="footer">
                    <p>
                        連絡メール：<a href="mailto:jinan@trans-cosmos.com.cn"
                            target="_blank">jinan@trans-cosmos.com.cn</a>
                    </p>
                </div>
            </div>

            <script type="text/javascript">
                                                    !function() {
                                                        laydate.skin('yahui');//切换皮肤，请查看skins下面皮肤库
                                                        laydate({
                                                            elem : '#demo'
                                                        });//绑定元素
                                                    }();

                                                    //日付範囲制限
                                                    var start = {
                                                        elem : '#startDateTime',
                                                        format : 'YYYY-MM-DD hh:mm',
                                                        istime : true,
                                                        istoday : false,
                                                        choose : function(datas) {
                                                            end.min = datas; //开始日选好后，重置结束日的最小日期
                                                            end.start = datas; //将结束日的初始值设定为开始日
                                                        }
                                                    };

                                                    var end = {
                                                        elem : '#endDateTime',
                                                        format : 'YYYY-MM-DD hh:mm',
                                                        /* min : laydate.now(),
                                                        max : laydate.now(+6), */
                                                        istime : true,
                                                        istoday : false,
                                                        choose : function(datas) {
                                                            start.max = datas; //结束日选好后，重置开始日的最大日期
                                                        }
                                                    };
                                                    laydate(start);
                                                    laydate(end);
                                                </script>
        </div>
    </div>
</body>
</html>
