<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="/struts-html" prefix="html" %>
<%@ taglib uri="/struts-bean" prefix="bean" %>
<%@ taglib uri="/struts-logic" prefix="logic" %>
<%@ taglib uri="/terasoluna-struts" prefix="ts" %>
<%@ taglib uri="/terasoluna" prefix="t" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html:html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>設備一覧</title>
<link rel="stylesheet" type="text/css" href="css/base.css" />
<link rel="stylesheet" type="text/css" href="css/main.css" />
<script type="text/javascript" src="js/jquery-1.11.3.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	var value = '<bean:write name="_JNTCIEquipListForm" property="setsubiShurui"/>';
	if(value=="主機"){
	 $('.detail').show();
	}
	else{
		 $('.detail').hide();
	}
});

</script>

</head>

<body>
<!--头部分 -->
	<div class="header">
		<ul class="breadcrumbs clearfix">
			<li>ステップチャート：</li>
			<li><a href="#">設備管理</a></li>
			<li class="ico">&gt;</li>
			<li><a href="/JNTCTEquip/JNTCIEquipList.jsp">設備一覧</a></li>
			<li class="ico">&gt;</li>
			<li><a href="#">詳細</a></li>
		</ul>
	</div>
           <div class="clearfix">
	      <div style="max-height: 100px; overflow: auto; width: 500px; margin-left: 70px;">
			<html:errors />
			<html:messages id="message" message="true">
				<bean:write name="message" />
			</html:messages>
		</div>
<div class="main-ctn" id="detailEquip">
			<span>設備番号：</span>  <bean:write name="_JNTCIEquipListForm"  property="setsubiNo"/><br />
			<span>設備種類：</span><bean:write name="_JNTCIEquipListForm" property="setsubiShurui"/><br />
			<span>設備規格：</span><bean:write name="_JNTCIEquipListForm"  property="setsubiKiKaku"/><br />
			<span>設備型番：</span><bean:write name="_JNTCIEquipListForm"  property="setsubiKataban"/><br />
			<span>単価：</span><bean:write name="_JNTCIEquipListForm"  property="setsubiTanka"/><br />
			<span>購入日：</span><bean:write name="_JNTCIEquipListForm"  property="setsubiKonyuhi"/><br />
			<span>購入者：</span><bean:write name="_JNTCIEquipListForm"  property="setsubiKonYusya"/><br />
			<span>設備メーカー：</span><bean:write name="_JNTCIEquipListForm"  property="setsubiMaker"/><br />
			<div class="detail">
				<span>CPU：</span><bean:write name="_JNTCIEquipListForm"  property="cpu"/><br />
				<span>CPU配置：</span><bean:write name="_JNTCIEquipListForm"  property="cpuHaichi"/><br />
				<span>メモリ：</span><bean:write name="_JNTCIEquipListForm"  property="memori"/><br />
				<span>ハードディスク：</span><bean:write name="_JNTCIEquipListForm"  property="hardDisk"/><br />
				<span>ハードディスク総量：</span><bean:write name="_JNTCIEquipListForm"  property="hardDiskTotal"/><br />
				<span>MACアドレス：</span><bean:write name="_JNTCIEquipListForm"  property="mac"/><br />
			</div>
			<div class="footer">
				<p>連絡メール：<a href="mailto:jinan@trans-cosmos.com.cn" target="_blank">jinan@trans-cosmos.com.cn</a></p>
			</div>
    </div>
</div>

</body>
</html:html>

