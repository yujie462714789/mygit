package com.action.common;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

/** 
 * ���û�ȡ�ͻ�����Ϣ�Ĺ��� 
 *  
 */  
public final class NetworkUtil {  
    /** 
     * Logger for this class 
     */  
    private static Logger logger = Logger.getLogger(NetworkUtil.class);  
    
    /* ��server.xml������������ã�
         <Valve   
            className="org.apache.catalina.valves.RemoteIpValve"  
            internalProxies="192\.168\.0\.10, 192\.168\.0\.11"  
            remoteIpHeader="x-forwarded-for"  
            remoteIpProxiesHeader="x-forwarded-by"  
            trustedProxies="192\.168\.0\.13, 192\.168\.0\.12"/> Ȼ��ʹ�� Request.getRemoteAddr()��ȡ��ʵ��Ip*/
    /** 
     * ��ȡ��������IP��ַ,���ͨ�������������͸������ǽ��ȡ��ʵIP��ַ; 
     *  
     * @param request 
     * @return 
     * @throws IOException 
    
     * ��ȡ�û���ʵIP��ַ����ʹ��request.getRemoteAddr();��ԭ�����п����û�ʹ���˴��������ʽ������ʵIP��ַ, 
     * 
     * ���ǣ����ͨ���˶༶�������Ļ���X-Forwarded-For��ֵ����ֹһ��������һ��IPֵ�������ĸ������������û��˵���ʵIP�أ� 
     * ����ȡX-Forwarded-For�е�һ����unknown����ЧIP�ַ����� 
     * 
     * �磺X-Forwarded-For��192.168.1.110, 192.168.1.120, 192.168.1.130, 
     * 192.168.1.100 
     * 
     * �û���ʵIPΪ�� 192.168.1.110 
     * 
     * @param request 
     * @return 
     */
    public final static String getIpAddress(HttpServletRequest request) throws IOException {  
        // ��ȡ��������IP��ַ,���ͨ�������������͸������ǽ��ȡ��ʵIP��ַ  
  
        String ip = request.getHeader("X-Forwarded-For");  
        if (logger.isInfoEnabled()) {  
            logger.info("getIpAddress(HttpServletRequest) - X-Forwarded-For - String ip=" + ip);  
        }  
  
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
            if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
                ip = request.getHeader("Proxy-Client-IP");  
                if (logger.isInfoEnabled()) {  
                    logger.info("getIpAddress(HttpServletRequest) - Proxy-Client-IP - String ip=" + ip);  
                }  
            }  
            if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
                ip = request.getHeader("WL-Proxy-Client-IP");  
                if (logger.isInfoEnabled()) {  
                    logger.info("getIpAddress(HttpServletRequest) - WL-Proxy-Client-IP - String ip=" + ip);  
                }  
            }  
            if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
                ip = request.getHeader("HTTP_CLIENT_IP");  
                if (logger.isInfoEnabled()) {  
                    logger.info("getIpAddress(HttpServletRequest) - HTTP_CLIENT_IP - String ip=" + ip);  
                }  
            }  
            if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
                ip = request.getHeader("HTTP_X_FORWARDED_FOR");  
                if (logger.isInfoEnabled()) {  
                    logger.info("getIpAddress(HttpServletRequest) - HTTP_X_FORWARDED_FOR - String ip=" + ip);  
                }  
            }  
            if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
                ip = request.getRemoteAddr();  
                if (logger.isInfoEnabled()) {  
                    logger.info("getIpAddress(HttpServletRequest) - getRemoteAddr - String ip=" + ip);  
                }  
            }  
        } else if (ip.length() > 15) {  
            String[] ips = ip.split(",");  
            for (int index = 0; index < ips.length; index++) {  
                String strIp = (String) ips[index];  
                if (!("unknown".equalsIgnoreCase(strIp))) {  
                    ip = strIp;  
                    break;  
                }  
            }  
        }  
        return ip;  
    }  
}  