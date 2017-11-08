var ui = com.createNameSpace("com.ui");

var msg = ui.msg = (function () {

    toastr.options.closeButton = true;
    toastr.options.showDuration = '3';
    toastr.options.hideDuration = '3';
    toastr.options.tapToDismiss = false;

    function showMsg(msg, type) {

        toastr[type](msg);
    }

    return {
        error: function (msg) {
            showMsg(msg, "error");
        },
        success: function (msg) {
            showMsg(msg, "success");
        },
        warning: function (msg) {
            showMsg(msg, "warning");
        }
    };
})();

ui.confirm = (function (){
	function showDialog(title,msg,callback){		
		title = "<div class='text-warning'><span class='glyphicon glyphicon-warning-sign'></span><strong>警告！</strong>"+title+"</div>";		
		bootbox.confirm({ 
			title: title,  
	        buttons: {  
	            confirm: {  
	                label: '确认',  
	                className: 'btn btn-purple btn-sm'  
	            },  
	            cancel: {  
	                label: '取消',  
	                className: 'btn btn-default btn-sm'  
	            }  
	        },  
	        message: msg,  
	        callback: function(result){
				if(result) {  
					if (callback) {                    	 
						callback();
					}
				}
	        }
    	});  
	}
	
	return{
		warning: function (title,msg,callback) {
            showDialog(title,msg,callback);
        }
	};

})();