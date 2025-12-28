package com.salma.mini_projet_pharmacie.repository;

import com.salma.mini_projet_pharmacie.model.Ordonnance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdonnanceRepository extends JpaRepository<Ordonnance, Integer> {
}
