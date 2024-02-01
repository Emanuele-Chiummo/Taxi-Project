package it.parthenope.taxi;

import java.io.IOException;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


import it.parthenope.taxi.email.EmailConfiguration;
import it.parthenope.taxi.email.EmailListener;
import jakarta.mail.MessagingException;




@SpringBootApplication(scanBasePackages = { "it.parthenope.taxi" })
public class TaxiApplication{

	public static void main(String[] args) throws MessagingException, InterruptedException, IOException {
		//SpringApplication.run(TaxiApplication.class, args);
		
		ConfigurableApplicationContext appContext = SpringApplication.run(TaxiApplication.class, args);
	    EmailListener emailListener = appContext.getBean(EmailListener.class);
	    emailListener.startListening();
	}
	
	/*@Override
	 public void run(String... args) throws Exception {
	  ApplicationContext context = new AnnotationConfigApplicationContext(EmailConfiguration.class);
	  EmailListener emailListener = context.getBean(EmailListener.class);
	  emailListener.startListening();
	 } */
	
	

}
