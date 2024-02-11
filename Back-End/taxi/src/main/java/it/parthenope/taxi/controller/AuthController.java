package it.parthenope.taxi.controller;

import java.util.List;


import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController; // Aggiungi questa importazione

import it.parthenope.taxi.dto.CourseDto;
import it.parthenope.taxi.dto.DriverDto;
import it.parthenope.taxi.services.AuthService;
import it.parthenope.taxi.services.UserService;

/**
 * Controller che gestisce le operazioni di autenticazione e gestione degli utenti.
 */


@CrossOrigin(
        origins = "*",
        allowedHeaders = {"*"})

@RestController 
public class AuthController {
    
	/**
     * Servizio di autenticazione.
     */
	
    @Autowired
    private AuthService authService;
    
    /**
     * Servizio per la gestione degli utenti.
     */
    
    @Autowired
    private UserService userService;
    
    /**
     * Endpoint per l'autenticazione dell'utente.
     *
     * @param credentials Le credenziali dell'utente (username e password) fornite nel corpo della richiesta.
     * @return ResponseEntity contenente l'oggetto DriverDto se l'autenticazione è riuscita, altrimenti restituisce una risposta con stato UNAUTHORIZED e un messaggio di errore.
     */

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/api/login")
    public ResponseEntity<?> authenticate(@RequestBody Map<String, String> credentials) {
        String username = credentials.get("username");
        String password = credentials.get("password");

        DriverDto driverDto = authService.authenticateUser(username, password);

        if (driverDto != null) {
            
            return ResponseEntity.ok(driverDto);
        } else {
            
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
        }
    }
    
    /**
     * Endpoint per ottenere la lista di tutti gli utenti.
     *
     * @return ResponseEntity contenente la lista di oggetti DriverDto.
     */
    
 


    @GetMapping("/api/user")
    public ResponseEntity<List<DriverDto>> getAllUsers() {
        List<DriverDto> users = userService.getAllUsers();

        return ResponseEntity.ok(users);
    }
    
    /**
     * Endpoint per ottenere la lista di tutti i tassisti.
     *
     * @return ResponseEntity contenente la lista di oggetti DriverDto corrispondenti ai tassisti.
     */
    
    @GetMapping("/api/user/tassisti")  
    public ResponseEntity<List<DriverDto>> getTassisti() {
        List<DriverDto> tassisti = userService.getTassisti("tassista");  

        return ResponseEntity.ok(tassisti);
    }
    
    /**
     * Endpoint per la creazione di un nuovo utente.
     *
     * @param driverDto Oggetto DriverDto contenente le informazioni del nuovo utente.
     * @return ResponseEntity contenente l'oggetto DriverDto creato e lo stato di risposta CREATED.
     */
    
    @PostMapping("/api/user")
	public ResponseEntity<DriverDto> createRequest(@RequestBody DriverDto driverDto) {

    	userService.createUser(driverDto);
		return new ResponseEntity<DriverDto>(driverDto, HttpStatus.CREATED);
		
	}
    
    /**
     * Endpoint per l'aggiornamento di un utente esistente.
     *
     * @param id        L'ID dell'utente da aggiornare.
     * @param driverDto Oggetto DriverDto contenente le nuove informazioni dell'utente.
     * @return ResponseEntity contenente l'oggetto DriverDto aggiornato e lo stato di risposta OK, oppure NOT_FOUND se l'utente non esiste.
     */
    
    @PutMapping("/api/user/{id}")
    public ResponseEntity<DriverDto> updateUser(@PathVariable Integer id, @RequestBody DriverDto driverDto) {

        if (!userService.userExist(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        userService.updateUser(driverDto);

        return new ResponseEntity<>(driverDto, HttpStatus.OK);
    }
    
    /**
     * Endpoint per disattivare un tassista.
     *
     * @param id L'ID del tassista da disattivare.
     * @return ResponseEntity con stato OK se l'operazione è riuscita.
     */
    
    @PutMapping("/api/user/deactivate/{id}")
    public ResponseEntity<Void> deactivateDriver(@PathVariable Integer id) {
        userService.deactivateDriver(id);
        return ResponseEntity.ok().build();
    }
    
    
}
