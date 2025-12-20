package com.salma.mini_projet_pharmacie.service;

import com.salma.mini_projet_pharmacie.model.User;
import com.salma.mini_projet_pharmacie.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;

    // authentification simple (sans hash pour l’instant)
    public User login(String email, String password) {

        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Utilisateur introuvable"));

        if (!user.getPassword().equals(password)) {
            throw new RuntimeException("Mot de passe incorrect");
        }

        return user;
    }
}
