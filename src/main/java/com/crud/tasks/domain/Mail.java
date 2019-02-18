package com.crud.tasks.domain;

import lombok.Getter;

@Getter
public class Mail {
    private String mailTo;
    private String subject;
    private String message;
    private String toCc;

    public Mail(final String mailTo, final String subject, final String message, String toCc) {
        this.mailTo = mailTo;
        this.subject = subject;
        this.message = message;
        this.toCc = toCc;
    }
}
