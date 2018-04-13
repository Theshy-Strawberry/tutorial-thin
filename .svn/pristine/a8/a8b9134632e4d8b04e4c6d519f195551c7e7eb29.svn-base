     <%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="/struts-html" prefix="html"%>
<%@ taglib uri="/struts-bean" prefix="bean"%>
<%@ taglib uri="/struts-logic" prefix="logic"%>
<%@ taglib uri="/terasoluna-struts" prefix="ts"%>
<%@ taglib uri="/terasoluna" prefix="t"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/base.css" />
<link rel="stylesheet" type="text/css" href="css/main.css" />
<script type="text/javascript" src="js/laydate/laydate.js"></script>
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/JNTCIPersonInfo.js"></script>
<script type="text/javascript" src="js/jquery-1.11.3.min.js"></script>
<style>
#add_table td{
border-style:none;
}
</style>
<script type="text/javascript">
    $(function() {
        $('#left-container .content').hide();
        $('#Attendance').show();
        $('h2.tit').click(function() {
            $(this).next('.content').stop().slideToggle();

        })
    })

    function onSubimitfun(type, index) {
        if (type == "1") {
            $(index).val("delete");
            var config =  confirm('本当に削除しますか?');
            if(config == true ){
            	  this.form.submit();
            }else{
            	return false;
            }
        } else if (type == "2") {
            $(index).val("update");
            this.form.submit();
        }
    }
</script>
<script type="text/javascript">
	$(
			function() {
				var value = $("#selectCheck").val();
				if (value != null) {
					$("#name option[value='" + value + "']").attr(
							"selected", false);
					$("#name option[value='" + value + "']").attr(
							"selected", true);
				}
			})
</script>
<script>
 function bao(s){
	$("#selectCheck").val(s);
}
</script>
</head>
<body>
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
                    <li><a href="#">休暇追加</a></li>
                </ul>
            </div>
            <div class="main-ctn"
                style="max-height: 100px; overflow: auto;">
                <html:errors />
                <html:messages id="message" message="true">
                    <bean:write name="message" />
                </html:messages>
            </div>
            <div class="main-ctn">
                <center>
                    <ts:form action="/writeholidayBL1">
                        <p>祝祭日と休暇名称を追加してください：</p>
                        <br>
               <table id="add_table">
                        <tr>
                        <td>休暇名称：</td>
                        <td><html:text property="name2" name="_Wform"
                            styleId="name" onblur="checkname()"/></td>
                        <td><span style="color:red">*</span></td>
                        <td> &nbsp;&nbsp;&nbsp;&nbsp;~~&nbsp;&nbsp;&nbsp;&nbsp;</td>
                        <td>休暇開始時間：</td>
                        <td><html:text property="startyear" name="_Wform"
						styleId="startholidaydate"  styleClass="laydate-icon"/></td>
                        <td>&nbsp;&nbsp;</td>
						<td>休暇終了時間：</td>
                        <td><html:text property="endyear" name="_Wform"
						styleId="endholidaydate"  styleClass="laydate-icon"/></td>
                        </tr>
                        </table>
           <p>
                            <ts:submit value="提出 "
                                styleClass="btn btn-blue" />
                            &nbsp;&nbsp;&nbsp;&nbsp;
                            <html:reset value="クリア"
                                onclick="clearMethod();"
                                styleClass="btn btn-green" />
                        </p>
                    </ts:form>
                </center>
                <p style="border-top: 1px solid #CCC"></p>
                <ts:form action="/selectwriteholidayBL">
                    <table>
                        <tr>
                            <th style="width: 90px;">休暇名称:<html:hidden property="name1"
                                    name="_Wform"  styleId="selectCheck" /></th>
                            <td style="width: 200px;"><html:select
                                    styleId="name" name="_Wform"
                                    property="name1" onchange="bao(this.options[this.options.selectedIndex].value)" style="width:125px;">
                                    <option value=""></option>
                                    <logic:notEmpty name="_Wform"
                                        property="holidaylist1">
                                        <logic:iterate
                                            id="jnTCIAttendance03"
                                            name="_Wform"
                                            property="holidaylist1">
                                            <option
                                                value="<bean:write name="jnTCIAttendance03" property="name"/>">
                                                <bean:write
                                                    name="jnTCIAttendance03"
                                                    property="name" />
                                            </option>
                                        </logic:iterate>
                                    </logic:notEmpty>
                                </html:select></td>

                            <td style="padding-left: 30px; border: none"><ts:submit
                                    styleClass="btn btn-blue fl"
                                    value="検索" /></td>
                        </tr>
                    </table>
                </ts:form>
                <ts:pageLinks id="userListPageLinks"
                    action="/selectwriteholidayBL" name="_Wform"
                    rowProperty="row" totalProperty="totalCount"
                    indexProperty="startIndex" currentPageIndex="now"
                    totalPageCount="total" />
                <table class="ctn" width="100%">
                    <caption>假期一覧</caption>
                    <tr>
                        <%--  <th style="width: 30px">假期ID</th> --%>
                        <th style="width: 40px">休暇名称</th>
                        <th style="width: 50px">開始時間</th>
                        <th style="width: 50px">終了時間</th>
                        <th style="width: 50px">操作</th>
                    </tr>
                    <logic:notEmpty name="_Wform" property="holidaylist">
                        <logic:iterate id="_WformBean" name="_Wform"
                            property="holidaylist">
                            <form action="/tutorial-thin/holiday.do"
                                method="post">
                                <html:hidden property="startIndex" name="_Wform"/>
                                <tr align="center" class="d">
                                    <td align="center"><bean:write
                                            name="_WformBean"
                                            property="name" />
                                            <html:hidden property="startIndex" name="_Wform"/>
                                  <html:hidden property="name1" name="_Wform"/></td>
                                    <td align="center"><bean:write
                                            name="_WformBean"
                                            property="startholidaydate" /></td>
                                    <td align="center"><bean:write
                                            name="_WformBean"
                                            property="endholidaydate" /></td>
                                    <td><input type="hidden"
                                        name="holidayid"
                                        value="<bean:write name="_WformBean" property="holidayid"/>" />
                                        <input type="hidden" name="flag"
                                        id="index" value="" /> <input
                                        class="btn btn-green"
                                        type="submit" value="修正"
                                        onclick="onSubimitfun(2,index)" />&nbsp;&nbsp;
                                        <input class="btn btn-red"
                                        type="submit" value="削除"
                                        onclick="return onSubimitfun(1,index)" /></td>
                                </tr>
                            </form>
                        </logic:iterate>
                    </logic:notEmpty>
                </table>
                <div class="pagination">
                    <ul>
                        <li>計<b><bean:write name="_Wform"
                                    property="totalCount" /></b>レコード数
                        </li>
                        <li><bean:write name ="now" />／<bean:write
                                name="total" /></li>
                        <li><bean:write name="userListPageLinks"
                                filter="false" /></li>
                    </ul>
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
        <script type="text/javascript">
		!function(){
			laydate.skin('yahui');//切换皮肤，请查看skins下面皮肤库
			laydate({elem: '#demo'});//绑定元素
		}();

		//日期范围限制
var start = {
  elem: '#startholidaydate',
  format: 'YYYY/MM/DD',
  max: '2099/06/16', //最大日期
  istime: false,
  istoday: false,
  choose: function(datas){
     end.min = datas; //开始日选好后，重置结束日的最小日期 */
  }
};
var end = {
  elem: '#endholidaydate',
  format: 'YYYY/MM/DD',
  max: '2099/06/16',
  istime: false,
  istoday: false,
  choose: function(datas){
    start.max = datas; //结束日选好后，重置开始日的最大日期
  }
};
laydate(start);
laydate(end);
	</script>
</body>
</html>