package it.parthenope.taxi.email;

import java.io.IOException;

import org.eclipse.angus.mail.imap.IMAPFolder;

import jakarta.mail.Folder;
import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.Session;
import jakarta.mail.Store;
import jakarta.mail.event.MessageCountAdapter;
import jakarta.mail.event.MessageCountEvent;

public class EmailListener extends MessageCountAdapter {
    private Session session;
    private String username;
    private String password;

    public EmailListener(Session session, String username, String password) {
        this.session = session;
        this.username = username;
        this.password = password;
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
                        System.out.println("New email received: " + message.getSubject() + " " + message.getContent().toString());
                    } catch (MessagingException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
						// TODO Auto-generated catch block
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
}
