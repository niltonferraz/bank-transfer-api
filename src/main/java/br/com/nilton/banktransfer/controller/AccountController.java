package br.com.nilton.banktransfer.controller;

import br.com.nilton.banktransfer.dto.AccountRequestDTO;
import br.com.nilton.banktransfer.dto.AccountResponseDTO;
import br.com.nilton.banktransfer.dto.DepositRequestDTO;
import br.com.nilton.banktransfer.dto.WithdrawRequestDTO;
import br.com.nilton.banktransfer.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.UUID;

@RestController
@RequestMapping("/accounts")
@RequiredArgsConstructor
public class AccountController {

    private final AccountService service;

    @PostMapping
    public AccountResponseDTO create(
            @RequestBody AccountRequestDTO dto) {

        return service.create(dto.customerId());
    }

    @GetMapping("/{id}/balance")
    public BigDecimal getBalance(
            @PathVariable UUID id) {

        return service.getBalance(id);
    }

    @PostMapping("/{id}/deposit")
    public AccountResponseDTO deposit(
            @PathVariable UUID id,
            @RequestBody DepositRequestDTO dto) {

        return service.deposit(
                id,
                dto.amount()
        );
    }

    @PostMapping("/{id}/withdraw")
    public AccountResponseDTO withdraw(
            @PathVariable UUID id,
            @RequestBody WithdrawRequestDTO dto) {

        return service.withdraw(
                id,
                dto.amount()
        );
    }
}