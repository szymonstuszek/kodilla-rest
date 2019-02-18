package com.crud.tasks.domain;


public class Mail {
    private final String mailTo;
    private final String subject;
    private final String message;
    private String toCc;

    public Mail(String mailTo, String subject, String message, String toCc) {
        this.mailTo = mailTo;
        this.subject = subject;
        this.message = message;
        this.toCc = toCc;
    }

    public Mail(String mailTo, String subject, String message) {
        this.mailTo = mailTo;
        this.subject = subject;
        this.message = message;
    }

    public String getMailTo() {
        return mailTo;
    }

    public String getSubject() {
        return subject;
    }

    public String getMessage() {
        return message;
    }

    public String[] getToCc() {
        return toCc != null ? new String[]{toCc} : new String[0];
    }
}
