package com.rubensc.crm.presentation;

import com.rubensc.crm.service.client.exception.ClientMissingEmailException;
import com.rubensc.crm.service.client.exception.ClientMissingNameException;
import com.rubensc.crm.service.client.exception.ClientMissingStatusException;
import com.rubensc.crm.service.client.exception.ClientMissingTinException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ClientControllerAdvice {

    @ResponseBody
    @ExceptionHandler(ClientMissingTinException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    String clientMissingTinException(ClientMissingTinException e) {
        return e.getMessage();
    }

    @ResponseBody
    @ExceptionHandler(ClientMissingNameException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    String clientMissingNameException(ClientMissingNameException e) {
        return e.getMessage();
    }

    @ResponseBody
    @ExceptionHandler(ClientMissingEmailException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    String clientMissingEmailException(ClientMissingEmailException e) {
        return e.getMessage();
    }

    @ResponseBody
    @ExceptionHandler(ClientMissingStatusException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    String clientMissingStatusException(ClientMissingStatusException e) {
        return e.getMessage();
    }
}
