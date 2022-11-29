package com.rubensc.crm.service.client.exceptions;

public class ClientMissingTinException  extends RuntimeException{
    public ClientMissingTinException(){
        super("Client TIN is missing.");
    };
}