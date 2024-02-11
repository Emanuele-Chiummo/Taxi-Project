package it.parthenope.taxi.services;

import java.util.List;

import org.springframework.stereotype.Service;

import it.parthenope.taxi.dto.EmailDto;


/**
 * Servizio per la gestione delle email nel sistema.
 */
@Service
public interface EmailService {

    /**
     * Salva un'istanza di email nel sistema.
     *
     * @param emailDto Un oggetto {@link EmailDto} contenente le informazioni dell'email da salvare.
     */
    void saveEmail(EmailDto emailDto);

    /**
     * Restituisce una lista di email filtrate per stato.
     *
     * @param state Lo stato delle email da recuperare.
     * @return Una lista di oggetti {@link EmailDto} rappresentanti le email nel sistema.
     */
    List<EmailDto> getAllEmail(String state);

    /**
     * Aggiorna le informazioni di un'email nel sistema.
     *
     * @param emailDto Un oggetto {@link EmailDto} contenente le nuove informazioni dell'email.
     */
    void updateEmail(EmailDto emailDto);

    /**
     * Restituisce una lista di richieste associate a un determinato taxi.
     *
     * @param taxiId L'ID del taxi per il quale recuperare le richieste.
     * @return Una lista di oggetti {@link EmailDto} rappresentanti le richieste del taxi.
     */
    List<EmailDto> getMyRequests(Long taxiId);
}
