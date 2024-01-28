package it.parthenope.taxi.services;

import java.util.List;

import org.springframework.stereotype.Service;

import it.parthenope.taxi.dto.CourseDto;
import it.parthenope.taxi.model.Course;

@Service
public interface CourseService {

 
	List<CourseDto> getAllCourse();


	boolean courseExist(Integer id);


	void updateCourse(CourseDto courseDto);


	Course createCourse(CourseDto courseDto);


	void deactivateCourse(Integer id);
	
	boolean courseExistsWithLocations(String startLocationName, String endLocationName);
	



	
	
	

}