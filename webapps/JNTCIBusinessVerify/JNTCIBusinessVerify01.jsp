<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="/struts-html" prefix="html"%>
<%@ taglib uri="/struts-bean" prefix="bean"%>
<%@ taglib uri="/struts-logic" prefix="logic"%>
<%@ taglib uri="/terasoluna-struts" prefix="ts"%>
<%@ taglib uri="/terasoluna" prefix="t"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<%
    request.setCharacterEncoding("UTF-8");
%>
<title>出張審査</title>
<link rel="stylesheet" type="text/css" href="css/base.css" />
<link rel="stylesheet" type="text/css" href="css/main.css" />
<link rel="stylesheet" type="text/css" href="Style/skin.css" />
<script type="text/javascript" src="js/jquery-1.11.3.min.js"></script>
<script type="text/javascript">
    $(function() {
        $("#submitButId").click(function() {
            $("#formid").submit();
        })
        var name = $("userNameBC").val();
        if (name != null) {
            $("user_Name").val(name);
        }
        $('#left-container .content').hide();
        $('#Attendance').show();

        $('h2.tit').click(function() {
            $(this).next('.content').stop().slideToggle();
        })
        document.getElementById("delete").disabled = true;
        document.getElementById("sure").disabled = true;
        document.getElementById("unSure").disabled = true;
        $("#selectAll").click(function() {
            if ($(this).prop("checked") == true) {
                $("[name='select']").prop("checked", true);
                document.getElementById("delete").disabled = false;
                document.getElementById("sure").disabled = false;
                document.getElementById("unSure").disabled = false;
            } else {
                $("[name='select']").prop("checked", false);
                document.getElementById("delete").disabled = true;
                document.getElementById("sure").disabled = true;
                document.getElementById("unSure").disabled = true;
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
            document.getElementById("delete").disabled = bool;
            document.getElementById("sure").disabled = bool;
            document.getElementById("unSure").disabled = bool;
        });

        $("#delete").on(
				"click",
				function() {
					if (confirm("削除したら、取り戻すことができません。本当に削除しますか")) {
						var cards = "";
						$("[name='select']")
								.each(
										function() {
											if ($(this).prop("checked") == true) {
												var id_card = $(this).parent().next().text();
												var arraylist = $(
														"#deleteId_card")
														.val().split(",");
												var symb = 0;
												for (var i = 0; i < arraylist.length; i++) {
													if (id_card == arraylist[i]) {
														symb = symb + 1;
													}
												}
												if (symb == 0) {
													cards = id_card + ","
															+ cards;
												}
											}
										})
						var selectlist ="";
						var arraylist = $("#deleteId_card").val().split(",");
						if (arraylist.length > 1) {
							for (var i = 0; i < arraylist.length; i++) {
								var quality = "[name='select']"
										+ "[value='" + arraylist[i] + "']";
								if ($(quality).prop("checked") != false) {
									selectlist = arraylist[i] + ","
											+ selectlist;
								}
							}
						}
						$("#deleteId_card").val(selectlist);
						if (selectlist == "" || selectlist == " ") {
						} else {
							cards = selectlist + cards;
						}
						cards = cards.substring(0, cards.length - 1);
						 $("#deleteId_card2").val(cards);
						 $("#formitDelete").submit();
            }
        })

         $("#sure").on("click", function() {

            if (confirm("確定すると、元へは戻る事はできません、確定しますか？")) {
            	var cards = "";
				$("[name='select']")
						.each(
								function() {
									if ($(this).prop("checked") == true) {
										var id_card = $(this).parent().next().text();
										var arraylist = $(
												"#deleteId_card")
												.val().split(",");
										var symb = 0;
										for (var i = 0; i < arraylist.length; i++) {
											if (id_card == arraylist[i]) {
												symb = symb + 1;
											}
										}
										if (symb == 0) {
											cards = id_card + ","
													+ cards;
										}
									}
								})
				var selectlist ="";
				var arraylist = $("#deleteId_card").val().split(",");
				if (arraylist.length > 1) {
					for (var i = 0; i < arraylist.length; i++) {
						var quality = "[name='select']"
								+ "[value='" + arraylist[i] + "']";
						if ($(quality).prop("checked") != false) {
							selectlist = arraylist[i] + ","
									+ selectlist;
						}
					}
				}
				$("#deleteId_card").val(selectlist);
				if (selectlist == "" || selectlist == " ") {
				} else {
					cards = selectlist + cards;
				}
				cards = cards.substring(0, cards.length - 1);
				 $("#deleteId_card").val(cards);
				 $("#formitOk").submit();
            }
        })


         $("#unSure").on("click", function() {

            if (confirm("確定すると、元へは戻る事はできません、確定しますか？")) {
            	var cards = "";
				$("[name='select']")
						.each(
								function() {
									if ($(this).prop("checked") == true) {
										var id_card = $(this).parent().next().text();
										var arraylist = $(
												"#deleteId_card")
												.val().split(",");
										var symb = 0;
										for (var i = 0; i < arraylist.length; i++) {
											if (id_card == arraylist[i]) {
												symb = symb + 1;
											}
										}
										if (symb == 0) {
											cards = id_card + ","
													+ cards;
										}
									}
								})
				var selectlist = "";
				var arraylist = $("#deleteId_card").val().split(",");
				if (arraylist.length > 1) {
					for (var i = 0; i < arraylist.length-1; i++) {
						var quality = "[name='select']"
								+ "[value='" + arraylist[i] + "']";
						if ($(quality).prop("checked") != false) {
							selectlist = arraylist[i] + ","+ selectlist;
						}
					}
				}
				$("#deleteId_card").val(selectlist);
				if (selectlist == "" || selectlist == " ") {
				} else {
					cards = selectlist + cards;
				}
				cards = cards.substring(0, cards.length - 1);
				$("#deleteId_card1").val(cards);
				 $("#formitNO").submit();
            }
        })
        $("td li a").on(
    			"click",
    			function() {
    				var record = "";
    				$("[name='select']").each(function() {
    					if ($(this).prop("checked") == true) {
    						var id_card =  $(this).parent().next().text();
    						var arraylist = $("#deleteId_card").val().split(",");
    						var symb = 0;
    						for (var i = 0; i < arraylist.length-1; i++) {
    							if (id_card == arraylist[i]) {
    								symb = symb + 1;
    							}
    						}
    						if (symb == 0) {
    							record = id_card + "," + record;
    						}
    					}
    				})
    				var selectlist = "";
    				var arraylist = $("#deleteId_card").val().split(",");
    				if (arraylist.length > 1) {
    					for (var i = 0; i < arraylist.length-1; i++) {
    						var quality = "[name='select']" + "[value='"
    								+ arraylist[i] + "']";
    						if ($(quality).prop("checked") != false) {
    							selectlist = arraylist[i] + "," + selectlist;
    						}
    					}
    				}
    				$("#deleteId_card").val(selectlist);
    				if (selectlist == "" || selectlist == " ") {
    				} else {
    					record = selectlist + record;
    				}
    				var address = $(this).attr("href") + "&deleteId_card=" + record+"&mark=6";
    				$(this).attr("href", address);
    			})

    	var array = $("#deleteId_card").val().split(",");
    	for (var i = 0; i < array.length; i++) {
    	/* 	var quality = "[name='select']" + "[value='" + array[i] + "']";
    		$(quality).prop("checked", true); */
    		bool = true;
   			$("[name='select']").each(function() {
   				if($(this).parent().next().text()==array[i]){
   					$(this).prop("checked", true);
   					document.getElementById("delete").disabled = false;
   				}

   			});
    	}
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
         document.getElementById("sure").disabled = bool;
         document.getElementById("unSure").disabled = bool;
    	var count = 0;
    	$("[name='select']").each(function() {
    		if ($(this).prop("checked") == true) {
    			count++;
    		}
    	})
    	if($("[name='select']").length==count){
    		$("#selectAll").prop("checked",true);
    	}
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
                    <li><a href="#">勤務管理</a></li>
                    <li class="ico">&gt;</li>
                    <li><a href="#">出張審査</a></li>
                </ul>
            </div>

            <div class="main-ctn">
                <p style="color: red;">
                    <html:errors />
                    <html:messages id="message" message="true">
                        <bean:write name="message" />
                    </html:messages>
                </p>
                <ts:form styleId="formid"
                    action="/JNTCIBusinessVerify01BL">
                    <div class="clearfix">
                        <table class="fl table-bar">
                            <colgroup>
                                <col style="width: 100px" />
                                <col style="width: 130px" />
                                <col style="width: 100px" />
                                <col style="width: 130px" />
                                <col style="width: 100px" />
                                <col style="width: 160px" />
                                <col style="width: 100px" />
                                <col style="width: 160px" />
                            </colgroup>
                            <tr>
                                <th>社員カード：</th>
                                <td><html:text property="user_Id"
                                        name="_JNTCIBusinessVerifyForm01" maxlength="4" /></td>
                                <th>社員名前： <input type="hidden"
                                    id="cod" name="cod" value="reset"/> <input
                                    type="hidden" id="userNameBC"
                                    name="userNameBC"
                                    value="<bean:write name="_JNTCIBusinessVerifyForm01" property="user_Name"/>" />
                                </th>
                                <td><html:text property="user_Name"
                                        name="_JNTCIBusinessVerifyForm01"
                                        styleId="user_Name" maxlength="20"/></td>
                                <th>部門所属：</th>
                                <td><html:select
                                        name="_JNTCIBusinessVerifyForm01"
                                        property="dept_Id">
                                        <option value="">--選択ください--</option>
                                        <t:defineCodeList
                                            id="businessVerifyDeptList" />
                                        <html:options
                                            collection="businessVerifyDeptList"
                                            property="id"
                                            labelProperty="name" />
                                    </html:select></td>
                                <%--
                     	<option value="">--選択ください--</option>
                        <logic:iterate id="JNTCIBusinessVerifyFormBean" name="_JNTCIBusinessVerifyForm01" property="deptList">
                        <option value="<bean:write name="JNTCIBusinessVerifyFormBean" property="CD_CODE" />"><bean:write name="JNTCIBusinessVerifyFormBean" property="KJ_NAME" /></option>
                         </logic:iterate>
                         </html:select>
                         </td>
                         --%>
                                <th>審査状態：</th>
                                <td><html:select
                                        name="_JNTCIBusinessVerifyForm01"
                                        property="examine_Status">
                                        <option value="">--選択ください--</option>
                                        <t:defineCodeList
                                            id="businessVerifyStatusList" />
                                        <html:options
                                            collection="businessVerifyStatusList"
                                            property="id"
                                            labelProperty="name" />
                                    </html:select></td>
                            </tr>
                        </table>
                        <input name="検索" type="button" value="検索"
                            style="margin: 16px 20px 0;"
                            class="btn btn-blue fl" id="submitButId" />
                    </div>
                </ts:form>
                <ts:pageLinks id="JNTCIBusinessVerify01ListPageLinks"
                    action="/JNTCIBusinessVerify01BL?user_Id=${_JNTCIBusinessVerifyForm01.user_Id }&user_Name=${_JNTCIBusinessVerifyForm01.user_Name}&dept_Id=${_JNTCIBusinessVerifyForm01.dept_Id }&examine_Status=${_JNTCIBusinessVerifyForm01.examine_Status}"

                    name="_JNTCIBusinessVerifyForm01" rowProperty="row"
                    totalProperty="totalCount"
                    indexProperty="startIndex" currentPageIndex="now"
                    totalPageCount="total" />
                <hr />
                <table class="ctn" width="100%">
                    <caption>出張審査一覧</caption>
                    <tr>
                        <th>選択</th>
                        <th>出張番号</th>
                        <th>社員カード</th>
                        <th>社員名前</th>
                        <th>部門所属</th>
                        <th>出張先</th>
                        <th width="200px">出張開始日</th>
                        <th width="200px">出張終了日</th>
                        <th>部門PM</th>
                        <th>審査状態</th>
                        <th>操作</th>
                    </tr>

                    <logic:notEmpty name="_JNTCIBusinessVerifyForm01"
                        property="JNTCIBusinessVerifyVoInfo">
                        <logic:iterate id="JNTCIBusinessVerifyFormBean"
                            name="_JNTCIBusinessVerifyForm01"
                            property="JNTCIBusinessVerifyVoInfo">

                            <tr align="center" class="d">
                            <logic:equal name="userId" scope="session" value="1072">
                            <td><input type="checkbox" name="select" id="select"   disabled="disabled" /></td>
                            </logic:equal>
                            <logic:notEqual name="userId" scope="session" value="1072">
                                 <logic:equal value="終了"
                                        name="JNTCIBusinessVerifyFormBean"
                                        property="examineStatus">
                                        <td><input type="checkbox"
                                            name="select" id="select"   disabled="disabled" /></td>
                                  </logic:equal>
                                  <logic:equal value="承認しない"
                                        name="JNTCIBusinessVerifyFormBean"
                                        property="examineStatus">
                                        <td><input type="checkbox"
                                            name="select" id="select"   disabled="disabled" /></td>
                                  </logic:equal>
                                    <logic:notEqual value="終了"
                                                name="JNTCIBusinessVerifyFormBean"
                                                property="examineStatus">
                                             <logic:notEqual value="承認しない"
                                                name="JNTCIBusinessVerifyFormBean"
                                                property="examineStatus">
                                                <td><input
                                                    type="checkbox"
                                                    name="select"
                                                    id="select"
                                                   /></td>
                                              </logic:notEqual>
                                            </logic:notEqual>
                                    </logic:notEqual>
                                <td align="center"><bean:write
                                        name="JNTCIBusinessVerifyFormBean"
                                        property="evectionId" /></td>
                                <td align="center"><bean:write
                                        name="JNTCIBusinessVerifyFormBean"
                                        property="uid1" /></td>
                                <td align="center"><bean:write
                                        name="JNTCIBusinessVerifyFormBean"
                                        property="uname1" /></td>
                                <td align="center"><bean:write
                                        name="JNTCIBusinessVerifyFormBean"
                                        property="deptId" /></td>
                                <td align="center"><bean:write
                                        name="JNTCIBusinessVerifyFormBean"
                                        property="evectionDestination" /></td>
                                <td align="center"><bean:write
                                        name="JNTCIBusinessVerifyFormBean"
                                        property="evectionStartTime" /></td>
                                <td align="center"><bean:write
                                        name="JNTCIBusinessVerifyFormBean"
                                        property="evectionEndTime" /></td>
                                <td align="center"><bean:write
                                        name="JNTCIBusinessVerifyFormBean"
                                        property="projectPm" /></td>
                                <td align="center"> <html:hidden
                                        styleId="examineStatus"
                                        name="JNTCIBusinessVerifyFormBean"
                                        property="examineStatus"></html:hidden><a
                                    href="${pageContext.request.contextPath}/JNTCIBusinessVerify02forwardBL.do?evectionId=<bean:write
					name="JNTCIBusinessVerifyFormBean" property="evectionId" />&startIndex=<bean:write
					name="_JNTCIBusinessVerifyForm01" property="startIndex" />&user_Id=<bean:write
					name="_JNTCIBusinessVerifyForm01" property="user_Id" />&user_Name=<bean:write
					name="_JNTCIBusinessVerifyForm01" property="user_Name" />&dept_Id=<bean:write
					name="_JNTCIBusinessVerifyForm01" property="dept_Id" />&examine_Status=<bean:write
					name="_JNTCIBusinessVerifyForm01" property="examine_Status" />"><bean:write
                                            name="JNTCIBusinessVerifyFormBean"
                                            property="examineStatus" /></a></td>
                               <td><a
                                    href="${pageContext.request.contextPath}/JNTCIBusinessVerifyDetailedBL.do?evectionId=<bean:write name="JNTCIBusinessVerifyFormBean" property="evectionId" />&startIndex=<bean:write
					name="_JNTCIBusinessVerifyForm01" property="startIndex" />&user_Id=<bean:write
					name="_JNTCIBusinessVerifyForm01" property="user_Id" />&user_Name=<bean:write
					name="_JNTCIBusinessVerifyForm01" property="user_Name" />&dept_Id=<bean:write
					name="_JNTCIBusinessVerifyForm01" property="dept_Id" />&examine_Status=<bean:write
					name="_JNTCIBusinessVerifyForm01" property="examine_Status" />">
                                        <img
                                        src="images/search-cion.png"
                                        width="20px" height="20px"
                                        title="査看詳細の情報" />
                                </a> <a
                                    href="/tutorial-thin/JNTCIBusinessVerifydownloadBL.do?evectionId=<bean:write name="JNTCIBusinessVerifyFormBean" property="evectionId" />"
                                    title="ダウンロード履歴書"
                                    style="margin-left: 5px;"><img
                                        src="images/download-cion.png"
                                        width="20px" height="20px" /></a> <a
                                    href="${pageContext.request.contextPath}/JNTCIBusinessVerifyUpdateBL.do?evectionId=<bean:write name="JNTCIBusinessVerifyFormBean" property="evectionId" />&startIndex=<bean:write
					name="_JNTCIBusinessVerifyForm01" property="startIndex" />&user_Id=<bean:write
					name="_JNTCIBusinessVerifyForm01" property="user_Id" />&user_Name=<bean:write
					name="_JNTCIBusinessVerifyForm01" property="user_Name" />&dept_Id=<bean:write
					name="_JNTCIBusinessVerifyForm01" property="dept_Id" />&examine_Status=<bean:write
					name="_JNTCIBusinessVerifyForm01" property="examine_Status" />">
                                        <img src="images/edit-cion.png"
                                        width="20px" height="20px"
                                        title="修正" />
                                </a></td>
                            </tr>
                        </logic:iterate>

                    <tfoot>
                        <tr>
                        <logic:equal name="userId" scope="session" value="1072">
                        <td><label style="width: auto">全て選択</label>
                                <input type="checkbox" name="selectAll"
                                id="selectAll" title="全て選択"  disabled="disabled" /></td>
                        </logic:equal>
                           <logic:notEqual name="userId" scope="session" value="1072">
                           <td><label style="width: auto">全て選択</label>
                                <input type="checkbox" name="selectAll"
                                id="selectAll" title="全て選択"  /></td>
                           </logic:notEqual>

                            <td><input type="button" value="削除"
                                class="btn btn-red" id="delete" /></td>
                                <html:form action="/JNTCIBusinessVerifySureBL"  styleId="formitOk" >
                                <html:hidden property="deleteId_card" name="_JNTCIBusinessVerifyForm01" styleId="deleteId_card"/>
                                <html:hidden property="startIndex" name="_JNTCIBusinessVerifyForm01" styleId="startIndex"/>
                                <html:hidden property="user_Id" name="_JNTCIBusinessVerifyForm01" styleId="user_Id"/>
                                <html:hidden property="user_Name" name="_JNTCIBusinessVerifyForm01" styleId="user_Name"/>
                                <html:hidden property="dept_Id" name="_JNTCIBusinessVerifyForm01" styleId="dept_Id"/>
                                <html:hidden property="examine_Status" name="_JNTCIBusinessVerifyForm01" styleId="examine_Status"/>
                                 <input type="hidden"  id="cod" name="cod" value="reset"/>
                                </html:form>
                                 <html:form action="/JNTCIBusinessVerifyDeleteBL"  styleId="formitDelete" >
                                <html:hidden property="deleteId_card" name="_JNTCIBusinessVerifyForm01" styleId="deleteId_card2"/>
                                <html:hidden property="startIndex" name="_JNTCIBusinessVerifyForm01" styleId="startIndex"/>
                                <html:hidden property="user_Id" name="_JNTCIBusinessVerifyForm01" styleId="user_Id"/>
                                <html:hidden property="user_Name" name="_JNTCIBusinessVerifyForm01" styleId="user_Name"/>
                                <html:hidden property="dept_Id" name="_JNTCIBusinessVerifyForm01" styleId="dept_Id"/>
                                <html:hidden property="examine_Status" name="_JNTCIBusinessVerifyForm01" styleId="examine_Status"/>
                                 <input type="hidden"  id="cod" name="cod" value="reset"/>
                                </html:form>
                                <html:form action="/JNTCIBusinessVerifyUnSureBL"  styleId="formitNO" >
                                <html:hidden property="deleteId_card" name="_JNTCIBusinessVerifyForm01" styleId="deleteId_card1"/>
                                <html:hidden property="startIndex" name="_JNTCIBusinessVerifyForm01" styleId="startIndex"/>
                                <html:hidden property="user_Id" name="_JNTCIBusinessVerifyForm01" styleId="user_Id"/>
                                <html:hidden property="user_Name" name="_JNTCIBusinessVerifyForm01" styleId="user_Name"/>
                                <html:hidden property="dept_Id" name="_JNTCIBusinessVerifyForm01" styleId="dept_Id"/>
                                <html:hidden property="examine_Status" name="_JNTCIBusinessVerifyForm01" styleId="examine_Status"/>
                                 <input type="hidden"  id="cod" name="cod" value="reset"/>
                                </html:form>
                               <td><input type="button" value="一括承認" class="btn btn-red" id="sure" /></td>
                                <td><input type="button" value="一括承認しない" class="btn btn-red" id="unSure" style="margin-left:20px"/></td>
                            <td colspan="9">
                                <div class="pagination clearfix">
                                    <ul style="float: right;">
                                        <li>計<b><bean:write
                                                    name="_JNTCIBusinessVerifyForm01"
                                                    property="totalCount" /></b>レコード
                                        </li>
                                        <li><bean:write name="now" />／<bean:write
                                                name="total" /></li>
                                        <li><bean:write
                                                name="JNTCIBusinessVerify01ListPageLinks"
                                                filter="false" /></li>
                                    </ul>
                                </div>
                            </td>
                        </tr>
                    </tfoot>

 </logic:notEmpty>
                </table>

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
</html>
