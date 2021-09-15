package com.example.sendgrid.service;

import com.example.sendgrid.entity.EmailRequest;
import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Content;
import com.sendgrid.helpers.mail.objects.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * Created by rakib
 * Date: 2021-07-31
 * Projekt: sendgrid
 */
@Service
public class EmailService {
    @Autowired
    private SendGrid sendGrid;

    private Email myemail = new Email("noreply.hakimlivs@gmail.com");


    public Response sendmail(EmailRequest emailRequest) {

        Mail mail = new Mail(myemail, emailRequest.getSubject(), new Email(emailRequest.getTo()), new Content("text/plain", emailRequest.getBody()));
        mail.setReplyTo(myemail);
        Request request = new Request();
        Response response = null;
        try {
            request.setMethod(Method.POST);
            request.setEndpoint("mail/send");
            request.setBody(mail.build());
            response = this.sendGrid.api(request);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return response;
    }
}