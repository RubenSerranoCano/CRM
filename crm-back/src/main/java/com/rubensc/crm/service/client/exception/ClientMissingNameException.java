package com.rubensc.crm.service.client.exception;

public class ClientMissingNameException extends RuntimeException {

    public ClientMissingNameException() {
        super("Client's name is missing.");
    };
}
