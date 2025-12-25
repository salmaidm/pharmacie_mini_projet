package com.salma.mini_projet_pharmacie.pharmacie.repository;

import com.salma.mini_projet_pharmacie.pharmacie.model.Fournisseur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FournisseurRepository extends JpaRepository<Fournisseur, Integer> {
}
