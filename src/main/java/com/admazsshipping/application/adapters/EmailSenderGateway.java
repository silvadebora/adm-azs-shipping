package com.admazsshipping.application.adapters;

import com.admazsshipping.domain.Shipment;
import com.admazsshipping.domain.dto.EmailRequest;

public interface EmailSenderGateway {

    void sendEmail(EmailRequest request);

    EmailRequest emailMessage(Shipment shipment);
}
