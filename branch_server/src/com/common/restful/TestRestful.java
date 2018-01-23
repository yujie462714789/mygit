package com.common.restful;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/test/restful")
public class TestRestful
{
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    /*
     * @Producesע������ָ����Ҫ���ظ�client�˵����ݱ�ʶ���ͣ�MIME����@Produces������Ϊclassע�ͣ�Ҳ������Ϊ����ע�ͣ� ������@Producesע�ͽ��Ḳ��class��ע�͡�
     * 
     * @Consumes��@Produces�෴������ָ�����Խ���client���͹�����MIME���ͣ�ͬ����������class����method��Ҳ����ָ�����MIME���ͣ�һ������@PUT��@POST
     HTTP GET����ȡ/�г�/������������Դ���ϡ�
     HTTP POST���½���Դ��
     HTTP PUT������������Դ����Դ���ϡ�
     HTTP DELETE��ɾ����Դ����Դ����
     */
    public String sayHello()
    {
        return "Hello World!";
    }
    //http://localhost:8088/branch_server/rest/test/restful/laji
    /**
     * 
     *@pathParam ����url�еĲ�����@queryParam ����get�����еĲ���
     *@DefaultValue ����Ĭ��ֵ
     *@FormParam ��ȡpost�����б��е�����
     *@BeanParam ��ȡ��������е����ݣ���ʵ��Bean���з�װ
     */
    @GET
    @Path("/{param}")
    @Produces("text/plain;charset=UTF-8")
    public String sayHelloToUTF8(@DefaultValue("test") @PathParam("param")
    String username)
    {
        return "Hello " + username;
    }
}
