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




/**
 * Classe principale per l'applicazione Taxi. Questa classe avvia l'applicazione Spring Boot
 * e inizializza il listener per le email.
 */
@SpringBootApplication(scanBasePackages = { "it.parthenope.taxi" })
public class TaxiApplication {

    /**
     * Metodo principale che avvia l'applicazione Spring Boot e inizializza il listener per le email.
     *
     * @param args Gli eventuali argomenti da passare all'applicazione.
     * @throws MessagingException     Eccezione generata in caso di errori durante la gestione delle email.
     * @throws InterruptedException   Eccezione generata in caso di interruzione durante l'esecuzione.
     * @throws IOException            Eccezione generata in caso di errori di input/output.
     */
    public static void main(String[] args) throws MessagingException, InterruptedException, IOException {
        ConfigurableApplicationContext appContext = SpringApplication.run(TaxiApplication.class, args);
        EmailListener emailListener = appContext.getBean(EmailListener.class);
        emailListener.startListening();
    }
}

