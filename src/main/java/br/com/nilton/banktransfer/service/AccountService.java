package br.com.nilton.banktransfer.service;

import br.com.nilton.banktransfer.dto.AccountResponseDTO;
import br.com.nilton.banktransfer.entity.Account;
import br.com.nilton.banktransfer.entity.Customer;
import br.com.nilton.banktransfer.exception.CustomerNotFoundException;
import br.com.nilton.banktransfer.exception.InsufficientBalanceException;
import br.com.nilton.banktransfer.repository.AccountRepository;
import br.com.nilton.banktransfer.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import br.com.nilton.banktransfer.exception.AccountNotFoundException;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AccountService {

    private final AccountRepository accountRepository;
    private final CustomerRepository customerRepository;

    public AccountResponseDTO create(UUID customerId) {

        Customer customer =
                customerRepository.findById(customerId)
                        .orElseThrow(() ->
                                new CustomerNotFoundException(
                                        "Customer not found"));

        Account account = Account.builder()
                .agency("0001")
                .accountNumber(
                        String.valueOf(System.currentTimeMillis()))
                .balance(BigDecimal.ZERO)
                .active(true)
                .customer(customer)
                .build();

        account = accountRepository.save(account);

        return new AccountResponseDTO(
                account.getId(),
                account.getAgency(),
                account.getAccountNumber(),
                account.getBalance(),
                account.getActive(),
                customer.getId()
        );
    }

    public BigDecimal getBalance(UUID accountId) {

        Account account = accountRepository.findById(accountId)
                .orElseThrow(() ->
                        new AccountNotFoundException("Account not found"));

        return account.getBalance();
    }

    public AccountResponseDTO deposit(
            UUID id,
            BigDecimal amount) {

        Account account = accountRepository.findById(id)
                .orElseThrow(() ->
                        new AccountNotFoundException("Account not found"));

        account.setBalance(
                account.getBalance().add(amount)
        );

        account = accountRepository.save(account);

        return mapToResponse(account);
    }

    private AccountResponseDTO mapToResponse(
            Account account) {

        return new AccountResponseDTO(
                account.getId(),
                account.getAgency(),
                account.getAccountNumber(),
                account.getBalance(),
                account.getActive(),
                account.getCustomer().getId()
        );
    }

    public AccountResponseDTO withdraw(
            UUID id,
            BigDecimal amount) {

        Account account = accountRepository.findById(id)
                .orElseThrow(() ->
                        new AccountNotFoundException(
                                "Account not found"));

        if (account.getBalance().compareTo(amount) < 0) {
            throw new InsufficientBalanceException(
                    "Insufficient balance");
        }

        account.setBalance(
                account.getBalance().subtract(amount)
        );

        account = accountRepository.save(account);

        return mapToResponse(account);
    }

    @Transactional
    public void transfer(
            UUID sourceAccountId,
            UUID destinationAccountId,
            BigDecimal amount) {

        Account sourceAccount = accountRepository.findById(sourceAccountId)
                .orElseThrow(() ->
                        new AccountNotFoundException(
                                "Source account not found"));

        Account destinationAccount = accountRepository.findById(destinationAccountId)
                .orElseThrow(() ->
                        new AccountNotFoundException(
                                "Destination account not found"));

        if (sourceAccount.getBalance().compareTo(amount) < 0) {
            throw new InsufficientBalanceException(
                    "Insufficient balance");
        }

        sourceAccount.setBalance(
                sourceAccount.getBalance().subtract(amount)
        );

        destinationAccount.setBalance(
                destinationAccount.getBalance().add(amount)
        );

        accountRepository.save(sourceAccount);
        accountRepository.save(destinationAccount);
    }
}