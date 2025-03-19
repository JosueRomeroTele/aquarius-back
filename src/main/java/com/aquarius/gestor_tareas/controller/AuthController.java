package com.aquarius.gestor_tareas.controller;

import com.aquarius.gestor_tareas.dto.LoginResponse;
import com.aquarius.gestor_tareas.dto.LoginUserDto;
import com.aquarius.gestor_tareas.dto.RegisterUserDto;
import com.aquarius.gestor_tareas.model.UserTask;
import com.aquarius.gestor_tareas.repository.UserTaskRepository;
import com.aquarius.gestor_tareas.service.AuthenticationService;
import com.aquarius.gestor_tareas.service.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final JwtService jwtService;

    private final AuthenticationService authenticationService;

    @PostMapping("/signup")
    public ResponseEntity<UserTask> register(@RequestBody RegisterUserDto registerUserDto) throws Exception {
        UserTask registeredUser = authenticationService.signUp(registerUserDto);

        return ResponseEntity.ok(registeredUser);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> authenticate(@RequestBody LoginUserDto loginUserDto) {
        UserTask authenticatedUser = authenticationService.authenticate(loginUserDto);

        String jwtToken = jwtService.generateToken(authenticatedUser);

        LoginResponse loginResponse = new LoginResponse();
        loginResponse.setToken(jwtToken);
        loginResponse.setExpiresIn(jwtService.getExpirationTime());

        return ResponseEntity.ok(loginResponse);
    }

}
