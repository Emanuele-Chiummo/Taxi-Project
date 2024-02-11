package it.parthenope.taxi.email;

import org.eclipse.angus.mail.imap.IMAPFolder;

import jakarta.mail.MessagingException;

/**
 * Runnable per mantenere attiva la connessione IMAP inviando periodicamente un comando NOOP.
 */
public class KeepAliveRunnable implements Runnable {

    /**
     * Frequenza di mantenimento della connessione in millisecondi.
     */
    private static final long KEEP_ALIVE_FREQ = 300000; // 5 minuti

    /**
     * La cartella IMAP da mantenere attiva.
     */
    private IMAPFolder folder;

    /**
     * Costruttore della classe.
     *
     * @param folder La cartella IMAP da mantenere attiva.
     */
    public KeepAliveRunnable(IMAPFolder folder) {
        this.folder = folder;
    }

    /**
     * Esegue il mantenimento della connessione inviando periodicamente un comando NOOP.
     */
    @Override
    public void run() {
        while (!Thread.interrupted()) {
            try {
                Thread.sleep(KEEP_ALIVE_FREQ);

                // Esegue un NOOP per mantenere attiva la connessione
                System.out.println("Esecuzione di un NOOP per mantenere attiva la connessione");
                folder.doCommand(protocol -> {
                    protocol.simpleCommand("NOOP", null);
                    return null;
                });
            } catch (InterruptedException e) {
                // Ignora, stiamo solo interrompendo il thread...
            } catch (MessagingException e) {
                // Non dovrebbe realmente accadere...
                System.out.println("Eccezione inaspettata durante il mantenimento della connessione IDLE");
                e.printStackTrace();
            }
        }
    }
}
