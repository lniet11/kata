package com.cine.kata.service;

import org.springframework.stereotype.Service;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailService;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailServiceClient;
import com.amazonaws.services.simpleemail.model.Body;
import com.amazonaws.services.simpleemail.model.Content;
import com.amazonaws.services.simpleemail.model.Destination;
import com.amazonaws.services.simpleemail.model.Message;
import com.amazonaws.services.simpleemail.model.SendEmailRequest;
import com.amazonaws.services.simpleemail.model.SendEmailResult;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;

@Service
@Getter
@Setter
public class EmailService {

    @Value("${aws.accessKeyId}")
    private String awsAccessKeyId;

    @Value("${aws.secretAccessKey}")
    private String awsSecretAccessKey;

    @Value("${aws.region}")
    private String awsRegion;
    private String destinatario="risithas@gmail.com";

    // Configura el cliente SES
    private AmazonSimpleEmailService getClient() {
        BasicAWSCredentials credentials = new BasicAWSCredentials(awsAccessKeyId, awsSecretAccessKey);
        return AmazonSimpleEmailServiceClient.builder()
                .withRegion(awsRegion)
                .withCredentials(new AWSStaticCredentialsProvider(credentials))
                .build();
    }

    // Método para enviar el correo
    public void enviarCorreo( String asunto, String cuerpo) {
        try {
            AmazonSimpleEmailService client = getClient();

            // Crear el mensaje
            SendEmailRequest request = new SendEmailRequest()
                    .withSource("lauraalejandranietop@gmail.com") 
                    .withDestination(new Destination().withToAddresses(destinatario))
                    .withMessage(new Message()
                            .withSubject(new Content(asunto))
                            .withBody(new Body().withText(new Content(cuerpo))));

            // Enviar el correo
            SendEmailResult response = client.sendEmail(request);
            System.out.println("Correo enviado con éxito: " + response.getMessageId());

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error enviando correo: " + e.getMessage());
        }
    }
}
