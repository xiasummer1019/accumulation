$(function () {
    var data = dataInit();
    htmlInit(data);
    ajaxInit();

});

function dataInit() {
    var data = {};
    data["date"] = showDate();
    data["url_title_img"] = "../images/custom/shijiuda.jpg";
    return data;
}

function ajaxInit() {
    var params = {};
    for (var i = 0; i < 9; i++) {
        params["module-title" + i] = $("#module-title" + i).val();
    }
    parseData();
}

function parseData(data) {
    var moduleCount =6;
    var listCount = 10;
    for (var i = 1; i <= moduleCount; i++) {
        if (i == 2) i++;
        //var detail1 = data["module_detail1"];
        var detail1 = {};
        detail1 ["article_url"] = "#";
        detail1 ["article_title"] = "离石区国土资源局帮扶贫困户养殖肉牛 9个月收益近70万元";
        detail1 ["article_date"] = "09-22";
        //$("#module_detail" + i).val();
        var str = "";
        if (i % 3 != 0)
            for (var j = 0; j < listCount; j++) {
                 str += '<div><img class=" mt12 mr6 mb2 " src="../images/custom/fk01.png">  ' +
                    '<a href="' + detail1["article_url"] + '" class="xinwen">' + detail1["article_title"] + '</a> ' +
                    '<span class="riqi">' + detail1["article_date"] + '</span></div>';
            }
        else
            for (var j = 0; j < listCount; j++) {
                 str += '<a href="' + detail1["article_url"] + '" class="xinwen">' + detail1["article_title"] + '</a> '
                if(i!=3)
                    str += '<span class="pull-right text-right line_30 grey_99">' + detail1["article_date"] + '</span>';
            }

        $("#module_detail" + i).append(str);
    }

}


function htmlInit(data) {
    $("#date").html(data["date"]);
    $("#url_title_img").css("background-image", "url(" + data["url_title_img"] + ")");
}
function showDate() {
    var mydate = new Date();
    var str = "" + mydate.getFullYear() + "年";
    str += (mydate.getMonth() + 1) + "月";
    str += mydate.getDate() + "日 ";
    var today = new Array('星期日', '星期一', '星期二', '星期三', '星期四', '星期五', '星期六');
    str += today[mydate.getDay()];
    return str;
}