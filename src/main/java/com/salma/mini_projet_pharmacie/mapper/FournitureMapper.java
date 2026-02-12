package com.salma.mini_projet_pharmacie.mapper;

import com.salma.mini_projet_pharmacie.dto.FournitureDTO;
import com.salma.mini_projet_pharmacie.model.Fourniture;

public class FournitureMapper {

    public static FournitureDTO toDTO(Fourniture f) {
        FournitureDTO dto = new FournitureDTO();

        dto.setIdProduit(f.getId().getIdProduit());
        dto.setIdFournisseur(f.getId().getIdFournisseur());
        dto.setPrixAchat(f.getPrixAchat());

        return dto;
    }
}
