package com.rubensc.crm.service.client.exception;

public class ClientMissingEmailException extends RuntimeException {

    public ClientMissingEmailException() {
        super("Client's email is missing.");
    }
}
