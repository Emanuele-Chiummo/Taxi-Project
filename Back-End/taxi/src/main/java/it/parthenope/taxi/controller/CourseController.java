package it.parthenope.taxi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import it.parthenope.taxi.dto.CourseDto;
import it.parthenope.taxi.dto.RequestDto;
import it.parthenope.taxi.mappers.CourseMapper;
import it.parthenope.taxi.model.Course;
import it.parthenope.taxi.services.CourseService;

@CrossOrigin(
        origins = "*",
        allowedHeaders = {"*"})

@RestController
public class CourseController {

	@Autowired
	CourseService courseService;
	
	@Autowired
	CourseMapper courseMapper;

	@GetMapping("/api/course")
	public List<CourseDto> getAllCourse(){

		return courseService.getAllCourse();
	}
	
	@PutMapping("/api/course/{id}")
    public ResponseEntity<CourseDto> updateCourse(@PathVariable Integer id, @RequestBody CourseDto courseDto) {

        if (!courseService.courseExist(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        courseService.updateCourse(courseDto);

        return new ResponseEntity<>(courseDto, HttpStatus.OK);
    }
	
	@PostMapping("/api/course")
	public ResponseEntity<CourseDto> createRequest(@RequestBody CourseDto courseDto) {

		courseService.createCourse(courseDto);
		return new ResponseEntity<CourseDto>(courseDto, HttpStatus.CREATED);
		
	}
	
	@PutMapping("/api/course/deactivate/{id}")
	public ResponseEntity<Void> deactivateCourse(@PathVariable Integer id) {
	    courseService.deactivateCourse(id);
	    return ResponseEntity.ok().build();
	}
	
	  @GetMapping("/api/course/exists")
	    public ResponseEntity<Boolean> courseExistsWithLocations(
	            @RequestParam String startLocation,
	            @RequestParam String endLocation) {
	        boolean exists = courseService.courseExistsWithLocations(startLocation, endLocation);
	        return ResponseEntity.ok(exists);
	   }
	




}