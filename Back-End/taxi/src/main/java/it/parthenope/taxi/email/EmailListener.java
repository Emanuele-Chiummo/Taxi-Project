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

@Component
@Order(1)
public class EmailListener extends MessageCountAdapter {
    private Session session;
    private String username;
    private String password;
    
    EmailService emailService;
    

    
    
    
    public EmailListener(Session session, String username, String password, EmailService emailService) {
        this.session = session;
        this.username = username;
        this.password = password;
        this.emailService = emailService;
        System.out.print("email" + username);
    }

    public void startListening() throws MessagingException, InterruptedException, IOException {
        Store store = session.getStore("imaps");
        store.connect(username, password);

        IMAPFolder inbox = (IMAPFolder)store.getFolder("INBOX");
        inbox.open(Folder.READ_WRITE);

        // Create a new thread to keep the connection alive
        Thread keepAliveThread = new Thread(new KeepAliveRunnable(inbox), "IdleConnectionKeepAlive");
        keepAliveThread.start();

        inbox.addMessageCountListener(new MessageCountAdapter() {
            @Override
            public void messagesAdded(MessageCountEvent event) {
                // Process the newly added messages
                Message[] messages = event.getMessages();
                for (Message message : messages) {
                    try {
                        // Implement your email processing logic here
                        System.out.println("New email received: " + message.getSubject());
                        
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

                        System.out.println("Email processed in EmailListener: " + newEmailDto);

                        
                        emailService.saveEmail(newEmailDto);
                        
                        

                        System.out.println("Email Saved on DB: " + newEmailDto);

                    } catch (MessagingException | IOException e) {
                        e.printStackTrace();
            
                    } catch (Exception e) {
                    	e.printStackTrace();
                    }
                }
            }
        });

        // Start the IDLE Loop
        while (!Thread.interrupted()) {
            try {
                System.out.println("Starting IDLE");
                inbox.idle();
            } catch (MessagingException e) {
                System.out.println("Messaging exception during IDLE");
                e.printStackTrace();
                throw new RuntimeException(e);
            }
        }

        // Interrupt and shutdown the keep-alive thread
        if (keepAliveThread.isAlive()) {
            keepAliveThread.interrupt();
        }
    }

    private String extractTextFromMultipart(Multipart multipart) throws MessagingException, IOException {
    	StringBuilder textContent = new StringBuilder();


        for (int i = 0; i < multipart.getCount(); i++) {
            BodyPart bodyPart = multipart.getBodyPart(i);


            if (bodyPart.isMimeType("text/plain")) {

                textContent.append(bodyPart.getContent());
            } else if (bodyPart.isMimeType("text/html")) {

            } else if (bodyPart.getContent() instanceof Multipart) {

                textContent.append(extractTextFromMultipart((Multipart) bodyPart.getContent()));
            }
        }
        return textContent.toString();
    }
}
