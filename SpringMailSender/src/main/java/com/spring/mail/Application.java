package com.spring.mail;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements ApplicationRunner {

	private static Logger log = LoggerFactory.getLogger(Application.class);

	@Autowired
	private EmailService emailService;

	public static void main(String[] args) throws Exception {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(ApplicationArguments applicationArguments) throws Exception {
		log.info("SPRING MAIL - JavaMailSender İle Spring Boot Uygulamadan Mail Gönderme");

		Mail mail = new Mail();
		mail.setFrom("no-reply@melahat.com");
		mail.setTo("melahatmindivanli@gmail.com");
		mail.setSubject("SPRING MAIL - JavaMailSender İle Spring Boot Uygulamadan Mail Gönderme");
		mail.setContent(
				"Merhaba, \n\n Bu bir Spring Mail örneğidir: https://melahatmindivanli.wordpress.com/2018/06/11/spring-mail-javamailsender-ile-mail-gonderme/");

		emailService.sendSimpleMessage(mail);
	}
}