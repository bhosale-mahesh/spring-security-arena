package com.mb.formlogin.contoller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FormController {

    @GetMapping("/")
    public String home() {
        return "Hello!!! 😁";
    }

    @GetMapping("/public")
    public String publicPage() {
        return "Welcome to public page!!! 🥱";
    }

    @GetMapping("/private")
    public String privatePage() {
        return "Welcome to private page!!! 🤫";
    }
}
