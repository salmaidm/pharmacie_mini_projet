package com.salma.mini_projet_pharmacie.pharmacie.controller;

import com.salma.mini_projet_pharmacie.pharmacie.dto.FournitureDTO;
import com.salma.mini_projet_pharmacie.pharmacie.service.FournitureService;
import com.salma.mini_projet_pharmacie.pharmacie.utils.ResponseHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/fournitures")
@RequiredArgsConstructor
public class FournitureController {

    private final FournitureService fournitureService;

    @PostMapping("/{idProduit}/{idFournisseur}")
    public ResponseEntity<?> ajouterLien(
            @PathVariable Integer idProduit,
            @PathVariable Integer idFournisseur,
            @RequestParam Double prixAchat
    ) {
        return ResponseHandler.success(
                "Lien produit-fournisseur ajouté",
                fournitureService.ajouterFourniture(idProduit, idFournisseur, prixAchat)
        );
    }
}
