package it.parthenope.taxi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.parthenope.taxi.model.Email;

@Repository
public interface EmailRepository extends JpaRepository<Email, Integer>{

	List<Email> findByState(String state);

	List<Email> findByStateAndTaxiId(String string, Long taxiId);
	
	

}
