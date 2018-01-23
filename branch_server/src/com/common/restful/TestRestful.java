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
     * @Produces注释用来指定将要返回给client端的数据标识类型（MIME）。@Produces可以作为class注释，也可以作为方法注释， 方法的@Produces注释将会覆盖class的注释。
     * 
     * @Consumes与@Produces相反，用来指定可以接受client发送过来的MIME类型，同样可以用于class或者method，也可以指定多个MIME类型，一般用于@PUT，@POST
     HTTP GET：读取/列出/检索单个或资源集合。
     HTTP POST：新建资源。
     HTTP PUT：更新现有资源或资源集合。
     HTTP DELETE：删除资源或资源集合
     */
    public String sayHello()
    {
        return "Hello World!";
    }
    //http://localhost:8088/branch_server/rest/test/restful/laji
    /**
     * 
     *@pathParam 请求url中的参数，@queryParam 请求get方法中的参数
     *@DefaultValue 设置默认值
     *@FormParam 获取post请求中表单中的数据
     *@BeanParam 获取请求参数中的数据，用实体Bean进行封装
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
