package com.example.springbootdocker.auth;


import com.example.springbootdocker.auth.config.JwtService;
import com.example.springbootdocker.entitys.Account;
import com.example.springbootdocker.repos.IAccountRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final PasswordEncoder passwordEncoder;
    private final IAccountRepo repository;
    private final JwtService jwtService;

    public AuthResponse register(RegisterRequest request){
        var account = new Account();
        account.setName(request.getName());
        account.setEmail(request.getEmail());
        account.setPassword(passwordEncoder.encode(request.getPassword()));
        account.setRole(request.getRole());

        repository.save(account);

        String jwtToken = jwtService.generateToken(account);
        return new AuthResponse(jwtToken);
    }

    public AuthResponse login(LoginRequest request){
        return null;
    }
}
