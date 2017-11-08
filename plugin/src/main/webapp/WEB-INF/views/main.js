//打开新的页面
function openPage(li,url){
    $("#page-frame").empty();
    $("#loading").show();
    $("#page-frame").load(url,function(){
        $("#page-menu li").removeClass("active");
        $("#loading").delay(100).hide(0);
        //$("#page-menu .open").addClass("active");
        li.parentElement.setAttribute("class","active");
        pageInit();
    });
}
