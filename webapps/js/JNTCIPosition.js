/**
 * ページ付値
 */
function cunfang() {
	scrollback();
    $('#left-container .content').hide();
    $('#Position').show();
    $('h2.tit').click(function() {
        $(this).next('.content').stop().slideToggle();
    })
    var count = ($("#count").val());
    for (var i = 0; i < count; i++) {
        var empno = $("#empno-" + i).val();
        var name = $("#name-" + i).val();
        var position = 'B' + $("#position-" + i).val();// 姓名工号所在位置的id
        var position1 = 'C' + $("#position-" + i).val();// 照片所在位置的id
        var position2 = 'D' + $("#position-" + i).val();// 部门所在位置的id
        var photo = $("#photo-" + i).val();
        var dept = $("#dept-" + i).val();
        position = '#' + position;
        position1 = '#' + position1;
        position2 = '#' + position2;
        $(position).html(empno + name);
        $(position1)
                .html(
                        "<img id= "
                                + photo
                                + " onmouseover=bigger(this) onmouseout=smaller() src=images/photo/"
                                + photo + " />");
        $(position2).html(dept);
    }
}

function doScroll(){
    var form = document.forms[0];
    $('#scrollPosit').val($('#main').scrollLeft());
}

function scrollback(){
    var form = document.forms[0];
    $('#main').scrollLeft($('#scrollPosit').val());
}
/**
 * 弾いて変更画面
 */
function chuanzhi(value) {
	doScroll();
    $("#positionLable").html(value);
    $("#positionHidden").val(value);
    var flag = document.getElementById("flag").value;
    if (flag == 5 || flag == 0) {
        document.getElementById('light').style.display = 'block';
    }
}
/**
 * 画像を大きくする
 */
function bigger(value) {
    document.getElementById('fade').style.display = 'block';
    var photo = value.id;
    document.getElementById('fade').innerHTML = "<img src=images/photo/"
            + photo + " style=width:100%;height:100%; />";
}
/**
 * 画像縮小
 */
function smaller() {
    document.getElementById('fade').style.display = 'none';
}
/**
 * 選択した従業員番号を入力フレームに挿入する
 */
function selectInfoEmpNo() {
    var value = $('#selectValue').val();
    var aa = value.substr(0,4);
    $('#inputValue').val(aa);
}
/**
 * 提出経路を変更する
 */
function getUserId(value) {
    var path = document.getElementById("formId");
    path.action = value;
    path.submit();
}