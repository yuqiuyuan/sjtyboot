package com.dre.sjty.domain;

import javax.validation.constraints.NotEmpty;
import java.io.File;
import java.util.Calendar;

public class MailMessage {
    private Long id;

    @NotEmpty(message = "Text is required ~!")
    private String text;

    @NotEmpty(message = "Subject is required ~!")
    private String subject;

    @NotEmpty(message = "To is required ~!")
    private String to;

    private String html;
    private String resourceName;
    private String templateName;
    private File attach;//upload Attach
    private String attachName;

    private Calendar created = Calendar.getInstance();
}
