package it.parthenope.taxi.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController; // Aggiungi questa importazione

import it.parthenope.taxi.dto.DriverDto;
import it.parthenope.taxi.services.AuthService;

@RestController 
public class AuthController {
    
    @Autowired
    private AuthService authService;

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
}
