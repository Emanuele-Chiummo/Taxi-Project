package it.parthenope.taxi.mappers.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import it.parthenope.taxi.dto.CourseDto;
import it.parthenope.taxi.mappers.CourseMapper;
import it.parthenope.taxi.model.Course;
import it.parthenope.taxi.model.Location;
import it.parthenope.taxi.model.Rates;
import it.parthenope.taxi.repository.LocationRepository;
import it.parthenope.taxi.repository.RateRepository;

@Component
public class CourseMapperImpl implements CourseMapper {

    @Autowired
    private LocationRepository locationRepository;

    @Autowired
    private RateRepository ratesRepository;

    @Override
    public Course dtoToModel(CourseDto courseDto) {
        Course course = new Course();

        course.setId(courseDto.getId());
        
        
        Location startLocation = courseDto.getStartLocation();
        if (startLocation.getId() != null) {
            startLocation = locationRepository.findById(startLocation.getId()).orElse(null);
        } else {
            startLocation = locationRepository.save(startLocation);
        }
        course.setStartLocation(startLocation);

        
        Location endLocation = courseDto.getEndLocation();
        if (endLocation.getId() != null) {
            endLocation = locationRepository.findById(endLocation.getId()).orElse(null);
        } else {
            endLocation = locationRepository.save(endLocation);
        }
        course.setEndLocation(endLocation);

        course.setKm(courseDto.getKm());

        
        Rates ratesType = courseDto.getRatesType();
        /*if (ratesType.getId() != null) {
            ratesType = ratesRepository.findById(ratesType.getId()).orElse(null);
        } else {
            ratesType = ratesRepository.save(ratesType);
        }*/
        course.setRatesType(ratesType);

        course.setActive(courseDto.getActive());

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
        courseDto.setActive(course.getActive());

        return courseDto;
    }
}
