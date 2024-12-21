package gestion_commercial.dto;

import gestion_commercial.models.Produit;

public class ProduitDto {

    private int id;
    private String libelle;
    private float prix;
    private int qteComd;
    private float mntStock;
    private int qteStock;

    public ProduitDto() {
        // Constructeur par défaut
    }

    // Getters et Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public int getQteComd() {
        return qteComd;
    }

    public void setQteComd(int qteComd) {
        this.qteComd = qteComd;
    }

    public float getMntStock() {
        return mntStock;
    }

    public void setMntStock(float mntStock) {
        this.mntStock = mntStock;
    }

    public int getQteStock() {
        return qteStock;
    }

    public void setQteStock(int qteStock) {
        this.qteStock = qteStock;
    }

    // Méthode pour convertir le DTO en modèle
    public Produit dtoToModel() {
        Produit produit = new Produit();
        produit.setId(this.id);
        produit.setQteStock(this.qteStock);
        return produit;
    }

    // Méthode pour calculer le montant en stock
    public void calculMntStock() {
        this.mntStock = this.prix * this.qteComd;
    }

    // Méthode pour convertir un modèle en DTO
    public ProduitDto modelToDto(Produit model) {
        ProduitDto dto = new ProduitDto();
        dto.setId(model.getId());
        dto.setQteStock(model.getQteStock());
        return dto;
    }
}
