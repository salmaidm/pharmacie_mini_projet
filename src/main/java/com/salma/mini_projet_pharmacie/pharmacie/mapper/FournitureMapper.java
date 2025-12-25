package com.salma.mini_projet_pharmacie.pharmacie.mapper;

import com.salma.mini_projet_pharmacie.pharmacie.dto.FournitureDTO;
import com.salma.mini_projet_pharmacie.pharmacie.model.Fourniture;
import com.salma.mini_projet_pharmacie.pharmacie.model.FournitureKey;

public class FournitureMapper {

    public static FournitureDTO toDTO(Fourniture f) {
        FournitureDTO dto = new FournitureDTO();

        dto.setIdProduit(f.getId().getIdProduit());
        dto.setIdFournisseur(f.getId().getIdFournisseur());
        dto.setPrixAchat(f.getPrixAchat());

        return dto;
    }
}
