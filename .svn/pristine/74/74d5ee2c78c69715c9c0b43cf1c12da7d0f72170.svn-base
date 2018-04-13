<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-html" prefix="html"%>
<%@ taglib uri="/struts-bean" prefix="bean"%>
<%@ taglib uri="/struts-logic" prefix="logic"%>
<%@ taglib uri="/terasoluna-struts" prefix="ts"%>
<%@ taglib uri="/terasoluna" prefix="t"%>
<%
    request.setCharacterEncoding("utf-8");
%>
<%
    response.setCharacterEncoding("utf-8");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>済南大宇宙内部システム-個人信息查询区</title>
<link rel="stylesheet" type="text/css" href="css/base.css" />
<link rel="stylesheet" type="text/css" href="css/main.css" />
<style type="text/css">
.display {
    display: none;
}
</style>

<script type="text/javascript" src="js/laydate/laydate.js"></script>
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/JNTCIPersonInfo.js"></script>
<script type="text/javascript">
    $(function() {

        $('#left-container .content').hide();
        $('#PersonInfo').show();
        $('h2.tit').click(function() {
            $(this).next('.content').stop().slideToggle();

        })

        var name = $("#nameBC").val();
        if (name != null) {
            $("#userName").val(name);
        }
        $("#submitButId").click(function() {
            $("#cod").val("reset");
            $("#formid").submit();
        });

        var m='<bean:write name="_JNTCIPersonalInfoInquireForm" property="deleteId_card"/>';//用m来接收要删除的列
        $(deleteId_c).val(m);
        var array=$(deleteId_c).val().split(",");
        var array1 = m.split(",");
       for (var i = 0; i < array.length; i++) {
        		bool = true;
        		$("[name='select']").each(function() {
        			if($(this).parent()
        				.next().text()==array[i]){

        				$(this).prop("checked", true);

        			}
        		});
        		}

//当点击另一页的时候
        $(".pagination li a").click(
        		function() {
        				var cards = "";
        				$("[name='select']").each(//遍历被选中的复选框
        						function() {
        							if ($(this).prop("checked") == true) {
        								var id_card = $(this).parent()
        								.next().text();//用id_card来接收被选中的复选框所对应的济南卡号
        								cards = cards + id_card + ",";//用cards来接收所有被选中的复选框所对应的济南卡号并用逗号分开

        							}
        						})
                               cards = cards.substring(0, cards.length - 1);//去掉最后一个逗号，因为最后一个逗号在字符串末尾
                            var address = $(this).attr("href") + "&deleteId_card=" + cards+","+$(deleteId_c).val();

        		             $(this).attr("href", address);
        }
        )

        $("#delete")
			.on(
					"click",
					function() {
						if (confirm("削除したら、復元することができません。本当に削除しますか？")) {
							var cards = "";
							$("[name='select']").each(
									function() {
										if ($(this).prop("checked") == true) {
											var id_card = $(this).parent()
													.next().text();
											cards = cards + id_card + ",";
										}
									})
							cards = cards.substring(0, cards.length - 1);
							 $.ajax({
										cache : true,
			                            type : "POST",
			                            url : '/tutorial-thin/JNTCIPersonalInfo/JNTCIPersonalInfoDeleteBL.do',//消除时更改路径
			                            data : {
			                                'deleteId_card' : cards+","+$(deleteId_c).val()
			                            },
			                            async : false,
			                            error : function(request) {
			                                alert("削除が失敗しました");
			                            },
			                            success : function(data) {
			                                alert("削除が成功しました");
			                                location = location;
			                            }
									});
						}
					});
        $("[name='select']").on("click", function () {

            if ($(this).prop("checked") == true) {

            	 $("#deleteId_card").val(m);
            }
            else//取消选中的复选框
            {
                var n=$(this).parent().next().text();//用n来接收被选中的复选框所对应的济南卡号
                array1= $.grep(array1, function(value) {
                	 return value != n;
                	});
                $(deleteId_c).val(array1);
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
                    <li><a href="#">社员情報</a></li>
                    <li class="ico">&gt;</li>
                    <li><a href="#">社员情報查询</a></li>
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
                <div class="clearfix">
                    <html:form
                        action="/JNTCIPersonalInfoInquireBL.do" styleId="formid"
                        method="POST">
                        <table class="fl table-bar" style="margin: 30px 0 10px 0;">
                            <colgroup>
                                <col width="100px" />
                                <col width="130px" />
                                <col width="100px" />
                                <col width="130px" />
                                <col width="100px" />
                                <col width="160px" />
                                <col width="100px" />
                                <col width="110px" />
                                <col width="100px" />
                                <col width="300px" />
                            </colgroup>
                            <tr>
                                <th>カード：</th>
                                <td><html:text
                                        name="_JNTCIPersonalInfoInquireForm"
                                        property="id_card" maxlength="4"></html:text></td>
                                <th>名前： <input type="hidden"
                                    id="cod" name="cod" value="" />
                                </th>
                                <td><html:text property="userName"
                                        styleId="userName" maxlength="10"/><input
                                    type="hidden" id="nameBC"
                                    name="nameBC"
                                    value="<bean:write name="_JNTCIPersonalInfoInquireForm" property="userName"/>" /></td>
                                <th>所属部門：</th>
                                <td><t:defineCodeList
                                        id="departmentList" /> <html:select
                                        name="_JNTCIPersonalInfoInquireForm"
                                        property="department">
                                        <html:option value="">--選択ください--</html:option>
                                        <html:options
                                            collection="departmentList"
                                            property="id"
                                            labelProperty="name" />
                                    </html:select></td>
                              <th>状態：</th>
                                <td> <html:select
                                        name="_JNTCIPersonalInfoInquireForm"
                                        property="zhuangtai">
                                        <html:option value=""> </html:option>
                                        <html:option value="0">在職</html:option>
                                        <html:option value ="1">退職</html:option>
                                    </html:select></td>
                                <th>入社時間：</th>
                                <td><html:text
                                        styleId="entryTime_Begin"
                                        name="_JNTCIPersonalInfoInquireForm"
                                        property="entryTime_Begin"
                                        styleClass="inline laydate-icon"
                                        readonly="true"></html:text> - <html:text
                                        styleId="entryTime_End"
                                        name="_JNTCIPersonalInfoInquireForm"
                                        property="entryTime_End"
                                        styleClass="inline laydate-icon"
                                        readonly="true"></html:text></td>
                            </tr>
                        </table>
                        <input class="fl btn btn-blue"
                            style="margin: 36px 0 8px 30px;"
                            type="submit" value="検索" name="js"
                            id="submitButId" />

                <logic:notEmpty name="_JNTCIPersonalInfoInquireForm"
                    property="personalInfos">
                    <table width="100%" class="ctn">
                        <caption>情報一覧表</caption>
                        <colgroup>
                            <col width="75px" />
                            <col width="100px" />
                            <col width="100px" />
                            <col width="100px" />
                            <col width="100px" />
                            <col width="100px" />

                            <col width="100px" />
                            <col width="100px" />
                            <col width="150px" />
                            <col width="100px" />
                            <col width="250px" />
                            <col width="100px" />
                        </colgroup>
                        <tr>
                            <th>選択</th>
                            <th>カード- JN</th>
                            <th>カード- TJ</th>
                            <th>名前</th>
                            <th>状態</th>
                            <th>性别</th>
                            <th>年齢</th>
                            <th>入社時間</th>
                            <th>職位レベル</th>
                            <th>連絡電話</th>
                            <th>住所</th>
                            <th>操作</th>
                        </tr>
                        <logic:iterate id="userInfo"
                            name="_JNTCIPersonalInfoInquireForm"
                            property="personalInfos">
                            <tr>
                                <td><input type="checkbox"
                                    name="select" id="select" /></td>
                                <td><bean:write name="userInfo"
                                        property="jn_card" /></td>
                                <td><bean:write name="userInfo"
                                        property="tj_card" /></td>
                                <td><bean:write name="userInfo"
                                        property="userName" /></td>
                                <td><bean:write name="userInfo"
                                        property="out_time" /></td>
                                <td><bean:write name="userInfo"
                                        property="sex" /></td>
                                <td><bean:write name="userInfo"
                                        property="age" /></td>
                                <td><bean:write name="userInfo"
                                        property="entryTime" /></td>
                                <td><bean:write name="userInfo"
                                        property="position" /></td>
                                <td><bean:write name="userInfo"
                                        property="telephone" /></td>
                                <td><bean:write name="userInfo"
                                        property="address" /></td>
                                <td><a
                                    href="/tutorial-thin/JNTCIPersonalInfoDetailedBL.do?id_card=<bean:write name="userInfo" property="jn_card" />&startIndex=<bean:write name="_JNTCIPersonalInfoInquireForm" property="startIndex"/>&userName=<bean:write name="_JNTCIPersonalInfoInquireForm" property="userName"/>&zhuangtai=<bean:write name="_JNTCIPersonalInfoInquireForm" property="zhuangtai"/>&entryTime_Begin=<bean:write name="_JNTCIPersonalInfoInquireForm" property="entryTime_Begin"/>&entryTime_End=<bean:write name="_JNTCIPersonalInfoInquireForm" property="entryTime_End"/>&department=<bean:write name="_JNTCIPersonalInfoInquireForm" property="department"/>&cardnum=<bean:write name="_JNTCIPersonalInfoInquireForm" property="id_card"/>"
                                    title="査看詳細の情報"><img
                                        src="images/search-cion.png"
                                        width="20px" height="20px" /></a> <a
                                    href="/tutorial-thin/downloadSkillBLogic.do?id_card=<bean:write name="userInfo" property="jn_card" />"
                                    title="ダウンロード履歴書"
                                    style="margin-left: 5px;"><img
                                        src="images/download-cion.png"
                                        width="20px" height="20px" /></a>
                                    <a
                                    href="/tutorial-thin/JNTCIAdminInfoUpdateInitBL.do?jn_Card=<bean:write name="userInfo" property="jn_card" />&id_card=<bean:write name="userInfo" property="jn_card" />&startIndex=<bean:write name="_JNTCIPersonalInfoInquireForm" property="startIndex"/>&userName=<bean:write name="_JNTCIPersonalInfoInquireForm" property="userName"/>&entryTime_Begin=<bean:write name="_JNTCIPersonalInfoInquireForm" property="entryTime_Begin"/>&entryTime_End=<bean:write name="_JNTCIPersonalInfoInquireForm" property="entryTime_End"/>&department=<bean:write name="_JNTCIPersonalInfoInquireForm" property="department"/>&cardnum=<bean:write name="_JNTCIPersonalInfoInquireForm" property="id_card"/>"
                                    title="修正" name="updateImg"
                                    style="margin-left: 5px;"><img
                                        src="images/edit-cion.png"
                                        width="20px" height="20px" /></a></td>
                            </tr>
                        </logic:iterate>
                        <tfoot>
                            <tr>
                                <td><label style="width: auto">全て選択</label>
                                    <input type="checkbox"
                                    name="selectAll" id="selectAll"
                                    title="全て選択" /></td>
                                <td><input type="button" value="削除"
                                    class="btn btn-red" id="delete" />
                                    <input
                                        type="hidden"
                                        name="deleteId_card"
                                        value="<bean:write name="_JNTCIPersonalInfoInquireForm" property="deleteId_card"/>" />
                                        <input
                                        type="hidden"
                                        name="deleteId_c"
                                        id="deleteId_c"
                                        value="" />
                                </td>
                                <ts:pageLinks
                                    id="JNTCIPersonalInfoListPageLinks"
                                    action="/JNTCIPersonalInfoInquireBL?id_card=${_JNTCIPersonalInfoInquireForm.id_card }&userName=${_JNTCIPersonalInfoInquireForm.userName }&
					department=${_JNTCIPersonalInfoInquireForm.department }&zhuangtai=${_JNTCIPersonalInfoInquireForm.zhuangtai}&entryTime_Begin=${_JNTCIPersonalInfoInquireForm.entryTime_Begin }&
					entryTime_End=${_JNTCIPersonalInfoInquireForm.entryTime_End }"
                                    name="_JNTCIPersonalInfoInquireForm"
                                    rowProperty="row"
                                    totalProperty="totalCount"
                                    indexProperty="startIndex"
                                    currentPageIndex="now"
                                    totalPageCount="total" />
                                <td colspan="10">
                                    <div class="pagination"
                                        style="margin-top: 0;">
                                        <ul>
                                            <li>共<b><bean:write
                                                        name="_JNTCIPersonalInfoInquireForm"
                                                        property="totalCount" /></b>条记录
                                            </li>
                                            <li><bean:write
                                                    name="now" />／<bean:write
                                                    name="total" /></li>
                                            <li><bean:write
                                                    name="JNTCIPersonalInfoListPageLinks"
                                                    filter="false" /></li>
                                        </ul>
                                    </div>
                                </td>
                            </tr>
                        </tfoot>
                    </table>
                </logic:notEmpty>

                </html:form>
                </div>


                <div class="footer">
                    <p>
                        意見反馈メール：<a
                            href="mailto:jinan@trans-cosmos.com.cn"
                            target="_blank">jinan@trans-cosmos.com.cn</a>
                    </p>
                    <%-- 显示选中的复选框 <bean:write name="_JNTCIPersonalInfoInquireForm" property="deleteId_card" /> --%>
                </div>
            </div>

            <script type="text/javascript">
                                                    //document.getElementById("delete").disabled = true;
                                                    $('#delete').attr(
                                                            'disabled', 'true')
                                                    !function() {
                                                        laydate.skin('yahui');//切换皮肤，请查看skins下面皮肤库
                                                        laydate({
                                                            elem : '#demo'
                                                        });//绑定元素
                                                    }();

                                                    //日期范围限制
                                                    var start = {
                                                        elem : '#entryTime_Begin',
                                                        format : 'YYYY\/MM\/DD',
                                                        max : laydate.now(), //设定最小日期为当前日期
                                                        istoday : false,
                                                        choose : function(datas) {
                                                            end.min = datas; //开始日选好后，重置结束日的最小日期
                                                            end.start = datas //将结束日的初始值设定为开始日
                                                        }
                                                    };

                                                    var end = {
                                                        elem : '#entryTime_End',
                                                        format : 'YYYY\/MM\/DD',
                                                        max : laydate.now(),
                                                        istoday : false,
                                                        choose : function(datas) {
                                                            start.max = datas; //结束日选好后，充值开始日的最大日期
                                                        }
                                                    };
                                                    laydate(start);
                                                    laydate(end);
                                                </script>
        </div>
    </div>
</body>
</html>