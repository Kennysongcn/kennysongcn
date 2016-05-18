package com.kennysongcn.providers.common.utils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * 类 名 称： StringTools 类 描 述： 字符串工具类 
 *
 */
public class StringTools
{
	// 日志记录
	private static Logger logger = LoggerFactory.getLogger(StringTools.class);

	private StringTools()
	{
	}

	/**
	 * getLength 返回字符串的长度
	 * 
	 * @param src
	 *            输入字符串
	 * @return int 字符串长度
	 * 
	 */
	public static int getLength(String src)
	{
		return ((null == src) || ("".equals(src))) ? 0 : src.getBytes().length;
	}

	/**
	 * getLength 返回非空字符串
	 * 
	 * @param o
	 *            输入对象
	 * @return string
	 * 
	 */
	public static String nvl(Object o)
	{
		return (null == o) ? "" : o.toString().trim();
	}

	public static String nvl(String str, String def)
	{
		return (null == str || str.isEmpty()) ? def : str;
	}

	/**
	 * String to float
	 * 
	 * @param s
	 * @param def
	 * @return [参数说明]
	 * 
	 * @return float [返回类型说明]
	 * @exception throws [违例类型] [违例说明]
	 * @see [类、类#方法、类#成员]
	 */
	public static float toFloat(Object s, float def)
	{
		float f = def;

		try
		{
			f = Float.parseFloat(s.toString());
		} catch (Exception e)
		{
			f = def;
		}
		return f;
	}

	/**
	 * String to double
	 * 
	 * @param s
	 * @param def
	 * @return [参数说明]
	 * 
	 * @return float [返回类型说明]
	 * @exception throws [违例类型] [违例说明]
	 * @see [类、类#方法、类#成员]
	 */
	public static double toDouble(Object s)
	{
		double f = 0.00;
		try
		{
			if (!isEmpty(StringTools.convertObjectToString(s)))
			{
				f = Double.parseDouble(convertObjectToString(s));
			}
		} catch (Exception e)
		{
			logger.error("数据转换出错", e);
		}
		return f;
	}

	public static double parseDouble(String s)
	{
		double f = 0.00;
		try
		{
			if (null != s && !"".equals(s))
			{
				f = Double.valueOf(s);
			}
		} catch (Exception e)
		{
			logger.error("数据转换出错", e);
		}
		return f;
	}

	/**
	 * String to int <功能详细描述>
	 * 
	 * @param s
	 * @param def
	 * @return [参数说明]
	 * 
	 * @return int [返回类型说明]
	 * @exception throws [违例类型] [违例说明]
	 * @see [类、类#方法、类#成员]
	 */
	public static int toInt(Object s, int def)
	{
		int value = def;

		try
		{
			value = Integer.parseInt(s.toString());
		} catch (Exception e)
		{
			value = def;
		}

		return value;
	}

	/**
	 * String to Long <功能详细描述>
	 * 
	 * @param s
	 * @param def
	 * @return [参数说明]
	 * 
	 * @return int [返回类型说明]
	 * @exception throws [违例类型] [违例说明]
	 * @see [类、类#方法、类#成员]
	 */
	public static Long toLong(String s, long def)
	{
		long value = def;

		try
		{
			value = Long.parseLong(s);
		} catch (Exception e)
		{
			value = def;
		}

		return value;
	}

	/**
	 * 判断字符串是否为null对象或是空白字符
	 */
	public static boolean isEmpty(String str)
	{
		return ((str == null) || (str.trim().length() == 0));
	}

	/**
	 * 判断字符串是否bu为null对象或是空白字符
	 */
	public static boolean isNotEmpty(String str)
	{
		return !isEmpty(str);
	}

	/**
	 * 
	 * 方法描述: 转换string 作 者： hua.yang 日 期： 2012-10-29-下午12:25:37
	 * 
	 * @param obj
	 * @return 返回类型： String
	 */
	public static String convertObjectToString(Object obj)
	{
		if (obj == null)
		{
			return "";
		} else
		{
			return obj.toString();
		}
	}

	/**
	 * 
	 * 方法描述: 判断str是否是 整型 作 者： hua.yang 日 期： 2012-10-29-下午03:28:00
	 * 
	 * @param str
	 * @return 返回类型： boolean
	 */
	public static boolean isNumeric(String str)
	{
		if (str == null || str == "")
		{
			return false;
		}
		for (int i = str.length(); --i >= 0;)
		{
			if (!Character.isDigit(str.charAt(i)))
			{
				return false;
			}
		}
		return true;
	}

	/**
	 * 
	 * 方法描述: (格式化double类型精度过长的 格式到精度后面1位) 作 者： qiang.fu 日 期：
	 * 2012-11-13-下午02:20:01
	 * 
	 * @param param
	 * @param n
	 * @return 返回类型： double
	 */
	public static double getFmtDouble(double param, int n)
	{
		param = new BigDecimal(param).divide(new BigDecimal(1.0), n,
				BigDecimal.ROUND_HALF_DOWN).doubleValue();
		return param;
	}

	/**
	 * 将array中的内容以delimiter为间隔拼接字符串
	 * 
	 * @param array
	 * @param delimiter
	 * @return
	 */
	public static String join(Object[] array, String delimiter)
	{
		if (array == null)
		{
			return null;
		}
		if (array.length == 0)
		{
			return "";
		}
		StringBuilder builder = new StringBuilder();
		for (Object item : array)
		{
			builder.append(item.toString() + delimiter);
		}
		builder.delete(builder.length() - delimiter.length(), builder.length());
		return builder.toString();

	}

	/**
	 * 将list中的内容以delimiter为间隔拼接字符串
	 * 
	 * @param list
	 * @param delimiter
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static String join(List list, String delimiter)
	{
		if (list == null)
		{
			return null;
		}
		return join(list.toArray(), delimiter);
	}


	/**
	 * 
	 * 方法描述:  去除list里重复记录
	 * 作    者： zhiwen.ni
	 * 日    期： 2013-8-20-下午05:43:30
	 * @param list 
	 * 返回类型： void
	 */
	public static void removeDuplicateWithOrder(List list)
	{
		Set set = new HashSet();
		List newList = new ArrayList();
		for (Iterator iter = list.iterator(); iter.hasNext();)
		{
			Object element = iter.next();
			if (set.add(element))
				newList.add(element);
		}
		list.clear();
		list.addAll(newList);
	}
    


}
