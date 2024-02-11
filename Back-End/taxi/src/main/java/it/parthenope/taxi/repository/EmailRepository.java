package it.parthenope.taxi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.parthenope.taxi.model.Email;

/**
 * Repository per l'accesso ai dati relativi alle email.
 */
@Repository
public interface EmailRepository extends JpaRepository<Email, Integer> {

    /**
     * Trova una lista di email in base allo stato.
     *
     * @param state Lo stato delle email da cercare.
     * @return Una lista di email con lo stato specificato.
     */
    List<Email> findByState(String state);

    /**
     * Trova una lista di email in base allo stato e all'ID del taxi.
     *
     * @param state   Lo stato delle email da cercare.
     * @param taxiId  L'ID del taxi associato alle email.
     * @return Una lista di email con lo stato e l'ID del taxi specificati.
     */
    List<Email> findByStateAndTaxiId(String state, Long taxiId);
}
