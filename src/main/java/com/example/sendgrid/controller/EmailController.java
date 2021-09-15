package com.example.sendgrid.controller;

import com.example.sendgrid.entity.EmailRequest;
import com.example.sendgrid.service.EmailService;
import com.sendgrid.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by rakib
 * Date: 2021-07-31
 * Projekt: sendgrid
 */
@RestController
public class EmailController {
    @Autowired
    private EmailService emailService;

    @PostMapping("/sendmail")
    public ResponseEntity<String> sendmail(@RequestBody EmailRequest emailRequest) {
        Response response = emailService.sendmail(emailRequest);
        if (response.getStatusCode() == 200 || response.getStatusCode() == 202)
            return new ResponseEntity<>("Mail send successful", HttpStatus.OK);
        return new ResponseEntity<>("Mail send failed", HttpStatus.NOT_FOUND);
    }

    @GetMapping("viewkey/log")
    public String log() {
        return "api key"+ System.getenv("SENDGRID_API_KEY");
    }
}
