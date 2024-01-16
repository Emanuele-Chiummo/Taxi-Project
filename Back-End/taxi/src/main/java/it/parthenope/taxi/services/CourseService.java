package it.parthenope.taxi.services;

import java.util.List;

import org.springframework.stereotype.Service;

import it.parthenope.taxi.dto.CourseDto;

@Service
public interface CourseService {

 
	List<CourseDto> getAllCourse();
	

}