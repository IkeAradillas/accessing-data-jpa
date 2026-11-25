package com.example.accessingdatajpa.expections;

public class EmailNotValidException extends Throwable {
    public EmailNotValidException(String elEmailNoEsValido) {
        super(elEmailNoEsValido);
    }
}
