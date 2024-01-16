package it.parthenope.taxi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.parthenope.taxi.model.Driver;

@Repository
public interface DriverRepository extends JpaRepository<Driver, Integer> {
	
	Driver findByEmailAndPassword(String email, String password);

}
