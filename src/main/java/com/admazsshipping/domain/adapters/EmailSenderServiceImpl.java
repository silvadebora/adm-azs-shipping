package com.admazsshipping.domain.adapters;

import com.admazsshipping.application.adapters.EmailSenderGateway;
import com.admazsshipping.domain.ports.interfaces.EmailSenderServicePort;

public class EmailSenderServiceImpl implements EmailSenderServicePort {

    private final EmailSenderGateway emailSenderGateway;

    public EmailSenderServiceImpl(EmailSenderGateway emailSenderGateway) {
        this.emailSenderGateway = emailSenderGateway;
    }

    @Override
    public void sendEmail(String to, String subject, String body) {
        this.emailSenderGateway.sendEmail(to, subject, body);
    }
}
