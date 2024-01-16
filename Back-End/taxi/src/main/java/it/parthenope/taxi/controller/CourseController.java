package it.parthenope.taxi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import it.parthenope.taxi.dto.CourseDto;
import it.parthenope.taxi.services.CourseService;

@RestController
public class CourseController {

	@Autowired
	CourseService courseService;

	@GetMapping("/api/course")
	public List<CourseDto> getAllCourse(){

		return courseService.getAllCourse();
	}




}