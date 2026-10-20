package br.com.nilton.banktransfer.repository;

import br.com.nilton.banktransfer.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CustomerRepository
        extends JpaRepository<Customer, UUID> {

    boolean existsByCpf(String cpf);

    boolean existsByEmail(String email);
}