package gestion_commercial.models;

public class DetailCommande {

    private int qteCom;

    // ManyToOne
    private Commande commande;
    private Produit produit;

    public int getQteCom() {
        return qteCom;
    }

    public void setQteCom(int qteCom) {
        this.qteCom = qteCom;
    }

    public Commande getCommande() {
        return commande;
    }

    public void setCommande(Commande commande) {
        this.commande = commande;
    }

    public Produit getProduit() {
        return produit;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
    }
}
