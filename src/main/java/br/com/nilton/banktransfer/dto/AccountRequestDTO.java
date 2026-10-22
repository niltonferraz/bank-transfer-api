package br.com.nilton.banktransfer.dto;

import java.util.UUID;

public record AccountRequestDTO(
        UUID customerId
) {
}