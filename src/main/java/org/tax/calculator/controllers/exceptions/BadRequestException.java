package org.tax.calculator.controllers.exceptions;

public class BadRequestException extends RuntimeException
{
    public BadRequestException(String message){
        super(message);
    }
}
