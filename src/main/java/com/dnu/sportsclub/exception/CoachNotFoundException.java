package com.dnu.sportsclub.exception;

public class CoachNotFoundException extends RuntimeException {
    public CoachNotFoundException(String message) {
        super(message);
    }

    public CoachNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}