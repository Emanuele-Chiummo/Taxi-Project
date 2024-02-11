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

/**
 * Implementazione di {@link CourseService} per la gestione dei corsi.
 *
 * @see CourseService
 */
@Service
@Transactional
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseMapper courseMapper;

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private LocationRepository locationRepository;

    @PersistenceContext
    private EntityManager entityManager;

    /**
     * Restituisce tutti i corsi attivi presenti nel sistema.
     *
     * @return Una lista di oggetti {@link CourseDto} rappresentanti i corsi attivi.
     * @see CourseService#getAllCourse()
     */
    @Override
    public List<CourseDto> getAllCourse() {
        List<Course> allCourse = courseRepository.findByActive(1);
        List<CourseDto> allCourseDto = new ArrayList<>();
        for (Course myCourse : allCourse) {
            allCourseDto.add(courseMapper.modelToDto(myCourse));
        }

        return allCourseDto;
    }

    /**
     * Verifica l'esistenza di un corso con l'ID specificato.
     *
     * @param id L'ID del corso da verificare.
     * @return True se il corso esiste, false altrimenti.
     * @see CourseService#courseExist(Integer)
     */
    @Override
    public boolean courseExist(Integer id) {
        return courseRepository.existsById(id);
    }

    /**
     * Aggiorna le informazioni relative a un corso.
     *
     * @param courseDto Oggetto {@link CourseDto} contenente le nuove informazioni del corso.
     * @see CourseService#updateCourse(CourseDto)
     */
    @Override
    public void updateCourse(CourseDto courseDto) {
        Course course = courseMapper.dtoToModel(courseDto);
        courseRepository.save(course);
    }

    /**
     * Crea un nuovo corso nel sistema.
     *
     * @param courseDto Oggetto {@link CourseDto} contenente le informazioni del nuovo corso.
     * @return Il corso appena creato.
     * @see CourseService#createCourse(CourseDto)
     */
    @Override
    public Course createCourse(CourseDto courseDto) {
        Course course = courseMapper.dtoToModel(courseDto);
        return courseRepository.save(course);
    }

    /**
     * Disattiva un corso nel sistema in base all'ID specificato.
     *
     * @param id L'ID del corso da disattivare.
     * @see CourseService#deactivateCourse(Integer)
     */
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

    /**
     * Verifica l'esistenza di un corso con le località specificate.
     *
     * @param startLocationName Nome della località di partenza del corso.
     * @param endLocationName   Nome della località di arrivo del corso.
     * @return True se il corso esiste con le località specificate, false altrimenti.
     * @see CourseService#courseExistsWithLocations(String, String)
     */
    @Override
    public boolean courseExistsWithLocations(String startLocationName, String endLocationName) {
        Location startLocation = locationRepository.findByName(startLocationName);
        Location endLocation = locationRepository.findByName(endLocationName);

        if (startLocation == null || endLocation == null) {
            // Se una delle località non esiste, il corso non può esistere
            return false;
        }

        boolean existsWithSameStartLocation = courseRepository.existsByStartLocationAndEndLocation(startLocation, endLocation);
        boolean existsWithSameEndLocation = courseRepository.existsByStartLocationAndEndLocation(endLocation, startLocation);

        return existsWithSameStartLocation || existsWithSameEndLocation;
    }
}
