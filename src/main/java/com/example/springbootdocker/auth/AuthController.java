package com.example.springbootdocker.auth;


import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService service;

    @PostMapping("/register")
    public ResponseEntity<AuthResponse> register(@RequestBody RegisterRequest request){
        AuthResponse res = service.register(request);
        return ResponseEntity.ok(res);
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody  LoginRequest request){
        AuthResponse res = service.login(request);
        return ResponseEntity.ok(res);
    }

    @PreAuthorize("hasRole('ROLE_PATIENT')")
    @GetMapping("/patient-test")
    public String patientSecure(){
        return "Hello from secure endpoint for patient";
    }



    @PreAuthorize("hasRole('ROLE_DOCTOR')")
    @GetMapping("/doctor-test")
    public String doctorSecure(){
        return "Hello from secure endpoint for doctor";
    }

    @PreAuthorize("hasAnyRole('ROLE_PATIENT','ROLE_DOCTOR')")
    @GetMapping("/doctor-patient-test")
    public String doctorPatientSecure(){
        return "Hello from secure endpoint for doctor and patient";
    }

}
