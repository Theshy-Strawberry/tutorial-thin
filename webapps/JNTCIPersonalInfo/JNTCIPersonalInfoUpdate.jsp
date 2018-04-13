<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="/struts-html" prefix="html"%>
<%@ taglib uri="/struts-bean" prefix="bean"%>
<%@ taglib uri="/struts-logic" prefix="logic"%>
<%@ taglib uri="/terasoluna-struts" prefix="ts"%>
<%@ taglib uri="/terasoluna" prefix="t"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>済南大宇宙内部システム-個人信息修正区</title>
<link rel="stylesheet" type="text/css" href="css/base.css" />
<link rel="stylesheet" type="text/css" href="css/main.css" />
<link rel="stylesheet" type="text/css" href="css/JNTCIPersonInfo.css" />
<script type="text/javascript" src="js/laydate/laydate.js"></script>
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/JNTCIPersonInfo.js"></script>
<script type="text/javascript">
	$(function() {
		$('#left-container .content').hide();
		$('#PersonInfo').show();
		$('h2.tit').click(function() {
			$(this).next('.content').stop().slideToggle();
		});
	})
</script>
<script type="text/javascript">
	$(function() {
		var bool = <bean:write name="_JNTCIPersonalInfoLoginForm" property="judge_flg" />;
		if (bool == "1") {
			$(".readonly").attr("readonly", true);
			$(".readonly").attr("style", "background-color:#DDDDDD")
		}
	});
</script>

<script>
	$(function() {
		$(".tdDisplay").each(function(index) {
			if (index != 0) {
				$(this).text("");
			}
		});
	});

	$(function() {
		$(".Display").each(function(index) {
			if (index != 0) {
				$(this).text("");
			}
		});
	});

	$(function() {
		var count= $("#count").val();
		if(count==1){
			alert("登录成功");
			$("#count").val("");
		}
		var checkResult= $("#checkResult").val();
		if(checkResult=='success'){
			alert("修改成功");
			$("#checkResult").val("");
		}
	});
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
		<div class="rightWidht">
			<div class="header">
				<ul class="breadcrumbs clearfix">
					<li>ステップチャート：</li>
					<li><a href="#">個人情報</a></li>
					<li class="ico">&gt;</li>
					<li><a href="#">個人情報修正</a></li>
				</ul>
			</div>
				<div
				      style="max-height: 100px; overflow: auto; width: 500px; margin-left: 25px;">
				     <html:errors />
				     <html:messages id="message" message="true">
					        <span style="color: blue" id="spanId"><bean:write
							        name="message" /></span>
				     </html:messages>
				</div>

			<div>
			     <ts:form styleId="loginForm" action="/JNTCIPersonalInfo01insertBL"
				method="POST" enctype="multipart/form-data">
				<div id="errorMessageDIV" class="main-ctn,display"
					style="max-height: 100px; overflow: auto; color: red; padding-left: 50px"></div>
				<div class="main-ctn self-info">
						<table width="100%">
							<colgroup>
								<col width="65" />
								<col width="80" />
								<col width="65" />
								<col width="100" />
								<col width="180" />
							</colgroup>
							<tr>
								<th colspan="5">基本情報<input type="hidden" id="count" value="<bean:write
									name="_JNTCIPersonalInfoLoginForm" property="count"/>"/>
									<input type="hidden" id="checkResult" value="<bean:write
									name="_JNTCIPersonalInfoLoginForm" property="checkResult"/>"/>
									</th>
							</tr>
							<tr>

								<td>済南カード：</td>
								<td><bean:write name="_JNTCIPersonalInfoLoginForm" property="jn_Card"/></td>

								<td> 天津カード：</td>
								<td><bean:write name="_JNTCIPersonalInfoLoginForm" property="tj_Card"/></td>

								<td rowspan="5" class="pic">
									<div id="preview"
										style="border: 2px solid; padding: 3px 5px 5px 3px;">
										<img id="imghead"
											src="<bean:write name="_JNTCIPersonalInfoLoginForm" property="photo_Path" />"
											width="100" height="110" />
									</div> <br />

									<input type="file" name="uploadFile"
									onchange="previewImage(this)" accept="image/jpeg" id="photo"
									style="display: none" />

								</td>
							</tr>
							<html:hidden name="_JNTCIPersonalInfoLoginForm" property="jn_Card" />
							<html:hidden name="_JNTCIPersonalInfoLoginForm" property="tj_Card" />
							<html:hidden name="_JNTCIPersonalInfoLoginForm" property="photo_Path" />
							<tr>
								<td>名前：</td>
								<td><bean:write name="_JNTCIPersonalInfoLoginForm" property="userName" /></td>
								<td>性別：</td>
								<td><html:radio name="_JNTCIPersonalInfoLoginForm"
										property="sex" value="1" /> <label for="man" >男</label> <html:radio
										name="_JNTCIPersonalInfoLoginForm" property="sex" value="0" />
									<label for="woman">女</label></td>
							</tr>
							<html:hidden name="_JNTCIPersonalInfoLoginForm" property="userName" />
							<tr>
								<td>ローマ字：</td>
								<td><bean:write name="_JNTCIPersonalInfoLoginForm" property="jn_Name"/></td>
								<td>民族：</td>
								<td><bean:write name="_JNTCIPersonalInfoLoginForm" property="nation" /></td>
							</tr>
							<html:hidden name="_JNTCIPersonalInfoLoginForm" property="jn_Name" />
							<html:hidden name="_JNTCIPersonalInfoLoginForm" property="nation" />
							<tr>
								<td>生年月日：</td>
								<td><bean:write name="_JNTCIPersonalInfoLoginForm" property="birthday"/></td>
								<td>国籍：</td>
								<td><bean:write name="_JNTCIPersonalInfoLoginForm" property="nationality"/></td>
							</tr>
							<html:hidden name="_JNTCIPersonalInfoLoginForm" property="birthday" />
							<html:hidden name="_JNTCIPersonalInfoLoginForm" property="nationality" />
							<tr>
 						<td>婚姻状況：</td>
						<td><html:radio
								 name="_JNTCIPersonalInfoLoginForm"
								property="marital_Status" value="1" /> <label for="unmarried"> 未婚  </label><html:radio
								 name="_JNTCIPersonalInfoLoginForm"
								property="marital_Status" value="0" /> <label for="married"> 既婚 </label>	</td>
							<td>身分証明書：</td>
								<td><bean:write name="_JNTCIPersonalInfoLoginForm" property="id_Card"/></td>
							</tr>
							<html:hidden name="_JNTCIPersonalInfoLoginForm" property="id_Card"  />
							<tr>
								<td>連絡電話：</td>
								<td><html:text name="_JNTCIPersonalInfoLoginForm"
										property="telephone" maxlength="11"/></td>
								<td>出身：</td>
								<td><bean:write name="_JNTCIPersonalInfoLoginForm" property="born_In" /></td>
							</tr>
							<html:hidden name="_JNTCIPersonalInfoLoginForm" property="telephone" />
							<html:hidden name="_JNTCIPersonalInfoLoginForm" property="born_In" />
							<tr>
								<td>緊急連絡先：</td>
								<td><html:text name="_JNTCIPersonalInfoLoginForm"
										property="emerg_Contact"
										maxlength="13"/></td>
								<td>緊急連絡先電話：</td>
								<td><html:text name="_JNTCIPersonalInfoLoginForm"
										property="emerg_Contact_tel" maxlength="11" /></td>
							</tr>
							<html:hidden name="_JNTCIPersonalInfoLoginForm" property="emerg_Contact" />
							<html:hidden name="_JNTCIPersonalInfoLoginForm" property="emerg_Contact_tel" />
							<tr>
								<td>今詳細な住所：</td>
								<td><html:text name="_JNTCIPersonalInfoLoginForm"
										property="address" maxlength="30"/></td>
							</tr>
							<html:hidden name="_JNTCIPersonalInfoLoginForm" property="address" />
							<tr>
								<th colspan="5">詳細情報</th>
							</tr>
							<tr>
								<td>所属部門：</td>
								<td><bean:write name="_JNTCIPersonalInfoLoginForm" property="department" /></td>
								<td>ポスト：</td>
								<td colspan="2"><bean:write
										name="_JNTCIPersonalInfoLoginForm" property="position" /></td>
							</tr>
							<html:hidden name="_JNTCIPersonalInfoLoginForm" property="department" />
							<html:hidden name="_JNTCIPersonalInfoLoginForm" property="position" />
							<tr>
								<td>パスポート：</td>
								<td><html:radio styleId="p-has"
										name="_JNTCIPersonalInfoLoginForm" property="passport"
										value="1" /> <label for="p-has">無</label> <html:radio
										styleId="p-hasnot" name="_JNTCIPersonalInfoLoginForm"
										property="passport" value="0" /> <label for="p-hasnot">有</label>
								</td>
								<td>ビザ：</td>
								<td colspan="2"><html:radio
										name="_JNTCIPersonalInfoLoginForm" property="visa" value="1" />
									<label for="v-has">無</label> <html:radio
										name="_JNTCIPersonalInfoLoginForm" property="visa" value="0" />
									<label for="v-hasnot">有</label></td>
							</tr>
							<tr>
								<td>入社時間：</td>
								<td><bean:write
										name="_JNTCIPersonalInfoLoginForm" property="entry_Time" /></td>
							<td>社保時間：</td>
								<td><bean:write
										name="_JNTCIPersonalInfoLoginForm" property="SYAHO_JIKAN" /></td>
										<html:hidden name="_JNTCIPersonalInfoLoginForm" property="SYAHO_JIKAN" />
							</tr>
							<tr><td>最終学歴：</td>
								<td colspan="2"> <bean:write
										name="_JNTCIPersonalInfoLoginForm" property="education" />
								</td></tr>
							<html:hidden name="_JNTCIPersonalInfoLoginForm" property="entry_Time" />
							<html:hidden name="_JNTCIPersonalInfoLoginForm" property="education" />

							<tr>
								<td>得意分野：</td>
								<td colspan="4"><html:text
										name="_JNTCIPersonalInfoLoginForm" property="tech_capability"
										style="width:450px" maxlength="66"/> <label style="margin-left: 10px">(コンマで仕切ってください)</label></td>
							</tr>
							<tr>
								<td>個人メールボックス：</td>
								<td><html:text name="_JNTCIPersonalInfoLoginForm"
										property="pesonal_Mall" maxlength="66"/></td>
								<td>社内メールボックス：</td>
								<td colspan="2"><html:text
										name="_JNTCIPersonalInfoLoginForm" property="offic_Mail" maxlength="20"/><label
									style="margin: 0 3px;">@trans-cosmos.com.cn </label></td>
							</tr>
							<logic:iterate id="occupationInfo"
								name="_JNTCIPersonalInfoLoginForm" property="occupation">
								<tr class="qualificationTR">
									<td class="tdDisplay">職業資格：</td>
									<td colspan="4"><label>受賞日付</label> <html:text
											name="occupationInfo" property="winning_date"
											style="width:70px; margin-right:20px" maxlength="7" /> <label
										style="margin-left: -20px">(YYYY/MM)</label> <label
										style="margin-left: 20px">受賞証書</label> <html:text
											name="occupationInfo" property="wining_certificate"
											style="width:350px; margin-right:20px" maxlength="20"/> <input
										type="button" class="btn btn-green" name="addRow"
										value="追加" /> <input type="button"
										class="btn btn-red" name="delRow" value="削除" />
									</td>
								</tr>
							</logic:iterate>

							<html:hidden styleId="qualification"
								name="_JNTCIPersonalInfoLoginForm" property="qualificationStr" />


							<logic:iterate id="workStrInfo"
								name="_JNTCIPersonalInfoLoginForm" property="workStr">
							<tr class="workStrTR">
								<td>作業経験：</td>
								<td colspan="4"><label>類型 ：</label> <t:defineCodeList
										id="occupationList" /> <html:select
										name="workStrInfo" property="work_Experience"
										style="width:120px">
										<html:options collection="occupationList" property="id"
											labelProperty="name" />
									</html:select> <label style="margin-left: 20px;">年限 ：</label> <html:text
										name="workStrInfo" property="work_time"
										style="width: 50px; margin-right: 20px" maxlength="3"/>(ヶ月)    <input
									type="button" class="btn btn-green" name="addRow" value="追加" />
									<input type="button" class="btn btn-red" name="delRow"
									value="削除" /></td>
							</tr>
							</logic:iterate>

							<html:hidden styleId="work_Experience"
								name="_JNTCIPersonalInfoLoginForm" property="work_ExperienceStr" />

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
												<th colspan="2" rowspan="2">機種及び<br />使用デバイス
												</th>
											</tr>
											<tr>
												<th>プロジエクト名</th>
											</tr>
										</thead>

										<tbody>
											<logic:iterate id="workInfo"
												name="_JNTCIPersonalInfoLoginForm" property="workList">
												<tr>
													<td rowspan='2'>
													<bean:write name="workInfo"
															property="order_no" /></td>
													<td><html:text name="workInfo" property="careers_type" maxlength="66" /></td>
													<td rowspan='2'>
													<html:text name="workInfo"
															property="attend_nm" style='width:25px' maxlength="4"/>人&nbsp;*&nbsp;<html:text
															name="workInfo" property="attend_month"
															style='width:25px' maxlength="4"/>ヶ月</td>
													<td rowspan='2'><html:textarea name="workInfo"
															property="attend_states"></html:textarea></td>
													<td rowspan='2'><html:textarea name="workInfo"
															property="develop_phase" styleClass="develop_phase16"></html:textarea></td>
													<td rowspan='2'><html:textarea name="workInfo"
															property="firm_content"></html:textarea></td>
													<td><html:text name="workInfo" property="lang_tool" maxlength="66" /></td>
													<td><html:text name="workInfo" property="data_base" maxlength="33"/></td>
													<td><html:text name="workInfo"
															property="technical_sys" maxlength="33" /></td>
													<td colspan='2'><html:text name="workInfo"
															property="model_device" maxlength="6"/></td>
												</tr>
												<tr>
													<td><html:text name="workInfo" property="proj_name" maxlength="50"/></td>
													<td
														style='font-weight: bold; font-size: 1.1em; text-align: right; padding-right: 15px;'>開発担当期間:</td>
													<td colspan='2'><html:text name="workInfo"
															property="develop_period" maxlength="15"/><span>(YYYY/MM~YYYY/MM)</span></td>
													<td
														style='font-weight: bold; font-size: 1.1em; text-align: right; padding-right: 15px;'>合計期間:</td>
													<td><html:text name="workInfo" property="total_period" maxlength="6" style='width:50px'/>(ヶ月)</td>
												</tr>
											</logic:iterate>
										</tbody>

									</table> <small> 参加形態： ①プロジェクト・マネージャ②プロジェクト・サブマネージャ ③システムエンジニア
										④プログラマー ⑤テスト ⑥運用<br /> 開発フェーズ：①要件定義②基本設計(システム設計) ③機能設計 ④詳細設計
										⑤プログラミング ⑥デバック ⑦評価 ⑧運用
								</small> <input type="button" class="btn btn-green" onclick="addT(this)"
									value="追加" /> <input type="button" class="btn btn-red"
									onclick="delT(this)" value="削除" />
								</td>
							</tr>
						</table>
						<table width="100%"><tr><th colspan="6"></th></tr></table>
						<div style="margin-left:35%"><small><small>レベル内容    levelc<br />
														  5 殆どの機能が完璧に使用できる（スペシャリスト）<br />
														  4 応用的機能が使える（複雑な処理を開発できる）<br />
														  3 一通り使用できる（実際いくつか開発した）<br />
														  2 簡単な機能が使える（組んだ事がある・社内研修済）<br />
														  1 触ったことがある（授業/独学）<br /></small></small>
						</div>
						<table width="100%" class="bottom_table">
							<colgroup>
								<col width="65" />
								<col width="50" />
								<col width="45" />
								<col width="50" />
								<col width="65" />
								<col width="220" />
							</colgroup>
						<logic:iterate id="languageInfo"
								name="_JNTCIPersonalInfoLoginForm" property="language">
							<tr class="lang">
								<td> 言語：</td>
								<td><t:defineCodeList id="languageList" /> <html:select
									name="languageInfo" property="yy_language"
									style="width:120px;">
									<html:options collection="languageList" property="id" labelProperty="name" />
									</html:select></td>

								<td> level:</td>
								<td><html:text
										name="languageInfo" property="yy_level"
										maxlength="1" /></td>

								<td> 年数：</td>
								<td><html:text
										name="languageInfo" property="yy_year"
										maxlength="4"  />	<input
									type="button" class="btn btn-green" name="addRow"
									value="追加" /> <input type="button"
									class="btn btn-red" name="delRow" value="削除" /></td>
							</tr>
						</logic:iterate>
						<html:hidden styleId="language2"
								name="_JNTCIPersonalInfoLoginForm" property="languageStr" />


						<logic:iterate id="javaEnvirnInfo"
								name="_JNTCIPersonalInfoLoginForm" property="jEnvirnment">
							<tr class="envirn">
								<td> Java環境：</td>
								<td><t:defineCodeList id="javaEnvirnList" /> <html:select
									name="javaEnvirnInfo" property="jhj_Envirnment"
									style="width:120px;">
									<html:options collection="javaEnvirnList" property="id" labelProperty="name" />
									</html:select></td>

								<td> level:</td>
								<td><html:text
										name="javaEnvirnInfo" property="jhj_level"
										maxlength="1" /></td>

								<td> 年数：</td>
								<td><html:text
										name="javaEnvirnInfo" property="jhj_year"
										maxlength="4"  />	<input
									type="button" class="btn btn-green" name="addRow"
									value="追加" /> <input type="button"
									class="btn btn-red" name="delRow" value="削除" /></td>
							</tr>
						</logic:iterate>
						<html:hidden styleId="javaenvironment"
								name="_JNTCIPersonalInfoLoginForm" property="javaenvironmentStr" />


						<logic:iterate id="javaLangInfo"
								name="_JNTCIPersonalInfoLoginForm" property="jLanguage">
							<tr class="javaLang">
								<td> Java言語：</td>
								<td><t:defineCodeList id="javaLangList" /> <html:select
									name="javaLangInfo" property="jyy_language"
									style="width:120px;">
									<html:options collection="javaLangList" property="id" labelProperty="name" />
									</html:select></td>

								<td> level:</td>
								<td><html:text
										name="javaLangInfo" property="jyy_level"
										maxlength="1" /></td>

								<td> 年数：</td>
								<td><html:text
										name="javaLangInfo" property="jyy_year"
										maxlength="4"  />	<input
									type="button" class="btn btn-green" name="addRow"
									value="追加" /> <input type="button"
									class="btn btn-red" name="delRow" value="削除" /></td>
							</tr>
						</logic:iterate>
						<html:hidden styleId="javalanguage"
								name="_JNTCIPersonalInfoLoginForm" property="javalanguageStr" />


						<logic:iterate id="toolInfo"
								name="_JNTCIPersonalInfoLoginForm" property="editTool">
							<tr class="jtool">
								<td> Tool：</td>
								<td><t:defineCodeList id="toolList" /> <html:select
									name="toolInfo" property="tl_tool"
									style="width:120px;">
									<html:options collection="toolList" property="id" labelProperty="name" />
									</html:select></td>

								<td> level:</td>
								<td><html:text
										name="toolInfo" property="tl_level"
										maxlength="1" /></td>

								<td> 年数：</td>
								<td><html:text
										name="toolInfo" property="tl_year"
										maxlength="4"  />	<input
									type="button" class="btn btn-green" name="addRow"
									value="追加" /> <input type="button"
									class="btn btn-red" name="delRow" value="削除" /></td>
							</tr>
						</logic:iterate>
						<html:hidden styleId="tool"
								name="_JNTCIPersonalInfoLoginForm" property="toolStr" />


						<logic:iterate id="dbInfo"
								name="_JNTCIPersonalInfoLoginForm" property="dataBase">
							<tr class="db">
								<td> DB：</td>
								<td><t:defineCodeList id="dbList" /> <html:select
									name="dbInfo" property="db_datebase"
									style="width:120px;">
									<html:options collection="dbList" property="id" labelProperty="name" />
									</html:select></td>

								<td> level:</td>
								<td><html:text
										name="dbInfo" property="db_level"
										maxlength="1" /></td>

								<td> 年数：</td>
								<td><html:text
										name="dbInfo" property="db_year"
										maxlength="4"  />	<input
									type="button" class="btn btn-green" name="addRow"
									value="追加" /> <input type="button"
									class="btn btn-red" name="delRow" value="削除" /></td>
							</tr>
						</logic:iterate>
						<html:hidden styleId="db"
								name="_JNTCIPersonalInfoLoginForm" property="dbStr" />


						<logic:iterate id="operatSysInfo"
								name="_JNTCIPersonalInfoLoginForm" property="operatSys">
							<tr class="os">
								<td> OS：</td>
								<td><t:defineCodeList id="sysOperatList" /> <html:select
									name="operatSysInfo" property="os_operatsys"
									style="width:120px;">
									<html:options collection="sysOperatList" property="id" labelProperty="name" />
									</html:select></td>

								<td> level:</td>
								<td><html:text
										name="operatSysInfo" property="os_level"
										maxlength="1" /></td>

								<td> 年数：</td>
								<td><html:text
										name="operatSysInfo" property="os_year"
										maxlength="4"  />	<input
									type="button" class="btn btn-green" name="addRow"
									value="追加" /> <input type="button"
									class="btn btn-red" name="delRow" value="削除" /></td>
							</tr>
						</logic:iterate>
						<html:hidden styleId="os"
								name="_JNTCIPersonalInfoLoginForm" property="osStr" />


							<tr>
								<td> ☆ 日本語:</td>
								<td colspan="5"></td>
							</tr>

							<tr>
								<td></td>
								<td colspan="5">
								<html:multibox
										name="_JNTCIPersonalInfoLoginForm" property="jap_skill" value="4" />業務上の会話ができる&nbsp;&nbsp;&nbsp;
								<html:multibox
										name="_JNTCIPersonalInfoLoginForm" property="jap_skill" value="5" />書く&nbsp;&nbsp;&nbsp;
								<html:multibox
										name="_JNTCIPersonalInfoLoginForm" property="jap_skill" value="6" />読む&nbsp;&nbsp;&nbsp;
								<html:multibox
										name="_JNTCIPersonalInfoLoginForm" property="jap_skill" value="7" />技術書が読める&nbsp;&nbsp;&nbsp;
								<html:multibox
										name="_JNTCIPersonalInfoLoginForm" property="jap_skill" value="8" />ドキュメントが作成できる&nbsp;&nbsp;&nbsp;

								</td>
							</tr>
							<html:hidden styleId="japan"
								name="_JNTCIPersonalInfoLoginForm" property="japanStr" />
							<tr>
								<td> ☆ 英語:</td>
								<td colspan="5"></td>
							</tr>

							<tr>
								<td></td>
								<td colspan="5">
								<html:multibox
										name="_JNTCIPersonalInfoLoginForm" property="eng_skill" value="4" />業務上の会話ができる&nbsp;&nbsp;&nbsp;
								<html:multibox
										name="_JNTCIPersonalInfoLoginForm" property="eng_skill" value="5" />書く&nbsp;&nbsp;&nbsp;
								<html:multibox
										name="_JNTCIPersonalInfoLoginForm" property="eng_skill" value="6" />読む&nbsp;&nbsp;&nbsp;
								<html:multibox
										name="_JNTCIPersonalInfoLoginForm" property="eng_skill" value="7" />技術書が読める&nbsp;&nbsp;&nbsp;
								<html:multibox
										name="_JNTCIPersonalInfoLoginForm" property="eng_skill" value="8" />ドキュメントが作成できる&nbsp;&nbsp;&nbsp;

								</td>
							</tr>
							<html:hidden styleId="english"
								name="_JNTCIPersonalInfoLoginForm" property="englishStr" />
						</table>
						<div style="margin: 35px 85px">
							<input id="submitForm" type="button" value="修正" class="btn btn-blue" />
					<a href="/tutorial-thin/JNTCIPersonalInfoLoginInitBL.do?jn_Card=<bean:write name="_JNTCIPersonalInfoLoginForm" property="jn_Card" />"
							title="重置" style="margin-right: 125px;">
							<input type="button" value="重置" class="btn btn-green" style="margin-left: 40px;" /></a>
						</div>
						<html:hidden name="_JNTCIPersonalInfoLoginForm"
							property="judge_flg" />
						<html:hidden name="_JNTCIPersonalInfoLoginForm" property="list"
							styleId="list" />
			           <div class="footer">
						<p>
							意見反馈メール：<a href="mailto:jinan@trans-cosmos.com.cn" target="_blank">jinan@trans-cosmos.com.cn</a>
						</p>
					   </div>
				</div>
			</ts:form>
			</div>
		</div>
			<script type="text/javascript">
				!function() {
					laydate.skin('yahui');//切换皮肤，请查看skins下面皮肤库
					laydate({
						elem : '#demo'
					});//绑定元素
				}();

				//日期范围限制
				var start = {
					elem : '#BIRTHDAR',
					format : 'YYYY-MM-DD',
					max : laydate.now(), //设定最小日期为当前日期
					istoday : false,

				};

				var end = {
					elem : '#ENTRY_TIME',
					format : 'YYYY-MM-DD',
					max : laydate.now(),
					istoday : false,

				};
				laydate(start);
				laydate(end);
			</script>
		</div>
	</div>
</body>
</html>
