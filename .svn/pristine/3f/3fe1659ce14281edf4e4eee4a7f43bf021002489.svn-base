//JavaScript Document
$(function() {
	 $('#left-container .content').hide();
     $('#Attendance').show();
     $('h2.tit').click(function() {
         $(this).next('.content').stop().slideToggle();
	var power = $("#flag").val();
//权限是2时，复选框不能使用
//	if (power == 2) {
//		$("[name='select']").prop("disabled", true);
//		$("[name='selectAll']").prop("disabled", true);
//	}
//	if (power == 1) {
//		$("[name='adminUpdateImg']").removeClass("display");
//		$("[name='updateImg']").addClass("display");
//	}
//
//	$("#photoUpload").click(function() {
//		$("#photo").click();
//	});


	/*$("#selectAll").click(function() {
		if ($(this).prop("checked") == true) {
			$("[name='select']").prop("checked", true);
			document.getElementById("admit_list").disabled = false;
			document.getElementById("refuse_list").disabled = false;
			document.getElementById("delete_list").disabled = false;
		} else {
			$("[name='select']").prop("checked", false);
			document.getElementById("admit_list").disabled = true;
			document.getElementById("refuse_list").disabled = true;
			document.getElementById("delete_list").disabled = true;
		}
	});
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
		document.getElementById("admit_list").disabled = bool;
		document.getElementById("refuse_list").disabled = bool;
		document.getElementById("delete_list").disabled = bool;
	});*/

	/*$("#refuse_listHide").on("click",function() {
			var cards = "";
			$("[name='select']").each(function() {
					if ($(this).prop("checked") == true) {
						var id_card = $(this).parent().next().children().val()
//											var id_card = $("[name='card_id']").val();
						cards = cards + id_card + ",";
					}
			})
			cards = cards.substring(0, cards.length - 1)+","+$(deleteId_c).val();
			$("#deleteExtra_Id").val(cards);
	});*/


	/*$("#delete_listHide").on("click",function() {
		var cards = "";
		$("[name='select']").each(function() {
				if ($(this).prop("checked") == true) {
					var id_card = $(this).parent().next().children().val()
//										var id_card = $("[name='card_id']").val();
					cards = cards + id_card + ",";
				}
		})
		cards = cards.substring(0, cards.length - 1)+$(deleteId_c).val();
		$("#deleteExtra_Id").val(cards);
});*/


	/*$("#admit_listHide").on("click",function() {
		var cards = "";
		$("[name='select']").each(function() {
				if ($(this).prop("checked") == true) {
					var id_card = $(this).parent().next().children().val()
//										var id_card = $("[name='card_id']").val();
					cards = cards + id_card + ",";
				}
		})
		cards = cards.substring(0, cards.length - 1)+","+$(deleteId_c).val();
		$("#deleteExtra_Id").val(cards);
});*/
//	$("#admit_list")
//	.on(
//			"click",
//			function() {
//				if (confirm("削除したら、復元することができません。本当に削除しますか？")) {
//					var cards = "";
//					$("[name='select']").each(
//							function() {
//								if ($(this).prop("checked") == true) {
//									var id_card = $(this).parent()
//									.next().children().next().val()
////									var id_card = $("[name='card_id']").val();
//
//									cards = cards + id_card + ",";
//								}
//							})
//					cards = cards.substring(0, cards.length - 1);
//					$
//							.ajax({
//								cache : true,
//								type : "POST",
//								url : '/tutorial-thin/JNTCIAddsignInfo/JNTCIAddsignInfoQueryAdmitBL.do',
//								data : {
//									'deleteExtra_Id' : cards
//								},
//								async : false,
//								error : function(request) {
//									alert("削除が失敗しました");
//								},
//								success : function(data) {
//									alert("削除が成功しました");
//									location = location;
//								}
//							});
//				}
//			});
//	$("#delete_list")
//	.on(
//			"click",
//			function() {
//				if (confirm("削除したら、復元することができません。本当に削除しますか？")) {
//					var cards = "";
//					$("[name='select']").each(
//							function() {
//								if ($(this).prop("checked") == true) {
//									var id_card = $(this).parent()
//									.next().children().next().val()
////									var id_card = $("[name='card_id']").val();
//
//									cards = cards + id_card + ",";
//								}
//							})
//					cards = cards.substring(0, cards.length - 1);
//					$
//							.ajax({
//								cache : true,
//								type : "POST",
//								url : '/tutorial-thin/JNTCIAddsignInfo/JNTCIAddsignInfoQueryDeleteBL.do',
//								data : {
//									'deleteExtra_Id' : cards
//								},
//								async : false,
//								error : function(request) {
//									alert("削除が失敗しました");
//								},
//								success : function(data) {
//									alert("削除が成功しました");
//									location = location;
//								}
//							});
//				}
//			});


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

