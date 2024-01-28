package it.parthenope.taxi.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.parthenope.taxi.dto.CourseDto;
import it.parthenope.taxi.mappers.CourseMapper;
import it.parthenope.taxi.model.Course;
import it.parthenope.taxi.model.Location;
import it.parthenope.taxi.repository.CourseRepository;
import it.parthenope.taxi.repository.LocationRepository;
import it.parthenope.taxi.services.CourseService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class CourseServiceImpl implements CourseService{
	
	@Autowired
	CourseMapper courseMapper;

	@Autowired
	CourseRepository courseRepository;
	
	@Autowired
	LocationRepository locationRepository;
	
	@PersistenceContext
	 EntityManager entityManager;
	
	
	@Override
	public List<CourseDto> getAllCourse() {
		// TODO Auto-generated method stub
		
		List<Course> allCourse = courseRepository.findByActive(1);
		List<CourseDto> allCourseDto = new ArrayList<CourseDto>();
		for(Course myCourse : allCourse) {
			allCourseDto.add(courseMapper.modelToDto(myCourse));
		}
		
		return allCourseDto;
	}
	
	
	
	@Override
    public boolean courseExist(Integer id) {
        return courseRepository.existsById(id);
    }
	
	@Override
    public void updateCourse(CourseDto courseDto) {
        Course course = courseMapper.dtoToModel(courseDto);
        courseRepository.save(course);
    }
	
	@Override
    public Course createCourse(CourseDto courseDto) {
        Course course = courseMapper.dtoToModel(courseDto);
        return courseRepository.save(course);
    }
	
	@Override
    public void deactivateCourse(Integer id) {
        Optional<Course> courseOptional = courseRepository.findById(id);
        if (courseOptional.isPresent()) {
            Course course = courseOptional.get();
            course.setActive(0);
            courseRepository.save(course);
        } else {
            throw new RuntimeException("Course not found with id: " + id);
        }
    }
	
	@Override
	public boolean courseExistsWithLocations(String startLocationName, String endLocationName) {
	    Location startLocation = locationRepository.findByName(startLocationName);
	    Location endLocation = locationRepository.findByName(endLocationName);

	    if (startLocation == null || endLocation == null) {
	        // If one of the locations does not exist, the course cannot exist
	        return false;
	    }

	    boolean existsWithSameStartLocation = courseRepository.existsByStartLocationAndEndLocation(startLocation, endLocation);
	    boolean existsWithSameEndLocation = courseRepository.existsByStartLocationAndEndLocation(endLocation, startLocation);

	    return existsWithSameStartLocation || existsWithSameEndLocation;
	}
	

}