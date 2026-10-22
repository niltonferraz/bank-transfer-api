package br.com.nilton.banktransfer.dto;

import java.math.BigDecimal;
import java.util.UUID;

public record TransferRequestDTO(
        UUID sourceAccountId,
        UUID destinationAccountId,
        BigDecimal amount
) {
}