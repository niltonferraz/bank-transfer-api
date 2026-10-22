package br.com.nilton.banktransfer.dto;

import java.math.BigDecimal;

public record DepositRequestDTO(
        BigDecimal amount
) {
}