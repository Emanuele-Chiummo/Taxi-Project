package it.parthenope.taxi.services;

import org.springframework.stereotype.Service;

import it.parthenope.taxi.dto.CourseDto;

@Service
public interface CourseService {

    CourseDto createCourse(CourseDto courseDto);

}
