package com.salma.mini_projet_pharmacie.controller;

import com.salma.mini_projet_pharmacie.model.Client;
import com.salma.mini_projet_pharmacie.model.Pharmacien;
import com.salma.mini_projet_pharmacie.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    /**
     * INSCRIPTION CLIENT
     * POST /users/register
     */
    @PostMapping("/register")
    public Client registerClient(@RequestBody Client client) {
        return userService.registerClient(client);
    }

    /**
     * AJOUT PHARMACIEN
     * POST /users/pharmacien
     */
    @PostMapping("/pharmacien")
    public Pharmacien addPharmacien(@RequestBody Pharmacien pharmacien) {
        return userService.createPharmacien(pharmacien);
    }

    /**
     * SUPPRESSION PHARMACIEN
     * DELETE /users/pharmacien/{id}
     */
    @DeleteMapping("/pharmacien/{id}")
    public void deletePharmacien(@PathVariable Long id) {
        userService.deletePharmacien(id);
    }
}
