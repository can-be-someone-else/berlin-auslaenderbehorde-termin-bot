package org.example.exceptions;

public class AntiCaptchaFailed extends Exception {
    public AntiCaptchaFailed(String message) {
        super(message);
    }
}
