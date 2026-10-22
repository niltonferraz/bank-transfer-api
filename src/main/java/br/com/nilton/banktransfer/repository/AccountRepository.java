package br.com.nilton.banktransfer.repository;

import br.com.nilton.banktransfer.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AccountRepository
        extends JpaRepository<Account, UUID> {
}