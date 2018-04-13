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
<title>設備編集</title>
<link rel="stylesheet" type="text/css" href="css/base.css" />
<link rel="stylesheet" type="text/css" href="css/main.css" />
<link rel="stylesheet" type="text/css"
       href="${pageContext.request.contextPath}/css/scroll.css" />
<script type="text/javascript" src="js/laydate/laydate.js"></script>
<script type="text/javascript" src="js/jquery-1.11.3.min.js"></script>
<script type="text/javascript" src="js/jquery.validate.js" ></script>
<script type="text/javascript">
       $(function() {
           hidden1='<bean:write name="_JNTCIEquipListForm" property="startIndex"/>';
           hidden2= '<bean:write name="_JNTCIEquipListForm" property="code"/>';
           hidden3='<bean:write name="_JNTCIEquipListForm" property="setsubiKubun"/>';
           hidden4='<bean:write name="_JNTCIEquipListForm" property="deptId"/>';
           hidden5='<bean:write name="_JNTCIEquipListForm" property="userId"/>';
       $('#left-container .content').hide();
       $('#Equip').show();
       $('h2.tit').click(function() {
              $(this).next('.content').stop().slideToggle();

       })

       })

       function onSubimitfun(type){
    		if(type == "1"){
    			$("#hidden_state").val("1");
    			 if(confirm('確認しますか？')){
    				 $("#formid").submit();
    				 }else{
    					 return false;
    				 }
    		}else if(type == "2"){
    			$("#hidden_state").val("2");
    			 if(confirm('強制帰庫しますか？')){
    				 $("#formid").submit();
    				 }else{
    					 return false;
    				 }
    		}else if(type == "3"){
    			$("#getlocationList").get(0).selectedIndex=0;
    			$("#getYoutoList").get(0).selectedIndex=0;
    			 $("#tanaoroshi_hiduke").val('');
    			 $("#shunyuko_date").val('');
    			 $("#tanaoroshi_hiduke").val('');
    			 $("#shunyuko_no").val('');
    			 $("#setsubi_no").val('');
    			 $("#setsubi_kanaoroshi_no").val('');
    			 $("#tanaoroshi_user").val('');
    		}else{}
       }
</script>
<script type="text/javascript">
function subimit() {
        $("#formid").attr('action',
                '/tutorial-thin/JNTCIEquipfanhui.do?cod=back'+"&startIndex=" + hidden1+"&code="+hidden2
                +"&setsubiKubun="+hidden3+"&deptId="+hidden4+"&userId="+hidden5);
        $("#formid").submit();
    }
</script>
</head>
<body onload="getflagMethod();">
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
       <div  id="insertMg" class="rightWidht">
              <div class="header">
              <ul class="breadcrumbs clearfix">
              <li>ステップチャート：</li>
              <li><a href="#">設備管理</a></li>
              <li class="ico">&gt;</li>
              <li><a href="#">設備編集</a></li>
              </ul>
              </div>
              <div class="main-ctn ul-li equip-apply">
              <!-- 設備番号を追加する -->
              <ts:form action="/JNTCIEquipEditorBL" styleId="formid" method="post">
              <div class="clearfix">
                     <div
                     style="max-height: 100px; overflow: auto; width: 500px; margin-left: 70px;">
                     <html:errors />
                     <html:messages id="message" message="true">
                            <bean:write name="message" />
                     </html:messages>
                     </div>
                     <ul>
                    <li><label>設備種類：</label>
                     <html:text property="setsubi_kuben" name="_JNTCIEquipListForm" readonly="true"
                                      styleId="setsubi_kuben"  style="width:150px;" />
                                      <html:hidden property="startIndex" name="_JNTCIEquipListForm"/>
                                      <html:hidden property="code" name="_JNTCIEquipListForm"/>
                                      <html:hidden property="setsubiKubun" name="_JNTCIEquipListForm"/>
                                      <html:hidden property="deptId" name="_JNTCIEquipListForm"/>
                                      <html:hidden property="userId" name="_JNTCIEquipListForm"/>
                        </li>
                           <li><label>ユーザー：</label>
                            <html:text property="userpg" name="_JNTCIEquipListForm" readonly="true"
                                      styleId="userpg"  style="width:150px;" />
						</li>
                      <li><label>保管方式：</label>
                     <t:defineCodeList id="getlocationList" />
                            <html:select name="_JNTCIEquipListForm" styleId="getlocationList"
                                                property="equipLocation" style="width:158px; ">
                                                <option value="" selected="selected"></option>
                                                <html:options collection="getlocationList" property="id" labelProperty="name" />
                            </html:select> <i class="red">*</i></li>
                     <li><label>設備用途：</label>
                     <t:defineCodeList id="getYoutoList" />
                            <html:select name="_JNTCIEquipListForm" styleId="getYoutoList"
                                                property="youto" style="width:158px; ">
                                                <option value="" selected="selected"></option>
                                                <html:options collection="getYoutoList" property="id" labelProperty="name" />
                            </html:select> <i class="red">*</i></li>
                     <li><label>棚卸日付：</label>
                     <html:text property="tanaoroshi_hiduke" styleClass="inline laydate-icon" name="_JNTCIEquipListForm"
                                        styleId="tanaoroshi_hiduke" readonly="true"></html:text>
                                         <i class="red">*</i></li>
                     <li><label>入庫日付：</label>
                      <html:text property="shunyuko_date"
                                       styleClass="inline laydate-icon" styleId="shunyuko_date" name="_JNTCIEquipListForm"
                                       readonly="true"></html:text> <i class="red">*</i></li>
                     <li><label>入庫番号：</label>
                      <html:text property="shunyuko_no"
                                       styleId="shunyuko_no"  style="width:150px;" name="_JNTCIEquipListForm" />
                                       <input type="hidden" name="before_shunyuko_no"  value="<bean:write name="_JNTCIEquipListForm" property="shunyuko_no"/>" />
                                        <i class="red">*</i></li>
                     <li><label>設備番号：</label>
                     <html:text property="setsubi_no" styleId="setsubi_no"   style="width:150px;" name="_JNTCIEquipListForm" />
                     <input type="hidden" name="before_no"  value="<bean:write name="_JNTCIEquipListForm" property="setsubi_no"/>" />
                     <input type="hidden" name="reutrnman"  value="<bean:write name="userId" scope="session" ignore="true"/>" />
                      <i class="red">*</i></li>
                     <li><label>棚卸番号：</label>
                     <html:text property="setsubi_kanaoroshi_no" name="_JNTCIEquipListForm"
                                      styleId="setsubi_kanaoroshi_no"  style="width:150px;" />
                                       <i class="red">*</i></li>
                     <li><label>棚卸人カード：</label>
                      <html:text   property="tanaoroshi_user" styleId="tanaoroshi_user"  maxlength="4"  style="width:150px;" name="_JNTCIEquipListForm" />
                      <i class="red">*</i></li>
                     </ul>
                     <p>
                     <input style="margin-left: 110px;width:80px;height:25px" type="button"  value="更新" onclick="onSubimitfun(1)" class="btn btn-blue"/>
                     <input class="btn btn-green" value="クリア"  style="margin-left:20px;width:80px;height:25px" type="button" onclick="onSubimitfun(3)"/>
                     <input style="margin-left: 25px;width:80px;height:25px" type="button"  value="強制帰庫" onclick="onSubimitfun(2)" class="btn btn-red"/>
                     <input type="hidden" id ="hidden_state" name ="hidden_state" />
                     <input type="hidden" id="cod" name="cod" value="" />
                     <input style="margin-left: 25px;width:80px;height:25px" type="button"  value="戻る" id="getback" onclick="subimit()" class="btn btn-green"/>
                     </p>
              </div>
              </ts:form>
              <div class="footer">
              <p>
                     連絡メール：<a href="mailto:jinan@trans-cosmos.com.cn" target="_blank">jinan@trans-cosmos.com.cn</a>

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

       //入庫日付
       var shunyuko_date = {
       elem : '#shunyuko_date',
       format : 'YYYY/MM/DD',
       max : laydate.now(),
       istime : true,
       istoday : false
       };
       //棚卸日付
       var tanaoroshi_hiduke = {
       elem : '#tanaoroshi_hiduke',
       format : 'YYYY/MM/DD',
       max : laydate.now(),
       istime : true,
       istoday : false
       };

       laydate(shunyuko_date);
       laydate(tanaoroshi_hiduke);
</script>