package it.parthenope.taxi.mappers.impl;

import org.springframework.stereotype.Component;

import it.parthenope.taxi.dto.CourseDto;
import it.parthenope.taxi.mappers.CourseMapper;
import it.parthenope.taxi.model.Course;

@Component
public class CourseMapperImpl implements CourseMapper {


	@Override
	public Course dtoToModel(CourseDto courseDto) {

		Course course = new Course();

		course.setId(courseDto.getId());
		course.setStartLocation(courseDto.getStartLocation());
		course.setEndLocation(courseDto.getEndLocation());
		course.setKm(courseDto.getKm());
		course.setRatesType(courseDto.getRatesType());

		return course;
	}

	@Override
	public CourseDto modelToDto(Course course) {

		CourseDto courseDto = new CourseDto();

		courseDto.setId(course.getId());
		courseDto.setStartLocation(course.getStartLocation());
		courseDto.setEndLocation(course.getEndLocation());
		courseDto.setKm(course.getKm());
		courseDto.setRatesType(course.getRatesType());

		return courseDto;
	}



}