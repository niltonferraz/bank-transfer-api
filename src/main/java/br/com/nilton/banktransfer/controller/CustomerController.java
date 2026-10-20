package br.com.nilton.banktransfer.controller;

import br.com.nilton.banktransfer.dto.CustomerRequestDTO;
import br.com.nilton.banktransfer.dto.CustomerResponseDTO;
import br.com.nilton.banktransfer.service.CustomerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService service;

    @PostMapping
    public CustomerResponseDTO create(
            @RequestBody @Valid CustomerRequestDTO dto) {

        return service.create(dto);
    }

    @GetMapping
    public List<CustomerResponseDTO> findAll() {

        return service.findAll();
    }
}