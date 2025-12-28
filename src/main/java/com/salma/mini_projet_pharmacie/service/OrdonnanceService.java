package com.pharmacie.service;

import com.pharmacie.model.Ordonnance;
import com.pharmacie.repository.OrdonnanceRepository;
import org.springframework.stereotype.Service;

@Service
public class OrdonnanceService {

    private final OrdonnanceRepository ordonnanceRepository;

    public OrdonnanceService(OrdonnanceRepository ordonnanceRepository) {
        this.ordonnanceRepository = ordonnanceRepository;
    }

    public Ordonnance enregistrerOrdonnance(Ordonnance ordonnance) {
        return ordonnanceRepository.save(ordonnance);
    }

    // Vérification simple (logique métier minimale)
    public boolean verifierOrdonnance(Ordonnance ordonnance) {
        return ordonnance != null && ordonnance.getNomMedecin() != null;
    }
}
