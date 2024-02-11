package it.parthenope.taxi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import it.parthenope.taxi.model.Rates;

/**
 * Repository per l'accesso ai dati relativi alle tariffe.
 */

@Repository
public interface RateRepository extends JpaRepository<Rates, Integer> {
	
	/*@Query("SELECT id FROM rates WHERE id = id")
	Rates getId(@Param("id") Integer id);*/

}