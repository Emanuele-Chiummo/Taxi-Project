package it.parthenope.taxi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.parthenope.taxi.model.Request;

@Repository
public interface RequestRepository extends JpaRepository<Request, Integer> {

}
