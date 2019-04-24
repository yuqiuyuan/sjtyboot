package com.dre.sjty.service.impl;

import com.dre.sjty.service.SjtyEmailService;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.IContext;

import javax.mail.internet.MimeMessage;
import java.io.File;

@Service
public class SjtyEmailServiceImpl implements SjtyEmailService {


    @Autowired
    private JavaMailSender jms;

    @Autowired
    private TemplateEngine templateEngine;


    /**
     * 从配置文件中获取发送邮件的源
     */
    @Value("${spring.mail.username}")
    private String from;


    public String sendTextEmail(String to, String subject, String text) {
        return sendEmail(to, subject, text, null, Types.TEXT, null, null, null);
    }

    public String sendHtmlEmail(String to, String subject, String html) {
        return sendEmail(to, subject, html, null, Types.HTML, null, null, null);
    }


    public String sendStaticResourceEmail(String to, String subject, String html, File file, String resourceName) {
        return sendEmail(to, subject, html, file, Types.STATICRESOURCE, resourceName, null, null);
    }


    public String sendFileEmail(String to, String subject, String text, File file, String fileName) {
        return sendEmail(to, subject, text, file, Types.ATTACH, fileName, null, null);
    }


    public String sendEmailByTemplete(String to, String subject, String text, IContext context, String templateName) {
        return sendEmail(to, subject, text, null,Types.TEMPLATE, null, context, templateName);
    }


//    *******************************************私有方法*********************************************************

    /**
     * 发送带附件邮件
     * type: 1:附件，2：静态HTML，3：文本邮件，4：模版
     *
     * @return
     */

    private String sendEmail(String to, String subject, String text, File file, Types type, String resourceName, IContext context, String templateName) {
        MimeMessage message;
        try {
            message = jms.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(from);
            helper.setTo(to);
            helper.setSubject(subject);
            if (Types.STATICRESOURCE.equals(type)) {
                //  示例：<html><body><img src=\"cid:resourceName\" ></body></html>
                FileSystemResource fileReource = new FileSystemResource(file);
                helper.addInline(resourceName, fileReource);
                helper.setText(text);
                //  附件类型
            } else if (Types.ATTACH.equals(type) && file != null) {
                helper.addAttachment(resourceName, file);
                helper.setText(text);
                //  模版加载
            } else if (Types.TEMPLATE.equals(type)) {
                helper.setText(templateEngine.process(templateName, context));
            }
            jms.send(message);
            return "发送成功～！";
        } catch (Exception e) {
            e.printStackTrace();
            return e.getMessage();
        }
    }


}
