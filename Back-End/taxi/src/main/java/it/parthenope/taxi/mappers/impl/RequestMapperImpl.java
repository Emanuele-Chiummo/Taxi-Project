package it.parthenope.taxi.mappers.impl;

import org.springframework.stereotype.Component;

import it.parthenope.taxi.dto.RequestDto;
import it.parthenope.taxi.dto.TaxiDto;
import it.parthenope.taxi.mappers.RequestMapper;
import it.parthenope.taxi.model.Request;

/**
 * Implementazione di {@link RequestMapper} che gestisce la conversione tra oggetti DTO (RequestDto) e oggetti modello (Request).
 */
@Component
public class RequestMapperImpl implements RequestMapper {

    /**
     * Converte un oggetto RequestDto in un oggetto Request.
     *
     * @param requestDto L'oggetto RequestDto da convertire.
     * @return Un oggetto Request convertito.
     */
    @Override
    public Request dtoToModel(RequestDto requestDto) {
        Request request = new Request();

        request.setId(requestDto.getId());
        request.setCourse(requestDto.getCourse());
        request.setDate(requestDto.getDate());
        request.setState(requestDto.getState());
        request.setTaxi(requestDto.getTaxi());

        return request;
    }

    /**
     * Converte un oggetto Request in un oggetto RequestDto.
     *
     * @param request L'oggetto Request da convertire.
     * @return Un oggetto RequestDto convertito.
     */
    @Override
    public RequestDto modelToDto(Request request) {
        RequestDto requestDto = new RequestDto();

        requestDto.setId(request.getId());
        requestDto.setCourse(request.getCourse());
        requestDto.setDate(request.getDate());
        requestDto.setState(request.getState());
        requestDto.setTaxi(request.getTaxi());

        return requestDto;
    }
}
