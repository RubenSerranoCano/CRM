package com.rubensc.crm.service.client.exception;

public class ClientMissingOpportunityException extends RuntimeException {

    public ClientMissingOpportunityException() {
        super("A client must be in at least one opportunity.");
    };
}