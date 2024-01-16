package it.parthenope.taxi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.parthenope.taxi.model.Location;

@Repository
public interface LocationRepository extends JpaRepository<Location, Integer> {

}
