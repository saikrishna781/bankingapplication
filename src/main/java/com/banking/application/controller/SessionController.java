package com.banking.application.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SessionController {

    @GetMapping("login")
    public String sessionExpired() {
        return "account-statement";
    }
}
