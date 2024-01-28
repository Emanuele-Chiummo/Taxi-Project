package it.parthenope.taxi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.parthenope.taxi.model.Course;
import it.parthenope.taxi.model.Location;
import it.parthenope.taxi.model.Request;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer> {

	List<Course> findByActive(int i);

	boolean existsByStartLocationAndEndLocation(Location startLocation, Location endLocation);

	//boolean existsByStartLocationIdAndEndLocationId(Long startLocationId, Long endLocationId);


}
