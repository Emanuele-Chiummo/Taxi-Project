package it.parthenope.taxi.email;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import it.parthenope.taxi.services.EmailService;
import jakarta.mail.Session;

/**
 * Configurazione della gestione delle email.
 */
@Configuration
public class EmailConfiguration {
	
    /**
     * Host dell'email.
     */
    @Value("imap.gmail.com")
    private String emailHost;

    /**
     * Porta dell'email.
     */
    @Value("993")
    private String emailPort;

    /**
     * Nome utente dell'email.
     */
    @Value("taxitogo2024@gmail.com")
    private String emailUsername;

    /**
     * Password dell'email.
     */
    @Value("fqnf fszy bpvt crlg")
    private String emailPassword;
    
    /**
     * Servizio di gestione delle email.
     */
    @Autowired
    EmailService emailService;

    /**
     * Crea e restituisce una sessione email.
     *
     * @return La sessione email configurata.
     */
    @Bean
    public Session mailSession() {
        Properties props = new Properties();
        props.setProperty("mail.store.protocol", "imaps");
        props.setProperty("mail.imaps.host", emailHost);
        props.setProperty("mail.imaps.port", emailPort);

        // Crea una nuova sessione con le proprietà
        Session session = Session.getInstance(props);
        session.setDebug(true); // Abilita la modalità di debug per il troubleshooting

        return session;
    }

    /**
     * Crea e restituisce un listener per la gestione delle email.
     *
     * @return Il listener per la gestione delle email.
     */
    @Bean
    public EmailListener emailListener() {
        return new EmailListener(mailSession(), emailUsername, emailPassword, emailService);
    }
}
