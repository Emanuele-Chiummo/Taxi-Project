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

/**
 * Controller che gestisce le operazioni relative ai corsi taxi.
 */

@CrossOrigin(
        origins = "*",
        allowedHeaders = {"*"})

@RestController
public class CourseController {
	
	 /**
     * Servizio per la gestione dei corsi taxi.
     */

	@Autowired
	CourseService courseService;
	
	/**
     * Mapper per la conversione tra oggetti Course e CourseDto.
     */
	
	@Autowired
	CourseMapper courseMapper;
	
	/**
     * Endpoint per ottenere la lista di tutti i corsi taxi.
     *
     * @return Lista di oggetti CourseDto.
     */

	@GetMapping("/api/course")
	public List<CourseDto> getAllCourse(){

		return courseService.getAllCourse();
	}
	
	/**
     * Endpoint per l'aggiornamento di un corso taxi esistente.
     *
     * @param id        L'ID del corso taxi da aggiornare.
     * @param courseDto Oggetto CourseDto contenente le nuove informazioni del corso.
     * @return ResponseEntity contenente l'oggetto CourseDto aggiornato e lo stato di risposta OK, oppure NOT_FOUND se il corso non esiste.
     */
	
	@PutMapping("/api/course/{id}")
    public ResponseEntity<CourseDto> updateCourse(@PathVariable Integer id, @RequestBody CourseDto courseDto) {

        if (!courseService.courseExist(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        courseService.updateCourse(courseDto);

        return new ResponseEntity<>(courseDto, HttpStatus.OK);
    }
	
	/**
     * Endpoint per la creazione di un nuovo corso taxi.
     *
     * @param courseDto Oggetto CourseDto contenente le informazioni del nuovo corso.
     * @return ResponseEntity contenente l'oggetto CourseDto creato e lo stato di risposta CREATED.
     */
	
	@PostMapping("/api/course")
	public ResponseEntity<CourseDto> createRequest(@RequestBody CourseDto courseDto) {

		courseService.createCourse(courseDto);
		return new ResponseEntity<CourseDto>(courseDto, HttpStatus.CREATED);
		
	}
	
	/**
     * Endpoint per disattivare un corso taxi.
     *
     * @param id L'ID del corso taxi da disattivare.
     * @return ResponseEntity con stato OK se l'operazione è riuscita.
     */
	
	@PutMapping("/api/course/deactivate/{id}")
	public ResponseEntity<Void> deactivateCourse(@PathVariable Integer id) {
	    courseService.deactivateCourse(id);
	    return ResponseEntity.ok().build();
	}
	
	/**
     * Endpoint per verificare l'esistenza di un corso taxi con le posizioni specificate.
     *
     * @param startLocation Posizione di partenza del corso taxi.
     * @param endLocation   Posizione di destinazione del corso taxi.
     * @return ResponseEntity contenente un booleano che indica se il corso esiste con le posizioni specificate.
     */
	
	  @GetMapping("/api/course/exists")
	    public ResponseEntity<Boolean> courseExistsWithLocations(
	            @RequestParam String startLocation,
	            @RequestParam String endLocation) {
	        boolean exists = courseService.courseExistsWithLocations(startLocation, endLocation);
	        return ResponseEntity.ok(exists);
	   }
	




}