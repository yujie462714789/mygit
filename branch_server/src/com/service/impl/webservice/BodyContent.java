package com.service.impl.webservice;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "aa1",
    "aa2",
    "aa3"
   
})
@XmlRootElement(name = "eapp:aaaaaa")
public class BodyContent {

        @XmlElement(required = true,name="eapp:compNo")
        protected String aa1;
        @XmlElement(required = true,name="eapp:agentCode")
        protected String aa2;
        @XmlElement(required = true,name="eapp:eAppId")
        protected String aa3;              
        //get set方法省略
        public String getAa1()
        {
            return aa1;
        }
        public void setAa1(String aa1)
        {
            this.aa1 = aa1;
        }
        public String getAa2()
        {
            return aa2;
        }
        public void setAa2(String aa2)
        {
            this.aa2 = aa2;
        }
        public String getAa3()
        {
            return aa3;
        }
        public void setAa3(String aa3)
        {
            this.aa3 = aa3;
        }
    
}