package com.admazsshipping.domain.adapters;

import com.admazsshipping.application.adapters.EmailSenderGateway;
import com.admazsshipping.domain.Shipment;
import com.admazsshipping.domain.dto.EmailRequest;
import com.admazsshipping.domain.ports.interfaces.EmailSenderServicePort;

public class EmailSenderServiceImpl implements EmailSenderServicePort {

    private final EmailSenderGateway emailSenderGateway;

    public EmailSenderServiceImpl(EmailSenderGateway emailSenderGateway) {
        this.emailSenderGateway = emailSenderGateway;
    }

    @Override
    public void sendEmail(EmailRequest request) {
        this.emailSenderGateway.sendEmail(request);
    }

    @Override
    public EmailRequest emailMessage(Shipment shipment) {
        return this.emailSenderGateway.emailMessage(shipment);
    }
}
