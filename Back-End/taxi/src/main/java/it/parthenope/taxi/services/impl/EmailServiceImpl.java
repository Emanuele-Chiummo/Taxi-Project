package it.parthenope.taxi.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

import it.parthenope.taxi.dto.EmailDto;
import it.parthenope.taxi.dto.RequestDto;
import it.parthenope.taxi.mappers.EmailMapper;
import it.parthenope.taxi.model.Email;
import it.parthenope.taxi.model.Request;
import it.parthenope.taxi.repository.EmailRepository;
import it.parthenope.taxi.services.EmailService;

/**
 * Implementazione di {@link EmailService} per la gestione delle email.
 */
@Service
@Order(0)
public class EmailServiceImpl implements EmailService {

    @Autowired
    private EmailMapper emailMapper;

    @Autowired
    private EmailRepository emailRepository;

    /**
     * Salva un'email nel sistema.
     *
     * @param emailDto L'oggetto {@link EmailDto} contenente le informazioni dell'email da salvare.
     * @see EmailService#saveEmail(EmailDto)
     */
    @Override
    public void saveEmail(EmailDto emailDto) {
        Email email = new Email();
        email.setSender(emailDto.getSender());
        email.setSubject(emailDto.getSubject());
        email.setBody(emailDto.getBody());
        email.setState(emailDto.getState());
        // Imposta le altre proprietà se necessario

        // Salva l'email nel database
        emailRepository.save(email);

        System.out.println("Email saved in EmailService: " + emailDto);
    }

    /**
     * Restituisce tutte le email nel sistema con lo stato specificato.
     *
     * @param state Lo stato delle email da recuperare.
     * @return Una lista di oggetti {@link EmailDto} rappresentanti le email con lo stato specificato.
     * @see EmailService#getAllEmail(String)
     */
    @Override
    public List<EmailDto> getAllEmail(String state) {
        List<Email> allEmails = emailRepository.findByState(state);
        return allEmails.stream()
                .map(emailMapper::modelToDto)
                .collect(Collectors.toList());
    }

    /**
     * Restituisce tutte le email accettate per un determinato tassista.
     *
     * @param taxiId L'ID del tassista.
     * @return Una lista di oggetti {@link EmailDto} rappresentanti le email accettate dal tassista.
     * @see EmailService#getMyRequests(Long)
     */
    @Override
    public List<EmailDto> getMyRequests(Long taxiId) {
        List<Email> acceptedRequestsForTaxi = emailRepository.findByStateAndTaxiId("Accettata", taxiId);
        return acceptedRequestsForTaxi.stream()
                .map(emailMapper::modelToDto)
                .collect(Collectors.toList());
    }

    /**
     * Aggiorna le informazioni di un'email nel sistema.
     *
     * @param emailDto L'oggetto {@link EmailDto} contenente le nuove informazioni dell'email.
     * @see EmailService#updateEmail(EmailDto)
     */
    @Override
    public void updateEmail(EmailDto emailDto) {
        Email email = emailMapper.dtoToModel(emailDto);
        emailRepository.save(email);
    }
}
