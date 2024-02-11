package it.parthenope.taxi.mappers;

import it.parthenope.taxi.dto.RequestDto;
import it.parthenope.taxi.model.Request;

/**
 * Interfaccia per la conversione tra oggetti DTO (RequestDto) e oggetti modello (Request).
 */
public interface RequestMapper {

    /**
     * Converte un oggetto RequestDto in un oggetto Request.
     *
     * @param requestDto L'oggetto RequestDto da convertire.
     * @return Un oggetto Request convertito.
     */
    Request dtoToModel(RequestDto requestDto);

    /**
     * Converte un oggetto Request in un oggetto RequestDto.
     *
     * @param request L'oggetto Request da convertire.
     * @return Un oggetto RequestDto convertito.
     */
    RequestDto modelToDto(Request request);
}
