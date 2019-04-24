package com.dre.sjty.service;


import org.thymeleaf.context.IContext;

import java.io.File;

public interface SjtyEmailService {
    enum Types {TEXT, HTML, ATTACH, TEMPLATE, STATICRESOURCE}

    String sendTextEmail(String to, String subject, String text);

    String sendHtmlEmail(String to, String subject, String html);

    String sendStaticResourceEmail(String to, String subject, String html, File file, String resourceName);

    String sendFileEmail(String to, String subject, String text, File file, String fileName);

    String sendEmailByTemplete(String to, String subject, String text, IContext context, String templateName);
}
