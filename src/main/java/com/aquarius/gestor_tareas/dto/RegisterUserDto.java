package com.aquarius.gestor_tareas.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class RegisterUserDto {
    private String email;

    private String password;
    private String firstName;
    private String lastName;
    private LocalDateTime birthDate;
}
