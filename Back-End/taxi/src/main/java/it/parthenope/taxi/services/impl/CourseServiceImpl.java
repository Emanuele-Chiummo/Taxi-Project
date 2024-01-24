package it.parthenope.taxi.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.parthenope.taxi.dto.CourseDto;
import it.parthenope.taxi.dto.RequestDto;
import it.parthenope.taxi.mappers.CourseMapper;
import it.parthenope.taxi.model.Course;
import it.parthenope.taxi.model.Request;
import it.parthenope.taxi.repository.CourseRepository;
import it.parthenope.taxi.services.CourseService;

@Service
public class CourseServiceImpl implements CourseService{
	
	@Autowired
	CourseMapper courseMapper;

	@Autowired
	CourseRepository courseRepository;
	
	@Override
	public List<CourseDto> getAllCourse() {
		// TODO Auto-generated method stub
		
		List<Course> allCourse = courseRepository.findAll();
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
	

}