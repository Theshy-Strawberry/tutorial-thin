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
<title>設備審査一覧</title>
<link rel="stylesheet" type="text/css" href="css/base.css" />
<link rel="stylesheet" type="text/css" href="css/main.css" />
<link rel="stylesheet" type="text/css" href="Style/skin.css" />
<script type="text/javascript" src="js/laydate/laydate.js"></script>
<script type="text/javascript" src="js/jquery-1.11.3.min.js"></script>
<script type="text/javascript" src="JNTCIEquipQuery.js"></script>
<script type="text/javascript">
    $(function() {
    	 $('#left-container .content').hide();
         $('#Equip').show();
         $('h2.tit').click(function() {
             $(this).next('.content').stop().slideToggle();
         })
    	var m='<bean:write name="_JNTCIEquip04Form" property="deleteId_card"/>';
    	var hidden1='<bean:write name="_JNTCIEquip04Form" property="shinsaJyoutai"/>';
    	var hidden2='<bean:write name="_JNTCIEquip04Form" property="userId1"/>';
    	var hidden3='<bean:write name="_JNTCIEquip04Form" property="deptName"/>';
    	var hidden4='<bean:write name="_JNTCIEquip04Form" property="shinseiStartDate"/>';
    	var hidden5='<bean:write name="_JNTCIEquip04Form" property="shinseiEndDate"/>';
    	var hidden6='<bean:write name="_JNTCIEquip04Form" property="startIndex"/>';
    	var array = m.split(",");
        var fg=0;
        $(deleteId_c).val(m);
        var array1=$(deleteId_c).val().split(",");
    	document.getElementById("delete").disabled = true;
   		for (var i = 0; i < array1.length; i++) {

   			bool = true;
   			$("[name='select']").each(function() {
   				if($(this).parent().next().children().val()==array1[i]){
   					fg=fg+1;
   					$(this).prop("checked", true);
   					document.getElementById("delete").disabled = false;
   				}

   			});
   			}



        $("#selectAll").click(function() {
            if ($(this).prop("checked") == true) {
                $("[name='select']").prop("checked", true);
                document.getElementById("delete").disabled = false;
            } else {
                $("[name='select']").prop("checked", false);
                document.getElementById("delete").disabled = true;
            }
        });
        $("[name='select']").bind("change", function() {
            var bool = false;
            $("[name='select']").each(function() {
                if ($(this).prop("checked") == true) {
                    bool = false;
                    return false;
                } else {
                    bool = true;
                }
            });
            document.getElementById("delete").disabled = bool;
        });

        $("[name='select']").on("click", function () {

            if ($(this).prop("checked") == true) {

            	 $("#deleteId_card").val(m);
            }
            else
            {
                var n=$(this).parent().next().children().val();

                array= $.grep(array, function(value) {
                	 return value != n;
                	});
                $(deleteId_c).val(array);
            }
        });
        $(".pagination li a").click(

        		function() {

        			var cards = "";
                    $("[name='select']").each(
                            function() {
                                if ($(this).prop("checked") == true) {
                                    var evectionId = $(this).parent()
                                            .next().children().val()
                                    cards = cards + evectionId + ",";
                                }else {

                                }
                            })
                               cards = cards.substring(0, cards.length - 1);

        var address = $(this).attr("href") + "&deleteId_card=" + cards+","+$(deleteId_c).val()+"&qwerr=2"+"&shinsaJyoutai="+hidden1
                            +"&userId1="+hidden2+"&deptName="+hidden3+"&shinseiStartDate="+hidden4+"&shinseiEndDate="+hidden5+"&startIndex="+hidden6;
				             $(this).attr("href", address);
    }
	)
        $("#delete").on(
                "click",
                function() {
                    if (confirm("削除したら、復元することができない。本当に削除するか？")) {
                        var cards = "";
                        $("[name='select']").each(
                                function() {
                                    if ($(this).prop("checked") == true) {
                                        var evectionId = $(this).parent()
                                                .next().children().val()
                                        cards = cards + evectionId + ",";
                                    }
                                })
                        cards = cards.substring(0, cards.length - 1);
                        $("#formid").attr('action',
                        '/tutorial-thin/JNTCIEquip04BLdelete.do?qwerr=1'+"&deleteId_card=" + cards+","+$(deleteId_c).val()+"&shinsaJyoutai="+hidden1
                        +"&userId1="+hidden2+"&deptName="+hidden3+"&shinseiStartDate="+hidden4+"&shinseiEndDate="+hidden5+"&startIndex="+hidden6);
                       $("#formid").submit();
                    }
                })
    })
    $(document).ready(function fresh() {
        var i = '<bean:write name="_JNTCIEquip04Form" property="qwerr" />';
        var m = '<bean:write name="_JNTCIEquip04Form" property="CF" />';
        var f = '<bean:write name="_JNTCIEquip04Form" property="mark" />';
        if (f == "6") {
            $(".Error").show();
        } else if (f == "8") {
            $(".Error").hide();
        } else {
            $(".Error").hide();
        }
    });

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
        </div>
        <!--/左侧部分 -->
        <!--右侧部分 -->
        <div id="applyLists" class="rightWidht">
            <div class="header">
                <ul class="breadcrumbs clearfix">
                    <li>ステップチャート：</li>
                    <li><a href="#">設備管理</a></li>
                    <li class="ico">&gt;</li>
                    <li><a href="#">設備審査一覧</a></li>
                </ul>
            </div>
            <div
                style="max-height: 100px; overflow: auto; padding-left: 40px;">
                <html:errors />
                <html:messages id="message" message="true">
                    <bean:write name="message" />
                </html:messages>
                <div style="color: red; display: none" class="Error">
                    <h3>以下のエラーが発生しました。</h3>
                    ●非本人の申請を削除することはできない
                </div>
            </div>
            <div class="main-ctn">
                <ts:form action="/JNTCIEquip04BL" styleId="formid">
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
                                <th>申請者ID：</th>
                                <td><html:text
                                        name="_JNTCIEquip04Form"
                                        property="userId1" maxlength="4" />
                                </td>
                                <th>部門名称：</th>
                                <td><t:defineCodeList
                                        id="deptNoCodeList" /> <html:select
                                        name="_JNTCIEquip04Form"
                                        property="deptName">
                                        <option value=""
                                            selected="selected"></option>
                                        <html:options
                                            collection="deptNoCodeList"
                                            property="id"
                                            labelProperty="name" />
                                    </html:select></td>
                                <th>審査状態：</th>
                                <td><t:defineCodeList
                                        id="shinsaList" /> <html:select
                                        name="_JNTCIEquip04Form"
                                        property="shinsaJyoutai">
                                        <option value=""
                                            selected="selected"></option>
                                        <html:options
                                            collection="shinsaList"
                                            property="id"
                                            labelProperty="name" />
                                    </html:select></td>
                                <th>申請日付：</th>
                                <td colspan="3" class="input-time">
                                    <html:text
                                        property="shinseiStartDate"
                                        styleClass="inline laydate-icon"
                                        styleId="shinseiStartDate"
                                        readonly="true"></html:text> -<html:text
                                        property="shinseiEndDate"
                                        styleClass="inline laydate-icon"
                                        styleId="shinseiEndDate"
                                        readonly="true"></html:text>
                                </td>
                            </tr>
                        </table>
                        <ts:submit styleClass="btn btn-blue fl"
                            style="margin: 5px 40px 0px;" value="検索" />
                    </div>
                    </ts:form>
                    <logic:notEmpty name="_JNTCIEquip04Form"
                        property="setsubiShinsaList">
                        <ts:pageLinks id="equipListPageLinks"
                            action="/JNTCIEquip04BL?shinsaJyoutai=${_JNTCIEquip04Form.
                            shinsaJyoutai}&deptName=${_JNTCIEquip04Form.
                            deptName}&userId1=${_JNTCIEquip04Form
                            .userId1}&shinseiStartDate=${_JNTCIEquip04Form
                            .shinseiStartDate}&shinseiEndDate=${_JNTCIEquip04Form.shinseiEndDate}"
                            name="_JNTCIEquip04Form" rowProperty="row"
                            totalProperty="totalCount"
                            indexProperty="startIndex"
                            currentPageIndex="now"
                            totalPageCount="total" />
                        <hr />
                        <table class="ctn" width="100%">
                            <caption>設備審査一覧表</caption>
                            <tr>
                                <th style="width: 80px;">選択</th>
                                <th style="width: 0px"></th>
                                <th style="width: 120px">申請日付</th>
                                <th style="width: 160px">部門名称</th>
                                <th style="width: 160px">申請者</th>
                                <th style="width: 160px">申請区分</th>
                                <th style="width: 160px">設備種類</th>
                                <th style="width: 160px">申請状態</th>
                                <th style="width: 120px">審査人</th>
                                <th style="width: 120px">審査状態</th>
                                <th style="width: 120px">審査日付</th>
                                <th style="width: 120px">操作</th>
                            </tr>
                            <logic:iterate id="equipBean"
                                name="_JNTCIEquip04Form"
                                property="setsubiShinsaList">
                                <ts:form action="/JNTCIEquip0301BL.do" method="post">
                                <tr>
                                    <logic:equal value="0"
                                        name="_JNTCIEquip04Form"
                                        property="CF">
                                        <td><input type="checkbox"
                                            name="select" id="select" /></td>
                                    </logic:equal>
                                    <logic:equal value="3"
                                        name="_JNTCIEquip04Form"
                                        property="CF">
                                        <td><input type="checkbox"
                                            name="select" id="select" /></td>
                                    </logic:equal>
                                    <logic:notEqual value="0"
                                        name="_JNTCIEquip04Form"
                                        property="CF">
                                        <logic:notEqual value="3"
                                            name="_JNTCIEquip04Form"
                                            property="CF">
                                            <logic:equal value="未審査"
                                                name="equipBean"
                                                property="shinsaJyoutai">
                                                <td><input
                                                    type="checkbox"
                                                    name="select"
                                                    id="select" /></td>
                                            </logic:equal>
                                            <logic:notEqual value="未審査"
                                                name="equipBean"
                                                property="shinsaJyoutai">
                                                <td><input
                                                    type="checkbox"
                                                    name="select"
                                                    id="select"
                                                    disabled="disabled" /></td>
                                            </logic:notEqual>
                                        </logic:notEqual>
                                    </logic:notEqual>
                                    <td><input type="hidden"
                                        name="apply_no"
                                        value="<bean:write name="equipBean" property="apply_no" />" />
                                    </td>
                                    <td style="width: 120px"><bean:write
                                            name="equipBean"
                                            property="shinseiDate" /></td>
                                    <td style="width: 120px"><bean:write
                                            name="equipBean"
                                            property="deptName" /></td>
                                    <td style="width: 120px"><bean:write
                                            name="equipBean"
                                            property="userName" />-<bean:write
                                            name="equipBean"
                                            property="userId" /></td>
                                    <td style="width: 160px"><bean:write
                                            name="equipBean"
                                            property="shinseiKubun" /></td>
                                    <td align="center"><bean:write
                                            name="equipBean"
                                            property="shinsasyurui" /> <input
                                        type="hidden"
                                        name="shinsasyurui"
                                        value="<bean:write name="equipBean" property="shinsasyurui"/>" /></td>
                                    <td style="width: 160px"><bean:write
                                            name="equipBean"
                                            property="shinseiJyoutai" />
                                        <input type="hidden"
                                        name="shinseiJyoutai"
                                        value="<bean:write name="equipBean" property="shinseiJyoutai"/>" />
                                    </td>
                                    <td style="width: 160px"><bean:write
                                            name="equipBean"
                                            property="shinsasyaName" />-<bean:write
                                            name="equipBean"
                                            property="shinsasyaId" /></td>
                                    <td><bean:write
                                            name="equipBean"
                                            property="shinsaJyoutai" /></td>
                                    <td><bean:write
                                            name="equipBean"
                                            property="shinsaHiduke" />
                                            <html:hidden property="userId1" name="_JNTCIEquip04Form"/>
                                           <html:hidden property="deptName" name="_JNTCIEquip04Form"/>
                                           <html:hidden property="shinsaJyoutai" name="_JNTCIEquip04Form"/>
                                           <html:hidden property="shinseiStartDate" name="_JNTCIEquip04Form"/>
                                           <html:hidden property="shinseiEndDate" name="_JNTCIEquip04Form"/>
                                           <html:hidden property="startIndex" name="_JNTCIEquip04Form"/>
                                            </td>
                                            <td><input type="submit"
                                        class="btn btn-green" value="詳細" /></td>
                                </tr>
                                </ts:form>
                            </logic:iterate>
                            <tfoot>
                                <tr>
                                    <logic:equal value="0"
                                        name="_JNTCIEquip04Form"
                                        property="CF">
                                        <td><label
                                            style="width: auto">全て選択</label>
                                            <input type="checkbox"
                                            name="selectAll"
                                            id="selectAll" title="全て選択" />
                                        </td>
                                    </logic:equal>
                                    <logic:equal value="3"
                                        name="_JNTCIEquip04Form"
                                        property="CF">
                                        <td><label
                                            style="width: auto">全て選択</label>
                                            <input type="checkbox"
                                            name="selectAll"
                                            id="selectAll" title="全て選択" />
                                        </td>
                                    </logic:equal>
                                    <td><input type="button"
                                        value="削除" class="btn btn-red"
                                        id="delete" />
                                        <input
                                        type="hidden"
                                        name="deleteId_card"
                                        value="<bean:write name="_JNTCIEquip04Form" property="deleteId_card"/>" />
                                           <input
                                        type="hidden"
                                        name="deleteId_c"
                                        id="deleteId_c"
                                        value="" />
                                        </td>
                                    <td colspan="10">
                                        <div class="pagination">
                                            <!--页数 上下页-->
                                            <ul>
                                                <li>計<b><bean:write
                                                            name="_JNTCIEquip04Form"
                                                            property="totalCount" /></b>レコード数
                                                </li>
                                                <li><bean:write
                                                        name="now" />／<bean:write
                                                        name="total" /></li>
                                                <li><bean:write
                                                        name="equipListPageLinks"
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
                                連絡メール：<a
                                    href="mailto:jinan@trans-cosmos.com.cn"
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
    var start = {
        elem : '#shinseiStartDate',
        format : 'YYYY-MM-DD',
        /* 	min: laydate.now(), //设定最小日期为当前日期
        	max: laydate.now(+6), //最大日期 */
        istime : true,
        istoday : false
    };
    var end = {
        elem : '#shinseiEndDate',
        format : 'YYYY-MM-DD',
        /* min: laydate.now(),
        max: laydate.now(+6), */
        istime : true,
        istoday : false
    };
    laydate(start);
    laydate(end);
</script>