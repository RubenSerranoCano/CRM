package com.rubensc.crm.service.client.exception;

public class ClientMissingStatusException extends RuntimeException{

    public ClientMissingStatusException(){
        super("Client's status is missing.");
    };
}
