package com.service.impl.webservice;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "soapenv:Body")
public class RequestBody {

    @XmlElement(required = true,name="eapp:aaaaaa")
    public BodyContent aaaaaaa;
    //get set方法省略

    public BodyContent getAaaaaaa()
    {
        return aaaaaaa;
    }

    public void setAaaaaaa(BodyContent aaaaaaa)
    {
        this.aaaaaaa = aaaaaaa;
    }
    
}