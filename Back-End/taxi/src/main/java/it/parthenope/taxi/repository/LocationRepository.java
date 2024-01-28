package it.parthenope.taxi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import it.parthenope.taxi.model.Location;

@Repository
public interface LocationRepository extends JpaRepository<Location, Integer> {

	Location existsByName(String name);
	
	Location findByName(String name);

	 @Query("SELECT l.id FROM Location l WHERE l.name = :name")
	    Long findIdByName(@Param("name") String name);

	
	


}
