package com.kennysongcn.providers.common.utils;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * 类 名 称： ObjectToMap
 * 类 描 述： 
 *
 */
public class ObjectToMap {
	@SuppressWarnings("unused")
	private static Logger logger = LoggerFactory.getLogger(ObjectToMap.class); 
	/**
	 * 
	 * 对象值转换为 Map<String, Object> 键值对形式
	 * 支持嵌套对象
	 * 目前不支持集合类型
	 * @param obj
	 * @param valueMap
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public static Map<String, Object> getObjectNotNullMap(Object obj, Map<String, Object> valueMap){
		if(obj == null)return null;
		Class<?> clz = obj.getClass();
		Properties fields_Properties = PropertiesUtil.getProperties("/Column_" + clz.getSimpleName() + "_Fields"+ ".properties");
		Field[] fields = clz.getDeclaredFields();
		for(Field field : fields){
			String fieldName = field.getName();
			String methodName = "get" + fieldName.substring(0,1).toUpperCase() + fieldName.substring(1);
			try{
				Method method = clz.getDeclaredMethod(methodName);
				Object value = method.invoke(obj);
				if(value != null && !"".equals(value)){
					if(value instanceof Date){
						valueMap.put(clz.getSimpleName() + "." + fieldName, DateUtil.getFormatCurrentDate((Date) value));
					}else if(value instanceof Serializable){
						Object fieldContent = fields_Properties.get(clz.getSimpleName() + "." + fieldName);
						if(fieldContent != null){
							Map<String, String> maps = MapUtil.StringtoMap(new String(fieldContent.toString().getBytes("iso8859-1"),"utf-8"), new HashMap<String, String>());
							value = (maps.get(value.toString()) != null ? maps.get(value.toString()) : maps.get("default"));
						}
						valueMap.put(clz.getSimpleName() + "." + fieldName, value);
						
					}else if(value instanceof Collection<?>){
						value = Arrays.toString(((Collection<?>) value).toArray()).toString();
						valueMap.put(clz.getSimpleName() + "." + fieldName, value);
					}else if(value instanceof Map<?,?>){
						valueMap.put(clz.getSimpleName() + "." + fieldName, MapUtil.MaptoString((Map)value));
					}else{
						getObjectNotNullMap(value, valueMap);
					}
				}else{
					valueMap.put(clz.getSimpleName() + "." + fieldName, value);
				}
				continue;
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		return valueMap;
	}

	
	/**
	 * 
	 * 方法描述:  (空值处理)
	 *
	 * @param obj 
	 * 返回类型： void
	 */
	public static void nullHandle(Object obj){
		Class<?> clz = obj.getClass();
		Field[] fields = clz.getDeclaredFields();
		for(Field field : fields){
			String fieldName = field.getName();
			String getMethodName = "get" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
			String setMethodName = "set" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
			try{
				Method getMethod = clz.getMethod(getMethodName);
				if(getMethod.invoke(obj) == null){
					
					Class<?> fieldType = field.getType();
					if(fieldType == String.class){
						Method setMethod = clz.getMethod(setMethodName, String.class);
						setMethod.invoke(obj, "");
					}else if(fieldType == Double.class){
						Method setMethod = clz.getMethod(setMethodName, Double.class);
						setMethod.invoke(obj, 0d);
					}else if(fieldType == Float.class){
						Method setMethod = clz.getMethod(setMethodName, Float.class);
						setMethod.invoke(obj, 0f);
					}else if(fieldType == Long.class){
						Method setMethod = clz.getMethod(setMethodName, Long.class);
						setMethod.invoke(obj, 0l);
					}
				}
			}catch(Exception ex){
				ex.printStackTrace();
			}
		}
	}
}
