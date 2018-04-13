//JavaScript Document
$(function() {
	/*var power = $("#flag").val();
	if (power == 2) {
		$("[name='select']").prop("disabled", true);
		$("[name='selectAll']").prop("disabled", true);
	}
	if (power == 1) {
		$("[name='adminUpdateImg']").removeClass("display");
		$("[name='updateImg']").addClass("display");
	}*/
	$("#photoUpload").click(function() {
		$("#photo").click();
	});
//当点击“全选”的时候，让本页所有的复选框被选中，并使“删除”按钮可用。
	$("#selectAll").click(function() {
		if ($(this).prop("checked") == true) {
			$("[name='select']").prop("checked", true);
			document.getElementById("delete").disabled = false;
		} else {
			$("[name='select']").prop("checked", false);
			document.getElementById("delete").disabled = true;
		}
	});
	//当点击某个复选框的时候，该复选框被选中，“删除”按钮可用。
	$("[name='select']").bind("click", function() {
		var bool = false;
		$("[name='select']").each(function() {
			if ($(this).prop("checked") == true) {
				bool = false;
				return false;
			} else {
				bool = true;
			}
		});
		document.getElementById("delete").disabled = bool;
	});
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
						var num4Check = /[0-9]{4}/;
						var numLevel = /^[1|2|3|4|5]?$/;
						var numCheck = /^[0-9]+$/;
						var yearCheck =/^[0-9]\d*(\.\d+)?$/;
						var dateCheck = /^[0-9]{4}\/[0-9]{2}$/;
						var offic_MailCheck = /^[A-Za-z0-9.]+$/;
						var email = $("input[name='pesonal_Mall']").val();
/*						if (email != "" && !emailCheck.test(email)) {
							errorMessage = errorMessage
									+ "● 個人メールボックスの形式は間違っている.</br>"
						}*/
/*						var offic_Mail = $("input[name='offic_Mail']").val();
						if (offic_Mail != ""
								&& !offic_MailCheck.test(offic_Mail)) {
							errorMessage = errorMessage
									+ "● 社内メールボックスの形式は間違っている.</br>"
						}*/
						$(".qualificationTR")
								.find("input[name='winning_date']")
								.each(
										function() {
											var winning_date = $(this).val();
											var winning_date1 = winning_date.substr(5,2);
											if (winning_date != ""
													&& !dateCheck.test(winning_date) && (winning_date1<1 || winning_date1>12)) {
												   errorMessage = errorMessage
														  + "● 受賞日付にYYYY/MM 形式を入力してください.</br>"
												   return false;
											}
											if (winning_date != ""  && (winning_date1<1 || winning_date1>12)) {
											   errorMessage = errorMessage
													  + "● 受賞日付にMM の形式は間違っている</br>"
											   return false;
										}
										}
										)

						$(".workStr").find("input[name='work_time']").each(
								function() {
									var work_time = $(this).val();
									if (work_time != ""
											&& !numCheck.test(work_time)) {
										errorMessage = errorMessage
												+ "● 年限数字を入力してください.</br>"
										return false;
									}
								})
						$(".bottom_table").find("input[name$='_year']").each(
								function() {
									var text_year = $(this).val();
									if (text_year != ""
											&& !yearCheck.test(text_year)) {
										errorMessage = errorMessage
												+ "● 技术年限数字を入力してください.</br>"
										return false;
									}
								})

						$(".bottom_table").find("input[name$='_level']").each(
								function() {
									var text_level = $(this).val();
									if (text_level != ""
											&& !numLevel.test(text_level)) {
										errorMessage = errorMessage
												+ "● 技术level数字[1-5]を入力してください.</br>"
										return false;
									}
								})
/*						$("input[name='attend_nm']").each(
								function() {
									var attend_nm = $(this).val();
									if (attend_nm != ""
											&& !numCheck.test(attend_nm)) {
										errorMessage = errorMessage
												+ "● 参加人数数字を入力してください.</br>"
										return false;
									}
								})*/
/*						$("input[name='attend_month']").each(
								function() {
									var attend_nm = $(this).val();
									if (attend_nm != ""
											&& !numCheck.test(attend_nm)) {
										errorMessage = errorMessage
												+ "● 参加月数数字を入力してください.</br>"
										return false;
									}
								})*/



/*										$("textarea[name='attend_states']").each(
								function() {
									var attend_states = $(this).val();
									if (attend_states.length >= 15
											) {
										errorMessage = errorMessage
												+ "● 参加形態入力超過長さ.</br>"
										return false;
									}
								})*/
/*								$("textarea[name='develop_phase']").each(
								function() {
									var develop_phase = $(this).val();
									if (develop_phase.length >= 50
											) {
										errorMessage = errorMessage
												+ "● 開発ﾌｪｰｽﾞ入力超過長さ.</br>"
										return false;
									}
								})*/
							/*	("input[type='text']")("text[name='lang_tool']")*/
/*								$("input[name='lang_tool']").each(
								function() {
									var lang_tool = $(this).val();
									if (lang_tool.length >= 50
											) {
										errorMessage = errorMessage
												+ "● 使用言語及びツール入力超過長さ.</br>"
										return false;
									}
								})*/
/*								$("input[name='data_base']").each(
								function() {
									var data_base = $(this).val();
									if (data_base.length >= 100
											) {
										errorMessage = errorMessage
												+ "● DB入力超過長さ.</br>"
										return false;
									}
								})*/
/*							$("input[name='technical_sys']").each(
								function() {
									var technical_sys = $(this).val();
									if (technical_sys.length >= 20
											) {
										errorMessage = errorMessage
												+ "● OS入力超過長さ.</br>"
										return false;
									}
								})*/
/*								$("input[name='model_device']").each(
								function() {
									var model_device = $(this).val();
									if (model_device.length >= 20
											) {
										errorMessage = errorMessage
												+ "● 機種及び使用デバイス入力超過長さ.</br>"
										return false;
									}
								})*/
/*								$("input[name='tech_capability']").each(
								function() {
									var tech_capability = $(this).val();
									if (tech_capability.length >= 50
											) {
										errorMessage = errorMessage
												+ "● 得意分野入力超過長さ.</br>"
										return false;
									}
								})*/
						$("#errorMessageDIV").html("");
						if (errorMessage.indexOf("●") != -1) {
							$("#errorMessageDIV").append(errorMessage);
							$("#errorMessageDIV").removeClass("display");
							return false;
						}

						// 仕事経験
						var trContext = "";
						var comma = "comma ";
						var semicolon = " semicolon";
						var b = $("#embed-table tbody tr :input");
						b.each(function(i) {
							trContext += $(this).val();
							trContext += comma;
							if ((i + 1) % 13 == 0) {
								trContext += semicolon;
							}
						});

						$("#list").val(trContext);

						// 作業経験
						var experienceStr = "";
						$("select[name='work_Experience']").each(
								function() {
									experienceStr += $(this).find("option:selected").text();
									experienceStr += ": ";
									experienceStr += $(this).next().next().val();
									experienceStr += ",";
								});

						$("#work_Experience").val(experienceStr);

						var languagel = "";
						$("select[name='yy_language']").each(
								function() {
									languagel += "lang";
									languagel += comma;
									languagel += $(this).find("option:selected").val();
									languagel += comma;
									languagel += $(this).parent().next().next().children().val();
									languagel += comma;
									languagel += $(this).parent().next().next().children().parent().next().next().children().val();
									languagel += semicolon;
								});
						$("#language2").val(languagel);

						var javaenvironmentt = "";
						$("select[name='jhj_Envirnment']").each(
								function() {
									javaenvironmentt += "Jenv";
									javaenvironmentt += comma;
									javaenvironmentt += $(this).find("option:selected").val();
									javaenvironmentt += comma;
									javaenvironmentt += $(this).parent().next().next().children().val();
									javaenvironmentt += comma;
									javaenvironmentt += $(this).parent().next().next().children().parent().next().next().children().val();
									javaenvironmentt += semicolon;
								});
						$("#javaenvironment").val(javaenvironmentt);

						var javalanguagee = "";
						$("select[name='jyy_language']").each(
								function() {
									javalanguagee += "Jlang";
									javalanguagee += comma;
									javalanguagee += $(this).find("option:selected").val();
									javalanguagee += comma;
									javalanguagee += $(this).parent().next().next().children().val();
									javalanguagee += comma;
									javalanguagee += $(this).parent().next().next().children().parent().next().next().children().val();
									javalanguagee += semicolon;
								});

						$("#javalanguage").val(javalanguagee);

						var tooll = "";
						$("select[name='tl_tool']").each(
								function() {
									tooll += "tool";
									tooll += comma;
									tooll += $(this).find("option:selected").val();
									tooll += comma;
									tooll += $(this).parent().next().next().children().val();
									tooll += comma;
									tooll += $(this).parent().next().next().children().parent().next().next().children().val();
									tooll += semicolon;
						});

						$("#tool").val(tooll);

						var dbb = "";
						$("select[name='db_datebase']").each(
								function() {
									dbb += "db";
									dbb += comma;
									dbb += $(this).find("option:selected").val();
									dbb += comma;
									dbb += $(this).parent().next().next().children().val();
									dbb += comma;
									dbb += $(this).parent().next().next().children().parent().next().next().children().val();
									dbb += semicolon;
						});
						$("#db").val(dbb);

						var oss = "";
						$("select[name='os_operatsys']").each(
								function() {
									oss += "os";
									oss += comma;
									oss += $(this).find("option:selected").val();
									oss += comma;
									oss += $(this).parent().next().next().children().val();
									oss += comma;
									oss += $(this).parent().next().next().children().parent().next().next().children().val();
									oss += semicolon;
						});
						$("#os").val(oss);


						var str = "";
						$("[name='jap_skill']").each(function() {
							if ($(this).prop("checked") == true) {
								str += $(this).val() + "-";
							}
						});

						$("#japan").val(str);


						var engstr = "";
						$("[name='eng_skill']").each(function() {
							if ($(this).prop("checked") == true) {
								engstr += $(this).val() + "-";
							}
						});

						$("#english").val(engstr);
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


	$("input[name='addRow1']").bind(
			"click",
			function(){

				alert("sdadsadsadasda");

			});




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

$(function () {
    H_login = {};
    H_login.openLogin = function(){
        $('#p-hasnot').click(function(){
        	  $('.login').show();
              $('.login-bg').show();
              $('#updateInfo').show();
        });
    };
    H_login.closeLogin = function(){
        $('.close-login').click(function(){
            $('.login').hide();
            $('.login-bg').hide();
            $('#updateInfo').hide();
        });
    };


	var passportNoCheck = /^[A-Za-z]{1}\d{8}/;

    H_login.loginForm = function () {
        $("#login-button-submit").on('click',function(){
              var passportNo = $("#passportNo");
              var passportNoValue = $("#passportNo").val();
              var issueDate = $("#issueDate");
              var issueDateValue = $("#issueDate").val();
			  var expiryDate = $("#expiryDate");
              var expiryDateValue = $("#expiryDate").val();
            if(passportNoValue == ""){
                alert("パスポート番号を必ず入力してください");
                passportNo.focus();
                return false;
            }else if(!passportNoCheck.test(passportNoValue)){
                alert("パスポート番号の形式は間違いです");
                expiryDate.focus();
                return false;
            }else if(issueDateValue == ""){
                alert("発行日付を必ず入力してください");
                issueDate.focus();
                return false;
            }else if(expiryDateValue == ""){
                alert("有効期限至を必ず入力してください");
                expiryDate.focus();
                return false;
            }else{
                alert("登録が成功しました");
                setTimeout(function(){
                    $('.login').hide();
                    $('.login-bg').hide();

                },2000);
            }
        });
    };
    H_login.run = function () {
        this.closeLogin();
        this.openLogin();
        this.loginForm();
    };
    H_login.run();
  //liguipeng
    $("input[name='resets']").click(function(){
    	/*清空下拉选项*/
    	var $ex = $("select");
    	$ex.each(function(){
    		if ($(this).children().eq(0).text().trim() == "") {
    			$(this).children().eq(0).prop("selected",true);
    		}else{
    			$(this).prepend("<option selected='selected'></option>");
    		}
    	})
		/*清空input*/
		var $inp = $("input[type='text']");
		var jn = $("input[name='jn_Card']").val().trim();
		var tj = $.trim($("input[name='tj_Card']").val());
		$inp.each(function(){
			if(this.value!=""){
				if(this.value.trim()==jn||this.value==tj){
						return true;
					}
				this.value = "";
			}
		});
		/*清空textarea*/
		var $tre = $("textarea");
		$tre.each(function(){
			if(this.value != ""){
				this.value = "";
			}
		});
		/*重置单选按钮*/
		var $rad = $("input[type='radio']");
		$rad.each(function(){
			if($(this).val()==1){
				$(this).prop("checked",true);
			}else{
				$(this).prop("checked",false);
			}
		});
	});
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
