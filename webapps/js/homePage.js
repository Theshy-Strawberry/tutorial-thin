/**
 *
 */
$(function() {
	$("#photoUpload").click(function() {
		$("#photo").click();
	});
});

function previewImage(file) {
	var MAXWIDTH = 360;
	var MAXHEIGHT = 280;
	var div = document.getElementById('preview');
	if (file.files && file.files[0]) {
		div.innerHTML = '<img id=imghead>';
		var img = document.getElementById('imghead');
		img.onload = function() {
			var rect = clacImgZoomParam(MAXWIDTH, MAXHEIGHT, img.offsetWidth,
					img.offsetHeight);
			img.width = 200;
			img.height = 210;
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



$(function() {
		$('#left-container .content').hide();
		$('#First').show();
		$('h2.tit').click(function() {
			$(this).next('.content').stop().slideToggle();
		})

	/*显示隐藏*/

		var timer = setInterval('autoScroll(".maquee")', 3000);
		$(".content1").hide();
		 $(".maquee").mouseover(function () {
	            clearInterval(timer);
				timer=null;
	        });
			/*设置隐藏div*/
		 $(".content1 a").click(function(){
		 var flag = $(".maquee").is(":hidden");
			if(flag){
				$(".content1").hide();
				$(".maquee").show();
				$("dl").show();
			}
			return false;
		 });
	        $(".maquee").mouseleave(function () {
	           timer = setInterval('autoScroll(".maquee")', 3000);
	        });

	/*为么个li标签添加点击事件*/

/*		$(".maquee li a").each(function(index){
			$(this).after("<span style='display:none'>"+$(this).text()+"</span>");
			if($(this).text().trim().length>10){
				$(this).text(""+$(this).text().trim().substring(0,10)+"");
			}
            $(this).click(function(){
			var flag = $(".content1").is(":hidden");
			if(flag){
				$("p").remove();
				$("<p class='noteStyle'>"+"<span>标题：</span>"+$(this).parent().parent().children().eq(1).text()+"</p>").appendTo($(".content1"));
				$("<p class='noteStyle2'>"+"<span>时间：</span>"+$(this).parent().next().text()+"</p>").appendTo($(".content1"));
				$("<p class='noteStyle1'>"+"<span>内容：</span>"+$(this).next().text()+"</p>").appendTo($(".content1"));
				$(".content1").show();
				$(".maquee").hide();
				$("dl").hide();
			}
			return false;
            })
          })*/
	});
/* 滚动 */
/*function autoScroll(obj) {
	$(obj).find("ul").animate({
		marginTop : "-39px"
	}, 500, function() {
		$(this).css({
			marginTop : "0px"
		}).find("li:first").appendTo(this);
	});
};*/
