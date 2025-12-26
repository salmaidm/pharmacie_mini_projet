package com.pharmacie.dto;

import java.time.LocalDate;

public class VenteDTO {

    private Long idVente;
    private int quantite;
    private LocalDate dateVente;

    private Long clientId;
    private Long produitId;
    private Long ordonnanceId;

    private double prixTotal;

    public Long getIdVente() { return idVente; }
    public void setIdVente(Long idVente) { this.idVente = idVente; }

    public int getQuantite() { return quantite; }
    public void setQuantite(int quantite) { this.quantite = quantite; }

    public LocalDate getDateVente() { return dateVente; }
    public void setDateVente(LocalDate dateVente) { this.dateVente = dateVente; }

    public Long getClientId() { return clientId; }
    public void setClientId(Long clientId) { this.clientId = clientId; }

    public Long getProduitId() { return produitId; }
    public void setProduitId(Long produitId) { this.produitId = produitId; }

    public Long getOrdonnanceId() { return ordonnanceId; }
    public void setOrdonnanceId(Long ordonnanceId) { this.ordonnanceId = ordonnanceId; }

    public double getPrixTotal() { return prixTotal; }
    public void setPrixTotal(double prixTotal) { this.prixTotal = prixTotal; }
}
