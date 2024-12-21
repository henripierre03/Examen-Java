package gestion_commercial.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "produit")
public class Produit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "libelle", nullable = false, length = 150)
    private String libelle;

    @Column(nullable = false)
    private double stock;

    @Column(nullable = false)
    private double prix;

    @Lob
    @Column(name = "image")
    private byte[] image;

    @Column(name = "id_sous_categorie", nullable = false)
    private int idSousCategorie;

    @Column(name = "reference", length = 150)
    private String reference;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_sous_categorie", insertable = false, updatable = false)
    private Categorie categorie;

    @OneToMany(mappedBy = "produit", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Detail> details = new HashSet<>();

    public Produit() {
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

    public double getStock() {
        return stock;
    }

    public void setStock(double stock) {
        this.stock = stock;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public int getIdSousCategorie() {
        return idSousCategorie;
    }

    public void setIdSousCategorie(int idSousCategorie) {
        this.idSousCategorie = idSousCategorie;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    public Set<Detail> getDetails() {
        return details;
    }

    public void setDetails(Set<Detail> details) {
        this.details = details;
    }
}
