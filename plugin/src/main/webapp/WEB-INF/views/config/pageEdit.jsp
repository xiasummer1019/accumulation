<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>


<div class="page-header" class="ui-widget-content">
    <h1>
        首页
        <small>
            <b class="ace-icon fa fa-angle-double-right"></b>
            编辑
        </small>
    </h1>
</div>

<div class="row">
    <div class="col-xs-3">
        <a  href="javascript:void(0);" class="active" onclick="openPage(this,'config/home')">
            <img class="img-responsive" src="images/email1.png" alt="Email Template" />
        </a>
        <span class="menu-text">首页编辑 </span>
    </div>

    <div class="col-xs-3">
        <a href="../build/demo/email-navbar.html" class="thumbnail" target="_blank">
            <img class="img-responsive" src="images/email2.png" alt="Email Template" />
        </a>
    </div>

</div>


<script type="text/javascript">
    function pageInit() {

    }
</script>
