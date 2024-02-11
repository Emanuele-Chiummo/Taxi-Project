package it.parthenope.taxi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import it.parthenope.taxi.dto.TaxiDto;
import it.parthenope.taxi.services.TaxiService;

/**
 * Controller che gestisce le operazioni relative ai taxi.
 */

@CrossOrigin(
        origins = "*",
        allowedHeaders = {"*"})
@RestController
public class TaxiController {
	
	/**
     * Servizio per la gestione dei taxi.
     */
	
	@Autowired
	TaxiService taxiService;
	
	/**
     * Endpoint per la creazione di un nuovo taxi.
     *
     * @param taxiDto Oggetto TaxiDto contenente le informazioni del nuovo taxi.
     * @return ResponseEntity contenente l'oggetto TaxiDto creato e lo stato di risposta CREATED.
     */

	
	@PostMapping("/api/taxi")
	public ResponseEntity<TaxiDto> createTaxi(@RequestBody TaxiDto taxiDto) {

		taxiService.createTaxi(taxiDto);
		return new ResponseEntity<TaxiDto>(taxiDto, HttpStatus.CREATED);
	}
	
	/**
     * Endpoint per ottenere la lista di tutti i taxi.
     *
     * @return Lista di oggetti TaxiDto rappresentanti i taxi.
     */
	
	@GetMapping("/api/taxi")
	public List<TaxiDto> getAllTaxi(){
		
		return taxiService.getAllTaxi();
	}
	
	/**
     * Endpoint per ottenere l'ID di un taxi dato l'ID del suo autista.
     *
     * @param driverId L'ID dell'autista di cui si vuole ottenere l'ID del taxi associato.
     * @return ResponseEntity contenente l'ID del taxi e lo stato di risposta OK, oppure NOT_FOUND se non esiste un taxi associato all'autista.
     */
	
	
	@GetMapping("/api/taxi/{driverId}")
    public ResponseEntity<Integer> getTaxiIdByDriverId(@PathVariable Integer driverId) {

		Integer taxiId = taxiService.getTaxiIdByDriverId(driverId);

        if (taxiId != null) {
            return new ResponseEntity<>(taxiId, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
	
	/**
     * Endpoint per ottenere le informazioni di un taxi dato il suo ID.
     *
     * @param taxiId L'ID del taxi di cui si vogliono ottenere le informazioni.
     * @return ResponseEntity contenente l'oggetto TaxiDto e lo stato di risposta OK, oppure NOT_FOUND se il taxi non esiste.
     */
	
	@GetMapping("/api/taxi/id/{taxiId}")
	public ResponseEntity<TaxiDto> getTaxiById(@PathVariable Integer taxiId) {
	    TaxiDto taxiDto = taxiService.getTaxiById(taxiId);

	    if (taxiDto != null) {
	        return new ResponseEntity<>(taxiDto, HttpStatus.OK);
	    } else {
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	}
	
	/**
     * Endpoint per verificare se un autista possiede un taxi.
     *
     * @param driverId L'ID dell'autista di cui si vuole verificare la presenza di un taxi.
     * @return ResponseEntity contenente un booleano che indica se l'autista possiede un taxi e lo stato di risposta OK.
     */
	
	@GetMapping("/api/taxi/hasTaxi/{driverId}")
    public ResponseEntity<Boolean> checkIfUserHasTaxi(@PathVariable Integer driverId) {
        boolean hasTaxi = taxiService.checkIfUserHasTaxi(driverId);
        return ResponseEntity.ok(hasTaxi);
    }
	
	/**
     * Endpoint per l'aggiornamento delle informazioni di un taxi esistente.
     *
     * @param id       L'ID del taxi da aggiornare.
     * @param taxiDto  Oggetto TaxiDto contenente le nuove informazioni del taxi.
     * @return ResponseEntity contenente l'oggetto TaxiDto aggiornato e lo stato di risposta OK, oppure NOT_FOUND se il taxi non esiste.
     */
	
	@PutMapping("/api/taxi/{id}")
    public ResponseEntity<TaxiDto> updateTaxi(@PathVariable Integer id, @RequestBody TaxiDto taxiDto) {

        if (!taxiService.taxiExists(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        taxiDto.setId(id);
        taxiService.updateTaxi(taxiDto);

        return new ResponseEntity<>(taxiDto, HttpStatus.OK);
    }
	
	/**
     * Endpoint per disattivare un taxi.
     *
     * @param id L'ID del taxi da disattivare.
     * @return ResponseEntity con stato OK se l'operazione è riuscita.
     */
	
	@PutMapping("/api/taxi/deactivate/{id}")
	public ResponseEntity<Void> deactivateTaxi(@PathVariable Integer id) {
	    taxiService.deactivateTaxi(id);
	    return ResponseEntity.ok().build();
	}
	
	
	


}
