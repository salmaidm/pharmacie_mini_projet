package com.salma.mini_projet_pharmacie.service;

import com.salma.mini_projet_pharmacie.model.Produit;
import com.salma.mini_projet_pharmacie.model.Vente;
import com.salma.mini_projet_pharmacie.repository.ProduitRepository;
import com.salma.mini_projet_pharmacie.repository.VenteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReportService {

    private final VenteRepository venteRepository;
    private final ProduitRepository produitRepository;

    public ReportService(VenteRepository venteRepository,
                         ProduitRepository produitRepository) {
        this.venteRepository = venteRepository;
        this.produitRepository = produitRepository;
    }

    public List<Vente> getRapportVentes() {
        return venteRepository.findAll();
    }

    public List<Produit> getRapportStock() {
        return produitRepository.findAll();
    }
}
