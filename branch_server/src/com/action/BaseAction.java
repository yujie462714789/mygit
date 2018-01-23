package com.action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;

public abstract class BaseAction
{

    private static Log log = LogFactory.getLog(BaseAction.class);
    public abstract String add() throws Exception;

    public abstract String save() throws Exception;

    public abstract String edit() throws Exception;

    public abstract String update() throws Exception;

    public abstract String delete() throws Exception;

    public abstract String list() throws Exception;

    public abstract String detail() throws Exception;

    public abstract String search() throws Exception;
    

    /**
     * ��ȡrequest����
     * 
     * @return
     */
    public HttpServletRequest getRequest() {
        return ServletActionContext.getRequest();
    }

    /**
     * ��ȡresponse����
     * 
     * @return
     */
    public HttpServletResponse getResponse() {
        return ServletActionContext.getResponse();
    }

    /**
     * ��ȡsession����
     * 
     * @return
     */
    @SuppressWarnings("unchecked")
    public Map<String, Object> getSession() {
        return ActionContext.getContext().getSession();
    }
}
