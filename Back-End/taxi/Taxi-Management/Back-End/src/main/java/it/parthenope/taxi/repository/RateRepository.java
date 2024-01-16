package it.parthenope.taxi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.parthenope.taxi.model.Rates;

@Repository
public interface RateRepository extends JpaRepository<Rates, Integer> {

}