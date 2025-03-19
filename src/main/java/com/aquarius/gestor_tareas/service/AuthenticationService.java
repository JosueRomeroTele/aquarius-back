package com.aquarius.gestor_tareas.service;

import com.aquarius.gestor_tareas.dto.LoginUserDto;
import com.aquarius.gestor_tareas.dto.RegisterUserDto;
import com.aquarius.gestor_tareas.model.UserTask;

public interface AuthenticationService {

    UserTask signUp(RegisterUserDto input) throws Exception;

    UserTask authenticate(LoginUserDto input);

}
