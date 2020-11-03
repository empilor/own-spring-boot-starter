package com.vzelenin.edu.signature.starter.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SignatureController {

    @GetMapping("/api/v1/signature")
    public String getSignature() {
        return "Best Regards";
    }
}
