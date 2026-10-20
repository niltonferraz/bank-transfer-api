package br.com.nilton.banktransfer.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record CustomerRequestDTO(

        @NotBlank
        String name,

        @NotBlank
        String cpf,

        @Email
        @NotBlank
        String email
) {
}