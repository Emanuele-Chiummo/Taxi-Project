package it.parthenope.taxi.mappers;

import it.parthenope.taxi.dto.EmailDto;
import it.parthenope.taxi.model.Email;

/**
 * Interfaccia per la conversione tra oggetti DTO (EmailDto) e oggetti modello (Email).
 */
public interface EmailMapper {

    /**
     * Converte un oggetto EmailDto in un oggetto Email.
     *
     * @param emailDto L'oggetto EmailDto da convertire.
     * @return Un oggetto Email convertito.
     */
    Email dtoToModel(EmailDto emailDto);

    /**
     * Converte un oggetto Email in un oggetto EmailDto.
     *
     * @param email L'oggetto Email da convertire.
     * @return Un oggetto EmailDto convertito.
     */
    EmailDto modelToDto(Email email);
}
