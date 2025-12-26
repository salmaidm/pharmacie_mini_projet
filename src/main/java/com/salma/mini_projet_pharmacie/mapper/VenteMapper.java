package com.pharmacie.mapper;

import com.pharmacie.dto.VenteDTO;
import com.pharmacie.model.*;

public class VenteMapper {

    public static Vente toEntity(VenteDTO dto) {
        Vente v = new Vente();
        v.setIdVente(dto.getIdVente());
        v.setQuantite(dto.getQuantite());

        Client c = new Client();
        c.setIdUser(dto.getClientId());
        v.setClient(c);

        Produit p = new Produit();
        p.setIdProduit(dto.getProduitId());
        v.setProduit(p);

        if (dto.getOrdonnanceId() != null) {
            Ordonnance o = new Ordonnance();
            o.setIdOrdonnance(dto.getOrdonnanceId());
            v.setOrdonnance(o);
        }
        return v;
    }

    public static VenteDTO toDTO(Vente v) {
        VenteDTO dto = new VenteDTO();
        dto.setIdVente(v.getIdVente());
        dto.setQuantite(v.getQuantite());
        dto.setDateVente(v.getDateVente());
        dto.setClientId(v.getClient().getIdUser());
        dto.setProduitId(v.getProduit().getIdProduit());
        dto.setPrixTotal(v.calculerPrixTotal());

        if (v.getOrdonnance() != null) {
            dto.setOrdonnanceId(v.getOrdonnance().getIdOrdonnance());
        }
        return dto;
    }
}
