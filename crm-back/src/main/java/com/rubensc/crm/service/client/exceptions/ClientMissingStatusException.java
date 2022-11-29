package com.rubensc.crm.service.client.exceptions;

public class ClientMissingStatusException extends RuntimeException{

    public ClientMissingStatusException(){
        super("Client status is missing.");
    };
}
