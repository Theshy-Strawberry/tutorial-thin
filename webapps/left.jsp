
<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="/struts-html" prefix="html"%>
<%@ taglib uri="/struts-bean" prefix="bean"%>
<%@ taglib uri="/struts-logic" prefix="logic"%>
<%@ taglib uri="/terasoluna-struts" prefix="ts"%>
<%@ taglib uri="/terasoluna" prefix="t"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html:html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>済南大宇宙内部管理システム</title>
</head>
<body>
    <div id="left-container">
        <input id="flag" type="hidden"
            value="<bean:write name="flag" scope="session" />" />
        <!-- 改正  始め -->
        <h2 class="tit">
            <ts:link action="/JNTCIEquipHomePageBL.do">首頁</ts:link>
        </h2>
        <!--  終瞭 -->
        <h2 class="tit">
            <a href="#">設備管理</a>
        </h2>
        <div class="content" id="Equip">
            <div class="item-top"></div>
            <ul class="items">
                <li><ts:link action="/JNTCIEquip01SCR.do">設備購入申請</ts:link></li>
                <li><logic:equal name="flag" scope="session"
                        value="0">
                        <ts:link action="/JNTCIEquipKatabanSCR.do">設備追加</ts:link>
                    </logic:equal> <logic:equal name="flag" scope="session" value="3">
                        <ts:link action="/JNTCIEquipKatabanSCR.do">設備追加</ts:link>
                    </logic:equal></li>
                <li><ts:link
                        action="/JNTCIEquipapply02BL.do?yichang=9">設備申請</ts:link></li>
                <li><ts:link action="/JNTCIEquipListBL.do">設備一覧</ts:link></li>
                <li><ts:link action="/JNTCIEquip04BL.do">設備審査一覧</ts:link></li>
            </ul>
        </div>
        <h2 class="tit">
            <a href="#">会議室管理</a>
        </h2>
        <div class="content" id="MtRoom">
            <div class="item-top"></div>
            <ul class="items">
                <li><ts:link action="/PERSONinfo01.do">会議室申請</ts:link></li>
                <li><ts:link action="/searchMTR.do">会議室状態照会</ts:link></li>
            </ul>
        </div>
        <h2 class="tit">
            <a href="#">個人情報</a>
        </h2>
        <div class="content" id="PersonInfo">
            <div class="item-top"></div>
            <ul class="items">
                <li><logic:equal name="flag" scope="session"
                        value="0">
                        <ts:link
                            action="/JNTCIPersonalInfoLoginInitAddBL.do">社员情報登録</ts:link>
                    </logic:equal> <logic:equal name="flag" scope="session" value="1">
                        <ts:link
                            action="/JNTCIPersonalInfoLoginInitAddBL.do">社员情報登録</ts:link>
                    </logic:equal> <logic:equal name="flag" scope="session" value="2">
                        <ts:link
                            action="/JNTCIPersonalInfoLoginInitAddBL.do">社员情報登録</ts:link>
                    </logic:equal></li>
                <li><logic:equal name="flag" scope="session"
                        value="0">
                        <ts:link action="/JNTCIPersonalInfoInquireBL.do">社员情報照会</ts:link>
                    </logic:equal> <logic:equal name="flag" scope="session" value="1">
                        <ts:link action="/JNTCIPersonalInfoInquireBL.do">社员情報照会</ts:link>
                    </logic:equal> <logic:equal name="flag" scope="session" value="2">
                        <ts:link action="/JNTCIPersonalInfoInquireBL.do">社员情報照会</ts:link>
                    </logic:equal></li>
                <li><ts:link
                        action="/JNTCIPersonalInfoDetailedBL.do">個人情報詳細</ts:link></li>
            </ul>
        </div>
        <h2 class="tit">
            <a href="#">勤務管理</a>
        </h2>
        <div class="content" id="Attendance">
            <div class="item-top"></div>
            <ul class="items">
                <li><ts:link action="/JNTCIquerySRC">勤務照会</ts:link></li>
                <li><ts:link action="/queryPersonalInformation">休暇申請</ts:link></li>
                <li><logic:equal name="flag" scope="session"
                        value="0">
                        <ts:link action="/JNTCIAttendance04selectBL">休暇審査</ts:link>
                    </logic:equal> <logic:equal name="flag" scope="session" value="1">
                        <ts:link action="/JNTCIAttendance04selectBL">休暇審査</ts:link>
                    </logic:equal> <logic:equal name="flag" scope="session" value="2">
                        <ts:link action="/JNTCIAttendance04selectBL">休暇審査</ts:link>
                    </logic:equal> <logic:equal name="flag" scope="session" value="4">
                        <ts:link action="/JNTCIAttendance04selectBL">休暇審査</ts:link>
                    </logic:equal></li>
                <li><ts:link action="/VocationlistBL">年休照会</ts:link></li>
                <li><ts:link action="/JNTCIAttendanceSCR">稼働修正申請</ts:link></li>
                <li><logic:equal name="flag" scope="session"
                        value="0">
                        <ts:link action="/JNTCIAddsignInfoBL">稼働修正審査</ts:link>
                    </logic:equal> <logic:equal name="flag" scope="session" value="1">
                        <ts:link action="/JNTCIAddsignInfoBL">稼働修正審査</ts:link>
                    </logic:equal> <logic:equal name="flag" scope="session" value="2">
                        <ts:link action="/JNTCIAddsignInfoBL">稼働修正審査</ts:link>
                    </logic:equal> <logic:equal name="flag" scope="session" value="4">
                        <ts:link action="/JNTCIAddsignInfoBL">稼働修正審査</ts:link>
                    </logic:equal></li>
                <li><ts:link action="/JNTCLOvertimeApplicationSCR">残業申請</ts:link></li>
                <li><logic:equal name="flag" scope="session"
                        value="0">
                        <ts:link action="/JNTCIOverTimeVerifySCR00">残業審査</ts:link>
                    </logic:equal> <logic:equal name="flag" scope="session" value="1">
                        <ts:link action="/JNTCIOverTimeVerifySCR00">残業審査</ts:link>
                    </logic:equal> <logic:equal name="flag" scope="session" value="2">
                        <ts:link action="/JNTCIOverTimeVerifySCR00">残業審査</ts:link>
                    </logic:equal> <logic:equal name="flag" scope="session" value="4">
                        <ts:link action="/JNTCIOverTimeVerifySCR00">残業審査</ts:link>
                    </logic:equal></li>
                <li><ts:link action="/JNTCIViewApplicationBL">出張申請</ts:link></li>
                <li><logic:equal name="flag" scope="session"
                        value="0">
                        <ts:link action="/JNTCIBusinessVerify01BL.do">出張審査</ts:link>
                    </logic:equal> <logic:equal name="flag" scope="session" value="1">
                        <ts:link action="/JNTCIBusinessVerify01BL.do">出張審査</ts:link>
                    </logic:equal> <logic:equal name="flag" scope="session" value="7">
                        <ts:link action="/JNTCIBusinessVerify01BL.do">出張審査</ts:link>
                    </logic:equal> <logic:equal name="flag" scope="session" value="4">
                        <ts:link action="/JNTCIBusinessVerify01BL.do">出張審査</ts:link>
                    </logic:equal></li>
                <li><ts:link action="/seek">稼働履歴</ts:link></li>
                <li><logic:equal name="flag" scope="session"
                        value="0">
                        <ts:link action="/writeholidayBL">休暇追加</ts:link>
                    </logic:equal> <logic:equal name="flag" scope="session" value="2">
                        <ts:link action="/writeholidayBL">休暇追加</ts:link>
                    </logic:equal></li>
            </ul>
        </div>
        <h2 class="tit">
            <a href="#">座席図管理</a>
        </h2>
        <div class="content" id="Position">
            <div class="item-top"></div>
            <ul class="items">
                <li><ts:link action="/EmpPositionNorth">北開発室</ts:link></li>
                <li><ts:link action="/EmpPositionSouth">南開発室</ts:link></li>
            </ul>
        </div>
        <h2 class="tit">
            <a href="#">项目管理</a>
        </h2>
        
        <div class="content" id="Position">
            <div class="item-top"></div>
            <ul class="items">
                <li><ts:link action="/programUpdate">项目修改</ts:link></li>
            </ul>
        </div>
        
        <logic:equal name="flag" scope="session" value="0">
            <h2 class="tit">
                <a href="#">権限管理</a>
            </h2>
            <div class="content" id="Kengen">
                <div class="item-top"></div>
                <ul class="items">
                    <li><ts:link action="/JNTCISuperButtonSRC">権限変更</ts:link></li>
                </ul>
            </div>
        </logic:equal>
           <logic:equal name="flag" scope="session" value="1">
            <h2 class="tit">
                <a href="#">権限管理</a>
            </h2>
            <div class="content" id="Kengen">
                <div class="item-top"></div>
                <ul class="items">
                    <li><ts:link action="/JNTCISuperButtonSRC">権限変更</ts:link></li>
                </ul>
            </div>
        </logic:equal>
           <logic:equal name="flag" scope="session" value="4">
            <h2 class="tit">
                <a href="#">権限管理</a>
            </h2>
            <div class="content" id="Kengen">
                <div class="item-top"></div>
                <ul class="items">
                    <li><ts:link action="/JNTCISuperButtonSRC">権限変更</ts:link></li>
                </ul>
            </div>
        </logic:equal>

    </div>
</body>
</html:html>