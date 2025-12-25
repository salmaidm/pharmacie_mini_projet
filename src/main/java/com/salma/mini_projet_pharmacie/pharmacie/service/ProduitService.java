package com.salma.mini_projet_pharmacie.pharmacie.service;

import com.salma.mini_projet_pharmacie.pharmacie.dto.ProduitDTO;
import com.salma.mini_projet_pharmacie.pharmacie.exception.NotFoundException;
import com.salma.mini_projet_pharmacie.pharmacie.mapper.ProduitMapper;
import com.salma.mini_projet_pharmacie.pharmacie.model.Produit;
import com.salma.mini_projet_pharmacie.pharmacie.repository.ProduitRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.salma.mini_projet_pharmacie.pharmacie.exception.GlobalExceptionHandler;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProduitService {

    private final ProduitRepository produitRepository;

    // Ajouter produit
    public ProduitDTO ajouterProduit(ProduitDTO dto) {
        Produit p = ProduitMapper.toEntity(dto);
        Produit saved = produitRepository.save(p);
        return ProduitMapper.toDTO(saved);
    }

    // Modifier produit
    public ProduitDTO modifierProduit(Integer id, ProduitDTO dto) {
        Produit produit = produitRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Produit introuvable"));


        produit.setNomCommercial(dto.getNomCommercial());
        produit.setComposition(dto.getComposition());
        produit.setPrixP(dto.getPrixP());
        produit.setFormPharmaceutique(dto.getFormPharmaceutique());
        produit.setDosage(dto.getDosage());
        produit.setDatePeremption(dto.getDatePeremption());
        produit.setQuantiteStock(dto.getQuantiteStock());

        return ProduitMapper.toDTO(produitRepository.save(produit));
    }

    // Supprimer
    public void supprimerProduit(Integer id) {
        produitRepository.deleteById(id);
    }

    // Lister
    public List<ProduitDTO> all() {
        return produitRepository.findAll()
                .stream()
                .map(ProduitMapper::toDTO)
                .toList();
    }

    // Stock faible
    public List<ProduitDTO> produitsStockFaible() {
        return produitRepository.findByQuantiteStockLessThan(10)
                .stream()
                .map(ProduitMapper::toDTO)
                .toList();
    }

    // Périmés
    public List<ProduitDTO> produitsPerimes() {
        Date today = new Date();
        return produitRepository.findByDatePeremptionBefore(today)
                .stream()
                .map(ProduitMapper::toDTO)
                .toList();
    }
}