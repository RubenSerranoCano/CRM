package com.rubensc.crm.service.client.exception;

public class ClientInvalidStatusException extends RuntimeException {

    public ClientInvalidStatusException() {
        super("The client's status .");
    }
}
