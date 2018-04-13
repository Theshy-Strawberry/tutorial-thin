<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="/struts-html" prefix="html"%>
<%@ taglib uri="/struts-bean" prefix="bean"%>
<%@ taglib uri="/struts-logic" prefix="logic"%>
<%@ taglib uri="/terasoluna-struts" prefix="ts"%>
<%@ taglib uri="/terasoluna" prefix="t"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html:html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>設備購入申請</title>
<link rel="stylesheet" type="text/css" href="css/base.css" />
<link rel="stylesheet" type="text/css" href="css/main.css" />
<script type="text/javascript" src="js/laydate/laydate.js"></script>
<script type="text/javascript" src="js/jquery-1.11.3.min.js"></script>
<script type="text/javascript" src="js/jquery.validate.js"></script>
<script type="text/javascript" src="js/roommeet.js"></script>
<script type="text/javascript">
    $(function() {
        $('#left-container .content').hide();
        $('#Equip').show();
        $('h2.tit').click(function() {
            $(this).next('.content').stop().slideToggle();

        })
    })
   // 宛先消除
    function deleteTo() {
        var a=$("#toId").val();
        var array = a.split(";");
        var removeItem = "";
        array = $.grep(array, function(value) {
            return value != removeItem;
        });
        var removeItem1 = array[array.length-1];
        array = $.grep(array, function(value) {
            return value != removeItem1;
        });
         var x="";
        for (var i = 0; i < array.length; i++) {
    		 x = x +array[i]+";";
        }
        $("#toId").val(x);
    }
    function resetself() {
        $("#formId").attr('action', '/tutorial-thin/JNTCIEquip01SCR.do');
        $("#formId").submit();
    }
     function onSubimitfun() {
        $("#formId").submit();
    }
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
                    <li><a href="#">設備購入申請</a></li>
                </ul>
            </div>

                                        <div
                                style="max-height: 100px; overflow: auto; width: 500px; margin-left: 70px;">
                                <html:errors />
                                <html:messages id="message"
                                    message="true">
                                    <bean:write name="message" />
                                </html:messages>
                            </div>
            <div class="main-ctn clearfix" style="height:700px；">
                <ts:form action="/JNTCIEquip01BL" method="post"
                    styleId="formId">
                    <div style="width: 700px; float: left;">
                        <p>
                            <label>申請日付：</label>
                            <html:text property="shinsei_hiduke"
                                styleClass="inline laydate-icon"
                                styleId="shinsei_hiduke" readonly="true"></html:text>
                            <i class="red">*</i>
                        </p>
                        <p>
                            <label>申請者：</label> <span> <bean:write
                                    name="userName" scope="session"
                                    ignore="true" /> -<bean:write
                                    name="userId" scope="session"
                                    ignore="true" />
                            </span>
                        </p>
                        <p>
                            <label>部門名称：</label>
                            <t:defineCodeList id="deptNoCodeList" />
                            <html:select name="_JNTCIEquip01Form"
                                property="deptName"
                                style="width:156px; ">
                                <option value="" selected="selected"></option>
                                <html:options
                                    collection="deptNoCodeList"
                                    property="id" labelProperty="name" />
                            </html:select>
                            <i class="red">*</i>
                        </p>
                        <p>
                            <label>物品名：</label>
                            <html:text property="aitemuName"
                                styleId="aitemuName" />
                            <i class="red">*</i>
                        </p>
                        <p>
                            <label>設備数：</label>
                            <html:text property="aitemuNumber"
                                styleId="aitemuNumber" />
                            <i class="red">*</i>
                        </p>
                        <p>
                            <label>宛先：</label>
                            <html:text property="toId" styleClass="to" styleId="toId" readonly="true"
                                style="width: 500px" />
                            <i class="red">*</i>
                        </p>
                        <p>
                            <label>件名：</label>
                            <html:text property="subject"
                                style="width: 500px" />
                            <i class="red">*</i>
                        </p>
                        <p class="reason">
                            <label>申請原因：</label>
                            <html:textarea styleId="reason"
                                property="reason" style="width: 500px"
                                name="_JNTCIEquip01Form" />
                            <i class="red">*</i>
                        </p>
                    </div>

                    <div
                        style="width: 700px; margin-right: 120px; float: right;margin-top: 40px;">
                        <div
                            style="width: 150px; float: left; margin-top: 224px;">
                            <a class="btn btn-blue" href="javascript:addTo();"> <-宛先追加</a><br /><br />
                             <a class="btn btn-red"  href="javascript:deleteTo();">宛先削除-></a><br />
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
                                name="_JNTCIEquip01Form"
                                property="officeMail"
                                multiple='multiple' size='17'
                                style="width:300px;height:445px;margin-top: 20px;">
                                <html:options
                                    collection="officeMailList"
                                    property="id" labelProperty="name" />
                            </html:select>
                        </div>
                    </div>
                </ts:form>
                <div style="width: 700px; height: 591px;">
                    <input style="margin-left: 170px" type="submit"
                        value="追加" onclick="onSubimitfun()"
                        class="btn btn-blue" />
                    <html:reset styleClass="btn btn-green" value="クリア"
                        style="margin-left:20px" styleId="reset"
                        onclick="resetself()"></html:reset>
                </div>
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
<script type="text/javascript">
    !function() {
        laydate.skin('yahui');//切换皮肤，请查看skins下面皮肤库
        laydate({
            elem : '#demo'
        });//绑定元素
    }();
    //日期范围限制
    var hiduke = {
        elem : '#shinsei_hiduke',
        format : 'YYYY-MM-DD',
        min : laydate.now(), //设定最小日期为当前日期
        max : laydate.now(+6), //最大日期
        istime : true,
        istoday : false
    };
    laydate(hiduke);

    /*字数限制*/
    function areatextLength() {
        if (text.value.length > 100) {
            text.value = text.value.substr(0, 100);
            //alert("100文字以内を入力してください");
        }
    }

    function ajaxSearch() {
        var valu = $("#emailSearchValue").val();
        var valu1 = $("#emailSearchCode").val();
        $.ajax({
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
            success : function(data) {
                $("#officeMail").empty();
                var select = document.getElementById("officeMail");
                var jsonobj = jQuery.parseJSON(data);
                for (var i = 0; i < jsonobj.length; i++) {
                    select.options.add(new Option(jsonobj[i].value,
                            jsonobj[i].key));
                }
                select.options[0].selected = true;
                select.options[0].selected = false;
            }
        });
    }
</script>