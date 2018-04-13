//JavaScript Document
$(function() {
	$('#left-container .content').hide();
	$('#Attendance').show();
	$('h2.tit').click(function(){
		$(this).next('.content').stop().slideToggle();
	})

	$("#selectAll").click(function() {
		if ($(this).prop("checked") == true) {
			$("[name='select']").prop("checked", true);
			document.getElementById("delete_list").disabled = false;
			document.getElementById("allowlist").disabled = false;
			document.getElementById("unallowlist").disabled = false;
		} else {
			$("[name='select']").prop("checked", false);
			document.getElementById("delete_list").disabled = true;
			document.getElementById("allowlist").disabled = true;
			document.getElementById("unallowlist").disabled = true;
		}
	});
	$("[name='select']").bind("click", function() {
		var bool="";
		$("[name='select']").each(function() {
			if ($(this).prop("checked") == true) {
				bool = false;
				return false;
			} else {
				bool = true;
			}
		});
		var num=0;
		$("[name='select']").each(function() {
			if ($(this).prop("checked") == true) {
				num++;
			}
		})
		if($("[name='select']").length==num){
			$("#selectAll").prop("checked",true);
		}else{
			$("#selectAll").prop("checked",false);
		}
		document.getElementById("delete_list").disabled = bool;
		document.getElementById("allowlist").disabled = bool;
		document.getElementById("unallowlist").disabled = bool;
	});

	$("#delete_list")
			.on(
					"click",
					function() {
						if (confirm("削除したら、復元することができません。本当に削除しますか？")) {
							var cards = "";
							$("[name='select']")
									.each(
											function() {
												if ($(this).prop("checked") == true) {
													var id_card = $(this).val();
													var arraylist = $(
															"#selectlistId")
															.val().split(",");
													var symb = 0;
													for (var i = 0; i < arraylist.length; i++) {
														if (id_card == arraylist[i]) {
															symb = symb + 1;
														}
													}
													if (symb == 0) {
														cards = id_card + ","
																+ cards;
													}
												}
											})
							var selectlist = "";
							var arraylist = $("#selectlistId").val().split(",");
							if (arraylist.length > 1) {
								for (var i = 0; i < arraylist.length; i++) {
									var quality = "[name='select']"
											+ "[value='" + arraylist[i] + "']";
									if ($(quality).prop("checked") != false) {
										selectlist = arraylist[i] + ","
												+ selectlist;
									}
								}
							}
							$("#selectlistId").val(selectlist);
							if (selectlist == "" || selectlist == " ") {
							} else {
								cards = selectlist + cards;
							}
							cards = cards.substring(0, cards.length - 1);
							$
									.ajax({
										cache : true,
										type : "POST",
										url : '/tutorial-thin/JNTCIOverTimeVerify/JNTCIOverTimeVerifyDeleteBL.do',
										data : {
											'deleteExtra_Id' : cards
										},
										async : false,
										error : function(request) {
											alert("削除が失敗しました");
										},
										success : function(data) {
											alert("削除が成功しました");
											$('#submitButId').click();
										}
									});
						}
					});
	$("td a").on(
			"click",
			function() {
				var record = "";
				$("[name='select']").each(function() {
					if ($(this).prop("checked") == true) {
						var id_card = $(this).val();
						var arraylist = $("#selectlistId").val().split(",");
						var symb = 0;
						for (var i = 0; i < arraylist.length-1; i++) {
							if (id_card == arraylist[i]) {
								symb = symb + 1;
							}
						}
						if (symb == 0) {
							record = id_card + "," + record;
						}
					}
				})
				var selectlist = "";
				var arraylist = $("#selectlistId").val().split(",");
				if (arraylist.length > 1) {
					for (var i = 0; i < arraylist.length-1; i++) {
						var quality = "[name='select']" + "[value='"
								+ arraylist[i] + "']";
						if ($(quality).prop("checked") != false) {
							selectlist = arraylist[i] + "," + selectlist;
						}
					}
				}
				$("#selectlistId").val(selectlist);
				if (selectlist == "" || selectlist == " ") {
				} else {
					record = selectlist + record;
				}
				var address = $(this).attr("href") + "&selectlist=" + record;
				$(this).attr("href", address);
			})

	var array = $("#selectlistId").val().split(",");
	for (var i = 0; i < array.length; i++) {
		var quality = "[name='select']" + "[value='" + array[i] + "']";
		$(quality).prop("checked", true);
	}
	var bool = false;
	$("[name='select']").each(function() {
		if ($(this).prop("checked") == true) {
			bool = false;
			return false;
		} else {
			bool = true;
		}
	});
	document.getElementById("delete_list").disabled = bool;
	document.getElementById("allowlist").disabled = bool;
	document.getElementById("unallowlist").disabled = bool;
	var count = 0;
	$("[name='select']").each(function() {
		if ($(this).prop("checked") == true) {
			count++;
		}
	})
	if($("[name='select']").length==count){
		$("#selectAll").prop("checked",true);
	}
	// 登録
	$("#submitForm")
			.click(
					function() {
						// データ チェック
						var errorMessage = "<h3>以下のエラーが発生しました。</h3>";
						$(".required").each(
								function() {
									if ($(this).children("input").val() == "") {
										errorMessage = errorMessage
												+ "●"
												+ $(this).prev().text()
														.replace("*", "")
														.replace("：", "")
												+ "は入力しなければならない.</br>";
									}
								});
						var phoneCheck = /^1[3|4|5|7|8]\d{9}$/;
						var idCradCheck = /(^\d{15}$)|(^\d{18}$)|(^\d{17}(\d|X|x)$)/;
						var emailCheck = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
						/* var nameCheck = /^[\u4e00-\u9fa5],{0,}$/; */
						var num4Check = /[0-9]{4}/;
						var numCheck = /^[0-9]+$/;
						var dateCheck = /^[0-9]{4}\/[0-9]{2}$/;
						var offic_MailCheck = /^[A-Za-z0-9.]+$/;
						var jn_Card = $("input[name='jn_Card']").val();
						if (jn_Card != "" && !num4Check.test(jn_Card)) {
							errorMessage = errorMessage
									+ "● 済南カード必須四位数字を入力してください.</br>"
						}
						var tj_Card = $("input[name='tj_Card']").val();
						if (tj_Card != "" && !num4Check.test(tj_Card)) {
							errorMessage = errorMessage
									+ "● 天津カード必須四位数字を入力してください.</br>"
						}
						var idCrad = $("input[name='id_Card']").val();
						if (idCrad != "" && !idCradCheck.test(idCrad)) {
							errorMessage = errorMessage
									+ "● 身分証明書の形式は間違っている.</br>"
						}
						/*
						 * var userName = $("input[name='userName']").val();
						 * if(userName != "" && !nameCheck.test(userName)){
						 * errorMessage = errorMessage + "● 名前漢字を入力してください.</br>" }
						 */
						var phone = $("input[name='telephone']").val();
						if (phone != "" && !phoneCheck.test(phone)) {
							errorMessage = errorMessage
									+ "● 連絡電話の形式は間違っている.</br>"
						}
						var emerg_Contact_tel = $(
								"input[name='emerg_Contact_tel']").val();
						if (emerg_Contact_tel != ""
								&& !phoneCheck.test(emerg_Contact_tel)) {
							errorMessage = errorMessage
									+ "● 緊急連絡先電話の形式は間違っている.</br>"
						}
						var email = $("input[name='pesonal_Mall']").val();
						if (email != "" && !emailCheck.test(email)) {
							errorMessage = errorMessage
									+ "● 個人メールボックスの形式は間違っている.</br>"
						}
						var offic_Mail = $("input[name='offic_Mail']").val();
						if (offic_Mail != ""
								&& !offic_MailCheck.test(offic_Mail)) {
							errorMessage = errorMessage
									+ "● 社内メールボックスの形式は間違っている.</br>"
						}
						$(".qualificationTR")
								.find("input[name='winning_date']")
								.each(
										function() {
											var winning_date = $(this).val();
											if (winning_date != ""
													&& !dateCheck
															.test(winning_date)) {
												errorMessage = errorMessage
														+ "● 受賞日付にYYYY/MM 形式を入力してください.</br>"
												return false;
											}
										})

						$(".workStrTR").find("input[name='work_time']").each(
								function() {
									var work_time = $(this).val();
									if (work_time != ""
											&& !numCheck.test(work_time)) {
										errorMessage = errorMessage
												+ "● 年限数字を入力してください.</br>"
										return false;
									}
								})
						$("input[name='attend_nm']").each(
								function() {
									var attend_nm = $(this).val();
									if (attend_nm != ""
											&& !numCheck.test(attend_nm)) {
										errorMessage = errorMessage
												+ "● 参加人数数字を入力してください.</br>"
										return false;
									}
								})
						$("input[name='attend_month']").each(
								function() {
									var attend_nm = $(this).val();
									if (attend_nm != ""
											&& !numCheck.test(attend_nm)) {
										errorMessage = errorMessage
												+ "● 参加月数数字を入力してください.</br>"
										return false;
									}
								})
						$("#errorMessageDIV").html("");
						if (errorMessage.indexOf("●") != -1) {
							$("#errorMessageDIV").append(errorMessage);
							$("#errorMessageDIV").removeClass("display");
							return false;
						}

						// 作業経験
						var experienceStr = "";
						$("select[name='work_Experience']")
								.each(
										function() {
											var experience = $(this).find(
													"option:selected").text();
											var time = $(this).next().next()
													.val();
											if (time != "") {
												experienceStr = experienceStr
														+ experience + ":"
														+ time + ",";
											}
										});
						experienceStr = experienceStr.substring(0,
								experienceStr.length - 1);
						$("#work_Experience").val(experienceStr);

						// 仕事経験
						var trContext = "";
						var comma = " comma";
						var semicolon = "semicolon";
						var b = $("#embed-table tbody tr :input");
						b.each(function(i) {
							trContext += $(this).val();
							trContext += comma;
							if ((i + 1) % 13 == 0) {
								trContext += semicolon;
							}
						});

						$("#list").val(trContext);

						// 職業資格
						var qualContext = "";
						var aa = $(".qualificationTR td input[type='text']");
						aa.each(function(i) {
							qualContext += $(this).val();
							qualContext += comma;
							if ((i + 1) % 2 == 0) {
								qualContext += semicolon;
							}
						});
						$("#qualification").val(qualContext);

						$("#loginForm").submit();
					});

	$(".qualificationTR:last input[type='button']").removeClass("display");
	$(".workStrTR:last input[type='button']").removeClass("display");

	$("input[name='addRow']").bind(
			"click",
			function() {
				var copyObj = $(this).parent().parent();
				var newObj = copyObj.clone(true);
				newObj.children("td:first").html("");
				copyObj.children("td:last").children("input[type='button']")
						.addClass("display");
				$(this).parent().parent().after(newObj);
				$(this).parent().parent().next().find("input[type='text']")
						.val("")
			});

	$("input[name='delRow']").bind(
			"click",
			function() {
				var copyObj = $(this).parent().parent();
				if ($("." + copyObj.attr("class")).length > 1) {
					copyObj.prev('tr').children("td:last").children(
							"input[type='button']").removeClass("display");
					copyObj.remove();
				}
			});

})

$(function() {
	H_login = {};
	H_login.openLogin = function() {
		$('#p-hasnot').click(function() {
			$('.login').show();
			$('.login-bg').show();
			$('#updateInfo').show();
		});
	};
	H_login.closeLogin = function() {
		$('.close-login').click(function() {
			$('.login').hide();
			$('.login-bg').hide();
			$('#updateInfo').hide();
		});
	};

	var passportNoCheck = /^[A-Za-z]{1}\d{8}/;

	H_login.loginForm = function() {
		$("#login-button-submit").on('click', function() {
			var passportNo = $("#passportNo");
			var passportNoValue = $("#passportNo").val();
			var issueDate = $("#issueDate");
			var issueDateValue = $("#issueDate").val();
			var expiryDate = $("#expiryDate");
			var expiryDateValue = $("#expiryDate").val();
			if (passportNoValue == "") {
				alert("パスポート番号を必ず入力してください！");
				passportNo.focus();
				return false;
			} else if (!passportNoCheck.test(passportNoValue)) {
				alert("パスポート番号の形式は間違いです");
				expiryDate.focus();
				return false;
			} else if (issueDateValue == "") {
				alert("発行日付を必ず入力してください");
				issueDate.focus();
				return false;
			} else if (expiryDateValue == "") {
				alert("有効期限至を必ず入力してください");
				expiryDate.focus();
				return false;
			} else {
				alert("登録が成功しました");
				setTimeout(function() {
					$('.login').hide();
					$('.login-bg').hide();

				}, 2000);
			}
		});
	};
	H_login.run = function() {
		this.closeLogin();
		this.openLogin();
		this.loginForm();
	};
	H_login.run();
});

function addT(o) {
	var tr1 = $("#embed-table tbody tr:last").prev();
	var copyTr1 = tr1.clone(true);
	copyTr1.children("td:eq(0)").text(
			Number(tr1.children("td:eq(0)").text()) + 1);
	var copyTr2 = $("#embed-table tbody tr:last").clone(true);
	var trStr = "<tr>" + copyTr1.html() + "</tr>" + "<tr>" + copyTr2.html()
			+ "</tr>";
	$("#embed-table tbody").append(trStr);
	$("#embed-table tbody tr:last").prev().find("input,textarea").val("");
	$("#embed-table tbody tr:last").find("input").val("");
};
function delT(o) {
	if ($("#embed-table tbody tr").length > 2) {
		$("#embed-table tbody tr:last").prev().remove();
		$("#embed-table tbody tr:last").remove();
	}
}

// 图片上传预览 IE是用了滤镜。
function previewImage(file) {
	var MAXWIDTH = 260;
	var MAXHEIGHT = 180;
	var div = document.getElementById('preview');
	if (file.files && file.files[0]) {
		div.innerHTML = '<img id=imghead>';
		var img = document.getElementById('imghead');
		img.onload = function() {
			var rect = clacImgZoomParam(MAXWIDTH, MAXHEIGHT, img.offsetWidth,
					img.offsetHeight);
			img.width = 100;
			img.height = 110;
			// img.style.marginLeft = rect.left+'px';
			// img.style.marginTop = rect.top+'px';
		}
		var reader = new FileReader();
		reader.onload = function(evt) {
			img.src = evt.target.result;
		}
		reader.readAsDataURL(file.files[0]);
	} else // 兼容IE
	{
		var sFilter = 'filter:progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=scale,src="';
		file.select();
		var src = document.selection.createRange().text;
		div.innerHTML = '<img id=imghead>';
		var img = document.getElementById('imghead');
		img.filters.item('DXImageTransform.Microsoft.AlphaImageLoader').src = src;
		var rect = clacImgZoomParam(MAXWIDTH, MAXHEIGHT, img.offsetWidth,
				img.offsetHeight);
		status = ('rect:' + rect.top + ',' + rect.left + ',' + rect.width + ',' + rect.height);
		div.innerHTML = "<div id=divhead style='width:" + rect.width
				+ "px;height:" + rect.height + "px;margin-top:" + rect.top
				+ "px;" + sFilter + src + "\"'></div>";
	}
}
function clacImgZoomParam(maxWidth, maxHeight, width, height) {
	var param = {
		top : 0,
		left : 0,
		width : width,
		height : height
	};
	if (width > maxWidth || height > maxHeight) {
		rateWidth = width / maxWidth;
		rateHeight = height / maxHeight;

		if (rateWidth > rateHeight) {
			param.width = maxWidth;
			param.height = Math.round(height / rateWidth);
		} else {
			param.width = Math.round(width / rateHeight);
			param.height = maxHeight;
		}
	}

	param.left = Math.round((maxWidth - param.width) / 2);
	param.top = Math.round((maxHeight - param.height) / 2);
	return param;
}
function allowliststate(value) {
	if (value == 1) {
		$("#allowstate").val("A06");
	} else if (value == 2) {
		$("#allowstate").val("A05");
	}
	var record = "";
	var selectlist = "";
	var arraylist = $("#selectlistId").val().split(",");
	if (arraylist.length > 1) {
		for (var i = 0; i < arraylist.length-1; i++) {
			var quality = "[name='select']" + "[value='" + arraylist[i] + "']";
			if ($(quality).prop("checked") != false) {
				selectlist = arraylist[i] + "," + selectlist;
			}
		}
	}
	$("[name='select']").each(function() {
		if ($(this).prop("checked") == true) {
			var id_card = $(this).val();
			var arraylist = $("#selectlistId").val().split(",");
			var symb = 0;
			for (var i = 0; i < arraylist.length; i++) {
				if (id_card == arraylist[i]) {
					symb = symb + 1;
				}
			}
			if (symb == 0) {
				record = id_card + "," + record;
			}
		}
	})
	$("#selectlistId").val(selectlist + record);
}
