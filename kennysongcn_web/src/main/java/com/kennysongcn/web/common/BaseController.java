package com.kennysongcn.web.common;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.servlet.ModelAndView;

/**
 * BaseController
 * Title: HG-TMS <br>
 * Description: <br>
 * Date: 2015年5月20日 <br>
 * Copyright (c) 2015 Hercules-Logistics <br>
 * 
 * @author wayne
 */
public class BaseController {

	@Autowired
	protected HttpServletResponse response;
	@Autowired
	protected HttpServletRequest request;
	@Autowired
	protected HttpSession sesson;
	@Autowired
	protected ServletContext servletContext;
	
	public static final String AJAX_MESSAGE = "success";
	public static final String SUCCESS = "true";
	public static final String FAIL = "fail";
	
	
    /**
     * 返回页面参数容器
     */
    public Map<String , Object> paramMap=new HashMap<String , Object>();
    protected ModelAndView mav;
	
	

	public static final String CONTENTTYPE_HTML = "text/html";
	
    public static final String CHARTSET_UTF8 = "utf-8";
	
    protected Logger logger = Logger.getLogger(getClass());
    
    public void debug(String message) {
		logger.debug(message);
	}
	public void error(String message) {
		logger.error(message);
	}
	public void info(String message) {
		logger.info(message);
	}
	
	
	public void renderText(HttpServletResponse response, String result) throws IOException {
		PrintWriter out = response.getWriter();
		response.setHeader("Cache-Control", "no-store"); 
		response.setHeader("Pragma", "no-cache"); 
		response.setDateHeader("Expires", 0); 
		out.print(result);
		out.flush();
		out.close();
	}
	
	private MessageSource messageSource;
    
    /**
     * 从Request获取参数
     * @param name
     * @return
     */
    final protected String getParam(String name){
    	return request.getParameter(name);
    }
    
    @Resource(name="messageSource")
	public void setMessageSource(MessageSource messageSource) {
		info("---------------messageSource");
		this.messageSource = messageSource;
	}

	public String getMessage(String key) {
		return this.messageSource.getMessage(key, null, null);
	}
    /**
     * 从Request获取参数
     * @param name
     * @return
     */
    final protected String[] getParams(String name){
    	return request.getParameterValues(name);
    }
    
    /**
     * 获取参数为Map
     * @return
     */
	final protected Map<String,String> getParamMap(){
    	Map<String, String> m = new HashMap<String, String>();
        Iterator<String> keys = request.getParameterMap().keySet().iterator();
        while (keys.hasNext()) {
            String key = keys.next();
            m.put(key, getParam(key));
        }
        return m;
    }
	
	
	/**
     * 向HttpServletResponse输出文本
     * @param response
     * @param text 输出的字符串
     * @param contentType 类型
     * @param charset 编码
     */
    final public void outputText(HttpServletResponse response,String text, String contentType, String charset) {
    	response.setCharacterEncoding(charset);
        //指定内容类型
    	response.setContentType(contentType + ";charset=" + charset);
        //禁止缓存
    	response.setHeader("Pragma", "no-cache");
    	response.setHeader("Cache-Control", "no-cache");
    	response.setDateHeader("Expires", 0);
    	OutputStream o = null;
        try {
        	byte[] content = text.getBytes(charset);
        	o = response.getOutputStream();
        	o.write(content);
        } catch (IOException e) {
            e.printStackTrace();
        } finally{
        	try {
        		if(o!=null){
        			o.close();
        		}
        		o = null;
			} catch (IOException e) {
				e.printStackTrace();
			}
        }
    }
    
    /**
     * 向客户端输出字符串，编码为UTF-8
     * @param response
     * @param text
     */
    final protected void outputString(HttpServletResponse response,String text){
    	this.outputText(response,text, CONTENTTYPE_HTML, CHARTSET_UTF8);
    }
    
    public ModelAndView getMav() {
		return mav;
	}

	public void setMav(ModelAndView mav) {
		this.mav = mav;
	}

	public void setParamMap(Map paramMap) {
		this.paramMap = paramMap;
	}
	
	
}
