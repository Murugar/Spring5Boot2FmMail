package com.iqmsoft.freemarker.service;

import com.iqmsoft.freemarker.bean.Mail;

public interface MailService {

	 void sendEmail(Mail mail) throws Exception;
}
