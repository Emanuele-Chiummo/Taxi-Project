package it.parthenope.taxi.services;

import java.util.List;

import org.springframework.stereotype.Service;

import it.parthenope.taxi.dto.CourseDto;
import it.parthenope.taxi.model.Course;

/**
 * Servizio per la gestione delle corse nel sistema.
 */
@Service
public interface CourseService {

    /**
     * Restituisce una lista di tutti le corse presenti nel sistema.
     *
     * @return Una lista di oggetti {@link CourseDto} rappresentanti le corse.
     */
    List<CourseDto> getAllCourse();

    /**
     * Verifica l'esistenza di una corsa nel sistema dato l'ID.
     *
     * @param id L'ID della corsa da verificare.
     * @return true se la corsa esiste, false altrimenti.
     */
    boolean courseExist(Integer id);

    /**
     * Aggiorna le informazioni di una corsa nel sistema.
     *
     * @param courseDto Un oggetto {@link CourseDto} contenente le nuove informazioni del corsa.
     */
    void updateCourse(CourseDto courseDto);

    /**
     * Crea un nuovo corso nel sistema.
     *
     * @param courseDto Un oggetto {@link CourseDto} contenente le informazioni della nuova corsa.
     * @return Un oggetto {@link Course} rappresentante la corsa appena creato.
     */
    Course createCourse(CourseDto courseDto);

    /**
     * Disattiva una corsa nel sistema dato l'ID.
     *
     * @param id L'ID della corsa da disattivare.
     */
    void deactivateCourse(Integer id);

    /**
     * Verifica l'esistenza di una corsa con le location di partenza e destinazione specificate.
     *
     * @param startLocationName Nome della location di partenza.
     * @param endLocationName   Nome della location di destinazione.
     * @return true se esiste un corso con le location specificate, false altrimenti.
     */
    boolean courseExistsWithLocations(String startLocationName, String endLocationName);
}