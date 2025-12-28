package com.pharmacie.mapper;

import com.pharmacie.dto.OrdonnanceDTO;
import com.pharmacie.model.Client;
import com.pharmacie.model.Ordonnance;

public class OrdonnanceMapper {

    public static Ordonnance toEntity(OrdonnanceDTO dto) {
        Ordonnance o = new Ordonnance();
        o.setIdOrdonnance(dto.getIdOrdonnance());
        o.setDateEmission(dto.getDateEmission());
        o.setNomMedecin(dto.getNomMedecin());
        o.setDescription(dto.getDescription());

        Client c = new Client();
        c.setIdUser(dto.getClientId());
        o.setClient(c);

        return o;
    }

    public static OrdonnanceDTO toDTO(Ordonnance o) {
        OrdonnanceDTO dto = new OrdonnanceDTO();
        dto.setIdOrdonnance(o.getIdOrdonnance());
        dto.setDateEmission(o.getDateEmission());
        dto.setNomMedecin(o.getNomMedecin());
        dto.setDescription(o.getDescription());
        dto.setClientId(o.getClient().getIdUser());
        return dto;
    }
}
