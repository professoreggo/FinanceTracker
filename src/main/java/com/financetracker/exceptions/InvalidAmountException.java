package com.financetracker.exceptions;

public class InvalidAmountException extends RuntimeException{

    public InvalidAmountException(String message){
        super(message); //passing the error message to runtime Exception
    }
}
