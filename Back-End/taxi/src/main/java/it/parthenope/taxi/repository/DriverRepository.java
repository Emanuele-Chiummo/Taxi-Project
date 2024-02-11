package it.parthenope.taxi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.parthenope.taxi.model.Driver;

/**
 * Repository per l'accesso ai dati relativi ai conducenti.
 */
@Repository
public interface DriverRepository extends JpaRepository<Driver, Integer> {
	
    /**
     * Trova un conducente in base all'email e alla password.
     *
     * @param email    L'email del conducente.
     * @param password La password del conducente.
     * @return Il conducente corrispondente all'email e alla password specificate.
     */
    Driver findByEmailAndPassword(String email, String password);
	
    /**
     * Trova una lista di conducenti in base al tipo di utente.
     *
     * @param userType Il tipo di utente da cercare.
     * @return Una lista di conducenti con il tipo di utente specificato.
     */
    List<Driver> findByUserType(String userType);

    /**
     * Trova una lista di conducenti in base allo stato di attivazione.
     *
     * @param active Lo stato di attivazione da cercare.
     * @return Una lista di conducenti con lo stato di attivazione specificato.
     */
    List<Driver> findByActive(int active);
}
