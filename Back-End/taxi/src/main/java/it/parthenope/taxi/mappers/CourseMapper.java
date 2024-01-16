package it.parthenope.taxi.mappers;

import it.parthenope.taxi.dto.CourseDto;
import it.parthenope.taxi.model.Course;


public interface CourseMapper {

	Course dtoToModel(CourseDto courseDto);

	CourseDto modelToDto(Course course);

}