package gestion_commercial.models;

import java.util.List;

public class Client extends User {

    private String tel;
    private String adresse;

    // OneToMany (Relation avec la classe Commande)
    private List<Commande> commandes;

    public Client() {
        super(null, null, null);  // Appel au constructeur de la classe parente
        this.setRole(new Role("ROLE_CLIENT"));
    }

    public Client(String nomComplet, String tel, String adresse) {
        super(nomComplet, null, null);  // Appel au constructeur de la classe parente
        this.tel = tel;
        this.adresse = adresse;
        this.setRole(new Role("ROLE_CLIENT"));
    }

    public Client(int id, String nomComplet, String tel, String adresse) {
        super(id, nomComplet, null, null);  // Appel au constructeur de la classe parente
        this.tel = tel;
        this.adresse = adresse;
        this.setRole(new Role("ROLE_CLIENT"));
    }

    // Getters et Setters
    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public List<Commande> getCommandes() {
        return commandes;
    }

    public void setCommandes(List<Commande> commandes) {
        this.commandes = commandes;
    }
}
