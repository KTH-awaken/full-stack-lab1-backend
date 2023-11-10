package com.example.springbootdocker.auth;


import com.example.springbootdocker.auth.config.JwtService;
import com.example.springbootdocker.entitys.Account;
import com.example.springbootdocker.repos.IAccountRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final PasswordEncoder passwordEncoder;
    private final IAccountRepo repository;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthResponse register(RegisterRequest request){
        var account = new Account();
        account.setFirstName(request.getFirstName());
        account.setLastName(request.getLastName());
        account.setEmail(request.getEmail());
        account.setPassword(passwordEncoder.encode(request.getPassword()));
        account.setRole(request.getRole());

        repository.save(account);

        String jwtToken = jwtService.generateToken(account);
        return new AuthResponse(jwtToken);
    }

    public AuthResponse login(LoginRequest request){
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );
        var account = repository.findByEmail(request.getEmail());

        String jwtToken = jwtService.generateToken(account);
        return new AuthResponse(jwtToken);
    }
}
