<%@ page contentType="text/html; charset=utf-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-html" prefix="html"%>
<%@ taglib uri="/struts-bean" prefix="bean"%>
<%@ taglib uri="/struts-logic" prefix="logic"%>
<%@ taglib uri="/terasoluna-struts" prefix="ts"%>
<%@ taglib uri="/terasoluna" prefix="t"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html:html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>北開発室座席図管理</title>
<link rel="stylesheet" type="text/css" href="css/base.css" />
<link rel="stylesheet" type="text/css" href="css/main.css" />
<link rel="stylesheet" type="text/css" href="css/position.css" />
<link rel="stylesheet" type="text/css"
    href="${pageContext.request.contextPath}/css/JNTCIPersonInfo.css" />
<script type="text/javascript" src="js/laydate/laydate.js"></script>
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/JNTCIPersonInfo.js"></script>
<script type="text/javascript" src="js/jquery-1.11.3.min.js"></script>
<script type="text/javascript" src="js/JNTCIPosition.js"></script>
<body onload="cunfang()">

    <div>
        <jsp:include page="/top.jsp" flush="true" />
    </div>
    <!--/?部分 -->
    <!-- <div style="position:relative;" > -->
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
                <li><a href="#">座席図管理</a></li>
                <li class="ico">&gt;</li>
                <li><a href="#">北開発室</a></li>
            </ul>
        </div>
        <div  style="max-height: 100px; overflow: auto; width: 500px; margin-left: 40px;">
                <html:errors />
                <h3 style="margin-top: 0px;margin-bottom: 0px;">
                    <html:messages id="message" message="true">
                        <bean:write name="message" />
                    </html:messages>
                </h3>
        </div>
        <div id = "main"
            style="overflow: auto; height: 820px;">
            <div class="main_empl">
                <html:hidden property="count" name="_EmpForm"
                    styleId="count" />
                <div style="display: none">
                    <table>
                        <logic:iterate id="bean" name="_EmpForm"
                            property="empList" indexId="index">
                            <tr>
                                <td><html:text
                                        property="emp_Position"
                                        name="bean"
                                        styleId="position-${index}"
                                        indexed="true" /></td>
                                <td><html:text
                                        property="info_EmpNo"
                                        name="bean"
                                        styleId="empno-${index}"
                                        indexed="true" /></td>
                                <td><html:text property="user_Name"
                                        name="bean"
                                        styleId="name-${index}"
                                        indexed="true" /></td>
                                <td><html:text property="dept"
                                        name="bean"
                                        styleId="dept-${index}"
                                        indexed="true" /></td>
                                <td><html:text property="photo"
                                        name="bean"
                                        styleId="photo-${index}"
                                        indexed="true" /></td>
                            </tr>
                        </logic:iterate>
                    </table>
                </div>

                <div>
                    <ts:link
                        action="/EmpPositionNorth/JNTCIEmpPositionDownloadBLogic">ダウンロードの座席図</ts:link>
                </div>
                <%
                    for (int j = 1; j <= 10; j++) {
                            if (j == 1 || j == 5 || j == 6 || j == 10) {
                %>
                <div class="position_B1_A">
                    <div class="position_B1_Title" align="center">
                        <%
                            switch (j) {
                                        case 1:
                        %>
                        <h1>B1_A</h1>
                        <%
                            break;
                                        case 5:
                        %>
                        <h1>B1_E</h1>
                        <%
                            break;
                                        case 6:
                        %>
                        <h1>B1_F</h1>
                        <%
                            break;
                                        case 10:
                        %>
                        <h1>B1_J</h1>
                        <%
                            break;
                                        }
                        %>
                    </div>
                    <div class="position_B1_tal">
                        <table>
                            <tr>
                                <%
                                    switch (j) {
                                                case 1:
                                %>
                                <td colspan="2">
                                    <div class="B1_person" id="B1_A1"
                                        onclick="chuanzhi(this.id)">
                                        <div class="B1_person_main">
                                            <div
                                                class="person_main_title">B1_A1</div>
                                            <div
                                                class="person_main_name"
                                                id="BB1_A1"></div>
                                        </div>
                                        <div class="B1_person_photo"
                                            id="CB1_A1"></div>
                                        <div class="B1_person_depart"
                                            id="DB1_A1"></div>
                                    </div>
                                </td>
                                <%
                                    break;
                                                case 5:
                                %>
                                <td colspan="2">
                                    <div class="B1_person" id="B1_E1"
                                        onclick="chuanzhi(this.id)">
                                        <div class="B1_person_main">
                                            <div
                                                class="person_main_title">B1_E1</div>
                                            <div
                                                class="person_main_name"
                                                id="BB1_E1"></div>
                                        </div>
                                        <div class="B1_person_photo"
                                            id="CB1_E1"></div>
                                        <div class="B1_person_depart"
                                            id="DB1_E1"></div>
                                    </div>
                                </td>
                                <%
                                    break;
                                                case 6:
                                %>
                                <td colspan="2">
                                    <div class="B1_person" id="B1_F1"
                                        onclick="chuanzhi(this.id)">
                                        <div class="B1_person_main">
                                            <div
                                                class="person_main_title">B1_F1</div>
                                            <div
                                                class="person_main_name"
                                                id="BB1_F1"></div>
                                        </div>
                                        <div class="B1_person_photo"
                                            id="CB1_F1"></div>
                                        <div class="B1_person_depart"
                                            id="DB1_F1"></div>
                                    </div>
                                </td>
                                <%
                                    break;
                                                case 10:
                                %>
                                <td colspan="2">
                                    <div class="B1_person" id="B1_J1"
                                        onclick="chuanzhi(this.id)">
                                        <div class="B1_person_main">
                                            <div
                                                class="person_main_title">B1_J1</div>
                                            <div
                                                class="person_main_name"
                                                id="BB1_J1"></div>
                                        </div>
                                        <div class="B1_person_photo"
                                            id="CB1_J1"></div>
                                        <div class="B1_person_depart"
                                            id="DB1_J1"></div>
                                    </div>
                                </td>
                                <%
                                    break;
                                                }
                                %>
                            </tr>
                            <%
                                for (int i = 2; i <= 6; i++) {
                            %>
                            <tr>
                                <td>
                                    <%
                                        switch (j) {
                                                        case 1:
                                    %>
                                    <div class="B1_person"
                                        id="B1_A<%=(i - 1) * 2%>"
                                        onclick="chuanzhi(this.id)">
                                        <div class="B1_person_main">
                                            <div
                                                class="person_main_title B1_A<%=(i - 1) * 2%>">
                                                B1_A<%=(i - 1) * 2%></div>
                                            <div
                                                class="person_main_name"
                                                id="BB1_A<%=(i - 1) * 2%>">
                                            </div>
                                        </div>
                                        <div class="B1_person_photo"
                                            id="CB1_A<%=(i - 1) * 2%>">
                                        </div>
                                        <div class="B1_person_depart"
                                            id="DB1_A<%=(i - 1) * 2%>"></div>
                                    </div> <%
     break;
                     case 5:
 %>
                                    <div class="B1_person"
                                        id="B1_E<%=(i - 1) * 2%>"
                                        onclick="chuanzhi(this.id)">
                                        <div class="B1_person_main">
                                            <div
                                                class="person_main_title B1_E<%=(i - 1) * 2%>">
                                                B1_E<%=(i - 1) * 2%></div>
                                            <div
                                                class="person_main_name"
                                                id="BB1_E<%=(i - 1) * 2%>"></div>
                                        </div>
                                        <div class="B1_person_photo"
                                            id="CB1_E<%=(i - 1) * 2%>">
                                        </div>
                                        <div class="B1_person_depart"
                                            id="DB1_E<%=(i - 1) * 2%>"></div>
                                    </div> <%
     break;
                     case 6:
 %>
                                    <div class="B1_person"
                                        id="B1_F<%=(i - 1) * 2%>"
                                        onclick="chuanzhi(this.id)">
                                        <div class="B1_person_main">
                                            <div
                                                class="person_main_title B1_F<%=(i - 1) * 2%>">
                                                B1_F<%=(i - 1) * 2%></div>
                                            <div
                                                class="person_main_name"
                                                id="BB1_F<%=(i - 1) * 2%>"></div>
                                        </div>
                                        <div class="B1_person_photo"
                                            id="CB1_F<%=(i - 1) * 2%>">
                                        </div>
                                        <div class="B1_person_depart"
                                            id="DB1_F<%=(i - 1) * 2%>"></div>
                                    </div> <%
     break;
                     case 10:
 %>
                                    <div class="B1_person"
                                        id="B1_J<%=(i - 1) * 2%>"
                                        onclick="chuanzhi(this.id)">
                                        <div class="B1_person_main">
                                            <div
                                                class="person_main_title B1_J<%=(i - 1) * 2%>">
                                                B1_J<%=(i - 1) * 2%></div>
                                            <div
                                                class="person_main_name"
                                                id="BB1_J<%=(i - 1) * 2%>"></div>
                                        </div>
                                        <div class="B1_person_photo"
                                            id="CB1_J<%=(i - 1) * 2%>">
                                        </div>
                                        <div class="B1_person_depart"
                                            id="DB1_J<%=(i - 1) * 2%>"></div>
                                    </div> <%
     break;
                     }
 %>
                                </td>
                                <td>
                                    <%
                                        switch (j) {
                                                        case 1:
                                    %>
                                    <div class="B1_person"
                                        id="B1_A<%=(i - 1) * 2 + 1%>"
                                        onclick="chuanzhi(this.id)">
                                        <div class="B1_person_main">
                                            <div
                                                class="person_main_title">
                                                B1_A<%=(i - 1) * 2 + 1%></div>
                                            <div
                                                class="person_main_name"
                                                id="BB1_A<%=(i - 1) * 2 + 1%>"></div>
                                        </div>
                                        <div class="B1_person_photo"
                                            id="CB1_A<%=(i - 1) * 2 + 1%>">
                                        </div>
                                        <div class="B1_person_depart"
                                            id="DB1_A<%=(i - 1) * 2 + 1%>"></div>
                                    </div> <%
     break;
                     case 5:
 %>
                                    <div class="B1_person"
                                        id="B1_E<%=(i - 1) * 2 + 1%>"
                                        onclick="chuanzhi(this.id)">
                                        <div class="B1_person_main">
                                            <div
                                                class="person_main_title">
                                                B1_E<%=(i - 1) * 2 + 1%></div>
                                            <div
                                                class="person_main_name"
                                                id="BB1_E<%=(i - 1) * 2 + 1%>"></div>
                                        </div>
                                        <div class="B1_person_photo"
                                            id="CB1_E<%=(i - 1) * 2 + 1%>">
                                        </div>
                                        <div class="B1_person_depart"
                                            id="DB1_E<%=(i - 1) * 2 + 1%>"></div>
                                    </div> <%
     break;
                     case 6:
 %>
                                    <div class="B1_person"
                                        id="B1_F<%=(i - 1) * 2 + 1%>"
                                        onclick="chuanzhi(this.id)">
                                        <div class="B1_person_main">
                                            <div
                                                class="person_main_title">
                                                B1_F<%=(i - 1) * 2 + 1%></div>
                                            <div
                                                class="person_main_name"
                                                id="BB1_F<%=(i - 1) * 2 + 1%>"></div>
                                        </div>
                                        <div class="B1_person_photo"
                                            id="CB1_F<%=(i - 1) * 2 + 1%>">
                                        </div>
                                        <div class="B1_person_depart"
                                            id="DB1_F<%=(i - 1) * 2 + 1%>"></div>
                                    </div> <%
     break;
                     case 10:
 %>
                                    <div class="B1_person"
                                        id="B1_J<%=(i - 1) * 2 + 1%>"
                                        onclick="chuanzhi(this.id)">
                                        <div class="B1_person_main">
                                            <div
                                                class="person_main_title">
                                                B1_J<%=(i - 1) * 2 + 1%></div>
                                            <div
                                                class="person_main_name"
                                                id="BB1_J<%=(i - 1) * 2 + 1%>"></div>
                                        </div>
                                        <div class="B1_person_photo"
                                            id="CB1_J<%=(i - 1) * 2 + 1%>">
                                        </div>
                                        <div class="B1_person_depart"
                                            id="DB1_J<%=(i - 1) * 2 + 1%>"></div>
                                    </div> <%
     break;
                     }
 %>
                                </td>
                            </tr>
                            <%
                                }
                            %>
                        </table>
                    </div>
                </div>
                <%
                    }
                %>
                <%
                    if (j == 2 || j == 4 || j == 7 || j == 9) {
                %>
                <div class="position_B1_B">
                    <div class="position_B1_Title" align="center">
                        <%
                            switch (j) {
                                        case 2:
                        %>
                        <h1>B1_B</h1>
                        <%
                            break;
                                        case 4:
                        %>
                        <h1>B1_D</h1>
                        <%
                            break;
                                        case 7:
                        %>
                        <h1>B1_G</h1>
                        <%
                            break;
                                        case 9:
                        %>
                        <h1>B1_I</h1>
                        <%
                            break;
                                        }
                        %>
                    </div>
                    <div class="position_B1_tal">
                        <table>
                            <%
                                for (int k = 1; k <= 6; k++) {
                            %>
                            <tr>
                                <td>
                                    <%
                                        switch (j) {
                                                        case 2:
                                    %>
                                    <div class="B1_person"
                                        id="B1_B<%=(k - 1) * 2 + 1%>"
                                        onclick="chuanzhi(this.id)">
                                        <div class="B1_person_main">
                                            <div
                                                class="person_main_title">
                                                B1_B<%=(k - 1) * 2 + 1%></div>
                                            <div
                                                class="person_main_name"
                                                id="BB1_B<%=(k - 1) * 2 + 1%>"></div>
                                        </div>
                                        <div class="B1_person_photo"
                                            id="CB1_B<%=(k - 1) * 2 + 1%>">
                                        </div>
                                        <div class="B1_person_depart"
                                            id="DB1_B<%=(k - 1) * 2 + 1%>"></div>
                                    </div> <%
     break;
                     case 4:
 %>
                                    <div class="B1_person"
                                        id="B1_D<%=(k - 1) * 2 + 1%>"
                                        onclick="chuanzhi(this.id)">
                                        <div class="B1_person_main">
                                            <div
                                                class="person_main_title">
                                                B1_D<%=(k - 1) * 2 + 1%></div>
                                            <div
                                                class="person_main_name"
                                                id="BB1_D<%=(k - 1) * 2 + 1%>"></div>
                                        </div>
                                        <div class="B1_person_photo"
                                            id="CB1_D<%=(k - 1) * 2 + 1%>">
                                        </div>
                                        <div class="B1_person_depart"
                                            id="DB1_D<%=(k - 1) * 2 + 1%>"></div>
                                    </div> <%
     break;
                     case 7:
 %>
                                    <div class="B1_person"
                                        id="B1_G<%=(k - 1) * 2 + 1%>"
                                        onclick="chuanzhi(this.id)">
                                        <div class="B1_person_main">
                                            <div
                                                class="person_main_title">
                                                B1_G<%=(k - 1) * 2 + 1%></div>
                                            <div
                                                class="person_main_name"
                                                id="BB1_G<%=(k - 1) * 2 + 1%>"></div>
                                        </div>
                                        <div class="B1_person_photo"
                                            id="CB1_G<%=(k - 1) * 2 + 1%>">
                                        </div>
                                        <div class="B1_person_depart"
                                            id="DB1_G<%=(k - 1) * 2 + 1%>"></div>
                                    </div> <%
     break;
                     case 9:
 %>
                                    <div class="B1_person"
                                        id="B1_I<%=(k - 1) * 2 + 1%>"
                                        onclick="chuanzhi(this.id)">
                                        <div class="B1_person_main">

                                            <div
                                                class="person_main_title">
                                                B1_I<%=(k - 1) * 2 + 1%></div>
                                            <div
                                                class="person_main_name"
                                                id="BB1_I<%=(k - 1) * 2 + 1%>"></div>
                                        </div>
                                        <div class="B1_person_photo"
                                            id="CB1_I<%=(k - 1) * 2 + 1%>">
                                        </div>
                                        <div class="B1_person_depart"
                                            id="DB1_I<%=(k - 1) * 2 + 1%>"></div>
                                    </div> <%
     break;
                     }
 %>
                                </td>
                                <td>
                                    <%
                                        switch (j) {
                                                        case 2:
                                    %>
                                    <div class="B1_person"
                                        id="B1_B<%=(k - 1) * 2 + 2%>"
                                        onclick="chuanzhi(this.id)">
                                        <div class="B1_person_main">
                                            <div
                                                class="person_main_title">
                                                B1_B<%=(k - 1) * 2 + 2%></div>
                                            <div
                                                class="person_main_name"
                                                id="BB1_B<%=(k - 1) * 2 + 2%>"></div>
                                        </div>
                                        <div class="B1_person_photo"
                                            id="CB1_B<%=(k - 1) * 2 + 2%>">
                                        </div>
                                        <div class="B1_person_depart"
                                            id="DB1_B<%=(k - 1) * 2 + 2%>"></div>
                                    </div> <%
     break;
                     case 4:
 %>
                                    <div class="B1_person"
                                        id="B1_D<%=(k - 1) * 2 + 2%>"
                                        onclick="chuanzhi(this.id)">
                                        <div class="B1_person_main">
                                            <div
                                                class="person_main_title">
                                                B1_D<%=(k - 1) * 2 + 2%></div>
                                            <div
                                                class="person_main_name"
                                                id="BB1_D<%=(k - 1) * 2 + 2%>"></div>
                                        </div>
                                        <div class="B1_person_photo"
                                            id="CB1_D<%=(k - 1) * 2 + 2%>">
                                        </div>
                                        <div class="B1_person_depart"
                                            id="DB1_D<%=(k - 1) * 2 + 2%>"></div>
                                    </div> <%
     break;
                     case 7:
 %>
                                    <div class="B1_person"
                                        id="B1_G<%=(k - 1) * 2 + 2%>"
                                        onclick="chuanzhi(this.id)">
                                        <div class="B1_person_main">
                                            <div
                                                class="person_main_title">
                                                B1_G<%=(k - 1) * 2 + 2%></div>
                                            <div
                                                class="person_main_name"
                                                id="BB1_G<%=(k - 1) * 2 + 2%>"></div>
                                        </div>
                                        <div class="B1_person_photo"
                                            id="CB1_G<%=(k - 1) * 2 + 2%>">
                                        </div>
                                        <div class="B1_person_depart"
                                            id="DB1_G<%=(k - 1) * 2 + 2%>"></div>
                                    </div> <%
     break;
                     case 9:
 %>
                                    <div class="B1_person"
                                        id="B1_I<%=(k - 1) * 2 + 2%>"
                                        onclick="chuanzhi(this.id)">
                                        <div class="B1_person_main">
                                            <div
                                                class="person_main_title">
                                                B1_I<%=(k - 1) * 2 + 2%></div>
                                            <div
                                                class="person_main_name"
                                                id="BB1_I<%=(k - 1) * 2 + 2%>"></div>
                                        </div>
                                        <div class="B1_person_photo"
                                            id="CB1_I<%=(k - 1) * 2 + 2%>">
                                        </div>
                                        <div class="B1_person_depart"
                                            id="DB1_I<%=(k - 1) * 2 + 2%>"></div>
                                    </div> <%
     break;
                     }
 %>
                                </td>
                            </tr>
                            <%
                                }
                            %>
                        </table>
                    </div>
                </div>
                <%
                    }
                %>
                <%
                    if (j == 3 || j == 8) {
                %>
                <div class="position_B1_C">
                    <div class="position_B1_Title" align="center">
                        <%
                            switch (j) {
                                        case 3:
                        %>
                        <h1>B1_C</h1>
                        <%
                            break;
                                        case 8:
                        %>
                        <h1>B1_H</h1>
                        <%
                            break;
                                        }
                        %>
                    </div>
                    <div class="position_B1_tal">
                        <table>
                            <tr>
                                <td colspan="2">
                                    <div class="B1_pillar"></div>
                                </td>
                            </tr>
                            <tr>
                                <%
                                    for (int z = 2; z <= 5; z++) {
                                %>

                            <tr>
                                <td>
                                    <%
                                        switch (j) {
                                                        case 3:
                                    %>
                                    <div class="B1_person"
                                        id="B1_C<%=(z - 1) * 2 - 1%>"
                                        onclick="chuanzhi(this.id)">
                                        <div class="B1_person_main">
                                            <div
                                                class="person_main_title">
                                                B1_C<%=(z - 1) * 2 - 1%></div>
                                            <div
                                                class="person_main_name"
                                                id="BB1_C<%=(z - 1) * 2 - 1%>"></div>
                                        </div>
                                        <div class="B1_person_photo"
                                            id="CB1_C<%=(z - 1) * 2 - 1%>">
                                        </div>
                                        <div class="B1_person_depart"
                                            id="DB1_C<%=(z - 1) * 2 - 1%>"></div>
                                    </div> <%
     break;
                     case 8:
 %>
                                    <div class="B1_person"
                                        id="B1_H<%=(z - 1) * 2 - 1%>"
                                        onclick="chuanzhi(this.id)">
                                        <div class="B1_person_main">
                                            <div
                                                class="person_main_title">
                                                B1_H<%=(z - 1) * 2 - 1%></div>
                                            <div
                                                class="person_main_name"
                                                id="BB1_H<%=(z - 1) * 2 - 1%>"></div>
                                        </div>
                                        <div class="B1_person_photo"
                                            id="CB1_H<%=(z - 1) * 2 - 1%>">
                                        </div>
                                        <div class="B1_person_depart"
                                            id="DB1_H<%=(z - 1) * 2 - 1%>"></div>
                                    </div> <%
     break;
                     }
 %>
                                </td>
                                <td>
                                    <%
                                        switch (j) {
                                                        case 3:
                                    %>
                                    <div class="B1_person"
                                        id="B1_C<%=(z - 1) * 2%>"
                                        onclick="chuanzhi(this.id)">
                                        <div class="B1_person_main">
                                            <div
                                                class="person_main_title">
                                                B1_C<%=(z - 1) * 2%></div>
                                            <div
                                                class="person_main_name"
                                                id="BB1_C<%=(z - 1) * 2%>"></div>
                                        </div>
                                        <div class="B1_person_photo"
                                            id="CB1_C<%=(z - 1) * 2%>">
                                        </div>
                                        <div class="B1_person_depart"
                                            id="DB1_C<%=(z - 1) * 2%>"></div>
                                    </div> <%
     break;
                     case 8:
 %>
                                    <div class="B1_person"
                                        id="B1_H<%=(z - 1) * 2%>"
                                        onclick="chuanzhi(this.id)">
                                        <div class="B1_person_main">
                                            <div
                                                class="person_main_title">
                                                B1_H<%=(z - 1) * 2%></div>
                                            <div
                                                class="person_main_name"
                                                id="BB1_H<%=(z - 1) * 2%>"></div>
                                        </div>
                                        <div class="B1_person_photo"
                                            id="CB1_H<%=(z - 1) * 2%>">
                                        </div>
                                        <div class="B1_person_depart"
                                            id="DB1_H<%=(z - 1) * 2%>"></div>
                                    </div> <%
     break;
                     }
 %>
                                </td>
                            </tr>
                            <%
                                }
                            %>
                            <tr>
                                <td colspan="2">
                                    <div class="B1_pillar"></div>
                                </td>
                            </tr>
                        </table>
                    </div>
                </div>
                <%
                    }
                %>
                <%
                    }
                %>
                <div id="light" class="white_content"
                    style="position: fixed; top: 40%; left: 40%;">
                    <a
                        onclick="document.getElementById('light').style.display='none';document.getElementById('fade').style.display='none'"
                        href="javascript:void(0)" style="float: right;"> 閉じる</a>
                    <div class="N_Fram">
                        <html:form action="/JNTCIUpdatePositionBL"
                            styleId="formId">
                             <html:hidden property="scrollPosit" name="_EmpForm" styleId="scrollPosit"/>
                            <ul>
                                <li><span>ユーザーID:</span>&nbsp; <html:text
                                        property="info_EmpNo"
                                        styleId="inputValue"
                                        style="width:120px;" maxlength="4"/><span
                                    style="width: 30px; color: red; text-align:center;"> *</span></li>
                                <li><span><input
                                        type="button" value="選択"
                                        onclick="selectInfoEmpNo()" /></span>&nbsp;
                                    <html:select styleId="selectValue"
                                        property="selectUserId"
                                        name="_EmpForm">
                                        <option value="">--選択ください--</option>
                                        <html:optionsCollection
                                            property="infoEmpNoList"
                                            label="KEY" value="VALUE" />
                                    </html:select></li>
                                <li><span>座席番号:</span>&nbsp;  <label
                                    id="positionLable"
                                    style="text-align: center"></label>
                                <html:hidden styleId="positionHidden"
                                        property="emp_Position" /></li>
                                <li style="text-align: center; margin-top: 50px;">
                                <input type="submit" value="提交"
                                    class="btn btn-blue" />

                                <input type="reset" class="btn btn-blue"
                                    value="重置" />
                                <ts:link onclick="getUserId(this);return false;"
                                        action="/deletepeople"
                                        title="">削除</ts:link>
                               </li>
                            </ul>
                        </html:form>
                    </div>
                </div>
                <div id="fade" class="white_content"
                    style="position: fixed; top: 30%; left: 40%; width: 300px; height: 400px;">
                </div>
                <div style="clear: both"></div>
            </div>
        </div>
    </div>

</body>
</html:html>