<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="/struts-html" prefix="html" %>
<%@ taglib uri="/struts-bean" prefix="bean" %>
<%@ taglib uri="/struts-logic" prefix="logic" %>
<%@ taglib uri="/terasoluna-struts" prefix="ts" %>
<%@ taglib uri="/terasoluna" prefix="t" %>

<!DOCTYPE HTML>

<html:html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>初期画面</title>
<link rel="stylesheet" type="text/css" href="css/style.css" />
<style>
    html{font-size:50px;-webkit-tap-highlight-color:transparent;height:100%;min-width:320px;overflow-x:hidden;overflow-y:hidden;}
    body{margin:0;height:100%;background:#16a085;overflow:hidden;font-family:"Microsoft YaHei";}
    canvas{z-index:-1;position:absolute;}
    .box{text-align: center;color: #fff;font-size: 30px;margin: 250px auto;display:inline-block;padding: 40px;  box-shadow: 0 -15px 30px #0d957a;border-radius: 5px;}
    .box-img{background: url(images/login_head.png) no-repeat 10px;background-size: 100%;height: 130px;background-position: 0 -17px;}
    .box-title{opacity: 0.8;}
    .btn a {box-shadow: 0 0 30px #0d957a;background-color: #5CBDAA;color:#fff;text-decoration:none;outline:0;opacity: 0.85;padding: 10px;border-radius: 30px;}
    .btn a:hover{color:#1A7C6A;box-shadow: 0 0 30px #0d957a;;}
</style>
<script src="js/jquery-1.11.3.min.js"></script>
<script src="js/Particleground.js"></script>
<script>
$(document).ready(function() {
  //粒子背景特效
  $('body').particleground({
    dotColor: '#5cbdaa',
    lineColor: '#5cbdaa'
  });
  //测试提交，对接程序删除即可
  $("a").click(function(){
      var width = 1904;
      var height = 980;
      var style = "width=" + width + ",height=" + height + ",status=yes,location=no,menubar=no,toolbar=no,resizable=yes,scrollbars=yes";
      window.open ("index.jsp", "newwindow", style)
	  });
});
</script>
</head>
<body>
<div style="text-align: center">
<div class="box">
<div class="box-img"></div>
<div class="box-title"style="margin: 20px">-- ようこそへ --</div>
<div class="btn"><a href="#">ログオン画面へ </a></div>
</div>
    </div>
<br>
</body>
</html:html>