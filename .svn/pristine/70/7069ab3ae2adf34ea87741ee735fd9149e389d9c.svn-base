<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="/struts-html" prefix="html"%>
<%@ taglib uri="/struts-bean" prefix="bean"%>
<%@ taglib uri="/struts-logic" prefix="logic"%>
<%@ taglib uri="/terasoluna-struts" prefix="ts"%>
<%@ taglib uri="/terasoluna" prefix="t"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/base.css" />
<link rel="stylesheet" type="text/css" href="css/main.css" />
<script type="text/javascript" src="js/laydate/laydate.js"></script>
<script src="js/laydate/laydate.js" type="text/javascript"></script>
<script type="text/javascript" src="js/jquery-1.11.3.min.js"></script>
<script type="text/javascript">
$(function(){
    $('#left-container .content').hide();
	$('#Attendance').show();
    $('h2.tit').click(function(){
    $(this).next('.content').stop().slideToggle();

    })
})
</script>
</head>
<body onload="getflagMethod()">
 <!--?部分 -->
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
        <div style="padding-left: 280px">
             <p style="font-size:30px ; color:red"> 更改成功！！！</p>
        </div>
        <div class="footer" style="margin-top:200px;margin-left:100px">
                    <p>
                        連絡メール：<a href="mailto:jinan@trans-cosmos.com.cn" target="_blank">jinan@trans-cosmos.com.cn</a>
                    </p>
         </div>
   </div>

</body>
</html>