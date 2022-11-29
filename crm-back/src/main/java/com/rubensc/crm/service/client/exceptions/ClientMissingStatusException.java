package com.rubensc.crm.service.client.exceptions;

public class ClientMissingStatusException extends RuntimeException{

    public ClientMissingStatusException(String message){
        super(message);
    };
}
