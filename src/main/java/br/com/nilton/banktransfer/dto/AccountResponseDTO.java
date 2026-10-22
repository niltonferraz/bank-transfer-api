package br.com.nilton.banktransfer.dto;

import java.math.BigDecimal;
import java.util.UUID;

public record AccountResponseDTO(
        UUID id,
        String agency,
        String accountNumber,
        BigDecimal balance,
        Boolean active,
        UUID customerId
) {
}