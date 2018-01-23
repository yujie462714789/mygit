package com.common.domain;

import com.action.common.MyAnnotation;

public class AnnotationTest
{  @MyAnnotation(id="1")
    private String id;
    @MyAnnotation(id ="1",name="annotationtest")
    private String name;
    public String getId()
    {
        return id;
    }
    public void setId(String id)
    {
        this.id = id;
    }
    public String getName()
    {
        return name;
    }
    public void setName(String name)
    {
        this.name = name;
    }
    
}
