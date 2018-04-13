<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="/struts-html" prefix="html"%>
<%@ taglib uri="/struts-bean" prefix="bean"%>
<%@ taglib uri="/struts-logic" prefix="logic"%>
<%@ taglib uri="/terasoluna-struts" prefix="ts"%>
<%@ taglib uri="/terasoluna" prefix="t"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html:html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>会議室申請</title>
<link rel="stylesheet" type="text/css" href="css/base.css" />
<link rel="stylesheet" type="text/css" href="css/main.css" />
<script type="text/javascript" src="js/laydate/laydate.js"></script>
<script type="text/javascript" src="js/jquery-1.11.3.min.js"></script>
<script type="text/javascript" src="js/roommeet.js"></script>
<script type="text/javascript">
    $(function() {
        $('#left-container .content').hide();
        $('#MtRoom').show();
        $('h2.tit').click(function() {
            $(this).next('.content').stop().slideToggle();
        })
    })
</script>
<style type="text/css">
.Thistable td {
    border: 0px;
}

.userInformation {
    margin-top: 20px;
}

.ctn {
    height: 150px;
}

.ctn tbody {
    display: block;
    width: 560px;
    height: 143px;
    overflow-x: auto;
}

.ctn td {
    padding: 2px;
}

.ctn th {
    padding: 2px;
    position: absolute;
}
</style>
</head>
<body onload="ajaxShow()">
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
                    <li><a href="#">会議室申請</a></li>
                </ul>
            </div>
            <div
                style="max-height: 100px; overflow: auto; width: 500px; margin-left: 80px;">
                <html:errors />
                <html:messages id="message" message="true">
                    <bean:write name="message" />
                </html:messages>
            </div>
            <div class="main-ctn ul-li timeChange">
                <ts:form action="/MeetingApply">
                    <div style="width: 1200px;">
                        <div
                            style="width: 600px; float: right; margin-top: 10px;">
                            <!-- 第一會議室預約狀況一覽 -->
                            <table class="ctn" id="ctn">
                                <caption>
                                    <label id="theOneRoomTalbe" />
                                </caption>
                            </table>
                            <!--第一會議室預約狀況一覽  -->
                        </div>
                        <div style="width: 600px">
                            <div class="userInformation">
                                <label>申請者カード：</label>
                                <bean:write name="userId"
                                    scope="session" ignore="true" />
                                <input id="flag" name="jnCard"
                                    type="hidden"
                                    value="<bean:write name="userId" scope="session" ignore="true"/>" />
                                <input name="jnCard" type="hidden"
                                    value="<bean:write name="userName" scope="session" ignore="true"/>"
                                    id="name" />
                            </div>
                            <div class="userInformation">
                                <label>会議室番号：</label>
                                <t:defineCodeList id="roomNoCodeList" />
                                <html:select
                                    name="_JNTCIMeetingApplyForm"
                                    property="roomNo"
                                    style="width:155px;" styleId="room"
                                    onchange="ajaxShow()">
                                    <html:options
                                        collection="roomNoCodeList"
                                        property="id"
                                        labelProperty="name" />
                                </html:select>
                            </div>
                            <div class="userInformation">
                                <label>使用日付：</label>
                                <html:text property="startTime"
                                    styleClass="inline laydate-icon"
                                    styleId="startTime" readonly="true"></html:text>
                                -
                                <html:text property="endTime"
                                    styleClass="inline laydate-icon"
                                    styleId="endTime" readonly="true"></html:text>
                                <i class="red">*</i>
                            </div>
                            <div class="userInformation">
                                <label>申請原因：</label>
                                <html:textarea property="remark"
                                    styleId="text"
                                    onkeyup="areatextLength()"
                                    style="width:325px;"></html:textarea>
                                <i class="red">*</i>
                            </div>
                        </div>
                    </div>
                    <div style="width: 1500px; margin-top: 20px;">

                        <div
                            style="width: 750px; float: left; margin-top: 20px;">
                            <table class="Thistable">
                                <tr>
                                    <td
                                        style="width: 150px; text-align: right">宛先：</td>
                                    <td
                                        style="width: 400px; text-align: left;"><html:text
                                            property="toId"
                                            styleClass="to"
                                            style="width: 500px" /></td>
                                </tr>
                                <tr>
                                    <td
                                        style="width: 150px; text-align: right">件名：</td>
                                    <td
                                        style="width: 400px; text-align: left;"><html:text
                                            property="subject"
                                            style="width: 600px" /></td>
                                </tr>
                            </table>
                        </div>
                        <div
                            style="width: 100px; float: left; margin-top: 30px;">
                            <a href="javascript:addTo();"> <-宛先追加</a><br />
                        </div>
                        <div
                            style="width: 300px; height: 100px; float: left; margin-left: 30px;">
                            <html:select property="emailSearchCode"
                                styleId="emailSearchCode"
                                onchange="ajaxSearch()" value="2">
                                <html:option value="0">メール名</html:option>
                                <html:option value="1">名前のみ</html:option>
                                <html:option value="2">社員カード</html:option>
                            </html:select>
                            <t:defineCodeList id="officeMailList" />
                            <input type="text" name="emailSearchValue"
                                style="width: 100px;"
                                onkeyup="ajaxSearch()"
                                id="emailSearchValue" autocomplete="off" />
                            <html:button value="檢索"
                                property="forward_name" disabled="true"
                                styleClass="btn btn-green" />
                            <html:select styleId="officeMail"
                                name="_JNTCIMeetingApplyForm"
                                property="officeMail"
                                multiple='multiple' size='17'
                                style="width:300px;height:445px;">
                                <html:options
                                    collection="officeMailList"
                                    property="id" labelProperty="name" />
                            </html:select>
                        </div>
                    </div>
                    <div style="width: 850px;">
                        <table class="Thistable">
                            <tr>
                                <td
                                    style="width: 150px; text-align: right">内容：</td>
                                <td></td>
                            </tr>
                            <tr>
                                <td></td>
                                <td><textarea id="textarea"
                                        style="width: 700px; height: 300px; text-align: left;"
                                        name="mailContent"></textarea></td>
                            </tr>
                            <tr>
                                <td></td>
                                <td style="text-align: right;"><input
                                    style="margin-left: 170px; width: 60px; height: 25px"
                                    type="submit" value="申請"
                                    class="btn btn-blue" /> <html:reset
                                        styleClass="btn btn-green"
                                        value="クリア"
                                        style="margin-left:20px;width:60px;height:25px"
                                        styleId="reset"
                                        onclick="reset()"></html:reset></td>
                            </tr>
                        </table>


                    </div>
                </ts:form>
                <div class="footer">
                    <p>
                        連絡メール：<a href="mailto:jinan@trans-cosmos.com.cn"
                            target="_blank">jinan@trans-cosmos.com.cn</a>
                    </p>
                </div>
            </div>


            <script type="text/javascript">
                                                    function setTime(startTime,
                                                            endTime) {
                                                        $("#startTime").attr(
                                                                'readonly',
                                                                false);
                                                        $("#startTime").val(
                                                                startTime);
                                                        $("#startTime").attr(
                                                                'readonly',
                                                                true);
                                                        $("#endTime").attr(
                                                                'readonly',
                                                                false);
                                                        if (endTime != 0) {
                                                            $("#endTime").val(
                                                                    endTime);
                                                        } else {
                                                            $("#endTime").val(
                                                                    startTime);
                                                        }
                                                        $("#endTime").attr(
                                                                'readonly',
                                                                true);
                                                    }
                                                    function ajaxShow() {
                                                        var roomNo = document
                                                                .getElementById("room").value;
                                                        $
                                                                .ajax({
                                                                    cache : true,
                                                                    type : 'POST',
                                                                    url : '/tutorial-thin/MeetingApplySelect.do',
                                                                    data : {
                                                                        'roomNo' : roomNo
                                                                    },
                                                                    async : false,
                                                                    error : function() {
                                                                        alert("削除が失敗しました！");
                                                                    },
                                                                    success : function(
                                                                            data) {

                                                                        $(
                                                                                "#tbody")
                                                                                .remove();//清空ID为tbody的tbody
                                                                        $(
                                                                                "#ctn")
                                                                                .append(
                                                                                        '<tbody id="tbody"></tbody>');
                                                                        ctn
                                                                        $(
                                                                                "#theOneRoomTalbe")
                                                                                .html(
                                                                                        '<p style="color:red">'
                                                                                                + $(
                                                                                                        "#room option:selected")
                                                                                                        .text()
                                                                                                + 'を予約していませんでした。</p>');

                                                                        if (data.length > 2) {
                                                                            $(
                                                                                    "#theOneRoomTalbe")
                                                                                    .html(
                                                                                            $(
                                                                                                    "#room option:selected")
                                                                                                    .text()
                                                                                                    + '予約状況一覧');
                                                                            var jsonobj = jQuery
                                                                                    .parseJSON(data);
                                                                            $(
                                                                                    "#tbody")
                                                                                    .append(
                                                                                            '<tr> <th><div style=\"width:150px\"/>会議日付</th><td><div style=\"width:150px\"/></td> </tr>'
                                                                                                    + '<tr> <th><div style=\"width:150px\"/>会議時間（自）</th> <td ></td></tr> <tr> <th><div style=\"width:150px\"/>会議時間（至）</th> <td></td></tr> <tr>'
                                                                                                    + '<th><div style=\"width:150px\"/>会議時長</th><td></td> </tr> <tr> <th><div style=\"width:150px\"/>会議間隔(点击预约)</th><td></td> </tr>');
                                                                            for (var i = 0; i < jsonobj.length; i++) {
                                                                                $(
                                                                                        "#tbody tr:eq(0)")
                                                                                        .append(
                                                                                                "<td>"
                                                                                                        + jsonobj[i].startTime
                                                                                                                .substr(
                                                                                                                        0,
                                                                                                                        10)
                                                                                                        + "</td>");
                                                                                $(
                                                                                        "#tbody tr:eq(1)")
                                                                                        .append(
                                                                                                "<td><div style=\"width:100px\">"
                                                                                                        + jsonobj[i].startTime
                                                                                                                .substring(10)
                                                                                                        + "</td>");
                                                                                $(
                                                                                        "#tbody tr:eq(2)")
                                                                                        .append(
                                                                                                "<td>"
                                                                                                        + jsonobj[i].endTime
                                                                                                                .substring(10)
                                                                                                        + "</td>");
                                                                                $(
                                                                                        "#tbody tr:eq(3)")
                                                                                        .append(
                                                                                                "<td>"
                                                                                                        + jsonobj[i].minite
                                                                                                        + "分</td>");
                                                                                if (i + 1 != jsonobj.length) {
                                                                                    if (jsonobj[i].startTime
                                                                                            .substr(
                                                                                                    0,
                                                                                                    10) == jsonobj[i + 1].startTime
                                                                                            .substr(
                                                                                                    0,
                                                                                                    10)) {
                                                                                        var time = (new Date(
                                                                                                jsonobj[i + 1].startTime) - new Date(
                                                                                                jsonobj[i].endTime)) / 60000;
                                                                                        if (time == 0) {
                                                                                            $(
                                                                                                    "#tbody tr:eq(4)")
                                                                                                    .append(
                                                                                                            "<td>"
                                                                                                                    + time
                                                                                                                    + "分</td>");
                                                                                        } else {

                                                                                            $(
                                                                                                    "#tbody tr:eq(4)")
                                                                                                    .append(
                                                                                                            "<td><a href=\"#\" onclick=\"setTime('"
                                                                                                                    + jsonobj[i].endTime
                                                                                                                    + "','"
                                                                                                                    + jsonobj[i + 1].startTime
                                                                                                                    + "')\" style=\"text-decoration: underline; color:#0000ff;\">"
                                                                                                                    + time
                                                                                                                    + "分</a></td>");
                                                                                        }
                                                                                    } else {
                                                                                        $(
                                                                                                "#tbody tr:eq(4)")
                                                                                                .append(
                                                                                                        "<td><a href=\"#\" onclick=\"setTime('"
                                                                                                                + jsonobj[i].endTime
                                                                                                                + "','0')\" style=\"text-decoration: underline; color:#0000ff;\">なし</a></td>");
                                                                                    }
                                                                                } else {
                                                                                    $(
                                                                                            "#tbody tr:eq(4)")
                                                                                            .append(
                                                                                                    "<td><a href=\"#\" onclick=\"setTime('"
                                                                                                            + jsonobj[i].endTime
                                                                                                            + "','0')\" style=\"text-decoration: underline; color:#0000ff;\">なし</a></td>");
                                                                                }
                                                                            }
                                                                        }
                                                                        setColspan();
                                                                    }
                                                                });
                                                    }

                                                    function setColspan() {
                                                        var td = $("#tbody tr:eq(0) td");
                                                        var index = 0;
                                                        var colspanIndex = 1;
                                                        for (var i = 0; i < td.length; i++) {
                                                            if (i != td.length - 1) {
                                                                var td0 = $(td
                                                                        .get(index));
                                                                var td1 = $(td
                                                                        .get(i + 1));
                                                                if (td0.html() == td1
                                                                        .html()) {
                                                                    td1
                                                                            .remove();
                                                                    td0
                                                                            .attr(
                                                                                    "colspan",
                                                                                    colspanIndex + 1);
                                                                    colspanIndex = colspanIndex + 1;
                                                                } else {
                                                                    index = i + 1;
                                                                    colspanIndex = 1;
                                                                }

                                                            }
                                                        }
                                                    }

                                                    /*字数限制*/
                                                    function areatextLength() {
                                                        if (text.value.length > 100) {
                                                            text.value = text.value
                                                                    .substr(0,
                                                                            100);
                                                            alert("33文字以内を入力してください！");
                                                        }
                                                    }
                                                    //添加邮件内容
                                                    var oldStartTime = '';
                                                    var oldEndTime = '';

                                                    $(".timeChange")
                                                            .mouseover(
                                                                    function() {

                                                                        var val = "皆さん\nお疲れ様です。nameです。\n\n会議通知：\n         会議室：room\n         会議時間：startTime - endTime\n         会議内容：text\n\n必ず時間通りに出席してください。ありがとうございます。\n\n以上です、よろしくお願い致します。";
                                                                        var room = document
                                                                                .getElementById("room").value;
                                                                        var startTime = document
                                                                                .getElementById("startTime").value;
                                                                        var endTime = document
                                                                                .getElementById("endTime").value;
                                                                        var text = document
                                                                                .getElementById("text").value;
                                                                        var name = document
                                                                                .getElementById("name").value;
                                                                        if (room != '') {
                                                                            val = val
                                                                                    .replace(
                                                                                            "room",
                                                                                            room);
                                                                        }
                                                                        if (startTime != oldStartTime
                                                                                && startTime != '') {
                                                                            val = val
                                                                                    .replace(
                                                                                            "startTime",
                                                                                            startTime);
                                                                        }
                                                                        if (endTime != oldEndTime
                                                                                && endTime != '') {
                                                                            val = val
                                                                                    .replace(
                                                                                            "endTime",
                                                                                            endTime);
                                                                        }
                                                                        if (text != '') {
                                                                            val = val
                                                                                    .replace(
                                                                                            "text",
                                                                                            text);
                                                                        }
                                                                        if (name != '') {
                                                                            val = val
                                                                                    .replace(
                                                                                            "name",
                                                                                            name);
                                                                        }
                                                                        var oldStartTime = document
                                                                                .getElementById("startTime").value;
                                                                        var oldEndTime = document
                                                                                .getElementById("endTime").value;
                                                                        var textarea = document
                                                                                .getElementById("textarea");
                                                                        textarea.value = val;
                                                                    });

                                                    function ajaxSearch() {
                                                        var valu = $(
                                                                "#emailSearchValue")
                                                                .val();
                                                        var valu1 = $(
                                                                "#emailSearchCode")
                                                                .val();
                                                        $
                                                                .ajax({
                                                                    cache : true,
                                                                    type : 'POST',
                                                                    url : '/tutorial-thin/MeetingApplyAjax.do',
                                                                    data : {
                                                                        'emailSearchValue' : valu,
                                                                        'emailSearchCode' : valu1
                                                                    },
                                                                    async : false,
                                                                    error : function() {
                                                                        alert("削除が失敗しました！");
                                                                    },
                                                                    success : function(
                                                                            data) {
                                                                        $(
                                                                                "#officeMail")
                                                                                .empty();
                                                                        var select = document
                                                                                .getElementById("officeMail");
                                                                        var jsonobj = jQuery
                                                                                .parseJSON(data);
                                                                        for (var i = 0; i < jsonobj.length; i++) {
                                                                            select.options
                                                                                    .add(new Option(
                                                                                            jsonobj[i].value,
                                                                                            jsonobj[i].key));
                                                                        }
                                                                        select.options[0].selected = true;
                                                                        select.options[0].selected = false;
                                                                    }
                                                                });
                                                    }

                                                    !function() {
                                                        laydate.skin('yahui');//切换皮肤，请查看skins下面皮肤库
                                                        laydate({
                                                            elem : '#demo'
                                                        });//绑定元素
                                                    }();
                                                    //日期范围限制
                                                    var start = {
                                                        elem : '#startTime',
                                                        format : 'YYYY-MM-DD hh:mm',
                                                        min : laydate.now(),
                                                        istime : true,
                                                        istoday : false,
                                                        choose : function(datas) {
                                                            end.min = datas
                                                                    .substr(0,
                                                                            14)
                                                                    + "00"; //开始日选好后，重置结束日的最小日期
                                                            end.start = datas; //将结束日的初始值设定为开始日
                                                        }
                                                    };

                                                    var end = {
                                                        elem : '#endTime',
                                                        format : 'YYYY-MM-DD hh:mm',
                                                        min : laydate.now(),
                                                        istime : true,
                                                        istoday : false,
                                                        choose : function(datas) {
                                                            start.max = datas; //结束日选好后，重置开始日的最大日期
                                                        }
                                                    };
                                                    laydate(start);
                                                    laydate(end);

                                                    $(document)
                                                            .ready(
                                                                    function() {
                                                                        $(
                                                                                "textarea[name='remark']")
                                                                                .bind(
                                                                                        'change',
                                                                                        function() {
                                                                                            var txt = $(
                                                                                                    "textarea[name='remark']")
                                                                                                    .val();
                                                                                            $(
                                                                                                    "input[name='subject']")
                                                                                                    .val(
                                                                                                            txt);
                                                                                        });
                                                                    });
                                                </script>
        </div>
    </div>
</body>
</html:html>
