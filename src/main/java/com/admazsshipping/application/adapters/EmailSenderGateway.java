package com.admazsshipping.application.adapters;

public interface EmailSenderGateway {

    void sendEmail(String to, String subject, String body);
}
