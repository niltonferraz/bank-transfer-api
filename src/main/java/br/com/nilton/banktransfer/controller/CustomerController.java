package br.com.nilton.banktransfer.controller;

import br.com.nilton.banktransfer.dto.CustomerRequestDTO;
import br.com.nilton.banktransfer.dto.CustomerResponseDTO;
import br.com.nilton.banktransfer.service.CustomerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

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

    @GetMapping("/{id}")
    public CustomerResponseDTO findById(
            @PathVariable UUID id) {

        return service.findById(id);
    }

    @PutMapping("/{id}")
    public CustomerResponseDTO update(
            @PathVariable UUID id,
            @RequestBody @Valid CustomerRequestDTO dto) {

        return service.update(id, dto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(
            @PathVariable UUID id) {

        service.delete(id);
    }
}