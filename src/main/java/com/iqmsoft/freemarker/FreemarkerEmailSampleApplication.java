package com.iqmsoft.freemarker;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.iqmsoft.freemarker.bean.Mail;
import com.iqmsoft.freemarker.service.MailService;

@SpringBootApplication
public class FreemarkerEmailSampleApplication implements CommandLineRunner {

	@Autowired
	MailService mailService;
	
	
	public static void main(String[] args) {
		SpringApplication.run(FreemarkerEmailSampleApplication.class, args);
	}
	

	@Override
	public void run(String... args) throws Exception {

		Mail mail = new Mail();
		mail.setMailFrom("test3@gmail.com");
		mail.setMailTo("test3@gmail.com");
		mail.setMailSubject("Spring Boot - Sending email with freemarker template");

		Map<String, Object> model = new HashMap<String, Object>();
		model.put("firstName", "Test");
		model.put("lastName", "Test");
		model.put("message", "Test1");
		model.put("recipient", "test3@gmail.com");
		mail.setModel(model);

		mailService.sendEmail(mail);

		System.out.println("Done!");

		//wait(0);
	}
}
