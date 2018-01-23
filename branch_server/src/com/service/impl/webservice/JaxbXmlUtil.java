package com.service.impl.webservice;

import java.io.StringReader;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.apache.http.protocol.RequestContent;
import org.springframework.stereotype.Component;

/**
 * Jaxb工具类 xml和java类相互转换
 * 
 * @author sunjianbo
 * @date 2017年4月17日
 */
@Component
public class JaxbXmlUtil
{
    
    public static final String DEFAULT_ENCODING = "UTF-8";
    
    /**
     * pojo转换成xml 默认编码UTF-8
     * 
     * @param obj 待转化的对象
     * @return xml格式字符串
     * @throws Exception JAXBException
     */
    public static String convertToXml(Object obj)
        throws Exception
    {
        return convertToXml(obj, DEFAULT_ENCODING);
    }
    
    /**
     * pojo转换成xml
     * 
     * @param obj 待转化的对象
     * @param encoding 编码
     * @return xml格式字符串
     * @throws Exception JAXBException
     */
    public static String convertToXml(Object obj, String encoding)
        throws Exception
    {
        String result = null;
        
        JAXBContext context = JAXBContext.newInstance(obj.getClass());
        Marshaller marshaller = context.createMarshaller();
        // 指定是否使用换行和缩排对已编组 XML 数据进行格式化的属性名称。
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.setProperty(Marshaller.JAXB_ENCODING, encoding);
        
        StringWriter writer = new StringWriter();
        marshaller.marshal(obj, writer);
        result = writer.toString();
        
        return result;
    }
    
    /**
     * xml转换成JavaBean
     * 
     * @param xml xml格式字符串
     * @param t 待转化的对象
     * @return 转化后的对象
     * @throws Exception JAXBException
     */
    @SuppressWarnings("unchecked")
    public static <T> T convertToJavaBean(String xml, Class<T> t)
        throws Exception
    {
        T obj = null;
        JAXBContext context = JAXBContext.newInstance(t);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        obj = (T)unmarshaller.unmarshal(new StringReader(xml));
        return obj;
    }
    
    public void test()
    {
        System.out.println("Start invoking....");
        String sb = new String();
        // sb =
        // " <soap:Envelope xmlns:soap='http://www.w3.org/2001/12/soap-envelope' soap:encodingStyle='http://www.w3.org/2001/12/soap-encoding'>";
        // sb +=
        // "<soap:Header></soap:Header><soap:Body><eapp:aaaaaa><eapp:aa1>041</eapp:aa1><eapp:aa2>5000</eapp:aa2>"
        // + "<eapp:aa3>?</eapp:aa3></eapp:aaaaaa></soap:Body></soap:Envelope>";
        try
        {
            RequestEntity requestEntity = new RequestEntity();
            RequestBody requestBody = new RequestBody();
            BodyContent bodyContent = new BodyContent();
            bodyContent.setAa1("1");
            bodyContent.setAa2("2");
            bodyContent.setAa3("3");
            requestBody.setAaaaaaa(bodyContent);
            requestEntity.setBody(requestBody);
            String xml = convertToXml(requestEntity, "utf-8");
            System.out.println("解析结束" + xml);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    
    public void test2()
    {
        System.out.println("Start invoking....");
        String sb = new String();
         sb = "<?xml version='1.0' encoding='utf-8' standalone='yes'?>";
         sb += "<soapnv:Header></soapnv:Header><soapnv:Body><eapp:aaaaaa><eapp:aa1>041</eapp:aa1><eapp:aa2>5000</eapp:aa2>"
         + "<eapp:aa3>?</eapp:aa3></eapp:aaaaaa></soapnv:Body></soapnv:Envelope>";
        try
        {
            RequestEntity requestEntity = convertToJavaBean(sb, RequestEntity.class);
            System.out.println("解析结束" + requestEntity.getEapp());
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}