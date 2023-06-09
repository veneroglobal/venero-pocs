package com.veneroglobal.common.exception.custom;

public class DuplicateEmailException extends RuntimeException {

    private String message;

    public DuplicateEmailException(String message){
        super();
        this.message = message;
    }
}
