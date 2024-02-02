package com.example.neww.services;

import org.springframework.stereotype.Service;
import com.example.neww.repositories.InterfaceUserRepository;
import com.example.neww.model.User;

import java.util.List;

@Service
public class AuthorizationService {
    private final InterfaceUserRepository interfaceUserRepository;
    public AuthorizationService(InterfaceUserRepository interfaceUserRepository) {
        this.interfaceUserRepository = interfaceUserRepository;
    }
    public String Authorization(String username, String password) {
        List<User> listUser = interfaceUserRepository.findPost(username, password);

        if (listUser.isEmpty()) return "not";
        else return listUser.get(0).getPost();
    }
}
