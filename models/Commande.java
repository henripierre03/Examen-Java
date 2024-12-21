package gestion_commercial.models;

import java.util.Date;

public class Commande {

    private int id;
    private String numero;
    private Date date = new Date();
    private float total;
    private Statut etat = Statut.ENCOURS;

    // ManyToOne
    private Client client;

    public Commande() {
    }

    public Commande(String numero, Date date, float total, Statut etat) {
        this.numero = numero;
        this.date = date;
        this.total = total;
        this.etat = etat;
    }

    public Commande(int id, String numero, Date date, float total, Statut etat) {
        this.id = id;
        this.numero = numero;
        this.date = date;
        this.total = total;
        this.etat = etat;
    }

    // Getters et Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public Statut getEtat() {
        return etat;
    }

    public void setEtat(Statut etat) {
        this.etat = etat;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
