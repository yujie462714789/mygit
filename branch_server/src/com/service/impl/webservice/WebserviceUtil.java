package com.service.impl.webservice;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.ws.rs.Path;

import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;
import com.sun.jersey.api.spring.Autowire;

/**
 * 
 * @Description : ���·�Դ��ҵ����Ϣ�Խ�
 * @time ����ʱ�� : 2017��7��5��
 * @author : lucy
 * @Copyright (c) 2017 һ���Ƽ�
 * @version
 */

@Autowire
public class WebserviceUtil  {
    private static Logger logger = Logger.getLogger(WebserviceUtil.class);

    public static void main(String[] args) {
        System.out.println("Start invoking....");
        try {
            Map<String, String> params = new HashMap<>();
            params.put("TimeStamp", "");
            params.put("Count", "0");
            params.put("CheckString", "abcdef");
            String result = getInfosFromJizhi("GetOrganizations", params);
            System.out.println("RES=" + result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String getInfosFromJizhi(String xmlName,Map<String, String> params) throws Exception{
        
        String result = "";
        String templateFilePath = Thread.currentThread().getContextClassLoader().getResource("").getPath()
                + "template/jxls/jizhi/" + xmlName + ".xml";

        String inputXmlStr = getXmlToString(templateFilePath);
        System.out.println("inputXmlStr1 : " + inputXmlStr);

        inputXmlStr = replace(inputXmlStr, params);

        System.out.println("inputXmlStr2 : " + inputXmlStr);
        
        URL url = new URL("http://120.25.58.157:8089/JeezWeb/JeezHLBService.asmx");
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("POST");
        conn.setConnectTimeout(5000);
        conn.setDoOutput(true);
        conn.setRequestProperty("Content-Type", "application/soap+xml; charset=utf-8");
        conn.setRequestProperty("Content-Length", String.valueOf(inputXmlStr.length()));
        conn.setRequestProperty("op", xmlName);
        
        OutputStream outPut = conn.getOutputStream();
        outPut.write(inputXmlStr.getBytes());
        outPut.flush();
        outPut.close();
        if (conn.getResponseCode() == 200) {
            InputStream in = conn.getInputStream();
            byte[] b1 = new byte[8192];
            int len = 0;
            int temp = 0;
            while ((temp = in.read()) != -1) {
                b1[len] = (byte) temp;
                len++;
            }
            result = new String(b1, "UTF-8");
        }
        
        return result;
    }

    public static String readSoapFile(InputStream input, String number) throws Exception {
        byte[] b = new byte[1024];
        int len = 0;
        int temp = 0;
        while ((temp = input.read()) != -1) {
            b[len] = (byte) temp;
            len++;
        }
        String soapxml = new String(b);
      
        Map<String, String> map = new HashMap<String, String>();
       
        return replace(soapxml, map);
    }

    public static String replace(String param, Map<String, String> params) throws Exception {
        String result = param;
        if (params != null && !params.isEmpty()) {
            for (Map.Entry<String, String> entry : params.entrySet()) {
                String name = "\\$" + entry.getKey();
                Pattern p = Pattern.compile(name);
                Matcher m = p.matcher(result);
                if (m.find()) {
                    result = m.replaceAll(entry.getValue());
                }
            }
        }
        return result;
    }
    
      public static byte[] InputStreamTOByte(InputStream in) throws IOException {  
           int BUFFER_SIZE = 4096;
            ByteArrayOutputStream outStream = new ByteArrayOutputStream();  
      
            byte[] data = new byte[BUFFER_SIZE];  
      
            int count = -1;  
      
            while ((count = in.read(data, 0, BUFFER_SIZE)) != -1)  
      
                outStream.write(data, 0, count);  
      
            data = null;  
      
            return outStream.toByteArray();  
      
        }  
      
        public static String getXmlToString (String filePath) throws DocumentException{
            
            String result = "";
            
            SAXReader reader = new SAXReader();
            Document document = reader.read(new File(filePath));
            result = document.asXML();
            
            return result;
            
        }
}
