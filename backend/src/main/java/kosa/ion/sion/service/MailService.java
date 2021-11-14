package kosa.ion.sion.service;

import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;


@Service
public class MailService {
	@Autowired
	private JavaMailSender javaMailSender;

	private static final Logger logger = LoggerFactory.getLogger(MailService.class);
	
	public void sendMail(String address, String subject, String text) {
		SimpleMailMessage mailMessage=new SimpleMailMessage();

		mailMessage.setTo(address);
		mailMessage.setSubject(subject);
		mailMessage.setText(text);

		javaMailSender.send(mailMessage);	
	}
}
