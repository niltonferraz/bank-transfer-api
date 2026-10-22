package br.com.nilton.banktransfer.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "accounts")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String agency;

    private String accountNumber;

    private BigDecimal balance;

    private Boolean active;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
}