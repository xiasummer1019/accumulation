package com.tool.cfg.base.system;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Properties;

/**
 * Created by XM on 2017/9/26.
 */
@Component("systemConfig")
public class SystemConfig {

    @Autowired
    private HttpServletRequest request;

    private Properties properties = new Properties();

    public HttpServletRequest getRequest() {
        return request;
    }

    /**
     * @param properties the properties to set
     */
    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    /**
     * @return the properties
     */
    public Properties getProperties() {
        return properties;
    }

    /**
     * 获取相对路径
     * @return
     */
    public String getContextPath(){return request.getContextPath();}

    /**
     * 获取相对路径
     * @return
     */
    public String getRootPath(){ return System.getProperty("web.root");}


    /**
     * 获取相对路径
     * @return
     */
    public String getRootPath1(){ return request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + request.getContextPath();}


    /**
     * 获取绝对路径
     * @return
     */
    @Deprecated
    public String getAbsolutePath(){return request.getSession().getServletContext().getRealPath("/");}


    /**
     * 获取url地址
     * @return
     */
    public String getRequestURI(){return request.getRequestURI();}


    public String getIpAddr() {
        String ip = request.getHeader("x-forwarded-for");
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
            if(ip.equals("127.0.0.1")){
                //根据网卡取本机配置的IP
                InetAddress inet=null;
                try {
                    inet = InetAddress.getLocalHost();
                } catch (UnknownHostException e) {
                    e.printStackTrace();
                }
                ip= inet.getHostAddress();
            }
        }
        // 对于通过多个代理的情况，第一个IP为客户端真实IP,多个IP按照','分割
        if(ip != null && ip.length() > 15){
            if(ip.indexOf(",")>0){
                ip = ip.substring(0,ip.indexOf(","));
            }
        }
        return ip;
    }

}
