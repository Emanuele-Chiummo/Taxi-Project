package it.parthenope.taxi.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.parthenope.taxi.model.Taxi;

@Repository
public interface TaxiRepository extends JpaRepository<Taxi, Integer> {
	
	Optional<Taxi> findByDriverId(Integer driverId);
	
	Optional<Taxi> findById(Integer taxiId);
	

}


