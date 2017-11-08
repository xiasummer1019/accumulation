<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" href="css/bootstrap-editable.css"/>
<style>
    .profile-info-name {
        width: 180px;
    }
</style>

<div class="row">
    <div class="col-xs-12">
        <div class="row">
            <div class="col-xs-3">
                <button class="btn btn-xs btn-info">保存</button>
                <button class="btn btn-xs btn-success ">预览</button>
            </div>

        </div>
        <div class="space-2"></div>
        <div class="row">
            <div class="profile-user-info profile-user-info-striped">
                <div class="profile-info-row w180">
                    <div class="profile-info-name"> 平台名称：（30字以内）</div>
                    <div class="profile-info-value">
                        <span class="editable" id="platform_title" maxLength="30">中共吕梁市离石区委智慧党建平台欢迎您！</span>
                    </div>
                </div>
                <div class="profile-info-row">
                    <div class="profile-info-name"> App下载地址</div>
                    <div class="profile-info-value">
                        <span class="editable" id="url_app">http://124.165.218.170:9000/ccps/file/ccps.apk</span>
                    </div>
                </div>
                <div class="profile-info-row">
                    <div class="profile-info-name">登录控制台地址：</div>
                    <div class="profile-info-value">
                        <span class="editable" id="url_console">http://124.165.218.170:9000/ccps</span>
                    </div>
                </div>

                <div class="profile-info-row">
                    <div class="profile-info-name">主标题图地址</div>
                    <div class="profile-info-value">
                        <div class="row">
                            <div class="col-xs-12">
                                <span class="" id="url_title_img">../images/custom/shijiuda.jpg</span>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-xs-9">
                                <input type="file" id="url_title_img_input" accept="image/jpeg,image/jpg,image/png"
                                       enctype="multipart/form-data"/>
                            </div>
                            <div class="col-xs-3">
                                <button id="url_title_img_btn" class="btn btn-info btn-xs invisible">上传</button>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="profile-info-row">
                    <div class="profile-info-name">导航页</div>
                    <div class="profile-info-value">
                        <div class="dd">
                            <ol class="dd-list">
                                <li class="dd-item" data-id="1">
                                    <div class="dd-handle"><span class="editable selectNav">党建要闻</span></div>
                                </li>
                                <li class="dd-item" data-id="2">
                                    <div class="dd-handle"><span class="editable selectNav">政策法规</span></div>
                                </li>
                                <li class="dd-item" data-id="3">
                                    <div class="dd-handle"><span class="editable selectNav">专题专栏</span></div>
                                </li>
                                <li class="dd-item" data-id="4">
                                    <div class="dd-handle"><span class="editable selectNav">党建工作</span></div>
                                </li>
                                <li class="dd-item" data-id="5">
                                    <div class="dd-handle"><span class="editable selectNav">干部工作</span><br/></div>
                                </li>
                                <li class="dd-item" data-id="6">
                                    <div class="dd-handle"><span class="editable selectNav">人才工作</span><br/></div>
                                </li>
                                <li class="dd-item" data-id="7">
                                    <div class="dd-handle"><span class="editable selectNav">党务公开</span><br/></div>
                                </li>
                                <li class="dd-item" data-id="8">
                                    <div class="dd-handle"><span class="editable selectNav">他山之石</span><br/></div>
                                </li>
                                <li class="dd-item" data-id="9">
                                    <div class="dd-handle"><span class="editable selectNav">党建论坛</span><br/></div>
                                </li>
                                <li class="dd-item" data-id="10">
                                    <div class="dd-handle"><span class="editable selectNav">资料下载</span><br/></div>
                                </li>
                                <li class="dd-item" data-id="11">
                                    <div class="dd-handle"><span class="editable selectNav">在线调查</span><br/></div>
                                </li>
                            </ol>
                        </div>
                    </div>
                </div>

                <div class="profile-info-row">
                    <div class="profile-info-name"> Last Online</div>

                    <div class="profile-info-value">
                        <span class="editable" id="login">3 hours ago</span>
                    </div>
                </div>

                <div class="profile-info-row">
                    <div class="profile-info-name"> About Me</div>

                    <div class="profile-info-value">
                        <span class="editable" id="about">Editable as WYSIWYG</span>
                    </div>
                </div>
            </div>
        </div>
    </div>

</div>

<script src="statics/js/x-editable/bootstrap-editable.js"></script>
<script src="statics/js/x-editable/ace-editable.js"></script>
<script src="statics/js/ace/elements.fileinput.js"></script>
<script src="statics/js/jquery.nestable.js"></script>
<script src="views/config/indexEdit.js "></script>
