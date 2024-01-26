package it.parthenope.taxi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import it.parthenope.taxi.model.Request;
import it.parthenope.taxi.model.Taxi;

@Repository
public interface RequestRepository extends JpaRepository<Request, Integer> {

	List<Request> findByState(String state);
	
	List<Request> findByStateAndTaxiId(String state, Long taxiId);

	List<Request> findByTaxi(Taxi taxi);
	
	@Query("SELECT r.course.startLocation.name as start_location_name, " +
            "r.course.endLocation.name as end_location_name, " +
            "count(r.id) as num_requests " +
    "FROM Request r " +
    "WHERE r.state = 'Accettata' " +
    "GROUP BY r.course.startLocation.name, r.course.endLocation.name " +
    "ORDER BY num_requests DESC")
	List<Object[]> findMostPopularRoutes();
	
	@Query("SELECT r.taxi.identifier, COUNT(r) FROM Request r WHERE r.state = 'Accettata' AND r.taxi IS NOT NULL GROUP BY r.taxi.id ORDER BY COUNT(r) DESC")
    List<Object[]> findMostTaxiCourse();
    
    @Query("SELECT r.taxi.identifier, r.date, SUM(r.course.ratesType.amount) " +
    	       "FROM Request r " +
    	       "WHERE r.state = 'Accettata' AND r.taxi IS NOT NULL " +
    	       "GROUP BY r.taxi.identifier, r.date " +
    	       "ORDER BY SUM(r.course.ratesType.amount) DESC")
    	List<Object[]> findMostTaxiAmount();

    
    /*@Query("SELECT r.taxi.identifier , SUM(r.course.ratesType.amount) FROM Request r WHERE r.state = 'Accettata' AND r.taxi IS NOT NULL GROUP BY r.taxi.id ORDER BY COUNT(r) DESC")
    List<Object[]> findMostTaxiAmount();*/



}
