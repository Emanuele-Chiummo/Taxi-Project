package it.parthenope.taxi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.parthenope.taxi.model.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer> {

}
