<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="/struts-html" prefix="html"%>
<%@ taglib uri="/struts-bean" prefix="bean"%>
<%@ taglib uri="/struts-logic" prefix="logic"%>
<%@ taglib uri="/terasoluna-struts" prefix="ts"%>
<%@ taglib uri="/terasoluna" prefix="t"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%
    request.setCharacterEncoding("utf-8");
%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/base.css" />
<link rel="stylesheet" type="text/css" href="css/main.css" />
<link rel="stylesheet" type="text/css" href="Style/skin.css" />
<script type="text/javascript" src="js/laydate/laydate.js"></script>
<script type="text/javascript" src="js/laydate/manhuaDate.1.0.js"></script>
<script type="text/javascript" src="js/jquery-1.11.3.min.js"></script>
<script type="text/javascript" src="js/JNTCIAddsignInfoQuery.js"></script>

<script type="text/javascript">
$(function() {
    $('#left-container .content').hide();
    $('#Attendance').show();
    $('h2.tit').click(function() {
        $(this).next('.content').stop().slideToggle();
    })

    $("#selectAll").click(function() {
		if ($(this).prop("checked") == true) {
			$("[name='select']").prop("checked", true);
			document.getElementById("admit_list").disabled = false;
			document.getElementById("refuse_list").disabled = false;
			document.getElementById("delete_list").disabled = false;
		} else {
			$("[name='select']").prop("checked", false);
			document.getElementById("admit_list").disabled = true;
			document.getElementById("refuse_list").disabled = true;
			document.getElementById("delete_list").disabled = true;
		}
	});
	$("[name='select']").bind("click", function() {
		var bool = false;
		$("[name='select']").each(function() {
			if ($(this).prop("checked") == true) {
				bool = false;
				return false;
			} else {
				bool = true;
			}
		});

		document.getElementById("admit_list").disabled = bool;
		document.getElementById("refuse_list").disabled = bool;
		document.getElementById("delete_list").disabled = bool;
	});


});

</script>
<script type="text/javascript">
     function getIndex() {
       var a = document.getElementById("retroactive2").value;
    //プルダウンフレームの補を取得するタイプ
        if (a == 3) {
        $("#test1").show();
        $("#endDateTime").show();
        $("#startDateTime").show();
        $("#startDateTime").removeAttr("style");
        $("#endDateTime").removeAttr("style");
         } else if (a == 2) {
        $("#test1").hide();
        $("#startDateTime").hide();
        $("#endDateTime").show();
        $("#endDateTime").removeAttr("style");
        } else {
        $("#test1").hide();
        $("#endDateTime").hide();
        $("#startDateTime").show();
        $("#startDateTime").removeAttr("style");
               }
        $("#retroactive_type_hide").val(a);
     }
</script>
<script type="text/javascript">
$(function() {
    var retroactive_type_keepval = $("#retroactive_type_hide").val();
    $("#retroactive2").find("option[value='" + retroactive_type_keepval + "']").attr("selected", true);
        var a = document.getElementById("retroactive2").value;
        //プルダウンフレームの補を取得するタイプ
        if (a == 3) {
            $("#test1").show();
            $("#endDateTime").show();
            $("#startDateTime").show();
            $("#startDateTime").removeAttr("style");
            $("#endDateTime").removeAttr("style");
        } else if (a == 2) {
            $("#test1").hide();
            $("#startDateTime").hide();
            $("#endDateTime").show();
            $("#endDateTime").removeAttr("style");
        } else {
            $("#test1").hide();
            $("#endDateTime").hide();
            $("#startDateTime").show();
            $("#startDateTime").removeAttr("style");
        }
        var m='<bean:write name="_JNTCIaddsignInfo" property="deleteExtra_Id" />';
        var hidden1='<bean:write name="_JNTCIaddsignInfo" property="JN_CARD_SEARCH"/>';
        var hidden2='<bean:write name="_JNTCIaddsignInfo" property="USER_NAME_SEARCH"/>';
        var hidden3='<bean:write name="_JNTCIaddsignInfo" property="retroactive_type2"/>';
        var hidden4='<bean:write name="_JNTCIaddsignInfo" property="startIndex"/>';
        var hidden5='<bean:write name="_JNTCIaddsignInfo" property="retroactive_starttime_search"/>';
        var hidden6='<bean:write name="_JNTCIaddsignInfo" property="retroactive_endtime_search"/>';
        var array = m.split(",");
        $(deleteId_c).val(m);
        document.getElementById("delete_list").disabled = true;
        document.getElementById("admit_list").disabled = true;
        document.getElementById("refuse_list").disabled = true;
        for (var i = 0; i < array.length; i++) {
        	bool = true;
   			$("[name='select']").each(function() {
   				if($(this).parent().next().children().val()==array[i]){
   					$(this).prop("checked", true);
   				  document.getElementById("delete_list").disabled = false;
   				  document.getElementById("admit_list").disabled = false;
   				  document.getElementById("refuse_list").disabled = false;
   				}
   			});
   			}

        $("[name='select']").on("click", function () {

            if ($(this).prop("checked") == true) {

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
                                    var evectionId = $(this).parent().next().children().val()
                                    cards = cards + evectionId + ",";
                                }else {

                                }
                            })
                               cards = cards.substring(0, cards.length - 1);


        var address = $(this).attr("href") + "&deleteExtra_Id=" + cards+","+$(deleteId_c).val()+ "&JN_CARD_SEARCH=" +$('#JN_CARDBC').val() +
        "&USER_NAME_SEARCH=" +$('#JN_USER_NAME').val() +
        "&retroactive_type2=" + $('#retroactive_type2BC').val()+
        "&retroactive_auditss_search=" + $('#retroactive_auditss_search').val()+
        "&retroactive_starttime_search=" + hidden5 +
        "&retroactive_endtime_search=" + hidden6 +
        "&startIndex="+ $('#startIndex').val()+"&mark=aa";
				             $(this).attr("href", address);
    }
	)
	$("#delete_listHide").on("click",function() {
		var cards = "";
		$("[name='select']").each(function() {
				if ($(this).prop("checked") == true) {
					var id_card = $(this).parent().next().children().val()
					cards = cards + id_card + ",";

				}
		})
		cards = cards.substring(0, cards.length - 1)+","+$(deleteId_c).val();

		 $("#deleteExtra_Id").val(cards);

});

        $("#refuse_listHide").on("click",function() {
			var cards = "";
			$("[name='select']").each(function() {
					if ($(this).prop("checked") == true) {
						var id_card = $(this).parent().next().children().val()
						cards = cards + id_card + ",";
					}
			})
			cards = cards.substring(0, cards.length - 1)+","+$(deleteId_c).val();
			$("#deleteExtra_Id").val(cards);
	});

        $("#admit_listHide").on("click",function() {
    		var cards = "";
    		$("[name='select']").each(function() {
    				if ($(this).prop("checked") == true) {
    					var id_card = $(this).parent().next().children().val()
    					cards = cards + id_card + ",";
    				}
    		})
    		cards = cards.substring(0, cards.length - 1)+","+$(deleteId_c).val();
    		$("#deleteExtra_Id").val(cards);
    });

})
    </script>

<script type="text/javascript">
    //日付チェック
    function checkDate() {
        var a = document.getElementById("retroactive2").value;
        var startDate = $("#startDateTime").val();
        var subStartDate = startDate.substring(11, 16);
        var hm1 = subStartDate.replace(":", "").trim();
        var hm11 = '0830';
        var hm12 = '1200';
        var endDate = $("#endDateTime").val();
        var subEndDate = endDate.substring(11, 16);
        var hm2 = subEndDate.replace(":", "").trim();
        var hm21 = '1300';
        var hm22 = '1730';
        if (a == 3) {
                if ((hm1 >= hm11 && hm1 <= hm12)&& (hm2 >= hm21 && hm2 <= hm22)) {
                    $("#flag_date_format").val("131");
                } else {
                    $("#flag_date_format").val("132");
                }

        } else if (a == 2) {
                if (hm2 >= hm21 && hm2 <= hm22) {
                    $("#flag_date_format").val("121");
                } else {
                    $("#flag_date_format").val("122");
                       }
        } else if (a == 1) {
                if (hm1 >= hm11 && hm1 <= hm12) {
                    $("#flag_date_format").val("111");
                } else {
                    $("#flag_date_format").val("112");
                }
        }else{
            $("#flag_date_format").val("0");
        }
    }
    </script>
<script>
//?出框
function delet() {
        if (confirm('削除を確認しますか？')) {
        	document.getElementById('delete_listHide').click();
        } else {
            return false;
        }
    }
</script>

</head>

<body>
    <div>
        <jsp:include page="/top.jsp" flush="true" />
    </div>
    <!--/?部分 -->
    <div style="position: relative;">
        <!--左?部分 -->
        <div style="position: absolute;">
            <jsp:include page="/left.jsp" flush="true" />
        </div>
        <!--/左?部分 -->
        <!--右?部分 -->
        <div class="rightWidht">
            <div class="header">
                <ul class="breadcrumbs clearfix">
                    <li>ステップチャート：</li>
                    <li><a href="#">勤務管理</a></li>
                    <li class="ico">&gt;</li>
                    <li><a href="#">稼働修正審査</a></li>
                </ul>
            </div>

            <div class="main-ctn">
                <!-- <form action="" method=""> -->
                <div id="errorMessageDIV" class="main-ctn,display"
                    style="max-height: 100px; overflow: auto;width:30%; padding-left: 50px">
                		<html:errors />
                        <html:messages id="message" message="true">
                            <bean:write name="message" />
                        </html:messages>
                </div>
                <div class="clearfix">
                    <html:form action="/JNTCIAddsignInfoBL" method="post" styleId="formid">
                        <table width="60%" class="fl addSignInfo">
                            <tr>
                                <th>社員カード:<input type="hidden" id="cod" name="cod" value="reset" /><input type="hidden" id="deleteId_c" name="deleteId_c" value="" /></th>
                                <td><html:text name="_JNTCIaddsignInfo"
                                        property="JN_CARD_SEARCH" maxlength="4"></html:text> <input type="hidden"
                                    id="JN_CARDBC" name="JN_CARDBC"
                                    value="<bean:write name='_JNTCIaddsignInfo' property='JN_CARD_SEARCH'/>" />
                                    <input type="hidden" id="mark" name="mark" value="aa" />
                                </td>
                                 <th>社員名前:</th>
                                 <td><html:text name="_JNTCIaddsignInfo"
                                        property="USER_NAME_SEARCH" maxlength="20"></html:text> <input type="hidden"
                                    id="JN_USER_NAME" name="JN_USER_NAME"
                                    value="<bean:write name='_JNTCIaddsignInfo' property='USER_NAME_SEARCH' />" />
                                </td>

                                <th>補くじタイプ:</th>
                                <td> <input type="hidden" id="retroactive_type2BC"
                                    name="retroactive_type2BC"
                                    value="<bean:write name="_JNTCIaddsignInfo" property="retroactive_type2"/>" />
                                    <html:hidden property="retroactive_type2"
                                        name="_JNTCIaddsignInfo" styleId="retroactive_type_hide" />

                                        <html:select
                                        name="_JNTCIaddsignInfo" property="retroactive_type2"
                                        styleId="retroactive2" onchange="getIndex()"
                                        style="width:120px;">

                                        <option value="" selected="selected">-選択してください-</option>
                                     <%--    <logic:notEmpty name="_JNTCIaddsignInfo"
                                            property="attendance06SelectRecOutput">
                                            <logic:iterate id="jNTCIAttendance06"
                                                name="_JNTCIaddsignInfo"
                                                property="attendance06SelectRecOutput">
                                                <option
                                                    value="<bean:write name="jNTCIAttendance06" property="cd_code" />">
                                                    <bean:write name="jNTCIAttendance06" property="kj_name" />
                                                </option>
                                            </logic:iterate>
                                        </logic:notEmpty> --%>
                                         <t:defineCodeList
                                            id="retroactivetype2Verify1" />
                                        <html:options
                                            collection="retroactivetype2Verify1"
                                            property="id"
                                            labelProperty="name" />
                                    </html:select>
                                  <%--   <input type="hidden" id="retroactive_type2BC"
                                    name="retroactive_type2BC"
                                    value="<bean:write name="_JNTCIaddsignInfo" property="retroactive_type2"/>" />
                                    <html:hidden property="retroactive_type2"
                                        name="_JNTCIaddsignInfo" styleId="retroactive_type_hide" />
                                    <html:select   name="_JNTCIaddsignInfo"    property="retroactive_type2">
                                        <option value="" selected="selected">-選択してください-</option>
                                        <t:defineCodeList
                                            id="retroactivetype2Verify1" />
                                        <html:options
                                            collection="retroactivetype2Verify1"
                                            property="id"
                                            labelProperty="name" />
                                    </html:select>
                                    <input type="hidden" id="retroactive_type2"
                                    name="retroactive_type2"
                                    value="<bean:write name="_JNTCIaddsignInfo" property="retroactive_type2"/>" /> --%></td>

                            </tr>
                             <tr>
                                <th>補くじ時間：</th>

                                <td colspan="3" class="input-time">
                                    <html:text
                                        property="retroactive_starttime_search"
                                        styleId="retroactive_starttime_search"
                                        styleClass="inline laydate-icon" style="width:170px"
                                        readonly="true" /> - <!-- <input type="text" class="mh_date" readonly="true" /> -->
                                    <html:text property="retroactive_endtime_search"
                                        styleId="retroactive_endtime_search"
                                        styleClass="inline laydate-icon"
                                        readonly="true" style="width:170px"/>
                                </td>
                                <th>補くじ審査状態:</th>
                                 <td>
                                    <html:select
                                        name="_JNTCIaddsignInfo"
                                        property="retroactive_auditss_search">
                                        <option value="" selected="selected">-選択してください-</option>
                                        <t:defineCodeList
                                            id="retroactiveVerify1" />
                                        <html:options
                                            collection="retroactiveVerify1"
                                            property="id"
                                            labelProperty="name" />
                                    </html:select>
                                    <input type="hidden" id="retroactive_auditss_search"
                                    name="retroactive_auditss_search"
                                    value="<bean:write name="_JNTCIaddsignInfo" property="retroactive_auditss_search"/>" />
                                </td>
                                </tr>
                        </table>
                        <input type="submit" style="margin: 20px 20px 0;"
                            class="fl btn btn-blue" onclick="checkDate();" value="検索" id="submitButId" />
                    </html:form>

                </div>
                <ts:pageLinks id="userListPageLinks" action="/JNTCIAddsignInfoBL"
                    name="_JNTCIaddsignInfo" rowProperty="row"
                    totalProperty="totalCount" indexProperty="startIndex"
                    currentPageIndex="now" totalPageCount="total">
                </ts:pageLinks>
                <hr />
				<logic:notEmpty name="_JNTCIaddsignInfo"
					property="addsignInfoList">
					<div style="height:570px">
                <table class="ctn" width="100%">
                    <caption>稼働修正審査</caption>
                    <tr>
                        <th style="width: 80px;">選択</th>
                        <th style="width: 100px;">申込ID</th>
                        <th style="width: 80px;">社員カード</th>
                        <th style="width: 100px;">社員名前</th>
                        <th style="width: 120px;">部門所属</th>
                        <th style="width: 120px;">補カードタイプ</th>
                        <th style="width: 120px;">所属上司</th>
                        <th style="width: 120px;">補くじタイプ</th>
                        <th style="width: 200px;">出勤時間</th>
                        <th style="width: 200px;">退勤時間</th>
                        <th style="width: 120px;">補くじ理由</th>
                   		<th >審査結果</th>
						<th>処理</th>
                    </tr>
                    <logic:iterate id="infoqueryId" name="_JNTCIaddsignInfo"
                        property="addsignInfoList">
                        <html:form action="/JNTCIAuditstatUpdateBL" method="post">
                            <tr>
                                <td><input type="checkbox" name="select" id="select" /></td>
                                 <td><bean:write name="infoqueryId" property="RETROACTIVE_ID" />
                                 <html:hidden
                                        property="RETROACTIVE_ID" name="infoqueryId" /></td>
                                <td><bean:write name="infoqueryId" property="JN_CARD" /> <html:hidden
                                        property="JN_CARD" name="infoqueryId" /> <input type="hidden"
                                    id="card_id" name="card_id" value="<bean:write name="infoqueryId" property="RETROACTIVE_ID" />" />
                                     <html:hidden name="_JNTCIaddsignInfo" property="startIndex"></html:hidden>
									<html:hidden name="_JNTCIaddsignInfo" property="JN_CARD_SEARCH"></html:hidden>
									<html:hidden name="_JNTCIaddsignInfo" property="USER_NAME_SEARCH"></html:hidden>
									<html:hidden name="_JNTCIaddsignInfo" property="retroactive_type2"></html:hidden>
									<html:hidden name="_JNTCIaddsignInfo" property="retroactive_auditss_search"></html:hidden>
									<html:hidden name="_JNTCIaddsignInfo" property="retroactive_starttime_search"></html:hidden>
									<html:hidden name="_JNTCIaddsignInfo" property="retroactive_endtime_search"></html:hidden>
									<input type="hidden" id="USER_NAME_SEARCH" name="USER_NAME_SEARCH" value="<bean:write name="_JNTCIaddsignInfo" property="USER_NAME_SEARCH" />" />
									<input type="hidden" id="startIndex" name="startIndex" value="<bean:write name="_JNTCIaddsignInfo" property="startIndex" />" />
                                </td>

                                <td><bean:write name="infoqueryId" property="USER_NAME" />
                                    <html:hidden property="USER_NAME" name="infoqueryId" /></td>
                                <td><bean:write name="infoqueryId" property="k_name" /> <html:hidden
                                        property="k_name" name="infoqueryId" /></td>
			                    <td>
			                        <bean:write name="infoqueryId" property="reason_type"/>
			                         <html:hidden property="reason_type" name="infoqueryId" />
								</td>
                                <td><bean:write name="infoqueryId" property="person" /> <html:hidden
                                        property="person" name="infoqueryId" /></td>
                                <td><bean:write name="infoqueryId"
                                        property="RETROACTIVE_TYPE" /> <html:hidden
                                        property="RETROACTIVE_TYPE" name="infoqueryId" /></td>
                                <td><bean:write name="infoqueryId"
                                        property="start_time_add" /> <html:hidden
                                        property="start_time_add" name="infoqueryId" /></td>
                                <td><bean:write name="infoqueryId" property="end_time_add" />
                                    <html:hidden property="end_time_add" name="infoqueryId" /></td>
                                <td style="white-space: nowrap; overflow: hidden; text-overflow: ellipsis;"><bean:write name="infoqueryId"
                                        property="retroactive_reason" /> <html:hidden
                                        property="retroactive_reason" name="infoqueryId" /></td>

                                <td>
                                <c:if test="${infoqueryId.status == 'A01'}"><span>承認中</span></c:if>
                            	<c:if test="${infoqueryId.status == 'A04' }"><span>未審査</span></c:if>
								<c:if test="${infoqueryId.status == 'A05' }"><span>承認しない</span></c:if>
                                <c:if test="${infoqueryId.status == 'A06'}"><span>終了</span></c:if>
                                <c:if test="${infoqueryId.status == 'A07' }"><span>PM承認しない</span></c:if>
								</td>
                                <td><input type="submit" class="btn btn-green" value="详细" /></td>
							</tr>

                        </html:form>
                    </logic:iterate>

                    <tfoot>
                        <tr>
							<ts:form action="/JNTCIAuditstatDis">
								<html:hidden name="_JNTCIaddsignInfo" property="deleteExtra_Id" styleId="deleteExtra_Id"/>
								 <html:hidden name="_JNTCIaddsignInfo" property="startIndex"></html:hidden>
									<html:hidden name="_JNTCIaddsignInfo" property="JN_CARD_SEARCH"></html:hidden>
									<html:hidden name="_JNTCIaddsignInfo" property="USER_NAME_SEARCH"></html:hidden>
									<html:hidden name="_JNTCIaddsignInfo" property="retroactive_type2"></html:hidden>
									<html:hidden name="_JNTCIaddsignInfo" property="retroactive_auditss_search"></html:hidden>
									<html:hidden name="_JNTCIaddsignInfo" property="retroactive_starttime_search"></html:hidden>
									<html:hidden name="_JNTCIaddsignInfo" property="retroactive_endtime_search"></html:hidden>

								<div style="display:none;">
	                               <ts:submit value="承認しない" styleClass="btn btn-red" property="forward_refuse"
	                                styleId="refuse_listHide"  />
	                               <ts:submit value="承認" styleClass="btn btn-red" property="forward_admit"
	                                styleId="admit_listHide" disabled="disabled" />
	                               <ts:submit value="削除" styleClass="btn btn-red" property="forward_delete"
	                                styleId="delete_listHide" disabled="disabled" />
								</div>
							</ts:form>
                            <td><label style="width: auto">全て選択</label> <input
                                type="checkbox" name="selectAll" id="selectAll" title="全て選択" />
                            </td>
                            <td>
	                           <input type="button" value="複数削除" class="btn btn-red" name="delete"
	                                id="delete_list" disabled="disabled"  onclick="delet()"/>
                            </td>
                              <td>
	                             <input type="button" value="一括承認" class="btn btn-red" name="admit"
	                                id="admit_list" disabled="disabled" onclick="document.getElementById('admit_listHide').click()" />
                            </td>
                            <td>
	                            <input type="button" value="一括承認しない" class="btn btn-red" name="delete" style="margin-left:15px"
	                                id="refuse_list" disabled="disabled" onclick="document.getElementById('refuse_listHide').click()" />
                            </td>
                            <td colspan="8">

                                <div class="pagination">
                                    <!--?数 上下?-->
                                    <div class="pagination">
                                        <ul>
                                            <li>計<b><bean:write name="_JNTCIaddsignInfo"
                                                        property="totalCount" /></b>レコード数

                                            </li>
                                            <li><bean:write name="now" />／<bean:write name="total" /></li>
                                            <li><bean:write name="userListPageLinks" filter="false" /></li>
                                        </ul>
                                    </div>
                             	</div>
                            </td>
                        </tr>
                    </tfoot>
                </table>
                </div>
                </logic:notEmpty>
                <!-- </form> -->
                <div class="footer" style="padding:60px 0 0">
					<p>
						連絡メール：<a href="mailto:jinan@trans-cosmos.com.cn" target="_blank">jinan@trans-cosmos.com.cn</a>
					</p>
				</div>
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

		//日期范?限制
		var start = {
			elem : '#retroactive_starttime_search',
			format : 'YYYY-MM-DD hh:mm',
			istime : true,
			istoday : false,
			choose : function(datas) {
				end.min = datas; //開始日を選択した後、終了日が再設定する。
				end.start = datas //終了日が開始日を設定する。
			}
		};

		var end = {
			elem : '#retroactive_endtime_search',
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
</html>