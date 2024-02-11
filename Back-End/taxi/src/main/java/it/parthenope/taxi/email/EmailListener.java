package it.parthenope.taxi.email;

import java.io.IOException;

import org.eclipse.angus.mail.imap.IMAPFolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import it.parthenope.taxi.dto.EmailDto;
import it.parthenope.taxi.services.EmailService;
import jakarta.mail.Address;
import jakarta.mail.BodyPart;
import jakarta.mail.Folder;
import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.Multipart;
import jakarta.mail.Session;
import jakarta.mail.Store;
import jakarta.mail.event.MessageCountAdapter;
import jakarta.mail.event.MessageCountEvent;

/**
 * Componente che gestisce l'ascolto delle email in arrivo.
 */
@Component
@Order(1)
public class EmailListener extends MessageCountAdapter {
    
    /**
     * Sessione email.
     */
    private Session session;

    /**
     * Nome utente per l'accesso all'email.
     */
    private String username;

    /**
     * Password per l'accesso all'email.
     */
    private String password;

    /**
     * Servizio di gestione delle email.
     */
    @Autowired
    EmailService emailService;

    /**
     * Costruttore della classe.
     *
     * @param session      La sessione email.
     * @param username     Il nome utente per l'accesso all'email.
     * @param password     La password per l'accesso all'email.
     * @param emailService Il servizio di gestione delle email.
     */
    public EmailListener(Session session, String username, String password, EmailService emailService) {
        this.session = session;
        this.username = username;
        this.password = password;
        this.emailService = emailService;
        System.out.print("email" + username);
    }

    /**
     * Avvia l'ascolto delle email in arrivo.
     *
     * @throws MessagingException Eccezione di messaggistica.
     * @throws InterruptedException Eccezione di interruzione.
     * @throws IOException Eccezione di input/output.
     */
    public void startListening() throws MessagingException, InterruptedException, IOException {
        Store store = session.getStore("imaps");
        store.connect(username, password);

        IMAPFolder inbox = (IMAPFolder) store.getFolder("INBOX");
        inbox.open(Folder.READ_WRITE);

        // Crea un nuovo thread per mantenere la connessione attiva
        Thread keepAliveThread = new Thread(new KeepAliveRunnable(inbox), "IdleConnectionKeepAlive");
        keepAliveThread.start();

        inbox.addMessageCountListener(new MessageCountAdapter() {
            @Override
            public void messagesAdded(MessageCountEvent event) {
                // Processa i nuovi messaggi aggiunti
                Message[] messages = event.getMessages();
                for (Message message : messages) {
                    try {
                        // Implementa qui la logica di elaborazione delle email
                        System.out.println("Nuova email ricevuta: " + message.getSubject());

                        EmailDto newEmailDto = new EmailDto();

                        newEmailDto.setId(1);
                        Address[] fromAddresses = message.getFrom();
                        if (fromAddresses != null && fromAddresses.length > 0) {
                            newEmailDto.setSender(fromAddresses[0].toString());
                        } else {
                            newEmailDto.setSender("Indirizzo email non disponibile");
                        }
                        newEmailDto.setSubject(message.getSubject());

                        Object content = message.getContent();
                        if (content instanceof String) {
                            newEmailDto.setBody((String) content);
                        } else if (content instanceof Multipart) {
                            newEmailDto.setBody(extractTextFromMultipart((Multipart) content));
                        } else {
                            newEmailDto.setBody("Tipo di contenuto non gestito");
                        }

                        newEmailDto.setState("Stato dell'email");

                        System.out.println("Email elaborata in EmailListener: " + newEmailDto);

                        emailService.saveEmail(newEmailDto);

                        System.out.println("Email salvata nel database: " + newEmailDto);

                    } catch (MessagingException | IOException e) {
                        e.printStackTrace();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        // Avvia il loop IDLE
        while (!Thread.interrupted()) {
            try {
                System.out.println("Avvio IDLE");
                inbox.idle();
            } catch (MessagingException e) {
                System.out.println("Eccezione di messaggistica durante l'IDLE");
                e.printStackTrace();
                throw new RuntimeException(e);
            }
        }

        // Interrompe e arresta il thread keep-alive
        if (keepAliveThread.isAlive()) {
            keepAliveThread.interrupt();
        }
    }

    /**
     * Estrae il testo da un oggetto Multipart.
     *
     * @param multipart L'oggetto Multipart da cui estrarre il testo.
     * @return Il testo estratto dall'oggetto Multipart.
     * @throws MessagingException Eccezione di messaggistica.
     * @throws IOException Eccezione di input/output.
     */
    private String extractTextFromMultipart(Multipart multipart) throws MessagingException, IOException {
        StringBuilder textContent = new StringBuilder();

        for (int i = 0; i < multipart.getCount(); i++) {
            BodyPart bodyPart = multipart.getBodyPart(i);

            if (bodyPart.isMimeType("text/plain")) {
                textContent.append(bodyPart.getContent());
            } else if (bodyPart.isMimeType("text/html")) {
                // Puoi gestire il testo HTML se necessario
            } else if (bodyPart.getContent() instanceof Multipart) {
                textContent.append(extractTextFromMultipart((Multipart) bodyPart.getContent()));
            }
        }
        return textContent.toString();
    }
}