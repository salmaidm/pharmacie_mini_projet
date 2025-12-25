package com.salma.mini_projet_pharmacie.pharmacie.repository;

import com.salma.mini_projet_pharmacie.pharmacie.model.Fourniture;
import com.salma.mini_projet_pharmacie.pharmacie.model.FournitureKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FournitureRepository extends JpaRepository<Fourniture, FournitureKey> {
}