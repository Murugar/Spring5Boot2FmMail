package com.iqmsoft.freemarker.service;


import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import com.iqmsoft.freemarker.bean.Mail;

import freemarker.template.Configuration;
import freemarker.template.Template;

@Service
public class MailServiceImpl implements MailService {


	   @Autowired
	    private JavaMailSender sender;

	    @Autowired
	    private Configuration freemarkerConfig;

	    
	    public void sendEmail(Mail mail) throws Exception {
	        MimeMessage message = sender.createMimeMessage();

	        MimeMessageHelper helper = new MimeMessageHelper(message);
	      
	        // Using a subfolder such as /templates here
	        freemarkerConfig.setClassForTemplateLoading(this.getClass(), "/templates");
	        
	        Template t = freemarkerConfig.getTemplate("email-template.ftl");
	        String text = FreeMarkerTemplateUtils.processTemplateIntoString(t, mail.getModel());

	        helper.setTo(mail.getMailTo());
	        helper.setText(text, true);
	        helper.setSubject(mail.getMailSubject());

	        sender.send(message);
	    }
	    
	    
}
