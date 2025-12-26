package com.pharmacie.dto;

import java.time.LocalDate;

public class OrdonnanceDTO {

    private Long idOrdonnance;
    private LocalDate dateEmission;
    private String nomMedecin;
    private String description;
    private Long clientId;

    public Long getIdOrdonnance() { return idOrdonnance; }
    public void setIdOrdonnance(Long idOrdonnance) { this.idOrdonnance = idOrdonnance; }

    public LocalDate getDateEmission() { return dateEmission; }
    public void setDateEmission(LocalDate dateEmission) { this.dateEmission = dateEmission; }

    public String getNomMedecin() { return nomMedecin; }
    public void setNomMedecin(String nomMedecin) { this.nomMedecin = nomMedecin; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public Long getClientId() { return clientId; }
    public void setClientId(Long clientId) { this.clientId = clientId; }
}
