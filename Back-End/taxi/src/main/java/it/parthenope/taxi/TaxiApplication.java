package it.parthenope.taxi;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import it.parthenope.taxi.email.EmailConfiguration;
import it.parthenope.taxi.email.EmailListener;




@SpringBootApplication(scanBasePackages = { "it.parthenope.taxi" })
public class TaxiApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(TaxiApplication.class, args);
	}

	@Override
	 public void run(String... args) throws Exception {
	  ApplicationContext context = new AnnotationConfigApplicationContext(EmailConfiguration.class);
	  EmailListener emailListener = context.getBean(EmailListener.class);
	  emailListener.startListening();
	 }

}
