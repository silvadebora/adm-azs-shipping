package com.admazsshipping.domain.ports.interfaces;

import com.admazsshipping.domain.Shipment;
import com.admazsshipping.domain.dto.EmailRequest;

public interface EmailSenderServicePort {
    void sendEmail(EmailRequest request);

    EmailRequest emailMessage(Shipment shipment);
}
