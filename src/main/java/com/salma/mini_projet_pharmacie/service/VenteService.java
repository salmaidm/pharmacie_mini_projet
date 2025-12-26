package com.pharmacie.service;

import com.pharmacie.dto.VenteDTO;
import com.pharmacie.mapper.VenteMapper;
import com.pharmacie.model.*;
import com.pharmacie.repository.ProduitRepository;
import com.pharmacie.repository.VenteRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class VenteService {

    private final VenteRepository venteRepository;
    private final ProduitRepository produitRepository;

    public VenteService(VenteRepository venteRepository,
                        ProduitRepository produitRepository) {
        this.venteRepository = venteRepository;
        this.produitRepository = produitRepository;
    }

    public VenteDTO enregistrerVente(VenteDTO dto) {
        Vente vente = VenteMapper.toEntity(dto);

        Produit produit = produitRepository.findById(
                vente.getProduit().getIdProduit()
        ).orElseThrow();

        if (produit.getQuantiteStock() < vente.getQuantite()) {
            throw new RuntimeException("Stock insuffisant");
        }

        produit.setQuantiteStock(
                produit.getQuantiteStock() - vente.getQuantite()
        );
        produitRepository.save(produit);

        vente.setProduit(produit);
        vente.setDateVente(LocalDate.now());

        return VenteMapper.toDTO(venteRepository.save(vente));
    }

    public List<VenteDTO> ventesParClient(Long clientId) {
        Client c = new Client();
        c.setIdUser(clientId);

        return venteRepository.findByClient(c)
                .stream()
                .map(VenteMapper::toDTO)
                .collect(Collectors.toList());
    }
}
