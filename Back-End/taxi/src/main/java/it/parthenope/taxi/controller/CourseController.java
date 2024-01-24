package it.parthenope.taxi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.RequestBody;
import it.parthenope.taxi.dto.CourseDto;
import it.parthenope.taxi.services.CourseService;

@CrossOrigin(
        origins = "*",
        allowedHeaders = {"*"})

@RestController
public class CourseController {

	@Autowired
	CourseService courseService;

	@GetMapping("/api/course")
	public List<CourseDto> getAllCourse(){

		return courseService.getAllCourse();
	}
	
	@PutMapping("/api/course/{id}")
    public ResponseEntity<CourseDto> updateCourse(@PathVariable Integer id, @RequestBody CourseDto courseDto) {

        if (!courseService.courseExist(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        System.out.println("StartLocation"+courseDto.getStartLocation());
        System.out.println("EndLocation"+courseDto.getEndLocation());
        courseService.updateCourse(courseDto);

        return new ResponseEntity<>(courseDto, HttpStatus.OK);
    }
	




}