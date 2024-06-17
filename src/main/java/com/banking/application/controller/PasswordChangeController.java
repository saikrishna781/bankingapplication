package com.banking.application.controller;

//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//
//@Controller
//public class PasswordController {
//
//    @GetMapping("/change-password")
//    public String changePassword() {
//        return "change-password";
//    }
//}

//
//import com.banking.application.model.PasswordChangeRequest;
//import com.banking.application.service.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//import reactor.core.publisher.Mono;
//
//@RestController
//@RequestMapping("/api")
//public class PasswordChangeController {
//
//    @Autowired
//    private UserService userService;
//
//    @PostMapping("/change-password")
//    public Mono<Void> changePassword(@RequestBody PasswordChangeRequest request) {
//        return userService.changePassword(request);
//
//    }
//
//}

import com.banking.application.model.PasswordChangeRequest;
import com.banking.application.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import reactor.core.publisher.Mono;

@Controller
public class PasswordChangeController {

    @Autowired
    private UserService userService;

    @GetMapping("/change-password")
    public String changePasswordForm(Model model) {
        model.addAttribute("passwordChangeRequest", new PasswordChangeRequest());
        return "change-password";
    }

    @PostMapping("/change-password")
    public Mono<String> changePassword(@ModelAttribute PasswordChangeRequest request, Model model) {
        return userService.changePassword(request)
                .then(Mono.just("redirect:/change-password?success"))
                .onErrorResume(e -> {
                    model.addAttribute("error", e.getMessage());
                    return Mono.just("change-password");
                });
    }
}
