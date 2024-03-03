package com.admazsshipping.domain.ports.interfaces;

public interface EmailSenderServicePort {
    void sendEmail(String to, String subject, String body);
}
