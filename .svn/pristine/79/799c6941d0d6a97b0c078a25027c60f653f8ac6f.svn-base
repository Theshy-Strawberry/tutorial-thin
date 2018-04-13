<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="/struts-html" prefix="html"%>
<%@ taglib uri="/struts-bean" prefix="bean"%>
<%@ taglib uri="/struts-logic" prefix="logic"%>
<%@ taglib uri="/terasoluna-struts" prefix="ts"%>
<%@ taglib uri="/terasoluna" prefix="t"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html:html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>設備一覧</title>
<meta name="viewport" content="width=device-width,initial-scale=1.0" />
<link rel="stylesheet" type="text/css" href="css/base.css" />
<link rel="stylesheet" type="text/css" href="css/main.css" />
<script type="text/javascript" src="js/jquery-1.11.3.min.js"></script>
<script type="text/javascript">
$(function(){
	$('#left-container .content').hide();
	$('#Equip').show();
	$('h2.tit').click(function(){
		$(this).next('.content').stop().slideToggle();

	});
	var flag = $('#flag').val();
	if(flag != 0 && flag != 3){
		$('.scrap').hide();
		$('.scrap01').hide();
		}

});


</script>

</head>

<body onload ="getflagMethod()">
<!--头部分 -->
	<div>
		<jsp:include page="/top.jsp" flush="true" />
	</div>
	<!--/头部分 -->
	<div style="position:relative;" >
		<!--左侧部分 -->
		<div style="position:absolute;">
			<jsp:include page="/left.jsp" flush="true" />
		</div>
		<!--/左侧部分 -->
		<!--右侧部分 -->
		<div  id="equipLists" class="rightWidht">

	<div class="header">
		<ul class="breadcrumbs clearfix">
			<li>ステップチャート：</li>
			<li><a href="#">設備管理</a></li>
			<li class="ico">&gt;</li>
			<li><a href="#">設備一覧</a></li>
		</ul>
	</div>
           <div class="clearfix">
	      <div style="max-height: 100px; overflow: auto; width: 500px; margin-left: 70px;">
			<html:errors />
			<html:messages id="message" message="true">
				<bean:write name="message" />
			</html:messages>
		</div>
<div class="main-ctn"  style="padding:10px 20px">
	<ts:form styleId="formid"  action="/JNTCIEquipListBL" method="post" >
		 <div class="clearfix">
		 <input id="flag" type="hidden" value="<bean:write name="flag" scope="session" />" />
			<table class="fl seach" style="width:83%">
				<colgroup>
                    <col width="10%" />
                    <col width="15%" />

                    <col width="10%" />
                    <col width="15%" />

                    <col width="10%" />
                    <col width="15%" />

                    <col width="10%" />
                    <col width="15%" />
                </colgroup>
				<tr>
					<td>
						<label>区分：</label>
					</td>
					<td>
						<t:defineCodeList
										id="getSetsubiJyoutaiList" /> <html:select
										name="_JNTCIEquipListForm" styleId="getSetsubiJyoutaiList"
										property="code" >
										<option value="" selected="selected"></option>
										<html:options collection="getSetsubiJyoutaiList" property="id"
											labelProperty="name" />
									</html:select>
					</td>
					<td>
						<label>設備区分：</label>
					</td>
					<td>
						<t:defineCodeList
										id="setsubikubenList" /> <html:select
										name="_JNTCIEquipListForm" styleId="setsubikubenList"
										property="setsubiKubun" >
										<option value="" selected="selected"></option>
										<html:options collection="setsubikubenList" property="id"
											labelProperty="name" />
									</html:select>
					</td>
					<td>
						<label>所属部門名称：</label>
					</td>
					<td>
						<t:defineCodeList
										id="departmentList" /> <html:select
										name="_JNTCIEquipListForm" styleId="departmentList"
										property="deptId" >
										<option value="" selected="selected"></option>
										<html:options collection="departmentList" property="id"
											labelProperty="name" />
									</html:select>
					</td>
					<td>
						<label>社員ID：</label>
					</td>
					<td>
						<html:text name="_JNTCIEquipListForm" property="userId" maxlength="4" ></html:text>
					</td>

				</tr>
			</table>
			<ts:submit styleClass="fl btn btn-blue"  style="margin:5px 50px 0;margin-top: 25px;" value="検索" property="forward_list1"></ts:submit>
		</div>
		<br />
	<logic:notEmpty name="_JNTCIEquipListForm" property="list">

		     <ts:pageLinks id="JNTCIEquipListPageLinks" action="/JNTCIEquipListBL?code=${ _JNTCIEquipListForm.code}&setsubiKubun=${_JNTCIEquipListForm.setsubiKubun}&deptId=${_JNTCIEquipListForm.deptId}&userId=${_JNTCIEquipListForm.userId}"
		name="_JNTCIEquipListForm" rowProperty="row" totalProperty="totalCount"
		indexProperty="startIndex" currentPageIndex="now"
		totalPageCount="total" />

		     <table class="ctn" width="100%">
                <caption>設備一覧</caption>
                <tr>
                  <th width="70px">区分</th>
                  <th width="70px">出入庫番号</th>
                  <th width="70px">出入庫日付</th>
                  <th width="70px">所属者</th>
                  <th width="70px">部門名称</th>
                  <th width="80px">棚卸番号</th>
                  <th width="80px" >設備番号</th>
                  <th width="70px">設備種類</th>
                  <th width="70px">保管方式</th>
                  <th width="80px">保管場所</th>
                  <th width="70px">用途</th>
                  <th width="70px">棚卸人</th>
                  <th width="70px">棚卸日付</th>
                  <th width="100px">操作</th>
                </tr>
            <logic:iterate id="listBean" name="_JNTCIEquipListForm" property="list">
                <tr align="center" class="d">
                	<td>
						<bean:write name="listBean" property="setsubiJyoutai"/>
					</td>
					<td>
						<bean:write name="listBean" property="shunyuNo"/>
					</td>
					<td>
						<bean:write name="listBean" property="shunyukoDate"/>
					</td>
					<td>
						<bean:write name="listBean" property="userId"/>
					</td>
					<td>
						<bean:write name="listBean" property="deptName"/>
					</td>
					<td>
						<bean:write name="listBean" property="tanaoroshiNo"/>
					</td>
					<td>
						<bean:write name="listBean" property="setsubiNo"/>
					</td>
					<td>
						<bean:write name="listBean" property="setsubiShurui"/>
					</td>
					<td>
						<bean:write name="listBean" property="hokanshiki"/>
					</td>
					<td>
						<bean:write name="listBean" property="hokanbasho"/>
					</td>
                    <td align="center">
                    	<bean:write name="listBean" property="youto"/>
                    </td>
                     <td align="center">
                    	<bean:write name="listBean" property="tanaoroshiSya"/>
                    </td>
                    <td align="center">
                    	<bean:write name="listBean" property="tanaoroshiDate"/>
                    </td>
                    <td align="center">
  	                 <a href="${pageContext.request.contextPath}/JNTCIEquipeditor.do?setsubiNo=<bean:write name="listBean" property="setsubiNo"  />&startIndex=<bean:write name="_JNTCIEquipListForm" property="startIndex"/>&shunyuNo=<bean:write name="listBean"  property="shunyuNo" />&code=${ _JNTCIEquipListForm.code}&setsubiKubun=${_JNTCIEquipListForm.setsubiKubun}&deptId=${_JNTCIEquipListForm.deptId}&userId=${_JNTCIEquipListForm.userId}"  class="scrap">編集</a>
                    <span class="scrap01">&nbsp;</span>
                    <a href="${pageContext.request.contextPath}/listOperateBL.do?setsubiNo=<bean:write name="listBean" property="setsubiNo"  />&shunyuNo=<bean:write name="listBean"  property="shunyuNo" />" onclick="window.open(this.href,'_blank','scrollbars=no,resizable=no,width=600,height=600,top=500,left=600');return false">詳細</a>
                     <span class="scrap01">&nbsp;</span>
                   <logic:notEqual  value="廃棄" name="listBean" property="setsubiJyoutai">
                    <a href="${pageContext.request.contextPath}/listOperate.do?setsubiNo=<bean:write name="listBean" property="setsubiNo"  />&shunyuNo=<bean:write name="listBean"  property="shunyuNo" />" onClick="return confirm('廃棄を確認しますか?');" class="scrap">廃棄</a>
                    </logic:notEqual>
                    <logic:equal  value="廃棄" name="listBean" property="setsubiJyoutai">
                    <span class="scrap01">----</span>
                    </logic:equal>
                    </td>
                 </tr>
              </logic:iterate>
            </table>

            <div class="pagination">
            <ul>
                <li>計<b><bean:write name="_JNTCIEquipListForm" property="totalCount" /></b>レコード数</li>
                <li><bean:write name="now" />／<bean:write name="total" /></li>
                <li> <bean:write name="JNTCIEquipListPageLinks" filter="false"/></li>
            </ul>
     </div>
     </logic:notEmpty>
     </ts:form>
     <div class="footer">
	<p>連絡メール：<a href="mailto:jinan@trans-cosmos.com.cn" target="_blank">jinan@trans-cosmos.com.cn</a></p>
</div>
    </div>
</div>
</div>
</div>
</body>
</html:html>

