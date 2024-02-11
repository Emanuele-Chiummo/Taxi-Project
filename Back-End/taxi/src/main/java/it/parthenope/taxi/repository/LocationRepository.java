package it.parthenope.taxi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import it.parthenope.taxi.model.Location;

/**
 * Repository per l'accesso ai dati relativi alle posizioni.
 */
@Repository
public interface LocationRepository extends JpaRepository<Location, Integer> {

    /**
     * Verifica l'esistenza di una posizione con il nome specificato.
     *
     * @param name Il nome della posizione da verificare.
     * @return La posizione se esiste, altrimenti null.
     */
    Location existsByName(String name);

    /**
     * Trova una posizione per il nome specificato.
     *
     * @param name Il nome della posizione da cercare.
     * @return La posizione se trovata, altrimenti null.
     */
    Location findByName(String name);

    /**
     * Trova l'ID di una posizione per il nome specificato.
     *
     * @param name Il nome della posizione di cui trovare l'ID.
     * @return L'ID della posizione se trovato, altrimenti null.
     */
    @Query("SELECT l.id FROM Location l WHERE l.name = :name")
    Long findIdByName(@Param("name") String name);
}
