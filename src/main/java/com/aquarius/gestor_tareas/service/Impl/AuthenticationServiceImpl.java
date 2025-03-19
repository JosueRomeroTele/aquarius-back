package com.aquarius.gestor_tareas.service.Impl;

import com.aquarius.gestor_tareas.dto.LoginUserDto;
import com.aquarius.gestor_tareas.dto.RegisterUserDto;
import com.aquarius.gestor_tareas.model.UserTask;
import com.aquarius.gestor_tareas.repository.UserTaskRepository;
import com.aquarius.gestor_tareas.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {

    private final UserTaskRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    private final AuthenticationManager authenticationManager;

    @Override
    public UserTask signUp(RegisterUserDto input) throws Exception {
        Optional<UserTask> findUser = userRepository.findByEmail(input.getEmail());
        if (findUser.isPresent()){
            throw new Exception("El usuario con el email " + input.getEmail() + " ya existe");
        }
        UserTask userTask = new UserTask();
        userTask.setFirstName(input.getFirstName());
        userTask.setEmail(input.getEmail());
        userTask.setLastName(input.getLastName());
        userTask.setBirthDate(input.getBirthDate());
        userTask.setPassword(passwordEncoder.encode(input.getPassword()));
        return userRepository.save(userTask);
    }

    @Override
    public UserTask authenticate(LoginUserDto input) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(input.getEmail(),input.getPassword())
        );
        return userRepository.findByEmail(input.getEmail()).orElseThrow();
    }
}
