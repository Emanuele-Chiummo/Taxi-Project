package it.parthenope.taxi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import it.parthenope.taxi.model.Request;
import it.parthenope.taxi.model.Taxi;

/**
 * Repository per l'accesso e la gestione delle entità {@link Request}.
 * Fornisce query personalizzate per recuperare informazioni su richieste, taxi e rotte popolari.*/

@Repository
public interface RequestRepository extends JpaRepository<Request, Integer> {

	/**
     * Recupera una lista di richieste in base allo stato.
     *
     * @param state Lo stato delle richieste.
     * @return Una lista di richieste corrispondenti allo stato fornito.
     */
    List<Request> findByState(String state);

    /**
     * Recupera una lista di richieste in base allo stato e all'ID del taxi.
     *
     * @param state  Lo stato delle richieste.
     * @param taxiId L'ID del taxi.
     * @return Una lista di richieste corrispondenti allo stato e all'ID del taxi forniti.
     */
    List<Request> findByStateAndTaxiId(String state, Long taxiId);

    /**
     * Recupera una lista di richieste in base al taxi associato.
     *
     * @param taxi Il taxi associato alle richieste.
     * @return Una lista di richieste associate al taxi fornito.
     */
    List<Request> findByTaxi(Taxi taxi);

    /**
     * Recupera una lista di rotte più popolari in base al numero di richieste accettate.
     *
     * @return Una lista di oggetti contenenti nomi delle località di partenza e arrivo e il numero di richieste.
     */
    @Query("SELECT r.course.startLocation.name as start_location_name, " +
            "r.course.endLocation.name as end_location_name, " +
            "count(r.id) as num_requests " +
            "FROM Request r " +
            "WHERE r.state = 'Accettata' " +
            "GROUP BY r.course.startLocation.name, r.course.endLocation.name " +
            "ORDER BY num_requests DESC")
    List<Object[]> findMostPopularRoutes();

    /**
     * Recupera una lista di taxi con il maggior numero di richieste accettate.
     *
     * @return Una lista di oggetti contenenti identificatori dei taxi e il conteggio delle richieste.
     */
    @Query("SELECT r.taxi.identifier, COUNT(r) FROM Request r WHERE r.state = 'Accettata' AND r.taxi IS NOT NULL GROUP BY r.taxi.id ORDER BY COUNT(r) DESC")
    List<Object[]> findMostTaxiCourse();

    /**
     * Recupera una lista di taxi con il maggior importo totale per le richieste accettate.
     *
     * @return Una lista di oggetti contenenti identificatori dei taxi, data della richiesta e importo totale.
     */
    @Query("SELECT r.taxi.identifier, r.date, SUM(r.course.ratesType.amount) " +
            "FROM Request r " +
            "WHERE r.state = 'Accettata' AND r.taxi IS NOT NULL " +
            "GROUP BY r.taxi.identifier, r.date " +
            "ORDER BY SUM(r.course.ratesType.amount) DESC")
    List<Object[]> findMostTaxiAmount();

    
    /*@Query("SELECT r.taxi.identifier , SUM(r.course.ratesType.amount) FROM Request r WHERE r.state = 'Accettata' AND r.taxi IS NOT NULL GROUP BY r.taxi.id ORDER BY COUNT(r) DESC")
    List<Object[]> findMostTaxiAmount();*/



}
