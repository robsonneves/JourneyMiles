package com.journeymiles.service;

public class PersistenceException extends Exception {
    public PersistenceException(String msg, Throwable e) {
        super(msg + " - " + e );
    }
}
