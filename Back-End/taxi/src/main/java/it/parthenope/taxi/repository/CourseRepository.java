package it.parthenope.taxi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.parthenope.taxi.model.Course;
import it.parthenope.taxi.model.Location;
import it.parthenope.taxi.model.Request;

/**
 * Repository per l'accesso ai dati relativi ai corsi.
 */
@Repository
public interface CourseRepository extends JpaRepository<Course, Integer> {

    /**
     * Trova tutti i corsi in base allo stato di attivazione.
     *
     * @param active Lo stato di attivazione da cercare.
     * @return Una lista di corsi con lo stato di attivazione specificato.
     */
    List<Course> findByActive(int active);

    /**
     * Verifica l'esistenza di un corso tra due posizioni specifiche.
     *
     * @param startLocation La posizione di partenza.
     * @param endLocation   La posizione di destinazione.
     * @return True se esiste un corso tra le posizioni specificate, altrimenti false.
     */
    boolean existsByStartLocationAndEndLocation(Location startLocation, Location endLocation);

    
}
