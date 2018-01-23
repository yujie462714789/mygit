package com.service.impl.webservice;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "header",
        "body"
    })
@XmlRootElement(name = "soapenv:Envelope")
public class RequestEntity {

    @XmlAttribute(name="xmlns:soapenv")
    protected String soapenv="http://schemas.xmlsoap.org/soap/envelope/";
    @XmlAttribute(name="xmlns:eapp")
    protected String eapp="http://wx.gmw9.com";
    
    @XmlAttribute(name="xmlns:bus")
    protected String bus=null;
    
    
    
    @XmlElement(required = true,name="soapenv:Header")
    protected RequestHeader header;
    
    @XmlElement(required = true,name="soapenv:Body")
    protected RequestBody body;

    public String getSoapenv()
    {
        return soapenv;
    }

    public void setSoapenv(String soapenv)
    {
        this.soapenv = soapenv;
    }

    public String getEapp()
    {
        return eapp;
    }

    public void setEapp(String eapp)
    {
        this.eapp = eapp;
    }

    public String getBus()
    {
        return bus;
    }

    public void setBus(String bus)
    {
        this.bus = bus;
    }

    public RequestHeader getHeader()
    {
        return header;
    }

    public void setHeader(RequestHeader header)
    {
        this.header = header;
    }

    public RequestBody getBody()
    {
        return body;
    }

    public void setBody(RequestBody body)
    {
        this.body = body;
    }

    
    
}
