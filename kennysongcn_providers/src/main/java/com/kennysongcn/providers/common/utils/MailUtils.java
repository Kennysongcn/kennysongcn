package com.kennysongcn.providers.common.utils;


import java.util.Date;
import java.util.Enumeration;
import java.util.Properties;
import java.util.Vector;
import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.MimeUtility;
import org.springframework.util.StringUtils;

/**
 * 发送时间工具类
 * @author wangyulong
 *
 */
public class MailUtils{
	
	String to = "";// 收件人  
	String cc = "";//抄送人
//    String from = "472282320@qq.com";// 发件人  
//    String host = "smtp.qq.com";// smtp主机  
//    String username = "472282320";  
//    String password = "qazwsx_123";  
	String from = "RMSproject";// 发件人  
	String host = "mail.hercules-logistics.com";// smtp主机  
	String username = "RMSproject";  
	String password = "rms20151125";  
    String filename = "";// 附件文件名  
    String subject = "";// 邮件主题  
    String content = "";// 邮件正文  
    @SuppressWarnings("rawtypes")
	Vector file = new Vector();// 附件文件集合    
//    //参数
//    String[] parameter;
//    //报表模板
//    String template; 
    
  
    
  
    /** 
     * <br> 
     * 方法说明：设置邮件服务器地址 <br> 
     * 输入参数：String host 邮件服务器地址名称 <br> 
     * 返回类型： 
     */  
    public void setHost(String host) {  
        this.host = host;  
    }  
  
    
    
    /** 
     * <br> 
     * 方法说明：设置登录服务器校验密码 <br> 
     * 输入参数： <br> 
     * 返回类型： 
     */  
    public void setPassWord(String pwd) {  
        this.password = pwd;  
    }  
  
    /** 
     * <br> 
     * 方法说明：设置登录服务器校验用户 <br> 
     * 输入参数： <br> 
     * 返回类型： 
     */  
    public void setUserName(String usn) {  
        this.username = usn;  
    }  
    
    
  
    /** 
     * <br> 
     * 方法说明：设置邮件发送目的邮箱 <br> 
     * 输入参数： <br> 
     * 返回类型： 
     */  
    public void setTo(String to) {  
        this.to = to;  
    }  
  
    /**
     * 抄送人
     * @param cc
     */
    public void setCc(String cc) {  
        this.cc = cc;  
    } 
    
    /** 
     * <br> 
     * 方法说明：设置邮件发送源邮箱 <br> 
     * 输入参数： <br> 
     * 返回类型： 
     */  
    public void setFrom(String from) {  
        this.from = from;  
    }  
  
    /** 
     * <br> 
     * 方法说明：设置邮件主题 <br> 
     * 输入参数： <br> 
     * 返回类型： 
     */  
    public void setSubject(String subject) {  
        this.subject = subject;  
    }  
  
    /** 
     * <br> 
     * 方法说明：设置邮件内容 <br> 
     * 输入参数： <br> 
     * 返回类型： 
     */  
    public void setContent(String content) {  
        this.content = content;  
    }  
  
    /** 
     * <br> 
     * 方法说明：把主题转换为中文 <br> 
     * 输入参数：String strText <br> 
     * 返回类型： 
     */  
    public String transferChinese(String strText) {  
        try {  
            strText = MimeUtility.encodeText(new String(strText.getBytes(),  
                    "GB2312"), "GB2312", "B");  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
        return strText;  
    }  
  
    /** 
     * <br> 
     * 方法说明：往附件组合中添加附件 <br> 
     * 输入参数： <br> 
     * 返回类型： 
     */  
    @SuppressWarnings("unchecked")
	public void attachfile(String fname) {  
        file.addElement(fname);  
    }  
  
    /** 
     * <br> 
     * 方法说明：发送邮件 <br> 
     * 输入参数： <br> 
     * 返回类型：boolean 成功为true，反之为false 
     */  
    @SuppressWarnings("rawtypes")
	public boolean sendMail() {  
  
        // 构造mail session  
        Properties props = new Properties() ;  
        props.put("mail.smtp.host", host);  
        props.put("mail.smtp.auth", "true");  
        Session session = Session.getDefaultInstance(props,  
                new Authenticator() {  
                    public PasswordAuthentication getPasswordAuthentication() {  
                        return new PasswordAuthentication(username, password);  
                    }  
                });  
        try {  
            // 构造MimeMessage 并设定基本的值  
            MimeMessage msg = new MimeMessage(session);  
            //MimeMessage msg = new MimeMessage();  
            msg.setFrom(new InternetAddress(from));  
            //msg.addRecipients(Message.RecipientType.TO, address); //这个只能是给一个人发送email  
            msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to)) ;  
            if(!StringUtils.isEmpty(cc))
            {
            	msg.setRecipients(Message.RecipientType.CC, InternetAddress.parse(cc)) ;  
            }
            //设置抄送
            subject = transferChinese(MimeUtility.encodeText(subject));  
            msg.setSubject(subject);  
  
            // 构造Multipart  
            Multipart mp = new MimeMultipart();  
  
            // 向Multipart添加正文  
            MimeBodyPart mbpContent = new MimeBodyPart();  
            mbpContent.setContent(content, "text/html;charset=gb2312");  
              
            // 向MimeMessage添加（Multipart代表正文）  
            mp.addBodyPart(mbpContent);  
  
            // 向Multipart添加附件  
            Enumeration efile = file.elements();  
            while (efile.hasMoreElements()) {  
  
                MimeBodyPart mbpFile = new MimeBodyPart();  
                filename = efile.nextElement().toString();  
                FileDataSource fds = new FileDataSource(filename);  
                mbpFile.setDataHandler(new DataHandler(fds));  
//                <span style="color: #ff0000;">//这个方法可以解决附件乱码问题。</span>    
//                String filename= new String(fds.getName().getBytes(),"ISO-8859-1");  
                String filename=  MimeUtility.encodeText(fds.getName());
                mbpFile.setFileName(filename);  
                // 向MimeMessage添加（Multipart代表附件）  
                mp.addBodyPart(mbpFile);  
  
            }  
  
            file.removeAllElements();  
            // 向Multipart添加MimeMessage  
            msg.setContent(mp);  
            msg.setSentDate(new Date());  
            msg.saveChanges() ;  
            // 发送邮件  
              
            Transport transport = session.getTransport("smtp");  
            transport.connect(host, username, password);  
            transport.sendMessage(msg, msg.getAllRecipients());  
            transport.close();  
        } catch (Exception mex) {  
            mex.printStackTrace();   
            return false;  
        }  
        return true;  
    }  
  
  
      
    /** 
     * <br> 
     * 方法说明：主方法，用于测试 <br> 
     * 输入参数： <br> 
     * 返回类型： 
     */  
    public static void main(String[] args) {  
        MailUtils sendmail = new MailUtils();  
          
//        sendmail.setHost("smtp.qq.com");  
//        sendmail.setUserName("472282320");  
//        sendmail.setPassWord("qazwsx_123");  
        sendmail.setTo("songzhihao@hercules-logistics.com");  
//        sendmail.setCc("472282320@qq.com");
//        sendmail.setFrom("472282320@qq.com");  
        sendmail.setSubject("敬阅$客户服务报告");  
        String countent = "<table>"
        		+"<tr><td>尊敬的$:<td/><tr>" 
        		+"<tr><td style=\"padding-left: 30px;\">请查收贵司$的服务报告。感谢贵司一直以来的支持和信赖,我司将竭诚为贵司提供高效专业的服务。</td></tr>"
        		+"<tr><td>如有业务咨询及异常处理可24小时致电,联系方式如下:$。</td></tr>"
        		+"<tr><td style=\"padding-top: 150px;\">****************************<td></tr>"
        		+"<tr><td>wangyulong</td></tr>"
        		+"<tr><td>王玉龙</td></tr>"
        		+"<tr><td>Senior Manager, Customer Relationship Management </td></tr>"
        		+"<tr><td>Hercules Transportation Co., Ltd.</td></tr>"
        		+"<tr><td>Office: +86 755-2528-1424</td></tr>"
        		+"<tr><td>Mobile: +86 189-2345-7961</td></tr>"
        		+"<tr><td>E-mail: wangyuzhen@hercules-transportation.com</td></tr>"
        		+"<tr><td>Website: www.hercules-transportation.com</td></tr>"
        		+"<tr><td>****************************<td></tr>"
        		+"</table>";
        sendmail.setContent(countent);  
//        sendmail.attachfile("D:\\测试.xls");  
//        sendmail.attachfile("d:\\jhjl.rar");  
          
        System.out.println(sendmail.sendMail());  
  
    }
    
    /**
     * 替换字符
     * @param parameter
     * @param content
     * @return
     */
    public static String replaceCharacter(String[] parameter,String content)
    {
    	for(String sb:parameter)
    	{
    		if(StringUtils.isEmpty(sb))
    		{
    			content = content.replaceFirst("\\$", "");
    		}
    		else{
    			content = content.replaceFirst("\\$", sb);
    		}
    	}
    	
    	return content;
    }
    
    /**
     * 替换字符
     * @param parameter
     * @param content
     * @return
     */
    public static String getJobTitle(String str)
    {
    	if(!StringUtils.isEmpty(str))
    	{
    		if(str.equals("高级客户经理"))
    		{
    			return "Senior Account Manager";
    		}
    		else if(str.equals("客户经理") || str.equals("客户关系专员"))
    		{
    			return "Account Manager";
    		}
    		else 
    		{
    			return "Assistant Account Manager";
    		}
    	}
    	else{
    		return "";
    	}
    	
    }
    
    /**
     * 替换职称中文名
     * @param parameter
     * @param content
     * @return
     */
    public static String getJobTitleZH(String str)
    {
    	if(!StringUtils.isEmpty(str))
    	{
    		if(str.equals("高级客户经理"))
    		{
    			return "高级客户经理 ";
    		}
    		else if(str.equals("客户经理") || str.equals("客户关系专员"))
    		{
    			return "客户经理";
    		}
    		else 
    		{
    			return "助理客户经理";
    		}
    	}
    	else{
    		return "";
    	}
    	
    }

	
}