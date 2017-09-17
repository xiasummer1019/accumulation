package com.tool.cfg.base.data.Entity;

/**
 200 OK - [GET]：服务器成功返回用户请求的数据，该操作是幂等的（Idempotent）。
 201 CREATED - [POST/PUT/PATCH]：用户新建或修改数据成功。
 202 Accepted - [*]：表示一个请求已经进入后台排队（异步任务）
 204 NO CONTENT - [DELETE]：用户删除数据成功。
 400 INVALID REQUEST - [POST/PUT/PATCH]：用户发出的请求有错误，服务器没有进行新建或修改数据的操作，该操作是幂等的。
 401 Unauthorized - [*]：表示用户没有权限（令牌、用户名、密码错误）。
 403 Forbidden - [*] 表示用户得到授权（与401错误相对），但是访问是被禁止的。
 404 NOT FOUND - [*]：用户发出的请求针对的是不存在的记录，服务器没有进行操作，该操作是幂等的。
 406 Not Acceptable - [GET]：用户请求的格式不可得（比如用户请求JSON格式，但是只有XML格式）。
 410 Gone -[GET]：用户请求的资源被永久删除，且不会再得到的。
 422 Unprocesable entity - [POST/PUT/PATCH] 当创建一个对象时，发生一个验证错误。
 500 INTERNAL SERVER ERROR - [*]：服务器发生错误，用户将无法判断发出的请求是否成功。
 */
public class AjaxResponse {
    private int code;
    private boolean status;
    private String msg;
    private Object object;

    public AjaxResponse(int code, boolean status, String msg, Object object) {
        this.code = code;
        this.status = status;
        this.msg = msg;
        this.object = object;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    public static AjaxResponse success(){ return new AjaxResponse(200,true,"操作成功！",null); }
    public static AjaxResponse success(String msg){ return new AjaxResponse(200,true,msg,null); }
    public static AjaxResponse success(String msg,Object obj){ return new AjaxResponse(200,true,msg,obj); }
    public static AjaxResponse warning(){
        return new AjaxResponse(400, false, "警告,运行失败",null);
    }
    public static AjaxResponse warning(String msg){
        return new AjaxResponse(400, false, "警告："+msg,null);
    }
    public static AjaxResponse warning(int code,String msg){
        return new AjaxResponse(code, false, "警告："+msg,null);
    }
    public static AjaxResponse error(){
        return new AjaxResponse(500, false, "错误！",null);
    }
    public static AjaxResponse error(int code,String msg){
        return new AjaxResponse(code, false, "错误："+msg,null);
    }
    public static AjaxResponse error(String msg){
        return new AjaxResponse(500, false, "错误："+msg,null);
    }
}
