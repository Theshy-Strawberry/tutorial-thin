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
<script src="../js/jquery-1.11.3.min.js" type="text/javascript"></script>
<link rel="stylesheet" type="text/css" href="css/base.css" />
<link rel="stylesheet" type="text/css" href="css/main.css" />
<script type="text/javascript" src="js/jquery-1.11.3.min.js"></script>
<script type="text/javascript">
    $(function() {
        var flag = $("#status").val();
        var userId = $("#userId").val();
        var type_leave = $("#type_leave").val();
        var leave_totaltime = $("#leave_totaltime").val();
        if (userId == "1070") {
            $("#agree").attr('disabled', "true");
            $("#disagree").attr('disabled', "true");
            $("#rollback").attr('disabled', "true");

        } else if (userId == "1003" || userId == "1004") {
            if (flag == "A01") {
                $("#rollback").attr('disabled', "true");
                $("#checkText").attr('disabled', "true");
            } else if (flag == "A11") {
                $("#disagree").attr('disabled', "true");
                $("#rollback").attr('disabled', "true");
                $("#checkText").attr('disabled', "true");
            } else if (flag == "A10" || flag == "A12") {
                $("#agree").attr('disabled', "true");
                $("#disagree").attr('disabled', "true");
                $("#rollback").attr('disabled', "true");
                $("#checkText").attr('disabled', "true");
            } else if (flag == "A04") {
                $("#rollback").attr('disabled', "true");
                $("#checkText").attr('disabled', "true");
            } else {
                $("#agree").attr('disabled', "true");
                $("#disagree").attr('disabled', "true");
            }
        } else if (userId == "1002") {
            if (flag == "A08") {
                $("#rollback").attr('disabled', "true");
                $("#checkText").attr('disabled', "true");
            } else if (flag == "A12") {
                $("#disagree").attr('disabled', "true");
                $("#rollback").attr('disabled', "true");
                $("#checkText").attr('disabled', "true");
            } else if (flag == "A04") {
                $("#rollback").attr('disabled', "true");
                $("#checkText").attr('disabled', "true");
            } else {
                $("#agree").attr('disabled', "true");
                $("#disagree").attr('disabled', "true");
                $("#checkText").attr('disabled', "true");
            }
        } else {
            if (flag == "A04") {
                $("#rollback").attr('disabled', "true");
                if(leave_totaltime < 24){
                	 $("#checkText").attr('disabled', "true");
                }
            } else if (flag == "A02") {
                $("#disagree").attr('disabled', "true");
                $("#rollback").attr('disabled', "true");
                if (type_leave == "AL1"||type_leave == "AL3") {
                    $("#checkText").attr('disabled', "true");
                }
            } else if (flag == "A10" || flag == "A11" || flag == "A08"
                    || flag == "A12") {
                $("#agree").attr('disabled', "true");
                $("#disagree").attr('disabled', "true");
                $("#rollback").attr('disabled', "true");
            } else {
                $("#agree").attr('disabled', "true");
                $("#disagree").attr('disabled', "true");
                $("#checkText").attr('disabled', "true");
            }

        }
        $('#left-container .content').hide();
        $('#Attendance').show();
        $('h2.tit').click(function() {
            $(this).next('.content').stop().slideToggle();

        })
    })
</script>
<!-- 页面加载完成之后首先执行的jsp -->
<script type="text/javascript">
    function onCheck() {
        var value = $("#status").val();
        var leave_totaltime = $("#leave_totaltime").val();
        var type_leave = $("#type_leave").val();
        var examine_paper_fg = $("#examine_paper_fg").val();
        if (value == "A02" || value == "A03" || value == "A08"
                || value == "A11") {
            if (examine_paper_fg == "1") {
                $("#checkText").attr('checked', "true");
                $("#checkText").attr('disabled', "true");
            }
            if (examine_paper_fg == "0") {
                /* $("#checkText").attr('disabled', "true"); */
            }
        }
        if (value == "A04") {
            if ((leave_totaltime < 24 )
                $("#checkText").attr('disabled', "true");
            }
        }
        $('#left-container .content').hide();
        $('#Attendance').show();
        $('h2.tit').click(function() {
            $(this).next('.content').stop().slideToggle();

        })
    }
</script>
<!--点击复选框触发的事件-->
<script type="text/javascript">
    function choose(obj) {
        $("#examine_paper_fg").val("1");
        var examine_paper_ = $("#examine_paper_fg").val();
    }
</script>

<!-- 点击三个按钮分别触发的事件 -->
<script type="text/javascript">
function onSubimit(){
    $("#cod").val("reset");
    $("#examine_person").val("goback");
    $("#formid").submit();

}
    function onSubimitfun(type) {
        var userId = $("#userId").val();
        var value = $("#status").val();
        var examine_paper = $("#examine_paper_fg").val();
        var leave_totaltime = $("#leave_totaltime").val();
        var type_leave = $("#type_leave").val();
        var examine_status1 = $("#status").val();
        var project_pm = $("#project_pm").val();
        var jn_card = $("#jn_card").val();

        if (userId == "1003" || userId == "1004") {
            if (type == "1") {
                if (leave_totaltime < 24) {
                    $("#examine_status").val("A13");
                } else if (leave_totaltime >= 24) {
                    $("#examine_status").val("A08");
                }
            } else if (type == "2") {
                $("#examine_status").val("A11");
            } else if (type == "3") {
                if (project_pm == "張棟" || project_pm == "衣蘭凱") {
                    $("#examine_status").val("A04");
                } else {
                    $("#examine_status").val("A01");
                }
                $("#codeId").val("3");
            }
        } else if (userId == "1002") {
            if (type == "1") {
                $("#examine_status").val("A10");
            } else if (type == "2") {
                $("#examine_status").val("A12");
            } else if (type == "3") {
                if (jn_card == "1003" || jn_card == "1004") {
                    $("#examine_status").val("A04");
                } else {
                    $("#examine_status").val("A08");
                }
                $("#codeId").val("3");
            }
        } else {
            if (type == "1") {
                if (examine_status1 != "A01") {
                    if (leave_totaltime < 24) {
                        $("#examine_status").val("A03");
                        if (value == "A02") {
                            $("#examine_status").val("A03");
                        } else {
                            $("#examine_status").val("A03");
                            var x = $("#examine_status").val();
                        }
                    } else if (leave_totaltime >= 24) {
                        $("#examine_status").val("A01");
                            if ($("#checkText").prop("checked")) {
                                if (examine_paper == "0") {
                                    alert("紙製の資料を必ずチェックしてください");
                                    return false;
                                }
                            } else {
                                alert("紙製の資料を必ずチェックしてください");
                                return false;
                            }
                    }

                }
            } else if (type == "2") {
                $("#examine_status").val("A02");

            } else if (type == "3") {
                $("#examine_status").val("flag");
                $("#codeId").val("3");
            }

        }
        $("#cod").val("reset");
        $("#formid").submit();
    }
</script>
</head>

<body onload="onCheck()">
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
                    <li><a href="#">休暇審査</a></li>
                </ul>
            </div>


            <div class="main-ctn"
                style="max-height: 100px; overflow: auto; color: red">
                <html:errors />
                <html:messages id="message" message="true">
                    <bean:write name="message" />
                </html:messages>
            </div>


            <div class="main-ctn ul-li">
                <ts:form action="/JNTCIAttendance04disagreeBL"
                    method="post" styleId="formid">
                    <input type="hidden" id="userId" name="userId"
                        value="<bean:write name="_JNTCIAttendance04selectForm" property="userId"/>" />
                    <ul>


                        <li><label>社員カード：
                                       <html:hidden property="jn_card_serch" name="_JNTCIAttendance04selectForm"/>
                                    <html:hidden property="name_serch" name="_JNTCIAttendance04selectForm"/>
                                    <html:hidden property="dept_id_serch" name="_JNTCIAttendance04selectForm"/>
                                    <html:hidden property="leave_starttime_serch" name="_JNTCIAttendance04selectForm"/>
                                    <html:hidden property="leave_endtime_serch" name="_JNTCIAttendance04selectForm"/>
                                    <html:hidden property="leave_type_serch" name="_JNTCIAttendance04selectForm"/>
                                    <html:hidden property="application_type_serch" name="_JNTCIAttendance04selectForm"/>
                                    <html:hidden property="examine_status_serch" name="_JNTCIAttendance04selectForm"/>
                                    <html:hidden property="startIndex" name="_JNTCIAttendance04selectForm"/>
                                    <html:hidden property="cod" name="_JNTCIAttendance04selectForm" styleId="cod"/>
                                <input
                                type="hidden" name="leave_id"
                                value="<bean:write name="_JNTCIAttendance04selectForm" property="leave_id"/>" />
                                <input type="hidden" id="examine_status"
                                name="examine_status" value="" /> <input
                                type="hidden" id="status" name="status"
                                value="<bean:write name="_JNTCIAttendance04selectForm" property="examine_status"/>" />
                                <input type="hidden" id="jn_card"
                                name="jn_card"
                                value="<bean:write name="_JNTCIAttendance04selectForm" property="jn_card"/>" />
                                <input type="hidden"
                                id="leave_totaltime"
                                name="leave_totaltime"
                                value="<bean:write name="_JNTCIAttendance04selectForm" property="leave_totaltime"/>" />
                                <input type="hidden" id="examine_person"
                                name="examine_person"
                                value="<bean:write name="_JNTCIAttendance04selectForm" property="examine_person"/>" />
                                <input type="hidden" id="leave_type"
                                name="leave_type"
                                value="<bean:write name="_JNTCIAttendance04selectForm" property="leave_type"/>" />
                                <input type="hidden"
                                id="application_type"
                                name="application_type"
                                value="<bean:write name="_JNTCIAttendance04selectForm" property="application_type"/>" />
                                <input type="hidden" id="type_leave"
                                name="type_leave"
                                value="<bean:write name="_JNTCIAttendance04selectForm" property="type_leave"/>" />
                                <input type="hidden"
                                id="examine_paper_fg"
                                name="examine_paper_fg"
                                value="<bean:write name="_JNTCIAttendance04selectForm" property="examine_paper_fg"/>" />
                        </label> <span><bean:write
                                    name="_JNTCIAttendance04selectForm"
                                    property="jn_card" />
                                <html:hidden property="jn_card"
                                    styleId="jn_card"
                                    name="_JNTCIAttendance04selectForm" /></span>
                            <label>社員名前：</label> <span> <bean:write
                                    name="_JNTCIAttendance04selectForm"
                                    property="name" /></span></li>
                        <li><label>所属上司：</label> <span><bean:write
                                    name="_JNTCIAttendance04selectForm"
                                    property="project_pm" /> <html:hidden
                                    property="project_pm"
                                    styleId="project_pm"
                                    name="_JNTCIAttendance04selectForm" />
                        </span> <label>部門所属：</label> <span><bean:write
                                    name="_JNTCIAttendance04selectForm"
                                    property="dept_id" /></span></li>
                        <li><label>審査人：</label> <span><bean:write
                                    name="_JNTCIAttendance04selectForm"
                                    property="examine_person" /></span> <label>休暇種類：</label>
                            <span><bean:write
                                    name="_JNTCIAttendance04selectForm"
                                    property="leave_type" /></span></li>
                        <li><label>申請方式：</label><span><bean:write
                                    name="_JNTCIAttendance04selectForm"
                                    property="application_type" /></span></li>
                        <li class="vt"><label>休暇始止時間：</label> <bean:write
                                name="_JNTCIAttendance04selectForm"
                                property="leave_starttime" /> <bean:write
                                name="_JNTCIAttendance04selectForm"
                                property="leave_endtime" /></li>

                        <li class="vt"><label>合計時長：<html:hidden
                                    name="_JNTCIAttendance04selectForm"
                                    property="leave_starttime" /> <html:hidden
                                    name="_JNTCIAttendance04selectForm"
                                    property="leave_endtime" /></label> <bean:write
                                name="_JNTCIAttendance04selectForm"
                                property="leave_totaltime" />(時間)</li>
                        <li class="vt"><label>休暇事由：</label> <span
                            style="width: 300px"><bean:write
                                    name="_JNTCIAttendance04selectForm"
                                    property="leave_reason" /></span> <html:hidden
                                name="_JNTCIAttendance04selectForm"
                                property="leave_reason" /></li>
                        <li class="vt">&nbsp;&nbsp;&nbsp;
                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input
                            type="checkbox" id="checkText"
                            onclick="choose(this)" /><label
                            style="width: 220px">紙の資料は既に処理しました</label>
                        </li>
                        <li class="vt"><label>理由：</label> <html:textarea
                                property="examine_reason" name="_JNTCIAttendance04selectForm"></html:textarea>
                            <html:hidden property="examine_reason"
                                name="_JNTCIAttendance04selectForm" /></li>
                        <li style="padding: 10px 0 0 170px;"><input
                            id="agree" name="承認" type="button"
                            style="min-width: 70px; margin-right: 20px"
                            class="btn btn-blue" value="承認"
                            onclick="onSubimitfun(1)" /> <input
                            id="disagree" name="承認しない" type="button"
                            style="min-width: 70px; margin-right: 20px"
                            class="btn btn-red" value="承認しない"
                            onclick="onSubimitfun(2)" /> <input
                            id="rollback" name="申請を取り消す" type="button"
                            style="min-width: 70px; margin-right: 20px"
                            class="btn btn-green" value="差戻し"
                            onclick="onSubimitfun(3)" />
                            <input
                            id="goback" name="戻る" type="button"
                            style="min-width: 70px; margin-right: 20px"
                            class="btn btn-blue" value="戻る"
                            onclick="onSubimit()" />
                            </li>
                        <html:hidden name="_JNTCIAttendance04selectForm"
                            styleId="codeId" property="code" />
                    </ul>
                </ts:form>
                <!--    点击此按钮会返回前一个页面并刷新 -->
                <!--    <a id="hhhhh" href="javascript:" onclick="self.location=document.referrer;">  asdasdassdas</a>  -->
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