package com.punithjsp.employee_management_system.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import lombok.Data;
@Component
@Data
public class MyEmailService {
	@Autowired
	private JavaMailSender emailSender;
	
	public void sendMail(String to) {
		SimpleMailMessage message=new SimpleMailMessage();
		message.setTo(to);
		message.setSubject("Registration Message");
		message.setText("Your registration successfully completed");
		
		emailSender.send(message);
	}
	
}
