package com.salma.mini_projet_pharmacie.pharmacie.service;


import com.salma.mini_projet_pharmacie.pharmacie.dto.FournitureDTO;
import com.salma.mini_projet_pharmacie.pharmacie.exception.NotFoundException;
import com.salma.mini_projet_pharmacie.pharmacie.mapper.FournitureMapper;
import com.salma.mini_projet_pharmacie.pharmacie.model.*;
import com.salma.mini_projet_pharmacie.pharmacie.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FournitureService {

    private final FournitureRepository fournitureRepository;
    private final ProduitRepository produitRepository;
    private final FournisseurRepository fournisseurRepository;

    public FournitureDTO ajouterFourniture(Integer idProduit, Integer idFournisseur, Double prixAchat) {

        Produit produit = produitRepository.findById(idProduit)
                .orElseThrow(() -> new NotFoundException("Produit introuvable"));
        Fournisseur fournisseur = fournisseurRepository.findById(idFournisseur)
                .orElseThrow(() -> new NotFoundException("Fournisseur introuvable"));

        Fourniture fourniture = new Fourniture(
                new FournitureKey(idProduit, idFournisseur),
                produit,
                fournisseur,
                prixAchat
        );

        Fourniture saved = fournitureRepository.save(fourniture);

        return FournitureMapper.toDTO(saved);
    }
}
