package com.salma.mini_projet_pharmacie.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "client")
public class Client extends User {

    // Constructeur vide requis par JPA
    public Client() {
        super();
    }
}
