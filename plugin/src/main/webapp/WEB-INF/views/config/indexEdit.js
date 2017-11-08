function pageInit() {
    var flag = true;
    if (flag) {
        aceInit();
        editInit();
        onClickInit();
    }
}
function onClickInit() {
    $("#url_title_img_btn").click(function () {
       // ajax.post("",'',function (data) {
            com.ui.msg.success("上传成功");
            $("#url_title_img").text("www.baidu.com");
        //});


    });
}

function editInit(editable) {
    //todo 标题数据
    var data = [
        { text: "党建要闻"},
        { text: "政策法规"},
        { text: "干部工作"},
        { text: "人才工作"},
        { text: "党务公开"},
        { text: "他山之石"},
        { text: "党建论坛"},
        { text: "资料下载"},
        { text: "在线调查"},
        { text: "专题专栏"}
        ];
    $('.selectNav').editable({
        type: "select",              //编辑框的类型。支持text|textarea|select|date|checklist等
        source: data,
        disabled: false,           //是否禁用编辑
        emptytext: "空文本",       //空值的默认文本
        mode: "inline",            //编辑框的模式：支持popup和inline两种模式，默认是popup
        validate: function (value) { //字段验证
            if (!$.trim(value)) {
                return '不能为空';
            }
        }
    });
    $('.editable').editable({
        type: 'text',
        mode: "inline",
        validate: function (value) { //字段验证
            var maxLength = $(this).attr("maxLength");
            if (maxLength) {
                var minLength = $(this).attr("minLength") ? $(this).attr("minLength") : 1;
                var length = $.trim(value).length
                if (length < minLength || length > maxLength) {
                    return '字段长度不合法！范围:' + minLength + "~" + maxLength;
                }
            }
        }
    });
}

function aceInit() {
    $('.dd').nestable({
        maxDepth:1,
    });
    $('.dd').nestable().on('change', function(){
        var r = $('.dd').nestable('serialize');
        alert(JSON.stringify(r));
    });

    $('#url_title_img_input').ace_file_input({
        no_file: '没有文件  ...',
        btn_choose: '选择',
        btn_change: '修改',
        droppable: false,
        onchange: null,
        thumbnail: 'small', //| true | large
        allowExt: ["jpeg", "jpg", "png"],
        allowMime: ["image/jpg", "image/jpeg", "image/png"],
        before_change: function (files, dropped) {
            $('#url_title_img_btn ').removeClass("invisible");

            return true;
        },
        before_remove: function (files, dropped) {
            $('#url_title_img_btn ').addClass("invisible");
            return true;
        }
    });
}


