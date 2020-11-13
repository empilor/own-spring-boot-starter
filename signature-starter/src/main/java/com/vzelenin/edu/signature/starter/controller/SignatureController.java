package com.vzelenin.edu.signature.starter.controller;

import com.vzelenin.edu.signature.starter.autoconfigure.SignatureProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Duration;

@RestController
public class SignatureController {

    private static final Logger LOGGER = LoggerFactory.getLogger(SignatureController.class);
    private final String username;
    private final Duration retentionPeriod;

    public SignatureController(SignatureProperties properties) {
        this.username = properties.getUsername();
        this.retentionPeriod = properties.getExtra().getRetentionPeriod();
        LOGGER.info("Started with 'username' - {}, 'retention period' - {}", username, retentionPeriod);
    }

    @GetMapping("/api/v1/signature")
    public String getSignature() {
        return "Best Regards,\n" + username + "\nEmail will be deleted after " + retentionPeriod;
    }
}
