package br.com.nilton.banktransfer.dto;

import java.util.UUID;

public record CustomerResponseDTO(
        UUID id,
        String name,
        String cpf,
        String email
) {
}