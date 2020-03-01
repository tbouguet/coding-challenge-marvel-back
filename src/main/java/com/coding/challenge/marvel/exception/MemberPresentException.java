package com.coding.challenge.marvel.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT)
public class MemberPresentException extends Exception{

    public MemberPresentException(String message){
        super(message);

    }
}
