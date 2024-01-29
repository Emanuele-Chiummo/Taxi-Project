package it.parthenope.taxi.email;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import jakarta.mail.Session;

@Configuration
public class EmailConfiguration {
	

    @Value("imap.gmail.com")
    private String emailHost;

    @Value("993")
    private String emailPort;

    @Value("taxitogo2024@gmail.com")
    private String emailUsername;

    @Value("fqnf fszy bpvt crlg")
    private String emailPassword;

    @Bean
    public Session mailSession() {
        Properties props = new Properties();
        props.setProperty("mail.store.protocol", "imaps");
        props.setProperty("mail.imaps.host", emailHost);
        props.setProperty("mail.imaps.port", emailPort);


        // Create a new session with the properties
        Session session = Session.getInstance(props);
        session.setDebug(true); // Enable debug mode for troubleshooting

        return session;
    }

    @Bean
    public EmailListener emailListener() {
        return new EmailListener(mailSession(), emailUsername, emailPassword);
    }
}
