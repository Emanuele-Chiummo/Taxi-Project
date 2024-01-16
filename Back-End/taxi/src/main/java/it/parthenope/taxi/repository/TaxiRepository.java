package it.parthenope.taxi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.parthenope.taxi.model.Taxi;

@Repository
public interface TaxiRepository extends JpaRepository<Taxi, Integer> {

}


