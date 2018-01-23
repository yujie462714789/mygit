package com.action.common;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;

public class PropertiesHelper
{
    private static PropertiesHelper helper =new PropertiesHelper();
    
    public static  synchronized PropertiesHelper getInstance()
    {
        return helper;
    }
    public String read(String properties, String key)
    {
      Properties p = new Properties();
      try {
        p.load(new InputStreamReader(getClass().getClassLoader().getResourceAsStream(properties), "UTF-8"));
      }
      catch (IOException e) {
        e.printStackTrace();
      }

      return p.getProperty(key);
    }
}

