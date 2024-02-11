package it.parthenope.taxi.repository;

import java.util.List;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.parthenope.taxi.model.Request;
import it.parthenope.taxi.model.Taxi;

/**
 * Repository per la gestione delle entità {@link Taxi}.
 * Fornisce metodi personalizzati per recuperare informazioni sui taxi.*/

@Repository
public interface TaxiRepository extends JpaRepository<Taxi, Integer> {
	
	/**
     * Trova un taxi in base all'ID del conducente associato.
     *
     * @param driverId L'ID del conducente associato al taxi.
     * @return Un Optional contenente il taxi associato all'ID del conducente, se presente.
     */
    Optional<Taxi> findByDriverId(Integer driverId);

    /**
     * Trova un taxi in base all'ID del taxi.
     *
     * @param taxiId L'ID del taxi.
     * @return Un Optional contenente il taxi con l'ID specificato, se presente.
     */
    Optional<Taxi> findById(Integer taxiId);

    /**
     * Salva un taxi nel repository.
     *
     * @param taxi Il taxi da salvare.
     */
    void save(Request taxi);

    /**
     * Trova una lista di taxi in base allo stato di attività.
     *
     * @param active Lo stato di attività dei taxi.
     * @return Una lista di taxi corrispondenti allo stato di attività fornito.
     */
    List<Taxi> findByActive(int active);

	

}


