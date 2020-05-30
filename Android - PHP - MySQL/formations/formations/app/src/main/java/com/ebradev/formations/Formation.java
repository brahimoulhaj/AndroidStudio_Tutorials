package com.ebradev.formations;

public class Formation {
    private String id, titre, categorie, description, prix, id_formateur;

    public Formation() {

    }

    public Formation(String id, String titre, String categorie, String description, String prix, String id_formateur) {
        this.id = id;
        this.titre = titre;
        this.categorie = categorie;
        this.description = description;
        this.prix = prix;
        this.id_formateur = id_formateur;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrix() {
        return prix;
    }

    public void setPrix(String prix) {
        this.prix = prix;
    }

    public String getId_formateur() {
        return id_formateur;
    }

    public void setId_formateur(String id_formateur) {
        this.id_formateur = id_formateur;
    }
}
