package com.rubensc.crm.service.client.exception;

public class ClientMissingTinException  extends RuntimeException{
    public ClientMissingTinException(){
        super("Client's TIN is missing.");
    };
}