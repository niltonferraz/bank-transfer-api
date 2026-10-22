package br.com.nilton.banktransfer.exception;

public class InsufficientBalanceException
        extends RuntimeException {

    public InsufficientBalanceException(
            String message) {

        super(message);
    }
}