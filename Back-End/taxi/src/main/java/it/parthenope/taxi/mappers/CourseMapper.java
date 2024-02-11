package it.parthenope.taxi.mappers;

import it.parthenope.taxi.dto.CourseDto;
import it.parthenope.taxi.model.Course;


/**
 * Interfaccia per la conversione tra oggetti DTO (CourseDto) e oggetti modello (Course).
 */
public interface CourseMapper {

    /**
     * Converte un oggetto CourseDto in un oggetto Course.
     *
     * @param courseDto L'oggetto CourseDto da convertire.
     * @return Un oggetto Course convertito.
     */
    Course dtoToModel(CourseDto courseDto);

    /**
     * Converte un oggetto Course in un oggetto CourseDto.
     *
     * @param course L'oggetto Course da convertire.
     * @return Un oggetto CourseDto convertito.
     */
    CourseDto modelToDto(Course course);
}