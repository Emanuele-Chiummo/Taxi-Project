package it.parthenope.taxi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.parthenope.taxi.model.Request;
import it.parthenope.taxi.model.Taxi;

@Repository
public interface RequestRepository extends JpaRepository<Request, Integer> {

	List<Request> findByState(String state);
	
	List<Request> findByStateAndTaxiId(String state, Long taxiId);

	List<Request> findByTaxi(Taxi taxi);


}
