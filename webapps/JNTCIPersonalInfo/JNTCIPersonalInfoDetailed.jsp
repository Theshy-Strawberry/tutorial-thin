<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="/struts-html" prefix="html"%>
<%@ taglib uri="/struts-bean" prefix="bean"%>
<%@ taglib uri="/struts-logic" prefix="logic"%>
<%@ taglib uri="/terasoluna-struts" prefix="ts"%>
<%@ taglib uri="/terasoluna" prefix="t"%>
<%
    request.setCharacterEncoding("utf-8");
%>
<%
    response.setCharacterEncoding("utf-8");
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>済南大宇宙内部システム-個人信息詳細区</title>
<link rel="stylesheet" type="text/css" href="css/base.css" />
<link rel="stylesheet" type="text/css" href="css/main.css" />
<script type="text/javascript" src="js/laydate/laydate.js"></script>
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/JNTCIPersonInfo.js"></script>
<script type="text/javascript">
    $(function() {
        $("#languageText").text("言語：");
        $("#javaText").text("JAVA環境：");
        $("#jlanguagesText").text("JAVA言語：");
        $("#toolText").text("TOOL：");
        $("#dbText").text("DB：");
        $("#osText").text("OS：");
        $('#left-container .content').hide();
        $('#PersonInfo').show();
        $('h2.tit').click(function() {
            $(this).next('.content').stop().slideToggle();

        })
    })
</script>
<script type="text/javascript">
    $(function() {
        $(".display").each(function(index) {
            if (index != 0) {
                $(this).text("");
            }
        });
    });
</script>
<script type="text/javascript">
function subimit() {
	$("#userId").val("qa");
	$("#formid").submit();
}
</script>
<style>
span {
    display: block;
    width: 350px;
    text-align: left;
}
</style>
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
                    <li><a href="#">個人情報</a></li>
                    <li class="ico">&gt;</li>
                    <li><a href="#">個人情報詳細</a></li>
                </ul>
            </div>
            <div class="main-ctn self-info">
                <div class="clearfix">
                    <html:form action="/JNTCIPersonalInfoDetailedBL"
                        method="POST">
                    </html:form>
                </div>
                <table width="100%">
                    <colgroup>
                        <col width="70px" />
                        <col width="80px" />
                        <col width="70px" />
                        <col width="100px" />
                        <col width="180px" />
                    </colgroup>
                    <tr>
                        <th colspan="5">基本情報</th>
                    </tr>
                    <tr>

                        <td><i class="red">*</i> 済南カード：</td>
                        <td><bean:write
                                name="_JNTCIPersonalInfoDetailedForm"
                                property="jntciSelectPersonalInfo.jn_Card" /></td>
                        <td><i class="red">*</i> 天津カード：</td>
                        <td><bean:write
                                name="_JNTCIPersonalInfoDetailedForm"
                                property="jntciSelectPersonalInfo.tj_Card" /></td>

                        <td rowspan="5" class="pic">
                            <div id="preview"
                                style="border: 2px solid; padding: 3px 5px 5px 3px;">
                                <img id="imghead"
                                    src="<bean:write name="_JNTCIPersonalInfoDetailedForm" property="jntciSelectPersonalInfo.photoPath" />"
                                    width="100" height="110" />
                            </div> <br /> <input type="file"
                            onchange="previewImage(this)"
                            accept="image/jpeg" id="photo"
                            style="display: none" />
                        </td>
                    </tr>
                    <tr>
                        <td><i class="red">*</i> 名前：</td>
                        <td><bean:write
                                name="_JNTCIPersonalInfoDetailedForm"
                                property="jntciSelectPersonalInfo.userName" /></td>
                        <td><i class="red">*</i> 性別：</td>
                        <td><bean:write
                                name="_JNTCIPersonalInfoDetailedForm"
                                property="jntciSelectPersonalInfo.sex" /></td>
                    </tr>
                    <tr>
                        <td>ローマ字：</td>
                        <td><bean:write
                                name="_JNTCIPersonalInfoDetailedForm"
                                property="jntciSelectPersonalInfo.jp_Name" /></td>
                        <td>民族：</td>
                        <td><bean:write
                                name="_JNTCIPersonalInfoDetailedForm"
                                property="jntciSelectPersonalInfo.nation" /></td>
                    </tr>
                    <tr>
                        <td>生年月日：</td>
                        <td><bean:write
                                name="_JNTCIPersonalInfoDetailedForm"
                                property="jntciSelectPersonalInfo.birthdar" /></td>
                        <td>国籍：</td>
                        <td><bean:write
                                name="_JNTCIPersonalInfoDetailedForm"
                                property="jntciSelectPersonalInfo.nationality" /></td>
                    </tr>
                    <tr>
                        <td>婚姻状況：</td>
                        <td><bean:write
                                name="_JNTCIPersonalInfoDetailedForm"
                                property="jntciSelectPersonalInfo.marital_Status" /></td>
                        <td><i class="red">*</i> 身分証明書：</td>
                        <td><bean:write
                                name="_JNTCIPersonalInfoDetailedForm"
                                property="jntciSelectPersonalInfo.id_Card" /></td>
                    </tr>
                    <tr>
                        <td>連絡電話：</td>
                        <td><bean:write
                                name="_JNTCIPersonalInfoDetailedForm"
                                property="jntciSelectPersonalInfo.telephone" /></td>
                        <td>出身：</td>
                        <td><bean:write
                                name="_JNTCIPersonalInfoDetailedForm"
                                property="jntciSelectPersonalInfo.born_In" /></td>
                    </tr>
                    <tr>
                        <td>緊急連絡先：</td>
                        <td><bean:write
                                name="_JNTCIPersonalInfoDetailedForm"
                                property="jntciSelectPersonalInfo.emerg_Contact" /></td>
                        <td>緊急連絡先電話：</td>
                        <td><bean:write
                                name="_JNTCIPersonalInfoDetailedForm"
                                property="jntciSelectPersonalInfo.emerg_Contact_tel" /></td>
                    </tr>
                    <tr>
                        <td>今詳細な住所：</td>
                        <td colspan="3"><bean:write
                                name="_JNTCIPersonalInfoDetailedForm"
                                property="jntciSelectPersonalInfo.address" /></td>
                    </tr>
                    <tr>
                        <th colspan="5">詳細情報</th>
                    </tr>
                    <tr>
                        <td><i class="red">*</i> 所属部門：</td>
                        <td><bean:write
                                name="_JNTCIPersonalInfoDetailedForm"
                                property="jntciSelectPersonalInfo.department" /></td>
                        <td><i class="red">*</i> ポスト：</td>
                        <td colspan="2"><bean:write
                                name="_JNTCIPersonalInfoDetailedForm"
                                property="jntciSelectPersonalInfo.position" /></td>
                    </tr>
                    <tr>
                        <td>パスポート：</td>
                        <td><bean:write
                                name="_JNTCIPersonalInfoDetailedForm"
                                property="jntciSelectPersonalInfo.passport" /></td>
                        <td>ビザ：</td>
                        <td colspan="2"><bean:write
                                name="_JNTCIPersonalInfoDetailedForm"
                                property="jntciSelectPersonalInfo.visa" /></td>
                    </tr>
                    <td>入社時間：</td>
						<td><bean:write name="_JNTCIPersonalInfoDetailedForm"
								property="jntciSelectPersonalInfo.entry_Time" /></td>
								<td>社保時間：</td>
								 <td><bean:write name="_JNTCIPersonalInfoDetailedForm"
								property="jntciSelectPersonalInfo.SYAHO_JIKAN" /></td>
					</tr>
					<tr>
					<td>最終学歴：</td>
						<td colspan="2"><bean:write
								name="_JNTCIPersonalInfoDetailedForm"
								property="jntciSelectPersonalInfo.education" /></td>
								</tr>
                    <tr>
                        <td>個人メールボックス：</td>
                        <td><bean:write
                                name="_JNTCIPersonalInfoDetailedForm"
                                property="jntciSelectPersonalInfo.personal_Mall" /></td>
                        <td>社内メールボックス：</td>
                        <logic:notEmpty
                            name="_JNTCIPersonalInfoDetailedForm"
                            property="jntciSelectPersonalInfo.offic_Mail">
                            <td colspan="2"><a
                                href="mailto:<bean:write name="_JNTCIPersonalInfoDetailedForm" property="jntciSelectPersonalInfo.offic_Mail" />"
                                target="_blank"> <bean:write
                                        name="_JNTCIPersonalInfoDetailedForm"
                                        property="jntciSelectPersonalInfo.offic_Mail" />@trans-cosmos.com.cn
                            </a></td>
                        </logic:notEmpty>
                    </tr>
                    <tr>
                        <td>得意分野：</td>
                        <td colspan="4"><bean:write
                                name="_JNTCIPersonalInfoDetailedForm"
                                property="jntciSelectPersonalInfo.tech_capability" /></td>
                    </tr>
                    <tr>
                        <td>作業経験類型及年限(ヶ月)：</td>
                        <td colspan="4"><bean:write
                                name="_JNTCIPersonalInfoDetailedForm"
                                property="jntciSelectPersonalInfo.work_Experience" /></td>
                    </tr>
                    <logic:iterate id="TRInfo"
                        name="_JNTCIPersonalInfoDetailedForm"
                        property="qualificationTR">
                        <tr>
                            <td class="display">職業資格：</td>
                            <td colspan="4">受賞日付 : <bean:write
                                    name="TRInfo"
                                    property="winning_date" /> <label
                                style="margin-left: 20px"></label> 受賞証書
                                : <bean:write name="TRInfo"
                                    property="winning_certificate" />
                            </td>
                        </tr>
                    </logic:iterate>
                    <tr>
                        <td colspan="5" class="embed-table">
                            <table id="embed-table" width="100%">
                                <colgroup>
                                    <col style="width: 50px;" />
                                    <col style="width: 150px;" />
                                    <col style="width: 135px;" />
                                    <col style="width: 100px;" />
                                    <col style="width: 100px;" />
                                    <col style="width: 180px;" />
                                    <col style="width: 180px;" />
                                    <col style="width: 110px;" />
                                    <col style="width: 110px;" />
                                    <col style="width: 100px;" />
                                    <col style="width: 110px;" />
                                </colgroup>
                                <thead>
                                    <tr>
                                        <th rowspan="2">No</th>
                                        <th>業種</th>
                                        <th rowspan="2">参加人数</th>
                                        <th rowspan="2">参加形態</th>
                                        <th rowspan="2">開発ﾌｪｰｽﾞ</th>
                                        <th rowspan="2">業務内容</th>
                                        <th rowspan="2">使用言語<br />及びツール
                                        </th>
                                        <th rowspan="2">DB</th>
                                        <th rowspan="2">OS</th>
                                        <th rowspan="2" colspan="2">機種及び<br />使用デバイス
                                        </th>
                                    </tr>
                                    <tr>
                                        <th>プロジエクト名</th>
                                    </tr>
                                </thead>
                                <logic:iterate id="workEx"
                                    name="_JNTCIPersonalInfoDetailedForm"
                                    property="workExperience">
                                    <tbody>
                                        <tr>
                                            <td rowspan='2'><bean:write
                                                    name="workEx"
                                                    property="order_no" /></td>
                                            <td><bean:write
                                                    name="workEx"
                                                    property="careers_type" /></td>
                                            <td rowspan='2'><bean:write
                                                    name="workEx"
                                                    property="attend_nm" />人&nbsp;*&nbsp;
                                                <bean:write
                                                    name="workEx"
                                                    property="attend_month" />ヶ月</td>
                                            <td rowspan='2'><bean:write
                                                    name="workEx"
                                                    property="attend_states" /></td>
                                            <td rowspan='2'><bean:write
                                                    name="workEx"
                                                    property="develop_phase" /></td>
                                            <td rowspan='2'><bean:write
                                                    name="workEx"
                                                    property="firm_content" /></td>
                                            <td><bean:write
                                                    name="workEx"
                                                    property="lang_tool" /></td>
                                            <td><bean:write
                                                    name="workEx"
                                                    property="data_base" /></td>
                                            <td><bean:write
                                                    name="workEx"
                                                    property="technical_sys" /></td>
                                            <td colspan='2'><bean:write
                                                    name="workEx"
                                                    property="model_device" /></td>
                                        </tr>
                                        <tr>
                                            <td><bean:write
                                                    name="workEx"
                                                    property="proj_name" /></td>
                                            <td
                                                style='font-weight: bold; font-size: 1.1em; text-align: right; padding-right: 15px;'>開発担当期間:</td>
                                            <td colspan='2'><bean:write
                                                    name="workEx"
                                                    property="develop_period" /></td>
                                            <td
                                                style='font-weight: bold; font-size: 1.1em; text-align: right; padding-right: 15px;'>合計期間:</td>
                                            <td><bean:write
                                                    name="workEx"
                                                    property="total_period" />(ヶ月)</td>
                                        </tr>
                                    </tbody>
                                </logic:iterate>
                            </table> <small>参加 形態： ①プロジェクト・マネージャ
                                ②プロジェクト・サブマネージャ ③システムエンジニア ④プログラマー ⑤テスト
                                ⑥運用<br /> 開発フェーズ：①要件定義 ②基本設計(システム設計)
                                ③機能設計 ④詳細設計 ⑤プログラミング ⑥デバック ⑦評価 ⑧運用
                        </small>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="5">&nbsp;</td>
                    </tr>
                    <tr>
                        <th colspan="5">機能情報</th>
                    </tr>
                    <tr>
                        <td colspan="5" style="font-weight: normal;">
                            <table>
                                <tr>
                                    <td colspan="3"
                                        style="text-align: center;"><div>
                                            <br /> <span
                                                style="text-align: center;">レベル内容</span>
                                            <br /> <small> <span>5
                                                    殆どの機能が完璧に使用できる（スペシャリスト）</span><br />
                                                <span>4
                                                    応用的機能が使える（複雑な処理を開発できる）</span><br />
                                                <span>3
                                                    一通り使用できる（実際いくつか開発した）</span><br />
                                                <span>2
                                                    簡単な機能が使える（組んだ事がある・社内研修済）</span><br />
                                                <span>1
                                                    触ったことがある（授業/独学）</span>
                                            </small>
                                        </div></td>
                                </tr>
                                <logic:iterate id="languages"
                                    name="_JNTCIPersonalInfoDetailedForm"
                                    property="languagelist">
                                    <tr>
                                        <td id="languageText"></td>
                                        <td style="padding-left: 0px;">種類：<bean:write
                                                name="languages"
                                                property="yy_language" /></td>
                                        <td style="font-weight: normal;">レベル：<bean:write
                                                name="languages"
                                                property="yy_level" /></td>
                                        <td colspan="2">年数：<bean:write
                                                name="languages"
                                                property="yy_year" />
                                        </td>
                                    </tr>
                                </logic:iterate>
                                <logic:iterate id="envirnments"
                                    name="_JNTCIPersonalInfoDetailedForm"
                                    property="envirnmentlist">
                                    <tr>
                                        <td id="javaText"></td>
                                        <td style="padding-left: 0px;">種類：<bean:write
                                                name="envirnments"
                                                property="jhj_Envirnment" /></td>
                                        <td style="font-weight: normal;">レベル：<bean:write
                                                name="envirnments"
                                                property="jhj_level" /></td>
                                        <td colspan="2">年数：<bean:write
                                                name="envirnments"
                                                property="jhj_year" />
                                        </td>
                                    </tr>
                                </logic:iterate>
                                <logic:iterate id="jlanguages"
                                    name="_JNTCIPersonalInfoDetailedForm"
                                    property="jlanguagelist">
                                    <tr>
                                        <td id="jlanguagesText"></td>
                                        <td style="padding-left: 0px;">種類：<bean:write
                                                name="jlanguages"
                                                property="jyy_language" /></td>
                                        <td style="font-weight: normal;">レベル：<bean:write
                                                name="jlanguages"
                                                property="jyy_level" /></td>
                                        <td colspan="2">年数：<bean:write
                                                name="jlanguages"
                                                property="jyy_year" />
                                        </td>
                                    </tr>
                                </logic:iterate>
                                <logic:iterate id="editTools"
                                    name="_JNTCIPersonalInfoDetailedForm"
                                    property="editToollist">
                                    <tr>
                                        <td id="toolText"></td>
                                        <td style="padding-left: 0px;">種類：<bean:write
                                                name="editTools"
                                                property="tl_tool" /></td>
                                        <td style="font-weight: normal;">レベル：<bean:write
                                                name="editTools"
                                                property="tl_level" /></td>
                                        <td colspan="2">年数：<bean:write
                                                name="editTools"
                                                property="tl_year" />
                                        </td>
                                    </tr>
                                </logic:iterate>
                                <logic:iterate id="dataBases"
                                    name="_JNTCIPersonalInfoDetailedForm"
                                    property="dataBaselist">
                                    <tr>
                                        <td id="dbText"></td>
                                        <td style="padding-left: 0px;">種類：<bean:write
                                                name="dataBases"
                                                property="db_datebase" /></td>
                                        <td style="font-weight: normal;">レベル：<bean:write
                                                name="dataBases"
                                                property="db_level" /></td>
                                        <td colspan="2">年数：<bean:write
                                                name="dataBases"
                                                property="db_year" />
                                        </td>
                                    </tr>
                                </logic:iterate>
                                <logic:iterate id="operatSys"
                                    name="_JNTCIPersonalInfoDetailedForm"
                                    property="operatSyslist">
                                    <tr>
                                        <td id="osText"></td>
                                        <td style="padding-left: 0px;">種類：<bean:write
                                                name="operatSys"
                                                property="os_operatsys" /></td>
                                        <td style="font-weight: normal;">レベル：<bean:write
                                                name="operatSys"
                                                property="os_level" /></td>
                                        <td colspan="2">年数：<bean:write
                                                name="operatSys"
                                                property="os_year" />
                                        </td>
                                    </tr>
                                </logic:iterate>
                                <tr>
                                    <td style="text-align: left;">日本語：</td>
                                    <td colspan="4"
                                        style="padding-left: 0px;"><bean:write
                                            name="_JNTCIPersonalInfoDetailedForm"
                                            property="japaneselist.jap_skill" />
                                        <label style="margin-left: 20px"></label></td>
                                </tr>
                                <tr>
                                    <td style="text-align: left;">英語：</td>
                                    <td colspan="4"
                                        style="padding-left: 0px;"><bean:write
                                            name="_JNTCIPersonalInfoDetailedForm"
                                            property="englishlist.eng_skill" />
                                        <label style="margin-left: 20px"></label></td>
                                </tr>
                            </table>
                        </td>
                    </tr>
                </table>






                <div style="margin: 35px 85px">
                    <logic:equal name="_JNTCIPersonalInfoDetailedForm"
                        property="jntciSelectPersonalInfo.jn_Card"
                        value="${userId }">
                        <a
                            href="/tutorial-thin/JNTCIPersonalInfoLoginInitBL.do?jn_Card=<bean:write name="_JNTCIPersonalInfoDetailedForm" property="jntciSelectPersonalInfo.jn_Card" />"
                            title="修正" style="margin-right: 125px;">
                            <input type="reset" value="修正"
                            class="btn btn-green"
                            style="margin-left: 40px;" />
                        </a>
                    </logic:equal>
                    <a
                        href="/tutorial-thin/downloadSkillBLogic.do?id_card=<bean:write name="_JNTCIPersonalInfoDetailedForm" property="jntciSelectPersonalInfo.jn_Card" />"
                        title="download" style="margin-left: -80px;">
                        <input type="reset" value="ダウンロード"
                        class="btn btn-green" style="margin-left: 40px;" />
                    </a> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                   <logic:equal name="flag" scope="session"
                        value="0">
                        <ts:link
                            action="/JNTCIPersonalInfoLoginInitAddBL.do"><a
                        href="/tutorial-thin/JNTCIPersonalInfoInquireBL.do?id_card=<bean:write name="_JNTCIPersonalInfoDetailedForm" property="cardnum" />&userName=<bean:write name="_JNTCIPersonalInfoDetailedForm" property="userName"/>&startIndex=<bean:write name="_JNTCIPersonalInfoDetailedForm" property="startIndex"/>&zhuangtai=<bean:write name="_JNTCIPersonalInfoDetailedForm" property="zhuangtai"/>&entryTime_Begin=<bean:write name="_JNTCIPersonalInfoDetailedForm" property="entryTime_Begin"/>&entryTime_End=<bean:write name="_JNTCIPersonalInfoDetailedForm" property="entryTime_End"/>&department=<bean:write name="_JNTCIPersonalInfoDetailedForm" property="department"/>&userName=<bean:write name="_JNTCIPersonalInfoDetailedForm" property="userName"/>"
                        title="getback" style="margin-left: -80px;">
                     <input  id="getback"  name="一覧に戻る" type="button" class="btn btn-green" value="一覧に戻る"   />
                   </a></ts:link>
                    </logic:equal>
                    <logic:equal name="flag" scope="session" value="1">
                        <ts:link
                            action="/JNTCIPersonalInfoLoginInitAddBL.do"><a
                        href="/tutorial-thin/JNTCIPersonalInfoInquireBL.do?id_card=<bean:write name="_JNTCIPersonalInfoDetailedForm" property="cardnum" />&userName=<bean:write name="_JNTCIPersonalInfoDetailedForm" property="userName"/>&startIndex=<bean:write name="_JNTCIPersonalInfoDetailedForm" property="startIndex"/>&zhuangtai=<bean:write name="_JNTCIPersonalInfoDetailedForm" property="zhuangtai"/>&entryTime_Begin=<bean:write name="_JNTCIPersonalInfoDetailedForm" property="entryTime_Begin"/>&entryTime_End=<bean:write name="_JNTCIPersonalInfoDetailedForm" property="entryTime_End"/>&department=<bean:write name="_JNTCIPersonalInfoDetailedForm" property="department"/>&userName=<bean:write name="_JNTCIPersonalInfoDetailedForm" property="userName"/>"
                        title="getback" style="margin-left: -80px;">
                     <input  id="getback"  name="一覧に戻る" type="button" class="btn btn-green" value="一覧に戻る"   />
                   </a></ts:link>
                    </logic:equal> <logic:equal name="flag" scope="session" value="2">
                        <ts:link
                            action="/JNTCIPersonalInfoLoginInitAddBL.do"><a
                        href="/tutorial-thin/JNTCIPersonalInfoInquireBL.do?id_card=<bean:write name="_JNTCIPersonalInfoDetailedForm" property="cardnum" />&userName=<bean:write name="_JNTCIPersonalInfoDetailedForm" property="userName"/>&startIndex=<bean:write name="_JNTCIPersonalInfoDetailedForm" property="startIndex"/>&zhuangtai=<bean:write name="_JNTCIPersonalInfoDetailedForm" property="zhuangtai"/>&entryTime_Begin=<bean:write name="_JNTCIPersonalInfoDetailedForm" property="entryTime_Begin"/>&entryTime_End=<bean:write name="_JNTCIPersonalInfoDetailedForm" property="entryTime_End"/>&department=<bean:write name="_JNTCIPersonalInfoDetailedForm" property="department"/>&userName=<bean:write name="_JNTCIPersonalInfoDetailedForm" property="userName"/>"
                        title="getback" style="margin-left: -80px;">
                     <input  id="getback"  name="一覧に戻る" type="button" class="btn btn-green" value="一覧に戻る"   />
                   </a></ts:link>
                    </logic:equal>
                </div>
                <div class="footer">
                    <p>
                        意見反馈メール：<a
                            href="mailto:jinan@trans-cosmos.com.cn"
                            target="_blank">jinan@trans-cosmos.com.cn</a>
                    </p>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
