package com.kennysongcn.providers.common.utils;

import java.util.Map;
import java.util.Map.Entry;

public class MapUtil
{
	public static String MaptoString(Map<?,?> map){
		if(map == null || map.isEmpty())return "";
		StringBuilder builder = new StringBuilder();
		for(Entry<?,?> entry : map.entrySet()){
			builder.append(entry.getKey() + ":" + entry.getValue() + ",");
		}
		
		return builder.toString().substring(0, builder.toString().length()-1);
	}
	@SuppressWarnings("unchecked")
	public static <K,V> Map<K, V> StringtoMap(String resource, Map<K,V> map){
		String[] strs = resource.split(",");
		for(String str : strs){
			String[] kvs = str.split(":");
			map.put((K)kvs[0], (V)kvs[1]);
		}
		return map;
	}
}
