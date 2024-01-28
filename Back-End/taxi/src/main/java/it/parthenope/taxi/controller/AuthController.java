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

@CrossOrigin(
        origins = "*",
        allowedHeaders = {"*"})

@RestController 
public class AuthController {
    
    @Autowired
    private AuthService authService;
    
    @Autowired
    private UserService userService;

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
    
 


    @GetMapping("/api/user")
    public ResponseEntity<List<DriverDto>> getAllUsers() {
        List<DriverDto> users = userService.getAllUsers();

        return ResponseEntity.ok(users);
    }
    
    @GetMapping("/api/user/tassisti")  
    public ResponseEntity<List<DriverDto>> getTassisti() {
        List<DriverDto> tassisti = userService.getTassisti("tassista");  

        return ResponseEntity.ok(tassisti);
    }
    
    @PostMapping("/api/user")
	public ResponseEntity<DriverDto> createRequest(@RequestBody DriverDto driverDto) {

    	userService.createUser(driverDto);
		return new ResponseEntity<DriverDto>(driverDto, HttpStatus.CREATED);
		
	}
    
    @PutMapping("/api/user/{id}")
    public ResponseEntity<DriverDto> updateUser(@PathVariable Integer id, @RequestBody DriverDto driverDto) {

        if (!userService.userExist(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        userService.updateUser(driverDto);

        return new ResponseEntity<>(driverDto, HttpStatus.OK);
    }
    
    @PutMapping("/api/user/deactivate/{id}")
    public ResponseEntity<Void> deactivateDriver(@PathVariable Integer id) {
        userService.deactivateDriver(id);
        return ResponseEntity.ok().build();
    }
    
    
}
