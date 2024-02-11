package it.parthenope.taxi.mappers.impl;



import org.springframework.stereotype.Component;

import it.parthenope.taxi.dto.EmailDto;
import it.parthenope.taxi.mappers.EmailMapper;
import it.parthenope.taxi.model.Email;

/**
 * Implementazione di {@link EmailMapper} che gestisce la conversione tra oggetti DTO (EmailDto) e oggetti modello (Email).
 */
@Component
public class EmailMapperImpl implements EmailMapper {

    /**
     * Converte un oggetto EmailDto in un oggetto Email.
     *
     * @param emailDto L'oggetto EmailDto da convertire.
     * @return Un oggetto Email convertito.
     */
    @Override
    public Email dtoToModel(EmailDto emailDto) {
        Email email = new Email();

        email.setId(emailDto.getId());
        email.setSender(emailDto.getSender());
        email.setSubject(emailDto.getSubject());
        email.setBody(emailDto.getBody());
        email.setState(emailDto.getState());
        email.setTaxi(emailDto.getTaxi());

        return email;
    }

    /**
     * Converte un oggetto Email in un oggetto EmailDto.
     *
     * @param email L'oggetto Email da convertire.
     * @return Un oggetto EmailDto convertito.
     */
    @Override
    public EmailDto modelToDto(Email email) {
        EmailDto emailDto = new EmailDto();

        emailDto.setId(email.getId());
        emailDto.setSender(email.getSender());
        emailDto.setSubject(email.getSubject());
        emailDto.setBody(email.getBody());
        emailDto.setState(email.getState());
        emailDto.setTaxi(email.getTaxi());

        return emailDto;
    }
}
