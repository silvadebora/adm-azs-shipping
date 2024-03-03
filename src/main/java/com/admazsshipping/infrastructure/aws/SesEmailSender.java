package com.admazsshipping.infrastructure.aws;

import com.admazsshipping.application.adapters.EmailSenderGateway;
import com.admazsshipping.domain.Shipment;
import com.admazsshipping.domain.dto.EmailRequest;
import com.admazsshipping.infrastructure.adapters.exceptions.EmailServiceException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailService;
import com.amazonaws.services.simpleemail.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SesEmailSender implements EmailSenderGateway {

    @Autowired
    private AmazonSimpleEmailService amazonSimpleEmailService;


    @Override
    public void sendEmail(EmailRequest emailMessage) {
        SendEmailRequest request = new SendEmailRequest()
                .withSource("silvadeborafisio@gmail.com")
                .withDestination(new Destination().withToAddresses(emailMessage.to()))
                .withMessage(new Message()
                        .withSubject(new Content(emailMessage.subject()))
                        .withBody(new Body().withText(new Content(emailMessage.body())))
                );
        try{
            this.amazonSimpleEmailService.sendEmail(request);
        }catch (AmazonServiceException exception){
            throw new EmailServiceException("Failure while sending email", exception);
        }
    }

    @Override
    public EmailRequest emailMessage(Shipment shipment){
        String to = shipment.getReceiver();
        String subject = "Novo envio registrado - A caminho!";
        String body = "Olá, " + to + "!\n\n" +
                "Gostaríamos de informar que um novo envio foi registrado e está a caminho.\n" +
                "ID do Envio: " + shipment.getId() + "\n" +
                "Nome do remetente: " + shipment.getSender().getName() + "\n" +
                "Email do remetente: " + shipment.getSender().getEmail() + "\n" +
                "Origem: " + shipment.getOrigin() + "\n" +
                "Destino: " + shipment.getDestination().getCity() +
                " - " + shipment.getDestination().getStreet() +
                ", " + shipment.getDestination().getNumber() + "\n\n" +
                "Atenciosamente,\nEquipe de Suporte";
        EmailRequest request = new EmailRequest(to, subject, body);
        return request;
    }
}
