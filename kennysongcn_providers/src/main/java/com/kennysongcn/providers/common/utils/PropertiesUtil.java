package com.kennysongcn.providers.common.utils;

import java.util.Properties;

/**
 * 
 * 类 名 称： PropertiesUtil
 * 类 描 述： 属性管理工具类
 * 创 建 人：hikone
 * 创建时间： 2016-03-15 上午10:43:17
 *
 */
public class PropertiesUtil
{
    private static PropertiesUtil intstance = null;
    private static Properties prop = null;


    public static synchronized PropertiesUtil getInstance()
    {
        if (null == intstance)
        {
            intstance = new PropertiesUtil();
        }
        return intstance;
    }
    
    
    /**
     * 根据属性的键得到属性的值 <功能详细描述>
     * 
     * @param key
     * @return
     * @see [类、类#方法、类#成员]
     */
    public String getPropertiesInfo(String key,String value)
    {
    	if(StringTools.isEmpty(prop.getProperty(key)))
    	{
    		return value;
    	}
        return prop.getProperty(key);
        
    }
    
    public Properties getProp()
    {
        return prop;
    }
    
	public static Properties getProperties(String fileName){
		try{
			Properties propreties = new Properties();
			propreties.load(PropertiesUtil.class.getResourceAsStream(fileName));
			return propreties;
		}catch(Exception ex){
			ex.printStackTrace();
			return null;
		}
	}
}
