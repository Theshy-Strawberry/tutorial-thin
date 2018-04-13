/**
 *
 */
$(function(){
	$("#tab-top li:first").bind("click",function() {
		$(".tab-content:first").show().next().hide();
	});
	$("#tab-top li:last").bind("click",function() {
		$(".tab-content:last").show().prev().hide();
	});

	$("#tab-top li").click(function(){
		$(this).addClass("on").siblings().removeClass("on");
	});
});