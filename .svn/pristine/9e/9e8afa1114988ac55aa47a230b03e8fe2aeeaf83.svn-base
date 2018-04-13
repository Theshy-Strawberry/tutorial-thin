<%@ page contentType="text/html; charset=Windows-31J"%>
<%@ taglib uri="/struts-html" prefix="html"%>
<%@ taglib uri="/struts-bean" prefix="bean"%>
<%@ taglib uri="/struts-logic" prefix="logic"%>
<%@ taglib uri="/terasoluna-struts" prefix="ts"%>
<%@ taglib uri="/terasoluna" prefix="t"%>

<%@ page language="java" contentType="text/html; charset=Windows-31J"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>济南大宇宙内部系统-内容区</title>
<link rel="stylesheet" type="text/css" href="../css/base.css" />
<link rel="stylesheet" type="text/css" href="../css/main.css" />
<script src="http://www.codefans.net/ajaxjs/jquery-1.6.2.min.js"></script>
<script type="text/javascript">
    jQuery(document).ready(
            function($) {
                $("#tableid").unbind();
                var myDate = new Date();
                function timer() {
                    $("td").each(function() {
                        $(this).html("");
                    });
                    var year = myDate.getFullYear();//获取完整的年份(4位,1970-????)
                    var month = myDate.getMonth();//获取当前月份(0-11,0代表1月)
                    var date = myDate.getDate();//获取当前日(1-31)
                    var day = myDate.getDay();//获取当前星期X(0-6,0 代表星期天)
                    var num = day - (date % 7 - 1);//1号星期X
                    $("#title_time").html(year + "年" + (month + 1) + "月");
                    $("#title_time").css("font-size", "24px")
                    var i = 1;
                    var end;
                    switch (month) {
                    case 0:
                        end = 31;
                        break;
                    case 1:
                        if ((year % 4 == 0 && year % 100 != 0)
                                || (year % 400 == 0))
                            end = 29;
                        else
                            end = 28;
                        break;
                    case 2:
                        end = 31;
                        break;
                    case 3:
                        end = 30;
                        break;
                    case 4:
                        end = 31;
                        break;
                    case 5:
                        end = 30;
                        break;
                    case 6:
                        end = 31;
                        break;
                    case 7:
                        end = 31;
                        break;
                    case 8:
                        end = 30;
                        break;
                    case 9:
                        end = 31;
                        break;
                    case 10:
                        end = 30;
                        break;
                    case 11:
                        end = 31;
                        break;
                    }
                    $("tr").eq(i).find("td").eq(num).html(
                            "<div class='timetextclas'>" + (i) + "</div>");
                    var riqi = null;
                    $("td").each(
                            function() {
                                if ($(this).parent().index() == 1) {
                                    if ($(this).prev("td").html())
                                        $(this).html(
                                                "<div class='timetextclas'>"
                                                        + (++i) + "</div>");
                                }
                                if ($(this).parent().index() > 1 && i < end) {
                                    $(this).html(
                                            "<div class='timetextclas'>"
                                                    + (++i) + "</div>");
                                }
                            });
                    $(".timetextclas").css("width", "6px");
                    $(".timetextclas").css("margin-left", "15px");
                }
                timer();
                $(".pre_d").click(function() {
                    var nian = myDate.getFullYear();
                    var yue = myDate.getMonth();
                    if (yue == 0) {
                        nian--;
                        yue = 12;
                    }
                    var ri = "01";
                    var str = nian + " " + yue + " " + ri;
                    myDate = new Date(str);
                    timer();
                });
                $(".next_d").click(function() {
                    var nian = myDate.getFullYear();
                    var yue = myDate.getMonth();
                    yue += 2;
                    if (yue == 13) {
                        nian++;
                        yue = 1;
                    }
                    var ri = "01";
                    var str = nian + " " + yue + " " + ri;
                    myDate = new Date(str);
                    timer();
                });
            });
</script>

</head>
<body>
    <div class="header">
        <ul class="breadcrumbs clearfix">
            <li>您的位置：</li>
            <li><a href="#">设备管理</a></li>
            <li class="ico">&gt;</li>
            <li><a href="#">状态设备查询</a></li>
        </ul>
    </div>
    <div style="width: 100%; height: 800px;">
        <div style="margin-left: 84%; margin-top: 30px;">
            <span class="pre_d" title="前一月"
                style="cursor: pointer; font-size: 24px; -moz-user-select: none;"></span>
            &nbsp;<span id="title_time" style="-moz-user-select: none;"></span>&nbsp;
            <span class="next_d" title="后一月"
                style="cursor: pointer; font-size: 24px; -moz-user-select: none;">>></span>
        </div>
        <table id="tableid" width="80%" height="90%" align="left"
            border="1" cellpadding="2" cellspacing="0"
            style="text-align: center; margin-top: 20px;">
            <tbody>
                <tr>
                    <th>日</th>
                    <th>一</th>
                    <th>二</th>
                    <th>三</th>
                    <th>四</th>
                    <th>五</th>
                    <th>六</th>
                </tr>
                <tr>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                </tr>
                <tr>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                </tr>
                <tr>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                </tr>
                <tr>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                </tr>
                <tr>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                </tr>
            </tbody>
        </table>
    </div>
</body>

</html>