package br.com.nilton.banktransfer.service;

import br.com.nilton.banktransfer.dto.CustomerRequestDTO;
import br.com.nilton.banktransfer.dto.CustomerResponseDTO;
import br.com.nilton.banktransfer.entity.Customer;
import br.com.nilton.banktransfer.exception.CustomerNotFoundException;
import br.com.nilton.banktransfer.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository repository;

    public CustomerResponseDTO create(CustomerRequestDTO dto) {

        Customer customer = Customer.builder()
                .name(dto.name())
                .cpf(dto.cpf())
                .email(dto.email())
                .build();

        customer = repository.save(customer);

        return mapToResponse(customer);
    }

    public List<CustomerResponseDTO> findAll() {

        return repository.findAll()
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    public CustomerResponseDTO findById(UUID id) {

        Customer customer = repository.findById(id)
                .orElseThrow(() ->
                        new CustomerNotFoundException(
                                "Customer not found"));

        return mapToResponse(customer);
    }

    public CustomerResponseDTO update(
            UUID id,
            CustomerRequestDTO dto) {

        Customer customer = repository.findById(id)
                .orElseThrow(() ->
                        new CustomerNotFoundException(
                                "Customer not found"));

        customer.setName(dto.name());
        customer.setCpf(dto.cpf());
        customer.setEmail(dto.email());

        customer = repository.save(customer);

        return mapToResponse(customer);
    }

    public void delete(UUID id) {

        Customer customer = repository.findById(id)
                .orElseThrow(() ->
                        new CustomerNotFoundException(
                                "Customer not found"));

        repository.delete(customer);
    }

    private CustomerResponseDTO mapToResponse(Customer customer) {

        return new CustomerResponseDTO(
                customer.getId(),
                customer.getName(),
                customer.getCpf(),
                customer.getEmail()
        );
    }
}