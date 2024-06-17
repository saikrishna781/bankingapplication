package com.banking.application.service;


import com.banking.application.model.PasswordChangeRequest;
import com.banking.application.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public Mono<Void> changePassword(PasswordChangeRequest request) {
        return userRepository.updatePassword(request.getUsername(), request.getNewLoginPassword(), request.getNewTransactionPassword());
    }
}

