package com.salma.mini_projet_pharmacie.repository;

import com.salma.mini_projet_pharmacie.model.Commande;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommandeRepository extends JpaRepository<Commande, Long> {
}
